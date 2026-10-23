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
_CACHE: dict[tuple, dict] = {}


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
    got = list(_doc(symbol, side, horizon, occ, timeout)["lines"])
    if not footer:
        got = [x for x in got if x != FOOTER]
    elif not any(x == FOOTER for x in got):
        got.append(FOOTER)     # an UNAVAILABLE block still says no size
    return got


def _doc(symbol: str, side: str, horizon: str, occ: str | None, timeout: int = 60) -> dict:
    """The engine's JSON ({status, lines, line, …}); a failure is {status: UNAVAILABLE, lines: [reason]}. Cached."""
    key = (symbol.upper(), side, horizon, occ or None)
    if key not in _CACHE:
        cmd = [MC_PY, "-m", "pipeline.decision.levels.alert", key[0], "--side", side, "--horizon", horizon, "--json"]
        if occ:
            cmd += ["--occ", occ]
        try:
            r = subprocess.run(cmd, cwd=MC_REPO, capture_output=True, text=True, timeout=timeout)
            d = json.loads(r.stdout.strip().splitlines()[-1]) if r.returncode == 0 and r.stdout.strip() else None
            if not d or not d.get("lines"):
                d = {"status": "UNAVAILABLE", "lines": [
                    f"Levels UNAVAILABLE — levels.v1 engine exit {r.returncode}: {(r.stderr or '').strip()[-120:]}"]}
        except (subprocess.TimeoutExpired, OSError, ValueError, KeyError, IndexError) as e:
            d = {"status": "UNAVAILABLE", "lines": [f"Levels UNAVAILABLE — levels.v1 engine: {type(e).__name__}"]}
        _CACHE[key] = d
    return _CACHE[key]


def exit_line(symbol: str, kind: str, dte=None) -> str | None:
    """One compact exit line for a card: the underlying's levels.v1 TP1 + SL with their methods, spot source and
    as_of. None when the engine has no TP1/SL for it (the caller drops the line; nothing is invented — R32)."""
    import re
    d = _doc(symbol, side_for(kind), horizon_for(dte), None)
    line, ls = d.get("line") or "", d.get("lines") or []
    tp, sl = re.search(r"TP1 ([0-9.]+)", line), re.search(r"SL ([0-9.]+)", line)
    meth = next((x for x in ls if x.startswith("Methods:")), "")
    mt, ms = re.search(r"TP1 (\w+)", meth), re.search(r"SL (\w+)", meth)
    spot = re.search(r"· spot (.+? ET)", meth)
    if d.get("status") != "OK" or not (tp and sl and mt and ms and spot):
        return None
    return (f"{symbol.upper()} TP1 {tp.group(1)} ({mt.group(1)}) · SL {sl.group(1)} ({ms.group(1)}) — "
            f"levels.v1, spot {spot.group(1)}")


def for_contract(symbol: str, kind: str, dte=None, occ: str | None = None, *, footer: bool = True) -> list[str]:
    """An option card's block: side from the contract type (call → long, put → short), horizon from its DTE."""
    return lines(symbol, side_for(kind), horizon_for(dte), occ=occ or None, footer=footer)
