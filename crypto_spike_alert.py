#!/usr/bin/env python3
"""crypto_spike_alert.py — fast intraday SPIKE alerts on YOUR real-money crypto.

Complements crypto_holdings_alert.py (24h moves): this catches sharp 15-minute moves
(≥3%) using Coinbase 5-min candles (no key). Per-coin 20-min cooldown so a sustained
pump pings once, not every run. Read-only. Cron every ~5 min.
"""
from __future__ import annotations

import json
import os
import sys
import time
import urllib.request
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import skill_to_discord as sd  # noqa: E402
from lib.portfolio import real_money_holdings  # noqa: E402
from lib.heartbeat import beat  # noqa: E402

ET = ZoneInfo("America/New_York")
STATE = Path.home() / ".openclaw" / "state" / "crypto_spike_seen.json"
THRESHOLD = 3.0       # % move over the 15-min window
DUST = 15.0           # ignore tiny positions
COOLDOWN = 1200       # s between alerts for the same coin


def _chg15(sym: str):
    """(pct_change_15m, latest_price) from Coinbase 5-min candles, or (None,None)."""
    try:
        r = urllib.request.Request(
            f"https://api.exchange.coinbase.com/products/{sym}-USD/candles?granularity=300",
            headers={"User-Agent": "mc/1.0"})
        c = json.loads(urllib.request.urlopen(r, timeout=10).read())  # newest first
        if len(c) < 4:
            return None, None
        now = float(c[0][4])
        ago = float(c[3][4])     # ~15 min ago (3×5min)
        return ((now - ago) / ago * 100 if ago else None), now
    except Exception:
        return None, None


def _load() -> dict:
    try:
        d = json.loads(STATE.read_text())
        if d.get("date") == datetime.now(ET).strftime("%Y-%m-%d"):
            return d.get("last", {})
    except Exception:
        pass
    return {}


def _save(last: dict) -> None:
    STATE.parent.mkdir(parents=True, exist_ok=True)
    tmp = STATE.with_suffix(".tmp")
    tmp.write_text(json.dumps({"date": datetime.now(ET).strftime("%Y-%m-%d"), "last": last}))
    os.replace(tmp, STATE)


def main():
    held = real_money_holdings()
    if not held:
        print("[crypto-spike] no holdings; skip", flush=True)
        return
    last = _load()
    now_ts = time.time()
    spikes = []
    for sym, val in sorted(held.items(), key=lambda x: -x[1]):
        if val < DUST:
            continue
        chg, px = _chg15(sym)
        if chg is None or abs(chg) < THRESHOLD:
            continue
        if now_ts - float(last.get(sym, 0)) < COOLDOWN:   # still cooling down
            continue
        last[sym] = now_ts
        spikes.append((sym, chg, px, val))
    if spikes:
        stamp = datetime.now(ET).strftime("%-I:%M %p ET")
        lines = [f"⚡ **CRYPTO SPIKE (15-min)** · {stamp}"]
        for sym, chg, px, val in spikes:
            ic = "🚀" if chg > 0 else "🔻"
            lines.append(f"{ic} **{sym}** {chg:+.1f}% in 15m → ${px:,.4g}  ·  ${val:,.0f} held")
        lines.append("_Fast-move radar on your real-money crypto. 20-min cooldown per coin._")
        sd.post(sd.resolve_channel("daily-crypto-pumps"), "\n".join(lines))
        print(f"[crypto-spike] posted {len(spikes)} spikes", flush=True)
    else:
        print("[crypto-spike] no fresh spikes", flush=True)
    _save({k: v for k, v in last.items() if k in held})
    beat("crypto_spike")


if __name__ == "__main__":
    main()
