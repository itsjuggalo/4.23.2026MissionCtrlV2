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
        name="Life & Wellness", avatar="raszagal",
        short="Your life compass — calendar, inbox, todos, weather. Zero trading.",
        desc=("Life & wellness assistant. Calendar, inbox, to-dos, weather, gentle nudges. "
              "/brief /today /todo. Talk to me like a friend, not a terminal. We embrace the shadows.")),
    "telegram_antigravity_bot_token": dict(
        name="AIME Briefs", avatar="zeratul",   # 2026-09-28: was "AIME Research" — push-only, no responder
        short="AInvest/AIME EOD brief + breakout scans (push only).",
        desc=("AIME briefs (push only — no chat). The AInvest/AIME end-of-day brief and the "
              "12:30 / 3:50 breakout scans. For questions, ask Trading Command. "
              "I have seen the future — and I will not let it come to pass.")),
    "telegram-bot-token.txt": dict(
        name="Flow Alerts & Exits", avatar="queen_of_blades",   # 2026-09-28: was "Flow Signals"
        short="Mega whale-flow alerts, exit warnings on open contracts, shock guards.",
        desc=("Flow alerts & exits (push). The meanest options flow: big sweeps, position exits, market "
              "shocks — straight to your phone. Pull the board with /winners /sweeps from the "
              "Trading Command bot. Paper-safe, edge-first. We will consume them.")),
    # 2026-09-28 — ex X-Sentiment (retired 09-27), now the QUIZ-ONLY lane (fleet fn `quiz`,
    # poller quiz_bot.py). Every trading quiz lives here, off the signal/command chats.
    "telegram_grok_bot_token": dict(
        name="Trading Quiz", avatar="nova",   # 2026-09-28: was "Options Quiz" — now carries every quiz
        short="Every trading quiz — options, live positions, signals, your trades. Tap A/B/C/D.",
        desc=("Quiz-only bot. Options Academy reps, live-position quizzes, signal quizzes from "
              "today's real flow, and lessons from your closed trades. Tap an answer to get "
              "graded; /quiz for another rep, /score for your belt and weak spots.")),
    # 2026-08-10 — un-parked as the ASTROLOGY-ONLY lane (fleet fn `astrology`). Natal chart,
    # real Swiss-Ephemeris transits, and the readings suite. Zero trading surface by design.
    "telegram_jazzyhazzy_bot_token": dict(
        name="Astrology", avatar="high_templar",
        short="Your chart, and only your chart — natal, live transits, readings. No trading.",
        desc=("Astrology — Mike's personal chart lane. /transits gives today's REAL sky "
              "(Swiss Ephemeris) against the Nov 3 1992 natal chart; /chart is the placements "
              "card; /readings lists the suite (natal, 2026 transits, career, future, "
              "trading-chart, Feb-2026 reading). Ask anything about the chart in plain English. "
              "No picks, no sizing, no market calls — that's Trading Command.")),
    # 2026-07-29 — un-parked and made the LEARNING lane. This is now fleet fn
    # `research_desk`: IV Desk, SPY Straddle Lab, Pre-Trade Confluence, payoff + IV
    # charts. Those five senders used to point at @ResearchDaMoney_Bot, which Mike
    # repurposed as his massage business chat — this bot exists so teaching content
    # has a quiet home that is neither a client chat nor the 57-msg/day cockpit.
    "antidote_telegram_bot_token": dict(
        name="Trading Lab", avatar="aldaris",
        short="Learn the mechanics — IV, straddles, payoff maths, confluence. No trade calls.",
        desc=("Trading Lab — the teaching lane. IV Desk (rich vs cheap vol), SPY Straddle "
              "Lab (ATM/OTM/ITM across daily/weekly/monthly), Pre-Trade Confluence, and "
              "payoff/IV charts. This bot NEVER tells you to buy anything — entries live in "
              "Trading Command and Flow Digest. Read this one to understand WHY a trade works.")),
    # 2026-07-29: this token IS the Massage By Mike website-chat relay (PM2 massage-chat-bot,
    # /AIWorkWSL/web/massage/server/chat-bot.js). Identity corrected 2026-09-28 (was still "PARKED").
    "telegram_orion_bot_token": dict(
        name="Massage By Mike — Chat", avatar="tassadar",
        short="Massage By Mike — website chat relay.",
        desc=("Massage By Mike — website chat. Messages from the booking-site chat widget are "
              "relayed here so Mike can reply.")),
    # 2026-07-19: ex-Screener token repurposed — now ClaudeClaw OS's own bot (grammy
    # poller in /AIWorkWSL/agents/claudeclaw; tg_responder "screener" lane RETIRED).
    "telegram_deepseek_bot_token": dict(
        name="ClaudeClaw OS", avatar="zergling",
        short="ClaudeClaw OS — agent dashboard, missions, /await + /gather orchestration.",
        desc=("ClaudeClaw OS bot. Talk to the laptop's agent hub: missions, scheduler, memory, "
              "skills, /delegate /await /gather orchestration, dashboard alerts. "
              "/help for commands. The Swarm needs you, magnificent bastard.")),
    # 2026-07-19: ex-Macro token repurposed — now the MasterMC agent's own bot
    # (claudeclaw --agent mastermc, MASTERMC_BOT_TOKEN; tg_responder "macro" lane RETIRED).
    # 2026-09-28: idle since mastermc was deleted (08-30) → "Trading Recaps" (fleet fn trading_recaps).
    "telegram_mc_skill_bot_token": dict(
        name="Trading Recaps", avatar="mengsk",
        short="End-of-day recaps: scorecards, grades, weekly report card.",
        desc=("Trading recaps (push). EOD scorecard, best-3 grades, the options position "
              "scorecard, scoreboard and the weekly report card — how the signals did, in one "
              "place, off the live alert chats.")),
}


# Bots whose token lives in ~/.openclaw/vault.db (not a file) → key in the secrets table.
VAULT = os.path.expanduser("~/.openclaw/vault.db")
VAULT_IDENTITY = {
    "telegram_boba2_bot_token": dict(   # 2026-09-28: "Trading Digest" (fleet fn trading_digest)
        name="Trading Digest", avatar="hydralisk",
        short="Compact FYI digest — watchlists, radars, pulses, one line per ticker.",
        desc=("Trading digest (push, silent). Pullback watch, runner radar, flow pulse, "
              "explosion watch and FYI flow notes folded into a few compact digests a day. "
              "Entries/exits/🟢 TRADE stay in Trading Command.")),
    "telegram_hermes_bot_token": dict(
        name="Hermes Agent", avatar="stukov",   # 2026-09-28: was "Hermes Relay"
        short="Chat with the Hermes agent (hermes-gateway on the laptop).",
        desc=("Hermes agent. DM to talk to the Hermes agent running on the laptop "
              "(PM2 hermes-gateway). No trading alerts land here. I will not fail you.")),
    "telegram_openclaw_bot_token": dict(
        name="OpenClaw Agent", avatar="duran",   # 2026-09-28: was "OpenClaw Grok" (Oracle box retired)
        short="Chat with the OpenClaw agent (openclaw-gateway on the laptop).",
        desc=("OpenClaw agent. DM to talk to the OpenClaw agent running on the laptop "
              "(PM2 openclaw-gateway). No trading alerts land here. "
              "Trust me — I know what I'm doing.")),
    # ── cloud bots folded into the fleet (new tg_fleet keys: telegram.<function>) ──────
    "telegram.daily_briefs": dict(
        name="Backup Alerts", avatar="battlecruiser",   # 2026-09-28: was "Daily Briefs" — fallback only
        short="Fallback only — gets a trading post only if Trading Digest can't send.",
        desc=("Backup alerts (push). Fallback lane: the EOD scorecard / flow picks land here only "
              "when the Trading Digest bot fails to send. The pre-open brief is in Trading Command. "
              "Battlecruiser operational.")),
    "telegram.media_gens": dict(
        name="Spare — Media (unused)", avatar="marine",   # 2026-09-28: was "Media & Gens" — nothing sends here
        short="Spare bot — reserved for media/gens; nothing sends here yet.",
        desc=("Spare bot (unused). Reserved for AI image/video output; no sender is wired to it "
              "today. Rock and roll.")),
    "telegram.spare_backup": dict(
        name="Spare Backup", avatar="sentinel",
        short="Spare relay — reserved capacity for the fleet.",
        desc=("Spare backup (push). Reserved fleet relay held for overflow / failover routing. "
              "I stand ready.")),
    # ── reserve pool (folded in 2026-06-16; names already Mike-set, add SC avatar + bio) ──
    "telegram.jazzy_relay": dict(
        name="Spare — Parked 1", avatar="dugalle",   # 2026-09-28: was "Jazzy Relay" (retired 09-15, no poller)
        short="Parked spare bot — not in use.",
        desc=("Parked spare bot. Nothing sends here and nothing answers DMs; held for a future "
              "lane. For the glory of Earth.")),
    "telegram.orion_relay": dict(
        name="Spare — Parked 2", avatar="artanis",   # 2026-09-28: was "Orion Relay" (retired 09-15, no poller)
        short="Parked spare bot — not in use.",
        desc=("Parked spare bot. Nothing sends here and nothing answers DMs; held for a future "
              "lane. En Taro Tassadar.")),
    "telegram.grok_scout": dict(        # 2026-09-28: "Crypto Desk" (fleet fn crypto_desk)
        name="Crypto Desk", avatar="dark_archon",
        short="BTC/ETH moves, crypto news and QuantEdge perp signals.",
        desc=("Crypto desk (push). BTC/ETH move + level alerts, crypto news sentiment and "
              "QuantEdge perp LONG/SHORT signals — all crypto, off the stock chats. Execute on "
              "Coinbase yourself; bots advise only.")),
    "telegram.trend_scanner": dict(
        name="WinMeals Alerts", avatar="overmind",   # 2026-09-28: was "Trend Scanner" — fleet fn winmeals
        short="WinMeals app alerts — promo checks, deal discovery, chain footprint, monitors.",
        desc=("WinMeals alerts (push). The WinMeals app's own events: promo verification and "
              "freshness, deal discovery, chain footprint and site monitors. No trading here. "
              "I am the Swarm.")),
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
