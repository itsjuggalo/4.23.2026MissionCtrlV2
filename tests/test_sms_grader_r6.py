"""sms_grader --edge (W7, DECISIONS R6): follow-through grading never peeks past a horizon, a horizon no bar fits is
None (UNAVAILABLE), PUTS are signed the other way, and the edge verdict needs n, a CI above 0, a beaten shuffled
baseline and a positive out-of-sample mean. Synthetic bars only (no network).
Run: ~/mc-kb/.venv/bin/python ~/scripts/tests/test_sms_grader_r6.py   (also pytest-compatible)"""
import datetime as dt
import sys
from pathlib import Path
from zoneinfo import ZoneInfo

import numpy as np
import pandas as pd

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "real_coach"))
import sms_grader as G  # noqa: E402

ET = ZoneInfo("America/New_York")


def bars(day="2026-10-15", start="09:30", n=390, step=1, px0=100.0, drift=0.01):
    idx = pd.date_range(f"{day} {start}", periods=n, freq=f"{step}min", tz=ET)
    close = px0 + drift * np.arange(1, n + 1)
    return pd.DataFrame({"Open": close - drift, "High": close + 0.02, "Low": close - drift - 0.02, "Close": close}, index=idx)


def test_calls_follow_through_no_peek():
    b = bars()
    t0 = dt.datetime(2026, 10, 15, 10, 0, tzinfo=ET)
    ft = G.follow_through_r6(t0, 100.30, 1, b, "1m")
    # +15 m reads the bar that ENDS at 10:15 (opened 10:14 = bar 44, close 100 + 0.01*45); +1 h the bar ending 11:00
    assert ft["m15"] == round((100 + 0.01 * 45 - 100.30) / 100.30 * 100, 4)
    assert ft["h1"] == round((100 + 0.01 * 90 - 100.30) / 100.30 * 100, 4)
    assert ft["close"] > ft["h1"] > ft["m15"] > 0
    assert ft["best"] >= ft["close"] and ft["worst"] <= ft["m15"]


def test_puts_are_signed_against_the_move():
    b = bars()
    t0 = dt.datetime(2026, 10, 15, 10, 0, tzinfo=ET)
    c, p = G.follow_through_r6(t0, 100.30, 1, b, "1m"), G.follow_through_r6(t0, 100.30, -1, b, "1m")
    assert p["h1"] == -c["h1"] and p["close"] == -c["close"]


def test_hourly_bars_leave_short_horizons_unavailable():
    b = bars(start="09:30", n=7, step=60)
    t0 = dt.datetime(2026, 10, 15, 10, 45, tzinfo=ET)
    ft = G.follow_through_r6(t0, 100.0, 1, b, "1h")
    assert ft["m15"] is None and ft["h1"] is None and ft["close"] is not None


def test_no_bars_after_card_is_none():
    b = bars(n=30)
    assert G.follow_through_r6(dt.datetime(2026, 10, 15, 15, 0, tzinfo=ET), 100.0, 1, b, "1m") is None


def _rows(vals, base):
    return [{"ts": f"2026-09-{i + 1:02d}T10:00:00-04:00", "h1": v, "baseline_h1": base} for i, v in enumerate(vals)]


def test_edge_verdict_requires_every_test():
    rng = np.random.default_rng(1)
    good = G.edge_stats(_rows([0.30 + 0.01 * (i % 5) for i in range(25)], [-0.1, 0.0, 0.1]), "h1", rng)
    assert good["verdict"] == "EDGE", good
    small = G.edge_stats(_rows([0.3] * 5, [-0.1, 0.0, 0.1]), "h1", rng)
    assert small["verdict"].startswith("NO PROVEN EDGE") and "n=5 < 20" in small["verdict"]
    random_like = G.edge_stats(_rows([0.05 * (-1) ** i for i in range(30)], [-0.1, 0.0, 0.1]), "h1", rng)
    assert "CI of the mean includes 0" in random_like["verdict"]
    decays = G.edge_stats(_rows([0.5] * 18 + [-0.2] * 12, [-0.1, 0.0, 0.1]), "h1", rng)
    assert "out-of-sample mean ≤ 0" in decays["verdict"]
    assert G.edge_stats([], "h1", rng)["verdict"].startswith("UNAVAILABLE")


def test_edge_mode_never_touches_the_live_gate_file():
    src = open(G.__file__).read()
    body = src[src.index("def edge_r6"):]
    assert "sms_edge.json" not in body.split("gate_status")[0]
    assert "tg-send" not in body and "send_sms" not in body


if __name__ == "__main__":
    tests = [(k, v) for k, v in dict(globals()).items() if k.startswith("test_")]
    bad = 0
    for k, f in tests:
        try:
            f(); print("  ok  " + k)
        except Exception as e:  # noqa: BLE001
            bad += 1; print(f"  FAIL {k} -> {e!r}"[:300])
    print(f"{len(tests) - bad} passed, {bad} failed")
    sys.exit(1 if bad else 0)
