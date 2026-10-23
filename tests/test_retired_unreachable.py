"""Retired code is unreachable (2026-10-23, W5 / W5c): no cron or PM2 entrypoint imports — directly or through
local modules — the archived Alpaca executors or the cap file, and the files are gone from their old homes.
Archive + restore lines: /AIWorkWSL/archive/2026-10-23-retired/{alpaca-exec,caps}/README.md."""
import ast
import json
import re
import shutil
import subprocess
from pathlib import Path

import pytest

RETIRED = {"auto_trader", "equity_swing_daemon", "risk_gate"}
OLD_HOMES = [Path.home() / "scripts/auto_trader.py", Path.home() / "scripts/lib/risk_gate.py",
             Path("/AIWorkWSL/trading/daemons/equity_swing_daemon.py")]
PM2 = Path.home() / ".nvm/versions/node/v22.22.3/bin/pm2"


def _entrypoints() -> list[Path]:
    out = []
    try:
        cron = subprocess.run(["crontab", "-l"], capture_output=True, text=True, timeout=10).stdout
    except Exception:  # noqa: BLE001
        cron = ""
    for line in cron.splitlines():
        if line.strip().startswith("#"):
            continue
        out += [Path(m) for m in re.findall(r"(/[\w./~-]+\.(?:py|sh))", line.replace("~", str(Path.home())))]
    pm2 = str(PM2) if PM2.exists() else shutil.which("pm2")
    if pm2:
        try:
            for p in json.loads(subprocess.run([pm2, "jlist"], capture_output=True, text=True, timeout=20).stdout or "[]"):
                ex = p.get("pm2_env", {}).get("pm_exec_path")
                if ex:
                    out.append(Path(ex))
        except Exception:  # noqa: BLE001
            pass
    return [p for p in dict.fromkeys(out) if p.exists()]


def _imports(py: Path) -> set[str]:
    try:
        tree = ast.parse(py.read_text(errors="ignore"))
    except (SyntaxError, ValueError):
        return set()
    names = set()
    for n in ast.walk(tree):
        if isinstance(n, ast.Import):
            names |= {a.name for a in n.names}
        elif isinstance(n, ast.ImportFrom) and n.module:
            names.add(n.module)
            names |= {f"{n.module}.{a.name}" for a in n.names}
    return names


def _closure(entry: Path) -> set[str]:
    """Every module name imported from `entry`, following local .py files in its dir, ~/scripts and ~/scripts/lib."""
    roots = [entry.parent, Path.home() / "scripts", Path.home() / "scripts/lib"]
    seen, todo, names = set(), [entry], set()
    if entry.suffix == ".sh":
        todo = [Path(m) for m in re.findall(r"(/[\w./-]+\.py)", entry.read_text(errors="ignore")) if Path(m).exists()]
    while todo:
        f = todo.pop()
        if f in seen:
            continue
        seen.add(f)
        for mod in _imports(f):
            names.add(mod)
            leaf = mod.split(".")
            for r in roots:
                for cand in (r.joinpath(*leaf).with_suffix(".py"), r / (leaf[-1] + ".py")):
                    if cand.exists() and cand not in seen:
                        todo.append(cand)
    return names


def test_retired_files_are_gone_from_their_old_homes():
    assert not [p for p in OLD_HOMES if p.exists()]


def test_no_cron_or_pm2_entrypoint_reaches_retired_code():
    eps = _entrypoints()
    if not eps:
        pytest.skip("no crontab / pm2 visible here")
    hits = {str(e): sorted(m for m in _closure(e) if set(m.split(".")) & RETIRED) for e in eps}
    assert not {k: v for k, v in hits.items() if v}
