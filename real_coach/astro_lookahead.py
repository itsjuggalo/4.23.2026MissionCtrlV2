#!/usr/bin/env python3
"""astro_lookahead.py — /week, /month and the daily sky-quality score.

  astro_lookahead.py week | month | quality
week/month: transit→natal aspects per day (slow bodies first, Moon excluded), peak day marked,
each hit with its Svehla thread when it has one. quality: 1-10 for LIFE decisions (never trading):
+ easy aspects, − hard aspects weighted by body slowness, − Mercury rx, − Moon void-of-course.
"""
from __future__ import annotations

import sys
from datetime import datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402

WEIGHT = {"Sun": 1.0, "Mercury": 0.6, "Venus": 0.8, "Mars": 1.2, "Jupiter": 1.5, "Saturn": 2.0,
          "Uranus": 1.8, "Neptune": 1.4, "Pluto": 2.0, "Chiron": 1.2, "Ceres": 0.6, "Juno": 0.8, "Moon": 0.3}
GLYPH = {"conjunct": "☌", "sextile": "﹡", "square": "□", "trine": "△", "opposite": "☍"}


def day_hits(d: datetime) -> list[dict]:
    return [h for h in T.aspects(d) if h["t"] != "Moon"]


def score(d: datetime) -> tuple[int, list[str]]:
    hits = T.aspects(d)
    s, why = 6.0, []
    for h in hits:
        w = WEIGHT.get(h["t"], 1.0) * (1.0 - h["orb"] / 3.0)
        if h["aspect"] in ("trine", "sextile"):
            s += 0.8 * w; why.append(f"+ {h['t']} {h['aspect']} {h['n']}")
        elif h["aspect"] in ("square", "opposite"):
            s -= 1.0 * w; why.append(f"− {h['t']} {h['aspect']} {h['n']}")
        else:
            s += (0.3 if h["t"] in ("Venus", "Jupiter", "Sun") else -0.4) * w
            why.append(f"{'+' if h['t'] in ('Venus', 'Jupiter', 'Sun') else '−'} {h['t']} conjunct {h['n']}")
    tr = T.transits(d)
    if tr["Mercury"]["rx"]:
        s -= 1.0; why.append("− Mercury retrograde")
    try:
        import astro_sky
        v = astro_sky.void_of_course(d)
        if v.get("is_voc_now"):
            s -= 0.8; why.append("− Moon void-of-course")
    except Exception:
        pass
    return max(1, min(10, round(s))), why


def quality_block(d: datetime | None = None) -> str:
    d = d or datetime.now(T.ET)
    n, why = score(d)
    label = {1: "stay small", 2: "stay small", 3: "defensive", 4: "careful", 5: "neutral", 6: "neutral",
             7: "constructive", 8: "green light", 9: "green light", 10: "rare — use it"}[n]
    return (f"🎚 SKY QUALITY {d:%a %b %-d}: {n}/10 — {label} (life decisions, not trades)\n" +
            "\n".join(why[:6]))


def lookahead_block(days: int, d: datetime | None = None) -> str:
    d = (d or datetime.now(T.ET)).replace(hour=12, minute=0)
    try:
        import svehla
        fit = svehla.fit_for
    except Exception:
        fit = lambda *a, **k: ""  # noqa: E731
    lines = [f"📅 NEXT {days} DAYS — transits to your chart (slow bodies first)", ""]
    seen, best_day, best_n = set(), None, -1
    for i in range(days):
        dd = d + timedelta(days=i)
        hits = day_hits(dd)
        if not hits:
            continue
        n, _ = score(dd)
        if len(hits) > best_n:
            best_n, best_day = len(hits), dd
        lines.append(f"{dd:%a %b %-d} · quality {n}/10")
        for h in hits[:4]:
            key = (h["t"], h["n"], h["aspect"])
            tag = "" if key in seen else " ← new"
            seen.add(key)
            f = fit(h["t"], h["n"], dd.date())
            lines.append(f"  {GLYPH[h['aspect']]} {h['t']} {h['aspect']} natal {h['n']} (orb {h['orb']}°){tag}" + (f" — {f.split(':')[0]}" if f else ""))
    if best_day:
        lines.append(""); lines.append(f"Peak day: {best_day:%a %b %-d} ({best_n} aspects in orb). /explain on the day for the full read.")
    return "\n".join(lines)


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "week"
    if "--send" in sys.argv:
        import io, contextlib
        buf = io.StringIO()
        with contextlib.redirect_stdout(buf):
            sys.argv = [a for a in sys.argv if a != "--send"]
            import importlib, runpy
            fn = {"week": lambda: print(lookahead_block(7)), "month": lambda: print(lookahead_block(30)), "quality": lambda: print(quality_block())}.get(cmd)
            fn() if fn else print(__doc__)
        from svehla import send_to_lane
        out = buf.getvalue()
        print(out)
        for chunk in (out[i:i + 3900] for i in range(0, len(out), 3900)):
            send_to_lane(chunk)
        sys.exit(0)
    print({"week": lambda: lookahead_block(7), "month": lambda: lookahead_block(30), "quality": quality_block}[cmd]())
