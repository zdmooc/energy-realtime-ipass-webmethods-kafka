# Plan POC (Streaming / Fast Data)

## POC 1 — Ingestion + routage + DLQ
- Producer via webMethods (mock possible)
- Validation schéma + enricher
- Publication topic `grid.meter.reading.v1.dev`
- Consommateur + règles simples, erreurs -> DLQ

## POC 2 — Agrégation temps réel
- Agrégation par site / fenêtre glissante (5 min)
- Publication d’un événement agrégé
- Mesure perf (latence, throughput, CPU)

## Critères de sortie
- Reproductibilité (scripts)
- Observabilité (metrics/dashboards)
- Rapport benchmark + recommandations
