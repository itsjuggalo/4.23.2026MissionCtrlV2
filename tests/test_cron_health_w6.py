"""Remedial W6 MC-AUD-126: cron_health latches the problem KIND (a changed failure speaks again), uses the market
clock, and no longer watches the retired grid-daemon."""
import json
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import cron_health as C  # noqa: E402


def test_kind_ignores_ages():
    assert C.problem_kind(["stale 47m (>45m)"]) == C.problem_kind(["stale 77m (>45m)"])
    assert C.problem_kind(["stale 47m (>45m)"]) != C.problem_kind(["recent error: Traceback"])


def test_latched_kind(tmp_path):
    p = tmp_path / "job"
    assert C.latched_kind(p) is None
    p.write_text("2026-10-20T13:30:05+00:00")
    assert C.latched_kind(p) == "__legacy__"
    p.write_text(json.dumps({"at": "x", "kind": "stale Nm (>Nm)"}))
    assert C.latched_kind(p) == "stale Nm (>Nm)"


def test_changed_failure_pings_again(tmp_path, monkeypatch):
    log = tmp_path / "x.log"
    log.write_text("Traceback (most recent call last)\n")
    monkeypatch.setattr(C, "LATCH", tmp_path / "latches")
    monkeypatch.setattr(C, "JOBS", [("job", log, None, False, True)])
    monkeypatch.setattr(C, "_gate_ok", lambda *a, **k: (True, "t"))
    monkeypatch.setattr(C, "_gate_mark", lambda *a, **k: None)
    monkeypatch.setattr(C, "market_open", lambda: False)
    sent = []
    monkeypatch.setattr(C, "ping", lambda m: sent.append(m) or True)
    C.main(); C.main()
    assert len(sent) == 1                      # same kind → one ping
    (C.LATCH / "job").write_text(json.dumps({"kind": "stale Nm (>Nm)"}))
    C.main()
    assert len(sent) == 2                      # different kind → speaks again


def test_fleet_retired():
    assert C.FLEET == []
