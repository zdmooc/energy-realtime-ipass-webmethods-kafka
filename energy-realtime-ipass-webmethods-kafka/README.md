# Energy Real-Time Exchange Modernization (webMethods + Kafka)

Dépôt “starter kit” **structuré en 3 tiers** pour cadrer, concevoir, intégrer et opérer des flux **temps réel** à forte criticité (secteur énergie) au sein d’une plateforme iPaaS / Digital PaaS.

> ⚠️ **webMethods est propriétaire.** Ce dépôt fournit des **standards**, des **gabarits**, des **scripts** et des **exemples** (mock) sans inclure de binaires Software AG.

## 1) Les 3 tiers (vue simple)

- **Tier 1 — Edge / API & Entrées sync**
  - Exposition REST/SOAP si nécessaire (API Management / façade), validation, corrélation, quotas.
  - Dossier: `tiers/tier-1-edge-api/`

- **Tier 2 — Intégration iPaaS (webMethods)**
  - Orchestration d’intégration, mapping XML/JSON, connectivité SI, publication/consommation Kafka, gestion d’erreurs standardisée.
  - Dossier: `tiers/tier-2-integration-webmethods/`

- **Tier 3 — Streaming / Fast Data (Kafka)**
  - Backbone événementiel (topics), consumers métiers, streaming (Kafka Streams/ksqlDB/Flink selon contexte), DLQ/replay.
  - Dossier: `tiers/tier-3-streaming/`

## 2) Démarrage rapide (local-dev)

### Pré-requis
- Docker + Docker Compose
- `bash` (Git Bash/WSL2 OK) + `curl` + `jq`
- (Option) Java 17+ si vous compilez le mock Kafka Streams

### Lancer un Kafka local + UI
```bash
cd local-dev
docker compose up -d
```

### Créer les topics + produire/consommer des événements (mock)
```bash
./scripts/00-prereqs.sh
./scripts/10-local-up.sh
./scripts/20-verify.sh
```

### Arrêt
```bash
./scripts/90-local-down.sh
```

## 3) Livrables “prêts mission”
- Architecture et décisions: `docs/` + `adrs/`
- Catalogue topics + conventions: `docs/03-topics-catalog.md` + `tiers/tier-3-streaming/kafka/topics/`
- Contrats d’événements (schemas + exemples): `contracts/`
- MCO / runbooks / support N3: `ops/runbooks/` + `docs/06-mco-runbooks.md`
- CI/CD templates: `ci/`
- Automatisation Ansible (squelette): `ansible/`

## 4) Roadmap (vision tournée vers l’avenir)
- Durcissement sécurité: mTLS/SASL, rotation secrets, policies d’accès
- Observabilité unifiée (OpenTelemetry) + SLOs “burn rate”
- Gouvernance contrats (schema registry / compatibilité)
- Tests de résilience automatisés (chaos drills / game days)
- Industrialisation multi-environnements (dev/recette/prod) via GitOps

---

Date de génération: 2025-12-20
