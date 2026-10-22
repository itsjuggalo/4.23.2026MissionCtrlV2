"""Remedial W1 MC-AUD-035: the live quiz labels journal rows as hypothetical paper examples, takes spot from the
Robinhood-first price guard (never Alpaca) and teaches no stop."""
import sys
from datetime import date
from pathlib import Path
from unittest import mock

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import options_live_quiz as L  # noqa: E402


def test_spot_via_price_guard_only():
    with mock.patch.object(L, "_get", side_effect=AssertionError("Alpaca called")), \
         mock.patch.object(L.price_guard, "fresh", return_value={"AAPL": {"ok": False, "price": 1.0}}):
        assert L._spot("AAPL") is None


def test_hypothetical_header_and_no_stop():
    pos = {"symbol": "AAPL990115C00200000", "root": "AAPL", "strike": 200.0, "kind": "call",
           "exp": date(2099, 1, 15), "mark": 30.0, "avg": 10.0, "uplpc": 200.0}
    pos["qty"] = 1
    with mock.patch.object(L, "_spot", return_value=220.0), \
         mock.patch.object(L, "_open_option_positions", return_value=[pos]):
        q = L.position_question()
    text = q["header"] + q["question"] + q["why"] + " ".join(q["options"])
    assert "hypothetical" in q["header"] and "YOUR LIVE" not in text
    assert "stop on" not in text and "breakeven stop" not in text
