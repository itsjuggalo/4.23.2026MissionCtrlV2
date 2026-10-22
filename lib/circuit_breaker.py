#!/usr/bin/env python3
"""circuit_breaker.py — fail-open safety rails for autonomous loops.

Bakes the quartet+1 into any loop: max-$ (daily), max-turns, max-hours (wall-clock
since session start), a STOP-file killswitch, and a done-detector. One call per
iteration:  ok, reason = cb.check()

Failure mode is EXPLICIT (W6 MC-AUD-131): fail_mode="open" (default, legacy) returns ok=True on an internal
error; fail_mode="closed" (use for any loop that can change code/systems) returns ok=False. Either way the reason
names the error. State writes are atomic (tmp + rename) under a per-name lock; a corrupt state file is
quarantined (never silently reset) and, in closed mode, keeps the loop stopped until `--reset NAME`.

Two activation modes:
  - enabled=True   → live rails (use for the non-trading nightshift loops).
  - enabled=False  → fully INERT: check() always returns (True, None), records nothing.
                     Use env-gating (CIRCUIT_BREAKERS=1) on live TRADING loops so the
                     code ships dormant and Mike arms it with one flag.

State persists per-name in a small JSON so max-$/day, turn counts, and session start
survive across cron-spawned processes within the same day. Daily rollover auto-resets.

Usage:
    from circuit_breaker import CircuitBreaker
    cb = CircuitBreaker(
        "decipher", max_usd=2000, max_turns=50, max_hours=6,
        stop_file="~/.openclaw/decipher_GATES_OFF",
        enabled=os.getenv("CIRCUIT_BREAKERS") == "1",
    )
    while work_remaining:
        ok, why = cb.check(auto_turn=True)
        if not ok:
            cb.log(f"halt: {why}"); break
        usd = do_one_turn()
        cb.record_spend(usd)
        if no_actionable_signal:
            cb.mark_done("no actionable signal")
"""
import contextlib, fcntl, json, os, time, datetime
from pathlib import Path

DEFAULT_STATE_DIR = Path(os.path.expanduser("~/.openclaw/state/circuit_breaker"))


def _today():
    try:
        from zoneinfo import ZoneInfo
        return datetime.datetime.now(ZoneInfo("America/New_York")).strftime("%Y-%m-%d")
    except Exception:
        return datetime.datetime.now().strftime("%Y-%m-%d")


class CircuitBreaker:
    def __init__(self, name, max_usd=None, max_turns=None, max_hours=None,
                 stop_file=None, enabled=True, state_dir=None, clock=time.time,
                 verbose=False, fail_mode="open"):
        if fail_mode not in ("open", "closed"):
            raise ValueError("fail_mode must be 'open' or 'closed'")
        self.fail_mode = fail_mode
        self.name = name
        self.max_usd = max_usd
        self.max_turns = max_turns
        self.max_hours = max_hours
        self.stop_file = Path(os.path.expanduser(stop_file)) if stop_file else None
        self.enabled = bool(enabled)
        self.verbose = verbose
        self._clock = clock                      # injectable for tests
        self.state_dir = Path(state_dir) if state_dir else DEFAULT_STATE_DIR
        self.path = self.state_dir / f"{name}.json"

    # ---- logging (never raises) ----
    def log(self, msg):
        if self.verbose:
            try: print(f"[circuit_breaker:{self.name}] {msg}")
            except Exception: pass

    # ---- state I/O (fail-open) ----
    def _fresh(self):
        return {"day": _today(), "spend": 0.0, "turns": 0,
                "first_ts": self._clock(), "last_ts": self._clock(),
                "done": False, "done_reason": None}

    @contextlib.contextmanager
    def _locked(self):
        """Per-name exclusive lock around read-modify-write (cron runs can overlap)."""
        self.state_dir.mkdir(parents=True, exist_ok=True)
        with open(self.state_dir / f"{self.name}.lock", "w") as fh:
            fcntl.flock(fh, fcntl.LOCK_EX)
            try:
                yield
            finally:
                fcntl.flock(fh, fcntl.LOCK_UN)

    def _quarantined_today(self):
        return sorted(self.state_dir.glob(f"{self.name}.json.corrupt-{_today()}*"))

    def _load(self, persist_if_new=False):
        if not self.path.exists():
            s = self._fresh()
            if persist_if_new:                      # stamp session start on first call
                self._save(s)
            return s
        try:
            s = json.loads(self.path.read_text())
            if not isinstance(s, dict) or "day" not in s:
                raise ValueError("state is not a breaker record")
        except Exception as e:
            # never silently reset a corrupt record — keep it as evidence and surface the error
            q = self.path.with_name(f"{self.name}.json.corrupt-{_today()}-{int(self._clock())}")
            with contextlib.suppress(OSError):
                self.path.replace(q)
            raise RuntimeError(f"corrupt state quarantined to {q.name}: {e}") from e
        if s.get("day") != _today():                # daily rollover
            s = self._fresh()
            if persist_if_new:
                self._save(s)
        return s

    def _save(self, s):
        """Atomic write (tmp + rename). Returns False on failure (closed mode treats that as a stop)."""
        try:
            self.state_dir.mkdir(parents=True, exist_ok=True)
            s["last_ts"] = self._clock()
            tmp = self.path.with_suffix(".json.tmp")
            tmp.write_text(json.dumps(s, indent=2))
            os.replace(tmp, self.path)
            return True
        except Exception as e:
            self.log(f"state save failed: {e}")
            return False

    def _error(self, e):
        ok = self.fail_mode == "open"
        self.log(f"check() error, failing {'OPEN' if ok else 'CLOSED'}: {e}")
        return (ok, f"breaker-error-fail{'open' if ok else 'closed'}: {e}")

    # ---- the per-iteration gate ----
    def check(self, auto_turn=False):
        """Return (ok, reason). ok=False means STOP this loop. Fail-open on any error."""
        if not self.enabled:
            return (True, None)                     # INERT
        try:
            # STOP-file is honored regardless of state — the intentional killswitch.
            if self.stop_file and self.stop_file.exists():
                return (False, f"STOP-file present: {self.stop_file}")
            if self.fail_mode == "closed" and self._quarantined_today():
                return (False, f"state was corrupt today ({self._quarantined_today()[-1].name}); "
                               f"inspect, then `circuit_breaker.py --reset {self.name}`")
            with self._locked():
                return self._check_locked(auto_turn)
        except Exception as e:
            return self._error(e)

    def _check_locked(self, auto_turn):
        s = self._load(persist_if_new=True)     # stamp session start so max_hours works
        if s.get("done"):
            return (False, f"done-detector: {s.get('done_reason') or 'complete'}")
        if self.max_usd is not None and s["spend"] >= self.max_usd:
            return (False, f"daily $ cap hit: ${s['spend']:.2f} >= ${self.max_usd}")
        if self.max_turns is not None and s["turns"] >= self.max_turns:
            return (False, f"max turns hit: {s['turns']} >= {self.max_turns}")
        if self.max_hours is not None:
            elapsed_h = (self._clock() - s.get("first_ts", self._clock())) / 3600.0
            if elapsed_h >= self.max_hours:
                return (False, f"max hours hit: {elapsed_h:.2f}h >= {self.max_hours}h")
        if auto_turn:
            s["turns"] += 1
            if not self._save(s) and self.fail_mode == "closed":
                return (False, "breaker-error-failclosed: could not record the turn")
        return (True, None)

    # ---- recorders (no-op when inert; never raise) ----
    def record_spend(self, usd):
        if not self.enabled:
            return
        try:
            with self._locked():
                s = self._load(); s["spend"] = float(s.get("spend", 0)) + float(usd or 0); self._save(s)
        except Exception as e:
            self.log(f"record_spend ignored: {e}")

    def record_turn(self, n=1):
        if not self.enabled:
            return
        try:
            with self._locked():
                s = self._load(); s["turns"] = int(s.get("turns", 0)) + int(n); self._save(s)
        except Exception as e:
            self.log(f"record_turn ignored: {e}")

    def mark_done(self, reason="complete"):
        if not self.enabled:
            return
        try:
            with self._locked():
                s = self._load(); s["done"] = True; s["done_reason"] = reason; self._save(s)
        except Exception as e:
            self.log(f"mark_done ignored: {e}")

    def reset(self):
        """Fresh record; also clears today's corrupt-state quarantine hold (closed mode)."""
        try:
            for q in self._quarantined_today():
                q.rename(q.with_name(q.name.replace(".corrupt-", ".corrupt-reviewed-")))
            self._save(self._fresh())
        except Exception:
            pass

    def status(self):
        try:
            s = self._load()
            return {"name": self.name, "enabled": self.enabled, **s,
                    "limits": {"max_usd": self.max_usd, "max_turns": self.max_turns,
                               "max_hours": self.max_hours, "stop_file": str(self.stop_file)}}
        except Exception:
            return {"name": self.name, "enabled": self.enabled, "error": "status unavailable"}


# ---------------- offline self-test ----------------
def _self_test():
    import tempfile
    ok = True
    def chk(n, c):
        nonlocal ok; print(f"  [{'PASS' if c else 'FAIL'}] {n}"); ok = ok and c

    d = tempfile.mkdtemp()
    # inert mode: never trips, records nothing
    cbi = CircuitBreaker("t-inert", max_turns=1, enabled=False, state_dir=d)
    cbi.record_turn(5); cbi.record_spend(999)
    chk("inert: check always ok", cbi.check(auto_turn=True) == (True, None))
    chk("inert: nothing recorded", not (Path(d) / "t-inert.json").exists())

    # max_turns
    cb = CircuitBreaker("t-turns", max_turns=3, enabled=True, state_dir=d)
    r = [cb.check(auto_turn=True)[0] for _ in range(5)]
    chk("max_turns trips on 4th", r == [True, True, True, False, False])

    # max_usd
    cu = CircuitBreaker("t-usd", max_usd=100, enabled=True, state_dir=d)
    chk("usd ok before cap", cu.check()[0] is True)
    cu.record_spend(120)
    chk("usd trips after cap", cu.check()[0] is False)

    # max_hours via injected clock
    clk = {"t": 1000.0}
    ch = CircuitBreaker("t-hours", max_hours=1, enabled=True, state_dir=d, clock=lambda: clk["t"])
    chk("hours ok at t0", ch.check()[0] is True)
    clk["t"] = 1000.0 + 3601                     # +1.0003h
    chk("hours trips after 1h", ch.check()[0] is False)

    # stop-file
    sf = Path(d) / "STOP"
    cs = CircuitBreaker("t-stop", enabled=True, state_dir=d, stop_file=str(sf))
    chk("stop-file absent → ok", cs.check()[0] is True)
    sf.write_text("x")
    chk("stop-file present → trips", cs.check()[0] is False)

    # done-detector
    cd = CircuitBreaker("t-done", enabled=True, state_dir=d)
    chk("done: ok before", cd.check()[0] is True)
    cd.mark_done("no signal")
    chk("done: trips after mark_done", cd.check()[0] is False)

    # daily rollover (simulate by writing yesterday)
    cr = CircuitBreaker("t-roll", max_turns=1, enabled=True, state_dir=d)
    cr.check(auto_turn=True); cr.check(auto_turn=True)       # tripped today
    st = json.loads((Path(d) / "t-roll.json").read_text()); st["day"] = "2000-01-01"
    (Path(d) / "t-roll.json").write_text(json.dumps(st))
    chk("daily rollover resets", cr.check()[0] is True)

    # corrupt state: quarantined (never silently reset); open mode proceeds, closed mode stops until reset
    cc = CircuitBreaker("t-corrupt", max_turns=1, enabled=True, state_dir=d)
    (Path(d) / "t-corrupt.json").write_text("{not json")
    r = cc.check()
    chk("corrupt state → fail-open ok, reason named", r[0] is True and "corrupt" in (r[1] or ""))
    chk("corrupt state quarantined", bool(list(Path(d).glob("t-corrupt.json.corrupt-*"))))
    cx = CircuitBreaker("t-closed", max_turns=5, enabled=True, state_dir=d, fail_mode="closed")
    (Path(d) / "t-closed.json").write_text("[]")
    chk("closed: corrupt → stop", cx.check()[0] is False)
    chk("closed: stays stopped", cx.check()[0] is False)
    cx.reset()
    chk("closed: reset → ok", cx.check()[0] is True)
    chk("atomic save leaves no tmp", not list(Path(d).glob("*.tmp")))

    print("SELF-TEST:", "PASS" if ok else "FAIL")
    return 0 if ok else 1


def _gate_cli(argv):
    """Shell preflight: build a breaker from flags, check once, exit 0 (proceed) or 75 (stop).
    For shell-wrapped loops (nightshift). Always enabled (these are the safe non-trading loops).
        circuit_breaker.py --gate NAME [--max-turns N] [--max-hours H] [--max-usd U]
                           [--stop-file PATH] [--record] [--done-if-empty]
    --record increments the turn counter when the gate passes (so max-turns counts invocations).
    """
    import argparse
    ap = argparse.ArgumentParser()
    ap.add_argument("--gate", required=True)
    ap.add_argument("--max-turns", type=int)
    ap.add_argument("--max-hours", type=float)
    ap.add_argument("--max-usd", type=float)
    ap.add_argument("--stop-file")
    ap.add_argument("--record", action="store_true")
    ap.add_argument("--fail-closed", action="store_true", help="an internal breaker error STOPS (exit 75)")
    a = ap.parse_args(argv)
    cb = CircuitBreaker(a.gate, max_usd=a.max_usd, max_turns=a.max_turns, max_hours=a.max_hours,
                        stop_file=a.stop_file, enabled=True, verbose=True,
                        fail_mode="closed" if a.fail_closed else "open")
    ok, why = cb.check(auto_turn=a.record)
    if ok:
        return 0
    print(f"[circuit_breaker:{a.gate}] STOP — {why}")
    return 75


if __name__ == "__main__":
    import sys
    if "--self-test" in sys.argv:
        sys.exit(_self_test())
    if "--gate" in sys.argv:
        sys.exit(_gate_cli(sys.argv[1:]))
    if "--reset" in sys.argv:
        CircuitBreaker(sys.argv[sys.argv.index("--reset") + 1]).reset()
        sys.exit(0)
    if "--status" in sys.argv:
        name = sys.argv[sys.argv.index("--status") + 1] if len(sys.argv) > sys.argv.index("--status") + 1 else "decipher"
        print(json.dumps(CircuitBreaker(name).status(), indent=2))
