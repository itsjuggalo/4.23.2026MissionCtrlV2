#!/usr/bin/env python3
"""holdings_flow_alert.py — ping #flow-picks when unusual options flow hits one of
YOUR names (holdings + watchlist). Read-only over the scraped flow data (does not
touch the signal stream). Deduped by alert key. Cron every ~10 min market hours.
"""
import json
import os
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import personal_tickers  # noqa: E402

ET = ZoneInfo("America/New_York")
DATA = Path.home() / "trading" / "signals" / "option-scraper" / "data"
FILES = ["flow_alerts_today.json", "flow2_alerts_today.json"]
STATE = Path.home() / ".openclaw" / "state" / "holdings_flow_seen.json"


def load():
    try:
        return set(json.loads(STATE.read_text()))
    except Exception:
        return set()


def save(seen):
    STATE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps(list(seen)[-3000:]))
    os.replace(tmp, STATE)


def fmt(a):
    sym = a.get("Symbol", "?")
    strike = a.get("Strike", "?")
    typ = str(a.get("OptionType", "?"))[:1]
    bt = a.get("BlockType", a.get("AlertType", "flow"))
    bull = "🟢 bullish" if a.get("isBullish") else "🔴 bearish"
    try:
        vs = f"${float(a.get('totalFlowValue', 0) or 0):,.0f}"
    except Exception:
        vs = "?"
    return f"🎯 **{sym}** ${strike}{typ} · {bt} · {vs} · {bull}"


def main():
    names = set(personal_tickers())   # holdings + watchlist only — NO index defaults
    if not names:
        print("[holdings-flow] no personal names; skip", flush=True)
        return
    seen = load()
    alerts = []
    for fn in FILES:
        p = DATA / fn
        if not p.exists():
            continue
        try:
            data = json.loads(p.read_text())
        except Exception:
            continue
        if not isinstance(data, dict):
            continue
        for k, entry in data.items():
            a = (entry or {}).get("alert", entry) if isinstance(entry, dict) else {}
            if isinstance(a, dict) and a.get("Symbol") in names:
                key = f"{fn}:{k}"
                if key not in seen:
                    alerts.append(fmt(a))
                    seen.add(key)
    if alerts:
        stamp = datetime.now(ET).strftime("%-I:%M %p ET")
        sd.post(sd.resolve_channel("flow-picks"),
                f"📡 **FLOW ON YOUR NAMES** · {stamp}\n" + "\n".join(alerts[:10]))
    save(seen)
    print(f"[holdings-flow] names={sorted(names)} alerts={len(alerts)}", flush=True)


if __name__ == "__main__":
    main()
