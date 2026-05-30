from pipeline.discord.router import Route, route, webhook_key
from pipeline.discord.scoring import (
    Score,
    TIER_SCALP,
    TIER_SKIP,
    TIER_SWING,
    TIER_WATCH,
)


def _score(value: float, tier: str) -> Score:
    return Score(value=value, tier=tier, components={}, premium_percentile=0.0)


def test_scalp_and_swing_go_instant():
    assert route(_score(90, TIER_SCALP)) is Route.INSTANT
    assert route(_score(70, TIER_SWING)) is Route.INSTANT


def test_watch_goes_to_digest():
    assert route(_score(55, TIER_WATCH)) is Route.DIGEST


def test_skip_drops():
    assert route(_score(30, TIER_SKIP)) is Route.DROP


def test_webhook_keys():
    assert webhook_key(_score(90, TIER_SCALP)) == "flow_instant"
    assert webhook_key(_score(55, TIER_WATCH)) == "flow_digest"
    assert webhook_key(_score(30, TIER_SKIP)) is None
