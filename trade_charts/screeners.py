#!/usr/bin/env python3
"""screeners.py — deterministic screeners for Discord: /earnings, /patterns, /correlation, /sentiment.

Replaces the dead Jazzy/Orion commands (earnings_screener, intraday_pattern_scanner, correlation_analysis,
market_sentiment). Reads MissionCtrl's own APIs (calendar, chart-patterns, fear-greed) plus bars from ta_cmd.
No LLM, read-only. A missing input prints UNAVAILABLE with the reason. Advisory only, no proven edge, no size.

CLI:  ~/.venv/bin/python screeners.py earnings [days] | patterns SYM [5m|1h|1d] | correlation A B C [days] | sentiment
"""
from __future__ import annotations

import warnings

warnings.filterwarnings("ignore")

import json
import sys
import urllib.parse
import urllib.request
from datetime import datetime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(HERE.parent))
import lib  # noqa: E402,F401 — bind ~/scripts/lib now; MissionCtrl modules put pipeline/ (which has its own lib/) first on sys.path
ET = ZoneInfo("America/New_York")
API = "http://localhost:3000/api/"
FOOT = "_No AI. Advisory only, no proven edge, no size._"


def _api(path: str, timeout: int = 60) -> dict:
    with urllib.request.urlopen(API + path, timeout=timeout) as r:
        return json.load(r)


def _ms_et(ms) -> str:
    try:
        return datetime.fromtimestamp(float(ms) / 1000, ET).strftime("%m-%d %H:%M ET")
    except Exception:  # noqa: BLE001
        return "time n/a"


def _iso_et(s) -> str:
    try:
        return datetime.fromisoformat(str(s)).astimezone(ET).strftime("%m-%d %H:%M ET")
    except Exception:  # noqa: BLE001
        return str(s or "time n/a")


def earnings(days: int = 7) -> str:
    head = f"📅 **Earnings — next {days} days**"
    try:
        d = _api("calendar")
    except Exception as e:  # noqa: BLE001
        return f"{head} — UNAVAILABLE (MissionCtrl /api/calendar: {type(e).__name__})"
    today = datetime.now(ET).date()
    end = today + timedelta(days=days)
    rows = []
    for day, evs in sorted((d.get("grouped") or {}).items()):
        try:
            dd = datetime.strptime(day, "%Y-%m-%d").date()
        except ValueError:
            continue
        if not today <= dd <= end:
            continue
        for e in evs:
            if e.get("category") == "earnings":
                flag = "" if e.get("date_status") in (None, "verified", "confirmed") else " ⚠️ date unverified"
                rows.append(f"`{dd:%a %m-%d}` **{e.get('ticker')}** · {e.get('detail') or 'no detail'}{flag} "
                            f"· {e.get('source') or 'source n/a'}")
    lines = [f"{head} · calendar updated {_iso_et(d.get('last_updated'))}"]
    lines += rows or ["No earnings in the calendar for that window. The calendar covers the MissionCtrl universe, "
                      "not the whole market."]
    lines.append("_'Date unverified' = an estimated date, not yet confirmed by the company. " + FOOT[1:])
    return "\n".join(lines)


def patterns(symbol: str, tf: str = "1d") -> str:
    sym = symbol.upper().strip().lstrip("$").replace("-USD", "")
    import ta_cmd
    asset = "crypto" if sym in ta_cmd.CRYPTO else "stock"
    res = {"5m": 300, "1h": 3600, "1d": 86400}.get(tf, 86400)
    head = f"🔎 **{sym} chart patterns** · {tf}"
    try:
        d = _api("chart-patterns?" + urllib.parse.urlencode({"symbol": sym, "asset": asset, "resolution": res}), 90)
    except Exception as e:  # noqa: BLE001
        return f"{head} — UNAVAILABLE (MissionCtrl /api/chart-patterns: {type(e).__name__})"
    if d.get("error"):
        return f"{head} — UNAVAILABLE ({str(d['error'])[:160]})"
    ms = d.get("matches") or []
    lines = [f"{head} · MissionCtrl pattern engine · checked {_ms_et(d.get('asOf'))}"]
    if not ms:
        lines.append("No pattern matched on the latest bars. That is a result, not an error.")
    for m in ms[:8]:
        if isinstance(m, dict):
            name = m.get("name") or m.get("pattern") or m.get("type") or "pattern"
            rest = " · ".join(f"{k} {v}" for k, v in m.items()
                              if k not in ("name", "pattern", "type") and isinstance(v, (str, int, float, bool)))
            lines.append(f"• **{name}** · {rest}"[:380])
        else:
            lines.append(f"• {m}"[:380])
    lines.append("_A pattern is a shape, not a forecast: no hit rate has been proven for these. " + FOOT[1:])
    return "\n".join(lines)


def correlation(tickers: list[str], days: int = 60) -> str:
    import pandas as pd
    import ta_cmd
    syms = []
    for t in tickers:
        t = t.upper().strip().lstrip("$").replace("-USD", "")
        if t and t not in syms:
            syms.append(t)
    head = f"🔗 **Correlation** · daily returns · last {days} sessions"
    if not 2 <= len(syms) <= 8:
        return f"{head} — give 2 to 8 tickers or coins (got {len(syms)})."
    series, srcs, bad = {}, set(), []
    for s in syms:
        try:
            df, src = (ta_cmd.crypto_bars(s, "1d") if s in ta_cmd.CRYPTO else ta_cmd.stock_bars(s, "1d"))
            c = df["Close"]
            c.index = pd.DatetimeIndex([x.date() for x in c.index])
            series[s] = c[~c.index.duplicated(keep="last")]
            srcs.add(src.split(" (")[0])
        except Exception as e:  # noqa: BLE001
            bad.append(f"{s} ({str(e)[:60]})")
    if len(series) < 2:
        return f"{head} — UNAVAILABLE (no bars for: {', '.join(bad)})"
    px = pd.DataFrame(series).dropna()
    ret = px.pct_change().dropna().tail(days)
    if len(ret) < 20:
        return f"{head} — UNAVAILABLE (only {len(ret)} shared sessions, 20 needed)"
    cm = ret.corr()
    names = list(cm.columns)
    w = max(6, max(len(n) for n in names) + 1)
    lines = [f"{head} · {len(ret)} shared sessions ending {ret.index[-1]:%m-%d}", "```",
             " " * w + "".join(f"{n:>{w}}" for n in names)]
    for a in names:
        lines.append(f"{a:<{w}}" + "".join(f"{cm.loc[a, b]:>{w}.2f}" for b in names))
    lines.append("```")
    pairs = sorted(((cm.loc[a, b], a, b) for i, a in enumerate(names) for b in names[i + 1:]), reverse=True)
    hi, lo = pairs[0], pairs[-1]
    lines.append(f"Most alike: {hi[1]}/{hi[2]} {hi[0]:+.2f} · Least alike: {lo[1]}/{lo[2]} {lo[0]:+.2f} "
                 "(+1 move together, 0 unrelated, −1 opposite)")
    if bad:
        lines.append("Left out: " + ", ".join(bad))
    if any(s in ta_cmd.CRYPTO for s in series) and any(s not in ta_cmd.CRYPTO for s in series):
        lines.append("Crypto trades on weekends; only days both markets have a bar are compared.")
    lines.append(f"_Sources: {' / '.join(sorted(srcs))}. Pearson correlation of daily % changes. " + FOOT[1:])
    return "\n".join(lines)


def sentiment() -> str:
    head = "🧭 **Market sentiment**"
    try:
        d = _api("fear-greed")
    except Exception as e:  # noqa: BLE001
        return f"{head} — UNAVAILABLE (MissionCtrl /api/fear-greed: {type(e).__name__})"
    lines = [f"{head} · generated {_iso_et(d.get('generatedAt'))}"]
    c = d.get("cnn") or {}
    if c.get("score") is not None:
        lines.append(f"**CNN Fear & Greed {c['score']:.0f}** ({c.get('rating')}) · as of {_iso_et(c.get('as_of'))} · "
                     f"prior close {c.get('previous_close', 0):.0f} · 1 week ago {c.get('previous_1_week', 0):.0f} · "
                     f"1 month ago {c.get('previous_1_month', 0):.0f}")
        for v in (c.get("components") or {}).values():
            lines.append(f"  • {v.get('label')}: {v.get('score')} ({v.get('rating')})")
    else:
        lines.append(f"CNN Fear & Greed: UNAVAILABLE ({c.get('status') or 'no score'})")
    k = d.get("computed") or {}
    if k.get("score") is not None:
        lines.append(f"**MissionCtrl computed index {k['score']:.0f}** ({k.get('rating')}) · {k.get('n_inputs')} of "
                     f"{k.get('of')} inputs · as of {_iso_et(k.get('as_of'))}")
    b = d.get("breadth") or {}
    if b.get("advancers") is not None:
        am = b.get("above_ma") or {}
        lines.append(f"**Breadth** ({b.get('universe')} names, session {b.get('session')}): {b.get('advancers')} up / "
                     f"{b.get('decliners')} down · above 50-day avg {am.get('50')}% · above 200-day avg {am.get('200')}% · "
                     f"new highs {b.get('new_highs')} / new lows {b.get('new_lows')}")
    cr = d.get("crypto") or {}
    if cr.get("value") is not None:
        lines.append(f"**Crypto Fear & Greed {cr['value']}** ({cr.get('classification')}) · previous {cr.get('previous')} · "
                     f"as of {_iso_et(cr.get('as_of'))} · {cr.get('source')}")
    else:
        lines.append("Crypto Fear & Greed: UNAVAILABLE")
    try:
        sys.path.append("/AIWorkWSL/web/missionctrl")
        from pipeline.intel import query as Q
        tide = Q.cmd_tide().splitlines()
        lines.append(f"**Options tide**: {tide[-1]} ({tide[0].split('·', 1)[-1].strip()})")
    except Exception as e:  # noqa: BLE001
        lines.append(f"Options tide: UNAVAILABLE ({type(e).__name__})")
    miss = d.get("missing") or []
    if miss:
        lines.append(f"Missing inputs: {', '.join(map(str, miss))}")
    lines.append("_Source: MissionCtrl /api/fear-greed (CNN, own computed index, breadth, alternative.me) + flow.db. "
                 + FOOT[1:])
    return "\n".join(lines)


if __name__ == "__main__":
    a = sys.argv[1:]
    cmd = a[0] if a else "sentiment"
    if cmd == "earnings":
        print(earnings(int(a[1]) if len(a) > 1 else 7))
    elif cmd == "patterns":
        print(patterns(a[1], a[2] if len(a) > 2 else "1d"))
    elif cmd == "correlation":
        n = int(a[-1]) if a[-1].isdigit() else 60
        print(correlation([x for x in a[1:] if not x.isdigit()], n))
    else:
        print(sentiment())
