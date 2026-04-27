#!/usr/bin/env python3
"""Read JSONL, summarize last 4h, post Discord embed to #liquidation-heatmap."""
import json, logging, requests
from pathlib import Path
from datetime import datetime, timezone, timedelta
from collections import defaultdict

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
LOG_DIR = Path("/home/ubuntu/.openclaw/workspace/logs"); LOG_DIR.mkdir(parents=True, exist_ok=True)
STATE = Path("/home/ubuntu/.openclaw/workspace/state/liquidations/binance_liqs.jsonl")

logging.basicConfig(filename=LOG_DIR/"liq_summary.log", level=logging.INFO,
                    format="%(asctime)s %(levelname)s %(message)s")
log = logging.getLogger("sum")

CHANNEL = "1498025465871597578"
WINDOW_HRS = 4
TOKEN = (SECRETS/"spacer_bot_token.txt").read_text().strip()

def post(payload):
    url = f"https://discord.com/api/v10/channels/{CHANNEL}/messages"
    r = requests.post(url, headers={"Authorization": f"Bot {TOKEN}", "Content-Type": "application/json"}, json=payload, timeout=15)
    log.info(f"post → {r.status_code}: {r.text[:200]}")
    return r.ok

def fmt_dollars(v):
    if v >= 1_000_000_000: return f"${v/1_000_000_000:.2f}B"
    if v >= 1_000_000: return f"${v/1_000_000:.2f}M"
    if v >= 1_000: return f"${v/1_000:.1f}K"
    return f"${v:.0f}"

def main():
    if not STATE.exists():
        log.error("no jsonl yet"); return
    
    cutoff_ms = (datetime.now(timezone.utc) - timedelta(hours=WINDOW_HRS)).timestamp() * 1000
    keep_ms = (datetime.now(timezone.utc) - timedelta(hours=24)).timestamp() * 1000
    
    # Read + prune (keep last 24h, summarize last 4h)
    events = []
    kept_lines = []
    with open(STATE) as f:
        for line in f:
            try:
                e = json.loads(line)
                if e["ts"] >= keep_ms:
                    kept_lines.append(line)
                if e["ts"] >= cutoff_ms:
                    events.append(e)
            except: pass
    
    # Rewrite pruned
    with open(STATE, "w") as f:
        f.writelines(kept_lines)
    
    log.info(f"window {WINDOW_HRS}h: {len(events)} events, kept {len(kept_lines)} (24h)")
    
    if not events:
        log.warning("no events in window"); return
    
    # Aggregate
    long_liq = sum(e["value"] for e in events if e["side"] == "SELL")
    short_liq = sum(e["value"] for e in events if e["side"] == "BUY")
    total = long_liq + short_liq
    
    # Per-coin (filter unicode/junk symbols, only USDT/USDC perps, min $1k per event)
    MIN_EVT = 1000
    by_coin = defaultdict(lambda: {"long": 0, "short": 0})
    for e in events:
        sym_raw = e["symbol"]
        # skip non-ASCII (e.g. Chinese meme pairs) and non-USD-quoted
        if not sym_raw.isascii(): continue
        if not (sym_raw.endswith("USDT") or sym_raw.endswith("USDC") or sym_raw.endswith("USD")): continue
        if e["value"] < MIN_EVT: continue
        sym = sym_raw.replace("USDT", "").replace("USDC", "").replace("USD", "")
        if e["side"] == "SELL":
            by_coin[sym]["long"] += e["value"]
        else:
            by_coin[sym]["short"] += e["value"]
    top_coins = sorted(by_coin.items(), key=lambda x: x[1]["long"]+x[1]["short"], reverse=True)[:8]
    
    # Largest single events (skip junk pairs)
    clean_events = [e for e in events if e["symbol"].isascii() and (e["symbol"].endswith("USDT") or e["symbol"].endswith("USDC"))]
    largest = sorted(clean_events, key=lambda e: e["value"], reverse=True)[:5]
    
    # Bias
    if total > 0:
        long_pct = long_liq / total * 100
        if long_pct > 65:
            bias = "🔴 LONGS WRECKED"; color = 0xef5350
        elif long_pct < 35:
            bias = "🟢 SHORTS WRECKED"; color = 0x00d2a0
        else:
            bias = "⚪ MIXED"; color = 0x607d8b
    else:
        bias = "⚪ NO DATA"; color = 0x607d8b
    
    # Build embed
    coin_lines = []
    for sym, v in top_coins:
        tot = v["long"] + v["short"]
        long_share = v["long"]/tot*100 if tot > 0 else 0
        emoji = "🔴" if long_share > 65 else "🟢" if long_share < 35 else "⚪"
        coin_lines.append(f"{emoji} **{sym}** {fmt_dollars(tot)} (L:{fmt_dollars(v['long'])} S:{fmt_dollars(v['short'])})")
    
    largest_lines = []
    for e in largest:
        sym = e["symbol"].replace("USDT", "").replace("USDC", "")
        side = "LONG" if e["side"] == "SELL" else "SHORT"
        largest_lines.append(f"`{sym}` {side} **{fmt_dollars(e['value'])}** @ ${e['price']:,.2f}")
    
    embed = {
        "title": f"💥 Liquidation Tracker — last {WINDOW_HRS}h",
        "description": f"**{bias}** · Total {fmt_dollars(total)} · {len(events)} events",
        "color": color,
        "fields": [
            {"name": "Long vs Short Wreck", "value": f"🔴 Longs liquidated: **{fmt_dollars(long_liq)}**\n🟢 Shorts liquidated: **{fmt_dollars(short_liq)}**", "inline": False},
            {"name": "Top coins by total liq", "value": "\n".join(coin_lines) or "—", "inline": False},
            {"name": "Largest single events", "value": "\n".join(largest_lines) or "—", "inline": False},
        ],
        "footer": {"text": "Binance Futures · forceOrder@arr stream · free public feed"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }
    post({"embeds": [embed]})

if __name__ == "__main__":
    main()
