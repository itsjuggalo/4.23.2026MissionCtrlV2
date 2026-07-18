"""Deterministic confidence score for trade signals.

Composes a 0-100 confidence score from multiple factors:
  - tier (premium-based): up to 40 pts
  - vol/OI ratio: up to 15 pts
  - sweep dominance: up to 12 pts
  - upstream score (firebase_to_scored / flow_scorer): up to 10 pts
  - regime alignment: -10 to +5 pts
  - time-of-day for 0DTE entries: -12 to 0 pts
  - DTE band (gamma vs theta tradeoff): -5 to +3 pts

Output bands:
  90-100  PLATINUM   full conviction, can size up
  75-89   GOLD       standard size, take confidently
  60-74   SILVER     smaller size, watch closely
  40-59   BRONZE     single contract, exploratory
   0-39   TRASH      skip — soft-gated out before showing to agent

Public API:
    score_signal(signal: dict, *, regime: str="",
                 et_hour: int|None=None) -> dict
        Returns {"score": int, "band": str, "breakdown": dict}

    annotate_shortlist(shortlist: list[tuple[str, dict]], *,
                       regime: str="",
                       drop_trash: bool=True) -> list[tuple[str, dict]]
        Adds 'confidence' dict to each signal, sorts by score DESC, drops TRASH band.
"""
from __future__ import annotations
from datetime import datetime, timezone, timedelta
from typing import Any


# Tier inferred from flow_value when the signal-side tier label is non-canonical
TIER_THRESHOLDS = [
    (10_000_000, "T0_MEGA",         40),
    ( 5_000_000, "T1_BIG",          35),
    ( 1_000_000, "T1_HUGE",         30),
    (   500_000, "T2_UNUSUAL_HUGE", 22),
    (   100_000, "T3",              12),
    (         0, "T4",               6),
]


def _tier_from_flow(flow_value: float) -> tuple[str, int]:
    for thresh, name, pts in TIER_THRESHOLDS:
        if flow_value >= thresh:
            return name, pts
    return "T4", 6


def _vol_oi_points(volume: float, oi: float) -> int:
    if oi <= 0: return 0
    ratio = volume / oi
    if ratio >= 10: return 15
    if ratio >=  5: return 10
    if ratio >=  2: return 5
    if ratio >=  1: return 2
    return 0


def _sweep_points(sweeps: int, blocks: int) -> int:
    total = (sweeps or 0) + (blocks or 0)
    if total <= 0: return 0
    pct = (sweeps or 0) / total
    if pct >= 0.85: return 12
    if pct >= 0.65: return 8
    if pct >= 0.40: return 4
    return 0


def _regime_points(direction: str, regime: str) -> int:
    r = (regime or "").upper()
    is_bull = direction == "CALL"
    if "BULL" in r and "MIXED" not in r:
        return 5 if is_bull else -10
    if "BEAR" in r and "MIXED" not in r:
        return 5 if not is_bull else -10
    return 0  # mixed / unknown


def _is_zero_dte(expiry: str) -> bool:
    if not expiry:
        return False
    today = datetime.now(timezone(timedelta(hours=-4))).date()  # ET-ish
    for fmt in ("%Y-%m-%d", "%m/%d/%y", "%m/%d/%Y"):
        try:
            return datetime.strptime(expiry, fmt).date() == today
        except Exception:
            continue
    return False


def _time_of_day_points(is_0dte: bool, et_hour: int | None) -> int:
    if not is_0dte:
        return 0
    if et_hour is None:
        et_hour = datetime.now(timezone(timedelta(hours=-4))).hour
    if et_hour >= 15: return -12
    if et_hour >= 14: return -8
    if et_hour >= 13: return -3
    return 0


def _dte_band_points(expiry: str) -> int:
    """Sweet spot is 5-21 DTE (theta-manageable, gamma not extreme)."""
    if not expiry:
        return 0
    today = datetime.now(timezone(timedelta(hours=-4))).date()
    for fmt in ("%Y-%m-%d", "%m/%d/%y", "%m/%d/%Y"):
        try:
            exp_date = datetime.strptime(expiry, fmt).date()
            dte = (exp_date - today).days
            if dte < 0: return -5
            if dte == 0: return -5  # 0DTE handled by time-of-day too
            if 5 <= dte <= 21: return 3
            if 22 <= dte <= 45: return 1
            if dte > 45: return -2
            return 0
        except Exception:
            continue
    return 0


def _upstream_score_points(score: float) -> int:
    """The signal already carries a 0-100 upstream score. Map to 0-10."""
    try:
        s = float(score or 0)
    except Exception:
        return 0
    return int(min(10, max(0, s / 10)))


def _band(score: int) -> str:
    if score >= 90: return "PLATINUM"
    if score >= 75: return "GOLD"
    if score >= 60: return "SILVER"
    if score >= 40: return "BRONZE"
    return "TRASH"


def score_signal(signal: dict, *, regime: str = "",
                 et_hour: int | None = None) -> dict:
    flow_value = float(signal.get("flow_value") or 0)
    tier_name, tier_pts = _tier_from_flow(flow_value)

    volume = float(signal.get("volume") or 0)
    oi = float(signal.get("oi") or 0)
    sweeps = int(signal.get("sweeps") or 0)
    blocks = int(signal.get("blocks") or 0)
    direction = (signal.get("option_type") or signal.get("direction") or "").upper()[:4]
    if direction.startswith("CALL"): direction = "CALL"
    elif direction.startswith("PUT"): direction = "PUT"
    expiry = signal.get("expiry") or ""
    is_0dte = _is_zero_dte(expiry)

    breakdown = {
        "tier":           tier_pts,
        "vol_oi":         _vol_oi_points(volume, oi),
        "sweep":          _sweep_points(sweeps, blocks),
        "upstream":       _upstream_score_points(signal.get("score") or 0),
        "regime":         _regime_points(direction, regime),
        "time_of_day":    _time_of_day_points(is_0dte, et_hour),
        "dte_band":       _dte_band_points(expiry),
    }
    total = sum(breakdown.values())
    total = max(0, min(100, total))
    return {
        "score": total,
        "band": _band(total),
        "tier_label": tier_name,
        "is_0dte": is_0dte,
        "breakdown": breakdown,
    }


def annotate_shortlist(shortlist: list[tuple[str, dict]], *,
                        regime: str = "",
                        drop_trash: bool = True) -> list[tuple[str, dict]]:
    """In-place: add 'confidence' to each signal, sort DESC, optionally drop TRASH."""
    et_hour = datetime.now(timezone(timedelta(hours=-4))).hour
    annotated = []
    for sid, s in shortlist:
        conf = score_signal(s, regime=regime, et_hour=et_hour)
        s["confidence"] = conf
        annotated.append((sid, s))
    annotated.sort(key=lambda x: -x[1]["confidence"]["score"])
    if drop_trash:
        kept = [x for x in annotated if x[1]["confidence"]["band"] != "TRASH"]
        if len(kept) != len(annotated):
            print(f"[signal-scorer] dropped {len(annotated) - len(kept)} TRASH-band signals", flush=True)
        return kept
    return annotated


def render_breakdown_line(conf: dict) -> str:
    """Compact one-line summary of a signal's confidence breakdown for the prompt."""
    b = conf["breakdown"]
    parts = [f"{k}({v:+d})" if v < 0 else f"{k}({v})" for k, v in b.items() if v != 0]
    return f"score={conf['score']} {conf['band']} [{conf['tier_label']}] | " + " ".join(parts)
