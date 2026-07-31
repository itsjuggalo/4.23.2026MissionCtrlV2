#!/usr/bin/env bash
# refresh-holdings.sh — refresh ~/portfolio holdings for the decipher portfolio-context ping.
#
# Root cause of staleness: the old refresh was bound to a systemd --user timer
# (rh-crypto-refresh.timer) which does NOT run in this WSL2 (no systemd as init). This
# script is cron-driven instead.
#
# LIVE today:  Robinhood CRYPTO via robinhood-holdings.py (API-key + Ed25519 + CoinGecko px).
#              Coinbase via coinbase-pp-cli (CDP key — LIVE since at least 2026-07, see below).
# PENDING creds (left on last CSV, age surfaced by portfolio_context.py):
#   - RH stocks : this script does NOT fetch equities. A brokerage session token now DOES
#                 exist (rh-session-keeper writes ~/.openclaw/secrets/robinhood-brokerage-token.txt,
#                 cron 05:45 ET) — wiring an equities pull here is open work, not a cred blocker.
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

# --- Coinbase (LIVE) ---
# The old "key 401s / regenerate the CDP key" note here was STALE. Verified live 2026-07-31:
# the existing key authenticates on BOTH APIs — /v2/accounts AND /api/v3/brokerage/accounts
# (37 accounts) both return 200, with either coinbase-private.pem or -pkcs8.pem. refresh.log
# has been recording "Coinbase LIVE — wrote coinbase_holdings.json" on every run.
# Direct-JWT reference implementation (no Go CLI needed): ~/scripts/real_coach/fills/coinbase.py
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
        echo "[$(ts)] Coinbase pull FAILED — kept prior file (key was live 2026-07-31; check errors above)" >> "$LOG"
    fi
fi

# --- Age reporting only. NOTE: this script never fetches RH equities; robinhood_holdings.json
#     is written elsewhere (wallets-refresh.sh). Age surfaced for portfolio_context.py. ---
for f in coinbase_holdings.json robinhood_holdings.json; do
    if [ -f "$PF/$f" ]; then
        age=$(( ( $(date +%s) - $(stat -c %Y "$PF/$f") ) / 86400 ))
        echo "[$(ts)] $f is ${age}d old" >> "$LOG"
    fi
done
echo "[$(ts)] refresh-holdings done" >> "$LOG"
