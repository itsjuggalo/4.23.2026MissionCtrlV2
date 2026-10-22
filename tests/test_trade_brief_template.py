import importlib.util
import subprocess
from datetime import datetime, timezone
from pathlib import Path

_spec = importlib.util.spec_from_file_location("tbg", Path(__file__).resolve().parents[1] / "trade-brief-generator.py")
tbg = importlib.util.module_from_spec(_spec)
_spec.loader.exec_module(tbg)


def test_template_sources_and_stale():
    fresh = datetime.now(timezone.utc).isoformat()
    b = tbg.template_brief([{"rank": 1, "ticker": "NVDA", "final_band": "GOLD", "generated_at": fresh}],
                           [], [], {"regime": "MIXED", "vix": 18, "vix_pct": 40, "fed_posture": "hold",
                                    "ran_at": "2026-01-01T00:00:00+00:00"})
    assert "src macro_context" in b[0] and "STALE" in b[0]
    assert "#1 NVDA GOLD" in b[1] and "STALE" not in b[1]
    assert tbg.template_brief([], [], [], None)[0].startswith("• Macro: UNAVAILABLE")


def test_read_reused_within_hour_and_verb_filter(monkeypatch):
    hour = datetime.now(tbg.ET).strftime("%Y-%m-%dT%H")
    assert tbg.llm_read(["• x"], {"read_hour": hour, "read": ["• r"], "read_status": "ok"}) == (["• r"], "ok", hour)
    monkeypatch.setattr(subprocess, "run", lambda *a, **k: subprocess.CompletedProcess(a, 0, "Watch NVDA\nBUY the dip\n", ""))
    assert tbg.llm_read(["• x"], {})[1] == "dropped (trade verb in LLM read)"
    monkeypatch.setattr(subprocess, "run", lambda *a, **k: subprocess.CompletedProcess(a, 0, "- Watch NVDA into the close\n", ""))
    lines, status, _ = tbg.llm_read(["• x"], {})
    assert status == "ok" and lines == ["• Read (LLM, interpretation only): Watch NVDA into the close"]


def test_prompt_capped(monkeypatch):
    seen = {}
    def fake(cmd, **k):
        seen["p"] = cmd[cmd.index("-p") + 1]
        assert "--setting-sources" in cmd and "--strict-mcp-config" in cmd
        return subprocess.CompletedProcess(cmd, 1, "", "llm-route: codex breaker open")
    monkeypatch.setattr(subprocess, "run", fake)
    _, status, _ = tbg.llm_read(["• " + "x" * 9000], {})
    assert len(seen["p"]) == tbg.READ_MAX_CHARS and status.startswith("unavailable (llm-route: codex breaker open")


def test_flow_winner_is_labelled_hindsight_peak():
    """W7 MC-AUD-098: flow_winners is a winner-only, first→max-print label — never shown as a return."""
    fresh = datetime.now(timezone.utc).isoformat()
    b = tbg.template_brief([], [{"symbol": "MU", "option_type": "C", "strike": 900, "expiry": "2026-11-20",
                                 "peak_pct": 1457, "detected_at": fresh}], [], None)
    line = next(x for x in b if "flow winner" in x)
    assert "hindsight peak +1457%" in line and "not a return" in line
