"""aime_flow_desk fails loud (script-standard #10, 2026-10-23): dead AIME cookie → exit 3, a lost Discord chunk → 1,
all chunks posted → 0. Nothing is posted here (post_discord and the health gate are stubbed)."""
import importlib.util
import sys
from pathlib import Path
from unittest import mock

P = Path.home() / "scripts" / "aime_flow_desk.py"


def load():
    spec = importlib.util.spec_from_file_location("aime_flow_desk_t", P)
    m = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(m)
    return m


def run(m, *argv):
    with mock.patch.object(sys, "argv", ["aime_flow_desk.py", *argv]):
        return m.main()


def test_exit_codes():
    m = load()
    with mock.patch.object(m, "load_digest", lambda: {"x": 1}), mock.patch.object(m, "ensure_aime_alive", lambda: False):
        assert run(m, "--digest", "--post") == 3
    with mock.patch.object(m, "load_digest", lambda: {"x": 1}), mock.patch.object(m, "ensure_aime_alive", lambda: True), \
            mock.patch.object(m, "top_flow_tickers", lambda d: [{"symbol": "NVDA"}]), \
            mock.patch.object(m, "render", lambda *a: "x" * 3000):
        with mock.patch.object(m, "post_discord", lambda msg: 1):
            assert run(m, "--digest", "--post") == 1
        with mock.patch.object(m, "post_discord", lambda msg: 2):
            assert run(m, "--digest", "--post") == 0


def test_wrapper_propagates_exit_code():
    src = (Path.home() / "scripts" / "run_aime_flow_desk.sh").read_text()
    assert 'RC=$?' in src and 'exit "$RC"' in src
