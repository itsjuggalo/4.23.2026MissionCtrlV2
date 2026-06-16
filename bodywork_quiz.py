#!/home/itsju/.venv/bin/python
"""bodywork_quiz.py — Erik Dalton bodywork quiz on the LIFE & WELLNESS bot.

Samples the vision-curated bank (erikdalton_quiz_build.py → quiz_bank.json) and sends a short
technique CLIP (motion — the move in action, metadata stripped, NO chapter-number leak) with
tappable A/B/C answers. Graded by lifeclaw_bot.py against ~/.lifeclaw/bodywork_quiz_state.json
(decoupled from the trading quiz). Distractors are drawn from the SAME body region first, so
the answer comes from recognizing the technique, not from frame provenance.

Run:  bodywork_quiz.py        Test: DRY=1 bodywork_quiz.py   Replace open quiz: FORCE=1 ...
"""
from __future__ import annotations

import json
import os
import random
import sys
import time
from pathlib import Path

ANAT = Path.home() / "erikdalton-kb" / "anatomy"
BANK = ANAT / "quiz_bank.json"
STATE = Path.home() / ".lifeclaw" / "bodywork_quiz_state.json"
LETTERS = ["A", "B", "C"]
DRY = os.environ.get("DRY") == "1"


def _load(p, default):
    try:
        return json.loads(Path(p).read_text())
    except Exception:
        return default


def main() -> int:
    bank = [e for e in _load(BANK, [])
            if e.get("clip") and os.path.exists(e["clip"]) and e.get("technique")]
    if len(bank) < 3:
        print(f"[bodywork-quiz] bank too small ({len(bank)}) — let erikdalton_quiz_build.py run first")
        return 0

    st = _load(STATE, {})
    cur = st.get("current")
    if cur and not DRY and os.environ.get("FORCE") != "1":
        # Skip only if a RECENT quiz is still open; expire stale ones so an unanswered
        # quiz can't permanently block future ones.
        if (time.time() - cur.get("asked_at", 0)) < 18 * 3600:
            print("[bodywork-quiz] a recent quiz is still open — skipping (won't clobber)")
            return 0

    item = random.choice(bank)
    correct = item["technique"]
    region = (item.get("region") or "").strip()
    # distractors: SAME region first (plausible), then any other technique — unique, != correct
    same = list(dict.fromkeys(e["technique"] for e in bank
                if e.get("region") == item.get("region") and e["technique"] != correct))
    others = list(dict.fromkeys(e["technique"] for e in bank if e["technique"] != correct))
    random.shuffle(same)
    random.shuffle(others)
    pool = []
    for t in same + others:
        if t not in pool and t != correct:
            pool.append(t)
        if len(pool) >= 2:
            break
    if len(pool) < 2:
        print("[bodywork-quiz] not enough distinct distractors yet")
        return 0

    opts = [correct] + pool
    random.shuffle(opts)
    ci = opts.index(correct)
    body = "\n".join(f"{LETTERS[i]}) {o}" for i, o in enumerate(opts))
    qid = f"bodywork-{int(st.get('asked_n', 0)) + 1}"
    caption = ("🧠 <b>BODYWORK QUIZ</b> — tap your answer 👇\n\n"
               "Which Erik Dalton technique is shown?"
               + (f" <i>(region: {region})</i>" if region else "")
               + f"\n{body}")
    explain = (f"<b>{correct}</b>" + (f" — region: {region}." if region else ".")
               + (f"\n{item.get('caption')}" if item.get("caption") else ""))
    buttons = [[{"text": L, "callback_data": f"quiz:{L}:{qid}"} for L in LETTERS[:len(opts)]]]

    if DRY:
        print(f"DRY bodywork quiz:\n{caption}\n→ correct={LETTERS[ci]} ({correct})\nclip={item['clip']}")
        return 0

    sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
    from lib.tg_wellness_card import send_card_with_buttons
    ok = send_card_with_buttons(item["clip"], caption, buttons, animation=True)
    if not ok:
        print("[bodywork-quiz] send failed")
        return 1

    st["current"] = {"qid": qid, "correct": LETTERS[ci], "answer_text": correct,
                     "explain": explain, "asked_at": time.time()}
    st["asked_n"] = int(st.get("asked_n", 0)) + 1
    st.setdefault("score", {"right": 0, "wrong": 0, "streak": 0})
    STATE.write_text(json.dumps(st, indent=1))
    print(f"[bodywork-quiz] sent ({correct}, answer={LETTERS[ci]}, region={region})")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
