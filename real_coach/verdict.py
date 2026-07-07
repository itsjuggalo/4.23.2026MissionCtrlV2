"""verdict.py — the coach brain: one REAL holding in → verdict + detailed reasoning out.

Rules ported from labs/quantum/src/portfolio_manage.py (assess/exit_plan shapes) and
trading/daemons/trail_daemon.py tiers, re-parameterized for real RH/CB stocks+crypto and
downgraded to ADVISORY (levels + words, never orders). Core+satellite doctrine per Mike
(2026-07-07): core = long-term conviction, TRIM/SELL needs ≥2 bearish TA factors AND
price under EMA50 (the anti-"sold-LLY-early" rule); satellite = fast money, tight stops,
tiered trims. Deep-red bags (≤−50%) follow the cb_rh_crypto_watch doctrine: exit dead
bags INTO STRENGTH, not at the low — unless TA shows a genuine recovery base forming.
Every verdict carries reasons[] with real numbers (Mike's discipline mode: explain in
detail, no bare labels).

Verdicts: HOLD ✅ · ADD ➕ · TRIM ✂️ · EXIT_ON_BOUNCE 🏃 · SWEEP 🧹 · TRIAGE 👀
(EXIT only ever arrives via a stop-breach alert in alerts.py — the sweep itself never
screams SELL-NOW into an illiquid low.)
"""
from __future__ import annotations

import json
import sys
import time
from pathlib import Path

SCRIPTS = Path(__file__).resolve().parent.parent  # 05_AUTOMATION/scripts
sys.path.insert(0, str(SCRIPTS))

from ta_engine.verdict import analyze  # noqa: E402
from real_coach import symbols as symmod  # noqa: E402
from real_coach import book as bookmod  # noqa: E402

ICON = {"HOLD": "✅", "ADD": "➕", "TRIM": "✂️", "EXIT": "🛑",
        "EXIT_ON_BOUNCE": "🏃", "SWEEP": "🧹", "TRIAGE": "👀"}

FUND_CACHE = Path.home() / "portfolio" / ".coach_fund_cache.json"
FUND_TTL = 24 * 3600


# ── fundamentals-lite (stocks only, cached 24h, fail-open) ─────────────────────
def fundamentals(sym: str) -> dict:
    cache = {}
    try:
        cache = json.loads(FUND_CACHE.read_text())
    except Exception:
        pass
    rec = cache.get(sym)
    if rec and (time.time() - rec.get("at", 0)) < FUND_TTL:
        return rec
    out = {"at": time.time()}
    try:
        import yfinance as yf
        t = yf.Ticker(sym)
        info = t.info or {}
        out["target"] = info.get("targetMeanPrice")
        out["rec"] = info.get("recommendationKey")
        try:
            cal = t.calendar
            ed = (cal or {}).get("Earnings Date")
            if ed:
                out["earnings"] = str(ed[0] if isinstance(ed, (list, tuple)) else ed)[:10]
        except Exception:
            pass
    except Exception:
        pass
    cache[sym] = out
    try:
        bookmod.atomic_write(FUND_CACHE, cache)
    except Exception:
        pass
    return out


def _factor_counts(ta: dict) -> tuple[list[str], list[str]]:
    """(bearish, bullish) factor-name lists from direction-aligned votes (side=long)."""
    votes = ta.get("votes", {})
    bear = [k for k, v in votes.items() if v < 0]
    bull = [k for k, v in votes.items() if v > 0]
    return bear, bull


def _fmt(x, nd=2):
    if x is None:
        return "?"
    return f"{x:,.{nd}f}" if isinstance(x, (int, float)) else str(x)


def assess_position(p: dict, cfg: dict, state: dict, invested: float,
                    with_fundamentals: bool = True) -> dict:
    """Verdict record for one book position. Never raises (returns TRIAGE on data failure)."""
    sym = p["symbol"].upper()
    ac = p["asset_class"]
    mv = float(p.get("mkt_value") or 0)
    qty = float(p.get("qty") or 0)
    pnl = p.get("unrealized_pct")  # may be None (basis missing until P1)
    pnl = float(pnl) if pnl is not None else None
    basis = p.get("cost_basis")
    conc = (mv / invested * 100) if invested else 0.0
    bucket = bookmod.bucket_of(sym, ac, cfg)
    rules = cfg["rules"]
    key = f"{p.get('broker','?')}:{sym}"

    rec = {"key": key, "symbol": sym, "broker": p.get("broker"), "asset_class": ac,
           "bucket": bucket, "mv": round(mv, 2), "qty": qty, "pnl_pct": pnl,
           "basis": basis, "conc_pct": round(conc, 1), "mode": "ta",
           "verdict": "HOLD", "reasons": [], "stop": None, "trail_stop": None,
           "target": None, "confidence": None, "current": None, "peak": None}

    # ── dust → one grouped SWEEP line, no TA spend ──
    if p.get("dust") or mv < float(cfg.get("dust_max_usd", 5)):
        rec.update(mode="dust", verdict="SWEEP",
                   reasons=[f"${mv:.2f} position — too small to matter; sweep to cash and "
                            f"free the mental slot" + (f" (down {pnl:.0f}%, the loss already happened)"
                                                       if pnl is not None and pnl < 0 else "")])
        return rec

    # ── TA fetch (honest degrade to triage) ──
    ta = None
    tsym = symmod.ta_symbol(sym, ac)
    try:
        ta = analyze(tsym, side="long", asset_type=ac, period="1y")
        if ta.get("error"):
            ta = None
    except Exception:
        ta = None

    if ta is None:
        cg = symmod.cg_prices([sym]).get(sym, {}) if ac == "crypto" else {}
        chg = cg.get("usd_24h_change")
        rec.update(mode="triage", verdict="TRIAGE", current=cg.get("usd"),
                   reasons=[f"no usable candle history for {tsym} — price-only triage"
                            + (f"; 24h {chg:+.1f}%" if isinstance(chg, (int, float)) else ""),
                            f"value ${mv:.2f}" + (f", basis ${basis:,.0f} ({pnl:+.0f}%)"
                                                  if basis and pnl is not None else ", basis unknown (P1 fills vault will recover it)")])
        if pnl is not None and pnl <= rules["dead_bag_pnl_pct"]:
            rec["verdict"] = "EXIT_ON_BOUNCE"
            rec["reasons"].append(f"down {pnl:.0f}% — dead bag: sell the next strong pop, "
                                  "don't add hope")
        return rec

    cur = float(ta["current"])
    ind = ta["indicators"]
    lv = ta["levels"]
    ema20, ema50 = ind.get("ema20"), ind.get("ema50")
    atr = ind.get("atr14")
    rsi = ta.get("rsi")
    bear, bull = _factor_counts(ta)
    peak = bookmod.peak_update(state, key, cur)
    supports = lv.get("supports") or []
    resistances = lv.get("resistances") or []
    nearest_sup = supports[-1] if supports else None
    nearest_res = resistances[0] if resistances else None
    swing_low, swing_high = lv.get("swing_low"), lv.get("swing_high")

    rec.update(current=cur, peak=round(peak, 4), confidence=ta["confidence"],
               trend=ta["trend"], rsi=rsi, signal_type=ta["signal_type"],
               ta_read=ta["ta_read"],
               levels={"support": nearest_sup, "resistance": nearest_res,
                       "swing_low": swing_low, "swing_high": swing_high,
                       "ema20": ema20, "ema50": ema50, "atr": atr})

    # structural stop: below support/swing-low, never tighter than 1.5 ATR noise band
    ta_stop = None
    cands = [x for x in (nearest_sup, swing_low) if x and x < cur]
    if cands:
        ta_stop = max(cands)
    if atr:
        ta_stop = max(ta_stop or 0, cur - 1.5 * atr) if ta_stop else cur - 1.5 * atr
    reasons = []
    fund_bits = []
    if with_fundamentals and ac == "stock":
        f = fundamentals(sym)
        if f.get("target"):
            updown = (f["target"] / cur - 1) * 100 if cur else 0
            fund_bits.append(f"analysts: {f.get('rec') or '?'} · target ${_fmt(f['target'])} "
                             f"({updown:+.0f}% vs now)")
        if f.get("earnings"):
            fund_bits.append(f"earnings ~{f['earnings']} (event risk window)")

    pnl_txt = f"{pnl:+.0f}%" if pnl is not None else "P&L unknown (basis lands in P1)"

    # ── CORE: protect the thesis, don't get shaken out (anti-sold-LLY rule) ──
    if bucket == "core":
        trail = round(peak * (1 - rules["core_trail_pct"] / 100.0), 4)
        thesis_broken = len(bear) >= rules["core_bear_factors_req"] and ema50 and cur < ema50
        if thesis_broken:
            rec["verdict"] = "TRIM"
            reasons.append(f"CORE thesis cracking — {len(bear)} bearish factors "
                           f"({', '.join(bear)}) AND price ${_fmt(cur)} below EMA50 ${_fmt(ema50)}")
            reasons.append(f"trim half, keep the rest with a hard line at swing low ${_fmt(swing_low)}")
        else:
            rec["verdict"] = "HOLD"
            reasons.append(f"CORE hold — trend {ta['trend']}, {len(bull)} bullish vs {len(bear)} "
                           f"bearish factors; do NOT sell strength early")
            reasons.append(f"let it run; trail alert {rules['core_trail_pct']}% below peak "
                           f"(${_fmt(trail)}); thesis line = EMA50 ${_fmt(ema50)}")
            if ta["signal_type"] == "pullback" and rsi is not None and 38 <= rsi <= 55:
                reasons.append(f"pullback-in-uptrend (RSI {rsi:.0f}) — this is an ADD zone, "
                               f"not a sell zone")
        rec["trail_stop"] = trail
        rec["stop"] = round(ta_stop, 4) if ta_stop else None
        rec["target"] = swing_high or nearest_res

    # ── SATELLITE: fast money, tight rules ──
    else:
        trail_pct = rules["satellite_trail_pct"]
        trail = round(peak * (1 - trail_pct / 100.0), 4)
        hard = round(cur * (1 - rules["satellite_hard_stop_pct"] / 100.0), 4)
        stop = round(max(ta_stop, hard) if ta_stop else hard, 4)

        if pnl is not None and pnl <= rules["dead_bag_pnl_pct"]:
            recovering = len(bull) >= 2 and ema20 and cur > ema20
            if recovering:
                rec["verdict"] = "HOLD"
                reasons.append(f"down {pnl:.0f}% BUT a real base is forming — "
                               f"{', '.join(bull)} bullish; price reclaimed EMA20 ${_fmt(ema20)}")
                reasons.append(f"recovery play: hold with hard line at swing low ${_fmt(swing_low)}; "
                               f"sell HALF into ${_fmt(nearest_res)} resistance to de-risk")
            else:
                rec["verdict"] = "EXIT_ON_BOUNCE"
                reasons.append(f"down {pnl:.0f}% and TA still {ta['trend']} "
                               f"({len(bear)} bearish: {', '.join(bear) or 'weak everything'}) — dead bag")
                reasons.append(f"do NOT market-dump the low: set the exit at the next pop toward "
                               f"${_fmt(nearest_res)}; final floor = close below ${_fmt(swing_low)} → out")
            rec["stop"] = round(swing_low, 4) if swing_low else stop
            rec["target"] = nearest_res
        elif pnl is not None and pnl >= rules["trim_gain_pct"]:
            rec["verdict"] = "TRIM"
            reasons.append(f"up {pnl:+.0f}% — lock half (pay yourself), ride the rest")
            reasons.append(f"runner keeps a {rules['trim_trail_pct']}% trail below peak "
                           f"${_fmt(peak)} → stop ${_fmt(round(peak * (1 - rules['trim_trail_pct']/100.0), 4))}")
            rec["trail_stop"] = round(peak * (1 - rules["trim_trail_pct"] / 100.0), 4)
            rec["stop"] = stop
            rec["target"] = swing_high or nearest_res
        elif conc > rules["concentration_pct"]:
            rec["verdict"] = "TRIM"
            reasons.append(f"{conc:.0f}% of the whole book in one name — concentration risk; "
                           f"trim back under {rules['concentration_pct']}%")
            rec["stop"] = stop
        elif ta["trend"] == "bearish" and len(bear) >= 3 and (pnl is None or pnl < 0):
            rec["verdict"] = "TRIM"
            reasons.append(f"{pnl_txt}, trend bearish with {len(bear)} bearish factors "
                           f"({', '.join(bear)}) — reduce BEFORE it becomes a dead bag")
            reasons.append(f"hard rule from your history: losers get cut at stop ${_fmt(stop)}, "
                           f"not held to −50%")
            rec["stop"] = stop
        elif (ta["trend"] == "bullish" and ta["signal_type"] == "pullback"
              and rsi is not None and 40 <= rsi <= 55 and (pnl is None or pnl >= -5)
              and conc < 15):
            rec["verdict"] = "ADD"
            reasons.append(f"uptrend pullback — RSI {rsi:.0f}, price near EMA20 ${_fmt(ema20)}: "
                           f"textbook add-the-dip zone (small, planned — not FOMO)")
            reasons.append(f"add only with stop set FIRST: ${_fmt(stop)} "
                           f"(below {'support' if nearest_sup else '1.5×ATR'})")
            rec["stop"] = stop
            rec["target"] = swing_high or nearest_res
        else:
            rec["verdict"] = "HOLD"
            reasons.append(f"{pnl_txt} · trend {ta['trend']}, confidence {ta['confidence']}/100 — "
                           f"no action edge; keep the stop honest at ${_fmt(stop)}")
            rec["stop"] = stop
            rec["target"] = swing_high or nearest_res
        if pnl is not None and pnl >= 25:
            rec["trail_stop"] = rec.get("trail_stop") or trail
            reasons.append(f"winner protection armed: trail {trail_pct}% below peak ${_fmt(peak)} "
                           f"→ ${_fmt(trail)} (ratchets up, never down)")

    reasons.append(f"TA: {ta['ta_read']}")
    reasons.extend(fund_bits)
    rec["reasons"] = reasons
    return rec
