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
PICKLOG_DIR = Path.home() / ".openclaw" / "state"


def _spot(ticker: str):
    """Underlying last price (yfinance) for grading later. None on failure."""
    try:
        import yfinance as yf
        i = yf.Ticker(ticker).history(period="1d", interval="5m")
        if len(i):
            return float(i["Close"].iloc[-1])
        h = yf.Ticker(ticker).history(period="1d")
        return float(h["Close"].iloc[-1]) if len(h) else None
    except Exception:
        return None


def _log_picks(picks):
    """Append swing picks to today's log so the EOD scorecard can grade them.
    Records the underlying spot at first pick-time (earliest reference per contract)."""
    if not picks:
        return
    date = datetime.now(ET).strftime("%Y-%m-%d")
    path = PICKLOG_DIR / f"flow_picks_log_{date}.jsonl"
    seen = set()
    if path.exists():
        try:
            for ln in path.read_text().splitlines():
                seen.add(json.loads(ln).get("optionSymbol"))
        except Exception:
            pass
    PICKLOG_DIR.mkdir(parents=True, exist_ok=True)
    with open(path, "a") as f:
        for a, fv, voi, dte, tag, spot, otm in picks:
            osym = a.get("OptionSymbol")
            if osym in seen:        # only log a contract's first appearance
                continue
            rec = {"ts": datetime.now(ET).isoformat(), "symbol": a.get("Symbol"), "optionSymbol": osym,
                   "strike": a.get("Strike"), "type": str(a.get("OptionType", ""))[:1],
                   "exp": int(a.get("Expiry", 0) or 0), "dte": dte, "spot": spot,
                   "flowValue": fv, "isBullish": bool(a.get("isBullish"))}
            f.write(json.dumps(rec) + "\n")


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


MAX_MNY = 0.15   # |moneyness| beyond this = hedge/LEAP/stock-replacement, not a swing pick
DTE_MIN, DTE_MAX = 7, 120   # swing window — excludes 0DTE lotto and long-dated LEAPs
RISK_CAP = 250   # Mike's per-trade risk cap (premium-at-risk model)


def _mid(row):
    bid, ask, last = float(row["bid"] or 0), float(row["ask"] or 0), float(row["lastPrice"] or 0)
    return (bid + ask) / 2 if (bid and ask) else last


ALT_MAX_MNY = 0.20   # an affordable alternative must still be within 20% of spot (no lotto)


def _sizing_line(a, is_call, spot=None):
    """Premium-based sizing for Mike's $150–250 risk. If the flagged contract is above his
    cap, scan the SAME-expiry chain for an affordable, still-near-money same-direction strike."""
    try:
        import yfinance as yf
        exp = datetime.fromtimestamp(int(a.get("Expiry", 0)), tz=timezone.utc).astimezone(ET).strftime("%Y-%m-%d")
        t = yf.Ticker(a.get("Symbol"))
        if exp not in (t.options or ()):
            return ""
        df = (t.option_chain(exp).calls if is_call else t.option_chain(exp).puts)
        strike = float(a.get("Strike", 0) or 0)
        row = df[df["strike"] == strike]
        mid = _mid(row.iloc[0]) if len(row) else None
    except Exception:
        return ""
    if not mid:
        return ""
    cost = mid * 100
    n = int(RISK_CAP // cost)
    if n >= 1:
        return (f"   💵 ~${mid:.2f}/ct (${cost:,.0f} ea) → **{n} ct** ≈ ${n*cost:,.0f} max risk "
                f"(${n*cost*0.5:,.0f} at a 50% stop)")
    # too rich → find the richest affordable same-direction strike (best delta you can buy)
    alt = None
    try:
        for _, r in df.iterrows():
            m = _mid(r)
            if not m or m * 100 > RISK_CAP or m < 0.30:
                continue
            k = float(r["strike"])
            # bullish call wants strikes ≥ pick (cheaper OTM); bearish put wants strikes ≤ pick
            ok = (k >= strike) if is_call else (k <= strike)
            if spot and abs(k - spot) / spot > ALT_MAX_MNY:    # reject deep-OTM lotto
                continue
            if ok and (alt is None or m > alt[1]):     # richest affordable = closest to money
                alt = (k, m)
    except Exception:
        alt = None
    base = (f"   💵 flagged contract ~${mid:.2f}/ct (${cost:,.0f}) = above your $250 cap")
    if alt:
        ac = alt[1] * 100
        an = int(RISK_CAP // ac)
        cp = "C" if is_call else "P"
        base += (f"\n   ✅ **affordable play: {a.get('Symbol')} ${alt[0]:g}{cp} {exp[5:].replace('-','/')}** "
                 f"~${alt[1]:.2f}/ct → **{an} ct** ≈ ${an*ac:,.0f} (${an*ac*0.5:,.0f} at a 50% stop)")
    else:
        base += " — no near-money strike fits $250 (this name's options are too rich for your account)"
    return base


def _moneyness(a: dict, spot: float):
    """(% OTM, ITM?) for the contract vs spot. Positive % = out of the money."""
    strike = float(a.get("Strike", 0) or 0)
    if not spot:
        return None, False
    is_call = str(a.get("OptionType", "")).upper().startswith("C")
    otm = (strike - spot) / spot if is_call else (spot - strike) / spot
    return otm, (otm < 0)


def build() -> str | None:
    merged = _load()
    if not merged:
        return None
    names = {s.upper() for s in personal_tickers()} | {s.upper() for s in personal_crypto()}
    scored = sorted(((_score(a), a) for a in merged.values()), key=lambda x: -x[0][0])

    spot_cache: dict[str, float | None] = {}

    def getspot(tk):
        if tk not in spot_cache:
            spot_cache[tk] = _spot(tk)
        return spot_cache[tk]

    conf, bulls, bears, hedges = [], [], [], []
    used = set()        # dedupe by underlying — one contract per ticker
    for (s, fv, voi, dte), a in scored:
        sym = str(a.get("Symbol", "")).upper()
        tag = " 🎯YOUR NAME" if sym in names else ""
        if dte <= 1 and a.get("isBullish") and len(conf) < 2:
            conf.append(f"• **{_fmt(a)}** — ${fv:,.0f}, {int(a.get('SWEEPS',0))} sweeps, V/OI {voi:.1f}{tag}")
        elif DTE_MIN <= dte <= DTE_MAX:
            sp = getspot(a.get("Symbol"))
            if not sp:
                continue
            otm, _ = _moneyness(a, sp)
            if otm is None or abs(otm) > MAX_MNY:
                if otm and otm > MAX_MNY and fv > 3_000_000 and len(hedges) < 2 and sym not in used:
                    hedges.append((a, fv, otm, tag)); used.add(sym)
                continue
            if sym in used:                  # one pick per underlying
                continue
            is_call = str(a.get("OptionType", "")).upper().startswith("C")
            rec = (a, fv, voi, dte, tag, sp, otm)
            # actionable = BOUGHT calls (bullish long) / BOUGHT puts (bearish); skip sold-side
            if a.get("isBullish") and is_call and len(bulls) < 3:
                bulls.append(rec); used.add(sym)
            elif not a.get("isBullish") and not is_call and len(bears) < 2:
                bears.append(rec); used.add(sym)

    _log_picks(bulls + bears)   # record for the EOD scorecard (direction from isBullish)
    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    tape = _tape()
    lines = [f"🎯 **FLOW PICKS — live contracts** · {stamp}"]
    if tape:
        lines.append(f"_Tape: {tape}_")
    if conf:
        lines.append("\n**🟢 TAPE CONFIRMATION (0DTE — direction, not swing buys):**")
        lines += conf

    def _pickline(idx, rec):
        a, fv, voi, dte, tag, sp, otm = rec
        vol = int(a.get("Volume", 0) or 0)
        oi = int(a.get("OI", 0) or 0)
        why = ("fresh opening flow (vol >> OI)" if voi >= 2 else
               "repeat institutional positioning" if voi < 1 else "building position")
        mny = f" · spot ${sp:,.2f} ({abs(otm)*100:.0f}% {'OTM' if otm >= 0 else 'ITM'})" if sp else ""
        is_call = str(a.get("OptionType", "")).upper().startswith("C")
        sizing = _sizing_line(a, is_call)
        line = f"**{idx}. {_fmt(a)}** ({dte} DTE) · ${fv:,.0f} · V/OI {voi:.1f} ({vol:,}/{oi:,}){mny}{tag}\n   *{why}*"
        return line + ("\n" + sizing if sizing else "")

    if bulls:
        lines.append("\n**⭐ BULLISH SWING PICKS (near-money, fresh, actionable longs):**")
        for i, rec in enumerate(bulls, 1):
            lines.append(_pickline(i, rec))
    if bears:
        lines.append("\n**🔴 BEARISH FLOW TO RESPECT (contra / hedge your longs):**")
        for i, rec in enumerate(bears, 1):
            lines.append(_pickline(i, rec))
    if hedges:
        lines.append("\n**🛡️ Notable big-money positioning (deep OTM — likely hedges, not buys):**")
        for a, fv, otm, tag in hedges:
            lines.append(f"• {_fmt(a)} — ${fv:,.0f} ({abs(otm)*100:.0f}% OTM){tag}")
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
