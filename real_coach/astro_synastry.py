#!/usr/bin/env python3
"""astro_synastry.py — synastry and progressed synastry from TWO isolated profiles.

Every factor carries full identity labels — "Mike.natal.Venus ☌ Sam.progressed.Mars" — so A and
B can never be swapped silently (tests assert synastry(A,B) is the mirror of synastry(B,A)).

  • Natal charts: 10 planets + Chiron + true Node; ASC/MC/houses ONLY when that person's birth
    time is known (otherwise UNAVAILABLE — never a noon-chart angle).
  • Orbs (natal↔natal): luminary/angle pairs 8/8/7/7/5 (conj/opp/sq/trine/sext), otherwise 6/6/5/5/4.
    Anything progressed: 1° (progressions are slow — a wider orb would claim years-long contacts).
  • House overlays: A's planets in B's houses only when B's time is known (and vice versa).
  • Progressed synastry, all four frames for a date: natal×natal, A.progressed×B.natal,
    A.natal×B.progressed, A.progressed×B.progressed. Progressions come from T.progressed_at
    (the ONE progression calculator — day-for-a-year from each person's own natal JD).

  astro_synastry.py <A> <B>                → natal synastry
  astro_synastry.py <A> <B> --progressed [YYYY-MM-DD]
"""
from __future__ import annotations

import sys
from datetime import date, datetime
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402
import astro_profiles as P  # noqa: E402
import swisseph as swe  # noqa: E402

BODIES = ["Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto",
          "Chiron", "Node"]
PROG_BODIES = ["Sun", "Moon", "Mercury", "Venus", "Mars"]
ASPECTS = {"conjunct": 0, "opposite": 180, "square": 90, "trine": 120, "sextile": 60}
GLYPH = {"conjunct": "☌", "sextile": "﹡", "square": "□", "trine": "△", "opposite": "☍"}
ORB_WIDE = {"conjunct": 8, "opposite": 8, "square": 7, "trine": 7, "sextile": 5}
ORB_STD = {"conjunct": 6, "opposite": 6, "square": 5, "trine": 5, "sextile": 4}
PROG_ORB = 1.0
WIDE = {"Sun", "Moon", "ASC", "MC"}
HARD = {"square", "opposite"}

# deterministic interpretation groups — first matching rule wins (order matters)
ATTRACTION_PAIRS = [{"Venus", "Mars"}, {"Venus"}, {"Venus", "Sun"}, {"Venus", "ASC"}, {"Mars", "ASC"}]
AFFLICTORS = {"Mars", "Saturn", "Pluto", "Uranus"}
GROUP_LABEL = {"emotional": "💞 Emotional bond", "attraction": "🔥 Attraction", "communication": "💬 Communication",
               "stability": "🧱 Stability & commitment", "friction": "⚡ Friction to work with",
               "long-term": "⏳ Long-term / fated", "other": "• Other contacts"}


def _calc(jd: float, name: str) -> tuple[float, float]:
    b = T.BODIES.get(name) if name in T.BODIES else T.EXTRA_BODIES[name]
    r = swe.calc_ut(jd, b)[0]
    return r[0] % 360, r[3]


def chart(p: dict) -> dict:
    """Natal chart of one profile. Houses/angles only when its birth time is known."""
    jd = p["natal_jd"]
    known = bool(p.get("time_known"))
    cusps = list(swe.houses(jd, p["lat"], p["lon"], b"P")[0]) if known else None
    pts = {}
    for n in BODIES:
        lon, spd = _calc(jd, n)
        pts[n] = T.describe(lon, spd, cusps, houses=known)
    angles = ({"ASC": cusps[0], "MC": cusps[9]} if known else {})
    for n, lon in angles.items():
        pts[n] = T.describe(lon, 0.0, cusps, houses=True)
    return {"profile": p["id"], "name": p["name"], "time_known": known, "cusps": cusps, "points": pts,
            "unavailable": [] if known else ["ASC", "MC", "houses"]}


def progressed_chart(p: dict, on: date) -> dict:
    tz = P.ZoneInfo(p["tz"])
    target = T.jd_local(on, 12, tz=tz)
    known = bool(p.get("time_known"))
    cusps = list(swe.houses(p["natal_jd"], p["lat"], p["lon"], b"P")[0]) if known else None
    pts = T.progressed_at(target, p["natal_jd"], PROG_BODIES, cusps, known)
    return {"profile": p["id"], "name": p["name"], "time_known": known, "cusps": cusps, "points": pts,
            "date": on.isoformat()}


def _orb(a: str, b: str, aspect: str, progressed: bool) -> float:
    if progressed:
        return PROG_ORB
    return (ORB_WIDE if (a in WIDE or b in WIDE) else ORB_STD)[aspect]


def group_of(a: str, b: str, aspect: str) -> str:
    pair, hard = {a, b}, aspect in HARD
    if "Moon" in pair:
        return "friction" if hard and pair & {"Saturn", "Pluto", "Mars"} else "emotional"
    if pair in ATTRACTION_PAIRS:
        return "attraction"
    if "Mercury" in pair:
        return "communication"
    if "Saturn" in pair:
        return "friction" if hard else "stability"
    if pair & {"Node", "Pluto"} or pair == {"Jupiter", "Saturn"}:
        return "long-term"
    if hard and pair & AFFLICTORS:
        return "friction"
    return "other"


def cross(ca: dict, fa: str, cb: dict, fb: str) -> list[dict]:
    """Every aspect between A.<fa> points and B.<fb> points, with identity labels."""
    progressed = "progressed" in (fa, fb)
    out = []
    for na, va in ca["points"].items():
        for nb, vb in cb["points"].items():
            sep = T.angle(va["lon"], vb["lon"])
            for asp, deg in ASPECTS.items():
                orb = abs(sep - deg)
                if orb <= _orb(na, nb, asp, progressed):
                    out.append({"a": f"{ca['name']}.{fa}.{na}", "b": f"{cb['name']}.{fb}.{nb}",
                                "a_point": na, "b_point": nb, "a_frame": fa, "b_frame": fb,
                                "a_profile": ca["profile"], "b_profile": cb["profile"],
                                "aspect": asp, "orb": round(orb, 2), "group": group_of(na, nb, asp),
                                "a_pos": va["dms"], "b_pos": vb["dms"]})
    out.sort(key=lambda x: (x["orb"] / _orb(x["a_point"], x["b_point"], x["aspect"], progressed)))
    return out


def overlays(ca: dict, cb: dict) -> list[dict]:
    """A's planets in B's houses — only if B's birth time is known."""
    if not cb["time_known"]:
        return []
    return [{"who": ca["name"], "point": n, "in": cb["name"], "house": T.house_of(v["lon"], cb["cusps"])}
            for n, v in ca["points"].items() if n in ("Sun", "Moon", "Venus", "Mars", "Mercury", "Jupiter", "Saturn")]


def synastry(a: dict, b: dict) -> dict:
    ca, cb = chart(a), chart(b)
    return {"a": a["id"], "b": b["id"], "aspects": cross(ca, "natal", cb, "natal"),
            "overlays_a_in_b": overlays(ca, cb), "overlays_b_in_a": overlays(cb, ca),
            "unavailable": {a["name"]: ca["unavailable"], b["name"]: cb["unavailable"]}}


def progressed_synastry(a: dict, b: dict, on: date) -> dict:
    ca, cb = chart(a), chart(b)
    pa, pb = progressed_chart(a, on), progressed_chart(b, on)
    return {"a": a["id"], "b": b["id"], "date": on.isoformat(), "frames": {
        "natal×natal": cross(ca, "natal", cb, "natal"),
        f"{a['name']}.progressed×{b['name']}.natal": cross(pa, "progressed", cb, "natal"),
        f"{a['name']}.natal×{b['name']}.progressed": cross(ca, "natal", pb, "progressed"),
        f"{a['name']}.progressed×{b['name']}.progressed": cross(pa, "progressed", pb, "progressed")},
        "unavailable": {a["name"]: ca["unavailable"], b["name"]: cb["unavailable"]}}


def _line(x: dict) -> str:
    return f"{GLYPH[x['aspect']]} {x['a']} ({x['a_pos']}) {x['aspect']} {x['b']} ({x['b_pos']}) · {x['orb']:.2f}°"


_GIST = {"emotional": "your feelings connect", "attraction": "attraction", "communication": "how you talk",
         "stability": "staying power", "long-term": "a long-term bond", "friction": "friction to work through",
         "other": "a background link"}
_NICE = {"ASC": "Rising", "MC": "Midheaven", "DSC": "Descendant"}


def _glance(s: dict, a: dict, b: dict) -> list[str]:
    """C12: lead with a plain 3-line answer + easy/hard count before the raw contact list."""
    asp = s["aspects"]
    if not asp:
        return ["No major contacts within orb — a low-key match on paper."]
    easy = sum(x["aspect"] in ("trine", "sextile") for x in asp)
    hard = sum(x["aspect"] in ("square", "opposite") for x in asp)
    fused = sum(x["aspect"] == "conjunct" for x in asp)
    out = [f"At a glance: {easy} easy · {hard} tense · {fused} fused contacts. Tightest:"]
    for x in sorted(asp, key=lambda x: x["orb"])[:3]:
        out.append(f"• {a['name']}'s {_NICE.get(x['a_point'], x['a_point'])} {GLYPH[x['aspect']]} "
                   f"{b['name']}'s {_NICE.get(x['b_point'], x['b_point'])} ({x['orb']:.2f}°) — {_GIST[x['group']]}")
    return out


def render(s: dict, a: dict, b: dict) -> str:
    lines = [f"💑 SYNASTRY — {a['name']} × {b['name']} (tropical, Placidus)"] + _glance(s, a, b) + ["", "All contacts by theme:"]
    for who, miss in s["unavailable"].items():
        if miss:
            lines.append(f"⚠️ {who}: birth time unknown → ASC, MC and houses UNAVAILABLE (planets at local noon; "
                         f"the Moon can be off by up to ±6°).")
    groups: dict[str, list] = {}
    for x in s["aspects"]:
        groups.setdefault(x["group"], []).append(x)
    for g in ("emotional", "attraction", "communication", "stability", "long-term", "friction", "other"):
        if g in groups:
            lines.append(""); lines.append(GROUP_LABEL[g])
            lines += [_line(x) for x in groups[g][:6 if g != "other" else 4]]
    for key, who in (("overlays_a_in_b", a["name"]), ("overlays_b_in_a", b["name"])):
        ov = s[key]
        if ov:
            lines.append(""); lines.append(f"🏠 {who}'s planets in {ov[0]['in']}'s houses: " +
                                            ", ".join(f"{o['point']} → {T.ordinal(o['house'])}" for o in ov))
    return "\n".join(lines)


def render_progressed(s: dict, a: dict, b: dict) -> str:
    lines = [f"💑⏳ PROGRESSED SYNASTRY — {a['name']} × {b['name']} on {date.fromisoformat(s['date']):%b %-d %Y} (orb 1° for progressed contacts)"]
    for frame, asp in s["frames"].items():
        lines.append(""); lines.append(f"[{frame}] — {len(asp)} contact(s)" + (" · tightest 8 shown" if len(asp) > 8 else ""))
        lines += [_line(x) for x in asp[:8]] or ["(none within orb)"]
    for who, miss in s["unavailable"].items():
        if miss:
            lines.append(f"⚠️ {who}: birth time unknown → no angles/houses; progressed Moon uncertain by ~±0.5°.")
    return "\n".join(lines)


def main() -> int:
    a = [x for x in sys.argv[1:] if not x.startswith("--")]
    if len(a) < 2:
        print(__doc__); return 2
    pa, pb = P.get(a[0]), P.get(a[1])
    missing = [n for n, p in ((a[0], pa), (a[1], pb)) if not p]
    if missing:
        print(f"UNAVAILABLE — no birth profile for {', '.join(missing)}. Add one: "
              f"/profile add <name> <YYYY-MM-DD> <HH:MM|unknown> <birth place>")
        return 1
    if "--progressed" in sys.argv:
        on = date.fromisoformat(a[2]) if len(a) > 2 else T.today_local()
        print(render_progressed(progressed_synastry(pa, pb, on), pa, pb))
    else:
        print(render(synastry(pa, pb), pa, pb))
    return 0


if __name__ == "__main__":
    sys.exit(main())
