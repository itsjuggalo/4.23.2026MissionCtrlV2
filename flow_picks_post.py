#!/usr/bin/env python3
"""flow_picks_post.py — deterministic FLOW PICKS poster for Discord.

Reads the LIVE scraped option flow (read-only — never touches the signal stream),
ranks the current contracts by conviction (flow $ + fresh vol/OI + sweep/repeat +
DTE sanity), splits 0DTE tape-confirmation from swing-able picks, flags YOUR names
(holdings + watchlist + real-money crypto), prepends a SPY/QQQ/VIX tape line, and
posts to #flow-picks. Cron-driven intraday. Run with ~/.venv/bin/python (for yfinance).

  flow_picks_post.py            # post to #flow-picks
  flow_picks_post.py --print    # print only, don't post
  flow_picks_post.py --channel flow-picks
"""
from __future__ import annotations

import argparse
import json
import math
import sys
from datetime import datetime, timezone
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from skill_to_discord import post, resolve_channel  # noqa: E402  (resilient bot poster)
from lib.portfolio import personal_tickers, personal_crypto  # noqa: E402

ET = ZoneInfo("America/New_York")
DATA = Path.home() / "trading" / "signals" / "option-scraper" / "data"
FILES = ["flow_alerts_today.json", "flow2_alerts_today.json"]


def _load() -> dict:
    merged = {}
    for fn in FILES:
        p = DATA / fn
        if not p.exists():
            continue
        try:
            d = json.loads(p.read_text())
        except Exception:
            continue
        for v in d.values():
            a = v.get("alert", v) if isinstance(v, dict) else v
            if not isinstance(a, dict):
                continue
            sym = a.get("OptionSymbol")
            if not sym:
                continue
            fv = float(a.get("totalFlowValue", 0) or 0)
            if sym not in merged or fv > float(merged[sym].get("totalFlowValue", 0) or 0):
                merged[sym] = a
    return merged


def _score(a: dict) -> tuple:
    fv = float(a.get("totalFlowValue", 0) or 0)
    vol = float(a.get("Volume", 0) or 0)
    oi = float(a.get("OI", 0) or 1)
    dte = int(a.get("DTE", 0) or 0)
    sweeps = int(a.get("SWEEPS", 0) or 0)
    blocks = int(a.get("BLOCKS", 0) or 0)
    voi = vol / oi if oi else 0
    s = math.log10(max(fv, 1)) * 2
    s += min(voi, 5) * 1.5
    s += 0.6 if 10 <= dte <= 180 else (-1.0 if dte < 7 else 0)
    s += min(sweeps + blocks, 15) * 0.15
    return s, fv, voi, dte


def _fmt(a: dict) -> str:
    exp = datetime.fromtimestamp(int(a["Expiry"]), tz=timezone.utc).astimezone(ET).strftime("%-m/%-d")
    typ = "C" if str(a.get("OptionType", "")).upper().startswith("C") else "P"
    return f"{a['Symbol']} ${a['Strike']:g}{typ} {exp}"


def _tape() -> str:
    try:
        import yfinance as yf
        out = []
        for t, lbl in (("SPY", "SPY"), ("QQQ", "QQQ"), ("^VIX", "VIX")):
            h = yf.Ticker(t).history(period="2d", interval="1d")
            i = yf.Ticker(t).history(period="1d", interval="5m")
            prev = float(h["Close"].iloc[-2])
            now = float(i["Close"].iloc[-1]) if len(i) else float(h["Close"].iloc[-1])
            chg = (now - prev) / prev * 100
            out.append(f"{lbl} {now:,.0f} ({chg:+.1f}%)" if lbl != "VIX" else f"VIX {now:.1f} ({chg:+.1f}%)")
        return " · ".join(out)
    except Exception:
        return ""


def build() -> str | None:
    merged = _load()
    if not merged:
        return None
    names = {s.upper() for s in personal_tickers()} | {s.upper() for s in personal_crypto()}
    scored = sorted(((_score(a), a) for a in merged.values()), key=lambda x: -x[0][0])
    conf, picks = [], []
    for (s, fv, voi, dte), a in scored:
        tag = " 🎯YOUR NAME" if str(a.get("Symbol", "")).upper() in names else ""
        if dte <= 1 and a.get("isBullish") and len(conf) < 2:
            conf.append(f"• **{_fmt(a)}** — ${fv:,.0f}, {int(a.get('SWEEPS',0))} sweeps, V/OI {voi:.1f}{tag}")
        elif dte >= 7 and len(picks) < 3:
            dirn = "🟢" if a.get("isBullish") else "🔴"
            picks.append((a, fv, voi, dte, dirn, tag))

    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    tape = _tape()
    lines = [f"🎯 **FLOW PICKS — live contracts** · {stamp}"]
    if tape:
        lines.append(f"_Tape: {tape}_")
    if conf:
        lines.append("\n**🟢 TAPE CONFIRMATION (0DTE — direction, not swing buys):**")
        lines += conf
    if picks:
        lines.append("\n**⭐ BEST SWING-ABLE PICKS (real DTE + fresh positioning):**")
        for i, (a, fv, voi, dte, dirn, tag) in enumerate(picks, 1):
            vol = int(a.get("Volume", 0) or 0)
            oi = int(a.get("OI", 0) or 0)
            why = ("fresh opening flow (vol >> OI)" if voi >= 2 else
                   "repeat institutional positioning" if voi < 1 else "building position")
            lines.append(f"**{i}. {_fmt(a)}** ({dte} DTE) {dirn}{tag} · ${fv:,.0f} · V/OI {voi:.1f} ({vol:,}/{oi:,})\n   *{why}*")
    # your-name caution: largest flow on a held name that reads bearish
    for (s, fv, voi, dte), a in scored:
        if str(a.get("Symbol", "")).upper() in names and not a.get("isBullish") and fv > 2_000_000:
            lines.append(f"\n⚠️ **YOUR NAME — {a['Symbol']}:** big flow ({_fmt(a)}, ${fv:,.0f}) reads "
                         f"**bearish** (V/OI {voi:.1f}). Don't mistake size for a green light.")
            break
    lines.append("\n_0DTE = confirmation not entry · size $100–250 risk (fraction of equity) · auto-posted intraday._")
    return "\n".join(lines)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="flow-picks")
    ap.add_argument("--print", action="store_true", dest="print_only")
    a = ap.parse_args()
    msg = build()
    if not msg:
        print("[flow-picks] no flow data; skip", flush=True)
        return
    if a.print_only:
        print(msg)
        return
    post(resolve_channel(a.channel), msg)
    print(f"[flow-picks] posted ({len(msg)} chars)", flush=True)


if __name__ == "__main__":
    main()
