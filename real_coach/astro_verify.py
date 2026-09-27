#!/usr/bin/env python3
"""astro_verify.py — guarantees the astrology bot never contradicts Mike's real chart.

  --all           run every check, write ~/portfolio/astrology/verify_status.json, exit 1 on failure
  --check-text    read a bot answer on stdin; print ⚠️ corrections (exit 1) or ✔ (exit 0)
  --send-on-fail  with --all: text the astrology lane if anything fails

Checks:
  A natal      computed placements == the canonical card (sign + Placidus house), every body
  B texts      every hard-coded claim in tg_responder persona/NATAL_CARD, daily_transits NATAL_PT,
               astro_lexicon HOUSES agrees with A (same claim extractor as free-chat)
  C horizons   NASA JPL Horizons geocentric ecliptic longitudes vs Swiss Ephemeris (≤0.05°)
  D svehla     every dated event in the Aug 2026 reading reproduces within 1 day
  E outputs    today's daily_transits / --progressed output re-parsed and re-derived from truth
  G passes     upcoming timeline "pass i of n" + retrograde flags recounted by an independent scan
"""
from __future__ import annotations

import json
import re
import subprocess
import sys
from datetime import date, datetime, timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402

STATUS = Path.home() / "portfolio/astrology/verify_status.json"
BODY_RX = r"(Sun|Moon|Mercury|Venus|Mars|Jupiter|Saturn|Uranus|Neptune|Pluto|Chiron|Ceres|Juno|Hades|Apollon|Midheaven|MC|Ascendant|ASC|Descendant|DSC)"
SIGN_RX = r"(Aries|Taurus|Gemini|Cancer|Leo|Virgo|Libra|Scorpio|Sagittarius|Capricorn|Aquarius|Pisces)"
ASP_RX = r"(conjunct(?:ion)?|conjoins?|squar(?:e|es|ing)|trin(?:e|es|ing)|opposit(?:e|ion)|oppos(?:es|ing)|sextil(?:e|es|ing))"
ASP_NORM = {"conj": "conjunct", "squa": "square", "trin": "trine", "oppo": "opposite", "sext": "sextile"}
ANGLE_ALIAS = {"Midheaven": "MC", "Ascendant": "ASC", "Descendant": "DSC"}
CANON = {  # the card every reading and the persona carry — sign + Placidus house
    "Sun": ("Scorpio", 4), "Moon": ("Pisces", 8), "Mercury": ("Sagittarius", 5), "Venus": ("Sagittarius", 5),
    "Mars": ("Cancer", 12), "Jupiter": ("Libra", 3), "Saturn": ("Aquarius", 7), "Uranus": ("Capricorn", 6),
    "Neptune": ("Capricorn", 6), "Pluto": ("Scorpio", 4), "Chiron": ("Leo", 2), "Juno": ("Cancer", 12),
    "ASC": ("Cancer", 1), "MC": ("Aries", 10), "Hades": ("Gemini", 11), "Apollon": ("Libra", 3),
    "Ceres": ("Aquarius", 7),
}


def norm_body(b: str) -> str:
    return ANGLE_ALIAS.get(b, b)


# ── claim extraction + verification (used for bot answers AND hard-coded texts) ──
BODY_NC = "(?:" + BODY_RX[1:]                 # same alternation, non-capturing
NB = rf"(?:(?!\b{BODY_NC}\b)[^.\n])"     # any char except a sentence break or another body name


def claims(text: str) -> list[dict]:
    out = []
    # 1. "<qualifier> Body at/in 12° Sign"  or  "Body in Sign"
    for m in re.finditer(rf"\b(natal|progressed|transiting|your|p)?\s*{BODY_RX}\s+(?:is\s+)?(?:in|at)\s+(?:(\d{{1,2}})\s*°\s*)?{SIGN_RX}", text, re.I):
        q, body, deg, sign = m.group(1), norm_body(m.group(2)), m.group(3), m.group(4).title()
        out.append({"kind": "sign", "q": (q or "").lower(), "body": body, "deg": int(deg) if deg else None, "sign": sign, "text": m.group(0)})
    # 2. "Body ... your 7th (house)"  — nearest body before the ordinal
    for m in re.finditer(rf"\b(natal|progressed|transiting|p)?\s*{BODY_RX}\b{NB}{{0,45}}?\b(?:your|the|his|my)\s+(\d{{1,2}})(?:st|nd|rd|th)\b", text, re.I):
        q, body, house = m.group(1), norm_body(m.group(2)), int(m.group(3))
        if 1 <= house <= 12:
            out.append({"kind": "house", "q": (q or "").lower(), "body": body, "house": house, "text": m.group(0)})
    # 3. "Body <aspect> (natal) Body"
    for m in re.finditer(rf"\b(transiting|natal|progressed|p)?\s*{BODY_RX}\b{NB}{{0,30}}?\b{ASP_RX}\b{NB}{{0,25}}?\b(natal|your|progressed|transiting)?\s*{BODY_RX}\b", text, re.I):
        out.append({"kind": "aspect", "q1": (m.group(1) or "").lower(), "a": norm_body(m.group(2)),
                    "asp": ASP_NORM[m.group(3)[:4].lower()], "q2": (m.group(4) or "").lower(), "b": norm_body(m.group(5)), "text": m.group(0)})
    # 4. "Body is retrograde" — nearest body before the keyword. Timeline pass stamps
    #    "(pass 2 of 3, retrograde)" describe the TRANSITING body on the event date, not the
    #    natal point just before them; check_pass_numbers() verifies those independently.
    rx_text = re.sub(r"\(pass \d+ of \d+(?:, retrograde)?\)", "", text)
    for m in re.finditer(rf"\b(natal|progressed)?\s*{BODY_RX}\b{NB}{{0,20}}?\b(retrograde|℞|rx)\b", rx_text, re.I):
        out.append({"kind": "rx", "q": (m.group(1) or "").lower(), "body": norm_body(m.group(2)), "text": m.group(0)})
    return out


def verify_claims(text: str, when: datetime | None = None) -> list[dict]:
    when = when or datetime.now(T.ET)
    nat, tr, pr = T.natal(), T.transits(when), T.progressed(when.date())
    wide = T.aspects(when, orb_mult=4.0)
    try:
        import svehla
        exact = svehla.exact_hits()
    except Exception:
        exact = []
    results = []
    for c in claims(text):
        ok, truth = False, ""
        if c["kind"] == "sign":
            cands = []
            if c["q"] in ("natal", "your") or c["body"] in ("ASC", "MC", "DSC") or c["q"] == "":
                cands.append(("natal", nat.get(c["body"])))
            if c["q"] in ("transiting", "") and c["body"] in tr:
                cands.append(("transit", tr[c["body"]]))
            if c["q"] in ("progressed", "p", "") and c["body"] in pr:
                cands.append(("progressed", pr[c["body"]]))
            for label, v in cands:
                if v and v["sign"] == c["sign"] and (c["deg"] is None or abs(v["deg_f"] - c["deg"]) <= 1.5):
                    ok = True
            truth = "; ".join(f"{l} {c['body']} {v['deg']}° {v['sign']}" for l, v in cands if v)
        elif c["kind"] == "house":
            cands = []
            if c["q"] in ("natal", "") and c["body"] in nat:
                cands.append(("natal", nat[c["body"]]))
            if c["q"] in ("transiting", "") and c["body"] in tr:
                cands.append(("transit", tr[c["body"]]))
            if c["q"] in ("progressed", "p", "") and c["body"] in pr:
                cands.append(("progressed", pr[c["body"]]))
            ok = any(v["house"] == c["house"] for _, v in cands)
            truth = "; ".join(f"{l} {c['body']} in your {T.ordinal(v['house'])}" for l, v in cands)
        elif c["kind"] == "aspect":
            a, b, asp = c["a"], c["b"], c["asp"]
            # transit a → natal b (or reversed wording), wide orb
            ok = any((h["t"] == a and h["n"] == b or h["t"] == b and h["n"] == a) and h["aspect"] == asp for h in wide)
            # natal-to-natal
            if not ok and a in nat and b in nat:
                ok = abs(T.angle(nat[a]["lon"], nat[b]["lon"]) - T.ASPECTS[asp]) <= 8
            # progressed a → natal b
            if not ok and a in pr and b in nat:
                ok = abs(T.angle(pr[a]["lon"], nat[b]["lon"]) - T.ASPECTS[asp]) <= 2
            # an exact hit within ±60 days
            if not ok:
                for h in exact:
                    if abs((date.fromisoformat(h["date"]) - when.date()).days) <= 60 and \
                       f"{a} exactly {asp} natal {b}" in h["what"]:
                        ok = True; break
            near = [h for h in wide if {h["t"], h["n"]} == {a, b}]
            truth = "; ".join(f"transit {h['t']} {h['aspect']} natal {h['n']} (orb {h['orb']}°)" for h in near) or f"no {a}–{b} aspect in orb today"
        elif c["kind"] == "rx":
            v = tr.get(c["body"]) if c["q"] == "" else (nat if c["q"] == "natal" else pr).get(c["body"])
            ok = bool(v and v["rx"]) if c["body"] not in ("Sun", "Moon") else False
            truth = f"{c['body']} {'is' if v and v['rx'] else 'is NOT'} retrograde"
        results.append({**c, "ok": ok, "truth": truth})
    return results


def check_text(text: str) -> tuple[bool, str]:
    res = verify_claims(text)
    if not res:
        return True, ""
    bad = [r for r in res if not r["ok"]]
    if not bad:
        return True, f"✔ {len(res)} chart claim(s) checked against your natal/transits/progressions."
    lines = ["🔎 Fact-check vs your chart:"]
    for r in bad:
        lines.append(f"⚠️ \"{r['text'].strip()}\" → {r['truth'] or 'not supported by the ephemeris'}")
    return False, "\n".join(lines)


# ── the scheduled checks ──
def check_natal() -> list[str]:
    nat, fails = T.natal(), []
    for body, (sign, house) in CANON.items():
        v = nat[body]
        if v["sign"] != sign or v["house"] != house:
            fails.append(f"A natal {body}: computed {v['deg']}° {v['sign']} house {v['house']}, card says {sign} house {house}")
    return fails


def check_texts() -> list[str]:
    fails = []
    srcs = {
        "tg_responder persona+card": Path.home() / "scripts/tg_responder.py",
        "daily_transits NATAL_PT": Path(__file__).with_name("daily_transits.py"),
        "astro_lexicon HOUSES": Path(__file__).with_name("astro_lexicon.py"),
    }
    for label, p in srcs.items():
        src = p.read_text()
        if "tg_responder" in label:
            m = re.search(r'"astrology": \{.*?"help"', src, re.S); src = (m.group(0) if m else "") + \
                (re.search(r'NATAL_CARD = \((.*?)\n\)', src, re.S) or re.search("x", "x")).group(0)
        for r in verify_claims(src.replace('"', " ").replace("\\n", " "), datetime(1992, 11, 4, 12, tzinfo=T.ET)):
            if r["kind"] in ("sign", "house") and not r["ok"]:
                fails.append(f"B {label}: '{r['text'].strip()}' vs {r['truth']}")
    return fails


def check_horizons() -> list[str]:
    try:
        import requests
    except ImportError:
        return []
    ids = {"Sun": "10", "Moon": "301", "Mars": "499", "Jupiter": "599", "Saturn": "699", "Uranus": "799"}
    now = datetime.now(T.ET).replace(second=0, microsecond=0)
    u = now.astimezone(datetime.now().astimezone().tzinfo)  # local; convert to UTC string below
    from datetime import timezone as _tz
    u = now.astimezone(_tz.utc)
    tr = T.transits(now)
    fails = []
    for n, hid in ids.items():
        try:
            r = requests.get("https://ssd.jpl.nasa.gov/api/horizons.api", timeout=25, params={
                "format": "text", "COMMAND": f"'{hid}'", "OBJ_DATA": "'NO'", "MAKE_EPHEM": "'YES'",
                "EPHEM_TYPE": "'OBSERVER'", "CENTER": "'500@399'", "START_TIME": f"'{u:%Y-%m-%d %H:%M}'",
                "STOP_TIME": f"'{(u + timedelta(minutes=1)):%Y-%m-%d %H:%M}'", "STEP_SIZE": "'1 m'",
                "QUANTITIES": "'31'", "CAL_FORMAT": "'CAL'", "ANG_FORMAT": "'DEG'"}).text
            row = r.split("$$SOE")[1].split("$$EOE")[0].strip().splitlines()[0]
            lon = float(re.findall(r"-?\d+\.\d+", row)[0])
            diff = abs((lon - tr[n]["lon"] + 180) % 360 - 180)
            if diff > 0.05:
                fails.append(f"C horizons {n}: NASA {lon:.3f}° vs swe {tr[n]['lon']:.3f}° (Δ {diff:.3f}°)")
        except Exception as e:
            return [f"C horizons unreachable ({str(e)[:60]}) — skipped"] if n == "Sun" else fails
    return fails


def check_svehla() -> list[str]:
    import svehla
    fails = []
    exp = [("2027-05-03", "Progressed Moon enters Gemini"), ("2027-06-06", "Progressed Venus enters Aquarius"),
           ("2027-04-17", "Transiting Saturn exactly conjunct natal MC"), ("2029-07-09", "Transiting Chiron exactly opposite natal Sun"),
           ("2028-06-15", "Transiting Uranus exactly conjunct natal Hades"), ("2029-09-02", "Progressed Venus exactly conjunct natal Ceres"),
           ("2026-10-24", "Transiting Juno enters Aquarius"), ("2028-08-24", "Transiting Jupiter enters Libra")]
    hits = svehla.exact_hits()
    for d, what in exp:
        tol = 45 if "Hades" in what else 2          # Uranus-Hades: he gives a window, not a day
        near = [h for h in hits if h["what"] == what and abs((date.fromisoformat(h["date"]) - date.fromisoformat(d)).days) <= tol]
        if not near:
            fails.append(f"D svehla: '{what}' expected ~{d}, engine has {[h['date'] for h in hits if h['what'] == what]}")
    return fails


VEDIC = re.compile(r"(?i)\b(vedic|sidereal|nakshatra|jyotish|dasha|rahu|ketu|lahiri)\b")


def check_no_vedic() -> list[str]:
    """Mike 2026-09-15: tropical Western only — no Vedic/sidereal layer anywhere the bot reads from."""
    fails = []
    here = Path(__file__).parent
    for fp in sorted(list(here.glob("astro_*.py")) + list(here.glob("astro_kb_*.json")) + [here / "astro_esoteric_kb.json",
                     here / "daily_transits.py", here / "svehla.py", Path.home() / "scripts/tg_set_commands.py"]):
        if not fp.exists() or fp.name == "astro_verify.py":
            continue
        txt = fp.read_text(errors="ignore")
        hits = sorted(set(m.lower() for m in VEDIC.findall(txt)))
        if hits:
            fails.append(f"V vedic/sidereal term in {fp.name}: {hits}")
    return fails


def check_commands() -> list[str]:
    """C — every bot module command (ASTRO_MODULE_CMDS in tg_responder.py) runs, exits 0, prints something, no traceback."""
    import ast
    fails = []
    src = (Path.home() / "scripts/tg_responder.py").read_text()
    i = src.find("ASTRO_MODULE_CMDS = {")
    j = src.find("\n}\n", i)
    try:
        cmds = ast.literal_eval(src[i + len("ASTRO_MODULE_CMDS = "):j + 2])
    except Exception as e:
        return [f"C cannot parse ASTRO_MODULE_CMDS: {e}"]
    py = str(Path.home() / ".venv/bin/python")
    rc = Path.home() / "scripts/real_coach"
    for cmd, (script, margs) in sorted(cmds.items()):
        try:
            r = subprocess.run([py, str(rc / script), *margs], capture_output=True, text=True, timeout=180)
            out = (r.stdout or "").strip()
            if r.returncode != 0 or "Traceback" in (r.stderr or "") or "Traceback" in out:
                fails.append(f"C {cmd} → {script} {' '.join(margs)} crashed: {(r.stderr or out)[-200:].strip()}")
            elif len(out) < 20:
                fails.append(f"C {cmd} → {script} printed nothing useful: {out[:80]!r}")
            elif "unavailable" in out:
                fails.append(f"C {cmd} degraded: " + next(l for l in out.splitlines() if "unavailable" in l)[:160])
        except Exception as e:
            fails.append(f"C {cmd} failed to run: {e}")
    return fails


def check_outputs() -> list[str]:
    fails = []
    py = str(Path.home() / ".venv/bin/python")
    dt = Path(__file__).with_name("daily_transits.py")
    out = subprocess.run([py, str(dt)], capture_output=True, text=True, timeout=120).stdout
    now = datetime.now(T.ET)
    for r in verify_claims(out, now):
        if not r["ok"] and r["kind"] in ("sign", "house", "rx"):
            fails.append(f"E daily: '{r['text'].strip()}' vs {r['truth']}")
    prog = subprocess.run([py, str(dt), "--progressed"], capture_output=True, text=True, timeout=120).stdout
    pr = T.progressed(now.date())
    for m in re.finditer(r"p(Moon|Venus|Sun|Juno) (\d+)° (\w+)", prog):
        v = pr[m.group(1)]
        if v["sign"] != m.group(3) or v["deg"] != int(m.group(2)):
            fails.append(f"E progressed: '{m.group(0)}' vs {v['deg']}° {v['sign']}")
    return fails


def check_modules() -> list[str]:
    """F — the r7 modules: returns, sky, patterns, lookahead, wheel. Skips (not fails) if a module is absent."""
    fails = []
    now = datetime.now(T.ET)
    nat = T.natal()
    try:
        import astro_returns as R
        sr = R.solar_return(now.year)
        srlon = sr.get("sun_lon") or sr.get("planets", {}).get("Sun", {}).get("lon")
        if srlon is not None and abs(T.angle(srlon, nat["Sun"]["lon"])) > 0.01:
            fails.append(f"F solar return Sun {srlon:.4f} vs natal {nat['Sun']['lon']:.4f}")
        ph = R.progressed_phase(now.date())
        pr = T.progressed(now.date())
        ang = (pr["Moon"]["lon"] - pr["Sun"]["lon"]) % 360
        want = ["new", "crescent", "first_quarter", "gibbous", "full", "disseminating", "last_quarter", "balsamic"][int(ang // 45)]
        if isinstance(ph, dict) and ph.get("phase") and ph["phase"] != want:
            fails.append(f"F progressed phase '{ph['phase']}' vs angle {ang:.1f}° → {want}")
    except ImportError:
        fails.append("F astro_returns missing — skipped")
    except Exception as e:
        fails.append(f"F astro_returns crashed: {e}")
    try:
        import astro_sky as S
        known = {"2026-08-12": "solar", "2026-08-28": "lunar", "2027-02-06": "solar", "2027-08-02": "solar"}
        ecl = S.eclipses(date(2026, 8, 1), 400)
        got = {str(e.get("date_et", ""))[:10]: e.get("kind") for e in ecl}
        for d, k in known.items():
            near = [g for g in got if abs((date.fromisoformat(g) - date.fromisoformat(d)).days) <= 1 and got[g] == k]
            if not near:
                fails.append(f"F eclipse {k} {d} not found by astro_sky (got {sorted(got)[:6]})")
        lun = S.lunations(now.date(), 40)
        for l in lun[:2]:
            dt = l.get("date_et"); dt = datetime.fromisoformat(dt) if isinstance(dt, str) else dt
            tr = T.transits(dt if dt.tzinfo else dt.replace(tzinfo=T.ET))
            el = (tr["Moon"]["lon"] - tr["Sun"]["lon"]) % 360
            want = 0 if l["kind"] == "new" else 180
            if abs((el - want + 180) % 360 - 180) > 1.0:
                fails.append(f"F lunation {l['kind']} {dt}: elongation {el:.2f}° ≠ {want}")
    except ImportError:
        fails.append("F astro_sky missing — skipped")
    except Exception as e:
        fails.append(f"F astro_sky crashed: {e}")
    try:
        import astro_patterns as P
        txt = P.patterns_block()
        if "MC" not in txt or "Mars" not in txt:
            fails.append("F patterns_block lost the MC-apex t-square")
        stars = P.fixed_stars_block()
        if "Acrux" not in stars:
            fails.append("F fixed stars: Acrux conjunct Sun missing (Svehla's Alpha Crucis)")
    except ImportError:
        fails.append("F astro_patterns missing — skipped")
    except Exception as e:
        fails.append(f"F astro_patterns crashed: {e}")
    try:
        import astro_lookahead as L
        q, _ = L.score(now)
        if not 1 <= q <= 10:
            fails.append(f"F quality score out of range: {q}")
    except Exception as e:
        fails.append(f"F astro_lookahead crashed: {e}")
    # round 8: timeline must agree with the sky module on ingress direction/date and with Svehla's exact hits
    try:
        import astro_timeline as TL, astro_sky as SK
        ev = TL.load()
        by = {}
        for e in ev:
            if e["kind"] == "sign":
                by.setdefault((e["body"], e["key"].split(" in ")[-1]), []).append(date.fromisoformat(e["date"]))
        checked = 0
        for ing in SK.ingresses(now.date(), 400):
            if ing["body"] not in TL.SLOW:
                continue
            d = date.fromisoformat(ing["date_et"][:10])
            cands = by.get((ing["body"], ing["sign"]), [])
            if not any(abs((c - d).days) <= 1 for c in cands):
                fails.append(f"F timeline/sky disagree: {ing['body']} → {ing['sign']} {d} not in timeline {cands[:3]}")
            checked += 1
        if checked == 0:
            fails.append("F timeline check: no slow-body ingresses to compare")
        want = {("Saturn", "MC", "conjunct"): date(2027, 4, 16), ("Saturn", "Apollon", "opposite"): date(2027, 3, 28),
                ("Uranus", "Hades", "conjunct"): date(2028, 7, 3)}
        for (b, n, a), d in want.items():
            ds = [date.fromisoformat(e["date"]) for e in ev if e["kind"] == "aspect" and e["body"] == b and e.get("natal") == n and e.get("aspect") == a]
            if not any(abs((x - d).days) <= 1 for x in ds):
                fails.append(f"F timeline missing {b} {a} {n} ≈ {d} (got {ds[:3]})")
        pm = [e["date"] for e in ev if e["kind"] == "progressed" and e["key"] == "Progressed Moon in Gemini"]
        if pm and abs((date.fromisoformat(pm[0]) - date(2027, 5, 3)).days) > 1:
            fails.append(f"F timeline pMoon→Gemini {pm[0]} vs Svehla 2027-05-03")
    except Exception as e:
        fails.append(f"F astro_timeline crashed: {e}")
    return fails


def check_pass_numbers(days: int = 120) -> list[str]:
    """G — every upcoming timeline aspect's "pass i of n" and retrograde flag, recounted by a
    brute-force daily scan ±900 days that shares no code with astro_timeline."""
    import swisseph as swe
    import astro_timeline as TL
    from svehla import natal_lon
    fails, today = [], datetime.now(T.ET).date()
    for e in TL.load():
        if e["kind"] != "aspect" or not (today <= date.fromisoformat(e["date"]) <= today + timedelta(days=days)):
            continue
        body, d0 = TL.SLOW[e["body"]], date.fromisoformat(e["date"])
        a, nl = TL.ASPECTS[e["aspect"]], natal_lon(e["natal"])
        hits = []
        for t in ({(nl + a) % 360} if a in (0, 180) else {(nl + a) % 360, (nl - a) % 360}):
            d, prev = d0 - timedelta(days=900), None
            while d < d0 + timedelta(days=900):
                x = ((swe.calc_ut(swe.julday(d.year, d.month, d.day, 16), body)[0][0] - t + 180) % 360) - 180
                if prev is not None and prev * x < 0 and abs(x - prev) < 90:
                    hits.append(d)
                prev, d = x, d + timedelta(days=1)
        hits.sort()
        if not hits:
            fails.append(f"G pass recount found no {e['key']} near {d0}"); continue
        i = min(range(len(hits)), key=lambda k: abs((hits[k] - d0).days))
        lo = hi = i
        while lo > 0 and (hits[lo] - hits[lo - 1]).days <= 600: lo -= 1
        while hi < len(hits) - 1 and (hits[hi + 1] - hits[hi]).days <= 600: hi += 1
        want = f"{i - lo + 1} of {hi - lo + 1}" if hi > lo else None
        if e.get("pass") != want:
            fails.append(f"G {e['date']} {e['key']}: timeline says pass {e.get('pass')} vs recount {want}")
        if want:
            rx = swe.calc_ut(swe.julday(d0.year, d0.month, d0.day, 16), body)[0][3] < 0
            if bool(e.get("rx")) != rx:
                fails.append(f"G {e['date']} {e['key']}: retrograde flag {e.get('rx')} vs ephemeris {rx}")
    return fails


def run_all(send_on_fail: bool = False) -> int:
    fails = []
    for fn in (check_natal, check_texts, check_horizons, check_svehla, check_outputs, check_modules, check_pass_numbers, check_no_vedic, check_commands):
        try:
            fails += fn()
        except Exception as e:
            fails.append(f"{fn.__name__} crashed: {e}")
    hard = [f for f in fails if "skipped" not in f]
    status = {"ok": not hard, "when_et": datetime.now(T.ET).isoformat(timespec="minutes"),
              "checks": ["natal", "texts", "horizons", "svehla", "outputs", "modules", "passes", "no-vedic", "commands"], "failures": fails}
    STATUS.parent.mkdir(parents=True, exist_ok=True)
    STATUS.write_text(json.dumps(status, indent=1))
    print(("✔ ALL CHECKS PASS" if not hard else "✖ FAILURES") + f" — {status['when_et']}")
    for f in fails:
        print("  " + f)
    if hard and send_on_fail:
        msg = "⚠️ Astrology engine verification FAILED — the 8:32 send may be wrong:\n" + "\n".join(hard[:8])
        subprocess.run([sys.executable, str(Path.home() / "scripts/tg_fleet.py"), "send", "astrology", msg], capture_output=True, timeout=30)
    return 0 if not hard else 1


if __name__ == "__main__":
    if "--check-text" in sys.argv:
        ok, msg = check_text(sys.stdin.read())
        print(msg)
        sys.exit(0 if ok else 1)
    sys.exit(run_all(send_on_fail="--send-on-fail" in sys.argv))
