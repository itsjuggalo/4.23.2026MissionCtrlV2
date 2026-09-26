#!/usr/bin/env python3
"""morning_command.py — ONE composed pre-open brief → #mission-control (8:15 ET).

Replaces the scattered pre-open posts (events / regime / X spread across macro-*
channels) with a single command-hub overview, built mostly from the deterministic
modules we already have so it's grounded and cheap:

  • Tape       — SPY/QQQ/VIX (flow_picks_post._tape, yfinance)
  • X read     — lib.x_search.x_sentiment() on your watchlist + relay tickers (native Grok sub)
  • Flow setup — top bullish near-money names from current flow (read-only, NO logging)
  • Today+orders — ONE short lib.llm.call_llm(..., ["claude_oauth","deepseek"]) for
                   scheduled catalysts + a single game-plan line, flat $400 cap

2026-09-15: dropped the PORTFOLIO/book block (lib.portfolio.portfolio_summary(),
Alpaca paper + RH/Coinbase real-money) — doctrine retirement (2026-08-11 Alpaca,
2026-09-12 portfolio views). Ticker context now comes from the watchlist +
Firebase relay signals, never Alpaca-held positions. See docs/audits/
telegram-sweep-2026-09-15/trade-lanes.md Lane 1/2.

Subscription/OAuth-billed. Never touches the signal stream. Run with ~/.venv/bin/python.

  morning_command.py            # post to #mission-control
  morning_command.py --print    # compose + print only
  morning_command.py --telegram # also mirror via the fleet's daily_briefs route (best-effort)
"""
from __future__ import annotations

import argparse
import json
import os
import sys
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from skill_to_discord import post, resolve_channel  # noqa: E402
from lib.portfolio import get_watchlist  # noqa: E402
from lib import x_search  # noqa: E402
from lib.llm import call_llm  # noqa: E402
from lib.heartbeat import beat  # noqa: E402
from lib.notify import tg_brief  # noqa: E402
from lib.news import headlines_block  # noqa: E402
from tg_format import hdr, section, row, esc, b, footer  # noqa: E402  (2026-09-15 format sweep, phone copy only)
from flow_picks_post import (  # noqa: E402  (read-only helpers — these do NOT log picks)
    _load, _score, _spot, _moneyness, _fmt, MAX_MNY, DTE_MIN, DTE_MAX, RISK_CAP, _tape,
)

ET = ZoneInfo("America/New_York")
FIREBASE_RELAY_URL = os.environ.get("FIREBASE_RELAY_URL", "http://localhost:3000/api/firebase-relay")


def _relay_tickers(n: int = 6) -> list[str]:
    """Watchlist + live Firebase-relay signal tickers, padded with index defaults.
    Replaces the retired Alpaca/RH-derived 'holdings' ticker list (2026-08-11 +
    2026-09-12 doctrine) — this is names Mike is watching or the flow relay is
    actively flagging, never a portfolio position. Best-effort: relay unreachable
    degrades to watchlist + defaults only, never raises."""
    import urllib.request
    syms = list(get_watchlist())
    try:
        req = urllib.request.Request(FIREBASE_RELAY_URL, headers={"User-Agent": "mc-morning/1.0"})
        with urllib.request.urlopen(req, timeout=8) as r:
            data = json.loads(r.read())
        for sig in (data.get("signals") or []):
            t = str(sig.get("ticker", "")).upper().strip()
            if t and t not in syms:
                syms.append(t)
    except Exception:
        pass
    for d in ("SPY", "QQQ", "NVDA"):
        if d not in syms:
            syms.append(d)
    return syms[:n] if syms else ["SPY", "QQQ", "NVDA"][:n]


def _relay_tickers_str(n: int = 6) -> str:
    return ", ".join(_relay_tickers(n))


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


def _catalysts_and_orders(names: str, tape: str) -> tuple[str, str, dict]:
    """ONE subscription-billed call for today's scheduled catalysts + a single game-plan
    line. Conservative prompt (don't invent events). Degrades to deterministic text.

    Also asks for the plan as STRUCTURED NUMBERS (`plan`), because the prose version came
    back as one run-on sentence — "Buy QQQ at 666-668 targeting 675-678 bounce, risk $350
    (~15 shares, stop 664), thesis being…" — which buries the entry, the stop and the
    target in a clause each. The desk copy still gets the sentence; the phone brief renders
    the numbers as separate orders. (2026-07-29)
    """
    today = datetime.now(ET).strftime("%A %B %-d, %Y")
    prompt = (
        f"You are a pre-open trading desk analyst. Today is {today} (US Eastern).\n"
        f"Operator's watchlist: {names}\n"
        f"Premarket tape: {tape or 'n/a'}\n\n"
        "The reader is a BEGINNER trader. Return STRICT JSON, no prose outside it:\n"
        '{"catalysts": "<=2 sentences on TODAY\'s scheduled US market catalysts you are '
        "confident about (FOMC/CPI/PPI/jobs/major single-name earnings). If you are not sure "
        'anything major is scheduled, say \\"No major scheduled macro catalysts today.\\"", '
        '"orders": "ONE concrete, actionable line: the single highest-conviction game plan for '
        f"the day. Position sizing is capped at ${RISK_CAP} risk per trade — this "
        "is a HARD cap, never suggest a size above it, and if the named play cannot be expressed "
        'under it, say so. Real money (Robinhood/Coinbase). Be specific.", '
        '"plan": {"ticker": "<symbol>", "direction": "BUY", "entry": <single number, not a '
        'range>, "stop": <single number, below entry>, "target": <single number, above entry>, '
        '"shares": <integer>, "why": "<one short clause>"}}\n'
        "The `plan` object must describe the SAME trade as `orders`, with one exact price "
        "per field — never a range, never a null when you named a trade. target must be at "
        "least as far from entry as stop is, so the win is worth the risk. If today's honest "
        "answer is to do nothing, set plan to null."
    )
    res = call_llm(prompt, ["claude_oauth", "claude_cli", "grok_oauth"])
    if res.get("ok"):
        r = res["response"]
        cat = str(r.get("catalysts", "")).strip()
        orders = str(r.get("orders", "")).strip()
        plan = r.get("plan") if isinstance(r.get("plan"), dict) else {}
        if cat or orders:
            return cat, orders, plan
    return ("Catalyst read unavailable — check the economic calendar.",
            f"Trade your plan; cap risk at ${RISK_CAP} per name — flat $400 cap, Mike decides.",
            {})


def _plan_orders(plan: dict) -> str:
    """Render the LLM's structured plan as the same three numbered orders every other card
    in the fleet uses. Returns '' unless entry/stop/target are all present AND ordered
    correctly — a half-plan is worse than the prose sentence, and a target below the entry
    (or a stop above it) is a hallucinated plan that would cost real money."""
    try:
        tkr = str(plan.get("ticker") or "").strip().upper()
        entry, stop, targ = (float(plan[k]) for k in ("entry", "stop", "target"))
        sh = int(plan.get("shares") or 0)
    except (TypeError, ValueError, KeyError, AttributeError):
        return ""
    if not tkr or sh < 1 or not (stop < entry < targ):
        return ""
    risk, reward = sh * (entry - stop), sh * (targ - entry)
    if risk > RISK_CAP:                      # hard cap, fail-CLOSED — never print an over-cap size
        return ""
    # 2026-09-15: the equity-derived "half the book" notional check was dropped with
    # the portfolio-view retirement (2026-09-12) — no live holdings feed exists to
    # gate against. The flat $400 RISK_CAP above (loss, not notional) is the only
    # sizing rule now; Mike sizes/funds the trade himself.
    why = str(plan.get("why") or "").strip().rstrip(".")
    return (f"👉 <b>PLAN</b>{f' — {esc(why)}' if why else ''}\n"
            f"1) BUY {sh} {b(tkr)} at ${entry:g} — ${sh * entry:,.0f}.\n"
            f"2) SELL at ${stop:g} if it drops — lose ${risk:.0f}.\n"
            f"3) SELL at ${targ:g} if it works — make ${reward:.0f}.\n"
            f"Both sell orders go in the moment you're filled.")


def _polymarket_line() -> str:
    """Optional macro crowd-odds one-liner for the top of the brief. Fully guarded —
    a fetch failure or missing module degrades to '' so it can NEVER break the brief."""
    try:
        from polymarket_macro_odds import one_liner
        return one_liner(3) or ""
    except Exception:
        return ""


# --------------------------------------------------------------------------- catalyst read-through
# 2026-09-14: catalysts-core's factor_catalysts.py writes an advisory Form4/8-K/earnings/
# analyst propagation read to factors/catalysts.json (industry + sector + symbol composites,
# each carrying sources[] naming the driving ticker:event). Surfaced here read-only — never
# wired to a live cycle/sizing/gate, and `catalysts` is NOT in weights.json's market blend.
CATALYSTS_JSON = Path(os.environ.get(
    "CATALYSTS_JSON", str(Path.home() / ".openclaw" / "data" / "decision" / "factors" / "catalysts.json")))
CATALYST_MAX_AGE_H = 26          # producer runs every 1h; >26h means the cron is broken, not "no news"
CATALYST_MIN_SCORE = 0.15        # spec §4: only industries clearing ±0.15
CATALYST_MAX_ROWS = 3


def _load_catalysts() -> dict | None:
    """Read factors/catalysts.json (CATALYSTS_JSON env override, for tests/fixtures). Returns
    None if the file is missing or stale (>26h) — callers print nothing rather than a broken
    block, per spec §4."""
    try:
        data = json.loads(CATALYSTS_JSON.read_text())
    except Exception:
        return None
    try:
        as_of = datetime.fromisoformat(str(data.get("asOf", "")))
        if as_of.tzinfo is None:
            as_of = as_of.replace(tzinfo=ET)
        age_h = (datetime.now(ET) - as_of.astimezone(ET)).total_seconds() / 3600
        if age_h > CATALYST_MAX_AGE_H:
            return None
    except Exception:
        return None
    return data if isinstance(data, dict) else None


def _catalyst_top_industries(data: dict, n: int = CATALYST_MAX_ROWS):
    industries = data.get("industries") or {}
    rows = [(name, info) for name, info in industries.items()
            if isinstance(info, dict) and abs(float(info.get("score", 0) or 0)) >= CATALYST_MIN_SCORE]
    rows.sort(key=lambda kv: -abs(float(kv[1].get("score", 0) or 0)))
    return rows[:n]


def _catalyst_source_note(data: dict, info: dict) -> str:
    """Best driving-event note for an industry row. The industries block only carries
    'TICKER:EVENT_ID' ids in sources[] — the human-readable note lives on the source
    symbol's own signal entry in symbols{}."""
    symbols = data.get("symbols") or {}
    for src in (info.get("sources") or []):
        tkr, _, ev = str(src).partition(":")
        sym = symbols.get(tkr) or {}
        for sig in (sym.get("signals") or []):
            if sig.get("name") == ev and sig.get("note"):
                return f"{tkr} {sig['note']}"
        if ev:
            return f"{tkr} {ev}"
    return "read-through"


def _catalyst_your_name_rows(data: dict):
    """Mike's watchlist + relay tickers (no index padding) that the factor actually scored."""
    try:
        mine = get_watchlist()
    except Exception:
        mine = []
    symbols = data.get("symbols") or {}
    rows = []
    for t in mine:
        s = symbols.get(str(t).upper())
        if not s:
            continue
        rows.append((str(t).upper(), float(s.get("score", 0) or 0), str(s.get("role", "peer"))))
    return rows


def _catalyst_block() -> str:
    """Desk-copy block for build(): industries clearing ±0.15 (max 3) + Mike's scored names."""
    data = _load_catalysts()
    if data is None:
        return ""
    top = _catalyst_top_industries(data)
    lines = ["\n🧭 **CATALYST READ-THROUGH** (Form 4 / 8-K / earnings / analysts, 45d decay):"]
    if not top:
        lines.append("• No sector read-through above ±0.15 today.")
    else:
        for name, info in top:
            score = float(info.get("score", 0) or 0)
            note = _catalyst_source_note(data, info)
            members = info.get("members")
            peers = (f" · {members} peers {'lifted' if score > 0 else 'pressured'}"
                     if members else "")
            lines.append(f"• {name} {score:+.2f} — {note}{peers}")
    rows = _catalyst_your_name_rows(data)
    if rows:
        names_line = " · ".join(f"{t} {s:+.2f} ({r})" for t, s, r in rows)
        lines.append(f"• Your names: {names_line}")
    return "\n".join(lines)


def _catalyst_phone_line() -> str:
    """One plain-English sentence for build_phone()."""
    data = _load_catalysts()
    if data is None:
        return ""
    top = _catalyst_top_industries(data, n=2)
    if not top:
        return "🧭 No sector read-through above ±0.15 today."
    parts = []
    for name, info in top:
        score = float(info.get("score", 0) or 0)
        word = "looks strong" if score > 0 else "looks soft"
        note = _catalyst_source_note(data, info)
        parts.append(f"{esc(name)} {word} ({esc(note)})")
    sentence = "; ".join(parts)
    rows = _catalyst_your_name_rows(data)
    actionable = [r for r in rows if abs(r[1]) >= CATALYST_MIN_SCORE]
    if actionable:
        tail = "Worth a look: " + ", ".join(f"{esc(t)} {s:+.2f}" for t, s, _ in actionable) + "."
    else:
        tail = "Nothing on your names needs action."
    return f"🧭 {sentence}. {tail}"


# --------------------------------------------------------------------------- structure vs sentiment
# 2026-09-15 (Mike, trader statement: "we focused on price structure and market reaction ...
# the market reflects expectations and capital flows, not just the data itself"). Two
# DETERMINISTIC blocks read straight off the pipeline JSON — no LLM, no network, never a
# sizing/gate input. Producers: pipeline/decision/rebound_setup.py (hourly market hours)
# and pipeline/decision/macro_reaction.py (07:00 / 09:05 / 16:40 ET).
REBOUND_JSON = Path(os.environ.get(
    "REBOUND_JSON", str(Path.home() / ".openclaw" / "data" / "decision" / "rebound_setup.json")))
MACRO_REACTION_JSON = Path(os.environ.get(
    "MACRO_REACTION_JSON", str(Path.home() / ".openclaw" / "data" / "decision" / "macro_reaction.json")))
REBOUND_MAX_AGE_H = 20           # last write is 16:48 the prior session; 8:15 brief is ~15.5h later
MACRO_MAX_AGE_H = 20             # 16:40 prior session -> 07:00 run should have refreshed; 20h = cron broken
REBOUND_MAX_ROWS = 4
_STATE_ORDER = {"triggered": 0, "momentum-on": 1, "held": 2, "level-tested": 3, "watching": 4, "expired": 5}


def _load_fresh_json(path: Path, max_age_h: float) -> dict | None:
    """Read a producer file; None if missing, unparseable, or older than max_age_h (a stale
    file means the cron is broken — printing it would be lying about 'today')."""
    try:
        data = json.loads(path.read_text())
        as_of = data.get("asOf")
        ts = float(as_of) / 1000.0 if isinstance(as_of, (int, float)) else datetime.fromisoformat(str(as_of)).timestamp()
        if (datetime.now(ET).timestamp() - ts) / 3600.0 > max_age_h:
            return None
        return data
    except Exception:
        return None


def _rebound_rows(data: dict, n: int = REBOUND_MAX_ROWS) -> list[dict]:
    """Best n setups: triggered first, then momentum-on / held, by score. Pure 'watching'
    names are skipped — a line that says nothing is happening is noise on a phone."""
    rows = [r for r in (data.get("symbols") or {}).values()
            if isinstance(r, dict) and r.get("state") not in (None, "watching", "expired")]
    rows.sort(key=lambda r: (_STATE_ORDER.get(r.get("state"), 9), -float(r.get("score") or 0)))
    return rows[:n]


def _structure_block() -> str:
    """Desk-copy block: one line per setup, straight from rebound_setup.json `read`."""
    data = _load_fresh_json(REBOUND_JSON, REBOUND_MAX_AGE_H)
    if data is None:
        return ""
    lines = ["\n🏗 **STRUCTURE VS SENTIMENT** (key level held + momentum, into negative sentiment):"]
    rows = _rebound_rows(data)
    if not rows:
        fg = (data.get("inputs") or {}).get("fearGreedLabel")
        lines.append(f"• No level-hold setups in play (F&G {fg or 'n/a'}). Watching {len(data.get('symbols') or {})} names.")
    else:
        for r in rows:
            lines.append(f"• {r.get('read')} · score {r.get('score')}/100")
    counts = data.get("counts") or {}
    if counts:
        lines.append(f"• States: {counts.get('triggered', 0)} triggered · {counts.get('momentum-on', 0)} momentum-on · "
                     f"{counts.get('held', 0)} held · {counts.get('level-tested', 0)} tested · {counts.get('watching', 0)} watching"
                     " · advisory, $400 cap, Mike decides")
    return "\n".join(lines)


def _structure_phone_line() -> str:
    data = _load_fresh_json(REBOUND_JSON, REBOUND_MAX_AGE_H)
    if data is None:
        return ""
    rows = _rebound_rows(data, n=2)
    trig = [r for r in rows if r.get("state") == "triggered"]
    if not trig:
        best = rows[0] if rows else None
        if best is None:
            return "🏗 No name has held a key level with momentum turning yet — sentiment is loud, structure is quiet."
        return (f"🏗 Closest structure setup: {esc(best.get('symbol'))} is {esc(best.get('state'))} "
                f"(score {best.get('score')}/100) — not a buy until momentum confirms.")
    parts = []
    for r in trig:
        opt = (r.get("option") or {}).get("label")
        parts.append(f"{esc(r.get('symbol'))} held its level and momentum turned" + (f" — {esc(opt)}" if opt else ""))
    return "🏗 Structure says: " + "; ".join(parts) + ". Advisory only — stop = level break."


def _rates_line() -> str:
    """2y / 10y / 10y-2y from the canonical normalized facts (T7.1). These are the same
    envelopes /api/intel/v1/rates serves to the dashboard, so Telegram and the UI can't
    disagree. Each value shows its own FRED as_of, and a non-EOD status is stated."""
    try:
        sys.path.insert(0, "/AIWorkWSL/web/missionctrl/pipeline")
        from decision.lib import intel_reader  # noqa: E402
        f = {x["key"]: x for x in intel_reader.read_domain("rates")["facts"]}
    except Exception:
        return ""
    t2, t10, sp = f.get("rates.us.t2y"), f.get("rates.us.t10y"), f.get("rates.us.spread_10y2y")
    ok = lambda x: x and x.get("value") is not None and x.get("status") in ("LIVE", "DELAYED", "EOD")  # noqa: E731
    if not (ok(t2) and ok(t10) and ok(sp)):
        return "• rates: 2y/10y facts UNAVAILABLE or STALE (see /api/intel/v1/rates)"
    flag = lambda x: "" if x["status"] == "EOD" else f" {x['status']}"  # noqa: E731
    return (f"• 2y {t2['value']:.2f}%{flag(t2)} · 10y {t10['value']:.2f}%{flag(t10)} "
            f"(FRED {t2['as_of']}) · 10y−2y {sp['value']:+.2f}{flag(sp)} (FRED {sp['as_of']})")


def _macro_block() -> str:
    """Desk-copy block: next release + countdown + last-3 reaction lines + the data-vs-flows read."""
    data = _load_fresh_json(MACRO_REACTION_JSON, MACRO_MAX_AGE_H)
    if data is None:
        return ""
    nxt = data.get("next") or {}
    lines = ["\n📅 **MACRO REACTION** (expectations vs what the tape actually did):"]
    if nxt:
        fc = nxt.get("forecast")
        also = nxt.get("alsoThatDay") or []
        head = f"• Next: {nxt.get('name')} {nxt.get('countdown')} ({str(nxt.get('at') or '')[:16].replace('T', ' ')} ET)"
        if fc is not None:
            head += f" · consensus {fc:+g}" if isinstance(fc, (int, float)) else f" · consensus {fc}"
        if also:
            head += f" · same day: {', '.join(also)}"
        lines.append(head)
        for ln in nxt.get("last3") or []:
            lines.append(f"  ↳ {ln}")
        roll = (nxt.get("rolling") or {}).get("read")
        if roll:
            lines.append(f"  ↳ {nxt.get('name')} pattern: {roll}")
    rates_line = _rates_line()
    if rates_line:
        lines.append(rates_line)
    dvf = (data.get("dataVsFlows") or {}).get("read")
    if dvf:
        lines.append(f"• Read: {dvf}")
    return "\n".join(lines)


def _macro_phone_line() -> str:
    data = _load_fresh_json(MACRO_REACTION_JSON, MACRO_MAX_AGE_H)
    if data is None:
        return ""
    nxt = data.get("next") or {}
    dvf = esc((data.get("dataVsFlows") or {}).get("read") or "")
    if not nxt:
        return f"📅 {dvf}" if dvf else ""
    roll = esc((nxt.get("rolling") or {}).get("read") or "")
    return f"📅 {esc(nxt.get('name'))} {esc(nxt.get('countdown'))}. Last 3 times: {roll}. {dvf}".strip()


# --------------------------------------------------------------------------- dark pool / relay / SNR
# 2026-09-15 spec §3 (docs/superpowers/specs/2026-09-15-telegram-lane-charter-design.md):
# three more deterministic, no-LLM read-throughs for the trading_command lane's 8:15
# brief. Each fails SOFT — an unreachable/empty endpoint is skipped with one log line,
# never a broken block. ADVISORY ONLY, never a sizing/gate input.
DARKPOOL_URL = os.environ.get("DARKPOOL_URL", "http://localhost:3000/api/darkpool")
DARKPOOL_RELAY_URL = os.environ.get("DARKPOOL_RELAY_URL", "http://localhost:3000/api/darkpool?view=relay")
NEWS_SNR_URL = os.environ.get("NEWS_SNR_URL", "http://localhost:3000/api/news-snr?min=65")
TELEGRAM_MAX_CHARS = 4096
RELAY_DP_TAGS = {"corroborated": 0, "conflict": 1, "supportive": 2}   # render order: most decisive first


def _get_json(url: str, timeout: int = 8) -> dict | None:
    import urllib.request
    try:
        req = urllib.request.Request(url, headers={"User-Agent": "mc-morning/1.0"})
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return json.loads(r.read())
    except Exception as e:
        print(f"[morning] fetch failed ({url}): {e}", flush=True)
        return None


def _fmt_usd_compact(v) -> str:
    try:
        v = float(v)
    except (TypeError, ValueError):
        return "$0"
    for div, suf in ((1e9, "B"), (1e6, "M"), (1e3, "K")):
        if abs(v) >= div:
            return f"${v / div:.1f}{suf}"
    return f"${v:,.0f}"


def _darkpool_line() -> str:
    """One-line dark-pool summary: score/label, prints today, top-3 hot sectors,
    biggest print. Skips silently (one log line) if `dph` is null/missing."""
    data = _get_json(DARKPOOL_URL)
    dph = (data or {}).get("dph")
    if not dph:
        print("[morning] darkpool: dph missing/null — skipped", flush=True)
        return ""
    label = dph.get("label") or "n/a"
    score = dph.get("score")
    bits = [esc(f"{label} {score:g}" if isinstance(score, (int, float)) else label)]
    prints = dph.get("printsToday")
    if isinstance(prints, (int, float)):
        bits.append(f"{int(prints)} prints")
    line = "🕳 " + b("DARK POOL") + " " + " · ".join(bits)
    hot = [h for h in (dph.get("hotSectors") or [])
           if h.get("etf") and isinstance(h.get("ratio"), (int, float))][:3]
    if hot:
        line += " · hot: " + ", ".join(f"{esc(h['etf'])} {h['ratio']:.1f}x" for h in hot)
    big = dph.get("largestPrint") or {}
    if big.get("ticker") and big.get("value") is not None:
        line += f" · biggest {esc(big['ticker'])} {_fmt_usd_compact(big['value'])}"
    return line


def _relay_dp_block(max_rows: int = 5) -> str:
    """Up to N relay picks whose dark-pool confluence tag is corroborated/conflict/
    supportive (neutral/absent skipped), joined against the LIVE firebase-relay feed
    by signal id so a stale relayConfluence entry never outlives the relay itself.
    One pick per ticker (most decisive tag first)."""
    dp = _get_json(DARKPOOL_RELAY_URL)
    dp_signals = ((dp or {}).get("relayConfluence") or {}).get("signals") or []
    if not dp_signals:
        print("[morning] relay x dark-pool: no relayConfluence signals — skipped", flush=True)
        return ""
    relay = _get_json(FIREBASE_RELAY_URL)
    relay_ids = {str(s.get("id")) for s in (relay or {}).get("signals") or [] if s.get("id")}
    if not relay_ids:
        print("[morning] relay x dark-pool: firebase-relay unreachable/empty — skipped", flush=True)
        return ""
    joined = [s for s in dp_signals if str(s.get("id")) in relay_ids and s.get("tag") in RELAY_DP_TAGS]
    if not joined:
        return ""
    joined.sort(key=lambda s: RELAY_DP_TAGS.get(s.get("tag"), 9))
    picks, seen = [], set()
    for s in joined:
        tkr = str(s.get("ticker", "")).upper()
        if not tkr or tkr in seen:
            continue
        seen.add(tkr)
        side = "P" if s.get("isPut") else "C"
        strike = s.get("strike")
        opt = f"{side}{strike:g}" if isinstance(strike, (int, float)) else side
        picks.append(row(tkr, opt, s["tag"]))
        if len(picks) >= max_rows:
            break
    if not picks:
        return ""
    return "📡 " + b("RELAY × DARK POOL") + "\n" + "\n".join(picks)


# --------------------------------------------------------------------------- overnight / levels / breadth / earnings
# 2026-09-16: four more deterministic, best-effort lines for the phone brief, added
# right after the tape line. Each is fully independent and degrades to '' (line
# omitted) on any missing data / unreachable endpoint / missing key — never breaks
# the brief. yfinance runs on ~/.venv (confirmed import there); the other three
# read local missionctrl APIs / macro_calendar_alert's Finnhub helper.
MTF_TA_URL = os.environ.get("MTF_TA_URL", "http://localhost:3000/api/mtf-ta?symbol=SPY")
BREADTH_URL = os.environ.get("BREADTH_URL", "http://localhost:3000/api/console/breadth?scope=SPY")
OVERNIGHT_TICKERS = ["ES=F", "NQ=F", "^TNX", "DX-Y.NYB", "CL=F", "BTC-USD"]


def _overnight_line() -> str:
    """ES/NQ/10Y/DXY/Oil/BTC overnight read, ONE yf.download call. ES/NQ/BTC show
    % change (latest available bar vs prior close); 10Y/DXY/Oil show the level."""
    try:
        import yfinance as yf
    except Exception:
        return ""
    try:
        data = yf.download(OVERNIGHT_TICKERS, period="5d", interval="1d", progress=False, threads=True)
        closes = data["Close"]
    except Exception as e:
        print(f"[morning] overnight yfinance fetch failed: {e}", flush=True)
        return ""

    def last2(t):
        try:
            s = closes[t].dropna()
            if len(s) < 2:
                return None
            return float(s.iloc[-1]), float(s.iloc[-2])
        except Exception:
            return None

    es, nq, tny, dxy, oil, btc = (last2(t) for t in OVERNIGHT_TICKERS)
    parts = []
    if es and es[1]:
        parts.append(f"ES {(es[0] - es[1]) / es[1] * 100:+.1f}%")
    if nq and nq[1]:
        parts.append(f"NQ {(nq[0] - nq[1]) / nq[1] * 100:+.1f}%")
    if tny:
        parts.append(f"10Y {tny[0]:.2f}%")
    if dxy:
        parts.append(f"DXY {dxy[0]:.1f}")
    if oil:
        parts.append(f"Oil ${oil[0]:.0f}")
    if btc and btc[1]:
        parts.append(f"BTC ${btc[0]:,.0f} ({(btc[0] - btc[1]) / btc[1] * 100:+.1f}%)")
    if not parts:
        return ""
    return "🌍 " + b("OVERNIGHT") + " " + esc(" · ".join(parts))


def _spy_levels_line() -> str:
    """SPY support/resistance (mtf-ta `levels`) + a derived D/W/M trend-stack word +
    the CHARTER's own MTF-alignment glyph (mtf_rebound.py convention: >=0.7 ▲,
    >=0.4 △, <=-0.7 ▼, <=-0.4 ▽, else ─) — one fetch, both reads off it."""
    data = _get_json(MTF_TA_URL)
    if not data:
        return ""
    levels = data.get("levels") or {}
    support, resistance = levels.get("support"), levels.get("resistance")
    if support is None or resistance is None:
        return ""
    tf = data.get("timeframes") or {}
    trends = [(tf.get(k) or {}).get("trend") for k in ("daily", "weekly", "monthly")]
    if trends and all(t == "bull" for t in trends):
        stack = "bull-stacked"
    elif trends and all(t == "bear" for t in trends):
        stack = "bear-stacked"
    else:
        stack = "mixed"
    align = data.get("alignment")
    glyph = "─"
    if isinstance(align, (int, float)):
        glyph = ("▲" if align >= 0.7 else "△" if align >= 0.4 else
                 "▼" if align <= -0.7 else "▽" if align <= -0.4 else "─")
    return ("📏 " + b("SPY LEVELS") +
            f" S {esc(f'{support:.1f}')} / R {esc(f'{resistance:.1f}')} · EMA {esc(stack)} · MTF {esc(glyph)}")


def _breadth_line() -> str:
    """SPY breadth read off /api/console/breadth?scope=SPY `current`: the smoothed
    breadthEma20/breadthEma50 curves + the day-over-day `delta` the API already
    computes."""
    data = _get_json(BREADTH_URL)
    if not data:
        return ""
    cur = data.get("current") or {}
    ema20, ema50, delta = cur.get("breadthEma20"), cur.get("breadthEma50"), cur.get("delta")
    try:
        p20 = float(ema20[-1]) if ema20 else None
        p50 = float(ema50[-1]) if ema50 else None
    except (TypeError, ValueError, IndexError):
        p20 = p50 = None
    if p20 is None or p50 is None:
        return ""
    parts = [f"{p20:.0f}% above EMA20", f"{p50:.0f}% above EMA50"]
    if isinstance(delta, (int, float)):
        parts.append(f"Δ {delta:+.1f}")
    return "📈 " + b("BREADTH") + " " + esc(" · ".join(parts))


def _scheduled_today() -> str:
    """Deterministic high-impact events TODAY (embedded FOMC/NFP floor + finnhub econ when keyed)
    via macro_calendar_alert — overrides the LLM's "no major catalysts" guess, which missed the
    2026-09-16 FOMC decision. Empty string when nothing is scheduled."""
    try:
        import macro_calendar_alert as mca
    except Exception:
        return ""
    today = datetime.now(ET).date()
    try:
        ev = mca.embedded_macro(today, today)
        key = mca.finnhub_key()
        if key:
            ev += [e for e in mca.finnhub_econ(key, today, today) if e.get("impact") == "high"]
    except Exception as e:
        print(f"[morning] scheduled-today fetch failed: {e}", flush=True)
        return ""
    seen, parts = set(), []
    for e in ev:
        glyph = str(e.get("tag", "")).split(" ")[0]          # "🏛️ FOMC" → "🏛️" (event already names it)
        txt = f"{glyph} {e.get('event', '')}".strip()
        if txt and txt[:18].lower() not in seen:
            seen.add(txt[:18].lower()); parts.append(txt)
    return " · ".join(parts[:3])


def _earnings_today_line() -> str:
    """Today's earnings on the brief's own relay/watchlist universe, via
    macro_calendar_alert.finnhub_earnings(). Skipped (no key / no rows) rather
    than printed empty."""
    try:
        import macro_calendar_alert as mca
    except Exception:
        return ""
    key = mca.finnhub_key()
    if not key:
        return ""
    today = datetime.now(ET).date()
    tickers = {t.upper() for t in _relay_tickers(6)}
    try:
        rows = mca.finnhub_earnings(key, today, today, tickers)
    except Exception as e:
        print(f"[morning] earnings fetch failed: {e}", flush=True)
        return ""
    if not rows:
        return ""
    bmo, amc, other = [], [], []
    for r in rows:
        ev = str(r.get("event", ""))
        sym = ev.split(" ")[0]
        if "pre-mkt" in ev:
            bmo.append(sym)
        elif "after close" in ev:
            amc.append(sym)
        else:
            other.append(sym)
    parts = []
    if bmo:
        parts.append("BMO: " + ", ".join(bmo))
    if amc:
        parts.append("AMC: " + ", ".join(amc))
    if other:
        parts.append(", ".join(other))
    if not parts:
        return ""
    return "📆 " + b("EARNINGS TODAY") + " " + esc(" · ".join(parts))


def _snr_headlines_block(max_rows: int = 3) -> str:
    """Top-N high-signal headlines (SNR >= 65), one line each. Skips silently if the
    endpoint is down or nothing clears the threshold."""
    data = _get_json(NEWS_SNR_URL)
    arts = sorted((data or {}).get("articles") or [], key=lambda a: -(a.get("snr") or 0))[:max_rows]
    if not arts:
        print("[morning] news-snr: no high-SNR articles / endpoint down — skipped", flush=True)
        return ""
    lines = ["📰 " + b("SIGNAL") + " (SNR≥65)"]
    for a in arts:
        tks = a.get("tickers") or []
        tag = tks[0] if tks else "—"
        title = str(a.get("title") or "").strip()
        src = a.get("source") or ""
        lines.append(f"▸ {b(tag)} {int(a.get('snr') or 0)} — {esc(title)} ({esc(src)})")
    return "\n".join(lines)


def build() -> str:
    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    names = _relay_tickers_str(6)
    tape = _tape()
    lines = [f"🌅 **MORNING COMMAND — pre-open brief** · {stamp}"]
    if tape:
        lines.append(f"_Tape: {tape}_")

    pm = _polymarket_line()
    if pm:
        lines.append(f"🎰 **POLYMARKET (crowd odds):** {pm}")

    # native Grok X read on your names (sub-billed); silent-degrade if no token / fail
    xs = x_search.x_sentiment(f"my watchlist ({names}) and the broad market", timeout=40)
    if xs:
        lines.append("\n📡 **X SENTIMENT (your names):**\n" + xs.strip())

    flow = _flow_setup(2)
    lines.append("\n🎯 **FLOW SETUP:**")
    if flow:
        lines += flow
    else:
        lines.append("• No fresh near-money flow yet — first live picks post 9:50 AM ET.")

    cat, orders, _plan = _catalysts_and_orders(names, tape)
    lines.append(f"\n📅 **TODAY:** {cat}")
    lines.append(f"📋 **ORDERS:** {orders}")

    # real overnight/pre-open headlines on your names (best-effort; "" if none)
    try:
        news = headlines_block(names, title="📰 **HEADLINES (last 24h):**", max_items=4)
        if news:
            lines.append("\n" + news)
    except Exception:
        pass

    cat_block = _catalyst_block()
    if cat_block:
        lines.append(cat_block)

    for block in (_structure_block(), _macro_block()):
        if block:
            lines.append(block)

    lines.append(f"\n_One overview · specifics land in #flow-picks · risk cap ${RISK_CAP}/trade · auto-posted 8:15 ET._")
    return "\n".join(lines)


# --------------------------------------------------------------------------- phone brief
# 2026-07-29: Mike was getting FIVE pre-open briefs (7:00 X digest, 7:15 AInvest, 8:15 this
# one, 9:00 MasterMC, 9:15 flow pre-market) carrying the same headlines and tape read, all
# written in desk shorthand. They are now ONE message on Trading Command, and the phone copy
# is written for a beginner: what happened, what he owns, the ONE thing to watch, and what
# would actually make him act. The Discord post (build()) is unchanged — that's the desk copy.
BEST_CONTRACTS = Path("/AIWorkWSL/labs/quantum/out/best_contracts.json")


def now_et():
    return datetime.now(ET)


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
    # Describe the weather, don't give the order — the Plan line below is the single voice
    # that tells Mike what to do. Two lines giving conflicting instructions is worse than one.
    if vix >= 25 or vix_chg >= 15:
        return "Fear is spiking — expect violent moves both ways today."
    if spy_chg <= -0.7 or vix_chg >= 5:
        return "Selling this morning — bigger swings than a normal day."
    if spy_chg >= 0.7:
        return "Strong open — the easy money was made before you woke up."
    return "Quiet tape — a normal, boring session."


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
        # All three numbers or none. "Cut it if it's down half" gave the losing exit and left
        # the winning one unwritten — so the only trades with a plan were the ones going
        # wrong. Premium −50% / +50% off yesterday's close, stated as dollars. (2026-07-29)
        # `per_contract` is DOLLARS (premium × 100); `mid` is the quoted price you actually
        # type into the broker. Don't mix them — a "buy near $187" on a $1.87 contract is
        # a hundredfold error in the one number he acts on.
        px = float(p.get("mid") or 0) or round((p.get("per_contract") or 0) / 100.0, 2)
        stop_px, targ_px = round(px * 0.50, 2), round(px * 1.50, 2)
        return (f"📈 " + b("IF YOU TAKE ONE TRADE") + f": {b(p['ticker'])} ${p['strike']:g} {esc(kind)} "
                f"expiring {esc(p['expiry'])}{esc(window)}.\n"
                f"1) BUY {n} contract{'s' if n != 1 else ''} near ${px:.2f} = ${cost} total.\n"
                f"2) SELL at ${stop_px:.2f} if it drops — lose ${cost / 2:.0f}.\n"
                f"3) SELL at ${targ_px:.2f} if it works — make ${cost / 2:.0f}.\n"
                f"Both sell orders go in as soon as you're filled — never add to it.\n"
                f"<i>Priced at yesterday's close — check the real price before you buy; if "
                f"it opens far from ${px:.2f}, the whole plan moves with it.</i>")
    except Exception:
        return ""


def build_phone() -> str:
    """The beginner-facing pre-open brief. First line is the answer, every number gets a
    'so what', and it ends with an action or an explicit 'do nothing'."""
    now = datetime.now(ET)
    lines = [hdr("☀️", "Today", now)]
    tape = _tape()

    if tape:
        lines.append(f"📊 {esc(tape)}" + (f"\n{esc(_tape_read(tape))}" if _tape_read(tape) else ""))

    for line in (_overnight_line(), _spy_levels_line(), _breadth_line(), _earnings_today_line()):
        if line:
            lines.append(line)

    cat, orders, plan = _catalysts_and_orders(_relay_tickers_str(6), tape)
    sched = _scheduled_today()
    if sched:
        # the calendar floor (FOMC/NFP/high-impact econ) beats the model's recollection
        lines.append(f"⚠️ {b('THE ONE THING TODAY')}: {esc(sched)}")
    elif cat:
        # first sentence only — the model likes to pad, and padding is what makes a brief
        # get skimmed instead of read
        lines.append(f"⚠️ {b('THE ONE THING TODAY')}: {esc(cat.split('. ')[0].rstrip('.'))}.")
    numbered = _plan_orders(plan)
    if numbered:
        lines.append(numbered)
    elif orders:
        lines.append(f"👉 {b('PLAN')}: {esc(orders)}")

    cat_line = _catalyst_phone_line()
    if cat_line:
        lines.append(cat_line)

    for line in (_structure_phone_line(), _macro_phone_line()):
        if line:
            lines.append(line)

    dp_line = _darkpool_line()
    if dp_line:
        lines.append(dp_line)

    relay_dp = _relay_dp_block(5)
    if relay_dp:
        lines.append(relay_dp)

    snr_block = _snr_headlines_block(3)
    if snr_block:
        lines.append(snr_block)

    one = _one_contract_line()
    if one:
        lines.append(one)

    lines.append(footer(f"Never risk more than ${RISK_CAP} on a single trade. "
                         "If nothing here fits, doing nothing is a valid day.").lstrip("\n"))

    text = "\n\n".join(lines)
    # §3: Telegram's hard cap is 4096 chars. Trim order — drop block 3 (SNR headlines)
    # first, then shrink block 2 (relay x dark-pool) to 3 picks. Everything else stays.
    if len(text) > TELEGRAM_MAX_CHARS and snr_block and snr_block in lines:
        lines.remove(snr_block)
        text = "\n\n".join(lines)
        print("[morning] phone brief over 4096 chars — dropped SNR headlines block", flush=True)
    if len(text) > TELEGRAM_MAX_CHARS and relay_dp and relay_dp in lines:
        idx = lines.index(relay_dp)
        smaller = _relay_dp_block(3)
        if smaller:
            lines[idx] = smaller
        else:
            lines.pop(idx)
        text = "\n\n".join(lines)
        print("[morning] phone brief still over 4096 chars — trimmed relay x dark-pool to 3 picks", flush=True)
    return text


def _mirror_telegram(_discord_text: str) -> None:
    """Send the BEGINNER copy to Trading Command — the 'what do I do right now' lane.
    Falls back down the old chain if that bot is unreachable. Never raises."""
    from lib.notify import tg_push
    text = build_phone()
    # html=True (2026-09-15 format sweep): build_phone() now routes every dynamic
    # string (LLM catalyst/orders text included) through tg_format.esc()/b(), so a
    # stray '<' or '&' from the model or a headline can no longer break the parse.
    if tg_push(text, "trading_command", loud=True, html=True):
        print("[morning] phone brief -> trading_command", flush=True)
        return
    used = tg_brief(text)
    print(f"[morning] phone brief -> {used}" if used
          else "[morning] phone brief NOT sent (no live bot)", flush=True)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="mission-control")
    ap.add_argument("--print", action="store_true", dest="print_only")
    ap.add_argument("--dry-run", action="store_true",
                     help="print both desk (build) and phone (build_phone) copies, send nothing")
    ap.add_argument("--telegram", action="store_true", help="also mirror via fleet daily_briefs")
    a = ap.parse_args()
    if a.dry_run:
        print("=== DESK (build) ===")
        print(build())
        print("\n=== PHONE (build_phone) ===")
        print(build_phone())
        return
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
