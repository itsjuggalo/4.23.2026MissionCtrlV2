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

ET = ZoneInfo("America/New_York")
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


def option_snapshot(occ):
    """Live mid / IV / delta / day-range for one OCC option symbol."""
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
    if move <= 12:
        reasons.append(f"near entry: {move:+.0f}% vs alert ${ap:g} (now ~${mid:g})")
    elif move <= 35:
        late += 1
        reasons.append(f"already {move:+.0f}% above alert ${ap:g} (now ~${mid:g})")
    else:
        late += 2
        reasons.append(f"ran {move:+.0f}% past alert ${ap:g} — you'd be late money")

    # 2) positioning freshness (volume vs open interest)
    if voi >= 1.5:
        reasons.append(f"fresh: vol {voi:.1f}× OI — new positions opening")
    elif voi >= 0.7:
        reasons.append(f"vol {voi:.1f}× OI — partly absorbed")
    else:
        late += 1
        reasons.append(f"vol {voi:.1f}× OI — position already built, little room")

    # 3) IV / crush risk
    if iv:
        ivp = iv * 100
        if ivp >= 90:
            late += 1
            reasons.append(f"IV {ivp:.0f}% hot — crush risk if it stalls")
        else:
            reasons.append(f"IV {ivp:.0f}%")

    # 4) theta wall
    if dte == 0:
        late += 1
        reasons.append("0DTE — must move NOW, theta brutal into the close")
    elif isinstance(dte, (int, float)) and dte <= 2:
        reasons.append(f"{int(dte)}DTE — short runway")

    # 5) underlying already gapped in the contract's favor (chasing the move) — or against it
    chg = eq.get("chg_pct")
    if chg is not None:
        if (is_call and chg >= 4) or ((not is_call) and chg <= -4):
            late += 1
            reasons.append(f"stock already {chg:+.1f}% today — chasing the move")
        elif (is_call and chg <= -2) or ((not is_call) and chg >= 2):
            reasons.append(f"stock {chg:+.1f}% today — moving AGAINST this contract")
        else:
            reasons.append(f"stock {chg:+.1f}% today")

    sym = a.get("Symbol")
    if late <= 1:
        tier, emoji, head = "EARLY", "🟢", "STILL EARLY — OK to enter"
        action = f"→ enter near ${mid:g}; stop if it loses ${ap:g}. /greeks {sym} for live Δ/IV"
    elif late <= 3:
        tier, emoji, head = "LATE", "🟡", "GETTING LATE — small / spread only"
        action = "→ ¼ size or a debit spread · hard stop −30% · skip if the spread is wide"
    else:
        tier, emoji, head = "SKIP", "🔴", "TOO LATE — let it go"
        action = "→ don't chase. Alert it; take the pullback or the next fresh flow"

    return {"tier": tier, "emoji": emoji, "head": head, "reasons": reasons,
            "move": move, "mid": mid, "action": action}


# ── formatting ───────────────────────────────────────────────────────────────
def _exp(a):
    m = re.search(r"(\d{6})[CP]\d{8}$", a.get("OptionSymbol") or "")
    if m:
        y = m.group(1)
        return f"{int(y[2:4])}/{int(y[4:6])}"
    return ""


def _contract_line(a):
    t = (a.get("OptionType") or "")[:4].upper()
    arrow = "🟢▲" if t.startswith("C") else "🔴▼"   # call = bet UP, put = bet DOWN
    dte = a.get("DTE")
    dpart = f" ({int(dte)}d)" if isinstance(dte, (int, float)) else ""
    return f"{arrow} *{a.get('Symbol')} ${a.get('Strike'):g} {t}* · {_exp(a)}{dpart}"


def format_alert(a, v):
    """The push / single-contract message — verdict first, then why, then the move."""
    swp = a.get("SWEEPS") or 0
    na = a.get("NumOfAlerts") or 0
    bits = [Q._human(a.get("totalFlowValue"))]
    if swp >= 5:
        bits.append(f"{swp} sweeps")
    if na >= 2:
        bits.append(f"repeat #{na}")
    lines = [f"{v['emoji']} *{v['head']}*",
             _contract_line(a),
             "flow " + " · ".join(bits)]
    lines += [f"• {r}" for r in v["reasons"][:4]]
    lines.append(v["action"])
    return "\n".join(lines)


def _compact(occ, a):
    snap = option_snapshot(occ)
    eq = equity_snapshot(a.get("Symbol", ""))
    v = chase_verdict(a, snap, eq)
    mv = f"{v['move']:+.0f}%" if v.get("move") is not None else "—"
    head = {"EARLY": "EARLY", "LATE": "LATE", "SKIP": "TOO LATE", "WAIT": "WAIT"}[v["tier"]]
    t = (a.get("OptionType") or "")[:1]
    l1 = f"{v['emoji']} *{a.get('Symbol')} ${a.get('Strike'):g}{t}* {_exp(a)} · {mv} · {head}"
    extra = [r for r in v["reasons"][1:3]]
    return l1 + ("\n   " + " · ".join(extra) if extra else "")


# ── scan / pull entry points ─────────────────────────────────────────────────
def _fresh_min(a):
    u = a.get("Updated") or a.get("Time")
    try:
        return (datetime.now(timezone.utc).timestamp() * 1000 - float(u)) / 60000
    except Exception:
        return 1e9


def _feed():
    try:
        return json.load(open(FLOW2))
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
        out.append((occ, a, chase_verdict(a, snap, eq)))
    return out


def winners(top=5, min_value=1_000_000):
    """Pull command: today's app-pushed flow alerts, each with a chase-or-skip verdict."""
    rows = _pushed_rows(min_value)
    if not rows:
        return "🔔 No big app-pushed flow yet today (waiting on the next FlowGreeks alert)."
    out = ["🔔 *FLOW WINNERS — chase or skip*"]
    for occ, a in rows[:top]:
        out.append(_compact(occ, a))
    out.append("_tap /chase <ticker> for the full read_")
    return "\n".join(out)


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
