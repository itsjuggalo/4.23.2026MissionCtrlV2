#!/home/itsju/.venv/bin/python
"""flow_chase.py — "should I CHASE this flow alert, or is it too late?"

When the FlowGreeks / option-signals app fires an FCM push (which it records as
NotifyAlert==1 in flow2_alerts_today.json), this answers the only question that
matters in that moment: JUMP IN or STAY OUT. It pulls the LIVE option quote
(Alpaca) and compares it to the price the flow ALERTED at — if the contract has
already run, you'd be the exit liquidity, not the early money.

Why each input (so the verdict is explainable, per Mike's ADD ask):
  • price vs AlertPrice  — already ran? then you're chasing the move, not catching it
  • Volume / OI          — vol > OI = brand-new positions opening (room); vol << OI = already built (late)
  • IV level             — hot IV = crush risk if the move stalls (you lose even if right on direction)
  • DTE / theta          — 0–2 DTE must move NOW; no time to recover a bad entry
  • underlying % today    — stock already gapped your way = you're chasing the gap

READ-ONLY. No trades. Reuses quantum_tg formatters + the live option-scraper feed.

  flow_chase.py winners        # today's app-pushed flow, each with a chase/skip verdict
  flow_chase.py chase INTC     # full chase read for a symbol's biggest pushed contract
  flow_chase.py verdict <OCC>  # one contract by OCC symbol
"""
import json
import os
import re
import sys
import urllib.request
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

sys.path.insert(0, os.path.expanduser("~/scripts"))
import quantum_tg as Q  # shared read-only formatters (_human, _market_open, etc.)
from tg_format import esc, b, hdr, row, footer, join
import levels_block as LB  # R32 (Mike 2026-10-21): computed levels.v1 block on the single-contract card
from price_guard import fresh, option_mid, src_label  # remedial W1/W4 send-time guard (Robinhood first)

ET = ZoneInfo("America/New_York")

# Per-trade price caps removed 2026-10-05 (Mike's decision): every contract shows its cost
# (mid × 100) and nothing is hidden for being expensive.


SECRETS = os.path.expanduser("~/.openclaw/secrets")
DATA = os.path.expanduser("~/trading/signals/option-scraper/data")
FLOW2 = os.path.join(DATA, "flow2_alerts_today.json")

SIGNIF_USD = 1_500_000   # only mirror the meaty app pushes (anti-bloat default for the guard)


# ── live quotes (Robinhood only; the Alpaca fallback was removed 2026-10-22) ─────
def _clean_occ(s):
    # flow2 alert keys can carry a "_<time><hash>" suffix on repeat alerts; the real
    # OCC symbol is the head before the first underscore.
    return (s or "").split("_")[0]


def option_snapshot(occ):
    """Live mid / IV / delta / day-range for one OCC option symbol. Remedial W4 (Mike 10-09 #1): Robinhood first
    (read-only marketdata/options); the Alpaca indicative snapshot only when Robinhood has no quote, labelled."""
    occ = _clean_occ(occ)
    mid, chk, src, x = option_mid(occ)
    if src is not None:
        return {"mid": mid, "bid": x.get("bid"), "ask": x.get("ask"), "quote_check": chk, "src": src,
                "iv": x.get("iv"), "delta": x.get("delta"), "day_high": x.get("high"), "day_low": x.get("low")}
    # Robinhood has no quote: no fallback. mid None sends the verdict to its existing NO LIVE QUOTE / WAIT branch.
    return {"mid": None, "bid": None, "ask": None, "quote_check": chk, "src": None,
            "iv": None, "delta": None, "day_high": None, "day_low": None, "rh_reason": x.get("rh_reason")}


def equity_snapshot(tkr):
    """Live underlying spot + % change vs the prior regular close — remedial W4: quote_client.require_fresh
    (Robinhood first; pre/after-hours = the extended print vs the last close). None unless it passes the send guard."""
    if not tkr:
        return {}
    r = fresh([tkr]).get(tkr.strip().upper()) or {}
    ok = bool(r.get("ok"))
    chg = r.get("change_pct") if ok else None
    return {"spot": r.get("price") if ok else None, "chg_pct": round(chg, 1) if isinstance(chg, (int, float)) else None,
            "spot_check": r, "src": r.get("src"), "window": r.get("window")}


def _src(d):
    """', src Robinhood 10:02 ET' — the provenance every printed price carries (market-data rule §2)."""
    return f", {d['src']}" if d and d.get("src") else ""


# ── the verdict ──────────────────────────────────────────────────────────────
def chase_verdict(a, snap, eq):
    """JUMP-IN / STAY-OUT for a flow alert, with explainable reasons."""
    ap = a.get("AlertPrice")
    ap = round(ap, 2) if isinstance(ap, (int, float)) else ap
    mid = snap.get("mid")
    dte = a.get("DTE")
    vol = a.get("Volume") or 0
    oi = a.get("OI") or 0
    voi = (vol / oi) if oi else (2.0 if vol else 0.0)
    iv = snap.get("iv")
    is_call = str(a.get("OptionType") or "").upper().startswith("C")  # what YOU'd buy needs: call→up, put→down
    reasons = []

    if not mid or not ap:
        return {"tier": "WAIT", "emoji": "⏸", "head": "NO LIVE QUOTE YET", "move": None, "mid": mid,
                "reasons": [f"no usable option quote ({(snap.get('quote_check') or {}).get('reason') or 'none returned'})"
                            " — re-check after ~9:45 ET open"],
                "action": "→ no live option quote — cost UNAVAILABLE until it's trading"}

    move = (mid - ap) / ap * 100
    late = 0

    # 1) how far it's already run vs where the flow hit (the decisive 'too late' signal)
    # 2026-07-29: a contract DOWN hard since the alert scored the same as one sitting at the
    # alert price — so the board called a −86% MU call "still early". Down that much means the
    # big buyer is underwater and the idea is failing, which is the opposite of early.
    if move <= -40:
        late += 2
        reasons.append(f"collapsed {move:+.0f}% since the alert — whoever bought it is deep "
                       f"underwater, the idea isn't working")
    elif move <= -15:
        late += 1
        reasons.append(f"down {move:+.0f}% since the alert — it's going the wrong way so far")
    elif move <= 12:
        reasons.append(f"near entry: {move:+.0f}% vs alert ${ap:g} (now ~${mid:g}{_src(snap)})")
    elif move <= 35:
        late += 1
        reasons.append(f"already {move:+.0f}% above alert ${ap:g} (now ~${mid:g}{_src(snap)})")
    else:
        late += 2
        reasons.append(f"ran {move:+.0f}% past alert ${ap:g} — you'd be late money")

    # 2) positioning freshness (volume vs open interest)
    # 2026-07-29: these read "vol 0.3× OI — position already built" / "IV 85%" / "0DTE — theta
    # brutal". Every one of those is a term Mike is still learning, and they're the WHY of the
    # verdict — the part he most needs to understand. Same maths, said in English.
    if voi >= 1.5:
        reasons.append("today's buying is bigger than everything already open here — "
                       "people are getting in NOW, not sitting on old positions")
    elif voi >= 0.7:
        reasons.append("about as much bought today as was already open — some of the move "
                       "is already spent")
    else:
        late += 1
        reasons.append("almost no new buying today — this position was built earlier, "
                       "so there's little room left")

    # 3) IV / crush risk
    if iv:
        ivp = iv * 100
        if ivp >= 90:
            late += 1
            reasons.append("the option is priced for a big move already — if the stock just "
                           "sits there you LOSE even when you picked the right direction")
        else:
            reasons.append(f"option pricing is normal ({ivp:.0f}%)")

    # 4) theta wall
    if dte == 0:
        late += 1
        reasons.append("expires TODAY — it has to move within hours or it's worth zero")
    elif isinstance(dte, (int, float)) and dte <= 2:
        reasons.append(f"only {int(dte)} day{'s' if dte != 1 else ''} left — very little time "
                       f"to be right")

    # 5) underlying already gapped in the contract's favor (chasing the move) — or against it
    chg = eq.get("chg_pct")
    when = "today" if eq.get("window") == "RTH" else "vs the last close"
    if chg is not None:
        if (is_call and chg >= 4) or ((not is_call) and chg <= -4):
            late += 1
            reasons.append(f"stock already {chg:+.1f}% {when}{_src(eq)} — chasing the move")
        elif (is_call and chg <= -2) or ((not is_call) and chg >= 2):
            late += 1
            reasons.append(f"stock {chg:+.1f}% {when}{_src(eq)} — moving AGAINST this contract (fighting the tape)")
        else:
            reasons.append(f"stock {chg:+.1f}% {when}{_src(eq)}")

    sym = a.get("Symbol")
    # One contract = mid × 100 — always shown, never filtered (caps removed 2026-10-05).
    cost = mid * 100 if mid else 0
    # 2026-10-08 audit F17: a contract already down >=15% since the alert scored late=1 (EARLY tier,
    # kept as-is so the guard fires exactly the same alerts) but was headed "🟢 STILL EARLY" over a
    # body saying "going the wrong way". Header/emoji only; tier and gating are unchanged.
    warn_down = move <= -15
    if late <= 1:
        tier, emoji, head = "EARLY", "🟢", "STILL EARLY — flow near the alert price (evidence)"
        if warn_down:
            emoji, head = "🟠", f"DOWN {abs(move):.0f}% SINCE THE ALERT — flow is not working yet (evidence)"
        action = (f"→ {move:+.0f}% vs the alert price. 1 contract ≈ ${cost:,.0f} "
                  f"(mid ${mid:g} × 100). Setup evidence, not a trade call.")
    elif late <= 3:
        tier, emoji, head = "LATE", "🟡", "GETTING LATE — part of the move is spent (evidence)"
        action = (f"→ {move:+.0f}% vs the alert price — part of the move is already spent. "
                  f"1 contract ≈ ${cost:,.0f} (mid ${mid:g} × 100). Setup evidence, not a trade call.")
    else:
        tier, emoji, head = "SKIP", "🔴", "TOO LATE — the move already happened (evidence)"
        action = ("→ chase gate closed: the move already happened. A pullback or the next "
                  "fresh alert would re-open it.")

    return {"tier": tier, "emoji": emoji, "head": head, "reasons": reasons,
            "move": move, "mid": mid, "action": action, "warn_down": warn_down}


# ── formatting ───────────────────────────────────────────────────────────────
def _exp(a):
    m = re.search(r"(\d{6})[CP]\d{8}", _clean_occ(a.get("OptionSymbol")))
    if m:
        y = m.group(1)
        return f"{int(y[2:4])}/{int(y[4:6])}"
    return ""


def _contract_line(a):
    t = (a.get("OptionType") or "")[:4].upper()
    arrow = "🟢▲" if t.startswith("C") else "🔴▼"   # call = bet UP, put = bet DOWN
    dte = a.get("DTE")
    dpart = f" ({int(dte)}d)" if isinstance(dte, (int, float)) else ""
    head = b(f"{a.get('Symbol')} ${a.get('Strike'):g} {t}")
    return f"{arrow} {head} · {esc(_exp(a))}{esc(dpart)}"


def format_alert(a, v):
    """The push / single-contract message — verdict first, then why, then the move."""
    swp = a.get("SWEEPS") or 0
    na = a.get("NumOfAlerts") or 0
    bits = [Q._human(a.get("totalFlowValue"))]
    if swp >= 5:
        bits.append(f"{swp} sweeps")
    if na >= 2:
        bits.append(f"repeat #{na}")
    lines = [f"{v['emoji']} {b(v['head'])}",
             _contract_line(a),
             esc("flow " + " · ".join(bits))]
    lines += [esc(f"• {r}") for r in v["reasons"][:4]]
    lines.append(esc(v["action"]))
    # R32: Entry / TP1 / TP2 / Final TP / SL from the levels.v1 engine only (methods, source, as_of; UNAVAILABLE named)
    lines += [esc(x) for x in LB.for_contract(a.get("Symbol") or "", a.get("OptionType") or "", a.get("DTE"),
                                              _clean_occ(a.get("OptionSymbol")) or None)]
    return "\n".join(lines)


def _compact(occ, a, with_cost=False, meta=None):
    """Board line. `with_cost=True` also returns the per-contract dollar cost so the caller
    can put cheaper contracts first when two rows tie on flow size."""
    snap = option_snapshot(occ)
    eq = equity_snapshot(a.get("Symbol", ""))
    v = chase_verdict(a, snap, eq)
    # 2026-07-29 beginner pass: "$320P · +1% · LATE" assumed the reader knows P=put and that
    # the % is how far the contract has already run since the alert. Say both. And show ONE
    # reason, not two — the board is a scan; /chase <ticker> is where the full read lives.
    mvp = v.get("move")
    # "already up +0% since the alert" is a rounding artefact that reads as nonsense — under
    # a point of drift means the contract is simply still where it was alerted.
    mv = ("" if mvp is None else
          "still at the alert price" if abs(mvp) < 1 else
          f"already up {mvp:+.0f}% since the alert" if mvp > 0 else
          f"down {abs(mvp):.0f}% since the alert")
    head = {"EARLY": "still early", "LATE": "getting late",
            "SKIP": "too late", "WAIT": "no live quote"}[v["tier"]]
    if v.get("warn_down"):
        head = "not working yet"     # F17: never "still early" on a contract down >=15%
    if meta is not None:
        meta.update(move=mvp, mid=v.get("mid"), emoji=v["emoji"])
    kind = "CALL" if (a.get("OptionType") or "").upper().startswith("C") else "PUT"
    title = b(f"{a.get('Symbol')} ${a.get('Strike'):g} {kind}")
    l1 = (f"{v['emoji']} {title} exp {esc(_exp(a))} — " + esc(head) + (esc(f", {mv}") if mv else ""))
    # Show the ACTION, not a reason. `reasons` is an unordered mix of positives and negatives
    # scored together, so cherry-picking one could print "still early" above "little room left"
    # — a beginner reading a contradiction learns nothing. The action always agrees with the
    # verdict, and it's the part he can act on; /chase <ticker> carries the full why.
    line = l1 + ("\n   " + esc(v["action"]) if v.get("action") else "")
    # audit 2026-10-22: the move % comes from this mark — show it with its source + data time (or say why none)
    mid = v.get("mid")
    line += "\n   " + esc(f"mark ${mid:.2f} · {snap.get('src') or 'src unknown'}" if mid is not None
                         else f"no live mark — {((snap.get('quote_check') or {}).get('reason')) or 'no quote'} "
                              f"({snap.get('src') or 'no source answered'})")
    return (line, (mid or 0) * 100) if with_cost else line


# ── scan / pull entry points ─────────────────────────────────────────────────
def _fresh_min(a):
    u = a.get("Updated") or a.get("Time")
    try:
        return (datetime.now(timezone.utc).timestamp() * 1000 - float(u)) / 60000
    except Exception:
        return 1e9


def _feed():
    # the live relay rewrites this file continuously; a mid-write read can yield
    # "" / a list / partial JSON — always hand back a dict so callers never crash.
    try:
        d = json.load(open(FLOW2))
        return d if isinstance(d, dict) else {}
    except Exception:
        return {}


def _pushed_rows(min_value):
    """[(occ, alert)] for app-pushed (NotifyAlert==1) alerts above a $ floor, biggest first."""
    rows = []
    for occ, row in _feed().items():
        a = row.get("alert", row)
        if int(a.get("NotifyAlert") or 0) != 1:
            continue
        if (a.get("totalFlowValue") or 0) < min_value:
            continue
        rows.append((occ, a))
    rows.sort(key=lambda x: x[1].get("totalFlowValue") or 0, reverse=True)
    return rows


def scan_pushed(min_value=SIGNIF_USD, fresh_min=8, require_open=True):
    """For the guard: [(occ, alert, verdict)] of app-pushed, big, FRESH flow."""
    if require_open and not Q._market_open():
        return []
    out = []
    for occ, a in _pushed_rows(min_value):
        if _fresh_min(a) > fresh_min:
            continue
        snap = option_snapshot(occ)
        eq = equity_snapshot(a.get("Symbol", ""))
        out.append((_clean_occ(occ), a, chase_verdict(a, snap, eq)))  # clean OCC = stable dedup key
    return out


def _winners_build(top=5, min_value=1_000_000):
    """(board_text, items). items = {occ: {"emoji", "move"}} for the contracts shown, so the
    scheduled push can dedupe on the contract set instead of the wiggling text."""
    rows = _pushed_rows(min_value)
    if not rows:
        return "🔔 No big app-pushed flow yet today (waiting on the next FlowGreeks alert).", {}
    # Ranked by flow size (biggest first); every priced contract is listed with its cost.
    # 2026-10-08 audit F3/F4: rows down >=40% or under $0.10 are not "winners" (a -99% $0.01
    # SPY call was headed FLOW WINNERS) — dropped from this DISPLAY board only; the verdict/tier
    # logic the guard uses is untouched.
    priced, waiting, items = [], [], {}
    for occ, a in rows:
        meta = {}
        line, cost = _compact(occ, a, with_cost=True, meta=meta)
        mvp, mid = meta.get("move"), meta.get("mid")
        if (mvp is not None and mvp <= -40) or (mid is not None and mid < 0.10):
            continue
        if cost > 0:
            priced.append((_clean_occ(occ), line, meta))
        else:
            # no live quote yet — backfill only, so a priced row is never pushed off the board.
            waiting.append((_clean_occ(occ), line, meta))
        if len(priced) >= top:
            break
    shown = (priced + waiting)[:top]
    out = [hdr("🔔", "Flow Winners", sub="chase-timing evidence · not trade calls")]
    if shown:
        out += [ln for _, ln, _ in shown]
    else:
        out.append(esc("No priced flow on the board yet."))
    out.append(footer("tap /chase <ticker> for the full read"))
    for k, _, m in shown:
        items[k] = {"emoji": m.get("emoji"), "move": m.get("move")}
    return join(*out), items


def winners(top=5, min_value=1_000_000):
    """Pull command: today's app-pushed flow alerts, each with a chase-or-skip verdict."""
    return _winners_build(top, min_value)[0]


def chase(symbol):
    """Pull command: full chase read for a symbol's biggest pushed (or any) flow contract."""
    symbol = symbol.upper().lstrip("$")
    rows = [(occ, row.get("alert", row)) for occ, row in _feed().items()
            if (row.get("alert", row)).get("Symbol") == symbol]
    if not rows:
        return f"No flow on {symbol} in today's feed. (/sweeps for the live board)"
    # prefer app-pushed, then biggest flow; show the top 2 contracts on the name
    rows.sort(key=lambda x: (int(x[1].get("NotifyAlert") or 0), x[1].get("totalFlowValue") or 0),
              reverse=True)
    eq = equity_snapshot(symbol)
    blocks = [format_alert(a, chase_verdict(a, option_snapshot(occ), eq)) for occ, a in rows[:2]]
    return "\n\n".join(blocks)


def verdict_for(occ):
    a = (_feed().get(occ) or {}).get("alert")
    if not a:
        return f"{occ} not in today's feed."
    return format_alert(a, chase_verdict(a, option_snapshot(occ), equity_snapshot(a.get("Symbol", ""))))


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "winners"
    arg = sys.argv[2] if len(sys.argv) > 2 else ""
    print(chase(arg) if (cmd == "chase" and arg)
          else verdict_for(arg) if (cmd == "verdict" and arg)
          else winners())
