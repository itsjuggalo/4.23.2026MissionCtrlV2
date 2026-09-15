#!/usr/bin/env python3
"""astro_timing.py — traditional timing layers, computed live (free, pyswisseph):
  • annual + monthly profections (whole-sign from the Cancer ASC; time-lord = sign ruler)
  • planetary hours for Dunedin FL (sunrise→sunset split in 12, Chaldean order)
  • Moon's sidereal nakshatra (Lahiri) — the daily lunar-mansion timing tool
Researched meanings attach by key from astro_kb_timing.json via astro_lexicon.kb_entry.

CLI: astro_timing.py profection | hours | nakshatra | today
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
NAKSHATRAS = ["Ashwini", "Bharani", "Krittika", "Rohini", "Mrigashira", "Ardra", "Punarvasu", "Pushya", "Ashlesha",
              "Magha", "Purva Phalguni", "Uttara Phalguni", "Hasta", "Chitra", "Swati", "Vishakha", "Anuradha", "Jyeshtha",
              "Mula", "Purva Ashadha", "Uttara Ashadha", "Shravana", "Dhanishta", "Shatabhisha", "Purva Bhadrapada",
              "Uttara Bhadrapada", "Revati"]
NAK_RULER = ["Ketu", "Venus", "Sun", "Moon", "Mars", "Rahu", "Jupiter", "Saturn", "Mercury"] * 3
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
    nxt = profection(date.fromisoformat(p["year_to"]))
    lines.append(f"Next year (from {p['year_to']}): {T.ordinal(nxt['house'])} house in {nxt['sign']}, lord {nxt['lord']}.")
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


def nakshatra(when: datetime | None = None) -> dict:
    when = when or datetime.now(T.ET)
    jd = T.jd_for(when)
    swe.set_sid_mode(swe.SIDM_LAHIRI)
    lon = swe.calc_ut(jd, swe.MOON, swe.FLG_SWIEPH | swe.FLG_SIDEREAL)[0][0] % 360
    idx = int(lon // (360 / 27))
    pada = int((lon % (360 / 27)) // (360 / 108)) + 1
    return {"name": NAKSHATRAS[idx], "ruler": NAK_RULER[idx], "pada": pada, "sidereal_lon": round(lon, 2),
            "sidereal_sign": T.SIGNS[int(lon // 30)]}


def natal_nakshatra() -> dict:
    swe.set_sid_mode(swe.SIDM_LAHIRI)
    lon = swe.calc_ut(T.NATAL_JD, swe.MOON, swe.FLG_SWIEPH | swe.FLG_SIDEREAL)[0][0] % 360
    idx = int(lon // (360 / 27))
    return {"name": NAKSHATRAS[idx], "ruler": NAK_RULER[idx], "sidereal_lon": round(lon, 2)}


def nakshatra_block(when: datetime | None = None) -> str:
    n = nakshatra(when)
    nn = natal_nakshatra()
    lines = [f"🌙 MOON'S NAKSHATRA — {n['name']} (pada {n['pada']}, ruler {n['ruler']}), sidereal {n['sidereal_lon']:.1f}° = {n['sidereal_sign']}"]
    lines += lex.entry_lines(f"Moon in nakshatra {n['name']}", full=True)
    lines.append(f"Your natal Moon nakshatra: {nn['name']} (ruler {nn['ruler']}). Days when the Moon returns there are your monthly reset.")
    return "\n".join(lines)


def daily_line(now: datetime | None = None) -> str:
    """One compact line for the 8:32 send."""
    now = now or datetime.now(T.ET)
    p = profection(now.date())
    n = nakshatra(now)
    h = current_hour(now)
    ent = lex.kb_entry(f"Moon in nakshatra {n['name']}")
    nak = f"Moon in {n['name']}" + (f" — {ent['translation']}" if ent and ent.get("translation") else "")
    return (f"⏳ Profection: {T.ordinal(p['house'])}-house year ({p['sign']}), lord {p['lord']} · month: {T.ordinal(p['month_house'])} house · "
            f"day ruler {DAY_RULER[now.weekday()]}" + (f", hour {h['ruler']}" if h else "") + f"\n   {nak}")


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "today"
    print({"profection": profection_block, "hours": hours_block, "nakshatra": nakshatra_block}.get(cmd, daily_line)())
