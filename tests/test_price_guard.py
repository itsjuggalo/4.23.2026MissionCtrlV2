"""Remedial W1 (2026-10-20): the shared send-time price guard.

Run: MC_QUOTE_CLIENT=<quote_client.py> ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_price_guard.py
"""
import sys
from datetime import datetime, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import price_guard as pg  # noqa: E402

RTH = datetime(2026, 10, 20, 14, 0, tzinfo=timezone.utc)  # Tue 10:00 ET


def test_loaded():
    assert pg.QC is not None


def test_alpaca_last_fresh_and_stale():
    px, chk = pg.alpaca_last({"latestTrade": {"p": 10.5, "t": "2026-10-20T13:59:40Z"}}, RTH)
    assert px == 10.5 and chk["ok"]
    px, chk = pg.alpaca_last({"latestTrade": {"p": 10.5, "t": "2026-10-20T13:50:00Z"}}, RTH)
    assert px is None and "max 60s" in chk["reason"]


def test_option_mid_needs_fresh_quote():
    node = {"latestQuote": {"bp": 1.0, "ap": 1.2, "t": "2026-10-20T13:59:50Z"}}
    assert pg.alpaca_option_mid(node, RTH)[0] == 1.1
    node["latestQuote"]["t"] = "2026-10-19T19:59:00Z"
    mid, chk = pg.alpaca_option_mid(node, RTH)
    assert mid is None and "not today" in chk["reason"]


def test_missing_lib_fails_closed(monkeypatch):
    monkeypatch.setattr(pg, "QC", None)
    assert pg.check("2026-10-20T13:59:50Z", 5, now=RTH)["ok"] is False
    assert pg.src_label("X", None) == "src X time n/a"


def test_session_bars_reanchor_before_first_print():
    node = {"dailyBar": {"t": "2026-10-19T04:00:00Z", "c": 24}, "prevDailyBar": {"t": "2026-10-16T04:00:00Z", "c": 22}}
    prev, today = pg.alpaca_session_bars(node, RTH)
    assert prev["c"] == 24 and today == {}
    node["dailyBar"]["t"] = "2026-10-20T04:00:00Z"
    prev, today = pg.alpaca_session_bars(node, RTH)
    assert prev["c"] == 22 and today["c"] == 24
