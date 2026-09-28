#!/usr/bin/env python3
"""astro_esoteric.py — the ESOTERIC READ: a soul-level (Alice Bailey / Rudhyar / Uranian) take on
Mike's CURRENT transits, delivered as its OWN Telegram message — never folded into the daily digest.

Every astrological FACT here (position, sign, house, aspect, orb, motion, exact time, applying/
separating, retrograde, pass label) is read straight off astro_events.current_transits() /
astro_truth.py — nothing is typed by hand and nothing comes from an LLM. The interpretive language
is composed from the existing esoteric knowledge base:
  astro_lexicon.py        — PLANETS[x]['eso'], SIGNS[x]['eso'/'eso_ruler'], HOUSES[i]['eso'], kb_entry()
  astro_esoteric_kb.json  — planets/signs/houses/aspects esoteric text + in_mikes_chart, combos
  astro_kb_method.json / astro_kb_timing.json / astro_kb_gaps2.json / astro_kb_fast_transits.json /
  astro_kb_slow_gaps.json / astro_kb_cycles.json — flat researched entries (astro_lexicon.kb_entry)
  astro_returns.progressed_phase() — Rudhyar's progressed lunation phase (soul-cycle climate)
  astro_timing.profection()        — the year's time-lord (soul-cycle context)

Tropical Western astrology ONLY (never Vedic/sidereal/nakshatras/Rahu-Ketu). Astrology only — never
trading, markets, stocks or positions.

CLI: astro_esoteric.py [--date YYYY-MM-DD]   (computed for 08:30 ET on that date; default: now)
"""
from __future__ import annotations

import sys
from datetime import date, datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T          # noqa: E402
import astro_events as E         # noqa: E402
import astro_lexicon as lex      # noqa: E402

ET = ZoneInfo("America/New_York")
GLYPH = E.GLYPH
TOP_N = 3


# ── small esoteric-lookup helpers (never invent — only read the KB) ───────────
def _first_clause(text: str) -> str:
    """The first clause of a long KB sentence (before ';'), capitalized, one tight line."""
    text = (text or "").strip()
    if not text:
        return ""
    clause = text.split(";")[0].strip()
    return clause[:1].upper() + clause[1:] if clause else ""


def _planet_eso(name: str) -> str:
    return lex.PLANETS.get(name, {}).get("eso", "")


def _sign_eso(sign: str) -> tuple[str, str]:
    """(esoteric keynote, esoteric ruler) for a sign, or ('', '') if unknown."""
    s = lex.SIGNS.get(sign, {})
    return s.get("eso", ""), s.get("eso_ruler", "")


def _house_eso(house: int | None) -> str:
    if not house or not (1 <= house <= 12):
        return ""
    return lex.HOUSES[house - 1].get("eso", "")


def _researched_line(e: dict) -> str:
    """Prefer a researched KB entry / combo over generic text; empty if nothing fits."""
    t, n, a = e["moving_body"], e.get("target_body"), e.get("aspect")
    entry = lex.kb_entry(e.get("key", ""))
    if entry and entry.get("esoteric"):
        return entry["esoteric"]
    combo = lex.combo_translation(f"{t} {a} natal {n}") or lex.combo_translation(f"{t} {a} {n}")
    if combo:
        return combo
    mike = lex.kb_get("planets", n or "", "in_mikes_chart")
    if mike:
        return mike
    th = e.get("target_house")
    if th:
        mike_h = lex.kb_get("houses", str(th), "in_mikes_chart")
        if mike_h:
            return mike_h
    return ""


def _practice_line(top: dict) -> str:
    """A reflective seed thought for the top transit — deterministic, from KB content only."""
    entry = lex.kb_entry(top.get("key", ""))
    if entry:
        p = entry.get("weekly_practice") or entry.get("do")
        if p:
            return p
    asp = lex.ASPECTS.get(top.get("aspect", ""), {})
    if asp.get("work"):
        return asp["work"]
    return "Sit with what is live today; let the geometry finish what it started."


# ── soul-level climate line (progressed lunation phase + profection + top theme) ──
def _soul_climate(when: datetime, events: list[dict]) -> str:
    d = when.date()
    bits: list[str] = []
    try:
        import astro_returns
        ph = astro_returns.progressed_phase(d)
        phase_key = ph.get("phase")
        meaning = lex.KB.get("lunation_phases", {}).get(phase_key, {})
        eso = meaning.get("esoteric") or meaning.get("traditional")
        if phase_key and eso:
            bits.append(f"Progressed {phase_key.replace('_', ' ')} moon: {eso}")
    except Exception:
        pass
    try:
        import astro_timing
        prof = astro_timing.profection(d)
        if prof.get("house") and prof.get("lord"):
            bits.append(f"A {T.ordinal(prof['house'])}-house profection year, time-lord {prof['lord']}.")
    except Exception:
        pass
    # include_context=False: themes must stay tied to `when`, never the real wall-clock "today"
    # (astro_events.context_factors() has no date parameter and always reads the live day).
    th = E.themes(events, include_context=False)
    if th:
        top_theme = th[0]
        bits.append(f"The live thread underneath it all: {top_theme['label']} ({top_theme['tone']}).")
    if not bits:
        bits.append("A quiet stretch on the soul-level dial — nothing insists on being seen today.")
    return " ".join(bits)


# ── one live transit → fact line + esoteric read ──────────────────────────────
def _event_block(e: dict, today: date, seen: set[str]) -> list[str]:
    t, n, a = e["moving_body"], e.get("target_body"), e.get("aspect")
    glyph = GLYPH.get(a, "")
    pass_bit = f", {e['pass_label']} ({e['pass_number']}/{e['pass_total']})" if e.get("pass_label") else ""
    fact = (f"{glyph} {e.get('key', f'Transiting {t} {a} natal {n}')} — orb {e['orb']:.2f}°, "
            f"{e.get('motion', '')}{pass_bit}, exact {E.when_label(e, today)}")
    if e.get("moving_degree") and e.get("target_degree"):
        fact += f". {t} at {e['moving_degree']} → natal {n} at {e['target_degree']}."
    lines = [fact]

    tp_eso, np_eso = _first_clause(_planet_eso(t)), _first_clause(_planet_eso(n))
    if tp_eso or np_eso:
        joined = "; ".join(x for x in (tp_eso, np_eso) if x)
        lines.append(f"Esoterically: {joined}.")

    sign = e.get("sign")
    sign_eso, sign_ruler = _sign_eso(sign) if sign else ("", "")
    house_eso = _house_eso(e.get("target_house"))
    if sign_eso or house_eso:
        parts = []
        if sign_eso:
            ruler_bit = f" (esoteric ruler {sign_ruler})" if sign_ruler else ""
            parts.append(f"{sign}{ruler_bit}: {_first_clause(sign_eso)}")
        if house_eso:
            parts.append(f"your {T.ordinal(e['target_house'])} house as a field of soul experience: {_first_clause(house_eso)}")
        lines.append(" — ".join(parts) + ".")

    researched = _researched_line(e)
    if researched and researched not in seen:
        seen.add(researched)
        lines.append(researched if researched.endswith((".", "!", "?")) else researched + ".")
    return lines


# ── esoteric ruler of the rising sign ──────────────────────────────────────────
def _ruler_note(when: datetime) -> list[str]:
    asc_lon = T.ANGLES["ASC"]
    asc_sign = T.SIGNS[int(asc_lon // 30)]
    eso_ruler = lex.SIGNS.get(asc_sign, {}).get("eso_ruler", "")
    if not eso_ruler:
        return []
    keynote = _first_clause(lex.SIGNS[asc_sign].get("eso", ""))
    lines = [f"Esoteric ruler of your {asc_sign} rising: {eso_ruler}. {keynote}."]
    if eso_ruler in T.BODIES:
        natal = T.natal().get(eso_ruler)
        jd = T.jd_for(when)
        lon, spd = T.lon_speed(jd, eso_ruler)
        cur = T.describe(lon, spd)
        if natal:
            lines.append(f"Natally {eso_ruler} sits at {natal['dms']} ({T.ordinal(natal['house'])} house).")
        lines.append(f"Right now transiting {eso_ruler} is at {cur['dms']} ({T.ordinal(cur['house'])} house), "
                     f"{'retrograde' if cur['rx'] else 'direct'}.")
        planet_eso = _first_clause(_planet_eso(eso_ruler))
        if planet_eso:
            lines.append(f"{planet_eso}.")
    return lines


# ── the post ────────────────────────────────────────────────────────────────
def esoteric_post(when: datetime | None = None) -> str:
    when = when or T.now_local()
    if when.tzinfo is None:
        when = when.replace(tzinfo=ET)
    today = when.astimezone(ET).date()
    events = E.current_transits(when)
    top = events[: min(TOP_N, len(events))]

    parts: list[str] = []
    parts.append(f"\U0001f702 ESOTERIC READ — {when.strftime('%a %b %-d')}")
    parts.append(_soul_climate(when, events))

    seen: set[str] = set()
    for e in top:
        parts.append("\n".join(_event_block(e, today, seen)))

    ruler = _ruler_note(when)
    if ruler:
        parts.append("\n".join(ruler))

    if top:
        parts.append(f"\U0001f56f Practice: {_practice_line(top[0])}")

    return "\n\n".join(p for p in parts if p).strip()



# ── NATAL esoteric (Mike 2026-09-28: "natal esoteric as well in a different message — planet,
# house, sign"). Positions/signs/houses are computed (astro_truth.natal); each placement gets the
# esoteric meaning of the planet, the sign (with its esoteric ruler), the house, and — when the
# researched KB entry matches the COMPUTED sign+house — the combined soul-reading. ─────────────────
NATAL_ORDER = ["Sun", "Moon", "ASC", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
               "Pluto", "Chiron", "Ceres", "Juno", "Hades", "Apollon", "MC", "DSC"]
_ANGLE_NAME = {"ASC": "Ascendant", "MC": "Midheaven", "DSC": "Descendant"}
_PATTERN_COMBOS = ("Mars conjunct the", "Sun conjunct Alpha Crucis", "The Saturn-Mars-Uranus/Neptune t-square")


def _combo_for(name: str, sign: str, house: int | None) -> dict | None:
    """Researched natal combo whose name matches the computed placement (never a mismatched one)."""
    for c in lex.KB.get("natal_combos", []):
        nm = c.get("name", "")
        if name in _ANGLE_NAME:
            if sign in nm and (name in nm or _ANGLE_NAME[name] in nm):
                return c
        elif nm.startswith(f"{name} in {sign}") and (house is None or f"the {T.ordinal(house)}" in nm):
            return c
    return None


def natal_esoteric_post() -> str:
    nat = T.natal()
    out = ["🜃 YOUR NATAL CHART, ESOTERICALLY — planet · sign · house (tropical, Placidus; positions computed)",
           f"Cancer rising → exoteric ruler Moon, esoteric ruler {lex.SIGNS['Cancer'].get('eso_ruler', 'Neptune')}.", ""]
    for n in NATAL_ORDER:
        v = nat[n]
        sign, house = v["sign"], v.get("house")
        glyph = lex._KEY_GLYPH.get(n, "•")
        head = f"{glyph} {_ANGLE_NAME.get(n, n)} {v['dms']}" + (f" · {T.ordinal(house)} house" if house and n not in _ANGLE_NAME else "") + (" ℞" if v.get("rx") else "")
        block = [head]
        p_eso = lex.kb_get("planets", n, "esoteric") or lex.PLANETS.get(n, {}).get("eso", "")
        if p_eso:
            block.append(f"  ✧ {_ANGLE_NAME.get(n, n)}: {lex._first_sentence(p_eso, 220)}")
        s_eso = lex.kb_get("signs", sign, "esoteric") or lex.SIGNS[sign].get("eso", "")
        block.append(f"  ✧ {sign} (esoteric ruler {lex.SIGNS[sign].get('eso_ruler', '—')}): {lex._first_sentence(s_eso, 220)}")
        if house and n not in _ANGLE_NAME:
            h_eso = lex.kb_get("houses", str(house), "esoteric") or lex.HOUSES[house - 1].get("eso", "")
            block.append(f"  ✧ {T.ordinal(house)} house: {lex._first_sentence(h_eso, 200)}")
        c = _combo_for(n, sign, house if n not in _ANGLE_NAME else None)
        if c and c.get("esoteric"):
            block.append(f"  ⟡ Together: {c['esoteric'].rstrip('.')}." + (f" In plain words: {c['translation']}" if c.get("translation") else ""))
        out.append("\n".join(block))
    pats = [c for c in lex.KB.get("natal_combos", []) if c.get("name", "").startswith(_PATTERN_COMBOS)]
    if pats:
        out.append("🔺 PATTERNS")
        for c in pats:
            out.append(f"• {c['name']}: {c.get('esoteric', '').rstrip('.')}." + (f" {c['translation']}" if c.get("translation") else ""))
    return "\n\n".join(out)

if __name__ == "__main__":
    import argparse

    ap = argparse.ArgumentParser(description="Esoteric read of Mike's current transits.")
    ap.add_argument("--date", help="YYYY-MM-DD (computed for 08:30 ET that date; default: now)")
    args = ap.parse_args()
    if args.date:
        dd = date.fromisoformat(args.date)
        when_arg = datetime(dd.year, dd.month, dd.day, 8, 30, tzinfo=ET)
    else:
        when_arg = T.now_local()
    print(esoteric_post(when_arg))
