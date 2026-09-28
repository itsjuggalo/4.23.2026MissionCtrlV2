#!/usr/bin/env python3
"""astro_moon.py — the Moon's sign and phase, read against Mike's placements.

Mike (2026-09-28): "post about every moon sign and phase … and how it affects my placements".
Every fact is computed (Swiss Ephemeris, tropical, Placidus, ET): the house(s) the Moon crosses in
that sign, the natal points it conjoins, every major aspect it makes to the natal chart during the
stay (exact ET times), the sign ruler's natal placement, and for phases the lunation's house and
contacts. Interpretation text comes from the lexicon/KB; the Moon is Mike's CHART RULER (Cancer
rising), so its sign changes matter more for him than the generic ~2.5-day mood shift.

  astro_moon.py now            → current Moon sign + phase post
  astro_moon.py sign [Sign]    → the post for the Moon's current/next stay in a sign
  astro_moon.py phase          → the post for the current phase
  astro_moon.py guide          → all 12 signs + 8 phases for Mike's chart (reference)
  astro_moon.py due [hours]    → sign ingresses / phase changes in the next N hours (for alerts)
"""
from __future__ import annotations

import sys
from datetime import datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402
import astro_events as E  # noqa: E402
import astro_lexicon as lex  # noqa: E402

PHASES = ["new", "crescent", "first quarter", "gibbous", "full", "disseminating", "last quarter", "balsamic"]
PHASE_ICON = dict(zip(PHASES, "🌑🌒🌓🌔🌕🌖🌗🌘"))
SIGN_ICON = dict(zip(T.SIGNS, "♈♉♊♋♌♍♎♏♐♑♒♓"))
# how the Moon (feelings, needs, instinct) behaves in each sign — interpretation, not fact
MOON_STYLE = {
    "Aries": "feelings flare fast and burn off fast — impatient, direct, wants to act on the mood now",
    "Taurus": "the Moon's exaltation — steady, sensual, wants comfort, food, money-security and no surprises",
    "Gemini": "restless and chatty — the mood follows conversations, news and whatever's new",
    "Cancer": "the Moon's own sign — protective, nostalgic, home-and-family first; your rising sign, so you feel it in your body",
    "Leo": "warm and proud — wants to be seen, to play, to be appreciated for what you make",
    "Virgo": "fix-it mode — lists, health, routines; soothed by being useful, irritated by mess",
    "Libra": "wants harmony and company — decisions by consensus, sensitive to fairness",
    "Scorpio": "the Moon's fall — intense, private, all-or-nothing; what's hidden surfaces (your Sun sign)",
    "Sagittarius": "wants room, meaning and a plan bigger than today; blunt and optimistic",
    "Capricorn": "the Moon's detriment — feelings go into work and duty; composed, a bit cool",
    "Aquarius": "detached and future-minded — friends, groups, ideas over intimacy",
    "Pisces": "porous and dreamy — absorbs every room's mood; your natal Moon sign, so this is your lunar return stretch",
}
NATAL_SKIP = {"IC"}


def _moon(jd: float) -> tuple[float, float]:
    return T.lon_speed(jd, "Moon")


def _elong(jd: float) -> float:
    return (T.lon_speed(jd, "Moon")[0] - T.lon_speed(jd, "Sun")[0]) % 360


def phase_at(jd: float) -> str:
    """The phase that BEGAN at the latest 45° crossing — the same convention as phase_moments
    (review A2/B3: a centred ±22.5° naming made /moon contradict itself ~45% of the time)."""
    return PHASES[int(_elong(jd) // 45) % 8]


def next_sign_ingress(jd: float) -> float:
    lon = _moon(jd)[0]
    nxt = (int(lon // 30) + 1) * 30 % 360
    xs = T.find_crossings(lambda j: T.signed_diff(_moon(j)[0], nxt), jd, jd + 3.5, step=0.25)
    return xs[0]


def prev_sign_ingress(jd: float) -> float:
    lon = _moon(jd)[0]
    cur = int(lon // 30) * 30
    xs = T.find_crossings(lambda j: T.signed_diff(_moon(j)[0], cur), jd - 3.5, jd + 1e-6, step=0.25)
    return xs[-1]


def phase_moments(jd0: float, jd1: float) -> list[tuple[float, str]]:
    """Instants the Sun–Moon elongation crosses a multiple of 45° (the start of each named phase —
    new/full/quarters exact; crescent/gibbous/disseminating/balsamic by the 45° convention)."""
    out = []
    for k in range(8):
        tgt = k * 45.0
        for x in T.find_crossings(lambda j: T.signed_diff(_elong(j), tgt), jd0, jd1, step=0.25):
            out.append((x, PHASES[k]))
    return sorted(out)


def _hm(jd: float, today=None) -> str:
    return E.when_label({"exact_at_local": T.jd_to_local(jd).isoformat()}, today)


def _natal_in_sign(sign_idx: int) -> list[tuple[str, dict]]:
    n = T.natal()
    return [(k, v) for k, v in n.items() if k not in NATAL_SKIP and int(v["lon"] // 30) == sign_idx]


def _houses_in_sign(sign_idx: int) -> list[tuple[int, float]]:
    """(house, starting longitude) segments the sign covers in Mike's Placidus chart."""
    lo = sign_idx * 30.0
    segs = [(T.house_of(lo + 0.0001), lo)]
    for i, c in enumerate(T.CUSPS):
        if lo < c < lo + 30:
            segs.append((i + 1, c))
    return sorted(segs, key=lambda s: s[1])


def _stay_aspects(jd0: float, jd1: float) -> list[dict]:
    """Every major Moon→natal aspect perfecting during the stay (the canonical root finder)."""
    out = []
    for n, v in T.natal().items():
        if n in NATAL_SKIP or n == "DSC":
            continue
        for a, deg in E.ASPECT_DEG.items():
            for pt in E.target_points(v["lon"], a):
                for x in T.find_crossings(lambda j, p=pt: T.signed_diff(_moon(j)[0], p), jd0, jd1, step=0.1):
                    out.append({"jd": x, "target": n, "aspect": a})
    rank = {"Sun": 0, "Moon": 0, "ASC": 0, "MC": 0, "Venus": 1, "Mars": 1, "Mercury": 1, "Saturn": 2, "Jupiter": 2}
    out.sort(key=lambda h: h["jd"])
    for h in out:
        h["rank"] = rank.get(h["target"], 3) + (0 if h["aspect"] in ("conjunct", "opposite", "square") else 1)
    return out


def sign_post(jd: float | None = None, sign: str | None = None) -> str:
    """The post for one Moon-in-sign stay (the current one, or the next stay in `sign`)."""
    jd = jd or T.jd_for(T.now_local())
    if sign:
        idx = T.SIGNS.index(sign.capitalize())
        j = jd
        while int(_moon(j)[0] // 30) != idx:
            j = next_sign_ingress(j) + 1e-4
        jd = j
    start, end = prev_sign_ingress(jd), next_sign_ingress(jd)
    idx = int(_moon(jd)[0] // 30)
    s = T.SIGNS[idx]
    today = T.today_local()
    ruler = T.RULER[s]
    rv = T.natal()[ruler]
    lines = [f"{SIGN_ICON[s]} MOON IN {s.upper()} — {_hm(start, today)} → {_hm(end, today)} ET",
             f"Mood: {MOON_STYLE[s]}.",
             f"✧ Esoterically: {lex._first_sentence(lex.kb_get('signs', s, 'esoteric') or lex.SIGNS[s]['eso'], 240)}",
             f"The Moon rules your chart (Cancer rising), so this sets the tone of your whole ~2.5 days."]
    segs = _houses_in_sign(idx)
    hl = []
    for h, lon in segs:
        seg_start = start if lon == idx * 30.0 else next(
            iter(T.find_crossings(lambda j, c=lon: T.signed_diff(_moon(j)[0], c), start, end, step=0.1)), None)
        tr = lex.combo_translation(f"Transiting Moon through the {T.ordinal(h)} house")
        what = tr.split(": ", 1)[-1].split(" (Esoteric:")[0] if tr else lex.HOUSES[h - 1]["is"]
        what = what.replace("For about two and a half days, ", "").replace(" for a day or two", "")
        what = what[:1].upper() + what[1:]
        hl.append(f"🏠 {T.ordinal(h)} house" + (f" from {_hm(seg_start, today)}" if seg_start and seg_start > start + 0.01 else "")
                  + f": {what} ✧ {lex._first_sentence(lex.kb_get('houses', str(h), 'esoteric'), 150)}")
    lines += hl
    lines.append(f"♛ The ruler of {s}, {ruler}, sits in your natal {rv['sign']} {T.ordinal(rv['house'])} house "
                 f"({rv['dms']}) — the mood routes through that part of your life.")
    placed = _natal_in_sign(idx)
    if placed:
        lines.append("📍 Your placements in " + s + ": " + ", ".join(f"{k} {v['dms']}" for k, v in placed))
    asp = _stay_aspects(start, end)
    if asp:
        lines.append("⏱ What it touches on the way through (exact ET; ✓ = already passed, → = still ahead):")
        now_jd = T.jd_for(T.now_local())
        for h in sorted(sorted(asp, key=lambda h: (h["rank"], h["jd"]))[:7], key=lambda h: h["jd"]):
            meaning = {"conjunct": "switches on", "opposite": "pulls against", "square": "pokes",
                       "trine": "eases", "sextile": "opens a door for"}[h["aspect"]]
            lines.append(f"  {'✓' if h['jd'] < now_jd else '→'} {_hm(h['jd'], today)}: Moon {h['aspect']} your natal {h['target']} — "
                         f"{meaning} {lex.PLANETS[h['target']]['is'] if h['target'] in lex.PLANETS else 'that angle'}")
    if s == "Pisces":
        lines.append("↺ Lunar return this stay (Moon back to your natal 1°16′ Pisces) — a monthly emotional reset.")
    return "\n".join(lines)


def phase_post(jd: float | None = None) -> str:
    jd = jd or T.jd_for(T.now_local())
    ph = phase_at(jd)
    moments = phase_moments(jd - 4, jd + 8)
    start = max((m for m in moments if m[0] <= jd + 1e-6), default=(jd, ph))[0]
    nxt = next((m for m in moments if m[0] > jd + 1e-6), None)
    lon = _moon(start)[0]
    today = T.today_local()
    ent = lex.kb_entry(f"Moon phase {ph}") or {}
    eso = lex.KB.get("lunation_phases", {}).get(ph.replace(" ", "_"), {})
    lines = [f"{PHASE_ICON[ph]} {ph.upper()} MOON — began {_hm(start, today)} ET at {T.dms(lon)}, your {T.ordinal(T.house_of(lon))} house"
             + (f" · next: {nxt[1]} {_hm(nxt[0], today)}" if nxt else "")]
    if eso.get("traditional") or ent.get("traditional"):
        lines.append(eso.get("traditional") or ent["traditional"])
    if eso.get("esoteric"):
        lines.append("✧ Esoterically: " + eso["esoteric"])
    if ent.get("translation"):
        lines.append("For you: " + ent["translation"])
    if ent.get("do"):
        lines.append("Mind: " + ent["do"])
    if ent.get("avoid"):
        lines.append("Avoid: " + ent["avoid"])
    hits = []
    for n, v in T.natal().items():
        if n in NATAL_SKIP or n == "DSC":       # review A4: the DSC hit is the ASC hit again
            continue
        for a, deg in E.ASPECT_DEG.items():
            orb = abs(T.angle(lon, v["lon"]) - deg)
            if orb <= (3 if a in ("conjunct", "opposite") else 2):
                hits.append(f"{E.GLYPH[a]} {a} your natal {n} ({orb:.1f}°)")
    if hits:
        lines.append("📍 At the phase moment the Moon is " + "; ".join(hits[:4]) + ".")
    return "\n".join(lines)


def now_post() -> str:
    return sign_post() + "\n\n" + phase_post()


def guide() -> str:
    """Reference: every Moon sign and phase, read against Mike's chart (static facts: houses the
    sign covers, placements in it, its ruler's natal house)."""
    out = ["🌙 YOUR MOON GUIDE — every sign and phase in your chart (tropical, Placidus)",
           "The Moon is your chart ruler (Cancer rising): its sign sets your baseline mood every ~2.5 days.", ""]
    for i, s in enumerate(T.SIGNS):
        rv = T.natal()[T.RULER[s]]
        houses = " → ".join(T.ordinal(h) for h, _ in _houses_in_sign(i))
        placed = _natal_in_sign(i)
        out.append(f"{SIGN_ICON[s]} {s}: your {houses} house · {MOON_STYLE[s]}. Ruler {T.RULER[s]} in your "
                   f"{T.ordinal(rv['house'])}." + (f" Lights up your {', '.join(k for k, _ in placed)}." if placed else "")
                   + f"\n   ✧ {lex._first_sentence(lex.kb_get('signs', s, 'esoteric') or lex.SIGNS[s]['eso'], 200)}")
    out.append("")
    for ph in PHASES:
        ent = lex.kb_entry(f"Moon phase {ph}") or {}
        eso = lex.KB.get("lunation_phases", {}).get(ph.replace(" ", "_"), {})
        out.append(f"{PHASE_ICON[ph]} {ph.title()}: {ent.get('translation') or ent.get('traditional', '')}"
                   + (f" {ent['do']}" if ent.get("do") else "")
                   + (f"\n   ✧ {eso['esoteric']}" if eso.get("esoteric") else ""))
    out.append("\nLive: /moon · posts arrive when the Moon changes sign or phase (8 AM–10 PM ET).")
    return "\n".join(out)


def due(start: datetime, end: datetime) -> list[tuple[str, str]]:
    """(uid, post) for every sign ingress / phase change in [start, end) — used by astro_alerts."""
    j0, j1 = T.jd_for(start), T.jd_for(end)
    out = []
    j = prev_sign_ingress(j0) if False else j0
    while True:
        x = next_sign_ingress(j)
        if x >= j1:
            break
        if x >= j0:
            out.append((f"moon-sign:{T.round_minute(T.jd_to_local(x)).isoformat()}", sign_post(x + 1e-3)))
        j = x + 1e-3
    for x, ph in phase_moments(j0, j1):
        out.append((f"moon-phase:{ph}:{T.round_minute(T.jd_to_local(x)).isoformat()}", phase_post(x + 1e-4)))
    return out


if __name__ == "__main__":
    a = sys.argv[1:]
    if len(a) > 1 and a[0] == "now" and a[1].capitalize() in T.SIGNS:    # Telegram "/moon Scorpio"
        a = ["sign", a[1]]
    cmd = a[0] if a else "now"
    if cmd == "now":
        print(now_post())
    elif cmd == "sign":
        print(sign_post(sign=a[1] if len(a) > 1 else None))
    elif cmd == "phase":
        print(phase_post())
    elif cmd == "guide":
        print(guide())
    elif cmd == "due":
        now = T.now_local()
        for uid, txt in due(now, now + timedelta(hours=float(a[1]) if len(a) > 1 else 24)):
            print(uid); print(txt); print()
    else:
        print(__doc__)
