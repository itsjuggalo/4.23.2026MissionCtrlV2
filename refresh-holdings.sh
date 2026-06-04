#!/usr/bin/env bash
# refresh-holdings.sh — refresh ~/portfolio holdings for the decipher portfolio-context ping.
#
# Root cause of staleness: the old refresh was bound to a systemd --user timer
# (rh-crypto-refresh.timer) which does NOT run in this WSL2 (no systemd as init). This
# script is cron-driven instead.
#
# LIVE today:  Robinhood CRYPTO via robinhood-holdings.py (API-key + Ed25519 + CoinGecko px).
# PENDING creds (left on last CSV, age surfaced by portfolio_context.py):
#   - Coinbase  : coinbase-pp-cli returns 401 (CDP key needs regen/permissions).
#   - RH stocks : needs a brokerage session token (crypto API doesn't cover equities).
set -uo pipefail
LOG="$HOME/portfolio/refresh.log"
PF="$HOME/portfolio"
SCR="$HOME/05_AUTOMATION/scripts"
ts() { date '+%Y-%m-%d %H:%M:%S %Z'; }

mkdir -p "$PF"

# --- Robinhood crypto (live) -> robinhood_crypto_holdings.json (atomic) ---
export ROBINHOOD_API_KEY="$(cat "$HOME/.openclaw/secrets/robinhood-api-key.txt" 2>/dev/null)"
tmp="$PF/robinhood_crypto_holdings.json.tmp"
if /usr/bin/python3 "$SCR/robinhood-holdings.py" > "$tmp" 2>>"$LOG" \
   && python3 -c "import json,sys; d=json.load(open('$tmp')); sys.exit(0 if d.get('results') is not None and 'error' not in d else 1)" 2>/dev/null; then
    mv "$tmp" "$PF/robinhood_crypto_holdings.json"
    tot=$(python3 -c "import json;print(json.load(open('$PF/robinhood_crypto_holdings.json')).get('total_usd',0))" 2>/dev/null)
    echo "[$(ts)] RH crypto OK — total_usd=$tot" >> "$LOG"
else
    rm -f "$tmp"
    echo "[$(ts)] RH crypto FAILED (see errors above) — kept prior file" >> "$LOG"
    exit 1
fi

# --- Coinbase (live-attempt; auto-activates the moment the CDP key is regenerated) ---
# Env mapping is correct & the JWT signs (verified 2026-06-04); today's key 401s on
# /api/v3/brokerage/accounts because it's revoked/under-permissioned. Regenerate at the
# Coinbase Developer Platform with "View" perms and this block goes live with NO code change.
CB_CLI="$HOME/go/bin/coinbase-pp-cli"
if [ -x "$CB_CLI" ] && [ -f "$HOME/.openclaw/secrets/coinbase-api-key.txt" ]; then
    export COINBASE_API_KEY_NAME="$(cat "$HOME/.openclaw/secrets/coinbase-api-key.txt" 2>/dev/null)"
    export COINBASE_API_PRIVATE_KEY="$(cat "$HOME/.openclaw/secrets/coinbase-private.pem" 2>/dev/null)"
    cbtmp="$PF/coinbase_holdings.json.tmp"
    if "$CB_CLI" accounts list --agent > "$cbtmp" 2>>"$LOG" \
       && python3 -c "import json,sys; d=json.load(open('$cbtmp')); sys.exit(0 if isinstance(d,(dict,list)) and 'error' not in (d if isinstance(d,dict) else {}) else 1)" 2>/dev/null; then
        mv "$cbtmp" "$PF/coinbase_holdings.json"
        echo "[$(ts)] Coinbase LIVE — wrote coinbase_holdings.json" >> "$LOG"
    else
        rm -f "$cbtmp"
        echo "[$(ts)] Coinbase still 401 (regen CDP key) — kept prior CSV" >> "$LOG"
    fi
fi

# --- RH stocks: CSV fallback (needs a brokerage session token; crypto API ≠ equities) ---
for f in coinbase_holdings.json robinhood_holdings.json; do
    if [ -f "$PF/$f" ]; then
        age=$(( ( $(date +%s) - $(stat -c %Y "$PF/$f") ) / 86400 ))
        echo "[$(ts)] $f is ${age}d old" >> "$LOG"
    fi
done
echo "[$(ts)] refresh-holdings done" >> "$LOG"
