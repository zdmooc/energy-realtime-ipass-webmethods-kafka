#!/usr/bin/env bash
set -euo pipefail

need() { command -v "$1" >/dev/null 2>&1 || { echo "Missing: $1" >&2; exit 1; }; }

need docker
need bash
need curl

echo "OK: prereqs présents (docker, bash, curl)"
