# Playbook performance & scalabilité

## Paramètres Kafka (à tester)
- Partitions / replication factor
- Producer: acks, linger.ms, batch.size, compression
- Consumer: max.poll.records, fetch.min.bytes, concurrency (groups)

## Paramètres webMethods (à tester)
- Pools (threads, JDBC, HTTP)
- Taille message (compression, chunking)
- Stratégie retry (backoff, jitter)

## Campagnes
1. Baseline (nominal)
2. Pic x3 (burst)
3. Soak test (4h/24h)
4. Chaos: broker down / restart webMethods

## Artefacts
- Scénarios charge: `tiers/tier-1-edge-api/tests/`
- Capture preuves: `scripts/30-generate-evidence.sh` -> `evidence/`
