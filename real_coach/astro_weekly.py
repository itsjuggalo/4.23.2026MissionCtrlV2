#!/usr/bin/env python3
"""astro_weekly.py — the WEEKLY read (/week, and the Monday section of the 8:32 morning packet).

Role split (2026-09-27 final round): the DAILY is "what is live today" (Moon, today's exacts, ranked
live transits, lunar phase). The WEEKLY is "the shape of the next 7 days" and never reprints the
daily: themes of the week, every exact in the next 7 days with local ET time + pass label, the slow
transits in force with their pass context, progressions, Svehla windows with Why/Do, best/hardest
days, and what's coming after. Every fact comes from astro_events / astro_timeline (canonical).

  astro_weekly.py            → print the week starting now
  astro_weekly.py 2026-10-05 → the week starting that date (08:00 ET)
  astro_weekly.py --send     → also send to the astrology bot
"""
from __future__ import annotations

import subprocess
import sys
from datetime import date, datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402
import astro_events as E  # noqa: E402

SLOW = {"Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"}
TG_FLEET = Path.home() / "05_AUTOMATION/scripts/tg_fleet.py"


def _week_exacts(start: datetime, days: int = 7) -> list[dict]:
    import astro_timeline as TL
    lo, hi = start.isoformat(), (start + timedelta(days=days)).isoformat()
    dlo, dhi = start.date().isoformat(), (start + timedelta(days=days)).date().isoformat()
    out = [e for e in TL.load()
           if (e.get("exact_at_local") and lo <= e["exact_at_local"] < hi)
           or (not e.get("exact_at_local") and dlo <= e["date"] < dhi)]
    seen = {(e.get("body"), e.get("aspect"), e.get("natal")) for e in out}
    for e in E.fast_exacts(T.jd_for(start), T.jd_for(start + timedelta(days=days))):
        if (e["body"], e["aspect"], e["natal"]) not in seen:
            e.setdefault("kind", "aspect")
            out.append(e)
    out.sort(key=lambda e: e.get("exact_at_local") or e["date"])
    return TL._merge_angles(out)


def _pass_txt(e: dict) -> str:
    if (e.get("pass_total") or 1) <= 1:
        return ""
    return f" ({(e.get('pass_label') or 'pass').lower()} {e.get('pass_number')} of {e['pass_total']})"


def weekly_block(start: datetime | date | None = None) -> str:
    if start is None:
        start = T.now_local()
    elif isinstance(start, date) and not isinstance(start, datetime):
        start = datetime.combine(start, datetime.min.time(), tzinfo=T.ET).replace(hour=8)
    today = start.date()
    end = start + timedelta(days=7)
    lines = [f"🗓 YOUR WEEK — {start:%a %b %-d} → {(end - timedelta(days=1)):%a %b %-d}", ""]

    mid = start + timedelta(days=3)
    live = E.current_transits(mid, with_passes=True)
    exacts = _week_exacts(start)

    # 1 · themes of the week (mid-week live events + this week's exacts)
    th = E.themes(live)
    if th:
        lines.append("🧭 THEMES OF THE WEEK")
        for t in th[:3]:
            sup, con = len(t["supporting_factors"]), len(t["conflicting_factors"])
            ev = [f.split(" — ")[0] for f in t["evidence"] if " — " in f][:3]
            lines.append(f"• {t['label']} — {t['tone']} ({sup} for" + (f", {con} against)" if con else ")")
                         + (f": {'; '.join(ev)}" if ev else ""))
            if t["missing"]:
                lines.append(f"   uncertain: {'; '.join(t['missing'])}")
        lines.append("")

    # 2 · every exact this week, with the local instant and pass label
    import astro_timeline as TL
    lines.append("⏰ EXACT THIS WEEK (ET)")
    if exacts:
        for e in exacts[:14]:
            when = T.round_minute(datetime.fromisoformat(e["exact_at_local"])).strftime("%a %b %-d %-I:%M %p") \
                if e.get("exact_at_local") and e.get("moving_frame") != "progressed" else \
                date.fromisoformat(e["date"]).strftime("%a %b %-d")
            m = TL._meaning(e)
            lines.append(f"{TL._glyph(e)} {when}: {e['what']}{_pass_txt(e) if '(pass' not in e['what'] else ''}"
                         + (f" — {m}" if m else ""))
    else:
        lines.append("Nothing goes exact to your chart this week — a consolidation week.")
    lines.append("")

    # 3 · slow transits in force (the backdrop), with pass context — no reprint of the daily paragraphs
    slow = [e for e in live if e["moving_body"] in SLOW]
    if slow:
        lines.append("🐢 SLOW TRANSITS IN FORCE")
        for e in slow[:6]:
            bits = [e["motion"]]
            if (e.get("pass_total") or 1) > 1:
                bits.append(f"{(e.get('pass_label') or '').lower()} {e['pass_number']}/{e['pass_total']}")
            nxt = [p for p in e.get("passes", []) if p.get("exact_at_local", "") >= start.isoformat()]
            if nxt:
                bits.append(f"next exact {E.when_label(nxt[0], today)}")
            if e.get("window_end"):
                bits.append(f"in orb until {date.fromisoformat(e['window_end']):%b %-d %Y}")
            lines.append(f"{E.GLYPH[e['aspect']]} {e['moving_body']} {e['aspect']} natal {e['target_body']} — "
                         + "; ".join(bits))
        lines.append("")

    # 4 · progressions (the slow inner clock)
    try:
        p = T.progressed(today)
        pm, pv = p["Moon"], p["Venus"]
        lines.append("🌙 PROGRESSIONS")
        lines.append(f"Progressed Moon {pm['dms']} in your {T.ordinal(pm['house'])} house · "
                     f"progressed Venus {pv['dms']} in your {T.ordinal(pv['house'])}")
        nxt = [e for e in TL.load() if e.get("moving_frame") == "progressed" and e["date"] >= today.isoformat()][:3]
        for e in nxt:
            lines.append(f"   next: {date.fromisoformat(e['date']):%b %-d %Y} — {e['what']}")
        lines.append("")
    except Exception as ex:
        lines += [f"🌙 (progressions unavailable: {ex})", ""]

    # 5 · Svehla windows touching this week (Why / Do live here, not in the daily)
    try:
        import svehla
        ws = [w for w in svehla.load_windows() if w["_start"] < end.date() and w["_end"] >= today]
        if ws:
            lines.append("📜 SVEHLA WINDOWS THIS WEEK")
            for w in ws:
                left = (w["_end"] - today).days
                state = f"starts {w['_start']:%b %-d}" if w["_start"] > today else f"{left}d left"
                lines.append(f"{svehla.KIND_ICON.get(w['kind'], '•')} {w['title']} ({state}){svehla.computed_note(w)}")
                if w.get("why"):
                    lines.append(f"   Why: {w['why']}")
                if w.get("do"):
                    lines.append(f"   Do: {w['do']}")
            lines.append("")
    except Exception as ex:
        lines += [f"📜 (Svehla windows unavailable: {ex})", ""]

    # 6 · best / hardest days (the life-decision sky score, per day at noon)
    try:
        import astro_lookahead as LA
        q = [(LA.score((start + timedelta(days=i)).replace(hour=12, minute=0))[0], start + timedelta(days=i)) for i in range(7)]
        hi_d = max(q, key=lambda x: x[0]); lo_d = min(q, key=lambda x: x[0])
        lines.append(f"✅ Best day {hi_d[1]:%a %b %-d} ({hi_d[0]}/10) · 🛑 hardest {lo_d[1]:%a %b %-d} ({lo_d[0]}/10) — life decisions")
        lines.append("")
    except Exception as ex:
        lines += [f"🎚 (day scores unavailable: {ex})", ""]

    # 7 · coming up after this week (next 3 slow / progressed / Svehla exacts within 45 days)
    later = [e for e in TL.load() if end.date().isoformat() <= e["date"] <= (end + timedelta(days=45)).date().isoformat()
             and (e["body"] in SLOW or e.get("moving_frame") == "progressed" or e.get("kind") == "eclipse")][:4]
    if later:
        lines.append("⏭ COMING UP")
        for e in later:
            lines.append(f"{TL._glyph(e)} {E.when_label(e, today)}: {e['what']}")
    return "\n".join(lines).rstrip()


def main() -> int:
    a = [x for x in sys.argv[1:] if not x.startswith("--")]
    start = datetime.fromisoformat(a[0]).replace(hour=8, tzinfo=T.ET) if a else None
    out = weekly_block(start)
    print(out)
    if "--send" in sys.argv:
        import daily_transits as DT
        for chunk in DT.chunk_message(out):
            subprocess.run([sys.executable, str(TG_FLEET), "send", "astrology", chunk], capture_output=True, timeout=30)
    return 0


if __name__ == "__main__":
    sys.exit(main())
