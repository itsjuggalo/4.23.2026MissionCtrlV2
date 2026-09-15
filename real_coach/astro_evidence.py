#!/usr/bin/env python3
"""astro_evidence.py — the evidence loop: what Mike wrote (/note) and scored (/score) versus what the sky
was doing (sky-quality score, exact timeline hits, active Svehla windows). Monthly on the 1st at 08:38 ET.
No questions asked — it only reads what he already logged.

CLI: astro_evidence.py [--days N] [--send]
"""
from __future__ import annotations
import json, sys
from collections import defaultdict
from datetime import date, datetime, timedelta
from pathlib import Path
import astro_truth as T
import astro_lookahead as LA
import astro_timeline as TL
import svehla

DIR = Path.home() / "portfolio/astrology"
JOURNAL, SCORES = DIR / "journal.jsonl", DIR / "scores.json"


def _notes() -> list[dict]:
    if not JOURNAL.exists():
        return []
    out = []
    for ln in JOURNAL.read_text().splitlines():
        try:
            out.append(json.loads(ln))
        except Exception:
            pass
    return out


def _hits_near(d: date, days: int = 1) -> list[dict]:
    lo, hi = (d - timedelta(days=days)).isoformat(), (d + timedelta(days=days)).isoformat()
    return [e for e in TL.load() if lo <= e["date"] <= hi and e["kind"] in ("aspect", "progressed", "to_progressed", "eclipse")]


def report(days: int = 31, d: date | None = None) -> str:
    d = d or datetime.now(T.ET).date()
    since = d - timedelta(days=days)
    notes = [n for n in _notes() if n.get("date", "") >= since.isoformat()]
    scores = json.loads(SCORES.read_text()) if SCORES.exists() else {}
    lines = [f"🧾 EVIDENCE — {since:%b %-d} → {d:%b %-d}: your notes vs the sky (no questions, just what you logged)"]
    if not notes and not scores:
        lines.append("Nothing logged yet. /note <what happened> any day, /score <window-id> 1-5 when a window ends — this report writes itself from those.")
        return "\n".join(lines)
    # per-note context
    qs = []
    if notes:
        lines.append("")
        lines.append(f"NOTES ({len(notes)}) with the sky that day:")
        for n in notes[-12:]:
            nd = date.fromisoformat(n["date"])
            q, why = LA.score(datetime(nd.year, nd.month, nd.day, 12, tzinfo=T.ET))
            qs.append(q)
            hits = _hits_near(nd)
            hit_txt = "; ".join(h["what"].split(" (pass")[0] for h in hits[:2])
            wins = ", ".join(n.get("windows", [])[:2])
            lines.append(f"• {nd:%b %-d} · quality {q}/10" + (f" · {hit_txt}" if hit_txt else "") + (f" · windows: {wins}" if wins else ""))
            lines.append(f"   “{n.get('text', '')[:140]}”")
        if qs:
            avg = sum(qs) / len(qs)
            lines.append(f"Average sky quality on the days you wrote something: {avg:.1f}/10 (baseline days sit near 6).")
            hi = [n for n, q in zip(notes[-12:], qs) if q >= 8]
            lo = [n for n, q in zip(notes[-12:], qs) if q <= 4]
            if hi:
                lines.append(f"Green-light days you noted: {', '.join(date.fromisoformat(n['date']).strftime('%b %-d') for n in hi)} — reread those notes, that is what a good sky feels like for you.")
            if lo:
                lines.append(f"Rough-sky days you noted: {', '.join(date.fromisoformat(n['date']).strftime('%b %-d') for n in lo)} — check whether the note matches the transit named above.")
    # window scores → which transit bodies actually land
    if scores:
        lines.append("")
        by_body: dict[str, list[int]] = defaultdict(list)
        for wid, v in scores.items():
            body = next((b for b in ("Saturn", "Jupiter", "Uranus", "Neptune", "Pluto", "Chiron", "Juno", "Ceres", "Progressed Moon", "Progressed Venus") if b.lower() in v.get("title", "").lower()), "other")
            by_body[body].append(v["score"])
        lines.append("WHAT LANDS FOR YOU (your /score 1-5 by transit body):")
        for body, vals in sorted(by_body.items(), key=lambda kv: -sum(kv[1]) / len(kv[1])):
            avg = sum(vals) / len(vals)
            verdict = "reliable" if avg >= 4 else "mixed" if avg >= 2.5 else "weak"
            lines.append(f"• {body}: {avg:.1f}/5 over {len(vals)} window{'s' if len(vals) > 1 else ''} — {verdict}")
        lines.append("This is the one thing Svehla can't tell you: which of his tools actually track your life. Score more windows and it sharpens.")
    # coming month: the hits worth noting
    nxt = [e for e in TL.load() if d.isoformat() < e["date"] <= (d + timedelta(days=31)).isoformat()
           and e["kind"] in ("aspect", "eclipse", "to_progressed") and (e["body"] in ("Saturn", "Uranus", "Neptune", "Pluto", "Chiron") or e["kind"] == "eclipse")]
    if nxt:
        lines.append("")
        lines.append("WORTH A /note WHEN THEY HIT (next 31 days):")
        for e in nxt[:5]:
            lines.append(f"• {date.fromisoformat(e['date']):%b %-d}: {e['what']}")
    return "\n".join(lines)


if __name__ == "__main__":
    days = int(sys.argv[sys.argv.index("--days") + 1]) if "--days" in sys.argv else 31
    out = report(days)
    print(out)
    if "--send" in sys.argv:
        for chunk in (out[i:i + 3900] for i in range(0, len(out), 3900)):
            svehla.send_to_lane(chunk)
