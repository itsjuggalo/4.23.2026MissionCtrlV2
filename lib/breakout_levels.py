"""levels.v1 for the breakout scan's LLM line (DECISIONS R32, Mike 2026-10-21: an entry/TP/SL only when computed from
data). The model gets each fresh name's computed LEVEL MENU and may only cite its ids (e.g. "SL NVDA:L3 214.10"); the
missionctrl validator then redacts any price on neither the menu nor the scan data. When the menus are unavailable the
prompt says "levels: pending levels.v1" and asks for no levels, and lib/llm_level_strip.py removes any the model writes.

    python3 lib/breakout_levels.py menus FRESH_JSON      → JSON {symbols, block, ok} on stdout (never fails: ok false)
    python3 lib/breakout_levels.py check LV_JSON FRESH_JSON < text → validated text on stdout
Read-only: runs `python -m pipeline.decision.levels.prompt` in missionctrl, writes nothing.
"""
from __future__ import annotations

import json
import subprocess
import sys
from pathlib import Path

MC = "/AIWorkWSL/web/missionctrl"
PY = str(Path.home() / ".venv/bin/python")
PENDING = ("levels: pending levels.v1 — give NO price levels: no entry, trigger, stop, target or take-profit numbers.")
ASK_RULE = "A name with no LEVEL MENU below gets no levels."   # the menu block carries the levels.v1 RULE itself


def _run(args: list[str], timeout: int, inp: str | None = None) -> tuple[int, str]:
    try:
        p = subprocess.run([PY, "-m", "pipeline.decision.levels.prompt", *args], cwd=MC, input=inp, capture_output=True,
                           text=True, timeout=timeout)
        return p.returncode, p.stdout or ""
    except (subprocess.TimeoutExpired, OSError) as e:
        return 124, str(e)


def symbols_of(fresh: dict) -> list[str]:
    return list(dict.fromkeys(str(h.get("symbol", "")).upper() for k in ("breakouts", "breakdowns") for h in fresh.get(k) or []
                              if h.get("symbol")))


def menus(fresh: dict, run=_run) -> dict:
    syms = symbols_of(fresh)
    if not syms:
        return {"ok": False, "symbols": {}, "block": PENDING}
    rc, out = run(["menus", ",".join(syms)], 300)
    try:
        lv = json.loads(out.strip().splitlines()[-1]) if rc == 0 else None
    except (ValueError, IndexError):
        lv = None
    if not lv or not any(v.get("status") == "OK" for v in (lv.get("symbols") or {}).values()):
        return {"ok": False, "symbols": {}, "block": PENDING}
    return {"ok": True, "symbols": lv["symbols"], "block": ASK_RULE + "\n" + lv["block"]}


def check(text: str, lv: dict, facts: str, run=_run) -> str:
    """Menu ok → the levels.v1 validator (redacts unknown prices, says what it removed). Otherwise, or when the validator
    is unavailable, every level clause is stripped (llm_level_strip) — never an unchecked model price."""
    if lv.get("ok"):
        rc, out = run(["validate"], 60, json.dumps({"text": text, "symbols": lv["symbols"], "facts": facts}))
        try:
            v = json.loads(out.strip().splitlines()[-1])
            if v.get("ok"):
                return text
            why = ", ".join([f"{n:g}" for n in v.get("unknown_numbers", [])] + list(v.get("unknown_ids", [])))
            return v["redacted"] + f"\n⚠️ removed (not on the levels.v1 menu or in the scan): {why}"
        except (ValueError, IndexError, KeyError, TypeError):
            pass
    sys.path.insert(0, str(Path(__file__).resolve().parent))
    from llm_level_strip import strip
    return strip(text)[0]


def main(argv: list[str]) -> int:
    if len(argv) >= 2 and argv[0] == "menus":
        print(json.dumps(menus(json.loads(Path(argv[1]).read_text()))))
        return 0
    if len(argv) >= 3 and argv[0] == "check":
        lv = json.loads(Path(argv[1]).read_text())
        print(check(sys.stdin.read(), lv, Path(argv[2]).read_text()))
        return 0
    print(__doc__, file=sys.stderr)
    return 2


if __name__ == "__main__":
    sys.exit(main(sys.argv[1:]))
