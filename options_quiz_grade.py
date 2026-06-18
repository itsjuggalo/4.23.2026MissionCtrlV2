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
BANK = Path(__file__).resolve().parent / "options_quiz_bank.json"

# Phase 2 — adaptive progression. A topic isn't "mastered" until its questions sit
# in Leitner box >=3 (correct, spaced). Belt = overall mastery milestone.
BELTS = [(0, "White"), (15, "Yellow"), (30, "Orange"), (45, "Green"),
         (60, "Blue"), (78, "Brown"), (92, "Black")]


def _bank():
    try:
        return json.loads(BANK.read_text())
    except Exception:
        return {"questions": [], "meta": {"modules": []}}


def _module_mastery(st: dict, data: dict) -> dict:
    """{module_id: pct of its questions in box>=3} from the shared Leitner boxes."""
    boxes = st.get("boxes", {})
    out = {}
    by_mod = {}
    for q in data.get("questions", []):
        by_mod.setdefault(q["module"], []).append(q["id"])
    for mod, ids in by_mod.items():
        mastered = sum(1 for i in ids if boxes.get(i, 0) >= 3)
        out[mod] = round(mastered / len(ids) * 100) if ids else 0
    return out


def _belt(overall_pct: float) -> str:
    name = "White"
    for thresh, nm in BELTS:
        if overall_pct >= thresh:
            name = nm
    return name


def grade(letter: str, qid):
    """Grade an Options Academy rep tap → (html_message, right|None). Updates Leitner box
    + per-module mastery + belt (Phase 2 adaptive progression)."""
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
    # per-module rolling accuracy (adaptive weak-spot signal for the picker)
    mod = q.get("module")
    if mod:
        ms = st.setdefault("module_stats", {}).setdefault(mod, {"right": 0, "wrong": 0})
        ms["right" if right else "wrong"] += 1
    st["current"] = None

    # belt / mastery nudge (Phase 2)
    data = _bank()
    mm = _module_mastery(st, data)
    overall = round(sum(mm.values()) / len(mm), 0) if mm else 0
    belt = _belt(overall)
    st["belt"] = belt
    modname = next((m["name"] for m in data.get("meta", {}).get("modules", []) if m["id"] == mod), mod)

    try:
        STATE.write_text(json.dumps(st, indent=1))
    except Exception:
        pass
    head = ("✅ <b>Correct!</b>" if right else
            f"❌ Not quite — it was <b>{q.get('correct')}) {q.get('answer_text', '')}</b>.")
    prog = (f"\n\nScore: {sc['right']}-{sc['wrong']} · streak {sc['streak']}"
            f" · 🥋 {belt} belt ({overall:.0f}% mastered)")
    if mod and mod in mm:
        prog += f"\n<i>{modname}: {mm[mod]}% mastered</i>"
    return f"{head}\n\n{q.get('explain', '')}{prog}", right
