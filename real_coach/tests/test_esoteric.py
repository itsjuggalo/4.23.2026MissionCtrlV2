"""astro_esoteric.py — the esoteric-post generator must never invent an astrological fact: every
'Transiting X <aspect> natal Y' line, and any degree/orb it shows, must trace back to
astro_events.current_transits() for that same instant. Also: deterministic, bounded length,
astrology-only (no trading words, no Vedic/sidereal terms), and must work across several dates."""
import re
from datetime import datetime
from zoneinfo import ZoneInfo

import astro_esoteric as AE
import astro_events as E

ET = ZoneInfo("America/New_York")
FACT_RE = re.compile(
    r"Transiting (?P<t>\S+) (?P<a>conjunct|sextile|square|trine|opposite) natal (?P<n>\S+) — "
    r"orb (?P<orb>[\d.]+)°"
)
TRADING_RE = re.compile(r"\btrade(s|d|r|rs|ing)?\b|\bstocks?\b|\bticker\b|\bSPY\b|\bmarkets?\b", re.I)
VEDIC_RE = re.compile(r"nakshatra|dasha|\brahu\b|\bketu\b|sidereal", re.I)

FIXED_WHEN = datetime(2026, 9, 27, 8, 32, tzinfo=ET)
OTHER_DATES = ["2026-10-16", "2027-02-17", "2028-07-03"]


def _events_by_key(when):
    return {e["key"]: e for e in E.current_transits(when)}


def test_post_nonempty_and_bounded():
    post = AE.esoteric_post(FIXED_WHEN)
    assert post
    assert len(post) < 4000


def test_post_deterministic_for_fixed_datetime():
    a = AE.esoteric_post(FIXED_WHEN)
    b = AE.esoteric_post(FIXED_WHEN)
    assert a == b


def test_every_fact_line_matches_a_real_engine_event():
    post = AE.esoteric_post(FIXED_WHEN)
    by_key = _events_by_key(FIXED_WHEN)
    matches = FACT_RE.findall(post)
    assert matches, "expected at least one 'Transiting X aspect natal Y' fact line"
    for t, a, n, orb_str in matches:
        key = f"Transiting {t} {a} natal {n}"
        assert key in by_key, f"invented aspect not returned by current_transits: {key}"
        ev = by_key[key]
        assert abs(float(orb_str) - ev["orb"]) <= 0.005 + 1e-9, (key, orb_str, ev["orb"])


def test_fact_line_degrees_match_engine():
    post = AE.esoteric_post(FIXED_WHEN)
    by_key = _events_by_key(FIXED_WHEN)
    for key, ev in by_key.items():
        if key not in post:
            continue
        if ev.get("moving_degree"):
            assert ev["moving_degree"] in post, (key, ev["moving_degree"])
        if ev.get("target_degree"):
            assert ev["target_degree"] in post, (key, ev["target_degree"])


def test_no_trading_words():
    post = AE.esoteric_post(FIXED_WHEN)
    assert not TRADING_RE.search(post), post


def test_no_vedic_terms():
    post = AE.esoteric_post(FIXED_WHEN)
    assert not VEDIC_RE.search(post), post


def test_works_for_multiple_dates():
    for iso in OTHER_DATES:
        y, m, d = (int(x) for x in iso.split("-"))
        when = datetime(y, m, d, 8, 30, tzinfo=ET)
        post = AE.esoteric_post(when)
        assert post and len(post) < 4000
        by_key = _events_by_key(when)
        for t, a, n, orb_str in FACT_RE.findall(post):
            key = f"Transiting {t} {a} natal {n}"
            assert key in by_key, (iso, key)
