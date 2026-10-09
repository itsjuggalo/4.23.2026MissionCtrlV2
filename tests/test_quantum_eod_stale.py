import sys
from pathlib import Path
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import quantum_tg as q  # noqa: E402


def test_sessions_old():
    assert q._sessions_old("2026-10-07", "2026-10-08") == 1
    assert q._sessions_old("2026-09-30", "2026-10-08") == 6
    assert q._sessions_old("2026-10-02", "2026-10-05") == 1  # Fri -> Mon
    assert q._sessions_old("", "2026-10-08") is None


def test_eod_marks_stale(monkeypatch):
    monkeypatch.setattr(q, "_load", lambda n: {"as_of": "2026-09-30T15:09:56", "overall": {"graded": 726, "win_rate": .36, "expectancy_pct": 49.0}})
    for f in ("_close_tape", "_close_breadth", "_close_sectors", "_tomorrow_events"):
        monkeypatch.setattr(q, f, lambda: None)
    out = q.eod()
    assert "STALE" in out and "09-30" in out
