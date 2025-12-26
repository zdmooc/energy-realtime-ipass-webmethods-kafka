# Support N3 — Checklist

## Quand ça casse (ordre conseillé)
1. Identifier le flux (topic / consumer group / app)
2. Vérifier DLQ rate + erreurs producer/consumer
3. Mesurer lag et time-lag (prioriser le “time-lag”)
4. Vérifier schéma (eventVersion) + breaking change
5. Vérifier infra (brokers, réseau, quotas)
6. Exécuter runbook correspondant

## RCA
- Timeline incident
- Cause racine (technique vs fonctionnelle)
- Actions correctives (préventives + détectives)
- Mise à jour runbook / alerting
