#!/usr/bin/env python3
"""
max_pain.py — MAX PAIN per expiry → #gamma-levels.

For each ticker (default SPY,QQQ + --from-flow top names), takes the nearest MONTHLY
expiry (3rd-Friday standard, falls back to nearest >=14 DTE) and computes the standard
max-pain strike: the strike that MINIMIZES total dollar payout to option holders at
expiry. Dollar pain at candidate settlement price K =
    sum_calls  OI * max(0, K - call_strike) * 100     (ITM call payout)
  + sum_puts   OI * max(0, put_strike - K) * 100       (ITM put payout)
The strike with the LOWEST total payout = max pain = the "pin"/price magnet into OpEx.

Plots the pain curve vs strike, marks the max-pain strike (the min) and current spot.
Caption: max pain $X vs spot $Y + "price magnet into OpEx".

OI basis: yfinance openInterest. OI only refreshes ~once daily (pre-market) and reads 0
after hours — when the chain's OI is empty we fall back to live VOLUME as the weighting
proxy and clearly label the chart "(VOL proxy)". Best signal = run pre-market with real OI.

Usage:
  python3 max_pain.py                       # SPY, QQQ (defaults)
  python3 max_pain.py TICKER [TICKER...]
  python3 max_pain.py --from-flow [--top 4] # add top flow-premium names
  python3 max_pain.py --dry                 # render only, no post
Read-only on all data. --channel gamma-levels.
"""
from __future__ import annotations
import sys, json, argparse, time, datetime as dt
from collections import defaultdict
from pathlib import Path
import numpy as np
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt
import yfinance as yf

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))
import chartlib                              # noqa: E402
import deliver                               # noqa: E402

FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"
BG = getattr(chartlib, "BG", "#0d1117")          # dark facecolor (chartlib may not export it)


def pick_expiry(exps: list[str], today: dt.date) -> tuple[str, int]:
    """Nearest standard monthly expiry (3rd Friday) with DTE>=0; else nearest >=14 DTE; else last."""
    monthlies = []
    for e in exps:
        d = dt.date.fromisoformat(e)
        if d.weekday() == 4 and 15 <= d.day <= 21 and (d - today).days >= 0:
            monthlies.append(e)
    if monthlies:
        e = monthlies[0]
        return e, (dt.date.fromisoformat(e) - today).days
    for e in exps:
        d = (dt.date.fromisoformat(e) - today).days
        if d >= 14:
            return e, d
    return exps[-1], (dt.date.fromisoformat(exps[-1]) - today).days


def compute(ticker: str):
    tk = yf.Ticker(ticker)
    spot = float(tk.history(period="1d")["Close"].iloc[-1])
    exps = tk.options
    if not exps:
        raise ValueError("no options")
    expiry, dte = pick_expiry(list(exps), dt.date.today())
    ch = tk.option_chain(expiry)
    calls, puts = ch.calls, ch.puts

    # OI per strike (primary). Fall back to VOLUME when the chain's OI is empty (after-hours).
    def by_strike(df, col):
        d = defaultdict(float)
        for strike, v in zip(df["strike"], df[col].fillna(0)):
            d[float(strike)] += float(v)
        return d

    # Prefer OI, but only if it's genuine two-sided open interest. yfinance OI is stale/empty
    # after-hours and refreshes pre-market — a few stray contracts (e.g. callOI=7, putOI=0) is
    # NOT a usable distribution and would pin max-pain to a grid edge. Require both sides to
    # clear a floor; otherwise fall back to live two-sided VOLUME (clearly labeled).
    coi, poi = by_strike(calls, "openInterest"), by_strike(puts, "openInterest")
    OI_FLOOR = 500          # min per-side OI to trust the OI distribution
    if sum(coi.values()) >= OI_FLOOR and sum(poi.values()) >= OI_FLOOR:
        basis = "OI"
    else:
        coi, poi = by_strike(calls, "volume"), by_strike(puts, "volume")
        basis = "VOL"

    strikes = sorted(set(coi) | set(poi))
    if not strikes or (sum(coi.values()) + sum(poi.values())) < 1:
        raise ValueError(f"no {basis} data on {expiry}")

    # Focus the candidate-settlement grid near spot (+/-25%) so the curve is readable
    # and the min isn't pulled to a far tail by a few deep contracts.
    lo, hi = spot * 0.75, spot * 1.25
    grid = [k for k in strikes if lo <= k <= hi] or strikes

    pain = {}
    for K in grid:  # K = candidate price at expiry
        total = 0.0
        for s, oi in coi.items():
            if K > s:
                total += oi * (K - s) * 100.0     # ITM call payout to holder
        for s, oi in poi.items():
            if K < s:
                total += oi * (s - K) * 100.0     # ITM put payout to holder
        pain[K] = total

    mp_strike = min(pain, key=pain.get)           # min total payout = max pain
    return dict(ticker=ticker, spot=spot, expiry=expiry, dte=dte, basis=basis,
                strikes=grid, pain=pain, mp=mp_strike,
                coi=coi, poi=poi,
                call_oi=int(sum(coi.values())), put_oi=int(sum(poi.values())))


def render(r) -> str:
    grid = r["strikes"]
    pain_m = np.array([r["pain"][k] / 1e6 for k in grid])  # $ millions
    fig, ax = plt.subplots(figsize=(11, 6.5), facecolor=BG)
    ax.set_facecolor(BG)

    # pain curve
    ax.plot(grid, pain_m, color="#58a6ff", lw=1.6, zorder=3)
    ax.fill_between(grid, pain_m, pain_m.min(), color="#58a6ff", alpha=0.10, zorder=1)

    # call vs put OI/VOL profile (light bars) on a twin axis for context
    ax2 = ax.twinx()
    w = (max(grid) - min(grid)) / max(len(grid), 1) * 0.42
    ax2.bar([k - w/2 for k in grid], [r["coi"].get(k, 0) for k in grid], width=w,
            color="#3fb950", alpha=0.30, zorder=0)
    ax2.bar([k + w/2 for k in grid], [r["poi"].get(k, 0) for k in grid], width=w,
            color="#f85149", alpha=0.30, zorder=0)
    ax2.set_ylabel(f"{r['basis']} (call=grn / put=red)", color="#6e7681", fontsize=8)
    ax2.tick_params(axis="y", colors="#3a3f47", labelsize=7)
    ax2.set_ylim(bottom=0)

    # max-pain (min) + spot markers
    ax.axvline(r["mp"], color="#bc8cff", ls="--", lw=1.4, zorder=4)
    ax.text(r["mp"], pain_m.max(), f" MAX PAIN {r['mp']:g}", color="#bc8cff",
            fontsize=10, va="top", ha="left", zorder=5)
    ax.axvline(r["spot"], color="#d29922", ls="-", lw=1.0, zorder=4)
    ax.text(r["spot"], pain_m.max() * 0.86, f" SPOT {r['spot']:.2f}", color="#d29922",
            fontsize=10, va="top", ha="left", zorder=5)

    pull = "below" if r["mp"] < r["spot"] else ("above" if r["mp"] > r["spot"] else "at")
    note = "" if r["basis"] == "OI" else "   [VOL proxy - OI flat after-hours]"
    title = (f"{r['ticker']}  Max Pain  {r['expiry']} ({r['dte']}DTE)\n"
             f"max pain {r['mp']:g}  vs  spot {r['spot']:.2f}  "
             f"(pin {pull} spot)  -  price magnet into OpEx{note}")
    ax.set_title(title, color="#e6edf3", fontsize=11, loc="left")
    ax.set_xlabel("strike / settlement price", color="#8b949e", fontsize=9)
    ax.set_ylabel("total option-holder payout ($M)", color="#8b949e", fontsize=9)
    ax.tick_params(colors="#8b949e")
    [sp.set_color("#30363d") for sp in ax.spines.values()]
    [sp.set_color("#30363d") for sp in ax2.spines.values()]
    ax.grid(color="#21262d", lw=0.5)

    path = str(chartlib.OUT / f"maxpain_{r['ticker']}.png")
    fig.savefig(path, dpi=120, bbox_inches="tight", facecolor=BG)
    plt.close(fig)
    return path


def caption(r) -> str:
    dist = (r["mp"] - r["spot"]) / r["spot"] * 100.0
    arrow = "🔻" if dist < -0.25 else ("🔺" if dist > 0.25 else "🎯")
    basis = "OI" if r["basis"] == "OI" else "VOL-proxy"
    return (f"🧲 **{r['ticker']}** max pain **{r['mp']:g}** vs spot **{r['spot']:.2f}** "
            f"({arrow} {dist:+.1f}%) — {r['expiry']} ({r['dte']}DTE)\n"
            f"Price magnet into OpEx: dealers pin toward where the fewest options pay out. "
            f"basis {basis} · call {r['call_oi']:,} / put {r['put_oi']:,}")


def flow_names(top: int) -> list[str]:
    raw = json.loads(FLOW.read_text()); items = raw.values() if isinstance(raw, dict) else raw
    prem = defaultdict(float)
    for it in items:
        a = it.get("alert", it)
        if a.get("UnderlyingType") == "stock" and a.get("Symbol"):
            prem[a["Symbol"]] += (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
    return [s for s, _ in sorted(prem.items(), key=lambda x: -x[1])[:top]]


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("tickers", nargs="*")
    ap.add_argument("--channel", default="gamma-levels")
    ap.add_argument("--from-flow", action="store_true")
    ap.add_argument("--top", type=int, default=4)
    ap.add_argument("--dry", action="store_true")
    a = ap.parse_args()

    tickers = list(a.tickers) or ["SPY", "QQQ"]
    if a.from_flow:
        for t in flow_names(a.top):
            if t not in tickers:
                tickers.append(t)

    n = 0
    for t in tickers:
        try:
            r = compute(t); png = render(r)
        except Exception as e:
            print(f"  {t}: {e}"); continue
        dok, tok = deliver.post_chart(a.channel, png, caption(r), dry=a.dry)
        print(f"  {t}: max_pain {r['mp']:g} vs spot {r['spot']:.2f} [{r['basis']}] "
              f"discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}")
        n += bool(dok or tok)
        time.sleep(0 if a.dry else 1)
    print(f"[max_pain] {n}/{len(tickers)} → #{a.channel}")


if __name__ == "__main__":
    main()
