#!/usr/bin/env python3
"""
earnings_em.py — EARNINGS expected-move vs HISTORICAL, grouped-bar card → #earnings-radar.

For every ticker with earnings in the next ~N trading days:
  • IMPLIED expected move  = ATM straddle of the expiry JUST AFTER earnings / spot.
  • HISTORICAL avg move    = mean of the abs 1-day reaction over the last ~6 earnings
    (quarter-anchored: step back ~91d per quarter from the next earnings date, take the
    max abs close-to-close move in a small window around each anchor — robust when exact
    past earnings dates are unavailable, which they are here since lxml is missing so
    yfinance.get_earnings_dates() fails).
Flags CHEAP (implied < historical → buy-straddle edge) vs RICH (implied > historical → sell).
Grouped bar chart implied vs historical per ticker; caption highlights the CHEAP names.

Ticker universe = a fixed majors list + (with --from-flow) the top premium names in today's
live options-flow stream (READ-ONLY). Earnings date comes from yfinance .calendar.

Usage:
  python3 earnings_em.py                       # majors + flow top, default 10-trading-day window
  python3 earnings_em.py AAPL TSLA NFLX        # explicit tickers (window filter still applies)
  python3 earnings_em.py --days 14 --no-flow   # widen window, majors only
  python3 earnings_em.py --all                 # ignore window — chart whatever has a known date
  python3 earnings_em.py --dry                 # render only, no posting
  --channel earnings-radar (default)
"""
from __future__ import annotations
import sys, json, argparse, time, math, datetime as dt
from pathlib import Path
from collections import defaultdict
import numpy as np, pandas as pd
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt
import yfinance as yf

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))
import chartlib                              # noqa: E402
import deliver                               # noqa: E402

FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"
MAJORS = ["AAPL", "MSFT", "NVDA", "TSLA", "AMZN", "META", "GOOGL", "AMD", "NFLX"]
BG = getattr(chartlib, "BG", "#0d1117")  # dark theme bg (chartlib lacks BG in this build)

# ~5 trading days per calendar week → N trading days ≈ N*7/5 calendar days (+slack for weekends)
def _cal_days(trading_days: int) -> int:
    return int(round(trading_days * 7 / 5)) + 2


def _mid(row):
    b, a = row.get("bid", 0) or 0, row.get("ask", 0) or 0
    return (b + a) / 2 if (b and a) else (row.get("lastPrice", 0) or 0)


def next_earnings(tk: yf.Ticker):
    """Return next earnings date (date) or None."""
    try:
        cal = tk.calendar
        ed = cal.get("Earnings Date") if isinstance(cal, dict) else None
        if not ed:
            return None
        e = ed[0] if isinstance(ed, (list, tuple)) else ed
        if hasattr(e, "date"):
            e = e.date()
        return e
    except Exception:
        return None


def implied_move(tk: yf.Ticker, spot: float, earn: dt.date):
    """ATM straddle of the expiry JUST AFTER earnings / spot. Returns (em, expiry, dte, straddle)."""
    exps = tk.options
    if not exps:
        raise ValueError("no options")
    today = dt.date.today()
    after = [e for e in exps if dt.date.fromisoformat(e) >= earn]
    pick = after[0] if after else exps[-1]
    dte = (dt.date.fromisoformat(pick) - today).days
    ch = tk.option_chain(pick)
    calls, puts = ch.calls.copy(), ch.puts.copy()
    if calls.empty or puts.empty:
        raise ValueError("empty chain")
    calls["d"] = (calls["strike"] - spot).abs()
    puts["d"] = (puts["strike"] - spot).abs()
    c = calls.loc[calls["d"].idxmin()]
    p = puts.loc[puts["d"].idxmin()]
    strad = _mid(c) + _mid(p)
    if not strad:
        raise ValueError("no straddle price")
    return strad / spot, pick, dte, strad


def historical_move(tk: yf.Ticker, next_ed: dt.date, n: int = 6):
    """Mean abs 1-day reaction over the last ~n earnings, quarter-anchored from next_ed.

    Approximates past earnings dates by stepping back 91 days/quarter, then takes the max
    abs close-to-close move in a +/-4 trading-day window around each anchor (the gap IS the
    reaction). Returns (mean_em, [(date, pct)...]).
    """
    h = tk.history(period="2y", interval="1d", auto_adjust=False)
    if h.empty or len(h) < 30:
        return None, []
    ret = (h["Close"] / h["Close"].shift(1) - 1).abs()
    idx = h.index
    moves, det = [], []
    for q in range(1, n + 1):
        anchor = pd.Timestamp(next_ed) - pd.Timedelta(days=91 * q)
        if idx.tz is not None and anchor.tzinfo is None:
            anchor = anchor.tz_localize(idx.tz)
        if anchor < idx[0]:
            break
        pos = idx.get_indexer([anchor], method="nearest")[0]
        lo, hi = max(0, pos - 4), min(len(idx) - 1, pos + 4)
        window = ret.iloc[lo:hi + 1]
        if len(window):
            mv = float(window.max())
            moves.append(mv)
            det.append((window.idxmax().date(), round(mv * 100, 1)))
    if not moves:
        return None, []
    return float(np.mean(moves)), det


def flow_names(top: int):
    """Top stock tickers by total premium in today's flow (READ-ONLY)."""
    try:
        raw = json.loads(FLOW.read_text())
    except Exception:
        return []
    items = raw.values() if isinstance(raw, dict) else raw
    prem = defaultdict(float)
    for it in items:
        a = it.get("alert", it) if isinstance(it, dict) else None
        if a and a.get("UnderlyingType") == "stock" and a.get("Symbol"):
            prem[a["Symbol"]] += (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
    return [s for s, _ in sorted(prem.items(), key=lambda x: -x[1])[:top]]


def assess(ticker: str, window_days: int | None):
    """Return a row dict or None (no earnings / out of window / no data)."""
    tk = yf.Ticker(ticker)
    earn = next_earnings(tk)
    if not earn:
        return None
    today = dt.date.today()
    days_out = (earn - today).days
    if window_days is not None and not (0 <= days_out <= window_days):
        return None  # earnings not in the window (or already passed)
    spot = float(tk.history(period="1d")["Close"].iloc[-1])
    imp, expiry, dte, strad = implied_move(tk, spot, earn)
    hist, det = historical_move(tk, earn)
    if hist is None:
        return None
    cheap = imp < hist
    return dict(ticker=ticker, spot=spot, earn=earn, days_out=days_out,
                implied=imp, historical=hist, expiry=expiry, dte=dte,
                straddle=strad, cheap=cheap, hist_detail=det)


def render(rows: list[dict], window_days: int | None) -> str:
    """Grouped bar chart: implied vs historical expected move per ticker."""
    rows = sorted(rows, key=lambda r: r["earn"])  # soonest earnings first
    imp = [r["implied"] * 100 for r in rows]
    his = [r["historical"] * 100 for r in rows]
    x = np.arange(len(rows))
    w = 0.38

    fig_w = max(9, 1.15 * len(rows) + 3)
    fig, ax = plt.subplots(figsize=(fig_w, 6.2), facecolor=BG)
    ax.set_facecolor(BG)

    b1 = ax.bar(x - w / 2, imp, w, label="Implied (straddle)", color="#bc8cff",
                edgecolor="#30363d", linewidth=0.5)
    b2 = ax.bar(x + w / 2, his, w, label="Historical avg", color="#58a6ff",
                edgecolor="#30363d", linewidth=0.5)

    # value labels on bars
    for bars, vals in ((b1, imp), (b2, his)):
        for rect, v in zip(bars, vals):
            ax.text(rect.get_x() + rect.get_width() / 2, rect.get_height() + 0.15,
                    f"{v:.1f}", ha="center", va="bottom", color="#c9d1d9", fontsize=8)

    # color the x tick label by cheap(green)/rich(red), append earnings date
    ax.set_xticks(x)
    xlabels = [f"{r['ticker']}\n{r['earn'].strftime('%-m/%-d')}" for r in rows]
    ax.set_xticklabels(xlabels, fontsize=9)
    for tick, r in zip(ax.get_xticklabels(), rows):
        tick.set_color("#3fb950" if r["cheap"] else "#f85149")

    ax.set_ylabel("Expected move  (%)", color="#c9d1d9")
    ax.tick_params(colors="#8b949e")
    for sp in ax.spines.values():
        sp.set_color("#30363d")
    ax.grid(axis="y", color="#21262d", lw=0.5)
    ax.set_axisbelow(True)

    cheap_n = sum(r["cheap"] for r in rows)
    win = f"next {window_days}d window" if window_days is not None else "all w/ known date"
    title = (f"Earnings Expected Move — Implied vs Historical   ({win})\n"
             f"green ticker = CHEAP (implied < historical, buy-straddle edge)  ·  "
             f"red = RICH (sell)   ·   {cheap_n}/{len(rows)} cheap")
    ax.set_title(title, color="#e6edf3", fontsize=11, loc="left")
    leg = ax.legend(facecolor=BG, edgecolor="#30363d", labelcolor="#c9d1d9",
                    fontsize=9, loc="upper right")
    leg.get_frame().set_alpha(0.9)

    fig.text(0.01, 0.01, dt.datetime.now().strftime("as of %Y-%m-%d %H:%M ET"),
             color="#6e7681", fontsize=7)
    path = str(chartlib.OUT / "earnings_em.png")
    fig.savefig(path, dpi=130, bbox_inches="tight", facecolor=BG)
    plt.close(fig)
    return path


def caption(rows: list[dict]) -> str:
    rows = sorted(rows, key=lambda r: r["earn"])
    cheap = [r for r in rows if r["cheap"]]
    rich = [r for r in rows if not r["cheap"]]
    head = (f"📊 **Earnings Expected Move — implied vs historical** "
            f"({len(rows)} names w/ upcoming earnings)")
    if cheap:
        cl = ", ".join(f"{r['ticker']} ({r['implied']*100:.1f}% vs {r['historical']*100:.1f}% hist, "
                       f"{r['earn'].strftime('%-m/%-d')})" for r in cheap)
        body = f"\n🟩 **CHEAP — buy-straddle edge:** {cl}"
    else:
        body = "\n🟩 CHEAP: none — all upcoming names price their move RICH (or fair)."
    if rich:
        rl = ", ".join(f"{r['ticker']} (+{(r['implied']-r['historical'])*100:.1f}pt)" for r in rich)
        body += f"\n🟥 **RICH — sell-premium lean:** {rl}"
    return head + body + "\n_Implied = ATM straddle of the expiry just after earnings ÷ spot. " \
                         "Historical = mean abs 1-day reaction, last ~6 earnings._"


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("tickers", nargs="*", help="explicit tickers (still window-filtered unless --all)")
    ap.add_argument("--channel", default="earnings-radar")
    ap.add_argument("--days", type=int, default=10, help="earnings within next N TRADING days")
    ap.add_argument("--from-flow", dest="from_flow", action="store_true", default=True,
                    help="include top flow-premium names (default on)")
    ap.add_argument("--no-flow", dest="from_flow", action="store_false")
    ap.add_argument("--top", type=int, default=12, help="how many flow names to consider")
    ap.add_argument("--all", action="store_true", help="ignore the window — chart any known date")
    ap.add_argument("--dry", action="store_true")
    args = ap.parse_args()

    window = None if args.all else _cal_days(args.days)

    # build candidate universe
    if args.tickers:
        cand = list(dict.fromkeys(t.upper() for t in args.tickers))
    else:
        cand = list(MAJORS)
        if args.from_flow:
            for t in flow_names(args.top):
                if t not in cand:
                    cand.append(t)

    win_lbl = "ALL known dates" if args.all else f"next {args.days} trading days (~{window} cal days)"
    print(f"[earnings-em] scanning {len(cand)} candidates for earnings in {win_lbl}: {', '.join(cand)}")

    rows = []
    for t in cand:
        try:
            r = assess(t, window)
        except Exception as e:
            print(f"  {t}: skip ({e})")
            continue
        if r:
            verdict = "CHEAP" if r["cheap"] else "RICH"
            print(f"  {t}: earn {r['earn']} ({r['days_out']}d) · implied "
                  f"{r['implied']*100:.1f}% vs hist {r['historical']*100:.1f}% → {verdict}")
            rows.append(r)
        time.sleep(0 if args.dry else 0.3)

    if not rows:
        print(f"[earnings-em] no tickers with earnings in {win_lbl} — nothing to post.")
        return

    png = render(rows, window)
    print(f"[earnings-em] rendered {png}")
    cap = caption(rows)
    dok, tok = deliver.post_chart(args.channel, png, cap, dry=args.dry)
    print(f"  delivery: discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}")
    cheap_n = sum(r["cheap"] for r in rows)
    print(f"[earnings-em] {len(rows)} names ({cheap_n} cheap) → #{args.channel}")


if __name__ == "__main__":
    main()
