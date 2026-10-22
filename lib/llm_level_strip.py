"""Strip model-invented price levels from LLM text (DECISIONS R32, Mike 2026-10-21: levels only when computed from
data). Removes clauses such as "entry 123.4", "trigger > $125", "stop 118", "SL: 117.50", "target 140", "TP1 150",
"PT $200" and "buy above 99". Everything else in the line stays. stdin → stdout CLI; prints the count to stderr.

    echo "AAPL — long, entry 231, stop 224, earnings Thu" | python3 lib/llm_level_strip.py
    → "AAPL — long, earnings Thu"
"""
from __future__ import annotations

import re
import sys

_WORD = r"(?:entry(?:[- ]?(?:or[- ]?)?trigger)?|trigger|stop(?:[- ]?loss)?|sl|target|tgt|pt|price target|tp\d?|take[- ]profit|" \
        r"(?:buy|sell|short|long)\s+(?:above|below|over|under|at|near))"
_NUM = r"\$?(?:\d{1,3}(?:,\d{3})+|\d+)(?:\.\d+)?"
_LEVEL = rf"\b{_WORD}\b\s*(?:level|zone|ref)?\s*[:=@]?\s*(?:[<>≥≤~]=?\s*)?{_NUM}(?:\s*(?:[-–/]|to)\s*{_NUM})?"
_CLAUSE = re.compile(rf"\s*[,;·|(]?\s*{_LEVEL}(?:\s*\))?", re.I)


def strip(text: str) -> tuple[str, int]:
    out, n = [], 0
    for line in (text or "").splitlines():
        new, k = _CLAUSE.subn("", line)
        n += k
        new = re.sub(r"\s*[,;·|]\s*(?=[,;·|]|$)", "", new).rstrip(" ,;·|-—")
        out.append(new if k else line)
    return "\n".join(out), n


if __name__ == "__main__":
    txt, n = strip(sys.stdin.read())
    sys.stdout.write(txt + ("\n" if txt and not txt.endswith("\n") else ""))
    print(f"llm_level_strip: removed {n} model-invented level clause(s)", file=sys.stderr)
