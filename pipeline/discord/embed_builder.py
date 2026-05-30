"""Discord embed builders for instant + digest posts."""
from __future__ import annotations

from datetime import datetime, timezone
from typing import Iterable

from .coalescer import CoalesceResult
from .normalize import FlowEvent
from .scoring import Score, TIER_SCALP, TIER_SWING, TIER_WATCH


_TIER_EMOJI = {
    TIER_SCALP: "🔥",
    TIER_SWING: "📈",
    TIER_WATCH: "👀",
}

# Call tints (greens) get brighter with tier; put tints (reds) likewise.
_COLOR_BY_TIER_BULL = {
    TIER_SCALP: 0x00E676,
    TIER_SWING: 0x00C853,
    TIER_WATCH: 0x4CAF50,
}
_COLOR_BY_TIER_BEAR = {
    TIER_SCALP: 0xFF1744,
    TIER_SWING: 0xD50000,
    TIER_WATCH: 0xC62828,
}


def _fmt_money(v: float) -> str:
    if v >= 1_000_000:
        return f"${v / 1_000_000:.2f}M"
    if v >= 1_000:
        return f"${v / 1_000:.1f}K"
    return f"${v:.0f}"


def _fmt_expiry(unix: int) -> str:
    if unix <= 0:
        return "?"
    return datetime.fromtimestamp(unix, tz=timezone.utc).strftime("%m/%d")


def _moneyness(strike: float, spot: float | None, opt_type: str) -> str:
    if not spot or spot <= 0 or strike <= 0:
        return ""
    delta_pct = (strike - spot) / spot
    if opt_type == "P":
        delta_pct = -delta_pct
    return f"{delta_pct:+.1%}"


def _aggressor_marker(event: FlowEvent) -> str:
    if event.block_type == "SWEEP":
        if event.bid_ask == "A" and event.opt_type == "C":
            return "⚡ sweep @ ASK"
        if event.bid_ask == "B" and event.opt_type == "P":
            return "⚡ sweep @ BID"
        return "⚡ sweep"
    if event.bid_ask == "A":
        return "↑ at ASK"
    if event.bid_ask == "B":
        return "↓ at BID"
    return ""


def _components_footer(score: Score) -> str:
    parts = [f"{k}:{v:+.0f}" for k, v in score.components.items() if abs(v) >= 0.5]
    return " · ".join(parts)


def build_instant_embed(
    event: FlowEvent,
    score: Score,
    coalesce: CoalesceResult | None = None,
) -> dict:
    """One scored event → one Discord embed."""
    emoji = _TIER_EMOJI.get(score.tier, "")
    color_map = _COLOR_BY_TIER_BULL if event.is_bullish else _COLOR_BY_TIER_BEAR
    color = color_map.get(score.tier, 0x888888)

    title = (
        f"{emoji} {event.symbol} {event.strike:g}{event.opt_type} "
        f"{_fmt_expiry(event.expiry_unix)}  · score {score.value:.0f}"
    )

    money = _moneyness(event.strike, event.spot, event.opt_type)
    money_str = f" · {money} from spot" if money else ""
    pct_line = (
        f"**{_fmt_money(event.premium)}** premium "
        f"· {score.premium_percentile:.0f}th pct vs {event.symbol} 30d"
    )
    vol_oi = (
        f"Vol {event.volume:,} / OI {event.open_interest:,} "
        f"· {event.volume / max(event.open_interest, 1):.1f}× "
        f"· DTE {event.dte}"
    )
    spot_line = f"Spot ${event.spot:.2f}{money_str}" if event.spot else ""

    markers = []
    aggr = _aggressor_marker(event)
    if aggr:
        markers.append(aggr)
    if coalesce and coalesce.hits > 1:
        markers.append(
            f"×{coalesce.hits} hits · {_fmt_money(coalesce.cumulative_premium)} cum"
        )

    description_lines = [pct_line, vol_oi]
    if spot_line:
        description_lines.append(spot_line)
    if markers:
        description_lines.append(" · ".join(markers))

    footer = _components_footer(score)
    return {
        "title": title,
        "description": "\n".join(description_lines),
        "color": color,
        "footer": {"text": f"v2 · {footer}"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }


def build_digest_embed(
    surfaced: Iterable[tuple[FlowEvent, Score, CoalesceResult | None]],
    total_scored: int,
    window_minutes: int = 10,
    drop_threshold: float = 45.0,
) -> dict:
    """Top-K events → one digest embed grouped by symbol."""
    rows: list[str] = []
    by_symbol: dict[str, list[tuple[FlowEvent, Score, CoalesceResult | None]]] = {}
    for evt, sc, co in surfaced:
        by_symbol.setdefault(evt.symbol, []).append((evt, sc, co))

    for symbol, items in by_symbol.items():
        items.sort(key=lambda x: x[1].value, reverse=True)
        for evt, sc, co in items:
            emoji = _TIER_EMOJI.get(sc.tier, "·")
            hits = f" ×{co.hits}" if co and co.hits > 1 else ""
            cum = (
                f" ({_fmt_money(co.cumulative_premium)} cum)"
                if co and co.hits > 1
                else f" ({_fmt_money(evt.premium)})"
            )
            rows.append(
                f"{emoji} **{evt.symbol} {evt.strike:g}{evt.opt_type}** "
                f"{_fmt_expiry(evt.expiry_unix)} — score {sc.value:.0f}{hits}{cum}"
            )

    surfaced_count = len(rows)
    description = "\n".join(rows) if rows else "_no events cleared threshold this window_"
    return {
        "title": (
            f"📊 Flow Digest — last {window_minutes} min "
            f"({total_scored} scored, {surfaced_count} surfaced)"
        ),
        "description": description,
        "color": 0x546E7A,
        "footer": {"text": f"next digest in {window_minutes}:00 · drop < {drop_threshold:.0f}"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }
