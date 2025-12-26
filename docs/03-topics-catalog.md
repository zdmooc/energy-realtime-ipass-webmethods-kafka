# Catalogue topics (exemple)

## Convention de nommage
`<domaine>.<sous-domaine>.<type>.<version>.<env>`

Exemples:
- `grid.meter.reading.v1.dev`
- `grid.incident.created.v1.prod`
- `billing.invoice.published.v1.preprod`

## Règles
- Une **clé de partition** stable (ex: `meterId`, `siteId`, `incidentId`).
- Rétention:
  - “operational”: 7 à 14 jours
  - “replay business”: 30 jours (si besoin)
- DLQ:
  - `*.dlq.*` (poison events / erreurs fonctionnelles)

## Fichiers dans le dépôt
- Définition topics: `tiers/tier-3-streaming/kafka/topics/`
- ACLs (placeholder): `tiers/tier-3-streaming/kafka/acls/`
