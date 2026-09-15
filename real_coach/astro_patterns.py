#!/usr/bin/env python3
"""astro_patterns.py — natal-to-natal aspects + chart PATTERNS (T-square, Grand Trine, Grand
Cross, Yod, Stellium, Kite, Mystic Rectangle) for Mike's chart, plus fixed-star conjunctions
and a transit-activation check for whichever patterns actually verify.

Truth source: astro_truth.py (T) — natal(), house_of, SIGNS, ordinal, angle, ASPECTS, BODIES,
NATAL_JD. Interpretive layer: astro_lexicon.py (lex) — PLANETS/SIGNS/HOUSES/ASPECTS 'is'/'eso'.

Orb rules (own to this module, distinct from astro_truth's transit orbs):
  natal_aspects(): conj/opp 8°, square/trine 7°, sextile 5° — +2° if either body is Sun/Moon.
  patterns():      majors (conj/sq/tri/opp) 8°, +2° if a luminary is involved; quincunx 3°.
  fixed_stars():   conjunction only, 1.5° orb.
  pattern_activation(): transiting body within 2° of conj/square/opposite to >=2 pattern members.

  astro_patterns.py aspects      — every natal-to-natal aspect, tightest orb first
  astro_patterns.py patterns     — T-square/Grand Trine/etc, with the astrologer's T-square claim
                                    checked against exact degrees
  astro_patterns.py activation   — today's transits (computed here via swe.calc_ut) vs the
                                    detected patterns
  astro_patterns.py stars        — fixed stars conjunct natal bodies/angles
"""
from __future__ import annotations

import json
import sys
from datetime import datetime
from pathlib import Path

import swisseph as swe

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402
import astro_lexicon as lex  # noqa: E402

swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))

# ── shared bodies/orb config ──────────────────────────────────────────────────────────────
# Sun..Pluto, Chiron, Ceres, Juno, ASC, MC — exactly the set the astrologer + Mike's readings use.
BODY_ORDER = ["Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
              "Pluto", "Chiron", "Ceres", "Juno", "ASC", "MC"]
LUMINARIES = {"Sun", "Moon"}
NATAL_ASPECT_ORB = {"conjunct": 8.0, "opposite": 8.0, "square": 7.0, "trine": 7.0, "sextile": 5.0}
MAJOR_ORB = 8.0
QUINCUNX_DEG = 150
QUINCUNX_ORB = 3.0
ELEMENT = {"Aries": "Fire", "Leo": "Fire", "Sagittarius": "Fire", "Taurus": "Earth", "Virgo": "Earth",
           "Capricorn": "Earth", "Gemini": "Air", "Libra": "Air", "Aquarius": "Air",
           "Cancer": "Water", "Scorpio": "Water", "Pisces": "Water"}


def _natal_points() -> dict:
    nat = T.natal()
    return {n: nat[n] for n in BODY_ORDER}


def _short(text: str, limit: int = 100) -> str:
    if len(text) <= limit:
        return text
    return text[:limit].rsplit(" ", 1)[0] + "..."


def _pt_str(name: str, pts: dict) -> str:
    v = pts[name]
    return f"{name} {v['deg']}°{v['sign']} ({T.ordinal(v['house'])} house)"


# ── 1. natal-to-natal aspects ─────────────────────────────────────────────────────────────
def _natal_orb_limit(aspect: str, a: str, b: str) -> float:
    base = NATAL_ASPECT_ORB[aspect]
    return base + 2.0 if (a in LUMINARIES or b in LUMINARIES) else base


def natal_aspects() -> list[dict]:
    """All natal-to-natal aspects among BODY_ORDER. 'applying' is intentionally left None —
    applying/separating is a transit-vs-natal (moving-body) concept; both ends of a natal-to-natal
    aspect are frozen at birth, so there is nothing to apply or separate from — per spec, skipped."""
    pts = _natal_points()
    hits = []
    for i in range(len(BODY_ORDER)):
        for j in range(i + 1, len(BODY_ORDER)):
            a, b = BODY_ORDER[i], BODY_ORDER[j]
            sep = T.angle(pts[a]["lon"], pts[b]["lon"])
            for aspect, deg in T.ASPECTS.items():
                orb = abs(sep - deg)
                if orb <= _natal_orb_limit(aspect, a, b):
                    hits.append({"a": a, "b": b, "aspect": aspect, "orb": round(orb, 2), "applying": None})
    hits.sort(key=lambda h: h["orb"])
    return hits


def natal_aspects_block() -> str:
    hits = natal_aspects()
    lines = ["NATAL ASPECTS -- Sun through Pluto, Chiron, Ceres, Juno, ASC, MC", ""]
    for h in hits:
        txt = _short(lex.ASPECTS[h["aspect"]]["is"])
        lines.append(f"{h['a']} {h['aspect']} {h['b']} -- orb {h['orb']}°: {txt}")
    lines.append("")
    lines.append(f"{len(hits)} aspects in orb, tightest first.")
    return "\n".join(lines)


# ── 2. pattern detection ──────────────────────────────────────────────────────────────────
def _major_orb(a: str, b: str) -> float:
    return MAJOR_ORB + 2.0 if (a in LUMINARIES or b in LUMINARIES) else MAJOR_ORB


def _aspect_pairs(pts: dict, deg: float, orb_fn) -> list[tuple]:
    out = []
    for i in range(len(BODY_ORDER)):
        for j in range(i + 1, len(BODY_ORDER)):
            a, b = BODY_ORDER[i], BODY_ORDER[j]
            sep = T.angle(pts[a]["lon"], pts[b]["lon"])
            orb = abs(sep - deg)
            if orb <= orb_fn(a, b):
                out.append((a, b, round(orb, 2)))
    return out


def _find(pairs: list[tuple], a: str, b: str):
    for x, y, orb in pairs:
        if {x, y} == {a, b}:
            return orb
    return None


def patterns() -> dict:
    pts = _natal_points()
    opp = _aspect_pairs(pts, 180, _major_orb)
    sq = _aspect_pairs(pts, 90, _major_orb)
    tri = _aspect_pairs(pts, 120, _major_orb)
    sext = _aspect_pairs(pts, 60, _major_orb)
    quinc = _aspect_pairs(pts, QUINCUNX_DEG, lambda a, b: QUINCUNX_ORB)

    found = {"t_square": [], "grand_trine": [], "grand_cross": [], "yod": [],
             "stellium": [], "kite": [], "mystic_rectangle": []}

    # T-SQUARE: opposition (a,b) both square a third body c (apex).
    for a, b, oorb in opp:
        for c in BODY_ORDER:
            if c in (a, b):
                continue
            oa, ob = _find(sq, a, c), _find(sq, b, c)
            if oa is not None and ob is not None:
                empty_lon = (pts[c]["lon"] + 180) % 360
                found["t_square"].append({
                    "base": [a, b], "base_orb": oorb, "apex": c, "apex_orbs": {a: oa, b: ob},
                    "empty_leg": {"lon": round(empty_lon, 2), "sign": T.SIGNS[int(empty_lon // 30)],
                                  "house": T.house_of(empty_lon)},
                })

    # GRAND TRINE: three mutual trines.
    for i in range(len(BODY_ORDER)):
        for j in range(i + 1, len(BODY_ORDER)):
            a, b = BODY_ORDER[i], BODY_ORDER[j]
            ab = _find(tri, a, b)
            if ab is None:
                continue
            for k in range(j + 1, len(BODY_ORDER)):
                c = BODY_ORDER[k]
                ac, bc = _find(tri, a, c), _find(tri, b, c)
                if ac is not None and bc is not None:
                    elems = {ELEMENT[pts[x]["sign"]] for x in (a, b, c)}
                    element = elems.pop() if len(elems) == 1 else "/".join(sorted(elems))
                    found["grand_trine"].append({"members": [a, b, c],
                                                  "orbs": {f"{a}-{b}": ab, f"{a}-{c}": ac, f"{b}-{c}": bc},
                                                  "element": element})

    # GRAND CROSS: two disjoint oppositions, all 4 cross-relationships square.
    for i in range(len(opp)):
        a, b, oorb1 = opp[i]
        for j in range(i + 1, len(opp)):
            c, d, oorb2 = opp[j]
            if {a, b} & {c, d}:
                continue
            sac, sad, sbc, sbd = _find(sq, a, c), _find(sq, a, d), _find(sq, b, c), _find(sq, b, d)
            if None not in (sac, sad, sbc, sbd):
                found["grand_cross"].append({"members": [a, b, c, d], "oppositions": [(a, b, oorb1), (c, d, oorb2)],
                                              "squares": {f"{a}-{c}": sac, f"{a}-{d}": sad, f"{b}-{c}": sbc, f"{b}-{d}": sbd}})

    # YOD: two bodies sextile each other, both quincunx (150°, orb 3°) a third (apex).
    for a, b, sorb in sext:
        for c in BODY_ORDER:
            if c in (a, b):
                continue
            qa, qb = _find(quinc, a, c), _find(quinc, b, c)
            if qa is not None and qb is not None:
                found["yod"].append({"sextile": [a, b], "sextile_orb": sorb, "apex": c,
                                      "quincunx_orbs": {a: qa, b: qb}})

    # STELLIUM: 3+ bodies sharing a sign OR a Placidus house.
    from collections import defaultdict
    by_sign, by_house = defaultdict(list), defaultdict(list)
    for n in BODY_ORDER:
        by_sign[pts[n]["sign"]].append(n)
        by_house[pts[n]["house"]].append(n)
    for sign, members in by_sign.items():
        if len(members) >= 3:
            found["stellium"].append({"kind": "sign", "where": sign, "members": members})
    for house, members in by_house.items():
        if len(members) >= 3:
            found["stellium"].append({"kind": "house", "where": house, "members": members})

    # KITE: a Grand Trine plus a 4th body opposite one member and sextile the other two.
    for gt in found["grand_trine"]:
        a, b, c = gt["members"]
        for apex_pt, others in ((a, (b, c)), (b, (a, c)), (c, (a, b))):
            for d in BODY_ORDER:
                if d in (a, b, c):
                    continue
                od = _find(opp, apex_pt, d)
                if od is None:
                    continue
                s1, s2 = _find(sext, d, others[0]), _find(sext, d, others[1])
                if s1 is not None and s2 is not None:
                    found["kite"].append({"grand_trine": [a, b, c], "opposite_point": apex_pt, "kite_tail": d,
                                           "opp_orb": od, "sextile_orbs": {others[0]: s1, others[1]: s2}})

    # MYSTIC RECTANGLE: 2 disjoint oppositions whose 4 cross-relationships alternate trine/sextile.
    seen = set()
    for i in range(len(opp)):
        a, b, oorb1 = opp[i]
        for j in range(i + 1, len(opp)):
            c, d, oorb2 = opp[j]
            if {a, b} & {c, d}:
                continue
            combos = [(_find(tri, a, c), _find(tri, b, d), _find(sext, a, d), _find(sext, b, c)),
                      (_find(sext, a, c), _find(sext, b, d), _find(tri, a, d), _find(tri, b, c))]
            for t1, t2, s1, s2 in combos:
                if None not in (t1, t2, s1, s2):
                    key = frozenset((a, b, c, d))
                    if key in seen:
                        continue
                    seen.add(key)
                    found["mystic_rectangle"].append({"members": [a, b, c, d],
                                                        "oppositions": [(a, b, oorb1), (c, d, oorb2)]})
                    break

    return found


def _astrologer_claim_check(pts: dict) -> list[str]:
    return claim_check_block().split("\n")


def claim_check_block() -> str:
    """Svehla's t-square, stated precisely. He wrote: TRANSITING Saturn (Aries) squares natal Mars
    (Cancer), 'creating a double t-square with natal Uranus and Neptune also at the base'. Natally
    the apex of that same Mars–Uranus/Neptune opposition is the Aries MIDHEAVEN; transiting Saturn
    crossing the MC (exact Apr 16-17 2027) becomes the moving apex. Natal Saturn (Aquarius) is NOT
    square natal Mars — its exact square is to the Sun (0.14°)."""
    nat = T.natal()
    def orb(a, b, asp):
        return abs(T.angle(nat[a]["lon"], nat[b]["lon"]) - asp)
    lines = ["SVEHLA'S T-SQUARE, VERIFIED BY DEGREE", ""]
    lines.append(f"Base: natal Mars {nat['Mars']['deg']}° Cancer (12th) opposite Neptune {nat['Neptune']['deg']}° Capricorn (6th), orb {orb('Mars','Neptune',180):.1f}°; "
                 f"Uranus {nat['Uranus']['deg']}° Capricorn rides with Neptune (conj {orb('Uranus','Neptune',0):.1f}°) so Mars faces the whole Capricorn pair.")
    lines.append(f"Natal apex: your MC {nat['MC']['deg']}° Aries — square Mars {orb('MC','Mars',90):.1f}°, square Neptune {orb('MC','Neptune',90):.1f}°, square Uranus {orb('MC','Uranus',90):.1f}°.")
    lines.append("Transiting apex: Saturn in Aries is walking up to that MC (exact Apr 16-17 2027) and will square natal Mars exactly when it reaches 24° Aries — that is the 'Square of Hercules' he named. Natal Saturn itself is not square Mars; its exact square is to your Sun (0.14°), the tightest aspect in the chart.")
    lines.append("Translation: your career point sits where your drive (Mars) and your idealism/rewiring (Neptune/Uranus) pull against each other. Saturn arriving there through 2027 turns the pull into a build — discipline in the career is the release valve.")
    return "\n".join(lines)


def patterns_block() -> str:
    pts = _natal_points()
    found = patterns()
    lines = ["NATAL PATTERNS", ""]

    lines += _astrologer_claim_check(pts)
    lines.append("")

    # T-SQUARE
    lines.append("T-SQUARE")
    if found["t_square"]:
        for ts in found["t_square"]:
            a, b, apex = ts["base"][0], ts["base"][1], ts["apex"]
            el = ts["empty_leg"]
            lines.append(f"Base (opposition): {_pt_str(a, pts)} opposite {_pt_str(b, pts)} -- orb {ts['base_orb']}°")
            lines.append(f"Apex (focal point): {_pt_str(apex, pts)} -- square {a} (orb {ts['apex_orbs'][a]}°), "
                         f"square {b} (orb {ts['apex_orbs'][b]}°)")
            lines.append(f"Empty leg: {el['sign']} {T.ordinal(el['house'])} house -- no natal body sits there; "
                         "a transit crossing this point would complete a Grand Cross.")
            sq_txt, opp_txt = lex.ASPECTS["square"]["is"], lex.ASPECTS["opposite"]["is"]
            lines.append(f"What it means: {opp_txt} between {a} and {b}, and {apex}'s {sq_txt.lower()} to both ends.")
            lines.append(f"Translation: {apex} ({lex.PLANETS[apex]['is']}) is the release valve for the "
                         f"{a}-{b} tug-of-war -- whenever {a} and {b} pull against each other, {apex} is the one "
                         "that actually has to DO something about it. There's no comfortable third option here.")
    else:
        lines.append("None found within orb (8° squares/oppositions, +2° if a luminary is involved).")
    lines.append("")

    # GRAND TRINE
    lines.append("GRAND TRINE")
    if found["grand_trine"]:
        for gt in found["grand_trine"]:
            a, b, c = gt["members"]
            lines.append(f"{_pt_str(a, pts)} -- {_pt_str(b, pts)} -- {_pt_str(c, pts)} -- {gt['element']} Grand Trine")
            lines.append("Orbs: " + ", ".join(f"{k} {v}°" for k, v in gt["orbs"].items()))
            tri_txt = lex.ASPECTS["trine"]["is"]
            lines.append(f"What it means: {tri_txt} All three legs support each other on tap, no effort needed.")
            lines.append(f"Translation: {lex.PLANETS[a]['is']}, {lex.PLANETS[b]['is']}, and {lex.PLANETS[c]['is']} "
                         f"all talk to each other easily in {gt['element'].lower()}. The risk of a Grand Trine is "
                         "exactly that ease -- it's a closed loop that can just sit there unused unless something "
                         "(a square, a transit) forces you to actually spend the gift.")
    else:
        lines.append("None found within orb (8° trines, +2° if a luminary is involved).")
    lines.append("")

    # GRAND CROSS
    lines.append("GRAND CROSS")
    if found["grand_cross"]:
        for gc in found["grand_cross"]:
            a, b, c, d = gc["members"]
            lines.append(f"{a}-{b} opposite / {c}-{d} opposite, cross-squared -- {_pt_str(a, pts)}, {_pt_str(b, pts)}, "
                         f"{_pt_str(c, pts)}, {_pt_str(d, pts)}")
            lines.append("Squares: " + ", ".join(f"{k} {v}°" for k, v in gc["squares"].items()))
            lines.append("What it means: four-way pressure, no empty leg to breathe through -- every point is "
                         "someone else's friction. Translation: this is the hardest, most productive pattern in "
                         "astrology -- constant tension in exchange for real, forced growth on all four fronts.")
    else:
        lines.append("None found (would need two independent oppositions that also cross-square -- rare, "
                     "and not present in this chart within orb).")
    lines.append("")

    # YOD
    lines.append("YOD (Finger of Fate)")
    if found["yod"]:
        for y in found["yod"]:
            a, b, apex = y["sextile"][0], y["sextile"][1], y["apex"]
            lines.append(f"{_pt_str(a, pts)} sextile {_pt_str(b, pts)} (orb {y['sextile_orb']}°), both quincunx "
                         f"{_pt_str(apex, pts)} (orbs {y['quincunx_orbs'][a]}° / {y['quincunx_orbs'][b]}°)")
            lines.append(f"Translation: {apex} ({lex.PLANETS[apex]['is']}) is a specialized, oddly-shaped skill that "
                         f"{a} and {b} feed with no natural outlet elsewhere -- it only pays off if you consciously "
                         "build the channel for it.")
    else:
        lines.append("None found within orb (60° sextile within major-orb rules, 150° quincunx within 3°). "
                     "Closest near-miss: Saturn quincunx Juno is essentially exact, but no third body sextiles "
                     "both of them within orb, so it never completes into a Yod.")
    lines.append("")

    # STELLIUM
    lines.append("STELLIUM")
    if found["stellium"]:
        for st in found["stellium"]:
            where_txt = f"{st['where']} sign" if st["kind"] == "sign" else f"{T.ordinal(st['where'])} house"
            lines.append(f"{where_txt}: " + ", ".join(_pt_str(m, pts) for m in st["members"]))
            if st["kind"] == "sign":
                s = lex.SIGNS.get(st["where"])
                if s:
                    lines.append(f"What it means: {s['is']}. Translation: this much weight in one sign makes "
                                 f"{st['where']} a dominant flavor in the whole chart, not just one placement's story.")
            else:
                lines.append("Translation: this much weight in one house makes that life area load-bearing -- "
                             "several different energies are all being spent on the same stage.")
    else:
        lines.append("None found (need 3+ of the 15 tracked points sharing a sign or a Placidus house).")
    lines.append("")

    # KITE
    lines.append("KITE")
    if found["kite"]:
        for k in found["kite"]:
            a, b, c = k["grand_trine"]
            lines.append(f"Grand Trine {a}-{b}-{c} + {k['kite_tail']} opposite {k['opposite_point']} "
                         f"(orb {k['opp_orb']}°), sextile the other two.")
            lines.append(f"Translation: {k['kite_tail']} gives the Grand Trine's easy loop a direction and an "
                         "outlet -- the one part of this pattern that actually has to push against something.")
    else:
        lines.append("None found (needs a Grand Trine plus a 4th body opposite one member and sextile the other "
                     "two -- no Grand Trine survives orb here to build one from)." if not found["grand_trine"]
                     else "Grand Trine present but no 4th body completes it into a Kite within orb.")
    lines.append("")

    # MYSTIC RECTANGLE
    lines.append("MYSTIC RECTANGLE")
    if found["mystic_rectangle"]:
        for mr in found["mystic_rectangle"]:
            a, b, c, d = mr["members"]
            lines.append(f"{a}-{b} opposite (orb {mr['oppositions'][0][2]}°), {c}-{d} opposite "
                         f"(orb {mr['oppositions'][1][2]}°), cross-linked by trine/sextile.")
            lines.append("Translation: two life tensions that quietly support each other through an easier "
                         "side-channel -- less raw pressure than a Grand Cross, but the balance takes real "
                         "maintenance to hold steady.")
    else:
        lines.append("None found (needs two disjoint oppositions whose 4 cross-relationships alternate "
                     "trine/sextile -- not present in this chart within orb).")

    return "\n".join(lines)


# ── 3. transit activation ─────────────────────────────────────────────────────────────────
ACTIVATION_ORB = 2.0
ACTIVATION_ASPECTS = {"conjunct": 0, "square": 90, "opposite": 180}


def _flatten_patterns(found: dict) -> list[dict]:
    out = []
    for ts in found["t_square"]:
        a, b, apex = ts["base"][0], ts["base"][1], ts["apex"]
        out.append({"type": "T-square", "members": [a, b, apex], "oppositions": [(a, b)], "apex": apex,
                    "label": f"{a}-{b}/{apex} T-square"})
    for gt in found["grand_trine"]:
        m = gt["members"]
        out.append({"type": "Grand Trine", "members": m, "oppositions": [],
                    "label": f"{'-'.join(m)} Grand Trine ({gt['element']})"})
    for gc in found["grand_cross"]:
        m = gc["members"]
        out.append({"type": "Grand Cross", "members": m,
                    "oppositions": [(gc["oppositions"][0][0], gc["oppositions"][0][1]),
                                    (gc["oppositions"][1][0], gc["oppositions"][1][1])],
                    "label": f"{'-'.join(m)} Grand Cross"})
    for y in found["yod"]:
        m = y["sextile"] + [y["apex"]]
        out.append({"type": "Yod", "members": m, "oppositions": [], "apex": y["apex"],
                    "label": f"{y['sextile'][0]}-{y['sextile'][1]}/{y['apex']} Yod"})
    for st in found["stellium"]:
        out.append({"type": "Stellium", "members": st["members"], "oppositions": [],
                    "label": f"{st['where']} stellium"})
    for k in found["kite"]:
        m = k["grand_trine"] + [k["kite_tail"]]
        out.append({"type": "Kite", "members": m, "oppositions": [(k["opposite_point"], k["kite_tail"])],
                    "label": f"{'-'.join(k['grand_trine'])} Kite"})
    for mr in found["mystic_rectangle"]:
        m = mr["members"]
        out.append({"type": "Mystic Rectangle", "members": m,
                    "oppositions": [(mr["oppositions"][0][0], mr["oppositions"][0][1]),
                                    (mr["oppositions"][1][0], mr["oppositions"][1][1])],
                    "label": f"{'-'.join(m)} Mystic Rectangle"})
    return out


def pattern_activation(transits: dict) -> list[str]:
    """transits: {name -> longitude}. Returns one Telegram-plain line per pattern a transiting
    body is actively lighting up (within 2 deg of conjunct/square/opposite to >=2 members)."""
    pts = _natal_points()
    infos = _flatten_patterns(patterns())
    lines = []
    for tname, tlon in transits.items():
        for info in infos:
            hits = {}
            for m in info["members"]:
                if m not in pts:
                    continue
                for aname, adeg in ACTIVATION_ASPECTS.items():
                    orb = abs(T.angle(tlon, pts[m]["lon"]) - adeg)
                    if orb <= ACTIVATION_ORB:
                        hits[m] = (aname, round(orb, 2))
                        break
            if len(hits) < 2:
                continue
            both_ends = next(((a, b) for a, b in info["oppositions"] if a in hits and b in hits), None)
            if both_ends and info["type"] == "T-square":
                a, b = both_ends
                apex = info.get("apex")
                extra = f", squaring the apex {apex} too" if apex in hits else ""
                lines.append(f"Transiting {tname} is lighting your {a}-{b} opposition from both ends{extra} "
                             f"({info['label']}).")
            elif both_ends:
                a, b = both_ends
                lines.append(f"Transiting {tname} is hitting both ends of the {a}-{b} axis in your {info['label']}.")
            else:
                detail = "; ".join(f"{m} {asp} (orb {orb}°)" for m, (asp, orb) in hits.items())
                lines.append(f"Transiting {tname} is activating your {info['label']} -- {detail}.")
    return lines


def today_transits() -> dict:
    """Computes today's transiting longitudes itself (swe.calc_ut), per spec -- doesn't reuse
    astro_truth.transits() so this module can run its own activation check standalone."""
    now = datetime.now(T.ET)
    jd = T.jd_for(now)
    out = {}
    for name, code in T.BODIES.items():
        if name in ("Hades", "Apollon"):
            continue
        out[name] = swe.calc_ut(jd, code)[0][0]
    return out


# ── 4. fixed stars ────────────────────────────────────────────────────────────────────────
STAR_LIST = ["Acrux", "Alcyone", "Algol", "Aldebaran", "Antares", "Regulus", "Spica", "Arcturus", "Sirius",
             "Fomalhaut", "Vega", "Altair", "Deneb Adige", "Capella", "Rigel", "Betelgeuse", "Pollux", "Castor",
             "Procyon", "Canopus", "Achernar", "Alphard", "Denebola", "Zosma", "Vindemiatrix", "Alphecca",
             "Zuben Elgenubi", "Zuben Eschamali", "Ras Alhague", "Rasalgethi", "Facies", "Nunki", "Deneb Algedi",
             "Sadalmelik", "Scheat", "Markab", "Algenib", "Mirach", "Hamal", "Menkar", "Alnilam", "Bellatrix",
             "Agena", "Toliman", "Rukbat", "Alhena", "Zavijava"]
FIXED_STAR_ORB = 1.5

# Built-in Robson-style meanings (paraphrased), used only when astro_esoteric_kb.json is absent
# or doesn't cover the star that actually hit.
BUILTIN_STAR_MEANINGS = {
    "Acrux": "Southern Cross's brightest star -- spiritual insight found through hardship; occult depth, but also self-sacrifice.",
    "Alcyone": "brightest of the Pleiades -- grief and loss, but protection and rebirth when the loss is honored rather than denied.",
    "Algol": "Medusa's head -- the most feared fixed star; intensity and loss of control that must be mastered consciously, not repressed.",
    "Aldebaran": "the Bull's Eye, a Royal Star (Watcher of the East) -- integrity, courage, high honors; a warning against letting pride curdle it.",
    "Antares": "the Scorpion's heart, a Royal Star (Watcher of the West) -- fearless, passionate, but prone to self-destruction if unchecked.",
    "Regulus": "the Lion's heart, a Royal Star (Watcher of the North) -- success and command, on condition you don't take revenge on the way up.",
    "Spica": "the Wheatsheaf in Virgo's hand -- one of the most fortunate stars; talent, brilliance, and grace that feels unearned.",
    "Arcturus": "the Bear-Watcher -- a pathfinder energy; prosperity through blazing a new road rather than following one.",
    "Sirius": "the Dog Star, brightest in the sky -- ambition, fame, leadership; demands honorable use of the power it grants.",
    "Fomalhaut": "the Fish's Mouth, a Royal Star (Watcher of the South) -- idealism and mystical gift, with a caution against escapism.",
    "Vega": "the Harp star -- charisma and artistic influence; a seductive, 'too good to be true' charm worth staying honest about.",
    "Altair": "the Eagle -- bold, quick success through daring; a fortunate but restless warrior/aviator energy.",
    "Deneb Adige": "the Swan's tail -- idealism and mysticism; benefit through service and self-sacrifice for a larger cause.",
    "Capella": "the Shepherd's star -- love of knowledge, restless curiosity; protection and honor earned through learning.",
    "Rigel": "Orion's foot -- success and honors, often a teaching influence; fortunate but far-traveling.",
    "Betelgeuse": "Orion's shoulder -- martial honor and sudden good fortune; luck earned through conflict, not given.",
    "Pollux": "the immortal twin -- courage and cruelty in tension; a rash, combative energy that needs tempering.",
    "Castor": "the mortal twin -- sharp wit and intellect, but an old reputation for sudden loss; a mercurial, restless mind.",
    "Procyon": "'before the dog' -- swift activity, sudden fame or reversal; impatience needs an outlet before it turns destructive.",
    "Canopus": "the great southern navigator star -- long journeys, exploration, a stabilizing high-status influence.",
    "Achernar": "end of the celestial river -- success that arrives late; protection and honor earned through persistence.",
    "Alphard": "the Serpent's heart, 'the solitary one' -- emotional intensity; a poison/healer duality needing self-control.",
    "Denebola": "the Lion's tail -- swift justice and sudden reversals of fortune; generosity that must guard against being used.",
    "Zosma": "the Lion's back -- a burdened conscience, taking on others' suffering; melancholy that can become real compassion.",
    "Vindemiatrix": "'the Grape Gatherer' -- an old 'widow-maker' star; loss followed by learning, solitude ripening into wisdom.",
    "Alphecca": "the Northern Crown -- honor and recognition of talent; artistic or romantic gifts, the 'gem of victory.'",
    "Zuben Elgenubi": "the Southern Scale of Libra -- old texts call it unbalanced; a testing of fairness, karmic debts around justice.",
    "Zuben Eschamali": "the Northern Scale of Libra -- the more fortunate scale; healing, honor, sound judgment.",
    "Ras Alhague": "the Serpent-Bearer's head, the healer's star -- fascination with medicine/poison/the occult; immunity through knowledge.",
    "Rasalgethi": "Hercules' head -- struggle and labors; hard-won strength, an ordeal that becomes mastery.",
    "Facies": "the 'veiled face' in Sagittarius -- sharp, ruthless focus; associated with military/surgical precision and eye themes.",
    "Nunki": "the Archer's bow tip -- trustworthy pursuit of truth; travel luck and an honest-broker influence.",
    "Deneb Algedi": "the Sea-Goat's tail -- mixed fortune; sacrifice now for gain later, beneficial and difficult swings together.",
    "Sadalmelik": "'the lucky one of the king' in Aquarius -- steady, well-earned fortune and high position through patience.",
    "Scheat": "Pegasus's shoulder -- an old unlucky star tied to accidents near water; caution around impulsive risk.",
    "Markab": "Pegasus's body -- protection through preparation; sturdy resourcefulness, benefits from planning ahead.",
    "Algenib": "Pegasus's wing -- a quick, sharp mind; sudden reputational shifts either way, restless energetic drive.",
    "Mirach": "Andromeda's girdle -- beauty and domestic happiness; the gift of making others feel safe and cared for.",
    "Hamal": "the Ram's head -- leadership and aggression that must be tempered; self-reliance, a healing capacity.",
    "Menkar": "the Sea-monster's jaw -- inheriting difficulty from family or ancestry; transmute the old burden rather than swallow it.",
    "Alnilam": "center star of Orion's belt -- fame that fades quickly; a brilliant moment of public visibility without lasting foundation.",
    "Bellatrix": "the 'Female Warrior' of Orion -- quick success through boldness; an outspoken, combative tongue, sharp advancement.",
    "Agena": "Centaurus's foot -- honor and refinement; high friendships, a noble, generous influence.",
    "Toliman": "Alpha Centauri, the Centaur's body -- expansive friendliness and generosity; high social standing through warmth.",
    "Rukbat": "the Archer's knee -- a quiet, supportive foundation star; steadiness underneath whatever you're aiming at.",
    "Alhena": "Gemini's foot -- artistic grace; honors through creative or diplomatic skill, refinement.",
    "Zavijava": "Virgo's wing -- a modest, lightly-documented star; gentle discernment and quiet reliability in service.",
}


def _load_kb() -> dict:
    p = Path(__file__).with_name("astro_esoteric_kb.json")
    if p.exists():
        try:
            data = json.loads(p.read_text())
            fs = data.get("fixed_stars")
            if isinstance(fs, dict):
                return fs
        except Exception:
            pass
    return {}


def _star_meaning(name: str, kb: dict) -> str:
    entry = kb.get(name)
    if isinstance(entry, dict) and entry.get("meaning"):
        return entry["meaning"]
    if isinstance(entry, str) and entry:
        return entry
    return BUILTIN_STAR_MEANINGS.get(name, "no meaning on file for this star")


def fixed_stars() -> tuple[list[dict], list[str]]:
    """Star longitude at NATAL_JD (precessed to Mike's birth moment by swe.fixstar_ut itself)
    vs every natal body/angle, conjunction within FIXED_STAR_ORB. Returns (hits, skipped_stars)."""
    nat = T.natal()
    hits, skipped = [], []
    for star in STAR_LIST:
        try:
            res = swe.fixstar_ut(star, T.NATAL_JD)
        except Exception:
            skipped.append(star)
            continue
        lon = res[0][0] % 360
        for bname, bval in nat.items():
            orb = T.angle(lon, bval["lon"])
            if orb <= FIXED_STAR_ORB:
                hits.append({"star": star, "lon": round(lon, 3), "sign": T.SIGNS[int(lon // 30)],
                            "deg": lon % 30, "body": bname, "orb": round(orb, 2)})
    hits.sort(key=lambda h: h["orb"])
    return hits, skipped


def _dm(lon: float) -> str:
    """Degree+minutes within sign, e.g. 11.86 -> '11°52' (11 deg 52 min)."""
    d = lon % 30
    deg = int(d)
    minute = int(round((d - deg) * 60))
    if minute == 60:
        minute = 0
        deg += 1
    return f"{deg}°{minute:02d}"


def fixed_stars_block() -> str:
    hits, skipped = fixed_stars()
    kb = _load_kb()
    lines = [f"FIXED STARS -- conjunct natal bodies/angles (orb <= {FIXED_STAR_ORB}°)", ""]
    if not hits:
        lines.append("No fixed-star conjunctions within orb of any natal point.")
    for h in hits:
        lines.append(f"{h['star']} {_dm(h['lon'])} {h['sign']} conjunct natal {h['body']} (orb {h['orb']}°)")
        lines.append(f"  {_star_meaning(h['star'], kb)}")
    if skipped:
        lines.append("")
        lines.append("Skipped (didn't resolve in sefstars.txt): " + ", ".join(skipped))
    return "\n".join(lines)


# ── CLI ────────────────────────────────────────────────────────────────────────────────────
def _activation_block() -> str:
    lines = pattern_activation(today_transits())
    if not lines:
        return "No transit is currently within 2° of activating a natal pattern."
    return "\n".join(["TODAY'S PATTERN ACTIVATIONS", ""] + lines)


def main() -> int:
    cmd = sys.argv[1] if len(sys.argv) > 1 else "patterns"
    fn = {"aspects": natal_aspects_block, "patterns": patterns_block,
          "activation": _activation_block, "stars": fixed_stars_block}.get(cmd)
    if not fn:
        print("usage: astro_patterns.py aspects|patterns|activation|stars")
        return 1
    print(fn())
    return 0


if __name__ == "__main__":
    sys.exit(main())
