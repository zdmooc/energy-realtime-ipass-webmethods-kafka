# Tier 2 — Intégration iPaaS (webMethods)

Objectif: standardiser les intégrations webMethods pour produire/consommer Kafka de manière fiable.

## Ce que contient ce dossier
- `design/` : patterns d’intégration, conventions, erreurs, idempotence
- `wm-assets/` : placeholders (à remplacer par vos packages/export IS)
- `tests/` : tests contractuels (schema), jeux de données, checklists

## Patterns recommandés
- At-least-once + idempotence
- Retry avec backoff + jitter
- DLQ pour:
  - erreurs fonctionnelles
  - poison events
- Headers/correlation:
  - `correlationId`, `eventId`, `eventType`, `eventVersion`

## À produire en mission
- Un package webMethods “Kafka Standard Producer”
- Un package webMethods “Kafka Standard Consumer”
- Un package “Error Handling + DLQ/Replay”
