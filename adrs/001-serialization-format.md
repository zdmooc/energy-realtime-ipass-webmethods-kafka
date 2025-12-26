# ADR-001: Format de sérialisation des événements

## Statut
Proposé

## Contexte
Les flux temps réel nécessitent validation, compatibilité, performance et gouvernance.

## Options
1. JSON + JSON Schema
2. Avro + Schema Registry
3. Protobuf + Registry

## Décision (proposée)
Démarrer en **JSON + JSON Schema** pour accélérer les POC, puis migrer vers Avro/Protobuf si:
- gouvernance multi-équipes,
- besoin compatibilité stricte,
- optimisation réseau/CPU.

## Conséquences
- + Rapide à adopter
- - Contrôle compatibilité moins industrialisé sans registry
