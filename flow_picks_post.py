#!/usr/bin/env python3
"""flow_picks_post.py — deterministic FLOW PICKS poster for Discord.

Reads the LIVE scraped option flow (read-only — never touches the signal stream),
ranks the current contracts by conviction (flow $ + fresh vol/OI + sweep/repeat +
DTE sanity), splits 0DTE tape-confirmation from swing-able picks, flags YOUR names
(holdings + watchlist + real-money crypto), prepends a SPY/QQQ/VIX tape line, and
posts to #flow-picks. Cron-driven intraday. Run with ~/.venv/bin/python (for yfinance).

  flow_picks_post.py            # post to #flow-picks
  flow_picks_post.py --print    # print only, don't post
  flow_picks_post.py --channel flow-picks
"""
from __future__ import annotations

import argparse
import json
import math
import sys
from datetime import datetime, timezone
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from skill_to_discord import post, resolve_channel, GUILD  # noqa: E402  (resilient bot poster)
from lib.portfolio import personal_tickers, personal_crypto  # noqa: E402
from lib.heartbeat import beat  # noqa: E402
from lib.notify import tg_brief  # noqa: E402
from lib import card_mute  # noqa: E402  — operator-muted names get skipped
from lib.discord_threading import (make_pick_key,  # noqa: E402  — per-pick lifecycle threads
                                   post_to_pick_thread_bot, _load_state as _thread_state)

SYNTH_TOKEN_FILE = Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token"
TOP_ACTION_PICK = None     # build() stashes the #1 actionable pick for the action card
ACTIONABLE_PICKS = []      # build() stashes all swing picks for per-pick threads

ET = ZoneInfo("America/New_York")
DATA = Path.home() / "trading" / "signals" / "option-scraper" / "data"
FILES = ["flow_alerts_today.json", "flow2_alerts_today.json"]
PICKLOG_DIR = Path.home() / ".openclaw" / "state"
IV_FORECAST = Path("/AIWorkWSL/labs/quantum/out/iv_forecast.json")  # quantum desk IV grader


def _load_iv_map() -> dict:
    """ticker → the desk's IV-forecast read (rich/cheap vs realized, tier, crush),
    so the FLOW PICKS surface carries the SAME 'researched & verified' stamp as the
    Telegram best-3. Empty on any failure → picks just post without the tag."""
    try:
        d = json.loads(IV_FORECAST.read_text())
        m: dict = {}
        for p in d.get("picks", []):
            t = str(p.get("ticker", "")).upper()
            if t and t not in m:  # first (highest-ranked) grade per name wins
                m[t] = p
        return m
    except Exception:
        return {}


def _iv_tag(a: dict, iv_map: dict) -> str:
    """Compact 'Desk IV' line for a flow pick when its NAME was graded by the desk.
    Rich/cheap is a symbol-level vol-regime read (honest at ticker level); the crush
    warning fires ONLY when the event date lands inside THIS contract's expiry — so
    it's precise per pick, not a blanket scare. Returns '' when the name isn't graded."""
    p = iv_map.get(str(a.get("Symbol", "")).upper())
    if not p:
        return ""
    bits = []
    r = p.get("ivVsHv")
    if r is not None:
        regime = "RICH" if r >= 1.15 else "CHEAP" if r <= 0.9 else "FAIR"
        tier = p.get("tier", "")
        mark = "✅" if (tier == "VERIFIED" and regime != "RICH") else ("⚠️" if (tier == "FLAG" or regime == "RICH") else "•")
        bits.append(f"{mark} Desk IV {regime} ({r:.2f}× realized)")
    crush = p.get("crush")
    if crush and crush.get("date"):
        try:
            cd = datetime.strptime(crush["date"], "%Y-%m-%d").date()
            exp = datetime.fromtimestamp(int(a.get("Expiry", 0)), tz=timezone.utc).astimezone(ET).date()
            if cd <= exp:  # event inside the contract's life → crush risk is real here
                drop = int((crush.get("expectedDropPct") or 0) * 100)
                bits.append(f"⚠️ {crush.get('event', 'event')} {cd.strftime('%-m/%-d')} in-window (~{drop}% IV crush — prefer a spread)")
        except Exception:
            pass
    return ("\n   📊 " + " · ".join(bits)) if bits else ""


def _spot(ticker: str):
    """Underlying last price (yfinance) for grading later. None on failure."""
    try:
        import yfinance as yf
        i = yf.Ticker(ticker).history(period="1d", interval="5m")
        if len(i):
            return float(i["Close"].iloc[-1])
        h = yf.Ticker(ticker).history(period="1d")
        return float(h["Close"].iloc[-1]) if len(h) else None
    except Exception:
        return None


def _log_picks(picks):
    """Append swing picks to today's log so the EOD scorecard can grade them.
    Records the underlying spot at first pick-time (earliest reference per contract)."""
    if not picks:
        return
    date = datetime.now(ET).strftime("%Y-%m-%d")
    path = PICKLOG_DIR / f"flow_picks_log_{date}.jsonl"
    seen = set()
    if path.exists():
        try:
            for ln in path.read_text().splitlines():
                seen.add(json.loads(ln).get("optionSymbol"))
        except Exception:
            pass
    PICKLOG_DIR.mkdir(parents=True, exist_ok=True)
    with open(path, "a") as f:
        for a, fv, voi, dte, tag, spot, otm in picks:
            osym = a.get("OptionSymbol")
            if osym in seen:        # only log a contract's first appearance
                continue
            rec = {"ts": datetime.now(ET).isoformat(), "symbol": a.get("Symbol"), "optionSymbol": osym,
                   "strike": a.get("Strike"), "type": str(a.get("OptionType", ""))[:1],
                   "exp": int(a.get("Expiry", 0) or 0), "dte": dte, "spot": spot,
                   "flowValue": fv, "isBullish": bool(a.get("isBullish"))}
            f.write(json.dumps(rec) + "\n")


def _load() -> dict:
    merged = {}
    for fn in FILES:
        p = DATA / fn
        if not p.exists():
            continue
        try:
            d = json.loads(p.read_text())
        except Exception:
            continue
        for v in d.values():
            a = v.get("alert", v) if isinstance(v, dict) else v
            if not isinstance(a, dict):
                continue
            sym = a.get("OptionSymbol")
            if not sym:
                continue
            fv = float(a.get("totalFlowValue", 0) or 0)
            if sym not in merged or fv > float(merged[sym].get("totalFlowValue", 0) or 0):
                merged[sym] = a
    return merged


def _score(a: dict) -> tuple:
    fv = float(a.get("totalFlowValue", 0) or 0)
    vol = float(a.get("Volume", 0) or 0)
    oi = float(a.get("OI", 0) or 1)
    dte = int(a.get("DTE", 0) or 0)
    sweeps = int(a.get("SWEEPS", 0) or 0)
    blocks = int(a.get("BLOCKS", 0) or 0)
    voi = vol / oi if oi else 0
    s = math.log10(max(fv, 1)) * 2
    s += min(voi, 5) * 1.5
    s += 0.6 if 10 <= dte <= 180 else (-1.0 if dte < 7 else 0)
    s += min(sweeps + blocks, 15) * 0.15
    return s, fv, voi, dte


def _fmt(a: dict) -> str:
    exp = datetime.fromtimestamp(int(a["Expiry"]), tz=timezone.utc).astimezone(ET).strftime("%-m/%-d")
    typ = "C" if str(a.get("OptionType", "")).upper().startswith("C") else "P"
    return f"{a['Symbol']} ${a['Strike']:g}{typ} {exp}"


def _tape() -> str:
    try:
        import yfinance as yf
        out = []
        for t, lbl in (("SPY", "SPY"), ("QQQ", "QQQ"), ("^VIX", "VIX")):
            h = yf.Ticker(t).history(period="2d", interval="1d")
            i = yf.Ticker(t).history(period="1d", interval="5m")
            prev = float(h["Close"].iloc[-2])
            now = float(i["Close"].iloc[-1]) if len(i) else float(h["Close"].iloc[-1])
            chg = (now - prev) / prev * 100
            out.append(f"{lbl} {now:,.0f} ({chg:+.1f}%)" if lbl != "VIX" else f"VIX {now:.1f} ({chg:+.1f}%)")
        return " · ".join(out)
    except Exception:
        return ""


MAX_MNY = 0.15   # |moneyness| beyond this = hedge/LEAP/stock-replacement, not a swing pick
DTE_MIN, DTE_MAX = 7, 120   # swing window — excludes 0DTE lotto and long-dated LEAPs
RISK_CAP = 800   # Mike's per-trade risk cap (premium-at-risk model) — raised 250→800 2026-06-15


def _mid(row):
    bid, ask, last = float(row["bid"] or 0), float(row["ask"] or 0), float(row["lastPrice"] or 0)
    return (bid + ask) / 2 if (bid and ask) else last


ALT_MAX_MNY = 0.20   # an affordable alternative must still be within 20% of spot (no lotto)


def _yf_option_chain_df(ticker_sym, exp, is_call, retries=3):
    """yfinance option_chain for one expiry, WITH retry. The single-expiry call can
    transiently raise or return an empty/partial frame (yfinance is flaky); retry a
    few times before giving up so sizing isn't silently skipped on a blip."""
    import yfinance as yf
    import time as _t
    for attempt in range(retries):
        try:
            t = yf.Ticker(ticker_sym)
            if exp not in (t.options or ()):
                return None
            oc = t.option_chain(exp)
            df = oc.calls if is_call else oc.puts
            if df is not None and len(df) > 0:
                return df
        except Exception:
            pass
        if attempt < retries - 1:
            _t.sleep(1.0)
    return None


def _sizing_line(a, is_call, spot=None):
    """Premium-based sizing for Mike's $150–250 risk. If the flagged contract is above his
    cap, scan the SAME-expiry chain for an affordable, still-near-money same-direction strike."""
    try:
        exp = datetime.fromtimestamp(int(a.get("Expiry", 0)), tz=timezone.utc).astimezone(ET).strftime("%Y-%m-%d")
        df = _yf_option_chain_df(a.get("Symbol"), exp, is_call)
        if df is None:
            return ""
        strike = float(a.get("Strike", 0) or 0)
        row = df[df["strike"] == strike]
        mid = _mid(row.iloc[0]) if len(row) else None
    except Exception:
        return ""
    if not mid:
        return ""
    cost = mid * 100
    n = int(RISK_CAP // cost)
    if n >= 1:
        return (f"   💵 ~${mid:.2f}/ct (${cost:,.0f} ea) → **{n} ct** ≈ ${n*cost:,.0f} max risk "
                f"(${n*cost*0.5:,.0f} at a 50% stop)")
    # too rich → find the richest affordable same-direction strike (best delta you can buy)
    alt = None
    try:
        for _, r in df.iterrows():
            m = _mid(r)
            if not m or m * 100 > RISK_CAP or m < 0.30:
                continue
            k = float(r["strike"])
            # bullish call wants strikes ≥ pick (cheaper OTM); bearish put wants strikes ≤ pick
            ok = (k >= strike) if is_call else (k <= strike)
            if spot and abs(k - spot) / spot > ALT_MAX_MNY:    # reject deep-OTM lotto
                continue
            if ok and (alt is None or m > alt[1]):     # richest affordable = closest to money
                alt = (k, m)
    except Exception:
        alt = None
    base = (f"   💵 flagged contract ~${mid:.2f}/ct (${cost:,.0f}) = above your $800 cap")
    if alt:
        ac = alt[1] * 100
        an = int(RISK_CAP // ac)
        cp = "C" if is_call else "P"
        base += (f"\n   ✅ **affordable play: {a.get('Symbol')} ${alt[0]:g}{cp} {exp[5:].replace('-','/')}** "
                 f"~${alt[1]:.2f}/ct → **{an} ct** ≈ ${an*ac:,.0f} (${an*ac*0.5:,.0f} at a 50% stop)")
    else:
        base += " — no near-money strike fits $250 (this name's options are too rich for your account)"
    return base


def _moneyness(a: dict, spot: float):
    """(% OTM, ITM?) for the contract vs spot. Positive % = out of the money."""
    strike = float(a.get("Strike", 0) or 0)
    if not spot:
        return None, False
    is_call = str(a.get("OptionType", "")).upper().startswith("C")
    otm = (strike - spot) / spot if is_call else (spot - strike) / spot
    return otm, (otm < 0)


def build() -> str | None:
    merged = _load()
    if not merged:
        return None
    names = {s.upper() for s in personal_tickers()} | {s.upper() for s in personal_crypto()}
    iv_map = _load_iv_map()
    scored = sorted(((_score(a), a) for a in merged.values()), key=lambda x: -x[0][0])

    spot_cache: dict[str, float | None] = {}

    def getspot(tk):
        if tk not in spot_cache:
            spot_cache[tk] = _spot(tk)
        return spot_cache[tk]

    conf, bulls, bears, hedges = [], [], [], []
    used = set()        # dedupe by underlying — one contract per ticker
    for (s, fv, voi, dte), a in scored:
        sym = str(a.get("Symbol", "")).upper()
        if card_mute.is_muted(sym):     # operator silenced this name from a card's 🔇 button
            continue
        tag = " 🎯YOUR NAME" if sym in names else ""
        if dte <= 1 and a.get("isBullish") and len(conf) < 2:
            conf.append(f"• **{_fmt(a)}** — ${fv:,.0f}, {int(a.get('SWEEPS',0))} sweeps, V/OI {voi:.1f}{tag}")
        elif DTE_MIN <= dte <= DTE_MAX:
            sp = getspot(a.get("Symbol"))
            if not sp:
                continue
            otm, _ = _moneyness(a, sp)
            if otm is None or abs(otm) > MAX_MNY:
                if otm and otm > MAX_MNY and fv > 3_000_000 and len(hedges) < 2 and sym not in used:
                    hedges.append((a, fv, otm, tag)); used.add(sym)
                continue
            if sym in used:                  # one pick per underlying
                continue
            is_call = str(a.get("OptionType", "")).upper().startswith("C")
            rec = (a, fv, voi, dte, tag, sp, otm)
            # actionable = BOUGHT calls (bullish long) / BOUGHT puts (bearish); skip sold-side
            if a.get("isBullish") and is_call and len(bulls) < 3:
                bulls.append(rec); used.add(sym)
            elif not a.get("isBullish") and not is_call and len(bears) < 2:
                bears.append(rec); used.add(sym)

    _log_picks(bulls + bears)   # record for the EOD scorecard (direction from isBullish)
    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    tape = _tape()
    lines = [f"🎯 **FLOW PICKS — live contracts** · {stamp}"]
    if tape:
        lines.append(f"_Tape: {tape}_")
    if conf:
        lines.append("\n**🟢 TAPE CONFIRMATION (0DTE — direction, not swing buys):**")
        lines += conf

    def _pickline(idx, rec):
        a, fv, voi, dte, tag, sp, otm = rec
        vol = int(a.get("Volume", 0) or 0)
        oi = int(a.get("OI", 0) or 0)
        why = ("fresh opening flow (vol >> OI)" if voi >= 2 else
               "repeat institutional positioning" if voi < 1 else "building position")
        mny = f" · spot ${sp:,.2f} ({abs(otm)*100:.0f}% {'OTM' if otm >= 0 else 'ITM'})" if sp else ""
        is_call = str(a.get("OptionType", "")).upper().startswith("C")
        sizing = _sizing_line(a, is_call, sp)
        line = f"**{idx}. {_fmt(a)}** ({dte} DTE) · ${fv:,.0f} · V/OI {voi:.1f} ({vol:,}/{oi:,}){mny}{tag}\n   *{why}*"
        line += ("\n" + sizing if sizing else "")
        line += _iv_tag(a, iv_map)   # researched-&-verified stamp when the name was graded
        return line

    if bulls:
        lines.append("\n**⭐ BULLISH SWING PICKS (near-money, fresh, actionable longs):**")
        for i, rec in enumerate(bulls, 1):
            lines.append(_pickline(i, rec))
    if bears:
        lines.append("\n**🔴 BEARISH FLOW TO RESPECT (contra / hedge your longs):**")
        for i, rec in enumerate(bears, 1):
            lines.append(_pickline(i, rec))
    if hedges:
        lines.append("\n**🛡️ Notable big-money positioning (deep OTM — likely hedges, not buys):**")
        for a, fv, otm, tag in hedges:
            lines.append(f"• {_fmt(a)} — ${fv:,.0f} ({abs(otm)*100:.0f}% OTM){tag}")
    # your-name caution: largest flow on a held name that reads bearish
    for (s, fv, voi, dte), a in scored:
        if str(a.get("Symbol", "")).upper() in names and not a.get("isBullish") and fv > 2_000_000:
            lines.append(f"\n⚠️ **YOUR NAME — {a['Symbol']}:** big flow ({_fmt(a)}, ${fv:,.0f}) reads "
                         f"**bearish** (V/OI {voi:.1f}). Don't mistake size for a green light.")
            break
    lines.append("\n_0DTE = confirmation not entry · size up to $800 risk (fraction of equity) · auto-posted intraday._")
    global TOP_ACTION_PICK, ACTIONABLE_PICKS
    TOP_ACTION_PICK = bulls[0] if bulls else (bears[0] if bears else None)
    ACTIONABLE_PICKS = list(bulls) + list(bears)
    return "\n".join(lines)


def _post_pick_threads(actionable) -> None:
    """Open a per-pick thread for each swing pick (entry message) the FIRST time the
    contract is seen — the EOD grader posts the grade into the same thread, so a
    trade's lifecycle lives in one place. Reuses lib/discord_threading (token-only).
    Threads hang off #flow-picks and auto-archive in 24h. Never raises."""
    if not actionable:
        return
    try:
        tok = SYNTH_TOKEN_FILE.read_text().strip()
        parent = resolve_channel("flow-picks")
        existing = _thread_state()
        for a, fv, voi, dte, tag, sp, otm in actionable:
            sym = str(a.get("Symbol", "")).upper()
            key = make_pick_key(sym, a.get("Strike"), str(a.get("OptionType", ""))[:1], a.get("Expiry"))
            if key in existing:        # thread already started → entry already posted
                continue
            is_call = str(a.get("OptionType", "")).upper().startswith("C")
            msg = (f"🎯 **ENTRY — {_fmt(a)}** ({dte} DTE)\n"
                   f"${fv:,.0f} flow · V/OI {voi:.1f}" + (f" · spot ${sp:,.2f}" if sp else "")
                   + f"\n{'🟢 bullish call' if is_call else '🔴 bearish put'}{tag}")
            r = post_to_pick_thread_bot(key, msg, f"{_fmt(a)} · {datetime.now(ET):%b %-d}", tok, parent)
            print(f"[flow-picks] thread {sym}: created={r.get('created')} ok={r.get('ok')}", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[flow-picks] thread err: {e}", flush=True)


def _post_action_card(rec) -> None:
    """Post a compact, button-bearing ACTION card for the #1 pick — AS SynthControl
    (the aime-discord bot's own app), so the Paper Buy / Set Alert / Explain / Grade /
    Mute buttons route to that gateway bot's persistent ActionView. Additive: the rich
    text digest already posted via the Boba bot. Never raises."""
    if not rec:
        return
    try:
        from lib import ops_card as oc, chart_renderer as cr, explain
        a, fv, voi, dte, tag, sp, otm = rec
        sym = str(a.get("Symbol", "")).upper()
        tok = SYNTH_TOKEN_FILE.read_text().strip()
        cid = oc.resolve_channel(GUILD, tok, "flow-picks")
        if not (tok and cid):
            return
        if not a.get("Spot") and sp:        # alert Spot is often 0 — backfill for the chart mark
            a = {**a, "Spot": sp}
        spec = explain.card_spec(a)
        cap = (f"🎯 **{spec['contract']}** · {spec['tier']} · conviction {spec['conviction']}/10"
               f"{('  ·' + tag) if tag.strip() else ''}")
        png = cr.pick_card(spec)
        if png and oc.post_image_bot(cid, tok, png, content=cap, components=oc.pick_action_rows()):
            print(f"[flow-picks] image card → {sym}: ok", flush=True)
            return
        # fallback — render/upload failed: post the compact embed (still button-bearing)
        is_call = str(a.get("OptionType", "")).upper().startswith("C")
        mny = f"${sp:,.2f} ({abs(otm)*100:.0f}% {'OTM' if otm >= 0 else 'ITM'})" if sp else "—"
        embed = {
            "title": f"⚡ ACTION · {sym}",
            "color": 0x2ECC71 if is_call else 0xE74C3C,
            "description": f"**{_fmt(a)}** · {dte} DTE · ${fv:,.0f} flow · V/OI {voi:.1f}",
            "fields": [
                {"name": "Spot", "value": mny, "inline": True},
                {"name": "Direction", "value": ("🟢 bullish call" if is_call else "🔴 bearish put"),
                 "inline": True},
            ],
            "footer": {"text": f"tk:{sym} · tap a button to act · {tag.strip() or 'flow pick'}"},
        }
        oc.post_message_bot(cid, tok, embeds=[embed], components=oc.pick_action_rows())
        print(f"[flow-picks] embed-fallback card → {sym}", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[flow-picks] action card err: {e}", flush=True)


def _post_action_cards(picks) -> None:
    """Action card for the top few picks (not just #1) — tap-to-act on each."""
    for rec in (picks or [])[:3]:
        _post_action_card(rec)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="flow-picks")
    ap.add_argument("--print", action="store_true", dest="print_only")
    a = ap.parse_args()
    msg = build()
    if not msg:
        print("[flow-picks] no flow data; skip", flush=True)
        return
    if a.print_only:
        print(msg)
        return
    post(resolve_channel(a.channel), msg)
    _post_action_cards(ACTIONABLE_PICKS)  # button-bearing cards for the top 3 picks (SynthControl)
    _post_pick_threads(ACTIONABLE_PICKS)  # per-pick lifecycle threads (entry; grade follows at EOD)
    beat("flow_picks")
    used = tg_brief(msg, chain=("flow_digest", "daily_briefs"))  # 2026-06-24: Flow Picks → flow_digest (fallback SpaceCoast so a vault hiccup never silences a pick)
    print(f"[flow-picks] posted ({len(msg)} chars) · tg→{used or 'skip'}", flush=True)


if __name__ == "__main__":
    main()
