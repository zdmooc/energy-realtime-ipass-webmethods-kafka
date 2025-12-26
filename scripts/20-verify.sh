#!/usr/bin/env bash
set -euo pipefail

BOOTSTRAP="${KAFKA_BOOTSTRAP:-localhost:9092}"

echo "Kafka bootstrap: $BOOTSTRAP"
echo "TIP: utilisez Kafka UI sur http://localhost:8089 (si exposé par docker-compose)"
echo "OK: vérification basique terminée (à enrichir selon contexte)"
