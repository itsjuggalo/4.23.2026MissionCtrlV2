#!/home/itsju/.venv/bin/python
"""build_academy.py — render the self-contained Options Academy HTML.

Single source of truth = options_quiz_bank.json (also read by the Telegram
quiz, options_quiz.py). This injects that bank into academy_template.html at
the /*__BANK__*/ marker and writes the standalone deliverable. Re-run it
whenever the question bank changes so the two surfaces never drift.

Run:  build_academy.py   →   ~/restructure/options-academy/index.html
"""
from __future__ import annotations
import json, sys
from pathlib import Path

HERE = Path(__file__).resolve().parent
BANK = HERE / "options_quiz_bank.json"
TEMPLATE = HERE / "academy_template.html"
OUT = Path.home() / "restructure" / "options-academy" / "index.html"
# Second emit: bundled into the ClaudeClaw dashboard (imported ?raw → iframe srcdoc).
EMBED = Path.home() / "agents" / "claudeclaw" / "web" / "src" / "embed" / "options-academy.html"
MARKER = "/*__BANK__*/"


def main() -> int:
    data = json.loads(BANK.read_text())          # validate JSON
    n = len(data.get("questions", []))
    if n < 50:
        print(f"[build_academy] refusing: only {n} questions (need >=50)")
        return 1
    tpl = TEMPLATE.read_text()
    if MARKER not in tpl:
        print(f"[build_academy] marker {MARKER} not found in template")
        return 1
    payload = json.dumps(data, ensure_ascii=False, separators=(",", ":"))
    if "</script" in payload.lower():            # guard against script-break injection
        print("[build_academy] payload contains a script tag — aborting")
        return 1
    html = tpl.replace(MARKER, payload)
    wrote = []
    for dest in (OUT, EMBED):
        try:
            dest.parent.mkdir(parents=True, exist_ok=True)
            dest.write_text(html)
            wrote.append(str(dest))
        except Exception as e:
            print(f"[build_academy] warn: could not write {dest}: {e}")
    kb = round(len(html) / 1024, 1)
    print(f"[build_academy] {n} questions, {kb} KB → " + " + ".join(wrote))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
