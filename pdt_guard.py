"""PDT (Pattern Day Trader) guard for Boba + Jazzy decision cycles.

Adds layered protection against Alpaca's 4-daytrade-in-5-business-days rule
on accounts under $25K equity.

Public API:
    apply_pdt_guard(picks, account, *, agent="boba") -> (filtered_picks, notes)

Behavior:
    daytrade_count ≥ 4: refuse ALL picks (Alpaca would reject anyway)
    daytrade_count ≥ 3:
      - refuse 0DTE option entries
      - refuse stock entries
      - allow multi-day option entries
      - allow exits of EXISTING positions (handled elsewhere)
    daytrade_count ≤ 2: no restrictions

Env override:
    BOBA_PDT_OVERRIDE=1 disables all guards.

Each picked-or-skipped decision is logged with reason for journal/grader audit.
"""
from __future__ import annotations
import os
from datetime import datetime, timezone
from typing import Any


PDT_EQUITY_THRESHOLD = 25_000  # Alpaca PDT rule only applies under this
WARN_COUNT = 3                 # one daytrade away from lockout
HARD_COUNT = 4                 # at this count, Alpaca rejects new daytrades


def _is_zero_dte(pick: dict[str, Any]) -> bool:
    """A 0DTE option is one expiring on the current calendar date (US/Eastern)."""
    expiry = pick.get("expiry") or ""
    if not expiry:
        return False
    # Compare YYYY-MM-DD strings. Boba/Jazzy build expiry as ISO date.
    try:
        from datetime import timezone, timedelta
        et = timezone(timedelta(hours=-4))  # naive EDT; close enough — PDT cares about session
        today_et = datetime.now(et).date().isoformat()
        return expiry[:10] == today_et
    except Exception:
        return False


def _is_stock(pick: dict[str, Any]) -> bool:
    """A stock pick has no strike / option_type / expiry."""
    return not (pick.get("strike") and pick.get("option_type"))


def apply_pdt_guard(
    picks: list[dict[str, Any]],
    account: dict[str, Any],
    *,
    agent: str = "boba",
) -> tuple[list[dict[str, Any]], list[str]]:
    """Filter picks per PDT policy.

    Args:
        picks: List of Boba/Jazzy pick dicts.
        account: Alpaca account dict (must have daytrade_count + equity).
        agent: 'boba' or 'jazzy' for log labels.

    Returns:
        (filtered_picks, notes) — notes are human-readable reasons for each skip.
    """
    notes: list[str] = []

    if os.environ.get("BOBA_PDT_OVERRIDE", "0") == "1":
        notes.append(f"[pdt-guard:{agent}] BOBA_PDT_OVERRIDE=1 — guards bypassed")
        return picks, notes

    # PDT rule doesn't apply to accounts above $25K
    try:
        equity = float(account.get("equity") or 0)
    except (TypeError, ValueError):
        equity = 0.0
    if equity >= PDT_EQUITY_THRESHOLD:
        return picks, notes

    try:
        dt_count = int(account.get("daytrade_count") or 0)
    except (TypeError, ValueError):
        dt_count = 0

    # Layer 1: HARD BLOCK at 4
    if dt_count >= HARD_COUNT:
        notes.append(
            f"[pdt-guard:{agent}] daytrade_count={dt_count} ≥ {HARD_COUNT} — "
            f"refusing ALL {len(picks)} pick(s) (would trigger PDT lockout)"
        )
        return [], notes

    # Layer 2 + 3 + 4: at warn count, filter 0DTE + stocks; keep multi-day options
    if dt_count >= WARN_COUNT:
        kept = []
        for p in picks:
            ticker = p.get("ticker", "?")
            if _is_stock(p):
                notes.append(
                    f"[pdt-guard:{agent}] skip STOCK {ticker} "
                    f"(daytrade_count={dt_count}, stocks risk same-day round-trip)"
                )
                continue
            if _is_zero_dte(p):
                expiry = p.get("expiry", "?")
                notes.append(
                    f"[pdt-guard:{agent}] skip 0DTE {ticker} "
                    f"${p.get('strike')}{p.get('option_type','')[:1]} {expiry} "
                    f"(daytrade_count={dt_count}, can't safely close)"
                )
                continue
            kept.append(p)
        if len(kept) != len(picks):
            notes.append(
                f"[pdt-guard:{agent}] kept {len(kept)}/{len(picks)} picks "
                f"(daytrade_count={dt_count}, equity=${equity:,.0f})"
            )
        return kept, notes

    return picks, notes
