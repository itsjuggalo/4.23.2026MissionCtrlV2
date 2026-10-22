"""levels.v1 block for Telegram senders outside MissionCtrl (DECISIONS R32, Mike 2026-10-21).

One call per card: MissionCtrl's levels engine CLI (pipeline.decision.levels.alert) computes Entry / TP1 / TP2 /
Final TP / SL from data, each with its method, plus the spot source + as_of, the contract premium levels (Black-Scholes
at the contract's Robinhood IV) when an OCC is given, and "No size, no cap". It replaces the retired R5 line
"No stop, no target, no size". Any failure renders ONE line naming the reason ("Levels UNAVAILABLE — …"), never a
guessed level. Read-only: computes and prints, writes nothing; no MissionCtrl imports land in the caller.

    from levels_block import lines, side_for
    lines("NVDA", side_for("CALL"), horizon_for(dte), occ="NVDA261120C00200000")
"""
from __future__ import annotations

import json
import os
import subprocess
from pathlib import Path

MC_REPO = Path(os.environ.get("MC_REPO", "/AIWorkWSL/web/missionctrl"))
MC_PY = os.environ.get("MC_PY", str(Path.home() / ".venv/bin/python"))
FOOTER = "Computed from data (R32). No size, no cap — sizing is yours."
_CACHE: dict[tuple, list[str]] = {}


def side_for(kind: str) -> str:
    """CALL / CALLS / LONG / BULLISH → long; PUT / PUTS / SHORT / BEARISH → short (the underlying's direction)."""
    return "short" if str(kind or "").strip().upper().startswith(("P", "SHORT", "BEAR")) else "long"


def horizon_for(dte) -> str:
    """0–1 DTE is a day trade; anything longer uses the swing horizon."""
    try:
        return "day" if int(dte) <= 1 else "swing"
    except (TypeError, ValueError):
        return "swing"


def lines(symbol: str, side: str = "long", horizon: str = "swing", occ: str | None = None, *,
          footer: bool = True, timeout: int = 60) -> list[str]:
    """The engine's plain-text block (caller escapes for HTML). footer=False drops the "No size" line so a digest can
    print it once. Cached per process by (symbol, side, horizon, occ)."""
    key = (symbol.upper(), side, horizon, occ or None)
    if key not in _CACHE:
        cmd = [MC_PY, "-m", "pipeline.decision.levels.alert", key[0], "--side", side, "--horizon", horizon, "--json"]
        if occ:
            cmd += ["--occ", occ]
        try:
            r = subprocess.run(cmd, cwd=MC_REPO, capture_output=True, text=True, timeout=timeout)
            out = json.loads(r.stdout.strip().splitlines()[-1])["lines"] if r.returncode == 0 and r.stdout.strip() else None
            if not out:
                out = [f"Levels UNAVAILABLE — levels.v1 engine exit {r.returncode}: {(r.stderr or '').strip()[-120:]}"]
        except (subprocess.TimeoutExpired, OSError, ValueError, KeyError, IndexError) as e:
            out = [f"Levels UNAVAILABLE — levels.v1 engine: {type(e).__name__}"]
        _CACHE[key] = out
    got = list(_CACHE[key])
    if not footer:
        got = [x for x in got if x != FOOTER]
    elif not any(x == FOOTER for x in got):
        got.append(FOOTER)     # an UNAVAILABLE block still says no size
    return got
