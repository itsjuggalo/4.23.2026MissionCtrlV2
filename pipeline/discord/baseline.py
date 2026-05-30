"""Per-ticker baselines for the scoring formula.

The scorer needs to answer: "is $52K premium big for *this* ticker?"
That requires a rolling distribution of recent premiums per symbol.

Two implementations:

- OnlineEWMABaselineProvider: maintains per-symbol EWMA of log-premium,
  treats observations as ~lognormal, returns a percentile.
- StaticBaselineProvider: fixed thresholds, used as cold-start fallback.

Both persist to a JSON file so the state survives PM2 restarts.
"""
from __future__ import annotations

import json
import math
import os
from abc import ABC, abstractmethod
from typing import Any


class BaselineProvider(ABC):
    @abstractmethod
    def premium_percentile(self, symbol: str, premium: float) -> float:
        """Return percentile (0-100) of `premium` within `symbol`'s recent distribution."""

    @abstractmethod
    def observe(self, symbol: str, premium: float) -> None:
        """Record a new observation."""


class StaticBaselineProvider(BaselineProvider):
    """Cold-start fallback using fixed dollar thresholds.

    Thresholds chosen from current relay routing: weekly_flow / unusual_high_flow
    typically fire ~$25K+, high_flow ~$100K+.
    """

    DEFAULT_THRESHOLDS = [
        (10_000, 30),
        (25_000, 55),
        (50_000, 70),
        (100_000, 82),
        (250_000, 92),
        (1_000_000, 99),
    ]

    def __init__(self, thresholds: list[tuple[float, float]] | None = None) -> None:
        self.thresholds = sorted(thresholds or self.DEFAULT_THRESHOLDS)

    def premium_percentile(self, symbol: str, premium: float) -> float:
        if premium <= 0:
            return 0.0
        last_pct = 0.0
        for threshold, pct in self.thresholds:
            if premium <= threshold:
                return pct
            last_pct = pct
        return last_pct

    def observe(self, symbol: str, premium: float) -> None:
        return


class OnlineEWMABaselineProvider(BaselineProvider):
    """Per-symbol exponentially-weighted moving stats over log-premium.

    Approximates the lognormal distribution; returns the percentile using the
    normal CDF on log-premium z-score.
    """

    def __init__(
        self,
        state_path: str | None = None,
        alpha: float = 0.05,
        min_observations: int = 20,
        fallback: BaselineProvider | None = None,
    ) -> None:
        self.state_path = state_path
        self.alpha = alpha
        self.min_observations = min_observations
        self.fallback = fallback or StaticBaselineProvider()
        self._state: dict[str, dict[str, float]] = {}
        if state_path and os.path.exists(state_path):
            try:
                with open(state_path) as f:
                    self._state = json.load(f)
            except (OSError, json.JSONDecodeError):
                self._state = {}

    def _persist(self) -> None:
        if not self.state_path:
            return
        try:
            with open(self.state_path, "w") as f:
                json.dump(self._state, f)
        except OSError:
            pass

    def observe(self, symbol: str, premium: float) -> None:
        if premium <= 0:
            return
        x = math.log(premium)
        s = self._state.get(symbol)
        if s is None:
            self._state[symbol] = {"mean": x, "var": 0.0, "n": 1.0}
            return
        n = s["n"] + 1.0
        prev_mean = s["mean"]
        new_mean = prev_mean + self.alpha * (x - prev_mean)
        new_var = (1.0 - self.alpha) * (s["var"] + self.alpha * (x - prev_mean) ** 2)
        self._state[symbol] = {"mean": new_mean, "var": new_var, "n": n}

    def premium_percentile(self, symbol: str, premium: float) -> float:
        if premium <= 0:
            return 0.0
        s = self._state.get(symbol)
        if not s or s["n"] < self.min_observations:
            return self.fallback.premium_percentile(symbol, premium)
        std = math.sqrt(max(s["var"], 1e-9))
        z = (math.log(premium) - s["mean"]) / std
        pct = 0.5 * (1.0 + math.erf(z / math.sqrt(2.0)))
        return max(0.0, min(100.0, pct * 100.0))

    def snapshot(self) -> dict[str, Any]:
        return {sym: dict(s) for sym, s in self._state.items()}

    def flush(self) -> None:
        self._persist()
