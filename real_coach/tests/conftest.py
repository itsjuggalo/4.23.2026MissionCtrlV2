"""Shared fixtures. The ORACLE here is deliberately independent of the engine: raw pyswisseph +
its own bisection + zoneinfo — it never calls astro_truth.find_crossings / progressed_at."""
import os
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path
from zoneinfo import ZoneInfo

import pytest
import swisseph as swe

HERE = Path(__file__).resolve().parent.parent
sys.path.insert(0, str(HERE))
swe.set_ephe_path(str(Path.home() / ".local/share/swisseph"))
ET = ZoneInfo("America/New_York")
NATAL_JD = swe.julday(1992, 11, 4, 3 + 46 / 60)


def o_jd(dt: datetime) -> float:
    u = dt.astimezone(timezone.utc)
    return swe.julday(u.year, u.month, u.day, u.hour + u.minute / 60 + u.second / 3600)


def o_local(jd: float) -> datetime:
    y, m, d, h = swe.revjul(jd)
    return (datetime(y, m, d, tzinfo=timezone.utc) + timedelta(hours=h)).astimezone(ET)


def o_lon(jd: float, body: int) -> float:
    return swe.calc_ut(jd, body)[0][0] % 360


def o_prog_lon(target_jd: float, body: int) -> float:
    return o_lon(NATAL_JD + (target_jd - NATAL_JD) / 365.25, body)


def o_root(f, lo: float, hi: float, iters: int = 60) -> float:
    """Plain bisection on a bracket (caller guarantees a sign change)."""
    flo = f(lo)
    for _ in range(iters):
        mid = (lo + hi) / 2
        fm = f(mid)
        if (flo < 0) == (fm < 0):
            lo, flo = mid, fm
        else:
            hi = mid
    return (lo + hi) / 2


def sdiff(a: float, b: float) -> float:
    return (a - b + 180) % 360 - 180


@pytest.fixture(autouse=True)
def _isolated_profiles(tmp_path, monkeypatch):
    """Never touch the real profile store from tests."""
    monkeypatch.setenv("ASTRO_PROFILES", str(tmp_path / "profiles.json"))
    yield


@pytest.fixture(autouse=True)
def _isolated_trace(tmp_path, monkeypatch):
    """Never write test requests into the production trace log (review B19)."""
    import astro_trace as TR
    monkeypatch.setenv("ASTRO_TRACE", str(tmp_path / "trace.jsonl"))
    monkeypatch.setattr(TR, "TRACE", tmp_path / "trace.jsonl")
    yield
