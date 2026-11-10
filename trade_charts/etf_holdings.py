#!/usr/bin/env python3
"""etf_holdings.py — % change of every stock inside an ETF, for the Discord /etf command.

Holdings (first source that answers, named on the source line):
  1. Direxion daily holdings CSV (SOXL, TQQQ-style leveraged funds: the stock rows; swaps and cash are left out)
  2. SPDR daily holdings XLSX (SPY, XLK, XLF ...)
  3. Yahoo top 10 only (labelled, with the share of the fund those 10 cover)
Changes: 1, 5 and 20 sessions from daily closes (Robinhood, Yahoo when Robinhood is stale: ta_cmd.stock_bars).
During the regular session the 1-day column is live: Robinhood last trade vs the prior session's close.

Deterministic, read-only, no LLM. A missing input prints UNAVAILABLE. Advisory only, no proven edge, no size.

CLI:  ~/.venv/bin/python etf_holdings.py SOXL [--sort 1d|5d|20d|weight] [--top 30] [--no-chart]
"""
from __future__ import annotations

import warnings

warnings.filterwarnings("ignore")

import argparse
import csv
import io
import json
import re
import sys
from concurrent.futures import ThreadPoolExecutor
from datetime import datetime, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(HERE.parent))
import lib  # noqa: E402,F401 — bind ~/scripts/lib before MissionCtrl modules put pipeline/ first on sys.path

ET = ZoneInfo("America/New_York")
CACHE = Path.home() / ".openclaw/data/etf-holdings"
UA = {"User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 Chrome/126 Safari/537.36"}
_TICK = re.compile(r"^[A-Z][A-Z.]{0,5}$")
SORTS = ("1d", "5d", "20d", "weight")


def _f(v) -> float | None:
    try:
        return float(str(v).replace(",", "").replace("%", ""))
    except (TypeError, ValueError):
        return None


def _direxion(etf: str) -> tuple[list[dict], str] | None:
    import requests
    r = requests.get(f"https://www.direxion.com/holdings/{etf}.csv", headers=UA, timeout=20)
    if r.status_code != 200 or "StockTicker" not in r.text:
        return None
    body = r.text[r.text.index('"TradeDate"'):]
    rows, day = [], ""
    for x in csv.DictReader(io.StringIO(body)):
        t, w = (x.get("StockTicker") or "").strip().upper(), _f(x.get("HoldingsPercent"))
        desc = (x.get("SecurityDescription") or "").upper()
        if not _TICK.match(t) or not (x.get("Cusip") or "").strip() or w is None or "SWAP" in desc or t == etf:
            continue
        day = (x.get("TradeDate") or "").split(" ")[0]
        rows.append({"sym": t, "name": desc.title()[:28], "w": w})
    if not rows:
        return None
    tot = sum(r["w"] for r in rows)
    return rows, (f"Direxion daily holdings file dated {day} · stock rows only, {tot:.0f}% of fund assets "
                  "(the rest is swaps and cash that give the leverage)")


def _spdr(etf: str) -> tuple[list[dict], str] | None:
    import openpyxl
    import requests
    r = requests.get("https://www.ssga.com/us/en/intermediary/library-content/products/fund-data/etfs/us/"
                     f"holdings-daily-us-en-{etf.lower()}.xlsx", headers=UA, timeout=25)
    if r.status_code != 200 or r.content[:2] != b"PK":
        return None
    ws = openpyxl.load_workbook(io.BytesIO(r.content), read_only=True).active
    rows, hdr, day = [], None, ""
    for row in ws.iter_rows(values_only=True):
        cells = [str(c).strip() if c is not None else "" for c in row]
        if hdr is None:
            if cells and cells[0].lower().startswith("holdings") and len(cells) > 1:
                day = cells[1].replace("As of ", "")
            if "Ticker" in cells and "Weight" in cells:
                hdr = {n: i for i, n in enumerate(cells)}
            continue
        if len(cells) <= max(hdr["Ticker"], hdr["Weight"]):
            continue
        t, w = cells[hdr["Ticker"]].upper(), _f(cells[hdr["Weight"]])
        if not _TICK.match(t) or w is None:
            continue
        rows.append({"sym": t, "name": cells[hdr.get("Name", 0)].title()[:28], "w": w})
    if not rows:
        return None
    return rows, f"State Street (SPDR) daily holdings file, as of {day or 'date n/a'} · {len(rows)} stocks"


def _yahoo(etf: str) -> tuple[list[dict], str] | None:
    import yfinance as yf
    th = yf.Ticker(etf).funds_data.top_holdings
    if th is None or not len(th):
        return None
    wcol = [c for c in th.columns if "percent" in c.lower()][0]
    ncol = [c for c in th.columns if "name" in c.lower()]
    rows = [{"sym": str(s).upper(), "name": (str(r[ncol[0]]) if ncol else "")[:28], "w": float(r[wcol]) * 100}
            for s, r in th.iterrows() if _TICK.match(str(s).upper())]
    if not rows:
        return None
    return rows, (f"Yahoo top {len(rows)} holdings ONLY (not the full fund; these cover "
                  f"{sum(r['w'] for r in rows):.0f}% of it) · no free full list for this issuer")


def holdings(etf: str) -> tuple[list[dict], str]:
    """Stock rows + source text. Cached per ETF per ET day. Raises LookupError when no source has them."""
    CACHE.mkdir(parents=True, exist_ok=True)
    f = CACHE / f"{etf}_{datetime.now(ET):%Y-%m-%d}.json"
    if f.exists():
        try:
            d = json.loads(f.read_text())
            return d["rows"], d["src"] + " · cached today"
        except (ValueError, KeyError):
            pass
    errs = []
    for name, fn in (("Direxion", _direxion), ("SPDR", _spdr), ("Yahoo", _yahoo)):
        try:
            got = fn(etf)
        except Exception as e:  # noqa: BLE001
            errs.append(f"{name}: {type(e).__name__}")
            continue
        if got:
            for old in CACHE.glob(f"{etf}_*.json"):
                old.unlink(missing_ok=True)
            f.write_text(json.dumps({"rows": got[0], "src": got[1]}))
            return got
        errs.append(f"{name}: no file")
    raise LookupError("; ".join(errs))


def _changes(sym: str) -> dict:
    import ta_cmd
    try:
        df, src = ta_cmd.stock_bars(sym, "1d")
    except Exception as e:  # noqa: BLE001
        return {"error": str(e)[:60]}
    c = df["Close"]
    if len(c) < 21:
        return {"error": f"only {len(c)} bars"}
    return {"closes": [float(x) for x in c.iloc[-22:]], "last_date": df.index[-1].date(),
            "yahoo": src.startswith("Yahoo")}


def _session_open() -> bool:
    try:
        sys.path.append("/AIWorkWSL/web/missionctrl/pipeline")
        from market_clock import clock
        now = datetime.now(timezone.utc)
        d = now.astimezone(ET).date()
        opened = datetime.combine(d, datetime.min.time(), ET).replace(hour=9, minute=30)
        return bool(clock.is_trading_day(d) and opened <= now < clock.session_close(d))
    except Exception:  # noqa: BLE001 — unknown clock: treat as closed, so no live column is claimed
        return False


def build(etf: str, sort: str = "1d", top: int = 30, chart: bool = True) -> dict:
    etf = re.sub(r"[^A-Z.]", "", (etf or "").upper())
    head = f"🧩 **{etf} holdings — % change by stock**"
    if not etf:
        return {"ok": False, "text": "Give an ETF ticker, e.g. SOXL.", "png": None}
    try:
        rows, h_src = holdings(etf)
    except LookupError as e:
        return {"ok": False, "text": f"{head} — UNAVAILABLE (no holdings source answered: {e})", "png": None}
    rows = sorted(rows, key=lambda r: -r["w"])
    total = len(rows)
    rows = rows[:max(1, min(top, 60))]
    syms = [etf] + [r["sym"] for r in rows]
    with ThreadPoolExecutor(max_workers=8) as ex:
        ch = dict(zip(syms, ex.map(_changes, syms)))
    live, live_src = {}, ""
    is_open = _session_open()
    if is_open:
        try:
            from lib.rh_quote import rh_equity_quotes
            q = rh_equity_quotes(syms)
            live = {s: v["last"] for s, v in q.items() if v.get("last")}
            if q:
                live_src = max(v["as_of_et"] for v in q.values())[5:16] + " ET"
        except Exception:  # noqa: BLE001 — no live quotes: the 1d column falls back to the last session
            live = {}
    today = datetime.now(ET).date()

    def pct(s: str) -> dict:
        x = ch.get(s) or {}
        if "closes" not in x:
            return {}
        c = x["closes"]
        if is_open and s in live:
            base = c[-2] if x["last_date"] == today else c[-1]   # skip today's forming bar as the base
            hist = c[:-1] if x["last_date"] == today else c
            return {"1d": (live[s] / base - 1) * 100, "5d": (live[s] / hist[-5] - 1) * 100,
                    "20d": (live[s] / hist[-20] - 1) * 100, "px": live[s], "live": True}
        return {"1d": (c[-1] / c[-2] - 1) * 100, "5d": (c[-1] / c[-6] - 1) * 100,
                "20d": (c[-1] / c[-21] - 1) * 100, "px": c[-1], "live": False}

    for r in rows:
        r.update(pct(r["sym"]))
    good = [r for r in rows if "1d" in r]
    bad = [r["sym"] for r in rows if "1d" not in r]
    if not good:
        return {"ok": False, "text": f"{head} — UNAVAILABLE (no price bars for any holding)", "png": None}
    key = "w" if sort == "weight" else sort if sort in SORTS else "1d"
    good.sort(key=lambda r: -r[key])
    e = pct(etf)
    n_live = sum(1 for r in good if r["live"])
    when = (f"LIVE vs prior close · Robinhood last trade {live_src}" if n_live == len(good) and n_live else
            f"last completed session {max(x['last_date'] for x in ch.values() if 'last_date' in x):%m-%d} (market closed"
            " or no live quote)")
    up = sum(1 for r in good if r["1d"] > 0)
    wsum = sum(r["w"] for r in good)
    wavg = sum(r["1d"] * r["w"] for r in good) / wsum if wsum else 0.0
    best, worst = max(good, key=lambda r: r["1d"]), min(good, key=lambda r: r["1d"])
    lines = [f"{head} · {datetime.now(ET):%a %m-%d %H:%M ET}", f"1d column: {when}"]
    if e:
        lines.append(f"**{etf}** itself: 1d {e['1d']:+.2f}% · 5d {e['5d']:+.2f}% · 20d {e['20d']:+.2f}% · {e['px']:,.2f}")
    else:
        lines.append(f"**{etf}** itself: UNAVAILABLE ({(ch.get(etf) or {}).get('error', 'no bars')})")
    lines.append(f"Holdings: {up} up / {len(good) - up} down · weight-averaged 1d move {wavg:+.2f}% · "
                 f"best {best['sym']} {best['1d']:+.2f}% · worst {worst['sym']} {worst['1d']:+.2f}%")
    lines += ["```", f"{'Stock':<6}{'Wt%':>6}{'1d%':>8}{'5d%':>8}{'20d%':>8}{'Price':>10}"]
    for r in good:
        lines.append(f"{r['sym']:<6}{r['w']:>6.2f}{r['1d']:>+8.2f}{r['5d']:>+8.2f}{r['20d']:>+8.2f}{r['px']:>10,.2f}")
    lines.append("```")
    notes = []
    if total > len(rows):
        notes.append(f"showing the {len(rows)} largest of {total} holdings")
    if bad:
        notes.append(f"no bars for {', '.join(bad)}")
    if any((ch.get(s) or {}).get("yahoo") for s in syms):
        notes.append("some closes are Yahoo (not Robinhood) because Robinhood's daily bars were a session behind")
    lines.append(f"_Holdings: {h_src}. Sorted by {key if key != 'w' else 'weight'}."
                 + (" " + "; ".join(notes).capitalize() + "." if notes else "")
                 + " No AI. Advisory only, no proven edge, no size._")
    text = "\n".join(lines)
    png = None
    if chart:
        try:
            png = _render(etf, good, e, key, when)
        except Exception as ex:  # noqa: BLE001
            text += f"\n_Chart render failed ({type(ex).__name__})._"
    return {"ok": True, "text": text, "png": png}


def _render(etf: str, good: list[dict], e: dict, key: str, when: str) -> str:
    import chartlib
    import matplotlib.pyplot as plt
    col = "1d" if key == "w" else key
    data = sorted(good, key=lambda r: r[col])
    fig, ax = plt.subplots(figsize=(9, max(4, 0.28 * len(data) + 1.4)), facecolor="#0d1117")
    ax.barh([r["sym"] for r in data], [r[col] for r in data],
            color=["#3fb950" if r[col] >= 0 else "#f85149" for r in data])
    if e:
        ax.axvline(e[col], color="#d29922", lw=1.2, ls="--")
        ax.text(e[col], len(data) - 0.3, f" {etf} {e[col]:+.2f}%", color="#d29922", fontsize=9, va="bottom")
    ax.axvline(0, color="#6e7681", lw=0.8)
    ax.set_facecolor("#0d1117")
    ax.tick_params(colors="#8b949e", labelsize=9)
    ax.grid(axis="x", color="#21262d", lw=0.6)
    for sp in ax.spines.values():
        sp.set_color("#30363d")
    ax.set_title(f"{etf} holdings · {col} % change · {when[:60]}", color="#e6edf3", fontsize=11)
    fig.tight_layout()
    path = str(chartlib.OUT / f"etf_{etf}.png")
    fig.savefig(path, dpi=120, facecolor="#0d1117")
    plt.close("all")
    return path


if __name__ == "__main__":
    ap = argparse.ArgumentParser()
    ap.add_argument("etf")
    ap.add_argument("--sort", default="1d", choices=SORTS)
    ap.add_argument("--top", type=int, default=30)
    ap.add_argument("--no-chart", action="store_true")
    a = ap.parse_args()
    r = build(a.etf, a.sort, a.top, chart=not a.no_chart)
    print(r["text"])
    print("png:", r["png"], "| chars:", len(r["text"]))
