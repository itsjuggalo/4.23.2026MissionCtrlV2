#!/usr/bin/env python3
"""Daily wrap-up bot. Posts EOD summary to #daily-wrap via webhook.
Runs once per day at 9PM ET via cron.
"""
import json, os, sys, time, logging
from datetime import datetime, timezone
from pathlib import Path
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_daily_wrap_webhook").read_text().strip()
RELAY_DIR = Path.home() / "mission-control-restored" / "Option-Signals-Scraper"
DATA_DIR = RELAY_DIR / "data"
STATE_FILE = RELAY_DIR / "sent_ids.json"

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "daily_wrap.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s"
)


def read_data(name):
    p = DATA_DIR / f"{name}.json"
    if not p.exists():
        return None
    try:
        return json.loads(p.read_text())
    except Exception as e:
        logging.error(f"read {name} failed: {e}")
        return None


def fmt_prem(v):
    if v >= 1_000_000: return f"${v/1_000_000:.1f}M"
    if v >= 1_000: return f"${v/1_000:.0f}K"
    return f"${v:.0f}"


def stock_flow_summary():
    """Top tickers by today's premium + overall %bull from FG1 LiveFlows."""
    d = read_data("flow_liveflows_today") or read_data("flow_live_last100") or {}
    if not isinstance(d, dict): d = {}
    ticker = {}
    total_bull, total_bear = 0.0, 0.0
    for entry in d.values():
        if not isinstance(entry, dict): continue
        sym = entry.get("Symbol", "")
        if not sym: continue
        opt = entry.get("OptionType", "")
        ba = entry.get("BidAskType", "")
        val = float(entry.get("Value", 0) or 0)
        if val <= 0: continue
        is_bull = (opt == "CALL" and ba == "A") or (opt == "PUT" and ba == "B")
        is_bear = (opt == "CALL" and ba == "B") or (opt == "PUT" and ba == "A")
        if not (is_bull or is_bear): continue
        s = ticker.setdefault(sym, {"bull": 0.0, "bear": 0.0, "total": 0.0})
        if is_bull:
            s["bull"] += val; total_bull += val
        else:
            s["bear"] += val; total_bear += val
        s["total"] += val
    top5 = sorted(ticker.items(), key=lambda x: x[1]["total"], reverse=True)[:5]
    overall = (total_bull / (total_bull + total_bear) * 100) if (total_bull + total_bear) > 0 else 50
    rows = []
    for sym, s in top5:
        bull_pct = (s["bull"] / s["total"] * 100) if s["total"] > 0 else 0
        rows.append(f"`{sym:<5} {fmt_prem(s['total']):>8} {bull_pct:>3.0f}% bull`")
    return {
        "rows": rows,
        "overall_pct": overall,
        "total_bull": total_bull,
        "total_bear": total_bear,
        "n_tickers": len(ticker),
    }


def crypto_summary():
    """BTC/ETH/SOL/BNB/XRP 24h change via CoinGecko."""
    ids = "bitcoin,ethereum,solana,binancecoin,ripple"
    name_map = {"bitcoin": "BTC", "ethereum": "ETH", "solana": "SOL", "binancecoin": "BNB", "ripple": "XRP"}
    rows = []
    try:
        r = requests.get(
            "https://api.coingecko.com/api/v3/simple/price",
            params={"ids": ids, "vs_currencies": "usd", "include_24hr_change": "true"},
            timeout=10
        )
        if r.status_code == 200:
            data = r.json()
            for cg_id, sym in name_map.items():
                if cg_id in data:
                    d = data[cg_id]
                    price = d.get("usd", 0)
                    chg = d.get("usd_24h_change", 0) or 0
                    sign = "+" if chg >= 0 else ""
                    px = f"${price:,.0f}" if price >= 1000 else f"${price:.2f}"
                    rows.append(f"`{sym:<4} {px:>10} {sign}{chg:>5.2f}%`")
    except Exception as e:
        logging.error(f"crypto fetch: {e}")
    return rows


def signal_counts():
    """Count signals fired today from the relay state."""
    try:
        state = json.loads(STATE_FILE.read_text())
    except Exception:
        return {}
    counts = {}
    for k in state:
        if k.endswith("_sent") and isinstance(state[k], list):
            counts[k.replace("_sent", "")] = len(state[k])
    return counts


def build_embed():
    now_et = datetime.now()
    ts_str = now_et.strftime("%A, %B %-d %Y")

    flow = stock_flow_summary()
    crypto = crypto_summary()
    sigs = signal_counts()

    overall = flow["overall_pct"]
    if overall >= 60: color = 0x2ecc71
    elif overall <= 40: color = 0xe74c3c
    else: color = 0xf1c40f

    fields = []

    if flow["rows"]:
        fields.append({
            "name": f"📊 Stock Options Flow ({flow['n_tickers']} tickers)",
            "value": (
                f"**Overall: {overall:.0f}% bullish**  •  {fmt_prem(flow['total_bull'])} bull / {fmt_prem(flow['total_bear'])} bear\n"
                f"Top 5 by premium:\n" + "\n".join(flow["rows"])
            )[:1024],
            "inline": False,
        })
    else:
        fields.append({"name": "📊 Stock Options Flow", "value": "_no flow data today_", "inline": False})

    if crypto:
        fields.append({
            "name": "₿ Crypto 24h",
            "value": "\n".join(crypto)[:1024],
            "inline": False,
        })

    if sigs:
        sig_lines = [f"`{k:<25} {v:>4}`" for k, v in sorted(sigs.items(), key=lambda x: -x[1])[:10] if v > 0]
        if sig_lines:
            fields.append({
                "name": "📡 Signals Fired Today (top 10)",
                "value": "\n".join(sig_lines)[:1024],
                "inline": False,
            })

    return {
        "title": "🌙 Daily Wrap-Up",
        "description": f"**{ts_str}**\nMarket close summary",
        "color": color,
        "fields": fields,
        "footer": {"text": f"Mission Control • {now_et.strftime('%-I:%M %p ET')}"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }


def post_to_discord(embed):
    try:
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=15)
        if r.status_code in (200, 204):
            logging.info(f"posted daily wrap (overall {embed.get('color')})")
            return True
        logging.error(f"webhook returned {r.status_code}: {r.text[:200]}")
        return False
    except Exception as e:
        logging.error(f"post failed: {e}")
        return False


if __name__ == "__main__":
    embed = build_embed()
    success = post_to_discord(embed)
    print(f"daily wrap posted: {success}")
    sys.exit(0 if success else 1)
