"""Review round (2026-09-28): natal esoteric post, router correctness (B4/C1/C11), gateway fence (B1/B2),
profile store safety (B14), digest/weekly readability (C3/C4/C8/C9), wording (B18/C10), trace isolation (B19)."""
import json
import re
from pathlib import Path

import pytest

import astro_truth as T

HERE = Path(__file__).resolve().parent.parent
GATEWAY = Path.home() / "scripts/tg_responder.py"
TRADING = re.compile(r"\btrad(e|es|ing)\b|\bticker|\bstocks?\b|\bFOMO\b|account balance|\bspeculat", re.I)
VEDIC = re.compile(r"nakshatra|dasha|rahu|ketu|sidereal|jyotish", re.I)


# ── natal esoteric post ─────────────────────────────────────────────────────
def test_natal_esoteric_facts_are_computed():
    import astro_esoteric as X
    out, nat = X.natal_esoteric_post(), T.natal()
    for n in ["Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto",
              "Chiron", "Ceres", "Juno"]:
        want = f"{n} {nat[n]['dms']} · {T.ordinal(nat[n]['house'])} house"
        assert want in out, want
    assert f"Ascendant {nat['ASC']['dms']}" in out and f"Midheaven {nat['MC']['dms']}" in out


def test_natal_esoteric_combos_only_for_matching_placements():
    import astro_esoteric as X
    nat = T.natal()
    for n in ["Sun", "Moon", "Venus", "Saturn", "Juno"]:
        c = X._combo_for(n, nat[n]["sign"], nat[n]["house"])
        assert c and nat[n]["sign"] in c["name"] and T.ordinal(nat[n]["house"]) in c["name"]
    assert X._combo_for("Sun", "Aries", 1) is None          # a wrong placement never borrows a reading


def test_natal_esoteric_clean_and_sendable():
    import astro_esoteric as X
    import daily_transits as D
    out = X.natal_esoteric_post()
    assert not VEDIC.search(out) and not TRADING.search(out)
    assert "Mike" not in out                                 # second person throughout
    assert all(len(c) <= 4096 for c in D.chunk_message(out))


def test_esoteric_kb_is_second_person():
    txt = (HERE / "astro_esoteric_kb.json").read_text()
    assert not re.search(r"\bMike\b(?!s_chart)", txt.replace("in_mikes_chart", ""))


# ── router ──────────────────────────────────────────────────────────────────
@pytest.mark.parametrize("q", ["how do today's transits hit me?", "what's in Mike's chart",
                               "what is the moon's sign today", "what does Saturn's transit mean for me?"])
def test_mikes_own_questions_are_not_refused(q):
    import astro_bot as B
    r = B.route(q)
    assert not (r["reply"] or "").startswith("UNAVAILABLE"), q


def test_stored_person_answered_from_their_chart_not_mikes():
    import astro_bot as B
    import astro_profiles as P
    import astro_synastry as S
    p = P.add("Sam", "1994-06-12", "14:30", lat=27.95, lon=-82.46, tz="America/New_York")
    r = B.route("where is Sam's moon")
    sam_moon = S.chart(p)["points"]["Moon"]["dms"]
    assert sam_moon in r["reply"] and T.natal()["Moon"]["dms"] not in r["reply"]
    r = B.route("tell me about Sam's chart")
    ctx = json.loads(r["context"].split("\n", 1)[1].split("\n\nRULES")[0])
    assert ctx["named_profile_charts"]["Sam"]["natal"]["Moon"]["pos"] == sam_moon


def test_unknown_person_still_unavailable():
    import astro_bot as B
    assert B.route("what's her moon sign")["reply"].startswith("UNAVAILABLE")


def test_new_deterministic_intents():
    import astro_bot as B
    assert "void" in B.route("when does the moon go void")["reply"].lower()
    r = B.route("is mercury retrograde")["reply"]
    assert r.startswith("Transiting Mercury now:") and T.transits()["Mercury"]["dms"] in r
    assert B.route("what's coming up this year")["reply"].startswith("📆")
    assert B.route("is today good for a hard conversation")["reply"] is None      # judgement → LLM + facts
    assert B.route("what sign is mercury in")["reply"].startswith("Transiting Mercury")


def test_facts_include_sky_now_and_voc():
    import astro_facts as F
    j = F.facts("is anything retrograde")
    assert j["sky_now"]["Mercury"]["pos"] == T.transits()["Mercury"]["dms"]
    assert "is_voc_now" in (j["moon_void_of_course"] or {"is_voc_now": 0})


# ── profile store ───────────────────────────────────────────────────────────
def test_corrupt_profile_store_raises_instead_of_wiping():
    import astro_profiles as P
    P.add("Alex", "1990-05-15", "14:30", lat=40.7, lon=-74.0, tz="America/New_York")
    P.store_path().write_text("{not json")
    with pytest.raises(RuntimeError):
        P.add("Blair", "1991-08-02", "unknown", lat=34.0, lon=-118.2, tz="America/Los_Angeles")
    assert P.store_path().read_text() == "{not json"


def test_profile_slug_collision_refused():
    import astro_profiles as P
    P.add("Sam", "1994-06-12", "14:30", lat=27.95, lon=-82.46, tz="America/New_York")
    with pytest.raises(ValueError):
        P.add("SAM!", "1990-01-01", "10:00", lat=1, lon=1, tz="UTC")


# ── gateway fence (static) ──────────────────────────────────────────────────
def test_gateway_astro_lane_has_no_compute_tools_and_is_fenced():
    src = GATEWAY.read_text()
    lane = re.search(r'"astrology": \{.*?"persona"', src, re.S).group(0)
    tools = re.search(r'"tools":\s*"([^"]*)"', lane).group(1)
    assert "Bash" not in tools and "Web" not in tools
    persona = re.search(r'"astrology": \{.*?"help"', src, re.S).group(0)
    assert "trading-chart" not in persona and "daily_transits.py" not in persona
    assert 'cfg.get("astro_only")) else tools + ",Skill"' in src           # no Skill on the astro lane
    assert "Unknown astrology command" in src and "no facts → refused LLM" in src


# ── digest / weekly readability ─────────────────────────────────────────────
def test_digest_moon_line_names_sign_change_and_gists():
    import subprocess
    import sys
    out = subprocess.run([sys.executable, str(HERE / "daily_transits.py")], capture_output=True, text=True,
                         timeout=240).stdout
    moon = next(ln for ln in out.splitlines() if ln.startswith("☽ Moon in"))
    assert "→" in moon and "ET" in moon
    assert re.search(r"^   → [A-Z]", out, re.M)                  # plain gist under ranked hits
    assert "⏳" not in out and "exact was today" not in out


def test_monday_weekly_skips_what_the_daily_explained():
    import astro_weekly as W
    import daily_transits as D
    keys = D.digest_keys()
    wk = W.weekly_block(exclude=keys)
    slow = wk.split("🐢 SLOW TRANSITS IN FORCE")[1].split("\n\n")[0] if "🐢" in wk else ""
    for m, a, t in keys:
        assert f"{m} {a} natal {t} —" not in slow


# ── wording ─────────────────────────────────────────────────────────────────
def test_lexicon_has_no_trading_flavour():
    import astro_lexicon as L
    blob = json.dumps([L.HOUSES, L.PLANETS, L.SIGNS])
    assert not re.search(r"FOMO|account balance|speculation", blob)


def test_moon_phase_prefix_removed():
    assert "money-and-career year" not in (HERE / "astro_kb_cycles.json").read_text()
    assert "is the Moon is" not in (HERE / "astro_kb_cycles.json").read_text()


# ── trace isolation ─────────────────────────────────────────────────────────
def test_router_trace_goes_to_temp_file_in_tests():
    import astro_trace as TR
    assert "logs/astrology" not in str(TR.TRACE)
