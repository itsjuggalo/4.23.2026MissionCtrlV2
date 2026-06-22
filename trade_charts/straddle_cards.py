#!/usr/bin/env python3
"""
straddle_cards.py — options/straddle decision card per ticker.

Shows the straddle edge: ATM straddle price → expected move ±, breakevens, ATM IV,
an expected-move CONE projected to expiry, and a 🚨 earnings IV-crush warning.
Also stores daily ATM IV → builds IV rank/percentile over time.

Usage: python3 straddle_cards.py TICKER [TICKER...]  [--channel straddle-cards] [--dry]
       python3 straddle_cards.py --from-flow [--top 4]   # pick straddle-worthy flow names
"""
from __future__ import annotations
import sys, json, argparse, time, math, datetime as dt
from pathlib import Path
import numpy as np, pandas as pd
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt
import yfinance as yf

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))
import chartlib                              # noqa: E402
import deliver                               # noqa: E402

SYNTH_TOKEN = (Path.home() / ".openclaw/secrets/discord_synthcontrol_token").read_text().strip()
IVHIST = Path.home() / ".openclaw/workspace/charts/iv_history.json"
FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"


def _mid(row):
    b, a = row.get("bid", 0) or 0, row.get("ask", 0) or 0
    return (b + a) / 2 if (b and a) else (row.get("lastPrice", 0) or 0)


def straddle(ticker: str):
    tk = yf.Ticker(ticker)
    spot = tk.history(period="1d")["Close"].iloc[-1]
    exps = tk.options
    if not exps:
        raise ValueError("no options")
    today = dt.date.today()
    # nearest monthly-ish expiry >= 14 DTE
    pick = None
    for e in exps:
        d = (dt.date.fromisoformat(e) - today).days
        if d >= 14:
            pick = e; dte = d; break
    if not pick:
        pick = exps[-1]; dte = (dt.date.fromisoformat(pick) - today).days
    ch = tk.option_chain(pick)
    calls, puts = ch.calls, ch.puts
    calls["d"] = (calls["strike"] - spot).abs(); puts["d"] = (puts["strike"] - spot).abs()
    c = calls.loc[calls["d"].idxmin()]; p = puts.loc[puts["d"].idxmin()]
    strad = _mid(c) + _mid(p)
    em = strad / spot
    # derive ATM IV from the straddle price (robust after-hours; yfinance IV is 0 when closed):
    # ATM straddle ≈ 0.7979 · S · σ · sqrt(T) → σ = straddle / (0.7979·S·sqrt(T))
    T = max(dte, 1) / 365.0
    iv = float(strad / (0.7979 * spot * math.sqrt(T))) if spot and strad else 0.0
    # earnings within window?
    edate = None
    try:
        cal = tk.calendar
        ed = cal.get("Earnings Date") if isinstance(cal, dict) else None
        if ed: edate = ed[0] if isinstance(ed, (list, tuple)) else ed
        if hasattr(edate, "date"): edate = edate.date()
    except Exception:
        pass
    crush = bool(edate and today <= edate <= dt.date.fromisoformat(pick))
    return dict(ticker=ticker, spot=float(spot), expiry=pick, dte=dte, straddle=float(strad),
                em=float(em), iv=iv, breakup=float(spot+strad), breakdn=float(spot-strad),
                strike=float(c["strike"]), earn=str(edate) if edate else None, crush=crush)


def iv_rank(ticker, iv):
    """Store today's IV, return percentile vs stored history (None until enough days)."""
    hist = json.loads(IVHIST.read_text()) if IVHIST.exists() else {}
    arr = hist.get(ticker, [])
    today = dt.date.today().isoformat()
    arr = [x for x in arr if x[0] != today] + [[today, round(iv, 4)]]
    arr = arr[-300:]
    hist[ticker] = arr
    IVHIST.write_text(json.dumps(hist))
    vals = [x[1] for x in arr]
    if len(vals) < 10:
        return None
    return round(100 * sum(v <= iv for v in vals) / len(vals))


def render(s, ivr) -> str:
    df = chartlib.fetch(s["ticker"], period="3mo")
    fig, ax = plt.subplots(figsize=(11, 6.5), facecolor="#0d1117")
    ax.set_facecolor("#0d1117")
    x = np.arange(len(df))
    ax.plot(x, df["Close"], color="#58a6ff", lw=1.3)
    # forward expected-move cone
    fwd = np.arange(len(df), len(df) + max(s["dte"], 1))
    t = np.linspace(0, 1, len(fwd))
    up = s["spot"] * (1 + s["em"] * np.sqrt(t)); dn = s["spot"] * (1 - s["em"] * np.sqrt(t))
    ax.fill_between(fwd, dn, up, color="#bc8cff", alpha=0.15)
    ax.plot(fwd, up, "--", color="#bc8cff", lw=1); ax.plot(fwd, dn, "--", color="#bc8cff", lw=1)
    ax.axhline(s["breakup"], color="#3fb950", ls=":", lw=1); ax.axhline(s["breakdn"], color="#f85149", ls=":", lw=1)
    ax.axhline(s["spot"], color="#8b949e", ls="-", lw=0.6)
    for sp, lbl, col in [(s["breakup"], rf"BE \${s['breakup']:.2f}", "#3fb950"),
                          (s["breakdn"], rf"BE \${s['breakdn']:.2f}", "#f85149")]:
        ax.text(len(df)+s["dte"], sp, " "+lbl, color=col, va="center", fontsize=9)
    ivr_s = f"{ivr}%" if ivr is not None else "building…"
    verdict = "RICH → favor selling premium" if (ivr or 0) >= 60 else \
              ("CHEAP → straddle/long-vol favorable" if ivr is not None and ivr <= 30 else "mid")
    title = (f"{s['ticker']}  ${s['spot']:.2f}   straddle ${s['straddle']:.2f}  "
             f"(±{s['em']*100:.1f}% by {s['expiry']}, {s['dte']}DTE)\n"
             f"ATM IV {s['iv']*100:.0f}%  ·  IV rank {ivr_s} ({verdict})"
             + ("   🚨 EARNINGS "+s['earn']+" before expiry → IV-CRUSH RISK" if s["crush"] else ""))
    ax.set_title(title.replace("$", r"\$"), color="#e6edf3", fontsize=11, loc="left")
    ax.tick_params(colors="#8b949e"); [sp.set_color("#30363d") for sp in ax.spines.values()]
    ax.grid(color="#21262d", lw=0.5)
    path = str(chartlib.OUT / f"straddle_{s['ticker']}.png")
    fig.savefig(path, dpi=120, bbox_inches="tight", facecolor="#0d1117"); plt.close(fig)
    return path


def caption(s, ivr):
    v = "🟥 RICH (sell premium)" if (ivr or 0) >= 60 else ("🟩 CHEAP (long vol ok)" if ivr is not None and ivr <= 30 else "🟨 mid")
    warn = "  🚨 **earnings before expiry — IV-crush risk on long straddle**" if s["crush"] else ""
    return (f"**{s['ticker']}** straddle ${s['straddle']:.2f} → expected ±{s['em']*100:.1f}% by {s['expiry']} "
            f"({s['dte']}DTE)\nBreakevens ${s['breakdn']:.2f} / ${s['breakup']:.2f} · "
            f"ATM IV {s['iv']*100:.0f}% · IV rank {ivr if ivr is not None else '…'} {v}{warn}")


def flow_names(top):
    raw = json.loads(FLOW.read_text()); items = raw.values() if isinstance(raw, dict) else raw
    from collections import defaultdict
    prem = defaultdict(float)
    for it in items:
        a = it.get("alert", it)
        if a.get("UnderlyingType") == "stock" and a.get("Symbol"):
            prem[a["Symbol"]] += (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
    return [s for s, _ in sorted(prem.items(), key=lambda x: -x[1])[:top]]


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("tickers", nargs="*")
    ap.add_argument("--channel", default="straddle-cards")
    ap.add_argument("--from-flow", action="store_true")
    ap.add_argument("--top", type=int, default=4)
    ap.add_argument("--dry", action="store_true")
    a = ap.parse_args()
    tickers = a.tickers or (flow_names(a.top) if a.from_flow else ["SPY"])
    n = 0
    for t in tickers:
        try:
            s = straddle(t); ivr = iv_rank(t, s["iv"]); png = render(s, ivr)
        except Exception as e:
            print(f"  {t}: {e}"); continue
        cap = caption(s, ivr)
        dok, tok = deliver.post_chart(a.channel, png, cap, dry=a.dry)
        print(f"  {t}: discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}"); n += bool(dok or tok); time.sleep(0 if a.dry else 1)
    print(f"[straddle] {n}/{len(tickers)} → #{a.channel}")


if __name__ == "__main__":
    main()
