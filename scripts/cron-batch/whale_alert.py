#!/usr/bin/env python3
"""Whale Alert — poll whale-alert.io API for $10M+ on-chain transfers.
Filters: BTC, ETH, USDT, USDC stablecoins/blue chips.
Posts to #whale-flow channel via existing webhook.
Cron: every 10 min during 24/7 (crypto never sleeps).
Free tier: 1 req/min. Get key at https://whale-alert.io/signup
"""
import json, time, requests
from pathlib import Path
from datetime import datetime, timezone

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_whale_flow_webhook").read_text().strip()
KEY_FILE = SECRETS / "whale_alert_api_key"
STATE_FILE = Path.home() / ".openclaw" / "workspace" / "state" / "whale_alert_state.json"
STATE_FILE.parent.mkdir(parents=True, exist_ok=True)

THRESHOLD_USD = 10_000_000
ALLOWED_SYMBOLS = {"btc", "eth", "usdt", "usdc"}

def main():
    if not KEY_FILE.exists():
        print("[whale] no API key at ~/.openclaw/secrets/whale_alert_api_key")
        print("        get free key at whale-alert.io/signup and save it there")
        return
    key = KEY_FILE.read_text().strip()

    state = json.loads(STATE_FILE.read_text()) if STATE_FILE.exists() else {"last_cursor": 0, "seen_ids": []}
    seen = set(state.get("seen_ids", []))
    # Default to last 10 minutes if no cursor
    start = state.get("last_cursor") or int(time.time()) - 600

    try:
        r = requests.get(
            "https://api.whale-alert.io/v1/transactions",
            params={"api_key": key, "min_value": THRESHOLD_USD, "start": start, "limit": 100},
            timeout=12,
        )
    except Exception as e:
        print(f"[whale] API error: {e}")
        return

    if r.status_code != 200:
        print(f"[whale] API status {r.status_code}: {r.text[:200]}")
        return

    data = r.json()
    txs = data.get("transactions", [])
    new_txs = []
    cursor = start
    for t in txs:
        tid = str(t.get("id") or t.get("hash", ""))
        if tid in seen: continue
        sym = (t.get("symbol") or "").lower()
        if sym not in ALLOWED_SYMBOLS: continue
        new_txs.append(t)
        seen.add(tid)
        if t.get("timestamp"): cursor = max(cursor, t["timestamp"])

    print(f"[whale] checked {len(txs)} txs, {len(new_txs)} new $10M+ on allowed symbols")

    for t in new_txs[:10]:  # cap posting to 10/run
        amt = t.get("amount_usd", 0) or t.get("amount", 0) * 1
        sym = (t.get("symbol") or "?").upper()
        from_addr = (t.get("from", {}) or {}).get("owner_type", "unknown")
        from_owner = (t.get("from", {}) or {}).get("owner", "")
        to_addr = (t.get("to", {}) or {}).get("owner_type", "unknown")
        to_owner = (t.get("to", {}) or {}).get("owner", "")
        tx_type = t.get("transaction_type", "transfer")

        emoji = {"btc": "🟠", "eth": "🟦", "usdt": "🟩", "usdc": "🔵"}.get(sym.lower(), "🐋")

        embed = {
            "title": f"{emoji} {sym} ${amt/1_000_000:.1f}M {tx_type}",
            "color": 0x00ffcc,
            "fields": [
                {"name": "From", "value": f"{from_addr}{' ('+from_owner+')' if from_owner else ''}"[:1024], "inline": True},
                {"name": "To", "value": f"{to_addr}{' ('+to_owner+')' if to_owner else ''}"[:1024], "inline": True},
                {"name": "Amount", "value": f"${amt:,.0f}", "inline": True},
            ],
            "timestamp": datetime.fromtimestamp(t.get("timestamp", time.time()), tz=timezone.utc).isoformat(),
        }
        if t.get("hash"):
            embed["footer"] = {"text": f"Tx: {t['hash'][:24]}..."}
        try:
            requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=10)
        except Exception as e:
            print(f"[whale] webhook error: {e}")

    state["last_cursor"] = cursor
    state["seen_ids"] = list(seen)[-1000:]  # keep last 1000
    STATE_FILE.write_text(json.dumps(state))

if __name__ == "__main__":
    main()
