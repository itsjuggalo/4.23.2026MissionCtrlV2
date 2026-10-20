"""Remedial W1 item 5 (2026-10-20): the flow-picks 'Tape' line uses today's bar vs the prior close.

Run: ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_flow_picks_tape.py
"""
import sys
import types
from datetime import datetime, timedelta
from pathlib import Path

import pandas as pd

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import flow_picks_post as F  # noqa: E402


def _fake_yf(intraday_day_offset=0):
    today = datetime.now(F.ET).replace(hour=10, minute=0, second=0, microsecond=0)
    days = [today - timedelta(days=k) for k in (3, 2, 1)]

    class T:
        def __init__(self, sym):
            self.sym = sym

        def history(self, period, interval):
            if interval == "1d":   # daily bars end YESTERDAY: today's daily bar not there yet
                return pd.DataFrame({"Close": [100.0, 101.0, 102.0]}, index=pd.DatetimeIndex(days))
            ts = today - timedelta(days=intraday_day_offset)
            return pd.DataFrame({"Close": [103.02]}, index=pd.DatetimeIndex([ts]))
    return types.SimpleNamespace(Ticker=T)


def test_change_is_vs_last_close_before_today(monkeypatch):
    monkeypatch.setitem(sys.modules, "yfinance", _fake_yf())
    tape = F._tape()
    assert "SPY 103 (+1.0%)" in tape          # vs 102 (yesterday), not vs 101
    assert "(Yahoo 5m bar 10:00 ET)" in tape


def test_no_intraday_bar_today_means_no_tape(monkeypatch):
    monkeypatch.setitem(sys.modules, "yfinance", _fake_yf(intraday_day_offset=1))
    assert F._tape() == ""
