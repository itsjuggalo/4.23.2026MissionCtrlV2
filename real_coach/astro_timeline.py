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
import json, os, re, sys
from datetime import date, datetime, timedelta
from pathlib import Path
import swisseph as swe
import astro_truth as T
import astro_events as E
import astro_lexicon as lex

HERE = Path(__file__).resolve().parent
CACHE = HERE / "astro_timeline.json"
START, END = date(2026, 9, 1), date(2031, 12, 31)
# aspect scans start this far back so a retrograde triple pass that began before START is
# numbered correctly (Saturn□Juno: May 27 → Sep 26 → Feb 17 is "2 of 3", not "1 of 2")
LOOKBACK = START - timedelta(days=1100)
VALID_DAYS = 7                     # cache lifetime; engine-code changes invalidate it immediately
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
PROG_INGRESS_BODIES = ["Moon", "Venus"]
PROG_ASPECT_BODIES = {"Moon": ["conjunct", "square", "opposite", "trine"], "Venus": ["conjunct", "square", "opposite", "trine"]}
GLYPH = {"Jupiter": "♃", "Saturn": "♄", "Uranus": "♅", "Neptune": "♆", "Pluto": "♇", "Chiron": "⚷",
         "Ceres": "⚳", "Juno": "⚵", "Moon": "☽", "eclipse": "🌑", "arc": "➡️", "progressed": "🌙", "sky": "🌐", "to_progressed": "🔁"}
# J1 = the END of END's day (END inclusive); JLA = look-ahead that only serves pass numbering, like
# LOOKBACK (review A5: a series straddling END was numbered 1/2 instead of 1/3)
J0, J1, JLB = T.jd_local(START), T.jd_local(END + timedelta(days=1)), T.jd_local(LOOKBACK)
JLA = T.jd_local(END + timedelta(days=1100))


def natal_lon(point: str) -> float:          # re-exported for older callers
    return E.natal_lon(point)


def _lon(jd: float, body: int) -> float:
    return swe.calc_ut(jd, body)[0][0] % 360


def _spd(jd: float, body: int) -> float:
    return swe.calc_ut(jd, body)[0][3]


def _ev(event_type: str, subtype: str, body: str, x: float, kind: str, key: str, what: str, **kw) -> dict:
    e = E.make_event(event_type, subtype, body, x, key=key, what=what, source="astro_timeline", **kw)
    e["kind"] = kind
    return e


def _sign_ingresses(name: str, body: int) -> list[dict]:
    out = []
    for s in range(12):
        for x in T.find_crossings(lambda jd, b=body, s=s: T.signed_diff(_lon(jd, b), s * 30.0), J0, J1):
            back = _spd(x, body) < 0
            sign = T.SIGNS[(s - 1) % 12] if back else T.SIGNS[s]
            house = T.house_of((s * 30.0 - 0.01) % 360 if back else s * 30.0 + 0.01)
            out.append(_ev("ingress", "sign_ingress", name, x, "sign", f"Transiting {name} in {sign}",
                           f"{name} {'backs into' if back else 'enters'} {sign} (your {T.ordinal(house)} house)",
                           target_body=None, extra={"retrograde": back, "sign": sign, "house": house}))
    return out


def _house_ingresses(name: str, body: int) -> list[dict]:
    out = []
    for i, cusp in enumerate(T.CUSPS):
        for x in T.find_crossings(lambda jd, b=body, c=cusp: T.signed_diff(_lon(jd, b), c), J0, J1):
            back = _spd(x, body) < 0
            house = i if back else i + 1          # cusp i (0-based) opens house i+1
            house = 12 if house == 0 else house
            out.append(_ev("ingress", "house_ingress", name, x, "house", f"Transiting {name} in the {T.ordinal(house)} house",
                           f"{name} {'backs into' if back else 'crosses into'} your {T.ordinal(house)} house",
                           target_body=None, extra={"retrograde": back, "house": house}))
    return out


def _stamp_series(evs: list[dict], body: str, orb: float, moving_frame: str = "transit") -> None:
    """Group one target point's crossings into retrograde-loop series; stamp pass i of n, the
    FIRST/RETROGRADE/FINAL label, direction and each pass's in-orb window (canonical fields)."""
    gap = E.PASS_GAP_DAYS.get(body, 600) if moving_frame == "transit" else 365.25 * 40
    evs.sort(key=lambda e: e["exact_jd"])
    runs, cur = [], []
    for e in evs:
        if cur and e["exact_jd"] - cur[-1]["exact_jd"] > gap:
            runs.append(cur); cur = []
        cur.append(e)
    if cur:
        runs.append(cur)
    for run in runs:
        n = len(run)
        for i, e in enumerate(run, 1):
            rx = e["retrograde"]
            e.update({"pass_number": i, "pass_total": n, "pass_label": E.pass_label(i, n, rx)})
            if n > 1:
                e["pass"] = f"{i} of {n}"
                e["rx"] = rx
                e["what"] += f" (pass {i} of {n}{', retrograde' if rx else ''})"
            e["passes"] = [{"pass_number": k, "exact_at_local": r["exact_at_local"], "retrograde": r["retrograde"],
                            "pass_label": E.pass_label(k, n, r["retrograde"])} for k, r in enumerate(run, 1)]


def _exact_aspects(name: str, body: int) -> list[dict]:
    out = []
    orb = T.ORB.get(name, 1.0)
    for npt in NATAL_POINTS:
        target = natal_lon(npt)
        for asp in BODY_ASPECTS[name]:
            for pt in E.target_points(target, asp):
                f = lambda jd, b=body, t=pt: T.signed_diff(_lon(jd, b), t)
                series = []
                for x in T.find_crossings(f, JLB, JLA):
                    lon = _lon(x, body)
                    w0, w1 = E._window(f, x, orb, 400, 1.0)
                    e = _ev("transit", "aspect", name, x, "aspect", f"Transiting {name} {asp} natal {npt}",
                            f"{name} exactly {asp} your natal {npt}", target_body=npt, aspect=asp,
                            extra={"retrograde": _spd(x, body) < 0, "moving_degree": T.dms(lon),
                                   "target_degree": T.dms(target), "orb": 0.0, "orb_allowed": orb, "motion": "exact",
                                   "house": T.house_of(lon), "target_house": T.house_of(target),
                                   "window_start": T.local_date(w0).isoformat(), "window_end": T.local_date(w1).isoformat()})
                    e["t_house"] = e["house"]
                    series.append(e)
                _stamp_series(series, name, orb)
                out += series
    return out


def _prog_f(body: str, point: float):
    return lambda jd: T.signed_diff(T.progressed_lon(jd, body), point)


def _progressed_ingresses() -> list[dict]:
    """Progressed Moon/Venus sign + Placidus-house ingresses, found by bisection on the real target
    instant and dated from that instant in ET (the 03:46-UT daily sample made these +1 day)."""
    out = []
    for body in PROG_INGRESS_BODIES:
        for s in range(12):
            for x in T.find_crossings(_prog_f(body, s * 30.0), J0, J1, step=2.0):
                back = T.lon_speed(T.progressed_jd(x), body)[1] < 0
                sign = T.SIGNS[(s - 1) % 12] if back else T.SIGNS[s]
                out.append(_ev("progression", "sign_ingress", body, x, "progressed", f"Progressed {body} in {sign}",
                               f"Progressed {body} enters {sign}", moving_frame="progressed", target_body=None,
                               extra={"retrograde": back, "sign": sign}))
        for i, cusp in enumerate(T.CUSPS):
            for x in T.find_crossings(_prog_f(body, cusp), J0, J1, step=2.0):
                back = T.lon_speed(T.progressed_jd(x), body)[1] < 0
                house = i if back else i + 1
                house = 12 if house == 0 else house
                out.append(_ev("progression", "house_ingress", body, x, "progressed", f"Progressed {body} in the {T.ordinal(house)} house",
                               f"Progressed {body} enters your {T.ordinal(house)} house", moving_frame="progressed",
                               target_body=None, extra={"retrograde": back, "house": house}))
    return out


def _progressed_aspects() -> list[dict]:
    out = []
    for body, asps in PROG_ASPECT_BODIES.items():
        for npt in NATAL_POINTS:
            target = natal_lon(npt)          # progressed Moon → natal Moon counts (the lunar cycle)
            for asp in asps:
                for pt in E.target_points(target, asp):
                    for x in T.find_crossings(_prog_f(body, pt), J0, J1, step=2.0):
                        e = _ev("progression", "aspect", body, x, "progressed", f"Progressed {body} {asp} natal {npt}",
                                f"Progressed {body} exactly {asp} your natal {npt}", moving_frame="progressed",
                                target_body=npt, aspect=asp,
                                extra={"retrograde": T.lon_speed(T.progressed_jd(x), body)[1] < 0, "orb": 0.0,
                                       "motion": "exact", "target_house": T.house_of(target),
                                       "moving_degree": T.dms(T.progressed_lon(x, body)), "target_degree": T.dms(target)})
                        out.append(e)
    return out


# ── transits → progressed points, sky-to-sky ────────────────────────────────
PROG_TARGETS = ["Sun", "Moon", "Mercury", "Venus"]
SKY_PAIRS_BODIES = ["Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"]


def _transits_to_progressed() -> list[dict]:
    out = []
    for name in ("Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"):
        body = SLOW[name]
        for pt in PROG_TARGETS:
            for asp in ("conjunct", "square", "opposite"):
                deg = ASPECTS[asp]
                for a in ({deg} if deg in (0, 180) else {deg, 360 - deg}):
                    f = lambda jd, b=body, p=pt, a=a: T.signed_diff(_lon(jd, b), (T.progressed_lon(jd, p) + a) % 360)
                    for x in T.find_crossings(f, J0, J1):
                        out.append(_ev("transit", "aspect_to_progressed", name, x, "to_progressed",
                                       f"Transiting {name} {asp} progressed {pt}", f"{name} exactly {asp} your progressed {pt}",
                                       target_body=pt, target_frame="progressed", aspect=asp,
                                       extra={"retrograde": _spd(x, body) < 0, "orb": 0.0, "motion": "exact"}))
    return out


def _sky_aspects() -> list[dict]:
    """Slow-body sky-to-sky aspects (mundane), with the house of each body for Mike."""
    out = []
    for i, a_name in enumerate(SKY_PAIRS_BODIES):
        for b_name in SKY_PAIRS_BODIES[i + 1:]:
            ab, bb = SLOW[a_name], SLOW[b_name]
            for asp in ("conjunct", "square", "opposite", "trine"):
                deg = ASPECTS[asp]
                for a in ({deg} if deg in (0, 180) else {deg, 360 - deg}):
                    f = lambda jd, ab=ab, bb=bb, a=a: T.signed_diff(_lon(jd, ab), (_lon(jd, bb) + a) % 360)
                    for x in T.find_crossings(f, J0, J1):
                        da, db = T.describe(_lon(x, ab)), T.describe(_lon(x, bb))
                        out.append(_ev("sky", "aspect", a_name, x, "sky", f"{a_name} {asp} {b_name} (sky)",
                                       f"{a_name} {da['deg']}° {da['sign']} (your {T.ordinal(da['house'])}) {asp} {b_name} {db['deg']}° {db['sign']} (your {T.ordinal(db['house'])}) — sky aspect",
                                       target_body=b_name, target_frame="transit", aspect=asp, extra={"other": b_name}))
    return out


def _eclipses() -> list[dict]:
    out = []
    try:
        import astro_sky
        for e in astro_sky.eclipses(START, (END - START).days):
            x = T.jd_for(datetime.fromisoformat(e["date_et"]))
            base = f"{e['type'].capitalize()} {e['kind']} eclipse at {e['deg']}° {e['sign']} (your {T.ordinal(e['house'])} house)"
            hits = e.get("natal_hits") or [None]
            for h in hits:
                key = (f"{e['kind'].capitalize()} eclipse {h['aspect']} natal {h['natal']}" if h
                       else f"{e['kind'].capitalize()} eclipse in the {T.ordinal(e['house'])} house")
                ev = _ev("eclipse", e["type"], e["kind"], x, "eclipse", key,
                         base + (f" — {h['aspect']} your natal {h['natal']} (orb {h['orb']:.1f}°)" if h else ""),
                         target_body=h["natal"] if h else None, aspect=h["aspect"] if h else None,
                         extra={"house": e["house"]})
                if h:
                    ev["alt_key"] = f"{e['kind'].capitalize()} eclipse in the {T.ordinal(e['house'])} house"
                out.append(ev)
    except Exception as ex:
        out.append({"date": START.isoformat(), "kind": "error", "body": "eclipse", "key": "", "what": f"eclipses unavailable: {ex}"})
    return out


def _solar_arcs() -> list[dict]:
    """Solar-arc hits: real instant from the root finder, dated in ET; shown to the day (no clock time)."""
    out = []
    try:
        import astro_returns
        for h in astro_returns.solar_arc_hits(START, years=6):
            e = E.make_event("solar_arc", "aspect", "arc", None, target_body=None, key=h["what"], what=h["what"], source="astro_returns")
            e.update({"local_date": h["date"], "date": h["date"], "kind": "arc", "precision": "day"})
            e["event_id"] = f"solar_arc:{h['date']}:{re.sub(r'[^A-Za-z]+', '.', h['what'])[:60]}"
            out.append(e)
    except Exception as ex:
        out.append({"date": START.isoformat(), "kind": "error", "body": "arc", "key": "", "what": f"solar arc unavailable: {ex}"})
    return out


def build() -> list[dict]:
    ev = []
    for name, body in SLOW.items():
        ev += _sign_ingresses(name, body) + _house_ingresses(name, body) + _exact_aspects(name, body)
    ev += (_progressed_ingresses() + _progressed_aspects() + _transits_to_progressed() + _sky_aspects()
           + _eclipses() + _solar_arcs())
    ev = [e for e in ev if e["kind"] != "error"] + [e for e in ev if e["kind"] == "error"]
    # lookback / look-ahead hits only served the numbering; solar arcs are capped at END too
    ev = [e for e in ev if START.isoformat() <= e["date"] <= END.isoformat()]
    ev.sort(key=lambda e: (e["date"], e.get("exact_at_local") or "", e["kind"], e["body"]))
    meta = E.cache_meta("astro_timeline.build (Swiss Ephemeris, Placidus)", VALID_DAYS)
    tmp = CACHE.with_suffix(f".{os.getpid()}.tmp")            # review B9: atomic replace
    tmp.write_text(json.dumps({"meta": meta, "built": meta["generated_at"], "start": START.isoformat(),
                               "end": END.isoformat(), "events": ev}, indent=1))
    tmp.replace(CACHE)
    return ev


def load(max_age_days: int = VALID_DAYS) -> list[dict]:
    """Cached events; rebuilt when expired, when the engine code changed, or on schema change."""
    if CACHE.exists():
        try:
            data = json.loads(CACHE.read_text())
            ok, _why = E.cache_fresh(data.get("meta"))
            if ok:
                return data["events"]
        except Exception:
            pass
    return build()


def meta() -> dict:
    try:
        return json.loads(CACHE.read_text()).get("meta", {})
    except Exception:
        return {}


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
        c = c.split(" (Esoteric:")[0].split(": ", 1)[-1]
    else:
        c = _generic(e)
    if e.get("moving_frame") == "progressed" and e.get("body"):
        c = c.replace(f"Transiting {e['body']} (", f"Your progressed {e['body']} (")
    return c


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
            nl, b = natal_lon(e["natal"]), e["body"]     # review C7: the progressed body, never "Transiting"
            return (lex.translate_hit({"t": b, "n": e["natal"], "aspect": e["aspect"]}, nl, nl)
                    .replace(f"Transiting {b} (", f"Your progressed {b} (").replace(f"In plain terms: {b} (", f"Your progressed {b} (")
                    .replace("In plain terms: ", ""))
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
    return d.strftime("%b %-d %Y") if d.year != T.today_local().year else d.strftime("%b %-d")


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


def next_block(now: datetime | None = None, hours: int = 48, skip: set | None = None, limit: int = 6) -> str:
    """What goes exact in the NEXT `hours` (forward-looking, local ET time + pass context) — the
    daily send's timing section. `skip` = {(body, aspect, natal)} already shown as a live hit."""
    now = now or T.now_local()
    lo, hi = now.isoformat(), (now + timedelta(hours=hours)).isoformat()
    ev = [e for e in load() if e.get("exact_at_local") and lo <= e["exact_at_local"] <= hi
          and not (skip and (e["body"], e.get("aspect"), e.get("natal")) in skip)]
    ev += [e for e in load() if not e.get("exact_at_local") and now.date().isoformat() <= e["date"]
           <= (now + timedelta(hours=hours)).date().isoformat()]
    if not ev:
        return ""
    ev.sort(key=lambda e: e.get("exact_at_local") or e["date"])
    lines = [f"🗓 Exact in the next {hours}h:"]
    for e in ev[:limit]:
        m = _meaning(e)
        lines.append(f"{_glyph(e)} {E.when_label(e, now.date())}: {e['what']}" + (f" — {m}" if m else ""))
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
    elif cmd == "next":
        print(next_block(hours=int(a[1]) if len(a) > 1 else 48) or "Nothing exact in that window.")
    elif cmd == "year":
        print(year_block())
    elif cmd == "key":
        ent = lex.kb_entry(" ".join(a[1:]))
        print(json.dumps(ent, indent=1) if ent else "no researched entry for that key")
    else:
        days = int(a[1]) if len(a) > 1 and a[1].isdigit() else (int(cmd) if cmd.isdigit() else 30)
        print(upcoming_block(days=days, full="full" in a))
