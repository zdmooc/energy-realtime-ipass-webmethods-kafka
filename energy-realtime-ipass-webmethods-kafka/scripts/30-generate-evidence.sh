#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
EVD="$ROOT/evidence"
mkdir -p "$EVD"

date > "$EVD/_timestamp.txt"
docker ps > "$EVD/docker_ps.txt"

echo "OK: evidence capturée dans $EVD/"
