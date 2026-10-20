"""Send-time price guard for every Telegram/SMS sender (remedial W1, 2026-10-20).

One rule, one implementation: MissionCtrl's pipeline/decision/lib/quote_client.py
(send_price_check + src_label, thresholds in fact_policies.json "send_guard": 60 s in
the regular session, 300 s pre/after-hours, today's print only — Mike's decision 3).
This module only path-loads it, so the pipeline lib never lands on sys.path. If it
can't be loaded, every check fails closed — a sender holds the card, it never guesses.

    from price_guard import check, src_label, alpaca_last, alpaca_option_mid
"""
from __future__ import annotations

import importlib.util
import os
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")

QUOTE_CLIENT = (os.environ.get("MC_QUOTE_CLIENT")
                or "/AIWorkWSL/web/missionctrl/pipeline/decision/lib/quote_client.py")


def _load():
    try:
        spec = importlib.util.spec_from_file_location("mc_quote_client", QUOTE_CLIENT)
        mod = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(mod)
        return mod if hasattr(mod, "send_price_check") else None
    except Exception:  # noqa: BLE001 — missing/broken lib = fail closed below
        return None


QC = _load()


def check(trade_ts, price, now: datetime | None = None, prev_bar_ts=None) -> dict:
    """{ok, reason, age_s, hhmm, window}. ok=False with a reason whenever the price can't be trusted."""
    if QC is None:
        return {"ok": False, "reason": "price guard unavailable", "age_s": None, "hhmm": None, "window": None}
    return QC.send_price_check(trade_ts, now=now, price=price, prev_bar_ts=prev_bar_ts)


def src_label(source: str, ts) -> str:
    return QC.src_label(source, ts) if QC else f"src {source} time n/a"


def _bar_date(bar: dict):
    try:
        return datetime.fromisoformat(str(bar.get("t", "")).replace("Z", "+00:00")).astimezone(ET).date()
    except ValueError:
        return None


def alpaca_session_bars(node: dict | None, now: datetime | None = None) -> tuple:
    """(prior_bar, today_bar) from an Alpaca snapshot, anchored on bar DATES. Before today's
    first print, Alpaca's dailyBar is still the LAST session and prevDailyBar is two sessions
    back (the 10-08 PCRX premarket gap was measured against that bar). today_bar is {} then."""
    node = node or {}
    daily, prev = node.get("dailyBar") or {}, node.get("prevDailyBar") or {}
    today = (now or datetime.now(timezone.utc)).astimezone(ET).date()
    d = _bar_date(daily) if daily else None
    if d is not None and d < today:
        return daily, {}
    return prev, daily


def alpaca_last(node: dict | None, now: datetime | None = None) -> tuple:
    """(price, check) from an Alpaca stock/crypto snapshot's latestTrade. price is None unless check ok."""
    t = (node or {}).get("latestTrade") or {}
    chk = check(t.get("t"), t.get("p"), now=now)
    return (float(t["p"]) if chk["ok"] else None), chk


def alpaca_option_mid(node: dict | None, now: datetime | None = None) -> tuple:
    """(mid, check) from an Alpaca option snapshot's latestQuote (bid/ask midpoint, one-sided
    falls back to the side present). mid is None unless the quote passes the same age rule."""
    q = (node or {}).get("latestQuote") or {}
    bp, ap = q.get("bp"), q.get("ap")
    mid = round((bp + ap) / 2, 2) if (bp and ap) else (ap or bp or None)
    chk = check(q.get("t"), mid, now=now)
    return (mid if chk["ok"] else None), chk
