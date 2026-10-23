"""R32 output validator for LLM free text (DECISIONS R32, Mike 2026-10-21): computed levels yes, sizes and caps no.

An LLM-written brief may name catalysts and a tone, but it may not size a trade, tell Mike to use a stop, or invent
a price level — levels come only from the levels.v1 engine (levels_block), each with method + source + as_of.
scrub(text) removes every sentence that does any of those and returns what it removed, so the sender can say so.
Deterministic, no network. Percentages, basis points and $-amounts with a unit (k/M/B) are data, not levels.

    from lib.r32_text import scrub
    clean, removed = scrub(llm_text)
"""
from __future__ import annotations

import re

_NUM = r"\$?\d[\d,]*(?:\.\d+)?(?![\d/:])(?!\s*(?:%|bp|bps|k\b|K\b|M\b|B\b|mn\b|bn\b|million|billion|trillion|percent))"

SIZE = re.compile(
    r"\b(?:trad(?:e|ing)|keep(?:ing)?|stay(?:ing)?|go(?:ing)?|start(?:ing)?|play(?:ing)?)\s+(?:it\s+|things\s+)?"
    r"(?:very\s+)?(?:small|smaller|light|lighter|tiny)\b"
    r"|\bsiz(?:e|ing)\s+(?:down|up|small|light)\b|\bposition[- ]?siz\w*|\bsized?\s+(?:small|light|down)\b"
    r"|\b(?:half|quarter|full|small|smaller|reduced|light|starter|partial)[- ](?:size[ds]?|position|positions|stake)\b"
    r"|\b(?:don'?t|do not|never)\s+(?:over)?size\b|\boversiz\w*"
    r"|\b\d+(?:\.\d+)?\s*%\s+of\s+(?:your\s+|the\s+|my\s+)?(?:account|portfolio|capital|book|buying power)\b"
    r"|\brisk(?:ing)?\s+(?:no more than|only|just|at most|max)\s+\$?\d"
    r"|\b\d+\s+(?:contracts?|shares?|lots?)\b|\btranches?\b|\bscal(?:e|ing)\s+in(?:to)?\b"
    r"|\b(?:risk|position|loss|price)\s+cap\b|\bmax(?:imum)?\s+(?:risk|loss|size)\b",
    re.I)

STOP = re.compile(
    r"\bstop[- ]?loss(?:es)?\b|\btrailing\s+stops?\b"
    r"|\b(?:use|set|place|keep|with|have|tight|hard|mental|honou?r|respect)\s+(?:a\s+|your\s+|the\s+)?"
    r"(?:tight\s+|hard\s+|firm\s+|mental\s+)?stops?\b"
    r"|\bstops?\s+(?:at|below|above|under|near|around|just)\b"
    r"|\btake[- ]profits?\b|\bprofit[- ]targets?\b|\btargets?\s+(?:at|of|near|around)\s+" + _NUM,
    re.I)

LEVEL = re.compile(
    r"\b(?:support|resistance|pivot|key level|levels?|entry|enter|entries|buy(?:ing)?|sell(?:ing)?|short(?:ing)?|"
    r"reclaim(?:s|ing)?|break(?:s|ing)?(?:\s+(?:above|below|through))?|breakout|breakdown|holds?|holding|loses?|"
    r"losing|trim|add(?:ing)?|fade|bounce)\s+(?:at|near|around|above|below|under|over|on|of|from|to)?\s*" + _NUM
    + r"|\b(?:above|below|under|over)\s+\$\d[\d,]*(?:\.\d+)?\b",
    re.I)

_SENT = re.compile(r"((?<=[.!?;])\s+|\s+[—–]\s+)")
_PREFIX = re.compile(r"^(\s*(?:[-*•]\s*)?(?:[A-Z][A-Za-z ]{1,20}:\s*)?)")


def _hits(s: str) -> list[str]:
    return [k for k, rx in (("size", SIZE), ("stop", STOP), ("level", LEVEL)) if rx.search(s)]


def scrub(text: str) -> tuple[str, list[dict]]:
    """Drop each sentence that sizes a trade, advises a stop/target or names an invented price level.
    A line whose every sentence goes keeps its label ("PLAN:") with a removal note, so the reader sees the gap.
    -> (clean text, [{kind: [...], text: removed sentence}])."""
    removed: list[dict] = []
    out: list[str] = []
    for line in (text or "").splitlines():
        if not line.strip():
            out.append(line)
            continue
        m = _PREFIX.match(line)
        label, rest = (m.group(1), line[m.end():]) if m else ("", line)
        parts = _SENT.split(rest)            # [sentence, separator, sentence, …]
        keep: list[tuple[str, str]] = []     # (separator before it, sentence)
        for i in range(0, len(parts), 2):
            sent, sep = parts[i], (parts[i - 1] if i else "")
            kinds = _hits(sent)
            if kinds:
                removed.append({"kind": kinds, "text": sent.strip()})
            elif sent.strip():
                keep.append((sep, sent.strip()))
        if keep:
            out.append(label + keep[0][1] + "".join(sep + s for sep, s in keep[1:]))
        elif rest.strip():
            if label.strip():
                out.append(label + "[removed: sizing / stop / level advice is not allowed (R32)]")
        else:
            out.append(line)
    return "\n".join(out), removed


def note(removed: list[dict]) -> str:
    """One footer line naming what the validator removed ('' when nothing was)."""
    if not removed:
        return ""
    kinds = sorted({k for r in removed for k in r["kind"]})
    return f"R32 check removed {len(removed)} phrase(s): {', '.join(kinds)} advice. Levels come only from levels.v1."
