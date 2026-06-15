"""heartbeat — tiny success-marker so a watchdog can tell if a cron poster went dark.
Each poster calls beat(name) on a successful run; poster_watchdog checks the mtimes."""
from __future__ import annotations

import os
import time
from pathlib import Path

HB_DIR = Path.home() / ".openclaw" / "state" / "heartbeats"


def beat(name: str) -> None:
    try:
        HB_DIR.mkdir(parents=True, exist_ok=True)
        (HB_DIR / name).write_text(str(int(time.time())))
    except Exception:
        pass


def beat_epoch(name: str) -> float | None:
    """Epoch seconds of the last beat, or None."""
    p = HB_DIR / name
    if not p.exists():
        return None
    try:
        return float(p.read_text().strip())
    except Exception:
        try:
            return os.path.getmtime(p)
        except Exception:
            return None


def age_min(name: str) -> float | None:
    """Minutes since the last successful beat, or None if never."""
    p = HB_DIR / name
    if not p.exists():
        return None
    try:
        return (time.time() - float(p.read_text().strip())) / 60.0
    except Exception:
        try:
            return (time.time() - os.path.getmtime(p)) / 60.0
        except Exception:
            return None
