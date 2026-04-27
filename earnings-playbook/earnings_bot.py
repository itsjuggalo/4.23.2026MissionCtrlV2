#!/usr/bin/env python3
"""
Earnings Playbook Bot — pre-market briefing (8AM ET, weekdays).

Pulls today's earnings calendar from Nasdaq (free, no auth), filters BMO + AMC,
sorts by market cap, picks top 5. For each: fetch ATM straddle from Tradier
sandbox to compute implied move %.

Posts color-coded embed to discord_earnings_playbook_webhook.
"""
import json
import logging
import re
import sys
from datetime import datetime, timezone
from pathlib import Path

import requests
import yfinance as yf

sys.path.insert(0, "/home/ubuntu/scripts/lib")
import tradier_client as tc

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
WEBHOOK = (SECRETS / "discord_earnings_playbook_webhook").read_text().strip()
LOG_DIR = Path("/home/ubuntu/.openclaw/workspace/logs")
LOG_DIR.mkdir(parents=True, exist_ok=True)

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
    handlers=[
        logging.FileHandler(LOG_DIR / "earnings_bot.log"),
        logging.StreamHandler(),
    ],
)
log = logging.getLogger("earnings")

NASDAQ_URL = "https://api.nasdaq.com/api/calendar/earnings"
HEADERS = {
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36",
    "Accept": "application/json",
}

# Implied move thresholds (color)
COLOR_HIGH = 0xE74C3C   # red — IM > 8%
COLOR_MED = 0xF39C12    # orange — IM 5-8%
COLOR_LOW = 0x2ECC71    # green — IM < 5%


def parse_market_cap(s: str) -> float:
    """Nasdaq returns mcap as '$3,979,479,234,560'. Returns float USD or 0."""
    if not s or s in ("N/A", "$0", ""):
        return 0.0
    try:
        return float(re.sub(r"[^\d.]", "", str(s)))
    except Exception:
        return 0.0


def fetch_calendar(date_str: str) -> list:
    """Fetch Nasdaq earnings calendar for given YYYY-MM-DD. Returns list of rows."""
    try:
        r = requests.get(NASDAQ_URL, params={"date": date_str}, headers=HEADERS, timeout=15)
        r.raise_for_status()
        data = r.json()
        return (data.get("data") or {}).get("rows", []) or []
    except Exception as e:
        log.error(f"nasdaq calendar fetch fail: {e}")
        return []


def categorize_time(t: str) -> str:
    """time-pre-market → BMO, time-after-hours → AMC, time-not-supplied → ?"""
    if "pre-market" in (t or ""):
        return "BMO"
    if "after-hours" in (t or ""):
        return "AMC"
    return "?"


def get_spot(symbol: str) -> float:
    try:
        t = yf.Ticker(symbol)
        return float(t.fast_info.last_price)
    except Exception as e:
        log.warning(f"yfinance spot fail {symbol}: {e}")
        return 0.0


def post_embed(today_iso: str, picks: list, bmo_count: int, amc_count: int, total: int):
    """Post one color-coded embed per pick to Discord webhook."""
    if not picks:
        # Send a "no large-cap earnings today" embed
        embed = {
            "title": f"📊 Earnings Playbook — {today_iso}",
            "description": f"**{total}** total earnings today\n• BMO: {bmo_count}\n• AMC: {amc_count}\n\nNo large-cap names with available options data.",
            "color": 0x95A5A6,
        }
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=15)
        log.info(f"posted summary-only embed: {r.status_code}")
        return

    # Header embed
    header = {
        "title": f"📊 Earnings Playbook — {today_iso}",
        "description": f"**{total}** total earnings today (BMO: {bmo_count} · AMC: {amc_count})\nTop {len(picks)} by market cap with implied moves:",
        "color": 0x3498DB,
    }
    embeds = [header]

    for p in picks:
        im = p["straddle"]["implied_move_pct"] if p["straddle"] else None
        if im is None:
            color = 0x95A5A6
        elif im > 8:
            color = COLOR_HIGH
        elif im >= 5:
            color = COLOR_MED
        else:
            color = COLOR_LOW

        mcap_b = p["mcap"] / 1e9
        mcap_str = f"${mcap_b:.1f}B" if mcap_b < 1000 else f"${mcap_b/1000:.2f}T"

        title = f"{p['symbol']} · {p['name'][:40]}"
        when = p["when"]
        eps_fc = p.get("eps_forecast", "?")
        spot = p["spot"]

        if p["straddle"]:
            s = p["straddle"]
            desc = (
                f"**{when}** · mcap {mcap_str} · spot ${spot:.2f}\n"
                f"EPS forecast: {eps_fc}\n"
                f"**Implied move: ±{im}%** (±${s['implied_move_dollars']})\n"
                f"ATM straddle exp {s['expiration']}: ${s['straddle_premium']}\n"
                f"  C ${s['call_strike']:.0f} @ ${s['call_premium']} · IV {s['call_iv']*100:.0f}%\n"
                f"  P ${s['put_strike']:.0f} @ ${s['put_premium']} · IV {s['put_iv']*100:.0f}%"
            )
        else:
            desc = (
                f"**{when}** · mcap {mcap_str} · spot ${spot:.2f}\n"
                f"EPS forecast: {eps_fc}\n"
                f"_No options data available_"
            )

        embeds.append({"title": title, "description": desc, "color": color})

        # Discord caps at 10 embeds per webhook payload
        if len(embeds) >= 10:
            break

    try:
        r = requests.post(WEBHOOK, json={"embeds": embeds}, timeout=15)
        log.info(f"posted {len(embeds)} embeds: {r.status_code}")
        if r.status_code >= 400:
            log.error(f"webhook body: {r.text[:300]}")
    except Exception as e:
        log.error(f"webhook post fail: {e}")


def main():
    today_iso = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    log.info(f"=== earnings playbook for {today_iso} ===")

    rows = fetch_calendar(today_iso)
    log.info(f"nasdaq returned {len(rows)} rows")
    if not rows:
        log.info("no earnings today, skipping post")
        return

    # Categorize, parse mcap, filter to BMO/AMC only
    parsed = []
    bmo_count = 0
    amc_count = 0
    for r in rows:
        when = categorize_time(r.get("time", ""))
        if when == "BMO":
            bmo_count += 1
        elif when == "AMC":
            amc_count += 1
        if when == "?":
            continue
        mcap = parse_market_cap(r.get("marketCap", ""))
        parsed.append({
            "symbol": (r.get("symbol") or "").strip(),
            "name": (r.get("name") or "").strip(),
            "when": when,
            "mcap": mcap,
            "eps_forecast": (r.get("epsForecast") or "?").strip(),
        })

    parsed.sort(key=lambda x: x["mcap"], reverse=True)
    top5 = parsed[:5]
    log.info(f"top 5 by mcap: {[p['symbol'] for p in top5]}")

    # Enrich: fetch spot + straddle
    enriched = []
    for p in top5:
        sym = p["symbol"]
        if not sym or sym in ("?", ""):
            continue
        spot = get_spot(sym)
        p["spot"] = spot
        if spot > 0:
            try:
                p["straddle"] = tc.fetch_atm_straddle(sym, spot)
            except Exception as e:
                log.warning(f"straddle fail {sym}: {e}")
                p["straddle"] = None
        else:
            p["straddle"] = None
        enriched.append(p)
        log.info(f"  {sym}: spot=${spot:.2f}, straddle={'yes' if p['straddle'] else 'no'}")

    post_embed(today_iso, enriched, bmo_count, amc_count, len(rows))
    log.info("=== done ===")


if __name__ == "__main__":
    main()
