#!/usr/bin/env python3
"""
Per-Wallet Drawdown Guard (Step 4 part 2 of /silver-platter build plan, 2026-05-11).
Recipe R6 from data_map.json.

Programmatic safety rail for an autonomous trading system: NO human approval gates,
just per-wallet drawdown caps that auto-trigger killswitch files when breached.
Boba reads ~/.openclaw/workspace/state/killswitch_<wallet> and skips writes for
that wallet until the killswitch is cleared.

Reads existing wallet balance feed at /home/ubuntu/wallets-snapshot (refreshed
by /home/ubuntu/scripts/wallets-snapshot every 5 min via cron). Defensively skips
wallets with $0 balance (likely broken integration, e.g. Robinhood today).

Caps are sensible defaults: tighter on real money + equities, looser on paper +
leveraged perps that can swing wide intra-day. Override via env vars
DD_DAY_OPEN_<WALLET> and DD_DAY_HIGH_<WALLET>, e.g. DD_DAY_OPEN_COINBASE=-12.
"""
import json, os, sys
from datetime import datetime, timezone, timedelta
from pathlib import Path

ET = timezone(timedelta(hours=-4))
NOW = datetime.now(timezone.utc)
NOW_ET = NOW.astimezone(ET)
TODAY_ET = NOW_ET.strftime("%Y-%m-%d")

SNAPSHOT = Path("/home/ubuntu/wallets-snapshot")
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state")
STATE_FILE = STATE_DIR / "wallet_drawdown_state.json"
KILLSWITCH_PATH = STATE_DIR  # killswitch_<wallet>
ALERT_DEDUP = STATE_DIR / "wallet_drawdown_alerts_today.json"
LINEAR_BRIDGE_ENV = Path("/home/ubuntu/linear-bridge/env")

# Map wallet display name from snapshot -> wallet_id used for killswitch + caps.
WALLET_NAME_MAP = {
    "Alpaca Paper Trading": "alpaca_paper",
    "Coinbase": "coinbase",
    "Robinhood": "robinhood",
    "Hyperliquid (Personal)": "hyperliquid_personal",
}

# Sensible defaults: tighter on real money + equities, looser on paper + perps.
# day_open: drop from today's opening balance.
# day_high: drop from today's highwater (catches mid-day reversals).
DEFAULT_CAPS = {
    "alpaca_paper":         {"day_open": -10.0, "day_high": -8.0,  "real": False, "asset": "mixed"},
    "coinbase":             {"day_open": -8.0,  "day_high": -6.0,  "real": True,  "asset": "crypto"},
    "robinhood":            {"day_open": -5.0,  "day_high": -4.0,  "real": True,  "asset": "equities"},
    "hyperliquid_personal": {"day_open": -15.0, "day_high": -10.0, "real": True,  "asset": "perps"},
}


def load_caps(wallet_id):
    base = DEFAULT_CAPS.get(wallet_id, {"day_open": -10.0, "day_high": -8.0, "real": False, "asset": "unknown"})
    env_open = os.environ.get(f"DD_DAY_OPEN_{wallet_id.upper()}")
    env_high = os.environ.get(f"DD_DAY_HIGH_{wallet_id.upper()}")
    if env_open:
        try: base["day_open"] = float(env_open)
        except ValueError: pass
    if env_high:
        try: base["day_high"] = float(env_high)
        except ValueError: pass
    return base


def load_state():
    if not STATE_FILE.exists():
        return {}
    try:
        return json.loads(STATE_FILE.read_text())
    except Exception:
        return {}


def save_state(state):
    STATE_DIR.mkdir(parents=True, exist_ok=True)
    STATE_FILE.write_text(json.dumps(state, indent=2))


def load_alerts_today():
    if not ALERT_DEDUP.exists():
        return {"date_et": TODAY_ET, "alerted": []}
    try:
        d = json.loads(ALERT_DEDUP.read_text())
        if d.get("date_et") != TODAY_ET:
            return {"date_et": TODAY_ET, "alerted": []}
        return d
    except Exception:
        return {"date_et": TODAY_ET, "alerted": []}


def save_alerts_today(d):
    ALERT_DEDUP.write_text(json.dumps(d))


def read_alerts_webhook():
    if not LINEAR_BRIDGE_ENV.exists():
        return None
    for line in LINEAR_BRIDGE_ENV.read_text().splitlines():
        if line.startswith("DISCORD_ALERTS_URL="):
            return line.split("=", 1)[1].strip()
    return None


def post_alert(wallet_id, balance, opening, high, dd_open, dd_high, caps):
    webhook = read_alerts_webhook()
    if not webhook:
        return False
    suppressed = (KILLSWITCH_PATH / f"killswitch_{wallet_id}.suppress").exists()
    suffix = " (auto-killswitch SUPPRESSED by override flag)" if suppressed else ""
    msg = (
        f"**P1 WALLET DRAWDOWN BREACH** {wallet_id}\n"
        f"At {NOW_ET.strftime('%Y-%m-%d %H:%M:%S ET')}\n"
        f"Balance ${balance:,.2f} | open ${opening:,.2f} | high ${high:,.2f}\n"
        f"From open: {dd_open:+.2f}% (cap {caps['day_open']}%)\n"
        f"From high: {dd_high:+.2f}% (cap {caps['day_high']}%)\n"
        f"Killswitch: ~/.openclaw/workspace/state/killswitch_{wallet_id}{suffix}"
    )
    payload = {"username": "drawdown-guard", "content": msg}
    try:
        import urllib.request
        req = urllib.request.Request(
            webhook,
            data=json.dumps(payload).encode(),
            headers={"Content-Type": "application/json"},
            method="POST",
        )
        urllib.request.urlopen(req, timeout=10)
        return True
    except Exception:
        return False


def set_killswitch(wallet_id, reason):
    if (KILLSWITCH_PATH / f"killswitch_{wallet_id}.suppress").exists():
        return False
    target = KILLSWITCH_PATH / f"killswitch_{wallet_id}"
    KILLSWITCH_PATH.mkdir(parents=True, exist_ok=True)
    target.write_text(json.dumps({
        "set_at": NOW.isoformat(),
        "set_at_et": NOW_ET.strftime("%Y-%m-%d %H:%M:%S ET"),
        "reason": reason,
        "set_by": "per_wallet_drawdown_guard.py",
    }, indent=2))
    return True


def main():
    if not SNAPSHOT.exists():
        print(f"[drawdown-guard] {NOW_ET}: wallet snapshot missing at {SNAPSHOT}, abort")
        return 1
    try:
        snapshot = json.loads(SNAPSHOT.read_text())
    except Exception as e:
        print(f"[drawdown-guard] {NOW_ET}: snapshot parse error: {e}")
        return 1

    state = load_state()
    alerts = load_alerts_today()
    summary = []

    for w in snapshot:
        name = w.get("name") or ""
        wallet_id = WALLET_NAME_MAP.get(name)
        if not wallet_id:
            summary.append((name or "?", "skip", "unknown wallet name (not in WALLET_NAME_MAP)"))
            continue
        balance = float(w.get("balance") or 0.0)
        if balance <= 0:
            summary.append((wallet_id, "skip", f"balance={balance} (broken integration?)"))
            continue

        s = state.get(wallet_id, {})
        if s.get("date_et") != TODAY_ET:
            s = {"date_et": TODAY_ET, "opening_balance": balance, "highwater": balance}
        s["highwater"] = max(s.get("highwater", balance), balance)

        opening = s["opening_balance"]
        high = s["highwater"]
        dd_open = (balance - opening) / opening * 100.0 if opening > 0 else 0.0
        dd_high = (balance - high) / high * 100.0 if high > 0 else 0.0
        caps = load_caps(wallet_id)
        breach_open = dd_open <= caps["day_open"]
        breach_high = dd_high <= caps["day_high"]

        s["last_balance"] = balance
        s["last_dd_open_pct"] = round(dd_open, 2)
        s["last_dd_high_pct"] = round(dd_high, 2)
        s["caps"] = caps
        state[wallet_id] = s

        if (breach_open or breach_high) and wallet_id not in alerts["alerted"]:
            reason = []
            if breach_open: reason.append(f"day_open {dd_open:.2f}% breached cap {caps['day_open']}%")
            if breach_high: reason.append(f"day_high {dd_high:.2f}% breached cap {caps['day_high']}%")
            reason_str = "; ".join(reason)
            killed = set_killswitch(wallet_id, reason_str)
            posted = post_alert(wallet_id, balance, opening, high, dd_open, dd_high, caps)
            alerts["alerted"].append(wallet_id)
            summary.append((wallet_id, "BREACH", f"killswitch={killed} alert_posted={posted} {reason_str}"))
        else:
            tag = "watched" if (breach_open or breach_high) else "ok"
            summary.append((wallet_id, tag, f"bal=${balance:,.2f} open=${opening:,.2f} high=${high:,.2f} dd_open={dd_open:+.2f}% dd_high={dd_high:+.2f}%"))

    save_state(state)
    save_alerts_today(alerts)

    print(f"[drawdown-guard] {NOW_ET.strftime('%Y-%m-%d %H:%M:%S ET')} checked={len(snapshot)} alerted_today={len(alerts['alerted'])}")
    for wid, status, msg in summary:
        print(f"  {status:8s} {wid:25s} {msg}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
