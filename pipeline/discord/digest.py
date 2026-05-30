"""Periodic digest buffer.

Tracks scored events in a sliding window; flush() returns the top-K events
above a drop threshold so the caller can post them as a single digest embed.
"""
from __future__ import annotations

import time
from dataclasses import dataclass

from .coalescer import CoalesceResult
from .normalize import FlowEvent
from .scoring import Score


@dataclass
class _Entry:
    received_at: float
    event: FlowEvent
    score: Score
    coalesce: CoalesceResult | None


class DigestBuffer:
    def __init__(
        self,
        window_seconds: int = 600,
        top_k: int = 10,
        drop_threshold: float = 45.0,
        now_fn=time.time,
    ) -> None:
        self.window = window_seconds
        self.top_k = top_k
        self.drop_threshold = drop_threshold
        self._now = now_fn
        self._entries: list[_Entry] = []

    def add(
        self,
        event: FlowEvent,
        score: Score,
        coalesce: CoalesceResult | None = None,
    ) -> None:
        if score.value < self.drop_threshold:
            return
        self._entries.append(_Entry(self._now(), event, score, coalesce))

    def _prune(self) -> None:
        cutoff = self._now() - self.window
        self._entries = [e for e in self._entries if e.received_at >= cutoff]

    def total_held(self) -> int:
        self._prune()
        return len(self._entries)

    def flush(self) -> list[tuple[FlowEvent, Score, CoalesceResult | None]]:
        self._prune()
        ranked = sorted(self._entries, key=lambda e: e.score.value, reverse=True)
        surfaced = ranked[: self.top_k]
        self._entries = []
        return [(e.event, e.score, e.coalesce) for e in surfaced]
