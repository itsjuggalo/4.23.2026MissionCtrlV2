"""Regression tests for the 2026-09-28 math review (Reviewer A findings A1–A10 + B3/B5)."""
from datetime import date, datetime, timedelta

import swisseph as swe

import astro_events as E
import astro_returns as R
import astro_sky as S
import astro_timeline as TL
import astro_truth as T
from conftest import ET, o_jd, o_local, o_lon, o_root, sdiff


def test_a1_lunar_eclipse_type_from_global_flag():
    ecl = [e for e in S.eclipses(date(2028, 12, 25), 14) if e["kind"] == "lunar"]
    assert ecl and ecl[0]["date_et"].startswith("2028-12-31")
    assert ecl[0]["type"] == "total"                           # NASA: total, umbral mag 1.246


def test_a2_phase_at_matches_latest_phase_moment():
    import astro_moon as M
    j0 = o_jd(datetime(2026, 10, 1, tzinfo=ET))
    moments = M.phase_moments(j0, j0 + 30)
    assert len(moments) >= 8
    for x, label in moments:
        assert M.phase_at(x + 1e-3) == label                   # just after a start → that phase
    for hrs in range(0, 26 * 24, 7):                           # any instant inside the window → latest start label
        j = j0 + 2 + hrs / 24
        prev = [lab for x, lab in moments if x <= j]
        if prev:
            assert M.phase_at(j) == prev[-1]


def test_a3_solar_arc_dated_by_real_instant():
    hits = R.solar_arc_hits(date(2026, 9, 1), years=2)
    h = [x for x in hits if x["what"] == "Solar-arc ASC opposite natal Moon"]
    assert h and h[0]["date"] == "2026-10-23"                  # true instant 2026-10-23 13:33 ET
    # oracle: directed ASC opposite natal Moon at that instant (arc = progressed Sun − natal Sun)
    nat_sun, nat_moon = o_lon(T.NATAL_JD, swe.SUN), o_lon(T.NATAL_JD, swe.MOON)
    jd = h[0]["jd"]
    pj = T.NATAL_JD + (jd - T.NATAL_JD) / 365.25
    arc = (o_lon(pj, swe.SUN) - nat_sun) % 360
    assert abs(sdiff((T.ANGLES["ASC"] + arc) % 360, (nat_moon + 180) % 360)) < 1e-4
    assert not [x for x in hits if "DSC" in x["what"] or " IC" in x["what"]]


def test_a4_no_duplicate_axis_events():
    ev = E.current_transits(datetime(2026, 10, 30, 10, 23, tzinfo=ET), with_passes=False)
    venus = [(e["target_body"], e["aspect"]) for e in ev if e["moving_body"] == "Venus" and e["target_body"] in ("ASC", "DSC")]
    assert len(venus) <= 1, venus
    assert all(e["aspect"] == "conjunct" for e in ev if e["target_body"] == "DSC")
    hits = S.natal_hits((T.ANGLES["ASC"] + 180) % 360, orb=0.5)   # a point exactly on the DSC
    assert [h["natal"] for h in hits if h["natal"] in ("ASC", "DSC")] == ["DSC"]
    assert not [h for h in T.aspects(datetime(2027, 7, 24, 21, 24, tzinfo=ET), one_per_axis=True) if h["n"] == "DSC"]


def test_a5_pass_numbering_sees_past_cache_end():
    run = [e for e in TL.load() if e["key"].startswith("Transiting Saturn opposite natal Venus")]
    assert run and all(e["pass_total"] == 3 for e in run)
    assert max(e["date"] for e in TL.load()) <= TL.END.isoformat()


def test_a6_display_minute_matches_one_step_rounding():
    # Neptune sextile natal Ceres 2026-10-09: true 06:33:29.56 ET → 06:33 (was shown 06:34)
    e = [x for x in TL.load() if x["key"].startswith("Transiting Neptune sextile natal Ceres") and x["date"] == "2026-10-09"][0]
    shown = T.round_minute(datetime.fromisoformat(e["exact_at_local"]))
    target = [p for p in E.target_points(E.natal_lon("Ceres"), "sextile")]
    jd = o_jd(datetime.fromisoformat(e["exact_at_local"]))
    pt = min(target, key=lambda p: abs(sdiff(o_lon(jd, swe.NEPTUNE), p)))
    r = o_root(lambda j: sdiff(o_lon(j, swe.NEPTUNE), pt), jd - 0.01, jd + 0.01)
    true = o_local(r)                                          # oracle instant, own JD→ET conversion
    assert shown == (true + timedelta(seconds=30)).replace(second=0, microsecond=0)
    assert shown.strftime("%H:%M") == "06:33"


def test_a8_return_times_rounded():
    assert R.solar_return(2028)["when_et"].strftime("%-I:%M %p") == "5:15 PM"


def test_a9_dms_never_crosses_sign():
    d = T.describe(59.9917)
    assert d["sign"] == "Taurus" and d["dms"].endswith("Taurus") and d["dms"].startswith("29°59")


def test_a10_when_label_keeps_local_date():
    e = {"exact_at_local": "2027-01-01T23:59:40-05:00", "local_date": "2027-01-01"}
    assert E.when_label(e, date(2027, 1, 1)).endswith("11:59 PM")


def test_b5_lookahead_uses_ranked_events():
    import astro_lookahead as L
    d = datetime(2026, 10, 30, 10, 23, tzinfo=ET)
    ranked = {(e["moving_body"], e["aspect"], e["target_body"]) for e in E.current_transits(d, with_passes=False)}
    _, why = L.score(d)
    for w in why:
        if w.startswith(("+ ", "− ")) and ("retrograde" not in w and "void" not in w):
            t, asp, n = w[2:].split(" ")
            assert (t, asp, n) in ranked, w
