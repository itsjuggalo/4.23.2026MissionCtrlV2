#!/usr/bin/env python3
"""daily_transits.py — Mike's real daily transit reading, Telegram'd each morning.

REAL astronomy, $0: Swiss Ephemeris (pyswisseph) computes today's planet
positions and aspects them against the natal chart (Nov 3 1992, 10:46 PM EST,
Dunedin FL — verified: Sun 12° Sco, Moon 1° Pis, ASC 27° Can, MC 19° Ari).
Placidus houses (Svehla's system; matches the natal readings). Cron: 8:32 ET daily.
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
from datetime import datetime, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

import swisseph as swe

sys.path.insert(0, str(Path(__file__).resolve().parent))
import svehla  # noqa: E402  — Aug 2026 reading windows + secondary progressions
import astro_lexicon as lex  # noqa: E402  — planets/signs/houses/aspects, practical + esoteric

swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))  # free se1 files (asteroids)
ET = ZoneInfo("America/New_York")

TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
TG_FN = "astrology"      # 2026-08-10: moved off trading_command → the astrology-only lane

SIGNS = ["Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
         "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"]
PLANETS = [("Sun", swe.SUN), ("Moon", swe.MOON), ("Mercury", swe.MERCURY),
           ("Venus", swe.VENUS), ("Mars", swe.MARS), ("Jupiter", swe.JUPITER),
           ("Saturn", swe.SATURN), ("Uranus", swe.URANUS),
           ("Neptune", swe.NEPTUNE), ("Pluto", swe.PLUTO),
           # 2026-09-14: the bodies Mike's astrologer (Svehla) actually reads
           ("Chiron", swe.CHIRON), ("Ceres", swe.CERES), ("Juno", swe.JUNO)]
# Slow Uranian points — natal-only (as transits they'd sit in orb for years)
NATAL_ONLY = [("Hades", swe.HADES), ("Apollon", swe.APOLLON)]

# natal: 1992-11-03 22:46 EST → 1992-11-04 03:46 UT · Dunedin FL
NATAL_JD = swe.julday(1992, 11, 4, 3 + 46 / 60)
LAT, LON = 28.0197, -82.7715

ASPECTS = [(0, "conjunct", "☌", "fused"), (60, "sextile", "﹡", "easy"),
           (90, "square", "□", "hard"), (120, "trine", "△", "easy"),
           (180, "opposite", "☍", "hard")]
ORB = {"Sun": 1.2, "Moon": 2.5, "Mercury": 1.0, "Venus": 1.0, "Mars": 1.0,
       "Jupiter": 0.8, "Saturn": 0.7, "Uranus": 0.6, "Neptune": 0.6, "Pluto": 0.6,
       "Chiron": 0.7, "Ceres": 0.6, "Juno": 0.8}

THEME = {  # transit planet → what it brings
    "Sun": "focus and visibility", "Moon": "the day's mood",
    "Mercury": "words, messages, decisions", "Venus": "money, ease, connection",
    "Mars": "drive, friction, urgency", "Jupiter": "expansion and luck",
    "Saturn": "pressure, structure, tests", "Uranus": "surprises and rewiring",
    "Neptune": "fog, intuition, idealism", "Pluto": "deep pressure and power shifts",
    "Chiron": "the old wound asking to be worked", "Ceres": "care, nourishment, fair pay",
    "Juno": "loyalty, fairness, the partnership contract",
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
    "DSC": "your partner point (27° Capricorn Descendant)",
    "Chiron": "your self-worth / money wound (Leo, 2nd)",
    "Ceres": "your self-care and fair-pay point (Aquarius)",
    "Juno": "your loyalty contract (11° Cancer, 12th)",
    "Hades": "your Hades point (12° Gemini — clearing the old, causality)",
    "Apollon": "your Apollon point (16° Libra — expansion of reach)",
}
HOUSE_LIFE = ["identity", "money & self-worth", "communication & siblings",
              "home & foundations", "creativity, kids & speculation",
              "daily work & health", "partnerships", "shared money & the deep end",
              "beliefs & long journeys", "career & public standing",
              "friends & networks", "solitude & the hidden"]


def positions(jd, bodies=PLANETS):
    out = {}
    for name, p in bodies:
        try:
            r = swe.calc_ut(jd, p)
        except swe.Error:      # asteroid file missing → skip that body, never crash the send
            continue
        out[name] = {"lon": r[0][0], "speed": r[0][3]}
    return out


def natal_points():
    pts = {n: v["lon"] for n, v in positions(NATAL_JD, PLANETS + NATAL_ONLY).items()}
    h = swe.houses(NATAL_JD, LAT, LON)
    pts["ASC"], pts["MC"] = h[1][0], h[1][1]
    pts["DSC"] = (h[1][0] + 180) % 360
    return pts


def angle(a, b):
    d = abs(a - b) % 360
    return d if d <= 180 else 360 - d


def whole_sign_house(lon, asc_lon=None):
    """0-based PLACIDUS house (name kept for call-site compat; switched 2026-09-15 so the daily
    lines agree with Svehla and the natal readings — Sun 4th, Moon 8th, Juno 12th)."""
    return lex.house_of(lon) - 1


def sign_deg(lon):
    return f"{int(lon % 30)}° {SIGNS[int(lon // 30)]}"


def ordinal(n):
    if 10 <= n % 100 <= 20:
        return f"{n}th"
    return f"{n}{ {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th') }"


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--dates", action="store_true", help="Svehla Aug-2026 windows, chronological")
    ap.add_argument("--progressed", action="store_true", help="secondary progressions today")
    ap.add_argument("--explain", action="store_true", help="full 4-level read of every aspect today")
    ap.add_argument("--lookup", nargs="+", metavar="KIND KEY", help="planet|sign|house|aspect <key>")
    args = ap.parse_args()
    if args.dates:
        print(svehla.dates_block()); return 0
    if args.progressed:
        print(svehla.progressed_block()); return 0
    if args.lookup:
        print(lex.lookup(args.lookup[0], " ".join(args.lookup[1:]))); return 0

    now_utc = datetime.now(timezone.utc)
    now_et = now_utc.astimezone(ET)
    jd = swe.julday(now_utc.year, now_utc.month, now_utc.day,
                    now_utc.hour + now_utc.minute / 60)
    trans = positions(jd)
    natal = natal_points()
    asc = natal["ASC"]

    # aspects: transiting planets (skip Moon noise except to Sun/Moon/ASC/MC) vs natal points
    hits = []
    for tname, t in trans.items():
        for nname, nlon in natal.items():
            if tname == "Moon" and nname not in ("Sun", "Moon", "ASC", "MC", "DSC"):
                continue
            if nname == "DSC" and tname not in ("Juno", "Venus", "Saturn", "Mars"):
                continue   # DSC only matters for the partnership bodies
            for adeg, aname, glyph, quality in ASPECTS:
                orb = abs(angle(t["lon"], nlon) - adeg)
                if orb <= ORB[tname]:
                    hits.append({"t": tname, "n": nname, "aspect": aname,
                                 "glyph": glyph, "quality": quality, "orb": orb})
    hits.sort(key=lambda h: (h["t"] == "Moon", h["orb"]))  # slow/tight first

    moon = trans["Moon"]
    mh = whole_sign_house(moon["lon"], asc)
    lines = [f"🌌 DAILY TRANSITS — {now_et:%a %b %-d}",
             f"☽ Moon in {SIGNS[int(moon['lon'] // 30)]}, your {ordinal(mh + 1)} house "
             f"({HOUSE_LIFE[mh]}) — where today's feelings live."]

    rx = [n for n, v in trans.items() if v["speed"] < 0 and n not in ("Sun", "Moon")]
    if rx:
        lines.append("↩ Retrograde: " + ", ".join(rx) +
                     (" — double-check orders/messages before sending." if "Mercury" in rx else ""))

    if args.explain:
        # /explain — the full four-level read (aspect · houses · signs · esoteric) of every hit
        out = [f"🔍 TODAY'S TRANSITS EXPLAINED — {now_et:%a %b %-d}", ""]
        for h in hits[:6]:
            th = whole_sign_house(trans[h["t"]]["lon"], asc) + 1
            out.append(f"{h['glyph']} {h['t']} ({sign_deg(trans[h['t']]['lon'])}, your {ordinal(th)}) "
                       f"{h['aspect']} natal {h['n']} ({sign_deg(natal[h['n']])}) · orb {h['orb']:.1f}°")
            out.append(lex.explain_hit(h, trans[h["t"]]["lon"], natal[h["n"]], asc, full=True))
            fit = svehla.fit_for(h["t"], h["n"], now_et.date())
            if fit:
                out.append(f"Svehla's thread: {fit}.")
            out.append("")
        if not hits:
            out.append("No tight aspects today. /planet /sign /house /aspect for the lexicon.")
        print("\n".join(out)); return 0

    if hits:
        lines.append("")
        seen_fit = set()
        for i, h in enumerate(hits[:5]):
            verb = {"easy": "supports", "hard": "pressures", "fused": "amplifies"}[h["quality"]]
            th = whole_sign_house(trans[h["t"]]["lon"], asc) + 1
            nh = whole_sign_house(natal[h["n"]], asc) + 1
            lines.append(f"{h['glyph']} {h['t']} (in {SIGNS[int(trans[h['t']]['lon'] // 30)]}, your {ordinal(th)}) "
                         f"{h['aspect']} natal {h['n']} (your {ordinal(nh)}) · orb {h['orb']:.1f}° — "
                         f"{THEME[h['t']].capitalize()} {verb} {NATAL_PT[h['n']]}.")
            if i < 3:   # the three tightest/slowest get the personal + esoteric read inline
                lines.append("   " + lex.explain_hit(h, trans[h["t"]]["lon"], natal[h["n"]], asc).replace("\n", "\n   "))
            fit = svehla.fit_for(h["t"], h["n"], now_et.date())
            if fit and fit not in seen_fit:          # one line per thread, not per aspect
                seen_fit.add(fit)
                lines.append(f"   ↳ Svehla: {fit}.")
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

    # 2026-09-14: the Aug 2026 Svehla reading — active windows + what's next
    try:
        sv = svehla.daily_block(now_et.date())
        if sv:
            lines.append("\n" + sv)
    except Exception as e:      # never let the reading layer kill the send
        lines.append(f"\n📜 (Svehla windows unavailable: {e})")

    # 2026-09-15: verification stamp — astro_verify.py --all runs 08:25 ET (natal canon, hard-coded
    # texts, NASA Horizons cross-check, Svehla dates, this script's own output)
    try:
        st = json.loads((Path.home() / "portfolio/astrology/verify_status.json").read_text())
        when = st.get("when_et", "")[:16].replace("T", " ")
        lines.append(f"\n{'✔ chart engine verified' if st.get('ok') else '⚠️ chart engine verification FAILED'} "
                     f"(natal · texts · NASA Horizons · Svehla dates · output) {when} ET")
    except Exception:
        lines.append("\n⚠️ no verification stamp — run astro_verify.py --all")
    lines.append(f"☉ {sign_deg(trans['Sun']['lon'])} · /explain for the full read · /dates · /progressed · /planet /sign /house /aspect")
    msg = "\n".join(lines)
    print(msg)
    if args.send:
        for chunk in chunk_message(msg):          # Telegram caps a message at 4096 chars
            subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, chunk],
                           capture_output=True, timeout=30)
    return 0


def chunk_message(msg: str, limit: int = 3900) -> list[str]:
    """Split on paragraph breaks so no Telegram send exceeds the cap."""
    if len(msg) <= limit:
        return [msg]
    out, cur = [], ""
    for para in msg.split("\n\n"):
        cand = (cur + "\n\n" + para) if cur else para
        if len(cand) > limit and cur:
            out.append(cur); cur = para
        else:
            cur = cand
    if cur:
        out.append(cur)
    return out


if __name__ == "__main__":
    sys.exit(main())
