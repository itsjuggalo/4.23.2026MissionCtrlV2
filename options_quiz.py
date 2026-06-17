#!/home/itsju/.venv/bin/python
"""options_quiz.py — Options Academy daily rep on the LifeClaw bot.

Sends ONE multiple-choice options question (A/B/C/D tappable) to Mike's Telegram
via the TRADING bot @oOLaptopClaude_Bot (trading_command), from the SAME bank the
HTML Academy uses (options_quiz_bank.json), so the two surfaces never drift.
Graded by tg_responder.py's `oq:` callback → options_quiz_grade.grade() against
~/.openclaw/data/options_quiz_state.json. (Trading lane — NOT LifeClaw, which is
life-only.)

Spaced repetition (Leitner): each question has a box 1..5. Missed → box 1 (comes
back often); correct → promoted (seen less). The picker prefers shaky questions
(box 1-2), then introduces new ones in curriculum order, then refreshes known ones.

Run:  options_quiz.py        Test: DRY=1 options_quiz.py     Force a new one: FORCE=1 ...
"""
from __future__ import annotations
import json, os, random, sys, time
from pathlib import Path
from datetime import datetime
from zoneinfo import ZoneInfo

import requests

HERE   = Path(__file__).resolve().parent
BANK   = HERE / "options_quiz_bank.json"
STATE  = Path.home() / ".openclaw" / "data" / "options_quiz_state.json"   # trading lane (not ~/.lifeclaw)
SECRETS = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SECRETS / "telegram_laptopclaude_bot_token"   # @oOLaptopClaude_Bot (trading_command)
CHAT_FILE  = SECRETS / "telegram-chat-id.txt"
ET     = ZoneInfo("America/New_York")
LETTERS = ["A", "B", "C", "D"]
DRY    = os.environ.get("DRY") == "1"
FORCE  = os.environ.get("FORCE") == "1"


def _load(p, default):
    try:
        return json.loads(Path(p).read_text())
    except Exception:
        return default


def _tg(method, **kwargs):
    token = TOKEN_FILE.read_text().strip()
    try:
        return requests.post(f"https://api.telegram.org/bot{token}/{method}",
                             json=kwargs, timeout=15).json()
    except Exception as e:
        print(f"tg {method} error: {e}")
        return {"ok": False}


def pick(bank: list, st: dict) -> dict:
    """Leitner-weighted pick: shaky (box 1-2) → new (in order) → refresh known."""
    boxes = st.get("boxes", {})
    seen  = st.get("last_seen", {})
    review = sorted([q for q in bank if boxes.get(q["id"], 0) in (1, 2)],
                    key=lambda q: seen.get(q["id"], 0))
    new    = [q for q in bank if q["id"] not in boxes]          # curriculum order
    known  = sorted([q for q in bank if boxes.get(q["id"], 0) >= 3],
                    key=lambda q: seen.get(q["id"], 0))
    if review and (random.random() < 0.5 or not new):
        return review[0]
    if new:
        return new[0]
    if review:
        return review[0]
    return known[0] if known else random.choice(bank)


def main() -> int:
    data = _load(BANK, {})
    bank = [q for q in data.get("questions", []) if "svg" not in q]   # Telegram reps = text-only
    if len(bank) < 10:
        print(f"[options-quiz] bank too small ({len(bank)})")
        return 0

    st = _load(STATE, {})
    cur = st.get("current")
    if cur and not DRY and not FORCE:
        # don't double-ask within ~5h; expire older open reps so they can't block forever
        if (time.time() - cur.get("asked_at", 0)) < 5 * 3600:
            print("[options-quiz] a recent rep is still open (<5h) — skipping")
            return 0

    q = pick(bank, st)
    ci = q["correct_index"]
    correct_letter = LETTERS[ci]
    mod = next((m["name"] for m in data.get("meta", {}).get("modules", []) if m["id"] == q["module"]), q["module"])
    lv  = {1: "Beginner", 2: "Intermediate", 3: "Advanced"}.get(q.get("level"), "")
    body = "\n".join(f"{LETTERS[i]}) {o}" for i, o in enumerate(q["options"]))
    caption = (f"🎓 <b>OPTIONS REP</b> — tap your answer 👇\n"
               f"<i>{mod}" + (f" · {lv}" if lv else "") + "</i>\n\n"
               f"{q['question']}\n\n{body}")
    explain = q["why"] + (f"\n\n💵 <b>Your $6k/RH:</b> {q['rh_note']}" if q.get("rh_note") else "")
    buttons = [[{"text": LETTERS[i], "callback_data": f"oq:{LETTERS[i]}:{q['id']}"} for i in (0, 1)],
               [{"text": LETTERS[i], "callback_data": f"oq:{LETTERS[i]}:{q['id']}"} for i in (2, 3)]]

    if DRY:
        print(f"DRY options rep:\n{caption}\n→ correct={correct_letter} ({q['options'][ci]})\nid={q['id']} box={st.get('boxes',{}).get(q['id'],0)}")
        return 0

    chat_id = CHAT_FILE.read_text().strip()
    r = _tg("sendMessage", chat_id=chat_id, text=caption, parse_mode="HTML",
            reply_markup={"inline_keyboard": buttons})
    if not r.get("ok"):
        print(f"[options-quiz] send failed: {r}")
        return 1

    st["current"] = {"qid": q["id"], "correct": correct_letter, "answer_text": q["options"][ci],
                     "explain": explain, "module": q["module"], "asked_at": time.time()}
    st["asked_n"] = int(st.get("asked_n", 0)) + 1
    st.setdefault("score", {"right": 0, "wrong": 0, "streak": 0})
    st.setdefault("boxes", {})
    st.setdefault("last_seen", {})
    STATE.parent.mkdir(parents=True, exist_ok=True)
    STATE.write_text(json.dumps(st, indent=1))
    print(f"[options-quiz] sent {q['id']} ({mod}, answer={correct_letter}) at {datetime.now(ET):%H:%M ET}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
