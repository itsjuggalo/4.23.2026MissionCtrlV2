#!/usr/bin/env python3
"""optionvol.py — option volatility analysis for the Discord /optionvol command (replaces the dead
Jazzy Trader /option_vol_analysis). Deterministic, read-only, no LLM.

Reads the CBOE delayed chain (pipeline/intel/chains.py) and daily closes (Robinhood, Yahoo fallback labelled):
ATM IV30 + IV rank, realized vol (20/60 sessions), IV minus realized, term structure, 25-delta skew,
expected move and put/call ratios. Anything that cannot be computed is reported UNAVAILABLE with the reason.

CLI:  ~/.venv/bin/python optionvol.py NVDA
"""
from __future__ import annotations

import warnings

warnings.filterwarnings("ignore")   # yfinance/pandas deprecation noise would flood the cron log

import math
import sys
from datetime import date
from pathlib import Path

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(HERE.parent))
import lib  # noqa: E402,F401 — bind ~/scripts/lib now; MissionCtrl modules put pipeline/ (which has its own lib/) first on sys.path
MC = "/AIWorkWSL/web/missionctrl"
sys.path.append(MC)   # append: must not shadow ~/scripts/lib
RICH_PTS = 5.0   # IV30 minus HV20, in vol points: above +5 = RICH, below -5 = CHEAP, else FAIR


def _atm_iv(rows: list[dict], spot: float) -> tuple[float | None, float | None]:
    """(ATM IV, ATM strike) for one expiry: mean of the call and put IV at the strike nearest spot."""
    strikes = sorted({r["strike"] for r in rows if r.get("iv") and r["iv"] > 0}, key=lambda k: abs(k - spot))
    for k in strikes[:3]:
        ivs = [r["iv"] for r in rows if r["strike"] == k and r.get("iv") and r["iv"] > 0]
        if ivs:
            return sum(ivs) / len(ivs), k
    return None, None


def _delta_iv(rows: list[dict], kind: str, target: float) -> tuple[float | None, float | None]:
    c = [r for r in rows if r["type"] == kind and r.get("iv") and r["iv"] > 0 and r.get("delta")
         and 0.05 < abs(r["delta"]) < 0.95]
    if not c:
        return None, None
    b = min(c, key=lambda r: abs(abs(r["delta"]) - target))
    return (b["iv"], b["strike"]) if abs(abs(b["delta"]) - target) <= 0.08 else (None, None)


def _hv(closes: list[float], n: int) -> float | None:
    if len(closes) < n + 1:
        return None
    r = [math.log(closes[i] / closes[i - 1]) for i in range(len(closes) - n, len(closes))]
    m = sum(r) / n
    return math.sqrt(sum((x - m) ** 2 for x in r) / (n - 1)) * math.sqrt(252)


def report(symbol: str) -> str:
    from pipeline.intel import chains
    from pipeline.intel.common import resolve
    try:
        sym = resolve(symbol) or symbol.upper().strip()
    except Exception:  # noqa: BLE001
        sym = symbol.upper().strip()
    if isinstance(sym, (tuple, list)):
        sym = sym[0]
    head = f"📊 **{sym} option volatility**"
    try:
        ch, _ = chains.fetch(sym)
    except Exception as e:  # noqa: BLE001
        return f"{head} — UNAVAILABLE (CBOE chain: {str(e)[:160]})"
    spot = float(ch.get("spot") or 0)
    d = chains.chain_date(ch)
    today = date.fromisoformat(d)
    cons = ch["contracts"]
    if not spot or not cons:
        return f"{head} — UNAVAILABLE (chain has no spot or no contracts)"
    lines = [f"{head} · CBOE delayed chain {d} (last trade {ch.get('last_trade_time')} ET) · chain spot {spot:,.2f} · "
             f"{len(cons)} contracts"]

    iv30 = chains.atm_iv30(cons, spot, today)
    st = chains.iv_stats(iv30, chains.iv_history(sym, before=d))
    rank = (f"IV rank {st['rank']:.0%} · percentile {st['percentile']:.0%} over {st['n']} sessions"
            if st["status"] == "OK" else f"IV rank UNAVAILABLE ({st['reason']})")
    lines.append(f"ATM IV30 {f'{iv30:.1%}' if iv30 else 'UNAVAILABLE'} · {rank}")

    closes, src = [], ""
    try:
        import ta_cmd
        df, src = ta_cmd.stock_bars(sym, "1d")
        closes = [float(x) for x in df["Close"].tolist()]
    except Exception as e:  # noqa: BLE001
        src = f"UNAVAILABLE ({str(e)[:80]})"
    hv20, hv60 = _hv(closes, 20), _hv(closes, 60)
    if hv20 is not None:
        lines.append(f"Realized vol: HV20 {hv20:.1%} · HV60 {f'{hv60:.1%}' if hv60 is not None else 'UNAVAILABLE'} "
                     f"(close-to-close, annualized · {src})")
        if iv30:
            gap = (iv30 - hv20) * 100
            tag = "RICH (options priced above recent movement)" if gap > RICH_PTS else \
                "CHEAP (options priced below recent movement)" if gap < -RICH_PTS else "FAIR"
            lines.append(f"IV30 minus HV20: {gap:+.1f} vol points → {tag} (rule: beyond ±{RICH_PTS:g} points)")
    else:
        lines.append(f"Realized vol: UNAVAILABLE ({src or 'not enough daily closes'})")

    by: dict[str, list[dict]] = {}
    for r in cons:
        by.setdefault(r["expiry"], []).append(r)
    term = []
    for exp in sorted(by):
        dte = (date.fromisoformat(exp) - today).days
        if dte < 1:
            continue
        iv, k = _atm_iv(by[exp], spot)
        if iv:
            term.append((dte, exp, iv, k))
    if term:
        want = (7, 14, 30, 60, 90, 180, 365)
        picks = sorted({min(term, key=lambda t: abs(t[0] - w)) for w in want})
        lines.append("Term structure (ATM IV by expiry): " + " · ".join(f"{t[1][5:]} ({t[0]}d) {t[2]:.1%}" for t in picks))
        near, far = min(term, key=lambda t: abs(t[0] - 30)), min(term, key=lambda t: abs(t[0] - 90))
        if far[0] > near[0]:
            shape = "CONTANGO (later expiries priced higher: normal)" if far[2] > near[2] else \
                "BACKWARDATION (near-term priced higher: event or stress priced in)"
            lines.append(f"Shape {near[0]}d → {far[0]}d: {near[2]:.1%} → {far[2]:.1%} = {shape}")
        dte, exp, iv, k = near
        rows = by[exp]
        p_iv, p_k = _delta_iv(rows, "put", 0.25)
        c_iv, c_k = _delta_iv(rows, "call", 0.25)
        if p_iv and c_iv:
            sk = (p_iv - c_iv) * 100
            lean = "puts cost more (downside protection bid)" if sk > 1 else \
                "calls cost more (upside chase)" if sk < -1 else "roughly balanced"
            lines.append(f"Skew {exp[5:]} ({dte}d): 25-delta put {p_iv:.1%} (strike {p_k:g}) minus 25-delta call "
                         f"{c_iv:.1%} (strike {c_k:g}) = {sk:+.1f} points → {lean}")
        else:
            lines.append(f"Skew {exp[5:]}: UNAVAILABLE (no contract within 0.08 of 25 delta on both sides)")
        em = spot * iv * math.sqrt(dte / 365)
        lines.append(f"Expected move to {exp[5:]} ({dte}d, 1σ from ATM IV {iv:.1%}): ±{em:,.2f} "
                     f"(±{em / spot:.1%}) → {spot - em:,.2f} to {spot + em:,.2f}")
        wk = min(term, key=lambda t: t[0])
        legs = [r for r in by[wk[1]] if r["strike"] == wk[3] and r.get("bid") and r.get("ask")]
        if len({r["type"] for r in legs}) == 2:
            strad = sum((r["bid"] + r["ask"]) / 2 for r in legs)
            lines.append(f"Nearest expiry {wk[1][5:]} ({wk[0]}d) ATM {wk[3]:g} straddle mid {strad:,.2f} "
                         f"(±{strad / spot:.1%} of spot)")
    else:
        lines.append("Term structure / skew / expected move: UNAVAILABLE (no expiry with a usable ATM IV)")

    cv = sum(r.get("volume") or 0 for r in cons if r["type"] == "call")
    pv = sum(r.get("volume") or 0 for r in cons if r["type"] == "put")
    co = sum(r.get("open_interest") or 0 for r in cons if r["type"] == "call")
    po = sum(r.get("open_interest") or 0 for r in cons if r["type"] == "put")
    lines.append(f"Put/call: volume {f'{pv / cv:.2f}' if cv else 'UNAVAILABLE'} · open interest "
                 f"{f'{po / co:.2f}' if co else 'UNAVAILABLE'} (whole chain)")
    lines.append("_Computed from the CBOE delayed chain (15+ min delayed; prior session outside market hours). "
                 "No AI. Advisory only, no proven edge, no size._")
    return "\n".join(lines)


if __name__ == "__main__":
    print(report(sys.argv[1] if len(sys.argv) > 1 else "SPY"))
