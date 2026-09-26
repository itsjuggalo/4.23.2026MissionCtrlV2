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

ET = ZoneInfo("America/New_York")

# Mike's per-trade risk cap — flat $400 max risk (doctrine since 2026-09-12), fail-CLOSED. $400 is the
# standing ceiling used wherever equity isn't already in hand (message-build paths must never
# block on a live account call). Same number as flow_picks_post.RISK_CAP_USD and the
# flow-digest affordability gate — if the doctrine changes, change it in all of them.
RISK_CAP_USD = 400.0


def _stop_for(mid, alert_px):
    """A stop must sit BELOW where you get in. The old text said "get out if it loses
    $<alert price>", which is only true while the contract trades ABOVE the alert — on a
    contract that has fallen since, it printed a stop HIGHER than the entry (buy at $1.80,
    stop at $12.71). Use the alert price only when it's genuinely below the current price;
    otherwise fall back to the −30% rule. (2026-07-29)

    The alert price is also CLAMPED to a −15%…−30% band. A contract alerted at $2.80 now
    trading at $3.00 produced a stop 6.7% below entry — narrower than the bid/ask spread on
    most options, so it fires on noise and books a loss the idea never earned. Too tight is
    as broken as above-entry was."""
    try:
        mid, alert_px = float(mid or 0), float(alert_px or 0)
    except (TypeError, ValueError):
        return 0
    if 0 < alert_px < mid:
        return round(max(mid * 0.70, min(alert_px, mid * 0.85)), 2)
    return round(mid * 0.7, 2)


def _target_for(mid, pct=0.50):
    """Where you SELL THE WINNER. Every action line on this board named an entry and a stop
    and then went quiet about the profitable case — so the only exit a beginner had written
    down was the losing one, and the winning trades got managed on feel. Default +50% on the
    premium against the −30% stop is roughly 1.7:1. (2026-07-29)"""
    try:
        return round(float(mid or 0) * (1 + pct), 2)
    except (TypeError, ValueError):
        return 0


SECRETS = os.path.expanduser("~/.openclaw/secrets")
DATA = os.path.expanduser("~/trading/signals/option-scraper/data")
FLOW2 = os.path.join(DATA, "flow2_alerts_today.json")
ALPACA = "https://data.alpaca.markets"

SIGNIF_USD = 1_500_000   # only mirror the meaty app pushes (anti-bloat default for the guard)


# ── live quotes (Alpaca) ─────────────────────────────────────────────────────
def _headers():
    try:
        return {"APCA-API-KEY-ID": open(f"{SECRETS}/alpaca-boba-key-id").read().strip(),
                "APCA-API-SECRET-KEY": open(f"{SECRETS}/alpaca-boba-secret").read().strip()}
    except Exception:
        return {}


def _get(url, timeout=6):
    try:
        req = urllib.request.Request(url, headers=_headers())
        return json.load(urllib.request.urlopen(req, timeout=timeout))
    except Exception:
        return None


def _clean_occ(s):
    # flow2 alert keys can carry a "_<time><hash>" suffix on repeat alerts; the real
    # OCC symbol is the head before the first underscore.
    return (s or "").split("_")[0]


def option_snapshot(occ):
    """Live mid / IV / delta / day-range for one OCC option symbol."""
    occ = _clean_occ(occ)
    d = _get(f"{ALPACA}/v1beta1/options/snapshots?symbols={occ}")
    node = ((d or {}).get("snapshots") or {}).get(occ, {})
    lq = node.get("latestQuote") or {}
    db = node.get("dailyBar") or {}
    g = node.get("greeks") or {}
    bp, ap = lq.get("bp"), lq.get("ap")
    mid = round((bp + ap) / 2, 2) if (bp and ap) else (ap or bp or None)
    return {"mid": mid, "bid": bp, "ask": ap,
            "iv": node.get("impliedVolatility") or g.get("iv"),
            "delta": g.get("delta"), "day_high": db.get("h"), "day_low": db.get("l")}


def equity_snapshot(tkr):
    """Live underlying spot + % change vs prior close."""
    if not tkr:
        return {}
    d = _get(f"{ALPACA}/v2/stocks/{tkr}/snapshot", timeout=5)
    if not d:
        return {}
    last = (d.get("latestTrade") or {}).get("p")
    prev = (d.get("prevDailyBar") or {}).get("c")
    chg = round((last - prev) / prev * 100, 1) if (last and prev) else None
    return {"spot": last, "prev_close": prev, "chg_pct": chg,
            "day_high": (d.get("dailyBar") or {}).get("h")}


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
        return {"tier": "WAIT", "emoji": "⏸", "head": "WAIT FOR LIVE QUOTE", "move": None, "mid": mid,
                "reasons": ["no live option quote yet (pre/after-market) — re-check after ~9:45 ET open"],
                "action": "→ set a mental alert; decide once it's actually trading"}

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
        reasons.append(f"near entry: {move:+.0f}% vs alert ${ap:g} (now ~${mid:g})")
    elif move <= 35:
        late += 1
        reasons.append(f"already {move:+.0f}% above alert ${ap:g} (now ~${mid:g})")
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
    if chg is not None:
        if (is_call and chg >= 4) or ((not is_call) and chg <= -4):
            late += 1
            reasons.append(f"stock already {chg:+.1f}% today — chasing the move")
        elif (is_call and chg <= -2) or ((not is_call) and chg >= 2):
            late += 1
            reasons.append(f"stock {chg:+.1f}% today — moving AGAINST this contract (fighting the tape)")
        else:
            reasons.append(f"stock {chg:+.1f}% today")

    sym = a.get("Symbol")
    # Mike's hard per-trade cap: flat $400, fail-CLOSED. One contract = mid×100.
    # Without this the board told him to "buy near $267.56" on an STX put — a $26,756 contract
    # on a ~$2k book. An idea he cannot afford is not an idea; say so instead of pricing it.
    cost = mid * 100 if mid else 0
    unaffordable = cost > RISK_CAP_USD
    if late <= 1:
        tier, emoji, head = "EARLY", "🟢", "STILL EARLY — you can still get in"
        action = (f"→ one contract is ${cost:,.0f} — over your ${RISK_CAP_USD:.0f} limit, so "
                  f"this one isn't for your account even though the setup is good."
                  if unaffordable else
                  f"→ 1 contract, ${cost:,.0f}. BUY near ${mid:g} · SELL at "
                  f"${_stop_for(mid, ap):g} if it drops (−${cost - _stop_for(mid, ap)*100:,.0f}) · "
                  f"SELL at ${_target_for(mid):g} if it works (+${_target_for(mid)*100 - cost:,.0f}). "
                  f"Set both sells right after you buy.")
    elif late <= 3:
        tier, emoji, head = "LATE", "🟡", "GETTING LATE — go small or skip it"
        action = (f"→ skip — ${cost:,.0f} a contract is over your ${RISK_CAP_USD:.0f} limit "
                  f"and the move is already underway."
                  if unaffordable else
                  f"→ half the move is gone. If you take it at all: 1 contract ${cost:,.0f} · "
                  f"BUY near ${mid:g} · SELL at ${_stop_for(mid, ap):g} if it drops "
                  f"(−${cost - _stop_for(mid, ap)*100:,.0f}) · SELL at "
                  f"${_target_for(mid, 0.30):g} if it works "
                  f"(+${_target_for(mid, 0.30)*100 - cost:,.0f}) — take the smaller win, the "
                  f"easy part already happened.")
    else:
        tier, emoji, head = "SKIP", "🔴", "TOO LATE — let this one go"
        action = ("→ don't chase it. The move already happened. Wait for a pullback, "
                  "or wait for the next fresh one.")

    return {"tier": tier, "emoji": emoji, "head": head, "reasons": reasons,
            "move": move, "mid": mid, "action": action}


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
    return "\n".join(lines)


def _compact(occ, a, with_cost=False):
    """Board line. `with_cost=True` also returns the per-contract dollar cost so the caller
    can rank affordable ideas first."""
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
            "SKIP": "too late", "WAIT": "wait"}[v["tier"]]
    kind = "CALL" if (a.get("OptionType") or "").upper().startswith("C") else "PUT"
    title = b(f"{a.get('Symbol')} ${a.get('Strike'):g} {kind}")
    l1 = (f"{v['emoji']} {title} exp {esc(_exp(a))} — " + esc(head) + (esc(f", {mv}") if mv else ""))
    # Show the ACTION, not a reason. `reasons` is an unordered mix of positives and negatives
    # scored together, so cherry-picking one could print "still early" above "little room left"
    # — a beginner reading a contradiction learns nothing. The action always agrees with the
    # verdict, and it's the part he can act on; /chase <ticker> carries the full why.
    line = l1 + ("\n   " + esc(v["action"]) if v.get("action") else "")
    return (line, (v.get("mid") or 0) * 100) if with_cost else line


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


def winners(top=5, min_value=1_000_000):
    """Pull command: today's app-pushed flow alerts, each with a chase-or-skip verdict."""
    rows = _pushed_rows(min_value)
    if not rows:
        return "🔔 No big app-pushed flow yet today (waiting on the next FlowGreeks alert)."
    # 2026-07-29: the board ranked purely by flow size, so 4 of 5 lines were routinely
    # contracts costing thousands — Mike scrolled a list of things he cannot buy. Rank the
    # ones that FIT his cap first (stable, so flow size still orders within each group) and
    # count the rest instead of listing them.
    priced, waiting, toobig = [], [], 0
    for occ, a in rows:
        line, cost = _compact(occ, a, with_cost=True)
        if cost > RISK_CAP_USD:
            toobig += 1
        elif cost > 0:
            priced.append(line)
        else:
            # no live quote yet — nothing to decide on. Keep it as backfill only, so a
            # tradeable idea is never pushed off the board by a row that says "wait".
            waiting.append(line)
        if len(priced) >= top:
            break
    shown = (priced + waiting)[:top]
    out = [hdr("🔔", "Flow Winners", sub="chase or skip")]
    if shown:
        out += shown
    else:
        out.append(esc(f"Nothing in today's big flow fits your ${RISK_CAP_USD:.0f} per-trade "
                       f"limit — that's a fine reason to sit out."))
    if toobig:
        note = (f"({toobig} other big-money contracts today cost more than "
                f"${RISK_CAP_USD:.0f} each — not for this account.)")
        out.append(f"<i>{esc(note)}</i>")
    out.append(footer("tap /chase <ticker> for the full read"))
    return join(*out)


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
