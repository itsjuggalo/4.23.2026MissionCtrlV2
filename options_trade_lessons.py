#!/home/itsju/.venv/bin/python
"""options_trade_lessons.py — Options Mastery Phase 5: the trade→lesson→quiz flywheel.

Every CLOSED option round-trip in Mike's Boba paper book becomes a teaching moment:
pair the fills → realized P/L → a post-mortem CARD (what happened + the doctrine
lesson) → and a personalized QUIZ off his OWN trade. Over weeks his reps become a
mirror of his actual mistakes — the fastest way to get good.

Sources: Alpaca closed orders (filled buys/sells), paired FIFO per OCC symbol.
Sends via the trading bot (same lane as the quiz). The optional quiz reuses the
existing `oq:` grader path (no responder changes), guarded by the shared 5h rule.

Run:  options_trade_lessons.py            (card for each NEW closed trade; +1 quiz)
      DRY=1 options_trade_lessons.py      (print, don't send / don't mark processed)
      QUIZ=0 options_trade_lessons.py     (cards only, no graded quiz)
"""
from __future__ import annotations
import json, os, re, sys, time, urllib.request
from datetime import datetime, date, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

SEC = Path.home() / ".openclaw" / "secrets"
QSTATE = Path.home() / ".openclaw" / "data" / "options_quiz_state.json"     # shared grader state
LSTATE = Path.home() / ".openclaw" / "data" / "options_lessons_state.json"  # processed-trade ledger
LLOG = Path.home() / ".openclaw" / "data" / "options_lessons.jsonl"
TOKEN_FILE = SEC / "telegram_laptopclaude_bot_token"
CHAT_FILE = SEC / "telegram-chat-id.txt"
PAPER = "https://paper-api.alpaca.markets"
ET = ZoneInfo("America/New_York")
LETTERS = ["A", "B", "C", "D"]
DRY = os.environ.get("DRY") == "1"
DO_QUIZ = os.environ.get("QUIZ", "1") != "0"
LOOKBACK_DAYS = int(os.environ.get("LOOKBACK_DAYS", "10"))
MAX_CARDS = int(os.environ.get("MAX_CARDS", "3"))
OCC = re.compile(r"^([A-Z]+)(\d{6})([CP])(\d{8})$")


def _key():
    return ((SEC / "alpaca-key-id").read_text().strip(),
            (SEC / "alpaca-secret").read_text().strip())


def _get(url: str):
    k, s = _key()
    req = urllib.request.Request(url, headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s})
    return json.loads(urllib.request.urlopen(req, timeout=25).read())


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


def parse_occ(sym: str):
    m = OCC.match(sym or "")
    if not m:
        return None
    root, ymd, cp, strike8 = m.groups()
    return {"root": root, "exp": date(2000 + int(ymd[:2]), int(ymd[2:4]), int(ymd[4:6])),
            "kind": "call" if cp == "C" else "put", "strike": int(strike8) / 1000.0}


def _closed_option_fills():
    """Filled option-symbol orders, oldest→newest, with the fields we need."""
    try:
        rows = _get(f"{PAPER}/v2/orders?status=closed&limit=500&nested=true")
    except Exception as e:
        print(f"[lessons] order fetch failed: {e}")
        return []
    fills = []
    for o in rows:
        sym = o.get("symbol", "")
        if not parse_occ(sym):
            continue
        qty = float(o.get("filled_qty", 0) or 0)
        px = o.get("filled_avg_price")
        if qty <= 0 or px in (None, "", "0"):
            continue
        fa = o.get("filled_at") or o.get("updated_at") or o.get("submitted_at")
        fills.append({"id": o.get("id"), "symbol": sym, "side": o.get("side"),
                      "qty": int(qty), "price": float(px), "at": fa})
    fills.sort(key=lambda f: f["at"] or "")
    return fills


def round_trips():
    """FIFO-pair buys→sells per OCC symbol into closed round-trips with realized P/L."""
    fills = _closed_option_fills()
    by_sym = {}
    for f in fills:
        by_sym.setdefault(f["symbol"], []).append(f)
    trips = []
    for sym, fs in by_sym.items():
        info = parse_occ(sym)
        lots = []  # open buy lots: [qty, price, at]
        for f in fs:
            if f["side"] == "buy":
                lots.append([f["qty"], f["price"], f["at"]])
            elif f["side"] == "sell":
                rem = f["qty"]
                cost = 0.0; bought = 0; open_at = None
                while rem > 0 and lots:
                    lot = lots[0]
                    take = min(rem, lot[0])
                    cost += take * lot[1]; bought += take
                    open_at = open_at or lot[2]
                    lot[0] -= take; rem -= take
                    if lot[0] == 0:
                        lots.pop(0)
                if bought == 0:
                    continue
                avg_buy = cost / bought
                pl = (f["price"] - avg_buy) * bought * 100.0
                plpc = (f["price"] - avg_buy) / avg_buy * 100.0 if avg_buy else 0.0
                trips.append({
                    "close_id": f["id"], "symbol": sym, **info,
                    "qty": bought, "buy": round(avg_buy, 2), "sell": round(f["price"], 2),
                    "pl": round(pl, 2), "plpc": round(plpc, 1),
                    "open_at": open_at, "close_at": f["at"],
                })
    return trips


def _days(a, b):
    try:
        da = datetime.fromisoformat(a.replace("Z", "+00:00"))
        db = datetime.fromisoformat(b.replace("Z", "+00:00"))
        return max((db - da).days, 0)
    except Exception:
        return None


def lesson_for(rt: dict):
    """Post-mortem card + a quiz dict off this real closed trade."""
    label = f"{rt['root']} {rt['strike']:g}{'C' if rt['kind']=='call' else 'P'} {rt['exp']:%-m/%-d}"
    hold = _days(rt["open_at"], rt["close_at"])
    win = rt["pl"] > 0
    plpc = rt["plpc"]
    holdtxt = f"{hold}d" if hold is not None else "—"
    verb = "✅ WIN" if win else "❌ LOSS"

    # --- classify the takeaway (honest heuristics) ---
    if win and plpc >= 40:
        lesson = ("Strong winner. The discipline test is whether you SCALED — sold half near "
                  "+50% and trailed the rest to breakeven — or round-tripped it. Banking partials "
                  "is what turns a good entry into kept money.")
        qz = {"q": f"Your <b>{label}</b> closed <b>+{plpc:.0f}%</b>. On the NEXT one like it, what locks the win without capping all the upside?",
              "opts": ["Hold the whole thing to expiry", "Sell half near +50% and trail the rest to breakeven",
                       "Add more at the high", "Set a +500% target and ignore it"],
              "ci": 1,
              "why": "Scale-out: bank half at the first target, move the stop on the runner to breakeven. You keep a real gain AND a free shot at more — 'never give it all back.'"}
    elif win:
        lesson = ("A win — good. Was it a planned exit (+25–50% target) or did you bail early out of "
                  "nerves? A repeatable +30% beaten out of fear of giving it back is fine; a winner "
                  "cut at +5% before the thesis played out is leaving edge on the table.")
        qz = {"q": f"Your <b>{label}</b> closed <b>+{plpc:.0f}%</b> in {holdtxt}. What's the disciplined target to set BEFORE entry next time?",
              "opts": ["No target — just vibe it", "A pre-set +25–50% take-profit (with a −25–50% stop)",
                       "Only sell at expiration", "Sell the instant it's green"],
              "ci": 1,
              "why": "Set the exit BEFORE you enter: a +25–50% take-profit and a −25–50% stop. No-plan exits are where small accounts give winners back."}
    elif plpc <= -40:
        lesson = ("Full stop hit. The question is whether your −50% stop fired on time or you let it "
                  "bleed past it hoping. The stop IS the trade — surviving to take the next setup beats "
                  "marrying a thesis. If the catalyst already passed, a flat/red option is theta bleed.")
        qz = {"q": f"Your <b>{label}</b> closed <b>{plpc:.0f}%</b>. What rule would have capped that loss?",
              "opts": ["Average down to lower the basis", "A hard −50% stop on the debit, exit when it triggers",
                       "Hold to expiration and hope", "Buy a second contract"],
              "ci": 1,
              "why": "A −50%-of-debit stop caps the damage and keeps you in the game. Averaging down a decaying long option just funds more theta on a move that isn't coming."}
    else:
        lesson = ("Small loss — often the quiet killer: THETA. If the stock went roughly nowhere and "
                  "the option faded, time decay (back-loaded, worse near expiry) did it. The fix is "
                  "the catalyst rule: only pay premium when a driver is due, and bail by ~21 DTE if "
                  "it isn't working.")
        qz = {"q": f"Your <b>{label}</b> closed <b>{plpc:.0f}%</b> in {holdtxt} with the stock ~flat. What most likely ate it?",
              "opts": ["Delta", "Theta (time decay) — no move, no catalyst", "Rho", "The broker"],
              "ci": 1,
              "why": "A long option with no move and no catalyst bleeds THETA daily, faster near expiry. Have a catalyst and an exit; don't rent time on a move that has no reason to come."}

    card = (f"📓 <b>TRADE POST-MORTEM</b> — {verb}\n"
            f"<b>{label}</b> · {rt['qty']}x · bought ${rt['buy']} → sold ${rt['sell']} · "
            f"<b>{'+' if rt['pl']>=0 else ''}{rt['pl']:.0f}</b> ({plpc:+.0f}%) · held {holdtxt}\n\n"
            f"💡 {lesson}")
    quiz = {"qid": f"trade-{rt['close_id']}", "question": qz["q"], "options": qz["opts"],
            "correct_index": qz["ci"], "why": qz["why"], "module": "management",
            "header": "📓 YOUR OWN TRADE"}
    return card, quiz


def _load(p, d):
    try:
        return json.loads(Path(p).read_text())
    except Exception:
        return d


def _send_quiz(quiz: dict) -> bool:
    """Ship one trade-quiz through the existing oq: grader path (respects the 5h guard)."""
    st = _load(QSTATE, {})
    cur = st.get("current")
    if cur and (time.time() - cur.get("asked_at", 0)) < 5 * 3600:
        print("[lessons] a rep is open (<5h) — card sent, quiz deferred"); return False
    ci = quiz["correct_index"]
    body = "\n".join(f"{LETTERS[i]}) {o}" for i, o in enumerate(quiz["options"]))
    caption = (f"🎓 <b>LIVE OPTIONS REP</b> — tap your answer 👇\n<i>{quiz['header']}</i>\n\n"
               f"{quiz['question']}\n\n{body}")
    buttons = [[{"text": LETTERS[i], "callback_data": f"oq:{LETTERS[i]}:{quiz['qid']}"} for i in (0, 1)],
               [{"text": LETTERS[i], "callback_data": f"oq:{LETTERS[i]}:{quiz['qid']}"} for i in (2, 3)]]
    r = _tg("sendMessage", chat_id=CHAT_FILE.read_text().strip(), text=caption,
            parse_mode="HTML", reply_markup={"inline_keyboard": buttons})
    if r is None:
        return False
    st["current"] = {"qid": quiz["qid"], "correct": LETTERS[ci], "answer_text": quiz["options"][ci],
                     "explain": quiz["why"], "module": quiz["module"], "asked_at": time.time()}
    st["asked_n"] = int(st.get("asked_n", 0)) + 1
    st.setdefault("score", {"right": 0, "wrong": 0, "streak": 0})
    st.setdefault("boxes", {}); st.setdefault("last_seen", {})
    QSTATE.write_text(json.dumps(st, indent=1))
    return True


def main() -> int:
    trips = round_trips()
    if not trips:
        print("[lessons] no closed option round-trips found")
        return 0
    led = _load(LSTATE, {"done": []})
    done = set(led.get("done", []))
    cutoff = time.time() - LOOKBACK_DAYS * 86400
    fresh = []
    for rt in sorted(trips, key=lambda t: t["close_at"] or "", reverse=True):
        if rt["close_id"] in done:
            continue
        ca = _days("1970-01-01T00:00:00+00:00", rt["close_at"])
        # within lookback window?
        try:
            ts = datetime.fromisoformat((rt["close_at"] or "").replace("Z", "+00:00")).timestamp()
        except Exception:
            ts = time.time()
        if ts < cutoff:
            continue
        fresh.append(rt)
    if not fresh:
        print("[lessons] nothing new in the lookback window")
        return 0

    cards = fresh[:MAX_CARDS]
    print(f"[lessons] {len(fresh)} new closed trade(s); carding {len(cards)}")
    chat = None if DRY else CHAT_FILE.read_text().strip()
    # pick the most instructive for the quiz: biggest |%| move
    quiz_pick = max(cards, key=lambda t: abs(t["plpc"]))
    sent_quiz = False
    for rt in cards:
        card, quiz = lesson_for(rt)
        if DRY:
            print("\n" + card)
            if rt is quiz_pick:
                print(f"   └─ QUIZ → correct {LETTERS[quiz['correct_index']]}: {quiz['options'][quiz['correct_index']]}")
            continue
        _tg("sendMessage", chat_id=chat, text=card, parse_mode="HTML")
        try:
            with LLOG.open("a") as f:
                f.write(json.dumps({"ts": datetime.now(timezone.utc).isoformat(), **{k: (v.isoformat() if isinstance(v, date) else v) for k, v in rt.items()}}) + "\n")
        except Exception:
            pass
        if DO_QUIZ and rt is quiz_pick and not sent_quiz:
            sent_quiz = _send_quiz(quiz)
        done.add(rt["close_id"])
    if not DRY:
        led["done"] = list(done)[-500:]
        LSTATE.parent.mkdir(parents=True, exist_ok=True)
        LSTATE.write_text(json.dumps(led, indent=1))
        print(f"[lessons] sent {len(cards)} card(s)"
              + (" + 1 quiz" if sent_quiz else "") + f" at {datetime.now(ET):%H:%M ET}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
