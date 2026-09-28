#!/home/itsju/.venv/bin/python
"""quiz_bot.py — the QUIZ-ONLY Telegram lane (@MoneyFlowz_Bot "Options Quiz", fleet fn `quiz`).

2026-09-28 (Mike: "use a retired bot for quizzes only"). Every trading quiz now sends here
instead of Trading Command / PipelineSignals, and this one poller grades them all:

  oq:<L>:<qid>    Options Academy / live-position / trade-lesson reps → options_quiz_grade
  quiz:<L>[:qid]  signal quizzes (best3_quiz) + learning quizzes (learn_quiz) → dm_responder.quiz_answer
  qn:<kind>       ▶ Next buttons (opt | sig | live)      qs  📊 score

Commands: /quiz (options rep now) · /signal (quiz from today's real flow) · /live (quiz on a
live contract) · /learn [greeks|ta|erik] · /score · /help. A bare A-D reply answers the open quiz.
After every answer the bot offers ▶ Next — practice at your own pace instead of waiting on cron.

Only ONE getUpdates consumer per token: PM2 `quiz-bot` owns telegram_grok_bot_token
(tg_responder refuses `xsentiment`; tg-fleet-audit flags a second poller as CONFLICT).
"""
from __future__ import annotations

import json
import os
import subprocess
import sys
import time
from pathlib import Path

import requests

HERE = Path(__file__).resolve().parent
DIGEST = Path("/AIWorkWSL/trading/signals/option-scraper/pipeline/digest")
sys.path.insert(0, str(HERE))
sys.path.insert(0, str(DIGEST))
import tg_fleet  # noqa: E402

PY = str(Path.home() / ".venv/bin/python")
SEC = Path.home() / ".openclaw" / "secrets"
OPT_STATE = Path.home() / ".openclaw" / "data" / "options_quiz_state.json"
SIG_STATE = Path("/AIWorkWSL/trading/signals/option-scraper/data/best3_quiz_state.json")
STALE_S = 3600          # taps/messages older than this at boot are dropped, not replayed
DRY = os.environ.get("DRY") == "1"

COMMANDS = [("quiz", "Options rep now"), ("signal", "Quiz from today's real flow"),
            ("live", "Quiz on a live contract"), ("learn", "Greeks / chart / bodywork quiz"),
            ("score", "Belt, streaks, weakest topics"), ("help", "How this bot works")]
NEXT_KB = {"inline_keyboard": [[{"text": "▶ Options rep", "callback_data": "qn:opt"},
                                {"text": "🧠 Signal quiz", "callback_data": "qn:sig"}],
                               [{"text": "📡 Live contract", "callback_data": "qn:live"},
                                {"text": "📊 Score", "callback_data": "qs"}]]}
HELP = ("🎓 <b>OPTIONS QUIZ</b> — quizzes only, nothing else lands here.\n\n"
        "▸ Tap A/B/C/D on any question to get graded + the why\n"
        "▸ /quiz — options rep now (misses come back until you own them)\n"
        "▸ /signal — quiz built from today's real flow alerts\n"
        "▸ /live — quiz on a contract that's live right now\n"
        "▸ /learn greeks | ta | erik — learning quizzes\n"
        "▸ /score — belt, streaks, weakest topics\n\n"
        "<i>Scheduled reps pause while one is unanswered, so they never pile up.</i>")

TOKEN = ""
OWNER = ""


def api(method: str, **kw):
    if DRY and method not in ("getUpdates", "getMe", "getWebhookInfo"):
        print(f"DRY {method}: {json.dumps(kw)[:300]}")
        return {"ok": True}
    try:
        return requests.post(f"https://api.telegram.org/bot{TOKEN}/{method}", json=kw,
                             timeout=kw.get("timeout", 0) + 20).json()
    except Exception as e:  # noqa: BLE001
        print(f"[quiz-bot] {method} error: {type(e).__name__}", flush=True)
        return {"ok": False}


def send(text: str, kb: dict | None = None) -> None:
    kw = {"chat_id": OWNER, "text": text, "parse_mode": "HTML", "disable_web_page_preview": True}
    if kb:
        kw["reply_markup"] = kb
    r = api("sendMessage", **kw)
    if not r.get("ok") and not DRY:          # malformed HTML → plain text, never lose the reply
        import re
        kw.pop("parse_mode"); kw["text"] = re.sub(r"<[^>]+>", "", text)
        r = api("sendMessage", **kw)
    try:
        from lib.tg_ledger import record
        record("quiz", text, bool(r.get("ok")), html=True, src="quiz_bot.py")
    except Exception:
        pass


def _load(p: Path) -> dict:
    try:
        return json.loads(p.read_text())
    except Exception:
        return {}


def run_sender(script: str, *args: str) -> str:
    """Run an existing quiz sender with FORCE=1 (it sends its own buttons to this bot)."""
    try:
        r = subprocess.run([PY, script, *args], env={**os.environ, "FORCE": "1"},
                           capture_output=True, text=True, timeout=120)
        return (r.stdout + r.stderr).strip()
    except Exception as e:  # noqa: BLE001
        return f"error: {e}"


def options_rep() -> None:
    out = run_sender(str(HERE / "options_quiz.py"))
    if "sent" not in out:
        send(f"🎓 Couldn't send a rep right now.\n<i>{out[-200:]}</i>")


def live_rep() -> None:
    out = run_sender(str(HERE / "options_live_quiz.py"))
    if "sent" not in out:
        send("📡 No live-contract quiz available right now — try /quiz.", NEXT_KB)


def learn_rep(domain: str) -> None:
    dom = {"greek": "greeks", "chart": "ta", "bodywork": "erik"}.get(domain, domain)
    if dom not in ("greeks", "ta", "erik", "random"):
        dom = "random"
    run_sender(str(DIGEST / "learn_quiz.py"), dom)


def signal_quiz() -> None:
    import telegram_dm_responder as dm
    text = dm.quiz_now()
    cur = _load(SIG_STATE).get("current") or {}
    kb = None
    if cur:
        n = int(cur.get("options") or 3)
        suf = f":{cur['qid']}" if cur.get("qid") else ""
        kb = {"inline_keyboard": [[{"text": L, "callback_data": f"quiz:{L}{suf}"}
                                   for L in "ABC"[:n]]]}
    send(text.replace(" (or reply A/B/C)", ""), kb)


def score() -> str:
    st = _load(OPT_STATE)
    sc = st.get("score") or {}
    right, wrong = int(sc.get("right", 0)), int(sc.get("wrong", 0))
    asked = int(st.get("asked_n", 0))
    lines = ["📊 <b>QUIZ SCORE</b>", "",
             f"<b>Options Academy</b> · 🥋 {st.get('belt', 'White')} belt",
             f"▸ {right}-{wrong} · streak {sc.get('streak', 0)} · answered {right + wrong} of {asked} sent"]
    try:
        import options_quiz_grade as g
        data = g._bank()
        mm = g._module_mastery(st, data)
        names = {m["id"]: m["name"] for m in data.get("meta", {}).get("modules", [])}
        ms = st.get("module_stats") or {}
        weak = sorted(mm.items(), key=lambda kv: kv[1])[:3]
        if weak:
            lines.append("▸ weakest: " + " · ".join(f"{names.get(k, k)} {v}%" for k, v in weak))
        misses = [f"{names.get(k, k)} {v['right']}/{v['right'] + v['wrong']}"
                  for k, v in ms.items() if v.get("right", 0) + v.get("wrong", 0)]
        if misses:
            lines.append("▸ by topic: " + " · ".join(misses[:4]))
        shaky = sum(1 for b in (st.get("boxes") or {}).values() if b in (1, 2))
        if shaky:
            lines.append(f"▸ {shaky} missed question(s) queued to come back")
    except Exception:
        pass
    sg = _load(SIG_STATE)
    ss = sg.get("score") or {}
    lines += ["", "<b>Signal quizzes</b> (today's real flow)",
              f"▸ {ss.get('right', 0)}-{ss.get('wrong', 0)} · streak {ss.get('streak', 0)}"]
    due = sg.get("concept_misses") or {}
    if due:
        lines.append("▸ re-testing: " + ", ".join(sorted(due)))
    if asked and right + wrong < asked / 4:
        lines += ["", "<i>Most reps go unanswered — one tap a day moves the belt. /quiz</i>"]
    return "\n".join(lines)


def grade_options(letter: str, qid: str | None) -> tuple[str, bool | None]:
    import options_quiz_grade
    return options_quiz_grade.grade(letter, qid)


def grade_signal(letter: str, qid: str | None) -> tuple[str | None, bool | None]:
    import telegram_dm_responder as dm
    cur = _load(SIG_STATE).get("current") or {}
    if qid and cur.get("qid") and qid != cur.get("qid"):
        return "🧠 That quiz was replaced — /signal for the current one.", None
    out = dm.quiz_answer(letter)
    if out is None:
        return None, None
    out = out.replace("Next quiz comes on schedule, or text QUIZ for one now.", "")
    return out.rstrip(), out.startswith("✅")


def on_callback(cq: dict) -> None:
    cq_id = cq.get("id")
    frm = str((cq.get("from") or {}).get("id", ""))
    msg = cq.get("message") or {}
    if frm != OWNER:
        api("answerCallbackQuery", callback_query_id=cq_id); return
    parts = (cq.get("data") or "").split(":")
    kind = parts[0]
    if kind in ("oq", "quiz"):
        letter = (parts[1] if len(parts) > 1 else "")[:1].upper()
        qid = parts[2] if len(parts) > 2 else None
        try:
            text, right = (grade_options if kind == "oq" else grade_signal)(letter, qid)
        except Exception as e:  # noqa: BLE001
            text, right = f"[grade error] {e}", None
        text = text or "🧠 No quiz open — /signal for one."
        api("answerCallbackQuery", callback_query_id=cq_id,
            text="✅ Correct!" if right else ("❌ Not quite" if right is False else "closed"))
        if right is not None and msg.get("message_id"):   # answered → buttons can't be re-tapped
            api("editMessageReplyMarkup", chat_id=OWNER, message_id=msg["message_id"])
        send(text, NEXT_KB)
        print(f"[quiz-bot] {kind} tap right={right}", flush=True)
        return
    api("answerCallbackQuery", callback_query_id=cq_id)
    if kind == "qs":
        send(score(), NEXT_KB)
    elif kind == "qn":
        {"opt": options_rep, "sig": signal_quiz, "live": live_rep}.get(
            parts[1] if len(parts) > 1 else "opt", options_rep)()


def on_message(m: dict) -> None:
    if str((m.get("chat") or {}).get("id", "")) != OWNER:
        return
    text = (m.get("text") or "").strip()
    if not text:
        return
    cmd, _, arg = text.partition(" ")
    cmd = cmd.lower().split("@")[0].lstrip("/")
    if cmd in ("start", "help", "menu"):
        send(HELP, NEXT_KB)
    elif cmd in ("quiz", "next", "rep", "options"):
        options_rep()
    elif cmd in ("signal", "flow"):
        signal_quiz()
    elif cmd == "live":
        live_rep()
    elif cmd in ("learn", "greeks", "ta", "erik"):
        learn_rep(arg.strip().lower() or (cmd if cmd != "learn" else "random"))
    elif cmd in ("score", "stats", "belt"):
        send(score(), NEXT_KB)
    elif len(text) == 1 and text.upper() in "ABCD":
        out, right = grade_signal(text.upper(), None)
        if out is None and (_load(OPT_STATE).get("current")):
            out, right = grade_options(text.upper(), None)
        send(out or "🧠 No quiz open right now — /quiz for one.", NEXT_KB)
    else:
        send("🎓 Quizzes only here. Tap an answer, or /quiz · /signal · /score · /help.")


def main() -> int:
    global TOKEN, OWNER
    TOKEN = tg_fleet.token("quiz")
    OWNER = (SEC / "telegram-chat-id.txt").read_text().strip()
    wh = api("getWebhookInfo")
    if (wh.get("result") or {}).get("url"):
        print("[quiz-bot] a webhook is set on this token — refusing to poll", flush=True)
        return 2
    if not DRY:
        api("setMyCommands", commands=[{"command": c, "description": d} for c, d in COMMANDS])
    offset, booted = 0, time.time()
    print(f"[quiz-bot] polling as @{(api('getMe').get('result') or {}).get('username')}", flush=True)
    while True:
        r = api("getUpdates", offset=offset, timeout=25,
                allowed_updates=["message", "callback_query"])
        if not r.get("ok"):
            time.sleep(5); continue
        for u in r.get("result", []):
            offset = u["update_id"] + 1
            if u.get("message") and time.time() - u["message"].get("date", booted) > STALE_S:
                continue                                     # old X-Sentiment backlog etc.
            try:
                if u.get("callback_query"):
                    on_callback(u["callback_query"])
                elif u.get("message"):
                    on_message(u["message"])
            except Exception as e:  # noqa: BLE001
                print(f"[quiz-bot] handler error: {type(e).__name__}: {e}", flush=True)
        if DRY:
            return 0


if __name__ == "__main__":
    raise SystemExit(main())
