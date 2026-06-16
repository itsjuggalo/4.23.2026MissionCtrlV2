#!/usr/bin/env python3
"""macro_calendar_alert.py — make the trading op EVENT-AWARE (the gap that let FOMC
sneak up on 2026-06-16). READ-ONLY: pulls scheduled macro catalysts + earnings on
held names and pushes a heads-up to Telegram. Never trades, never gates anything.

Reliable floor (no API needed): embedded 2026 FOMC decision days + computed monthly
NFP (first Friday). Layered on top, best-effort: Finnhub economic calendar (CPI/PCE/
etc.) and Finnhub earnings filtered to held tickers. Degrades gracefully if Finnhub's
free tier 403s the economic endpoint — the FOMC/NFP floor still fires.

  macro_calendar_alert.py                 # print digest (no send) — default
  macro_calendar_alert.py --send          # push to trading_command Telegram bot
  macro_calendar_alert.py --send --t1     # evening T-1 mode: emphasise TOMORROW
  macro_calendar_alert.py --days 10       # lookahead window (default 7)
Run with ~/.venv/bin/python (for lib.* imports); falls back to stdlib if run bare.
"""
from __future__ import annotations

import argparse
import json
import sys
import urllib.request
from datetime import date, datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))

SEC = Path.home() / ".openclaw" / "secrets"
ET = timezone(timedelta(hours=-4))  # EDT; ET label only, dates are what matter

# ── Reliable floor: 2026 FOMC decision days (published by the Fed, second meeting day) ──
FOMC_2026 = [
    "2026-01-28", "2026-03-18", "2026-04-29", "2026-06-17",
    "2026-07-29", "2026-09-16", "2026-10-28", "2026-12-16",
]
# His current stock names (from the 2026-06-16 eval) — earnings filter seed, unioned
# with whatever ARIES/Alpaca report live so it stays correct as the book changes.
SEED_TICKERS = ["MU", "ORCL", "NFLX", "SMCI", "SOFI", "COIN", "NIO", "QQQ", "KLAR"]


def et_today() -> date:
    return datetime.now(timezone.utc).astimezone(ET).date()


def finnhub_key() -> str | None:
    for n in ("finnhub.key", "finnhub_api_key", "finnhub-api-key.txt", "FINNHUB_API_KEY"):
        p = SEC / n
        if p.exists():
            k = p.read_text().strip()
            if k:
                return k
    return None


def _get_json(url: str, timeout: int = 12):
    try:
        with urllib.request.urlopen(url, timeout=timeout) as r:
            return json.loads(r.read().decode())
    except Exception:
        return None


def first_friday(y: int, m: int) -> date:
    d = date(y, m, 1)
    return d + timedelta(days=(4 - d.weekday()) % 7)  # weekday 4 == Friday


def embedded_macro(start: date, end: date) -> list[dict]:
    """FOMC decision days + NFP (first Friday) within [start, end]. Always available."""
    out = []
    for s in FOMC_2026:
        d = date.fromisoformat(s)
        if start <= d <= end:
            out.append({"date": d, "event": "FOMC decision + dot-plot + Powell ~2:00 PM ET",
                        "impact": "high", "tag": "🏛️ FOMC"})
    m = date(start.year, start.month, 1)
    for _ in range(4):  # cover up to ~4 months of lookahead
        nfp = first_friday(m.year, m.month)
        if start <= nfp <= end:
            out.append({"date": nfp, "event": "Non-Farm Payrolls / jobs report 8:30 AM ET",
                        "impact": "high", "tag": "📊 Jobs"})
        m = (m.replace(day=28) + timedelta(days=7)).replace(day=1)
    return out


def finnhub_econ(key: str, start: date, end: date) -> list[dict]:
    """Best-effort US economic calendar (CPI/PCE/retail/etc). [] if free-tier blocked."""
    url = (f"https://finnhub.io/api/v1/calendar/economic?from={start}&to={end}&token={key}")
    j = _get_json(url)
    if not j or "economicCalendar" not in j:
        return []
    out = []
    for e in j.get("economicCalendar", []):
        if (e.get("country") or "").upper() not in ("US", "USA", "UNITED STATES"):
            continue
        imp = (e.get("impact") or "").lower()
        if imp not in ("high", "medium"):
            continue
        ev = e.get("event", "")
        if not any(k in ev.lower() for k in ("cpi", "pce", "ppi", "gdp", "retail", "unemploy",
                                             "payroll", "fomc", "fed", "inflation", "jobless")):
            continue
        try:
            d = date.fromisoformat((e.get("time") or e.get("date") or "")[:10])
        except Exception:
            continue
        out.append({"date": d, "event": ev, "impact": "high" if imp == "high" else "med",
                    "tag": "📈 Econ"})
    return out


def held_tickers() -> set[str]:
    """Best-effort union of held STOCK names (ARIES RH/Alpaca + seed)."""
    tk = set(SEED_TICKERS)
    try:
        from lib.portfolio import top_tickers  # Alpaca paper names
        tk |= {t.upper() for t in top_tickers(12)}
    except Exception:
        pass
    j = _get_json("http://localhost:1337/api/brokers/robinhood", timeout=6)
    if isinstance(j, dict):
        for row in (j.get("holdings") or j.get("positions") or []):
            s = (row.get("asset") or row.get("symbol") or "").upper()
            if s and s.isalpha() and len(s) <= 5:
                tk.add(s)
    return tk


def finnhub_earnings(key: str, start: date, end: date, tickers: set[str]) -> list[dict]:
    url = f"https://finnhub.io/api/v1/calendar/earnings?from={start}&to={end}&token={key}"
    j = _get_json(url)
    if not j:
        return []
    out = []
    for e in j.get("earningsCalendar", []):
        sym = (e.get("symbol") or "").upper()
        if sym not in tickers:
            continue
        try:
            d = date.fromisoformat(e.get("date", ""))
        except Exception:
            continue
        hour = {"bmo": "pre-mkt", "amc": "after close"}.get((e.get("hour") or "").lower(), "")
        out.append({"date": d, "event": f"{sym} earnings {hour}".strip(),
                    "impact": "high", "tag": "💵 Earnings"})
    return out


def build(days: int):
    today = et_today()
    end = today + timedelta(days=days)
    key = finnhub_key()
    events = embedded_macro(today, end)
    if key:
        events += finnhub_econ(key, today, end)
        events += finnhub_earnings(key, today, end, held_tickers())
    # de-dup (date, first 6 words) and sort
    seen, uniq = set(), []
    for e in sorted(events, key=lambda x: (x["date"], x["impact"] != "high")):
        k = (e["date"], e["event"][:18].lower())
        if k in seen:
            continue
        seen.add(k)
        uniq.append(e)
    return today, uniq


def render(today: date, events: list[dict], t1: bool) -> tuple[str, bool]:
    tom = today + timedelta(days=1)
    t0 = [e for e in events if e["date"] == today]
    t_next = [e for e in events if e["date"] == tom]
    later = [e for e in events if e["date"] > tom]
    high_soon = any(e["impact"] == "high" for e in t0 + t_next)
    L = ["📅 <b>MACRO / EVENT RADAR</b> — " + today.strftime("%a %b %-d")]
    def fmt(e):
        dd = e["date"]
        when = "TODAY" if dd == today else ("TOMORROW" if dd == tom else dd.strftime("%a %b %-d"))
        return f"{e['tag']} <b>{when}</b> — {e['event']}"
    if t0:
        L += ["", "🔴 <b>TODAY:</b>"] + [f"• {fmt(e)}" for e in t0]
    if t_next:
        L += ["", ("⚠️ <b>TOMORROW</b> — prep today:" if t1 else "🟠 <b>TOMORROW:</b>")]
        L += [f"• {fmt(e)}" for e in t_next]
    if later:
        L += ["", f"🗓️ <b>Next {len(later)} ahead:</b>"] + [f"• {fmt(e)}" for e in later[:8]]
    if not events:
        L += ["", "Clear runway — no scheduled high-impact catalysts in window."]
    L += ["", "<i>Heads-up only. Don't over-deploy into a high-impact event; size down spec names before it.</i>"]
    return "\n".join(L), high_soon


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--days", type=int, default=7)
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--t1", action="store_true", help="evening T-1 mode (emphasise tomorrow)")
    a = ap.parse_args()
    today, events = build(a.days)
    msg, high = render(today, events, a.t1)
    if not a.send:
        print(msg.replace("<b>", "").replace("</b>", "").replace("<i>", "").replace("</i>", ""))
        print(f"\n[dry-run] would send={'LOUD' if high else 'quiet'} · {len(events)} events", flush=True)
        return
    try:
        from lib.notify import tg_push
        fn = tg_push(msg, "trading_command", loud=high,
                     fallback_token_file="telegram_laptopclaude_bot_token")
        print(f"[macro-cal] sent via {fn} (loud={high}, {len(events)} events)", flush=True)
    except Exception as e:
        print(f"[macro-cal] send FAILED: {e}", flush=True)


if __name__ == "__main__":
    main()
