"""EOD scorecard is sent once (eval 10-23 §15): tg_fleet exit 0 means accepted — "sent", "queued for digest" or "held"
— so the chain stops; only a real failure (exit 1) falls back to the next bot. No real send (subprocess stubbed, or the
fleet in TG_DRY_RUN)."""
import importlib.util
import os
import subprocess
import sys
from pathlib import Path
from unittest import mock

P = Path.home() / "scripts" / "eod_scorecard.py"
sys.path.insert(0, str(P.parent))


def load():
    spec = importlib.util.spec_from_file_location("eod_scorecard_t", P)
    m = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(m)
    return m


def fake_runs(*outs):
    calls = []

    def run(cmd, **k):
        rc, out = outs[len(calls)]
        calls.append(cmd[3])
        return subprocess.CompletedProcess(cmd, rc, out, "")
    return run, calls


def test_queued_for_digest_is_delivered_once():
    m = load()
    run, calls = fake_runs((0, "queued for digest (accepted; delivered at the next digest slot)\n"), (0, "sent\n"))
    with mock.patch.object(subprocess, "run", run):
        assert m._tg_send_html("📊 <b>EOD SCORECARD</b>") == "flow_digest"
    assert calls == ["flow_digest"]                      # the fallback bot never fires


def test_held_is_delivered_and_failure_falls_back():
    m = load()
    run, calls = fake_runs((0, "held by pre-send review: exact repeat within 30 min\n"))
    with mock.patch.object(subprocess, "run", run):
        assert m._tg_send_html("x") == "flow_digest"
    run, calls = fake_runs((1, "fail: Bad Request\n"), (0, "sent\n"))
    with mock.patch.object(subprocess, "run", run):
        assert m._tg_send_html("x") == "daily_briefs"   # negative: a real failure still falls back
    assert calls == ["flow_digest", "daily_briefs"]


def test_real_card_dry_render_one_send():
    card = Path(os.environ.get("EOD_CARD", "/nonexistent"))
    if not card.exists():
        return
    m = load()
    seen = []
    real = subprocess.run

    def spy(cmd, **k):
        r = real(cmd, **k)
        seen.append(r.stdout)
        return r
    with mock.patch.dict(os.environ, {"TG_DRY_RUN": "1"}), mock.patch.object(subprocess, "run", spy):
        assert m._tg_send_html(card.read_text().rstrip("\n")) == "flow_digest"
    assert len(seen) == 1 and seen[0].startswith("DRY ")
