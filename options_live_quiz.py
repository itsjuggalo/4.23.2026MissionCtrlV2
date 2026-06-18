#!/home/itsju/.venv/bin/python
"""options_live_quiz.py — Options Mastery Phase 3: LIVE + his-own-trade reps.

The static bank teaches concepts; THIS teaches off the live market and Mike's
OWN open paper positions — the "un-limiting" win. Two generators:

  • POSITION mode — reads Boba's real Alpaca paper option positions, computes
    live greeks (theo.bs_greeks) on the actual contract, and asks a grounded
    question: "Your AMZN 250C (3d left, ~flat) — which greek is the daily rent?"
  • STRADDLE mode — calls straddle_engine.read('SPY') and asks a GO/WAIT/SELL
    question off the REAL IV/HV + implied-vs-realized numbers, graded to the
    engine's own verdict.

It ships through the SAME Telegram path + `oq:` callback + grader the static
reps use (options_quiz.py / options_quiz_grade.py), so there are NO responder
changes — the tap is graded by the existing logic. State is shared, so the 5h
anti-double-ask guard keeps it from colliding with the curriculum reps.

Run:  options_live_quiz.py                 (auto: position if open options, else straddle)
      MODE=straddle options_live_quiz.py   (force the SPY engine read)
      MODE=position options_live_quiz.py    (force his-trade)
      DRY=1 options_live_quiz.py            (print, don't send)
"""
from __future__ import annotations
import json, os, re, sys, time, urllib.parse, urllib.request
from datetime import datetime, date, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, "/AIWorkWSL/labs/quantum/src")
import theo  # noqa: E402

SEC = Path.home() / ".openclaw" / "secrets"
STATE = Path.home() / ".openclaw" / "data" / "options_quiz_state.json"
TOKEN_FILE = SEC / "telegram_laptopclaude_bot_token"
CHAT_FILE = SEC / "telegram-chat-id.txt"
PAPER = "https://paper-api.alpaca.markets"
DATA = "https://data.alpaca.markets"
ET = ZoneInfo("America/New_York")
LETTERS = ["A", "B", "C", "D"]
DRY = os.environ.get("DRY") == "1"
MODE = os.environ.get("MODE", "auto").lower()
OCC = re.compile(r"^([A-Z]+)(\d{6})([CP])(\d{8})$")


def _key():
    return ((SEC / "alpaca-key-id").read_text().strip(),
            (SEC / "alpaca-secret").read_text().strip())


def _get(url: str):
    k, s = _key()
    req = urllib.request.Request(url, headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s})
    return json.loads(urllib.request.urlopen(req, timeout=20).read())


def _tg(method, **kwargs):
    token = TOKEN_FILE.read_text().strip()
    try:
        return urllib.request.urlopen(urllib.request.Request(
            f"https://api.telegram.org/bot{token}/{method}",
            data=json.dumps(kwargs).encode(), headers={"Content-Type": "application/json"}),
            timeout=15)
    except Exception as e:
        print(f"tg {method} error: {e}")
        return None


def _spot(sym: str) -> float | None:
    try:
        d = _get(f"{DATA}/v2/stocks/{sym}/trades/latest?feed=iex")
        return float(d.get("trade", {}).get("p") or 0) or None
    except Exception:
        return None


def parse_occ(sym: str):
    m = OCC.match(sym)
    if not m:
        return None
    root, ymd, cp, strike8 = m.groups()
    exp = date(2000 + int(ymd[:2]), int(ymd[2:4]), int(ymd[4:6]))
    return {"root": root, "exp": exp, "kind": "call" if cp == "C" else "put",
            "strike": int(strike8) / 1000.0}


def _open_option_positions():
    try:
        rows = _get(f"{PAPER}/v2/positions")
    except Exception:
        return []
    out = []
    for p in rows:
        info = parse_occ(p.get("symbol", ""))
        if not info:
            continue
        info.update({
            "symbol": p["symbol"], "qty": int(float(p.get("qty", 0))),
            "avg": float(p.get("avg_entry_price", 0) or 0),
            "mark": float(p.get("current_price", 0) or 0),
            "upl": float(p.get("unrealized_pl", 0) or 0),
            "uplpc": float(p.get("unrealized_plpc", 0) or 0) * 100,
        })
        out.append(info)
    return out


def _greeks_for(pos: dict):
    """Live greeks on the actual contract. Backs IV out of the market mark; falls
    back to None greeks (the theta question is still qualitatively correct)."""
    spot = _spot(pos["root"])
    if not spot:
        return None
    dte = max((pos["exp"] - datetime.now(ET).date()).days, 0)
    T = max(dte, 0.5) / 365.0
    mark = pos["mark"] or pos["avg"]
    iv = theo.implied_vol(mark, spot, pos["strike"], T, pos["kind"]) or 0.0
    g = theo.bs_greeks(spot, pos["strike"], T, iv or 0.30, pos["kind"]) if (iv or mark) else None
    be = theo.breakeven(pos["strike"], pos["avg"], pos["kind"])
    moneyness = ("ITM" if (pos["kind"] == "call" and spot > pos["strike"]) or
                 (pos["kind"] == "put" and spot < pos["strike"]) else "OTM")
    return {"spot": round(spot, 2), "dte": dte, "iv": iv, "greeks": g,
            "breakeven": round(be, 2), "moneyness": moneyness}


def _fmt_contract(pos: dict) -> str:
    return f"{pos['root']} {pos['strike']:g}{'C' if pos['kind']=='call' else 'P'} {pos['exp']:%-m/%-d}"


def position_question():
    """Build a personalized rep off a real open option position."""
    positions = [p for p in _open_option_positions() if p["qty"] != 0]
    if not positions:
        return None
    # prefer the most interesting teachable: biggest |%P/L|, then nearest expiry
    pos = sorted(positions, key=lambda p: (-abs(p["uplpc"]),
                 (p["exp"] - date.today()).days))[0]
    gx = _greeks_for(pos)
    if not gx:
        return None
    g = gx["greeks"] or {}
    label = _fmt_contract(pos)
    dte, mny = gx["dte"], gx["moneyness"]
    delta = g.get("delta"); theta_day = g.get("theta_day"); vega = g.get("vega")
    gtxt = ""
    if g:
        gtxt = (f"\n\n📐 <b>Live greeks on YOUR contract:</b> delta {delta:+.2f} "
                f"(≈${abs(delta)*100:.0f} per $1 {pos['root']} move) · "
                f"theta {theta_day:+.2f}/day (≈${abs(theta_day)*100:.0f} rent/day) · "
                f"vega {vega:.2f} · breakeven ${gx['breakeven']:g} · {mny}, {dte}d left.")

    # choose template by state
    big_winner = pos["uplpc"] >= 40
    deep_itm = delta is not None and abs(delta) >= 0.62

    if big_winner:
        q = (f"Your <b>{label}</b> is <b>{pos['uplpc']:+.0f}%</b> on the premium you paid. "
             f"What's the disciplined move right now?")
        opts = ["Hold the whole thing for a possible double",
                "Sell HALF to bank the win, then move the stop on the rest to breakeven",
                "Add more contracts to press the winner",
                "Set a target at +500% and walk away"]
        ci = 1
        why = (f"At +{pos['uplpc']:.0f}% you scale: sell half to lock a real gain, then arm a "
               f"breakeven stop on the runner so it can't go red. 'Scale winners, never give it "
               f"all back' — exactly what the profit-lock daemon does in shadow mode. Holding the "
               f"whole position invites theta and a reversal to round-trip your gain.{gtxt}")
        mod = "management"
    elif deep_itm:
        q = (f"Your <b>{label}</b> is now {mny} with a delta around {delta:+.2f}. "
             f"Which greek explains that it now moves almost dollar-for-dollar with {pos['root']}?")
        opts = ["Theta", "Delta", "Vega", "Rho"]
        ci = 1
        why = (f"DELTA is the $-per-$1 sensitivity and the rough probability of finishing ITM. "
               f"At {delta:+.2f} this contract behaves like ~{abs(delta)*100:.0f} shares of {pos['root']} — "
               f"a near-stock substitute. High delta = less leverage, more directional certainty; it's "
               f"the trade-off you accepted by being {mny}.{gtxt}")
        mod = "greeks-iv"
    else:
        q = (f"You hold <b>{label}</b> — {mny}, {dte} day{'s' if dte!=1 else ''} to expiry — and "
             f"{pos['root']} sits roughly flat. Which greek is quietly charging you RENT every day "
             f"you hold, win or lose?")
        opts = ["Delta", "Theta", "Vega", "Gamma"]
        ci = 1
        why = (f"THETA is time decay — the daily rent on a long option, and it's BACK-LOADED "
               f"(it accelerates as expiry nears, brutal in the final third for an OTM strike). "
               f"With {dte}d left and the stock flat, theta is the force eroding this position. "
               f"That's why the rule is: have a catalyst and an exit — don't pay rent on a move "
               f"that isn't coming. Bail by ~21 DTE if it isn't working.{gtxt}")
        mod = "vol-edge"

    return {"qid": f"live-pos-{pos['symbol']}-{date.today():%Y%m%d}",
            "question": q, "options": opts, "correct_index": ci, "why": why,
            "module": mod, "header": "📟 YOUR LIVE POSITION"}


def straddle_question():
    """Build a GO/WAIT/SELL rep off the live SPY straddle engine read."""
    try:
        import straddle_engine as se
    except Exception as e:
        print(f"[live-quiz] engine import failed: {e}")
        return None
    r = se.read("SPY")
    if not r:
        return None
    if r.get("iv"):
        se._log_iv("SPY", r["iv"]); r["iv_percentile"] = se.iv_percentile("SPY", r["iv"])
    hol = se.holiday_in_life(r["dte"])
    verdict, why = se.classify(r, catalyst=False)
    iv_rv = r.get("iv_rv"); impl = r.get("implied_move_pct"); real = r.get("realized_move_pct")
    edge = r.get("edge_ratio")
    cond = (f"SPY ${r['spot']}, {r['exp']} ({r['dte']}d): the ATM straddle is pricing a "
            f"{impl}% move vs ~{real}% it typically does (edge {edge}×), IV/HV {iv_rv}"
            + (", and the market is CLOSED at least one day inside its life" if hol else "")
            + ".")
    q = f"📊 LIVE READ — {cond}\n\nWhat's the disciplined call right now?"
    opts = ["Buy the straddle now — a move is coming",
            "WAIT — vol isn't cheap-with-a-catalyst; you'd just pay theta",
            "SELL premium — vol is rich, this is a seller's setup",
            "Buy a far-OTM strangle and hope"]
    # map engine verdict → correct option
    ci = {"GO": 0, "CHEAP·WAIT": 1, "FAIR": 1, "UNKNOWN": 1, "NO-GO": 2}.get(verdict, 1)
    lens = {
        0: "GO is the rare case the pros wait for: cheap vol AND a catalyst to deliver the move before theta bites.",
        1: ("Cheap-or-fair vol with no catalyst (or a holiday theta trap) = WAIT. tastytrade wouldn't buy; "
            "SteadyOptions only buys cheap vol WITH a catalyst; without a driver you're just renting theta."),
        2: ("Rich vol (IV/HV ≥ 1.20 or high IVR) = a SELLER's setup. You'd overpay for the move — "
            "tastytrade/SMB/Option Alpha all lean seller here; on a small account keep it defined-risk."),
    }[ci]
    full_why = f"Engine verdict: {verdict} — {why}\n\n{lens}\n\nManage if you ever DO buy: take +50% / cut −50% of debit, bail by 21 DTE, close before any event (IV crush)."
    return {"qid": f"live-spy-{date.today():%Y%m%d}",
            "question": q, "options": opts, "correct_index": ci, "why": full_why,
            "module": "debate", "header": "🎲 LIVE STRADDLE DESK"}


def main() -> int:
    # respect an open recent rep (don't stomp the curriculum), like the static sender
    try:
        st = json.loads(STATE.read_text())
    except Exception:
        st = {}
    cur = st.get("current")
    if cur and not DRY and (time.time() - cur.get("asked_at", 0)) < 5 * 3600:
        print("[live-quiz] a rep is still open (<5h) — skipping to avoid double-ask")
        return 0

    item = None
    if MODE == "position":
        item = position_question()
    elif MODE == "straddle":
        item = straddle_question()
    else:  # auto: his real trade first (most personal), else the live engine read
        item = position_question() or straddle_question()
    if not item:
        print("[live-quiz] no question could be built (no positions + engine read failed)")
        return 0

    ci = item["correct_index"]
    body = "\n".join(f"{LETTERS[i]}) {o}" for i, o in enumerate(item["options"]))
    caption = (f"🎓 <b>LIVE OPTIONS REP</b> — tap your answer 👇\n<i>{item['header']}</i>\n\n"
               f"{item['question']}\n\n{body}")
    buttons = [[{"text": LETTERS[i], "callback_data": f"oq:{LETTERS[i]}:{item['qid']}"} for i in (0, 1)],
               [{"text": LETTERS[i], "callback_data": f"oq:{LETTERS[i]}:{item['qid']}"} for i in (2, 3)]]

    if DRY:
        print(f"DRY live rep [{item['module']}]:\n{caption}\n→ correct={LETTERS[ci]} ({item['options'][ci]})")
        print(f"--- explain ---\n{item['why']}")
        return 0

    chat_id = CHAT_FILE.read_text().strip()
    r = _tg("sendMessage", chat_id=chat_id, text=caption, parse_mode="HTML",
            reply_markup={"inline_keyboard": buttons})
    if r is None:
        return 1
    st["current"] = {"qid": item["qid"], "correct": LETTERS[ci], "answer_text": item["options"][ci],
                     "explain": item["why"], "module": item["module"], "asked_at": time.time()}
    st["asked_n"] = int(st.get("asked_n", 0)) + 1
    st.setdefault("score", {"right": 0, "wrong": 0, "streak": 0})
    st.setdefault("boxes", {}); st.setdefault("last_seen", {})
    STATE.parent.mkdir(parents=True, exist_ok=True)
    STATE.write_text(json.dumps(st, indent=1))
    print(f"[live-quiz] sent {item['qid']} ({item['module']}, answer={LETTERS[ci]}) at {datetime.now(ET):%H:%M ET}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
