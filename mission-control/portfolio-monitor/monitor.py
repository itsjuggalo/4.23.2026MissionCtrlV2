#!/usr/bin/env python3
"""
Portfolio Monitor — BlackRock Aladdin-style unified portfolio view.
READ-ONLY. Collects positions from risk_state.json, fetches live prices,
calculates P&L, detects alerts, writes portfolio_state.json and
portfolio_history.json.

Cycle:  every 5 minutes  → update state + detect alerts
Discord: every 30 minutes → summary post to #portfolio-status
         immediately      → alerts to #portfolio-rebalance
"""
import asyncio
import json
import logging
import os
import sys
import time
from datetime import datetime, timezone

import aiohttp
import requests
import yfinance as yf
import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR          = os.path.dirname(os.path.abspath(__file__))
_ROOT         = os.path.dirname(_DIR)

# ── Alpaca live data ──────────────────────────────────────────────────────────
_secrets = os.path.expanduser("~/.openclaw/secrets")
try:
    ALPACA_KEY    = open(os.path.join(_secrets, "alpaca-key-id")).read().strip()
    ALPACA_SECRET = open(os.path.join(_secrets, "alpaca-secret")).read().strip()
    ALPACA_BASE   = "https://paper-api.alpaca.markets/v2"
    ALPACA_DATA   = "https://data.alpaca.markets/v2"
    ALPACA_HDR    = {"APCA-API-KEY-ID": ALPACA_KEY, "APCA-API-SECRET-KEY": ALPACA_SECRET}
    ALPACA_OK     = True
except Exception:
    ALPACA_OK = False

def fetch_alpaca_account():
    """Pull live account value, cash, P&L from Alpaca."""
    if not ALPACA_OK:
        return None
    try:
        r = requests.get(f"{ALPACA_BASE}/account", headers=ALPACA_HDR, timeout=8)
        return r.json()
    except Exception as e:
        log.warning(f"Alpaca account fetch failed: {e}")
        return None

def fetch_alpaca_positions():
    """Pull real open positions with live P&L from Alpaca."""
    if not ALPACA_OK:
        return None
    try:
        r = requests.get(f"{ALPACA_BASE}/positions", headers=ALPACA_HDR, timeout=8)
        pos = r.json()
        if not isinstance(pos, list):
            return None
        return pos
    except Exception as e:
        log.warning(f"Alpaca positions fetch failed: {e}")
        return None

def fetch_alpaca_price(symbol: str) -> float | None:
    """Get latest stock price from Alpaca data API."""
    if not ALPACA_OK:
        return None
    try:
        r = requests.get(f"{ALPACA_DATA}/stocks/{symbol}/quotes/latest",
                         headers=ALPACA_HDR, timeout=8)
        q = r.json().get("quote", {})
        ask, bid = float(q.get("ap", 0)), float(q.get("bp", 0))
        if ask > 0 and bid > 0:
            return round((ask + bid) / 2, 4)
    except Exception:
        pass
    return None

RISK_STATE    = os.path.join(_ROOT, "risk-manager",   "risk_state.json")
MACRO_STATE   = os.path.join(_ROOT, "macro-strategist","macro_state.json")
PORT_STATE    = os.path.join(_DIR,  "portfolio_state.json")
PORT_HISTORY  = os.path.join(_DIR,  "portfolio_history.json")

STATUS_URL    = os.getenv("DISCORD_PORTFOLIO_STATUS_WEBHOOK",    "")
REBALANCE_URL = os.getenv("DISCORD_PORTFOLIO_REBALANCE_WEBHOOK", "")
ARCHIVE_URL   = os.getenv("DISCORD_ARCHIVE_PORTFOLIO_WEBHOOK",   "")
HISTORY_MAX   = 500

POLL_INTERVAL      = 5 * 60   # 5 minutes
DISCORD_INTERVAL   = 30 * 60  # 30 minutes
MAX_HISTORY        = 500
STOP_WARN_PCT      = 1.0   # % distance to stop  → HIGH alert
TARGET_WARN_PCT    = 1.0   # % distance to target → MEDIUM alert
LOSS_WARN_PCT      = 3.0   # % unrealized loss    → HIGH alert
DRAWDOWN_WARN_PCT  = 3.0   # % from daily high    → HIGH alert
STALE_DAYS         = 7     # days open, <1% move  → LOW alert
YF_DELAY           = 1.0   # seconds between yfinance calls

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [PORTFOLIO] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("portfolio")


# ── Helpers ───────────────────────────────────────────────────────────────────

def load_json(path: str, default):
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception as e:
            log.warning(f"Could not load {path}: {e}")
    return default


def save_json(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)


def pct(a, b) -> float | None:
    """Safe percent: (a-b)/b * 100"""
    if b and b != 0:
        return round((a - b) / abs(b) * 100, 4)
    return None


def classify_asset(symbol: str) -> str:
    sym = symbol.upper().replace("/", "").replace("-", "")
    if sym.endswith("USDT") or sym.endswith("USD"):
        return "crypto"
    known_crypto = {
        "BTC","ETH","SOL","BNB","XRP","ADA","DOGE","AVAX","DOT","MATIC",
        "LINK","UNI","ATOM","LTC","BCH","NEAR","APT","ARB","OP","SUI",
        "INJ","SEI","TIA","PEPE","WIF","SHIB","FTM","ALGO","VET","HBAR",
        "FIL","AAVE","CRV","TAO","RDNT","ZEN","ONT","LRC","JST",
    }
    base = sym.replace("USDT","").replace("USD","")
    if base in known_crypto:
        return "crypto"
    return "stocks"


# ── Price Fetchers ────────────────────────────────────────────────────────────

def okx_inst_id(symbol: str) -> str:
    """Convert BTC/USDT or BTC or BTCUSDT → BTC-USDT for OKX."""
    sym = symbol.upper().replace("/","").replace("-","").strip()
    if sym.endswith("USDT"):
        return f"{sym[:-4]}-USDT"
    if sym.endswith("USD"):
        return f"{sym[:-3]}-USD"
    return f"{sym}-USDT"


def fetch_crypto_prices(symbols: list[str]) -> dict[str, float | None]:
    """Batch-fetch prices from OKX spot tickers."""
    prices: dict[str, float | None] = {}
    for sym in symbols:
        inst = okx_inst_id(sym)
        # Try spot first
        for inst_id in [inst, inst.replace("-USDT", "-USDT-SWAP")]:
            try:
                r = requests.get(
                    "https://www.okx.com/api/v5/market/ticker",
                    params={"instId": inst_id},
                    timeout=8,
                )
                r.raise_for_status()
                data = r.json()
                if data.get("data"):
                    prices[sym] = float(data["data"][0]["last"])
                    break
            except Exception:
                pass
        if sym not in prices:
            prices[sym] = None
            log.warning(f"  Price fetch failed: {sym}")
        time.sleep(0.15)
    return prices


def fetch_stock_price(symbol: str) -> float | None:
    """Fetch single stock price via yfinance."""
    import math
    try:
        df = yf.Ticker(symbol).history(period="5d", interval="1d")
        if not df.empty:
            # Walk backwards to find a non-NaN close
            for val in reversed(df["Close"].tolist()):
                if val is not None and not (isinstance(val, float) and math.isnan(val)):
                    return round(float(val), 4)
    except Exception as e:
        log.warning(f"  yfinance {symbol} failed: {e}")
    return None


# ── Position Enrichment ───────────────────────────────────────────────────────

def enrich_position(pos: dict, current_price: float | None) -> dict:
    """Add current price, value, P&L and distance fields to a position dict."""
    p = dict(pos)
    entry = float(p.get("entry_price") or p.get("entry") or 0)
    size  = float(p.get("size") or 0)
    sl    = p.get("stop_loss")
    tgts  = p.get("targets") or []
    t1    = float(tgts[0]) if tgts else None
    direction = (p.get("direction") or "LONG").upper()

    import math
    # Sanitize NaN from yfinance
    if current_price is not None and isinstance(current_price, float) and math.isnan(current_price):
        current_price = None

    p["current_price"] = current_price
    p["price_stale"]   = current_price is None

    if current_price and size:
        value     = round(size * current_price, 2)
        pnl_usd   = round(size * (current_price - entry) *
                          (1 if direction in ("LONG","BUY","CALL") else -1), 2)
        pnl_pct   = round(pnl_usd / (size * entry) * 100, 4) if entry else None
    else:
        value   = p.get("value", 0)
        pnl_usd = None
        pnl_pct = None

    p["value_usd"]          = value
    p["unrealized_pnl_usd"] = pnl_usd
    p["unrealized_pnl_pct"] = pnl_pct

    # Distance to stop / target
    if current_price and sl:
        dist_stop = pct(current_price, float(sl))
        if direction in ("LONG","BUY","CALL"):
            p["distance_to_stop_pct"] = round(pct(float(sl), current_price) or 0, 4)
        else:
            p["distance_to_stop_pct"] = round(pct(current_price, float(sl)) or 0, 4)
    else:
        p["distance_to_stop_pct"] = None

    if current_price and t1:
        if direction in ("LONG","BUY","CALL"):
            p["distance_to_target_pct"] = round(pct(t1, current_price) or 0, 4)
        else:
            p["distance_to_target_pct"] = round(pct(current_price, t1) or 0, 4)
    else:
        p["distance_to_target_pct"] = None

    # Normalise fields
    p.setdefault("opened_at", None)
    p.setdefault("stop_loss",  sl)
    p.setdefault("targets",    tgts)
    p.setdefault("symbol",     pos.get("symbol","?"))
    p.setdefault("direction",  direction)
    p.setdefault("asset_class", classify_asset(p.get("symbol","")))

    return p


# ── Alert Detection ───────────────────────────────────────────────────────────

def detect_alerts(positions: list[dict], portfolio_value: float,
                  prev_state: dict | None) -> list[dict]:
    alerts: list[dict] = []
    now = datetime.now(timezone.utc)

    # Track daily high from history for drawdown calc
    daily_high = portfolio_value
    if prev_state:
        daily_high = max(portfolio_value,
                         prev_state.get("total_value_usd", portfolio_value))

    for pos in positions:
        sym      = pos.get("symbol","?")
        pnl_pct  = pos.get("unrealized_pnl_pct")
        d_stop   = pos.get("distance_to_stop_pct")
        d_tgt    = pos.get("distance_to_target_pct")
        opened   = pos.get("opened_at")
        price    = pos.get("current_price")
        entry    = pos.get("entry_price") or pos.get("entry")

        # Near stop loss
        if d_stop is not None and abs(d_stop) <= STOP_WARN_PCT:
            alerts.append({
                "priority": "HIGH",
                "type":     "near_stop",
                "symbol":   sym,
                "message":  f"Price {abs(d_stop):.2f}% from stop loss",
                "details":  {"entry": entry, "current": price,
                             "stop": pos.get("stop_loss"), "distance_pct": d_stop},
            })

        # Near target
        if d_tgt is not None and 0 < d_tgt <= TARGET_WARN_PCT:
            alerts.append({
                "priority": "MEDIUM",
                "type":     "near_target",
                "symbol":   sym,
                "message":  f"Price {d_tgt:.2f}% from target",
                "details":  {"entry": entry, "current": price,
                             "target": (pos.get("targets") or [None])[0],
                             "distance_pct": d_tgt},
            })

        # Large unrealized loss
        if pnl_pct is not None and pnl_pct < -LOSS_WARN_PCT:
            alerts.append({
                "priority": "HIGH",
                "type":     "large_loss",
                "symbol":   sym,
                "message":  f"Unrealized loss {pnl_pct:.2f}%",
                "details":  {"pnl_pct": pnl_pct,
                             "pnl_usd": pos.get("unrealized_pnl_usd")},
            })

        # Stale position
        if opened:
            try:
                opened_dt = datetime.fromisoformat(opened)
                if opened_dt.tzinfo is None:
                    opened_dt = opened_dt.replace(tzinfo=timezone.utc)
                days_open = (now - opened_dt).days
                move_pct  = abs(pnl_pct or 0)
                if days_open >= STALE_DAYS and move_pct < 1.0:
                    alerts.append({
                        "priority": "LOW",
                        "type":     "stale_position",
                        "symbol":   sym,
                        "message":  f"Open {days_open}d with only {move_pct:.2f}% move",
                        "details":  {"days_open": days_open, "move_pct": move_pct},
                    })
            except Exception:
                pass

    # Portfolio drawdown from daily high
    if portfolio_value and daily_high:
        dd = pct(portfolio_value, daily_high)
        if dd is not None and dd < -DRAWDOWN_WARN_PCT:
            alerts.append({
                "priority": "HIGH",
                "type":     "portfolio_drawdown",
                "symbol":   "PORTFOLIO",
                "message":  f"Portfolio down {abs(dd):.2f}% from today's high",
                "details":  {"current": portfolio_value, "daily_high": daily_high,
                             "drawdown_pct": dd},
            })

    return alerts


# ── Build Portfolio State ─────────────────────────────────────────────────────

def build_state(positions: list[dict], portfolio_value: float,
                cash_available: float, prev_state: dict | None) -> dict:
    now = datetime.now(timezone.utc)

    import math
    def _safe_val(v) -> float:
        if v is None: return 0.0
        if isinstance(v, float) and math.isnan(v): return 0.0
        try: return float(v)
        except: return 0.0

    # Deployed capital = sum of position values
    deployed = sum(_safe_val(p.get("value_usd")) for p in positions)
    deployed_pct = round(deployed / portfolio_value * 100, 2) if portfolio_value else 0

    # Allocation breakdown
    alloc: dict[str, dict] = {}
    for ac in ("crypto", "stocks", "other"):
        v = sum(_safe_val(p.get("value_usd")) for p in positions
                if classify_asset(p.get("symbol","")) == ac)
        alloc[ac] = {"value": round(v, 2),
                     "pct":   round(v / portfolio_value * 100, 2) if portfolio_value else 0}
    alloc["cash"] = {"value": round(cash_available, 2),
                     "pct":   round(cash_available / portfolio_value * 100, 2)
                     if portfolio_value else 0}

    # Total P&L today (vs prev state)
    prev_value  = prev_state.get("total_value_usd", portfolio_value) if prev_state else portfolio_value
    pnl_today   = round(portfolio_value - prev_value, 2) if prev_state else 0.0
    pnl_today_p = round(pnl_today / prev_value * 100, 4) if prev_value else 0.0

    # Weekly P&L — rough from history
    pnl_week_usd = pnl_today  # will be updated with history in main loop

    # Risk metrics
    pos_by_pct = sorted(positions,
                        key=lambda p: _safe_val(p.get("value_usd")), reverse=True)
    largest    = pos_by_pct[0] if pos_by_pct else {}
    near_stop  = [p["symbol"] for p in positions
                  if (p.get("distance_to_stop_pct") or 999) <= STOP_WARN_PCT]
    near_tgt   = [p["symbol"] for p in positions
                  if 0 < (p.get("distance_to_target_pct") or 999) <= TARGET_WARN_PCT]
    at_risk    = [p["symbol"] for p in positions
                  if (p.get("unrealized_pnl_pct") or 0) < -LOSS_WARN_PCT]

    # Add pct_of_portfolio to each position
    for p in positions:
        v = _safe_val(p.get("value_usd"))
        p["pct_of_portfolio"] = round(v / portfolio_value * 100, 4) if portfolio_value else 0

    alerts = detect_alerts(positions, portfolio_value, prev_state)

    return {
        "last_updated":        now.isoformat(),
        "total_value_usd":     round(portfolio_value, 2),
        "total_pnl_today_usd": pnl_today,
        "total_pnl_today_pct": pnl_today_p,
        "total_pnl_week_usd":  pnl_week_usd,
        "cash_available":      round(cash_available, 2),
        "deployed_capital":    round(deployed, 2),
        "deployed_pct":        deployed_pct,
        "positions":           positions,
        "allocation":          alloc,
        "risk_metrics": {
            "total_exposure_pct":  deployed_pct,
            "largest_position_pct": round(
                (largest.get("value_usd", 0) or 0) / portfolio_value * 100, 2)
                if portfolio_value and largest else 0,
            "largest_position":    largest.get("symbol", "—"),
            "positions_at_risk":   len(at_risk),
            "positions_near_stop": near_stop,
            "positions_near_target": near_tgt,
        },
        "alerts": alerts,
    }


# ── Discord Embeds ────────────────────────────────────────────────────────────

def bar(pct_val: float, width: int = 10) -> str:
    filled = round(max(0, min(1, pct_val / 100)) * width)
    return "█" * filled + "░" * (width - filled)


async def post_discord(session: aiohttp.ClientSession, url: str, payload: dict) -> None:
    if not url:
        return
    try:
        async with session.post(url, json=payload,
                                timeout=aiohttp.ClientTimeout(total=10)) as resp:
            if resp.status not in (200, 204):
                body = await resp.text()
                log.warning(f"Discord {resp.status}: {body[:120]}")
    except Exception as e:
        log.warning(f"Discord post failed: {e}")


def build_status_embed(state: dict) -> dict:
    total  = state["total_value_usd"]
    pnl_u  = state["total_pnl_today_usd"]
    pnl_p  = state["total_pnl_today_pct"]
    cash   = state["cash_available"]
    dep    = state["deployed_capital"]
    dep_p  = state["deployed_pct"]
    alloc  = state["allocation"]
    posns  = state["positions"]

    pnl_sign = "+" if pnl_u >= 0 else ""
    pnl_icon = "📈" if pnl_u >= 0 else "📉"

    # Position lines
    pos_lines = []
    for p in posns[:8]:  # cap at 8 to avoid embed overflow
        sym     = p.get("symbol","?")
        dire    = p.get("direction","")[:1]
        size    = p.get("size", 0)
        val     = p.get("value_usd", 0) or 0
        pnl     = p.get("unrealized_pnl_pct") or 0
        d_tgt   = p.get("distance_to_target_pct")
        pct_p   = p.get("pct_of_portfolio", 0)
        pnl_sign_p = "+" if pnl >= 0 else ""
        tgt_str = f" {d_tgt:+.2f}% to TP" if d_tgt is not None else ""
        stale_  = " ⚠️stale" if p.get("price_stale") else ""
        pos_lines.append(
            f"`{sym:12s}` {dire} `{size}` ${val:>9,.0f} "
            f"{pnl_sign_p}{pnl:.2f}%{tgt_str}{stale_}"
        )

    pos_block = "\n".join(pos_lines) if pos_lines else "_No open positions_"

    alloc_line = " | ".join(
        f"{ac.capitalize()} {v['pct']:.1f}%"
        for ac, v in alloc.items() if v["pct"] > 0
    )

    desc = (
        f"**Total: ${total:,.0f}** {pnl_icon} ({pnl_sign}${pnl_u:,.0f} / {pnl_sign}{pnl_p:.2f}% today)\n"
        f"Deployed: ${dep:,.0f} ({dep_p:.1f}%) | Cash: ${cash:,.0f}\n"
        f"\n**Positions ({len(posns)}):**\n"
        f"{pos_block}\n"
        f"\n**Allocation:** {alloc_line}"
    )

    color = 0x00d2a0 if pnl_u >= 0 else 0xff4757

    return {"embeds": [{
        "title":       "💰 PORTFOLIO UPDATE",
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Portfolio Monitor • {state['last_updated'][:19].replace('T',' ')} UTC"},
    }]}


def build_alert_embed(alert: dict) -> dict:
    ptype = alert["priority"]
    atype = alert["type"]
    sym   = alert["symbol"]
    msg   = alert["message"]
    det   = alert.get("details", {})

    icons = {"near_stop": "⚠️", "near_target": "🎯", "large_loss": "🚨",
             "stale_position": "💤", "portfolio_drawdown": "📉"}
    icon  = icons.get(atype, "⚠️")
    colors = {"HIGH": 0xff4757, "MEDIUM": 0xffa502, "LOW": 0xaaa9ad}
    color = colors.get(ptype, 0xffa502)

    if atype == "near_stop":
        title = f"⚠️ POSITION ALERT — {sym}"
        desc  = (
            f"Price approaching stop loss — currently **{abs(det.get('distance_pct',0)):.2f}%** away\n"
            f"Entry: ${det.get('entry',0):,.2f} | "
            f"Current: ${det.get('current',0):,.2f} | "
            f"Stop: ${det.get('stop',0):,.2f}\n\n"
            f"_Action: Monitor closely. PsychTechologist notified._"
        )
    elif atype == "near_target":
        title = f"🎯 TARGET APPROACHING — {sym}"
        desc  = (
            f"Price within **{det.get('distance_pct',0):.2f}%** of TP1\n"
            f"Entry: ${det.get('entry',0):,.2f} | "
            f"Current: ${det.get('current',0):,.2f} | "
            f"Target: ${det.get('target',0):,.2f}\n\n"
            f"_Execution Specialist notified for exit preparation._"
        )
    elif atype == "large_loss":
        title = f"🚨 LARGE LOSS ALERT — {sym}"
        desc  = (
            f"Unrealized loss: **{det.get('pnl_pct',0):.2f}%** "
            f"(${abs(det.get('pnl_usd',0)):,.0f})\n\n"
            f"_Risk Manager has been notified._"
        )
    elif atype == "portfolio_drawdown":
        title = "📉 PORTFOLIO DRAWDOWN ALERT"
        desc  = (
            f"Portfolio down **{abs(det.get('drawdown_pct',0)):.2f}%** from today's high\n"
            f"Current: ${det.get('current',0):,.0f} | "
            f"High: ${det.get('daily_high',0):,.0f}\n\n"
            f"_Circuit breaker may activate if drawdown continues._"
        )
    elif atype == "stale_position":
        title = f"💤 STALE POSITION — {sym}"
        desc  = (
            f"Open for **{det.get('days_open',0)} days** with only "
            f"{det.get('move_pct',0):.2f}% move.\n"
            f"_Consider closing to free capital._"
        )
    else:
        title = f"{icon} PORTFOLIO ALERT — {sym}"
        desc  = msg

    return {"embeds": [{
        "title":       title,
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Portfolio Monitor • [{ptype}] {datetime.now(timezone.utc).strftime('%Y-%m-%d %H:%M')} UTC"},
    }]}


# ── History ───────────────────────────────────────────────────────────────────

def append_history(state: dict) -> None:
    history = load_json(PORT_HISTORY, [])
    prev_val = history[-1]["total_value"] if history else state["total_value_usd"]
    snapshot = {
        "timestamp":       state["last_updated"],
        "total_value":     state["total_value_usd"],
        "pnl_since_last":  round(state["total_value_usd"] - prev_val, 2),
        "positions_count": len(state["positions"]),
        "exposure_pct":    state["deployed_pct"],
    }
    history.append(snapshot)
    if len(history) > MAX_HISTORY:
        history = history[-MAX_HISTORY:]
    save_json(PORT_HISTORY, history)


async def maybe_archive_history(session: aiohttp.ClientSession) -> None:
    """Archive portfolio history when it exceeds HISTORY_MAX."""
    history = load_json(PORT_HISTORY, [])
    if len(history) <= HISTORY_MAX:
        return
    history = await maybe_rotate(
        session, "portfolio-history", history, PORT_HISTORY,
        max_entries=HISTORY_MAX, webhook_url=ARCHIVE_URL
    )
    save_json(PORT_HISTORY, history)


def calc_weekly_pnl(current_value: float) -> float:
    history = load_json(PORT_HISTORY, [])
    # ~2016 entries per week at 5-min intervals, but we keep 500
    # Use oldest available as weekly proxy
    if len(history) >= 2:
        oldest_val = history[0]["total_value"]
        return round(current_value - oldest_val, 2)
    return 0.0


# ── Main loop ─────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Portfolio Monitor starting ===")
    log.info(f"Risk state : {RISK_STATE}")
    log.info(f"Port state : {PORT_STATE}")
    log.info(f"Discord status    : {'✅' if STATUS_URL else '❌'}")
    log.info(f"Discord rebalance : {'✅' if REBALANCE_URL else '❌'}")
    log.info(f"Cycle: every {POLL_INTERVAL//60}min | Discord: every {DISCORD_INTERVAL//60}min\n")

    last_discord_post = 0.0
    # Track which alert types have already been posted this cycle to avoid spam
    # Key: (symbol, alert_type) — reset each cycle
    alerted_this_cycle: set = set()

    async with aiohttp.ClientSession() as session:
        while True:
            cycle_start = time.monotonic()
            now_ts = datetime.now(timezone.utc).strftime("%H:%M:%S")
            log.info(f"[{now_ts}] Running portfolio cycle...")

            try:
                # ── Load source data ──────────────────────────────────────────
                risk_state  = load_json(RISK_STATE, {})
                prev_state  = load_json(PORT_STATE, None)

                # ── Alpaca live data (primary source) ─────────────────────────
                alpaca_account   = fetch_alpaca_account()
                alpaca_positions = fetch_alpaca_positions()

                if alpaca_account:
                    portfolio_val = float(alpaca_account.get("portfolio_value", 0))
                    cash_avail    = float(alpaca_account.get("cash", 0))
                    daily_pnl     = float(alpaca_account.get("unrealized_intraday_pl", 0))
                    log.info(f"  Alpaca: portfolio=${portfolio_val:,.2f} cash=${cash_avail:,.2f} day_pnl=${daily_pnl:+.2f}")
                else:
                    portfolio_val = float(risk_state.get("portfolio_value", 100000))
                    cash_avail    = portfolio_val - sum(float(p.get("value",0)) for p in risk_state.get("open_positions",[]))
                    daily_pnl     = float(risk_state.get("daily_pnl", 0))
                    log.warning("  Alpaca unavailable — using cached risk_state")

                # Build raw_positions from Alpaca (real) or risk_state (fallback)
                if alpaca_positions is not None:
                    raw_positions = [{
                        "symbol":      p["symbol"],
                        "direction":   "LONG" if float(p["qty"]) > 0 else "SHORT",
                        "size":        abs(float(p["qty"])),
                        "entry":       float(p["avg_entry_price"]),
                        "entry_price": float(p["avg_entry_price"]),
                        "value":       abs(float(p["market_value"])),
                        "current_price_live": float(p["current_price"]),
                        "unrealized_pnl_usd": float(p["unrealized_pl"]),
                        "unrealized_pnl_pct": float(p["unrealized_plpc"]) * 100,
                        "asset_class": "stocks",
                        "stop_loss":   None,
                        "targets":     [],
                    } for p in alpaca_positions]
                    log.info(f"  Alpaca positions: {len(raw_positions)} open")
                else:
                    raw_positions = risk_state.get("open_positions", [])

                # ── Fetch prices (Alpaca first, yfinance fallback) ────────────
                all_prices: dict[str, float | None] = {}

                crypto_syms = [p["symbol"] for p in raw_positions
                               if classify_asset(p.get("symbol","")) == "crypto"]
                stock_syms  = [p["symbol"] for p in raw_positions
                               if classify_asset(p.get("symbol","")) == "stocks"]

                if crypto_syms:
                    log.info(f"  Fetching crypto prices: {crypto_syms}")
                    all_prices.update(fetch_crypto_prices(crypto_syms))

                for sym in stock_syms:
                    # Try Alpaca data API first (faster, no rate limits)
                    price = fetch_alpaca_price(sym)
                    if not price:
                        log.info(f"  Alpaca price miss for {sym}, trying yfinance")
                        price = fetch_stock_price(sym)
                        time.sleep(YF_DELAY)
                    else:
                        log.info(f"  {sym}: ${price} (Alpaca live)")
                    all_prices[sym] = price

                # ── Enrich positions ──────────────────────────────────────────
                enriched = []
                for raw in raw_positions:
                    sym   = raw.get("symbol","")
                    # Use Alpaca live price if available in the position record
                    price = raw.get("current_price_live") or all_prices.get(sym)
                    norm = {
                        "symbol":        sym,
                        "asset_class":   raw.get("asset_class", classify_asset(sym)),
                        "direction":     raw.get("direction","LONG"),
                        "size":          raw.get("size", 0),
                        "entry_price":   raw.get("entry") or raw.get("entry_price"),
                        "stop_loss":     raw.get("stop_loss"),
                        "targets":       raw.get("targets", []),
                        "opened_at":     raw.get("opened_at"),
                        "value_usd":     raw.get("value", 0),
                        # Carry through live P&L if Alpaca provided it
                        "_alpaca_pnl_usd": raw.get("unrealized_pnl_usd"),
                        "_alpaca_pnl_pct": raw.get("unrealized_pnl_pct"),
                    }
                    enriched.append(enrich_position(norm, price))

                import math as _math
                def _sv(v):
                    if v is None: return 0.0
                    if isinstance(v, float) and _math.isnan(v): return 0.0
                    try: return float(v)
                    except: return 0.0

                # Recalculate total portfolio value with live prices
                live_pos_val = sum(_sv(p.get("value_usd")) for p in enriched)
                live_total   = live_pos_val + cash_avail

                # ── Build state ───────────────────────────────────────────────
                state = build_state(enriched, live_total, cash_avail, prev_state)
                state["total_pnl_week_usd"] = calc_weekly_pnl(live_total)

                save_json(PORT_STATE, state)
                append_history(state)
                await maybe_archive_history(session)

                log.info(f"  Portfolio: ${live_total:,.0f} | "
                         f"Deployed: ${live_pos_val:,.0f} ({state['deployed_pct']:.1f}%) | "
                         f"Positions: {len(enriched)} | "
                         f"Alerts: {len(state['alerts'])}")

                # ── Fire immediate alerts (new ones only) ─────────────────────
                new_alerts = []
                for alert in state["alerts"]:
                    key = (alert["symbol"], alert["type"])
                    if key not in alerted_this_cycle:
                        new_alerts.append(alert)
                        alerted_this_cycle.add(key)

                for alert in new_alerts:
                    if alert["priority"] in ("HIGH", "MEDIUM"):
                        log.info(f"  🚨 Alert [{alert['priority']}]: {alert['symbol']} — {alert['message']}")
                        payload = build_alert_embed(alert)
                        await post_discord(session, REBALANCE_URL, payload)
                        await asyncio.sleep(0.5)

                # ── Periodic Discord summary ──────────────────────────────────
                elapsed_since_post = time.monotonic() - last_discord_post
                if elapsed_since_post >= DISCORD_INTERVAL:
                    payload = build_status_embed(state)
                    await post_discord(session, STATUS_URL, payload)
                    last_discord_post = time.monotonic()
                    log.info("  Posted summary to #portfolio-status")

            except Exception as e:
                log.error(f"Cycle error: {e}", exc_info=True)

            # Reset alert dedup at midnight-ish (every 288 cycles = 24h)
            if len(alerted_this_cycle) > 1000:
                alerted_this_cycle.clear()

            elapsed = time.monotonic() - cycle_start
            sleep_for = max(0, POLL_INTERVAL - elapsed)
            log.info(f"  Cycle done in {elapsed:.1f}s. Sleeping {sleep_for:.0f}s\n")
            await asyncio.sleep(sleep_for)


if __name__ == "__main__":
    asyncio.run(run())
