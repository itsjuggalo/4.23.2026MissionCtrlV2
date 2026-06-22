#!/usr/bin/env python3
"""
gex_chart.py — Dealer Gamma Exposure (GEX) by strike → #gamma-levels.

For a ticker (default SPY), pulls the nearest monthly option chain, computes per-strike
Black-Scholes gamma (r=0, IV from chain or derived from price), then:
    GEX_strike = gamma * OI * 100 * spot^2 * 0.01
with calls + and puts - (dealer-short-gamma convention: dealers are assumed long calls /
short puts vs customers, so call OI adds positive dealer gamma, put OI subtracts).

Renders a horizontal bar chart of GEX by strike, marks spot and the GAMMA FLIP (the strike
where CUMULATIVE GEX crosses zero), and captions net-GEX sign + flip level + regime:
  negative net GEX = dealers amplify moves (momentum / trend)
  positive net GEX = dealers suppress moves (mean-revert / pin / chop)

Usage:
  python3 gex_chart.py [TICKER ...] [--channel gamma-levels] [--dry]
  python3 gex_chart.py --from-flow [--top 3]    # top flow underlyings by premium
  python3 gex_chart.py SPY QQQ --strikes 25     # window of strikes around spot
"""
from __future__ import annotations
import sys, json, argparse, time, math, datetime as dt
from pathlib import Path
from collections import defaultdict
import numpy as np
import pandas as pd
import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt
import yfinance as yf

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))  # 05_AUTOMATION/scripts
import chartlib                               # noqa: E402  (same dir)
import deliver                                # noqa: E402

FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"
OUT = chartlib.OUT
BG = chartlib.BG if hasattr(chartlib, "BG") else "#0d1117"

SQRT_2PI = math.sqrt(2 * math.pi)


def _scale(net_abs: float):
    """Pick a display unit/divisor so net GEX reads sensibly (Bn vs Mn vs K)."""
    if net_abs >= 1e8:
        return 1e9, "$Bn"
    if net_abs >= 1e5:
        return 1e6, "$Mn"
    return 1e3, "$K"


def _norm_pdf(x: float) -> float:
    return math.exp(-0.5 * x * x) / SQRT_2PI


def bs_gamma(S: float, K: float, T: float, sigma: float, r: float = 0.0) -> float:
    """Black-Scholes gamma (same for call and put). r=0 per spec."""
    if S <= 0 or K <= 0 or T <= 0 or sigma <= 0:
        return 0.0
    d1 = (math.log(S / K) + (r + 0.5 * sigma * sigma) * T) / (sigma * math.sqrt(T))
    return _norm_pdf(d1) / (S * sigma * math.sqrt(T))


def _mid(row) -> float:
    b = row.get("bid", 0) or 0
    a = row.get("ask", 0) or 0
    if b and a:
        return (b + a) / 2
    return row.get("lastPrice", 0) or 0


def _implied_vol_bisect(price: float, S: float, K: float, T: float, is_call: bool,
                        r: float = 0.0) -> float:
    """Tiny bisection IV solve (used only when chain IV is missing/zero, after-hours)."""
    if price <= 0 or S <= 0 or K <= 0 or T <= 0:
        return 0.0

    def bs_price(sig):
        if sig <= 0:
            return max(0.0, (S - K) if is_call else (K - S))
        d1 = (math.log(S / K) + (r + 0.5 * sig * sig) * T) / (sig * math.sqrt(T))
        d2 = d1 - sig * math.sqrt(T)
        Nd1 = 0.5 * (1 + math.erf(d1 / math.sqrt(2)))
        Nd2 = 0.5 * (1 + math.erf(d2 / math.sqrt(2)))
        if is_call:
            return S * Nd1 - K * math.exp(-r * T) * Nd2
        return K * math.exp(-r * T) * (1 - Nd2) - S * (1 - Nd1)

    lo, hi = 1e-4, 5.0
    if bs_price(hi) < price:        # price above model max — give up
        return 0.0
    for _ in range(60):
        mid = (lo + hi) / 2
        if bs_price(mid) > price:
            hi = mid
        else:
            lo = mid
    return (lo + hi) / 2


def _chain_oi(tk, expiry: str) -> int:
    try:
        ch = tk.option_chain(expiry)
        return int((ch.calls["openInterest"].fillna(0).sum()
                    + ch.puts["openInterest"].fillna(0).sum()))
    except Exception:
        return -1


def _pick_monthly(tk, exps, today, min_dte=20, max_dte=45, min_oi=200):
    """
    Nearest standard monthly (3rd-Friday) within ~20-45 DTE that actually carries OI.
    GEX is meaningless without open interest, and yfinance OI is often sparse/delayed
    on near-dated weeklies, so we VERIFY OI on candidates and fall back to the most-liquid
    expiry rather than a hollow one.
    """
    parsed = [(e, (dt.date.fromisoformat(e) - today).days) for e in exps]
    parsed = [(e, d) for e, d in parsed if d >= 1]
    if not parsed:
        e = exps[-1]
        return e, (dt.date.fromisoformat(e) - today).days
    monthlies = [(e, d) for e, d in parsed
                 if dt.date.fromisoformat(e).weekday() == 4 and 15 <= dt.date.fromisoformat(e).day <= 21]
    # ordered preference of monthly candidates by DTE proximity to the window
    ordered = sorted(monthlies, key=lambda x: x[1]) if monthlies else []
    win = [c for c in ordered if min_dte <= c[1] <= max_dte] + [c for c in ordered if c[1] > max_dte] \
          + [c for c in ordered if c[1] < min_dte]
    for e, d in win:
        if _chain_oi(tk, e) >= min_oi:
            return e, d
    # no liquid monthly → pick the single most-liquid expiry in a sane DTE band
    band = [(e, d) for e, d in parsed if 3 <= d <= 90] or parsed
    best, best_oi, best_d = None, -1, None
    for e, d in band:
        oi = _chain_oi(tk, e)
        if oi > best_oi:
            best, best_oi, best_d = e, oi, d
    if best and best_oi > 0:
        return best, best_d
    # last resort: nearest monthly, else nearest expiry
    if ordered:
        return ordered[0]
    parsed.sort(key=lambda x: x[1])
    return parsed[0]


def compute_gex(ticker: str, strikes_window: int = 0):
    tk = yf.Ticker(ticker)
    hist = tk.history(period="5d")["Close"].dropna()
    if hist.empty:
        raise ValueError("no spot")
    spot = float(hist.iloc[-1])
    exps = tk.options
    if not exps:
        raise ValueError("no options")
    today = dt.date.today()
    expiry, dte = _pick_monthly(tk, exps, today)
    T = max(dte, 1) / 365.0
    ch = tk.option_chain(expiry)
    calls, puts = ch.calls, ch.puts

    # build per-strike GEX
    per_strike: dict[float, float] = defaultdict(float)
    call_gex: dict[float, float] = defaultdict(float)
    put_gex: dict[float, float] = defaultdict(float)

    def _accum(df, is_call):
        for _, row in df.iterrows():
            K = float(row.get("strike", 0) or 0)
            oi = float(row.get("openInterest", 0) or 0)
            if K <= 0 or oi <= 0:
                continue
            iv = float(row.get("impliedVolatility", 0) or 0)
            if not (0.01 < iv < 5.0):
                iv = _implied_vol_bisect(_mid(row), spot, K, T, is_call)
            if not (0.01 < iv < 5.0):
                continue
            g = bs_gamma(spot, K, T, iv)
            gex = g * oi * 100 * spot * spot * 0.01
            signed = gex if is_call else -gex          # dealer short-gamma convention
            per_strike[K] += signed
            (call_gex if is_call else put_gex)[K] += gex

    _accum(calls, True)
    _accum(puts, False)

    if not per_strike:
        raise ValueError("no usable OI/IV in chain")

    ks = sorted(per_strike.keys())
    # optional window around spot
    if strikes_window and strikes_window > 0:
        ks_sorted_by_dist = sorted(ks, key=lambda k: abs(k - spot))[:strikes_window]
        ks = sorted(ks_sorted_by_dist)

    gex_by_k = [per_strike[k] for k in ks]
    net = sum(gex_by_k)

    # gamma flip = strike where cumulative GEX (low→high) crosses zero
    cum = np.cumsum(gex_by_k)
    flip = None
    for i in range(1, len(ks)):
        if (cum[i - 1] <= 0 < cum[i]) or (cum[i - 1] >= 0 > cum[i]):
            # linear interp between strikes for a smoother flip level
            x0, x1 = ks[i - 1], ks[i]
            y0, y1 = cum[i - 1], cum[i]
            flip = x0 + (x1 - x0) * (0 - y0) / (y1 - y0) if (y1 - y0) else x0
            break

    # scale by the largest single-strike magnitude so a near-zero net (cancellation)
    # still renders with readable bar units
    mag = max((abs(v) for v in gex_by_k), default=0.0)
    div, unit = _scale(max(mag, abs(net)))
    thin = len(ks) < 6           # off-hours / illiquid: OI too sparse to trust the read

    return dict(ticker=ticker, spot=spot, expiry=expiry, dte=dte, strikes=ks,
                gex=gex_by_k, call_gex=[call_gex[k] for k in ks],
                put_gex=[-put_gex[k] for k in ks], net=net, flip=flip,
                div=div, unit=unit, n_strikes=len(ks), thin=thin)


def render(g: dict) -> str:
    ks = g["strikes"]
    div, unit = g["div"], g["unit"]
    vals = [v / div for v in g["gex"]]            # scaled GEX per 1% move
    spot, flip = g["spot"], g["flip"]
    fig, ax = plt.subplots(figsize=(11, 8.5), facecolor=BG)
    ax.set_facecolor(BG)
    y = np.arange(len(ks))
    cols = ["#3fb950" if v >= 0 else "#f85149" for v in vals]
    ax.barh(y, vals, color=cols, height=0.78)
    ax.set_yticks(y)
    ax.set_yticklabels([f"{k:g}" for k in ks], fontsize=7, color="#8b949e")
    ax.axvline(0, color="#6e7681", lw=0.8)

    # spot line (nearest strike row)
    spot_i = int(np.argmin([abs(k - spot) for k in ks]))
    ax.axhline(spot_i, color="#58a6ff", ls="-", lw=1.0, alpha=0.7)
    ax.text(ax.get_xlim()[1], spot_i, f" spot {spot:,.2f}", color="#58a6ff",
            va="center", ha="left", fontsize=9)

    # gamma flip line (zero-cross of cumulative GEX)
    if flip is not None and len(ks) > 1:
        fi = float(np.interp(flip, ks, y))        # map flip price to fractional row position
        ax.axhline(fi, color="#d29922", ls="--", lw=1.3)
        ax.text(ax.get_xlim()[0], fi, f"GAMMA FLIP {flip:,.2f} ", color="#d29922",
                va="center", ha="right", fontsize=9, fontweight="bold")

    net = g["net"] / div
    regime = ("NEGATIVE GEX  ->  dealers amplify moves (momentum/trend)" if g["net"] < 0
              else "POSITIVE GEX  ->  dealers suppress moves (mean-revert/pin)")
    thin_note = "   [THIN OI - off-hours/illiquid, read tentatively]" if g["thin"] else ""
    title = (f"{g['ticker']}  Dealer Gamma Exposure by strike   exp {g['expiry']} ({g['dte']}DTE)\n"
             f"Net GEX {net:+.2f} {unit}/1%   |   {regime}{thin_note}")
    ax.set_title(title, color="#e6edf3", loc="left", fontsize=11)
    ax.set_xlabel(f"GEX  ({unit} per 1% move)   green=+call gamma  red=-put gamma",
                  color="#8b949e", fontsize=9)
    ax.tick_params(colors="#8b949e")
    [s.set_color("#30363d") for s in ax.spines.values()]
    ax.grid(color="#21262d", lw=0.5, axis="x")
    ax.margins(y=0.01)

    path = str(OUT / f"gex_{g['ticker']}.png")
    fig.savefig(path, dpi=120, bbox_inches="tight", facecolor=BG)
    plt.close(fig)
    return path


def caption(g: dict) -> str:
    net = g["net"] / g["div"]
    unit = g["unit"]
    if g["net"] < 0:
        sign = "🔴 **NEGATIVE GEX**"
        regime = "dealers *amplify* moves → momentum / trend-day (chase breakouts, wider stops)"
    else:
        sign = "🟢 **POSITIVE GEX**"
        regime = "dealers *suppress* moves → mean-revert / pin (fade extremes, expect chop)"
    flip = f"${g['flip']:,.2f}" if g["flip"] is not None else "n/a"
    above = ""
    if g["flip"] is not None:
        above = ("  · spot **above** flip (positive-gamma / stabilizing zone)"
                 if g["spot"] >= g["flip"] else
                 "  · spot **below** flip (negative-gamma / accelerant zone)")
    thin = "\n⚠️ thin OI (off-hours/illiquid) — read tentatively" if g["thin"] else ""
    return (f"**{g['ticker']}** GEX — exp {g['expiry']} ({g['dte']}DTE) · spot ${g['spot']:,.2f}\n"
            f"{sign}  net {net:+.2f} {unit}/1% · gamma flip {flip}{above}\n"
            f"⚙️ {regime}{thin}")


def flow_names(top: int):
    raw = json.loads(FLOW.read_text())
    items = raw.values() if isinstance(raw, dict) else raw
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
    ap.add_argument("--top", type=int, default=3)
    ap.add_argument("--strikes", type=int, default=0,
                    help="limit to N strikes nearest spot (0 = full chain)")
    ap.add_argument("--dry", action="store_true")
    a = ap.parse_args()
    tickers = a.tickers or (flow_names(a.top) if a.from_flow else ["SPY"])
    n = 0
    for t in tickers:
        t = t.upper()
        try:
            g = compute_gex(t, strikes_window=a.strikes)
            png = render(g)
        except Exception as e:
            print(f"  {t}: {e}")
            continue
        cap = caption(g)
        dok, tok = deliver.post_chart(a.channel, png, cap, dry=a.dry)
        print(f"  {t}: net {g['net']/g['div']:+.2f}{g['unit']} flip "
              f"{('%.2f' % g['flip']) if g['flip'] is not None else 'n/a'} "
              f"({g['n_strikes']} strikes{', THIN' if g['thin'] else ''}) "
              f"discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}")
        n += bool(dok or tok)
        time.sleep(0 if a.dry else 1)
    print(f"[gex] {n}/{len(tickers)} → #{a.channel}")


if __name__ == "__main__":
    main()
