#!/usr/bin/env python3
"""morning_radar.py — 9:12 ET "big move THIS morning?" radar (advisory-only, P0 2026-07-07).

The evening pre_breakout_scan (17:30) finds coiled springs for TOMORROW; this answers
"which spring is firing TODAY, before the open?" using the signals that actually lead
a big day (premarket volume anomaly + gap) filtered by posture (EMA20/50 + MACD
histogram inflection — confirmation, not triggers, per Mike's coaching doctrine).

Universe = real holdings (coach_verdicts.json, mv>=$50 stocks) + latest evening scan
picks (scan_history) + CORE stocks. Stocks only (premarket is a stock concept; crypto
is covered 24/7 by btc_desk + coach alerts).

Scoring (explainable, 0-20+):
  premarket vol ratio vs prior premarkets  ->  3 x min(ratio, 6)   (the tell)
  gap % vs prior close                     ->  1.5 x min(|gap|, 6) (the confirmation)
  reclaim/lose EMA20 premarket             ->  +3                  (coil trigger)
  MACD hist rising 3d & near zero-cross    ->  +2                  (about to turn)
  tight coil yesterday (range < 0.6xATR)   ->  +2                  (spring loaded)

Cron: 12 9 * * 1-5 -> --send (>= ~/portfolio/coach.log). Never raises.
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
import traceback
from datetime import datetime, time as dtime
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
HOME = Path.home()
VERDICTS = HOME / "portfolio" / "coach_verdicts.json"
DB = HOME / "portfolio" / "mike.sqlite"
TG_FLEET = HOME / "scripts" / "tg_fleet.py"
TG_FN = "trading_command"
CORE_STOCKS = ["QQQ", "IBIT"]
MAX_UNIVERSE = 35


def tg(msg: str) -> None:
    try:
        subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, msg],
                       capture_output=True, timeout=30)
    except Exception:
        pass


def now_et() -> datetime:
    return datetime.now(tz=ET)


def universe() -> dict[str, str]:
    """symbol -> tag (holding|scan|core). Stocks only."""
    uni: dict[str, str] = {}
    for s in CORE_STOCKS:
        uni[s] = "core"
    try:
        d = json.loads(VERDICTS.read_text())
        for r in d.get("results", []):
            if r.get("asset_class") == "stock" and (r.get("mv") or 0) >= 50:
                uni.setdefault(r["symbol"], "holding")
    except Exception:
        pass
    try:
        import sqlite3
        con = sqlite3.connect(str(DB))
        rows = con.execute(
            "SELECT symbol FROM scan_history WHERE scanned_at = "
            "(SELECT MAX(scanned_at) FROM scan_history) ORDER BY score DESC LIMIT 10"
        ).fetchall()
        con.close()
        for (s,) in rows:
            uni.setdefault(s, "scan")
    except Exception:
        pass
    return dict(list(uni.items())[:MAX_UNIVERSE])


def ema(series, span: int):
    return series.ewm(span=span, adjust=False).mean()


def daily_posture(daily) -> dict[str, dict]:
    """Per symbol: ema20/50, macd hist last 3, ATR, yesterday range/close.
    Uses bars strictly BEFORE today (ET) so 'close' = prior session even if today's
    partial/final bar is already in the frame (correct at any run hour)."""
    out: dict[str, dict] = {}
    today = now_et().date()
    keep = [d for d in daily.index if d.date() < today]
    daily = daily.loc[keep]
    closes = daily["Close"]
    highs, lows = daily["High"], daily["Low"]
    for sym in closes.columns:
        try:
            c = closes[sym].dropna()
            if len(c) < 40:
                continue
            e20, e50 = ema(c, 20), ema(c, 50)
            macd = ema(c, 12) - ema(c, 26)
            hist = macd - ema(macd, 9)
            h3 = [float(x) for x in hist.iloc[-3:]]
            hi, lo = highs[sym].dropna(), lows[sym].dropna()
            tr = (hi - lo).iloc[-15:]
            atr = float(tr.mean()) if len(tr) else 0.0
            out[sym] = {
                "close": float(c.iloc[-1]), "ema20": float(e20.iloc[-1]),
                "ema50": float(e50.iloc[-1]), "hist3": h3, "atr": atr,
                "yrange": float(hi.iloc[-1] - lo.iloc[-1]) if len(hi) else 0.0,
            }
        except Exception:
            continue
    return out


def alpaca_pm_volumes(symbols: list[str]) -> dict[str, dict]:
    """symbol -> {pm_vol (today 04:00-09:29 ET), pm_base (median of prior premarkets)}
    via Alpaca free IEX feed — yfinance reports premarket volume as 0, IEX is real
    (partial SIP, but ratio vs its own history is valid)."""
    import urllib.request
    from datetime import timedelta
    sec_dir = HOME / ".openclaw" / "secrets"
    try:
        key = (sec_dir / "alpaca-boba-key-id").read_text().strip()
        sec = (sec_dir / "alpaca-boba-secret").read_text().strip()
    except Exception:
        return {}
    days = [d for d in (now_et().date() - timedelta(days=i) for i in range(9, -1, -1))
            if d.weekday() < 5][-6:]
    vols: dict[str, dict] = {s: {} for s in symbols}
    for day in days:
        url = ("https://data.alpaca.markets/v2/stocks/bars?symbols=" + ",".join(symbols)
               + f"&timeframe=1Min&start={day}T04:00:00-04:00&end={day}T09:29:59-04:00"
               + "&feed=iex&limit=10000")
        token = ""
        try:
            while True:
                req = urllib.request.Request(url + (f"&page_token={token}" if token else ""),
                                             headers={"APCA-API-KEY-ID": key,
                                                      "APCA-API-SECRET-KEY": sec})
                d = json.loads(urllib.request.urlopen(req, timeout=30).read())
                for sym, bars in (d.get("bars") or {}).items():
                    vols[sym][day] = vols[sym].get(day, 0) + sum(b["v"] for b in bars)
                token = d.get("next_page_token")
                if not token:
                    break
        except Exception:
            continue
    today = now_et().date()
    out: dict[str, dict] = {}
    for sym, by_day in vols.items():
        prior = sorted(v for d, v in by_day.items() if d != today and v > 0)
        out[sym] = {"pm_vol": by_day.get(today, 0),
                    "pm_base": prior[len(prior) // 2] if prior else 0.0}
    return out


def premarket_stats(intraday, symbols: list[str]) -> dict[str, dict]:
    """Per symbol: today's premarket (04:00-09:29 ET) last price + vol, vs prior-day
    premarket median vol from the same 1m prepost frame."""
    import pandas as pd  # noqa: F401
    out: dict[str, dict] = {}
    try:
        idx = intraday.index.tz_convert(ET)
    except Exception:
        return out
    today = now_et().date()
    pm_mask = [(dtime(4, 0) <= t.time() < dtime(9, 30)) for t in idx]
    for sym in symbols:
        try:
            vol = intraday["Volume"][sym]
            px = intraday["Close"][sym]
            pm_v = vol[pm_mask]
            pm_p = px[pm_mask]
            days = {}
            for t, v in pm_v.dropna().items():
                days.setdefault(t.tz_convert(ET).date(), []).append(float(v))
            today_vol = sum(days.get(today, [])) or 0.0
            prior = sorted(sum(vs) for d, vs in days.items() if d != today and sum(vs) > 0)
            base = prior[len(prior) // 2] if prior else 0.0
            pm_today_px = pm_p.dropna()
            pm_today_px = pm_today_px[[t.tz_convert(ET).date() == today for t in pm_today_px.index]]
            last_pm = float(pm_today_px.iloc[-1]) if len(pm_today_px) else None
            out[sym] = {"pm_vol": today_vol, "pm_base": base,
                        "ratio": (today_vol / base) if base > 0 else 0.0,
                        "pm_last": last_pm}
        except Exception:
            continue
    return out


def build_signals() -> tuple[list[dict], int]:
    import yfinance as yf
    uni = universe()
    syms = sorted(uni)
    daily = yf.download(" ".join(syms), period="4mo", interval="1d",
                        progress=False, threads=True, group_by="column", auto_adjust=True)
    intra = yf.download(" ".join(syms), period="5d", interval="1m", prepost=True,
                        progress=False, threads=True, group_by="column", auto_adjust=True)
    posture = daily_posture(daily)
    pm = premarket_stats(intra, syms)
    apm = alpaca_pm_volumes(syms)
    for sym, av in apm.items():
        if sym in pm and av["pm_base"] > 0:
            pm[sym]["pm_vol"] = av["pm_vol"]
            pm[sym]["pm_base"] = av["pm_base"]
            pm[sym]["ratio"] = av["pm_vol"] / av["pm_base"]
        elif sym in pm and av["pm_vol"] > 0 and pm[sym]["ratio"] == 0:
            pm[sym]["ratio"] = 1.0  # traded premarket, no baseline — neutral
    rows: list[dict] = []
    for sym in syms:
        p, m = posture.get(sym), pm.get(sym)
        if not p or not m:
            continue
        ref = m["pm_last"] if m["pm_last"] else p["close"]
        gap = 100.0 * (ref - p["close"]) / p["close"] if p["close"] else 0.0
        score, why = 0.0, []
        if m["ratio"] >= 1.5:
            score += 3 * min(m["ratio"], 6)
            why.append(f"PM vol {m['ratio']:.1f}x")
        if abs(gap) >= 1.0:
            score += 1.5 * min(abs(gap), 6)
            why.append(f"gap {gap:+.1f}%")
        if p["close"] < p["ema20"] <= ref or (ref >= p["ema20"] and abs(ref - p["ema20"]) / p["ema20"] < 0.01 <= m["ratio"]):
            score += 3
            why.append("reclaiming EMA20")
        elif p["close"] > p["ema20"] > ref:
            score += 3
            why.append("LOSING EMA20")
        h = p["hist3"]
        if len(h) == 3 and h[0] < h[1] < h[2] and h[2] < 0 and p["atr"] and abs(h[2]) < 0.15 * p["atr"]:
            score += 2
            why.append("MACD hist rising toward cross")
        if p["atr"] and p["yrange"] < 0.6 * p["atr"]:
            score += 2
            why.append("coiled (tight day)")
        rows.append({"sym": sym, "tag": uni[sym], "score": round(score, 1),
                     "gap": round(gap, 1), "ratio": round(m["ratio"], 1),
                     "why": why, "ema20": p["ema20"], "close": p["close"]})
    rows.sort(key=lambda r: -r["score"])
    return rows, len(syms)


def card(rows: list[dict], nsyms: int, top: int) -> str:
    ts = now_et().strftime("%Y-%m-%d %H:%M ET")
    hot = [r for r in rows[:top] if r["score"] >= 4]
    lines = [f"📡 MORNING RADAR — {ts} ({nsyms} names)"]
    if not hot:
        lines.append("😴 quiet morning — no name shows unusual premarket volume/gap. "
                     "Don't force a trade today.")
    for r in hot:
        tag = {"holding": "📦 you own", "scan": "🌙 last-night pick", "core": "🏛 core"}[r["tag"]]
        lines.append(f"• *{r['sym']}* [{r['score']}] {tag} — " + " · ".join(r["why"]))
    if hot:
        lines.append("Rules: $75 max loss · stop set BEFORE entry · min ticket $200 · no chase >+15%/5d.")
    return "\n".join(lines)


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--top", type=int, default=5)
    args = ap.parse_args()
    try:
        rows, nsyms = build_signals()
        msg = card(rows, nsyms, args.top)
        print(msg)
        if args.send:
            tg(msg)
        print(f"[morning_radar] {now_et():%Y-%m-%d %H:%M ET} — scored {len(rows)}/{nsyms}, "
              f"sent={args.send}", flush=True)
    except Exception:
        print(f"[morning_radar] FAILED {now_et():%Y-%m-%d %H:%M ET}\n{traceback.format_exc()}",
              flush=True)
    return 0


if __name__ == "__main__":
    sys.exit(main())
