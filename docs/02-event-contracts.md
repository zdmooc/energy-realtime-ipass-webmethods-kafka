# Contrats d’événements

## Règles
- Un événement = **fait passé**, immuable (append-only).
- Champs minimum:
  - `eventId` (UUID), `eventType`, `eventVersion`, `occurredAt` (ISO-8601)
  - `sourceSystem`, `correlationId`, `partitionKey`
  - `payload` (objet métier)
- Versioning:
  - `v1`, `v2` ... et **compatibilité** (backward/forward selon stratégie).
- Validation: JSON Schema (dans ce dépôt) ou Avro/Protobuf (si schema registry).

## Artefacts
- Schemas: `contracts/schemas/`
- Exemples: `contracts/examples/`

## Décisions (à acter)
- Format de sérialisation: JSON / Avro / Protobuf
- Registry: oui/non, et gestion du cycle de vie
- Convention de compatibilité: backward-only, full, etc.
