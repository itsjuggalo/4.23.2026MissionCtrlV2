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
from datetime import date, datetime, timedelta, timezone
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
BODY_IDS = dict(PLANETS)
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
    ap.add_argument("--full", action="store_true", help="print the complete read (the 8:32 send is a one-message digest when long)")
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

    # 2026-09-27 final round: hits are CANONICAL events (astro_events) — motion, exact time, pass
    # series, window, lifecycle and an explained priority. Ranked by priority, never by orb alone.
    import astro_events as AE
    events = AE.current_transits(now_et)
    hits = [{"t": e["moving_body"], "n": e["target_body"], "aspect": e["aspect"], "orb": e["orb"],
             "glyph": AE.GLYPH[e["aspect"]], "quality": {"conjunct": "fused", "square": "hard", "opposite": "hard"}.get(e["aspect"], "easy"),
             "event": e} for e in events]

    moon = trans["Moon"]
    mh = whole_sign_house(moon["lon"], asc)
    try:                                   # researched 'Moon through the Nth house' line (esoteric KB)
        _mt = lex.combo_translation(f"Transiting Moon through the {ordinal(mh + 1)} house")
        moon_note = " " + _mt.split(": ", 1)[-1].split(" (Esoteric:")[0] if _mt else " — where today's feelings live."
    except Exception:
        moon_note = " — where today's feelings live."
    # the KB line opens "For about two and a half days" whatever day of the transit it is —
    # swap in when the Moon actually leaves this house (10-min steps, bisected to the minute)
    try:
        step, j = 10 / 1440, jd
        while whole_sign_house(swe.calc_ut(j + step, swe.MOON)[0][0], asc) == mh and j - jd < 4:
            j += step
        lo, hi = j, j + step
        for _ in range(6):
            mid = (lo + hi) / 2
            lo, hi = (mid, hi) if whole_sign_house(swe.calc_ut(mid, swe.MOON)[0][0], asc) == mh else (lo, mid)
        leave = now_et + timedelta(days=hi - jd)
        leave = leave + timedelta(seconds=30)
        until = (f"In this house until {leave:%-I:%M %p} ET today" if leave.date() == now_et.date()
                 else f"In this house until {leave:%a %-I:%M %p} ET")
        if "For about two and a half days, " in moon_note:
            moon_note = moon_note.replace("For about two and a half days, ", until + ", ")
            moon_note = moon_note.replace(" for a day or two", "")
        else:
            moon_note += f" ({until.lower()})"
    except Exception:
        pass
    msign = SIGNS[int(moon["lon"] // 30)]
    try:                                   # C3: say when the SIGN changes, not only the house
        import astro_moon as _AM
        import astro_truth as _T
        ing = _T.round_minute(_T.jd_to_local(_AM.next_sign_ingress(_T.jd_for(now_et))))
        nsign = SIGNS[(SIGNS.index(msign) + 1) % 12]
        sign_txt = (f"Moon in {msign} → {nsign} {ing:%-I:%M %p} ET" if ing.date() == now_et.date()
                    else f"Moon in {msign} (→ {nsign} {ing:%a %-I:%M %p} ET)")
    except Exception:
        sign_txt = f"Moon in {msign}"
    lines = [f"🌌 DAILY TRANSITS — {now_et:%a %b %-d} (times ET)",
             f"☽ {sign_txt} · your {ordinal(mh + 1)} house "
             f"({HOUSE_LIFE[mh]}).{moon_note}"]

    rx = [n for n, v in trans.items() if v["speed"] < 0 and n not in ("Sun", "Moon")]
    # 2026-09-27 (Mike): the full retrograde list barely changes day to day — the morning send
    # only names a STATION (a planet turning within ±1 day); /full keeps the whole list
    stations = []
    for n in trans:
        if n in ("Sun", "Moon") or n not in BODY_IDS:
            continue
        try:
            before, after = (swe.calc_ut(jd + k, BODY_IDS[n])[0][3] for k in (-1, 1))
        except swe.Error:
            continue
        if (before < 0) != (after < 0):
            stations.append(f"{n} turns {'retrograde' if after < 0 else 'direct'}")
    if stations:
        lines.append("↩ Station: " + "; ".join(stations) + " (within a day) — the planet's theme is loudest now." +
                     (" Double-check messages before sending." if any(x.startswith("Mercury turns retro") for x in stations) else ""))
    elif args.full and rx:
        lines.append("↩ Retrograde: " + ", ".join(rx))

    if args.explain:
        # /explain — the full four-level read (aspect · houses · signs · esoteric) of every hit
        out = [f"🔍 TODAY'S TRANSITS EXPLAINED — {now_et:%a %b %-d}", ""]
        for h in hits[:6]:
            e = h["event"]
            th = whole_sign_house(trans[h["t"]]["lon"], asc) + 1
            out.append(f"{h['glyph']} Transiting {h['t']} ({sign_deg(trans[h['t']]['lon'])}, your {ordinal(th)}) "
                       f"{h['aspect']} natal {h['n']} ({sign_deg(natal[h['n']])}) · orb {h['orb']:.2f}° · {e['motion']}")
            out.append(lex.explain_hit(h, trans[h["t"]]["lon"], natal[h["n"]], asc, full=True))
            fit = svehla.fit_for(h["t"], h["n"], now_et.date())
            if fit:
                out.append(f"Svehla's thread: {fit}.")
            out.append("")
        if not hits:
            out.append("No tight aspects today. /planet /sign /house /aspect for the lexicon.")
        print("\n".join(out)); return 0

    # digest = top DIGEST_HITS by priority + (max 2) lower-ranked events that are NEW or EXACT today
    top = hits if args.full else _select_top(hits)
    shown = {(h["t"], h["aspect"], h["n"]) for h in top}
    changed = [f"{AE.GLYPH[h['aspect']]} {h['t']} {h['aspect']} {h['n']} {_changed_text(h['event']).replace(' since yesterday', '')}"
               for h in top if h["event"].get("changed")]
    if changed:
        lines.append("Δ Since yesterday: " + "; ".join(changed[:4]) + ".")
    if hits:
        lines.append("")
        lines.append("⚡ What's live, ranked (why: /full):" if not args.full else "⚡ What's live, ranked by importance:")
        for h in top:
            e = h["event"]
            lines.append(hit_line(e, trans, natal, now_et, digest=not args.full))
            detail = e["lifecycle"] in ("NEW", "EXACT") or (args.full and hits.index(h) < 3)
            if detail:     # the long read only on entry / exact day (Mike: describe change, not reprint)
                block = lex.explain_hit(h, trans[h["t"]]["lon"], natal[h["n"]], asc)
                if not args.full:
                    block = "\n".join(ln for ln in block.split("\n") if ln.startswith("In plain terms:"))
                lines.append("   " + block.replace("\n", "\n   "))
                fit = svehla.fit_for(h["t"], h["n"], now_et.date())
                if fit:
                    lines.append(f"   ↳ Svehla: {fit}.")
            if args.full:
                lines.append("   why it ranks: " + "; ".join(e["priority_reasons"]))
        if len(hits) > len(top):
            lines.append(f"   … +{len(hits) - len(top)} more in /full")
        th = AE.themes(events)
        if th:
            lines.append("")
            lines.append(AE.themes_line(th))
            if args.full:
                for t in th[:4]:
                    lines.append(f"   {t['label']} ({t['tone']}): " + "; ".join(t["evidence"][:5])
                                 + (f" · uncertain: {'; '.join(t['missing'])}" if t["missing"] else ""))
    else:
        lines.append("\nNo tight aspects today — a quiet sky.")

    # 2026-09-15 r7: sky quality · lunations/eclipses/stations/rx alerts · natal-pattern activation ·
    # progressed lunation phase. Each layer is optional (try/except) so the send never dies.
    try:
        import astro_lookahead
        q, why = astro_lookahead.score(now_et)
        pos_n, neg_n = sum(w.startswith("+") for w in why), sum(w.startswith("−") for w in why)
        lines.append(f"\n🎚 Sky quality {q}/10 — {pos_n} supportive vs {neg_n} challenging; biggest: "
                     + ("; ".join(why[:3]) if why else "quiet sky"))
    except Exception as e:
        lines.append(f"\n🎚 (quality unavailable: {e})")
    try:
        import astro_sky
        al = astro_sky.daily_alerts(now_et.date())
        try:
            import astro_truth as _T
            v = astro_sky.void_of_course(now_et)
            vs, vi = (_T.round_minute(datetime.fromisoformat(v[k])) for k in ("voc_start_et", "ingress_et"))
            if v["is_voc_now"] or vs.date() == now_et.date():
                al = [(f"🌫 Moon void-of-course now → {vi:%-I:%M %p} ET" if v["is_voc_now"] else
                       f"🌫 Moon void-of-course {vs:%a %-I:%M %p} → {vi:%a %-I:%M %p} ET")
                      + " — finish things, start nothing big."] + list(al or [])
        except Exception:
            pass
        if al:
            lines.append("\n🌒 Sky events (next 3 days):")
            lines.extend(al[:5])
    except Exception as e:
        lines.append(f"\n🌒 (sky events unavailable: {e})")
    try:
        import astro_patterns
        act = astro_patterns.pattern_activation({n: v["lon"] for n, v in trans.items()})
        if act:
            lines.append("\n🔺 Natal pattern lit today:")
            lines.extend(act[:3] if isinstance(act, list) else [str(act)])
    except Exception as e:
        lines.append(f"\n🔺 (pattern check unavailable: {e})")
    try:
        import astro_returns
        ph = astro_returns.progressed_phase(now_et.date())
        if isinstance(ph, dict) and ph.get("phase"):
            lines.append(f"\n🌗 Progressed lunation phase: {ph['phase'].replace('_', ' ')}"
                         + (f" (since {_long_day(ph['phase_start'])}, next {ph['next_phase']} {_long_day(ph['next_phase_start'])})" if ph.get("phase_start") else "")
                         + " · /phase for the meaning")
    except Exception as e:
        lines.append(f"\n🌗 (phase unavailable: {e})")

    # round 8: the monthly lunar phase (Sun–Moon elongation / 45°) with researched do/avoid
    try:
        import astro_truth as _T
        tr = _T.transits(now_et)
        el = (tr["Moon"]["lon"] - tr["Sun"]["lon"]) % 360
        pname = ["new", "crescent", "first quarter", "gibbous", "full", "disseminating", "last quarter", "balsamic"][int(el // 45)]
        ent = lex.kb_entry(f"Moon phase {pname}")
        if ent:
            icon = dict(zip(["new", "crescent", "first quarter", "gibbous", "full", "disseminating", "last quarter", "balsamic"],
                            "🌑🌒🌓🌔🌕🌖🌗🌘"))[pname]
            lines.append(f"\n{icon} Moon phase: {pname}" + (f" ({el:.0f}°)" if args.full else "") + f" — {ent.get('translation', '')}"
                         + (f" → {ent['do']}" if ent.get("do") else ""))
    except Exception as e:
        lines.append(f"\n🌘 (moon phase unavailable: {e})")

    # round 8: traditional timing layer — profection year/month, day+hour ruler, firdaria
    try:
        import astro_timing
        lines.append("\n" + astro_timing.daily_line(now_et))
    except Exception as e:
        lines.append(f"\n⏳ (timing unavailable: {e})")

    # round 8: Uranian layer (planetary pictures, 90° dial TNP hits, critical degrees, star transits) — only what is live
    try:
        import astro_uranian
        ul = astro_uranian.daily_lines(now_et)
        if ul:
            lines.append("\n🜨 Uranian layer (Svehla's dial):\n" + ul)
    except Exception as e:
        lines.append(f"\n🜨 (uranian layer unavailable: {e})")

    # round 8: dated timeline — what goes exact / changes house within ±2 days, researched meaning attached
    try:
        import astro_timeline
        tb = astro_timeline.next_block(now_et, hours=48, skip=shown)
        if tb:
            lines.append("\n" + tb)
    except Exception as e:
        lines.append(f"\n🗓 (timeline unavailable: {e})")

    # 2026-09-14: the Aug 2026 Svehla reading — active windows + what's next
    try:
        sv = svehla.daily_block(now_et.date(), skip={f"Transiting {t} exactly {a} natal {n}" for t, a, n in shown})
        if sv:
            lines.append("\n" + sv)
    except Exception as e:      # never let the reading layer kill the send
        lines.append(f"\n📜 (Svehla windows unavailable: {e})")

    # 2026-09-15: verification stamp — astro_verify.py --all runs 08:25 ET (natal canon, hard-coded
    # texts, NASA Horizons cross-check, Svehla dates, this script's own output)
    try:
        st = json.loads((Path.home() / "portfolio/astrology/verify_status.json").read_text())
        if st.get("ok") and not args.full:        # C16: a passing stamp is noise in the digest
            raise StopIteration
        when = st.get("when_et", "")[:16].replace("T", " ")
        lines.append(f"\n{'✔ chart engine verified' if st.get('ok') else '⚠️ chart engine verification FAILED'} "
                     f"(natal · texts · NASA Horizons · Svehla dates · output) {when} ET")
    except StopIteration:
        pass
    except Exception:
        lines.append("\n⚠️ no verification stamp — run astro_verify.py --all")
    msg = "\n".join(lines)
    out = msg if args.full else digest(msg)
    if not args.full:
        out += "\n\n" + LIVE_LINE
    print(out)
    if args.send:
        for chunk in chunk_message(out):          # Telegram caps a message at 4096 chars
            subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, chunk],
                           capture_output=True, timeout=30)
    return 0


LIVE_LINE = "📖 Full read + 30-day timeline: https://claudeclaw.serveftp.com/astrology/readings/mike-today-live.html"
DIGEST_HITS = 4
DIGEST_KEEP = ("🌌", "☽", "↩", "Δ", "⚡", "🧭", "🎚", "🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘", "🗓", "📜", "⚠️")  # ⏳ timing → /full (C16)
LIFE = {"EXACT": "EXACT TODAY", "NEW": "NEW", "BUILDING": "building", "SEPARATING": "separating", "ONGOING": "ongoing"}


def _select_top(hits: list) -> list:
    """The digest's hit list: top DIGEST_HITS by priority + (max 2) lower-ranked NEW/EXACT events."""
    return hits[:DIGEST_HITS] + [h for h in hits[DIGEST_HITS:] if h["event"]["lifecycle"] in ("NEW", "EXACT")][:2]


def digest_keys(now_et=None) -> set:
    """(moving, aspect, target) of every hit the 08:32 digest shows — the Monday weekly skips these (C4)."""
    import astro_events as AE
    ev = AE.current_transits(now_et)
    return {(h["event"]["moving_body"], h["event"]["aspect"], h["event"]["target_body"])
            for h in _select_top([{"event": e} for e in ev])}


def _changed_text(e: dict) -> str:
    c = e.get("changed", "")
    if c.startswith("was ") and ", now " in c:
        return "now " + c.split(", now ")[1]
    return c


_VERB = {"conjunct": "fuses with", "sextile": "opens a door for", "square": "pressures",
         "trine": "eases", "opposite": "pulls against"}


_NOUN = {"Sun": "your sense of self", "Moon": "your feelings", "Mercury": "your mind", "Venus": "love",
         "Mars": "your drive", "Jupiter": "growth", "Saturn": "discipline", "Uranus": "sudden change",
         "Neptune": "idealism", "Pluto": "deep change", "Chiron": "an old wound", "Ceres": "how you nurture",
         "Juno": "commitment", "Hades": "buried stuff", "Apollon": "success", "ASC": "how you come across",
         "MC": "your career", "DSC": "your partners", "IC": "home"}


def _gist(e: dict) -> str:
    """Short plain gist for the digest (C8): 'growth eases your career'."""
    t, n = (_NOUN.get(x, x) for x in (e["moving_body"], e["target_body"]))
    return f"{t[0].upper() + t[1:]} {_VERB.get(e['aspect'], e['aspect'])} {n}"


def _long_day(iso: str) -> str:
    from datetime import date as _d
    return _d.fromisoformat(str(iso)[:10]).strftime("%b %-d %Y")


def _short_day(iso: str) -> str:
    from datetime import date as _d
    return _d.fromisoformat(iso[:10]).strftime("%b %-d")


def hit_line(e: dict, trans: dict, natal: dict, now_et, digest: bool = False) -> str:
    """One line per live event: position, orb, lifecycle, exact time (from the localized instant),
    pass context. Wording keeps 'Transiting X (in Sign, your Nth)' so astro_verify can re-derive it."""
    import astro_events as AE
    t, n, today = e["moving_body"], e["target_body"], now_et.date()
    th, nh = lex.house_of(trans[t]["lon"]), lex.house_of(natal[n])
    head = (f"{AE.GLYPH[e['aspect']]} Transiting {t} (in {SIGNS[int(trans[t]['lon'] // 30)]}, your {ordinal(th)}) "
            f"{e['aspect']} natal {n} (your {ordinal(nh)}) · {e['orb']:.2f}° · {LIFE[e['lifecycle']]}")
    bits = []
    if e.get("exact_at_local"):
        future = e["exact_at_local"] >= now_et.isoformat()
        when = AE.when_label(e, today)
        if e["lifecycle"] == "EXACT":            # C9: the head already says EXACT TODAY
            bits.append(f"{when.split(' ', 1)[-1]}" + ("" if future else " (passed)"))
        elif digest and not future:
            bits.append(f"peaked {when}")
        else:
            bits.append(f"exact {when}" if future else f"exact was {when.replace('tonight', 'today')}")
    elif e.get("no_exact_this_window"):
        bits.append("no exact in this stretch")
    if (e.get("pass_total") or 1) > 1:
        cur = e.get("pass_number")
        bits.append(f"pass {cur} of {e['pass_total']}" if digest else
                    f"{(e.get('pass_label') or '').lower()} {cur} of {e['pass_total']}")
        later = [p for p in e.get("passes", []) if p["pass_number"] > (cur or 0)]
        if later:
            nx = later[0]
            nxt_when = (datetime.fromisoformat(nx["exact_at_local"]).strftime("%b %Y") if digest and nx.get("exact_at_local")
                        else AE.when_label(nx, today))
            bits.append(f"{'final' if nx['pass_number'] == e['pass_total'] else 'next'} "
                        f"{nxt_when}{' ℞' if nx['retrograde'] and not digest else ''}")
    if e["lifecycle"] == "ONGOING" and e.get("window_start"):
        bits.append(f"in orb {_short_day(e['window_start'])} → {_short_day(e['window_end'])}")
    if e.get("changed") and e["lifecycle"] not in ("NEW", "EXACT"):
        ct = _changed_text(e)
        if ct.replace("now ", "") != e["motion"]:      # "separating … now separating" said once
            bits.append(ct)
    line = head + (" — " + "; ".join(bits) if bits else "")
    return line + (f"\n   → {_gist(e)}" if digest else "")


def digest(msg: str) -> str:
    """Morning digest: keep the paragraphs whose first glyph is in DIGEST_KEEP (the hit list is
    already limited upstream); if still long, drop timing, then the Moon phase."""
    paras = [p for p in msg.split("\n\n") if p.strip()]
    out = [p for i, p in enumerate(paras) if i == 0 or p.lstrip().startswith(DIGEST_KEEP)]
    d = "\n\n".join(out)
    if len(d) > 3900:
        out = [p for p in out if not p.lstrip().startswith("⏳")]
        d = "\n\n".join(out)
    if len(d) > 3900:
        out = [p for p in out if " Moon phase:" not in p[:16]]
        d = "\n\n".join(out)
    return d


def chunk_message(msg: str, limit: int = 3900) -> list[str]:
    """Split on paragraph breaks, then line breaks, then hard-wrap — no Telegram send exceeds the cap
    (a single oversized paragraph used to go out whole and be rejected)."""
    if len(msg) <= limit:
        return [msg]
    pieces = []
    for para in msg.split("\n\n"):
        if len(para) <= limit:
            pieces.append(para); continue
        buf = ""
        for ln in para.split("\n"):
            while len(ln) > limit:
                if buf:
                    pieces.append(buf); buf = ""
                pieces.append(ln[:limit]); ln = ln[limit:]
            if buf and len(buf) + 1 + len(ln) > limit:
                pieces.append(buf); buf = ln
            else:
                buf = f"{buf}\n{ln}" if buf else ln
        if buf:
            pieces.append(buf)
    out, cur = [], ""
    for para in pieces:
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
