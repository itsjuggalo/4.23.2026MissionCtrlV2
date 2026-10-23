#!/usr/bin/env python3
"""flow_picks_post.py — deterministic FLOW PICKS poster for Discord.

Reads the LIVE scraped option flow (read-only — never touches the signal stream),
ranks the current contracts by conviction (flow $ + fresh vol/OI + sweep/repeat +
DTE sanity), splits 0DTE tape-confirmation from swing-able picks, flags YOUR names
(watchlist), prepends a SPY/QQQ/VIX tape line, and posts to #flow-picks. Cron-driven
intraday. Run with ~/.venv/bin/python (for yfinance).

YOUR-NAME tag was watchlist+holdings+real-money-crypto; narrowed to watchlist-only
2026-09-15 (portfolio views retired site-wide 2026-09-12, no live holdings feed to
tag against).

  flow_picks_post.py            # post to #flow-picks
  flow_picks_post.py --print    # dry run: render only — no post, no pick log, no score write, no alert send
  flow_picks_post.py --channel flow-picks
"""
from __future__ import annotations

import argparse
import json
import math
import os
import re
import subprocess
import sys
from datetime import datetime, timezone
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from skill_to_discord import post, resolve_channel, GUILD  # noqa: E402  (resilient bot poster)
from lib.portfolio import get_watchlist  # noqa: E402
from lib.heartbeat import beat  # noqa: E402
from lib.notify import tg_brief  # noqa: E402
from lib import card_mute  # noqa: E402  — operator-muted names get skipped
import levels_block as LB  # noqa: E402  R32 (Mike 2026-10-21): computed levels.v1 block per swing pick
from price_guard import check as price_check, fresh, option_quotes, src_label  # noqa: E402  quote.v1, Robinhood first
from lib.discord_threading import (make_pick_key,  # noqa: E402  — per-pick lifecycle threads
                                   post_to_pick_thread_bot, _load_state as _thread_state)

SYNTH_TOKEN_FILE = Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token"
TOP_ACTION_PICK = None     # build() stashes the #1 actionable pick for the action card
ACTIONABLE_PICKS = []      # build() stashes all swing picks for per-pick threads

ET = ZoneInfo("America/New_York")
DATA = Path.home() / "trading" / "signals" / "option-scraper" / "data"
FILES = ["flow_alerts_today.json", "flow2_alerts_today.json"]
PICKLOG_DIR = Path.home() / ".openclaw" / "state"
IV_FORECAST = Path("/AIWorkWSL/labs/quantum/out/iv_forecast.json")
MC_REPO = Path(os.environ.get("MC_REPO", "/AIWorkWSL/web/missionctrl"))
MC_PY = os.environ.get("MC_PY", str(Path.home() / ".venv/bin/python"))  # quantum desk IV grader
TAPE = (("SPY", "SPY"), ("QQQ", "QQQ"), ("^VIX", "VIX"))
STATE: dict = {}   # build() → render(): the selected picks + their slow enrichment (pick_score, levels)
PRICED: list = []  # (as_of, price) of every price on the rendered card — re-checked right before the send
SPOT_SRC: dict = {}  # SYM → the render-time spot's "src … ET" label (pick threads / action cards)
MISSING: dict = {} # input → [{source, ok, error}] for the loud missing-data alert (market-data rule §3)


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


_OCC_ROOT = re.compile(r"^[A-Z]{1,6}\d{6}[CP]\d{8}")
_INDEX_Q = {"VIX": "^VIX", "SPX": "^SPX", "NDX": "^NDX", "RUT": "^RUT", "XSP": "^XSP"}  # index options → quote.v1


def _occ(a: dict) -> str | None:
    """The plain OCC symbol. flow2 rows append a source id ("NTRA270115C00460000_0941…"), which no pricer parses."""
    m = _OCC_ROOT.match(str(a.get("OptionSymbol") or ""))
    return m.group(0) if m else None


def _qsym(sym) -> str:
    s = str(sym or "").strip().upper()
    return _INDEX_Q.get(s, s)


def _spot_q(ticker: str) -> dict:
    """quote.v1 send-time quote (price_guard.fresh: Robinhood first, a fallback is labelled "not Robinhood"; the
    regular-session price in RTH, the extended print outside it). {ok, price, src, as_of, reason, change_pct}."""
    sym = _qsym(ticker)
    return (fresh([sym]).get(sym) or {}) if sym else {}


def _spot(ticker: str):
    """Underlying price that passed the send guard, else None (fail closed). Was direct yfinance until
    2026-10-22 (audit P0): no source, no as_of, never Robinhood."""
    r = _spot_q(ticker)
    return r.get("price") if r.get("ok") else None


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


_V2_NOTES: dict[str, list[str]] = {}   # OptionSymbol → staged-term notes (shown only while the flag is on)
_V2_BUYS: dict[str, dict] = {}
_V2_ON = False


def _v2_delta(a: dict) -> float:
    """STAGED pick terms (Mike 2026-10-21; missionctrl pipeline/intel/pick_features.py): accumulation (same contract
    bought on several sessions, flow.db) + IV rank (tastytrade / CBOE index). Adds 0 unless the pick_features_v2 flag
    file exists — trade-changing, so it waits for Mike's GO. A failure adds 0 and is noted on the pick."""
    global _V2_ON
    try:
        if "/AIWorkWSL/web/missionctrl" not in sys.path:
            sys.path.append("/AIWorkWSL/web/missionctrl")
        from pipeline.intel import pick_features as PF
    except Exception:  # noqa: BLE001 — module not reachable → production score unchanged
        return 0.0
    if not PF.enabled():
        return 0.0
    _V2_ON = True
    osym = a.get("OptionSymbol")
    try:
        sym = str(a.get("Symbol", "")).upper()
        if sym not in _V2_BUYS:
            _V2_BUYS[sym] = PF.buys_by_symbol(sym, datetime.now(ET).date())
        exp = datetime.fromtimestamp(int(a["Expiry"]), tz=timezone.utc).astimezone(ET).date().isoformat()
        acc = PF.accumulation(_V2_BUYS[sym], str(a.get("OptionType", "")), float(a.get("Strike") or 0), exp)
        d, parts = PF.score_delta(acc, PF.iv_rank(sym))
        _V2_NOTES[osym] = parts + [f"score {d:+.2f}"]
        return d
    except Exception as e:  # noqa: BLE001
        _V2_NOTES[osym] = [f"staged terms failed ({type(e).__name__}) — score unchanged"]
        return 0.0


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
    s += _v2_delta(a)   # STAGED: 0 unless Mike's GO flag file exists
    return s, fv, voi, dte


def _fmt(a: dict) -> str:
    exp = datetime.fromtimestamp(int(a["Expiry"]), tz=timezone.utc).astimezone(ET).strftime("%-m/%-d")
    typ = "C" if str(a.get("OptionType", "")).upper().startswith("C") else "P"
    return f"{a['Symbol']} ${a['Strike']:g}{typ} {exp}"


def _tape(q: dict | None = None) -> str:
    """'SPY 766 (+0.4%, src Robinhood 09:49 ET) · QQQ … · VIX …'. Audit P0 (2026-10-22): quote.v1 via
    price_guard.fresh (Robinhood first; VIX is Yahoo's delayed index, exempt from the "not Robinhood" label), each
    value with its own source and data time, % vs the prior regular close. A symbol that fails the send guard shows
    UNAVAILABLE with the reason — never an older price. `q` = an already-fetched fresh() result."""
    try:
        q = q if q is not None else fresh([t for t, _ in TAPE])
    except Exception as e:  # noqa: BLE001
        return f"Tape UNAVAILABLE ({type(e).__name__})"
    out = []
    for t, lbl in TAPE:
        r = q.get(t) or {}
        if not r.get("ok"):
            out.append(f"{lbl} UNAVAILABLE ({r.get('reason') or 'no quote'})")
            continue
        px, chg = float(r["price"]), r.get("change_pct")
        val = f"{px:.1f}" if lbl == "VIX" else f"{px:,.0f}"
        pct = f"{chg:+.1f}%, " if isinstance(chg, (int, float)) else ""
        out.append(f"{lbl} {val} ({pct}{r.get('src')})")
    return " · ".join(out)


MAX_MNY = 0.15   # |moneyness| beyond this = hedge/LEAP/stock-replacement, not a swing pick
DTE_MIN, DTE_MAX = 7, 120   # swing window — excludes 0DTE lotto and long-dated LEAPs
# Per-trade price caps removed 2026-10-05 (Mike's decision): each pick shows its cost
# per contract (mid × 100) — no contract counts, no "affordable alternative" swaps.


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


def _yahoo_last(a: dict) -> dict:
    """Labelled fallback when Robinhood can't price the contract: Yahoo's last trade for the exact strike, with its
    own trade time (Yahoo's chain carries no quote time, so its bid/ask are never shown). Send-guard checked."""
    try:
        exp = datetime.fromtimestamp(int(a.get("Expiry", 0)), tz=timezone.utc).astimezone(ET).strftime("%Y-%m-%d")
        is_call = str(a.get("OptionType", "")).upper().startswith("C")
        df = _yf_option_chain_df(a.get("Symbol"), exp, is_call)
        if df is None:
            return {"ok": False, "reason": "no Yahoo chain"}
        row = df[df["strike"] == float(a.get("Strike", 0) or 0)]
        if not len(row):
            return {"ok": False, "reason": "strike not in the Yahoo chain"}
        px, ts = float(row.iloc[0]["lastPrice"] or 0), row.iloc[0]["lastTradeDate"]
        ts = ts.isoformat() if hasattr(ts, "isoformat") else str(ts)
    except Exception as e:  # noqa: BLE001
        return {"ok": False, "reason": f"Yahoo chain {type(e).__name__}"}
    chk = price_check(ts, px)
    if not chk["ok"]:
        return {"ok": False, "reason": f"Yahoo last trade: {chk['reason']}"}
    return {"ok": True, "mid": round(px, 2), "as_of": ts, "src": src_label("Yahoo last trade (not Robinhood)", ts)}


def _marks(picks) -> dict:
    """OCC → {ok, mid, as_of, src, reason}: Robinhood marketdata/options first (price_guard.option_quotes, send-guard
    checked at the quote's own time), else the labelled Yahoo last trade. Both fail → ok False, both reasons named.
    Audit P0 2026-10-22: the cost line was a Yahoo mid stamped with the render time."""
    occs = [o for o in (_occ(r[0]) for r in picks) if o]
    try:
        rh = option_quotes(occs)
    except Exception as e:  # noqa: BLE001
        rh = {o: {"ok": False, "reason": f"Robinhood helper {type(e).__name__}"} for o in occs}
    out = {}
    for rec in picks:
        a = rec[0]
        occ = _occ(a) or a.get("OptionSymbol")
        q = rh.get(occ) or {"reason": "not an OCC symbol"}
        if q.get("ok"):
            ts = datetime.fromtimestamp(q["as_of"], timezone.utc).isoformat()
            out[occ] = {"ok": True, "mid": round(q["mid"], 2), "as_of": ts, "src": q["src"]}
            continue
        y = _yahoo_last(a)
        y["rh_reason"] = q.get("reason") or "no Robinhood quote"
        if not y["ok"]:
            y["reason"] = f"Robinhood: {y['rh_reason']}; {y['reason']}"
        out[occ] = y
    return out


def _cost_line(m: dict | None) -> str:
    """Cost of ONE contract (price × 100) with the price's source + data time; no contract count, no cap
    (caps removed 2026-10-05, R32). A price that fails the send guard is UNAVAILABLE with the reason."""
    if not m or not m.get("ok"):
        return f"   💵 cost per contract UNAVAILABLE — {(m or {}).get('reason') or 'no quote'}"
    return f"   💵 ~${m['mid']:.2f}/ct [{m['src']}] → ${m['mid'] * 100:,.0f} per contract"


def _levels(rec) -> list[str]:
    """levels.v1 block (DECISIONS R32) for a swing pick: underlying levels with methods + the contract premium
    levels. The "No size, no cap" footer is printed once per card. A failure is one UNAVAILABLE line."""
    a, dte = rec[0], rec[3]
    return LB.lines(str(a.get("Symbol", "")).upper(), LB.side_for(a.get("OptionType")), LB.horizon_for(dte),
                    occ=_occ(a), footer=False)


def _moneyness(a: dict, spot: float):
    """(% OTM, ITM?) for the contract vs spot. Positive % = out of the money."""
    strike = float(a.get("Strike", 0) or 0)
    if not spot:
        return None, False
    is_call = str(a.get("OptionType", "")).upper().startswith("C")
    otm = (strike - spot) / spot if is_call else (spot - strike) / spot
    return otm, (otm < 0)


def build(dry_run: bool = False) -> str | None:
    """Select the picks (flow facts + a send-guarded spot for the moneyness filter), run the slow enrichment
    (pick_score, levels.v1), then render() fetches the displayed prices last so they are seconds old at send.
    dry_run: no pick log, no pick_score write."""
    merged = _load()
    if not merged:
        return None
    names = {s.upper() for s in get_watchlist()}
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
    unpriced = sorted(t for t, v in spot_cache.items() if v is None)
    if unpriced:   # a swing candidate dropped only because its underlying had no send-guarded price
        MISSING["flow_picks underlying spot"] = [
            {"source": "quote.v1 (Robinhood → Yahoo → Finnhub)", "ok": False,
             "error": f"no send-guarded price for {', '.join(unpriced[:8])} — those picks were skipped"}]

    if not dry_run:
        _log_picks(bulls + bears)   # record for the EOD scorecard (direction from isBullish)
    picks = bulls + bears
    STATE.clear()
    STATE.update(conf=conf, bulls=bulls, bears=bears, hedges=hedges, names=names, scored=scored,
                 iv_map=_load_iv_map(),
                 ps=_pick_scores([_occ(r[0]) for r in picks], write=not dry_run),
                 levels={_occ(r[0]): _levels(r) for r in picks})
    return render()


def render() -> str:
    """The card from STATE with prices fetched NOW: tape + each pick's spot (quote.v1, Robinhood first) and option
    price (_marks). Every price carries its source + data time; a failed one is UNAVAILABLE. Records each shown
    price in PRICED for the send-time re-check and each miss in MISSING for the loud alert."""
    st = STATE
    bulls, bears, iv_map, ps, lv = st["bulls"], st["bears"], st["iv_map"], st["ps"], st["levels"]
    PRICED.clear()
    for k in [k for k in MISSING if k != "flow_picks underlying spot"]:
        MISSING.pop(k)
    syms = list(dict.fromkeys(_qsym(r[0].get("Symbol")) for r in bulls + bears))
    try:
        q = fresh([t for t, _ in TAPE] + syms)
    except Exception as e:  # noqa: BLE001
        q = {t: {"ok": False, "reason": f"quote.v1 {type(e).__name__}"} for t in [t for t, _ in TAPE] + syms}
    marks = _marks(bulls + bears)
    # refresh each pick's spot/moneyness to the render-time quote (selection ran before the slow enrichment)
    fresh_recs = []
    for a, fv, voi, dte, tag, sp, otm in bulls + bears:
        r = q.get(_qsym(a.get("Symbol"))) or {}
        if r.get("ok"):
            sp = r["price"]
            otm, _ = _moneyness(a, sp)
            PRICED.append((r.get("as_of"), sp))
        else:
            sp = otm = None
        fresh_recs.append((a, fv, voi, dte, tag, sp, otm))
    bulls, bears = fresh_recs[:len(bulls)], fresh_recs[len(bulls):]
    for t, _ in TAPE:
        if (q.get(t) or {}).get("ok"):
            PRICED.append((q[t].get("as_of"), q[t]["price"]))
    for m in marks.values():
        if m.get("ok"):
            PRICED.append((m["as_of"], m["mid"]))
    bad_spot = [f"{s}: {(q.get(s) or {}).get('reason') or 'no quote'}" for s in syms if not (q.get(s) or {}).get("ok")]
    bad_tape = [f"{t}: {(q.get(t) or {}).get('reason') or 'no quote'}" for t, _ in TAPE if not (q.get(t) or {}).get("ok")]
    bad_mark = [(o, m) for o, m in marks.items() if not m.get("ok")]
    if bad_spot or bad_tape:
        MISSING["flow_picks spot/tape"] = [{"source": "quote.v1 (Robinhood → Yahoo → Finnhub)", "ok": False,
                                            "error": "; ".join(bad_spot + bad_tape)[:400]}]
    if bad_mark:
        MISSING["flow_picks option price"] = [
            {"source": "Robinhood marketdata/options", "ok": False,
             "error": "; ".join(f"{o}: {m.get('rh_reason')}" for o, m in bad_mark)[:300]},
            {"source": "Yahoo option chain last trade (not Robinhood)", "ok": False,
             "error": "; ".join(f"{o}: {m['reason'].split('; ', 1)[-1]}" for o, m in bad_mark)[:300]}]

    stamp = datetime.now(ET).strftime("%a %b %-d %-I:%M %p ET")
    lines = [f"🎯 **FLOW PICKS — live contracts** · {stamp}"]
    lines.append(f"_Tape: {_tape(q)}_")
    if st["conf"]:
        lines.append("\n**🟢 TAPE CONFIRMATION (0DTE — direction, not swing buys):**")
        lines += st["conf"]

    def _pickline(idx, rec):
        a, fv, voi, dte, tag, sp, otm = rec
        vol = int(a.get("Volume", 0) or 0)
        oi = int(a.get("OI", 0) or 0)
        why = ("fresh opening flow (vol >> OI)" if voi >= 2 else
               "repeat institutional positioning" if voi < 1 else "building position")
        sq = q.get(_qsym(a.get("Symbol"))) or {}
        occ = _occ(a)
        mny = (f" · spot ${sp:,.2f} ({abs(otm)*100:.0f}% {'OTM' if otm >= 0 else 'ITM'}, {sq.get('src')})" if sp
               else f" · spot UNAVAILABLE ({sq.get('reason') or 'no quote'})")
        line = f"**{idx}. {_fmt(a)}** ({dte} DTE) · ${fv:,.0f} · V/OI {voi:.1f} ({vol:,}/{oi:,}){mny}{tag}\n   *{why}*"
        line += "\n" + _cost_line(marks.get(occ or a.get("OptionSymbol")))
        line += _iv_tag(a, iv_map)   # researched-&-verified stamp when the name was graded
        for lvl in lv.get(occ) or []:
            line += "\n   📐 " + lvl
        if ps.get(occ):
            line += "\n   _" + ps[occ] + "_"
        if _V2_ON and _V2_NOTES.get(a.get("OptionSymbol")):
            line += "\n   _v2 terms: " + "; ".join(_V2_NOTES[a.get("OptionSymbol")]) + "_"
        return line

    if bulls:
        lines.append("\n**⭐ BULLISH SWING PICKS (near-money, fresh, actionable longs):**")
        for i, rec in enumerate(bulls, 1):
            lines.append(_pickline(i, rec))
    if bears:
        lines.append("\n**🔴 BEARISH FLOW TO RESPECT (contra flow — evidence only):**")
        for i, rec in enumerate(bears, 1):
            lines.append(_pickline(i, rec))
    if st["hedges"]:
        lines.append("\n**🛡️ Notable big-money positioning (deep OTM — likely hedges, not buys):**")
        for a, fv, otm, tag in st["hedges"]:
            lines.append(f"• {_fmt(a)} — ${fv:,.0f} ({abs(otm)*100:.0f}% OTM){tag}")
    # your-name caution: largest flow on a held name that reads bearish
    for (s, fv, voi, dte), a in st["scored"]:
        if str(a.get("Symbol", "")).upper() in st["names"] and not a.get("isBullish") and fv > 2_000_000:
            lines.append(f"\n⚠️ **YOUR NAME — {a['Symbol']}:** big flow ({_fmt(a)}, ${fv:,.0f}) reads "
                         f"**bearish** (V/OI {voi:.1f}). Don't mistake size for a green light.")
            break
    lines.append("\n_0DTE = confirmation not entry · cost shown per contract · auto-posted intraday._")
    if bulls or bears:
        lines.append(f"_{LB.FOOTER}_")
    global TOP_ACTION_PICK, ACTIONABLE_PICKS
    TOP_ACTION_PICK = bulls[0] if bulls else (bears[0] if bears else None)
    ACTIONABLE_PICKS = list(bulls) + list(bears)
    for a, *_ in ACTIONABLE_PICKS:   # thread / action-card spot carries its source too
        SPOT_SRC[str(a.get("Symbol", "")).upper()] = (q.get(_qsym(a.get("Symbol"))) or {}).get("src")
    return "\n".join(lines)


def prices_fresh(now: datetime | None = None) -> bool:
    """Send-time re-check (market-data rule §1): every price on the card still passes send_price_check."""
    return all(price_check(ts, px, now=now)["ok"] for ts, px in PRICED)


def _pick_scores(occs: list[str], timeout: int = 240, write: bool = True) -> dict:
    """pick_score.v1 factor line per pick (missionctrl pipeline/decision/pick_score, DECISIONS R35) — display-only,
    never re-ranks. Stores the full tables for /api/pick-score. A failure says so on the card."""
    occs = [o for o in occs if o]
    if not occs:
        return {}
    cmd = [MC_PY, "-m", "pipeline.decision.pick_score.score", "--lines", ",".join(occs)] + (["--write"] if write else [])
    try:
        r = subprocess.run(cmd, cwd=MC_REPO, capture_output=True, text=True, timeout=timeout)
        if r.returncode == 0:
            return json.loads(r.stdout.strip().splitlines()[-1])
        why = f"rc {r.returncode}"
    except (subprocess.TimeoutExpired, OSError, ValueError, IndexError) as e:
        why = type(e).__name__
    return {o: f"pick_score.v1 UNAVAILABLE ({why})" for o in occs}


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
                   f"${fv:,.0f} flow · V/OI {voi:.1f}"
                   + (f" · spot ${sp:,.2f} ({SPOT_SRC.get(sym) or 'src n/a'})" if sp else " · spot UNAVAILABLE")
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
        mny = (f"${sp:,.2f} ({abs(otm)*100:.0f}% {'OTM' if otm >= 0 else 'ITM'}, {SPOT_SRC.get(sym) or 'src n/a'})"
               if sp else "UNAVAILABLE")
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


def _chunks(msg: str, limit: int = 3900) -> list[str]:
    """Split on blank-line section breaks so a Telegram part never cuts a pick (tg_brief truncates past 4000)."""
    parts, cur = [], ""
    for block in msg.split("\n\n"):
        cand = f"{cur}\n\n{block}" if cur else block
        if len(cand) <= limit:
            cur = cand
            continue
        if cur:
            parts.append(cur)
        cur = block[:limit]
    return parts + ([cur] if cur else [])


def _alert_missing(dry_run: bool) -> None:
    """Loud missing-data alert (market-data rule §3) via MissionCtrl's missing_data (system_health lane via tg_fleet,
    once per input per ET day; the state file feeds Data Health). Path-loaded so the pipeline lib stays off sys.path."""
    if not MISSING:
        return
    try:
        import importlib.util
        spec = importlib.util.spec_from_file_location(
            "mc_missing_data", MC_REPO / "pipeline/decision/lib/missing_data.py")
        md = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(md)
        for name, tried in MISSING.items():
            md.alert_missing(name, tried, dry_run=dry_run)
    except Exception as e:  # noqa: BLE001
        print(f"[flow-picks] missing-data alert failed: {type(e).__name__} — inputs {sorted(MISSING)}", flush=True)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="flow-picks")
    ap.add_argument("--print", "--dry-run", action="store_true", dest="print_only")
    a = ap.parse_args()
    msg = build(dry_run=a.print_only)
    if not msg:
        print("[flow-picks] no flow data; skip", flush=True)
        return
    if not prices_fresh():   # the slow steps ran before render(); a price that aged past the guard is re-fetched
        print("[flow-picks] a price aged past the send guard before send — re-rendering", flush=True)
        msg = render()
    if a.print_only:
        print(msg)
        _alert_missing(dry_run=True)
        return
    post(resolve_channel(a.channel), msg)
    _post_action_cards(ACTIONABLE_PICKS)  # button-bearing cards for the top 3 picks (SynthControl)
    _post_pick_threads(ACTIONABLE_PICKS)  # per-pick lifecycle threads (entry; grade follows at EOD)
    beat("flow_picks")
    # 2026-06-24: Flow Picks → flow_digest (fallback daily_briefs so a vault hiccup never silences a pick)
    used = [tg_brief(part, chain=("flow_digest", "daily_briefs")) for part in _chunks(msg)]
    print(f"[flow-picks] posted ({len(msg)} chars) · tg→{','.join(u or 'skip' for u in used)}", flush=True)
    _alert_missing(dry_run=False)
    if MISSING:   # card went out with those values UNAVAILABLE; the run still reports the miss (script-standards §10)
        sys.exit(3)


if __name__ == "__main__":
    main()
