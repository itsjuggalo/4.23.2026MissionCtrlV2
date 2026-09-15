#!/usr/bin/env python3
"""astro_lexicon.py — the interpretive layer for Mike's daily transits.

Every transit line can be explained on four levels, each kept to one tight sentence:
  ASPECT   — what the geometry (square/trine/…) actually does between two energies
  PLANETS  — what each body is, practically and esoterically (soul-level principle)
  SIGNS    — the sign the transiting body is moving through + the natal point's sign
  HOUSES   — WHERE it fires from (transit house) and WHERE it lands (natal house) = life areas
Then `explain_hit()` composes them into a personal read for a specific aspect in Mike's chart.

Esoteric layer draws on the Alice Bailey / esoteric-astrology tradition (soul purpose, esoteric
rulers) plus the classical symbolism Svehla uses (Alpha Crucis, anaretic degrees, Hades/Apollon).
Natal: Sun 12° Scorpio 4H, Moon 1° Pisces 8H, ASC 27° Cancer (Mars on it), MC 19° Aries.
"""
from __future__ import annotations

PLANETS = {
    "Sun":     {"is": "your core identity, vitality and conscious purpose",
                "eso": "the Soul's light itself; esoterically the Sun veils the Heart of the Sun — what you are here to become, not just who you are",
                "verb": "illuminates"},
    "Moon":    {"is": "mood, instinct, memory and what feels safe",
                "eso": "the past and the form-nature; esoterically the Moon is a 'dead' planet veiling Vulcan/Uranus/Neptune — old habit that the Soul is asked to outgrow",
                "verb": "colours"},
    "Mercury": {"is": "thinking, words, messages, decisions and short trips",
                "eso": "the Messenger of the Gods; the bridge (antahkarana) between mind and Soul — how insight gets into language",
                "verb": "activates"},
    "Venus":   {"is": "money, values, attraction, pleasure and what you draw toward you",
                "eso": "the elder sister of Earth; esoterically Venus is the mind made loving — union of intellect and heart, the 'Solar Angel'",
                "verb": "sweetens"},
    "Mars":    {"is": "drive, anger, sex, courage and the will to act",
                "eso": "the warrior of desire; esoterically Mars rules the astral (emotional) body — its lesson is desire turned into directed will",
                "verb": "charges"},
    "Jupiter": {"is": "growth, luck, faith, expansion and 'more'",
                "eso": "the second Ray of Love-Wisdom; esoterically Jupiter fuses heart and head — expansion that is also inclusion",
                "verb": "expands"},
    "Saturn":  {"is": "limits, time, structure, tests and earned authority",
                "eso": "the Lord of Karma and the Dweller on the Threshold; esoterically Saturn is the third Ray of Active Intelligence — opportunity disguised as pressure",
                "verb": "tests"},
    "Uranus":  {"is": "sudden change, freedom, rewiring and the unexpected",
                "eso": "the Awakener; esoterically the seventh Ray of Ceremonial Order — old form shattered so a truer pattern can appear",
                "verb": "shocks"},
    "Neptune": {"is": "fog, longing, intuition, escape and ideal",
                "eso": "the God of the Waters; esoterically the sixth Ray of Devotion — dissolving the personal so the universal can be felt",
                "verb": "dissolves"},
    "Pluto":   {"is": "power, death-and-rebirth, obsession and what must transform",
                "eso": "the first Ray of Will — destroyer of forms that have served their purpose; the underworld where the Soul retrieves what was buried",
                "verb": "transforms"},
    "Chiron":  {"is": "the old wound, and the healing skill that grows from it",
                "eso": "the Wounded Healer, the bridge between Saturn (form) and Uranus (freedom); the gift is only found inside the wound",
                "verb": "opens"},
    "Ceres":   {"is": "nourishment, care, cycles of loss and return, and fair compensation",
                "eso": "the Great Mother of grain; the mystery of Persephone — what you must let go for a season so it returns grown",
                "verb": "nourishes"},
    "Juno":    {"is": "commitment, loyalty, fairness and the partnership contract",
                "eso": "the Queen of Heaven; the sacred marriage — equality inside union, what is owed and what is given",
                "verb": "binds"},
    "Hades":   {"is": "the past, decay, causality and clearing what is finished",
                "eso": "the Uranian point of the underworld — degradation that composts into new soil",
                "verb": "unearths"},
    "Apollon": {"is": "multiplication, breadth, reach and success through expansion",
                "eso": "the Uranian point of the many-branched tree — science, commerce, many hands, wide effect",
                "verb": "multiplies"},
    "ASC":     {"is": "your body, identity and how you meet the world",
                "eso": "the rising sign shows the Soul's chosen doorway this life — the direction of purpose, not just persona",
                "verb": "meets"},
    "MC":      {"is": "career, calling, reputation and public standing",
                "eso": "the point of spiritual ambition — where the Soul wants to be seen serving",
                "verb": "crowns"},
    "DSC":     {"is": "partnership, the significant other, and open enemies",
                "eso": "the mirror — what you meet in others is what you have not yet claimed in yourself",
                "verb": "mirrors"},
}

SIGNS = {
    "Aries":       {"mode": "cardinal fire", "ruler": "Mars", "eso_ruler": "Mercury",
                    "is": "initiation, courage, the first move",
                    "eso": "'I come forth and from the plane of mind I rule' — the birth of an idea into action"},
    "Taurus":      {"mode": "fixed earth", "ruler": "Venus", "eso_ruler": "Vulcan",
                    "is": "possessions, security, the body's needs, stubborn worth",
                    "eso": "'I see, and when the Eye is opened, all is light' — desire refined into value; Vulcan forges the personality into a tool"},
    "Gemini":      {"mode": "mutable air", "ruler": "Mercury", "eso_ruler": "Venus",
                    "is": "words, siblings, duality, quick connection",
                    "eso": "'I recognise my other self, and in the waning of that self I grow and glow' — the pairs of opposites reconciled"},
    "Cancer":      {"mode": "cardinal water", "ruler": "Moon", "eso_ruler": "Neptune",
                    "is": "home, roots, protection, the tide of feeling",
                    "eso": "'I build a lighted house and therein dwell' — the gate into incarnation; mass consciousness becoming individual"},
    "Leo":         {"mode": "fixed fire", "ruler": "Sun", "eso_ruler": "Sun",
                    "is": "self-expression, pride, creativity, being seen",
                    "eso": "'I am That and That am I' — the individual fully self-aware, then offered up"},
    "Virgo":       {"mode": "mutable earth", "ruler": "Mercury", "eso_ruler": "Moon",
                    "is": "work, health, refinement, service, the details",
                    "eso": "'I am the Mother and the Child, I God, I matter am' — the Christ-principle gestating inside matter"},
    "Libra":       {"mode": "cardinal air", "ruler": "Venus", "eso_ruler": "Uranus",
                    "is": "balance, partnership, fairness, the other",
                    "eso": "'I choose the Way which leads between the two great lines of force' — the point of balance before the Path"},
    "Scorpio":     {"mode": "fixed water", "ruler": "Mars/Pluto", "eso_ruler": "Mars",
                    "is": "intensity, intimacy, power, death-and-rebirth, what is hidden",
                    "eso": "'Warrior I am, and from the battle I emerge triumphant' — the sign of the tests; the disciple's nine trials"},
    "Sagittarius": {"mode": "mutable fire", "ruler": "Jupiter", "eso_ruler": "Earth",
                    "is": "belief, travel, teaching, the far target",
                    "eso": "'I see the goal. I reach that goal and then I see another' — the arrow of one-pointed direction"},
    "Capricorn":   {"mode": "cardinal earth", "ruler": "Saturn", "eso_ruler": "Saturn",
                    "is": "ambition, structure, authority, the long climb",
                    "eso": "'Lost am I in light supernal, yet on that light I turn my back' — the mountain top; initiation, then service"},
    "Aquarius":    {"mode": "fixed air", "ruler": "Saturn/Uranus", "eso_ruler": "Jupiter",
                    "is": "friendship, freedom, the group, the future",
                    "eso": "'Water of life am I, poured forth for thirsty men' — the world server; the individual as a channel for the group"},
    "Pisces":      {"mode": "mutable water", "ruler": "Jupiter/Neptune", "eso_ruler": "Pluto",
                    "is": "compassion, dissolution, the unseen, sacrifice",
                    "eso": "'I leave the Father's home and turning back, I save' — the World Saviour; the end of the cycle that becomes the beginning"},
}

# Placidus cusps from the natal chart (the system Svehla and Mike's natal readings use —
# Sun 12° Scorpio = 4th, Moon 1° Pisces = 8th, Mercury/Venus Sag = 5th, Juno 11° Cancer = 12th).
import swisseph as _swe
from pathlib import Path as _P
_swe.set_ephe_path(str(_P.home() / ".local/share/swisseph"))
_NATAL_JD = _swe.julday(1992, 11, 4, 3 + 46 / 60)
CUSPS = list(_swe.houses(_NATAL_JD, 28.0197, -82.7715, b"P")[0])
_SIGN_NAMES = ["Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
               "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"]
HOUSE_SIGN = [_SIGN_NAMES[int(c // 30)] for c in CUSPS]     # sign on each cusp
HOUSES = [
    {"is": "your body, identity and how you come across",          "eso": "the Soul's doorway — the dharma of this incarnation",
     "mike": "Cancer rising with Mars 3° before it (12th side, conjunct ASC): you lead with protection and heat at once"},
    {"is": "money, possessions and self-worth",                     "eso": "the value you place on yourself before anyone pays you",
     "mike": "Leo 2nd with Chiron in it: the wound is in being valued — the account balance is a metric, not a verdict"},
    {"is": "communication, siblings, learning, short trips",        "eso": "the mind as a bridge — how thought becomes speech",
     "mike": "Libra 3rd with Jupiter: growth comes through fair talk and teaching"},
    {"is": "home, roots, family, your private foundation",          "eso": "the end of the matter — the ground the Soul stands on",
     "mike": "Scorpio 4th with your Sun and Pluto: home is intense; your core self is built in private"},
    {"is": "creativity, children, romance, speculation",            "eso": "the heart's fire — what you make for joy, including the risks you take",
     "mike": "Sagittarius 5th with Mercury + Venus: the FOMO chase and the teaching voice live in the same room"},
    {"is": "daily work, health, routine, service",                  "eso": "purification — Virgo's ground where the mission gets proven boring-and-real",
     "mike": "Capricorn 6th with Uranus + Neptune: the inner engineer and the inner mystic share your routines"},
    {"is": "partnership, the significant other, open opponents",    "eso": "the mirror — the Other as the unowned half of yourself",
     "mike": "Aquarius 7th with Saturn: commitment must have structure AND freedom, or it chafes"},
    {"is": "shared money, sex, debt, death, the deep end",          "eso": "the crossing — what must die for something else to be born; other people's resources",
     "mike": "Pisces 8th with your Moon: you absorb other people's depths; feelings run underground"},
    {"is": "beliefs, higher learning, long journeys, meaning",      "eso": "the arrow toward the goal — philosophy that becomes direction",
     "mike": "Aries 9th: your beliefs are fought for, not inherited"},
    {"is": "career, reputation, public standing, authority",        "eso": "spiritual ambition — where the Soul wants to be seen serving",
     "mike": "Aries MC ruled by Mars: entrepreneurship or a leadership role; Saturn is transiting here until 2030"},
    {"is": "friends, networks, groups, income from vocation",       "eso": "the group — Aquarius's house of world service and the future",
     "mike": "Taurus 11th with Hades (12° Gemini) inside it: your progressed Moon enters here Oct 30 2026 — income from vocation, per Svehla"},
    {"is": "solitude, the hidden, endings, self-undoing, retreat",  "eso": "the closed room before rebirth — the Soul's storehouse and its blind spot",
     "mike": "Gemini 12th with Juno (11° Cancer) and Mars (23° Cancer) inside it: loyalty and the engine both live just behind the Ascendant"},
]

ASPECTS = {
    "conjunct": {"geo": "0°", "is": "fusion — the two energies act as one; the transit temporarily IS that natal point",
                 "eso": "a new cycle seeded; what is joined here gets born together",
                 "work": "let the transiting planet's quality run through that part of you on purpose"},
    "sextile":  {"geo": "60°", "is": "opportunity — an easy channel that only pays if you use it",
                 "eso": "two compatible elements (fire-air, earth-water) offering a door, never pushing you through",
                 "work": "take the small action; sextiles reward initiative and ignore passivity"},
    "square":   {"geo": "90°", "is": "friction — two energies at cross-purposes, forcing a decision or a build",
                 "eso": "the cross of matter; the Soul learns through resistance — squares build the muscle trines never do",
                 "work": "don't smooth it over; find the concrete thing the tension is asking you to construct"},
    "trine":    {"geo": "120°", "is": "flow — same element, effortless support, talent that feels like luck",
                 "eso": "grace; the danger is inertia — a gift unused becomes a habit",
                 "work": "use it while it's open; trines leave as quietly as they came"},
    "opposite": {"geo": "180°", "is": "polarity — the same axis seen from both ends; awareness through the Other",
                 "eso": "the full-moon moment of a cycle; illumination that comes through a partner, a mirror, a confrontation",
                 "work": "hold both ends — integrate rather than pick a side"},
}

ORDINAL = lambda n: f"{n}{'th' if 10 <= n % 100 <= 20 else {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th')}"


def sign_of(lon: float) -> str:
    return list(SIGNS)[int((lon % 360) // 30)]


def house_of(lon: float, asc_lon: float = 0.0) -> int:
    """1-based Placidus house of a longitude in Mike's natal chart (asc_lon kept for API compat)."""
    lon %= 360
    for i in range(12):
        a, b = CUSPS[i], CUSPS[(i + 1) % 12]
        if (a <= lon < b) if a < b else (lon >= a or lon < b):
            return i + 1
    return 12


def houses_for_sign(sign: str) -> list[int]:
    """Which of Mike's houses a sign occupies (Placidus: usually one or two, may be intercepted)."""
    idx = _SIGN_NAMES.index(sign)
    hs = sorted({house_of(idx * 30 + d) for d in (0.5, 15, 29.5)})
    return hs


def explain_hit(h: dict, t_lon: float, n_lon: float, asc_lon: float, full: bool = False) -> str:
    """h = {"t","n","aspect","orb"}; returns a compact (3-line) or full (6-line) personal read."""
    t, n, a = h["t"], h["n"], h["aspect"]
    tp, np_, asp = PLANETS[t], PLANETS[n], ASPECTS[a]
    ts, ns = sign_of(t_lon), sign_of(n_lon)
    th, nh = house_of(t_lon, asc_lon), house_of(n_lon, asc_lon)
    TH, NH = HOUSES[th - 1], HOUSES[nh - 1]
    lines = []
    lines.append(f"{asp['geo']} {a}: {asp['is']}.")
    lines.append(f"From your {ORDINAL(th)} house ({TH['is']}) into your {ORDINAL(nh)} house ({NH['is']}): "
                 f"{t} {tp['verb']} {n} — {tp['is']} meets {np_['is']}.")
    if full:
        lines.append(f"{t} in {ts} ({SIGNS[ts]['mode']}): {SIGNS[ts]['is']}. Natal {n} in {ns}: {SIGNS[ns]['is']}.")
        lines.append(f"Esoteric {t}: {tp['eso']}.")
        lines.append(f"Esoteric {n}: {np_['eso']}.")
        lines.append(f"Esoteric {a}: {asp['eso']}. {NH['mike']}.")
        ent = kb_entry(f"Transiting {t} {a} natal {n}")
        combo = combo_translation(f"{t} {a} natal {n}") or combo_translation(f"{t} {a} {n}") or combo_translation(f"{t} {a}")
        if ent:
            lines.append(f"Researched: {ent.get('traditional', '')} Esoteric: {ent.get('esoteric', '')}")
            if ent.get("svehla_link"):
                lines.append(f"Svehla fit: {ent['svehla_link']}")
            if ent.get("do") or ent.get("avoid"):
                lines.append(f"Do: {ent.get('do', '')} Avoid: {ent.get('avoid', '')}")
        elif combo:
            lines.append(f"Researched: {combo}")
        elif kb_get("planets", t, "in_mikes_chart"):
            lines.append(f"Researched ({t} for you): {kb_get('planets', t, 'in_mikes_chart')}")
        lines.append(f"How to work it: {asp['work']}.")
    else:
        lines.append(f"Esoterically: {tp['eso'].split(';')[0]}; {asp['eso'].split(';')[0]}. In your chart: {NH['mike']}.")
    lines.append(translate_hit(h, t_lon, n_lon))
    return "\n".join(lines)


def lookup(kind: str, key: str) -> str:
    kind, key = kind.lower(), key.strip().title()
    if kind in ("planet", "body"):
        key = {"Asc": "ASC", "Mc": "MC", "Dsc": "DSC"}.get(key, key)
        p = PLANETS.get(key)
        if not p:
            return f"Unknown planet '{key}'. Try: {', '.join(PLANETS)}"
        out = f"{key}: {p['is']}.\nEsoteric: {p['eso']}."
        if kb_get("planets", key, "esoteric"):
            out += f"\nResearched: {kb_get('planets', key, 'esoteric')}"
        if kb_get("planets", key, "in_mikes_chart"):
            out += f"\nIn your chart: {kb_get('planets', key, 'in_mikes_chart')}"
        return out
    if kind == "sign":
        s = SIGNS.get(key)
        if not s:
            return f"Unknown sign '{key}'."
        hs = houses_for_sign(key)
        where = " and ".join(ORDINAL(h) for h in hs)
        out = (f"{key} ({s['mode']}, ruler {s['ruler']}, esoteric ruler {s['eso_ruler']}): {s['is']}.\n"
               f"Esoteric keynote: {s['eso']}.\nIn your chart (Placidus): {key} falls in your {where} house — "
               + " / ".join(HOUSES[h - 1]['mike'] for h in hs) + ".")
        if kb_get("signs", key, "esoteric"):
            out += f"\nResearched: {kb_get('signs', key, 'esoteric')}"
        if kb_get("signs", key, "in_mikes_chart"):
            out += f"\nFor you: {kb_get('signs', key, 'in_mikes_chart')}"
        return out
    if kind == "house":
        try:
            n = int(key); h = HOUSES[n - 1]
        except Exception:
            return "House must be 1-12."
        out = f"{ORDINAL(n)} house (cusp in {HOUSE_SIGN[n - 1]} for you): {h['is']}.\nEsoteric: {h['eso']}.\nYours: {h['mike']}."
        if kb_get("houses", str(n), "esoteric"):
            out += f"\nResearched: {kb_get('houses', str(n), 'esoteric')}"
        if kb_get("houses", str(n), "in_mikes_chart"):
            out += f"\nFor you: {kb_get('houses', str(n), 'in_mikes_chart')}"
        return out
    if kind == "aspect":
        key = {"Conjunction": "conjunct", "Opposition": "opposite", "Square": "square", "Trine": "trine",
               "Sextile": "sextile", "Conjunct": "conjunct", "Opposite": "opposite"}.get(key, key.lower())
        a = ASPECTS.get(key)
        if not a:
            return f"Unknown aspect. Try: {', '.join(ASPECTS)}"
        out = f"{key} ({a['geo']}): {a['is']}.\nEsoteric: {a['eso']}.\nHow to work it: {a['work']}."
        if kb_get("aspects", key, "esoteric"):
            out += f"\nResearched: {kb_get('aspects', key, 'esoteric')}"
        return out
    if kind in ("phase", "event", "combo"):
        if kind == "combo":
            return combo_translation(key) or f"No researched combo matching '{key}'."
        sec = "lunation_phases" if kind == "phase" else "sky_events"
        k = key.lower().replace(" ", "_")
        e = KB.get(sec, {}).get(k)
        return (f"{key}: {e.get('traditional', '')}\nEsoteric: {e.get('esoteric', '')}\nIn plain terms: {e.get('translation', '')}"
                if e else f"Unknown {kind}. Try: {', '.join(KB.get(sec, {}))}")
    return "Usage: /planet saturn · /sign scorpio · /house 10 · /aspect square · /phase balsamic · /event solar_eclipse · /combo Saturn conjunct MC"


# ── plain-English translation layer + esoteric KB merge (2026-09-15) ─────────────
import json as _json
_KB_PATH = _P(__file__).with_name("astro_esoteric_kb.json")
try:
    KB = _json.loads(_KB_PATH.read_text())
except Exception:
    KB = {}


def kb_get(section: str, key: str, field: str, default: str = "") -> str:
    try:
        return KB[section][key][field] or default
    except Exception:
        return default


# ── researched entry files (round 8): flat {key → entry} across astro_kb_*.json ───────────
ENTRY_FILES = ["astro_kb_fast_transits.json", "astro_kb_slow_gaps.json", "astro_kb_cycles.json",
               "astro_kb_timing.json", "astro_kb_method.json", "astro_kb_gaps2.json"]
ENTRIES: dict[str, dict] = {}


def _load_entries() -> None:
    import json as _json
    from pathlib import Path as _P
    here = _P(__file__).resolve().parent
    for fn in ENTRY_FILES:
        fp = here / fn
        if not fp.exists():
            continue
        try:
            data = _json.loads(fp.read_text())
        except Exception:
            continue
        lists = [data.get("entries", [])]
        for sec in ("tnp_points", "midpoints", "fixed_stars", "critical_degrees"):
            lists.append(data.get(sec, []))
        for lst in lists:
            for e in lst or []:
                k = str(e.get("key", "")).strip().lower()
                if k and k not in ENTRIES:
                    ENTRIES[k] = e


_load_entries()


def kb_entry(key: str) -> dict | None:
    """Researched entry by exact key (case-insensitive), e.g. 'Transiting Mars in the 12th house'."""
    if not key:
        return None
    return ENTRIES.get(key.strip().lower())


def entry_lines(key: str, full: bool = False) -> list[str]:
    e = kb_entry(key)
    if not e:
        return []
    out = [f"In plain terms: {e.get('translation', '')}"] if e.get("translation") else []
    if full:
        for f, label in (("traditional", "Traditional"), ("esoteric", "Esoteric"), ("in_mikes_chart", "In your chart"),
                         ("svehla_link", "Svehla"), ("do", "Do"), ("avoid", "Avoid"), ("weekly_practice", "This week")):
            if e.get(f):
                out.append(f"{label}: {e[f]}")
    return out


def plain(body: str) -> str:
    """Short plain-English keyword for a body (KB 'plain' if researched, else our own)."""
    fallback = {"Sun": "your core self", "Moon": "your feelings and habits", "Mercury": "your thinking and words",
                "Venus": "money, love and what you value", "Mars": "your drive and temper", "Jupiter": "growth and luck",
                "Saturn": "limits, duty and time", "Uranus": "sudden change", "Neptune": "fog and longing",
                "Pluto": "deep change and power", "Chiron": "the old wound", "Ceres": "care and fair pay",
                "Juno": "commitment and fairness", "Hades": "the buried past", "Apollon": "reach and multiplication",
                "ASC": "how you show up", "MC": "your career and reputation", "DSC": "your partner"}
    return kb_get("planets", body, "plain", fallback.get(body, body.lower()))


ASPECT_PLAIN = {
    "conjunct": "{A} and {B} fuse — they act as one thing now",
    "sextile": "{A} opens an easy door for {B}, but only if you walk through it",
    "square": "{A} and {B} pull against each other until you build something that holds both",
    "trine": "{A} and {B} flow together — this is easy, so use it before it passes",
    "opposite": "{A} and {B} face off across the chart — you'll meet it through another person or a choice",
}


def translate_hit(h: dict, t_lon: float, n_lon: float) -> str:
    """'In plain terms:' one line a non-astrologer understands, for a transit→natal aspect."""
    t, n, a = h["t"], h["n"], h["aspect"]
    nh = house_of(n_lon)
    ent = kb_entry(f"Transiting {t} {a} natal {n}")
    if ent and ent.get("translation"):
        return f"In plain terms: {ent['translation'].rstrip('.')}. Where it lands in your life: {kb_get('houses', str(nh), 'plain', HOUSES[nh - 1]['is'])} ({ORDINAL(nh)} house)."
    tmpl = kb_get("aspects", a, "plain", ASPECT_PLAIN[a])
    A = f"{t} ({plain(t)})" if t not in ("ASC", "MC", "DSC") else f"your {t} ({plain(t)})"
    B = f"your {n} ({plain(n)})" if n not in ("ASC", "MC", "DSC") else f"your {n} ({plain(n)})"
    core = tmpl.replace("{A}", A).replace("{B}", B)
    where = kb_get("houses", str(nh), "plain", HOUSES[nh - 1]["is"])
    return f"In plain terms: {core.rstrip('.')}. Where it lands in your life: {where} ({ORDINAL(nh)} house)."


def combo_translation(name_fragment: str) -> str:
    """Look up a researched natal/transit combo by name fragment (e.g. 'Saturn conjunct MC')."""
    for sec in ("transit_combos", "natal_combos"):
        for c in KB.get(sec, []):
            if name_fragment.lower() in c.get("name", "").lower():
                return f"{c['name']}: {c.get('translation', '')} (Esoteric: {c.get('esoteric', '')})"
    return ""


if __name__ == "__main__":
    import sys
    print(lookup(sys.argv[1], " ".join(sys.argv[2:])) if len(sys.argv) > 2 else "usage: astro_lexicon.py <planet|sign|house|aspect> <key>")