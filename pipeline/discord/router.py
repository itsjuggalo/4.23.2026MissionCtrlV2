"""Score → routing decision."""
from __future__ import annotations

from enum import Enum

from .scoring import Score, TIER_SCALP, TIER_SKIP, TIER_SWING, TIER_WATCH


class Route(str, Enum):
    INSTANT = "instant"
    DIGEST = "digest"
    DROP = "drop"


_TIER_TO_ROUTE = {
    TIER_SCALP: Route.INSTANT,
    TIER_SWING: Route.INSTANT,
    TIER_WATCH: Route.DIGEST,
    TIER_SKIP: Route.DROP,
}


def route(score: Score) -> Route:
    return _TIER_TO_ROUTE.get(score.tier, Route.DROP)


def webhook_key(score: Score) -> str | None:
    """Webhook key for the new consolidated channels. None means DROP."""
    r = route(score)
    if r is Route.DROP:
        return None
    if r is Route.INSTANT:
        return "flow_instant"
    return "flow_digest"
