#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT/local-dev"

docker compose down -v
echo "OK: stack local-dev arrêtée"
