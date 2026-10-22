"""levels_block: the levels.v1 block for out-of-repo senders (DECISIONS R32). No engine run, no network."""
import json
import os
import subprocess
import sys

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
import levels_block as LB  # noqa: E402

LINES = ["Levels: Entry: 1–2 (Long) · TP1 3 · TP2 4 · Final TP 5 · SL 0.5", LB.FOOTER]


def _run(monkeypatch, rc=0, out=None, err="", exc=None):
    seen = []
    def fake(cmd, **kw):
        seen.append((cmd, kw.get("cwd")))
        if exc:
            raise exc
        return subprocess.CompletedProcess(cmd, rc, out if out is not None else json.dumps({"lines": LINES}) + "\n", err)
    monkeypatch.setattr(LB.subprocess, "run", fake)
    LB._CACHE.clear()
    return seen


def test_side_and_horizon():
    assert [LB.side_for(x) for x in ("CALL", "calls", "PUT", "PUTS", "short", "BEARISH", None)] == \
        ["long", "long", "short", "short", "short", "short", "long"]
    assert [LB.horizon_for(x) for x in (0, 1, 2, "9", None)] == ["day", "day", "swing", "swing", "swing"]


def test_cli_args_cache_and_footer(monkeypatch):
    seen = _run(monkeypatch)
    assert LB.lines("spy", "short", "day", occ="SPY261022P00760000") == LINES
    cmd = seen[0][0]
    assert cmd[2:4] == ["pipeline.decision.levels.alert", "SPY"] and cmd[-2:] == ["--occ", "SPY261022P00760000"]
    assert cmd[cmd.index("--side") + 1] == "short" and cmd[cmd.index("--horizon") + 1] == "day"
    assert LB.lines("SPY", "short", "day", occ="SPY261022P00760000", footer=False) == LINES[:1]
    assert len(seen) == 1   # cached per process


def test_failures_are_named_and_still_say_no_size(monkeypatch):
    _run(monkeypatch, rc=1, out="", err="boom")
    assert LB.lines("X") == ["Levels UNAVAILABLE — levels.v1 engine exit 1: boom", LB.FOOTER]
    _run(monkeypatch, exc=subprocess.TimeoutExpired("x", 60))
    assert LB.lines("X")[0] == "Levels UNAVAILABLE — levels.v1 engine: TimeoutExpired"
