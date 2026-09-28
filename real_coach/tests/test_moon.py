"""Moon sign + phase posts (Mike 2026-09-28) — facts vs the independent oracle."""
from datetime import datetime

import swisseph as swe

import astro_moon as M
import astro_truth as T
from conftest import ET, o_jd, o_local, o_lon, o_root, sdiff


def test_sign_ingress_matches_oracle():
    jd = o_jd(datetime(2026, 9, 28, 0, 0, tzinfo=ET))
    x = M.next_sign_ingress(jd)
    t = o_local(o_root(lambda j: sdiff(o_lon(j, swe.MOON), 30.0), jd, jd + 1.0))   # → Taurus
    assert abs((T.jd_to_local(x) - t).total_seconds()) <= 10
    assert t.strftime("%Y-%m-%d %H") == "2026-09-28 10"


def test_phase_moment_full_moon_matches_oracle():
    jd = o_jd(datetime(2026, 9, 24, tzinfo=ET))
    full = [x for x, ph in M.phase_moments(jd, jd + 5) if ph == "full"][0]
    f = lambda j: sdiff((o_lon(j, swe.MOON) - o_lon(j, swe.SUN)) % 360, 180.0)
    t = o_local(o_root(f, jd, jd + 5))
    assert abs((T.jd_to_local(full) - t).total_seconds()) <= 10


def test_sign_post_is_about_his_placements():
    p = M.sign_post(sign="Taurus")
    assert "MOON IN TAURUS" in p and "ruler of Taurus, Venus" in p and "5th house" in p
    assert "natal Sun" in p                               # Moon in Taurus opposes his Scorpio Sun
    assert "trad" not in p.lower()


def test_guide_covers_every_sign_and_phase():
    g = M.guide()
    for s in T.SIGNS:
        assert f" {s}: your " in g
    for ph in M.PHASES:
        assert ph.title() in g


def test_due_emits_unique_uids():
    start = datetime(2026, 9, 28, 0, 0, tzinfo=ET)
    items = M.due(start, start.replace(day=30, hour=23))
    uids = [u for u, _ in items]
    assert len(uids) == len(set(uids)) and any(u.startswith("moon-sign:") for u in uids)
    assert any(u.startswith("moon-phase:") for u in uids)
