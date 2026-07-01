"""shock_guard closing-bell z-artifact guard (GATED, flag defaults OFF).

Verifies _is_closing_bar's ET window and that SHOCK_EXCLUDE_CLOSING_BAR drops the
15:59→16:00 auction bar from the SPY z-score window (so a bell-only spike can't latch
a false CRISIS). No network — _get is monkeypatched.
"""
import os
import sys

sys.path.insert(0, os.path.expanduser("~/scripts"))
import shock_guard as sg  # noqa: E402


def test_is_closing_bar_et_window():
    # July = EDT (UTC-4): 19:59Z == 15:59 ET (closing minute), 20:00Z == 16:00 ET.
    assert sg._is_closing_bar("2026-07-01T19:59:00Z") is True
    assert sg._is_closing_bar("2026-07-01T20:00:00Z") is True
    assert sg._is_closing_bar("2026-07-01T19:58:00Z") is False   # 15:58 ET
    assert sg._is_closing_bar("2026-07-01T17:00:00Z") is False   # 13:00 ET
    assert sg._is_closing_bar("") is False
    assert sg._is_closing_bar("not-a-timestamp") is False


def _bars_with_bell_spike():
    # 20 quiet pre-close bars (15:30–15:49 ET) then a -5% closing-auction spike at 15:59 ET.
    bars = []
    price = 100.0
    for i in range(20):
        price += 0.02 if i % 2 else -0.01           # small, nonzero variance
        bars.append({"t": f"2026-07-01T19:{30 + i:02d}:00Z", "c": round(price, 2)})
    bars.append({"t": "2026-07-01T19:59:00Z", "c": round(price * 0.95, 2)})  # bell spike
    return bars


def _patch(monkey_env, exclude):
    sg.EXCLUDE_CLOSING_BAR = exclude
    sg._secret = lambda name: "x"
    sg._get = lambda *a, **k: {"bars": _bars_with_bell_spike()}


def test_bell_spike_dominates_when_flag_off():
    _prev = sg.EXCLUDE_CLOSING_BAR
    try:
        _patch(os.environ, exclude=False)
        r = sg.check_spy_z()
        assert r["z"] is not None
        assert r["last_ret_pct"] < -4.0            # the -5% auction bar is the latest return
    finally:
        sg.EXCLUDE_CLOSING_BAR = _prev


def test_bell_spike_excluded_when_flag_on():
    _prev = sg.EXCLUDE_CLOSING_BAR
    try:
        _patch(os.environ, exclude=True)
        r = sg.check_spy_z()
        assert r["z"] is not None
        assert abs(r["last_ret_pct"]) < 1.0        # spike removed -> latest return is quiet
    finally:
        sg.EXCLUDE_CLOSING_BAR = _prev
