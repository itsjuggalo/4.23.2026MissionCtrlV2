"""Shock Guard BLIND goes to its charter lane flow_signals, not trading_command (eval 10-23 §17). The real 16:40 ET
10-23 card is re-rendered through alert_blind() → lib.notify.tg_push → tg_fleet in TG_DRY_RUN in /usr/bin/python3 (the
cron interpreter). The alert gate is stubbed so the real cooldown state is untouched. No send."""
import json
import os
import subprocess
from pathlib import Path

CHILD = r'''
import sys, json
sys.path.insert(0, "/home/itsju/scripts")
import shock_guard as g
g.DRY = False
g.should_send = lambda *a, **k: (True, "test")
marked = []
g.mark_sent = lambda *a, **k: marked.append(a)
g.log_event = lambda *a, **k: None
g.alert_blind(["news (localhost market-news failed)"])
print("\nRESULT " + json.dumps({"marked": len(marked)}))
'''
REAL = ("🩶 <b>SHOCK GUARD — BLIND</b>", "<b>FAILED SOURCES</b>", "▸ <b>news (localhost market-news failed)</b>",
        "<i>CRISIS/HALT detection is degraded until this clears — both the free source and its fallback failed on the "
        "same tick.</i>")


def test_real_blind_card_renders_on_flow_signals():
    env = {**os.environ, "TG_DRY_RUN": "1", "TG_DIGEST_OFF": "1"}
    r = subprocess.run(["/usr/bin/python3", "-c", CHILD], capture_output=True, text=True, env=env, timeout=120)
    out = r.stdout
    assert "RESULT " in out, out + r.stderr
    dry = [ln for ln in out.splitlines() if ln.startswith("DRY ")]
    assert dry and all(ln.split()[1] == "flow_signals" for ln in dry), dry
    assert not any(ln.split()[1] == "trading_command" for ln in dry)        # negative: old lane gone
    for part in REAL:
        assert part in out, part


def test_crisis_alerts_keep_their_lane():
    src = (Path.home() / "scripts" / "shock_guard.py").read_text()
    assert src.count('tg_push(text, "flow_signals"') == 2 and '"trading_command"' not in src
