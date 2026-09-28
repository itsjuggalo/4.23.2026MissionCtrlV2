"""Phase 1–2: timezone root fix + progressed dates, checked against the independent oracle."""
from datetime import date, datetime, timedelta

import pytest
import swisseph as swe

import astro_truth as T
import astro_timeline as TL
from conftest import ET, NATAL_JD, o_jd, o_local, o_lon, o_prog_lon, o_root, sdiff


def _ev(event_id_prefix, on=None):
    m = [e for e in TL.load() if e["event_id"].startswith(event_id_prefix) and (on is None or e["date"] == on)]
    assert m, f"no timeline event {event_id_prefix} {on}"
    return m[0]


def _oracle_transit(body, target_lon, aspect_deg, lo_dt, hi_dt, sign=1):
    pt = (target_lon + sign * aspect_deg) % 360
    f = lambda jd: sdiff(o_lon(jd, body), pt)
    return o_local(o_root(f, o_jd(lo_dt), o_jd(hi_dt)))


def test_sun_conjunct_jupiter_sep27_is_1036pm_et_not_sep28():
    # the event that exposed the UT-date bug: 02:36 UT Sep 28 = 10:36 PM ET Sep 27
    nat_jup = o_lon(NATAL_JD, swe.JUPITER)
    t = _oracle_transit(swe.SUN, nat_jup, 0, datetime(2026, 9, 27, 12, tzinfo=ET), datetime(2026, 9, 28, 12, tzinfo=ET))
    assert t.date() == date(2026, 9, 27) and t.hour == 22 and t.minute in (36, 37)
    import astro_events as E
    ev = [e for e in E.current_transits(datetime(2026, 9, 27, 20, tzinfo=ET))
          if e["moving_body"] == "Sun" and e["target_body"] == "Jupiter"][0]
    got = datetime.fromisoformat(ev["exact_at_local"])
    assert abs((got - t).total_seconds()) <= 60
    assert ev["local_date"] == "2026-09-27"
    assert T.local_date(T.jd_for(got)) == date(2026, 9, 27)


def test_saturn_square_juno_feb17_2027_near_1151pm_est():
    e = _ev("transit:transit:Saturn:square:natal.Juno", "2027-02-17")
    juno = o_lon(NATAL_JD, swe.JUNO)
    cands = [_oracle_transit(swe.SATURN, juno, 90, datetime(2027, 2, 17, tzinfo=ET), datetime(2027, 2, 18, 6, tzinfo=ET), s)
             for s in (1, -1)]
    got = datetime.fromisoformat(e["exact_at_local"])
    best = min(cands, key=lambda c: abs((c - got).total_seconds()))
    assert abs((got - best).total_seconds()) <= 60
    assert got.date() == date(2027, 2, 17) and got.hour == 23 and got.utcoffset() == timedelta(hours=-5)


def test_progression_between_8pm_and_midnight_et():
    e = _ev("progression:progressed:Moon:sign_ingress", "2031-08-20")   # pMoon → Leo 21:39 ET
    got = datetime.fromisoformat(e["exact_at_local"])
    assert 20 <= got.hour <= 23
    f = lambda jd: sdiff(o_prog_lon(jd, swe.MOON), 120.0)
    t = o_local(o_root(f, o_jd(datetime(2031, 8, 10, tzinfo=ET)), o_jd(datetime(2031, 8, 30, tzinfo=ET))))
    assert abs((got - t).total_seconds()) <= 600          # progressed: minutes are sub-arcsecond
    assert t.date() == date(2031, 8, 20)


def test_est_and_edt_offsets_come_from_tzdb():
    est = _ev("transit:transit:Saturn:square:natal.Juno", "2027-02-17")
    edt = _ev("transit:transit:Uranus:opposite:natal.Mercury", "2026-10-16")
    assert est["exact_at_local"].endswith("-05:00")
    assert edt["exact_at_local"].endswith("-04:00")


def test_spring_forward_2027():
    # 2027-03-14: 01:59 EST → 03:00 EDT is ONE real minute
    a = T.jd_local(date(2027, 3, 14), 1, 59)
    b = T.jd_local(date(2027, 3, 14), 3, 0)
    assert abs((b - a) * 1440 - 1) < 1e-3
    assert T.jd_to_local(b).utcoffset() == timedelta(hours=-4)


def test_fall_back_2026():
    # 2026-11-01: midnight → noon is 13 real hours (01:00–02:00 happens twice)
    a = T.jd_local(date(2026, 11, 1), 0, 0)
    b = T.jd_local(date(2026, 11, 1), 12, 0)
    assert abs((b - a) * 24 - 13) < 1e-6
    assert T.jd_to_local(b).utcoffset() == timedelta(hours=-5)


def test_1159pm_and_1201am_events_keep_their_local_date():
    late = _ev("transit:transit:Jupiter:square:natal.Pluto", "2026-10-17")      # 23:52 ET
    early = _ev("transit:transit:Chiron:square:progressed.Venus", "2026-10-07")  # 00:01 ET
    lt, et_ = datetime.fromisoformat(late["exact_at_local"]), datetime.fromisoformat(early["exact_at_local"])
    assert lt.hour == 23 and late["local_date"] == "2026-10-17"          # UT is already Oct 18
    assert et_.hour == 0 and early["local_date"] == "2026-10-07"          # UT is Oct 7 04:01
    # synthetic boundary instants
    assert T.local_date(T.jd_local(date(2026, 12, 31), 23, 59)) == date(2026, 12, 31)
    assert T.local_date(T.jd_local(date(2027, 1, 1), 0, 1)) == date(2027, 1, 1)
    assert swe.revjul(T.jd_local(date(2026, 12, 31), 23, 59))[2] == 1     # UT day already Jan 1


@pytest.mark.parametrize("prefix,on,target_lon,sample", [
    ("progression:progressed:Moon:sign_ingress", "2027-05-03", 60.0, (date(2027, 4, 20), date(2027, 5, 20))),
])
def test_progressed_moon_gemini_may3(prefix, on, target_lon, sample):
    e = _ev(prefix, on)
    f = lambda jd: sdiff(o_prog_lon(jd, swe.MOON), target_lon)
    t = o_local(o_root(f, o_jd(datetime.combine(sample[0], datetime.min.time(), ET)),
                       o_jd(datetime.combine(sample[1], datetime.min.time(), ET))))
    assert t.date() == date(2027, 5, 3)
    assert e["date"] == "2027-05-03"


def test_progressed_moon_11th_house_oct29():
    e = _ev("progression:progressed:Moon:house_ingress", "2026-10-29")
    cusp11 = T.CUSPS[10]
    f = lambda jd: sdiff(o_prog_lon(jd, swe.MOON), cusp11)
    t = o_local(o_root(f, o_jd(datetime(2026, 10, 1, tzinfo=ET)), o_jd(datetime(2026, 11, 30, tzinfo=ET))))
    assert t.date() == date(2026, 10, 29)
    assert e["house"] == 11


def test_progressed_civil_date_is_local_noon():
    d = date(2026, 9, 27)
    got = T.progressed(d)["Moon"]["lon"]
    want = o_prog_lon(o_jd(datetime(2026, 9, 27, 12, tzinfo=ET)), swe.MOON)
    assert abs(sdiff(got, want)) < 1e-3


def test_svehla_hits_are_timeline_view_with_local_dates():
    import svehla
    hits = svehla.exact_hits()
    first = lambda w: next(h for h in hits if h["what"] == w)
    assert first("Transiting Juno enters Aquarius")["date"] == "2026-10-23"
    assert first("Progressed Moon enters Gemini")["date"] == "2027-05-03"
    assert first("Transiting Jupiter enters Libra")["date"] == "2028-08-24"
    assert all(h.get("event_id") for h in hits)


def test_lexicon_pmoon_11th_date_corrected():
    import astro_lexicon as L
    src = (L.__file__)
    txt = open(src).read()
    assert "enters here Oct 29 2026" in txt and "enters here Oct 30 2026" not in txt


def test_jd_for_rejects_naive():
    with pytest.raises(ValueError):
        T.jd_for(datetime(2026, 9, 27, 12))
