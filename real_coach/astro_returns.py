#!/usr/bin/env python3
"""astro_returns.py — solar returns, lunar returns, progressed lunation phase, and solar-arc
directions for Mike's chart. Builds on astro_truth.py (the one source of truth for the natal
chart + secondary progressions) and astro_lexicon.py (house/planet meanings), and follows
svehla.py's plain-text, Telegram-friendly style — no markdown.

Everything here is real astronomy (pyswisseph), Placidus houses, Dunedin FL by default,
secondary progressions = day-for-a-year from astro_truth.NATAL_JD at birth-hour.

CLI:  astro_returns.py solar [year] | lunar | phase | arc
"""
from __future__ import annotations

import sys
from datetime import date, datetime, timedelta, timezone
from pathlib import Path

import swisseph as swe

swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))

import astro_truth as T
import astro_lexicon as lex

# ── shared helpers ──────────────────────────────────────────────────────────
ASPECT_SUBSET = {"conjunct": 0, "square": 90, "opposite": 180}


def _signed_diff(a: float, b: float) -> float:
    """a - b folded to (-180, 180]."""
    return (a - b + 180) % 360 - 180


def _house_of(lon: float, cusps: list[float]) -> int:
    """1-based house of `lon` under an arbitrary set of 12 cusps (Placidus)."""
    lon %= 360
    for i in range(12):
        a, b = cusps[i], cusps[(i + 1) % 12]
        if (a <= lon < b) if a < b else (lon >= a or lon < b):
            return i + 1
    return 12


def _sign_deg(lon: float) -> str:
    lon %= 360
    return f"{int(lon % 30)}° {T.SIGNS[int(lon // 30)]}"


def _jd_of(d: date, hour_et: float = 12.0) -> float:
    """Civil date (at hour_et ET) → Julian Day (UT)."""
    from zoneinfo import ZoneInfo
    dt = datetime(d.year, d.month, d.day, tzinfo=T.ET) + timedelta(hours=hour_et)
    u = dt.astimezone(timezone.utc)
    return swe.julday(u.year, u.month, u.day, u.hour + u.minute / 60 + u.second / 3600)


def _jd_to_et(jd: float) -> datetime:
    y, m, d, _h = swe.revjul(jd)
    frac = jd - swe.julday(y, m, d, 0.0)
    dt_utc = datetime(y, m, d, tzinfo=timezone.utc) + timedelta(days=frac)
    return dt_utc.astimezone(T.ET)


def _prog_lon(d: date, body: int) -> float:
    """Secondary-progressed longitude of `body` for civil date d (day-for-a-year, birth-hour)."""
    pj = T.NATAL_JD + (swe.julday(d.year, d.month, d.day, 3 + 46 / 60) - T.NATAL_JD) / 365.25
    return swe.calc_ut(pj, body)[0][0] % 360


def _interp_line(prefix: str, name: str, house: int) -> str:
    """One tight line using astro_lexicon's own planet + house meanings."""
    p_is = lex.PLANETS[name]["is"]
    h_is = lex.HOUSES[house - 1]["is"]
    return f"{prefix} {name} in the {T.ordinal(house)}: {p_is} — focused on {h_is}."


# ═══════════════════════════════════════════════════════════════════════════
# 1. SOLAR RETURN
# ═══════════════════════════════════════════════════════════════════════════
def solar_return(year: int, lat: float = T.LAT, lon: float = T.LON) -> dict:
    """Exact moment (bisected to the second) transiting Sun == natal Sun longitude in `year`,
    then the full Placidus chart for that moment at (lat, lon)."""
    natal = T.natal()
    natal_sun = natal["Sun"]["lon"]

    def sun_lon(jd: float) -> float:
        return swe.calc_ut(jd, swe.SUN)[0][0] % 360

    def f(jd: float) -> float:
        return _signed_diff(sun_lon(jd), natal_sun)

    # Sun's tropical longitude is monotonic (no retrograde) — one crossing per year.
    # Scan from Jan 1 of `year` in 4-day steps, then bisect to the second.
    step = 4.0
    lo_jd = swe.julday(year, 1, 1, 0.0)
    prev = f(lo_jd)
    hi_jd = None
    jd = lo_jd
    for _ in range(100):  # up to 400 days of coverage
        jd2 = jd + step
        cur = f(jd2)
        if prev == 0 or ((prev < 0) != (cur < 0) and abs(cur - prev) < 90):
            lo_jd, hi_jd = jd, jd2
            break
        jd, prev = jd2, cur
    if hi_jd is None:
        raise RuntimeError(f"solar return crossing not found in {year}")
    lo, hi = lo_jd, hi_jd
    flo = f(lo)
    tol = 1 / 86400  # 1 second
    while (hi - lo) > tol:
        mid = (lo + hi) / 2
        fm = f(mid)
        if (flo < 0) == (fm < 0):
            lo, flo = mid, fm
        else:
            hi = mid
    sr_jd = (lo + hi) / 2

    cusps = list(swe.houses(sr_jd, lat, lon, b"P")[0])
    asc, mc = cusps[0], cusps[9]

    planets = {}
    for name, body in T.BODIES.items():
        r = swe.calc_ut(sr_jd, body)[0]
        plon = r[0] % 360
        planets[name] = {
            "lon": round(plon, 4), "sign": T.SIGNS[int(plon // 30)], "deg_f": round(plon % 30, 2),
            "sr_house": _house_of(plon, cusps), "natal_house": T.house_of(plon), "rx": r[3] < 0,
        }

    conjunctions = []
    for pname, pv in planets.items():
        for nname, nv in natal.items():
            d = T.angle(pv["lon"], nv["lon"])
            if d <= 2.0:
                conjunctions.append({"sr": pname, "natal": nname, "orb": round(d, 2)})
    conjunctions.sort(key=lambda h: h["orb"])

    return {
        "year": year, "jd": sr_jd, "when_et": _jd_to_et(sr_jd),
        "asc_lon": round(asc, 4), "mc_lon": round(mc, 4), "cusps": [round(c, 3) for c in cusps],
        "asc_natal_house": T.house_of(asc),
        "planets": planets,
        "sr_sun_house": planets["Sun"]["sr_house"],
        "sr_moon_sign": planets["Moon"]["sign"], "sr_moon_house": planets["Moon"]["sr_house"],
        "conjunctions": conjunctions,
        "check_sun_orb": round(T.angle(planets["Sun"]["lon"], natal_sun), 6),
    }


def solar_return_block(year: int) -> str:
    sr = solar_return(year)
    when = sr["when_et"]
    lines = [f"☀️ SOLAR RETURN {year} — exact {when:%b %-d %Y %-I:%M%p} ET, Dunedin FL chart (Placidus)", ""]
    lines.append(f"SR ASC {_sign_deg(sr['asc_lon'])} — falls in your natal {T.ordinal(sr['asc_natal_house'])} house "
                 f"({lex.HOUSES[sr['asc_natal_house'] - 1]['is']})")
    lines.append(f"SR MC {_sign_deg(sr['mc_lon'])}")
    lines.append("")
    lines.append("SR PLANETS (sign · SR house / your natal house):")
    for name in T.BODIES:
        p = sr["planets"][name]
        rx = " ℞" if p["rx"] else ""
        lines.append(f"• {name} {int(p['deg_f'])}° {p['sign']}{rx} — SR {T.ordinal(p['sr_house'])} / natal {T.ordinal(p['natal_house'])}")
    lines.append("")
    lines.append("WHAT THE YEAR EMPHASIZES:")
    try:
        for k in (f"Solar return ASC in {T.SIGNS[int(sr['asc_lon'] // 30)]}", f"Solar return Sun in the {T.ordinal(sr['sr_sun_house'])} house"):
            for ln in lex.entry_lines(k, full=True)[:4]:
                lines.append(ln)
    except Exception:
        pass
    lines.append(_interp_line("SR", "Sun", sr["sr_sun_house"]))
    lines.append(_interp_line("SR", "Moon", sr["sr_moon_house"]))
    for name in ("Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto",
                 "Chiron", "Ceres", "Juno", "Hades", "Apollon"):
        lines.append(_interp_line("SR", name, sr["planets"][name]["sr_house"]))
    lines.append(_interp_line("SR", "ASC", sr["asc_natal_house"]))
    if sr["conjunctions"]:
        lines.append("")
        lines.append("SR PLANETS CONJUNCT NATAL (within 2°):")
        for c in sr["conjunctions"]:
            lines.append(f"• SR {c['sr']} conjunct natal {c['natal']} (orb {c['orb']}°)")
    return "\n".join(lines)


# ═══════════════════════════════════════════════════════════════════════════
# 2. LUNAR RETURN
# ═══════════════════════════════════════════════════════════════════════════
def _lunar_chart(lr_jd: float, lat: float = T.LAT, lon: float = T.LON) -> dict:
    cusps = list(swe.houses(lr_jd, lat, lon, b"P")[0])
    asc, mc = cusps[0], cusps[9]
    natal = T.natal()
    moon_lon = swe.calc_ut(lr_jd, swe.MOON)[0][0] % 360

    hits = []
    for pname, pbody in T.BODIES.items():
        plon = swe.calc_ut(lr_jd, pbody)[0][0] % 360
        for nname, nv in natal.items():
            if nname == "IC":
                continue
            for aname, adeg in T.ASPECTS.items():
                orb = abs(T.angle(plon, nv["lon"]) - adeg)
                if orb <= 2.0:
                    hits.append({"lr": pname, "natal": nname, "aspect": aname, "orb": round(orb, 2)})
    hits.sort(key=lambda h: h["orb"])

    return {
        "jd": lr_jd, "when_et": _jd_to_et(lr_jd),
        "asc_lon": round(asc, 4), "mc_lon": round(mc, 4),
        "asc_natal_house": T.house_of(asc),
        "moon_lon": round(moon_lon, 4), "moon_sign": T.SIGNS[int(moon_lon // 30)],
        "moon_lr_house": _house_of(moon_lon, cusps),
        "check_moon_orb": round(T.angle(moon_lon, natal["Moon"]["lon"]), 6),
        "aspects": hits,
    }


def lunar_return(d: date | None = None) -> dict:
    """Most recent LR before `d` and the next one after, each as a full LR chart (Dunedin FL, Placidus)."""
    d = d or datetime.now(T.ET).date()
    natal_moon = T.natal()["Moon"]["lon"]

    def moon_lon(jd: float) -> float:
        return swe.calc_ut(jd, swe.MOON)[0][0] % 360

    def f(jd: float) -> float:
        return _signed_diff(moon_lon(jd), natal_moon)

    def scan(direction: int) -> float:
        step = 0.5
        anchor = _jd_of(d)
        prev_jd, prev = anchor, f(anchor)
        jd = anchor
        for _ in range(160):  # up to 80 days either way
            jd2 = jd + direction * step
            cur = f(jd2)
            if prev == 0 or ((prev < 0) != (cur < 0) and abs(cur - prev) < 90):
                lo, hi = (jd, jd2) if direction > 0 else (jd2, jd)
                flo = f(lo)
                tol = 1 / 86400
                while (hi - lo) > tol:
                    mid = (lo + hi) / 2
                    fm = f(mid)
                    if (flo < 0) == (fm < 0):
                        lo, flo = mid, fm
                    else:
                        hi = mid
                return (lo + hi) / 2
            jd, prev = jd2, cur
        raise RuntimeError("lunar return crossing not found")

    prev_jd = scan(-1)
    next_jd = scan(1)
    return {"previous": _lunar_chart(prev_jd), "next": _lunar_chart(next_jd)}


def lunar_return_block(d: date | None = None) -> str:
    d = d or datetime.now(T.ET).date()
    lr = lunar_return(d)
    lines = [f"\U0001f319 LUNAR RETURN — around {d:%b %-d %Y} (Dunedin FL, Placidus)", ""]
    for label, r in (("PREVIOUS", lr["previous"]), ("NEXT", lr["next"])):
        lines.append(f"{label}: {r['when_et']:%b %-d %Y %-I:%M%p} ET")
        lines.append(f"  LR Moon {_sign_deg(r['moon_lon'])} — LR {T.ordinal(r['moon_lr_house'])} house")
        lines.append(f"  LR ASC {_sign_deg(r['asc_lon'])} — falls in your natal {T.ordinal(r['asc_natal_house'])} house")
        if r["aspects"]:
            lines.append("  Tight LR aspects to natal (≤2°):")
            for h in r["aspects"][:6]:
                lines.append(f"   • LR {h['lr']} {h['aspect']} natal {h['natal']} (orb {h['orb']}°)")
        lines.append("")
    return "\n".join(lines).rstrip()


# ═══════════════════════════════════════════════════════════════════════════
# 3. PROGRESSED LUNATION PHASE
# ═══════════════════════════════════════════════════════════════════════════
PHASE_NAMES = ["new", "crescent", "first_quarter", "gibbous", "full", "disseminating",
               "last_quarter", "balsamic"]

PHASE_MEANINGS = {
    "new": ("A new cycle is seeded in the dark, its shape not yet visible even to you.",
            "This is a season for planting rather than judging results — trust the impulse before you can defend it."),
    "crescent": ("Emergence: the new impulse breaks through the surface of the old pattern for the first time, fragile but real.",
                 "Growth here is uneven and effortful — keep pushing through inertia rather than waiting for it to feel easy."),
    "first_quarter": ("A crisis in action: the new direction meets the old structure head-on and something has to give.",
                       "Decisive, sometimes uncomfortable choices made now determine whether the cycle's intention survives contact with the world."),
    "gibbous": ("Overcoming: you refine and perfect the work by confronting exactly what still resists you, detail by detail.",
                "This is where discipline and self-correction turn effort into something that can withstand being seen."),
    "full": ("Illumination: what was planted in darkness is now fully lit and visible, seen by others as well as yourself.",
             "Relationship and reflection matter most now — the meaning of the cycle becomes objective through contact with the outer world."),
    "disseminating": ("Having seen the light of the full phase, you now carry it outward — teaching, sharing, distributing what you've learned.",
                       "The emphasis shifts from personal experience to social usefulness: what you know now serves a wider circle."),
    "last_quarter": ("A crisis in consciousness: old beliefs and structures that no longer fit the person you've become must be released.",
                      "This is reorientation, not collapse — clearing the ground of outworn commitments so the next cycle has room to begin."),
    "balsamic": ("Release and quiet withdrawal, seeding a future not yet visible even to the seer of the phase before.",
                 "What matters now is faith in what comes after you, not what you can still finish — let go before the new cycle needs the space."),
}


def _prog_angle(d: date) -> float:
    return (_prog_lon(d, swe.MOON) - _prog_lon(d, swe.SUN)) % 360


def _phase_of(ang: float) -> str:
    idx = min(int(ang // 45), 7)
    return PHASE_NAMES[idx]


def _find_angle_crossing(target_deg: float, d: date, direction: int, max_days: int) -> date | None:
    """Daily scan from d in `direction` for the date the progressed lunation angle
    (pMoon - pSun, mod 360) crosses target_deg (mod 360, monotonic increasing)."""
    def g(dd: date) -> float:
        return _signed_diff(_prog_angle(dd), target_deg)

    dd = d
    prev = g(dd)
    for _ in range(max_days):
        nd = dd + timedelta(days=direction)
        cur = g(nd)
        if prev == 0:
            return dd
        if (prev < 0) != (cur < 0) and abs(cur - prev) < 90:
            return nd if direction > 0 else dd
        dd, prev = nd, cur
    return None


def progressed_phase(d: date | None = None) -> dict:
    d = d or datetime.now(T.ET).date()
    ang = _prog_angle(d)
    idx = min(int(ang // 45), 7)
    phase, phase_lo = PHASE_NAMES[idx], idx * 45
    phase_hi = (idx + 1) * 45 % 360
    next_phase = PHASE_NAMES[(idx + 1) % 8]

    phase_start = _find_angle_crossing(phase_lo, d, -1, 1825)
    next_phase_start = _find_angle_crossing(phase_hi, d, 1, 1825)
    last_new_moon = _find_angle_crossing(0, d, -1, 11680)
    next_new_moon = _find_angle_crossing(0, d, 1, 11680)
    next_full_moon = _find_angle_crossing(180, d, 1, 11680)
    candidates = [x for x in (next_new_moon, next_full_moon) if x]
    next_new_or_full = min(candidates) if candidates else None

    return {
        "date": d, "angle": round(ang, 3), "phase": phase,
        "phase_start": phase_start, "next_phase": next_phase, "next_phase_start": next_phase_start,
        "last_new_moon": last_new_moon, "next_new_moon": next_new_moon,
        "next_full_moon": next_full_moon, "next_new_or_full_moon": next_new_or_full,
    }


def progressed_phase_block(d: date | None = None) -> str:
    d = d or datetime.now(T.ET).date()
    ph = progressed_phase(d)
    m1, m2 = PHASE_MEANINGS[ph["phase"]]
    lines = [f"\U0001f317 PROGRESSED LUNATION PHASE — {d:%b %-d %Y}", ""]
    lines.append(f"Phase: {ph['phase'].upper().replace('_', ' ')} ({round(ph['angle'])}° progressed Moon from progressed Sun)")
    if ph["phase_start"]:
        lines.append(f"Started {ph['phase_start']:%b %-d %Y}")
    if ph["next_phase_start"]:
        lines.append(f"Next phase ({ph['next_phase'].replace('_', ' ')}) begins {ph['next_phase_start']:%b %-d %Y}")
    lines.append("")
    lines.append(m1)
    lines.append(m2)
    lines.append("")
    if ph["last_new_moon"]:
        lines.append(f"Last progressed New Moon: {ph['last_new_moon']:%b %-d %Y}")
    if ph["next_new_or_full_moon"]:
        kind = "New" if ph["next_new_or_full_moon"] == ph["next_new_moon"] else "Full"
        lines.append(f"Next progressed {kind} Moon: {ph['next_new_or_full_moon']:%b %-d %Y}")
    return "\n".join(lines)


# ═══════════════════════════════════════════════════════════════════════════
# 4. SOLAR ARC
# ═══════════════════════════════════════════════════════════════════════════
def solar_arc(d: date | None = None) -> dict:
    """Directed positions = natal + (progressed Sun lon - natal Sun lon), every natal body/angle."""
    d = d or datetime.now(T.ET).date()
    natal = T.natal()
    arc = (_prog_lon(d, swe.SUN) - natal["Sun"]["lon"]) % 360
    directed = {name: (v["lon"] + arc) % 360 for name, v in natal.items()}
    return {"date": d, "arc": round(arc, 4), "directed": directed}


def solar_arc_hits(start: date, years: int = 5) -> list[dict]:
    """Dates a directed body is exactly conjunct/square/opposite a natal body or angle
    (0deg orb crossing; monthly scan, bisected to the day)."""
    natal = T.natal()
    natal_sun = natal["Sun"]["lon"]
    pts = {n: v["lon"] for n, v in natal.items() if n != "IC"}

    def arc_deg(d: date) -> float:
        return (_prog_lon(d, swe.SUN) - natal_sun) % 360

    end = date(start.year + years, start.month, start.day)
    months: list[date] = []
    d = start
    while d <= end:
        months.append(d)
        y, m = d.year, d.month
        m, y = (m + 1, y) if m < 12 else (1, y + 1)
        d = date(y, m, min(start.day, 28))
    arcs = [arc_deg(m) for m in months]

    hits = []
    for xname, xlon0 in pts.items():
        for yname, ylon0 in pts.items():
            for aname, adeg in ASPECT_SUBSET.items():
                target = (ylon0 + adeg) % 360
                series = [_signed_diff((xlon0 + a) % 360, target) for a in arcs]
                for i in range(1, len(series)):
                    prev, cur = series[i - 1], series[i]
                    if prev == 0 or ((prev < 0) != (cur < 0) and abs(cur - prev) < 90):
                        lo, hi = months[i - 1], months[i]
                        while (hi - lo).days > 1:
                            mid = lo + (hi - lo) // 2
                            fm = _signed_diff((xlon0 + arc_deg(mid)) % 360, target)
                            if (prev < 0) == (fm < 0):
                                lo, prev = mid, fm
                            else:
                                hi = mid
                        hits.append({"date": hi.isoformat(),
                                     "what": f"Solar-arc {xname} {aname} natal {yname}"})
    hits.sort(key=lambda h: h["date"])
    return hits


def solar_arc_block(d: date | None = None) -> str:
    d = d or datetime.now(T.ET).date()
    sa = solar_arc(d)
    hits = [h for h in solar_arc_hits(d, years=10) if h["date"] >= d.isoformat()][:12]
    lines = [f"➡️ SOLAR ARC DIRECTIONS — from {d:%b %-d %Y}", ""]
    lines.append(f"Current solar arc: {sa['arc']}° applied to every natal point (roughly 1° per year lived)")
    lines.append("")
    lines.append("NEXT 12 HITS (0° orb, conjunct/square/opposite only):")
    for h in hits:
        lines.append(f"• {date.fromisoformat(h['date']):%b %-d %Y}: {h['what']}")
    return "\n".join(lines)


# ═══════════════════════════════════════════════════════════════════════════
if __name__ == "__main__":
    args = [a for a in sys.argv[1:] if a != "--send"]
    send = "--send" in sys.argv
    cmd = args[0] if args else "phase"
    today = datetime.now(T.ET).date()
    if cmd == "solar":
        year = int(args[1]) if len(args) > 1 else today.year
        out = solar_return_block(year)
    elif cmd == "lunar":
        out = lunar_return_block(today)
    elif cmd == "phase":
        out = progressed_phase_block(today)
    elif cmd == "arc":
        out = solar_arc_block(today)
    else:
        out = __doc__
    print(out)
    if send:
        # Telegram cap is 4096; chunk on blank lines like daily_transits does.
        chunks, cur = [], ""
        for para in out.split("\n\n"):
            if len(cur) + len(para) + 2 > 3900 and cur:
                chunks.append(cur); cur = para
            else:
                cur = f"{cur}\n\n{para}" if cur else para
        if cur:
            chunks.append(cur)
        from svehla import send_to_lane
        for c in chunks:
            send_to_lane(c)
