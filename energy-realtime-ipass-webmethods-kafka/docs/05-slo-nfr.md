# SLO / NFR (exemple à adapter)

## SLO temps réel (cible)
- Latence end-to-end p95: < 2s
- Latence end-to-end p99: < 5s
- Disponibilité pipeline: 99.9%
- Perte de messages: 0 (tolérance: duplication possible si at-least-once)

## NFR clés
- Throughput nominal: X msg/s ; pic: 3X
- Reprise: replay 24h d’événements < Y heures
- Résilience: broker down, réseau instable, redémarrage webMethods

## Indicateurs
- Producer errors rate
- Consumer lag / time-lag
- DLQ rate
- End-to-end latency (trace)
