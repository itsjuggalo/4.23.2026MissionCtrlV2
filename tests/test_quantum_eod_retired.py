import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import quantum_tg as q  # noqa: E402


def test_eod_has_no_track_record_after_supercomputer_retired(monkeypatch):
    """supercomputer.sh (scoreboard.json) was retired 2026-10-23: the Close card never reads it."""
    monkeypatch.setattr(q, "_load", lambda n: {"as_of": "2026-09-30T15:09:56", "overall": {"graded": 726},
                                               "recent": [{"date": "2026-10-23", "outcome": "win"}]})
    for f in ("_close_tape", "_close_breadth", "_close_sectors", "_tomorrow_events"):
        monkeypatch.setattr(q, f, lambda: None)
    out = q.eod()
    assert "Track record" not in out and "graded" not in out and "Close" in out.title()


def test_paused_note_says_retired(monkeypatch, tmp_path):
    import json
    reg = tmp_path / "r.json"
    reg.write_text(json.dumps({"entries": [{"id": "quantum-lab", "expectation": "retired",
                                            "retired": {"date": "2026-10-23"}}]}))
    monkeypatch.setattr(q, "REGISTRY", str(reg))
    assert q.paused_note() == "quantum pipeline retired 10-23 (Mike) — no current pick"


def test_tidy_strips_markdown_urls():
    out = q.tidy("Chips up ([Reuters](https://www.marketscreener.com/x?a=1)) ok\nhttps://foo.com/bar")
    assert "http" not in out and "Reuters" in out
