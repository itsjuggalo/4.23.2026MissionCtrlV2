"""FLOW PICKS prices (audit P0 2026-10-22) — dry-run renders only, no sends, no network.

Robinhood option price first with its own data time; Yahoo last trade only as the labelled "not Robinhood" fallback;
both failing → UNAVAILABLE + a loud missing-data entry; levels.v1 block per pick with the R32 footer once; the
send-time re-check re-renders an aged price; flow2's suffixed OptionSymbol is priced by its plain OCC.
Run: ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_flow_picks_prices.py
"""
import sys
import time
from datetime import datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import flow_picks_post as F  # noqa: E402

NV = "NVDA261120C00200000"
AMD_RAW = "AMD261120P00150000_0941198737a6e1"   # flow2 row: OCC + source id
AMD = "AMD261120P00150000"
NOW = datetime.now(timezone.utc)
TS = NOW.isoformat()


def _alert(occ, sym, strike, typ, bull, fv):
    exp = int(time.time()) + 30 * 86400
    return {"OptionSymbol": occ, "Symbol": sym, "Strike": strike, "OptionType": typ, "Expiry": exp, "DTE": 30,
            "isBullish": bull, "totalFlowValue": fv, "Volume": 5000, "OI": 1000, "SWEEPS": 3, "BLOCKS": 0}


def _q(px, src="src Robinhood 09:49 ET"):
    return {"ok": True, "price": px, "src": src, "as_of": TS, "change_pct": 0.5}


def _setup(monkeypatch, rh, yahoo, logged, levels_seen, ps_seen):
    alerts = {NV: _alert(NV, "NVDA", 200, "Call", True, 2_000_000),
              AMD_RAW: _alert(AMD_RAW, "AMD", 150, "Put", False, 900_000)}
    monkeypatch.setattr(F, "_load", lambda: alerts)
    monkeypatch.setattr(F, "get_watchlist", lambda: [])
    monkeypatch.setattr(F, "_load_iv_map", lambda: {})
    monkeypatch.setattr(F, "_spot", lambda tk: {"NVDA": 198.0, "AMD": 152.0}[tk])
    monkeypatch.setattr(F, "fresh", lambda syms: {"SPY": _q(766.0), "QQQ": _q(705.0), "^VIX": _q(17.2, "src Yahoo 09:48 ET"),
                                                  "NVDA": _q(199.0), "AMD": _q(151.0)})
    monkeypatch.setattr(F, "option_quotes", lambda occs: {o: rh.get(o, {"ok": False, "reason": "Robinhood could not price it"})
                                                         for o in occs})
    monkeypatch.setattr(F, "_yahoo_last", lambda a: dict(yahoo))
    monkeypatch.setattr(F, "_log_picks", lambda picks: logged.append(picks))
    monkeypatch.setattr(F.card_mute, "is_muted", lambda s: False)

    def ps(occs, timeout=240, write=True):
        ps_seen.append((list(occs), write))
        return {}
    monkeypatch.setattr(F, "_pick_scores", ps)

    def lv(sym, side, horizon, occ=None, footer=True, timeout=60):
        levels_seen.append((sym, side, horizon, occ, footer))
        return [f"Levels: {sym} entry 1–2 · SL 0.5", "Methods: entry pivot · SL pivot · spot quote.v1"]
    monkeypatch.setattr(F.LB, "lines", lv)
    F.MISSING.clear()


def test_robinhood_price_shown_with_its_data_time_and_levels_block(monkeypatch):
    logged, lv, ps = [], [], []
    rh = {NV: {"ok": True, "mid": 4.25, "as_of": NOW.timestamp(), "src": "src Robinhood 09:49 ET"},
          AMD: {"ok": True, "mid": 1.1, "as_of": NOW.timestamp(), "src": "src Robinhood 09:49 ET"}}
    _setup(monkeypatch, rh, {"ok": False, "reason": "unused"}, logged, lv, ps)
    msg = F.build(dry_run=True)
    assert "💵 ~$4.25/ct [src Robinhood 09:49 ET] → $425 per contract" in msg
    assert "spot $199.00 (1% OTM, src Robinhood 09:49 ET)" in msg          # render-time spot, not selection-time
    assert "VIX 17.2 (+0.5%, src Yahoo 09:48 ET)" in msg
    assert msg.count("📐 Levels:") == 2 and msg.count(F.LB.FOOTER) == 1
    assert ("NVDA", "long", "swing", NV, False) in lv and ("AMD", "short", "swing", AMD, False) in lv
    assert ps == [([NV, AMD], False)]                                      # plain OCC, no --write in a dry run
    assert logged == []                                                    # dry run never logs picks
    assert F.MISSING == {}
    assert F.prices_fresh(now=NOW) is True


def test_yahoo_fallback_is_labelled_and_double_failure_is_unavailable_and_loud(monkeypatch):
    logged, lv, ps = [], [], []
    rh = {AMD: {"ok": False, "reason": "last trade 900s old (max 60s RTH)"}}
    yahoo = {"ok": True, "mid": 4.1, "as_of": TS, "src": "src Yahoo last trade (not Robinhood) 09:47 ET"}
    _setup(monkeypatch, rh, yahoo, logged, lv, ps)
    msg = F.build(dry_run=False)
    assert "~$4.10/ct [src Yahoo last trade (not Robinhood) 09:47 ET]" in msg
    assert logged and len(logged[0]) == 2

    _setup(monkeypatch, rh, {"ok": False, "reason": "Yahoo last trade: last trade 4000s old (max 60s RTH)"}, [], [], [])
    msg = F.build(dry_run=True)
    assert ("cost per contract UNAVAILABLE — Robinhood: last trade 900s old (max 60s RTH); "
            "Yahoo last trade: last trade 4000s old (max 60s RTH)") in msg
    tried = F.MISSING["flow_picks option price"]
    assert [t["source"] for t in tried] == ["Robinhood marketdata/options", "Yahoo option chain last trade (not Robinhood)"]
    assert AMD in tried[0]["error"]


def test_send_time_recheck_flags_an_aged_price(monkeypatch):
    rh = {NV: {"ok": True, "mid": 4.25, "as_of": NOW.timestamp(), "src": "src Robinhood 09:49 ET"}}
    _setup(monkeypatch, rh, {"ok": False, "reason": "x"}, [], [], [])
    F.build(dry_run=True)
    monkeypatch.setattr(F, "price_check", lambda ts, px, now=None: {"ok": False, "reason": "aged"})
    assert F.prices_fresh() is False


def test_unpriced_underlying_is_named_not_silent(monkeypatch):
    _setup(monkeypatch, {}, {"ok": False, "reason": "x"}, [], [], [])
    monkeypatch.setattr(F, "_spot", lambda tk: None if tk == "AMD" else 198.0)
    msg = F.build(dry_run=True)
    assert "AMD" not in msg.split("BEARISH")[0] and "AMD $150P" not in msg
    assert "AMD" in F.MISSING["flow_picks underlying spot"][0]["error"]


def test_occ_and_chunks():
    assert F._occ({"OptionSymbol": AMD_RAW}) == AMD and F._occ({"OptionSymbol": "junk"}) is None
    assert F._qsym("vix") == "^VIX" and F._qsym("NVDA") == "NVDA"
    parts = F._chunks("a" * 3000 + "\n\n" + "b" * 3000 + "\n\n" + "c" * 10, limit=3900)
    assert len(parts) == 2 and parts[1].startswith("b") and parts[1].endswith("c" * 10)
