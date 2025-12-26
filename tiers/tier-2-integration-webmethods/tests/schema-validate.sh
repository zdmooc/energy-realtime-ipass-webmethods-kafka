#!/usr/bin/env bash
set -euo pipefail

# Valide un JSON contre un JSON Schema (nécessite python + jsonschema)
# Usage:
#   ./schema-validate.sh <schema.json> <payload.json>

SCHEMA="${1:?schema json manquant}"
PAYLOAD="${2:?payload json manquant}"

python - <<'PY'
import sys, json
from jsonschema import validate
schema_path, payload_path = sys.argv[1], sys.argv[2]
with open(schema_path, 'r', encoding='utf-8') as f:
    schema = json.load(f)
with open(payload_path, 'r', encoding='utf-8') as f:
    payload = json.load(f)
validate(instance=payload, schema=schema)
print("OK: payload valide")
PY "$SCHEMA" "$PAYLOAD"
