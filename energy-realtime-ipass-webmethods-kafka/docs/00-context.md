# Contexte & enjeux

## Objectif
Moderniser des échanges **temps réel** à forte criticité au sein d’une plateforme iPaaS / Digital PaaS, avec:
- **webMethods** pour l’intégration et l’interopérabilité SI,
- **Kafka** comme backbone streaming / fast data.

## Contraintes typiques énergie
- Volumes élevés (pics), faible latence, ordering partiel par clé métier
- Disponibilité, reprise, traçabilité et audit
- Sécurité (données sensibles / opérations critiques)
- Exploitabilité (runbooks, support N3, RCA)

## Hypothèses
- Kafka est déjà standard ou en cours de standardisation.
- webMethods (IS) est la couche d’intégration principale (adapters, mapping, orchestration).
