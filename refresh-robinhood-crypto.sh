#!/usr/bin/env bash
# Refresh ~/portfolio/robinhood_crypto_holdings.json from the live Robinhood
# Crypto Trading API. Auth is API-key + Ed25519 — no 2FA. Driven by the
# rh-crypto-refresh.timer systemd --user unit.
set -u
KEY_FILE="$HOME/.openclaw/secrets/robinhood-api-key.txt"
[ -f "$KEY_FILE" ] || { echo "no $KEY_FILE"; exit 1; }
export ROBINHOOD_API_KEY="$(cat "$KEY_FILE")"
/usr/bin/python3 "$HOME/.openclaw/workspace/mission-control/scripts/robinhood-holdings.py" \
    > "$HOME/portfolio/robinhood_crypto_holdings.json"
