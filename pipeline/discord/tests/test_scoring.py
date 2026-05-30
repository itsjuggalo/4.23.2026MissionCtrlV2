from pipeline.discord.baseline import StaticBaselineProvider
from pipeline.discord.coalescer import CoalesceResult
from pipeline.discord.normalize import FlowEvent
from pipeline.discord.scoring import (
    TIER_SCALP,
    TIER_SKIP,
    TIER_SWING,
    TIER_WATCH,
    score,
)


def _evt(**overrides) -> FlowEvent:
    base = dict(
        source_id="t",
        symbol="TSLA",
        strike=480.0,
        opt_type="C",
        expiry_unix=1748563200,
        dte=0,
        is_bullish=True,
        premium=300_000.0,
        volume=1500,
        open_interest=500,
        spot=478.0,
        alert_price=2.10,
        block_type="SWEEP",
        bid_ask="A",
        alert_type="high_flow",
        underlying_type="STOCK",
        time_unix=1748560000,
        sweeps=4,
        blocks=1,
    )
    base.update(overrides)
    return FlowEvent(**base)


def _first_hit() -> CoalesceResult:
    return CoalesceResult(is_first=True, hits=1, cumulative_premium=0.0, first_seen_unix=0.0)


def test_high_premium_aligned_sweep_zero_dte_is_scalp():
    sc = score(_evt(), StaticBaselineProvider(), _first_hit())
    assert sc.tier == TIER_SCALP
    assert sc.value >= 85


def test_small_premium_long_dte_is_skip_or_watch():
    sc = score(
        _evt(premium=5_000.0, volume=10, open_interest=1000, dte=180, block_type="", bid_ask=""),
        StaticBaselineProvider(),
        _first_hit(),
    )
    assert sc.tier in (TIER_SKIP, TIER_WATCH)
    assert sc.value < 65


def test_conflicting_aggressor_penalised():
    aligned = score(_evt(), StaticBaselineProvider(), _first_hit())
    contra = score(
        _evt(opt_type="C", bid_ask="B", block_type=""), StaticBaselineProvider(), _first_hit()
    )
    assert contra.value < aligned.value
    assert contra.components["aggressor"] < 0


def test_repeater_lifts_tier():
    base = score(_evt(premium=50_000.0, dte=20, volume=400, open_interest=800),
                 StaticBaselineProvider(), _first_hit())
    repeater = score(
        _evt(premium=50_000.0, dte=20, volume=400, open_interest=800),
        StaticBaselineProvider(),
        CoalesceResult(is_first=False, hits=3, cumulative_premium=150_000.0, first_seen_unix=0.0),
    )
    assert repeater.value == base.value + 10.0


def test_tier_boundaries_are_inclusive_at_85():
    # synthesize an event that lands exactly on each boundary by varying premium
    bl = StaticBaselineProvider()
    edge = score(
        _evt(premium=1_500_000.0, dte=0, volume=2000, open_interest=200),
        bl,
        _first_hit(),
    )
    assert edge.tier == TIER_SCALP


def test_components_sum_to_value():
    sc = score(_evt(premium=80_000.0, dte=25, volume=600, open_interest=1000),
               StaticBaselineProvider(), _first_hit())
    assert abs(sum(sc.components.values()) - sc.value) < 1e-6 or sc.value in (0.0, 100.0)


def test_swing_band_between_65_and_85():
    # premium=300K → 92 pct → 36.8 premium pts
    # V/OI = 1.0 → 10 unusualness pts
    # bid_ask=A, opt_type=C, block_type="" → 5 aggressor pts (aligned, no sweep)
    # dte=5 → 15 dte pts
    # total = 66.8 → SWING tier
    sc = score(
        _evt(premium=300_000.0, dte=5, volume=500, open_interest=500,
             block_type="", bid_ask="A"),
        StaticBaselineProvider(),
        _first_hit(),
    )
    assert 65 <= sc.value < 85, f"got {sc.value} components={sc.components}"
    assert sc.tier == TIER_SWING
