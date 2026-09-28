#!/usr/bin/env python3
"""astro_morning.py — the ONE morning astrology send (08:32 ET), replacing five crons that fired
08:32–08:38 (Mike 2026-09-27: "merge the morning pile-up").

  daily digest            every day            (daily_transits.py)
  + Svehla week           Mondays              (svehla.weekly_block) — the daily's 📜/⏳/🗓 sections are
                                                dropped that day because the weekly carries them in full
  + 30-day lookahead      1st of the month     (astro_lookahead.lookahead_block(30, compact=True))
  + evidence report       1st of the month     (astro_evidence.report(31)) — only once /note has entries
  + lunar return brief    lunar-return day     (astro_returns.lunar_return_block)

Sections are packed into as few Telegram messages as fit under 3900 chars (paragraph boundaries).
The 08:34 astro_tasks guardrail (trading lane) and the Oct 27 solar return stay separate.

CLI: astro_morning.py [--send] [--force monday,first,lunar]   (--force = preview the extra sections)
"""
from __future__ import annotations

import subprocess
import sys
from datetime import datetime
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402

HERE = Path(__file__).resolve().parent
PY = str(Path.home() / ".venv/bin/python")
RULE = "━━━━━━━━━━"
WEEKLY_COVERS = ("📜", "⏳", "🗓")          # daily paragraphs the Monday weekly repeats in full


def _daily() -> str:
    r = subprocess.run([PY, str(HERE / "daily_transits.py")], capture_output=True, text=True, timeout=240)
    return (r.stdout or "").strip() or f"🌌 (daily transits unavailable: rc={r.returncode} {r.stderr.strip()[:200]})"


def _section(label: str, fn) -> str:
    try:
        return (fn() or "").strip()
    except Exception as e:                       # one layer failing never kills the send
        return f"({label} unavailable: {e})"


def build(force: set[str] | None = None) -> str:
    force = force or set()
    today = datetime.now(T.ET).date()
    monday, first = today.weekday() == 0 or "monday" in force, today.day == 1 or "first" in force
    daily = _daily()
    if monday:
        daily = "\n\n".join(p for p in daily.split("\n\n") if not p.lstrip().startswith(WEEKLY_COVERS))
    parts = [daily]
    if monday:
        import svehla
        parts.append(_section("Svehla week", svehla.weekly_block))
    if first:
        import astro_lookahead, astro_evidence
        parts.append(_section("month lookahead", lambda: astro_lookahead.lookahead_block(30, compact=True)))
        ev = _section("evidence", lambda: astro_evidence.report(31))
        if "Nothing logged yet" not in ev:        # silent until there are notes to compare
            parts.append(ev)
    try:
        import astro_returns
        nxt = (astro_returns.lunar_return(today).get("next") or {})
        if str(nxt.get("when_et", ""))[:10] == today.isoformat() or "lunar" in force:
            parts.append(_section("lunar return", lambda: astro_returns.lunar_return_block(today)))
    except Exception as e:
        parts.append(f"(lunar return check unavailable: {e})")
    return f"\n\n{RULE}\n\n".join(p for p in parts if p)


def pack(msg: str, limit: int = 3900) -> list[str]:
    chunks, cur = [], ""
    for para in msg.split("\n\n"):
        while len(para) > limit:                 # a single oversized paragraph: hard-split on lines
            cut = para.rfind("\n", 0, limit)
            cut = cut if cut > 0 else limit
            if cur:
                chunks.append(cur); cur = ""
            chunks.append(para[:cut]); para = para[cut:].lstrip("\n")
        if cur and len(cur) + len(para) + 2 > limit:
            chunks.append(cur); cur = para
        else:
            cur = f"{cur}\n\n{para}" if cur else para
    if cur:
        chunks.append(cur)
    return [c.strip().removesuffix(RULE).strip() for c in chunks if c.strip() and c.strip() != RULE]


if __name__ == "__main__":
    force = set()
    if "--force" in sys.argv:
        force = set(sys.argv[sys.argv.index("--force") + 1].split(","))
    chunks = pack(build(force))
    for i, c in enumerate(chunks, 1):
        print(f"── message {i}/{len(chunks)} ({len(c)} chars) ──\n{c}\n")
    if "--send" in sys.argv:
        from svehla import send_to_lane           # retries with backoff
        failed = [i for i, c in enumerate(chunks, 1) if not send_to_lane(c)]
        if failed:
            print(f"✖ morning send FAILED for message(s) {failed} of {len(chunks)}", file=sys.stderr)
            sys.exit(1)
