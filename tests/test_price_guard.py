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
    def __init__(self, quotes, why=None):
        self.quotes, self.why = quotes, why or {}

    def rh_quotes(self, occs, diag=None):
        if diag is not None:
            diag.update({o: w for o, w in self.why.items() if o in occs})
        return {o: q for o, q in self.quotes.items() if o in occs}


def test_option_mid_0dte_caller_now_before_fetch_is_not_future(monkeypatch):
    """2026-10-22 12:10 ET: the SPY 0DTE scalp card fell back to Alpaca because the engine passed the `now` it took at
    the start of its run; the fresh RH quote was seconds later, so the guard called it "trade time in the future"."""
    import time
    from datetime import timedelta
    occ = "SPY261022C00765000"
    q_at = time.time() - 1
    fake = _FakeRH({occ: {"bid": 1.58, "ask": 1.62, "mid": 1.6, "as_of": q_at, "as_of_et": "x"}})
    monkeypatch.setattr(pg, "_rh_quote_mod", lambda: fake)
    seen = {}
    monkeypatch.setattr(pg, "check", lambda ts, px, now=None, prev_bar_ts=None: seen.update(now=now) or
                        {"ok": True, "reason": None, "age_s": 1, "hhmm": "12:10", "window": "RTH"})
    run_start = datetime.now(timezone.utc) - timedelta(seconds=20)
    mid, chk, src, ex = pg.option_mid(occ, now=run_start)
    assert mid == 1.6 and "Robinhood" in src and ex["rh_reason"] is None
    assert seen["now"].timestamp() >= q_at          # checked against the fetch time, not the stale run start
    old = datetime(2026, 10, 20, 14, 0, tzinfo=timezone.utc)   # a backtest `now` before the quote is left alone
    fake.quotes[occ]["as_of"] = old.timestamp() - 5
    pg.option_mid(occ, now=old)
    assert seen["now"] == old


def test_option_mid_names_why_robinhood_missed(monkeypatch):
    occ = "SPY261022P00767000"
    monkeypatch.setattr(pg, "_rh_quote_mod", lambda: _FakeRH({}, {occ: "instrument lookup failed (HTTP 401)"}))
    mid, chk, src, ex = pg.option_mid(occ, now=RTH)
    assert mid is None and ex["rh_reason"] == "instrument lookup failed (HTTP 401)"
    assert "instrument lookup failed (HTTP 401)" in chk["reason"]
    node = {"latestQuote": {"bp": 2.4, "ap": 2.48, "t": "2026-10-20T13:59:55Z"}}
    mid, chk, src, ex = pg.option_mid(occ, now=RTH, alpaca_node=node)
    assert "not Robinhood" in src and ex["rh_reason"] == "instrument lookup failed (HTTP 401)"


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
    assert not q["A"]["ok"] and "Robinhood unavailable (OSError)" in q["A"]["reason"]   # chain reason names every source tried (2026-10-23)
