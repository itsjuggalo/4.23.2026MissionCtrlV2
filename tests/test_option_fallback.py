"""Option-mark fallback chain: Robinhood -> Yahoo (not Robinhood) -> CBOE delayed ~15m, each dated, send-guard age rule per
leg, all failing = UNAVAILABLE naming every source + one loud alert. Stubbed legs, no network, no real alert sends."""
import importlib.util
import sys
from datetime import datetime, timezone
from pathlib import Path
from types import SimpleNamespace

import pandas as pd

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
import price_guard as pg  # noqa: E402

spec = importlib.util.spec_from_file_location("t_option_fallback", ROOT / "lib" / "option_fallback.py")
of = importlib.util.module_from_spec(spec)
spec.loader.exec_module(of)

NOW = datetime(2026, 10, 20, 14, 0, tzinfo=timezone.utc)          # Tue 10:00 ET
OCC = "SPY261030C00700000"
FRESH = NOW.timestamp() - 10
OLD = NOW.timestamp() - 900                                          # 15 min: the delayed-feed case


def q(provider, label, as_of, bid=1.0, ask=1.2):
    return {"bid": bid, "ask": ask, "mid": round((bid + ask) / 2, 2), "last": 1.1, "as_of": as_of,
            "as_of_et": "x", "provider": provider, "label": label}


def setup(monkeypatch, rh=None, yahoo=(None, "no chain"), cboe=(None, "no chain")):
    rq = SimpleNamespace(rh_quotes=lambda occs, diag=None: ({OCC: rh} if rh else {}))
    monkeypatch.setattr(pg, "_rh_quote_mod", lambda: rq)
    calls = []
    legs = (("Yahoo", lambda o: (calls.append("Yahoo"), yahoo)[1]), ("CBOE", lambda o: (calls.append("CBOE"), cboe)[1]))
    monkeypatch.setattr(pg, "_option_fallback_mod", lambda: SimpleNamespace(LEGS=legs))
    alerts = []
    monkeypatch.setattr(pg, "_alert_missing", lambda name, tried: alerts.append((name, tried)))
    return calls, alerts


def test_robinhood_hit_skips_fallbacks(monkeypatch):
    rh = {"bid": 1.0, "ask": 1.2, "mid": 1.1, "as_of": FRESH, "iv": None, "delta": None, "high": None, "low": None}
    calls, alerts = setup(monkeypatch, rh=rh)
    mid, chk, src, x = pg.option_mid(OCC, now=NOW)
    assert mid == 1.1 and "Robinhood" in src and calls == [] and alerts == []


def test_yahoo_leg_labelled_and_dated(monkeypatch):
    calls, alerts = setup(monkeypatch, yahoo=(q("yahoo", of.YAHOO_LABEL, FRESH), None))
    mid, chk, src, x = pg.option_mid(OCC, now=NOW)
    assert mid == 1.1 and "Yahoo · not Robinhood" in src and x["provider"] == "yahoo" and x["as_of"] == FRESH
    assert calls == ["Yahoo"] and alerts == []


def test_cboe_leg_when_yahoo_has_nothing(monkeypatch):
    calls, alerts = setup(monkeypatch, cboe=(q("cboe", of.CBOE_LABEL, FRESH), None))
    mid, chk, src, x = pg.option_mid(OCC, now=NOW)
    assert mid == 1.1 and "CBOE delayed ~15m" in src and calls == ["Yahoo", "CBOE"]
    assert [t["source"] for t in x["tried"]] == ["Robinhood", "Yahoo", "CBOE"]


def test_too_old_fallback_not_used_by_sender_but_shown(monkeypatch):
    calls, alerts = setup(monkeypatch, yahoo=(None, "x"), cboe=(q("cboe", of.CBOE_LABEL, OLD), None))
    mid, chk, src, x = pg.option_mid(OCC, now=NOW)
    assert mid is None and not chk["ok"] and "CBOE" in chk["reason"] and "too old" in chk["reason"]
    assert x["stale"]["provider"] == "cboe" and x["stale"]["mid"] == 1.1     # a display caller can still show it, dated
    assert alerts == []                                                       # a source answered: gate closed, not missing data


def test_all_fail_names_every_source_and_alerts_once(monkeypatch):
    calls, alerts = setup(monkeypatch, yahoo=(None, "HTTP 429"), cboe=(None, "contract not in the CBOE chain"))
    mid, chk, src, x = pg.option_mid(OCC, now=NOW)
    assert mid is None and src is None
    for name in ("Robinhood", "Yahoo", "CBOE", "HTTP 429"):
        assert name in chk["reason"]
    assert chk["reason"].startswith("UNAVAILABLE")
    assert len(alerts) == 1 and alerts[0][0] == f"option mark {OCC}"


def test_expired_contract_is_not_chased(monkeypatch):
    calls, alerts = setup(monkeypatch)
    mid, chk, src, x = pg.option_mid("SPY250117C00500000", now=NOW)
    assert mid is None and calls == [] and alerts == [] and "expired" in chk["reason"]


def test_option_quotes_batch_uses_fallback(monkeypatch):
    calls, alerts = setup(monkeypatch, yahoo=(q("yahoo", of.YAHOO_LABEL, FRESH), None))
    r = pg.option_quotes([OCC], now=NOW)[OCC]
    assert r["ok"] and r["mid"] == 1.1 and r["provider"] == "yahoo" and "Yahoo · not Robinhood" in r["src"]


def test_option_quotes_all_fail_is_unavailable_with_one_alert(monkeypatch):
    calls, alerts = setup(monkeypatch, yahoo=(None, "down"), cboe=(None, "down"))
    r = pg.option_quotes([OCC], now=NOW)[OCC]
    assert not r["ok"] and r["mid"] is None and "Yahoo: down" in r["reason"] and "CBOE: down" in r["reason"]
    assert len(alerts) == 1


# ── the two leg parsers ───────────────────────────────────────────────────────
def test_yahoo_quote_parses_chain():
    calls = pd.DataFrame([{"contractSymbol": OCC, "bid": 2.0, "ask": 2.2, "lastPrice": 2.1,
                           "lastTradeDate": pd.Timestamp("2026-10-20 13:59:50", tz="UTC")}])
    got, why = of.yahoo_quote(OCC, _fetch=lambda root, exp: SimpleNamespace(calls=calls, puts=calls.iloc[0:0]))
    assert why is None and got["mid"] == 2.1 and got["label"] == of.YAHOO_LABEL and got["as_of"] == FRESH


def test_yahoo_quote_rejects_one_sided_and_missing():
    calls = pd.DataFrame([{"contractSymbol": OCC, "bid": 0.0, "ask": 0.0, "lastPrice": 1.0,
                           "lastTradeDate": pd.Timestamp("2026-10-20 13:59:50", tz="UTC")}])
    fetch = lambda root, exp: SimpleNamespace(calls=calls, puts=calls)
    assert of.yahoo_quote(OCC, _fetch=fetch)[0] is None
    assert of.yahoo_quote("SPY261030C00999000", _fetch=fetch)[1] == "contract not in the Yahoo chain"


def test_cboe_quote_parses_and_uses_feed_data_time_in_et():
    d = {"data": {"last_trade_time": "2026-10-20T09:59:50", "options": [
        {"option": OCC, "bid": 3.0, "ask": 3.4, "last_trade_price": 3.2}]}}
    got, why = of.cboe_quote(OCC, _fetch=lambda root: d)
    assert why is None and got["mid"] == 3.2 and got["label"] == of.CBOE_LABEL and got["as_of"] == FRESH


def test_cboe_quote_failure_reasons():
    assert of.cboe_quote(OCC, _fetch=lambda root: {"data": {"options": []}})[1] == "contract not in the CBOE chain"
    def boom(root):
        raise OSError("down")
    assert "OSError" in of.cboe_quote(OCC, _fetch=boom)[1]


def test_yahoo_without_yfinance_asks_the_venv(monkeypatch):
    def no_yf(root, exp):
        raise ImportError("no yfinance")
    monkeypatch.setattr(of, "_yahoo_via_venv", lambda occ: ({"mid": 9.0}, None))
    assert of.yahoo_quote(OCC, _fetch=no_yf) == ({"mid": 9.0}, None)
