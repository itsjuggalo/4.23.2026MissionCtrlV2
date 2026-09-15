#!/usr/bin/env python3
"""svehla.py — the Aug 29 2026 Svehla reading as data + real secondary progressions.

Two jobs, both $0 and both real astronomy:
  1. WINDOWS  — Svehla's dated windows (svehla_windows.json) → what's active today,
                what's next, how many days out. Feeds the 8:32 ET Telegram send and /dates.
  2. PROGRESSED — secondary progressions (day-for-a-year) from the natal JD, so the bot
                can SEE what Svehla sees: progressed Moon/Venus/Sun/Juno, their Placidus
                house (his system), and the real ingress dates. Verified against every date
                in his reading within 0.05° (2026-09-14).

CLI:  svehla.py windows|dates | progressed | daily | weekly [--send] | context | check
Cron: Monday 08:35 ET `svehla.py weekly --send` → astrology lane (astrology auto-posts are allowed).
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
        if w["_start"] == d and w["_end"] == d:
            when = "TODAY"
        elif w["_start"] == d:
            when = f"starts TODAY, {left}d"
        elif left == 0:
            when = "ends TODAY"
        else:
            when = f"{left}d left"
        # insight, not instruction (Mike 2026-09-14): lead with how he read it; the "do" lives in /dates + Monday
        first = w["why"].split(". ")[0].rstrip(".")
        lines.append(f"{KIND_ICON.get(w['kind'], '•')} {w['title']} — {when}. {first}.")
    for w in nxt:
        lines.append(f"⏭ Next: {w['title']} — {w['_start']:%b %-d %Y} ({(w['_start'] - d).days}d).")
    for h in exact_soon(d, 3):
        when = "TODAY" if h["in"] == 0 else f"in {h['in']}d"
        fit = fit_for_exact(h["what"], d)
        lines.append(f"⏰ Exact {when}: {h['what']}." + (f" ↳ {fit}." if fit else ""))
    for w in [w for w in load_windows() if w["_end"] == d - timedelta(days=1)]:
        lines.append(retrospective(w, d))
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
    lines.append("Ask me about any window by name for the why + what to do (/dates is the only place the to-do list lives).")
    return "\n".join(lines)


def weekly_block(d: date | None = None) -> str:
    """Monday nudge: every active window in full (why + do), the next two, progressed snapshot."""
    d = d or today_et()
    lines = [f"📜 SVEHLA WEEK — {d:%a %b %-d %Y}", ""]
    act = active(d)
    if act:
        lines.append("ACTIVE NOW")
        for w in act:
            left = (w["_end"] - d).days
            lines.append(f"{KIND_ICON.get(w['kind'], '•')} {w['title']} ({'ends today' if left == 0 else f'{left}d left'})")
            lines.append(f"   Why: {w['why']}")
            lines.append(f"   Do: {w['do']}")
            lines.append("")
    nxt = upcoming(d, 2)
    if nxt:
        lines.append("COMING UP")
        for w in nxt:
            lines.append(f"⏭ {w['_start']:%b %-d %Y} ({(w['_start'] - d).days}d): {w['title']}")
        lines.append("")
    soon = [h for h in exact_hits() if 0 <= (date.fromisoformat(h["date"]) - d).days <= 14]
    if soon:
        lines.append("EXACT THIS FORTNIGHT")
        for h in soon:
            fit = fit_for_exact(h["what"], d)
            lines.append(f"⏰ {date.fromisoformat(h['date']):%b %-d}: {h['what']}" + (f" — {fit}" if fit else ""))
        lines.append("")
    if d < date(2027, 3, 10):
        lines.append(f"🛡 {(date(2027, 3, 10) - d).days} days to the spring-2027 window he's most concerned about (housing + cash contingency).")
        lines.append("")
    try:                                   # round 8: progressed-phase weekly practice (Rudhyar) + timing week
        import astro_returns, astro_lexicon as lex, astro_timing
        ph = astro_returns.progressed_phase(d)
        ent = lex.kb_entry(f"Progressed phase {ph['phase'].replace('_', ' ')}")
        if ent and ent.get("weekly_practice"):
            lines += [f"🌗 Progressed {ph['phase'].replace('_', ' ')} phase — this week: {ent['weekly_practice']}", ""]
        pf = astro_timing.profection(d)
        lines += [f"⏳ {T_ordinal(pf['house'])}-house profection year, lord {pf['lord']} · this month {T_ordinal(pf['month_house'])} house (lord {pf['month_lord']}) — transits to {pf['lord']} count double.", ""]
    except Exception as e:
        lines += [f"🌗 (phase/timing unavailable: {e})", ""]
    try:                                   # round 8: full dated timeline for the fortnight (all slow bodies, progressions, eclipses)
        import astro_timeline
        tl = astro_timeline.upcoming_block(d, days=14, limit=10)
        if "Nothing exact" not in tl:
            lines += tl.split("\n") + [""]
    except Exception as e:
        lines += [f"🗓 (timeline unavailable: {e})", ""]
    try:
        import astro_tasks
        nag = astro_tasks.loose_nag(d)
        if nag:
            lines += [nag, ""]
    except Exception:
        pass
    p = progressed(d)
    lines.append(f"🔭 pMoon {sign_deg(p['Moon']['lon'])} · pVenus {sign_deg(p['Venus']['lon'])} · /progressed for the rest")
    out = "\n".join(lines)
    if len(out) > 3800:     # Telegram hard cap 4096 — drop the Why lines, keep the Do lines
        out = "\n".join(ln for ln in lines if not ln.startswith("   Why: "))
    return out


def context_block(d: date | None = None) -> str:
    """Compact live-sky context prepended to the astrology lane's free-chat prompt so the
    bot always knows which Svehla window is active without a tool call."""
    d = d or today_et()
    p = progressed(d)
    parts = [f"Today {d:%a %b %-d %Y} ET. Progressed Moon {sign_deg(p['Moon']['lon'])}, "
             f"progressed Venus {sign_deg(p['Venus']['lon'])} (Placidus houses, Svehla's system)."]
    act = active(d)
    if act:
        parts.append("Active windows from the Aug 29 2026 Svehla reading: " + "; ".join(
            f"{w['title']} (until {w['_end']:%b %-d %Y})" for w in act) + ".")
    nxt = upcoming(d, 2)
    if nxt:
        parts.append("Next: " + "; ".join(f"{w['title']} from {w['_start']:%b %-d %Y}" for w in nxt) + ".")
    return " ".join(parts)


def T_ordinal(n: int) -> str:
    return f"{n}{'th' if 11 <= n % 100 <= 13 else {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th')}"


def send_to_lane(msg: str) -> None:
    import subprocess
    subprocess.run([sys.executable, str(Path.home() / "scripts/tg_fleet.py"), "send", "astrology", msg],
                   capture_output=True, timeout=30)


# ── exact hits (idea #1 + #2): real crossing dates, cached ────────────────────
EXACT_FILE = HERE / "svehla_exact_hits.json"
SCAN_START, SCAN_END = date(2026, 9, 1), date(2031, 12, 31)
ASPECT_NAME = {0: "conjunct", 90: "square", 180: "opposite", 120: "trine", 60: "sextile"}
# (transit body, natal point, aspect) — the pairs Svehla's reading turns on
EXACT_PAIRS = [
    ("Saturn", "MC", 0), ("Saturn", "Mars", 90), ("Saturn", "Apollon", 180),
    ("Saturn", "Jupiter", 180), ("Saturn", "Juno", 90), ("Saturn", "Uranus", 90),
    ("Uranus", "Hades", 0), ("Uranus", "Mercury", 180),
    ("Chiron", "Sun", 180), ("Pluto", "Ceres", 0),
    ("Jupiter", "Jupiter", 0), ("Juno", "DSC", 0),
]
T_BODY = {"Saturn": swe.SATURN, "Uranus": swe.URANUS, "Chiron": swe.CHIRON, "Pluto": swe.PLUTO,
          "Jupiter": swe.JUPITER, "Juno": swe.JUNO, "Neptune": swe.NEPTUNE}
N_BODY = {"Sun": swe.SUN, "Moon": swe.MOON, "Mercury": swe.MERCURY, "Venus": swe.VENUS,
          "Mars": swe.MARS, "Jupiter": swe.JUPITER, "Saturn": swe.SATURN, "Uranus": swe.URANUS,
          "Neptune": swe.NEPTUNE, "Pluto": swe.PLUTO, "Chiron": swe.CHIRON, "Ceres": swe.CERES,
          "Juno": swe.JUNO, "Hades": swe.HADES, "Apollon": swe.APOLLON}


def natal_lon(name: str) -> float:
    if name in ("ASC", "MC", "DSC"):
        h = swe.houses(NATAL_JD, LAT, LON)[1]
        return {"ASC": h[0], "MC": h[1], "DSC": (h[0] + 180) % 360}[name]
    return swe.calc_ut(NATAL_JD, N_BODY[name])[0][0] % 360


def _signed_diff(t_lon: float, target: float) -> float:
    """t_lon - target folded to (-180, 180]."""
    d = (t_lon - target + 180) % 360 - 180
    return d


def _crossings(f, start: date, end: date) -> list[date]:
    """Dates where f(jd) crosses zero (daily step, bisected to ~1h). f must be a signed
    distance folded to (-180,180]; we ignore the wrap jump at ±180."""
    out = []
    d = start
    prev = f(jd_of(d))
    while d < end:
        d2 = d + timedelta(days=1)
        cur = f(jd_of(d2))
        if prev == 0 or (prev < 0 < cur or cur < 0 < prev) and abs(cur - prev) < 90:
            lo, hi = jd_of(d), jd_of(d2)
            for _ in range(8):
                mid = (lo + hi) / 2
                if (f(lo) < 0) == (f(mid) < 0):
                    lo = mid
                else:
                    hi = mid
            y, m, dd, _h = swe.revjul((lo + hi) / 2)
            out.append(date(y, m, dd))
        prev, d = cur, d2
    return out


def compute_exact_hits() -> list[dict]:
    hits = []
    # transits → natal, every aspect pair, all passes (retrograde = multiple real hits)
    for tname, nname, asp in EXACT_PAIRS:
        tb, target = T_BODY[tname], natal_lon(nname)
        for a in ({asp, (360 - asp) % 360} if asp not in (0, 180) else {asp}):
            f = lambda jd, tb=tb, target=target, a=a: _signed_diff(swe.calc_ut(jd, tb)[0][0], (target + a) % 360)
            for dt in _crossings(f, SCAN_START, SCAN_END):
                hits.append({"date": dt.isoformat(), "kind": "transit",
                             "what": f"Transiting {tname} exactly {ASPECT_NAME[asp]} natal {nname}"})
    # transiting Juno / Jupiter sign ingresses Svehla dated
    for tname, tb in (("Juno", swe.JUNO), ("Jupiter", swe.JUPITER)):
        d, prev = SCAN_START, sign_of(swe.calc_ut(jd_of(SCAN_START), tb)[0][0])
        while d < date(2029, 12, 31):
            d += timedelta(days=1)
            sgn = sign_of(swe.calc_ut(jd_of(d), tb)[0][0])
            if sgn != prev:
                hits.append({"date": d.isoformat(), "kind": "ingress", "what": f"Transiting {tname} enters {sgn}"})
                prev = sgn
    # progressed Moon: sign + Placidus house ingress; progressed Venus: sign ingress + natal Ceres
    cusps = placidus_cusps()
    for name in ("Moon", "Venus"):
        body = dict(PROG_BODIES)[name]
        d = SCAN_START
        eod = lambda dd: NATAL_JD + (swe.julday(dd.year, dd.month, dd.day, 28.0) - NATAL_JD) / 365.25
        lon0 = swe.calc_ut(eod(d), body)[0][0]
        prev_sign, prev_house = sign_of(lon0), placidus_house(lon0, cusps)
        while d < SCAN_END:
            d += timedelta(days=1)
            lon = swe.calc_ut(eod(d), body)[0][0]   # end-of-day ET, same rule as next_ingress()
            sgn, hs = sign_of(lon), placidus_house(lon, cusps)
            if sgn != prev_sign:
                hits.append({"date": d.isoformat(), "kind": "progressed", "what": f"Progressed {name} enters {sgn}"})
                prev_sign = sgn
            if hs != prev_house:
                hits.append({"date": d.isoformat(), "kind": "progressed",
                             "what": f"Progressed {name} enters your {ordinal(hs)} house (Placidus)"})
                prev_house = hs
    ceres = natal_lon("Ceres")
    fv = lambda jd: _signed_diff(swe.calc_ut(NATAL_JD + (jd - NATAL_JD) / 365.25, swe.VENUS)[0][0], ceres)
    for dt in _crossings(fv, SCAN_START, SCAN_END):
        hits.append({"date": dt.isoformat(), "kind": "progressed", "what": "Progressed Venus exactly conjunct natal Ceres"})
    hits.sort(key=lambda h: h["date"])
    return hits


def exact_hits(refresh: bool = False) -> list[dict]:
    if EXACT_FILE.exists() and not refresh:
        try:
            cached = json.loads(EXACT_FILE.read_text())
            if cached.get("scan_end") == SCAN_END.isoformat():
                return cached["hits"]
        except Exception:
            pass
    hits = compute_exact_hits()
    EXACT_FILE.write_text(json.dumps({"generated": today_et().isoformat(),
                                      "scan_end": SCAN_END.isoformat(), "hits": hits}, indent=1))
    return hits


def exact_soon(d: date | None = None, days: int = 3) -> list[dict]:
    d = d or today_et()
    out = []
    for h in exact_hits():
        hd = date.fromisoformat(h["date"])
        if 0 <= (hd - d).days <= days:
            out.append({**h, "in": (hd - d).days})
    return out


def exact_block(d: date | None = None, n: int = 12) -> str:
    d = d or today_et()
    lines = [f"⏰ NEXT EXACT HITS — real ephemeris, from {d:%b %-d %Y}", ""]
    shown = 0
    for h in exact_hits():
        hd = date.fromisoformat(h["date"])
        if hd < d:
            continue
        lines.append(f"{hd:%b %-d %Y} ({(hd - d).days}d): {h['what']}")
        shown += 1
        if shown >= n:
            break
    lines.append("")
    lines.append("Exact = 0° orb crossing; retrograde passes are separate real hits. Pinged 3 days before + day-of.")
    return "\n".join(lines)


# ── insight layer (Mike 2026-09-14: "less questions, more astrological insight") ──
# Maps a transit/natal pairing to the thread of Svehla's reading it belongs to, so every
# daily aspect and exact hit is explained in HIS terms, not left as a bare degree.
FIT_RULES = [
    # (transit bodies, natal points, window-id prefix, how Svehla framed it)
    ({"Saturn"}, {"MC", "Mars", "Apollon", "Jupiter", "Uranus", "Neptune"}, "saturn-",
     "Saturn on your Midheaven / the Mars t-square: the 'settle career loose ends, build the foundation' thread. Discipline beats swings here"),
    ({"Saturn"}, {"Juno"}, "juno-",
     "Saturn square natal Juno: work and authority stress leaking into the relationship — the thread behind the Juno-on-Descendant tension"),
    ({"Juno"}, {"DSC", "ASC", "Mars", "Juno"}, "juno-",
     "Juno on your Descendant: loyalty, fairness, the household contract. Boundaries and equal load are the fix he named"),
    ({"Jupiter"}, {"Venus", "Sun", "Moon", "MC", "Apollon", "Jupiter", "Chiron"}, "jupiter-",
     "Jupiter's 'controlled expansion': grow income while managing resources securely. Expansion favors what you already built"),
    ({"Uranus"}, {"Hades"}, "uranus-hades",
     "Uranus on natal Hades: no impulsive money moves; the clearing-and-fresh-start transit"),
    ({"Uranus"}, {"Mercury", "Venus", "Sun"}, "saturn-",
     "Uranus rewiring your Sagittarius 5th-house voice — the 'find your unique groove' Uranian undertone of the whole reading"),
    ({"Chiron"}, {"Sun", "Moon", "Chiron"}, "chiron-",
     "Chiron opposite your Sun: financial security and ego in how you relate — the gift in the wound"),
    ({"Pluto", "Venus", "Ceres"}, {"Ceres"}, "venus-ceres",
     "Ceres: self-care, seeking care from someone brilliant, and fair compensation for what you do"),
    ({"Venus", "Ceres", "Moon"}, {"Venus", "Juno", "DSC", "Saturn"}, "pvenus-",
     "The progressed-Venus thread: partner as friend, structure with freedom, partnerships that pay"),
    ({"Mars", "Sun", "Mercury"}, {"MC", "Mars"}, "saturn-",
     "Mars rules your Midheaven: 'take action' on career — the Square of Hercules wants a move, not a mood"),
    ({"Moon", "Sun", "Mercury", "Venus", "Mars"}, {"Sun", "Pluto"}, "pmoon-",
     "Your Scorpio 4th-house core: security and intensity — the same nerve the progressed Moon is pressing on money"),
]


def fit_for(tname: str, nname: str, d: date | None = None) -> str:
    """One line tying a transit→natal pairing to Svehla's reading; empty if it doesn't map."""
    d = d or today_et()
    act = {w["id"] for w in active(d)}
    for tb, npts, prefix, text in FIT_RULES:
        if tname in tb and nname in npts:
            live = any(a.startswith(prefix) for a in act)
            return text + (" (active window)" if live else "")
    return ""


def fit_for_exact(what: str, d: date | None = None) -> str:
    """Same mapping for an exact-hit description string (researched combo translation first)."""
    try:
        import astro_lexicon as lex
        key = what.replace("Transiting ", "").replace(" exactly", "").replace("natal ", "natal ")
        c = lex.combo_translation(key)
        if c:
            return c.split(" (Esoteric:")[0]
    except Exception:
        pass
    for tname in T_BODY:
        if what.startswith(f"Transiting {tname} exactly"):
            nname = what.split("natal ")[-1]
            return fit_for(tname, nname, d)
    if what.startswith("Progressed Moon enters"):
        return "Progressed Moon changing sign/house: the emotional-security focus shifts — he read this as the material-security thread moving from evaluation into the 11th (income from vocation)"
    if what.startswith("Progressed Venus enters Aquarius"):
        return "The June 6 2027 Venus shift he flagged: relief in relationships, partner-as-friend, partnerships that pay"
    if what.startswith("Progressed Venus exactly conjunct natal Ceres"):
        return "Self-care and fair pay; ending a difficult cycle"
    if what.startswith("Transiting Juno enters Aquarius"):
        return "Juno stops opposing natal Mars — he expects the relationship to feel less heavy from here"
    if what.startswith("Transiting Jupiter enters Libra"):
        return "Your Jupiter return: a new 12-year growth cycle begins"
    return ""


def retrospective(w: dict, d: date | None = None) -> str:
    """Auto-written window close-out: what the sky actually did, what he expected, what you noted."""
    d = d or today_et()
    hits = [h for h in exact_hits() if w["start"] <= h["date"] <= w["end"]]
    lines = [f"🏁 Window closed: {w['title']} ({w['_start']:%b %-d} → {w['_end']:%b %-d %Y})."]
    if hits:
        lines.append("Sky during it: " + "; ".join(f"{date.fromisoformat(h['date']):%b %-d} {h['what'].replace('Transiting ', '').replace(' exactly', '')}" for h in hits[:4]) + ".")
    lines.append(f"He read it as: {w['why'].split('. ')[0]}.")
    try:
        import astro_tasks
        notes = [n for n in astro_tasks._lines(astro_tasks.JOURNAL) if w["id"] in n.get("windows", [])]
        if notes:
            lines.append("Your notes: " + " | ".join(n["text"][:80] for n in notes[-3:]))
    except Exception:
        pass
    nxt = upcoming(d, 1)
    if nxt:
        lines.append(f"What carries forward: {nxt[0]['title']} from {nxt[0]['_start']:%b %-d %Y}.")
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
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    cmd = args[0] if args else "windows"
    out = {"windows": dates_block, "dates": dates_block, "progressed": progressed_block,
           "daily": daily_block, "weekly": weekly_block, "context": context_block,
           "exact": exact_block, "check": check_block,
           "rebuild": lambda: f"{len(exact_hits(refresh=True))} exact hits cached"}[cmd]()
    print(out)
    if "--send" in sys.argv:
        send_to_lane(out)
