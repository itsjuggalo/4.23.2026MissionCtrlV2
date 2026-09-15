#!/usr/bin/env python3
"""astro_timing.py — traditional timing layers, computed live (free, pyswisseph):
  • annual + monthly profections (whole-sign from the Cancer ASC; time-lord = sign ruler)
  • planetary hours for Dunedin FL (sunrise→sunset split in 12, Chaldean order)
Researched meanings attach by key from astro_kb_timing.json via astro_lexicon.kb_entry.

CLI: astro_timing.py profection | hours | firdaria | today
"""
from __future__ import annotations
import sys
from datetime import date, datetime, timedelta
import swisseph as swe
import astro_truth as T
import astro_lexicon as lex

BIRTH = date(1992, 11, 3)                       # local date (10:46 PM EST)
RULER = {"Aries": "Mars", "Taurus": "Venus", "Gemini": "Mercury", "Cancer": "Moon", "Leo": "Sun", "Virgo": "Mercury",
         "Libra": "Venus", "Scorpio": "Mars", "Sagittarius": "Jupiter", "Capricorn": "Saturn", "Aquarius": "Saturn", "Pisces": "Jupiter"}
CHALDEAN = ["Saturn", "Jupiter", "Mars", "Sun", "Venus", "Mercury", "Moon"]
DAY_RULER = {0: "Moon", 1: "Mars", 2: "Mercury", 3: "Jupiter", 4: "Venus", 5: "Saturn", 6: "Sun"}   # Monday=0
ASC_SIGN_IDX = int(T.ANGLES["ASC"] // 30)       # Cancer = 3


def age_on(d: date) -> int:
    return d.year - BIRTH.year - ((d.month, d.day) < (BIRTH.month, BIRTH.day))


def profection(d: date | None = None) -> dict:
    d = d or datetime.now(T.ET).date()
    age = age_on(d)
    house = age % 12 + 1
    sign = T.SIGNS[(ASC_SIGN_IDX + age) % 12]
    lord = RULER[sign]
    # monthly profection: one whole-sign house per month from the birthday, counting on from the year's house
    last_bday = date(d.year if (d.month, d.day) >= (BIRTH.month, BIRTH.day) else d.year - 1, BIRTH.month, BIRTH.day)
    months = (d.year - last_bday.year) * 12 + d.month - last_bday.month - (d.day < last_bday.day)
    m_house = (house - 1 + months) % 12 + 1
    m_sign = T.SIGNS[(ASC_SIGN_IDX + age + months) % 12]
    nat = T.natal()
    lord_nat = nat.get(lord, {})
    return {"age": age, "house": house, "sign": sign, "lord": lord, "year_from": last_bday.isoformat(),
            "year_to": date(last_bday.year + 1, BIRTH.month, BIRTH.day).isoformat(),
            "month_house": m_house, "month_sign": m_sign, "month_lord": RULER[m_sign],
            "lord_natal": f"{lord} natal {lord_nat.get('deg', '?')}° {lord_nat.get('sign', '?')} ({T.ordinal(lord_nat.get('house', 0))} house)" if lord_nat else ""}


def profection_block(d: date | None = None) -> str:
    p = profection(d)
    lines = [f"⏳ PROFECTION — age {p['age']}: {T.ordinal(p['house'])}-house year in {p['sign']} · time-lord {p['lord']}",
             f"Year runs {p['year_from']} → {p['year_to']}. This month: {T.ordinal(p['month_house'])} house ({p['month_sign']}, lord {p['month_lord']}).",
             f"Your time-lord in the natal chart: {p['lord_natal']}. Transits to it count double this year."]
    lines += lex.entry_lines(f"Profection year {T.ordinal(p['house'])} house", full=True)
    lines += lex.entry_lines(f"Profection lord {p['lord']}", full=True)[:2]
    f = firdaria(d)
    lines.append(f"Firdaria: {f['major']} major period (ages {f['major_years']}), {f['sub']} sub-period now — /firdaria for the read.")
    nxt = profection(date.fromisoformat(p["year_to"]))
    lines.append(f"Next year (from {p['year_to']}): {T.ordinal(nxt['house'])} house in {nxt['sign']}, lord {nxt['lord']}.")
    return "\n".join(lines)


# ── Firdaria (Persian time-lords), NIGHT chart (born 10:46 PM) ─────────────────────────
FIRDARIA_NIGHT = [("Moon", 9), ("Saturn", 11), ("Jupiter", 12), ("Mars", 7), ("Sun", 10), ("Venus", 8), ("Mercury", 13),
                  ("North Node", 3), ("South Node", 2)]
PLANET_SEQ = [p for p, _ in FIRDARIA_NIGHT[:7]]


def firdaria(d: date | None = None) -> dict:
    d = d or datetime.now(T.ET).date()
    yrs = (d - BIRTH).days / 365.2425
    cycle = yrs % 75
    start = 0.0
    for lord, span in FIRDARIA_NIGHT:
        if cycle < start + span:
            major_from = BIRTH.year + int(start) + (yrs // 75) * 75
            if lord in PLANET_SEQ:                       # 7 equal sub-periods starting with the major lord
                sub_len = span / 7
                k = int((cycle - start) // sub_len)
                sub = PLANET_SEQ[(PLANET_SEQ.index(lord) + k) % 7]
                sub_from = start + k * sub_len
                return {"major": lord, "major_years": f"{int(start)}–{int(start + span)}", "sub": sub,
                        "sub_years": f"{sub_from:.1f}–{sub_from + sub_len:.1f}", "age": round(yrs, 1),
                        "sub_index": k + 1, "sub_of": 7}
            return {"major": lord, "major_years": f"{int(start)}–{int(start + span)}", "sub": lord, "sub_years": "", "age": round(yrs, 1), "sub_index": 1, "sub_of": 1}
        start += span
    return {}


def firdaria_block(d: date | None = None) -> str:
    f = firdaria(d)
    lines = [f"🕯 FIRDARIA (night chart) — major {f['major']} (ages {f['major_years']}) · sub-period {f['sub']} ({f['sub_index']} of {f['sub_of']}, ages {f['sub_years']}) · you are {f['age']}"]
    lines += lex.entry_lines(f"Firdaria {f['major']}", full=True)[:5]
    if f["sub"] != f["major"]:
        sub = lex.kb_entry(f"Firdaria {f['sub']}")
        if sub:
            lines.append(f"Sub-lord {f['sub']}: {sub.get('translation', '')}")
    lines.append("Sequence (night): Moon 9y → Saturn 11 → Jupiter 12 → Mars 7 → Sun 10 → Venus 8 → Mercury 13 → North Node 3 → South Node 2.")
    return "\n".join(lines)


def _rise_set(d: date) -> tuple[datetime, datetime, datetime]:
    """Sunrise, sunset (that day) and next sunrise, as ET datetimes."""
    jd0 = swe.julday(d.year, d.month, d.day, 4.0)             # 00:00 ET ≈ 04:00 UT (EDT) — search from local midnight
    flags = swe.FLG_SWIEPH
    def _next(jd, what):
        return swe.rise_trans(jd, swe.SUN, what | swe.BIT_DISC_CENTER, (T.LON, T.LAT, 0), 1013.25, 15.0, flags)[1][0]
    rise = _next(jd0, swe.CALC_RISE)
    sset = _next(rise, swe.CALC_SET)
    rise2 = _next(sset, swe.CALC_RISE)
    def _dt(jd):
        y, m, dd, h = swe.revjul(jd)
        from datetime import timezone
        return datetime(y, m, dd, tzinfo=timezone.utc) + timedelta(hours=h)
    return _dt(rise).astimezone(T.ET), _dt(sset).astimezone(T.ET), _dt(rise2).astimezone(T.ET)


def planetary_hours(d: date | None = None) -> list[dict]:
    d = d or datetime.now(T.ET).date()
    rise, sset, rise2 = _rise_set(d)
    day_len, night_len = (sset - rise) / 12, (rise2 - sset) / 12
    start_idx = CHALDEAN.index(DAY_RULER[d.weekday()])
    out = []
    for i in range(24):
        t0 = rise + day_len * i if i < 12 else sset + night_len * (i - 12)
        t1 = t0 + (day_len if i < 12 else night_len)
        out.append({"n": i + 1, "ruler": CHALDEAN[(start_idx + i) % 7], "start": t0, "end": t1, "day": i < 12})
    return out


def current_hour(now: datetime | None = None) -> dict | None:
    now = now or datetime.now(T.ET)
    hrs = planetary_hours(now.date())
    if now < hrs[0]["start"]:                       # before sunrise → yesterday's night hours
        hrs = planetary_hours(now.date() - timedelta(days=1))
    for h in hrs:
        if h["start"] <= now < h["end"]:
            return h
    return None


def hours_block(d: date | None = None) -> str:
    d = d or datetime.now(T.ET).date()
    hrs = planetary_hours(d)
    lines = [f"🕰 PLANETARY HOURS — {d:%a %b %-d} (Dunedin FL) · day ruler {DAY_RULER[d.weekday()]}"]
    lines += lex.entry_lines(f"Planetary day {DAY_RULER[d.weekday()]}")
    cur = current_hour()
    for h in hrs:
        mark = " ← now" if cur and cur["start"] == h["start"] and cur["day"] == h["day"] else ""
        lines.append(f"{'☀' if h['day'] else '☾'} {h['start']:%-I:%M%p}–{h['end']:%-I:%M%p} {h['ruler']}{mark}")
    if cur:
        lines += lex.entry_lines(f"Planetary hour {cur['ruler']}", full=True)[:3]
    return "\n".join(lines)


def daily_line(now: datetime | None = None) -> str:
    """One compact line for the 8:32 send."""
    now = now or datetime.now(T.ET)
    p = profection(now.date())
    h = current_hour(now)
    f = firdaria(now.date())
    return (f"⏳ Profection: {T.ordinal(p['house'])}-house year ({p['sign']}), lord {p['lord']} · month: {T.ordinal(p['month_house'])} house · "
            f"day ruler {DAY_RULER[now.weekday()]}" + (f", hour {h['ruler']}" if h else "")
            + f"\n   Firdaria: {f['major']} period, {f['sub']} sub-period (tropical, whole-sign by convention)")


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "today"
    print({"profection": profection_block, "hours": hours_block, "firdaria": firdaria_block}.get(cmd, daily_line)())
