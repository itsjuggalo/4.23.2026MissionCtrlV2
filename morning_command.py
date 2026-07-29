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
                   scheduled catalysts + a single game-plan line sized to the min($400, 15%) cap

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
from lib.news import headlines_block  # noqa: E402
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
        f"the day given the book. Position sizing is capped at ${RISK_CAP} risk per trade — this "
        "is a HARD cap, never suggest a size above it, and if the named play cannot be expressed "
        'under it, say so. Paper accounts. Be specific."}'
    )
    res = call_llm(prompt, ["claude_oauth", "claude_cli", "grok_oauth"])
    if res.get("ok"):
        r = res["response"]
        cat = str(r.get("catalysts", "")).strip()
        orders = str(r.get("orders", "")).strip()
        if cat or orders:
            return cat, orders
    return ("Catalyst read unavailable — check the economic calendar.",
            f"Trade your plan; cap risk at ${RISK_CAP} per name (fraction of equity), paper-first.")


def _polymarket_line() -> str:
    """Optional macro crowd-odds one-liner for the top of the brief. Fully guarded —
    a fetch failure or missing module degrades to '' so it can NEVER break the brief."""
    try:
        from polymarket_macro_odds import one_liner
        return one_liner(3) or ""
    except Exception:
        return ""


def build() -> str:
    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    names = top_tickers_str(6)
    tape = _tape()
    lines = [f"🌅 **MORNING COMMAND — pre-open brief** · {stamp}"]
    if tape:
        lines.append(f"_Tape: {tape}_")

    pm = _polymarket_line()
    if pm:
        lines.append(f"🎰 **POLYMARKET (crowd odds):** {pm}")

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

    # real overnight/pre-open headlines on your names (best-effort; "" if none)
    try:
        news = headlines_block(names, title="📰 **HEADLINES (last 24h):**", max_items=4)
        if news:
            lines.append("\n" + news)
    except Exception:
        pass

    lines.append(f"\n_One overview · specifics land in #flow-picks · risk cap ${RISK_CAP}/trade · auto-posted 8:15 ET._")
    return "\n".join(lines)


# --------------------------------------------------------------------------- phone brief
# 2026-07-29: Mike was getting FIVE pre-open briefs (7:00 X digest, 7:15 AInvest, 8:15 this
# one, 9:00 MasterMC, 9:15 flow pre-market) carrying the same headlines and tape read, all
# written in desk shorthand. They are now ONE message on Trading Command, and the phone copy
# is written for a beginner: what happened, what he owns, the ONE thing to watch, and what
# would actually make him act. The Discord post (build()) is unchanged — that's the desk copy.
BEST_CONTRACTS = Path("/AIWorkWSL/labs/quantum/out/best_contracts.json")


def _tape_read(tape: str) -> str:
    """Translate the tape into one sentence a beginner can act on. VIX LEVEL alone lies —
    a 19 VIX that just jumped 9% while SPY is down 1% is not a calm tape."""
    try:
        spy_chg = float(tape.split("SPY ")[1].split("(")[1].split("%")[0])
        vix_part = tape.split("VIX ")[1]
        vix = float(vix_part.split(" ")[0])
        vix_chg = float(vix_part.split("(")[1].split("%")[0])
    except Exception:
        return ""
    if vix >= 25 or vix_chg >= 15:
        return "Fear is spiking — moves will be violent both ways. Smallest size or sit out."
    if spy_chg <= -0.7 or vix_chg >= 5:
        return "Selling pressure this morning. Wait for it to stop falling before buying dips."
    if spy_chg >= 0.7:
        return "Strong open. Chasing green candles is where beginners lose — wait for a pullback."
    return "Quiet tape — nothing is forcing a trade today."


def _book_line() -> str:
    """'You own: $5,130 total · biggest position ETH $1,363'. Never raises."""
    try:
        from lib.portfolio import equity_day_pnl, real_money_holdings
        paper, day = equity_day_pnl()
        crypto = real_money_holdings()
        total = paper + sum(crypto.values())
        if not total:
            return ""
        line = f"💼 You own: ${total:,.0f}"
        if day:
            line += f" ({day:+,.0f} yesterday)"
        if crypto:
            sym, val = max(crypto.items(), key=lambda x: x[1])
            line += f" · biggest is {sym} at ${val:,.0f}"
        return line
    except Exception:
        return ""


def _one_contract_line() -> str:
    """The single best-graded option idea, in plain English with the dollar cost and the
    stop — folded in from the retired 9:00 MasterMC brief. Silent if stale or nothing
    cleared validation: no forced pick is better than a bad one."""
    try:
        import json
        from datetime import timedelta
        d = json.loads(BEST_CONTRACTS.read_text())
        picks = [p for p in (d.get("picks") or []) if str(p.get("action", "")).startswith("ACT")]
        if not picks:
            return ""
        as_of = datetime.fromisoformat(str(d.get("as_of", "")).replace("Z", "+00:00"))
        if as_of.tzinfo:
            as_of = as_of.astimezone(ET)
        if datetime.now(ET) - as_of > timedelta(hours=24):
            return ""                      # yesterday's price is not today's trade
        p = picks[0]
        if p.get("structure") == "spread":
            return ""                      # spreads need their own explainer, not a one-liner
        cost = int((p.get("per_contract") or 0) * (p.get("qty") or 0))
        if not cost or cost > RISK_CAP:
            return ""                      # can't afford it → it isn't an idea for this account
        kind = "call (a bet it goes UP)" if str(p.get("type", "")).lower().startswith("c") \
            else "put (a bet it goes DOWN)"
        try:
            days = (datetime.fromisoformat(p["expiry"]).date() - now_et().date()).days
            window = f", you have {days} days" if days < 60 else f", it runs {days // 30} months"
        except Exception:
            window = ""
        n = p.get("qty") or 1
        return (f"📈 If you take one trade: {p['ticker']} ${p['strike']:g} {kind} "
                f"expiring {p['expiry']}{window} — {n} contract{'s' if n != 1 else ''} = ${cost} "
                f"total, and that ${cost} is the most you can lose. Cut it if it's down half. "
                f"(priced at yesterday's close — check the real price before you buy)")
    except Exception:
        return ""


def build_phone() -> str:
    """The beginner-facing pre-open brief. First line is the answer, every number gets a
    'so what', and it ends with an action or an explicit 'do nothing'."""
    now = datetime.now(ET)
    tape = _tape()
    lines = [f"☀️ TODAY — {now:%a %b %-d}"]

    if tape:
        lines.append(f"📊 {tape}" + (f"\n   {_tape_read(tape)}" if _tape_read(tape) else ""))

    book = _book_line()
    if book:
        lines.append(book)

    cat, orders = _catalysts_and_orders(top_tickers_str(6), tape)
    if cat:
        lines.append(f"⚠️ The one thing today: {cat}")
    if orders:
        lines.append(f"👉 Plan: {orders}")

    one = _one_contract_line()
    if one:
        lines.append(one)

    lines.append(f"🛡️ Never risk more than ${RISK_CAP} on a single trade. "
                 "If nothing here fits, doing nothing is a valid day.")
    return "\n\n".join(lines)


def _mirror_telegram(_discord_text: str) -> None:
    """Send the BEGINNER copy to Trading Command — the 'what do I do right now' lane.
    Falls back down the old chain if that bot is unreachable. Never raises."""
    from lib.notify import tg_push
    text = build_phone()
    # html=False: the catalyst/orders lines come from an LLM and a stray '<' would make
    # Telegram reject the whole message with a parse error (silent missed brief).
    if tg_push(text, "trading_command", loud=True, html=False):
        print("[morning] phone brief -> trading_command", flush=True)
        return
    used = tg_brief(text)
    print(f"[morning] phone brief -> {used}" if used
          else "[morning] phone brief NOT sent (no live bot)", flush=True)


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
