#!/usr/bin/env python3
"""
Brief Pre-Processor — Gathers ALL market data into one clean markdown file.
Runs 10 min before each brief via cron. Zero LLM tokens.
Output: ~/.openclaw/workspace/pre_brief_data.md

JazzyHazzy reads this instead of raw JSON — no parsing, no API calls needed.
"""

import json
import os
import requests
import time
from datetime import datetime, timezone, timedelta
from pathlib import Path

SECRETS = Path.home() / ".openclaw" / "secrets"
DIRECTIVES = Path.home() / ".openclaw" / "workspace" / "directives"
DATA_DIR = Path.home() / "mission-control-restored" / "Option-Signals-Scraper" / "data"
OUTPUT = Path.home() / ".openclaw" / "workspace" / "pre_brief_data.md"
MEMORY = Path.home() / ".openclaw" / "workspace" / "memory"

EST = timezone(timedelta(hours=-4))

def secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else None

ALPACA_KEY = secret("alpaca-key-id") or secret("alpaca_key.txt")
ALPACA_SECRET = secret("alpaca-secret") or secret("alpaca_secret.txt")
ALPACA_BASE = "https://paper-api.alpaca.markets"
FINNHUB_KEY = secret("finnhub_api_key") or "d70ov6hr01ql6rg044qgd70ov6hr01ql6rg044r0"

def safe_get(url, headers=None, timeout=10):
    try:
        r = requests.get(url, headers=headers, timeout=timeout)
        if r.ok:
            return r.json()
    except:
        pass
    return None

# ─── PORTFOLIO ──────────────────────────────────────────────
def get_portfolio():
    if not ALPACA_KEY:
        return "Portfolio data unavailable — no Alpaca API key"
    headers = {"APCA-API-KEY-ID": ALPACA_KEY, "APCA-API-SECRET-KEY": ALPACA_SECRET}
    acct = safe_get(f"{ALPACA_BASE}/v2/account", headers)
    positions = safe_get(f"{ALPACA_BASE}/v2/positions", headers) or []

    if not acct:
        return "Portfolio data unavailable — Alpaca API error"

    equity = float(acct.get("equity", 0))
    cash = float(acct.get("cash", 0))
    buying_power = float(acct.get("buying_power", 0))
    prev_equity = float(acct.get("last_equity", equity))
    day_change = equity - prev_equity
    day_pct = (day_change / prev_equity * 100) if prev_equity > 0 else 0
    total_return = ((equity - 100000) / 100000 * 100)

    lines = [
        f"Equity: ${equity:,.2f} ({day_pct:+.2f}% / ${day_change:+,.2f} today)",
        f"Total Return: {total_return:+.2f}% from $100K start",
        f"Buying Power: ${buying_power:,.2f}",
        f"Cash: ${cash:,.2f}",
        ""
    ]

    for p in positions:
        sym = p.get("symbol", "?")
        qty = float(p.get("qty", 0))
        entry = float(p.get("avg_entry_price", 0))
        current = float(p.get("current_price", 0))
        pnl = float(p.get("unrealized_pl", 0))
        pnl_pct = float(p.get("unrealized_plpc", 0)) * 100
        market_val = float(p.get("market_value", 0))
        side = p.get("side", "long").upper()

        lines.append(f"• {sym} ({side}): {qty} shares @ ${entry:,.2f} → ${current:,.2f}")
        lines.append(f"  P&L: ${pnl:+,.2f} ({pnl_pct:+.2f}%) | Market Value: ${market_val:,.2f}")

        # Add action recommendations
        if pnl_pct > 20:
            lines.append(f"  ⚠️ ACTION: Consider taking partial profits — up {pnl_pct:.1f}%")
        elif pnl_pct > 10:
            lines.append(f"  ACTION: Tighten stop loss — up {pnl_pct:.1f}%")
        elif pnl_pct < -5:
            lines.append(f"  🚨 ACTION: Review position — down {abs(pnl_pct):.1f}%")
        else:
            lines.append(f"  ACTION: Hold — within normal range")
        lines.append("")

    return "\n".join(lines)

# ─── CRYPTO MARKET ──────────────────────────────────────────
def get_crypto_market():
    # Fear & Greed
    fg = safe_get("https://api.alternative.me/fng/?limit=1")
    fg_val = fg["data"][0]["value"] if fg and "data" in fg else "?"
    fg_label = fg["data"][0]["value_classification"] if fg and "data" in fg else "?"

    # BTC price + major coins from CoinGecko
    coins = safe_get("https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum,solana,ripple&vs_currencies=usd&include_24hr_change=true&include_24hr_vol=true&include_market_cap=true")

    lines = [f"Fear & Greed Index: {fg_val} ({fg_label})", ""]

    if coins:
        for coin_id, label in [("bitcoin", "BTC"), ("ethereum", "ETH"), ("solana", "SOL"), ("ripple", "XRP")]:
            d = coins.get(coin_id, {})
            price = d.get("usd", 0)
            change = d.get("usd_24h_change", 0)
            vol = d.get("usd_24h_vol", 0)
            mcap = d.get("usd_market_cap", 0)
            emoji = "🟢" if change > 0 else "🔴"
            lines.append(f"{emoji} {label}: ${price:,.2f} ({change:+.2f}%)")
            lines.append(f"  24h Volume: ${vol/1e9:.2f}B | Market Cap: ${mcap/1e9:.1f}B")
    else:
        lines.append("CoinGecko data unavailable")

    # Funding rate
    try:
        funding = safe_get("https://fapi.binance.com/fapi/v1/fundingRate?symbol=BTCUSDT&limit=1")
        if funding and len(funding) > 0:
            rate = float(funding[0].get("fundingRate", 0))
            lines.append(f"\nBTC Funding Rate: {rate*100:.4f}%")
            if rate > 0.01:
                lines.append("  ⚠️ Elevated — longs paying, potential squeeze risk")
            elif rate < -0.01:
                lines.append("  🟢 Negative — shorts paying, bullish pressure")
            else:
                lines.append("  Neutral — no squeeze risk")
    except:
        pass

    # BTC dominance
    try:
        global_data = safe_get("https://api.coingecko.com/api/v3/global")
        if global_data and "data" in global_data:
            dom = global_data["data"].get("market_cap_percentage", {}).get("btc", 0)
            total_mcap = global_data["data"].get("total_market_cap", {}).get("usd", 0)
            lines.append(f"BTC Dominance: {dom:.1f}%")
            lines.append(f"Total Crypto Market Cap: ${total_mcap/1e12:.2f}T")
    except:
        pass

    return "\n".join(lines)

# ─── HIGH VOLUME CRYPTO SCANNER ─────────────────────────────
def get_volume_movers():
    """Scan for high-volume crypto with $1M+ market cap"""
    coins = safe_get("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=volume_desc&per_page=50&page=1&sparkline=false&price_change_percentage=1h,24h,7d")
    if not coins:
        return "Volume scanner unavailable — CoinGecko rate limited"

    lines = ["Top coins by 24h volume (sorted by volume, $1M+ market cap):"]
    lines.append(f"{'Coin':<8} {'Price':>12} {'24h%':>8} {'Volume':>14} {'MCap':>12} {'Signal'}")
    lines.append("-" * 75)

    for c in coins[:20]:
        sym = c.get("symbol", "?").upper()
        price = c.get("current_price", 0)
        change_24h = c.get("price_change_percentage_24h", 0) or 0
        vol = c.get("total_volume", 0)
        mcap = c.get("market_cap", 0)

        if mcap < 1_000_000:
            continue

        # Volume/MCap ratio — high ratio = unusual activity
        vol_mcap_ratio = (vol / mcap * 100) if mcap > 0 else 0

        signal = ""
        if change_24h > 10:
            signal = "🚀 BREAKOUT"
        elif change_24h > 5:
            signal = "🟢 STRONG"
        elif change_24h < -10:
            signal = "🔴 CRASH"
        elif change_24h < -5:
            signal = "🔴 WEAK"
        elif vol_mcap_ratio > 30:
            signal = "⚡ HIGH VOL"
        else:
            signal = ""

        price_str = f"${price:,.4f}" if price < 1 else f"${price:,.2f}"
        vol_str = f"${vol/1e6:.1f}M" if vol < 1e9 else f"${vol/1e9:.2f}B"
        mcap_str = f"${mcap/1e6:.0f}M" if mcap < 1e9 else f"${mcap/1e9:.1f}B"

        lines.append(f"{sym:<8} {price_str:>12} {change_24h:>+7.2f}% {vol_str:>14} {mcap_str:>12} {signal}")

    return "\n".join(lines)

# ─── BTC TECHNICALS ─────────────────────────────────────────
def get_btc_technicals():
    """Read from market_data_latest.json if available"""
    p = Path.home() / ".openclaw" / "workspace" / "market_data_latest.json"
    if not p.exists():
        return "BTC technicals unavailable — market_data_latest.json not found"

    try:
        data = json.loads(p.read_text())
        lines = []

        # Extract technicals
        tech = data.get("btc_technicals", data.get("technicals", {}))
        if isinstance(tech, dict):
            for tf, vals in tech.items():
                if isinstance(vals, dict):
                    trend = vals.get("trend", "?")
                    rsi = vals.get("rsi", "?")
                    sup = vals.get("support", "?")
                    res = vals.get("resistance", "?")
                    lines.append(f"{tf}: {trend} | RSI {rsi} | S: ${sup} | R: ${res}")

        # SuperTrend
        st = data.get("supertrend", {})
        if isinstance(st, dict):
            signal = st.get("signal", st.get("direction", "?"))
            entry = st.get("entry_price", st.get("last_action_price", "?"))
            lines.append(f"SuperTrend: {signal} | Entry: ${entry}")

        # Market regime
        regime = data.get("market_regime", {})
        if isinstance(regime, dict):
            bias = regime.get("bias", "?")
            recommendation = regime.get("recommendation", "?")
            lines.append(f"Regime: {bias} | Recommendation: {recommendation}")

        return "\n".join(lines) if lines else "BTC technicals parsed but empty"
    except Exception as e:
        return f"BTC technicals error: {e}"

# ─── WHALE FLOW ─────────────────────────────────────────────
def get_whale_flow():
    """Read top whale flows from scraped data"""
    lines = []

    for fname in ["flow_alerts_today.json", "flow2_alerts_today.json"]:
        fpath = DATA_DIR / fname
        if not fpath.exists():
            continue
        try:
            data = json.loads(fpath.read_text())
            items = []
            for key, entry in data.items():
                alert = entry.get("alert", entry)
                val = float(alert.get("totalFlowValue", 0))
                if val >= 500000:
                    items.append({
                        "symbol": alert.get("Symbol", "?"),
                        "strike": alert.get("Strike", "?"),
                        "type": alert.get("OptionType", "?"),
                        "value": val,
                        "sweeps": alert.get("SWEEPS", 0),
                        "vol": alert.get("Volume", "?"),
                        "oi": alert.get("OI", "?"),
                        "spot": alert.get("Spot", "?"),
                        "alert_type": alert.get("AlertType", "?"),
                        "dte": alert.get("DTE", "?"),
                    })
            items.sort(key=lambda x: x["value"], reverse=True)
            for item in items[:10]:
                val_str = f"${item['value']/1e6:.2f}M" if item['value'] >= 1e6 else f"${item['value']/1e3:.0f}K"
                opt_char = str(item['type'])[0] if item['type'] else "?"
                emoji = "🟢" if opt_char == "C" else "🔴"
                lines.append(f"{emoji} {item['symbol']} ${item['strike']}{opt_char} — {val_str} | Sweeps: {item['sweeps']} | Vol/OI: {item['vol']}/{item['oi']} | Spot: ${item['spot']} | DTE: {item['dte']} | {item['alert_type']}")
        except:
            continue

    # Deduplicate by symbol+strike
    seen = set()
    deduped = []
    for line in lines:
        key = line[:30]
        if key not in seen:
            seen.add(key)
            deduped.append(line)

    return "\n".join(deduped[:10]) if deduped else "No whale flow data available"

# ─── NEWS ───────────────────────────────────────────────────
def get_news():
    """Get market news from Finnhub"""
    news = safe_get(f"https://finnhub.io/api/v1/news?category=general&token={FINNHUB_KEY}")
    if not news:
        return "News unavailable"

    lines = []
    seen_headlines = set()
    for item in news[:10]:
        headline = item.get("headline", "")
        source = item.get("source", "")
        ts = item.get("datetime", 0)
        time_str = datetime.fromtimestamp(ts, tz=EST).strftime("%I:%M %p") if ts else ""

        # Deduplicate similar headlines
        short = headline[:40].lower()
        if short in seen_headlines:
            continue
        seen_headlines.add(short)

        lines.append(f"• [{source}] {headline} ({time_str})")

    return "\n".join(lines[:7]) if lines else "No recent news"

# ─── ACTIVE SIGNALS ─────────────────────────────────────────
def get_active_signals():
    """Read from Firebase signal data"""
    try:
        r = requests.get("http://localhost:3033/api/trade-signals", timeout=10)
        if not r.ok:
            return "Signal API unavailable"
        data = r.json()
        lines = []
        for src_name, src_key in [("Name", "name"), ("Name2", "name2"), ("Vivid", "vivid")]:
            src = data.get(src_key, {})
            for term in ["shortTerm", "longTerm"]:
                for sig in src.get(term, []):
                    sym = sig.get("symbol", "?")
                    cat = sig.get("category", "?")
                    strike = sig.get("strike", "")
                    buy = sig.get("buyTarget", "?")
                    tp1 = sig.get("sellTarget", sig.get("earlyTarget", "?"))
                    tp2 = sig.get("sellTarget2", "")
                    sl = sig.get("stopLoss", sig.get("reduceLoss", "?"))
                    risk = sig.get("risk", "")

                    strike_str = f" ${strike}C" if strike else ""
                    tp2_str = f" | T2: ${tp2}" if tp2 else ""
                    risk_str = f" | Risk: {risk}" if risk else ""

                    lines.append(f"• {cat} {sym}{strike_str} — Buy: ${buy} | TP: ${tp1}{tp2_str} | SL: ${sl}{risk_str} [{src_name}]")

        return "\n".join(lines) if lines else "No active signals"
    except:
        return "Signal data unavailable"

# ─── PREVIOUS BRIEF ────────────────────────────────────────
def get_previous_brief():
    """Find the most recent brief from today"""
    today = datetime.now().strftime("%Y-%m-%d")
    for suffix in ["morning-brief", "premarket", "midday", "eod-summary", "nightly"]:
        p = MEMORY / f"{today}-{suffix}.md"
        if p.exists():
            content = p.read_text().strip()
            return f"[Today's {suffix}]\n{content[:1000]}"

    yesterday = (datetime.now() - timedelta(days=1)).strftime("%Y-%m-%d")
    for suffix in ["eod-summary", "nightly"]:
        p = MEMORY / f"{yesterday}-{suffix}.md"
        if p.exists():
            content = p.read_text().strip()
            return f"[Yesterday's {suffix}]\n{content[:1000]}"

    return "No previous brief found"

# ─── MAIN ───────────────────────────────────────────────────
def main():
    now = datetime.now(EST)
    print(f"[pre-processor] Starting at {now.strftime('%I:%M %p EST')}")

    sections = {}
    sections["portfolio"] = get_portfolio()
    print("[pre-processor] Portfolio done")
    sections["crypto"] = get_crypto_market()
    print("[pre-processor] Crypto market done")
    sections["volume"] = get_volume_movers()
    print("[pre-processor] Volume scanner done")
    sections["technicals"] = get_btc_technicals()
    print("[pre-processor] BTC technicals done")
    sections["whale"] = get_whale_flow()
    print("[pre-processor] Whale flow done")
    sections["news"] = get_news()
    print("[pre-processor] News done")
    sections["signals"] = get_active_signals()
    print("[pre-processor] Active signals done")
    sections["previous"] = get_previous_brief()
    print("[pre-processor] Previous brief done")

    # Build the clean markdown
    output = f"""# PRE-BRIEF DATA — {now.strftime('%A, %B %d, %Y %I:%M %p EST')}
Generated automatically by brief_preprocessor.py — ALL data below is REAL.
DO NOT fabricate any prices. If a section says "unavailable", skip it.

---

## PORTFOLIO (Alpaca Paper Account)
{sections["portfolio"]}

---

## CRYPTO MARKET
{sections["crypto"]}

---

## HIGH VOLUME CRYPTO SCANNER ($1M+ Market Cap)
{sections["volume"]}

---

## BTC TECHNICALS (from SuperTrend + indicators)
{sections["technicals"]}

---

## INSTITUTIONAL FLOW (Top by value, deduplicated)
{sections["whale"]}

---

## MARKET NEWS (Latest headlines)
{sections["news"]}

---

## ACTIVE TRADE SIGNALS (from scraped sources)
{sections["signals"]}

---

## PREVIOUS BRIEF REFERENCE
{sections["previous"]}

---
Generated at {now.isoformat()} by brief_preprocessor.py
"""

    OUTPUT.parent.mkdir(parents=True, exist_ok=True)
    OUTPUT.write_text(output)
    print(f"[pre-processor] Saved to {OUTPUT} ({len(output)} bytes)")

if __name__ == "__main__":
    main()
