#!/usr/bin/env python3
"""
Firebase Signal Relay — polls Name/Name2/Vivid for new trade signals, posts to
Discord, and writes the canonical feed that Boba/Jazzy/askgrok read via the
firebase_signals module.

PM2: pm2 start scripts/firebase_signal_relay.py --name firebase-signal-relay --interpreter python3

Canonical location is scripts/ so code-push tracks it. The old copies under
mission-control-vercel/bots/ and mission-control-restored/bots/ are retired.
"""
import json, time, requests, sys
from pathlib import Path
from datetime import datetime

SECRETS = Path.home() / ".openclaw" / "secrets"
STATE_DIR = Path.home() / ".openclaw" / "workspace" / "state"
STATE_DIR.mkdir(parents=True, exist_ok=True)
STATE_FILE = STATE_DIR / "signal_relay_state.json"
BASE = "https://stock-signal-72772-default-rtdb.firebaseio.com"

# Boba/Jazzy/askgrok feed — consumed via the shared firebase_signals module.
BOBA_FEED = Path.home() / ".openclaw" / "workspace" / "directives" / "firebase_trade_signals.json"
BOBA_FEED.parent.mkdir(parents=True, exist_ok=True)
BOBA_FEED_MAX = 50  # keep last N trade signals

# Explicit liveness — firebase_signals.feed_health() and precycle_health read this
# instead of guessing from feed mtime (silent-degradation guard, MIS-107).
STATUS_FILE = BOBA_FEED.with_name("firebase_signal_relay_status.json")
FAIL_EXIT_THRESHOLD = 10  # consecutive all-fetch-failed polls -> exit non-zero for PM2


def get_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else None

WEBHOOKS = {
    "Name": get_secret("discord-webhook-signals-name.txt"),
    "Name2": get_secret("discord-webhook-signals-name2.txt"),
    "Vivid": get_secret("discord-webhook-signals-vivid.txt"),
}
WEBHOOK = get_secret("discord_tv_signals_webhook")  # fallback


def load_state():
    if STATE_FILE.exists():
        try:
            return json.loads(STATE_FILE.read_text())
        except Exception:
            pass
    return {"seen_ids": []}


def save_state(state):
    STATE_FILE.write_text(json.dumps(state))


def write_status(poll_ok, consecutive_failures, last_signal_at):
    """Record relay liveness so downstream health checks are honest."""
    try:
        STATUS_FILE.write_text(json.dumps({
            "last_poll_ok": poll_ok,
            "last_poll_at": datetime.now().isoformat(),
            "last_signal_at": last_signal_at,
            "consecutive_failures": consecutive_failures,
        }, indent=2))
    except Exception as e:
        print(f"[signal-relay] status write failed: {e}")


def fetch_json(path):
    try:
        r = requests.get(f"{BASE}/{path}", timeout=10)
        return (r.json() if r.status_code == 200 else None), (r.status_code == 200)
    except Exception:
        return None, False


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


def post_to_discord(message, source=None):
    wh = WEBHOOKS.get(source, WEBHOOK) if source else WEBHOOK
    if not wh:
        print(f"[signal-relay] No webhook for source {source}")
        return
    try:
        requests.post(wh, json={
            "username": "Signal Relay",
            "content": message
        }, timeout=10)
        print(f"[signal-relay] Posted to Discord")
    except Exception as e:
        print(f"[signal-relay] Discord error: {e}")


def save_for_boba(new_signals):
    """Append new signals to the Boba feed JSON, capping at BOBA_FEED_MAX."""
    if not new_signals:
        return
    existing = []
    if BOBA_FEED.exists():
        try:
            existing = json.loads(BOBA_FEED.read_text())
            if not isinstance(existing, list):
                existing = []
        except Exception:
            existing = []
    combined = existing + new_signals
    # Most recent first, dedupe by id, cap
    seen_ids = set()
    deduped = []
    for s in reversed(combined):
        if s.get("id") not in seen_ids:
            seen_ids.add(s.get("id"))
            deduped.append(s)
    deduped = list(reversed(deduped))[-BOBA_FEED_MAX:]
    BOBA_FEED.write_text(json.dumps(deduped, indent=2))
    print(f"[signal-relay] Wrote {len(deduped)} signals to Boba feed")


def poll():
    """Returns (new_count, any_fetch_ok). any_fetch_ok=False means every RTDB
    call failed this cycle — treated as a degradation signal, not 'no news'."""
    state = load_state()
    new_signals_buffer = []
    seen = set(state.get("seen_ids", []))
    new_count = 0
    any_fetch_ok = False

    for source, paths in [
        ("Name", ["ShortTermOptions", "LongTermOptions"]),
        ("Name2", ["ShortTermOptions", "LongTermOptions"]),
        ("Vivid", ["ShortTermOptions"]),
    ]:
        for path in paths:
            data, ok = fetch_json(f"{source}/{path}.json")
            if ok:
                any_fetch_ok = True
            if not data or not isinstance(data, dict):
                continue
            for sig_id, sig in data.items():
                full_id = f"{source}:{sig_id}"
                if full_id not in seen:
                    seen.add(full_id)
                    msg = format_signal(sig, f"{source}/{path}")
                    post_to_discord(msg, source=source)
                    new_signals_buffer.append({
                        "id": full_id,
                        "source": source,
                        "path": path,
                        "ticker": sig.get("symbol", "???"),
                        "strike": sig.get("strike"),
                        "is_put": sig.get("isPut", False),
                        "category": sig.get("category", "UNKNOWN"),
                        "buy_target": sig.get("buyTarget"),
                        "sell_target": sig.get("sellTarget"),
                        "stop_loss": sig.get("stopLoss") or sig.get("reduceLoss"),
                        "expiry_ts": sig.get("expiry"),
                        "risk": sig.get("risk"),
                        "is_free": sig.get("free", False),
                        "captured_at": datetime.now().isoformat(),
                    })
                    new_count += 1
                    time.sleep(1)

    # Keep only last 500 IDs
    state["seen_ids"] = list(seen)[-500:]
    save_state(state)
    save_for_boba(new_signals_buffer)
    return new_count, any_fetch_ok


if __name__ == "__main__":
    print("[signal-relay] Starting Firebase signal relay...")
    print(f"[signal-relay] Webhook: {'configured' if WEBHOOK else 'MISSING'}")

    # Initial poll to seed state without spamming
    state = load_state()
    if not state.get("seen_ids"):
        print("[signal-relay] First run — seeding state (no Discord posts)...")
        for source in ["Name", "Name2", "Vivid"]:
            for path in ["ShortTermOptions", "LongTermOptions"]:
                data, _ok = fetch_json(f"{source}/{path}.json")
                if data and isinstance(data, dict):
                    for sig_id in data:
                        state.setdefault("seen_ids", []).append(f"{source}:{sig_id}")
        save_state(state)
        print(f"[signal-relay] Seeded {len(state['seen_ids'])} existing signals")

    consecutive_failures = 0
    last_signal_at = None

    while True:
        try:
            n, any_fetch_ok = poll()
            if n > 0:
                print(f"[signal-relay] Found {n} new signals")
                last_signal_at = datetime.now().isoformat()
            if any_fetch_ok:
                consecutive_failures = 0
            else:
                consecutive_failures += 1
                print(f"[signal-relay] All RTDB fetches failed "
                      f"({consecutive_failures}/{FAIL_EXIT_THRESHOLD})")
            write_status(any_fetch_ok, consecutive_failures, last_signal_at)
            # Silent-degradation guard: exit non-zero so PM2 surfaces a dead feed
            # instead of the process looking 'online' while the API 401s for days.
            if consecutive_failures >= FAIL_EXIT_THRESHOLD:
                print("[signal-relay] FATAL: RTDB unreachable for "
                      f"{consecutive_failures} consecutive polls — exiting non-zero.")
                sys.exit(1)
        except Exception as e:
            print(f"[signal-relay] Error: {e}")
        time.sleep(60)
