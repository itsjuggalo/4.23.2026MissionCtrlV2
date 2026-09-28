"""Phases 11–13, 16: grounding, profiles, synastry (+ progressed, reversal), router, tracing."""
import json
import os
import stat
from datetime import date, datetime

import pytest
import swisseph as swe

import astro_profiles as P
import astro_synastry as S
import astro_truth as T
from conftest import ET, o_jd, o_lon, sdiff


@pytest.fixture
def pair():
    a = P.add("Alex", "1990-05-15", "14:30", lat=40.7128, lon=-74.006, tz="America/New_York")
    b = P.add("Blair", "1991-08-02", "unknown", lat=34.05, lon=-118.24, tz="America/Los_Angeles")
    return a, b


# ── profiles ─────────────────────────────────────────────────────────────────
def test_profile_store_private_and_isolated(pair):
    path = P.store_path()
    assert "pytest" in str(path) or "tmp" in str(path)          # never the live store
    assert stat.S_IMODE(os.stat(path).st_mode) == 0o600


def test_profile_local_time_to_ut_via_tzdb(pair):
    a, b = pair
    assert a["natal_jd"] == pytest.approx(o_jd(datetime(1990, 5, 15, 14, 30, tzinfo=ET)), abs=1e-6)   # EDT
    assert b["time_known"] is False and b["birth_time"] is None


def test_profile_validation():
    with pytest.raises(ValueError):
        P.add("Bad", "1990-13-01", "10:00", lat=1, lon=1, tz="UTC")
    with pytest.raises(ValueError):
        P.add("Bad", "1990-01-01", "25:61", lat=1, lon=1, tz="UTC")
    with pytest.raises(ValueError):
        P.add("mike", "1990-01-01", "10:00", lat=1, lon=1, tz="UTC")


def test_geocoder_user_agent_is_generic():
    assert "@" not in P.USER_AGENT and "gmail" not in P.USER_AGENT.lower()


# ── synastry ─────────────────────────────────────────────────────────────────
def test_unknown_time_means_no_angles_or_houses(pair):
    _, b = pair
    c = S.chart(b)
    assert "ASC" not in c["points"] and "MC" not in c["points"]
    assert all(v["house"] is None for v in c["points"].values())
    s = S.synastry(P.get("mike"), b)
    assert s["overlays_a_in_b"] == [] and s["overlays_b_in_a"]          # Mike's time known → B in Mike's houses
    assert "UNAVAILABLE" in S.render(s, P.get("mike"), b) or "unknown" in S.render(s, P.get("mike"), b)


def test_synastry_positions_match_oracle(pair):
    a, _ = pair
    c = S.chart(a)
    assert abs(sdiff(c["points"]["Venus"]["lon"], o_lon(a["natal_jd"], swe.VENUS))) < 1e-3


def test_synastry_reversal_is_exact_mirror(pair):
    a, b = pair
    ab, ba = S.synastry(a, b)["aspects"], S.synastry(b, a)["aspects"]
    key = lambda x: (x["a"], x["b"], x["aspect"], x["orb"])
    mirror = {(x["b"], x["a"], x["aspect"], x["orb"]) for x in ba}
    assert {key(x) for x in ab} == mirror
    assert all(x["a"].startswith("Alex.natal.") and x["b"].startswith("Blair.natal.") for x in ab)


def test_orbs_luminary_vs_standard():
    assert S._orb("Sun", "Saturn", "conjunct", False) == 8
    assert S._orb("Venus", "Saturn", "conjunct", False) == 6
    assert S._orb("Venus", "Mars", "sextile", False) == 4
    assert S._orb("Sun", "Moon", "square", True) == 1.0


def test_progressed_synastry_four_frames_and_labels(pair):
    a, b = pair
    s = S.progressed_synastry(a, b, date(2026, 9, 28))
    assert set(s["frames"]) == {"natal×natal", "Alex.progressed×Blair.natal", "Alex.natal×Blair.progressed",
                                "Alex.progressed×Blair.progressed"}
    for x in s["frames"]["Alex.progressed×Blair.natal"]:
        assert x["a"].startswith("Alex.progressed.") and x["b"].startswith("Blair.natal.") and x["orb"] <= 1.0
    for x in s["frames"]["Alex.natal×Blair.progressed"]:
        assert x["a"].startswith("Alex.natal.") and x["b"].startswith("Blair.progressed.")


def test_progressed_synastry_not_swapped(pair):
    a, b = pair
    ab = S.progressed_synastry(a, b, date(2026, 9, 28))["frames"]
    ba = S.progressed_synastry(b, a, date(2026, 9, 28))["frames"]
    x = {(i["a"], i["b"], i["aspect"]) for i in ab["Alex.progressed×Blair.natal"]}
    y = {(i["b"], i["a"], i["aspect"]) for i in ba["Blair.natal×Alex.progressed"]}
    assert x == y


def test_progressed_positions_use_each_persons_natal_jd(pair):
    a, _ = pair
    pc = S.progressed_chart(a, date(2026, 9, 28))
    tj = T.jd_local(date(2026, 9, 28), 12, tz=P.ZoneInfo(a["tz"]))
    want = o_lon(a["natal_jd"] + (tj - a["natal_jd"]) / 365.25, swe.MOON)
    assert abs(sdiff(pc["points"]["Moon"]["lon"], want)) < 1e-3


# ── grounding / facts ────────────────────────────────────────────────────────
def test_placement_answer_is_computed():
    import astro_facts as F
    a = F.answer("where is my Venus")
    assert T.natal()["Venus"]["dms"] in a and "5th house" in a


def test_exact_answer_uses_canonical_times():
    import astro_facts as F
    a = F.answer("when is Saturn exact on my MC")
    assert "Apr 16 2027" in a and "6:38 PM" in a


def test_general_question_gets_facts_and_rules():
    import astro_facts as F
    ctx = F.llm_context("tell me about love")
    assert "COMPUTED FACTS" in ctx and "UNAVAILABLE" in ctx
    j = json.loads(ctx.split("\n", 1)[1].split("\n\nRULES")[0])
    assert j["natal"]["Sun"]["pos"] == T.natal()["Sun"]["dms"] and j["houses"] == "Placidus"


def test_router_refuses_unknown_person():
    import astro_bot as B
    r = B.route("what's her moon sign")
    assert r["reply"].startswith("UNAVAILABLE")
    r = B.route("compatibility with Jordan")
    assert r["reply"].startswith("UNAVAILABLE")


def test_router_synastry_with_profile(pair):
    import astro_bot as B
    r = B.route("/synastry Alex")
    assert "Mike.natal." in r["reply"] and "Alex.natal." in r["reply"]


def test_router_deterministic_paths_skip_llm():
    import astro_bot as B
    assert B.route("where is my Mars")["reply"]
    assert B.route("/chart")["reply"].startswith("🪐")
    r = B.route("tell me about love this month")
    assert r["reply"] is None and "COMPUTED FACTS" in r["context"]
    assert B.route("/timeline")["handled"] is False          # still handled by the gateway table


# ── tracing ──────────────────────────────────────────────────────────────────
def test_trace_drops_private_fields(tmp_path, monkeypatch):
    import astro_trace as TR
    monkeypatch.setattr(TR, "TRACE", tmp_path / "t.jsonl")
    TR.log(request_id="x", chat=123456, intent="placement", text="where is my Venus", birth="1990-01-01")
    row = json.loads((tmp_path / "t.jsonl").read_text())
    assert "text" not in row and "birth" not in row
    assert row["chat"] != "123456" and len(row["chat"]) == 10
