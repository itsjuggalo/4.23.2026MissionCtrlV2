"""Mirror trade outcomes (closures + peak-gain crossings) to #flow-v2-shadow.

Sources (same JSON files the existing relay reads):
- closed_options.json + closed_stocks.json -> closure embeds (win/loss)
- flow_alerts_today.json                   -> peak-gain threshold crossings

Maintains its own dedup state so it doesn't depend on whether the existing
relay's winners_mirror / flow_peak_gains posted successfully.
"""
from __future__ import annotations

import re
from datetime import datetime, timezone
from typing import Any, Callable


PEAK_THRESHOLDS = [25, 50, 100, 300, 500]

_COLOR_WIN = 0x00D2A0
_COLOR_LOSS = 0xFF4757
_COLOR_BE = 0x636E72
_COLOR_PEAK = {
    25: 0xFF8800,
    50: 0xFF8800,
    100: 0xAA00FF,
    300: 0xAA00FF,
    500: 0xFFD700,
}


def _fmt_expiry_unix(unix_ts: Any) -> str:
    try:
        ts = int(unix_ts)
        if ts <= 1_000_000_000:
            return ""
        return datetime.fromtimestamp(ts, tz=timezone.utc).strftime(" %m/%d")
    except (TypeError, ValueError):
        return ""


def _extract_pct(status: str) -> float | None:
    if not status:
        return None
    m = re.search(r"(-?\d+(?:\.\d+)?)\s*%", status)
    return float(m.group(1)) if m else None


def _contract_label(entry: dict, kind: str) -> str:
    sym = entry.get("symbol", "?")
    strike = entry.get("strike", "")
    if kind != "OPTION" or not strike:
        return sym
    opt_letter = "P" if entry.get("isPut", 0) else "C"
    return f"{sym} {strike}{opt_letter}{_fmt_expiry_unix(entry.get('expiry'))}"


def build_closure_embed(entry: dict, kind: str) -> dict | None:
    """Build a compact closure embed. Returns None if entry has no usable signal."""
    status = entry.get("status", "") or entry.get("message", "")
    if not status:
        return None

    pct = _extract_pct(status)
    if pct is None:
        try:
            buy = float(entry.get("buyTarget") or 0)
            sell = float(
                entry.get("sellTarget")
                or entry.get("exit1")
                or entry.get("sellTarget3")
                or 0
            )
            if buy > 0 and sell > 0:
                pct = round((sell - buy) / buy * 100, 1)
        except (TypeError, ValueError):
            pct = None

    if pct is None:
        emoji, color, tag = "🔒", _COLOR_BE, "CLOSED"
    elif pct >= 100:
        emoji, color, tag = "🚀", _COLOR_WIN, f"+{pct:.0f}%"
    elif pct >= 25:
        emoji, color, tag = "✅", _COLOR_WIN, f"+{pct:.0f}%"
    elif pct >= 0:
        emoji, color, tag = "✅", _COLOR_WIN, f"+{pct:.1f}%"
    else:
        emoji, color, tag = "❌", _COLOR_LOSS, f"{pct:.1f}%"

    label = _contract_label(entry, kind)
    short_name = entry.get("shortName", "")
    category = entry.get("category", "")

    desc_parts = [status]
    meta = []
    buy = entry.get("buyTarget")
    sell = entry.get("sellTarget")
    if buy and sell:
        meta.append(f"Buy ${buy} → Sell ${sell}")
    if category:
        meta.append(f"[{category}]")
    if meta:
        desc_parts.append(" · ".join(meta))

    return {
        "title": f"{emoji} {label} — {tag}",
        "description": "\n".join(desc_parts) if desc_parts else None,
        "color": color,
        "footer": {"text": f"v2 outcome · {short_name}" if short_name else "v2 outcome"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }


def build_peak_gain_embed(
    alert: dict, peak_pct: float, threshold: int, alert_price: float, day_high: float
) -> dict:
    sym = alert.get("Symbol", "?")
    strike = alert.get("Strike", "?")
    opt_type = (alert.get("OptionType") or "?").upper()
    opt_letter = "C" if opt_type.startswith("C") else ("P" if opt_type.startswith("P") else "?")
    expiry_str = _fmt_expiry_unix(alert.get("Expiry"))

    if threshold >= 500:
        emoji = "💫"
        label_word = "LEGENDARY"
    elif threshold >= 300:
        emoji = "⚡"
        label_word = "MASSIVE"
    elif threshold >= 100:
        emoji = "🚀"
        label_word = "Triple-bagger"
    elif threshold >= 50:
        emoji = "🎆"
        label_word = "Strong move"
    else:
        emoji = "🎭"
        label_word = "Pattern playing out"

    color = _COLOR_PEAK.get(threshold, _COLOR_PEAK[50])

    contract = f"{sym} {strike}{opt_letter}{expiry_str}"
    return {
        "title": f"{emoji} {contract} peaked +{peak_pct:.0f}%",
        "description": (
            f"**{label_word}** — alert→peak ${alert_price:.2f} → ${day_high:.2f}\n"
            f"Threshold {threshold}% crossed."
        ),
        "color": color,
        "footer": {"text": f"v2 outcome · peak gain"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }


def relay_v2_outcomes(
    state: dict,
    read_data: Callable[[str], dict | None],
    post_embed: Callable[[str, dict], bool],
    webhook_key: str = "flow_v2_shadow",
) -> dict:
    """Read closure + peak-gain sources and mirror new outcomes to v2 shadow."""
    sent: set[str] = set(state.get("v2_outcomes_sent", []))
    new_sent: list[str] = []

    # --- Closures (option + stock) ---
    for fname, kind in [("closed_options", "OPTION"), ("closed_stocks", "STOCK")]:
        data = read_data(fname)
        if not data or not isinstance(data, dict):
            continue
        for entry_id, entry in data.items():
            if not isinstance(entry, dict):
                continue
            key = f"v2closure|{fname}|{entry_id}"
            if key in sent:
                continue
            embed = build_closure_embed(entry, kind)
            if not embed:
                continue
            if post_embed(webhook_key, embed):
                new_sent.append(key)

    # --- Peak gain threshold crossings on previously-alerted flow ---
    flow = read_data("flow_alerts_today")
    if flow and isinstance(flow, dict):
        for fkey, fentry in flow.items():
            alert = fentry.get("alert", {}) or {}
            quote = fentry.get("quote", {}) or {}
            try:
                alert_price = float(alert.get("AlertPrice") or 0)
                day_high = float(quote.get("DayHigh") or quote.get("High") or 0)
            except (TypeError, ValueError):
                continue
            if alert_price <= 0 or day_high <= 0:
                continue
            peak_pct = (day_high - alert_price) / alert_price * 100.0
            for thresh in sorted(PEAK_THRESHOLDS, reverse=True):
                if peak_pct < thresh:
                    continue
                key = f"v2peak|{fkey}|{thresh}"
                if key in sent:
                    break
                embed = build_peak_gain_embed(alert, peak_pct, thresh, alert_price, day_high)
                if post_embed(webhook_key, embed):
                    new_sent.append(key)
                break  # only highest threshold per contract per cycle

    if new_sent:
        all_sent = list(sent | set(new_sent))[-50_000:]
        state["v2_outcomes_sent"] = all_sent
    return state
