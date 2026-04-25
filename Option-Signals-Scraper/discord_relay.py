#!/usr/bin/env python3
"""
Option Signals → Discord Relay
================================
Reads locally scraped Firebase JSON files and posts new signals
to Discord channels via webhooks. Zero AI tokens.

Deploy:
  cp discord_relay.py /home/ubuntu/mission-control-restored/Option-Signals-Scraper/
  pm2 start discord_relay.py --name "option-signals-relay" --interpreter python3
  pm2 save
"""

import json
import time
import os
import re
import logging
import requests
from datetime import datetime, timezone

# ─── CONFIG ────────────────────────────────────────────────────────────────────
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
STATE_FILE = os.path.join(BASE_DIR, "sent_ids.json")
POLL_INTERVAL = 60  # seconds between checks

logging.basicConfig(
    filename=os.path.join(BASE_DIR, "relay.log"),
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S"
)
console = logging.StreamHandler()
console.setLevel(logging.INFO)
logging.getLogger().addHandler(console)

# ─── WEBHOOKS ──────────────────────────────────────────────────────────────────
WEBHOOKS = {
    "flow_alerts":      "https://discord.com/api/webhooks/1493401894310383826/uUUHIRv3GqVncJCftpCQTAZ-9Erdjk45AH0BMZhQXOfgvqFqNOEZtbPAj3_SnxJMADU3",
    "flow_live":        "https://discord.com/api/webhooks/1493402170119159909/Pqs3pyN8ZyVzYOInm9AW-_ez5LsMZhkoFJK-X-mZAFJMK2bV95qmmochnF5v6e2H1N43",
    "scalp_signals":    "https://discord.com/api/webhooks/1493402271642554409/v4hJfM6w6aW34oqsIWtten7apGe6YmkCgrU1v-ppyOPkxgUGTSxY6JzvVlqWFbzQ5GGI",
    "swing_signals":    "https://discord.com/api/webhooks/1493402334716493916/3Pninv0bIWOO8FXb6CAzDTD5K-n0wy61xuR0luhCwZjqXXokOB4NhKwoC2qyZHLmX0be",
    "stock_signals":    "https://discord.com/api/webhooks/1493402402299052052/LjR3bHljamFb-pcrwPsZumUJSgGw7Za-aXC2PbRyGDunAEVAXI2-5LMm014U9XVcjnfr",
    "long_term_options": "https://discord.com/api/webhooks/1493402455176646831/3xbaAmcPNhFgKvCaBchfFVlrogOBh8iMNe9hTh_MWwNKk3MzlGPeFl3fMPdSuPbuU2o0",
    "long_term_stocks":  "https://discord.com/api/webhooks/1493402513502634186/GiXkTE0VhdbCZER4l8THB9TfaR4pJ6x84Ilnm-JZI-UY9nVxNGK86-B1pgxy4uINHgKj",
    "closed_trades":    "https://discord.com/api/webhooks/1493402563410788442/hQLE4DY3WmKhumUcWNsiHxIdRBQIjXkwV3_n89WaUxWvrhvpar8jMwHvdsBLUnCmcS5D",
    "flow_alerts_fg":   "https://discordapp.com/api/webhooks/1495490266604376194/bYKgqn64LjN7SGW27iX6rFFgsyv2u0BvN6MCpCYPd9N1LrluQ5MwL8Vyn8cTBf8ls612",
    "flow_weekly":      "https://discordapp.com/api/webhooks/1495498687978275058/jZmluiXHtGrtVZJr1upleLlIRPK0-ykoS9IPCfgr-djBdcpnAHMDdIzF09dJ7W9aS_pQ",
    "flow_repeaters":   "https://discordapp.com/api/webhooks/1495498970967969885/moFqKah8nmLDNnbFYKuH1X9USbE7KfPoyXEccWdw4XR2pf_hYRl04DnBzFOXHwZmc3un",
    "flow_unusual":     "https://discordapp.com/api/webhooks/1495499097615106110/iSSylcNPZtzIWi_3f4GAgva4XEb4JavZU99CK_Dhda04PtLaycYzlPvDk55-YjY3ILLc",
    "flow_huge":        "https://discordapp.com/api/webhooks/1495499184512434308/fqh1umawF2mXZs2679-qENjqCNNcKtlzSqMoUyX3P8CH4kb6B6hFPS3qJrH6q19Tyfmc",
    "ts_picks":           "https://discordapp.com/api/webhooks/1497686981012881505/86vXVi4Tq5AJaFsRXU0oVYkWF8CBFZL1UwB--AHk2o9oLqCDwJjAJsM_4rg0gTaGc4oC",
    "ts_closed":          "https://discordapp.com/api/webhooks/1497687033450205308/kRBByqvIOzDLCi57KN2NHSe2xn8XOoeM75ZZF6KhC-XAcnCHQvAThwc_nnQq52_19VdH",
    "ts_mgmt":            "https://discordapp.com/api/webhooks/1497687088663892030/xo2dk5-jD_k56yf4FFabnDjoOeeJ4lhPU_XWmV4d0VkSaym4V0lFFMfvFLU1HmNvKYq9",
    "ss_picks":           "https://discordapp.com/api/webhooks/1497686205217898687/DxkPdFVOMBnSR2gDRbt_jthQ814kimPvyO1stDdlsF5WhlzFg0q0W7V4geuvOUhcQ-hR",
    "ss_closed":          "https://discordapp.com/api/webhooks/1497686368179196055/G2mJXX0oNZcTsJVgqzcDtNw1dvJw8EhyLDiVD5LS5yUkdxUwN6QqvPt1HirQYedf3Jf6",
    "ss_mgmt":            "https://discordapp.com/api/webhooks/1497686609154281554/GTbFYTzAOTxAjYY0ddsnbiRot70jBqIDsbl_DxxBFujux96iIGhvLubIZ3ObMLEAlDNe",
    "os_closed_stocks":   "https://discordapp.com/api/webhooks/1497687226870665264/BkNppKtAPqNEIpOECh33GGx2fyyiW32g_1Zxz99Q7rjbC3wq7Os4rp8k_HYhBIwSfJcA",
    "fg1_sentiment":      "https://discordapp.com/api/webhooks/1497687328557371543/3dHICJGUg3txpH5fPGHRL67A7G0rfOykyuaEYAppYUnhhh_2iuZD4WE-NlR4RubsDkA2",
    "synthetic_analysis":  "https://discordapp.com/api/webhooks/1497723109296443574/09Vir6qTI2xdBFoUcggH9WemQi_RKnMM4AoaFVklQItTaqek2UV9piaylUMC1grNUbgA",
    "fg2_sentiment":      "https://discordapp.com/api/webhooks/1497687543531962418/1nYerfY_4TuNAO4lrjgCcVNxq66RhbJIMhmQfJATIZhL0y39nhn8m-drL7TKBJ_Ihuiy",
    "flow_messages":   "https://discordapp.com/api/webhooks/1497628988938649684/3IrKREiuukaqLb73fW-ugSVazebeER92tCi2Ys9RE8LEEetwXnTnSvFXssbH0ufPjiAv",
    "flow_trade_results": "https://discordapp.com/api/webhooks/1497661681126609008/tlS_qnTSq4Uef8AUVpllp2vwC3sJ7u0BHt2_WcoJz5y75dnh3cgHpkhOn59zGlkWmyPk",
    "flow_etf":         "https://discordapp.com/api/webhooks/1495499274828517498/-NhSohclpP8hBxlekP_BNSnLF7ZeDb-Zdb39QhyyXUp43xhxppN8PeQwz1CSn0It_xNY",
}

FINNHUB_KEY = "d70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0"
def get_flow_channel(alert_type):
    """Route flow alerts to the correct Discord channel by AlertType."""
    at = (alert_type or "").lower()
    if at.endswith("_etf"):
        return "flow_etf"
    elif at == "weekly_flow":
        return "flow_weekly"
    elif at == "repeat_flow":
        return "flow_repeaters"
    elif at == "unusual_high_flow":
        return "flow_unusual"
    elif at == "high_flow":
        return "flow_huge"
    else:
        return "flow_alerts"  # fallback


def finnhub_option_quote(symbol, strike, opt_type, expiry_ts):
    """Fetch option chain from Finnhub to get last price and high."""
    try:
        expiry_str = datetime.fromtimestamp(expiry_ts, tz=timezone.utc).strftime("%Y-%m-%d")
        r = requests.get(f"https://finnhub.io/api/v1/stock/option-chain",
            params={"symbol": symbol, "expiration": expiry_str, "token": FINNHUB_KEY}, timeout=10)
        if r.status_code != 200:
            return None
        data = r.json()
        chain = data.get("data", [])
        for item in chain:
            if abs(float(item.get("strike", 0)) - float(strike)) < 0.01:
                if item.get("contractType", "").upper() == opt_type.upper():
                    return {
                        "last": item.get("lastPrice", 0),
                        "high": item.get("highPrice", 0),
                        "low": item.get("lowPrice", 0),
                        "volume": item.get("volume", 0),
                        "oi": item.get("openInterest", 0),
                    }
    except Exception as e:
        logging.debug(f"Finnhub option quote error: {e}")
    return None

# ─── COLORS ────────────────────────────────────────────────────────────────────
GREEN  = 0x00FF00
RED    = 0xFF0000
BLUE   = 0x0088FF
ORANGE = 0xFF8800
PURPLE = 0xAA00FF
GREY   = 0x888888

# ─── STATE (track what's been posted) ─────────────────────────────────────────
def load_state():
    if os.path.exists(STATE_FILE):
        try:
            with open(STATE_FILE) as f:
                return json.load(f)
        except:
            pass
    return {}

def save_state(state):
    with open(STATE_FILE, "w") as f:
        json.dump(state, f)

# ─── READ LOCAL JSON ──────────────────────────────────────────────────────────
def read_data(filename):
    filepath = os.path.join(DATA_DIR, f"{filename}.json")
    if not os.path.exists(filepath):
        return None
    try:
        with open(filepath) as f:
            return json.load(f)
    except:
        return None

# ─── DISCORD POST ─────────────────────────────────────────────────────────────
def post_embed(webhook_key, embed):
    url = WEBHOOKS.get(webhook_key)
    if not url:
        return False
    try:
        r = requests.post(url, json={"embeds": [embed]}, timeout=10)
        if r.status_code == 204:
            return True
        elif r.status_code == 429:
            retry = r.json().get("retry_after", 5)
            logging.warning(f"Rate limited on {webhook_key}, waiting {retry}s")
            time.sleep(retry)
            return False
        else:
            logging.warning(f"Discord error {webhook_key}: {r.status_code}")
            return False
    except Exception as e:
        logging.error(f"Discord post failed {webhook_key}: {e}")
        return False

def format_timestamp(unix_ms):
    """Convert unix ms or seconds to readable string."""
    try:
        ts = int(unix_ms)
        if ts > 1e12:
            ts = ts / 1000
        return datetime.fromtimestamp(ts, tz=timezone.utc).strftime("%m/%d %I:%M %p")
    except:
        return "?"

def format_expiry(unix_ts):
    """Convert unix timestamp to expiry date string."""
    try:
        ts = int(unix_ts)
        return datetime.fromtimestamp(ts, tz=timezone.utc).strftime("%m/%d/%y")
    except:
        return str(unix_ts)

def format_value(val):
    """Format dollar value nicely."""
    try:
        v = float(val)
        if v >= 1_000_000:
            return f"${v/1_000_000:.2f}M"
        elif v >= 1_000:
            return f"${v/1_000:.1f}K"
        else:
            return f"${v:.0f}"
    except:
        return str(val)

# ─── RELAY: FLOW ALERTS ───────────────────────────────────────────────────────
def relay_flow_alerts(state):
    data = read_data("flow_alerts_today")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("flow_alerts", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        alert = entry.get("alert", {})
        quote = entry.get("quote", {})
        sym = alert.get("Symbol", "?")
        strike = alert.get("Strike", "?")
        opt_type = alert.get("OptionType", "?")
        expiry = format_expiry(alert.get("Expiry", 0))
        bullish = alert.get("isBullish", False)
        block_type = alert.get("BlockType", alert.get("option_activity_type", "?"))
        sweeps = alert.get("SWEEPS", 0)
        blocks = alert.get("BLOCKS", 0)

        flow_val = alert.get("totalFlowValue", 0)
        alert_price = float(alert.get("AlertPrice", 0) or 0)
        last_price = quote.get("Last")
        day_high = quote.get("DayHigh")
        dte = alert.get("DTE", "?")
        trades = alert.get("trade_count", "?")

        # Calculate gains
        gain_pct = "?"
        max_gain_pct = "?"
        if last_price and alert_price > 0:
            try:
                gain_pct = f"{((float(last_price) - alert_price) / alert_price * 100):+.2f}%"
            except: pass
        if day_high and alert_price > 0:
            try:
                max_gain_pct = f"{((float(day_high) - alert_price) / alert_price * 100):+.2f}%"
            except: pass

        fields = [
            {"name": "Flow Premium", "value": f"**{format_value(flow_val)}**", "inline": True},
            {"name": "Size / OI", "value": f"{alert.get('Volume', '?')} / {alert.get('OI', '?')}", "inline": True},
            {"name": "\u200b", "value": "\u200b", "inline": True},
            {"name": "Sweeps / Blocks", "value": f"{sweeps} / {blocks}", "inline": True},
            {"name": "Alerted Price", "value": f"${alert_price}", "inline": True},
            {"name": "DTE", "value": str(dte), "inline": True},
        ]
        if last_price and str(last_price) != "?":
            fields.append({"name": "Last Price", "value": f"${last_price}", "inline": True})
            fields.append({"name": "Gain %", "value": str(gain_pct), "inline": True})
            fields.append({"name": "Max Gain %", "value": str(max_gain_pct), "inline": True})
        if day_high and str(day_high) != "?":
            fields.append({"name": "Highest After", "value": f"${day_high}", "inline": True})
        if alert.get("Spot") and float(alert.get("Spot", 0)) > 0:
            fields.append({"name": "Spot", "value": f"${alert['Spot']}", "inline": True})
        if trades and str(trades) != "?":
            fields.append({"name": "Trades", "value": str(trades), "inline": True})

        embed = {
            "title": f"{'🟢' if bullish else '🔴'} {sym} ${strike}{opt_type[0]} {expiry}",
            "color": GREEN if bullish else RED,
            "fields": fields,
            "footer": {"text": f"Option Signals Flow | {format_timestamp(alert.get('Time', 0))}"}
        }

        channel = get_flow_channel(alert.get("AlertType", ""))
        posted = post_embed(channel, embed)
        post_embed("flow_alerts", embed)  # also post to original firehose
        if posted:
            new_sent.append(key)
            time.sleep(1)  # rate limit buffer

    state["flow_alerts"] = list(sent | set(new_sent))
    return state

# ─── RELAY: LIVE FLOW ─────────────────────────────────────────────────────────
def relay_flow_live(state):
    data = read_data("flow_live_last100")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("flow_live", []))
    new_sent = []

    # Sort by timestamp, only post newest 10 unseen to avoid flooding
    unseen = [(k, v) for k, v in data.items() if k not in sent]
    unseen.sort(key=lambda x: int(x[0]), reverse=True)

    for key, entry in unseen[:10]:
        sym = entry.get("Symbol", "?")
        strike = entry.get("Strike", "?")
        opt_type = entry.get("OptionType", "?")
        block_type = entry.get("BlockType", "?")
        bid_ask = entry.get("BidAskType", "?")
        expiry_str = entry.get("ExpiryStr", "?")
        value = format_value(entry.get("Value", 0))
        vol = entry.get("Volume", "?")
        oi = entry.get("OI", "?")
        spot = entry.get("Spot", "?")
        price = entry.get("Price", "?")

        # Bullish: calls at ask or puts at bid
        bullish = (opt_type == "CALL" and bid_ask == "A") or (opt_type == "PUT" and bid_ask == "B")
        side = "ASK ↑" if bid_ask == "A" else "BID ↓"

        emoji = "🟢" if bullish else "🔴"
        type_emoji = "⚡" if block_type == "SWEEP" else "📦"

        embed = {
            "title": f"{emoji} {sym} ${strike}{opt_type[0]} {expiry_str} | {type_emoji} {block_type}",
            "color": GREEN if bullish else RED,
            "description": f"**{side}** @ ${price} | {value} total",
            "fields": [
                {"name": "Volume", "value": str(vol), "inline": True},
                {"name": "OI", "value": str(oi), "inline": True},
                {"name": "Spot", "value": f"${spot}", "inline": True},
            ],
            "footer": {"text": f"Flow | {format_timestamp(entry.get('Time', 0))}"}
        }

        if post_embed("flow_live", embed):
            new_sent.append(key)
            time.sleep(0.8)

    # Keep last 500 IDs to prevent memory bloat
    all_sent = list(sent | set(new_sent))
    state["flow_live"] = all_sent[-500:]
    return state

# ─── RELAY: OPTION NOTIFICATIONS (SCALPS + SWINGS) ────────────────────────────
def relay_option_notifications(state):
    data = read_data("option_notifications")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("option_notifs", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        category = entry.get("category", "SWING").upper()
        symbol = entry.get("symbol", "?")
        title = entry.get("title", f"{symbol} Signal")
        message = entry.get("message", "")

        if category == "SCALP":
            webhook = "scalp_signals"
            color = ORANGE
            emoji = "⚡"
        else:
            webhook = "swing_signals"
            color = BLUE
            emoji = "🔄"

        embed = {
            "title": f"{emoji} {title}",
            "description": message,
            "color": color,
            "fields": [
                {"name": "Category", "value": category, "inline": True},
                {"name": "Symbol", "value": symbol, "inline": True},
            ],
            "footer": {"text": f"Option Signals | {format_timestamp(key)}"}
        }

        if post_embed(webhook, embed):
            new_sent.append(key)
            time.sleep(1)

    state["option_notifs"] = list(sent | set(new_sent))
    return state

# ─── RELAY: STOCK NOTIFICATIONS ───────────────────────────────────────────────
def relay_stock_notifications(state):
    data = read_data("stock_notifications")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("stock_notifs", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        symbol = entry.get("symbol", "?")
        title = entry.get("title", f"{symbol} Stock Signal")
        message = entry.get("message", "")
        category = entry.get("category", "STOCK")

        embed = {
            "title": f"📊 {title}",
            "description": message,
            "color": BLUE,
            "fields": [
                {"name": "Category", "value": category, "inline": True},
                {"name": "Symbol", "value": symbol, "inline": True},
            ],
            "footer": {"text": f"Option Signals | {format_timestamp(key)}"}
        }

        if post_embed("stock_signals", embed):
            new_sent.append(key)
            time.sleep(1)

    state["stock_notifs"] = list(sent | set(new_sent))
    return state

# ─── RELAY: SHORT TERM OPTIONS (ACTIVE TRADES) ────────────────────────────────
def relay_short_term_options(state):
    data = read_data("short_term_options")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("short_options", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        sym = entry.get("symbol", "?")
        strike = entry.get("strike", "?")
        expiry = format_expiry(entry.get("expiry", 0))
        buy = entry.get("buyTarget", "?")
        sell1 = entry.get("sellTarget", "?")
        sell2 = entry.get("sellTarget2", "?")
        sell3 = entry.get("sellTarget3", "?")
        stop = entry.get("stopLoss", "?")
        status = entry.get("status", "Active")
        name = entry.get("shortName", "")
        category = entry.get("category", "SWING")

        quote = entry.get("quote", {})
        last = quote.get("lastPrice", "?")
        vol = quote.get("totalVolume", "?")
        oi = quote.get("openInterest", "?")

        webhook = "scalp_signals" if category == "SCALP" else "swing_signals"
        color = ORANGE if category == "SCALP" else BLUE

        embed = {
            "title": f"{'⚡' if category == 'SCALP' else '🔄'} {sym} ${strike}C {expiry}",
            "description": f"**{name}**\n📌 {status}",
            "color": color,
            "fields": [
                {"name": "Buy Target", "value": f"${buy}", "inline": True},
                {"name": "Stop Loss", "value": f"${stop}", "inline": True},
                {"name": "Last Price", "value": f"${last}", "inline": True},
                {"name": "Target 1", "value": f"${sell1}", "inline": True},
                {"name": "Target 2", "value": f"${sell2}", "inline": True},
                {"name": "Target 3", "value": f"${sell3}", "inline": True},
                {"name": "Volume", "value": str(vol), "inline": True},
                {"name": "OI", "value": str(oi), "inline": True},
            ],
            "footer": {"text": f"Option Signals | {category}"}
        }

        if post_embed(webhook, embed):
            new_sent.append(key)
            time.sleep(1)

    state["short_options"] = list(sent | set(new_sent))
    return state

# ─── RELAY: LONG TERM OPTIONS ─────────────────────────────────────────────────
def relay_long_term_options(state):
    data = read_data("long_term_options")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("long_options", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        sym = entry.get("symbol", "?")
        strike = entry.get("strike", "?")
        expiry = format_expiry(entry.get("expiry", 0))
        buy = entry.get("buyTarget", "?")
        sell1 = entry.get("sellTarget", "?")
        sell2 = entry.get("sellTarget2", "?")
        sell3 = entry.get("sellTarget3", "?")
        stop = entry.get("stopLoss", "?")
        status = entry.get("status", "Active")
        name = entry.get("shortName", "")

        embed = {
            "title": f"📅 {sym} ${strike}C {expiry}",
            "description": f"**{name}**\n📌 {status}",
            "color": PURPLE,
            "fields": [
                {"name": "Buy Target", "value": f"${buy}", "inline": True},
                {"name": "Stop Loss", "value": f"${stop}", "inline": True},
                {"name": "Target 1", "value": f"${sell1}", "inline": True},
                {"name": "Target 2", "value": f"${sell2}", "inline": True},
                {"name": "Target 3", "value": f"${sell3}", "inline": True},
            ],
            "footer": {"text": "Option Signals | LEAP"}
        }

        if post_embed("long_term_options", embed):
            new_sent.append(key)
            time.sleep(1)

    state["long_options"] = list(sent | set(new_sent))
    return state

# ─── RELAY: LONG TERM STOCKS ──────────────────────────────────────────────────
def relay_long_term_stocks(state):
    data = read_data("long_term_stocks")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("long_stocks", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        sym = entry.get("symbol", "?")
        buy = entry.get("buyTarget", "?")
        sell1 = entry.get("sellTarget", "?")
        sell2 = entry.get("sellTarget2", "?")
        sell3 = entry.get("sellTarget3", "?")
        stop = entry.get("stopLoss", "?")
        status = entry.get("status", "Active")
        name = entry.get("shortName", "")

        embed = {
            "title": f"📈 {sym} — Long Term Stock",
            "description": f"**{name}**\n📌 {status}",
            "color": PURPLE,
            "fields": [
                {"name": "Buy Target", "value": f"${buy}", "inline": True},
                {"name": "Stop Loss", "value": f"${stop}", "inline": True},
                {"name": "Target 1", "value": f"${sell1}", "inline": True},
                {"name": "Target 2", "value": f"${sell2}", "inline": True},
                {"name": "Target 3", "value": f"${sell3}", "inline": True},
            ],
            "footer": {"text": "Option Signals | Long Term Stock"}
        }

        if post_embed("long_term_stocks", embed):
            new_sent.append(key)
            time.sleep(1)

    state["long_stocks"] = list(sent | set(new_sent))
    return state

# ─── RELAY: CLOSED TRADES ─────────────────────────────────────────────────────
def relay_closed_trades(state):
    data = read_data("closed_options")
    if not data or not isinstance(data, dict):
        return state

    sent = set(state.get("closed", []))
    new_sent = []

    for key, entry in data.items():
        if key in sent:
            continue

        sym = entry.get("symbol", "?")
        strike = entry.get("strike", "?")
        status = entry.get("status", "Closed")
        buy = entry.get("buyTarget", "?")
        name = entry.get("shortName", "")

        # Determine win/loss from status text
        status_lower = status.lower()
        if any(w in status_lower for w in ["profit", "target", "win", "gain"]):
            color = GREEN
            emoji = "✅"
        elif any(w in status_lower for w in ["loss", "stop", "expired", "cut"]):
            color = RED
            emoji = "❌"
        else:
            color = GREY
            emoji = "🔒"

        embed = {
            "title": f"{emoji} {sym} ${strike} — CLOSED",
            "description": f"**{name}**\n📌 {status}",
            "color": color,
            "fields": [
                {"name": "Entry", "value": f"${buy}", "inline": True},
            ],
            "footer": {"text": "Option Signals | Closed Trade"}
        }

        if post_embed("closed_trades", embed):
            new_sent.append(key)
            time.sleep(1)

    state["closed"] = list(sent | set(new_sent))
    return state


# ─── RELAY: FLOWGREEKS2 ALERTS ────────────────────────────────────────────────


# ═══════════════════════════════════════════════════════════════════════════════
# AUTO MIRRORS TO #flow-messages — additive
# ═══════════════════════════════════════════════════════════════════════════════


def _post_to(webhook_key, content, log_tag):
    """Generic post to any webhook key with rate-limit handling."""
    url = WEBHOOKS.get(webhook_key)
    if not url: return False
    try:
        r = requests.post(url, json={"content": content[:1900]}, timeout=10)
        if r.status_code in (200, 204): return True
        if r.status_code == 429:
            retry = r.json().get("retry_after", 5)
            logging.warning(f"[{log_tag}] rate limited, sleeping {retry}s")
            time.sleep(retry)
            return False
        logging.warning(f"[{log_tag}] HTTP {r.status_code}: {r.text[:150]}")
        return False
    except Exception as e:
        logging.warning(f"[{log_tag}] post error: {e}")
        return False

def _post_to_flow_messages(content, log_tag):
    url = WEBHOOKS.get("flow_messages")
    if not url: return False
    try:
        r = requests.post(url, json={"content": content[:1900]}, timeout=10)
        if r.status_code in (200, 204): return True
        if r.status_code == 429:
            retry = r.json().get("retry_after", 5)
            logging.warning(f"[{log_tag}] rate limited, sleeping {retry}s")
            time.sleep(retry)
            return False
        logging.warning(f"[{log_tag}] HTTP {r.status_code}: {r.text[:150]}")
        return False
    except Exception as e:
        logging.warning(f"[{log_tag}] post error: {e}")
        return False



def _post_to_trade_results(content, log_tag):
    url = WEBHOOKS.get("flow_trade_results")
    if not url: return False
    try:
        r = requests.post(url, json={"content": content[:1900]}, timeout=10)
        if r.status_code in (200, 204): return True
        if r.status_code == 429:
            retry = r.json().get("retry_after", 5)
            logging.warning(f"[{log_tag}] rate limited, sleeping {retry}s")
            time.sleep(retry)
            return False
        logging.warning(f"[{log_tag}] HTTP {r.status_code}: {r.text[:150]}")
        return False
    except Exception as e:
        logging.warning(f"[{log_tag}] post error: {e}")
        return False

def _fmt_money(v):
    try: v = float(v)
    except: return str(v)
    if v >= 1_000_000: return f"{v/1_000_000:.1f}M"
    if v >= 1_000: return f"{v/1_000:.0f}K"
    return f"{v:.2f}"


def _extract_pct_from_status(status):
    if not status: return None
    m = re.search(r"(-?\d+(?:\.\d+)?)\s*%", status)
    return float(m.group(1)) if m else None


def relay_winners_mirror(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("winners_mirror_sent", []))
    new_sent = []
    for fname, kind in [("closed_options", "OPTION"), ("closed_stocks", "STOCK")]:
        data = read_data(fname)
        if not data or not isinstance(data, dict): continue
        for entry_id, entry in data.items():
            if not isinstance(entry, dict): continue
            sent_key = f"win|{fname}|{entry_id}"
            if sent_key in sent: continue
            status = entry.get("status", "") or entry.get("message", "")
            if not status: continue
            pct = _extract_pct_from_status(status)
            symbol = entry.get("symbol", "?")
            buy = entry.get("buyTarget", "")
            sell = entry.get("sellTarget", "")
            strike = entry.get("strike", "")
            expiry = entry.get("expiry", "")
            category = entry.get("category", "")
            if pct is None and "profits" not in status.lower() and "delivered" not in status.lower() and "winner" not in status.lower():
                continue
            if pct is not None and pct <= 0: continue
            if pct is None: emoji, tier = "🏆", "Winner"
            elif pct >= 500: emoji, tier = "🚀", "Magic"
            elif pct >= 100: emoji, tier = "💫", "Mega-Win"
            elif pct >= 50: emoji, tier = "💎", "Diamond Hands"
            elif pct >= 25: emoji, tier = "🏆", "Bull Run"
            else: emoji, tier = "🎯", "Win"
            expiry_str = ""
            try:
                if expiry and str(expiry).isdigit() and int(expiry) > 1000000000:
                    from datetime import datetime
                    exp_dt = datetime.fromtimestamp(int(expiry))
                    expiry_str = f" {exp_dt.month}/{exp_dt.day}/{str(exp_dt.year)[2:]}"
            except: pass
            title = f"{symbol} {strike}{expiry_str}" if (kind == "OPTION" and strike) else symbol
            pct_str = f" +{pct:.1f}%" if pct is not None else ""
            lines = [f"{emoji} {title} {tier} Alert!{pct_str}"]
            if status: lines.append(status)
            if buy and sell: lines.append(f"Buy {buy} → Sell {sell}")
            if category: lines.append(f"[{category}]")
            msg = "\n".join(lines)
            if _post_to_trade_results(msg, "winners"):
                new_sent.append(sent_key)
                logging.info(f"[winners] posted {symbol} pct={pct} tier={tier}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new_sent: state["winners_mirror_sent"] = list(set(state.get("winners_mirror_sent", []) + new_sent))[-5000:]
                return state
                time.sleep(1.2)
    if new_sent:
        state["winners_mirror_sent"] = list(sent | set(new_sent))[-5000:]
    return state


def relay_picks_mirror(state):
    sent = set(state.get("picks_mirror_sent", []))
    new_sent = []
    for fname, label in [("short_term_options", "ST OPTION"), ("long_term_options", "LT OPTION"),
                          ("short_term_stocks", "ST STOCK"), ("long_term_stocks", "LT STOCK")]:
        data = read_data(fname)
        if not data or not isinstance(data, dict): continue
        for entry_id, entry in data.items():
            if not isinstance(entry, dict): continue
            sent_key = f"pick|{fname}|{entry_id}"
            if sent_key in sent: continue
            symbol = entry.get("symbol", "?")
            strike = entry.get("strike", "")
            buy = entry.get("buyTarget", "")
            sell = entry.get("sellTarget", "")
            sell2 = entry.get("sellTarget2", "")
            stop = entry.get("stopLoss", "")
            risk = entry.get("risk", "")
            category = entry.get("category", "")
            expiry = entry.get("expiry", "")
            short_name = entry.get("shortName", "")
            expiry_str = ""
            try:
                if expiry and str(expiry).isdigit() and int(expiry) > 1000000000:
                    from datetime import datetime
                    exp_dt = datetime.fromtimestamp(int(expiry))
                    expiry_str = f" {exp_dt.month}/{exp_dt.day}/{str(exp_dt.year)[2:]}"
            except: pass
            title = f"{symbol} {strike}{expiry_str}" if ("OPTION" in label and strike) else symbol
            lines = [f"📊 {title} — {label} Pick"]
            if short_name: lines.append(short_name)
            row = []
            if buy: row.append(f"Buy {buy}")
            if sell: row.append(f"T1 {sell}")
            if sell2: row.append(f"T2 {sell2}")
            if stop: row.append(f"SL {stop}")
            if row: lines.append(" | ".join(row))
            tags = []
            if category: tags.append(category)
            if risk: tags.append(f"Risk:{risk}")
            if tags: lines.append("[" + ", ".join(tags) + "]")
            msg = "\n".join(lines)
            if _post_to_flow_messages(msg, "picks"):
                new_sent.append(sent_key)
                logging.info(f"[picks] posted {symbol} {label}")
                time.sleep(1.2)
    if new_sent:
        state["picks_mirror_sent"] = list(sent | set(new_sent))[-5000:]
    return state


def relay_management_mirror(state):
    sent = set(state.get("management_mirror_sent", []))
    new_sent = []
    for fname in ["option_notifications", "stock_notifications"]:
        data = read_data(fname)
        if not data or not isinstance(data, dict): continue
        for entry_id, entry in data.items():
            if not isinstance(entry, dict): continue
            sent_key = f"mgmt|{fname}|{entry_id}"
            if sent_key in sent: continue
            title = entry.get("title", "")
            message = entry.get("message", "")
            category = entry.get("category", "")
            if not title and not message: continue
            emoji = "📋"
            if "stopped" in message.lower(): emoji = "🛑"
            elif "target" in message.lower() and ("reach" in message.lower() or "lock" in message.lower()): emoji = "🎯"
            elif "stc" in title.lower() or "sell" in title.lower(): emoji = "💰"
            lines = [f"{emoji} {title}" if title else f"{emoji} {entry.get('symbol','?')}"]
            if message: lines.append(message)
            if category: lines.append(f"[{category}]")
            msg = "\n".join(lines)
            if _post_to_trade_results(msg, "mgmt"):
                new_sent.append(sent_key)
                logging.info(f"[mgmt] posted {title or entry_id}")
                time.sleep(1.2)
    if new_sent:
        state["management_mirror_sent"] = list(sent | set(new_sent))[-5000:]
    return state


def relay_fg1_mirror(state):
    data = read_data("flow_alerts_today")
    if not data or not isinstance(data, dict): return state
    sent = set(state.get("fg1_mirror_sent", []))
    new_sent = []
    def _hdr(at, bull, ut):
        direction = "Bullish" if bull else "Bearish"
        is_etf = (ut or "").upper() == "ETF"
        prefix = "ETF: " if is_etf else ""
        if at in ("weekly_flow", "weekly_flow_etf"): kind = "Rapid"
        elif at in ("repeat_flow", "repeat_flow_etf"): kind = "Repeated"
        else: kind = "Unusual"
        return f"{prefix}{kind} {direction} Flow Alert!"
    for option_symbol, entry in data.items():
        if not isinstance(entry, dict): continue
        a = entry.get("alert", {})
        if not a or a.get("NotifyAlert", 0) != 1: continue
        sym = a.get("Symbol", "")
        at = a.get("AlertType", "")
        fc = a.get("totalFlowCount", 0)
        sent_key = f"fg1|{option_symbol}|{at}|{fc}"
        if sent_key in sent: continue
        m = re.match(r"^([A-Z]+)(\d{2})(\d{2})(\d{2})([CP])(\d{8})$", option_symbol)
        if m:
            t, yr, mo, day, opt, sk = m.groups()
            title = f"{t} {int(sk)//1000}{opt} {int(mo)}/{int(day)}/{yr}"
        else:
            title = sym
        msg = f"{title}\n{_hdr(at, a.get('isBullish'), a.get('UnderlyingType'))}\nFlow count: {fc}, Premium: {_fmt_money(a.get('totalFlowValue', 0))} !!"
        if _post_to_flow_messages(msg, "fg1"):
            new_sent.append(sent_key)
            logging.info(f"[fg1] posted {sym} {at}")
            time.sleep(1.2)
    if new_sent:
        state["fg1_mirror_sent"] = list(sent | set(new_sent))[-5000:]
    return state



# ═══════════════════════════════════════════════════════════════════════════════
# TRADE SIGNALS + STOCK SIGNALS + OS-CLOSED-STOCKS + FG1/FG2 SENTIMENT MIRRORS
# ═══════════════════════════════════════════════════════════════════════════════

def _format_pick(entry, label):
    sym = entry.get("symbol", "?")
    strike = entry.get("strike", "")
    buy = entry.get("buyTarget", "")
    sell = entry.get("sellTarget", "")
    sell2 = entry.get("sellTarget2", "")
    stop = entry.get("stopLoss", "")
    risk = entry.get("risk", "")
    cat = entry.get("category", "")
    expiry = entry.get("expiry", "")
    short_name = entry.get("shortName", "")
    is_put = entry.get("isPut", 0)

    expiry_str = ""
    try:
        if expiry and str(expiry).isdigit() and int(expiry) > 1000000000:
            from datetime import datetime
            exp_dt = datetime.fromtimestamp(int(expiry))
            expiry_str = f" {exp_dt.month}/{exp_dt.day}/{str(exp_dt.year)[2:]}"
    except: pass

    side = "P" if is_put else "C"
    if "OPTION" in label.upper() and strike:
        title = f"{sym} {strike}{side}{expiry_str}"
    else:
        title = sym

    lines = [f"📊 {title} — {label}"]
    if short_name: lines.append(short_name)
    row = []
    if buy: row.append(f"Buy {buy}")
    if sell: row.append(f"T1 {sell}")
    if sell2: row.append(f"T2 {sell2}")
    if stop: row.append(f"SL {stop}")
    if row: lines.append(" | ".join(row))
    tags = []
    if cat: tags.append(cat)
    if risk: tags.append(f"Risk:{risk}")
    if tags: lines.append("[" + ", ".join(tags) + "]")
    return "\n".join(lines)


def _format_closed(entry, kind):
    sym = entry.get("symbol", "?")
    strike = entry.get("strike", "")
    status = entry.get("status", "")
    buy = entry.get("buyTarget", "")
    sell = entry.get("sellTarget", "")
    cat = entry.get("category", "")
    expiry = entry.get("expiry", "")
    is_put = entry.get("isPut", 0)
    expiry_str = ""
    try:
        if expiry and str(expiry).isdigit() and int(expiry) > 1000000000:
            from datetime import datetime
            exp_dt = datetime.fromtimestamp(int(expiry))
            expiry_str = f" {exp_dt.month}/{exp_dt.day}/{str(exp_dt.year)[2:]}"
    except: pass
    side = "P" if is_put else "C"
    if kind == "OPTION" and strike:
        title = f"{sym} {strike}{side}{expiry_str}"
    else:
        title = sym
    lines = [f"📕 {title} — Closed"]
    if status: lines.append(status)
    if buy and sell: lines.append(f"Buy {buy} → Sell {sell}")
    if cat: lines.append(f"[{cat}]")
    return "\n".join(lines)


def _format_mgmt(entry):
    title = entry.get("title", "")
    msg = entry.get("message", "")
    cat = entry.get("category", "")
    sym = entry.get("symbol", "?")
    emoji = "📋"
    if "stopped" in msg.lower(): emoji = "🛑"
    elif ("target" in msg.lower() and ("reach" in msg.lower() or "lock" in msg.lower())): emoji = "🎯"
    elif "stc" in title.lower() or "sell" in title.lower(): emoji = "💰"
    lines = [f"{emoji} {title}" if title else f"{emoji} {sym}"]
    if msg: lines.append(msg)
    if cat: lines.append(f"[{cat}]")
    return "\n".join(lines)


# --- Trade Signals (Name/) ---
def relay_ts_picks(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("ts_picks_sent", []))
    new = []
    for fname, label in [("ts_short_term_options", "TS ST OPTION"),
                          ("ts_long_term_options", "TS LT OPTION"),
                          ("ts_short_term_stocks", "TS ST STOCK"),
                          ("ts_long_term_stocks", "TS LT STOCK")]:
        d = read_data(fname)
        if not d or not isinstance(d, dict): continue
        for k, e in d.items():
            if not isinstance(e, dict): continue
            sk = f"tsp|{fname}|{k}"
            if sk in sent: continue
            if _post_to("ts_picks", _format_pick(e, label), "ts_picks"):
                new.append(sk)
                logging.info(f"[ts_picks] posted {e.get('symbol','?')}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["ts_picks_sent"] = list(set(state.get("ts_picks_sent", []) + new))[-5000:]
                return state
                time.sleep(1.2)
    if new: state["ts_picks_sent"] = list(sent | set(new))[-5000:]
    return state


def relay_ts_closed(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("ts_closed_sent", []))
    new = []
    for fname, kind in [("ts_closed_options", "OPTION"), ("ts_closed_stocks", "STOCK")]:
        d = read_data(fname)
        if not d or not isinstance(d, dict): continue
        for k, e in d.items():
            if not isinstance(e, dict): continue
            sk = f"tsc|{fname}|{k}"
            if sk in sent: continue
            if _post_to("ts_closed", _format_closed(e, kind), "ts_closed"):
                new.append(sk)
                logging.info(f"[ts_closed] posted {e.get('symbol','?')}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["ts_closed_sent"] = list(set(state.get("ts_closed_sent", []) + new))[-5000:]
                return state
                time.sleep(1.2)
    if new: state["ts_closed_sent"] = list(sent | set(new))[-5000:]
    return state


def relay_ts_mgmt(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("ts_mgmt_sent", []))
    new = []
    for fname in ["ts_option_notifications", "ts_stock_notifications"]:
        d = read_data(fname)
        if not d or not isinstance(d, dict): continue
        for k, e in d.items():
            if not isinstance(e, dict): continue
            sk = f"tsm|{fname}|{k}"
            if sk in sent: continue
            if not (e.get("title") or e.get("message")): continue
            if _post_to("ts_mgmt", _format_mgmt(e), "ts_mgmt"):
                new.append(sk)
                logging.info(f"[ts_mgmt] posted {e.get('title','?')[:30]}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["ts_mgmt_sent"] = list(set(state.get("ts_mgmt_sent", []) + new))[-5000:]
                return state
                time.sleep(1.2)
    if new: state["ts_mgmt_sent"] = list(sent | set(new))[-5000:]
    return state


# --- Stock Signals (Name2/) ---
def relay_ss_picks(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("ss_picks_sent", []))
    new = []
    for fname, label in [("ss_short_term_options", "SS ST OPTION"),
                          ("ss_long_term_options", "SS LT OPTION"),
                          ("ss_short_term_stocks", "SS ST STOCK"),
                          ("ss_long_term_stocks", "SS LT STOCK")]:
        d = read_data(fname)
        if not d or not isinstance(d, dict): continue
        for k, e in d.items():
            if not isinstance(e, dict): continue
            sk = f"ssp|{fname}|{k}"
            if sk in sent: continue
            if _post_to("ss_picks", _format_pick(e, label), "ss_picks"):
                new.append(sk)
                logging.info(f"[ss_picks] posted {e.get('symbol','?')}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["ss_picks_sent"] = list(set(state.get("ss_picks_sent", []) + new))[-5000:]
                return state
                time.sleep(1.2)
    if new: state["ss_picks_sent"] = list(sent | set(new))[-5000:]
    return state


def relay_ss_closed(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("ss_closed_sent", []))
    new = []
    for fname, kind in [("ss_closed_options", "OPTION"), ("ss_closed_stocks", "STOCK")]:
        d = read_data(fname)
        if not d or not isinstance(d, dict): continue
        for k, e in d.items():
            if not isinstance(e, dict): continue
            sk = f"ssc|{fname}|{k}"
            if sk in sent: continue
            if _post_to("ss_closed", _format_closed(e, kind), "ss_closed"):
                new.append(sk)
                logging.info(f"[ss_closed] posted {e.get('symbol','?')}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["ss_closed_sent"] = list(set(state.get("ss_closed_sent", []) + new))[-5000:]
                return state
                time.sleep(1.2)
    if new: state["ss_closed_sent"] = list(sent | set(new))[-5000:]
    return state


def relay_ss_mgmt(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("ss_mgmt_sent", []))
    new = []
    for fname in ["ss_option_notifications", "ss_stock_notifications"]:
        d = read_data(fname)
        if not d or not isinstance(d, dict): continue
        for k, e in d.items():
            if not isinstance(e, dict): continue
            sk = f"ssm|{fname}|{k}"
            if sk in sent: continue
            if not (e.get("title") or e.get("message")): continue
            if _post_to("ss_mgmt", _format_mgmt(e), "ss_mgmt"):
                new.append(sk)
                logging.info(f"[ss_mgmt] posted {e.get('title','?')[:30]}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["ss_mgmt_sent"] = list(set(state.get("ss_mgmt_sent", []) + new))[-5000:]
                return state
                time.sleep(1.2)
    if new: state["ss_mgmt_sent"] = list(sent | set(new))[-5000:]
    return state


# --- OS Closed Stocks (Vivid2/ClosedStocks — currently scraped, never routed) ---
def relay_os_closed_stocks(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("os_closed_stocks_sent", []))
    new = []
    d = read_data("closed_stocks")
    if not d or not isinstance(d, dict): return state
    for k, e in d.items():
        if not isinstance(e, dict): continue
        sk = f"osc|{k}"
        if sk in sent: continue
        if _post_to("os_closed_stocks", _format_closed(e, "STOCK"), "os_closed_stocks"):
            new.append(sk)
            logging.info(f"[os_closed_stocks] posted {e.get('symbol','?')}")
            _posted_count += 1
            if _posted_count >= _max_per_cycle:
                if new: state["os_closed_stocks_sent"] = list(set(state.get("os_closed_stocks_sent", []) + new))[-5000:]
                return state
            time.sleep(1.2)
    if new: state["os_closed_stocks_sent"] = list(sent | set(new))[-5000:]
    return state


# --- FG1 + FG2 Sentiment (BullBears) ---
def _format_sentiment(ticker, entry):
    if not isinstance(entry, dict): return None
    bull = entry.get("bullish", entry.get("Bullish", entry.get("bull", 0)))
    bear = entry.get("bearish", entry.get("Bearish", entry.get("bear", 0)))
    try:
        bull_n = float(bull) if bull else 0
        bear_n = float(bear) if bear else 0
    except: bull_n = bear_n = 0
    if bull_n == 0 and bear_n == 0: return None
    total = bull_n + bear_n
    bull_pct = (bull_n / total * 100) if total else 0
    arrow = "🟢" if bull_pct > 60 else ("🔴" if bull_pct < 40 else "⚪")
    return f"{arrow} {ticker}: {bull_pct:.0f}% bull / {100-bull_pct:.0f}% bear (vol {int(total)})"


def relay_fg1_sentiment(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("fg1_sent_sent", []))
    new = []
    d = read_data("flow_bullbears_today")
    if not d or not isinstance(d, dict): return state
    for ticker, entry in d.items():
        sk = f"fg1s|{ticker}|{json.dumps(entry, sort_keys=True)[:60] if isinstance(entry, dict) else entry}"
        if sk in sent: continue
        msg = _format_sentiment(ticker, entry)
        if not msg: continue
        if _post_to("fg1_sentiment", msg, "fg1_sentiment"):
            new.append(sk)
            time.sleep(1.2)
    if new: state["fg1_sent_sent"] = list(sent | set(new))[-3000:]
    return state


def relay_fg2_sentiment(state):
    _max_per_cycle = 200
    _posted_count = 0
    sent = set(state.get("fg2_sent_sent", []))
    new = []
    d = read_data("flow2_bullbears")
    if not d or not isinstance(d, dict): return state
    # Schema is {"today": {ticker: {...}}} — drill down if needed
    if "today" in d and isinstance(d.get("today"), dict):
        d = d["today"]
    elif "today" in d:
        return state  # today exists but is not a dict (empty string), nothing to post
    for ticker, entry in d.items():
        sk = f"fg2s|{ticker}|{json.dumps(entry, sort_keys=True)[:60] if isinstance(entry, dict) else entry}"
        if sk in sent: continue
        msg = _format_sentiment(ticker, entry)
        if not msg: continue
        if _post_to("fg2_sentiment", msg, "fg2_sentiment"):
            new.append(sk)
            time.sleep(1.2)
    if new: state["fg2_sent_sent"] = list(sent | set(new))[-3000:]
    return state




def relay_synthetic_analysis(state):
    """Compute synthetic bull/bear sentiment per ticker from FG1 LiveFlows.
    Bullish trades: (CALL @ ASK) or (PUT @ BID) — buyers paying up to be long calls or short puts
    Bearish trades: (CALL @ BID) or (PUT @ ASK) — sellers letting them go cheap or buying puts
    Posts hourly rollup of top 20 tickers by total premium volume.
    """
    import datetime as _dt
    _max_per_cycle = 1  # only post once per cycle
    _posted_count = 0

    # Hourly cadence — only post if last post was over 55 min ago
    last_post = state.get("synthetic_analysis_last_post", 0)
    now = int(time.time())
    if now - last_post < 55 * 60:
        return state

    d = read_data("flow_live_last100")
    if not d or not isinstance(d, dict):
        # Try LiveFlows today as fallback
        d = read_data("flow_liveflows_today")
        if not d or not isinstance(d, dict):
            return state

    # Aggregate per ticker
    ticker_stats = {}
    for entry_id, entry in d.items():
        if not isinstance(entry, dict): continue
        sym = entry.get("Symbol", "")
        if not sym: continue
        opt_type = entry.get("OptionType", "")
        bid_ask = entry.get("BidAskType", "")
        value = float(entry.get("Value", 0) or 0)
        if value <= 0: continue

        # Determine direction
        is_bullish = (opt_type == "CALL" and bid_ask == "A") or (opt_type == "PUT" and bid_ask == "B")
        is_bearish = (opt_type == "CALL" and bid_ask == "B") or (opt_type == "PUT" and bid_ask == "A")
        if not (is_bullish or is_bearish): continue

        s = ticker_stats.setdefault(sym, {"bull_count": 0, "bear_count": 0, "bull_prem": 0.0, "bear_prem": 0.0, "total_prem": 0.0})
        if is_bullish:
            s["bull_count"] += 1
            s["bull_prem"] += value
        else:
            s["bear_count"] += 1
            s["bear_prem"] += value
        s["total_prem"] += value

    if not ticker_stats:
        return state

    # Sort by total premium, take top 20
    top = sorted(ticker_stats.items(), key=lambda x: x[1]["total_prem"], reverse=True)[:20]

    # Build the message
    def fmt_prem(v):
        if v >= 1_000_000: return f"${v/1_000_000:.1f}M"
        if v >= 1_000: return f"${v/1_000:.0f}K"
        return f"${v:.0f}"

    ts_str = _dt.datetime.now().strftime("%H:%M ET")
    lines = [f"📊 **Synthetic Sentiment Rollup** — {ts_str}", f"Top 20 tickers by total options premium:", "```"]
    lines.append(f"{'TKR':<6} {'BULL$':<9} {'BEAR$':<9} {'B/B%':<8} {'TOT$':<9}")
    for sym, s in top:
        bull_pct = (s["bull_prem"] / s["total_prem"] * 100) if s["total_prem"] > 0 else 0
        emoji = "🟢" if bull_pct >= 60 else "🔴" if bull_pct <= 40 else "🟡"
        lines.append(f"{sym:<6} {fmt_prem(s['bull_prem']):<9} {fmt_prem(s['bear_prem']):<9} {emoji}{bull_pct:>5.0f}%  {fmt_prem(s['total_prem']):<9}")
    lines.append("```")
    msg = "\n".join(lines)

    if _post_to("synthetic_analysis", msg, "synthetic_analysis"):
        state["synthetic_analysis_last_post"] = now
        logging.info(f"[synthetic_analysis] posted hourly rollup, {len(top)} tickers")
    return state


def relay_flow2_phone_mirror(state):
    """Mirror FlowGreeks2 alerts to #flow-messages in phone-notification format.
    Reads same data as relay_flow2_alerts but separate sent-tracking and posts as plain text."""
    data = read_data("flow2_alerts_today")
    if not data or not isinstance(data, dict):
        return state
    sent = set(state.get("flow2_phone_sent", []))
    new_sent = []

    # AlertType → notification header mapping
    # Match AlertType values from live FlowGreeks2 data, paired with isBullish + UnderlyingType
    def _header(alert_type, is_bullish, underlying):
        direction = "Bullish" if is_bullish else "Bearish"
        is_etf = (underlying or "").upper() == "ETF"
        prefix = "ETF: " if is_etf else ""
        if alert_type == "weekly_flow" or alert_type == "weekly_flow_etf":
            kind = "Rapid"
        elif alert_type == "repeat_flow" or alert_type == "repeat_flow_etf":
            kind = "Repeated"
        else:
            kind = "Unusual"
        return f"{prefix}{kind} {direction} Flow Alert!"


    def fmt_premium(val):
        try:
            v = float(val)
        except Exception:
            return "0"
        if v >= 1_000_000:
            return f"{v/1_000_000:.1f}M"
        if v >= 1_000:
            return f"{v/1_000:.0f}K"
        return f"{v:.0f}"

    for option_symbol, entry in data.items():
        if not isinstance(entry, dict):
            continue
        alert = entry.get("alert", {})
        if not alert:
            continue
        # Only mirror what the phone would have notified
        if alert.get("NotifyAlert", 0) != 1:
            continue
        # Dedupe: ticker + alertType + flow_count keeps re-fires of the same alert level out
        symbol = alert.get("Symbol", "")
        alert_type = alert.get("AlertType", "")
        flow_count = alert.get("totalFlowCount", 0)
        flow_value = alert.get("totalFlowValue", 0)
        sent_key = f"{option_symbol}|{alert_type}|{flow_count}"
        if sent_key in sent:
            continue

        header = _header(alert_type, alert.get("isBullish", False), alert.get("UnderlyingType", ""))
        premium_str = fmt_premium(flow_value)

        # Parse OptionSymbol "SPY260424P00710000" → "SPY 710P 4/24/26"
        _m = re.match(r"^([A-Z]+)(\d{2})(\d{2})(\d{2})([CP])(\d{8})$", option_symbol)
        if _m:
            _ticker, _yr, _mo, _day, _opt, _strike_raw = _m.groups()
            _strike_dollars = int(_strike_raw) // 1000
            title_line = f"{_ticker} {_strike_dollars}{_opt} {int(_mo)}/{int(_day)}/{_yr}"
        else:
            title_line = symbol

        msg = (
            f"{title_line}\n"
            f"{header}\n"
            f"Flow count: {flow_count}, Premium: {premium_str} !!"
        )

        try:
            url = WEBHOOKS.get("flow_messages")
            if not url:
                continue
            r = requests.post(url, json={"content": msg}, timeout=10)
            if r.status_code in (200, 204):
                new_sent.append(sent_key)
                logging.info(f"[flow_messages] posted {symbol} {alert_type} count={flow_count} premium={premium_str}")
            elif r.status_code == 429:
                retry = r.json().get("retry_after", 5)
                logging.warning(f"[flow_messages] rate limited, sleeping {retry}s")
                time.sleep(retry)
            else:
                logging.warning(f"[flow_messages] HTTP {r.status_code}: {r.text[:200]}")
        except Exception as e:
            logging.warning(f"[flow_messages] post error: {e}")

    if new_sent:
        all_sent = list(sent | set(new_sent))
        # Cap tracked IDs to last 5000 to avoid unbounded growth
        state["flow2_phone_sent"] = all_sent[-5000:]
    return state


def relay_flow2_alerts(state):
    data = read_data("flow2_alerts_today")
    if not data or not isinstance(data, dict):
        return state
    sent = set(state.get("flow2_alerts", []))
    new_sent = []
    for key, entry in data.items():
        if key in sent:
            continue
        alert = entry.get("alert", entry)
        sym = alert.get("Symbol", "?")
        strike = alert.get("Strike", "?")
        opt_type = alert.get("OptionType", "?")
        expiry = format_expiry(alert.get("Expiry", 0))
        bullish = alert.get("isBullish", False)
        sweeps = alert.get("SWEEPS", 0)
        blocks = alert.get("BLOCKS", 0)
        flow_val = alert.get("totalFlowValue", 0)
        vol = alert.get("Volume", "?")
        oi = alert.get("OI", "?")
        alert_price = float(alert.get("AlertPrice", 0) or 0)
        spot = alert.get("Spot", 0)
        dte = alert.get("DTE", "?")
        trade_count = alert.get("trade_count", alert.get("NumOfAlerts", "?"))

        # Enrich with Finnhub option quote
        quote = finnhub_option_quote(sym, strike, opt_type, alert.get("Expiry", 0)) if alert.get("Expiry") else None
        last_price = quote["last"] if quote and quote.get("last") else None
        day_high = quote["high"] if quote and quote.get("high") else None
        day_low = quote["low"] if quote and quote.get("low") else None

        # Calculate gains
        gain_pct = "?"
        max_gain_pct = "?"
        if last_price and alert_price > 0:
            gain_pct = f"{((last_price - alert_price) / alert_price * 100):+.2f}%"
        if day_high and alert_price > 0:
            max_gain_pct = f"{((day_high - alert_price) / alert_price * 100):+.2f}%"

        fields = [
            {"name": "Flow Premium", "value": f"**{format_value(flow_val)}**", "inline": True},
            {"name": "Size/OI", "value": f"{vol} / {oi}", "inline": True},
            {"name": "\u200b", "value": "\u200b", "inline": True},
            {"name": "Sweeps / Blocks", "value": f"{sweeps} / {blocks}", "inline": True},
            {"name": "Alerted Price", "value": f"${alert_price}", "inline": True},
            {"name": "DTE", "value": str(dte), "inline": True},
        ]

        if last_price is not None:
            fields.extend([
                {"name": "Last Price", "value": f"${last_price}", "inline": True},
                {"name": "Gain %", "value": str(gain_pct), "inline": True},
                {"name": "Max Gain %", "value": str(max_gain_pct), "inline": True},
            ])
            if day_high is not None:
                fields.append({"name": "Highest After", "value": f"${day_high}", "inline": True})

        embed = {
            "title": f"{'🟢' if bullish else '🔴'} {sym} ${strike}{opt_type[0]} {expiry}",
            "color": GREEN if bullish else RED,
            "fields": fields,
            "footer": {"text": f"FlowGreeks2 | {format_timestamp(alert.get('Time', 0))}"}
        }
        channel = get_flow_channel(alert.get("AlertType", ""))
        posted = post_embed(channel, embed)
        post_embed("flow_alerts_fg", embed)  # also post to original fg firehose
        if posted:
            new_sent.append(key)
            time.sleep(1.5)  # extra delay for finnhub rate limit
    state["flow2_alerts"] = list(sent | set(new_sent))
    return state

# ─── RELAY: FLOWGREEKS2 LIVE FLOWS ───────────────────────────────────────────
def relay_flow2_live(state):
    data = read_data("flow2_liveflows_today")
    if not data or not isinstance(data, dict):
        return state
    sent = set(state.get("flow2_live", []))
    new_sent = []
    unseen = [(k, v) for k, v in data.items() if k not in sent]
    unseen.sort(key=lambda x: int(x[0]), reverse=True)
    for key, entry in unseen[:10]:
        sym = entry.get("Symbol", "?")
        strike = entry.get("Strike", "?")
        opt_type = entry.get("OptionType", "?")
        block_type = entry.get("BlockType", "?")
        bid_ask = entry.get("BidAskType", "?")
        expiry_str = entry.get("ExpiryStr", "?")
        value = format_value(entry.get("Value", 0))
        vol = entry.get("Volume", "?")
        oi = entry.get("OI", "?")
        spot = entry.get("Spot", "?")
        price = entry.get("Price", "?")
        bullish = (opt_type == "CALL" and bid_ask == "A") or (opt_type == "PUT" and bid_ask == "B")
        side = "ASK" if bid_ask == "A" else "BID"
        emoji = "🟢" if bullish else "🔴"
        type_emoji = "⚡" if block_type == "SWEEP" else "📦"
        embed = {
            "title": f"{emoji} {sym} ${strike}{opt_type[0]} {expiry_str} | {type_emoji} {block_type}",
            "color": GREEN if bullish else RED,
            "description": f"**{side}** @ ${price} | {value} total",
            "fields": [
                {"name": "Volume", "value": str(vol), "inline": True},
                {"name": "OI", "value": str(oi), "inline": True},
                {"name": "Spot", "value": f"${spot}", "inline": True},
            ],
            "footer": {"text": f"FlowGreeks2 | {format_timestamp(entry.get('Time', 0))}"}
        }
        if post_embed("flow_live", embed):
            new_sent.append(key)
            time.sleep(0.8)
    all_sent = list(sent | set(new_sent))
    state["flow2_live"] = all_sent[-500:]
    return state

# ─── MAIN LOOP ────────────────────────────────────────────────────────────────
def run():
    logging.info("=" * 60)
    logging.info("Option Signals Discord Relay starting")
    logging.info(f"Polling interval: {POLL_INTERVAL}s")
    logging.info(f"Data dir: {DATA_DIR}")
    logging.info(f"Webhooks: {len(WEBHOOKS)} channels")
    logging.info("=" * 60)

    state = load_state()
    cycle = 0

    while True:
        try:
            state = relay_flow_alerts(state)
            state = relay_flow_live(state)
            state = relay_option_notifications(state)
            state = relay_stock_notifications(state)
            state = relay_short_term_options(state)
            state = relay_long_term_options(state)
            state = relay_long_term_stocks(state)
            state = relay_closed_trades(state)
            state = relay_flow2_alerts(state)
            state = relay_flow2_phone_mirror(state)
            # === MIRROR_BLOCK_INSERTED ===
            state = relay_winners_mirror(state)
            state = relay_ts_picks(state)
            state = relay_ts_closed(state)
            state = relay_ts_mgmt(state)
            state = relay_ss_picks(state)
            state = relay_ss_closed(state)
            state = relay_ss_mgmt(state)
            state = relay_os_closed_stocks(state)
            state = relay_fg1_sentiment(state)
            state = relay_fg2_sentiment(state)
            state = relay_flow2_live(state)
            save_state(state)

            if cycle % 10 == 0:
                logging.info(f"Relay cycle {cycle} complete — tracking {sum(len(v) for v in state.values() if isinstance(v, list))} sent IDs")

            cycle += 1

        except Exception as e:
            logging.error(f"Relay cycle error: {e}", exc_info=True)

        time.sleep(POLL_INTERVAL)

if __name__ == "__main__":
    try:
        run()
    except KeyboardInterrupt:
        logging.info("Relay stopped by user")
    except Exception as e:
        logging.critical(f"Relay crashed: {e}", exc_info=True)
        raise
