#!/home/itsju/.venv/bin/python
"""bot_rebrand.py — rebrand the Telegram bot fleet: FUNCTION-based display names +
Brood War flavored bios + authentic StarCraft 1 avatars. 100% Bot-API driven
(setMyName / setMyShortDescription / setMyDescription / setMyProfilePhoto — the last
added in Bot API 9.4) so NO BotFather is needed. Idempotent; re-run to update.

  bot_rebrand.py --smoke <token_file>   # one bot first — verify setMyProfilePhoto works
  bot_rebrand.py                        # rebrand the whole fleet
"""
import json
import os
import sys
import time

import requests

SEC = os.path.expanduser("~/.openclaw/secrets")
AV = os.path.expanduser("~/.openclaw/bot_avatars")

# token-file → identity. name ≤128, short ≤120, desc ≤512. avatar = staged PNG stem.
IDENTITY = {
    "telegram_laptopclaude_bot_token": dict(
        name="Trading Command", avatar="raynor",
        short="Command center — your full options-flow trading cockpit + ops copilot.",
        desc=("Trading command. The #1 contract to buy now, live whale flow, exits and ops — "
              "from your phone. /pick /winners /chase /flow /sweeps /odte /book /greeks /grade "
              "/x /news. Ask anything. en taro Tassadar, commander.")),
    "telegram-ping-bot-token": dict(
        name="System Health", avatar="adjutant",
        short="Adjutant on watch — PM2, cron, disk, RAM, tunnels, 24/7.",
        desc=("System health monitor. Reads PM2 / cron / disk / RAM / logs and delivers "
              "generated images. Ask 'is everything healthy?', 'pm2 status', 'why is X down?'. "
              "Read-only diagnostics. Power overwhelming.")),
    "lifeclaw_telegram_bot_token": dict(
        name="Life & Wellness", avatar="arbiter",
        short="Your life compass — calendar, inbox, todos, weather. Zero trading.",
        desc=("Life & wellness assistant. Calendar, inbox, to-dos, weather, gentle nudges. "
              "/brief /today /todo. Talk to me like a friend, not a terminal. My life for Aiur.")),
    "telegram_antigravity_bot_token": dict(
        name="AIME Research", avatar="zeratul",
        short="Seer of markets — AIME intel + research copilot.",
        desc=("AIME research copilot. Live AInvest/AIME intel, charts, screens, forecasts, news. "
              "Ask 'what's the read on NVDA', 'screen oversold large caps', 'earnings outlook'. "
              "I have seen the future — and I will not let it come to pass.")),
    "telegram-bot-token.txt": dict(
        name="Flow Signals", avatar="queen_of_blades",
        short="The Swarm hunts the flow — live whale sweeps, exits & shock warnings.",
        desc=("Flow signals (push). The meanest options flow: big sweeps, position exits, market "
              "shocks — straight to your phone. Pull the board with /winners /sweeps from the "
              "Trading Command bot. Paper-safe, edge-first. We will consume them.")),
    "telegram_grok_bot_token": dict(
        name="X-Sentiment", avatar="mutalisk",
        short="Swarm scout of X/Twitter — live trader chatter on any ticker.",
        desc=("X-sentiment scout (Grok on your subscription). Text me a ticker → live "
              "bullish/bearish X/Twitter chatter + catalysts in the last 24h. e.g. 'NVDA'. "
              "The Swarm sees all.")),
    "telegram_jazzyhazzy_bot_token": dict(
        name="Jazzy Desk", avatar="duke",
        short="General of the Jazzy account — positions, sizing, decisions (paper).",
        desc=("Jazzy desk. Your Jazzy paper-account command: positions, P&L, sizing vs current "
              "equity, decision reads. Read-only. Ask 'jazzy positions', 'size NVDA on jazzy'. "
              "For the Confederacy.")),
    "antidote_telegram_bot_token": dict(
        name="Risk & Hedge", avatar="aldaris",
        short="Judicator of risk — drawdown, position size, correlation, hedges.",
        desc=("Risk & hedge desk. Judges every trade: max loss, size vs current equity "
              "($800 risk cap), correlation, drawdown, hedges. Ask 'how much should I size "
              "NVDA?', 'am I over-exposed?'. The Conclave is watching.")),
    "telegram_orion_bot_token": dict(
        name="Research Desk", avatar="high_templar",
        short="Psionic deep-dive — fundamental research on any name.",
        desc=("Research desk. Deep fundamental dives: business, financials, catalysts, valuation, "
              "the bull and bear case. Ask 'deep research on PLTR'. Slower, thorough. "
              "My thoughts are clear.")),
    "telegram_deepseek_bot_token": dict(
        name="Screener", avatar="wraith",
        short="Recon flyer — finds & ranks names: movers, oversold, unusual volume.",
        desc=("Screener. Find and rank tickers on demand: top movers, oversold large-caps, "
              "unusual options volume, insider buying. Ask 'screen oversold large caps', "
              "'top movers today'. Cloaked and scanning.")),
    "telegram_mc_skill_bot_token": dict(
        name="Macro & Regime", avatar="mengsk",
        short="The Emperor's view — Fed, rates, regime, SPY/QQQ levels, politics.",
        desc=("Macro & regime. Top-down read: risk-on/off, Fed and rates, key SPY/QQQ levels, "
              "sector rotation, and how politics/news hits your book. Ask 'regime today?', "
              "'what does the Fed mean for me?'. The Dominion endures.")),
}


# Bots whose token lives in ~/.openclaw/vault.db (not a file) → key in the secrets table.
VAULT = os.path.expanduser("~/.openclaw/vault.db")
VAULT_IDENTITY = {
    "telegram_boba2_bot_token": dict(
        name="Flow Digest", avatar="hydralisk",
        short="The Swarm's daily flow brief — 3x a day best-of options flow.",
        desc=("Flow digest (push). The 3x/day best-of options-flow brief: verdict-first picks "
              "from the scraper. Pull more with /winners /sweeps from the Trading Command bot. "
              "The Swarm feeds.")),
    "telegram_hermes_bot_token": dict(
        name="Hermes Relay", avatar="dragoon",
        short="Hermes LLM router — message bus on the subscription wallet.",
        desc=("Hermes relay. Routes LLM traffic for the agent fleet on the subscription wallet. "
              "Infra relay — not a chat target. en taro Adun.")),
    "telegram_openclaw_bot_token": dict(
        name="OpenClaw Grok", avatar="ghost",
        short="OpenClaw's Grok/X relay — X-native intel from the Oracle box.",
        desc=("OpenClaw Grok relay. Grok / X-native intel from the openclaw (Oracle) box. "
              "Infra relay. We move unseen.")),
}


def _tok(f):
    return open(os.path.join(SEC, f)).read().strip()


def _vault_tok(key):
    import sqlite3
    con = sqlite3.connect(VAULT)
    try:
        row = con.execute("SELECT value FROM secrets WHERE key=?", (key,)).fetchone()
        return row[0].strip() if row else None
    finally:
        con.close()


def _ok(j):
    # "not modified" on a re-run is a success, not a failure
    return bool(j.get("ok")) or "not modified" in (j.get("description", "") or "").lower()


def _call(tok, method, **params):
    r = requests.post(f"https://api.telegram.org/bot{tok}/{method}", data=params, timeout=15)
    return r.json()


def _photo(tok, path):
    # Bot API 9.4: photo is an InputProfilePhoto (JSON) referencing the upload via attach://
    with open(path, "rb") as fh:
        r = requests.post(
            f"https://api.telegram.org/bot{tok}/setMyProfilePhoto",
            data={"photo": json.dumps({"type": "static", "photo": "attach://pic"})},
            files={"pic": fh}, timeout=30)
    return r.json()


def rebrand_tok(tok, idn):
    res = {}
    res["name"] = _ok(_call(tok, "setMyName", name=idn["name"]));            time.sleep(0.4)
    res["short"] = _ok(_call(tok, "setMyShortDescription", short_description=idn["short"])); time.sleep(0.4)
    res["desc"] = _ok(_call(tok, "setMyDescription", description=idn["desc"]));  time.sleep(0.4)
    pj = _photo(tok, f"{AV}/{idn['avatar']}.png")
    res["photo"] = _ok(pj)
    if not res["photo"]:
        res["photo_err"] = pj.get("description")
    return res


def rebrand(tokfile, idn):
    return rebrand_tok(_tok(tokfile), idn)


def rebrand_vault(key, idn):
    tok = _vault_tok(key)
    if not tok:
        return {"error": "no vault token"}
    return rebrand_tok(tok, idn)


if __name__ == "__main__":
    args = sys.argv[1:]
    if args and args[0] == "--smoke":
        tf = args[1]
        print(tf, "→", rebrand(tf, IDENTITY[tf]))
        sys.exit()
    for tf, idn in IDENTITY.items():
        try:
            r = rebrand(tf, idn)
            ok = all(r.get(k) for k in ("name", "short", "desc", "photo"))
            print(f"{'✓' if ok else '✗'} {idn['name']:16} {r}")
        except Exception as e:
            print(f"✗ {idn.get('name')}: {e}")
        time.sleep(1)
    for key, idn in VAULT_IDENTITY.items():    # vault-stored bots
        try:
            r = rebrand_vault(key, idn)
            ok = all(r.get(k) for k in ("name", "short", "desc", "photo"))
            print(f"{'✓' if ok else '✗'} {idn['name']:16} (vault) {r}")
        except Exception as e:
            print(f"✗ {idn.get('name')} (vault): {e}")
        time.sleep(1)
