"""Layer-3 seam test: pipe the TA verdict through the REAL signal_scorer +
signal_gatekeeper, in isolation. Proves the engine's output drops into the
gatekeeper contract WITHOUT importing or touching the live trader.

Memory/bypass writes are redirected to a temp dir (the real modules target an
Oracle-only path). The scorer + gate LOGIC are the real, unmodified code.
"""
import sys
import os
import json
import tempfile
from pathlib import Path

ENGINE_ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SHARED = os.path.expanduser("~/.openclaw/skills/shared")
sys.path.insert(0, ENGINE_ROOT)
sys.path.insert(0, SHARED)

from ta_engine import verdict

import signal_scorer
import signal_memory
import bypass_log
import signal_gatekeeper

# redirect Oracle-only paths to a temp dir
_tmp = Path(tempfile.mkdtemp(prefix="ta_seam_"))
signal_memory.CACHE_DIR = _tmp
signal_memory.MEMORY_FILE = _tmp / "signal_memory.json"
bypass_log.CACHE_DIR = _tmp
bypass_log.LOG_FILE = _tmp / "bypass_log.json"


def to_gatekeeper_signal(v):
    return {
        "asset": v["ticker"], "symbol": v["ticker"],
        "direction": v["direction"], "price": v["current"],
        "confidence": v["confidence"], "risk_reward": v["risk_reward"],
        "factors": v["factors"], "trend": v["trend"],
        "signal_type": v["signal_type"], "rsi": v["rsi"],
    }


def run(ticker, side, **kw):
    v = verdict.analyze(ticker, side=side, **kw)
    if "error" in v:
        print(f"{ticker}: ERROR {v['error']}"); return
    sig = to_gatekeeper_signal(v)
    scored = signal_scorer.score_signal(sig)              # REAL scorer
    gate = signal_gatekeeper.gate_signal(dict(scored))    # REAL gatekeeper
    print(f"{ticker} [{side}] conf={v['confidence']} rr={v['risk_reward']} factors={v['factors']}")
    print(f"   -> quality_score={scored['quality_score']}  GATE: passed={gate['passed']} "
          f"bypass={gate['bypass']} reason='{gate['reason']}'")


if __name__ == "__main__":
    # sanity: confirm we did NOT import the live trader
    assert not any("boba_decision_cycle" in m for m in sys.modules), "live trader was imported!"
    print("isolation OK: boba_decision_cycle NOT imported\n")
    run("QCOM", "long", asset_type="option", buy="5.0", sell="5.75", stop="3")
    run("TSLA", "short", asset_type="option", buy="4", sell="6", stop="2.5")
    run("NVDA", "long", asset_type="option", buy="3.2", sell="4.5", stop="2.0")
    run("SPY", "long", asset_type="stock")
    print(f"\nscorer+gatekeeper modules loaded from: {SHARED}")
    print("seam test complete (live trader untouched)")
