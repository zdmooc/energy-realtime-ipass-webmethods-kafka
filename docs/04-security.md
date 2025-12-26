# Sécurité (checklist)

## AuthN/AuthZ
- Kafka: SASL/SCRAM ou mTLS (selon standard)
- ACLs par topic + consumer group
- webMethods: comptes techniques + rotation

## Données
- Chiffrement in-transit (TLS)
- Chiffrement at-rest (disques / brokers / backups)
- Classification (PII/secret/operational)

## Traçabilité
- Logs structurés (sans secret)
- `correlationId` propagé de bout en bout
- Audit d’accès (Kafka + API)

## Actions (projet)
- ADR: stratégie AuthN Kafka (mTLS vs SASL)
- Runbook: rotation certificats / secrets
