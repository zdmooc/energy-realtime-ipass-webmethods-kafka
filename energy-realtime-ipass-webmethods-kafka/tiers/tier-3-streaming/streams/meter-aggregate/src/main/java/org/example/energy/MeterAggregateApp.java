package org.example.energy;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Consumed;

import java.time.Duration;
import java.util.Properties;

/**
 * Squelette Kafka Streams:
 * - Lit un topic "grid.meter.reading.v1.dev" (messages JSON en String)
 * - Agrège par clé (partitionKey) sur fenêtre 5 minutes
 * - Ecrit un résultat sur "grid.meter.reading.agg.v1.dev"
 *
 * IMPORTANT: parsing JSON volontairement omis ici (à intégrer selon choix JSON/Avro/Protobuf).
 */
public class MeterAggregateApp {

  public static void main(String[] args) {
    String bootstrap = System.getenv().getOrDefault("KAFKA_BOOTSTRAP", "localhost:9092");
    String inputTopic = System.getenv().getOrDefault("INPUT_TOPIC", "grid.meter.reading.v1.dev");
    String outputTopic = System.getenv().getOrDefault("OUTPUT_TOPIC", "grid.meter.reading.agg.v1.dev");

    Properties props = new Properties();
    props.put(StreamsConfig.APPLICATION_ID_CONFIG, "meter-aggregate-dev");
    props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
    props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
    props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

    StreamsBuilder builder = new StreamsBuilder();

    // NOTE: On suppose ici que la clé Kafka est déjà positionnée sur partitionKey.
    builder.stream(inputTopic, Consumed.with(Serdes.String(), Serdes.String()))
      .groupByKey()
      .windowedBy(TimeWindows.ofSizeWithNoGrace(Duration.ofMinutes(5)))
      .count()
      .toStream()
      .map((windowedKey, count) -> new org.apache.kafka.streams.KeyValue<>(
        windowedKey.key(),
        String.format("{"partitionKey":"%s","windowStart":"%s","count":%d}",
          windowedKey.key(), windowedKey.window().startTime(), count)
      ))
      .to(outputTopic);

    KafkaStreams streams = new KafkaStreams(builder.build(), props);
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    streams.start();
  }
}
