#!/usr/bin/env python3
"""astro_sky.py — real-ephemeris sky events layered on top of astro_truth.py's natal chart.

Everything here is geocentric tropical, computed with pyswisseph against the free se1
ephemeris files, and read against Mike's Placidus houses (astro_truth.CUSPS/house_of).
No estimates, no almanac lookups — every date is a scanned + bisected swisseph crossing.

  lunations(start, days)      → new/full Moon events, house + natal hits
  eclipses(start, days)       → solar/lunar eclipses, type, house + natal hits
  void_of_course(now)         → current Moon VoC window
  stations(start, days)       → retrograde/direct stations, Mercury..Pluto + Chiron
  ingresses(start, days)      → sign changes, Sun..Pluto + Chiron
  mercury_rx(start, days)     → Mercury retrograde periods incl. pre/post shadow
  daily_alerts(d)             → plain-text lines for anything hitting in the next 3 days
  upcoming_block(d, days=60)  → full plain-text chronological listing

CLI:  astro_sky.py [--days N] | astro_sky.py alerts | astro_sky.py voc
"""
from __future__ import annotations

import json
import sys
from datetime import date, datetime, timedelta, timezone
from pathlib import Path

import swisseph as swe

import astro_truth as T

swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))

HERE = Path(__file__).resolve().parent
CACHE_FILE = HERE / "astro_sky_cache.json"
CACHE_HORIZON_DAYS = 400   # how far ahead a rebuilt cache covers
CACHE_MAX_AGE_DAYS = 7

# bodies used across stations/ingresses (Mercury..Pluto + Chiron; Sun/Moon never "station")
OUTER_BODIES = {"Mercury": swe.MERCURY, "Venus": swe.VENUS, "Mars": swe.MARS,
                "Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS,
                "Neptune": swe.NEPTUNE, "Pluto": swe.PLUTO, "Chiron": swe.CHIRON}
INGRESS_BODIES = {"Sun": swe.SUN, "Mercury": swe.MERCURY, "Venus": swe.VENUS, "Mars": swe.MARS,
                   "Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS,
                   "Neptune": swe.NEPTUNE, "Pluto": swe.PLUTO, "Chiron": swe.CHIRON}
VOC_BODIES = ["Sun", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"]
VOC_BODY_ID = {"Sun": swe.SUN, "Mercury": swe.MERCURY, "Venus": swe.VENUS, "Mars": swe.MARS,
               "Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS,
               "Neptune": swe.NEPTUNE, "Pluto": swe.PLUTO}
ASPECT_ANGLES = [0.0, 60.0, 90.0, 120.0, 180.0]

# short plain-English house tags for daily_alerts lines (general meanings, not the
# Mike-specific "mike" gloss astro_lexicon carries — that stays out of this module)
HOUSE_TAG = [
    "identity, body, first impressions", "money, possessions, self-worth",
    "communication, siblings, learning", "home, roots, family",
    "creativity, children, romance", "daily work, health, routine",
    "partnership, the significant other", "shared resources, debt, transformation",
    "beliefs, higher learning, travel", "career, reputation, public standing",
    "friends, groups, income from vocation", "solitude, endings, the hidden",
]
BODY_ICON = {"Mercury": "☿", "Venus": "♀", "Mars": "♂", "Jupiter": "♃", "Saturn": "♄",
             "Uranus": "⛢", "Neptune": "♆", "Pluto": "♇", "Chiron": "⚷"}


# ── time / geometry helpers ─────────────────────────────────────────────────
def _jd(dt: datetime) -> float:
    u = dt.astimezone(timezone.utc)
    return swe.julday(u.year, u.month, u.day, u.hour + u.minute / 60 + u.second / 3600)


def _jd_of_date(d: date, hour: float = 12.0) -> float:
    return _jd(datetime(d.year, d.month, d.day, tzinfo=T.ET) + timedelta(hours=hour))


def _jd_to_dt(jd: float) -> datetime:
    y, m, d, h = swe.revjul(jd)
    hh = int(h)
    mm = int(round((h - hh) * 60))
    if mm == 60:
        mm, hh = 0, hh + 1
    if hh == 24:
        hh = 0
        d += 1  # good enough; revjul never actually returns 24 in practice
    return datetime(y, m, d, hh, mm, tzinfo=timezone.utc).astimezone(T.ET)


def _iso(jd: float) -> str:
    return _jd_to_dt(jd).isoformat(timespec="minutes")


def angle(a: float, b: float) -> float:
    d = abs(a - b) % 360
    return d if d <= 180 else 360 - d


def _signed_gap(lon: float, target: float) -> float:
    """lon - target, wrapped to (-180, 180]. Zero when lon == target (mod 360)."""
    return ((lon - target + 180) % 360) - 180


def _lon(jd: float, body: int) -> float:
    return swe.calc_ut(jd, body)[0][0] % 360


def _speed(jd: float, body: int) -> float:
    return swe.calc_ut(jd, body)[0][3]


def natal_hits(lon: float, orb: float = 3.0) -> list[dict]:
    """Natal points within `orb` degrees of `lon` by conjunction or opposition."""
    hits = []
    for name, v in T.natal().items():
        sep = angle(lon, v["lon"])
        for aname, adeg in (("conjunct", 0.0), ("opposite", 180.0)):
            o = abs(sep - adeg)
            if o <= orb:
                hits.append({"natal": name, "aspect": aname, "orb": round(o, 2)})
    hits.sort(key=lambda h: h["orb"])
    return hits


def _point(lon: float) -> dict:
    info = T.describe(lon)
    return {"lon": info["lon"], "sign": info["sign"], "deg": info["deg"], "house": info["house"]}


def _bisect_root(f, lo: float, hi: float, flo: float, tol_days: float = 1 / 1440) -> float:
    for _ in range(60):
        if hi - lo < tol_days:
            break
        mid = (lo + hi) / 2
        fm = f(mid)
        if (flo < 0) == (fm < 0):
            lo, flo = mid, fm
        else:
            hi = mid
    return (lo + hi) / 2


def _scan_crossings(f, jd0: float, jd1: float, step_days: float, tol_days: float = 1 / 1440) -> list[float]:
    """Coarse-scan f over [jd0,jd1] at step_days, bisect every sign change to tol_days."""
    out: list[float] = []
    t0, f0 = jd0, f(jd0)
    if f0 == 0:
        out.append(t0)
    while t0 < jd1 - 1e-9:
        t1 = min(t0 + step_days, jd1)
        f1 = f(t1)
        if f1 == 0:
            out.append(t1)
        elif (f0 < 0) != (f1 < 0) and abs(f1 - f0) < 180:
            # real root, not a ±180° wraparound artifact of _signed_gap
            out.append(_bisect_root(f, t0, t1, f0, tol_days))
        t0, f0 = t1, f1
    return out


# ── 1. lunations ─────────────────────────────────────────────────────────────
def lunations(start: date, days: int) -> list[dict]:
    jd0, jd1 = _jd_of_date(start), _jd_of_date(start + timedelta(days=days))
    out = []
    for kind, target in (("new", 0.0), ("full", 180.0)):
        def g(t, target=target):
            return _signed_gap((_lon(t, swe.MOON) - _lon(t, swe.SUN)) % 360, target)
        for jd in _scan_crossings(g, jd0, jd1, 1.0):
            lon = _lon(jd, swe.MOON)
            out.append({"date_et": _iso(jd), "kind": kind, **_point(lon), "natal_hits": natal_hits(lon)})
    out.sort(key=lambda e: e["date_et"])
    return out


# ── 2. eclipses ──────────────────────────────────────────────────────────────
def eclipses(start: date, days: int) -> list[dict]:
    jd0, jd1 = _jd_of_date(start), _jd_of_date(start + timedelta(days=days))
    out = []
    jd = jd0 - 1
    for _ in range(30):
        res, tret = swe.sol_eclipse_when_glob(jd, swe.FLG_SWIEPH, 0, False)
        jdmax = tret[0]
        if jdmax > jd1:
            break
        if jdmax >= jd0:
            etype = ("total" if res & swe.ECL_TOTAL else "annular" if res & swe.ECL_ANNULAR
                      else "hybrid" if res & swe.ECL_ANNULAR_TOTAL else "partial")
            lon = _lon(jdmax, swe.SUN)
            out.append({"date_et": _iso(jdmax), "kind": "solar", "type": etype,
                        **_point(lon), "natal_hits": natal_hits(lon)})
        jd = jdmax + 5
    jd = jd0 - 1
    for _ in range(30):
        _res, tret = swe.lun_eclipse_when(jd, swe.FLG_SWIEPH, 0, False)
        jdmax = tret[0]
        if jdmax > jd1:
            break
        if jdmax >= jd0:
            retflag, _attr = swe.lun_eclipse_how(jdmax, (0.0, 0.0, 0.0), swe.FLG_SWIEPH)
            etype = "total" if retflag & swe.ECL_TOTAL else "partial" if retflag & swe.ECL_PARTIAL else "penumbral"
            lon = _lon(jdmax, swe.MOON)
            out.append({"date_et": _iso(jdmax), "kind": "lunar", "type": etype,
                        **_point(lon), "natal_hits": natal_hits(lon)})
        jd = jdmax + 5
    out.sort(key=lambda e: e["date_et"])
    return out


# ── 3. void of course ────────────────────────────────────────────────────────
def _moon_sign_bounds(jd_now: float) -> tuple[float, float]:
    """(jd Moon entered current sign, jd Moon leaves current sign) bracketing jd_now."""
    idx = int(_lon(jd_now, swe.MOON) // 30)

    def g_exit(t):
        return _signed_gap(_lon(t, swe.MOON), (idx + 1) * 30 % 360)

    def g_enter(t):
        return _signed_gap(_lon(t, swe.MOON), idx * 30 % 360)

    exits = _scan_crossings(g_exit, jd_now, jd_now + 3.0, 0.25)
    exit_jd = exits[0] if exits else jd_now + 3.0
    enters = _scan_crossings(g_enter, jd_now - 3.0, jd_now, 0.25)
    enter_jd = enters[-1] if enters else jd_now - 3.0
    return enter_jd, exit_jd


def void_of_course(now: datetime | None = None) -> dict:
    now = now or datetime.now(T.ET)
    jd_now = _jd(now)
    sign_start, sign_end = _moon_sign_bounds(jd_now)
    last_aspect = None
    targets = sorted({a for base in ASPECT_ANGLES for a in (base, (360 - base) % 360)})
    for name in VOC_BODIES:
        body = VOC_BODY_ID[name]
        for a in targets:
            def g(t, body=body, a=a):
                return _signed_gap((_lon(t, swe.MOON) - _lon(t, body)) % 360, a)
            for jd in _scan_crossings(g, sign_start, sign_end, 2 / 24):
                if last_aspect is None or jd > last_aspect:
                    last_aspect = jd
    voc_start = last_aspect if last_aspect is not None else sign_start
    return {"voc_start_et": _iso(voc_start), "ingress_et": _iso(sign_end),
            "is_voc_now": voc_start <= jd_now < sign_end}


# ── 4. stations ──────────────────────────────────────────────────────────────
def stations(start: date, days: int, bodies: dict | None = None) -> list[dict]:
    bodies = bodies or OUTER_BODIES
    jd0, jd1 = _jd_of_date(start), _jd_of_date(start + timedelta(days=days))
    out = []
    for name, body in bodies.items():
        def g(t, body=body):
            return _speed(t, body)
        for jd in _scan_crossings(g, jd0, jd1, 1.0):
            eps = 0.5
            kind = "retrograde" if _speed(jd - eps, body) > 0 > _speed(jd + eps, body) else "direct"
            lon = _lon(jd, body)
            out.append({"date_et": _iso(jd), "body": name, "kind": kind, **_point(lon)})
    out.sort(key=lambda e: e["date_et"])
    return out


# ── 5. ingresses ─────────────────────────────────────────────────────────────
def ingresses(start: date, days: int) -> list[dict]:
    jd0, jd1 = _jd_of_date(start), _jd_of_date(start + timedelta(days=days))
    out = []
    for name, body in INGRESS_BODIES.items():
        step = 0.5 if name in ("Mercury", "Venus", "Mars") else 1.0
        t0 = jd0
        idx0 = int(_lon(t0, body) // 30)
        while t0 < jd1 - 1e-9:
            t1 = min(t0 + step, jd1)
            idx1 = int(_lon(t1, body) // 30)
            if idx1 != idx0:
                forward = idx1 == (idx0 + 1) % 12
                boundary = (idx1 * 30 if forward else idx0 * 30) % 360

                def g(t, boundary=boundary):
                    return _signed_gap(_lon(t, body), boundary)
                jd = _bisect_root(g, t0, t1, g(t0))
                out.append({"date_et": _iso(jd), "body": name, **_point(boundary % 360)})
            t0, idx0 = t1, idx1
    out.sort(key=lambda e: e["date_et"])
    return out


# ── 6. mercury retrograde cycles (incl. shadow) ─────────────────────────────
def mercury_rx(start: date, days: int) -> list[dict]:
    pad = 50
    st = stations(start - timedelta(days=pad), days + 2 * pad, bodies={"Mercury": swe.MERCURY})
    events = []
    i = 0
    while i < len(st) - 1:
        if st[i]["kind"] == "retrograde" and st[i + 1]["kind"] == "direct":
            rx_start, rx_end = st[i], st[i + 1]
            rx_start_jd = _jd(datetime.fromisoformat(rx_start["date_et"]))
            rx_end_jd = _jd(datetime.fromisoformat(rx_end["date_et"]))
            rx_end_deg = rx_end["lon"]     # station-direct degree (lower)
            rx_start_deg = rx_start["lon"]  # station-retrograde degree (higher)

            def g_pre(t):
                return _signed_gap(_lon(t, swe.MERCURY), rx_end_deg)
            pre_hits = _scan_crossings(g_pre, rx_start_jd - 45, rx_start_jd - 0.5, 0.5)
            pre_shadow = pre_hits[-1] if pre_hits else None

            def g_post(t):
                return _signed_gap(_lon(t, swe.MERCURY), rx_start_deg)
            post_hits = _scan_crossings(g_post, rx_end_jd + 0.5, rx_end_jd + 45, 0.5)
            post_shadow = post_hits[0] if post_hits else None

            events.append({
                "pre_shadow": _iso(pre_shadow) if pre_shadow else None,
                "rx_start": rx_start["date_et"], "rx_end": rx_end["date_et"],
                "post_shadow": _iso(post_shadow) if post_shadow else None,
                "from_deg": rx_start["deg"], "from_sign": rx_start["sign"],
                "to_deg": rx_end["deg"], "to_sign": rx_end["sign"],
                "houses": sorted({rx_start["house"], rx_end["house"]}),
            })
            i += 2
        else:
            i += 1
    win_start = _jd_of_date(start)
    win_end = _jd_of_date(start + timedelta(days=days))
    return [e for e in events if win_start <= _jd(datetime.fromisoformat(e["rx_start"])) <= win_end
            or win_start <= _jd(datetime.fromisoformat(e["rx_end"])) <= win_end
            or (e["pre_shadow"] and win_start <= _jd(datetime.fromisoformat(e["pre_shadow"])) <= win_end)]


# ── cache ────────────────────────────────────────────────────────────────────
def _today_et() -> date:
    return datetime.now(T.ET).date()


def _build_cache(start: date | None = None) -> dict:
    start = start or _today_et()
    data = {
        "generated": _today_et().isoformat(),
        "range_start": start.isoformat(),
        "range_end": (start + timedelta(days=CACHE_HORIZON_DAYS)).isoformat(),
        "lunations": lunations(start, CACHE_HORIZON_DAYS),
        "eclipses": eclipses(start, CACHE_HORIZON_DAYS),
        "stations": stations(start, CACHE_HORIZON_DAYS),
        "ingresses": ingresses(start, CACHE_HORIZON_DAYS),
        "mercury_rx": mercury_rx(start, CACHE_HORIZON_DAYS),
    }
    CACHE_FILE.write_text(json.dumps(data, indent=1))
    return data


def _get_cache(min_days_needed: int) -> dict:
    if CACHE_FILE.exists():
        try:
            data = json.loads(CACHE_FILE.read_text())
            gen = date.fromisoformat(data["generated"])
            end = date.fromisoformat(data["range_end"])
            if (_today_et() - gen).days < CACHE_MAX_AGE_DAYS and end >= _today_et() + timedelta(days=min_days_needed):
                return data
        except Exception:
            pass
    return _build_cache()


def _events_in(d: date, days: int) -> dict:
    cache = _get_cache(days)
    lo, hi = d.isoformat(), (d + timedelta(days=days)).isoformat()
    out = {}
    for key in ("lunations", "eclipses", "stations", "ingresses"):
        out[key] = [e for e in cache[key] if lo <= e["date_et"][:10] <= hi]
    out["mercury_rx"] = [e for e in cache["mercury_rx"]
                          if lo <= e["rx_start"][:10] <= hi or lo <= e["rx_end"][:10] <= hi
                          or (e["pre_shadow"] and lo <= e["pre_shadow"][:10] <= hi)
                          or (e["post_shadow"] and lo <= e["post_shadow"][:10] <= hi)]
    return out


# ── text rendering ───────────────────────────────────────────────────────────
def _house_line(house: int) -> str:
    return f"your {T.ordinal(house)} house ({HOUSE_TAG[house - 1]})"


def _hit_str(hits: list[dict]) -> str:
    if not hits:
        return ""
    h = hits[0]
    return f" — {h['orb']}° from natal {h['natal']} ({h['aspect']})"


def _fmt_lunation(e: dict) -> str:
    icon = "🌑" if e["kind"] == "new" else "🌕"
    label = "New Moon" if e["kind"] == "new" else "Full Moon"
    dt = datetime.fromisoformat(e["date_et"])
    return (f"{icon} {label} {dt:%b %-d} at {e['deg']}° {e['sign']}, {_house_line(e['house'])}"
            f"{_hit_str(e['natal_hits'])}")


def _fmt_eclipse(e: dict) -> str:
    icon = "☀️" if e["kind"] == "solar" else "🌘"
    label = f"{e['type'].title()} {'Solar' if e['kind'] == 'solar' else 'Lunar'} Eclipse"
    dt = datetime.fromisoformat(e["date_et"])
    return (f"{icon} {label} {dt:%b %-d} at {e['deg']}° {e['sign']}, {_house_line(e['house'])}"
            f"{_hit_str(e['natal_hits'])}")


def _fmt_station(e: dict) -> str:
    icon = BODY_ICON.get(e["body"], "•")
    arrow = "℞ retrograde" if e["kind"] == "retrograde" else "direct"
    dt = datetime.fromisoformat(e["date_et"])
    return f"{icon} {e['body']} stations {arrow} {dt:%b %-d} at {e['deg']}° {e['sign']}, {_house_line(e['house'])}"


def _fmt_ingress(e: dict) -> str:
    icon = BODY_ICON.get(e["body"], "☉" if e["body"] == "Sun" else "•")
    dt = datetime.fromisoformat(e["date_et"])
    return f"{icon} {e['body']} enters {e['sign']} {dt:%b %-d}, {_house_line(e['house'])}"


def _fmt_mercury_rx(e: dict) -> str:
    rx = datetime.fromisoformat(e["rx_start"])
    end = datetime.fromisoformat(e["rx_end"])
    houses = " & ".join(f"your {T.ordinal(h)}" for h in e["houses"])
    return (f"☿℞ Mercury retrograde {rx:%b %-d} → {end:%b %-d}, {e['from_sign']} {e['from_deg']}° "
            f"back to {e['to_sign']} {e['to_deg']}° ({houses} house)")


def daily_alerts(d: date | None = None) -> list[str]:
    """Lines for anything in the next 3 days, plus VoC today. Chronological."""
    d = d or _today_et()
    events = _events_in(d, 3)
    rows: list[tuple[str, str]] = []
    for e in events["lunations"]:
        rows.append((e["date_et"], _fmt_lunation(e)))
    for e in events["eclipses"]:
        rows.append((e["date_et"], _fmt_eclipse(e)))
    for e in events["stations"]:
        rows.append((e["date_et"], _fmt_station(e)))
    for e in events["ingresses"]:
        rows.append((e["date_et"], _fmt_ingress(e)))
    for e in events["mercury_rx"]:
        for key, label in (("pre_shadow", "shadow begins"), ("rx_start", "stations retrograde"),
                            ("rx_end", "stations direct"), ("post_shadow", "shadow ends")):
            val = e.get(key)
            if val and d.isoformat() <= val[:10] <= (d + timedelta(days=3)).isoformat():
                dt = datetime.fromisoformat(val)
                rows.append((val, f"☿℞ Mercury {label} {dt:%b %-d} ({e['from_sign']}→{e['to_sign']})"))
    day_start = datetime(d.year, d.month, d.day, tzinfo=T.ET)
    day_end = day_start + timedelta(days=1)
    voc = void_of_course(day_start + timedelta(hours=12))
    start_dt = datetime.fromisoformat(voc["voc_start_et"])
    end_dt = datetime.fromisoformat(voc["ingress_et"])
    if start_dt < day_end and end_dt > day_start:   # VoC window overlaps today at all
        start_s = start_dt.strftime("%H:%M") if day_start <= start_dt < day_end else start_dt.strftime("%b %-d %H:%M")
        end_s = end_dt.strftime("%H:%M") if day_start <= end_dt < day_end else end_dt.strftime("%b %-d %H:%M")
        rows.append((voc["voc_start_et"], f"🌙 Moon void-of-course today {start_s} → {end_s} ET"))
    rows.sort(key=lambda r: r[0])
    return [text for _iso, text in rows]


def upcoming_block(d: date | None = None, days: int = 60) -> str:
    """Chronological plain-text listing for /sky."""
    d = d or _today_et()
    events = _events_in(d, days)
    rows: list[tuple[str, str]] = []
    for e in events["lunations"]:
        rows.append((e["date_et"], _fmt_lunation(e)))
    for e in events["eclipses"]:
        rows.append((e["date_et"], _fmt_eclipse(e)))
    for e in events["stations"]:
        rows.append((e["date_et"], _fmt_station(e)))
    for e in events["ingresses"]:
        rows.append((e["date_et"], _fmt_ingress(e)))
    for e in events["mercury_rx"]:
        rows.append((e["rx_start"], _fmt_mercury_rx(e)))
    rows.sort(key=lambda r: r[0])
    lines = [f"🔭 SKY — {d:%a %b %-d %Y} to {d + timedelta(days=days):%b %-d %Y}", ""]
    for _iso, text in rows:
        lines.append(text)
    voc = void_of_course(datetime.now(T.ET))
    if voc["is_voc_now"]:
        end_dt = datetime.fromisoformat(voc["ingress_et"])
        lines.append("")
        lines.append(f"🌙 Moon is void-of-course right now, until {end_dt:%b %-d %H:%M} ET")
    return "\n".join(lines)


if __name__ == "__main__":
    args = sys.argv[1:]
    if args and args[0] == "alerts":
        for line in daily_alerts():
            print(line)
    elif args and args[0] == "voc":
        print(json.dumps(void_of_course(), indent=1))
    else:
        days = 60
        if "--days" in args:
            days = int(args[args.index("--days") + 1])
        print(upcoming_block(days=days))
