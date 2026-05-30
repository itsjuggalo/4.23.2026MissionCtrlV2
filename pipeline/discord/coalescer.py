"""Repeater coalescing — collapse N hits on the same contract within a window.

Keys are (symbol, strike, opt_type, expiry_unix). Each observe() returns the
number of hits seen so far in the window and the cumulative premium, so the
scorer can apply a repeater bonus and the embed builder can show "×3 hits".
"""
from __future__ import annotations

import time
from collections import deque
from dataclasses import dataclass
from typing import Hashable


@dataclass(frozen=True)
class CoalesceResult:
    is_first: bool
    hits: int
    cumulative_premium: float
    first_seen_unix: float


class Coalescer:
    def __init__(self, window_seconds: int = 600, now_fn=time.time) -> None:
        self.window = window_seconds
        self._now = now_fn
        self._by_key: dict[Hashable, deque[tuple[float, float]]] = {}

    def _key(self, symbol: str, strike: float, opt_type: str, expiry_unix: int) -> tuple:
        return (symbol.upper(), round(strike, 4), opt_type.upper(), int(expiry_unix))

    def _prune(self, key: Hashable, cutoff: float) -> None:
        dq = self._by_key.get(key)
        if not dq:
            return
        while dq and dq[0][0] < cutoff:
            dq.popleft()
        if not dq:
            self._by_key.pop(key, None)

    def observe(
        self,
        symbol: str,
        strike: float,
        opt_type: str,
        expiry_unix: int,
        premium: float,
    ) -> CoalesceResult:
        now = self._now()
        cutoff = now - self.window
        k = self._key(symbol, strike, opt_type, expiry_unix)
        self._prune(k, cutoff)
        dq = self._by_key.setdefault(k, deque())
        dq.append((now, max(0.0, premium)))
        cum = sum(p for _, p in dq)
        first_seen = dq[0][0]
        return CoalesceResult(
            is_first=len(dq) == 1,
            hits=len(dq),
            cumulative_premium=cum,
            first_seen_unix=first_seen,
        )

    def peek(self, symbol: str, strike: float, opt_type: str, expiry_unix: int) -> int:
        k = self._key(symbol, strike, opt_type, expiry_unix)
        self._prune(k, self._now() - self.window)
        return len(self._by_key.get(k, ()))

    def sweep(self) -> int:
        """Drop all expired keys. Returns number of keys remaining."""
        cutoff = self._now() - self.window
        for k in list(self._by_key.keys()):
            self._prune(k, cutoff)
        return len(self._by_key)
