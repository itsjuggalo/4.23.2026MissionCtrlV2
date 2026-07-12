#!/usr/bin/env python3
"""daily_transits.py — Mike's real daily transit reading, Telegram'd each morning.

REAL astronomy, $0: Swiss Ephemeris (pyswisseph) computes today's planet
positions and aspects them against the natal chart (Nov 3 1992, 10:46 PM EST,
Dunedin FL — verified: Sun 12° Sco, Moon 1° Pis, ASC 27° Can, MC 19° Ari).
Whole-sign houses from the Cancer Ascendant. Cron: 8:32 ET daily.
"""
from __future__ import annotations

import argparse
import subprocess
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path

import swisseph as swe

TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
TG_FN = "trading_command"

SIGNS = ["Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
         "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"]
PLANETS = [("Sun", swe.SUN), ("Moon", swe.MOON), ("Mercury", swe.MERCURY),
           ("Venus", swe.VENUS), ("Mars", swe.MARS), ("Jupiter", swe.JUPITER),
           ("Saturn", swe.SATURN), ("Uranus", swe.URANUS),
           ("Neptune", swe.NEPTUNE), ("Pluto", swe.PLUTO)]

# natal: 1992-11-03 22:46 EST → 1992-11-04 03:46 UT · Dunedin FL
NATAL_JD = swe.julday(1992, 11, 4, 3 + 46 / 60)
LAT, LON = 28.0197, -82.7715

ASPECTS = [(0, "conjunct", "☌", "fused"), (60, "sextile", "﹡", "easy"),
           (90, "square", "□", "hard"), (120, "trine", "△", "easy"),
           (180, "opposite", "☍", "hard")]
ORB = {"Sun": 1.2, "Moon": 2.5, "Mercury": 1.0, "Venus": 1.0, "Mars": 1.0,
       "Jupiter": 0.8, "Saturn": 0.7, "Uranus": 0.6, "Neptune": 0.6, "Pluto": 0.6}

THEME = {  # transit planet → what it brings
    "Sun": "focus and visibility", "Moon": "the day's mood",
    "Mercury": "words, messages, decisions", "Venus": "money, ease, connection",
    "Mars": "drive, friction, urgency", "Jupiter": "expansion and luck",
    "Saturn": "pressure, structure, tests", "Uranus": "surprises and rewiring",
    "Neptune": "fog, intuition, idealism", "Pluto": "deep pressure and power shifts",
}
NATAL_PT = {  # natal point → what it touches in Mike
    "Sun": "your core self (Scorpio, 4th — home base, intensity)",
    "Moon": "your emotional depth (Pisces, 8th — the absorber)",
    "Mercury": "your thinking and speech (Sag, 5th)",
    "Venus": "your money and affection style (Sag, 5th)",
    "Mars": "your engine on the Ascendant (Cancer rising)",
    "Jupiter": "your growth channel (Libra, 3rd)",
    "Saturn": "your commitments (Aquarius, 7th)",
    "Uranus": "your inner engineer (Capricorn, 6th)",
    "Neptune": "your inner mystic (Capricorn, 6th)",
    "Pluto": "your transformer core (Scorpio)",
    "ASC": "your identity point (27° Cancer rising)",
    "MC": "your career point (19° Aries Midheaven)",
}
HOUSE_LIFE = ["identity", "money & self-worth", "communication & siblings",
              "home & foundations", "creativity, kids & speculation",
              "daily work & health", "partnerships", "shared money & the deep end",
              "beliefs & long journeys", "career & public standing",
              "friends & networks", "solitude & the hidden"]


def positions(jd):
    out = {}
    for name, p in PLANETS:
        r = swe.calc_ut(jd, p)
        out[name] = {"lon": r[0][0], "speed": r[0][3]}
    return out


def natal_points():
    pts = {n: v["lon"] for n, v in positions(NATAL_JD).items()}
    h = swe.houses(NATAL_JD, LAT, LON)
    pts["ASC"], pts["MC"] = h[1][0], h[1][1]
    return pts


def angle(a, b):
    d = abs(a - b) % 360
    return d if d <= 180 else 360 - d


def whole_sign_house(lon, asc_lon):
    return (int(lon // 30) - int(asc_lon // 30)) % 12  # 0-based


def sign_deg(lon):
    return f"{int(lon % 30)}° {SIGNS[int(lon // 30)]}"


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    args = ap.parse_args()

    now_utc = datetime.now(timezone.utc)
    now_et = now_utc - timedelta(hours=4)
    jd = swe.julday(now_utc.year, now_utc.month, now_utc.day,
                    now_utc.hour + now_utc.minute / 60)
    trans = positions(jd)
    natal = natal_points()
    asc = natal["ASC"]

    # aspects: transiting planets (skip Moon noise except to Sun/Moon/ASC/MC) vs natal points
    hits = []
    for tname, t in trans.items():
        for nname, nlon in natal.items():
            if tname == "Moon" and nname not in ("Sun", "Moon", "ASC", "MC"):
                continue
            for adeg, aname, glyph, quality in ASPECTS:
                orb = abs(angle(t["lon"], nlon) - adeg)
                if orb <= ORB[tname]:
                    hits.append({"t": tname, "n": nname, "aspect": aname,
                                 "glyph": glyph, "quality": quality, "orb": orb})
    hits.sort(key=lambda h: (h["t"] == "Moon", h["orb"]))  # slow/tight first

    moon = trans["Moon"]
    mh = whole_sign_house(moon["lon"], asc)
    lines = [f"🌌 DAILY TRANSITS — {now_et:%a %b %-d}",
             f"☽ Moon in {SIGNS[int(moon['lon'] // 30)]}, your {mh + 1}th house "
             f"({HOUSE_LIFE[mh]}) — where today's feelings live."]

    rx = [n for n, v in trans.items() if v["speed"] < 0 and n not in ("Sun", "Moon")]
    if rx:
        lines.append("↩ Retrograde: " + ", ".join(rx) +
                     (" — double-check orders/messages before sending." if "Mercury" in rx else ""))

    if hits:
        lines.append("")
        for h in hits[:5]:
            verb = {"easy": "supports", "hard": "pressures", "fused": "amplifies"}[h["quality"]]
            lines.append(f"{h['glyph']} {h['t']} {h['aspect']} natal {h['n']} "
                         f"(orb {h['orb']:.1f}°) — {THEME[h['t']].capitalize()} {verb} "
                         f"{NATAL_PT[h['n']]}.")
    else:
        lines.append("\nNo tight aspects today — a quiet sky. Trade the plan, not the stars.")

    # one trading-relevant line
    trade = []
    if "Mercury" in rx:
        trade.append("Mercury rx: slow down on tickets, re-read before you tap")
    hard_hits = [h for h in hits if h["quality"] == "hard" and h["t"] in ("Mars", "Saturn", "Pluto")]
    if hard_hits:
        trade.append("hard sky pressure — smaller size, wider patience")
    easy_moon = mh in (1, 4, 9)  # money, speculation, career houses (0-based)
    if easy_moon:
        trade.append(f"Moon lights your {HOUSE_LIFE[mh]} house — feelings there aren't signals")
    if trade:
        lines.append("\n📈 Desk note: " + "; ".join(trade) + ".")

    lines.append(f"\n☉ {sign_deg(trans['Sun']['lon'])} · full monthly map: your 2026 transit reading (Telegram, Jul 12)")
    msg = "\n".join(lines)
    print(msg)
    if args.send:
        subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, msg],
                       capture_output=True, timeout=30)
    return 0


if __name__ == "__main__":
    sys.exit(main())
