"""D-4 (T8.1c): the desk publisher must not republish the verdict-scan's final trading verdict under a
persona byline. Fixture-only: build_raynor runs against monkeypatched _get/_file — no HTTP, no DB write,
main() is never called (so no draft is queued and the state file is untouched)."""
from __future__ import annotations

import importlib.machinery
import importlib.util
import os
import re

import pytest

MOD_PATH = os.environ.get("DESK_PUBLISHER_PATH", os.path.expanduser("~/05_AUTOMATION/scripts/desk_publisher.py"))

SCAN = {"results": [
    {"symbol": "NVDA", "verdict": "STRONG BUY", "score": 87},
    {"symbol": "SPY", "verdict": "AVOID", "score": 22},
    {"ticker": "AAPL", "verdict": "HOLD"},
]}
CACHE = {"brief": "Macro: NEUTRAL regime, VIX 14.85.", "bullets": ["Top recent flow winner: META CALL peaked +299.0%."]}
CONSENSUS = {"numAnalysts": 40, "recs": {"strongBuy": 10, "buy": 20, "hold": 8, "sell": 2}, "targetMean": 200.5,
             "recommendationKey": "buy", "sources": ["yfinance"]}


@pytest.fixture()
def dp(monkeypatch):
    loader = importlib.machinery.SourceFileLoader("desk_publisher_under_test", MOD_PATH)
    spec = importlib.util.spec_from_loader(loader.name, loader)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)

    def fake_get(path, timeout=None, **_):
        if path.startswith("/api/verdict-scan"):
            return SCAN
        if path.startswith("/api/analyst-consensus"):
            return CONSENSUS
        return {}

    monkeypatch.setattr(mod, "_get", fake_get)
    monkeypatch.setattr(mod, "_file", lambda p: CACHE)
    monkeypatch.setattr(mod, "publish_article", lambda *a, **k: pytest.fail("publish_article must not run in a fixture test"))
    return mod


def test_raynor_keeps_evidence(dp):
    title, summary, body, tickers = dp.build_raynor("premarket")
    for sym in ("NVDA", "SPY", "AAPL"):
        assert f"**{sym}**" in body
    assert tickers == "NVDA,SPY,AAPL"
    assert "Macro: NEUTRAL regime" in body            # desk brief kept
    assert "META CALL" in body                         # bullets kept
    assert "30B/8H/2S" in body and "tgt $200.5" in body  # Wall-St consensus (sourced evidence) kept


def test_raynor_drops_scan_verdict(dp):
    _, _, body, _ = dp.build_raynor("premarket")
    assert "Top conviction" not in body
    assert "Verdict-first" not in body
    for v in ("STRONG BUY", "AVOID", "HOLD", "(87)", "(22)"):
        assert v not in body, v
    names = body.split("## Names on the scanner", 1)[1].split("\n\n", 1)[0]
    assert re.findall(r"^- \*\*(\w+)\*\*$", names, re.M) == ["NVDA", "SPY", "AAPL"]
    assert "Mike decides and places every order" in body
