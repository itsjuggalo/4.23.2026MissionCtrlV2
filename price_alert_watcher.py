#!/usr/bin/env python3
"""price_alert_watcher.py — fire Command Center price/flow-repeat alerts to Telegram.

Store: ~/.openclaw/workspace/state/price_alerts.json (written by the missionctrl
/api/price-alerts route; this watcher flips status active→fired and prunes >7d).
Quotes: local /api/live-quotes (alpaca-iex, the CC source-of-record).
Flow repeats: local /api/options-flow (Symbol + Updated epoch-ms).
Delivery: tg_fleet send trading_command (LaptopClaude bot — Mike's trading lane).

Cron: * 9-16 * * 1-5 ET; exits instantly outside 09:28-16:02 ET. Advisory only —
never touches the merged flow-signal stream or any trading state.
"""
import json, os, subprocess, sys, tempfile, urllib.request
from datetime import datetime
from zoneinfo import ZoneInfo

HOME = os.path.expanduser("~")
STORE = os.path.join(HOME, ".openclaw/workspace/state/price_alerts.json")
TG = [sys.executable, os.path.join(HOME, "scripts/tg_fleet.py"), "send", "trading_command"]
BASE = "http://127.0.0.1:3000"
ET = ZoneInfo("America/New_York")


def rth_now() -> bool:
    now = datetime.now(ET)
    if now.weekday() >= 5:
        return False
    m = now.hour * 60 + now.minute
    return 9 * 60 + 28 <= m <= 16 * 60 + 2


def get_json(path: str, timeout: int = 10):
    with urllib.request.urlopen(f"{BASE}{path}", timeout=timeout) as r:
        return json.load(r)


def load_alerts():
    try:
        with open(STORE) as f:
            return json.load(f)
    except Exception:
        return []


def save_alerts(alerts):
    fd, tmp = tempfile.mkstemp(dir=os.path.dirname(STORE), prefix=".alerts-")
    with os.fdopen(fd, "w") as f:
        json.dump(alerts, f, indent=1)
    os.replace(tmp, STORE)


def notify(text: str) -> bool:
    try:
        return subprocess.run(TG + [text], capture_output=True, timeout=30).returncode == 0
    except Exception:
        return False


SCALP_STATE = os.path.join(HOME, ".openclaw/workspace/state/scalp_watch_state.json")


def watch_scalp_transitions():
    """Auto-ping (no registration needed) when the SPY 0DTE scalp signal hits
    TARGET1 or closes — a scalper shouldn't have to stare at the panel."""
    try:
        d = get_json("/api/spy-scalp")
    except Exception:
        return
    sig = d.get("signal") or {}
    log = d.get("log") or []
    cur = {
        "status": sig.get("status") or "",
        "contract": sig.get("contract") or "",
        "log_len": len(log),
    }
    try:
        with open(SCALP_STATE) as f:
            prev = json.load(f)
    except Exception:
        prev = {}
    try:
        if (
            cur["status"] == "TARGET1"
            and (prev.get("status") != "TARGET1" or prev.get("contract") != cur["contract"])
        ):
            notify(f"🎯 SCALP T1 HIT: {cur['contract']} — half sold, stop to break-even (advisory)")
        if cur["log_len"] > prev.get("log_len", cur["log_len"]):
            r = log[-1]
            notify(
                f"🏁 SCALP CLOSED: SPY ${r.get('strike')}{'C' if r.get('direction')=='CALL' else 'P'} "
                f"{r.get('result')} {r.get('pnl_pct', 0):+.0f}% ({r.get('fired_at_h')}→{r.get('closed_at_h')})"
            )
    finally:
        fd, tmp = tempfile.mkstemp(dir=os.path.dirname(SCALP_STATE), prefix=".scalp-")
        with os.fdopen(fd, "w") as f:
            json.dump(cur, f)
        os.replace(tmp, SCALP_STATE)


def main():
    if not rth_now():
        return
    watch_scalp_transitions()
    alerts = load_alerts()
    active = [a for a in alerts if a.get("status") == "active"]
    if not active:
        return

    now_ms = int(datetime.now().timestamp() * 1000)
    changed = False

    # --- price alerts ---
    price_alerts = [a for a in active if a.get("kind") == "price"]
    if price_alerts:
        syms = ",".join(sorted({a["sym"] for a in price_alerts}))
        try:
            prices = get_json(f"/api/live-quotes?symbols={syms}").get("prices", {})
        except Exception:
            prices = {}
        for a in price_alerts:
            q = prices.get(a["sym"])
            if not q or not q.get("price"):
                continue
            px = q["price"]
            hit = px >= a["price"] if a.get("dir") == "above" else px <= a["price"]
            if hit:
                note = f" — {a['note']}" if a.get("note") else ""
                detail = f"{a['sym']} {a['dir']} ${a['price']:g} hit (now ${px:g}){note}"
                if notify(f"🔔 ALERT: {detail}  [{a.get('source','manual')}]"):
                    a.update(status="fired", firedAt=now_ms, firedDetail=detail)
                    changed = True

    # --- flow-repeat alerts ---
    repeat_alerts = [a for a in active if a.get("kind") == "flow-repeat"]
    if repeat_alerts:
        try:
            rows = get_json("/api/options-flow").get("alerts", []) or []
        except Exception:
            rows = []
        for a in repeat_alerts:
            fresh = [
                r for r in rows
                if str(r.get("Symbol", "")).upper() == a["sym"]
                and float(r.get("Updated") or 0) > a["created"]
            ]
            if fresh:
                r = max(fresh, key=lambda x: float(x.get("totalFlowValue") or 0))
                prem = float(r.get("totalFlowValue") or 0)
                detail = (
                    f"{a['sym']} flow fired again: {r.get('OptionType','?')} ${r.get('Strike','?')} "
                    f"~${prem/1e6:.2f}M {'bullish' if r.get('isBullish') else 'bearish'}"
                )
                if notify(f"🔁 FLOW REPEAT: {detail}"):
                    a.update(status="fired", firedAt=now_ms, firedDetail=detail)
                    changed = True

    # --- prune fired/cancelled >7d so the store never grows unbounded ---
    cutoff = now_ms - 7 * 24 * 3600_000
    pruned = [
        a for a in alerts
        if a.get("status") == "active" or (a.get("firedAt") or a.get("created", 0)) > cutoff
    ]
    if changed or len(pruned) != len(alerts):
        save_alerts(pruned)


if __name__ == "__main__":
    main()
