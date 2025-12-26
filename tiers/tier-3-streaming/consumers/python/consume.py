import os
import sys
from confluent_kafka import Consumer

def main():
    if len(sys.argv) < 2:
        print("Usage: python consume.py <topic>")
        sys.exit(1)

    topic = sys.argv[1]
    bootstrap = os.getenv("KAFKA_BOOTSTRAP", "localhost:9092")

    c = Consumer({
        "bootstrap.servers": bootstrap,
        "group.id": "consumer-mock-dev",
        "auto.offset.reset": "earliest",
        "enable.auto.commit": True,
    })

    c.subscribe([topic])
    print(f"Consuming {topic} from {bootstrap} ... Ctrl+C to stop")

    try:
        while True:
            msg = c.poll(1.0)
            if msg is None:
                continue
            if msg.error():
                print(f"Error: {msg.error()}")
                continue
            key = msg.key().decode("utf-8") if msg.key() else None
            val = msg.value().decode("utf-8") if msg.value() else None
            print(f"[{msg.topic()}] key={key} value={val}")
    except KeyboardInterrupt:
        pass
    finally:
        c.close()

if __name__ == "__main__":
    main()
