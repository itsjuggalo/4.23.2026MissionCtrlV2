#!/bin/bash
# Deferred: install Ollama + wire local
# nomic-embed-text into claudeclaw consolidation ($0 embeddings). Pings Mike on
# completion (success OR failure). Launched via systemd-run --user so it survives
# /compact, /clear, and Claude exiting. Set up 2026-05-30 at Mike's request.
set -uo pipefail
LOG=/home/itsju/cron/nightshift/logs/ollama_setup_deferred.log
ENVF=/home/itsju/claudeclaw-os/.env
PING=/home/itsju/scripts/ping_mike.py
log(){ echo "[$(date '+%F %T')] $*" >> "$LOG"; }
ping(){ /usr/bin/python3 "$PING" "$1" >/dev/null 2>&1 || true; }

# Single-instance lock — a reboot-launched copy and the transient copy must not
# race (both installing Ollama).
exec 9>"/home/itsju/cron/nightshift/logs/.ollama_setup.lock"
if ! flock -n 9; then log "another instance holds the lock — exiting"; exit 0; fi

# Idempotency — if already fully wired, exit cleanly (handles reboot-after-done so
# the boot-time service is a no-op once the work is complete).
if grep -q "^OLLAMA_EMBED_URL=" "$ENVF" 2>/dev/null \
   && curl -sf --max-time 3 http://localhost:11434/api/tags 2>/dev/null | grep -q "nomic-embed-text"; then
  log "already wired (OLLAMA_EMBED_URL set + ollama serving nomic-embed-text) — nothing to do"
  exit 0
fi

log "=== deferred Ollama setup armed ==="
log "RAM available: $(free -h | awk '/Mem/{print $7" available"}')"

# 2. Install Ollama if absent (installer uses sudo; laptop has passwordless sudo)
if ! command -v ollama >/dev/null 2>&1; then
  log "installing Ollama..."
  curl -fsSL https://ollama.com/install.sh | sh >> "$LOG" 2>&1
fi
if ! command -v ollama >/dev/null 2>&1; then
  log "FAIL: ollama binary not present after install"
  ping "❌ Ollama setup FAILED — installer didn't produce the binary. Check $LOG"
  exit 1
fi

# 3. Ensure ollama serve is up on :11434 (installer may start a system service; else start via systemd-run --user)
if ! curl -sf --max-time 3 http://localhost:11434/api/tags >/dev/null 2>&1; then
  log "starting ollama serve..."
  systemd-run --user --unit=ollama-serve --collect ollama serve >> "$LOG" 2>&1 \
    || ( nohup ollama serve >> "$LOG" 2>&1 & )
  for i in $(seq 1 30); do curl -sf --max-time 2 http://localhost:11434/api/tags >/dev/null 2>&1 && break; sleep 2; done
fi
if ! curl -sf --max-time 3 http://localhost:11434/api/tags >/dev/null 2>&1; then
  log "FAIL: ollama serve not responding on :11434"
  ping "❌ Ollama serve not responding on :11434. Check $LOG"
  exit 1
fi

# 4. Pull the embedding model
log "pulling nomic-embed-text..."
ollama pull nomic-embed-text >> "$LOG" 2>&1

# 5. Verify embedding works + capture dimension
EMB=$(curl -sf --max-time 30 http://localhost:11434/api/embeddings \
  -d '{"model":"nomic-embed-text","prompt":"hello"}' \
  | python3 -c "import sys,json;print(len(json.load(sys.stdin).get('embedding',[])))" 2>/dev/null || echo 0)
log "embedding dim test: $EMB"
if ! [ "${EMB:-0}" -gt 100 ] 2>/dev/null; then
  log "FAIL: embedding test returned dim=$EMB"
  ping "❌ Ollama embed test failed (dim=$EMB). Check $LOG"
  exit 1
fi

# 6. Wire claudeclaw + restart to pick up OLLAMA_EMBED_URL (code already deployed, inert)
grep -q "^OLLAMA_EMBED_URL=" "$ENVF" || echo "OLLAMA_EMBED_URL=http://localhost:11434" >> "$ENVF"
systemctl --user restart claudeclaw.service
log "claudeclaw restarted with OLLAMA_EMBED_URL=http://localhost:11434"

# 7. Success ping
ping "✅ Ollama set up. Local nomic-embed-text (${EMB}-dim) now powers claudeclaw consolidation embeddings — FREE + local. Consolidation is now fully $0: insight=DeepSeek, vectors=local Ollama. Log: $LOG"
log "=== done — embeddings now local/free ==="
