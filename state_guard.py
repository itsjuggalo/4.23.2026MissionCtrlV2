"""State-file reads with a max age, for every digest / sender input (script standard #4, market-data rule §3).

One rule, one implementation: the age of a state/cache file is judged by MissionCtrl's fact envelope
(pipeline/decision/lib/envelope.py `status_for`, thresholds in fact_policies.json `policies`), never a local
number. This module only path-loads it (like price_guard), so the pipeline lib never lands on sys.path.

    from state_guard import read_state, file_status
    r = read_state(path, "flow_agg", name="flow digest · live flow", as_of=lambda d: d["generated_at"])
    if r.ok: use(r.doc)            # LIVE / DELAYED / EOD
    else:    r.status, r.reason    # STALE / UNAVAILABLE / ERROR -> r.doc is None, never read as current

The data time is the document's own as-of when `as_of` is given (a key name or a callable), else the file's
mtime (labelled basis "file mtime"). A required input that is not usable raises the loud missing-data alert
(MissionCtrl missing_data: ops lane via tg_fleet, once per input per ET day; TG_DRY_RUN=1 / dry_run renders only).
If the envelope can't be loaded every read fails closed (status ERROR).
"""
from __future__ import annotations

import importlib.util
import json
import os
import sqlite3
from dataclasses import dataclass, field
from datetime import datetime, timezone
from pathlib import Path
from typing import Any, Callable, Optional, Union
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
MC_LIB = Path(os.environ.get("MC_DECISION_LIB") or "/AIWorkWSL/web/missionctrl/pipeline/decision/lib")
USABLE = ("LIVE", "DELAYED", "EOD")

_ENV = None
_MD = None


def _path_load(name: str, file: Path):
    spec = importlib.util.spec_from_file_location(name, file)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


def _envelope():
    global _ENV
    if _ENV is None:
        try:
            _ENV = _path_load("sg_envelope", MC_LIB / "envelope.py")
        except Exception:  # noqa: BLE001 — no envelope = every read fails closed
            _ENV = False
    return _ENV or None


def _alert_missing(name: str, tried: list, dry_run: bool) -> None:
    global _MD
    try:
        if _MD is None:
            _MD = _path_load("sg_missing_data", MC_LIB / "missing_data.py")
        _MD.alert_missing(name, tried, dry_run=dry_run)
    except Exception as e:  # noqa: BLE001 — an alert failure never breaks a sender; it is printed
        print(f"[state_guard] missing-data alert failed for {name}: {type(e).__name__}")


@dataclass
class StateRead:
    path: str
    policy: str
    status: str                       # LIVE | DELAYED | EOD | STALE | UNAVAILABLE | ERROR
    as_of: Optional[str]              # data time, ET ISO (None when unknown)
    basis: str                        # "document as_of" | "file mtime" | "none"
    doc: Any = None                   # the parsed document, ONLY when usable
    reason: Optional[str] = None
    raw: Any = field(default=None, repr=False)   # parsed document whatever its age (for labelled display only)

    @property
    def ok(self) -> bool:
        return self.status in USABLE

    def stamp(self) -> dict:
        """{source, as_of, status, policy} — what a context file records beside the value it took from here."""
        return {"source": self.path, "as_of": self.as_of, "status": self.status, "policy": self.policy,
                "basis": self.basis, **({"reason": self.reason} if self.reason else {})}


def _et_iso(dt: datetime) -> str:
    return dt.astimezone(ET).isoformat(timespec="seconds")


def _parse_as_of(v: Any) -> Optional[datetime]:
    if v is None or v == "":
        return None
    if isinstance(v, (int, float)):
        x = float(v)
        return datetime.fromtimestamp(x / 1000 if x > 1e11 else x, tz=timezone.utc)
    s = str(v).strip().replace(" ET", "")
    try:
        dt = datetime.fromisoformat(s.replace("Z", "+00:00"))
    except ValueError:
        try:
            dt = datetime.strptime(s, "%Y-%m-%d %H:%M:%S")
        except ValueError:
            return None
    return dt if dt.tzinfo else dt.replace(tzinfo=ET)


def judge(as_of: Optional[datetime], policy: str, now: Optional[datetime] = None) -> str:
    env = _envelope()
    if env is None:
        return "ERROR"
    if as_of is None:
        return "UNAVAILABLE"
    try:
        return env.status_for(as_of.isoformat(), policy, (now or datetime.now(ET)).astimezone(ET))
    except Exception:  # noqa: BLE001 — unknown policy / bad time = fail closed
        return "ERROR"


def read_state(path: Union[str, Path], policy: str, *, name: Optional[str] = None,
               as_of: Union[None, str, Callable[[Any], Any]] = None, required: bool = False,
               loader: Callable[[Path], Any] = None, now: Optional[datetime] = None,
               dry_run: Optional[bool] = None) -> StateRead:
    """Read one JSON (or `loader`) state file and judge its age against `policy`. Never raises."""
    p = Path(path).expanduser()
    label = name or p.name
    dry = os.environ.get("TG_DRY_RUN") == "1" if dry_run is None else dry_run
    try:
        doc = (loader or (lambda q: json.loads(q.read_text(encoding="utf-8"))))(p)
    except FileNotFoundError:
        r = StateRead(str(p), policy, "UNAVAILABLE", None, "none", reason="file missing")
    except Exception as e:  # noqa: BLE001
        r = StateRead(str(p), policy, "ERROR", None, "none", reason=f"unreadable: {type(e).__name__}")
    else:
        if as_of is not None:
            try:
                raw_t = as_of(doc) if callable(as_of) else (doc or {}).get(as_of)
            except Exception:  # noqa: BLE001
                raw_t = None
            t, basis = _parse_as_of(raw_t), "document as_of"
        else:
            try:
                t, basis = datetime.fromtimestamp(p.stat().st_mtime, tz=timezone.utc), "file mtime"
            except OSError:
                t, basis = None, "none"
        st = judge(t, policy, now)
        r = StateRead(str(p), policy, st, _et_iso(t) if t else None, basis, raw=doc,
                      doc=doc if st in USABLE else None,
                      reason=None if st in USABLE else (f"{basis} {_et_iso(t)} is {st} under {policy}" if t
                                                        else f"no data time ({basis})"))
    if required and not r.ok:
        _alert_missing(label, [{"source": str(p), "ok": False, "error": r.reason or r.status}], dry)
    return r


def file_status(path: Union[str, Path], policy: str, now: Optional[datetime] = None) -> StateRead:
    """Age of a file by its mtime only (for non-JSON inputs). doc is None."""
    p = Path(path).expanduser()
    try:
        t = datetime.fromtimestamp(p.stat().st_mtime, tz=timezone.utc)
    except OSError:
        return StateRead(str(p), policy, "UNAVAILABLE", None, "none", reason="file missing")
    st = judge(t, policy, now)
    return StateRead(str(p), policy, st, _et_iso(t), "file mtime",
                     reason=None if st in USABLE else f"file mtime {_et_iso(t)} is {st} under {policy}")


def sqlite_status(db: Union[str, Path], sql: str, policy: str, now: Optional[datetime] = None) -> StateRead:
    """Age of a SQLite table by a one-value `SELECT max(<time col>) …` (read-only). doc is None."""
    p = Path(db).expanduser()
    try:
        con = sqlite3.connect(f"file:{p}?mode=ro", uri=True)
        try:
            v = con.execute(sql).fetchone()[0]
        finally:
            con.close()
    except Exception as e:  # noqa: BLE001
        return StateRead(str(p), policy, "ERROR", None, "none", reason=f"unreadable: {type(e).__name__}")
    t = _parse_as_of(v)
    if t is not None and isinstance(v, str) and "T" not in v and "+" not in v:
        t = t.replace(tzinfo=timezone.utc)          # SQLite CURRENT_TIMESTAMP text is UTC
    st = judge(t, policy, now)
    return StateRead(str(p), policy, st, _et_iso(t) if t else None, "table max time",
                     reason=None if st in USABLE else (f"newest row {_et_iso(t)} is {st} under {policy}" if t
                                                       else "no rows"))
