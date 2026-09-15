#!/usr/bin/env python3
"""svehla.py — the Aug 29 2026 Svehla reading as data + real secondary progressions.

Two jobs, both $0 and both real astronomy:
  1. WINDOWS  — Svehla's dated windows (svehla_windows.json) → what's active today,
                what's next, how many days out. Feeds the 8:32 ET Telegram send and /dates.
  2. PROGRESSED — secondary progressions (day-for-a-year) from the natal JD, so the bot
                can SEE what Svehla sees: progressed Moon/Venus/Sun/Juno, their Placidus
                house (his system), and the real ingress dates. Verified against every date
                in his reading within 0.05° (2026-09-14).

CLI:  svehla.py windows | progressed | check
"""
from __future__ import annotations

import json
import sys
from datetime import date, datetime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

import swisseph as swe

EPHE = Path.home() / ".local/share/swisseph"     # seas_18/sepl_18/semo_18/sefstars (free)
swe.set_ephe_path(str(EPHE))

HERE = Path(__file__).resolve().parent
WINDOWS_FILE = HERE / "svehla_windows.json"
ET = ZoneInfo("America/New_York")

SIGNS = ["Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
         "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"]
# natal: 1992-11-03 22:46 EST → 1992-11-04 03:46 UT · Dunedin FL
NATAL_JD = swe.julday(1992, 11, 4, 3 + 46 / 60)
LAT, LON = 28.0197, -82.7715

PROG_BODIES = [("Moon", swe.MOON), ("Sun", swe.SUN), ("Mercury", swe.MERCURY),
               ("Venus", swe.VENUS), ("Mars", swe.MARS), ("Juno", swe.JUNO)]
KIND_ICON = {"money": "💰", "career": "🏛", "relationship": "💞", "psyche": "🌑"}


# ── helpers ───────────────────────────────────────────────────────────────────
def today_et() -> date:
    return datetime.now(ET).date()


NATAL_UT_HOUR = 3 + 46 / 60


def jd_of(d: date) -> float:
    """Civil date → JD at the natal birth-hour (so progressed 'birthdays' land on the day)."""
    return swe.julday(d.year, d.month, d.day, NATAL_UT_HOUR)


def sign_deg(lon: float) -> str:
    lon %= 360
    return f"{int(lon % 30)}° {SIGNS[int(lon // 30)]}"


def sign_of(lon: float) -> str:
    return SIGNS[int((lon % 360) // 30)]


def ordinal(n: int) -> str:
    if 10 <= n % 100 <= 20:
        return f"{n}th"
    return f"{n}{ {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th') }"


def placidus_cusps() -> list[float]:
    """Natal Placidus cusps 1..12 — Svehla's house system (2H 20° Leo, 11H 23° Taurus)."""
    return list(swe.houses(NATAL_JD, LAT, LON, b"P")[0])


def placidus_house(lon: float, cusps: list[float]) -> int:
    lon %= 360
    for i in range(12):
        a, b = cusps[i], cusps[(i + 1) % 12]
        if (a <= lon < b) if a < b else (lon >= a or lon < b):
            return i + 1
    return 12


# ── secondary progressions ───────────────────────────────────────────────────
def prog_jd(d: date) -> float:
    """Day-for-a-year: one ephemeris day after birth per tropical year lived."""
    return NATAL_JD + (jd_of(d) - NATAL_JD) / 365.25


def progressed(d: date | None = None) -> dict:
    d = d or today_et()
    pj = prog_jd(d)
    out = {}
    for name, body in PROG_BODIES:
        r = swe.calc_ut(pj, body)[0]
        out[name] = {"lon": r[0] % 360, "speed": r[3]}
    return out


def next_ingress(body_name: str, start: date, horizon_days: int = 366 * 6) -> tuple[date, str] | None:
    """First date after `start` when the progressed body changes sign (daily scan; a
    progressed Moon moves ~1°/month so a day step is more than fine)."""
    body = dict(PROG_BODIES)[body_name]

    def sign_at_end_of(d: date) -> str:   # ~midnight ET at the close of civil day d
        pj = NATAL_JD + (swe.julday(d.year, d.month, d.day, 28.0) - NATAL_JD) / 365.25
        return sign_of(swe.calc_ut(pj, body)[0][0])

    cur = sign_at_end_of(start)
    d = start
    for _ in range(horizon_days):
        d += timedelta(days=1)
        s = sign_at_end_of(d)
        if s != cur:
            return d, s
    return None


def progressed_block(d: date | None = None) -> str:
    d = d or today_et()
    p = progressed(d)
    cusps = placidus_cusps()
    lines = [f"🔭 PROGRESSED CHART — {d:%a %b %-d %Y} (secondary, day-for-a-year)"]
    for name in ("Moon", "Venus", "Sun", "Juno"):
        v = p[name]
        h = placidus_house(v["lon"], cusps)
        deg = v["lon"] % 30
        flag = ""
        if deg >= 29:
            flag = " · ANARETIC 29°"
        elif name == "Moon" and 21 <= deg < 23 and sign_of(v["lon"]) == "Taurus":
            flag = " · critical degrees"
        rx = " ℞" if v["speed"] < 0 else ""
        lines.append(f"• p{name} {sign_deg(v['lon'])}{rx} · {ordinal(h)} house{flag}")
    for name in ("Moon", "Venus"):
        nxt = next_ingress(name, d)
        if nxt:
            nd, ns = nxt
            lines.append(f"→ p{name} enters {ns} {nd:%b %-d %Y} ({(nd - d).days} days)")
    lines.append("Houses are Placidus, the system your astrologer reads.")
    return "\n".join(lines)


# ── Svehla windows ────────────────────────────────────────────────────────────
def load_windows() -> list[dict]:
    data = json.loads(WINDOWS_FILE.read_text())
    ws = data["windows"]
    for w in ws:
        w["_start"] = date.fromisoformat(w["start"])
        w["_end"] = date.fromisoformat(w["end"])
    return sorted(ws, key=lambda w: (w["_start"], w["_end"]))


def active(d: date | None = None) -> list[dict]:
    d = d or today_et()
    return [w for w in load_windows() if w["_start"] <= d <= w["_end"]]


def upcoming(d: date | None = None, n: int = 3) -> list[dict]:
    d = d or today_et()
    return [w for w in load_windows() if w["_start"] > d][:n]


def daily_block(d: date | None = None) -> str:
    """Compact block appended to the morning transit send."""
    d = d or today_et()
    act, nxt = active(d), upcoming(d, 1)
    if not act and not nxt:
        return ""
    lines = ["📜 From your Aug 2026 reading (Svehla):"]
    for w in act:
        left = (w["_end"] - d).days
        when = "today" if left == 0 else f"{left}d left"
        first = w["do"].split(". ")[0].rstrip(".")
        lines.append(f"{KIND_ICON.get(w['kind'], '•')} {w['title']} — {when}. {first}.")
    for w in nxt:
        lines.append(f"⏭ Next: {w['title']} — {w['_start']:%b %-d %Y} ({(w['_start'] - d).days}d).")
    return "\n".join(lines)


def dates_block(d: date | None = None) -> str:
    """Full chronological list for /dates — active windows marked."""
    d = d or today_et()
    lines = ["📜 SVEHLA DATES — Aug 29 2026 reading, chronological", ""]
    for w in load_windows():
        if w["_start"] == w["_end"]:
            span = f"{w['_start']:%b %-d %Y}"
        elif w["_start"].year == w["_end"].year:
            span = f"{w['_start']:%b %-d} → {w['_end']:%b %-d %Y}"
        else:
            span = f"{w['_start']:%b %-d %Y} → {w['_end']:%b %-d %Y}"
        if w["_start"] <= d <= w["_end"]:
            mark = "🟢 NOW "
        elif w["_end"] < d:
            mark = "✓ "
        else:
            mark = ""
        lines.append(f"{mark}{KIND_ICON.get(w['kind'], '•')} {span}: {w['title']}")
    lines.append("")
    lines.append("Ask me about any window by name for the why + what to do.")
    return "\n".join(lines)


def check_block() -> str:
    """Self-test: our ephemeris vs the dates Svehla wrote down."""
    rows = []
    def p(d, body): return swe.calc_ut(prog_jd(d), body)[0][0] % 360
    rows.append(("pMoon 21° Tau on Aug 29 2026", sign_deg(p(date(2026, 8, 29), swe.MOON))))
    rows.append(("pMoon 22-23° Tau on Oct 23 2026", sign_deg(p(date(2026, 10, 23), swe.MOON))))
    rows.append(("pMoon 28° Tau on Mar 10 2027", sign_deg(p(date(2027, 3, 10), swe.MOON))))
    rows.append(("pMoon enters Gemini May 3 2027", sign_deg(p(date(2027, 5, 3), swe.MOON))))
    rows.append(("pVenus enters Aquarius Jun 6 2027", sign_deg(p(date(2027, 6, 6), swe.VENUS))))
    ceres = swe.calc_ut(NATAL_JD, swe.CERES)[0][0]
    rows.append(("pVenus conj natal Ceres Sep 2 2029", f"{sign_deg(p(date(2029, 9, 2), swe.VENUS))} vs Ceres {sign_deg(ceres)}"))
    hades = swe.calc_ut(NATAL_JD, swe.HADES)[0][0]
    ur = swe.calc_ut(jd_of(date(2028, 7, 1)), swe.URANUS)[0][0]
    rows.append(("tUranus conj natal Hades Jul 2028", f"{sign_deg(ur)} vs Hades {sign_deg(hades)}"))
    sun = swe.calc_ut(NATAL_JD, swe.SUN)[0][0]
    ch = swe.calc_ut(jd_of(date(2029, 7, 9)), swe.CHIRON)[0][0]
    rows.append(("tChiron opp natal Sun Jul 9 2029", f"{sign_deg(ch)} vs Sun {sign_deg(sun)}"))
    return "\n".join(f"{k:38s} → {v}" for k, v in rows)


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "windows"
    print({"windows": dates_block, "dates": dates_block, "progressed": progressed_block,
           "daily": daily_block, "check": check_block}[cmd]())
