#!/usr/bin/env bash
# hf_guard.sh — pre-flight check before any HuggingFace model download
# Usage: source hf_guard.sh && hf_check_space || exit 1
# Or: hf_guard.sh <huggingface-cli download ...>
#
# Enforces:
#   - DrvFs /mnt/c/ is NEVER used as HF_HOME (crash vector)
#   - WSL disk has >= MIN_FREE_GB free before downloading
#   - HF hub cache stays under MAX_HF_GB after cleanup if needed

MIN_FREE_GB=50    # require at least 50GB free before any HF download
MAX_HF_GB=15      # auto-cleanup HF hub if it grows past 15GB
CLEANUP_SCRIPT="$HOME/scripts/disk_cleanup.sh"

hf_check_space() {
    # 1. Validate HF_HOME is NOT on DrvFs
    local hf_home="${HF_HOME:-$HOME/.cache/huggingface}"
    if [[ "$hf_home" == /mnt/c/* || "$hf_home" == /mnt/d/* ]]; then
        echo "ERROR: HF_HOME='$hf_home' is on DrvFs — this is the crash vector." >&2
        echo "       Fix: export HF_HOME=\$HOME/.cache/huggingface" >&2
        return 1
    fi

    # 2. Check free disk
    local avail_gb; avail_gb=$(df -BG / | awk 'NR==2 {gsub(/G/,""); print $4}')
    if [[ "$avail_gb" -lt "$MIN_FREE_GB" ]]; then
        echo "ERROR: Only ${avail_gb}GB free on WSL disk (need ${MIN_FREE_GB}GB). Run disk_cleanup.sh first." >&2
        return 1
    fi

    # 3. Check + trim HF hub if over limit
    local hf_hub="${hf_home}/hub"
    if [[ -d "$hf_hub" ]]; then
        local hf_gb; hf_gb=$(du -sG "$hf_hub" 2>/dev/null | cut -f1 || echo 0)
        if [[ "$hf_gb" -ge "$MAX_HF_GB" ]]; then
            echo "WARNING: HF hub at ${hf_gb}GB >= ${MAX_HF_GB}GB limit — running cleanup..." >&2
            bash "$CLEANUP_SCRIPT" 2 >&2 || true
        fi
    fi

    echo "OK: HF_HOME='$hf_home' | disk ${avail_gb}GB free | checks passed"
    return 0
}

# If called directly (not sourced), run as a wrapper
if [[ "${BASH_SOURCE[0]}" == "${0}" ]]; then
    hf_check_space || exit 1
    if [[ $# -gt 0 ]]; then
        exec "$@"
    fi
fi
