# Tier 1 — Edge / API

Objectif: gérer les entrées **synchrones** (REST/SOAP) et exposer des services si nécessaire, avec:
- AuthN/AuthZ, quotas, rate limiting
- Validation (schéma), corrélation
- Publication vers Tier 2 / Kafka selon design

## Fichiers
- `openapi/openapi.yaml` : contrat REST (exemple)
- `tests/k6/` : scripts de charge (exemple)
