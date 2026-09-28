"""Phases 3–10, 15: canonical events, motion, passes, ranking, wording, daily/weekly roles, themes,
cache metadata, alerts, trading-contamination guard."""
import re
import subprocess
import sys
from datetime import datetime, timedelta
from pathlib import Path

import pytest
import swisseph as swe

import astro_events as E
import astro_timeline as TL
import astro_truth as T
from conftest import ET, NATAL_JD, o_jd, o_lon, sdiff

HERE = Path(__file__).resolve().parent.parent
NOW = datetime(2026, 9, 27, 8, 32, tzinfo=ET)
CANON = ["event_id", "event_type", "subtype", "moving_body", "moving_frame", "target_body", "target_frame",
         "aspect", "orb", "motion", "retrograde", "exact_at_utc", "exact_at_local", "local_date", "timezone",
         "pass_number", "pass_total", "pass_label", "source", "calculated_at"]
TRADING = re.compile(r"📈|desk note|trade the plan|\btrad(e|es|ing)\b|\bticker|\bSPY\b|\bstocks?\b|options? flow", re.I)


@pytest.fixture(scope="module")
def live():
    return E.current_transits(NOW)


def _run(*args):
    return subprocess.run([sys.executable, str(HERE / args[0]), *args[1:]], capture_output=True, text=True,
                          timeout=240).stdout


# ── one canonical event model ────────────────────────────────────────────────
def test_timeline_events_carry_canonical_fields():
    ev = TL.load()
    assert len(ev) > 400
    for e in ev:
        for k in CANON:
            assert k in e, (k, e.get("event_id"))
        assert e["timezone"] == "America/New_York"
        if e.get("exact_at_local"):
            assert e["local_date"] == e["exact_at_local"][:10]


def test_live_events_canonical_and_ids_unique(live):
    assert live
    ids = [e["event_id"] for e in live]
    assert len(ids) == len(set(ids))
    for e in live:
        for k in CANON + ["lifecycle", "priority", "priority_reasons"]:
            assert k in e


# ── motion + lifecycle ───────────────────────────────────────────────────────
def test_motion_matches_independent_finite_difference(live):
    jd = o_jd(NOW)
    for e in live:
        if e["motion"] in ("exact", "stationary"):
            continue
        b = T.BODIES[e["moving_body"]]
        tgt = T.natal()[e["target_body"]]["lon"]
        pts = [(tgt + s * E.ASPECT_DEG[e["aspect"]]) % 360 for s in (1, -1)]
        d0 = min(abs(sdiff(o_lon(jd, b), p)) for p in pts)
        d1 = min(abs(sdiff(o_lon(jd + 0.01, b), p)) for p in pts)
        assert e["motion"] == ("applying" if d1 < d0 else "separating"), e["event_id"]


def test_lifecycle_values(live):
    assert {e["lifecycle"] for e in live} <= {"NEW", "BUILDING", "EXACT", "SEPARATING", "ONGOING"}
    sj = [e for e in live if e["moving_body"] == "Sun" and e["target_body"] == "Jupiter"]
    assert sj and sj[0]["lifecycle"] == "EXACT"


# ── multi-pass ───────────────────────────────────────────────────────────────
def test_saturn_square_juno_three_pass_series():
    run = [e for e in TL.load() if e["event_id"].startswith("transit:transit:Saturn:square:natal.Juno")
           and "2026-01-01" <= e["date"] <= "2027-12-31"]
    # pass 1 (May 27 2026) predates the cache window but is still counted in the series
    assert [e["pass_label"] for e in run] == ["RETROGRADE PASS", "FINAL PASS"]
    assert [e["pass_number"] for e in run] == [2, 3] and all(e["pass_total"] == 3 for e in run)
    assert [p["exact_at_local"][:10] for p in run[0]["passes"]] == ["2026-05-27", "2026-09-26", "2027-02-17"]
    assert [p["pass_label"] for p in run[0]["passes"]] == ["FIRST PASS", "RETROGRADE PASS", "FINAL PASS"]
    assert run[0]["retrograde"] is True and run[1]["date"] == "2027-02-17"
    for e in run:
        assert e.get("window_start") and e.get("window_end")


def test_live_pass_context(live):
    jm = [e for e in live if e["moving_body"] == "Jupiter" and e["target_body"] == "MC"][0]
    assert jm["pass_total"] == 3 and jm["pass_label"] == "FIRST PASS" and jm["pass_number"] == 1


# ── ranking ──────────────────────────────────────────────────────────────────
def test_ranking_deterministic_and_explained(live):
    again = E.current_transits(NOW)
    assert [e["event_id"] for e in live] == [e["event_id"] for e in again]
    for e in live:
        assert e["priority_reasons"], e["event_id"]
        assert e["priority"] == sum(int(re.search(r"\(([+-]?\d+)\)$", r).group(1)) for r in e["priority_reasons"])


def test_jupiter_trine_mc_and_venus_rank_high(live):
    order = [(e["moving_body"], e["target_body"]) for e in live]
    assert order.index(("Jupiter", "MC")) == 0
    assert order.index(("Jupiter", "Venus")) < order.index(("Sun", "Mercury"))
    jm = live[0]
    assert any("angular" in r for r in jm["priority_reasons"])


# ── wording ──────────────────────────────────────────────────────────────────
def test_same_body_wording_has_no_repeated_gloss():
    import astro_lexicon as L
    s = L.translate_hit({"t": "Saturn", "n": "Saturn", "aspect": "sextile"}, 10, 70)
    assert "Transiting Saturn (" in s and "your natal Saturn" in s
    assert s.count("(your hard lessons") == 1
    assert "Saturn (your hard lessons and discipline) and your Saturn (" not in s


def test_daily_labels_frames():
    out = _run("daily_transits.py", "--full")
    hit_lines = [ln for ln in out.splitlines() if ln[:1] in "☌﹡□△☍" and "Transiting" in ln]
    assert hit_lines and all(" natal " in ln for ln in hit_lines)


# ── daily vs weekly roles ────────────────────────────────────────────────────
def test_daily_and_weekly_do_not_duplicate_content():
    daily, weekly = _run("daily_transits.py"), _run("astro_weekly.py")
    dl = {ln.strip() for ln in daily.splitlines() if len(ln.strip()) > 40}
    wl = {ln.strip() for ln in weekly.splitlines() if len(ln.strip()) > 40}
    assert not (dl & wl), dl & wl
    assert "☽ Moon in" in daily and "☽ Moon in" not in weekly          # daily-only section
    assert "EXACT THIS WEEK" in weekly and "SVEHLA WINDOWS" in weekly   # weekly-only sections
    assert "Why:" not in daily                                          # Why/Do lives in the weekly


def test_digest_counts_real_remaining_hits():
    out = _run("daily_transits.py")
    m = re.search(r"\+(\d+) more in /full", out)
    if m:
        shown = len([ln for ln in out.split("⚡", 1)[1].split("\n\n")[0].splitlines() if ln[:1] in "☌﹡□△☍"])
        assert shown + int(m.group(1)) == len(E.current_transits())


# ── trading contamination ────────────────────────────────────────────────────
@pytest.mark.parametrize("args", [("daily_transits.py",), ("daily_transits.py", "--full"), ("astro_weekly.py",),
                                  ("astro_lookahead.py", "quality")])
def test_no_trading_contamination_in_outputs(args):
    out = _run(*args)
    assert out.strip()
    assert not TRADING.search(out), TRADING.search(out).group(0)


def test_no_trading_contamination_in_free_chat_context():
    import astro_facts as F
    ctx = F.llm_context("how is my week")
    assert not TRADING.search(ctx)


# ── themes ───────────────────────────────────────────────────────────────────
def test_themes_structure(live):
    th = E.themes(live)
    assert th
    for t in th:
        for k in ("supporting_factors", "conflicting_factors", "timing", "missing", "evidence", "tone"):
            assert k in t
        assert len(t["supporting_factors"]) + len(t["conflicting_factors"]) >= 2


# ── cache metadata ───────────────────────────────────────────────────────────
def test_cache_metadata_and_freshness():
    m = TL.meta()
    for k in ("schema_version", "generated_at", "source", "timezone", "code_hash", "valid_until"):
        assert k in m
    assert m["timezone"] == "America/New_York" and m["schema_version"] >= 2
    ok, _ = E.cache_fresh(m)
    assert ok
    stale = dict(m, code_hash="000000000000")
    assert not E.cache_fresh(stale)[0]
    old = dict(m, valid_until=(T.now_local() - timedelta(minutes=1)).isoformat())
    assert not E.cache_fresh(old)[0]


def test_sky_cache_has_metadata():
    import astro_sky
    c = astro_sky._get_cache(30)
    assert c.get("meta", {}).get("timezone") == "America/New_York"


# ── alerts use the canonical instant ─────────────────────────────────────────
def test_alerts_fire_on_canonical_exact_time():
    import astro_alerts as A
    due = A.due(datetime(2026, 10, 16, 3, 30, tzinfo=ET), 60, 0)
    tl = [t for u, t in due if u.startswith("tl:2026-10-16:Transiting Uranus opposite natal Mercury")]
    assert tl and "3:52 AM" in tl[0]
    assert not [u for u, _ in A.due(datetime(2026, 10, 16, 5, 0, tzinfo=ET), 60, 0) if "Uranus opposite" in u]


def test_fast_exacts_match_oracle():
    jd0 = o_jd(datetime(2026, 10, 1, tzinfo=ET))
    ev = [e for e in E.fast_exacts(jd0, jd0 + 20) if e["moving_body"] == "Mercury" and e["target_body"] == "Sun"
          and e["aspect"] == "conjunct"]
    assert ev
    jd = ev[0]["exact_jd"]
    assert abs(sdiff(o_lon(jd, swe.MERCURY), o_lon(NATAL_JD, swe.SUN))) < 0.001


def test_chunk_message_splits_under_limit():
    import daily_transits as D
    msg = "\n".join(f"line {i} " + "x" * 80 for i in range(200))
    parts = D.chunk_message(msg)
    assert len(parts) > 1 and all(len(p) <= 4096 for p in parts)
