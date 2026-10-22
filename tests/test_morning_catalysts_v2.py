"""Briefs v2 (W-HUB 2026-10-22): morning_command's catalysts come from real calendars — the dossier calendar block and
the free-sources Nasdaq file — never the model's memory. Dry renders only; nothing is sent.

  ~/.venv/bin/python -m pytest -q tests/test_morning_catalysts_v2.py
"""
import importlib
import json
import os
import sys
from datetime import datetime

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.insert(0, ROOT)
MC = importlib.import_module("morning_command")


def _cal(tmp_path, monkeypatch, by_symbol):
    today = datetime.now(MC.ET).date().isoformat()
    doc = {"calendar": {"source": "Nasdaq", "as_of": f"{today}T00:56:00-04:00", "status": "OK", "window": [today, today]},
           "by_symbol": {s: {k: {kk: (today if vv == "TODAY" else vv) for kk, vv in v.items()} for k, v in ev.items()}
                         for s, ev in by_symbol.items()}}
    p = tmp_path / "catalysts.json"
    p.write_text(json.dumps(doc))
    monkeypatch.setattr(MC, "FREE_CATALYSTS", p)
    if MC.MC_REPO_DIR not in sys.path:
        sys.path.append(MC.MC_REPO_DIR)
    from pipeline.intel import dossier
    monkeypatch.setattr(dossier, "FREE", tmp_path)
    monkeypatch.setattr(MC, "_scheduled_today", lambda: "🏛️ FOMC rate decision")


def test_catalysts_from_calendars_name_their_source(tmp_path, monkeypatch):
    _cal(tmp_path, monkeypatch, {"PG": {"earnings": {"date": "TODAY", "time": "pre-market", "n_est": 10}},
                                 "XYZ": {"ex_dividend": {"ex_date": "TODAY", "amount": 0.5}},
                                 "BIG": {"earnings": {"date": "TODAY", "time": "after-hours", "n_est": 40}}})
    out = MC._calendar_catalysts(["PG", "XYZ", "NVDA"])
    assert out.startswith("🏛️ FOMC rate decision (macro calendar)")
    assert "your names: PG earnings pre-market, XYZ ex-dividend $0.5 (Nasdaq calendar via dossier)" in out
    assert "2 earnings today; most-covered: BIG (AMC), PG (BMO) (Nasdaq calendar" in out and "NVDA" not in out


def test_llm_only_writes_the_momentum_line(tmp_path, monkeypatch):
    _cal(tmp_path, monkeypatch, {})
    monkeypatch.setattr(MC, "_scheduled_today", lambda: "")
    seen = {}

    def fake(prompt, chain):
        seen["prompt"] = prompt
        return {"ok": True, "response": {"orders": "NVDA +2.5% since the open", "catalysts": "INVENTED CPI"}}
    monkeypatch.setattr(MC, "call_llm", fake)
    cat, orders = MC._catalysts_and_orders("NVDA, PG", "SPY +0.4%")
    assert cat == "" and orders == "NVDA +2.5% since the open"      # nothing scheduled → no catalysts line at all
    assert '"catalysts"' not in seen["prompt"] and "INVENTED" not in cat
