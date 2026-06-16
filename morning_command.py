#!/usr/bin/env python3
"""morning_command.py — ONE composed pre-open brief → #mission-control (8:15 ET).

Replaces the scattered pre-open posts (events / regime / X spread across macro-*
channels) with a single command-hub overview, built mostly from the deterministic
modules we already have so it's grounded and cheap:

  • Tape       — SPY/QQQ/VIX (flow_picks_post._tape, yfinance)
  • Your book  — lib.portfolio.portfolio_summary() (paper + real-money crypto)
  • X read     — lib.x_search.x_sentiment() on your top holdings (native Grok sub)
  • Flow setup — top bullish near-money names from current flow (read-only, NO logging)
  • Today+orders — ONE short lib.llm.call_llm(..., ["claude_oauth","deepseek"]) for
                   scheduled catalysts + a single game-plan line sized to the $800 cap

Subscription/OAuth-billed. Never touches the signal stream. Run with ~/.venv/bin/python.

  morning_command.py            # post to #mission-control
  morning_command.py --print    # compose + print only
  morning_command.py --telegram # also mirror via the fleet's daily_briefs route (best-effort)
"""
from __future__ import annotations

import argparse
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from skill_to_discord import post, resolve_channel  # noqa: E402
from lib.portfolio import portfolio_summary, top_tickers_str  # noqa: E402
from lib import x_search  # noqa: E402
from lib.llm import call_llm  # noqa: E402
from lib.heartbeat import beat  # noqa: E402
from lib.notify import tg_brief  # noqa: E402
from flow_picks_post import (  # noqa: E402  (read-only helpers — these do NOT log picks)
    _load, _score, _spot, _moneyness, _fmt, MAX_MNY, DTE_MIN, DTE_MAX, RISK_CAP, _tape,
)

ET = ZoneInfo("America/New_York")


def _flow_setup(n: int = 2):
    """Top-N bullish, near-money swing names from the CURRENT flow files. Read-only —
    deliberately does not call _log_picks (the scorecard is fed by flow_picks_post)."""
    merged = _load()
    if not merged:
        return []
    scored = sorted(((_score(a), a) for a in merged.values()), key=lambda x: -x[0][0])
    out, used = [], set()
    for (s, fv, voi, dte), a in scored:
        if not (DTE_MIN <= dte <= DTE_MAX):
            continue
        sym = str(a.get("Symbol", "")).upper()
        if sym in used:
            continue
        is_call = str(a.get("OptionType", "")).upper().startswith("C")
        if not (a.get("isBullish") and is_call):
            continue
        sp = _spot(a.get("Symbol"))
        if not sp:
            continue
        otm, _ = _moneyness(a, sp)
        if otm is None or abs(otm) > MAX_MNY:
            continue
        out.append(f"• **{_fmt(a)}** — ${fv:,.0f}, V/OI {voi:.1f}")
        used.add(sym)
        if len(out) >= n:
            break
    return out


def _catalysts_and_orders(names: str, tape: str) -> tuple[str, str]:
    """ONE subscription-billed call for today's scheduled catalysts + a single game-plan
    line. Conservative prompt (don't invent events). Degrades to deterministic text."""
    today = datetime.now(ET).strftime("%A %B %-d, %Y")
    prompt = (
        f"You are a pre-open trading desk analyst. Today is {today} (US Eastern).\n"
        f"Operator's holdings: {names}\n"
        f"Premarket tape: {tape or 'n/a'}\n\n"
        "Return STRICT JSON, no prose outside it:\n"
        '{"catalysts": "<=2 sentences on TODAY\'s scheduled US market catalysts you are '
        "confident about (FOMC/CPI/PPI/jobs/major single-name earnings). If you are not sure "
        'anything major is scheduled, say \\"No major scheduled macro catalysts today.\\"", '
        '"orders": "ONE concrete, actionable line: the single highest-conviction game plan for '
        "the day given the book. Position sizing is capped at $800 risk per trade (a fraction of "
        'equity), paper accounts. Be specific."}'
    )
    res = call_llm(prompt, ["claude_oauth", "deepseek"])
    if res.get("ok"):
        r = res["response"]
        cat = str(r.get("catalysts", "")).strip()
        orders = str(r.get("orders", "")).strip()
        if cat or orders:
            return cat, orders
    return ("Catalyst read unavailable — check the economic calendar.",
            f"Trade your plan; cap risk at ${RISK_CAP} per name (fraction of equity), paper-first.")


def build() -> str:
    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    names = top_tickers_str(6)
    tape = _tape()
    lines = [f"🌅 **MORNING COMMAND — pre-open brief** · {stamp}"]
    if tape:
        lines.append(f"_Tape: {tape}_")

    lines.append("\n" + portfolio_summary())

    # native Grok X read on your names (sub-billed); silent-degrade if no token / fail
    xs = x_search.x_sentiment(f"my holdings ({names}) and the broad market", timeout=40)
    if xs:
        lines.append("\n📡 **X SENTIMENT (your names):**\n" + xs.strip())

    flow = _flow_setup(2)
    lines.append("\n🎯 **FLOW SETUP:**")
    if flow:
        lines += flow
    else:
        lines.append("• No fresh near-money flow yet — first live picks post 9:50 AM ET.")

    cat, orders = _catalysts_and_orders(names, tape)
    lines.append(f"\n📅 **TODAY:** {cat}")
    lines.append(f"📋 **ORDERS:** {orders}")

    lines.append(f"\n_One overview · specifics land in #flow-picks · risk cap ${RISK_CAP}/trade · auto-posted 8:15 ET._")
    return "\n".join(lines)


def _mirror_telegram(text: str) -> None:
    """Mirror to Mike's phone via lib.notify (daily_briefs → flow_digest fallback).
    Best-effort; auto-upgrades to a dedicated briefs bot once its token is set."""
    used = tg_brief(text)
    print(f"[morning] telegram mirror -> {used}" if used
          else "[morning] telegram mirror skipped (no live briefs bot)", flush=True)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="mission-control")
    ap.add_argument("--print", action="store_true", dest="print_only")
    ap.add_argument("--telegram", action="store_true", help="also mirror via fleet daily_briefs")
    a = ap.parse_args()
    msg = build()
    if a.print_only:
        print(msg)
        return
    post(resolve_channel(a.channel), msg)
    _post_market_dashboard(a.channel)
    if a.telegram:
        _mirror_telegram(msg)
    beat("morning_command")
    print(f"[morning] posted ({len(msg)} chars)", flush=True)


def _post_market_dashboard(channel_name: str) -> None:
    """Attach the visual market dashboard image (tiles + regime dial) above the brief.
    Posted AS SynthControl; never raises."""
    try:
        import sys as _s
        from pathlib import Path as _P
        _s.path.insert(0, str(_P(__file__).resolve().parent))
        from lib import ops_card as oc, chart_renderer as cr, regime as rl
        tok = (_P.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token").read_text().strip()
        cid = oc.resolve_channel("1486025777970548908", tok, channel_name)
        if not cid:
            return
        r = rl.regime()
        tiles = []
        for sym, lbl in (("SPY", "SPY"), ("QQQ", "QQQ"), ("^VIX", "VIX")):
            df = cr.ohlc(sym, days=15, interval="1d")
            if df is None or len(df) < 2:
                continue
            price = float(df["Close"].iloc[-1]); prev = float(df["Close"].iloc[-2])
            tiles.append({"ticker": lbl, "price": price,
                          "chg": (price - prev) / prev * 100 if prev else 0.0,
                          "series": list(df["Close"].values[-20:])})
        score = {"RISK-ON": 8, "NEUTRAL": 5, "RISK-OFF": 2}.get(r.get("state"), 5)
        color = {"RISK-ON": cr.PAL["up"], "RISK-OFF": cr.PAL["down"]}.get(r.get("state"), cr.PAL["neutral"])
        png = cr.market_card({"title": "PRE-MARKET DASHBOARD", "tiles": tiles,
                              "regime": {"label": r.get("label", ""), "score": score, "color": color}})
        if png and oc.post_image_bot(cid, tok, png, content="🛰️ pre-market dashboard"):
            print("[morning] market dashboard posted", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[morning] dashboard err: {e}", flush=True)


if __name__ == "__main__":
    main()
