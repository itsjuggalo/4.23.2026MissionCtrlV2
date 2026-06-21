#!/usr/bin/env python3
"""
discord_polish.py — public-ready polish: START HERE category (#welcome + #rules-disclaimer
with content), public-channel topics, read-only member perms. Actor = ops bot (Administrator).
"""
import sys, time, json
from pathlib import Path
sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret
import requests

API = "https://discord.com/api/v10"
G = get_secret("discord_guild_id").strip()
BOT = get_secret("discord_ops_bot_token").strip()
H = {"Authorization": f"Bot {BOT}", "User-Agent": "MC/1.0", "Content-Type": "application/json"}
SNAP = json.loads((Path.home()/".openclaw"/"workspace"/"state"/"discord_guild_snapshot.json").read_text())
VIEW, SEND, HIST = 1024, 2048, 65536
RED = 0xE02434

# topics for public channels (function → one-liner). Unknown public channels get a generic topic.
TOPICS = {
    "premarket-brief": "🌅 Pre-market setup — gaps, overnight news, levels to watch before the open",
    "morning-briefs": "📈 Morning game-plan — the day's key trades, catalysts & bias",
    "midday-brief": "🕛 Midday check-in — how the morning played out + afternoon setups",
    "closing-brief": "🔔 Closing + after-hours wrap — what moved, what carries overnight",
    "price-checker": "💲 On-demand price/quote lookups",
    "flow-unusual": "🐳 Unusual options flow — out-of-the-ordinary contract activity (live)",
    "flow-huge": "💥 Huge prints — the largest single option orders hitting the tape",
    "flow-repeaters": "🔁 Repeat flow — names getting hit again and again",
    "flow-etf-weekly": "🧺 ETF + weekly-expiry flow",
    "whale-flow": "🐋 Whale flow — $5M / $10M / $25M+ premium prints",
    "flow-picks": "⭐ Curated best-of-flow picks — the day's highest-conviction reads",
    "flow-results": "✅ Flow track-record — how the called trades actually resolved",
    "fg-live-flow": "📡 Live FlowGreeks tape — raw real-time option alerts",
    "fg-option-alerts": "🚨 FlowGreeks option alerts",
    "pattern-alerts": "📐 Chart-pattern + squeeze detections (breakouts, flags, gamma squeezes)",
    "market-sentiment": "🧭 Aggregate market sentiment — fear/greed, bull/bear tilt",
    "macro": "🌐 Macro — Fed, rates, CPI/PCE, the calendar that moves everything",
    "macro-calendar": "🗓️ Upcoming macro/economic events",
    "sector-rotation": "🔄 Sector rotation — where money is flowing in/out",
    "earnings": "📊 Earnings playbook — who reports, expected moves, setups",
    "analyst-research": "🔬 Analyst research — setups, watchlist, ratings",
    "provider-signals": "📨 Third-party provider signals (aggregated)",
    "scalp-signals": "⚡ Scalp-timeframe signals", "swing-signals": "🌊 Swing-timeframe signals",
    "stock-signals": "📈 Equity signals", "options-signals": "🎯 Longer-dated option signals",
    "crypto-signals": "🪙 Crypto signals", "service-picks": "📌 Service picks",
    "x-updates": "𝕏 Curated market chatter from X",
}
PUBLIC_CATS = ["📰 BRIEFS", "🎯 ALERTS & SENTIMENT", "📡 SIGNALS — WHALE FLOW",
               "📡 SIGNALS — PROVIDERS", "🌐 RESEARCH & MACRO"]

WELCOME = {
    "title": "🎯 Welcome to Mission Control",
    "description": (
        "An AI-driven **options-flow & signals desk** — an extension of the Mission Control "
        "platform. Bots watch the tape 24/7 and post the good stuff here in plain English.\n\n"
        "**How it's organized:**\n"
        "📰 **Briefs** — pre-market → close game-plans\n"
        "🐳 **Whale Flow** — unusual & large option prints, plus ⭐ curated `#flow-picks`\n"
        "🎯 **Alerts & Sentiment** — patterns, squeezes, fear/greed\n"
        "📡 **Signals** — scalp / swing / stock / crypto provider signals\n"
        "🌐 **Research & Macro** — analyst setups, earnings, the Fed calendar\n\n"
        "Feeds are **read-only** — sit back and read the desk. "
        "Start with `#flow-picks` and `#morning-briefs`.\n\n"
        "_Please read `#rules-disclaimer` first._"),
    "color": RED,
}
RULES = {
    "title": "📜 Rules & Disclaimer",
    "description": (
        "**Not financial advice.** Everything here is automated, educational, and informational "
        "only — it is **not** a recommendation to buy or sell any security.\n\n"
        "• Do your own research; trade at your own risk.\n"
        "• Data is automated and may be **delayed, incomplete, or wrong**.\n"
        "• Paper-trade first. Never risk more than you can afford to lose.\n"
        "• Options are high-risk and can expire worthless.\n"
        "• Be respectful — no spam, no self-promotion, no financial solicitation.\n\n"
        "_By participating you accept full responsibility for your own trades._"),
    "color": RED,
}


def _req(m, p, **k):
    for _ in range(6):
        r = requests.request(m, API + p, headers=H, timeout=30, **k)
        if r.status_code == 429:
            time.sleep(float(r.headers.get("Retry-After", 2)) + .5); continue
        return r
    raise RuntimeError("rl")


def main():
    cats = {c["name"]: c["id"] for c in SNAP["categories"]}
    name2id = {c["name"]: c["id"] for cat in SNAP["categories"] for c in cat["channels"]}

    # 1) START HERE category (public read-only) + welcome/rules
    sh = next((cid for n, cid in cats.items() if "START HERE" in n.upper()), None)
    if not sh:
        sh = _req("POST", f"/guilds/{G}/channels", json={"name": "📌 START HERE", "type": 4,
                  "position": 0, "permission_overwrites": [
                      {"id": G, "type": 0, "allow": str(VIEW | HIST), "deny": str(SEND)}]}).json()["id"]
        print(f"created category 📌 START HERE ({sh})")
    for nm, body in (("welcome", WELCOME), ("rules-disclaimer", RULES)):
        cid = name2id.get(nm)
        if not cid:
            cid = _req("POST", f"/guilds/{G}/channels", json={"name": nm, "type": 0, "parent_id": sh,
                       "permission_overwrites": [{"id": G, "type": 0, "allow": str(VIEW | HIST),
                        "deny": str(SEND)}]}).json()["id"]
            print(f"created #{nm} ({cid})")
        time.sleep(.4)
        _req("POST", f"/channels/{cid}/messages", json={"embeds": [body]})
        print(f"posted content → #{nm}")
        time.sleep(.4)

    # 2) topics on public channels
    print("\nsetting public-channel topics…")
    done = 0
    for cat in SNAP["categories"]:
        if cat["name"] not in PUBLIC_CATS:
            continue
        for c in cat["channels"]:
            t = TOPICS.get(c["name"], f"📊 {c['name'].replace('-', ' ')} — Mission Control live feed")
            r = _req("PATCH", f"/channels/{c['id']}", json={"topic": t})
            if r.status_code == 200:
                done += 1
            time.sleep(.35)
    print(f"✅ topics set on {done} public channels")
    print("\nDONE — welcome/rules live, public channels described.")


if __name__ == "__main__":
    main()
