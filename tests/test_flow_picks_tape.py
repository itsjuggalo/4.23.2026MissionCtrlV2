"""The flow-picks 'Tape' line (audit P0 2026-10-22, was remedial W1 item 5): quote.v1 via price_guard.fresh, each
value with its own source + data time; a value that fails the send guard is UNAVAILABLE, never an older price.

Run: ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_flow_picks_tape.py
"""
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import flow_picks_post as F  # noqa: E402


def _ok(px, chg, src):
    return {"ok": True, "price": px, "change_pct": chg, "src": src, "as_of": "2026-10-22T13:49:00Z"}


def test_tape_carries_source_and_data_time_per_value():
    q = {"SPY": _ok(766.2, 0.41, "src Robinhood 09:49 ET"), "QQQ": _ok(705.3, -0.2, "src Robinhood 09:49 ET"),
         "^VIX": _ok(17.24, 1.1, "src Yahoo 09:48 ET")}
    tape = F._tape(q)
    assert "SPY 766 (+0.4%, src Robinhood 09:49 ET)" in tape
    assert "QQQ 705 (-0.2%, src Robinhood 09:49 ET)" in tape
    assert "VIX 17.2 (+1.1%, src Yahoo 09:48 ET)" in tape


def test_failed_guard_is_unavailable_with_reason():
    q = {"SPY": {"ok": False, "reason": "last trade 900s old (max 60s RTH)", "price": 760.0},
         "QQQ": _ok(705.3, None, "src Robinhood 09:49 ET")}
    tape = F._tape(q)
    assert "SPY UNAVAILABLE (last trade 900s old (max 60s RTH))" in tape
    assert "760" not in tape                                  # the stale price is never shown
    assert "QQQ 705 (src Robinhood 09:49 ET)" in tape
    assert "VIX UNAVAILABLE (no quote)" in tape
