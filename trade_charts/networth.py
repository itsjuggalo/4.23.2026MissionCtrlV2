#!/usr/bin/env python3
"""
networth.py — daily NET-WORTH equity curve for the #net-worth channel.

Pulls equity from every reachable source, sums today's total, APPENDS it to a
self-contained snapshot file so the cumulative net-worth curve grows over time,
and renders a dark-theme equity curve that gets posted to Discord + Telegram.

Sources (each is best-effort — a missing/expired token is SKIPPED gracefully and
called out in the caption, the chart still renders from whatever IS available):
  - Alpaca PAPER  : Boba + Jazzy via /v2/account/portfolio/history (period=1A,1D).
                    This is the always-on backbone and also seeds a 1-year daily
                    backfill for the combined-paper curve.
  - Robinhood     : brokerage (stock) equity via the live brokerage token, plus RH
                    crypto bag value from the cached signed-key holdings feed.
  - Coinbase      : crypto bag value from the cached CDP holdings feed priced live
                    off CoinGecko (free, no key).

COORDINATE: another session owns bank autosync — this script NEVER reads or writes
any bank file. Its only state file is networth_history.json (created here).

Snapshot file : ~/.openclaw/workspace/charts/networth_history.json
  {"YYYY-MM-DD": {"total": float, "by_source": {...}, "missing": [...], "ts": epoch}, ...}

Usage: python3 networth.py [--channel net-worth] [--dry] [--no-snapshot]

Read-only on every data source except its own snapshot file.
"""
from __future__ import annotations
import sys, os, json, time, argparse, urllib.parse, urllib.request
import datetime as dt
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))  # 05_AUTOMATION/scripts
import chartlib                              # noqa: E402
import deliver                              # noqa: E402

import numpy as np                          # noqa: E402
import pandas as pd                         # noqa: E402
import matplotlib                           # noqa: E402
matplotlib.use("Agg")
import matplotlib.pyplot as plt             # noqa: E402
import matplotlib.dates as mdates           # noqa: E402
import matplotlib.ticker as mticker         # noqa: E402

SECRETS = Path.home() / ".openclaw/secrets"
PORT = Path.home() / "portfolio"
HISTORY = chartlib.OUT / "networth_history.json"   # self-contained snapshot (NOT a bank file)
ALPACA_BASE = "https://paper-api.alpaca.markets"
CG = "https://api.coingecko.com/api/v3/simple/price"

# dark theme (chartlib only exposes OUT/STYLE; mirror the suite palette here)
BG = "#0d1117"
GREEN = "#3fb950"
RED = "#f85149"
GRID = "#21262d"

# symbol -> CoinGecko id (reused from the live crypto watcher; unmapped = skipped, never guessed)
CG_ID = {
    "BTC": "bitcoin", "ETH": "ethereum", "DOGE": "dogecoin", "XRP": "ripple",
    "SOL": "solana", "AVAX": "avalanche-2", "ETC": "ethereum-classic", "LTC": "litecoin",
    "XLM": "stellar", "ALGO": "algorand", "HBAR": "hedera-hashgraph", "JASMY": "jasmycoin",
    "CRO": "crypto-com-chain", "SHIB": "shiba-inu", "GRT": "the-graph", "UNI": "uniswap",
    "RNDR": "render-token", "COTI": "coti", "LRC": "loopring", "AMP": "amp-token",
    "XCN": "onyxcoin",
}
STABLE = {"USD", "USDC", "USDT", "DAI"}


# ---------------------------------------------------------------- helpers
def _read(p: Path) -> str | None:
    try:
        return p.read_text().strip()
    except Exception:
        return None


def _load_json(p: Path) -> dict:
    try:
        return json.loads(p.read_text())
    except Exception:
        return {}


def _http_json(url: str, headers: dict | None = None, timeout: int = 15):
    req = urllib.request.Request(url, headers=headers or {})
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.loads(r.read().decode())


# ---------------------------------------------------------------- Alpaca (paper)
def alpaca_history(name: str):
    """Return (current_equity, {date: equity}) for a paper account, or (None, {}) on failure."""
    kid = _read(SECRETS / f"alpaca-{name}-key-id")
    sec = _read(SECRETS / f"alpaca-{name}-secret")
    if not kid or not sec:
        return None, {}
    h = {"APCA-API-KEY-ID": kid, "APCA-API-SECRET-KEY": sec}
    try:
        acct = _http_json(f"{ALPACA_BASE}/v2/account", h)
        cur = float(acct.get("equity") or 0)
    except Exception as e:
        print(f"  alpaca {name}: account fail {e}")
        return None, {}
    series: dict[str, float] = {}
    try:
        ph = _http_json(
            f"{ALPACA_BASE}/v2/account/portfolio/history?period=1A&timeframe=1D", h)
        for t, eq in zip(ph.get("timestamp", []), ph.get("equity", [])):
            if eq is None:
                continue
            d = dt.datetime.fromtimestamp(t).strftime("%Y-%m-%d")
            series[d] = float(eq)   # last write per day wins
    except Exception as e:
        print(f"  alpaca {name}: history fail {e}")
    return cur, series


# ---------------------------------------------------------------- Robinhood (real money)
def rh_brokerage_equity():
    """Live RH stock-account equity via brokerage token, or None if token dead/missing."""
    tok = _read(SECRETS / "robinhood-brokerage-token.txt")
    if not tok:
        return None
    h = {"Authorization": f"Bearer {tok}", "User-Agent": "Mozilla/5.0"}
    try:
        d = _http_json("https://api.robinhood.com/portfolios/", h, timeout=15)
        res = d.get("results") or []
        if not res:
            return None
        p = res[0]
        for k in ("extended_hours_equity", "equity", "market_value"):
            v = p.get(k)
            if v not in (None, ""):
                return float(v)
    except Exception as e:
        print(f"  rh brokerage: {e}")
    return None


def rh_crypto_value():
    """RH crypto bag $ from the cached signed-key holdings feed (value_usd already present)."""
    d = _load_json(PORT / "robinhood_crypto_holdings.json")
    res = d.get("results") or []
    if not res:
        return None
    tot = 0.0
    got = False
    for r in res:
        v = r.get("value_usd")
        if v not in (None, ""):
            tot += float(v); got = True
    return round(tot, 2) if got else None


# ---------------------------------------------------------------- Coinbase (real money)
def _cg_prices(ids: list[str]) -> dict:
    if not ids:
        return {}
    q = urllib.parse.urlencode({"ids": ",".join(sorted(set(ids))), "vs_currencies": "usd"})
    try:
        return _http_json(f"{CG}?{q}", {"User-Agent": "mc-networth/1.0"}, timeout=20)
    except Exception:
        return {}


def coinbase_value():
    """Coinbase bag $ = cached CDP balances * live CoinGecko price + stablecoin face value."""
    d = _load_json(PORT / "coinbase_holdings.json")
    accts = (d.get("results", {}) or {}).get("accounts", [])
    if not accts:
        return None
    qty: dict[str, float] = {}
    stable_usd = 0.0
    for a in accts:
        sym = (a.get("currency") or "").upper()
        bal = float(a.get("available_balance", {}).get("value", 0) or 0) + \
              float(a.get("hold", {}).get("value", 0) or 0)
        if bal <= 0 or not sym:
            continue
        if sym in STABLE:
            stable_usd += bal          # USD/USDC ~= $1
            continue
        qty[sym] = qty.get(sym, 0.0) + bal
    ids = [CG_ID[s] for s in qty if s in CG_ID]
    px = _cg_prices(ids)
    tot = stable_usd
    for s, q in qty.items():
        cid = CG_ID.get(s)
        p = (px.get(cid) or {}).get("usd") if cid else None
        if p:
            tot += q * float(p)
    return round(tot, 2) if (tot > 0) else None


# ---------------------------------------------------------------- gather + snapshot
def gather():
    """Return (sources dict $, missing list, paper_series {date: combined paper equity})."""
    sources: dict[str, float] = {}
    missing: list[str] = []

    boba_cur, boba_s = alpaca_history("boba")
    jazzy_cur, jazzy_s = alpaca_history("jazzy")
    if boba_cur is not None:
        sources["Boba (paper)"] = round(boba_cur, 2)
    else:
        missing.append("Boba paper")
    if jazzy_cur is not None:
        sources["Jazzy (paper)"] = round(jazzy_cur, 2)
    else:
        missing.append("Jazzy paper")

    # combined paper daily series for the backfilled curve
    paper_series: dict[str, float] = {}
    for s in (boba_s, jazzy_s):
        for d, eq in s.items():
            paper_series[d] = paper_series.get(d, 0.0) + eq

    rh_stk = rh_brokerage_equity()
    if rh_stk is not None:
        sources["RH stocks"] = round(rh_stk, 2)
    else:
        missing.append("RH stocks (token)")

    rh_cx = rh_crypto_value()
    if rh_cx is not None:
        sources["RH crypto"] = rh_cx
    else:
        missing.append("RH crypto (token)")

    cb = coinbase_value()
    if cb is not None:
        sources["Coinbase"] = cb
    else:
        missing.append("Coinbase (token)")

    return sources, missing, paper_series


def load_history() -> dict:
    return _load_json(HISTORY)


def save_history(hist: dict) -> None:
    HISTORY.parent.mkdir(parents=True, exist_ok=True)
    tmp = HISTORY.with_suffix(".json.tmp")
    tmp.write_text(json.dumps(hist, indent=1, sort_keys=True))
    tmp.replace(HISTORY)


def snapshot(hist: dict, sources: dict, missing: list, total: float) -> dict:
    today = dt.date.today().strftime("%Y-%m-%d")
    hist[today] = {
        "total": round(total, 2),
        "by_source": sources,
        "missing": missing,
        "ts": int(time.time()),
    }
    return hist


# ---------------------------------------------------------------- render
def render(hist: dict, sources: dict, total: float, missing: list,
           paper_series: dict) -> str:
    """Cumulative net-worth curve. Snapshot history = the true total curve; the
    Alpaca 1-yr paper backfill is drawn as a faint context line so the chart has
    real shape from day one while the total-curve grows."""
    plt.style.use("dark_background")
    fig, ax = plt.subplots(figsize=(11, 6.2))
    fig.patch.set_facecolor(BG)
    ax.set_facecolor(BG)

    all_vals: list[float] = []

    # --- backfill context: combined paper equity over the past year (faint) ---
    # Trim the pre-funding flatline so the context line shows real shape, not a
    # year of $0/base then a vertical spike.
    if paper_series:
        ps = sorted(paper_series.items())
        pvals_all = [v for _, v in ps]
        base = pvals_all[-1] if pvals_all else 0.0
        # first index where equity diverges from the resting base by >2%
        start = 0
        for i, v in enumerate(pvals_all):
            if abs(v - pvals_all[0]) > max(50.0, 0.02 * (base or 1)):
                start = max(0, i - 1)
                break
        ps = ps[start:]
        # Only draw the paper context line once it has real multi-day shape —
        # right after an Alpaca reset there are only a few post-funding points and
        # a "backfill" line is a misleading $0->reset ramp.
        if len(ps) >= 10:
            pdates = [dt.datetime.strptime(d, "%Y-%m-%d") for d, _ in ps]
            pvals = [v for _, v in ps]
            ax.plot(pdates, pvals, color="#58a6ff", lw=1.2, alpha=0.55,
                    label="Paper accts (Boba+Jazzy)")
            all_vals += pvals

    # --- the real net-worth curve from the growing snapshot file ---
    snaps = sorted((d, v["total"]) for d, v in hist.items()
                   if isinstance(v, dict) and "total" in v)
    if snaps:
        sdates = [dt.datetime.strptime(d, "%Y-%m-%d") for d, _ in snaps]
        svals = [v for _, v in snaps]
        all_vals += svals
        up = svals[-1] >= svals[0]
        line_c = GREEN if up else RED
        ms = 9 if len(snaps) == 1 else 4
        ax.plot(sdates, svals, color=line_c, lw=2.4, marker="o", ms=ms,
                label="Net worth (total)", zorder=5)
        if len(snaps) >= 2:
            ax.fill_between(sdates, svals, min(all_vals) * 0.97, color=line_c,
                            alpha=0.08)
        # last point label
        ax.annotate(f"${svals[-1]:,.0f}", (sdates[-1], svals[-1]),
                    textcoords="offset points", xytext=(8, 8),
                    color="#e6edf3", fontsize=12, fontweight="bold", zorder=6)

    # frame the y-axis around the actual data so a lone snapshot isn't a tiny dot
    if all_vals:
        lo, hi = min(all_vals), max(all_vals)
        pad = max((hi - lo) * 0.12, hi * 0.06, 200.0)
        ax.set_ylim(max(0.0, lo - pad), hi + pad)

    ax.set_title(f"NET WORTH  —  ${total:,.0f}   ({dt.date.today():%b %d, %Y})",
                 color="#e6edf3", fontsize=15, fontweight="bold", pad=14)
    ax.grid(True, color=GRID, lw=0.6, alpha=0.8)
    for sp in ax.spines.values():
        sp.set_color("#30363d")
    ax.tick_params(colors="#8b949e")
    ax.yaxis.set_major_formatter(mticker.FuncFormatter(lambda x, _: f"${x:,.0f}"))
    ax.xaxis.set_major_formatter(mdates.DateFormatter("%m/%d"))
    fig.autofmt_xdate(rotation=0, ha="center")

    # source breakdown box (today)
    if sources:
        lines = [f"{k}: ${v:,.0f}" for k, v in sorted(sources.items(),
                                                       key=lambda kv: -kv[1])]
        txt = "Today's sources\n" + "\n".join(lines)
        ax.text(0.012, 0.975, txt, transform=ax.transAxes, va="top", ha="left",
                fontsize=9, color="#c9d1d9", family="monospace",
                bbox=dict(boxstyle="round,pad=0.5", fc="#161b22", ec="#30363d", alpha=0.95))

    leg = ax.legend(loc="lower right", facecolor="#161b22", edgecolor="#30363d",
                    labelcolor="#c9d1d9", fontsize=9)
    if leg:
        leg.get_frame().set_alpha(0.95)

    sub = "single snapshot — curve grows daily" if len(snaps) < 2 else f"{len(snaps)} daily snapshots"
    if missing:
        sub += "   |   pending: " + ", ".join(missing)
    fig.text(0.5, 0.012, sub, ha="center", color="#6e7681", fontsize=8)

    path = str(chartlib.OUT / "networth.png")
    fig.savefig(path, dpi=120, facecolor=BG, bbox_inches="tight")
    plt.close("all")
    return path


def build_caption(sources: dict, total: float, missing: list, hist: dict) -> str:
    parts = [f"**Net Worth: ${total:,.0f}**"]
    if sources:
        order = sorted(sources.items(), key=lambda kv: -kv[1])
        parts.append(" · ".join(f"{k.split(' (')[0]} ${v:,.0f}" for k, v in order))
    snaps = [v for v in hist.values() if isinstance(v, dict) and "total" in v]
    if len(snaps) >= 2:
        first = sorted((d for d, v in hist.items()
                        if isinstance(v, dict) and "total" in v))[0]
        prev = hist[first]["total"]
        chg = total - prev
        parts.append(f"since first snap {('+' if chg>=0 else '')}{chg:,.0f}")
    emoji = "📈" if (not snaps or total >= snaps[0]["total"]) else "📉"
    cap = f"{emoji} " + "\n".join(parts)
    if missing:
        cap += f"\n_({', '.join(missing)} pending token — skipped)_"
    return cap


def main():
    ap = argparse.ArgumentParser(description="Net-worth equity curve → #net-worth")
    ap.add_argument("--channel", default="net-worth")
    ap.add_argument("--dry", action="store_true", help="render + post dry (no real send)")
    ap.add_argument("--no-snapshot", action="store_true",
                    help="render without appending today's snapshot")
    args = ap.parse_args()

    sources, missing, paper_series = gather()
    total = round(sum(sources.values()), 2)
    print(f"[networth] total=${total:,.2f}  sources={sources}  missing={missing}")

    hist = load_history()
    if not args.no_snapshot:
        hist = snapshot(hist, sources, missing, total)
        save_history(hist)
        print(f"[networth] snapshot appended → {HISTORY} ({len(hist)} days)")

    png = render(hist, sources, total, missing, paper_series)
    print(f"[networth] rendered {png} ({os.path.getsize(png)} bytes)")

    cap = build_caption(sources, total, missing, hist)
    dok, tok = deliver.post_chart(args.channel, png, cap, dry=args.dry)
    print(f"[networth] discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'} → #{args.channel}")


if __name__ == "__main__":
    main()
