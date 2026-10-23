"""Remedial W1 (MC-AUD-026/029): the options scorecard never joins another contract, takes spot from the
Robinhood-first price guard (never Alpaca), and states the breakeven move with its direction."""
import sys
from datetime import date
from pathlib import Path
from unittest import mock

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import options_position_scorecard as S  # noqa: E402


def pos(**kw):
    p = {"id": "x1", "root": "AAPL", "exp": date(2099, 1, 15), "kind": "call", "strike": 200.0, "mid": 5.0,
         "flags": [], "_side_known": True, "_quote_valid": True}
    p.update(kw)
    return p


def test_darkpool_join_needs_full_identity():
    by_id, by_ts = {}, {}
    sig = {"id": "other", "ticker": "AAPL", "strike": 200.0, "isPut": True, "expiryMs": None, "tag": "PUT FLOW"}
    by_ts[("AAPL", 200.0)] = sig
    assert S._dp_tag_for(pos(id="nomatch"), by_id, by_ts) == (None, None)   # ticker+strike alone never joins
    assert S._dp_tag_for(pos(id="other"), {"other": sig}, by_ts) == ("PUT FLOW", None)


def test_spot_comes_from_price_guard_not_alpaca():
    assert not hasattr(S, "_get")   # c56978c35 removed the Alpaca HTTP helper entirely
    with mock.patch.object(S.price_guard, "fresh", return_value={"AAPL": {"ok": True, "price": 210.0, "provider": "robinhood"}}):
        S._SPOT_CACHE.clear()
        assert S._spot("AAPL") == 210.0
    with mock.patch.object(S.price_guard, "fresh", return_value={"AAPL": {"ok": False, "price": 209.0, "reason": "stale"}}):
        S._SPOT_CACHE.clear()
        assert S._spot("AAPL") is None                                       # held price → no card, never a guess


def test_breakeven_move_is_signed():
    with mock.patch.object(S, "_spot", return_value=210.0):
        c = S.scorecard(pos())                       # call BE 205 < spot 210 → already beyond breakeven
        assert c["need_pct"] < 0
        p = S.scorecard(pos(kind="put", strike=200.0))   # put BE 195, spot 210 → needs a 7.1% drop
        assert round(p["need_pct"], 1) == 7.1
