"""Reference wiring — how Oracle's discord_relay.py adopts the v2 pipeline.

This is documentation-as-code. None of it runs by default; copy the relevant
calls into discord_relay.py to enable shadow mode.

Shadow rollout sequence:

  1. Add to WEBHOOKS dict in discord_relay.py:
         "flow_v2_shadow": "<new discord webhook>",
         "flow_digest":    "<new discord webhook>",

  2. Initialize the singletons once at module load (see `_init_v2` below).

  3. In relay_flow_alerts(), after building each alert, call `relay_v2_shadow`.

  4. Run `digest_tick` from a separate PM2 process or schedule it via the
     existing relay loop (every POLL_INTERVAL it can check elapsed time).
"""
from __future__ import annotations

import os
import time
from typing import Any, Callable

from . import normalize
from .baseline import OnlineEWMABaselineProvider
from .coalescer import Coalescer
from .digest import DigestBuffer
from .embed_builder import build_digest_embed, build_instant_embed
from .router import Route, route, webhook_key
from .scoring import score


_STATE_DIR = os.environ.get("FLOW_V2_STATE_DIR", os.path.dirname(os.path.abspath(__file__)))
_BASELINE_PATH = os.path.join(_STATE_DIR, "baseline_state.json")

_baseline: OnlineEWMABaselineProvider | None = None
_coalescer: Coalescer | None = None
_digest: DigestBuffer | None = None
_last_digest_at: float = 0.0
DIGEST_INTERVAL_SEC = 600


def _init_v2() -> tuple[OnlineEWMABaselineProvider, Coalescer, DigestBuffer]:
    global _baseline, _coalescer, _digest
    if _baseline is None:
        _baseline = OnlineEWMABaselineProvider(state_path=_BASELINE_PATH)
    if _coalescer is None:
        _coalescer = Coalescer(window_seconds=600)
    if _digest is None:
        _digest = DigestBuffer(window_seconds=DIGEST_INTERVAL_SEC, top_k=10)
    return _baseline, _coalescer, _digest


def relay_v2_shadow(
    source_id: str,
    alert: dict[str, Any],
    quote: dict[str, Any] | None,
    post_embed: Callable[[str, dict], bool],
) -> None:
    """Score a flow_alerts_today entry and post it to the shadow channel.

    `post_embed` is `discord_relay.post_embed(webhook_key, embed) -> bool`.
    Safe to call alongside the existing relay code; purely additive.
    """
    baseline, coalescer, digest = _init_v2()

    event = normalize.from_flow_alert(source_id, alert, quote)
    if not event.symbol or not event.premium:
        return

    coalesce = coalescer.observe(
        event.symbol, event.strike, event.opt_type, event.expiry_unix, event.premium
    )
    baseline.observe(event.symbol, event.premium)

    sc = score(event, baseline, coalesce)
    r = route(sc)

    if r is Route.INSTANT:
        embed = build_instant_embed(event, sc, coalesce)
        post_embed("flow_v2_shadow", embed)
    elif r is Route.DIGEST:
        digest.add(event, sc, coalesce)


def digest_tick(post_embed: Callable[[str, dict], bool]) -> bool:
    """Call from the main relay loop. Flushes digest if interval elapsed."""
    global _last_digest_at
    _, _, digest = _init_v2()
    now = time.time()
    if now - _last_digest_at < DIGEST_INTERVAL_SEC:
        return False
    surfaced = digest.flush()
    total = len(surfaced)
    if total == 0:
        _last_digest_at = now
        return False
    embed = build_digest_embed(
        surfaced,
        total_scored=total,
        window_minutes=DIGEST_INTERVAL_SEC // 60,
    )
    ok = post_embed("flow_digest", embed)
    _last_digest_at = now
    return ok


def flush_baseline_state() -> None:
    """Call periodically (or on shutdown) to persist EWMA state."""
    if _baseline is not None:
        _baseline.flush()
