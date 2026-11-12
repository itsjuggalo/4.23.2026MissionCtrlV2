"""flow_report.py — the `/flow <TICKER>` evidence report for the Synth Control Discord bot (Mike 2026-11-11).

One session, one ticker. The prints come from two feeds of the same FlowGreeks tape: flow.db (FlowScraper, the
`flow_events_dedup` view) and the FlowGreeks LiveFlows RTDB stream (lib/flowgreeks). A print seen in both, or as a
single-trade FG alert, is counted once. Per contract the report lists which independent confirmations are present
(an evidence checklist, never a confidence score) and orders contracts by how many there are.

Direction comes from the vendor's ask/bid flag only: calls bought at the ask or puts sold at the bid = bullish; puts
bought at the ask or calls sold at the bid = bearish; an ask/bid premium split closer than 60/40, or no flag = unclear.
Opening vs closing is never guessed: only MissionCtrl's next-day OI check (pipeline/intel/oi_confirm) says it.

Advisory only. No proven edge. No size, no entry/stop/target, no win rate. Every number carries its source and data
time; a missing input prints UNAVAILABLE (<reason>), never a guess or a zero.

Outside regular hours the ticker is queued (with the Discord channel it was asked in) for the next-session OI
follow-up: trade_charts/flow_oi_followup.py.

CLI (prints the report, sends nothing):  ~/.venv/bin/python -m lib.flow_report NVDA [--min-prem 250K]
"""
from __future__ import annotations

import fcntl
import importlib.util
import json
import os
import sqlite3
import statistics
import subprocess
import sys
from collections import Counter
from datetime import date, datetime, time as dtime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
SCRIPTS = Path(__file__).resolve().parents[1]
MC = "/AIWorkWSL/web/missionctrl"
FLOW_DB = Path.home() / "02_DATA/flow-data/flow.db"
EARN_DIR = Path.home() / ".openclaw/data/decision/earnings_next"
BYK_PATH = Path(MC) / "pipeline/lib/bykaranteli.py"
QUEUE_DIR = Path.home() / ".openclaw/data/flow-oi-followup"
QUEUE = QUEUE_DIR / "queue.json"
INTEL_PY = "/home/itsju/.venv/bin/python"

LEG_S = 1.0          # a sweep and the exchange legs it filled in share a timestamp to within ~0.1 s (stream) or the second
DUP_S = 3           # a print seen in two feeds lands within a few seconds (ms vs truncated-second copies)
ALERT_LAG_S = 600    # an FG alert card is written 11–549 s after its print (measured 2026-11-11, n=69)
ONE_WAY = 0.60       # ≥ 60% of a contract's sided premium on one side = one-way; closer than 60/40 = unclear
UNUSUAL_X = 1.5      # session premium ≥ 1.5× the ticker's own 20-session median = unusual (a display threshold)
NORM_N, NORM_MIN = 20, 10
FLAT_PCT = 0.10      # a day move under ±0.10% is "flat": neither agrees nor disagrees
TOP = 30             # contracts considered: the top 30 by premium
SHOW = {"bull": 4, "bear": 4, "unclear": 3}
# Spot crypto ETFs → the coin whose perpetual is context for them (labelled as such, never as the ETF itself)
CRYPTO_ETF = {"IBIT": "BTC", "FBTC": "BTC", "GBTC": "BTC", "BITB": "BTC", "ARKB": "BTC", "BTCO": "BTC", "HODL": "BTC",
              "BITO": "BTC", "ETHA": "ETH", "ETHE": "ETH", "FETH": "ETH"}
CRYPTO = {"BTC", "ETH", "SOL", "XRP", "DOGE", "ADA", "AVAX", "LINK", "LTC", "BCH", "DOT", "UNI", "AAVE", "XLM", "HBAR",
          "ALGO", "ATOM", "NEAR", "SUI", "APT", "ARB", "OP", "SHIB", "PEPE", "ZEC", "CRO", "ETC", "FIL", "ICP", "XTZ"}
LEGEND = ("Direction = vendor ask/bid flag only: calls at ask or puts at bid 🟢 · puts at ask or calls at bid 🔴 · "
          "split closer than 60/40 or no flag ⚪")
FOOT = ["_Vendor flag = the feed's ask/bid tag; not NBBO-checked (we do not store the quote at print time)._",
        "_Prints ≥ $50K only (FlowGreeks feeds), not the full OPRA tape. Opening vs closing only from the next-day OI "
        "check. No proven edge; advisory only, no size or levels._"]


# ─── formatting ───────────────────────────────────────────────────────────────
def money(x: float | None) -> str:
    if x is None:
        return "n/a"
    a = abs(x)
    v = f"${a / 1e9:.2f}B" if a >= 1e9 else f"${a / 1e6:.2f}M" if a >= 1e6 else f"${a / 1e3:.0f}K" if a >= 1e3 else f"${a:.0f}"
    return ("-" if x < 0 else "") + v


def hm(t: float | None) -> str:
    return datetime.fromtimestamp(t, ET).strftime("%H:%M") if t else "?"


def label(c: dict) -> str:
    try:
        e = date.fromisoformat(c["exp"]).strftime("%m/%d/%y")
    except (TypeError, ValueError):
        e = "exp ?"
    return f"{c['sym']} {c['strike']:g}{c['cp']} {e}"


def occ(c: dict) -> str | None:
    try:
        y, m, d = c["exp"].split("-")
        return f"{c['sym']}{y[-2:]}{m}{d}{c['cp']}{round(float(c['strike']) * 1000):08d}"
    except (AttributeError, ValueError):
        return None


# ─── prints: normalize, dedupe, alerts ────────────────────────────────────────
def _iso_exp(e) -> str | None:
    s = str(e or "")[:10]
    for fmt in ("%Y-%m-%d", "%m/%d/%y"):
        try:
            return datetime.strptime(s if fmt == "%Y-%m-%d" else str(e), fmt).date().isoformat()
        except ValueError:
            continue
    return None


def print_from_db(r: dict) -> dict:
    side = (r.get("bid_ask") or "").upper()[:1]
    return {"sym": str(r["symbol"]).upper(), "cp": str(r["option_type"] or "?")[:1].upper(), "strike": float(r["strike"]),
            "exp": _iso_exp(r.get("expiry")), "t": r["event_time"] / 1000, "premium": float(r["premium"] or 0),
            "volume": None if r.get("volume") is None else int(r["volume"]),
            "oi": None if r.get("open_interest") is None else int(r["open_interest"]),
            "side": side if side in ("A", "B") else None, "kind": (r.get("block_type") or "").upper(),
            "src": {"flow.db"}, "copies": 1}


def print_from_live(s: dict) -> dict:
    """A lib/flowgreeks LiveFlows signal (already collapsed with its same-feed copies: s['dup'])."""
    return {"sym": s["sym"], "cp": s["cp"], "strike": float(s["strike"]), "exp": _iso_exp(s["exp"]),
            "t": s["ts"].timestamp(), "premium": float(s["premium"]), "volume": s.get("size"), "oi": s.get("oi"),
            "side": {"ask": "A", "bid": "B"}.get(s.get("side") or ""), "kind": (s.get("kind") or "").upper(),
            "src": {s["resource"].split(" ")[0] + " LiveFlows"}, "copies": int(s.get("dup") or 1)}


def alert_from_sig(s: dict) -> dict:
    return {"sym": s["sym"], "cp": s["cp"], "strike": float(s["strike"]), "exp": _iso_exp(s["exp"]),
            "t": s["ts"].timestamp(), "premium": float(s["premium"]), "volume": s.get("size"), "oi": s.get("oi"),
            "view": s.get("view") or "", "type": s["resource"].replace("FG Alerts ", "").replace("FG2 Alerts ", ""),
            "trades": s.get("trades")}


def _ckey(p: dict) -> tuple:
    return p["sym"], p["cp"], p["strike"], p["exp"]


def dedup(prints: list[dict], window: float = DUP_S) -> tuple[list[dict], int]:
    """Count a print once across feeds: same contract, side, premium (to the dollar) and volume, from a feed the kept
    copy does not already have, within `window` seconds. Two identical prints from the SAME feed stay two prints (each
    feed already collapses its own repeats). Returns (unique prints, duplicate copies removed incl. same-feed ones)."""
    out: list[dict] = []
    last: dict[tuple, dict] = {}
    removed = 0
    for p in sorted(prints, key=lambda p: p["t"]):
        removed += max(0, int(p.get("copies", 1)) - 1)
        k = _ckey(p) + (p["side"], round(p["premium"]), p["volume"])
        q = last.get(k)
        if q is not None and p["t"] - q["t"] <= window and not (p["src"] & q["src"]):
            q["src"] |= p["src"]
            if q.get("oi") is None:
                q["oi"] = p.get("oi")
            removed += 1
            continue
        q = {**p, "src": set(p["src"]), "alerts": []}
        out.append(q)
        last[k] = q
    return out, removed


def fold_legs(prints: list[dict], window: float = LEG_S) -> tuple[list[dict], int, float]:
    """The LiveFlows stream shows a sweep AND the exchange legs it was filled in as separate BLOCK rows in the same
    second (11-11: 1,597 of 1,721 sweep+block clusters had the blocks at the sweep's price and side with their volume
    inside the sweep's; unrelated prints would overshoot about half the time). Adding both counts the order twice.
    A BLOCK is folded into a sweep when it is the same contract and side, within `window` seconds, at the same
    per-contract price (±1%), and the folded volume stays within the sweep's volume. A block that does not fit stays
    a print of its own. Returns (prints without the legs, legs folded, premium folded)."""
    by: dict[tuple, list[dict]] = {}
    for p in prints:
        by.setdefault(_ckey(p) + (p["side"],), []).append(p)
    gone: set[int] = set()
    folded = 0.0
    for group in by.values():
        sweeps = sorted((p for p in group if "SWEEP" in (p.get("kind") or "") and p.get("volume")),
                        key=lambda p: -p["volume"])
        blocks = [p for p in group if (p.get("kind") or "") == "BLOCK" and p.get("volume")]
        if not sweeps or not blocks:
            continue
        for s in sweeps:
            px, room = s["premium"] / s["volume"], s["volume"]
            for b in sorted(blocks, key=lambda b: abs(b["t"] - s["t"])):
                if id(b) in gone or abs(b["t"] - s["t"]) > window or b["volume"] > room:
                    continue
                if abs(b["premium"] / b["volume"] - px) > 0.01 * px:
                    continue
                gone.add(id(b))
                room -= b["volume"]
                folded += b["premium"]
                s["legs"] = s.get("legs", 0) + 1
                s["src"] |= b["src"]
    return [p for p in prints if id(p) not in gone], len(gone), folded


def attach_alerts(prints: list[dict], alerts: list[dict]) -> tuple[list[dict], int]:
    """A single-trade FG alert is the same print as a tape row (same contract, volume, premium ±0.2%, printed 0–10 min
    before the alert): it is merged into that print. An unmatched single-trade alert is a print the feeds missed and
    is added (no side flag). Multi-trade alerts are summaries of several prints: returned, never added to totals.
    Returns (summaries, alerts merged)."""
    by: dict[tuple, list[dict]] = {}
    for p in prints:
        by.setdefault(_ckey(p), []).append(p)
    summaries, merged = [], 0
    for a in sorted(alerts, key=lambda a: a["t"]):
        if a.get("trades") != 1:
            summaries.append(a)
            continue
        cands = [p for p in by.get(_ckey(a), []) if not p["alerts"] and p["volume"] == a["volume"]
                 and abs(p["premium"] - a["premium"]) <= max(1.0, 0.002 * a["premium"]) and -5 <= a["t"] - p["t"] <= ALERT_LAG_S]
        if cands:
            p = min(cands, key=lambda p: abs(a["t"] - p["t"]))
            p["alerts"].append(a)
            p["src"].add("FG Alerts")
            merged += 1
        else:
            p = {**{k: a[k] for k in ("sym", "cp", "strike", "exp", "t", "premium", "volume", "oi")}, "side": None,
                 "kind": "", "src": {"FG Alerts"}, "copies": 1, "alerts": [a]}
            prints.append(p)
            by.setdefault(_ckey(a), []).append(p)
    return summaries, merged


def aggregate(prints: list[dict], summaries: list[dict] = ()) -> list[dict]:
    """Per contract: premium, ask/bid premium (vendor flag), prints, sweeps/blocks, volume, OI, first/last time, and the
    FG views / alert types seen on it (alerts are tags, not evidence)."""
    acc: dict[tuple, dict] = {}
    for p in prints:
        c = acc.setdefault(_ckey(p), {"sym": p["sym"], "cp": p["cp"], "strike": p["strike"], "exp": p["exp"], "premium": 0.0,
                                       "ask": 0.0, "bid": 0.0, "noside": 0.0, "prints": 0, "sweeps": 0, "blocks": 0,
                                       "volume": 0, "vol_known": False, "oi": None, "first": p["t"], "last": p["t"],
                                       "views": Counter(), "types": Counter()})
        c["premium"] += p["premium"]
        c[{"A": "ask", "B": "bid"}.get(p["side"] or "", "noside")] += p["premium"]
        c["prints"] += 1
        c["sweeps"] += "SWEEP" in (p.get("kind") or "")
        c["blocks"] += (p.get("kind") or "") == "BLOCK"
        if p.get("volume") is not None:
            c["volume"] += int(p["volume"])
            c["vol_known"] = True
        if p.get("oi") is not None:
            c["oi"] = max(c["oi"] or 0, int(p["oi"]))
        c["first"], c["last"] = min(c["first"], p["t"]), max(c["last"], p["t"])
        for a in p.get("alerts") or []:
            if a.get("view"):
                c["views"][a["view"]] += 1
            c["types"][a["type"]] += 1
    for a in summaries:
        c = acc.get(_ckey(a))
        if c is not None:
            if a.get("view"):
                c["views"][a["view"]] += 1
            c["types"][a["type"]] += 1
    return sorted(acc.values(), key=lambda c: -c["premium"])


# ─── direction + evidence (pure) ──────────────────────────────────────────────
def direction(c: dict) -> tuple[str, float | None]:
    """('bull' | 'bear' | 'unclear', ask share of the sided premium or None when no prints carry a side flag)."""
    sided = c["ask"] + c["bid"]
    if sided <= 0:
        return "unclear", None
    ask = c["ask"] / sided
    if ask >= ONE_WAY:
        return ("bull" if c["cp"] == "C" else "bear"), ask
    if ask <= 1 - ONE_WAY:
        return ("bear" if c["cp"] == "C" else "bull"), ask
    return "unclear", ask


YES, NO, NA, AGAINST = "yes", "no", "na", "against"


def evidence(c: dict, ctx: dict) -> list[tuple[str, str, str]]:
    """[(item, state, plain words)] for one contract. state: yes / no / na (UNAVAILABLE, not counted) / against.
    ctx: session (date), norm {mult, ...} or {na}, move {pct} or {na}, oi {occ: oi_confirm row} (may be empty)."""
    d, share = direction(c)
    out = []
    if share is None:
        out.append(("one-way", NA, "no side flag"))
    elif max(share, 1 - share) >= ONE_WAY:
        out.append(("one-way", YES, f"{max(share, 1 - share):.0%} at the {'ask' if share >= 0.5 else 'bid'}"))
    else:
        out.append(("one-way", NO, f"split {share:.0%} ask / {1 - share:.0%} bid"))
    if c["oi"] is None or not c["vol_known"]:
        out.append(("vol>OI", NA, "OI not reported" if c["oi"] is None else "volume not reported"))
    elif c["volume"] > c["oi"]:
        out.append(("vol>OI", YES, f"vol {c['volume']:,} > OI {c['oi']:,}"))
    else:
        out.append(("vol>OI", NO, f"vol {c['volume']:,} ≤ OI {c['oi']:,}"))
    out.append(("repeat", YES if c["prints"] >= 3 else NO,
                f"{c['prints']} prints" if c["prints"] >= 3 else f"only {c['prints']} print{'s' if c['prints'] > 1 else ''}"))
    n = ctx.get("norm") or {"na": "not computed"}
    if "na" in n:
        out.append(("unusual", NA, f"premium norm UNAVAILABLE ({n['na']})"))
    else:
        out.append(("unusual", YES if n["mult"] >= UNUSUAL_X else NO,
                    f"ticker premium {n['mult']:.1f}× norm" + ("" if n["mult"] >= UNUSUAL_X else " (not unusual)")))
    m = ctx.get("move") or {"na": "not computed"}
    if d == "unclear":
        out.append(("stock", NA, "stock move: no direction to compare"))
    elif "na" in m:
        out.append(("stock", NA, f"stock move UNAVAILABLE ({m['na']})"))
    elif abs(m["pct"]) < FLAT_PCT:
        out.append(("stock", NO, f"stock flat {m['pct']:+.2f}%"))
    else:
        agree = (m["pct"] > 0) == (d == "bull")
        out.append(("stock", YES if agree else NO, f"stock {m['pct']:+.1f}% {'agrees' if agree else 'disagrees'}"))
    r = (ctx.get("oi") or {}).get(occ(c))
    if r is not None:   # only when the next-day OI check exists for this contract
        if r["verdict"] == "OPENING":
            out.append(("OI next day", YES, f"next-day OI OPENING ({r['prior_oi']:,}→{r['new_oi']:,})"))
        elif r["verdict"] == "PENDING":
            out.append(("OI next day", NA, "next-day OI PENDING"))
        else:
            out.append(("OI next day", NO, f"next-day OI {r['verdict']}"))
    try:
        dte = (date.fromisoformat(c["exp"]) - ctx["session"]).days
    except (TypeError, ValueError):
        dte = None
    if dte is None:
        out.append(("expiry", NA, "expiry not reported"))
    elif dte <= 0:
        out.append(("expiry", AGAINST, "0DTE/expired"))
    elif dte == 1:
        out.append(("expiry", NO, "1 day to expiry"))
    else:
        out.append(("expiry", YES, f"{dte} days to expiry"))
    return out


def count(items: list[tuple[str, str, str]]) -> int:
    return sum(s == YES for _, s, _ in items) - sum(s == AGAINST for _, s, _ in items)


def rank(contracts: list[dict], ctx: dict, top: int = TOP) -> dict[str, list[tuple[dict, list, int]]]:
    """Top `top` contracts by premium → {'bull'|'bear'|'unclear': [(contract, items, count)]}, most evidence first
    (ties: bigger premium first)."""
    groups: dict[str, list] = {"bull": [], "bear": [], "unclear": []}
    for c in sorted(contracts, key=lambda c: -c["premium"])[:top]:
        items = evidence(c, ctx)
        groups[direction(c)[0]].append((c, items, count(items)))
    for g in groups.values():
        g.sort(key=lambda x: (-x[2], -x[0]["premium"]))
    return groups


def norm_eval(today: float, hist: list[float]) -> dict:
    """Session premium vs the ticker's own recent sessions (sessions with no prints count as $0)."""
    if len(hist) < NORM_MIN:
        return {"na": f"only {len(hist)} stored sessions, {NORM_MIN} needed"}
    med = statistics.median(hist)
    if med <= 0:
        return {"na": f"median $0: prints on {sum(1 for h in hist if h > 0)} of {len(hist)} sessions"}
    return {"mult": today / med, "median": med, "n": len(hist), "today": today}


# ─── render (pure) ────────────────────────────────────────────────────────────
_MARK = {YES: "✅", NO: "❌", NA: "❔", AGAINST: "⛔"}


def render_contract(i: int, c: dict, items: list, n: int) -> list[str]:
    kinds = " · ".join(x for x in (f"{c['sweeps']} sweep{'s' * (c['sweeps'] != 1)}" if c["sweeps"] else "",
                                    f"{c['blocks']} block{'s' * (c['blocks'] != 1)}" if c["blocks"] else "") if x)
    fg = ""
    if c["views"]:
        fg = " · FG's own tag " + ("mixed" if c["views"]["bull"] and c["views"]["bear"] else
                                   ("🟢" if c["views"]["bull"] else "🔴")) + " (not used)"
    head = (f"{i}. **{label(c)}** · {money(c['premium'])} · {c['prints']} print{'s' * (c['prints'] != 1)}"
            + (f" ({kinds})" if kinds else "") + f" · {hm(c['first'])}–{hm(c['last'])} · evidence {n}{fg}")
    out = [head]
    yes = [t for _, s, t in items if s == YES]
    rest = [f"{_MARK[s]} {t}" for _, s, t in items if s != YES]
    if yes:
        out.append("   ✅ " + " · ".join(yes))
    if rest:
        out.append("   " + " · ".join(rest))
    return out


def render(*, sym: str, session: date, prints: list[dict], removed: int, summaries: list[dict], ctx: dict,
           data_times: str, context: list[str], fg_block: str = "", tape_block: str = "", stale: list[str] = (),
           queued: str | None = None, band: str = "", legs: int = 0, legs_prem: float = 0.0,
           both: int | None = None) -> str:
    contracts = aggregate(prints, summaries)
    calls = [p for p in prints if p["cp"] == "C"]
    puts = [p for p in prints if p["cp"] == "P"]
    if both is None:
        both = sum(1 for p in prints if len(p["src"] - {"FG Alerts"}) > 1)
    alerted = sum(1 for p in prints if p.get("alerts") and len(p["src"]) > 1)
    out = [f"**{sym} options flow · evidence report · session {session:%a %m/%d}**{band}",
           (f"{len(prints):,} print{'s' * (len(prints) != 1)} after dedup · calls {money(sum(p['premium'] for p in calls))} "
            f"({len(calls):,}) · puts {money(sum(p['premium'] for p in puts))} ({len(puts):,})" if prints else
            f"No prints ≥ $50K for {sym} in the {session:%m/%d} session (flow.db and FG LiveFlows)"),
           f"Duplicates removed: {removed:,}" + (
               f" ({both:,} in both flow.db and the LiveFlows stream, {alerted:,} FG alerts that were the same print"
               + (f", {removed - both - alerted:,} repeat copies inside one feed" if removed - both - alerted > 0 else "")
               + "; each counted once)" if removed else ""),
           *([f"Sweep legs not added: {legs:,} blocks ({money(legs_prem)}) printed in the same second as a sweep, same "
              "side and price, volume inside the sweep's: counted as part of that sweep"] if legs else []),
           *([f"{len(summaries)} FG alert summaries ({money(sum(a['premium'] for a in summaries))}) total several prints "
              "each: tags only, not added"] if summaries else []),
           f"Data: {data_times}",
           LEGEND + ".",
           f"Top {min(TOP, len(contracts))} contract{'s' * (min(TOP, len(contracts)) != 1)} by premium, most evidence first (✅ present, ❌ absent, "
           "❔ UNAVAILABLE, ⛔ counts against).",
           ("Next-day OI check: " + (f"stored for {ctx['oi_n']} of these contracts" if ctx.get("oi_n") else
                                     f"none stored for {session:%m/%d} yet ({ctx.get('oi_why', 'runs 10:35 ET next session')})"))]
    if queued:
        out.append(queued)
    groups = rank(contracts, ctx)
    titles = {"bull": "🟢 **Bullish evidence**", "bear": "🔴 **Bearish evidence**", "unclear": "⚪ **Unclear or mixed**"}
    for g in ("bull", "bear", "unclear"):
        rows = groups[g]
        out.append("")
        out.append(f"{titles[g]} · {len(rows)} contract{'s' * (len(rows) != 1)} · evidence count · no proven edge")
        if not rows:
            out.append("none")
        for i, (c, items, n) in enumerate(rows[:SHOW[g]], 1):
            out += render_contract(i, c, items, n)
        if len(rows) > SHOW[g]:
            out.append(f"…{len(rows) - SHOW[g]} more in this group (lower evidence or premium)")
    out += ["", "**Context**", *[f"• {x}" for x in context]]
    if fg_block:
        out += ["", fg_block]
    if tape_block:
        out += ["", tape_block]
    out.append("")
    if stale:
        out += ["Stale or empty sources:", *(f"• {x}" for x in stale)]
    out += FOOT
    return "\n".join(out)


# ─── context readers (each returns a line; a failure says UNAVAILABLE + why) ──
def _mc_path() -> None:
    if MC not in sys.path:
        sys.path.append(MC)   # append: MissionCtrl's pipeline/ has its own lib/ that must not shadow ~/scripts/lib


def _clock():
    _mc_path()
    from pipeline.market_clock import clock
    return clock


def session_for(now: datetime, clock=None) -> date:
    """The session the report is about: today once the regular session has opened, else the previous trading day."""
    try:
        clock = clock or _clock()
        d = now.astimezone(ET).date()
        if clock.is_trading_day(d) and now >= clock.session_open(d):
            return d
        return clock.previous_trading_day(d)
    except Exception:  # noqa: BLE001 — calendar unreadable: weekday rule
        d = now.astimezone(ET).date()
        if now.astimezone(ET).time() < dtime(9, 30):
            d -= timedelta(days=1)
        while d.weekday() >= 5:
            d -= timedelta(days=1)
        return d


def outside_rth(now: datetime, clock=None) -> bool:
    """True after 16:00 ET (13:00 on a half day), before 09:30 ET, on a weekend or a holiday (market_clock)."""
    try:
        return not (clock or _clock()).is_open(now)
    except Exception:  # noqa: BLE001
        t = now.astimezone(ET)
        return t.weekday() >= 5 or not (dtime(9, 30) <= t.time() < dtime(16, 0))


def _ro(path: Path) -> sqlite3.Connection:
    con = sqlite3.connect(f"file:{path}?mode=ro", uri=True, timeout=10)
    con.row_factory = sqlite3.Row
    return con


def load_db(sym: str, d: date) -> list[dict]:
    s = datetime.combine(d, dtime(0, 0), tzinfo=ET).timestamp() * 1000
    con = _ro(FLOW_DB)
    try:
        return [dict(r) for r in con.execute(
            "SELECT event_time, symbol, option_type, strike, expiry, premium, volume, open_interest, bid_ask, block_type "
            "FROM flow_events_dedup WHERE symbol=? AND event_time>=? AND event_time<?", (sym, s, s + 86_400_000))]
    finally:
        con.close()


def norm_history(sym: str, d: date, clock=None) -> tuple[list[float], str]:
    """Premium per session for the NORM_N trading days before d (flow.db rollup); a day the whole tape is empty is an
    ingest gap and is skipped, a day with tape but no prints for this ticker counts as $0."""
    clock = clock or _clock()
    days, x = [], d
    while len(days) < NORM_N:
        x = clock.previous_trading_day(x)
        days.append(x.isoformat())
    con = _ro(FLOW_DB)
    try:
        q = ",".join("?" * len(days))
        tape = {r[0]: r[1] for r in con.execute(
            f"SELECT day, sum(prints) FROM flow_events_dedup_daily WHERE day IN ({q}) GROUP BY day", days)}
        mine = {r[0]: r[1] for r in con.execute(
            f"SELECT day, premium FROM flow_events_dedup_daily WHERE symbol=? AND day IN ({q})", [sym, *days])}
    finally:
        con.close()
    used = [dd for dd in days if tape.get(dd)]
    hist = [float(mine.get(dd) or 0) for dd in used]
    span = f"{date.fromisoformat(used[-1]):%m/%d}–{date.fromisoformat(used[0]):%m/%d}" if used else "none"
    return hist, span


def ctx_norm(sym: str, d: date, today: float, live: bool) -> tuple[dict, str]:
    try:
        hist, span = norm_history(sym, d)
    except Exception as e:  # noqa: BLE001
        n = {"na": f"flow.db rollup unreadable: {type(e).__name__}"}
        return n, f"Flow vs norm: UNAVAILABLE ({n['na']})"
    n = norm_eval(today, hist)
    if "na" in n:
        return n, f"Flow vs norm: UNAVAILABLE ({n['na']}) · flow.db"
    return n, (f"Flow vs norm: {money(today)} {'so far today' if live else 'this session'} = {n['mult']:.1f}× its "
               f"{n['n']}-session median {money(n['median'])} ({span}; flow.db ≥$50K prints"
               + ("; session still open" if live else "") + ")")


def ctx_stock(sym: str, d: date, now: datetime) -> tuple[dict, list[str]]:
    """Price first from Robinhood (quote), day move from daily bars (Robinhood, Yahoo labelled when RH is behind)."""
    if str(SCRIPTS / "trade_charts") not in sys.path:
        sys.path.append(str(SCRIPTS / "trade_charts"))
    if sym in CRYPTO:
        try:
            import ta_cmd
            df, src = ta_cmd.crypto_bars(sym, "1d")
            c0, c1 = float(df["Close"].iloc[-2]), float(df["Close"].iloc[-1])
            pct = (c1 / c0 - 1) * 100
            return {"pct": pct}, [f"Price: {sym} coin ${c1:,.2f}, {pct:+.2f}% vs the prior UTC day close ({src}, bar "
                                  f"{df.index[-1]:%m/%d} UTC)",
                                  f"Options printed under the ticker {sym} are a US-listed exchange product, not the coin"]
        except Exception as e:  # noqa: BLE001
            return {"na": type(e).__name__}, [f"Price: UNAVAILABLE ({type(e).__name__}: {str(e)[:80]})"]
    q_line = ""
    quote = None
    try:
        from lib.rh_quote import rh_equity_quotes
        diag: dict = {}
        quote = rh_equity_quotes([sym], diag=diag).get(sym)
        if quote and quote.get("last"):
            at = datetime.fromtimestamp(quote["as_of"], ET)
            q_line = (f"Price: {sym} last ${quote['last']:,.2f} at {at:%m/%d %H:%M} ET (Robinhood quote"
                      + (", extended hours" if outside_rth(at) else "") + ")")
        else:
            q_line = f"Price: Robinhood quote UNAVAILABLE ({diag.get(sym, 'no row')})"
    except Exception as e:  # noqa: BLE001
        q_line = f"Price: Robinhood quote UNAVAILABLE ({type(e).__name__})"
    try:
        import ta_cmd
        df, src = ta_cmd.stock_bars(sym, "1d")
        days = [ix.date() for ix in df.index]
        if d in days:
            i = days.index(d)
            if i == 0:
                raise ValueError("no prior bar")
            c0, c1 = float(df["Close"].iloc[i - 1]), float(df["Close"].iloc[i])
            pct = (c1 / c0 - 1) * 100
            return {"pct": pct}, [q_line, f"Day move {d:%m/%d}: {pct:+.2f}% (close ${c1:,.2f} vs {days[i - 1]:%m/%d} "
                                          f"${c0:,.2f}) · {src}"]
        if quote and quote.get("last") and days and days[-1] < d:
            c0 = float(df["Close"].iloc[-1])
            pct = (quote["last"] / c0 - 1) * 100
            return {"pct": pct}, [q_line, f"Day move {d:%m/%d}: {pct:+.2f}% so far (Robinhood last vs {days[-1]:%m/%d} "
                                          f"close ${c0:,.2f}, {src})"]
        return {"na": f"no {d:%m/%d} bar"}, [q_line, f"Day move: UNAVAILABLE (no {d:%m/%d} bar in {src})"]
    except Exception as e:  # noqa: BLE001
        return {"na": type(e).__name__}, [q_line, f"Day move: UNAVAILABLE ({type(e).__name__}: {str(e)[:80]})"]


def ctx_darkpool(sym: str) -> str:
    try:
        _mc_path()
        from pipeline.darkpool import _common as C
        d = C.load_latest()
    except Exception as e:  # noqa: BLE001
        return f"Dark pool: UNAVAILABLE ({type(e).__name__})"
    s = (d.get("symbols") or {}).get(sym)
    if not s:
        return (f"Dark pool: UNAVAILABLE ({sym} is outside the S&P universe the FINRA layer covers) · pipeline/darkpool "
                f"as of {d.get('asOf') or 'n/a'}")
    try:
        day = datetime.strptime(str(s.get("date")), "%Y%m%d").strftime("%m/%d")
    except ValueError:
        day = str(s.get("date"))
    z = s.get("z20")
    return (f"Dark pool {day}: off-exchange {s['dpShareDaily']:.1%} of volume (z20 {z:+.2f}{', ELEVATED' if s.get('flag') else ''}) "
            f"· short-vol {s['shortVolRatio']:.1%} · not directional · FINRA via pipeline/darkpool, {d.get('asOf')}"
            if z is not None else
            f"Dark pool {day}: off-exchange {s['dpShareDaily']:.1%} · short-vol {s['shortVolRatio']:.1%} · FINRA, {d.get('asOf')}")


_BYK = None


def _byk():
    global _BYK
    if _BYK is None:
        spec = importlib.util.spec_from_file_location("mc_bykaranteli", BYK_PATH)
        mod = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(mod)
        _BYK = mod
    return _BYK


def _utc_to_et(s) -> str:
    try:
        return datetime.fromisoformat(str(s).replace("Z", "+00:00")).astimezone(ET).strftime("%m/%d %H:%M ET")
    except ValueError:
        return str(s)


def perp_line(sym: str, r: dict) -> str:
    """Bykaranteli pressure envelope → one context line (pure; r = bykaranteli.get(...))."""
    coin = CRYPTO_ETF.get(sym) or (sym if sym in CRYPTO else None)
    t = coin or sym
    pair = f"{t}USDT"
    note = f" ({sym} tracks {coin})" if coin and coin != sym else ""
    if r.get("error") == "HTTP 404":
        return f"Perp: no perpetual for this ticker (Bykaranteli has no {pair})"
    d = r.get("data")
    if not r.get("ok") and r.get("status") != "STALE" or not isinstance(d, dict):
        return f"Perp: UNAVAILABLE ({r.get('error') or 'no data'})"
    comp = d.get("components") or {}
    bits = [str(d.get("regimeLabel") or d.get("regime") or "regime n/a")]
    if d.get("openInterestUsd") is not None:
        bits.append(f"OI {money(float(d['openInterestUsd']))}"
                    + (f" ({comp['oi24hPct']:+.0f}% 24h)" if comp.get("oi24hPct") is not None else ""))
    if comp.get("fundingRatePct") is not None:
        bits.append(f"funding {comp['fundingRatePct']:+.3f}%")
    stale = " · STALE copy" if r.get("status") == "STALE" else ""
    return (f"Perp: crypto-venue perpetual on {t}{note}, not the stock or its options: " + " · ".join(bits)
            + f" · Bykaranteli {_utc_to_et(r.get('as_of'))}{stale}")


def ctx_perp(sym: str) -> str:
    t = CRYPTO_ETF.get(sym) or sym
    try:
        return perp_line(sym, _byk().get(f"/api/public/pressure/{t}USDT"))
    except Exception as e:  # noqa: BLE001
        return f"Perp: UNAVAILABLE ({type(e).__name__})"


def ctx_earnings(sym: str, d: date) -> str:
    p = EARN_DIR / f"{sym}.json"
    try:
        j = json.loads(p.read_text())
    except (OSError, ValueError):
        return f"Earnings: UNAVAILABLE (no local calendar entry for {sym})"
    when = _utc_to_et(j.get("fetched_at"))
    rows = sorted((r for r in j.get("rows") or [] if str(r.get("date") or "") >= d.isoformat()), key=lambda r: r["date"])
    if j.get("error"):
        return f"Earnings: UNAVAILABLE ({str(j['error'])[:80]}) · Finnhub cache {when}"
    if not rows:
        return f"Earnings: none listed (Finnhub cache, fetched {when})"
    r = rows[0]
    hour = {"amc": "after close", "bmo": "before open", "dmh": "during market"}.get(r.get("hour") or "", "time n/a")
    return (f"Earnings: next {date.fromisoformat(r['date']):%a %m/%d} {hour} (Finnhub cache fetched {when}; "
            "may be a projection until confirmed)")


def ctx_oi(sym: str, d: date) -> tuple[dict, str | None]:
    try:
        _mc_path()
        from pipeline.intel import oi_confirm
        rows = oi_confirm.read(sym, d=d.isoformat())
        return {r["occ"]: r for r in rows}, None
    except Exception as e:  # noqa: BLE001
        return {}, f"check unreadable: {type(e).__name__}"


def intel_flow(sym: str, lo: float | None, hi: float | None, timeout: int = 90) -> str:
    """MissionCtrl's existing tape/OI block (pipeline.intel.query flow), unchanged."""
    args = [INTEL_PY, "-m", "pipeline.intel.query", "flow", sym]
    args += ["--min-prem", f"{lo:.0f}"] if lo is not None else []
    args += ["--max-prem", f"{hi:.0f}"] if hi is not None else []
    try:
        r = subprocess.run(args, capture_output=True, text=True, timeout=timeout, cwd=MC)
        out = (r.stdout or "").strip()
        if r.returncode != 0:
            return f"⚠️ tape block UNAVAILABLE (intel rc={r.returncode}: {(r.stderr or out).strip()[-200:]})"
        return out or "tape block UNAVAILABLE (intel returned nothing)"
    except subprocess.TimeoutExpired:
        return f"⚠️ tape block UNAVAILABLE (intel timed out after {timeout}s)"


# ─── morning OI follow-up queue ───────────────────────────────────────────────
class _Lock:
    def __init__(self, path: Path):
        self.path = path

    def __enter__(self):
        self.path.parent.mkdir(parents=True, exist_ok=True)
        self.fh = open(self.path.with_suffix(".lock"), "w")
        fcntl.flock(self.fh, fcntl.LOCK_EX)
        return self

    def __exit__(self, *exc):
        fcntl.flock(self.fh, fcntl.LOCK_UN)
        self.fh.close()


def read_queue(path: Path = QUEUE) -> list[dict]:
    try:
        q = json.loads(path.read_text())
        return q if isinstance(q, list) else []
    except (OSError, ValueError):
        return []


def write_queue(entries: list[dict], path: Path = QUEUE) -> None:
    tmp = path.with_suffix(".tmp")
    tmp.write_text(json.dumps(entries, indent=1))
    tmp.replace(path)


def enqueue(sym: str, channel_id, session: date, now: datetime, path: Path = QUEUE) -> bool:
    """Add (ticker, channel, session) once. True when added, False when already queued."""
    with _Lock(path):
        q = read_queue(path)
        key = (sym, str(channel_id), session.isoformat())
        if any((e.get("sym"), str(e.get("channel_id")), e.get("session")) == key for e in q):
            return False
        q.append({"sym": sym, "channel_id": str(channel_id), "session": session.isoformat(),
                  "queued_at": now.astimezone(ET).isoformat(timespec="seconds")})
        write_queue(q, path)
        return True


def maybe_queue(sym: str, channel_id, session: date, now: datetime, clock=None, path: Path = QUEUE) -> str | None:
    """Queue the ticker for the next-session OI follow-up when asked outside regular hours. Returns the line to show."""
    if channel_id is None or not outside_rth(now, clock):
        return None
    try:
        added = enqueue(sym, channel_id, session, now, path)
    except OSError as e:
        return f"🕘 Morning OI follow-up: could not queue ({type(e).__name__})"
    return (f"🕘 Asked outside market hours: {sym} {'is now' if added else 'was already'} queued for the next-session OI "
            f"check of {session:%m/%d}. It posts here and on Telegram once the new OI is in (about 10:45 ET).")


# ─── assemble (impure) ────────────────────────────────────────────────────────
def report(sym: str, *, lo: float | None = None, hi: float | None = None, channel_id=None,
           now: datetime | None = None, tape: bool = True) -> str:
    from lib import flowgreeks as F
    sym = sym.strip().upper().lstrip("$")
    now = (now or datetime.now(ET)).astimezone(ET)
    d = session_for(now)
    since = datetime.combine(d, dtime(0, 0), tzinfo=ET)
    end = min(since + timedelta(days=1), now + timedelta(minutes=1))
    status: dict = {}
    alerts_all = [s for s in F.load_alerts(status) if since <= s["ts"] < end]
    live_all = F.load_liveflows(since, end, status)
    band = "" if lo is None and hi is None else f" · premium {money(lo) if lo is not None else '$0'}–{money(hi) if hi is not None else 'any'}"
    keep = lambda p: (lo is None or p["premium"] >= lo) and (hi is None or p["premium"] <= hi)  # noqa: E731
    try:
        db_rows = load_db(sym, d)
        db_note = f"flow.db {datetime.fromtimestamp(FLOW_DB.stat().st_mtime, ET):%H:%M} ET"
    except Exception as e:  # noqa: BLE001
        db_rows, db_note = [], f"flow.db UNAVAILABLE ({type(e).__name__})"
    raw = [print_from_db(r) for r in db_rows] + [print_from_live(s) for s in live_all if s["sym"] == sym]
    prints, removed = dedup([p for p in raw if keep(p)])
    both = sum(1 for p in prints if len(p["src"]) > 1)
    prints, legs, legs_prem = fold_legs(prints)
    my_alerts = [alert_from_sig(s) for s in alerts_all if s["sym"] == sym]
    summaries, merged = attach_alerts(prints, [a for a in my_alerts if keep(a)])
    removed += merged
    live = d == now.date() and not outside_rth(now)
    fl = status.get("FG LiveFlows", (0, "n/a"))
    fa = status.get("FG Alerts", (0, "n/a"))
    data_times = f"{db_note} · FG LiveFlows {fl[1].replace('RTDB stream ', 'stream ')} · FG Alerts {fa[1]}"
    # context
    move, stock_lines = ctx_stock(sym, d, now)
    today_db = sum(float(r["premium"] or 0) for r in db_rows)
    norm, norm_line = ctx_norm(sym, d, today_db, live)
    oi, oi_err = ctx_oi(sym, d)
    ctx = {"session": d, "norm": norm, "move": move, "oi": oi, "oi_n": len(oi),
           "oi_why": oi_err or "it runs 10:35 ET the next session, for the top contracts by premium"}
    context = [*stock_lines, norm_line, ctx_darkpool(sym), ctx_perp(sym), ctx_earnings(sym, d)]
    # existing FlowGreeks block, one line per print, mixed tags reconciled, stale sources moved to the end
    mine = [{**print_from_live(s), "sig": s} for s in live_all if s["sym"] == sym]
    not_leg = {id(p["sig"]) for p in fold_legs(mine)[0]}
    sigs, _ = F.merge_twins(alerts_all + [s for s in live_all if s["sym"] != sym or id(s) in not_leg])
    rows = F.pick(sigs, "all", sym, lo, hi)
    bb_stale: list[str] = []
    bb = F.bullbears(sym, bb_stale)
    stale: list[str] = []
    fg = F.render(rows, status, kind="all", ticker=sym, lo=lo, hi=hi, since=since, bb=bb, stale=bb_stale,
                  stale_out=stale, merged=sum(1 for r in rows if r.get("also")))
    queued = maybe_queue(sym, channel_id, d, now)
    return render(sym=sym, session=d, prints=prints, removed=removed, summaries=summaries, ctx=ctx,
                  data_times=data_times, context=context, fg_block=fg, tape_block=intel_flow(sym, lo, hi) if tape else "",
                  stale=stale, queued=queued, band=band, legs=legs, legs_prem=legs_prem, both=both)


if __name__ == "__main__":
    import argparse
    sys.path.insert(0, str(SCRIPTS))
    ap = argparse.ArgumentParser(description="Print the /flow evidence report (sends nothing, queues nothing)")
    ap.add_argument("ticker")
    ap.add_argument("--min-prem")
    ap.add_argument("--max-prem")
    ap.add_argument("--no-tape", action="store_true")
    a = ap.parse_args()
    from lib.discord_flow import parse_premium
    print(report(a.ticker, lo=parse_premium(a.min_prem) if a.min_prem else None,
                 hi=parse_premium(a.max_prem) if a.max_prem else None, tape=not a.no_tape))
