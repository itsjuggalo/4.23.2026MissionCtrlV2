#!/usr/bin/env python3
"""astro_uranian.py — the Hamburg-school / Uranian layer Svehla reads with, computed live:
  • all 8 transneptunian points (TNPs): natal positions + transits to Mike's natal points (1° orb)
  • midpoints and planetary pictures on the 90° dial (transiting body = natal A/B midpoint, 1° orb)
  • critical-degree watch (0/13/26 cardinal · 8-9/21-22 fixed · 4/17 mutable · 29° anaretic) for natal, progressed, transiting
  • fixed-star transits (transiting bodies within 1° of the significant stars)
Meanings come from astro_kb_method.json via astro_lexicon.kb_entry.

CLI: astro_uranian.py tnp | midpoints | critical | stars | today
"""
from __future__ import annotations
import sys
from datetime import date, datetime
from itertools import combinations
import swisseph as swe
import astro_truth as T
import astro_lexicon as lex

TNP = {"Cupido": swe.CUPIDO, "Hades": swe.HADES, "Zeus": swe.ZEUS, "Kronos": swe.KRONOS,
       "Apollon": swe.APOLLON, "Admetos": swe.ADMETOS, "Vulkanus": swe.VULKANUS, "Poseidon": swe.POSEIDON}
PRIORITY_MIDPOINTS = [("Sun", "Moon"), ("ASC", "MC"), ("Mars", "Saturn"), ("Jupiter", "Saturn"), ("Venus", "Mars"),
                      ("Sun", "Saturn"), ("Moon", "Saturn"), ("Mars", "Uranus")]
CRITICAL = {"cardinal": [0, 13, 26], "fixed": [8.5, 21.5], "mutable": [4, 17]}
MODALITY = ["cardinal", "fixed", "mutable"] * 4
STARS = ["Regulus", "Aldebaran", "Antares", "Fomalhaut", "Alcyone", "Acrux", "Alphecca", "Rukbat", "Vega", "Pollux",
         "Altair", "Spica", "Algol", "Sirius"]
TRANSIT_BODIES = ["Sun", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Chiron"]


def _natal_points() -> dict[str, float]:
    n = {k: v["lon"] for k, v in T.natal().items()}
    n.update({"ASC": T.ANGLES["ASC"], "MC": T.ANGLES["MC"]})
    return n


def natal_tnps() -> dict[str, dict]:
    out = {}
    for name, b in TNP.items():
        lon = swe.calc_ut(T.NATAL_JD, b)[0][0] % 360
        out[name] = T.describe(lon)
    return out


def transit_tnps(when: datetime | None = None) -> dict[str, dict]:
    jd = T.jd_for(when or datetime.now(T.ET))
    return {name: T.describe(swe.calc_ut(jd, b)[0][0] % 360, swe.calc_ut(jd, b)[0][3]) for name, b in TNP.items()}


def tnp_hits(when: datetime | None = None, orb: float = 1.0) -> list[dict]:
    """Transiting TNP → natal point, and transiting classical body → natal TNP (hard aspects on the 90° dial)."""
    when = when or datetime.now(T.ET)
    hits = []
    nat = _natal_points()
    ntnp = {k: v["lon"] for k, v in natal_tnps().items()}
    tt = {k: v["lon"] for k, v in transit_tnps(when).items()}
    tr = {k: v["lon"] for k, v in T.transits(when).items()}
    def dial(a, b):                       # distance on the 90° dial (conj/sq/opp all collapse to 0)
        d = abs((a - b) % 90)
        return min(d, 90 - d)
    for tn, tl in tt.items():
        for nn, nl in nat.items():
            o = dial(tl, nl)
            if o <= orb:
                hits.append({"t": tn, "n": nn, "orb": round(o, 2), "kind": "tnp→natal"})
    for tn, tl in tr.items():
        if tn == "Moon":
            continue
        for nn, nl in ntnp.items():
            o = dial(tl, nl)
            if o <= orb:
                hits.append({"t": tn, "n": nn, "orb": round(o, 2), "kind": "transit→natal TNP"})
    return sorted(hits, key=lambda h: h["orb"])


def tnp_block(when: datetime | None = None) -> str:
    lines = ["🜨 TRANSNEPTUNIAN POINTS (Hamburg school) — natal, Placidus"]
    for name, p in natal_tnps().items():
        ent = lex.kb_entry(name)
        lines.append(f"• {name} {p['deg']}° {p['sign']} ({T.ordinal(p['house'])} house)" + (f" — {ent['translation']}" if ent and ent.get("translation") else ""))
    hits = tnp_hits(when)
    if hits:
        lines.append("")
        lines.append("ON THE 90° DIAL NOW (≤1°):")
        for h in hits[:8]:
            ent = lex.kb_entry(h["n"]) if h["kind"] == "transit→natal TNP" else lex.kb_entry(h["t"])
            lines.append(f"• transiting {h['t']} = natal {h['n']} (orb {h['orb']}°)" + (f" — {ent.get('translation', '')}" if ent else ""))
    return "\n".join(lines)


def midpoints() -> dict[str, float]:
    nat = _natal_points()
    out = {}
    for a, b in combinations(sorted(nat), 2):
        la, lb = nat[a], nat[b]
        m = (la + lb) / 2 if abs(la - lb) <= 180 else ((la + lb + 360) / 2) % 360
        out[f"{a}/{b}"] = m % 360
    return out


def pictures(when: datetime | None = None, orb: float = 1.0, bodies: list[str] | None = None) -> list[dict]:
    """Transiting body on a natal midpoint (90° dial)."""
    when = when or datetime.now(T.ET)
    tr = T.transits(when)
    mps = midpoints()
    out = []
    for tb in bodies or TRANSIT_BODIES:
        if tb not in tr:
            continue
        tl = tr[tb]["lon"]
        for name, ml in mps.items():
            d = abs((tl - ml) % 90); d = min(d, 90 - d)
            if d <= orb:
                pri = tuple(name.split("/")) in PRIORITY_MIDPOINTS or tuple(reversed(name.split("/"))) in PRIORITY_MIDPOINTS
                out.append({"t": tb, "mid": name, "orb": round(d, 2), "priority": pri})
    return sorted(out, key=lambda x: (not x["priority"], x["orb"]))


def midpoints_block(when: datetime | None = None) -> str:
    when = when or datetime.now(T.ET)
    mps = midpoints()
    lines = ["⚖ MIDPOINTS — your priority pairs (natal), then today's planetary pictures (90° dial, ≤1°)"]
    for a, b in PRIORITY_MIDPOINTS:
        key = f"{a}/{b}" if f"{a}/{b}" in mps else f"{b}/{a}"
        p = T.describe(mps[key])
        ent = lex.kb_entry(f"{a}/{b}")
        lines.append(f"• {a}/{b} = {p['deg']}° {p['sign']} ({T.ordinal(p['house'])} house)" + (f" — {ent['translation']}" if ent and ent.get("translation") else ""))
    pics = pictures(when)
    lines.append("")
    if pics:
        lines.append("PICTURES NOW:")
        for x in pics[:10]:
            a, b = x["mid"].split("/")
            ent = lex.kb_entry(f"{a}/{b}") or lex.kb_entry(f"{b}/{a}")
            tag = " ★" if x["priority"] else ""
            lines.append(f"• transiting {x['t']} = {x['mid']} (orb {x['orb']}°){tag}" + (f" — {ent.get('transit_trigger', ent.get('translation', ''))}" if ent else ""))
    else:
        lines.append("No planetary pictures within 1° today.")
    return "\n".join(lines)


def critical(when: datetime | None = None, orb: float = 0.5) -> list[dict]:
    when = when or datetime.now(T.ET)
    sets = {"natal": {k: v["lon"] for k, v in T.natal().items()},
            "progressed": {k: v["lon"] for k, v in T.progressed(when.date()).items()},
            "transiting": {k: v["lon"] for k, v in T.transits(when).items() if k != "Moon"}}
    out = []
    for layer, pts in sets.items():
        for name, lon in pts.items():
            sign_i, deg = int(lon // 30), lon % 30
            band = None
            if deg >= 29 - (orb if orb < 1 else 0.99):
                band = "29° anaretic"
            else:
                for c in CRITICAL[MODALITY[sign_i]]:
                    if abs(deg - c) <= orb:
                        band = f"{int(c) if c == int(c) else '21-22' if c == 21.5 else '8-9'}° {MODALITY[sign_i]}"
            if band:
                out.append({"layer": layer, "body": name, "lon": lon, "sign": T.SIGNS[sign_i], "deg": round(deg, 2), "band": band})
    return out


def critical_block(when: datetime | None = None) -> str:
    lines = ["🎯 CRITICAL DEGREES — natal / progressed / transiting bodies sitting on a critical band (±0.5°)"]
    rows = critical(when)
    if not rows:
        lines.append("Nothing on a critical degree right now.")
    for r in rows:
        key = "29th degree (anaretic)" if "anaretic" in r["band"] else next((k for k in ("0/13/26 cardinal (Aries, Cancer, Libra, Capricorn)", "8-9 / 21-22 fixed (Taurus, Leo, Scorpio, Aquarius)", "4 / 17 mutable (Gemini, Virgo, Sagittarius, Pisces)") if r["band"].split("° ")[-1] in k), "")
        ent = lex.kb_entry(key)
        lines.append(f"• {r['layer']} {r['body']} {r['deg']:.1f}° {r['sign']} — {r['band']}" + (f": {ent.get('translation', '')}" if ent else ""))
    return "\n".join(lines)


def star_transits(when: datetime | None = None, orb: float = 1.0) -> list[dict]:
    when = when or datetime.now(T.ET)
    jd = T.jd_for(when)
    tr = T.transits(when)
    out = []
    for star in STARS:
        try:
            slon = swe.fixstar_ut(star, jd)[0][0] % 360
        except Exception:
            continue
        for b, p in tr.items():
            if b == "Moon":
                continue
            o = abs(T.angle(p["lon"], slon))
            if o <= orb:
                out.append({"body": b, "star": star, "orb": round(o, 2), "star_lon": slon})
    return sorted(out, key=lambda x: x["orb"])


def stars_block(when: datetime | None = None) -> str:
    lines = ["✨ FIXED-STAR TRANSITS — transiting bodies within 1° of a significant star"]
    rows = star_transits(when)
    if not rows:
        lines.append("None today.")
    for r in rows:
        ent = next((e for k, e in lex.ENTRIES.items() if k.startswith(r["star"].lower())), None)
        lines.append(f"• {r['body']} conjunct {r['star']} ({T.describe(r['star_lon'])['deg']}° {T.describe(r['star_lon'])['sign']}, orb {r['orb']}°)"
                     + (f" — {ent.get('translation', '')}" if ent else ""))
    return "\n".join(lines)


def daily_lines(when: datetime | None = None) -> str:
    """Compact Uranian line(s) for the 8:32 send — only what is live today."""
    when = when or datetime.now(T.ET)
    out = []
    pics = [x for x in pictures(when, orb=0.5) if x["priority"]][:2]
    for x in pics:
        a, b = x["mid"].split("/")
        ent = lex.kb_entry(f"{a}/{b}") or lex.kb_entry(f"{b}/{a}")
        out.append(f"⚖ Planetary picture: {x['t']} = {x['mid']} (orb {x['orb']}°)" + (f" — {ent.get('transit_trigger', ent.get('translation', ''))}" if ent else ""))
    hits = [h for h in tnp_hits(when, orb=0.5) if h["t"] in ("Saturn", "Jupiter", "Uranus", "Neptune", "Pluto", "Mars", "Sun") or h["kind"] == "tnp→natal"][:2]
    for h in hits:
        out.append(f"🜨 90° dial: transiting {h['t']} = natal {h['n']} (orb {h['orb']}°)")
    crit = [r for r in critical(when) if r["layer"] in ("progressed", "transiting") and r["body"] not in ("Sun", "Mercury", "Venus")]
    for r in crit[:2]:
        out.append(f"🎯 {r['layer']} {r['body']} at {r['deg']:.1f}° {r['sign']} — {r['band']} degree")
    st = star_transits(when, orb=0.5)[:1]
    for r in st:
        out.append(f"✨ {r['body']} on {r['star']} (orb {r['orb']}°)")
    return "\n".join(out)


if __name__ == "__main__":
    cmd = sys.argv[1] if len(sys.argv) > 1 else "today"
    fn = {"tnp": tnp_block, "midpoints": midpoints_block, "critical": critical_block, "stars": stars_block}.get(cmd)
    print(fn() if fn else (daily_lines() or "Nothing on the Uranian layer today."))
