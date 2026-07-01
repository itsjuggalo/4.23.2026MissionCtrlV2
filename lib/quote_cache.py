"""lib/quote_cache.py — tiny file-backed TTL cache for Alpaca quote GETs.

The exit-watcher (and any other poller) fetches the same per-symbol option quote
repeatedly within a few seconds. Alpaca's quote latency is not free and repeated
GETs for an unchanged mark waste the rate budget (the exit-watcher already has a
429 fan-out path for this reason). This caches the parsed value (a mid price, or
any small JSON-able value) per symbol/occ for a short TTL so repeated GETs inside
the window hit the cache instead of the network.

Design (mirrors lib/http_retry's "stdlib only, importable from ~/scripts"):
  * Stdlib only (json/os/tempfile/time) — no deps.
  * File-backed JSON under ~/.cache (falls back to /tmp) so multiple short-lived
    cron invocations of the same poller share the cache across process restarts.
  * TTL is per-entry (stamped at write). 15-30s is the intended band; default 20s.
  * Read-path only: this NEVER decides trades, it only avoids duplicate quote GETs.
    A stale/absent entry simply means "go fetch it" — the cache can never fabricate
    a price, only hand back one this process wrote within the TTL.

Usage:
    from lib.quote_cache import QuoteCache
    qc = QuoteCache("exit_watcher_quotes", ttl=20)
    fresh = qc.get_fresh(contracts)          # {occ: mid} for entries still in TTL
    misses = [c for c in contracts if c not in fresh]
    ... fetch misses over the network ...
    qc.put(newly_fetched)                     # {occ: mid}
"""
from __future__ import annotations

import json
import os
import tempfile
import time
from pathlib import Path
from typing import Any, Iterable


def _default_cache_dir() -> Path:
    base = os.environ.get("XDG_CACHE_HOME") or os.path.expanduser("~/.cache")
    d = Path(base) / "mc-quote-cache"
    try:
        d.mkdir(parents=True, exist_ok=True)
        return d
    except OSError:
        # Home/.cache unwritable (locked-down cron) — fall back to /tmp.
        d = Path(tempfile.gettempdir()) / "mc-quote-cache"
        d.mkdir(parents=True, exist_ok=True)
        return d


class QuoteCache:
    """A per-symbol TTL cache. `name` scopes the backing file (one file per poller)."""

    def __init__(self, name: str = "quotes", ttl: float = 20.0,
                 cache_dir: str | os.PathLike | None = None):
        if ttl <= 0:
            raise ValueError("ttl must be positive")
        self.ttl = float(ttl)
        safe = "".join(c if c.isalnum() or c in "-_" else "_" for c in name)
        directory = Path(cache_dir) if cache_dir is not None else _default_cache_dir()
        directory.mkdir(parents=True, exist_ok=True)
        self.path = directory / f"{safe}.json"

    # ---- backing-file IO (best-effort; a corrupt/missing file == empty cache) --

    def _load(self) -> dict[str, dict[str, Any]]:
        try:
            with open(self.path, "r", encoding="utf-8") as fh:
                data = json.load(fh)
            return data if isinstance(data, dict) else {}
        except (FileNotFoundError, json.JSONDecodeError, OSError):
            return {}

    def _store(self, data: dict[str, dict[str, Any]]) -> None:
        # Atomic replace so a concurrent reader never sees a half-written file.
        tmp = None
        try:
            fd, tmp = tempfile.mkstemp(dir=str(self.path.parent), suffix=".tmp")
            with os.fdopen(fd, "w", encoding="utf-8") as fh:
                json.dump(data, fh)
            os.replace(tmp, self.path)
            tmp = None
        except OSError:
            pass  # cache is an optimization; never fail the caller on write error
        finally:
            if tmp and os.path.exists(tmp):
                try:
                    os.unlink(tmp)
                except OSError:
                    pass

    # ---- public API -----------------------------------------------------------

    def get(self, key: str, now: float | None = None) -> Any | None:
        """Return the cached value for `key` if still within TTL, else None."""
        now = time.time() if now is None else now
        entry = self._load().get(key)
        if not entry:
            return None
        if now - entry.get("ts", 0) > self.ttl:
            return None
        return entry.get("value")

    def get_fresh(self, keys: Iterable[str], now: float | None = None) -> dict[str, Any]:
        """Return {key: value} for every requested key still within TTL (one file read)."""
        now = time.time() if now is None else now
        data = self._load()
        out: dict[str, Any] = {}
        for key in keys:
            entry = data.get(key)
            if entry and now - entry.get("ts", 0) <= self.ttl:
                out[key] = entry.get("value")
        return out

    def put(self, mapping: dict[str, Any], now: float | None = None) -> None:
        """Store {key: value} entries, stamped now. Prunes expired entries too."""
        if not mapping:
            return
        now = time.time() if now is None else now
        data = self._load()
        for key, value in mapping.items():
            data[key] = {"value": value, "ts": now}
        # Opportunistic prune so the file cannot grow without bound.
        data = {k: v for k, v in data.items() if now - v.get("ts", 0) <= self.ttl * 3}
        self._store(data)

    def set(self, key: str, value: Any, now: float | None = None) -> None:
        self.put({key: value}, now=now)

    def clear(self) -> None:
        try:
            os.unlink(self.path)
        except OSError:
            pass
