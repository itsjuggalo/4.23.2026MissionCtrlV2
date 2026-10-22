"""pick_score.v1 line on the flow-picks card (missionctrl DECISIONS R35) — dry-run render only, no sends.

The card shows the factor line under each pick and never re-ranks by it; a scorer failure says UNAVAILABLE.
Run: ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_flow_picks_pick_score.py
"""
import json
import subprocess
import sys
import time
from pathlib import Path
from types import SimpleNamespace

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import flow_picks_post as F  # noqa: E402

OCC = "NVDA261120C00200000"
LINE = "pick_score.v1 +0.24 (10/12, display-only): flow +0.9 · OI — · IVR +0.4"


def _alert(occ, sym, strike, typ, bull, fv):
    exp = int(time.time()) + 30 * 86400
    return {"OptionSymbol": occ, "Symbol": sym, "Strike": strike, "OptionType": typ, "Expiry": exp, "DTE": 30,
            "isBullish": bull, "totalFlowValue": fv, "Volume": 5000, "OI": 1000, "SWEEPS": 3, "BLOCKS": 0}


def _render(monkeypatch, run):
    alerts = {OCC: _alert(OCC, "NVDA", 200, "Call", True, 2_000_000),
              "AMD261120P00150000": _alert("AMD261120P00150000", "AMD", 150, "Put", False, 900_000)}
    monkeypatch.setattr(F, "_load", lambda: alerts)
    monkeypatch.setattr(F, "get_watchlist", lambda: [])
    monkeypatch.setattr(F, "_load_iv_map", lambda: {})
    monkeypatch.setattr(F, "_spot", lambda tk: {"NVDA": 198.0, "AMD": 152.0}[tk])
    monkeypatch.setattr(F, "_tape", lambda: "")
    monkeypatch.setattr(F, "_log_picks", lambda picks: None)
    monkeypatch.setattr(F, "_cost_line", lambda *a, **k: "")
    monkeypatch.setattr(F.card_mute, "is_muted", lambda s: False)
    monkeypatch.setattr(F.subprocess, "run", run)
    return F.build()


def test_card_shows_factor_line_and_order_is_unchanged(monkeypatch):
    seen = {}

    def run(cmd, **kw):
        seen["cmd"] = cmd
        occs = cmd[cmd.index("--lines") + 1].split(",")
        return SimpleNamespace(returncode=0, stdout=json.dumps({o: LINE for o in occs}))
    msg = _render(monkeypatch, run)
    assert "--write" in seen["cmd"] and OCC in seen["cmd"][seen["cmd"].index("--lines") + 1]
    assert msg.count("pick_score.v1 +0.24") == 2
    assert msg.index("NVDA $200C") < msg.index("AMD $150P")      # ranking untouched


def test_scorer_failure_is_named_on_the_card(monkeypatch):
    def run(cmd, **kw):
        raise subprocess.TimeoutExpired(cmd, 240)
    msg = _render(monkeypatch, run)
    assert "pick_score.v1 UNAVAILABLE (TimeoutExpired)" in msg
