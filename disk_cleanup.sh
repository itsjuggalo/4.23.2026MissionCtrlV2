#!/usr/bin/env bash
# disk_cleanup.sh — tiered cache eviction for WSL disk pressure
# Usage: disk_cleanup.sh [1|2|3] [--dry-run]
#   Level 1 (warn  ~75%): pip + uv caches
#   Level 2 (high  ~85%): + HF hub models (keep newest 3GB), puppeteer, node cache
#   Level 3 (crit  ~90%): + old logs, temp files, npm cache
set -euo pipefail

LEVEL="${1:-1}"
DRY=false
[[ "${2:-}" == "--dry-run" ]] && DRY=true

freed=0

du_mb() { du -sm "$1" 2>/dev/null | cut -f1 || echo 0; }

rm_if() {
    local path="$1"
    if [[ -e "$path" ]]; then
        local mb; mb=$(du_mb "$path")
        if $DRY; then
            echo "[dry-run] would remove $path (~${mb}MB)"
        else
            rm -rf "$path"
            echo "[cleaned] $path (~${mb}MB)"
            freed=$((freed + mb))
        fi
    fi
}

rm_glob_if() {
    local pattern="$1"
    # shellcheck disable=SC2086
    for f in $pattern; do
        [[ -e "$f" ]] && rm_if "$f"
    done
}

echo "=== disk_cleanup.sh level=$LEVEL $(date '+%Y-%m-%dT%H:%M:%S%z') ==="

# --- Level 1: pip + uv ---
if [[ "$LEVEL" -ge 1 ]]; then
    echo "-- Level 1: pip + uv caches --"
    if command -v pip &>/dev/null; then
        if $DRY; then
            echo "[dry-run] would run: pip cache purge"
        else
            pip cache purge 2>/dev/null && echo "[cleaned] pip cache" || true
        fi
    fi
    rm_if "$HOME/.cache/uv"
    # Keep pip cache dir but clear wheels/http
    rm_if "$HOME/.cache/pip/wheels"
    rm_if "$HOME/.cache/pip/http-v2"
fi

# --- Level 2: HF models (LRU evict >3GB), puppeteer, node cache ---
if [[ "$LEVEL" -ge 2 ]]; then
    echo "-- Level 2: HF + browser caches --"

    # HF: keep total under 3GB — delete least recently accessed model dirs
    HF_HUB="$HOME/.cache/huggingface/hub"
    if [[ -d "$HF_HUB" ]]; then
        HF_MB=$(du_mb "$HF_HUB")
        LIMIT_MB=3072  # 3GB
        if [[ "$HF_MB" -gt "$LIMIT_MB" ]]; then
            echo "HF hub is ${HF_MB}MB > ${LIMIT_MB}MB — evicting LRU models"
            # Sort model dirs by last access time (oldest first), delete until under limit
            while IFS= read -r model_dir; do
                [[ -d "$model_dir" ]] || continue
                current_mb=$(du_mb "$HF_HUB")
                [[ "$current_mb" -le "$LIMIT_MB" ]] && break
                rm_if "$model_dir"
            done < <(find "$HF_HUB" -mindepth 1 -maxdepth 1 -type d -printf '%A@ %p\n' 2>/dev/null | sort -n | awk '{print $2}')
        else
            echo "HF hub OK: ${HF_MB}MB"
        fi
    fi

    # HF datasets/downloads — safe to delete (re-downloaded on demand per HF docs)
    HF_HOME_EFF="${HF_HOME:-$HOME/.cache/huggingface}"
    rm_if "${HF_HOME_EFF}/datasets/downloads"

    rm_if "$HOME/.cache/puppeteer"
    rm_if "$HOME/.cache/ms-playwright"
    # node-gyp can be rebuilt on demand
    rm_if "$HOME/.cache/node-gyp"
fi

# --- Level 3: old logs, temp, npm cache ---
if [[ "$LEVEL" -ge 3 ]]; then
    echo "-- Level 3: logs + temp + npm --"

    # Old PM2 logs > 50MB each
    find "$HOME/.pm2/logs" -name "*.log" -size +50M 2>/dev/null | while read -r f; do
        if $DRY; then echo "[dry-run] truncate $f"; else > "$f" && echo "[truncated] $f"; fi
    done

    # Old log files older than 30 days
    find "$HOME/logs" -name "*.log" -mtime +30 2>/dev/null | while read -r f; do
        rm_if "$f"
    done

    # npm/yarn global caches
    if command -v npm &>/dev/null; then
        local npm_cache; npm_cache=$(npm config get cache 2>/dev/null || echo "")
        [[ -n "$npm_cache" && -d "$npm_cache" ]] && rm_if "$npm_cache"
    fi

    # Temp dirs
    find /tmp -maxdepth 1 -user "$USER" -mtime +1 -exec rm -rf {} + 2>/dev/null || true
    find "$HOME/.tmp" -mtime +1 2>/dev/null | xargs rm -rf || true
fi

$DRY || echo "=== freed ~${freed}MB ==="
$DRY && echo "=== dry-run complete (nothing deleted) ==="
