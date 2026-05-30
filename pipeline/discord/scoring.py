"""Significance score for a FlowEvent.

See PIPELINE_DISCORD_REDESIGN.md for the formula and tier boundaries.
"""
from __future__ import annotations

from dataclasses import dataclass

from .baseline import BaselineProvider
from .coalescer import CoalesceResult
from .normalize import FlowEvent


TIER_SCALP = "SCALP"
TIER_SWING = "SWING"
TIER_WATCH = "WATCH"
TIER_SKIP = "SKIP"


@dataclass(frozen=True)
class Score:
    value: float
    tier: str
    components: dict[str, float]
    premium_percentile: float


def _premium_component(percentile: float) -> float:
    return min(40.0, percentile * 0.4)


def _unusualness_component(volume: int, open_interest: int) -> float:
    oi = max(open_interest, 1)
    vol_to_oi = volume / oi
    return min(20.0, vol_to_oi * 10.0)


def _aggressor_component(event: FlowEvent) -> float:
    is_sweep = event.block_type == "SWEEP"
    aligned_call = event.opt_type == "C" and event.bid_ask == "A"
    aligned_put = event.opt_type == "P" and event.bid_ask == "B"
    aligned = aligned_call or aligned_put

    if is_sweep and aligned:
        return 15.0
    if aligned:
        return 5.0
    conflicting_call = event.opt_type == "C" and event.bid_ask == "B"
    conflicting_put = event.opt_type == "P" and event.bid_ask == "A"
    if conflicting_call or conflicting_put:
        return -5.0
    return 0.0


def _dte_component(dte: int) -> float:
    if dte < 0:
        return -5.0
    if dte <= 7:
        return 15.0
    if dte <= 30:
        return 10.0
    if dte <= 90:
        return 5.0
    return 0.0


def _repeater_component(hits: int) -> float:
    if hits <= 1:
        return 0.0
    return min(10.0, (hits - 1) * 5.0)


def _tier_for(value: float) -> str:
    if value >= 85:
        return TIER_SCALP
    if value >= 65:
        return TIER_SWING
    if value >= 45:
        return TIER_WATCH
    return TIER_SKIP


def score(
    event: FlowEvent,
    baseline: BaselineProvider,
    coalesce: CoalesceResult,
) -> Score:
    percentile = baseline.premium_percentile(event.symbol, event.premium)

    components = {
        "premium": _premium_component(percentile),
        "unusualness": _unusualness_component(event.volume, event.open_interest),
        "aggressor": _aggressor_component(event),
        "dte": _dte_component(event.dte),
        "repeater": _repeater_component(coalesce.hits),
    }
    total = max(0.0, min(100.0, sum(components.values())))
    return Score(
        value=total,
        tier=_tier_for(total),
        components=components,
        premium_percentile=percentile,
    )
