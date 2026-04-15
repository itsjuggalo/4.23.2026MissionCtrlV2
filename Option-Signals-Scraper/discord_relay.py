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
    "flow_alerts":      "https://discordapp.com/api/webhooks/1493401894310383826/uUUHIRv3GqVncJCftpCQTAZ-9Erdjk45AH0BMZhQXOfgvqFqNOEZtbPAj3_SnxJMADU3",
    "flow_live":        "https://discordapp.com/api/webhooks/1493402170119159909/Pqs3pyN8ZyVzYOInm9AW-_ez5LsMZhkoFJK-X-mZAFJMK2bV95qmmochnF5v6e2H1N43",
    "scalp_signals":    "https://discordapp.com/api/webhooks/1493402271642554409/v4hJfM6w6aW34oqsIWtten7apGe6YmkCgrU1v-ppyOPkxgUGTSxY6JzvVlqWFbzQ5GGI",
    "swing_signals":    "https://discordapp.com/api/webhooks/1493402334716493916/3Pninv0bIWOO8FXb6CAzDTD5K-n0wy61xuR0luhCwZjqXXokOB4NhKwoC2qyZHLmX0be",
    "stock_signals":    "https://discordapp.com/api/webhooks/1493402402299052052/LjR3bHljamFb-pcrwPsZumUJSgGw7Za-aXC2PbRyGDunAEVAXI2-5LMm014U9XVcjnfr",
    "long_term_options": "https://discordapp.com/api/webhooks/1493402455176646831/3xbaAmcPNhFgKvCaBchfFVlrogOBh8iMNe9hTh_MWwNKk3MzlGPeFl3fMPdSuPbuU2o0",
    "long_term_stocks":  "https://discordapp.com/api/webhooks/1493402513502634186/GiXkTE0VhdbCZER4l8THB9TfaR4pJ6x84Ilnm-JZI-UY9nVxNGK86-B1pgxy4uINHgKj",
    "closed_trades":    "https://discordapp.com/api/webhooks/1493402563410788442/hQLE4DY3WmKhumUcWNsiHxIdRBQIjXkwV3_n89WaUxWvrhvpar8jMwHvdsBLUnCmcS5D",
}

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

        embed = {
            "title": f"{'🟢' if bullish else '🔴'} {sym} ${strike}{opt_type[0]} {expiry}",
            "color": GREEN if bullish else RED,
            "fields": [
                {"name": "Alert Type", "value": alert.get("AlertType", "?"), "inline": True},
                {"name": "Flow Value", "value": format_value(alert.get("totalFlowValue", 0)), "inline": True},
                {"name": "Volume / OI", "value": f"{alert.get('Volume', '?')} / {alert.get('OI', '?')}", "inline": True},
                {"name": "Sweeps / Blocks", "value": f"{sweeps} / {blocks}", "inline": True},
                {"name": "Spot", "value": f"${alert.get('Spot', '?')}", "inline": True},
                {"name": "DTE", "value": str(alert.get("DTE", "?")), "inline": True},
                {"name": "Trades", "value": str(alert.get("trade_count", "?")), "inline": True},
                {"name": "Last Price", "value": f"${quote.get('Last', '?')}", "inline": True},
            ],
            "footer": {"text": f"Option Signals Flow | {format_timestamp(alert.get('Time', 0))}"}
        }

        if post_embed("flow_alerts", embed):
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
        embed = {
            "title": f"{'🟢' if bullish else '🔴'} {sym} ${strike}{opt_type[0]} {expiry}",
            "color": GREEN if bullish else RED,
            "fields": [
                {"name": "Alert Type", "value": alert.get("AlertType", "?"), "inline": True},
                {"name": "Flow Value", "value": format_value(alert.get("totalFlowValue", 0)), "inline": True},
                {"name": "Volume / OI", "value": f"{alert.get('Volume', '?')} / {alert.get('OI', '?')}", "inline": True},
                {"name": "Sweeps / Blocks", "value": f"{sweeps} / {blocks}", "inline": True},
                {"name": "Spot", "value": f"${alert.get('Spot', '?')}", "inline": True},
                {"name": "DTE", "value": str(alert.get("DTE", "?")), "inline": True},
            ],
            "footer": {"text": f"FlowGreeks2 | {format_timestamp(alert.get('Time', 0))}"}
        }
        if post_embed("flow_alerts", embed):
            new_sent.append(key)
            time.sleep(1)
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
