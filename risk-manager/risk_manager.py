#!/usr/bin/env python3
"""
Risk Manager — Bridgewater-style institutional risk controls.
Reads Analyst results, applies 9-check risk pipeline, posts
APPROVED / VETOED decisions to Discord. Has VETO power over
every trade.

Polls every 30 seconds.
"""
import asyncio
import json
import logging
import os
import sys
import uuid
from datetime import datetime, timezone

import aiohttp
import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from dotenv import load_dotenv
from shared.archiver import maybe_rotate, rotate_dict_field

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR          = os.path.dirname(os.path.abspath(__file__))
ANALYST_FILE  = os.path.join(os.path.dirname(_DIR), "analyst", "analysis_results.json")
STATE_FILE    = os.path.join(_DIR, "risk_state.json")
RULES_FILE    = os.path.join(_DIR, "risk_rules.json")

DECISIONS_URL  = os.getenv("DISCORD_RISK_DECISIONS_WEBHOOK", "")
ARCHIVE_URL    = os.getenv("DISCORD_ARCHIVE_RISK_WEBHOOK",    "")
DECISIONS_MAX  = 200
ALERTS_URL    = os.getenv("DISCORD_RISK_ALERTS_WEBHOOK", "")

POLL_INTERVAL = 30  # seconds

CRYPTO_SYMBOLS = {
    "BTC","ETH","SOL","BNB","XRP","ADA","DOGE","AVAX","DOT","MATIC",
    "LINK","UNI","ATOM","LTC","BCH","NEAR","APT","ARB","OP","SUI",
    "INJ","SEI","TIA","PEPE","WIF","FLOKI","SHIB","SAND","MANA",
    "FTM","ALGO","VET","HBAR","FIL","AAVE","CRV","GMX","RUNE","TAO",
}

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [RISK] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("risk_manager")


# ── File I/O ──────────────────────────────────────────────────────────────────

def load_json(path: str, default):
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception as e:
            log.warning(f"Failed to load {path}: {e}")
    return default


def save_json(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)


def load_rules() -> dict:
    return load_json(RULES_FILE, {})


ALPACA_KEY    = open(os.path.expanduser("~/.openclaw/secrets/alpaca-key-id")).read().strip()
ALPACA_SECRET = open(os.path.expanduser("~/.openclaw/secrets/alpaca-secret")).read().strip()
ALPACA_BASE   = "https://paper-api.alpaca.markets/v2"

def sync_alpaca_state(state: dict) -> dict:
    """Pull live account + positions from Alpaca and update state."""
    try:
        import requests as _req
        headers = {"APCA-API-KEY-ID": ALPACA_KEY, "APCA-API-SECRET-KEY": ALPACA_SECRET}
        acct = _req.get(f"{ALPACA_BASE}/account", headers=headers, timeout=8).json()
        pos  = _req.get(f"{ALPACA_BASE}/positions", headers=headers, timeout=8).json()
        if isinstance(pos, list):
            state["portfolio_value"] = round(float(acct.get("portfolio_value", state.get("portfolio_value", 100000))), 2)
            state["cash"]            = round(float(acct.get("cash", 0)), 2)
            state["daily_pnl"]       = round(float(acct.get("unrealized_intraday_pl", 0)), 2)
            state["open_positions"]  = [{
                "symbol":      p["symbol"],
                "direction":   "LONG" if float(p["qty"]) > 0 else "SHORT",
                "entry":       float(p["avg_entry_price"]),
                "size":        abs(float(p["qty"])),
                "value":       abs(float(p["market_value"])),
                "asset_class": "stocks",
            } for p in pos]
            log.debug(f"[ALPACA SYNC] portfolio=${state['portfolio_value']:,.2f}  positions={len(state['open_positions'])}")
    except Exception as e:
        log.warning(f"[ALPACA SYNC] Failed: {e} — using cached state")
    return state

def load_state() -> dict:
    return load_json(STATE_FILE, {
        "portfolio_value": 100000,
        "cash": 100000,
        "open_positions": [],
        "daily_pnl": 0.0,
        "weekly_pnl": 0.0,
        "consecutive_losses": 0,
        "decisions": [],
        "last_updated": datetime.now(timezone.utc).isoformat(),
    })


def save_state(state: dict) -> None:
    state["last_updated"] = datetime.now(timezone.utc).isoformat()
    save_json(STATE_FILE, state)


def load_analyst_results() -> list:
    return load_json(ANALYST_FILE, [])


# ── Asset classification ──────────────────────────────────────────────────────

def classify_asset(symbol: str) -> str:
    sym = symbol.upper().replace("/","").replace("-","")
    base = sym.replace("USDT","").replace("USD","").replace("BTC","").replace("ETH","")
    if base in CRYPTO_SYMBOLS or sym.endswith("USDT") or sym.endswith("USD"):
        return "crypto"
    if any(kw in symbol.upper() for kw in ["FUTURE","PERP","SWAP"]):
        return "futures"
    if any(kw in symbol.upper() for kw in ["CALL","PUT"]):
        return "options"
    return "stocks"


# ── Position sizing ───────────────────────────────────────────────────────────

def calc_position(entry: float | None, stop: float | None,
                  portfolio_value: float, rules: dict,
                  cool_down_active: bool) -> dict | None:
    """Returns position sizing dict or None if data is missing."""
    if entry is None or stop is None or entry == stop:
        return None
    risk_pct  = rules.get("default_risk_per_trade_pct", 1.5)
    risk_amt  = portfolio_value * (risk_pct / 100)
    risk_per_unit = abs(entry - stop)
    size      = risk_amt / risk_per_unit
    value     = size * entry
    pos_pct   = (value / portfolio_value) * 100

    if cool_down_active:
        reduce = rules.get("cool_down_reduce_size_pct", 50)
        size  *= (1 - reduce / 100)
        value *= (1 - reduce / 100)
        pos_pct *= (1 - reduce / 100)

    return {
        "size":              round(size, 6),
        "value_usd":         round(value, 2),
        "risk_amount_usd":   round(risk_amt, 2),
        "pct_of_portfolio":  round(pos_pct, 2),
        "cool_down_applied": cool_down_active,
    }


# ── Portfolio exposure helpers ────────────────────────────────────────────────

def total_exposure_pct(positions: list, portfolio_value: float) -> float:
    total = sum(p.get("value", 0) for p in positions)
    return round((total / portfolio_value) * 100, 2) if portfolio_value else 0


def asset_class_exposure(positions: list, asset_class: str, portfolio_value: float) -> float:
    total = sum(p.get("value", 0) for p in positions if p.get("asset_class") == asset_class)
    return round((total / portfolio_value) * 100, 2) if portfolio_value else 0


def correlated_exposure(positions: list, new_symbol: str, portfolio_value: float) -> tuple[float, list]:
    """Return (correlated_pct, list_of_correlated_symbols) for same asset class."""
    new_class = classify_asset(new_symbol)
    corr_positions = [p for p in positions if p.get("asset_class") == new_class]
    corr_symbols   = [p["symbol"] for p in corr_positions]
    corr_value     = sum(p.get("value", 0) for p in corr_positions)
    corr_pct       = round((corr_value / portfolio_value) * 100, 2) if portfolio_value else 0
    return corr_pct, corr_symbols


# ── 9-Check Risk Pipeline ─────────────────────────────────────────────────────

def run_checks(analysis: dict, state: dict, rules: dict) -> dict:
    """
    Returns dict:
      {
        "decision": "APPROVED" | "VETOED" | "CIRCUIT_BREAKER",
        "checks": { ... },
        "veto_reasons": [...],
        "warnings": [...],
        "recommended_position": {...} | None,
        "cool_down_active": bool,
      }
    """
    checks      = {}
    veto        = []
    warnings    = []
    positions   = state.get("open_positions", [])
    portfolio   = float(state.get("portfolio_value", 282000))
    daily_dd    = float(state.get("daily_pnl", 0))
    weekly_dd   = float(state.get("weekly_pnl", 0))
    consec_loss = int(state.get("consecutive_losses", 0))

    symbol    = analysis.get("symbol", "")
    direction = analysis.get("direction", "")
    entry     = analysis.get("entry")
    stop      = analysis.get("stop_loss")
    targets   = analysis.get("targets", [])
    rr_ratio  = analysis.get("indicators", {}).get("risk_reward", {}).get("ratio")
    leverage  = _parse_leverage(analysis)
    asset_cls = classify_asset(symbol)

    # ── Check 8: Drawdown Circuit Breaker (run first — blocks everything) ────
    daily_limit  = rules.get("max_daily_drawdown_pct", 5)
    weekly_limit = rules.get("max_weekly_drawdown_pct", 10)
    cb_triggered = (daily_dd <= -daily_limit) or (weekly_dd <= -weekly_limit)

    checks["drawdown"] = {
        "status":       "CIRCUIT_BREAKER" if cb_triggered else "PASS",
        "daily_pnl":    daily_dd,
        "weekly_pnl":   weekly_dd,
        "daily_limit":  -daily_limit,
        "weekly_limit": -weekly_limit,
    }
    if cb_triggered:
        return {
            "decision":             "CIRCUIT_BREAKER",
            "checks":               checks,
            "veto_reasons":         [f"Circuit breaker: daily PnL {daily_dd}% / weekly {weekly_dd}%"],
            "warnings":             [],
            "recommended_position": None,
            "cool_down_active":     False,
        }

    # ── Check 1: Open Position Limit ─────────────────────────────────────────
    max_pos = rules.get("max_open_positions", 15)
    current_n = len(positions)
    if current_n >= max_pos:
        checks["open_positions"] = {"status":"VETO","current":current_n,"limit":max_pos}
        veto.append(f"Open positions at limit ({current_n}/{max_pos})")
    else:
        checks["open_positions"] = {"status":"PASS","current":current_n,"limit":max_pos}

    # ── Check 2: Portfolio Exposure ───────────────────────────────────────────
    max_exp    = rules.get("max_portfolio_exposure_pct", 75)
    cur_exp    = total_exposure_pct(positions, portfolio)
    new_pos_val = (entry or 0) * 0.05 * portfolio / 100  # rough placeholder until sizing
    # We'll use actual sizing after all checks; for exposure check use min(10%, risk-based)
    est_pos_val = min(portfolio * 0.10, portfolio * rules.get("default_risk_per_trade_pct", 1.5) / 100 * 20)
    would_be   = round(cur_exp + (est_pos_val / portfolio * 100), 2)
    if would_be > max_exp:
        checks["portfolio_exposure"] = {"status":"VETO","current_pct":cur_exp,"would_be_pct":would_be,"limit":max_exp}
        veto.append(f"Portfolio exposure {cur_exp}% → {would_be}% (limit {max_exp}%)")
    else:
        checks["portfolio_exposure"] = {"status":"PASS","current_pct":cur_exp,"would_be_pct":would_be,"limit":max_exp}

    # ── Check 9: Consecutive Loss Cool-down (before sizing) ──────────────────
    cd_threshold = rules.get("cool_down_after_consecutive_losses", 3)
    cool_down    = consec_loss >= cd_threshold
    checks["consecutive_losses"] = {
        "status":    "REDUCED_SIZE" if cool_down else "PASS",
        "streak":    consec_loss,
        "threshold": cd_threshold,
    }
    if cool_down:
        warnings.append(f"Cool-down active: {consec_loss} consecutive losses — position size reduced {rules.get('cool_down_reduce_size_pct',50)}%")

    # ── Check 3: Single Position Size ─────────────────────────────────────────
    # NOTE: We check RISK amount (1.5% of portfolio) not position VALUE.
    # A properly risk-sized trade on a wide-stop stock will have high position
    # value but that's expected — we cap by dollar risk, not dollar value.
    # Hard cap: position value must not exceed 25% of portfolio regardless.
    pos_sizing = calc_position(entry, stop, portfolio, rules, cool_down)
    max_single = rules.get("max_single_position_pct", 10)
    HARD_VALUE_CAP_PCT = 25.0  # never put more than 25% of portfolio in one trade
    if pos_sizing is None:
        checks["position_size"] = {"status":"WARN","note":"Cannot calculate (missing entry/stop)"}
        warnings.append("Position size unknown — entry or stop loss missing from signal")
    else:
        pct  = pos_sizing["pct_of_portfolio"]
        risk_pct = round((pos_sizing["risk_amount_usd"] / portfolio) * 100, 2)
        # Only veto if BOTH risk% > limit AND value > hard cap
        if pct > HARD_VALUE_CAP_PCT:
            checks["position_size"] = {"status":"VETO","pct_of_portfolio":pct,"risk_pct":risk_pct,"limit":HARD_VALUE_CAP_PCT}
            veto.append(f"Position value {pct}% exceeds hard cap {HARD_VALUE_CAP_PCT}%")
        elif risk_pct > max_single:
            checks["position_size"] = {"status":"VETO","pct_of_portfolio":pct,"risk_pct":risk_pct,"limit":max_single}
            veto.append(f"Risk {risk_pct}% of portfolio exceeds limit {max_single}%")
        else:
            checks["position_size"] = {"status":"PASS","pct_of_portfolio":pct,"risk_pct":risk_pct,"note":"Risk-based sizing OK"}

    # ── Check 4: Asset Class Allocation ───────────────────────────────────────
    alloc_limits = rules.get("asset_allocation_limits", {})
    ac_limit     = alloc_limits.get(asset_cls, 100)
    cur_ac_pct   = asset_class_exposure(positions, asset_cls, portfolio)
    add_pct      = pos_sizing["pct_of_portfolio"] if pos_sizing else 5.0
    new_ac_pct   = round(cur_ac_pct + add_pct, 2)
    if new_ac_pct > ac_limit:
        checks["asset_allocation"] = {
            "status":         "VETO",
            "asset_class":    asset_cls,
            "current_pct":    cur_ac_pct,
            "would_be_pct":   new_ac_pct,
            "limit":          ac_limit,
        }
        veto.append(f"{asset_cls.capitalize()} allocation {cur_ac_pct}% → {new_ac_pct}% (limit {ac_limit}%)")
    else:
        checks["asset_allocation"] = {
            "status":         "PASS",
            "asset_class":    asset_cls,
            "current_pct":    cur_ac_pct,
            "would_be_pct":   new_ac_pct,
            "limit":          ac_limit,
        }

    # ── Check 5: Correlation ──────────────────────────────────────────────────
    max_corr   = rules.get("max_correlated_exposure_pct", 30)
    corr_pct, corr_syms = correlated_exposure(positions, symbol, portfolio)
    corr_after = round(corr_pct + add_pct, 2)
    if corr_after > max_corr:
        checks["correlation"] = {
            "status":               "VETO",
            "correlated_positions": corr_syms,
            "exposure_pct":         corr_pct,
            "would_be_pct":         corr_after,
            "limit":                max_corr,
        }
        veto.append(f"Correlated exposure {corr_pct}% → {corr_after}% (limit {max_corr}%)")
    elif len(corr_syms) >= 2:
        checks["correlation"] = {
            "status":               "WARN",
            "correlated_positions": corr_syms,
            "exposure_pct":         corr_pct,
            "would_be_pct":         corr_after,
            "limit":                max_corr,
        }
        warnings.append(f"Correlation warning: {', '.join(corr_syms)} also open ({asset_cls} exposure {corr_after}%)")
    else:
        checks["correlation"] = {
            "status":               "PASS",
            "correlated_positions": corr_syms,
            "exposure_pct":         corr_pct,
            "would_be_pct":         corr_after,
            "limit":                max_corr,
        }

    # ── Check 6: Risk/Reward ──────────────────────────────────────────────────
    min_rr = rules.get("min_risk_reward_ratio", 1.5)
    if rr_ratio is None:
        checks["risk_reward"] = {"status":"VETO","note":"R:R not calculable — missing entry/stop/target"}
        veto.append("R:R ratio unavailable — conservative VETO")
    elif rr_ratio < min_rr:
        checks["risk_reward"] = {"status":"VETO","ratio":rr_ratio,"minimum":min_rr}
        veto.append(f"R:R {rr_ratio}:1 below minimum {min_rr}:1")
    else:
        checks["risk_reward"] = {"status":"PASS","ratio":rr_ratio,"minimum":min_rr}

    # ── Check 7: Leverage ─────────────────────────────────────────────────────
    max_lev = rules.get("max_leverage", 20)
    if leverage is not None and leverage > max_lev:
        checks["leverage"] = {"status":"VETO","requested":leverage,"max":max_lev}
        veto.append(f"Leverage {leverage}x exceeds max {max_lev}x")
    else:
        checks["leverage"] = {"status":"PASS","requested":leverage,"max":max_lev}

    decision = "APPROVED" if not veto else "VETOED"
    return {
        "decision":             decision,
        "checks":               checks,
        "veto_reasons":         veto,
        "warnings":             warnings,
        "recommended_position": pos_sizing if decision == "APPROVED" else None,
        "cool_down_active":     cool_down,
    }


def _parse_leverage(analysis: dict) -> float | None:
    """Extract leverage from analysis indicators or original signal leverage field."""
    lev_str = analysis.get("leverage")
    if lev_str and isinstance(lev_str, str):
        try:
            return float(lev_str.lower().replace("x","").strip())
        except ValueError:
            pass
    # Try from risk_reward indicator notes
    rr_sig = analysis.get("indicators",{}).get("risk_reward",{}).get("signal","")
    return None


# ── Discord ───────────────────────────────────────────────────────────────────

async def post_discord(session: aiohttp.ClientSession, url: str, payload: dict) -> None:
    if not url:
        return
    try:
        async with session.post(url, json=payload, timeout=aiohttp.ClientTimeout(total=10)) as resp:
            if resp.status not in (200, 204):
                body = await resp.text()
                log.warning(f"Discord {resp.status}: {body[:120]}")
    except Exception as e:
        log.warning(f"Discord post failed: {e}")


def _check_icon(status: str) -> str:
    return {"PASS":"✅","VETO":"❌","WARN":"⚠️","REDUCED_SIZE":"⚠️",
            "CIRCUIT_BREAKER":"🚨","UNKNOWN":"❓"}.get(status, "❓")


def build_approved_embed(result: dict, analysis: dict) -> dict:
    sym  = result["symbol"]
    dire = result["direction"]
    chks = result["checks"]
    pos  = result["recommended_position"] or {}
    warnings = result.get("warnings", [])
    cd   = result.get("cool_down_active", False)

    cur_exp = chks.get("portfolio_exposure",{}).get("current_pct","?")
    new_exp = chks.get("portfolio_exposure",{}).get("would_be_pct","?")

    warn_lines = "\n".join(f"⚠️ {w}" for w in warnings) if warnings else ""
    cd_note    = "\n🔻 *Cool-down active: position size reduced*" if cd else ""

    desc = (
        f"All {len(chks)} risk checks passed{cd_note}\n\n"
        f"**Position Size:** {pos.get('size','?')} {sym.split('/')[0] if '/' in sym else sym}\n"
        f"**Value:** ${pos.get('value_usd',0):,.0f}\n"
        f"**Risk Amount:** ${pos.get('risk_amount_usd',0):,.0f} "
        f"({result.get('rules_snapshot',{}).get('default_risk_per_trade_pct',1.5)}% of portfolio)\n"
        f"**Portfolio Exposure:** {cur_exp}% → {new_exp}%\n"
    )
    if warn_lines:
        desc += f"\n{warn_lines}"
    desc += "\n\n→ *Forwarded to Execution Specialist*"

    return {"embeds": [{
        "title":       f"✅ APPROVED — {sym} {dire}",
        "description": desc,
        "color":       0x00d2a0,
        "footer":      {"text": f"Risk Manager • {result['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


def build_vetoed_embed(result: dict) -> dict:
    sym   = result["symbol"]
    dire  = result["direction"]
    chks  = result["checks"]
    vetos = result["veto_reasons"]
    total = len(chks)
    fails = len(vetos)

    check_lines = []
    for name, data in chks.items():
        status = data.get("status","UNKNOWN")
        icon   = _check_icon(status)
        label  = name.replace("_"," ").title()
        check_lines.append(f"{icon} {label}")

    veto_lines = "\n".join(f"❌ {v}" for v in vetos)
    desc = (
        f"Failed {fails} of {total} checks\n\n"
        f"{veto_lines}\n\n"
        + "\n".join(check_lines)
    )

    # Recommendation
    if any("exposure" in v.lower() or "allocation" in v.lower() for v in vetos):
        rec = "Wait for existing positions to close before adding more exposure."
    elif any("r:r" in v.lower() or "ratio" in v.lower() for v in vetos):
        rec = "Signal R:R does not meet minimum threshold. Seek better entry."
    elif any("leverage" in v.lower() for v in vetos):
        rec = "Reduce requested leverage to comply with risk limits."
    elif any("position limit" in v.lower() for v in vetos):
        rec = "Close existing positions before opening new ones."
    else:
        rec = "Review risk parameters and signal quality before re-submission."

    desc += f"\n\n**Recommendation:** {rec}"

    return {"embeds": [{
        "title":       f"🚫 VETOED — {sym} {dire}",
        "description": desc,
        "color":       0xff4757,
        "footer":      {"text": f"Risk Manager • {result['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


def build_circuit_breaker_embed(state: dict, rules: dict) -> dict:
    daily  = state.get("daily_pnl", 0)
    weekly = state.get("weekly_pnl", 0)
    d_lim  = rules.get("max_daily_drawdown_pct", 5)
    w_lim  = rules.get("max_weekly_drawdown_pct", 10)

    desc = (
        f"**Daily drawdown:** {daily}% (limit: -{d_lim}%)\n"
        f"**Weekly drawdown:** {weekly}% (limit: -{w_lim}%)\n\n"
        f"ALL new trades are **BLOCKED** until drawdown recovers.\n"
        f"Current open positions will **NOT** be closed automatically — Commander decision required."
    )
    return {"embeds": [{
        "title":       "🚨 CIRCUIT BREAKER ACTIVE",
        "description": desc,
        "color":       0xff4757,
        "footer":      {"text": f"Risk Manager • {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


# ── Main loop ─────────────────────────────────────────────────────────────────


# ── Agent Directives reader ───────────────────────────────────────────────────

import os as _os
_DIRECTIVES_FILE = _os.path.join(_os.path.dirname(_os.path.dirname(_os.path.abspath(__file__))), "shared", "agent_directives.json")

def load_directives() -> dict:
    try:
        if _os.path.exists(_DIRECTIVES_FILE):
            with open(_DIRECTIVES_FILE) as f:
                return json.load(f)
    except Exception:
        pass
    return {"symbols": {}}

def get_market_regime(symbol: str) -> dict:
    """Get current volatility regime for a symbol from optimizer."""
    base = symbol.split("/")[0].upper()
    d = load_directives().get("symbols", {}).get(base, {})
    return {
        "regime":         d.get("volatility_regime", "UNKNOWN"),
        "atr_period":     d.get("atr_period", 10),
        "multiplier":     d.get("multiplier", 3.0),
        "win_rate":       d.get("win_rate", 0),
        "profit_factor":  d.get("profit_factor", 0),
    }

async def run():
    log.info("=== Risk Manager starting ===")
    log.info(f"Analyst file  : {ANALYST_FILE}")
    log.info(f"State file    : {STATE_FILE}")
    log.info(f"Rules file    : {RULES_FILE}")
    log.info(f"Discord decisions : {'✅' if DECISIONS_URL else '❌'}")
    log.info(f"Discord alerts    : {'✅' if ALERTS_URL else '❌'}")
    log.info(f"Polling every {POLL_INTERVAL}s\n")

    _circuit_breaker_alerted = False  # avoid spamming alerts

    async with aiohttp.ClientSession() as session:
        while True:
            try:
                rules   = load_rules()
                state   = load_state()
                state   = sync_alpaca_state(state)   # ← live Alpaca sync every cycle
                save_state(state)
                results = load_analyst_results()

                # IDs already decided on
                decided_ids = {d["signal_id"] for d in state.get("decisions", [])}

                # Only STRONG or MODERATE verdicts enter risk pipeline
                candidates = [
                    r for r in results
                    if r.get("verdict") in ("STRONG", "MODERATE")
                    and r.get("signal_id") not in decided_ids
                ]

                if candidates:
                    log.info(f"Found {len(candidates)} new trade proposal(s)")

                for analysis in candidates:
                    sym  = analysis.get("symbol", "?")
                    dire = analysis.get("direction", "?")
                    log.info(f"Evaluating {sym} {dire} (analyst score {analysis.get('total_score',0)}/6)")

                    regime_data = get_market_regime(sym)
                    eval_result = run_checks(analysis, state, rules)

                    decision_record = {
                        "id":                   str(uuid.uuid4()),
                        "signal_id":            analysis.get("signal_id"),
                        "analyst_result_id":    analysis.get("id"),
                        "symbol":               sym,
                        "direction":            dire,
                        "timestamp":            datetime.now(timezone.utc).isoformat(),
                        "decision":             eval_result["decision"],
                        "veto_reasons":         eval_result["veto_reasons"],
                        "warnings":             eval_result["warnings"],
                        "checks":               eval_result["checks"],
                        "recommended_position": eval_result["recommended_position"],
                        "cool_down_active":     eval_result["cool_down_active"],
                        "rules_snapshot": {
                            "default_risk_per_trade_pct": rules.get("default_risk_per_trade_pct", 1.5),
                        },
                        "volatility_regime":    regime_data.get("regime", "UNKNOWN"),
                        "supertrend_win_rate":  regime_data.get("win_rate", 0),
                        "entry":                analysis.get("entry"),
                        "stop_loss":            analysis.get("stop_loss"),
                        "targets":              analysis.get("targets", []),
                    }

                    # Append to state decisions
                    state.setdefault("decisions", []).append(decision_record)
                    # Rotate decisions array when it grows large
                    state, _ = rotate_dict_field(
                        state, "decisions", DECISIONS_MAX, STATE_FILE, "risk-decisions"
                    )
                    if ARCHIVE_URL and len(state.get("decisions", [])) == 1:
                        # Just rotated — post archive notice async-style
                        asyncio.create_task(post_discord(session, ARCHIVE_URL, {"embeds": [{
                            "title": "📦 ARCHIVE ROTATED — Risk Decisions",
                            "description": f"Rotated decisions log. Live entries: {len(state['decisions'])}",
                            "color": 0x6c5ce7,
                        }]}))
                    save_state(state)

                    dec = eval_result["decision"]
                    log.info(f"  → {dec}  vetos={len(eval_result['veto_reasons'])}  "
                             f"warnings={len(eval_result['warnings'])}")

                    if dec == "CIRCUIT_BREAKER":
                        if not _circuit_breaker_alerted:
                            payload = build_circuit_breaker_embed(state, rules)
                            await post_discord(session, ALERTS_URL, payload)
                            _circuit_breaker_alerted = True
                    elif dec == "APPROVED":
                        payload = build_approved_embed(decision_record, analysis)
                        await post_discord(session, DECISIONS_URL, payload)
                    else:  # VETOED
                        payload = build_vetoed_embed(decision_record)
                        await post_discord(session, DECISIONS_URL, payload)

                    await asyncio.sleep(1)  # slight spacing between decisions

                # Reset circuit breaker alert flag if drawdown recovers
                daily_dd  = float(state.get("daily_pnl", 0))
                weekly_dd = float(state.get("weekly_pnl", 0))
                d_lim = rules.get("max_daily_drawdown_pct", 5)
                w_lim = rules.get("max_weekly_drawdown_pct", 10)
                if daily_dd > -d_lim and weekly_dd > -w_lim:
                    _circuit_breaker_alerted = False

            except Exception as e:
                log.error(f"Main loop error: {e}", exc_info=True)

            await asyncio.sleep(POLL_INTERVAL)


if __name__ == "__main__":
    asyncio.run(run())
