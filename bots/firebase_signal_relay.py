#!/usr/bin/env python3
"""
Firebase Signal Relay — polls Name/Vivid for new trade signals, posts to Discord.
PM2: pm2 start bots/firebase_signal_relay.py --name firebase-signal-relay --interpreter python3
"""
import json, time, requests
from pathlib import Path
from datetime import datetime

SECRETS = Path.home() / ".openclaw" / "secrets"
DATA = Path.home() / "mission-control-restored" / "data"
DATA.mkdir(parents=True, exist_ok=True)
STATE_FILE = DATA / "signal_relay_state.json"
BASE = "https://stock-signal-72772-default-rtdb.firebaseio.com"

def get_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else None

WEBHOOK = get_secret("discord_tv_signals_webhook")

def load_state():
    if STATE_FILE.exists():
        return json.loads(STATE_FILE.read_text())
    return {"seen_ids": []}

def save_state(state):
    STATE_FILE.write_text(json.dumps(state))

def fetch_json(path):
    try:
        r = requests.get(f"{BASE}/{path}", timeout=10)
        return r.json() if r.status_code == 200 else None
    except:
        return None

def format_signal(sig, source):
    sym = sig.get("symbol", "???")
    strike = sig.get("strike", "?")
    cat = sig.get("category", "UNKNOWN")
    buy = sig.get("buyTarget", "?")
    sell = sig.get("sellTarget", "?")
    sl = sig.get("stopLoss", sig.get("reduceLoss", "?"))
    is_put = "PUT" if sig.get("isPut") else "CALL"
    expiry_ts = sig.get("expiry")
    exp_str = datetime.fromtimestamp(int(expiry_ts)).strftime("%m/%d") if expiry_ts else "?"
    risk = sig.get("risk", "?")
    free = "FREE" if sig.get("free") else "PREMIUM"

    return (
        f"{'🟢' if not sig.get('isPut') else '🔴'} **{source}** — {cat}\n"
        f"**{sym}** ${strike} {is_put} exp {exp_str}\n"
        f"Entry: ${buy} | Target: ${sell} | SL: ${sl}\n"
        f"Risk: {risk} | {free}"
    )

def post_to_discord(message):
    if not WEBHOOK:
        print(f"[signal-relay] No webhook configured")
        return
    try:
        requests.post(WEBHOOK, json={
            "username": "Signal Relay",
            "content": message
        }, timeout=10)
        print(f"[signal-relay] Posted to Discord")
    except Exception as e:
        print(f"[signal-relay] Discord error: {e}")

def poll():
    state = load_state()
    seen = set(state.get("seen_ids", []))
    new_count = 0

    for source, paths in [
        ("Name", ["ShortTermOptions", "LongTermOptions"]),
        ("Name2", ["ShortTermOptions", "LongTermOptions"]),
        ("Vivid", ["ShortTermOptions"]),
    ]:
        for path in paths:
            data = fetch_json(f"{source}/{path}.json")
            if not data or not isinstance(data, dict):
                continue
            for sig_id, sig in data.items():
                full_id = f"{source}:{sig_id}"
                if full_id not in seen:
                    seen.add(full_id)
                    msg = format_signal(sig, f"{source}/{path}")
                    post_to_discord(msg)
                    new_count += 1
                    time.sleep(1)

    # Keep only last 500 IDs
    state["seen_ids"] = list(seen)[-500:]
    save_state(state)
    return new_count

if __name__ == "__main__":
    print("[signal-relay] Starting Firebase signal relay...")
    print(f"[signal-relay] Webhook: {'configured' if WEBHOOK else 'MISSING'}")

    # Initial poll to seed state without spamming
    state = load_state()
    if not state.get("seen_ids"):
        print("[signal-relay] First run — seeding state (no Discord posts)...")
        for source in ["Name", "Name2", "Vivid"]:
            for path in ["ShortTermOptions", "LongTermOptions"]:
                data = fetch_json(f"{source}/{path}.json")
                if data and isinstance(data, dict):
                    for sig_id in data:
                        state.setdefault("seen_ids", []).append(f"{source}:{sig_id}")
        save_state(state)
        print(f"[signal-relay] Seeded {len(state['seen_ids'])} existing signals")

    while True:
        try:
            n = poll()
            if n > 0:
                print(f"[signal-relay] Found {n} new signals")
        except Exception as e:
            print(f"[signal-relay] Error: {e}")
        time.sleep(60)
