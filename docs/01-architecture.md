# Architecture (macro)

## Diagramme (3 tiers)
```mermaid
flowchart LR
  subgraph T1[Tier 1 — Edge / API]
    API[API Gateway / API Mgmt]
    VAL[Validation + AuthN/AuthZ + Quotas]
    API --> VAL
  end

  subgraph T2[Tier 2 — Intégration iPaaS]
    WM[webMethods Integration Server]
    MAP[Mapping XML/JSON + Enrichissement]
    ERR[Erreur standard: retry/DLQ/idempotence]
    WM --> MAP --> ERR
  end

  subgraph T3[Tier 3 — Streaming / Fast Data]
    K[(Kafka Cluster)]
    STR[Streaming Apps
(Kafka Streams/ksqlDB/Flink)]
    CON[Consumers métiers
(microservices/data)]
    DLQ[(DLQ Topics)]
    K --> STR --> K
    K --> CON
    K --> DLQ
  end

  Sources[Systèmes sources
SCADA/ERP/CRM/IoT] --> T1
  T1 --> T2
  T2 --> K
```

## Principes d’architecture
- **Contrat d’événement** (schéma, version, compatibilité) comme artefact de gouvernance.
- **At-least-once + idempotence** par défaut (exactly-once seulement si justifié).
- **DLQ** + **replay** maîtrisé.
- Observabilité: logs structurés + métriques + corrélation (`correlationId`, `eventId`).

## Interfaces
- Sync: REST/SOAP (Tier 1)
- Async: Kafka (Tier 3) avec production/consommation gérées au Tier 2
