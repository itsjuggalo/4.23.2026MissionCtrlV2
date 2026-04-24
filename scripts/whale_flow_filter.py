#!/usr/bin/env python3
"""
whale_flow_filter.py
Reads FlowGreeks scraped data and posts only $1M+ options flow
to a dedicated Discord webhook channel.
Run via cron every 5 minutes alongside the main scraper.
"""

import requests
import json
import os
import time
from datetime import datetime, timezone, timedelta

SECRETS_DIR = "/home/ubuntu/.openclaw/secrets"
DATA_DIR = "/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data"
SENT_FILE = os.path.join(DATA_DIR, "whale_sent_ids.json")
MIN_VALUE = 1_000_000  # $1M minimum

EST = timezone(timedelta(hours=-4))


def load_secret(name):
    path = os.path.join(SECRETS_DIR, name)
    if os.path.exists(path):
        with open(path) as f:
            return f.read().strip()
    return None


WHALE_WEBHOOK = load_secret("discord_whale_flow_webhook")


def load_sent_ids():
    if os.path.exists(SENT_FILE):
        with open(SENT_FILE) as f:
            return set(json.load(f))
    return set()


def save_sent_ids(sent):
    with open(SENT_FILE, "w") as f:
        json.dump(list(sent), f)


def parse_value(val):
    """Parse value string like '$1,234,567' or numeric."""
    if isinstance(val, (int, float)):
        return float(val)
    if isinstance(val, str):
        cleaned = val.replace("$", "").replace(",", "").strip()
        try:
            return float(cleaned)
        except:
            return 0
    return 0


def format_whale_embed(flow):
    """Create a Discord embed for a whale flow alert."""
    symbol = flow.get("Symbol", flow.get("symbol", "???"))
    strike = flow.get("Strike", flow.get("strike", "?"))
    expiry = flow.get("ExpiryStr", flow.get("Expiry", flow.get("expiry", "?")))
    opt_type = flow.get("OptionType", flow.get("optionType", "?"))
    value = parse_value(flow.get("Value", flow.get("value", flow.get("totalFlowValue", 0))))
    volume = flow.get("Volume", flow.get("volume", "?"))
    oi = flow.get("OI", flow.get("oi", flow.get("openInterest", "?")))
    block_type = flow.get("BlockType", flow.get("blockType", flow.get("type", "?")))
    bid_ask = flow.get("BidAskType", flow.get("bidAskType", flow.get("side", "?")))
    spot = flow.get("SpotPrice", flow.get("spotPrice", flow.get("spot", "?")))
    is_bullish = flow.get("isBullish", None)

    # Determine sentiment
    if is_bullish is True:
        sentiment = "🟢 BULLISH"
        color = 0x00ff00
    elif is_bullish is False:
        sentiment = "🔴 BEARISH"
        color = 0xff0000
    elif bid_ask and "ask" in str(bid_ask).lower():
        sentiment = "🟢 BOUGHT (ASK)"
        color = 0x00ff00
    elif bid_ask and "bid" in str(bid_ask).lower():
        sentiment = "🔴 SOLD (BID)"
        color = 0xff0000
    else:
        sentiment = "⚪ NEUTRAL"
        color = 0x808080

    # Format value
    if value >= 10_000_000:
        val_str = f"${value/1_000_000:.1f}M 🐋🐋🐋"
    elif value >= 5_000_000:
        val_str = f"${value/1_000_000:.1f}M 🐋🐋"
    else:
        val_str = f"${value/1_000_000:.1f}M 🐋"

    opt_letter = str(opt_type)[0].upper() if opt_type else "?"
    title = f"🐋 {symbol} ${strike}{opt_letter} {expiry}"

    now_est = datetime.now(EST).strftime("%I:%M %p EST")

    sweeps = flow.get("SWEEPS", flow.get("sweeps", "?"))
    blocks = flow.get("BLOCKS", flow.get("blocks", "?"))
    alert_price = flow.get("AlertPrice", flow.get("alertPrice", flow.get("Price", flow.get("price", None))))
    dte = flow.get("DTE", flow.get("dte", "?"))
    alert_type = flow.get("AlertType", flow.get("alertType", flow.get("alert_type", "")))
    trades = flow.get("trade_count", flow.get("Trades", flow.get("trades", "?")))

    # Check nested alert object
    alert_obj = flow.get("alert", {})
    if isinstance(alert_obj, dict) and alert_obj:
        sweeps = sweeps if sweeps != "?" else alert_obj.get("SWEEPS", "?")
        blocks = blocks if blocks != "?" else alert_obj.get("BLOCKS", "?")
        alert_price = alert_price or alert_obj.get("AlertPrice")
        dte = dte if dte != "?" else alert_obj.get("DTE", "?")
        alert_type = alert_type or alert_obj.get("AlertType", "")
        trades = trades if trades != "?" else alert_obj.get("trade_count", "?")
        if not volume or volume == "?":
            volume = alert_obj.get("Volume", "?")
        if not oi or oi == "?":
            oi = alert_obj.get("OI", "?")

    # Check nested quote object for last price / gain
    quote = flow.get("quote", {})
    last_price = None
    day_high = None
    if isinstance(quote, dict) and quote:
        last_price = quote.get("Last", quote.get("last", quote.get("lastPrice")))
        day_high = quote.get("DayHigh", quote.get("dayHigh", quote.get("highPrice", quote.get("High"))))

    fields = [
        {"name": "Flow Premium", "value": f"**{val_str}**", "inline": True},
        {"name": "Size / OI", "value": f"{volume} / {oi}", "inline": True},
        {"name": "​", "value": "​", "inline": True},
        {"name": "Sweeps / Blocks", "value": f"{sweeps} / {blocks}", "inline": True},
        {"name": "Alerted Price", "value": f"${alert_price}" if alert_price else "?", "inline": True},
        {"name": "DTE", "value": str(dte), "inline": True},
    ]

    if last_price:
        try:
            lp = float(last_price)
            ap = float(alert_price) if alert_price else 0
            gain = ((lp - ap) / ap * 100) if ap > 0 else 0
            fields.append({"name": "Last Price", "value": f"${lp}", "inline": True})
            fields.append({"name": "Gain %", "value": f"{gain:+.2f}%", "inline": True})
        except:
            pass

    if day_high:
        try:
            dh = float(day_high)
            ap = float(alert_price) if alert_price else 0
            max_gain = ((dh - ap) / ap * 100) if ap > 0 else 0
            fields.append({"name": "Max Gain %", "value": f"{max_gain:+.2f}%", "inline": True})
            fields.append({"name": "Highest After", "value": f"${dh}", "inline": True})
        except:
            pass

    if spot and spot != "?":
        fields.append({"name": "Spot", "value": f"${spot}", "inline": True})

    if alert_type:
        fields.append({"name": "Alert Type", "value": str(alert_type), "inline": True})

    embed = {
        "title": title,
        "color": color,
        "fields": fields,
        "footer": {"text": f"Whale Flow Filter | {now_est}"},
    }

    return embed


def scan_flow_files():
    """Read all FlowGreeks data files and extract high-value flows."""
    whales = []

    flow_files = [
        "flow_live_last100.json",
        "flow_alerts_today.json",
        "flow2_alerts_today.json",
        "flow2_live_today.json",
    ]

    for fname in flow_files:
        fpath = os.path.join(DATA_DIR, fname)
        if not os.path.exists(fpath):
            continue

        try:
            with open(fpath) as f:
                data = json.load(f)
        except:
            continue

        # Handle different data structures
        items = []
        if isinstance(data, list):
            items = data
        elif isinstance(data, dict):
            # Could be keyed by ID or nested
            for key, val in data.items():
                if isinstance(val, dict):
                    val["_key"] = key
                    items.append(val)
                elif isinstance(val, list):
                    items.extend(val)

        for item in items:
            # Try multiple field names for value
            value = 0
            for field in ["Value", "value", "totalFlowValue", "total_value", "premium"]:
                if field in item:
                    value = parse_value(item[field])
                    if value > 0:
                        break

            if value >= MIN_VALUE:
                # Create a unique ID
                symbol = item.get("Symbol", item.get("symbol", "?"))
                strike = item.get("Strike", item.get("strike", "?"))
                uid = f"{fname}_{symbol}_{strike}_{value}"
                item["_uid"] = uid
                item["_value"] = value
                item["_source"] = fname
                whales.append(item)

    return whales


def main():
    if not WHALE_WEBHOOK:
        print("❌ No whale webhook found. Save it to:")
        print("   ~/.openclaw/secrets/discord_whale_flow_webhook")
        return

    sent = load_sent_ids()
    whales = scan_flow_files()

    new_whales = [w for w in whales if w["_uid"] not in sent]

    if not new_whales:
        return  # Silent — nothing to report

    print(f"🐋 Found {len(new_whales)} new whale flows ($1M+)")

    for whale in new_whales:
        embed = format_whale_embed(whale)

        payload = {
            "username": "🐋 Whale Flow",
            "embeds": [embed],
        }

        try:
            resp = requests.post(WHALE_WEBHOOK, json=payload, timeout=10)
            if resp.status_code == 429:
                retry = resp.json().get("retry_after", 5)
                time.sleep(retry)
                resp = requests.post(WHALE_WEBHOOK, json=payload, timeout=10)

            if resp.status_code in (200, 204):
                sent.add(whale["_uid"])
                print(f"  ✅ {whale.get('Symbol', '?')} ${whale['_value']/1_000_000:.1f}M")
            else:
                print(f"  ❌ Discord {resp.status_code}")
        except Exception as e:
            print(f"  ❌ {e}")

        time.sleep(1.5)

    save_sent_ids(sent)


if __name__ == "__main__":
    main()
