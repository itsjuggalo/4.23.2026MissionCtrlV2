"""
Score Reasoner — takes an options flow event (raw data) and produces a
component-by-component score breakdown so every scoring decision is auditable.

Works standalone. Does NOT modify existing flow_scorer.py. Downstream consumers
(Orion, Boba, Discord webhooks) can call annotate_event() to get reasoning.

Once we verify this replicates flow_scorer's logic, we can deprecate the
black-box version — but for now this RUNS IN PARALLEL.
"""
from typing import Dict, Any, List, Tuple


def annotate_event(event: Dict[str, Any]) -> Dict[str, Any]:
    """
    Input: a raw options flow event. Expected fields (defensive to missing):
        ticker, strike, expiry, type (call/put), volume, open_interest,
        premium_usd, side (ASK/BID/MID), delta, iv, iv_rank, sweep (bool),
        block (bool), dte (int, days to expiry)
    Output: original event + _reasoning dict with:
        components: list of (label, points, note) tuples
        total_score: sum of positive + negative components
        grade: TOP / STRONG / MAYBE / WEAK / REJECT
        top_reason: the single biggest positive contributor
    """
    components: List[Tuple[str, int, str]] = []

    volume = float(event.get("volume", 0) or 0)
    oi = float(event.get("open_interest", 0) or 0)
    vol_oi = volume / oi if oi > 0 else 0

    if vol_oi >= 5:
        components.append(("VOL/OI", 25, f"{vol_oi:.1f}x — extreme unusual"))
    elif vol_oi >= 3:
        components.append(("VOL/OI", 18, f"{vol_oi:.1f}x — strong unusual"))
    elif vol_oi >= 1.5:
        components.append(("VOL/OI", 10, f"{vol_oi:.1f}x — mild unusual"))
    elif vol_oi >= 0.5:
        components.append(("VOL/OI", 3, f"{vol_oi:.1f}x — normal"))
    else:
        components.append(("VOL/OI", 0, f"{vol_oi:.1f}x — below normal"))

    delta = abs(float(event.get("delta", 0) or 0))
    if 0.35 <= delta <= 0.55:
        components.append(("Delta band", 15, f"{delta:.2f} — sweet spot (near money)"))
    elif 0.25 <= delta < 0.35 or 0.55 < delta <= 0.65:
        components.append(("Delta band", 8, f"{delta:.2f} — acceptable"))
    elif delta < 0.15:
        components.append(("Delta band", -5, f"{delta:.2f} — too far OTM (lotto)"))
    elif delta > 0.85:
        components.append(("Delta band", -3, f"{delta:.2f} — too deep ITM (capital-heavy)"))
    else:
        components.append(("Delta band", 3, f"{delta:.2f} — edge"))

    side = str(event.get("side", "")).upper()
    if "ASK" in side:
        components.append(("Aggressor side", 12, "ASK (buyer-aggressive)"))
    elif "BID" in side:
        components.append(("Aggressor side", -8, "BID (seller-aggressive)"))
    elif side:
        components.append(("Aggressor side", 0, f"{side} — neutral"))

    if event.get("sweep"):
        components.append(("Sweep flag", 10, "multi-exchange sweep"))
    if event.get("block"):
        components.append(("Block flag", 8, "institutional block"))

    premium = float(event.get("premium_usd", 0) or 0)
    if premium >= 2_000_000:
        components.append(("Premium", 15, f"${premium/1e6:.1f}M — whale tier"))
    elif premium >= 500_000:
        components.append(("Premium", 10, f"${premium/1e3:.0f}K — large"))
    elif premium >= 100_000:
        components.append(("Premium", 5, f"${premium/1e3:.0f}K — mid"))
    elif premium > 0:
        components.append(("Premium", 1, f"${premium/1e3:.0f}K — small"))

    dte = int(event.get("dte", 0) or 0)
    if 7 <= dte <= 45:
        components.append(("DTE", 8, f"{dte}d — sweet spot"))
    elif dte < 2:
        components.append(("DTE", -10, f"{dte}d — 0–1DTE (gambling)"))
    elif dte < 7:
        components.append(("DTE", 2, f"{dte}d — short"))
    elif dte > 90:
        components.append(("DTE", -3, f"{dte}d — too long (theta drag)"))

    iv_rank = float(event.get("iv_rank", -1) or -1)
    if 0 <= iv_rank <= 30:
        components.append(("IV rank", 8, f"{iv_rank:.0f}th — cheap IV"))
    elif 30 < iv_rank <= 60:
        components.append(("IV rank", 3, f"{iv_rank:.0f}th — fair IV"))
    elif iv_rank > 80:
        components.append(("IV rank", -5, f"{iv_rank:.0f}th — expensive IV"))

    total = sum(pts for _, pts, _ in components)

    if total >= 70:
        grade = "TOP"
    elif total >= 50:
        grade = "STRONG"
    elif total >= 30:
        grade = "MAYBE"
    elif total >= 10:
        grade = "WEAK"
    else:
        grade = "REJECT"

    positives = sorted([c for c in components if c[1] > 0], key=lambda x: -x[1])
    top_reason = f"{positives[0][0]} ({positives[0][2]})" if positives else "no positive signal"

    result = dict(event)
    result["_reasoning"] = {
        "components": components,
        "total_score": total,
        "grade": grade,
        "top_reason": top_reason,
    }
    return result


def format_reasoning_text(annotated_event: Dict[str, Any]) -> str:
    """Convert a reasoning dict into human-readable multi-line text."""
    r = annotated_event.get("_reasoning", {})
    if not r:
        return "(no reasoning available)"
    lines = [f"Score {r['total_score']} / grade {r['grade']}"]
    for label, pts, note in r["components"]:
        sign = "+" if pts >= 0 else ""
        lines.append(f"  {sign}{pts} {label}: {note}")
    lines.append(f"  → top reason: {r['top_reason']}")
    return "\n".join(lines)


if __name__ == "__main__":
    demo = {
        "ticker": "NVDA", "strike": 145, "expiry": "2026-05-17", "type": "call",
        "volume": 12500, "open_interest": 3000, "premium_usd": 2_800_000,
        "side": "ASK", "delta": 0.42, "iv_rank": 35, "sweep": True, "dte": 28,
    }
    annotated = annotate_event(demo)
    print(format_reasoning_text(annotated))
    print()
    print(f"Used by downstream consumers as: event['_reasoning']['top_reason']")
    print(f"Example: {annotated['_reasoning']['top_reason']}")
