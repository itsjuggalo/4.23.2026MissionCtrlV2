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


class _FakeRH:
    def __init__(self, quotes):
        self.quotes = quotes

    def rh_quotes(self, occs):
        return {o: q for o, q in self.quotes.items() if o in occs}


def _rhq(ts_iso, bid=1.0, ask=1.2):
    at = datetime.fromisoformat(ts_iso).timestamp()
    return {"bid": bid, "ask": ask, "mid": round((bid + ask) / 2, 2), "as_of": at, "as_of_et": "x"}


def test_option_quotes_live_guard_and_missing(monkeypatch):
    fake = _FakeRH({"A": _rhq("2026-10-20T13:59:50+00:00"), "B": _rhq("2026-10-20T13:40:00+00:00")})
    monkeypatch.setattr(pg, "_rh_quote_mod", lambda: fake)
    q = pg.option_quotes(["A", "B", "C"], now=RTH)
    assert q["A"]["ok"] and q["A"]["mid"] == 1.1 and q["A"]["provider"] == "robinhood" and "Robinhood" in q["A"]["src"]
    assert not q["B"]["ok"] and q["B"]["mid"] is None and "max 60s" in q["B"]["reason"]
    assert q["B"]["bid"] == 1.0          # the quote itself is still returned for the record
    assert not q["C"]["ok"] and q["C"]["provider"] is None and "could not price" in q["C"]["reason"]


def test_option_quotes_close_mode_needs_last_session(monkeypatch):
    night = datetime(2026, 10, 21, 1, 0, tzinfo=timezone.utc)      # Tue 10-20 21:00 ET, after the close
    fake = _FakeRH({"A": _rhq("2026-10-20T19:59:00+00:00"), "B": _rhq("2026-10-19T19:59:00+00:00")})
    monkeypatch.setattr(pg, "_rh_quote_mod", lambda: fake)
    q = pg.option_quotes(["A", "B"], now=night, mode="close")
    assert q["A"]["ok"] and q["A"]["mid"] == 1.1
    assert not q["B"]["ok"] and "last session 2026-10-20" in q["B"]["reason"]


def test_option_quotes_rh_down_fails_to_caller(monkeypatch):
    def boom():
        raise OSError("no token")
    monkeypatch.setattr(pg, "_rh_quote_mod", boom)
    q = pg.option_quotes(["A"], now=RTH)
    assert not q["A"]["ok"] and q["A"]["reason"] == "Robinhood unavailable (OSError)"
