# Patterns de flux webMethods (guidelines)

## Producer standard
1. Input validation (schema)
2. Enrichissement (source, correlation, partitionKey)
3. Publication Kafka (acks selon NFR)
4. Journalisation (succès/erreur) + métriques
5. Gestion erreurs:
   - technique -> retry
   - fonctionnelle -> DLQ

## Consumer standard
1. Poll/consume
2. Validation + idempotence (store eventId)
3. Traitement métier / orchestration
4. Commit offset (après succès)
5. Gestion erreurs -> retry puis DLQ

## Idempotence (suggestion)
- Store (KV) des `eventId` traités sur une fenêtre temporelle (TTL)
- En cas de doublon: no-op + commit offset
