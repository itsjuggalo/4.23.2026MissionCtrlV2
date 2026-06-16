"""boba_flow_enhancements — supplementary signal-quality helpers for Boba/Jazzy.

All functions return a Markdown block (or "" if their data is unavailable). The
decision cycle imports this module and injects the blocks into the prompt before
the existing best_options_text. Designed to NEVER raise — every helper wraps its
work in try/except and returns "" on any failure so the trading cycle continues.

Helpers:
  - platinum_mandate_banner()  → HARD RULE banner when Platinum tier hits exist
  - confluence_block()         → multi-source agreement scoring per ticker (4h window)
  - fresh_flow_5min_block()    → 🔥 LAST 5 MIN whale prints (institutional opens)
  - strike_cluster_block()     → 📊 tickers with 3+ distinct T1+T2 strikes today
  - sector_mix_warning()       → ⚠️ when 3+ picks fall in same sector

Tier-ladder + tiebreaker tweaks (IV-adjusted stops, Kronos confidence) are
applied via prompt-text edits in the patch script, not via this module.
"""
from __future__ import annotations

import collections
import json
from datetime import datetime, timezone, timedelta
from pathlib import Path

# (No new imports needed; datetime + json + Path are already pulled in.)

# ── REVIVED 2026-06-16: the original module read dead post-restructure feeds
# (best-options snapshots frozen May-11, scored_signals_recent.json frozen May-18,
# firebase directives stale/missing). Repointed at the LIVE merged flow stream +
# the live IV-forecast catalyst calendar so the 6 enhancers actually fire. SCORED_PATH
# is retained only as a label; no enhancer reads it.
DIRECTIVES = Path("/home/ubuntu/.openclaw/workspace/directives")
BEST_OPTIONS_DIR = Path.home() / ".openclaw" / "data" / "best-options"
SCORED_PATH = Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")

# LIVE feeds (the same stream the revived decision cycles read)
LIVE_FLOW_STREAMS = [
    Path("/AIWorkWSL/trading/signals/option-scraper/data/flow_alerts_today.json"),
    Path("/AIWorkWSL/trading/signals/option-scraper/data/flow2_alerts_today.json"),
]
IV_FORECAST_FILE = Path("/AIWorkWSL/labs/quantum/out/iv_forecast.json")
_MIN_FLOW_VALUE = 500_000  # floor; matches the decision-cycle MIN_FLOW_VALUE


def _ms_to_iso(ms) -> str:
    """Flow 'Updated'/'Time' are epoch milliseconds → UTC ISO (string-comparable)."""
    try:
        return datetime.fromtimestamp(float(ms) / 1000.0, tz=timezone.utc).isoformat()
    except Exception:
        return ""


def _epoch_to_ymd(sec) -> str:
    try:
        return datetime.fromtimestamp(float(sec), tz=timezone.utc).strftime("%Y-%m-%d")
    except Exception:
        return "?"


def _live_flow_contracts() -> list[dict]:
    """Read the live merged flow stream → the dict schema the enhancers expect
    (ticker/premium/is_bullish/option_type/strike/expiry/dte/volume/oi/sweeps/blocks/
    captured_at/tier). Dedup by OCC keeping the highest-premium print."""
    by_occ: dict[str, dict] = {}
    for fp in LIVE_FLOW_STREAMS:
        raw = _safe_read_json(fp, {})
        if not isinstance(raw, dict):
            continue
        for occ, rec in raw.items():
            a = (rec or {}).get("alert") or {}
            try:
                prem = float(a.get("totalFlowValue") or 0)
            except (TypeError, ValueError):
                prem = 0.0
            if prem < _MIN_FLOW_VALUE:
                continue
            ot = str(a.get("OptionType") or "").upper()
            opt = "C" if ot.startswith("C") else ("P" if ot.startswith("P") else "?")
            tier = ("T1_HUGE" if prem >= 5_000_000
                    else "T2_UNUSUAL_HUGE" if prem >= 1_000_000
                    else "T3_NOTABLE")
            try:
                sweeps = int(a.get("SWEEPS") or 0)
            except (TypeError, ValueError):
                sweeps = 0
            try:
                blocks = int(a.get("BLOCKS") or 0)
            except (TypeError, ValueError):
                blocks = 0
            item = {
                "ticker": str(a.get("Symbol") or "?").upper(),
                "premium": prem,
                "is_bullish": bool(a.get("isBullish")),
                "is_put": opt == "P",
                "option_type": opt,
                "strike": a.get("Strike") or 0,
                "expiry": _epoch_to_ymd(a.get("Expiry")),
                "dte": a.get("DTE") or 0,
                "volume": a.get("Volume") or 0,
                "oi": a.get("OI") or 0,
                "sweeps": sweeps,
                "blocks": blocks,
                "alert_type": str(a.get("AlertType") or ""),
                "captured_at": _ms_to_iso(a.get("Updated") or a.get("Time")),
                "tier": tier,
            }
            cur = by_occ.get(occ)
            if cur is None or item["premium"] > cur["premium"]:
                by_occ[occ] = item
    return list(by_occ.values())

# Coarse sector map — extend as needed. Tickers not in map fall under "OTHER".
SECTOR_MAP = {
    # AI / Semis
    "NVDA": "AI-semi", "AMD": "AI-semi", "MU": "AI-semi", "TSM": "AI-semi",
    "AVGO": "AI-semi", "INTC": "AI-semi", "SMCI": "AI-semi", "MRVL": "AI-semi",
    "ARM": "AI-semi", "QCOM": "AI-semi", "ASML": "AI-semi",
    # Mega-cap tech
    "AAPL": "mega-tech", "MSFT": "mega-tech", "GOOGL": "mega-tech",
    "GOOG": "mega-tech", "META": "mega-tech", "AMZN": "mega-tech",
    # Index ETFs / vol products
    "SPY": "index", "QQQ": "index", "IWM": "index", "DIA": "index",
    "SPX": "index", "NDX": "index", "VIX": "index", "UVXY": "index",
    # Crypto-proxy
    "MSTR": "crypto-proxy", "COIN": "crypto-proxy", "MARA": "crypto-proxy",
    "RIOT": "crypto-proxy",
    # Energy
    "XOM": "energy", "CVX": "energy", "OXY": "energy", "COP": "energy",
    "SLB": "energy", "USO": "energy", "XLE": "energy",
    # Financials
    "JPM": "financial", "BAC": "financial", "GS": "financial", "MS": "financial",
    "WFC": "financial", "C": "financial", "XLF": "financial",
    # Healthcare / pharma
    "LLY": "pharma", "UNH": "pharma", "JNJ": "pharma", "PFE": "pharma",
    "MRK": "pharma", "ABBV": "pharma", "XLV": "pharma",
    # EV / auto
    "TSLA": "ev-auto", "RIVN": "ev-auto", "LCID": "ev-auto", "F": "ev-auto",
    "GM": "ev-auto", "NIO": "ev-auto",
    # Consumer
    "WMT": "consumer", "HD": "consumer", "TGT": "consumer", "COST": "consumer",
    "NKE": "consumer", "SBUX": "consumer", "MCD": "consumer",
}


def _safe_read_json(path: Path, default):
    try:
        if not path.exists():
            return default
        return json.loads(path.read_text())
    except Exception:
        return default


def _today_et_str() -> str:
    """Best-options snapshots are keyed by ET date (UTC-4 standard)."""
    return (datetime.now(timezone.utc) + timedelta(hours=-4)).strftime("%Y-%m-%d")


def _read_best_options_today() -> list[dict]:
    # REVIVED: the dead best-options snapshot (BEST_OPTIONS_DIR, frozen May-11) is gone;
    # source the live merged flow stream instead, sorted by premium like the old archive.
    contracts = _live_flow_contracts()
    contracts.sort(key=lambda c: -(c.get("premium") or 0))
    return contracts


# ──────────────────────────────────────────────────────────────────────────────
# 1) PLATINUM MANDATE banner — hard gate on the unique 4-condition tier
# ──────────────────────────────────────────────────────────────────────────────

def platinum_mandate_banner(has_platinum: bool) -> str:
    if not has_platinum:
        return ""
    return (
        "\n🚨 **PLATINUM MANDATE ACTIVE THIS CYCLE**\n"
        "\n"
        "The Platinum tier (1–3% of all whale flow — premium ≥$10M + Vol≥5×OI + Sweep≥80% + DTE extreme) "
        "has at least one candidate below.\n"
        "\n"
        "**Hard rule (Bible 18.8):** Every NEW pick this cycle MUST come from the Platinum list, OR you must "
        "cite in `reasoning` the *specific* reason a non-Platinum candidate is superior (e.g. better R:R, "
        "better Kronos alignment, multi-source confluence). Picking a non-Platinum without explicit "
        "justification is treated as a violation of the unusual-flow priority rule.\n"
        "\n"
    )


# ──────────────────────────────────────────────────────────────────────────────
# 2) Multi-source confluence — same-ticker same-direction across N feeds in 4h
# ──────────────────────────────────────────────────────────────────────────────

def confluence_block(shortlist_tickers: list[str], window_hours: int = 4) -> str:
    if not shortlist_tickers:
        return ""

    cutoff = datetime.now(timezone.utc) - timedelta(hours=window_hours)
    cutoff_iso = cutoff.isoformat()

    def _is_bull(item) -> bool | None:
        """Return True/False direction, or None if unknown."""
        if not isinstance(item, dict):
            return None
        if "is_bullish" in item:
            return bool(item["is_bullish"])
        if "is_put" in item:
            return not bool(item["is_put"])
        # Heuristic from text fields
        for fld in ("action", "category", "direction"):
            v = (item.get(fld) or "").upper()
            if "BUY" in v or "BULL" in v or "CALL" in v:
                return True
            if "SELL" in v or "BEAR" in v or "PUT" in v:
                return False
        return None

    def _item_ts(item) -> str:
        return item.get("captured_at") or item.get("timestamp") or item.get("created_at") or ""

    # REVIVED: the firebase directive feeds are stale (May-11) / missing post-restructure.
    # Derive THREE genuinely-independent institutional signatures from the live flow stream:
    #   sweep_flow  — aggressive/urgent execution (multi-exchange sweeps)
    #   block_flow  — size/negotiated prints (block trades)
    #   repeat_flow — recurring conviction (same contract re-alerting)
    # A ticker agreeing across ≥2 of these = real confluence, not one signature double-counted.
    _live = _read_best_options_today()
    feeds: dict[str, list[dict]] = {
        "sweep_flow": [c for c in _live if (c.get("sweeps") or 0) >= 1],
        "block_flow": [c for c in _live if (c.get("blocks") or 0) >= 1],
        "repeat_flow": [c for c in _live if "repeat" in (c.get("alert_type") or "").lower()],
    }

    rows = []
    for ticker in shortlist_tickers:
        bull_sources = {}
        bear_sources = {}
        for src_name, items in feeds.items():
            if not isinstance(items, list):
                continue
            bull = 0
            bear = 0
            for it in items:
                if not isinstance(it, dict):
                    continue
                if (it.get("ticker") or "").upper() != ticker.upper():
                    continue
                ts = _item_ts(it)
                # Exclude items with a missing/corrupt timestamp (empty string) too —
                # otherwise `ts and ...` short-circuits and counts them as in-window.
                if not ts or ts < cutoff_iso:
                    continue
                d = _is_bull(it)
                if d is True:
                    bull += 1
                elif d is False:
                    bear += 1
            if bull >= 1:
                bull_sources[src_name] = bull
            if bear >= 1:
                bear_sources[src_name] = bear

        # Tally — biased side counts as "agreement" only if ≥2× the opposite
        bull_total = sum(bull_sources.values())
        bear_total = sum(bear_sources.values())
        # Skip rows where the ticker has no data in any feed — they clutter the prompt
        if bull_total == 0 and bear_total == 0:
            continue
        if bull_total >= max(2 * bear_total, 1) and bull_total >= 2:
            direction = "BULL"
            src_count = len(bull_sources)
            details = ", ".join(f"{s}×{n}" for s, n in bull_sources.items())
        elif bear_total >= max(2 * bull_total, 1) and bear_total >= 2:
            direction = "BEAR"
            src_count = len(bear_sources)
            details = ", ".join(f"{s}×{n}" for s, n in bear_sources.items())
        else:
            direction = "MIXED"
            src_count = len(set(list(bull_sources) + list(bear_sources)))
            details = (
                f"BULL: {', '.join(bull_sources) or 'none'} | "
                f"BEAR: {', '.join(bear_sources) or 'none'}"
            )
        rows.append((ticker, direction, src_count, details))

    if not rows:
        return ""

    # Sort: more sources first; BULL/BEAR before MIXED
    rows.sort(key=lambda r: (-r[2], 0 if r[1] != "MIXED" else 1))

    lines = [
        f"\n# 🎯 FLOW-SIGNATURE CONFLUENCE ({window_hours}h window — all 3 signatures agreeing = strong)",
        "# Signatures scanned (live flow): sweep_flow (urgent multi-exchange sweeps), block_flow (negotiated size), repeat_flow (recurring conviction).",
        "# A ticker with all 3 signatures agreeing direction = act as if upgraded one tier (T2 → T1, etc).",
    ]
    for ticker, direction, n, details in rows[:8]:
        emoji = "🟢" if direction == "BULL" else ("🔴" if direction == "BEAR" else "⚪")
        lines.append(f"  {emoji} **{ticker}** — {direction} ({n} sources) | {details}")
    return "\n".join(lines) + "\n"


# ──────────────────────────────────────────────────────────────────────────────
# 3) Fresh 5-min whale prints
# ──────────────────────────────────────────────────────────────────────────────

def fresh_flow_5min_block(window_minutes: int = 5) -> str:
    contracts = _read_best_options_today()
    if not contracts:
        return ""
    cutoff = (datetime.now(timezone.utc) - timedelta(minutes=window_minutes)).isoformat()
    fresh = [c for c in contracts if isinstance(c, dict) and (c.get("captured_at") or "") > cutoff]
    # Floor at T2 ($1M+)
    fresh = [c for c in fresh if (c.get("premium") or 0) >= 1_000_000]
    if not fresh:
        return ""
    fresh.sort(key=lambda c: -(c.get("premium") or 0))
    lines = [
        f"\n# 🔥 LAST {window_minutes} MINUTES — fresh institutional prints (T1/T2 only)",
        "# Recency in flow matters: morning institutional opens > 3:55 PM retail muppet flow.",
        "# Bias toward these if the broader confluence agrees direction.",
    ]
    for c in fresh[:8]:
        side = "C" if (c.get("option_type") or "?").upper().startswith("C") else "P"
        bull = "BULL" if c.get("is_bullish") else "BEAR"
        lines.append(
            f"  🔥 ${(c.get('premium') or 0)/1_000_000:>5.1f}M  {c.get('ticker','?'):5s} "
            f"${c.get('strike',0):.0f}{side} {c.get('expiry','?')} ({c.get('dte',0)}d) {bull} "
            f"| V:{c.get('volume',0):,} OI:{c.get('oi',0):,} Sw:{c.get('sweeps',0)}"
        )
    return "\n".join(lines) + "\n"


# ──────────────────────────────────────────────────────────────────────────────
# 4) Strike-range clusters — smart money playing a strike RANGE on one ticker
# ──────────────────────────────────────────────────────────────────────────────

def strike_cluster_block(min_strikes: int = 3) -> str:
    contracts = _read_best_options_today()
    if not contracts:
        return ""
    # T1+T2 only
    whale = [c for c in contracts
             if isinstance(c, dict) and c.get("tier") in ("T1_HUGE", "T2_UNUSUAL_HUGE")]
    by_ticker: dict[str, dict] = {}
    for c in whale:
        t = c.get("ticker") or "?"
        b = by_ticker.setdefault(t, {"strikes": set(), "total_prem": 0, "calls": 0, "puts": 0})
        b["strikes"].add((c.get("strike", 0), c.get("option_type", "?")))
        b["total_prem"] += c.get("premium") or 0
        if (c.get("option_type") or "").upper().startswith("C"):
            b["calls"] += 1
        else:
            b["puts"] += 1

    clusters = [(t, b) for t, b in by_ticker.items() if len(b["strikes"]) >= min_strikes]
    if not clusters:
        return ""
    clusters.sort(key=lambda x: -x[1]["total_prem"])

    lines = [
        f"\n# 📊 STRIKE-RANGE CLUSTERS (T1+T2, ≥{min_strikes} distinct strikes same ticker today)",
        "# Smart money playing a strike RANGE on one ticker = high-conviction directional/positioning thesis,",
        "# stronger than a single repeated contract. Bias toward these for new picks.",
    ]
    for t, b in clusters[:6]:
        strikes_str = ", ".join(
            f"${s:.0f}{ot[0].upper()}" for s, ot in sorted(b["strikes"])
        )[:120]
        bias = "BULL" if b["calls"] > b["puts"] else ("BEAR" if b["puts"] > b["calls"] else "MIXED")
        lines.append(
            f"  **{t}** — {len(b['strikes'])} strikes, ${b['total_prem']/1_000_000:.1f}M total, {bias} "
            f"({b['calls']}C/{b['puts']}P) | {strikes_str}"
        )
    return "\n".join(lines) + "\n"


# ──────────────────────────────────────────────────────────────────────────────
# 5) Sector mix warning — when 3+ picks fall in same sector
# ──────────────────────────────────────────────────────────────────────────────

def sector_mix_warning(shortlist_tickers: list[str], threshold: int = 3) -> str:
    if not shortlist_tickers:
        return ""
    counter = collections.Counter(SECTOR_MAP.get(t.upper(), "OTHER") for t in shortlist_tickers)
    if not counter:
        return ""
    top_sector, top_count = counter.most_common(1)[0]
    if top_sector == "OTHER" or top_count < threshold:
        return ""
    by_sector = ", ".join(f"{n}× {s}" for s, n in counter.most_common())
    return (
        f"\n# ⚠️ SECTOR CONCENTRATION — {top_count}/{len(shortlist_tickers)} shortlist in **{top_sector}**\n"
        f"# Mix: {by_sector}\n"
        f"# If you pick all from this sector you carry single-factor risk. "
        f"# Either justify the concentration (e.g. specific sector catalyst) "
        f"or rebalance one pick to a different sector ticker on the shortlist.\n"
    )


# ──────────────────────────────────────────────────────────────────────────────
# Convenience: assemble all blocks given shortlist + platinum existence
# ──────────────────────────────────────────────────────────────────────────────

# ──────────────────────────────────────────────────────────────────────────────
# 6) Catalyst awareness — earnings / Fed / CPI within next 48h
# ──────────────────────────────────────────────────────────────────────────────

CATALYSTS_FILE = Path("/home/ubuntu/.openclaw/data/catalysts.json")


def catalyst_block(shortlist_tickers: list[str] | None = None, window_hours: int = 48) -> str:
    """IV-CRUSH CALENDAR — REVIVED 2026-06-16.

    The old manual ~/.openclaw/data/catalysts.json is gone. Source the LIVE
    iv_forecast.json instead (built by the quantum lab's IV intelligence system):
    every pick flagged 'IV-CRUSH AHEAD' carries an event (earnings / FOMC), the
    event date (parsed from the verdict), and an expected vol-drop %. These are the
    exact long-premium traps Boba/Jazzy must avoid buying naked into.

    `window_hours` is ignored — vol events are typically weeks out but stay relevant
    for any contract whose expiry spans them. Shortlist tickers are flagged ⚠️.
    """
    import re
    data = _safe_read_json(IV_FORECAST_FILE, {})
    picks = (data.get("picks") if isinstance(data, dict) else None) or []
    if not picks:
        return ""

    shortlist = {t.upper() for t in (shortlist_tickers or [])}
    earnings: list[tuple[str, str]] = []   # (date_str, rendered)
    macro: list[tuple[str, str]] = []

    seen = set()
    for p in picks:
        if not isinstance(p, dict):
            continue
        crush = p.get("crush")
        if not isinstance(crush, dict) or not crush.get("event"):
            continue
        tk = str(p.get("ticker") or "").upper()
        event = str(crush.get("event") or "").lower()
        try:
            drop = float(crush.get("expectedDropPct") or 0)
        except (TypeError, ValueError):
            drop = 0.0
        drop_pct = f"-{drop*100:.0f}% vol crush" if drop else "vol crush"
        m = re.search(r"(\d{4}-\d{2}-\d{2})", str(p.get("verdict") or ""))
        date_str = m.group(1) if m else "9999-99-99"
        date_show = m.group(1) if m else "date TBD"
        key = (tk, event, date_str)
        if key in seen:
            continue
        seen.add(key)
        flag = "⚠️ " if tk in shortlist else ""
        if "earn" in event:
            earnings.append((date_str, f"{flag}{tk} earnings — {date_show} ({drop_pct})"))
        else:
            label = event.upper()
            macro.append((date_str, f"{flag}{tk}: {label} — {date_show} ({drop_pct})"))

    if not (earnings or macro):
        return ""

    earnings.sort(key=lambda x: x[0])
    macro.sort(key=lambda x: x[0])

    lines = ["\n# 📅 IV-CRUSH CALENDAR (live IV-forecast — vol events ahead; don't buy naked premium into these)"]
    if earnings:
        lines.append("\n**Earnings (vol collapses after the print):**")
        lines.extend(f"  - {r}" for _, r in earnings[:12])
    if macro:
        lines.append("\n**Macro / rate events:**")
        lines.extend(f"  - {r}" for _, r in macro[:8])
    lines.append(
        "\n**Rule:** if a shortlist ticker has a vol-crush event inside the contract's expiry window, "
        "prefer a debit spread / premium-selling structure, OR size down 50% and tighten stop. "
        "Long calls/puts pay rich vol that collapses on the event."
    )
    return "\n".join(lines) + "\n"


# ──────────────────────────────────────────────────────────────────────────────
# Convenience: assemble all blocks given shortlist + platinum existence
# ──────────────────────────────────────────────────────────────────────────────

def assemble_enhancements(shortlist_tickers: list[str], platinum_count: int = 0) -> str:
    """One-liner for the patch — concatenates all enhancement blocks."""
    parts = [
        platinum_mandate_banner(platinum_count > 0),
        confluence_block(shortlist_tickers),
        fresh_flow_5min_block(),
        strike_cluster_block(),
        catalyst_block(shortlist_tickers),
        sector_mix_warning(shortlist_tickers),
    ]
    return "".join(p for p in parts if p)


if __name__ == "__main__":
    # Self-test
    import sys
    tickers = sys.argv[1:] or ["NVDA", "SPY", "TSLA", "MU", "QQQ"]
    out = assemble_enhancements(tickers, platinum_count=1)
    print(out or "(no enhancement output — feeds may be empty)")
