#!/home/itsju/.venv/bin/python
"""options_quiz_grade.py — shared grader for the Options Academy Telegram reps.

ONE place owns the grading + Leitner spaced-repetition logic, imported by the
trading-bot responder (tg_responder.py) on the `oq:` callback. The sender
(options_quiz.py) writes `current`; this grades the tap and updates the box.

State: ~/.openclaw/data/options_quiz_state.json (trading lane — NOT in ~/.lifeclaw).
"""
from __future__ import annotations
import json, time
from pathlib import Path

STATE = Path.home() / ".openclaw" / "data" / "options_quiz_state.json"


def grade(letter: str, qid):
    """Grade an Options Academy rep tap → (html_message, right|None). Updates Leitner box."""
    try:
        st = json.loads(STATE.read_text())
    except Exception:
        st = {}
    q = st.get("current")
    if not q or (qid and q.get("qid") and q.get("qid") != qid):
        return "🎓 That rep already closed — the next one's on its way.", None
    right = (letter or "")[:1].upper() == q.get("correct")
    sc = st.setdefault("score", {"right": 0, "wrong": 0, "streak": 0})
    if right:
        sc["right"] += 1; sc["streak"] = sc.get("streak", 0) + 1
    else:
        sc["wrong"] += 1; sc["streak"] = 0
    boxes = st.setdefault("boxes", {}); seen = st.setdefault("last_seen", {})
    prev = boxes.get(qid, 2)
    boxes[qid] = min(prev + 1, 5) if right else 1     # correct → promote, miss → box 1 (resurfaces)
    seen[qid] = time.time()
    st["current"] = None
    try:
        STATE.write_text(json.dumps(st, indent=1))
    except Exception:
        pass
    head = ("✅ <b>Correct!</b>" if right else
            f"❌ Not quite — it was <b>{q.get('correct')}) {q.get('answer_text', '')}</b>.")
    return f"{head}\n\n{q.get('explain', '')}\n\nScore: {sc['right']}-{sc['wrong']} · streak {sc['streak']}", right
