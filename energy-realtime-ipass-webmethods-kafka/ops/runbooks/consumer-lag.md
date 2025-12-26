# Runbook — Consumer Lag

## Symptômes
- Lag augmente sur un consumer group
- Latence end-to-end qui monte, SLO en risque

## Diagnostic rapide
1. Identifier group + topics
2. Vérifier:
   - erreurs consumer
   - DLQ rate
   - saturation CPU/mémoire
   - taille des messages

## Actions
- Scale consumers (augmenter instances / threads)
- Vérifier partitioning (trop peu de partitions)
- Vérifier backpressure côté downstream
- Si poison events: isoler via DLQ

## Post-incident
- RCA + ajuster partitions/threads/config
- Renforcer alertes (time-lag)
