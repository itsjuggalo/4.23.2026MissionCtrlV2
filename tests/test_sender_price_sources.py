"""Audit 2026-10-22 (market-data §2): every price the six senders print carries a source + data time. Dry renders with
fakes only — no network, nothing is sent. Run: ~/.venv/bin/python -m pytest -q tests/test_sender_price_sources.py"""
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
sys.path.insert(0, str(ROOT / "trade_charts"))
sys.path.insert(0, str(ROOT / "lib"))


def test_max_pain_caption_names_spot_source_and_chain_time():
    import max_pain as M
    r = dict(ticker="SPY", spot=763.67, spot_src="src Robinhood 09:35 ET", chain_asof="10-22 16:14 ET", mp=770.0,
             expiry="2026-11-20", dte=29, basis="OI", call_oi=1, put_oi=2)
    cap = M.caption(r)
    assert "spot src Robinhood 09:35 ET" in cap and "Yahoo option chain (not Robinhood" in cap and "10-22 16:14 ET" in cap


def test_straddle_caption_names_spot_and_leg_sources():
    import straddle_cards as S
    s = dict(ticker="SPY", straddle=19.39, em=0.025, expiry="2026-11-06", dte=15, breakdn=744.28, breakup=783.06, iv=0.16,
             crush=False, spot=763.67, spot_src="src Robinhood 09:55 ET", leg_src="Yahoo option chain (not Robinhood, delayed) bid/ask mid",
             leg_asof="10-22 09:54 ET")
    cap = S.caption(s, None)
    assert "spot $763.67 src Robinhood 09:55 ET" in cap and "last leg trade 10-22 09:54 ET" in cap


def test_spot_unavailable_fails_closed(monkeypatch):
    import spotsrc
    import price_guard
    monkeypatch.setattr(price_guard, "fresh", lambda syms: {s: {"ok": False, "reason": "stale"} for s in syms})
    assert spotsrc.live_spot("SPY") == (None, "spot UNAVAILABLE — stale")
    import max_pain as M
    try:
        M.compute("SPY")
        raise AssertionError("compute must refuse without a fresh spot")
    except ValueError as e:
        assert "spot UNAVAILABLE" in str(e)


def test_flow_ta_caption_carries_alert_time_and_spot_source():
    import flow_ta_cards as F
    fs = [{"prem": 2e6, "isBullish": True, "Expiry": None, "SWEEPS": 1, "OptionType": "Call",
           "OptionSymbol": "TSLA261023C00380000", "Strike": 380, "t": 1792694258019}]
    cap = F.caption("TSLA", fs, (375.93, "src Robinhood 09:50 ET"))
    first, second = cap.split("\n")
    assert "latest alert 10-22" in second and "spot $375.93 src Robinhood 09:50 ET" in second and "Yahoo bars" in second
    assert "spot" not in first                     # the dedupe key (first line) is stable across runs


def test_watchlist_last_is_reread_with_source(monkeypatch):
    import price_guard
    import watchlist_exec as W
    monkeypatch.setattr(price_guard, "fresh", lambda syms: {"TSLA": {"ok": True, "price": 376.0, "src": "src Robinhood 15:10 ET"},
                                                          "AAPL": {"ok": False, "reason": "stale"}})
    last = W.live_last(["TSLA", "AAPL"])
    assert last == {"TSLA": "last 376.00 · src Robinhood 15:10 ET", "AAPL": "last UNAVAILABLE (stale)"}
    assert "src Robinhood 15:10 ET" in W.fmt_swing({"symbol": "TSLA", "dir": "LONG", "score": 8.4, "entry": 1}, True, last)


def test_flow_board_line_shows_mark_with_source(monkeypatch):
    import flow_chase as FC
    monkeypatch.setattr(FC, "option_snapshot", lambda occ: {"mid": 2.5, "src": "src Robinhood 10:31 ET", "quote_check": {"ok": True}})
    monkeypatch.setattr(FC, "equity_snapshot", lambda t: {})
    monkeypatch.setattr(FC, "chase_verdict", lambda a, s, e: {"tier": "EARLY", "emoji": "🟢", "mid": 2.5, "move": 3.0, "action": ""})
    line = FC._compact("TSLA261023C00380000", {"Symbol": "TSLA", "Strike": 380, "OptionType": "Call"})
    assert "mark $2.50 · src Robinhood 10:31 ET" in line


def test_eod_tape_names_yahoo_and_the_session():
    src = (ROOT / "quantum_tg.py").read_text()
    assert "Yahoo daily close (not Robinhood), session" in src
