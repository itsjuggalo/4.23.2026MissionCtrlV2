"""Remedial W6 MC-AUD-125: exchange holidays are not trading days for the poster watchdog."""
import sys
from datetime import date
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import poster_watchdog as W  # noqa: E402


def test_holidays():
    assert W.trading_day(date(2026, 11, 26)) is False   # Thanksgiving
    assert W.trading_day(date(2026, 10, 21)) is True
    assert W.trading_day(date(2026, 10, 24)) is False   # Saturday
