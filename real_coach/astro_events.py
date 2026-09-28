#!/usr/bin/env python3
"""astro_events.py — the canonical astrology EVENT model + timing / priority / theme synthesis.

Pipeline:  astro_truth (Swiss Ephemeris math)  →  THIS module (canonical events, motion, passes,
lifecycle, priority, themes)  →  formatters (daily_transits, svehla weekly, alerts, calendar,
live page, free-chat facts).  Formatters never recompute geometry; they read these dicts.

CANONICAL EVENT (one dict shape everywhere; legacy alias keys date/kind/body/natal/key/what are
kept so older formatters keep working):
  event_id, event_type (transit|progression|ingress|sky|eclipse|solar_arc|synastry|progressed_synastry),
  subtype (aspect|sign_ingress|house_ingress|...), moving_body, moving_frame (transit|progressed|natal),
  target_body, target_frame, aspect, aspect_deg, moving_degree, target_degree, orb, orb_allowed,
  motion (applying|exact|separating|stationary), retrograde, exact_at_utc, exact_at_local, local_date,
  timezone, house, target_house, pass_number, pass_total, pass_label, passes[], window_start,
  window_end, lifecycle (NEW|BUILDING|EXACT|SEPARATING|ONGOING), changed, priority, priority_reasons,
  priority_features, source, calculated_at, freshness.

MOTION (never from one static orb): signed distance d = lon − exact point; the body's own
instantaneous ephemeris speed v (negative when retrograde). |d| shrinks iff d·v < 0 → applying.
A body whose speed changes sign within ±1 day is STATIONARY. |d| ≤ 0.02° or the exact instant within
±1 h → EXACT. Works through retrogrades, stations, the 0°/360° wrap (folded distance) and the Moon.

PASSES: all exact crossings of the same moving body over the same target point, clustered while the
gap between consecutive crossings ≤ PASS_GAP_DAYS[body] (a retrograde loop). Labels: FIRST PASS,
RETROGRADE PASS / DIRECT PASS, FINAL PASS (single crossings are unlabeled).

PRIORITY: integer points from named, documented features (PRIORITY_POINTS) — every point comes with
a human-readable reason; no hidden weights, no probabilities.
"""
from __future__ import annotations

import hashlib
import json
from datetime import date, datetime, timedelta
from pathlib import Path

import astro_truth as T

HERE = Path(__file__).resolve().parent
SCHEMA_VERSION = 2
ASPECT_DEG = {"conjunct": 0, "sextile": 60, "square": 90, "trine": 120, "opposite": 180}
GLYPH = {"conjunct": "☌", "sextile": "﹡", "square": "□", "trine": "△", "opposite": "☍"}
ANGLE_POINTS = ("ASC", "MC", "DSC", "IC")
LUMINARIES = ("Sun", "Moon")
PERSONAL = ("Mercury", "Venus", "Mars")
TNP = ("Hades", "Apollon")
SPEED_CLASS = {"Moon": "moon", "Sun": "fast", "Mercury": "fast", "Venus": "fast", "Mars": "medium",
               "Ceres": "medium", "Juno": "medium", "Jupiter": "slow", "Saturn": "slow", "Uranus": "slow",
               "Neptune": "slow", "Pluto": "slow", "Chiron": "slow"}
PASS_GAP_DAYS = {"Moon": 0, "Sun": 0, "Mercury": 60, "Venus": 100, "Mars": 200}   # others: 600
SCAN_STEP = {"Moon": 1 / 24, "Sun": 0.5, "Mercury": 0.5, "Venus": 0.5, "Mars": 1.0}
HORIZON = {"Moon": 3, "Sun": 40, "Mercury": 120, "Venus": 200, "Mars": 400}         # others: 800
TRANSIT_BODIES = [b for b in T.BODIES if b not in TNP]
NATAL_TARGETS = list(T.BODIES) + ["ASC", "MC", "DSC"]
HARD = ("square", "opposite")
BENEFIC = ("Venus", "Jupiter", "Sun")
PRIORITY_POINTS = {           # the whole ranking model — every point is a named, explained feature
    "exact_today": (3, "exact today"),
    "applying": (1, "applying (still building)"),
    "strong_orb": (1, "within a strong orb (≤25% of allowed)"),
    "slow": (3, "slow-moving transit (weeks to months)"),
    "medium": (1, "medium-speed body (days to weeks)"),
    "moon": (-2, "fast Moon (hours)"),
    "angle": (2, "angular target (ASC/MC/DSC)"),
    "luminary": (2, "Sun/Moon target"),
    "chart_ruler": (1, "chart ruler target"),
    "personal": (1, "personal-planet target"),
    "major": (1, "major aspect"),
    "multi_pass": (1, "part of a multi-pass series"),
    "svehla_active": (2, "matches an active window from the Aug 2026 reading"),
    "svehla": (1, "a thread of the Aug 2026 reading"),
    "profection": (1, "touches the profection-year house or lord"),
    "progression": (2, "progression involved (slow, months-long)"),
    "new": (1, "newly in orb"),
    "theme": (1, "corroborated by a multi-factor theme"),
}
HOUSE_THEME = {1: "identity", 2: "finances/resources", 3: "communication", 4: "home/family",
               5: "creativity", 6: "health/routines", 7: "relationships", 8: "finances/resources",
               9: "learning/travel", 10: "career/public direction", 11: "social/community",
               12: "introspection"}
POINT_THEME = {"Venus": "relationships", "Juno": "relationships", "DSC": "relationships",
               "Mercury": "communication", "MC": "career/public direction", "ASC": "identity",
               "Sun": "identity", "Moon": "home/family", "IC": "home/family", "Ceres": "health/routines"}
WINDOW_THEME = {"money": "finances/resources", "career": "career/public direction",
                "relationship": "relationships", "psyche": "introspection"}
THEME_LABEL = {t: t.split("/")[0].capitalize() + ("/" + t.split("/")[1] if "/" in t else "")
               for t in set(HOUSE_THEME.values()) | set(POINT_THEME.values())}


# ── geometry helpers ──────────────────────────────────────────────────────────
def natal_lon(point: str) -> float:
    if point in T.ANGLES:
        return T.ANGLES[point]
    return T.lon_speed(T.NATAL_JD, point)[0]


def target_points(target_lon: float, aspect: str) -> list[float]:
    a = ASPECT_DEG[aspect]
    if a == 0:
        return [target_lon % 360]
    if a == 180:
        return [(target_lon + 180) % 360]
    return [(target_lon + a) % 360, (target_lon - a) % 360]


def _diff_fn(body: str, point: float, moving_frame: str = "transit", natal_jd: float = T.NATAL_JD):
    if moving_frame == "progressed":
        return lambda jd: T.signed_diff(T.progressed_lon(jd, body, natal_jd), point)
    return lambda jd: T.signed_diff(T.lon_speed(jd, body)[0], point)


def _speed(body: str, jd: float, moving_frame: str = "transit", natal_jd: float = T.NATAL_JD) -> float:
    if moving_frame == "progressed":
        return T.lon_speed(T.progressed_jd(jd, natal_jd), body)[1] / T.PROG_YEAR
    return T.lon_speed(jd, body)[1]


def is_stationary(body: str, jd: float, moving_frame: str = "transit") -> bool:
    if body in ("Sun", "Moon") and moving_frame == "transit":
        return False
    span = 1.0 if moving_frame == "transit" else 365.25       # ±1 day, or ±1 year of progression
    a, b = _speed(body, jd - span, moving_frame), _speed(body, jd + span, moving_frame)
    return (a < 0) != (b < 0)


def motion_state(body: str, jd: float, point: float, moving_frame: str = "transit",
                 exact_jd: float | None = None) -> str:
    d = _diff_fn(body, point, moving_frame)(jd)
    if abs(d) <= 0.02 or (exact_jd is not None and abs(jd - exact_jd) <= 1 / 24):
        return "exact"
    if is_stationary(body, jd, moving_frame):
        return "stationary"
    return "applying" if d * _speed(body, jd, moving_frame) < 0 else "separating"


def pass_label(i: int, n: int, rx: bool) -> str | None:
    if n <= 1:
        return None
    if i == 1:
        return "FIRST PASS"
    if i == n:
        return "FINAL PASS"
    return "RETROGRADE PASS" if rx else "DIRECT PASS"


def _window(f, jd: float, orb: float, span: float, step: float) -> tuple[float, float]:
    """In-orb interval containing jd (|f| ≤ orb), searched ±span days."""
    g = lambda j: abs(f(j)) - orb
    back = T.find_crossings(g, jd - span, jd, step)
    fwd = T.find_crossings(g, jd, jd + span, step)
    return (back[-1] if back else jd - span, fwd[0] if fwd else jd + span)


def pass_series(body: str, point: float, jd: float, orb: float, moving_frame: str = "transit",
                natal_jd: float = T.NATAL_JD) -> list[dict]:
    """The retrograde-loop series of exact crossings over `point` nearest to jd, each with its
    local time, direction, pass index/label and in-orb window."""
    f = _diff_fn(body, point, moving_frame, natal_jd)
    if moving_frame == "progressed":
        span, step, gap = 365.25 * 6, 5.0, 365.25 * 40
    else:
        span, step, gap = HORIZON.get(body, 800), SCAN_STEP.get(body, 1.0), PASS_GAP_DAYS.get(body, 600)
    xs = T.find_crossings(f, jd - span, jd + span, step)
    if not xs:
        return []
    clusters, cur = [], [xs[0]]
    for x in xs[1:]:
        if x - cur[-1] <= gap:
            cur.append(x)
        else:
            clusters.append(cur); cur = [x]
    clusters.append(cur)
    best = min(clusters, key=lambda c: 0 if c[0] - 1 <= jd <= c[-1] + 1 else min(abs(jd - c[0]), abs(jd - c[-1])))
    out = []
    for i, x in enumerate(best, 1):
        rx = _speed(body, x, moving_frame, natal_jd) < 0
        w0, w1 = _window(f, x, orb, min(span, 400 if moving_frame == "transit" else 365.25 * 3), step)
        out.append({"pass_number": i, "pass_total": len(best), "pass_label": pass_label(i, len(best), rx),
                    "exact_jd": x, "exact_at_utc": T.jd_to_utc(x).isoformat(),
                    "exact_at_local": T.jd_to_local(x).isoformat(), "local_date": T.local_date(x).isoformat(),
                    "retrograde": rx, "window_start": T.local_date(w0).isoformat(),
                    "window_end": T.local_date(w1).isoformat(), "window_start_jd": w0, "window_end_jd": w1})
    return out


# ── canonical event constructor ───────────────────────────────────────────────
def make_event(event_type: str, subtype: str, moving_body: str, exact_jd: float | None = None, *,
               moving_frame: str = "transit", target_body: str | None = None, target_frame: str | None = "natal",
               aspect: str | None = None, what: str = "", key: str = "", source: str = "astro_events",
               extra: dict | None = None) -> dict:
    now = T.now_local()
    e = {"event_type": event_type, "subtype": subtype, "moving_body": moving_body, "moving_frame": moving_frame,
         "target_body": target_body, "target_frame": target_frame if target_body else None,
         "aspect": aspect, "aspect_deg": ASPECT_DEG.get(aspect) if aspect else None,
         "moving_degree": None, "target_degree": None, "orb": None, "motion": None, "retrograde": None,
         "exact_at_utc": None, "exact_at_local": None, "local_date": None, "timezone": T.TZ_NAME,
         "house": None, "target_house": None, "pass_number": None, "pass_total": None, "pass_label": None,
         "window_start": None, "window_end": None, "priority_features": {}, "source": source,
         "calculated_at": now.isoformat(timespec="seconds"), "freshness": {}}
    if exact_jd is not None:
        e["exact_at_utc"] = T.jd_to_utc(exact_jd).isoformat()
        e["exact_at_local"] = T.jd_to_local(exact_jd).isoformat()
        e["local_date"] = T.local_date(exact_jd).isoformat()
        e["exact_jd"] = round(exact_jd, 6)
    if extra:
        e.update(extra)
    tgt = f"{target_frame or ''} {target_body}".strip() if target_body else ""
    e["event_id"] = ":".join(str(x) for x in (event_type, moving_frame, moving_body, aspect or subtype,
                                              tgt.replace(" ", "."), e["local_date"] or "") if x)
    # legacy aliases (older formatters/calendar key off these)
    e.setdefault("date", e["local_date"])
    e.setdefault("body", moving_body)
    if target_body:
        e.setdefault("natal", target_body if target_frame == "natal" else f"{target_frame} {target_body}")
    e["key"] = key or e.get("key", "")
    e["what"] = what or e.get("what", "")
    return e


def when_label(e: dict, today: date | None = None, with_time: bool = True) -> str:
    """'today 3:40 PM' / 'yesterday 3:40 PM' / 'Feb 17 2027 11:51 PM' — always from the localized instant."""
    today = today or T.today_local()
    if not e.get("exact_at_local"):
        return e.get("local_date") or e.get("date") or ""
    t = T.round_minute(datetime.fromisoformat(e["exact_at_local"]))
    n = (t.date() - today).days
    day = {0: "today", -1: "yesterday", 1: "tomorrow"}.get(n)
    if day is None:
        day = t.strftime("%b %-d") if t.year == today.year else t.strftime("%b %-d %Y")
    if day == "today" and with_time and t.hour >= 18:
        day = "tonight"
    return f"{day} {t:%-I:%M %p}" if with_time and e.get("moving_frame") != "progressed" else day


# ── live transits (what is in orb NOW) ────────────────────────────────────────
def _svehla_fit(t: str, n: str, d: date) -> str:
    try:
        import svehla
        return svehla.fit_for(t, n, d)
    except Exception:
        return ""


def _profection(d: date | None = None) -> dict:
    try:
        import astro_timing
        return astro_timing.profection(d or T.today_local())
    except Exception:
        return {}


def lifecycle(e: dict, now_jd: float) -> str:
    today = T.local_date(now_jd)
    if e.get("local_date") == today.isoformat() and e.get("exact_at_local"):
        return "EXACT"
    ws = e.get("window_start_jd")
    if ws is not None and ws > now_jd - 1.0:
        return "NEW"
    if e.get("motion") == "stationary":
        return "ONGOING"
    we = e.get("window_end_jd")
    if ws is not None and we is not None and we - ws > 45 and abs(now_jd - (e.get("exact_jd") or now_jd)) > 3:
        return "ONGOING"
    return "BUILDING" if e.get("motion") == "applying" else "SEPARATING"


def priority(e: dict, prof: dict | None = None) -> tuple[int, list[str], dict]:
    feats: dict[str, bool] = {}
    t, n, cls = e["moving_body"], e.get("target_body"), SPEED_CLASS.get(e["moving_body"], "slow")
    feats["exact_today"] = e.get("lifecycle") == "EXACT"
    feats["applying"] = e.get("motion") == "applying"
    feats["strong_orb"] = e.get("orb") is not None and e.get("orb_allowed") and e["orb"] <= 0.25 * e["orb_allowed"]
    feats["slow"] = cls == "slow" and e.get("moving_frame") == "transit"
    feats["medium"] = cls == "medium" and e.get("moving_frame") == "transit"
    feats["moon"] = t == "Moon" and e.get("moving_frame") == "transit"
    feats["angle"] = n in ANGLE_POINTS
    feats["luminary"] = n in LUMINARIES
    feats["chart_ruler"] = n == T.CHART_RULER
    feats["personal"] = n in PERSONAL
    feats["major"] = e.get("aspect") in ("conjunct", "opposite", "square", "trine")
    feats["multi_pass"] = (e.get("pass_total") or 1) > 1
    fit = e.get("svehla_fit") or ""
    feats["svehla_active"] = "(active window)" in fit
    feats["svehla"] = bool(fit) and not feats["svehla_active"]
    prof = prof or {}
    feats["profection"] = bool(prof) and (n == prof.get("lord") or e.get("target_house") == prof.get("house"))
    feats["progression"] = e.get("moving_frame") == "progressed" or e.get("target_frame") == "progressed"
    feats["new"] = e.get("lifecycle") == "NEW"
    feats["theme"] = bool(e.get("theme_corroborated"))
    score, reasons = 0, []
    for k, on in feats.items():
        if on:
            pts, why = PRIORITY_POINTS[k]
            score += pts
            reasons.append(f"{why} ({'+' if pts >= 0 else ''}{pts})")
    if n in TNP:
        reasons.append("Uranian point — tradition-dependent (+0)")
    if e.get("aspect") == "sextile":
        reasons.append("sextile — softer major aspect (+0)")
    return score, reasons, feats


def current_transits(when: datetime | None = None, with_passes: bool = True) -> list[dict]:
    """Every transit→natal aspect inside ORB right now, as canonical events with motion, exact time,
    pass series, window, lifecycle and priority — ranked by priority (orb breaks ties)."""
    when = when or T.now_local()
    jd = T.jd_for(when)
    today = when.astimezone(T.ET).date()
    prof = _profection(today)
    events = []
    for t in TRANSIT_BODIES:
        lon, spd = T.lon_speed(jd, t)
        for n in NATAL_TARGETS:
            if t == "Moon" and n not in ("Sun", "Moon", "ASC", "MC", "DSC"):
                continue                              # Moon noise: only luminaries + angles
            if n == "DSC" and t not in ("Juno", "Venus", "Saturn", "Mars"):
                continue                              # DSC only matters for the partnership bodies
            nl = natal_lon(n)
            for asp in ASPECT_DEG:
                pts = target_points(nl, asp)
                d, pt = min(((T.signed_diff(lon, p), p) for p in pts), key=lambda x: abs(x[0]))
                orb_allowed = T.ORB.get(t, 1.0)
                if abs(d) > orb_allowed:
                    continue
                e = make_event("transit", "aspect", t, None, target_body=n, aspect=asp,
                               key=f"Transiting {t} {asp} natal {n}",
                               what=f"{t} {asp} your natal {n}", source="astro_events.current_transits")
                e.update({"orb": round(abs(d), 3), "signed_orb": round(d, 4), "orb_allowed": orb_allowed,
                          "moving_degree": T.dms(lon), "target_degree": T.dms(nl), "retrograde": spd < 0,
                          "speed": round(spd, 5), "house": T.house_of(lon), "target_house": T.house_of(nl),
                          "sign": T.SIGNS[int(lon // 30)], "target_point": pt})
                series = pass_series(t, pt, jd, orb_allowed) if with_passes else []
                inwin = [p for p in series if p["window_start_jd"] - 0.01 <= jd <= p["window_end_jd"] + 0.01]
                motion = motion_state(t, jd, pt)
                if inwin:
                    # applying → the next exact in this window; otherwise the most recent one
                    fut = [p for p in inwin if p["exact_jd"] >= jd]
                    past = [p for p in inwin if p["exact_jd"] < jd]
                    cur = (fut[0] if fut else past[-1]) if motion in ("applying", "stationary") else (past[-1] if past else fut[0])
                    motion = motion_state(t, jd, pt, exact_jd=cur["exact_jd"]) if motion != "stationary" else motion
                    e.update({k: cur[k] for k in ("exact_at_utc", "exact_at_local", "local_date", "pass_number",
                                                  "pass_total", "pass_label", "window_start", "window_end",
                                                  "window_start_jd", "window_end_jd", "exact_jd")})
                    e["date"] = e["local_date"]
                    e["exact_retrograde"] = cur["retrograde"]
                    e["passes"] = [{k: v for k, v in p.items() if not k.endswith("_jd")} for p in series]
                else:
                    # in orb without an exact crossing in this stretch (a retrograde near-miss, or a
                    # long approach): the live in-orb window, and the nearest series as context
                    f = _diff_fn(t, pt)
                    w0, w1 = _window(f, jd, orb_allowed, HORIZON.get(t, 800) / 2, SCAN_STEP.get(t, 1.0))
                    e.update({"window_start": T.local_date(w0).isoformat(), "window_end": T.local_date(w1).isoformat(),
                              "window_start_jd": w0, "window_end_jd": w1, "no_exact_this_window": True})
                    if series:
                        e["passes"] = [{k: v for k, v in p.items() if not k.endswith("_jd")} for p in series]
                e["motion"] = motion
                e["event_id"] = f"transit:{t}:{asp}:natal.{n}:{e.get('local_date') or today.isoformat()}"
                e["lifecycle"] = lifecycle(e, jd)
                # yesterday, same clock time: what changed?
                yj = jd - 1.0
                yd = T.signed_diff(T.lon_speed(yj, t)[0], pt)
                if abs(yd) > orb_allowed:
                    e["changed"] = "entered orb since yesterday"
                else:
                    ym = motion_state(t, yj, pt)
                    if ym != motion and motion != "exact":
                        e["changed"] = f"was {ym} yesterday, now {motion}"
                e["svehla_fit"] = _svehla_fit(t, n, today)
                events.append(e)
    # the ASC–DSC axis is one point: drop "X opposite ASC" when "X conjunct DSC" is present
    dsc = {e["moving_body"] for e in events if e["target_body"] == "DSC" and e["aspect"] == "conjunct"}
    events = [e for e in events if not (e["target_body"] == "ASC" and e["aspect"] == "opposite" and e["moving_body"] in dsc)]
    th = themes(events, d=today)
    corroborated = {ev for t_ in th for ev in t_["event_ids"] if len(t_["supporting_factors"]) + len(t_["conflicting_factors"]) >= 3}
    for e in events:
        e["theme_corroborated"] = e["event_id"] in corroborated
        e["priority"], e["priority_reasons"], e["priority_features"] = priority(e, prof)
    events.sort(key=lambda e: (-e["priority"], e["orb"]))
    return events


# ── theme synthesis (deterministic, evidence-carrying) ────────────────────────
FAST_BODIES = ("Sun", "Mercury", "Venus", "Mars")
FAST_TARGETS = [b for b in T.BODIES if b not in TNP and b not in ("Ceres", "Juno")] + ["ASC", "MC"]


def fast_exacts(jd0: float, jd1: float) -> list[dict]:
    """Sun/Mercury/Venus/Mars exact aspects to the natal planets + ASC/MC in [jd0, jd1) — the inner-
    planet hits the (slow-body) timeline cache doesn't carry. Same root finder, same event model."""
    out = []
    for b in FAST_BODIES:
        for n in FAST_TARGETS:
            for a in ASPECT_DEG:
                for pt in target_points(natal_lon(n), a):
                    for jx in T.find_crossings(_diff_fn(b, pt), jd0, jd1, step=0.25):
                        e = make_event("transit", "aspect", b, jx, target_body=n, aspect=a,
                                       what=f"{b} exactly {a} your natal {n}",
                                       key=f"Transiting {b} {a} natal {n}", source="astro_events.fast_exacts")
                        e["retrograde"] = _speed(b, jx) < 0
                        out.append(e)
    out.sort(key=lambda e: e["exact_jd"])
    return out


def _tone(e: dict) -> str:
    if e.get("aspect") in HARD:
        return "challenging"
    if e.get("aspect") == "conjunct":
        return "supportive" if e["moving_body"] in BENEFIC else "challenging" if e["moving_body"] in (
            "Saturn", "Mars", "Pluto", "Uranus", "Neptune", "Chiron") else "neutral"
    return "supportive"


def themes(events: list[dict], extra_factors: list[dict] | None = None, include_context: bool = True,
           d: date | None = None) -> list[dict]:
    """Group events that independently point at the same life domain. Each factor names WHY it maps
    (the natal house of the target, the target point itself, a Svehla window, profection, pMoon)."""
    buckets: dict[str, dict] = {}

    def add(theme: str, factor: dict):
        b = buckets.setdefault(theme, {"theme": theme, "label": THEME_LABEL.get(theme, theme), "factors": [],
                                       "event_ids": set(), "timing": {}, "missing": []})
        if factor.get("event_id") and factor["event_id"] in b["event_ids"]:
            return                                    # one event counts once per theme
        b["factors"].append(factor)
        if factor.get("event_id"):
            b["event_ids"].add(factor["event_id"])
            if factor.get("exact_at_local"):
                b["timing"].setdefault("exacts", []).append({"event": factor["label"], "exact_at_local": factor["exact_at_local"]})
            if factor.get("window_end"):
                b["timing"].setdefault("windows", []).append({"event": factor["label"], "start": factor.get("window_start"), "end": factor["window_end"]})

    for e in events:
        n = e.get("target_body")
        label = f"{'progressed ' if e.get('moving_frame') == 'progressed' else 'transiting '}{e['moving_body']} {e.get('aspect')} natal {n}"
        base = {"event_id": e["event_id"], "label": label, "tone": _tone(e), "exact_at_local": e.get("exact_at_local"),
                "window_start": e.get("window_start"), "window_end": e.get("window_end"),
                "tradition_dependent": n in TNP}
        if e.get("target_house"):
            add(HOUSE_THEME[e["target_house"]], {**base, "why": f"natal {n} sits in your {T.ordinal(e['target_house'])} house"})
        if n in POINT_THEME:
            add(POINT_THEME[n], {**base, "why": f"natal {n} is a {POINT_THEME[n]} point"})
    ctx = list(extra_factors or [])
    if include_context:
        ctx += context_factors(d)          # context for the SAME date as the events (not wall-clock today)
    for f in ctx:
        add(f["theme"], f)
    out = []
    for b in buckets.values():
        ev_factors = [f for f in b["factors"] if f.get("event_id")]
        if not ev_factors or len(b["factors"]) < 2:
            continue                                  # a theme needs ≥2 factors incl. ≥1 live event
        tones = [f["tone"] for f in b["factors"] if f.get("tone") in ("supportive", "challenging")]
        major = max(("supportive", "challenging"), key=tones.count) if tones else "neutral"
        if tones and tones.count("supportive") == tones.count("challenging"):
            major = "mixed"
        sup = [f for f in b["factors"] if f.get("tone") in (major, "neutral", None) or major == "mixed"]
        con = [] if major == "mixed" else [f for f in b["factors"] if f.get("tone") not in (major, "neutral", None)]
        if all(f.get("tradition_dependent") for f in ev_factors):
            b["missing"].append("every live factor is an Uranian point (tradition-dependent)")
        if len(ev_factors) == 1:
            b["missing"].append("only one live transit — the rest is background context")
        out.append({"theme": b["theme"], "label": b["label"], "tone": major, "supporting_factors": sup,
                    "conflicting_factors": con, "timing": b["timing"], "missing": b["missing"],
                    "evidence": [f"{f['label']} — {f['why']}" if f.get("event_id") else f["why"] for f in b["factors"]],
                    "event_ids": sorted(b["event_ids"])})
    out.sort(key=lambda x: -(len(x["supporting_factors"]) + len(x["conflicting_factors"])))
    return out


def context_factors(d: date | None = None) -> list[dict]:
    """Background (non-transit) factors: profection year, progressed Moon house, active Svehla windows."""
    d = d or T.today_local()
    out = []
    pf = _profection(d)
    if pf.get("house"):
        out.append({"theme": HOUSE_THEME[pf["house"]], "label": f"{T.ordinal(pf['house'])}-house profection year",
                    "why": f"{T.ordinal(pf['house'])}-house profection year (lord {pf.get('lord')})", "tone": "neutral"})
    try:
        pm = T.progressed(d)["Moon"]
        out.append({"theme": HOUSE_THEME[pm["house"]], "label": f"progressed Moon in the {T.ordinal(pm['house'])}",
                    "why": f"progressed Moon in your {T.ordinal(pm['house'])} house ({pm['dms']})", "tone": "neutral"})
    except Exception:
        pass
    try:
        import svehla
        for w in svehla.active(d):
            if w.get("kind") in WINDOW_THEME:
                out.append({"theme": WINDOW_THEME[w["kind"]], "label": w["title"],
                            "why": f"Svehla window: {w['title']} (until {w['_end']:%b %-d %Y})", "tone": "neutral",
                            "window_end": w["end"]})
    except Exception:
        pass
    return out


def themes_line(th: list[dict], n: int = 3) -> str:
    if not th:
        return ""
    parts = []
    for t in th[:n]:
        sup, con = len(t["supporting_factors"]), len(t["conflicting_factors"])
        parts.append(f"{t['label']} ({t['tone']}: {sup} for" + (f", {con} against)" if con else ")"))
    return "🧭 Threads: " + " · ".join(parts)


# ── cache metadata (every engine cache carries this) ──────────────────────────
ENGINE_FILES = ("astro_truth.py", "astro_events.py", "astro_timeline.py")


def code_hash(files: tuple[str, ...] = ENGINE_FILES) -> str:
    h = hashlib.sha1()
    for f in files:
        try:
            h.update((HERE / f).read_bytes())
        except OSError:
            pass
    return h.hexdigest()[:12]


def cache_meta(source: str, valid_days: float, files: tuple[str, ...] = ENGINE_FILES) -> dict:
    now = T.now_local()
    return {"schema_version": SCHEMA_VERSION, "generated_at": now.isoformat(timespec="seconds"),
            "source": source, "timezone": T.TZ_NAME, "code_hash": code_hash(files),
            "valid_until": (now + timedelta(days=valid_days)).isoformat(timespec="seconds")}


def cache_fresh(meta: dict | None, files: tuple[str, ...] = ENGINE_FILES) -> tuple[bool, str]:
    if not meta:
        return False, "no metadata"
    if meta.get("schema_version") != SCHEMA_VERSION:
        return False, f"schema {meta.get('schema_version')} ≠ {SCHEMA_VERSION}"
    if meta.get("code_hash") != code_hash(files):
        return False, "engine code changed"
    try:
        if datetime.fromisoformat(meta["valid_until"]) < T.now_local():
            return False, "expired"
    except Exception:
        return False, "bad valid_until"
    return True, "fresh"


if __name__ == "__main__":
    import sys
    evs = current_transits()
    if "--json" in sys.argv:
        print(json.dumps(evs, indent=1, default=str))
    else:
        for e in evs:
            print(f"{e['priority']:>3}  {GLYPH[e['aspect']]} {e['moving_body']} {e['aspect']} natal {e['target_body']} "
                  f"orb {e['orb']:.2f} {e['motion']} {e['lifecycle']} exact {e.get('exact_at_local')} "
                  f"{e.get('pass_label') or ''} {e.get('pass_number')}/{e.get('pass_total')}")
            print("       " + "; ".join(e["priority_reasons"]))
        print(themes_line(themes(evs)))
