#!/usr/bin/env python3
"""astro_facts.py — free-chat GROUNDING: intent → calculations → structured facts → (LLM).

The LLM never invents positions, degrees, signs, houses, aspects, orbs, dates, times, motion,
retrograde state, progressions, ingresses or synastry. This module computes them and either
  • answers deterministically (placement / exact-date / strongest-transit questions), or
  • hands the LLM a JSON block of computed facts with the rule "anything not listed → UNAVAILABLE".

  astro_facts.py intent "<question>"   → detected intent (JSON)
  astro_facts.py answer "<question>"   → deterministic answer or null
  astro_facts.py facts                 → the facts JSON the LLM receives
"""
from __future__ import annotations

import json
import re
import sys
from datetime import datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402
import astro_events as E  # noqa: E402

PLANETS = ["Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto",
           "Chiron", "Ceres", "Juno", "Hades", "Apollon"]
POINTS = PLANETS + ["ASC", "MC", "DSC", "IC"]
ALIASES = {"ascendant": "ASC", "rising": "ASC", "midheaven": "MC", "descendant": "DSC", "mc": "MC",
           "asc": "ASC", "dsc": "DSC", "ic": "IC"}
_NOT_PERSON = ("today|tonight|tomorrow|yesterday|mike|the|this|that|what|where|who|how|it|there|here|he|she|let|"
               "sun|moon|mercury|venus|mars|jupiter|saturn|uranus|neptune|pluto|chiron|ceres|juno|week|month|year")
# possessive + chart word = someone else's chart — but not "today's transits", "Saturn's transit", "Mike's chart"
OTHER_CHART = (r"\b(her|his|their|(?!(?:" + _NOT_PERSON + r")'s)\w+'s)\s+"
               r"(chart|sign|sun|moon|rising|ascendant|venus|mars|placements?|birth ?chart|transits?)\b")
RELATION = r"\b(girlfriend|boyfriend|wife|husband|partner|fianc[eé]e?|mom|mother|dad|father|son|daughter|" \
           r"brother|sister|friend|boss|ex|her|his|their|she|he)\b"

INTENTS = [   # (intent, regex) — first match wins; order = specificity
    ("general", r"\b(good|bad|ok|okay|wise|safe|right) (day |time |moment )?(for|to)\b|\bshould i\b"),  # judgement → LLM + facts
    ("profile", r"\b(add|save|store|new)\b.*\bprofile\b|\bprofile\b.*\b(add|save)\b"),
    ("chart", r"\b(my|mike's) (natal |birth )?chart\b|\bshow (me )?my (natal )?chart\b"),
    ("progressed_synastry", r"\bprogress\w*\b.*\b(synastry|compat\w*|relationship|us|together)\b|\b(synastry|compat\w*)\b.*\bprogress"),
    ("synastry", r"\b(synastry|compat\w*|our charts?|me and \w+|\w+ and me|match with)\b"),
    ("voc", r"\bvoid\b|\bv\.?o\.?c\b"),
    ("moon", r"\b(moon (sign|phase|today|now|doing|this week)|what('s| is) the moon|lunar phase|full moon|new moon)\b"),
    ("sky", r"\btransiting (sun|moon|mercury|venus|mars|jupiter|saturn|uranus|neptune|pluto|chiron)\b|\bretrograde\b|\b(is|are) \w+ (rx|retro)\b|\bwhat('s| is) in the sky\b"),
    ("strongest", r"\b(strongest|most important|biggest|main|top|key)\b.*\b(transit|aspect|influence|thing|energy)"),
    ("exact", r"\bwhen\b.*\b(exact|hit|hits|perfect|enter|enters|ingress|happen|peak|station)|\bwhat time\b"),
    ("placement", r"\b(where is|where's|what sign|what house|which sign|which house|what degree)\b|\bmy (natal |progressed )?\w+ (in|sign|house)\b"),
    ("week", r"\b(this|next|coming|my|the) week\b|\bweek ahead\b|\bnext 7 days\b|\bweekly\b"),
    ("year", r"\b(this|next|coming|the) year\b|\byear ahead\b|\b12 months\b"),
    ("today", r"\b(today|tonight|right now|this morning|this afternoon|how's the sky|daily)\b"),
    ("progressions", r"\bprogress\w*\b"),
    ("timeline", r"\b(timeline|coming up|upcoming|next month|dates ahead|what's next|year ahead)\b"),
]


def detect(text: str) -> dict:
    t = text.lower()
    intent = next((i for i, rx in INTENTS if re.search(rx, t)), "general")
    pts = []
    for w in re.findall(r"[a-zA-Z]+", text):
        k = ALIASES.get(w.lower()) or next((p for p in PLANETS if p.lower() == w.lower()), None)
        if k and k not in pts:
            pts.append(k)
    # frame: "my Venus"/natal/birth → natal; progress → progressed; otherwise the live sky
    # ("what sign is Mercury in" = where it is now, not Mike's natal Mercury)
    frame = ("progressed" if re.search(r"\bprogress", t) else
             "transit" if re.search(r"\btransit|\bnow\b|\bcurrent|\btoday\b", t) else
             "natal" if re.search(r"\b(my|natal|birth|born)\b", t) else "transit")
    return {"intent": intent, "points": pts, "frame": frame, "other_person": bool(re.search(RELATION, t)),
            "other_chart": bool(re.search(OTHER_CHART, t)) and not re.search(r"\bmy\b\s+(chart|sign)", t)}


def profiles_named(text: str) -> list[dict]:
    """Stored birth profiles (not Mike) whose name or id appears in the text."""
    try:
        import astro_profiles as P
        allp = P.all_profiles()
    except Exception:
        return []
    t = text.lower()
    return [p for p in allp if p["id"] != "mike" and
            (re.search(rf"\b{re.escape(p['name'].lower())}\b", t) or re.search(rf"\b{re.escape(p['id'])}\b", t))]


def _profile_chart(p: dict) -> dict:
    import astro_synastry as S
    return S.chart(p)


def answer_profile(text: str, p: dict) -> str:
    """A question about a stored person → THEIR computed chart, never Mike's."""
    c = _profile_chart(p)
    pts = [x for x in detect(text)["points"] if x in c["points"]] or \
          [x for x in ["Sun", "Moon", "ASC", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "MC"] if x in c["points"]]
    miss = [x for x in detect(text)["points"] if x not in c["points"]]
    lines = [f"{p['name']}'s natal chart (stored profile · Swiss Ephemeris · tropical · Placidus):"]
    for x in pts:
        v = c["points"][x]
        lines.append(f"{p['name']}'s {x}: {v['dms']}" + (f", {T.ordinal(v['house'])} house" if v.get("house") and x not in ("ASC", "MC") else "")
                     + (" ℞" if v.get("rx") else ""))
    for x in miss:
        lines.append(f"{p['name']}'s {x}: UNAVAILABLE (birth time unknown → no angles/houses)")
    if not c["time_known"]:
        lines.append("Birth time unknown → no Ascendant, Midheaven or houses.")
    return "\n".join(lines)


def _sky_now() -> dict:
    tr = T.transits()
    return {n: {"pos": v["dms"], "in_mikes_house": v.get("house"), "rx": bool(v.get("rx"))} for n, v in tr.items()}


def _voc() -> dict:
    import astro_sky
    return astro_sky.void_of_course(T.now_local())


def _natal_line(n: str, v: dict) -> str:
    return f"natal {n} {v['dms']}" + (f", {T.ordinal(v['house'])} house" if v.get("house") else "") + (" ℞" if v.get("rx") else "")


def answer(text: str) -> str | None:
    """Deterministic answer when the question is fully computable; None → LLM with facts."""
    d = detect(text)
    it, pts = d["intent"], d["points"]
    if it == "placement" and pts and not d["other_person"]:
        out = []
        nat, tr, pr = T.natal(), T.transits(), T.progressed()
        for p in pts[:4]:
            if d["frame"] == "progressed":
                v = pr.get(p)
                out.append(f"Progressed {p}: {v['dms']}, your {T.ordinal(v['house'])} house" if v else
                           f"Progressed {p}: UNAVAILABLE (progressed bodies computed: {', '.join(pr)})")
            elif d["frame"] == "transit":
                v = tr.get(p)
                out.append(f"Transiting {p} now: {v['dms']}, in your {T.ordinal(v['house'])} house" + (" (retrograde)" if v["rx"] else "")
                           if v else f"Transiting {p}: UNAVAILABLE")
            else:
                v = nat.get(p)
                out.append(("N" + _natal_line(p, v)[1:]) if v else f"{p}: UNAVAILABLE")
        return "\n".join(out) + "\n(Swiss Ephemeris · tropical · Placidus)"
    if it == "voc":
        v = _voc()
        fmt = lambda iso: T.round_minute(datetime.fromisoformat(iso)).strftime("%a %b %-d %-I:%M %p ET")
        return ((f"The Moon is void-of-course now, until it changes sign {fmt(v['ingress_et'])}." if v["is_voc_now"] else
                 f"Next void-of-course: {fmt(v['voc_start_et'])} → {fmt(v['ingress_et'])} (Moon changes sign)."
                 if v["voc_start_et"] > T.now_local().isoformat() else
                 f"Not void right now; the Moon changes sign {fmt(v['ingress_et'])}.")
                + "\n(Void = no more major aspects before the sign change — start nothing important.)")
    if it == "sky" and not d["other_person"]:
        tr = T.transits()
        live = E.current_transits()
        pts = [x for x in pts if x in tr]
        if not pts:     # "what's retrograde?" / "what's in the sky"
            rx = [n for n, v in tr.items() if v.get("rx")]
            return ("Retrograde right now: " + (", ".join(rx) if rx else "nothing") + ".\n" +
                    "\n".join(f"{n}: {v['dms']} (your {T.ordinal(v['house'])} house)" + (" ℞" if v.get("rx") else "")
                              for n, v in tr.items() if n in PLANETS[:10]))
        out = []
        for x in pts[:3]:
            v = tr[x]
            out.append(f"Transiting {x} now: {v['dms']}, in your {T.ordinal(v['house'])} house · "
                       + ("retrograde" if v.get("rx") else "direct"))
            for e in [e for e in live if e["moving_body"] == x][:4]:
                ex = f", exact {E.when_label(e)}" if e.get("exact_at_local") else ""
                out.append(f"  {E.GLYPH[e['aspect']]} {e['aspect']} your natal {e['target_body']} · {e['orb']:.2f}° {e['motion']}{ex}")
        return "\n".join(out) + "\n(Swiss Ephemeris · tropical · Placidus · times ET)"
    if it == "strongest" and not d["other_person"]:
        ev = E.current_transits()[:3]
        if not ev:
            return "Nothing is in orb to your chart right now — a quiet sky."
        lines = ["Strongest right now (deterministic ranking — why in brackets):"]
        for e in ev:
            ex = f", exact {E.when_label(e)}" if e.get("exact_at_local") else ""
            lines.append(f"{E.GLYPH[e['aspect']]} Transiting {e['moving_body']} {e['aspect']} natal {e['target_body']} · "
                         f"{e['orb']:.2f}° {e['motion']}{ex} [{'; '.join(r.split(' (+')[0] for r in e['priority_reasons'][:3])}]")
        return "\n".join(lines)
    if it == "exact" and pts and not d["other_person"]:
        import astro_timeline as TL
        today = T.today_local().isoformat()
        want = set(pts)
        hits = [e for e in TL.load() if e["date"] >= today and
                (want <= {e.get("body"), e.get("natal")} or (len(want) == 1 and want & {e.get("body"), e.get("natal")}))][:6]
        fast = []
        if not hits:
            now = T.now_local()
            allf = E.fast_exacts(T.jd_for(now), T.jd_for(now + timedelta(days=45)))
            if len(pts) >= 2:          # "Mercury hit my Sun" → moving Mercury, target Sun first
                allf.sort(key=lambda e: (not (e["moving_body"] == pts[0] and e["target_body"] == pts[1]), e["exact_jd"]))
            fast = [e for e in allf if want <= {e["moving_body"], e["target_body"]}][:6] or \
                   [e for e in allf if want & {e["moving_body"], e["target_body"]}][:6]
        rows = hits or fast
        if not rows:
            return (f"UNAVAILABLE — no exact {' / '.join(pts)} event in the computed range "
                    f"(timeline to 2031 for slow bodies, 45 days for Sun–Mars).")
        return "Next exact (ET, Swiss Ephemeris):\n" + "\n".join(
            f"• {E.when_label(e)}: {e['what']}" for e in rows)
    return None


def facts(text: str = "") -> dict:
    """The structured context the LLM gets — every number here is computed, none remembered."""
    now = T.now_local()
    nat = T.natal()
    live = E.current_transits(now)
    import astro_timeline as TL
    nxt = [e for e in TL.load() if (e.get("exact_at_local") or "") >= now.isoformat() or
           (not e.get("exact_at_local") and e["date"] >= now.date().isoformat())][:12]
    try:
        import svehla
        windows = [{"title": w["title"], "start": w["_start"].isoformat(), "end": w["_end"].isoformat()}
                   for w in svehla.active(now.date())]
    except Exception:
        windows = []
    prog = T.progressed(now.date())
    try:
        import astro_profiles as P
        profiles = [p["name"] for p in P.all_profiles()]
    except Exception:
        profiles = ["Mike"]
    named = {}
    for p in profiles_named(text)[:2]:
        c = _profile_chart(p)
        named[p["name"]] = {"time_known": c["time_known"],
                            "natal": {n: {"pos": v["dms"], "house": v.get("house"), "rx": bool(v.get("rx"))} for n, v in c["points"].items()}}
    try:
        voc = _voc()
    except Exception:
        voc = None
    year = []
    if re.search(r"\byear|\bmonths?\b|\blong.?term|\b20[23]\d\b|\bcareer\b", text.lower()):
        end = (now + timedelta(days=365)).date().isoformat()
        year = [{"when_et": e.get("exact_at_local") or e["date"], "what": e["what"]} for e in TL.load()
                if now.date().isoformat() <= e["date"] <= end and e.get("event_type") != "ingress"][:40]
    return {
        "now_et": now.isoformat(timespec="minutes"), "zodiac": "tropical", "houses": "Placidus",
        "natal": {n: {"pos": v["dms"], "house": v["house"], "rx": v["rx"]} for n, v in nat.items()},
        "chart_ruler": T.CHART_RULER,
        "live_transits": [{"event": f"Transiting {e['moving_body']} {e['aspect']} natal {e['target_body']}",
                           "orb": e["orb"], "motion": e["motion"], "lifecycle": e["lifecycle"],
                           "exact_at_et": e.get("exact_at_local"), "pass": e.get("pass_label") and f"{e['pass_label']} {e['pass_number']}/{e['pass_total']}",
                           "priority": e["priority"], "why": e["priority_reasons"][:4]} for e in live[:10]],
        "themes": [{"theme": t["label"], "tone": t["tone"], "evidence": t["evidence"][:4], "missing": t["missing"]}
                   for t in E.themes(live)[:3]],
        "progressed": {n: {"pos": v["dms"], "house": v["house"]} for n, v in prog.items()},
        "next_exact": [{"when_et": e.get("exact_at_local") or e["date"], "what": e["what"]} for e in nxt],
        "svehla_active_windows": windows,
        "sky_now": _sky_now(),
        "moon_void_of_course": voc,
        **({"next_12_months": year} if year else {}),
        "profiles_on_file": profiles,
        **({"named_profile_charts": named} if named else {}),
    }


RULES = ("RULES: The COMPUTED FACTS block is the ONLY source for positions, degrees, signs, houses, aspects, "
         "orbs, dates, times, applying/separating, retrograde state, progressions, ingresses and synastry. "
         "Never compute or recall these yourself. If the answer needs a fact that is not in the block, "
         "say it is UNAVAILABLE (and which command computes it) instead of guessing. Charts exist only for "
         "people in profiles_on_file. Interpretation is yours; facts are not.")


def llm_context(text: str) -> str:
    return f"COMPUTED FACTS (Swiss Ephemeris, authoritative):\n{json.dumps(facts(text), ensure_ascii=False)}\n\n{RULES}"


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "facts"
    q = " ".join(sys.argv[2:])
    if cmd == "intent":
        print(json.dumps(detect(q)))
    elif cmd == "answer":
        print(answer(q))
    else:
        print(json.dumps(facts(q), indent=1, ensure_ascii=False))
