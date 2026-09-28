#!/usr/bin/env python3
"""astro_truth.py — the ONE source of truth for Mike's chart. Everything the astrology bot
says must reduce to what this module computes.

Birth: 1992-11-03 22:46 EST (= 1992-11-04 03:46 UT), Dunedin FL 28.0197N 82.7715W.
Houses: PLACIDUS (Svehla's system; matches the natal readings).
Bodies: 10 planets + Chiron, Ceres, Juno (se1 files) + Hades, Apollon (Uranian, Moshier).
Progressions: secondary, day-for-a-year from the natal JD (365.25-day key), sampled at the real
  target instant — a civil date means LOCAL NOON on that date (never a UT-hour-of-birth sample,
  which is the evening BEFORE in ET and put progressed ingresses one day late; fixed 2026-09-27).
Time policy: every human-facing date/time is derived from the actual instant localized with
  zoneinfo America/New_York (DST from the tz database — never a fixed UTC-4/-5 or "hour=28").
Crossings: find_crossings() is the ONE root finder (step scan + bisection to ~1 minute).

  astro_truth.py            → JSON: natal, transits now, progressed now, aspects now
  astro_truth.py 2027-04-17 → same for that date (12:00 ET)
"""
from __future__ import annotations

import json
import sys
from datetime import date, datetime, time as dtime, timedelta, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

import swisseph as swe

swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))
TZ_NAME = "America/New_York"
ET = ZoneInfo(TZ_NAME)
UTC = timezone.utc
NATAL_JD = swe.julday(1992, 11, 4, 3 + 46 / 60)
LAT, LON = 28.0197, -82.7715
SIGNS = ["Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
         "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"]
BODIES = {"Sun": swe.SUN, "Moon": swe.MOON, "Mercury": swe.MERCURY, "Venus": swe.VENUS,
          "Mars": swe.MARS, "Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS,
          "Neptune": swe.NEPTUNE, "Pluto": swe.PLUTO, "Chiron": swe.CHIRON, "Ceres": swe.CERES,
          "Juno": swe.JUNO, "Hades": swe.HADES, "Apollon": swe.APOLLON}
PROG_BODIES = ["Moon", "Sun", "Mercury", "Venus", "Mars", "Juno"]
PROG_YEAR = 365.25            # day-for-a-year key (Svehla's; 365.2422 differs by ~0.01° of pMoon)
ASPECTS = {"conjunct": 0, "sextile": 60, "square": 90, "trine": 120, "opposite": 180}
ORB = {"Sun": 1.2, "Moon": 2.5, "Mercury": 1.0, "Venus": 1.0, "Mars": 1.0, "Jupiter": 0.8,
       "Saturn": 0.7, "Uranus": 0.6, "Neptune": 0.6, "Pluto": 0.6, "Chiron": 0.7, "Ceres": 0.6, "Juno": 0.8}
CUSPS = list(swe.houses(NATAL_JD, LAT, LON, b"P")[0])
ANGLES = {"ASC": CUSPS[0], "MC": CUSPS[9], "DSC": (CUSPS[0] + 180) % 360, "IC": (CUSPS[9] + 180) % 360}
# traditional rulers — the chart ruler is RULER[sign of the ASC] (Cancer rising → Moon)
RULER = {"Aries": "Mars", "Taurus": "Venus", "Gemini": "Mercury", "Cancer": "Moon", "Leo": "Sun",
         "Virgo": "Mercury", "Libra": "Venus", "Scorpio": "Mars", "Sagittarius": "Jupiter",
         "Capricorn": "Saturn", "Aquarius": "Saturn", "Pisces": "Jupiter"}
CHART_RULER = RULER[SIGNS[int(ANGLES["ASC"] // 30)]]


def ordinal(n: int) -> str:
    return f"{n}{'th' if 10 <= n % 100 <= 20 else {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th')}"


def house_of(lon: float, cusps: list[float] | None = None) -> int:
    cusps = CUSPS if cusps is None else cusps
    lon %= 360
    for i in range(12):
        a, b = cusps[i], cusps[(i + 1) % 12]
        if (a <= lon < b) if a < b else (lon >= a or lon < b):
            return i + 1
    return 12


def describe(lon: float, speed: float = 0.0, cusps: list[float] | None = None, houses: bool = True) -> dict:
    """houses=False (unknown birth time) → house None: never invent a house."""
    lon %= 360
    return {"lon": round(lon, 4), "sign": SIGNS[int(lon // 30)], "deg": int(lon % 30),
            "deg_f": round(lon % 30, 2), "dms": dms(lon), "house": house_of(lon, cusps) if houses else None,
            "rx": speed < 0, "speed": round(speed, 5)}


def dms(lon: float) -> str:
    """12°34′ Scorpio — minutes of arc, never a truncated degree next to a boundary."""
    lon %= 360
    m = int(round((lon % 30) * 60))
    d, m = divmod(m, 60)
    sign = SIGNS[int(lon // 30)]
    if d == 30:                                  # 29°59.99′ rounds up → next sign 0°00′
        d, sign = 0, SIGNS[(int(lon // 30) + 1) % 12]
    return f"{d}°{m:02d}′ {sign}"


# ── time: instants ↔ JD ↔ local civil time (zoneinfo, DST-correct year-round) ──
def jd_for(when: datetime) -> float:
    if when.tzinfo is None:
        raise ValueError("jd_for needs an aware datetime (naive local times are ambiguous)")
    u = when.astimezone(UTC)
    return swe.julday(u.year, u.month, u.day, u.hour + u.minute / 60 + (u.second + u.microsecond / 1e6) / 3600)


def jd_to_utc(jd: float) -> datetime:
    y, m, d, h = swe.revjul(jd)
    # round to the nearest second (float JD → 06:59:59.9999 must not truncate to :59)
    return (datetime(y, m, d, tzinfo=UTC) + timedelta(hours=h) + timedelta(microseconds=500000)).replace(microsecond=0)


def jd_to_local(jd: float, tz: ZoneInfo = ET) -> datetime:
    return jd_to_utc(jd).astimezone(tz)


def round_minute(dt: datetime) -> datetime:
    """Display rounding: nearest minute (never truncation — 10:36:48 shows as 10:37)."""
    return (dt + timedelta(seconds=30)).replace(second=0, microsecond=0)


def local_date(jd: float, tz: ZoneInfo = ET) -> date:
    """The human-facing calendar date of an instant — NEVER swe.revjul's UT date."""
    return jd_to_local(jd, tz).date()


def jd_local(d: date, hour: int = 0, minute: int = 0, tz: ZoneInfo = ET) -> float:
    """JD of a local wall-clock time on civil date d (tz rules decide EST vs EDT)."""
    return jd_for(datetime.combine(d, dtime(hour, minute), tzinfo=tz))


def now_local(tz: ZoneInfo = ET) -> datetime:
    return datetime.now(tz)


def today_local(tz: ZoneInfo = ET) -> date:
    return datetime.now(tz).date()


def signed_diff(lon: float, target: float) -> float:
    """lon - target folded to (-180, 180]."""
    return (lon - target + 180) % 360 - 180


def find_crossings(f, jd0: float, jd1: float, step: float = 1.0, tol: float = 5 / 86400) -> list[float]:
    """Every JD in [jd0, jd1) where the signed distance f(jd) crosses zero — the ONE root finder.
    f must be continuous except for the ±180° wrap, whose jump is ignored. Bisection to `tol` days
    (5 s, so two callers bracketing differently can never disagree on the displayed minute)."""
    out, j, prev = [], jd0, f(jd0)
    while j < jd1:
        j2 = min(j + step, jd1)
        cur = f(j2)
        if prev == 0:
            out.append(j)
        elif (prev < 0 < cur or cur < 0 < prev) and abs(cur - prev) < 90:
            lo, hi, flo = j, j2, prev
            while hi - lo > tol:
                mid = (lo + hi) / 2
                fm = f(mid)
                if (flo < 0) == (fm < 0):
                    lo, flo = mid, fm
                else:
                    hi = mid
            out.append((lo + hi) / 2)
        prev, j = cur, j2
    return out


def lon_speed(jd: float, body: str | int) -> tuple[float, float]:
    r = swe.calc_ut(jd, BODIES[body] if isinstance(body, str) else body)[0]
    return r[0] % 360, r[3]


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


# ── secondary progressions (the ONE progression calculator — synastry reuses it) ──
def progressed_jd(target_jd: float, natal_jd: float = NATAL_JD) -> float:
    """Ephemeris JD whose sky is the progressed chart for the real instant target_jd."""
    return natal_jd + (target_jd - natal_jd) / PROG_YEAR


def progressed_lon(target_jd: float, body: str, natal_jd: float = NATAL_JD) -> float:
    return swe.calc_ut(progressed_jd(target_jd, natal_jd), BODIES[body])[0][0] % 360


def progressed_at(target_jd: float, natal_jd: float = NATAL_JD, bodies: list[str] | None = None,
                  cusps: list[float] | None = None, houses: bool = True) -> dict:
    """Progressed positions for a real instant. Houses stay NATAL (Placidus) — progressed angles
    are not computed (method-dependent; see docs)."""
    pj = progressed_jd(target_jd, natal_jd)
    out = {}
    for n in (bodies or PROG_BODIES):
        r = swe.calc_ut(pj, BODIES[n] if n in BODIES else EXTRA_BODIES[n])[0]
        # progressed daily motion expressed per real day (ephemeris speed / PROG_YEAR)
        out[n] = describe(r[0], r[3], cusps, houses)
        out[n]["speed_per_real_day"] = round(r[3] / PROG_YEAR, 6)
    return out


def progressed(d: date | None = None) -> dict:
    """Mike's progressed chart for civil date d = the instant LOCAL NOON (ET) on d."""
    d = d or today_local()
    return progressed_at(jd_local(d, 12))


EXTRA_BODIES = {"Node": swe.TRUE_NODE}      # true lunar node (synastry)


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
            "progressed": progressed_at(jd_for(when)), "aspects": aspects(when)}


if __name__ == "__main__":
    w = datetime.now(ET)
    if len(sys.argv) > 1:
        w = datetime.fromisoformat(sys.argv[1]).replace(hour=12, tzinfo=ET)
    print(json.dumps(snapshot(w), indent=1))
