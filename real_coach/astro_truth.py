#!/usr/bin/env python3
"""astro_truth.py — the ONE source of truth for Mike's chart. Everything the astrology bot
says must reduce to what this module computes.

Birth: 1992-11-03 22:46 EST (= 1992-11-04 03:46 UT), Dunedin FL 28.0197N 82.7715W.
Houses: PLACIDUS (Svehla's system; matches the natal readings).
Bodies: 10 planets + Chiron, Ceres, Juno (se1 files) + Hades, Apollon (Uranian, Moshier).
Progressions: secondary, day-for-a-year from the natal JD.

  astro_truth.py            → JSON: natal, transits now, progressed now, aspects now
  astro_truth.py 2027-04-17 → same for that date (12:00 ET)
"""
from __future__ import annotations

import json
import sys
from datetime import date, datetime, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

import swisseph as swe

swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))
ET = ZoneInfo("America/New_York")
NATAL_JD = swe.julday(1992, 11, 4, 3 + 46 / 60)
LAT, LON = 28.0197, -82.7715
SIGNS = ["Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
         "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"]
BODIES = {"Sun": swe.SUN, "Moon": swe.MOON, "Mercury": swe.MERCURY, "Venus": swe.VENUS,
          "Mars": swe.MARS, "Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS,
          "Neptune": swe.NEPTUNE, "Pluto": swe.PLUTO, "Chiron": swe.CHIRON, "Ceres": swe.CERES,
          "Juno": swe.JUNO, "Hades": swe.HADES, "Apollon": swe.APOLLON}
PROG_BODIES = ["Moon", "Sun", "Mercury", "Venus", "Mars", "Juno"]
ASPECTS = {"conjunct": 0, "sextile": 60, "square": 90, "trine": 120, "opposite": 180}
ORB = {"Sun": 1.2, "Moon": 2.5, "Mercury": 1.0, "Venus": 1.0, "Mars": 1.0, "Jupiter": 0.8,
       "Saturn": 0.7, "Uranus": 0.6, "Neptune": 0.6, "Pluto": 0.6, "Chiron": 0.7, "Ceres": 0.6, "Juno": 0.8}
CUSPS = list(swe.houses(NATAL_JD, LAT, LON, b"P")[0])
ANGLES = {"ASC": CUSPS[0], "MC": CUSPS[9], "DSC": (CUSPS[0] + 180) % 360, "IC": (CUSPS[9] + 180) % 360}


def ordinal(n: int) -> str:
    return f"{n}{'th' if 10 <= n % 100 <= 20 else {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th')}"


def house_of(lon: float) -> int:
    lon %= 360
    for i in range(12):
        a, b = CUSPS[i], CUSPS[(i + 1) % 12]
        if (a <= lon < b) if a < b else (lon >= a or lon < b):
            return i + 1
    return 12


def describe(lon: float, speed: float = 0.0) -> dict:
    lon %= 360
    return {"lon": round(lon, 4), "sign": SIGNS[int(lon // 30)], "deg": int(lon % 30),
            "deg_f": round(lon % 30, 2), "house": house_of(lon), "rx": speed < 0}


def jd_for(when: datetime) -> float:
    u = when.astimezone(timezone.utc)
    return swe.julday(u.year, u.month, u.day, u.hour + u.minute / 60 + u.second / 3600)


def natal() -> dict:
    out = {}
    for n, b in BODIES.items():
        r = swe.calc_ut(NATAL_JD, b)[0]
        out[n] = describe(r[0], r[3])
    for n, lon in ANGLES.items():
        out[n] = describe(lon)
    return out


def transits(when: datetime | None = None) -> dict:
    when = when or datetime.now(ET)
    jd = jd_for(when)
    out = {}
    for n, b in BODIES.items():
        if n in ("Hades", "Apollon"):
            continue
        r = swe.calc_ut(jd, b)[0]
        out[n] = describe(r[0], r[3])
    return out


def progressed(d: date | None = None) -> dict:
    d = d or datetime.now(ET).date()
    pj = NATAL_JD + (swe.julday(d.year, d.month, d.day, 3 + 46 / 60) - NATAL_JD) / 365.25
    out = {}
    for n in PROG_BODIES:
        r = swe.calc_ut(pj, BODIES[n])[0]
        out[n] = describe(r[0], r[3])
    return out


def angle(a: float, b: float) -> float:
    d = abs(a - b) % 360
    return d if d <= 180 else 360 - d


def aspects(when: datetime | None = None, orb_mult: float = 1.0) -> list[dict]:
    """Transit → natal aspects inside orb (orb_mult>1 widens, for verifying loose claims)."""
    t, n = transits(when), natal()
    hits = []
    for tn, tv in t.items():
        for nn, nv in n.items():
            if nn == "IC":
                continue
            for an, adeg in ASPECTS.items():
                orb = abs(angle(tv["lon"], nv["lon"]) - adeg)
                if orb <= ORB.get(tn, 1.0) * orb_mult:
                    hits.append({"t": tn, "n": nn, "aspect": an, "orb": round(orb, 2)})
    hits.sort(key=lambda h: (h["t"] == "Moon", h["orb"]))
    return hits


def snapshot(when: datetime | None = None) -> dict:
    when = when or datetime.now(ET)
    return {"when_et": when.astimezone(ET).isoformat(timespec="minutes"), "house_system": "Placidus",
            "cusps": [round(c, 3) for c in CUSPS], "natal": natal(), "transits": transits(when),
            "progressed": progressed(when.date()), "aspects": aspects(when)}


if __name__ == "__main__":
    w = datetime.now(ET)
    if len(sys.argv) > 1:
        w = datetime.fromisoformat(sys.argv[1]).replace(hour=12, tzinfo=ET)
    print(json.dumps(snapshot(w), indent=1))
