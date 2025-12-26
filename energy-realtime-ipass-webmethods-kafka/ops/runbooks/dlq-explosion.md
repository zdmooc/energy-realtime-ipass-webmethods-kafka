# Runbook — DLQ explosion

## Objectif
Stopper l’hémorragie, qualifier l’erreur (fonctionnelle/technique) et décider du replay.

## Étapes
1. Geler le flux si nécessaire (feature flag / pause consumer)
2. Extraire un échantillon DLQ (10-100 messages)
3. Classifier:
   - schéma incompatible
   - donnée invalide
   - dépendance aval indisponible
4. Corriger la cause
5. Replay contrôlé (par lot) avec suivi SLO

## Artefacts
- Ticket JIRA + RCA
- Mise à jour schéma / compatibilité
- Mise à jour runbook
