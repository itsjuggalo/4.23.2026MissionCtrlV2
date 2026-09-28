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
Cron: none since 2026-09-27 — the Monday weekly rides in astro_morning.py (08:32 ET) → astrology lane.
Engine: all dates/crossings/progressions come from astro_truth + the astro_timeline canonical events
(2026-09-27 final round: no private crossing search, no fixed-offset "end of day").
"""
from __future__ import annotations

import json
import sys
from datetime import date, datetime, timedelta
from pathlib import Path
from zoneinfo import ZoneInfo

import swisseph as swe

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402  — the ONE engine: time, crossings, progressions

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


def jd_of(d: date) -> float:
    """Civil date → JD of LOCAL NOON (ET, tz rules) — a date's representative instant."""
    return T.jd_local(d, 12)


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
    """Day-for-a-year for civil date d (local noon) — astro_truth.progressed_jd."""
    return T.progressed_jd(jd_of(d))


def progressed(d: date | None = None) -> dict:
    d = d or today_et()
    return {n: {"lon": v["lon"], "speed": v["speed"]} for n, v in T.progressed(d).items()}


def next_ingress(body_name: str, start: date, horizon_days: int = 366 * 6) -> tuple[date, str] | None:
    """First progressed sign change after `start`, found by bisection on the real instant and dated
    in ET from that instant (replaces an end-of-day sample hardcoded to UTC-4)."""
    j0 = jd_of(start)
    best = None
    for s_ in range(12):
        xs = T.find_crossings(lambda jd, b=s_ * 30.0: T.signed_diff(T.progressed_lon(jd, body_name), b),
                              j0, j0 + horizon_days, step=2.0)
        if xs and (best is None or xs[0] < best[0]):
            best = (xs[0], s_)
    if not best:
        return None
    x, s_ = best
    back = T.lon_speed(T.progressed_jd(x), body_name)[1] < 0
    return T.local_date(x), SIGNS[(s_ - 1) % 12] if back else SIGNS[s_]


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


# Svehla's windows are READING data (his dates, verbatim). Where the start/exact is an
# engine-computable event, the canonical timeline instant is shown beside it — if the two disagree,
# the computed local time is the truth (e.g. Juno→Aquarius Oct 23 10:40 PM ET vs his "Oct 24").
WINDOW_EVENT = {       # window id → (event_id prefix, n-th match on/after window start − 45 d)
    "jupiter-2h-a": ("ingress:transit:Jupiter:house_ingress", 0),
    "jupiter-2h-b": ("ingress:transit:Jupiter:house_ingress", 0),
    "juno-aquarius": ("ingress:transit:Juno:sign_ingress", 0),
    "saturn-apollon": ("transit:transit:Saturn:opposite:natal.Apollon", 0),
    "saturn-10h": ("transit:transit:Saturn:conjunct:natal.MC", 0),
    "pvenus-aquarius": ("progression:progressed:Venus:sign_ingress", 0),
    "uranus-hades-1": ("transit:transit:Uranus:conjunct:natal.Hades", 0),
    "uranus-hades-2": ("transit:transit:Uranus:conjunct:natal.Hades", 0),
    "uranus-hades-3": ("transit:transit:Uranus:conjunct:natal.Hades", 0),
    "jupiter-return": ("ingress:transit:Jupiter:sign_ingress", 0),
    "chiron-sun-1": ("transit:transit:Chiron:opposite:natal.Sun", 0),
    "chiron-sun-2": ("transit:transit:Chiron:opposite:natal.Sun", 0),
    "chiron-sun-3": ("transit:transit:Chiron:opposite:natal.Sun", 0),
    "venus-ceres": ("progression:progressed:Venus:conjunct:natal.Ceres", 0),
}


def computed_exact(w: dict) -> dict | None:
    """The canonical timeline event behind a window (None if it isn't engine-computable)."""
    spec = WINDOW_EVENT.get(w.get("id"))
    if not spec:
        return None
    import astro_timeline as TL
    lo = (w["_start"] - timedelta(days=45)).isoformat()
    hi = (w["_end"] + timedelta(days=45)).isoformat()
    m = [e for e in TL.load() if e.get("event_id", "").startswith(spec[0]) and lo <= e["date"] <= hi]
    if w.get("id") == "jupiter-2h-b":
        m = [e for e in m if e.get("house") == 2 and not e.get("retrograde")]
    elif w.get("id", "").startswith("jupiter-2h"):
        m = [e for e in m if e.get("house") == 2]
    elif w.get("id") == "juno-aquarius":
        m = [e for e in m if e["key"].endswith("Aquarius")]
    elif w.get("id") == "pvenus-aquarius":
        m = [e for e in m if e["key"].endswith("Aquarius")]
    elif w.get("id") == "jupiter-return":
        m = [e for e in m if e["key"].endswith("Libra")]
    m.sort(key=lambda e: abs((date.fromisoformat(e["date"]) - w["_start"]).days))
    return m[spec[1]] if len(m) > spec[1] else None


def computed_note(w: dict) -> str:
    e = computed_exact(w)
    if not e or not e.get("exact_at_local"):
        return ""
    import astro_events as E
    t = T.round_minute(datetime.fromisoformat(e["exact_at_local"]))
    label = t.strftime("%b %-d %Y") if e.get("moving_frame") == "progressed" else t.strftime("%b %-d %Y %-I:%M %p ET")
    return f" [engine: exact {label}]"


def daily_block(d: date | None = None, skip: set | None = None) -> str:
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
        lines.append(f"⏭ Next: {w['title']} — {w['_start']:%b %-d %Y} ({(w['_start'] - d).days}d){computed_note(w)}.")
    for h in exact_soon(d, 3):
        if skip and h["what"] in skip:      # already a top hit in the same message
            continue
        when = "TODAY" if h["in"] == 0 else f"in {h['in']}d"
        fit = fit_for_exact(h["what"], d)
        lines.append(f"⏰ Exact {when}: {h['what']}." + (f" ↳ {fit.rstrip('.')}." if fit else ""))
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
        lines.append(f"{mark}{KIND_ICON.get(w['kind'], '•')} {span}: {w['title']}{computed_note(w)}")
    lines.append("")
    lines.append("Ask me about any window by name for the why + what to do (/dates is the only place the to-do list lives).")
    return "\n".join(lines)




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


def send_to_lane(msg: str, tries: int = 4) -> bool:
    """Post to the astrology lane. Retries with backoff (the laptop's Telegram link drops often —
    'Connection reset by peer' in tg-gateway logs); returns False only if every try failed."""
    import subprocess, time
    for i in range(tries):
        try:
            r = subprocess.run([sys.executable, str(Path.home() / "scripts/tg_fleet.py"), "send", "astrology", msg],
                               capture_output=True, text=True, timeout=45)
            if r.returncode == 0:
                return True
            err = (r.stdout + r.stderr).strip()[-200:]
        except Exception as e:
            err = str(e)
        print(f"[send_to_lane] try {i + 1}/{tries} failed: {err}", file=sys.stderr)
        time.sleep(5 * 2 ** i)
    return False


# ── exact hits (idea #1 + #2): real crossing dates, cached ────────────────────
SCAN_START, SCAN_END = date(2026, 9, 1), date(2031, 12, 31)      # = astro_timeline START/END
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
    if name == "DSC":
        return T.ANGLES["DSC"]
    import astro_events as E
    return E.natal_lon(name)


def _signed_diff(t_lon: float, target: float) -> float:
    """t_lon - target folded to (-180, 180] (astro_truth.signed_diff)."""
    return T.signed_diff(t_lon, target)




def compute_exact_hits() -> list[dict]:
    """The dated hits Svehla's reading turns on — a VIEW of the canonical timeline events (no
    second crossing search). `what` keeps the historical wording other layers key on."""
    import astro_timeline as TL
    want = {(t, n, ASPECT_NAME[a]) for t, n, a in EXACT_PAIRS}
    hits = []
    for e in TL.load():
        k = e.get("kind")
        what = None
        if k == "aspect":
            t, n, asp = e["body"], e.get("natal"), e.get("aspect")
            if (t, n, asp) == ("Juno", "ASC", "opposite"):
                n, asp = "DSC", "conjunct"              # the ASC–DSC axis: Svehla names the DSC
            if (t, n, asp) in want:
                what = f"Transiting {t} exactly {asp} natal {n}"
        elif k == "sign" and e["body"] in ("Juno", "Jupiter"):
            sign = e["key"].split(" in ")[-1]
            what = f"Transiting {e['body']} {'backs into' if e.get('retrograde') else 'enters'} {sign}"
        elif k == "progressed" and e["body"] in ("Moon", "Venus") and e.get("subtype") == "sign_ingress":
            what = f"Progressed {e['body']} enters {e['key'].split(' in ')[-1]}"
        elif k == "progressed" and e["body"] in ("Moon", "Venus") and e.get("subtype") == "house_ingress":
            what = f"Progressed {e['body']} enters your {T.ordinal(e['house'])} house (Placidus)"
        elif k == "progressed" and e.get("subtype") == "aspect" and (e["body"], e.get("natal"), e.get("aspect")) == ("Venus", "Ceres", "conjunct"):
            what = "Progressed Venus exactly conjunct natal Ceres"
        if what:
            hits.append({"date": e["date"], "kind": {"aspect": "transit", "sign": "ingress"}.get(k, "progressed"),
                         "what": what, "exact_at_local": e.get("exact_at_local"), "event_id": e.get("event_id"),
                         "pass": e.get("pass"), "rx": e.get("rx"), "pass_label": e.get("pass_label"),
                         "moving_frame": e.get("moving_frame")})
    hits.sort(key=lambda h: (h["date"], h.get("exact_at_local") or ""))
    return hits


def exact_hits(refresh: bool = False) -> list[dict]:
    """Derived from the timeline cache (which carries metadata + code-hash freshness); no own file."""
    if refresh:
        import astro_timeline as TL
        TL.build()
    return compute_exact_hits()


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
           "daily": daily_block, "context": context_block,
           "exact": exact_block, "check": check_block,
           "rebuild": lambda: f"{len(exact_hits(refresh=True))} exact hits cached"}[cmd]()
    print(out)
    if "--send" in sys.argv:
        send_to_lane(out)
