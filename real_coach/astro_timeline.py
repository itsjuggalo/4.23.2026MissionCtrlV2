#!/usr/bin/env python3
"""astro_timeline.py — dated calendar of what the sky does to Mike's chart, 2026→2031,
computed from the real ephemeris (never from a reading), with researched meanings attached
by key from the astro_kb_*.json files (via astro_lexicon.kb_entry).

Events: slow-body sign ingresses, Placidus house ingresses, exact aspects to every natal
point, progressed Moon sign/house ingresses, eclipses touching natal points, solar-arc hits.

CLI: astro_timeline.py [next N]  → chronological list (default 30 days)
     astro_timeline.py today      → what is exact / ingressing within ±2 days
     astro_timeline.py year       → the next 12 months, one line each
     astro_timeline.py rebuild    → recompute the cache (astro_timeline.json)
     astro_timeline.py key "<key>"→ show the researched entry for a key
"""
from __future__ import annotations
import json, re, sys
from datetime import date, datetime, timedelta
from pathlib import Path
import swisseph as swe
import astro_truth as T
import astro_lexicon as lex
from svehla import _signed_diff, _crossings, jd_of, natal_lon

HERE = Path(__file__).resolve().parent
CACHE = HERE / "astro_timeline.json"
START, END = date(2026, 9, 1), date(2031, 12, 31)
# aspect scans start this far back so a retrograde triple pass that began before START is
# numbered correctly (Saturn□Juno: May 28 → Sep 27 → Feb 18 is "2 of 3", not "1 of 2")
LOOKBACK = START - timedelta(days=1100)
SLOW = {"Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS, "Neptune": swe.NEPTUNE,
        "Pluto": swe.PLUTO, "Chiron": swe.CHIRON, "Ceres": swe.CERES, "Juno": swe.JUNO}
NATAL_POINTS = ["Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
                "Pluto", "Chiron", "Ceres", "Juno", "Hades", "Apollon", "ASC", "MC"]
ASPECTS = {"conjunct": 0, "square": 90, "opposite": 180, "trine": 120, "sextile": 60}
# which aspects are worth a dated line per body (fast asteroids only on the hard ones)
BODY_ASPECTS = {"Jupiter": ["conjunct", "square", "opposite", "trine"],
                "Saturn": ["conjunct", "square", "opposite", "trine"],
                "Uranus": ["conjunct", "square", "opposite", "trine", "sextile"],
                "Neptune": ["conjunct", "square", "opposite", "trine", "sextile"],
                "Pluto": ["conjunct", "square", "opposite", "trine", "sextile"],
                "Chiron": ["conjunct", "square", "opposite"],
                "Ceres": ["conjunct"], "Juno": ["conjunct", "opposite"]}
GLYPH = {"Jupiter": "♃", "Saturn": "♄", "Uranus": "♅", "Neptune": "♆", "Pluto": "♇", "Chiron": "⚷",
         "Ceres": "⚳", "Juno": "⚵", "Moon": "☽", "eclipse": "🌑", "arc": "➡️", "progressed": "🌙", "sky": "🌐", "to_progressed": "🔁"}


def _lon(jd: float, body: int) -> float:
    return swe.calc_ut(jd, body)[0][0] % 360


def _sign_ingresses(name: str, body: int) -> list[dict]:
    out = []
    for s in range(12):
        f = lambda jd, b=body, s=s: _signed_diff(_lon(jd, b), s * 30.0)
        for d in _crossings(f, START, END):
            spd = swe.calc_ut(jd_of(d) + 0.5, body)[0][3]
            back = spd < 0
            sign = T.SIGNS[(s - 1) % 12] if back else T.SIGNS[s]
            house = T.house_of((s * 30.0 - 0.01) % 360 if back else s * 30.0 + 0.01)
            out.append({"date": d.isoformat(), "kind": "sign", "body": name,
                        "key": f"Transiting {name} in {sign}",
                        "what": f"{name} {'backs into' if back else 'enters'} {sign} (your {T.ordinal(house)} house)"})
    return out


def _house_ingresses(name: str, body: int) -> list[dict]:
    out = []
    for i, cusp in enumerate(T.CUSPS):
        f = lambda jd, b=body, c=cusp: _signed_diff(_lon(jd, b), c)
        for d in _crossings(f, START, END):
            spd = swe.calc_ut(jd_of(d) + 0.5, body)[0][3]
            back = spd < 0
            house = i if back else i + 1          # cusp i (0-based) opens house i+1
            house = 12 if house == 0 else house
            out.append({"date": d.isoformat(), "kind": "house", "body": name,
                        "key": f"Transiting {name} in the {T.ordinal(house)} house",
                        "what": f"{name} {'backs into' if back else 'crosses into'} your {T.ordinal(house)} house"})
    return out


def _exact_aspects(name: str, body: int) -> list[dict]:
    out = []
    for npt in NATAL_POINTS:
        target = natal_lon(npt)
        for asp in BODY_ASPECTS[name]:
            deg = ASPECTS[asp]
            angles = {deg} if deg in (0, 180) else {deg, 360 - deg}
            for a in angles:
                f = lambda jd, b=body, t=(target + a) % 360: _signed_diff(_lon(jd, b), t)
                for d in _crossings(f, LOOKBACK, END):
                    lon = _lon(jd_of(d) + 0.5, body)
                    out.append({"date": d.isoformat(), "kind": "aspect", "body": name, "natal": npt,
                                "aspect": asp, "t_house": T.house_of(lon),
                                "key": f"Transiting {name} {asp} natal {npt}",
                                "what": f"{name} exactly {asp} your natal {npt}"})
    return out


def _progressed_moon() -> list[dict]:
    out, d = [], START
    prev = T.progressed(d)["Moon"]
    while d < END:
        d += timedelta(days=1)
        cur = T.progressed(d)["Moon"]
        if cur["sign"] != prev["sign"]:
            out.append({"date": d.isoformat(), "kind": "progressed", "body": "Moon",
                        "key": f"Progressed Moon in {cur['sign']}",
                        "what": f"Progressed Moon enters {cur['sign']}"})
        if cur["house"] != prev["house"]:
            out.append({"date": d.isoformat(), "kind": "progressed", "body": "Moon",
                        "key": f"Progressed Moon in the {T.ordinal(cur['house'])} house",
                        "what": f"Progressed Moon enters your {T.ordinal(cur['house'])} house"})
        prev = cur
    return out


# ── progressed Moon → natal aspects, transits → progressed points, sky-to-sky ────────────
PROG_TARGETS = ["Sun", "Moon", "Mercury", "Venus"]
SKY_PAIRS_BODIES = ["Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"]


def _prog_table() -> dict[str, dict[int, float]]:
    """Progressed longitudes per day-ordinal for the scan window (one ephemeris pass)."""
    tbl: dict[str, dict[int, float]] = {k: {} for k in PROG_TARGETS}
    d = START - timedelta(days=1)
    while d <= END + timedelta(days=1):
        pr = T.progressed(d)
        for k in PROG_TARGETS:
            tbl[k][d.toordinal()] = pr[k]["lon"]
        d += timedelta(days=1)
    return tbl


def _prog_lon(tbl: dict[int, float], jd: float) -> float:
    """Interpolated progressed longitude at a JD (progressed bodies move < 0.1°/day, linear is exact enough)."""
    y, m, dd, h = swe.revjul(jd)
    o = date(y, m, dd).toordinal()
    a, b = tbl.get(o), tbl.get(o + 1)
    if a is None:
        return b if b is not None else 0.0
    if b is None:
        return a
    return (a + ((b - a + 180) % 360 - 180) * (h / 24.0)) % 360


def _progressed_moon_aspects(tbl: dict[str, dict[int, float]]) -> list[dict]:
    out = []
    pm = tbl["Moon"]
    for npt in NATAL_POINTS:
        target = natal_lon(npt)
        for asp in ("conjunct", "square", "opposite", "trine"):
            deg = ASPECTS[asp]
            for a in ({deg} if deg in (0, 180) else {deg, 360 - deg}):
                f = lambda jd, t=(target + a) % 360, pm=pm: _signed_diff(_prog_lon(pm, jd), t)
                for d in _crossings(f, START, END):
                    out.append({"date": d.isoformat(), "kind": "progressed", "body": "Moon", "natal": npt, "aspect": asp,
                                "key": f"Progressed Moon {asp} natal {npt}",
                                "what": f"Progressed Moon exactly {asp} your natal {npt}"})
    return out


def _transits_to_progressed(tbl: dict[str, dict[int, float]]) -> list[dict]:
    out = []
    for name in ("Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"):
        body = SLOW[name]
        for pt in PROG_TARGETS:
            pt_tbl = tbl[pt]
            for asp in ("conjunct", "square", "opposite"):
                deg = ASPECTS[asp]
                for a in ({deg} if deg in (0, 180) else {deg, 360 - deg}):
                    f = lambda jd, b=body, t=pt_tbl, a=a: _signed_diff(_lon(jd, b), (_prog_lon(t, jd) + a) % 360)
                    for d in _crossings(f, START, END):
                        out.append({"date": d.isoformat(), "kind": "to_progressed", "body": name, "natal": f"progressed {pt}", "aspect": asp,
                                    "key": f"Transiting {name} {asp} progressed {pt}",
                                    "what": f"{name} exactly {asp} your progressed {pt}"})
    return out


def _sky_aspects() -> list[dict]:
    """Slow-body sky-to-sky aspects (mundane), with the house of the faster body for Mike."""
    out = []
    for i, a_name in enumerate(SKY_PAIRS_BODIES):
        for b_name in SKY_PAIRS_BODIES[i + 1:]:
            ab, bb = SLOW[a_name], SLOW[b_name]
            for asp in ("conjunct", "square", "opposite", "trine"):
                deg = ASPECTS[asp]
                for a in ({deg} if deg in (0, 180) else {deg, 360 - deg}):
                    f = lambda jd, ab=ab, bb=bb, a=a: _signed_diff(_lon(jd, ab), (_lon(jd, bb) + a) % 360)
                    for d in _crossings(f, START, END):
                        la, lb = _lon(jd_of(d) + 0.5, ab), _lon(jd_of(d) + 0.5, bb)
                        da, db = T.describe(la), T.describe(lb)
                        out.append({"date": d.isoformat(), "kind": "sky", "body": a_name, "other": b_name, "aspect": asp,
                                    "key": f"{a_name} {asp} {b_name} (sky)",
                                    "what": f"{a_name} {da['deg']}° {da['sign']} (your {T.ordinal(da['house'])}) {asp} {b_name} {db['deg']}° {db['sign']} (your {T.ordinal(db['house'])}) — sky aspect"})
    return out


def _eclipses() -> list[dict]:
    out = []
    try:
        import astro_sky
        for e in astro_sky.eclipses(START, (END - START).days):
            d = e["date_et"][:10]
            base = f"{e['type'].capitalize()} {e['kind']} eclipse at {e['deg']}° {e['sign']} (your {T.ordinal(e['house'])} house)"
            if e.get("natal_hits"):
                for h in e["natal_hits"]:
                    out.append({"date": d, "kind": "eclipse", "body": e["kind"],
                                "key": f"{e['kind'].capitalize()} eclipse {h['aspect']} natal {h['natal']}",
                                "alt_key": f"{e['kind'].capitalize()} eclipse in the {T.ordinal(e['house'])} house",
                                "what": f"{base} — {h['aspect']} your natal {h['natal']} (orb {h['orb']:.1f}°)"})
            else:
                out.append({"date": d, "kind": "eclipse", "body": e["kind"],
                            "key": f"{e['kind'].capitalize()} eclipse in the {T.ordinal(e['house'])} house",
                            "what": base})
    except Exception as ex:
        out.append({"date": START.isoformat(), "kind": "error", "body": "eclipse", "key": "", "what": f"eclipses unavailable: {ex}"})
    return out


def _solar_arcs() -> list[dict]:
    out = []
    try:
        import astro_returns
        for h in astro_returns.solar_arc_hits(START, years=6):
            out.append({"date": h["date"], "kind": "arc", "body": "arc", "key": h["what"], "what": h["what"]})
    except Exception as ex:
        out.append({"date": START.isoformat(), "kind": "error", "body": "arc", "key": "", "what": f"solar arc unavailable: {ex}"})
    return out


def _stamp(run: list[dict]) -> None:
    if len(run) > 1:
        for i, e in enumerate(run, 1):
            rx = swe.calc_ut(jd_of(date.fromisoformat(e["date"])) + 0.5, SLOW[e["body"]])[0][3] < 0
            e["pass"] = f"{i} of {len(run)}"
            e["rx"] = rx
            e["what"] += f" (pass {i} of {len(run)}{', retrograde' if rx else ''})"


def build() -> list[dict]:
    ev = []
    for name, body in SLOW.items():
        ev += _sign_ingresses(name, body) + _house_ingresses(name, body) + _exact_aspects(name, body)
    tbl = _prog_table()
    ev += _progressed_moon() + _progressed_moon_aspects(tbl) + _transits_to_progressed(tbl) + _sky_aspects() + _eclipses() + _solar_arcs()
    ev = [e for e in ev if e["kind"] != "error"] + [e for e in ev if e["kind"] == "error"]
    ev.sort(key=lambda e: (e["date"], e["kind"], e["body"]))
    # pass numbering: same aspect key hitting again within 20 months = the retrograde triple pass
    groups: dict[str, list[dict]] = {}
    for e in ev:
        if e["kind"] == "aspect":
            groups.setdefault(e["key"], []).append(e)
    for key, lst in groups.items():
        run: list[dict] = []
        for e in lst:
            if run and (date.fromisoformat(e["date"]) - date.fromisoformat(run[-1]["date"])).days > 600:
                _stamp(run); run = []
            run.append(e)
        _stamp(run)
    ev = [e for e in ev if e["date"] >= START.isoformat()]   # lookback hits only served the numbering
    CACHE.write_text(json.dumps({"built": datetime.now(T.ET).isoformat(timespec="minutes"),
                                 "start": START.isoformat(), "end": END.isoformat(), "events": ev}, indent=1))
    return ev


def load(max_age_days: int = 30) -> list[dict]:
    if CACHE.exists():
        try:
            data = json.loads(CACHE.read_text())
            built = datetime.fromisoformat(data["built"])
            if (datetime.now(T.ET) - built).days <= max_age_days:
                return data["events"]
        except Exception:
            pass
    return build()


# ── rendering ─────────────────────────────────────────────────────────────────
def _sentence_case(s: str) -> str:
    return re.sub(r"(^|[.!?]\s+)([a-z])", lambda m: m.group(1) + m.group(2).upper(), s)


def _meaning(e: dict, full: bool = False) -> str:
    return _sentence_case(_meaning_raw(e, full))


def _meaning_raw(e: dict, full: bool = False) -> str:
    """Researched translation for the event key (or alt_key), else the lexicon combo, else ''."""
    ent = lex.kb_entry(e.get("key", "")) or lex.kb_entry(e.get("alt_key", ""))
    if ent:
        s = ent.get("translation", "")
        if full:
            if ent.get("esoteric"):
                s += f" Esoteric: {ent['esoteric']}"
            if ent.get("svehla_link"):
                s += f" Svehla: {ent['svehla_link']}"
            if ent.get("do"):
                s += f" Do: {ent['do']}"
        return s
    c = lex.combo_translation(e.get("key", "")) or lex.combo_translation(e.get("key", "").replace("Transiting ", "").replace("natal ", ""))
    if c:
        return c.split(" (Esoteric:")[0].split(": ", 1)[-1]
    return _generic(e)


def _generic(e: dict) -> str:
    """Composed from the lexicon (planets/signs/houses/aspects) when no researched entry exists."""
    try:
        if e["kind"] == "aspect":
            nl = natal_lon(e["natal"])
            return lex.translate_hit({"t": e["body"], "n": e["natal"], "aspect": e["aspect"]}, nl, nl).replace("In plain terms: ", "")
        if e["kind"] == "house":
            n = int("".join(ch for ch in e["key"].split(" the ")[-1] if ch.isdigit()))
            return f"{e['body']} ({lex.plain(e['body'])}) now works through {lex.HOUSES[n - 1]['is']}. {lex.HOUSES[n - 1]['mike']}."
        if e["kind"] == "sign":
            sign = e["key"].split(" in ")[-1]
            hs = lex.houses_for_sign(sign)
            return f"{e['body']} ({lex.plain(e['body'])}) takes on {sign}: {lex.SIGNS[sign]['is']}. For you {sign} is your {'/'.join(lex.ORDINAL(h) for h in hs)} house."
        if e["kind"] == "sky":
            A, B, asp = e["body"], e["other"], e["aspect"]
            return (f"A sky-wide aspect (everyone feels it): {lex.plain(A)} {lex.ASPECT_PLAIN[asp].split('{B}')[0].replace('{A}', '').strip() or asp} {lex.plain(B)}. "
                    f"For you it lands where the two planets sit in your houses (see the line above).")
        if e["kind"] == "to_progressed":
            pt = e["natal"].replace("progressed ", "")
            return (f"{e['body']} ({lex.plain(e['body'])}) meets your progressed {pt} — the {pt}-part of you as it has evolved by now, "
                    f"not the birth position. {lex.ASPECTS[e['aspect']]['is']}.")
        if e["kind"] == "progressed" and e.get("aspect"):
            nl = natal_lon(e["natal"])
            return lex.translate_hit({"t": "Moon", "n": e["natal"], "aspect": e["aspect"]}, nl, nl).replace("In plain terms: Moon (", "In plain terms: your progressed Moon (").replace("In plain terms: ", "")
        if e["kind"] == "progressed":
            tail = e["key"].split("Progressed Moon in ")[-1]
            if tail.startswith("the "):
                n = int("".join(ch for ch in tail if ch.isdigit()))
                return f"Your emotional focus (progressed Moon, ~2.5 years per house) moves to {lex.HOUSES[n - 1]['is']}. {lex.HOUSES[n - 1]['mike']}."
            return f"Your emotional style (progressed Moon, ~2.5 years per sign) takes on {tail}: {lex.SIGNS[tail]['is']}."
    except Exception:
        return ""
    return ""


def _glyph(e: dict) -> str:
    if e["kind"] in ("sky", "to_progressed"):
        return GLYPH[e["kind"]]
    return GLYPH.get(e["body"], GLYPH.get(e["kind"], "•"))


def _fmt_date(s: str) -> str:
    d = date.fromisoformat(s)
    return d.strftime("%b %-d %Y") if d.year != date.today().year else d.strftime("%b %-d")


def upcoming_block(d: date | None = None, days: int = 30, full: bool = False, limit: int = 40) -> str:
    d = d or datetime.now(T.ET).date()
    end = d + timedelta(days=days)
    ev = _merge_angles([e for e in load() if d.isoformat() <= e["date"] <= end.isoformat()])
    lines = [f"🗓 TIMELINE — next {days} days from {d.strftime('%b %-d')} (real ephemeris, Placidus)"]
    if not ev:
        lines.append("Nothing exact in this window.")
    for e in ev[:limit]:
        m = _meaning(e, full)
        lines.append(f"{_glyph(e)} {_fmt_date(e['date'])}: {e['what']}" + (f"\n   ↳ {m}" if m else ""))
    if len(ev) > limit:
        lines.append(f"… +{len(ev) - limit} more (/timeline {days} full)")
    return "\n".join(lines)


ANGLE_CUSP = {("ASC", "conjunct"): 1, ("ASC", "opposite"): 7, ("MC", "conjunct"): 10, ("MC", "opposite"): 4}


def _merge_angles(ev: list[dict]) -> list[dict]:
    house = {(e["date"], e["body"], e["key"].split(" the ")[-1].split()[0]): e for e in ev if e["kind"] == "house"}
    out = []
    for e in ev:
        cusp = ANGLE_CUSP.get((e.get("natal"), e.get("aspect"))) if e["kind"] == "aspect" else None
        h = house.get((e["date"], e["body"], T.ordinal(cusp))) if cusp else None
        if h:
            if e.get("pass") and "(pass" not in h["what"]:
                h = {**h, "what": h["what"] + f" (pass {e['pass']}{', retrograde' if e.get('rx') else ''})"}
                house[(e["date"], e["body"], T.ordinal(cusp))] = h
            continue
        out.append(e)
    return [house.get((e["date"], e["body"], e["key"].split(" the ")[-1].split()[0]), e) if e["kind"] == "house" else e for e in out]


def near_events(d: date, window: int = 2) -> list[dict]:
    lo, hi = (d - timedelta(days=window)).isoformat(), (d + timedelta(days=window)).isoformat()
    return _merge_angles([e for e in load() if lo <= e["date"] <= hi])


def rel_day(s: str, d: date) -> str:
    n = (date.fromisoformat(s) - d).days
    return {0: "today", -1: "yesterday", 1: "tomorrow"}.get(n, _fmt_date(s))


def today_block(d: date | None = None, window: int = 2, skip: set | None = None) -> str:
    """Events exact within ±window days — for the daily send. `skip` = {(body, aspect, natal)}
    already shown as a top hit (their pass/date ride on that line instead of repeating here)."""
    d = d or datetime.now(T.ET).date()
    ev = [e for e in near_events(d, window)
          if not (skip and (e["body"], e.get("aspect"), e.get("natal")) in skip)]
    if not ev:
        return ""
    lines = ["🗓 Exact this week (timeline):"]
    for e in ev[:6]:
        when = rel_day(e["date"], d)
        m = _meaning(e)
        lines.append(f"{_glyph(e)} {when}: {e['what']}" + (f" — {m}" if m else ""))
    return "\n".join(lines)


def year_block(d: date | None = None) -> str:
    d = d or datetime.now(T.ET).date()
    end = d + timedelta(days=365)
    ev = [e for e in load() if d.isoformat() <= e["date"] <= end.isoformat()
          and (e["kind"] in ("sign", "house", "eclipse", "sky", "to_progressed") or (e["kind"] == "progressed" and e.get("aspect") in (None, "conjunct", "opposite"))
               or e["body"] in ("Saturn", "Uranus", "Neptune", "Pluto", "Chiron")
               or e.get("aspect") in ("conjunct", "opposite", "square"))]
    lines = [f"📆 THE YEAR AHEAD — {d.strftime('%b %-d %Y')} → {end.strftime('%b %-d %Y')}"]
    for e in ev:
        lines.append(f"{_glyph(e)} {_fmt_date(e['date'])}: {e['what']}")
    return "\n".join(lines)


if __name__ == "__main__":
    a = sys.argv[1:]
    cmd = a[0] if a else "next"
    if cmd == "rebuild":
        ev = build(); print(f"rebuilt: {len(ev)} events {START} → {END}")
    elif cmd == "today":
        print(today_block() or "Nothing exact within ±2 days.")
    elif cmd == "year":
        print(year_block())
    elif cmd == "key":
        ent = lex.kb_entry(" ".join(a[1:]))
        print(json.dumps(ent, indent=1) if ent else "no researched entry for that key")
    else:
        days = int(a[1]) if len(a) > 1 and a[1].isdigit() else (int(cmd) if cmd.isdigit() else 30)
        print(upcoming_block(days=days, full="full" in a))
