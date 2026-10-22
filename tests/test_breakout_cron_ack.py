"""W5 MC-AUD-081: the breakout cooldown advances only after tg_fleet acknowledges the send.

Runs breakout_cron.sh under a throwaway HOME with a stub tg_fleet.py (no network, no real Telegram) and a replayed scan.
"""
import json, os, subprocess, sys
from pathlib import Path

CRON = Path(__file__).resolve().parents[1] / "breakout_cron.sh"
SCAN = {"breakouts": [{"symbol": "XYZ", "close": 80.0, "pct_vs_level": 1.2, "rvol": 2.0, "extreme_label": "",
                       "has_flow": False, "flow_dir": ""}], "breakdowns": []}


def _run(tmp, rc):
    home = tmp / "home"
    (home / "scripts").mkdir(parents=True, exist_ok=True)
    (home / ".venv/bin").mkdir(parents=True, exist_ok=True)
    py = home / ".venv/bin/python"
    if not py.exists():
        py.symlink_to(sys.executable)
    (home / "scripts/tg_fleet.py").write_text(
        f"import sys\nopen({str(tmp / 'sent.log')!r}, 'a').write(sys.argv[2] + '\\n')\nsys.exit({rc})\n")
    scan = tmp / "scan.json"; scan.write_text(json.dumps(SCAN))
    env = {"HOME": str(home), "PATH": os.environ["PATH"], "FORCE": "1", "BREAKOUT_ENRICH": "0",
           "BREAKOUT_SCAN_JSON_FILE": str(scan)}
    p = subprocess.run(["bash", str(CRON)], env=env, capture_output=True, text=True, timeout=60)
    return p.returncode, home / ".openclaw/data/breakout_seen.json"


def test_failed_send_keeps_cooldown_open_then_commits(tmp_path):
    rc, state = _run(tmp_path, 1)
    assert rc == 1 and not state.exists() and not Path(str(state) + ".pending").exists()
    rc, state = _run(tmp_path, 0)
    assert rc == 0 and json.loads(state.read_text())["sent"] == {"up:XYZ": 2.0}
    rc, _ = _run(tmp_path, 0)          # same RVOL → on cooldown, nothing sent
    assert rc == 0
    assert (tmp_path / "sent.log").read_text().split() == ["aime_research", "aime_research"]
