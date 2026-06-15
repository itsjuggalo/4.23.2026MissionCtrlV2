#!/usr/bin/env python3
"""crypto_holdings_alert.py — ping #daily-crypto-pumps when YOUR real-money crypto
(Robinhood + Coinbase, via lib.portfolio) makes a notable 24h move. Read-only.

24h % from Coinbase's public stats API (no key, covers all his coins). Alerts on
|move| >= THRESHOLD for positions worth >= DUST, deduped per day per 5%-bucket so it
re-pings as a move GROWS (5→10→15%) but not every run. Cron every ~30 min.
"""
from __future__ import annotations

import json
import os
import sys
import urllib.request
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import real_money_holdings  # noqa: E402
from lib.heartbeat import beat  # noqa: E402

ET = ZoneInfo("America/New_York")
STATE = Path.home() / ".openclaw" / "state" / "crypto_holdings_seen.json"
THRESHOLD = 5.0     # % 24h move to alert
DUST = 15.0         # ignore positions worth less than this


def _stats_chg(sym: str) -> float | None:
    try:
        r = urllib.request.Request(
            f"https://api.exchange.coinbase.com/products/{sym}-USD/stats",
            headers={"User-Agent": "mc/1.0"})
        d = json.loads(urllib.request.urlopen(r, timeout=10).read())
        o = float(d.get("open", 0) or 0)
        last = float(d.get("last", 0) or 0)
        return (last - o) / o * 100 if o else None
    except Exception:
        return None


def _load() -> dict:
    try:
        d = json.loads(STATE.read_text())
        if d.get("date") == datetime.now(ET).strftime("%Y-%m-%d"):
            return d.get("seen", {})
    except Exception:
        pass
    return {}


def _save(seen: dict) -> None:
    STATE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps({"date": datetime.now(ET).strftime("%Y-%m-%d"), "seen": seen}))
    os.replace(tmp, STATE)


def main():
    held = real_money_holdings()
    if not held:
        print("[crypto-alert] no holdings / ARIES down; skip", flush=True)
        return
    seen = _load()
    moves, fresh = [], False
    for sym, val in sorted(held.items(), key=lambda x: -x[1]):
        if val < DUST:
            continue
        chg = _stats_chg(sym)
        if chg is None or abs(chg) < THRESHOLD:
            continue
        bucket = int(chg // 5)          # 5%-granularity; grows as the move grows
        if seen.get(sym) != bucket:
            fresh = True
        seen[sym] = bucket
        moves.append((sym, chg, val))
    if moves and fresh:
        stamp = datetime.now(ET).strftime("%-I:%M %p ET")
        lines = [f"💎 **YOUR CRYPTO — notable 24h moves** · {stamp}"]
        for sym, chg, val in moves:
            ic = "🚀" if chg > 0 else "🔻"
            lines.append(f"{ic} **{sym}** {chg:+.1f}%  ·  ${val:,.0f} held")
        lines.append("_Real-money RH + Coinbase book. Alerts on ≥5% 24h moves._")
        sd.post(sd.resolve_channel("daily-crypto-pumps"), "\n".join(lines))
        print(f"[crypto-alert] posted {len(moves)} moves", flush=True)
    else:
        print(f"[crypto-alert] {len(moves)} elevated, none fresh; no post", flush=True)
    # prune seen to current holdings to keep it tidy
    _save({k: v for k, v in seen.items() if k in held})
    beat("crypto_holdings")


if __name__ == "__main__":
    main()
