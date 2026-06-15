#!/usr/bin/env python3
"""aime_discord_bot.py — AIME in Discord (browserless, no window).

Mirrors the Telegram AIME bot for Discord. Ask AIME two ways:
  - Slash command:  /aime question:<text>        (works with no privileged intents)
  - Dedicated channel: set AIME_CHANNEL_ID and every message there is an AIME query
    (requires the Message Content intent enabled on the bot).

Uses the shared browserless client (~/scripts/aime_client.py) — pure HTTP + ainvest
cookie, never a browser. Bot token from ~/.openclaw/secrets/<DISCORD_AIME_TOKEN_FILE>.
"""
from __future__ import annotations

import asyncio
import json
import os
import re
import subprocess
import sys
import tempfile
from datetime import datetime, timezone
from pathlib import Path
from typing import Optional

sys.path.insert(0, str(Path.home() / "scripts"))
sys.path.insert(0, str(Path.home() / "05_AUTOMATION" / "scripts"))
import aime_client as aime  # noqa: E402
import discord  # noqa: E402
from discord import app_commands  # noqa: E402
from lib.portfolio import (portfolio_summary, add_watch, remove_watch,  # noqa: E402
                           get_watchlist, total_equity, daily_journal_recap, weekly_review)
from lib import x_search  # noqa: E402  — native Grok x_search w/ web fallback

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = os.environ.get("DISCORD_AIME_TOKEN_FILE", "discord_ops_bot_token")
TOKEN = (SEC / TOKEN_FILE).read_text(encoding="utf-8").strip()
CHANNEL_ID = int(os.environ.get("AIME_CHANNEL_ID", "0") or 0)
DISCORD_MAX = 2000


def _chunks(text: str):
    text = text or "[empty]"
    for i in range(0, len(text), DISCORD_MAX):
        yield text[i:i + DISCORD_MAX]


async def _answer(question: str) -> str:
    # ask_aime is blocking HTTP — run off the event loop
    return await asyncio.to_thread(aime.ask_aime, question)


# ─── HEADLESS SKILL BRIDGE ────────────────────────────────────────────────────
# Run any Claude skill via `claude -p`, billed to the claude.ai SUBSCRIPTION (the
# ANTHROPIC_API_KEY is stripped). Same proven pattern as antigravity_aime_bot.ask_local
# and flow_digest_cron.sh — cwd=$HOME + --allowedTools are mandatory or it's
# permission-blocked at runtime; use ~/.local/bin/claude (the sub CLI, not ~/bin wrapper).
CLAUDE_BIN = str(Path.home() / ".local/bin/claude")
CLAUDE_CWD = str(Path.home())
CLAUDE_TOOLS = "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite"


def _run_skill(prompt: str, model: str = "sonnet", timeout: int = 300) -> str:
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    try:
        r = subprocess.run(
            [CLAUDE_BIN, "-p", prompt, "--model", model, "--output-format", "json",
             "--allowedTools", CLAUDE_TOOLS],
            capture_output=True, text=True, timeout=timeout, env=env, cwd=CLAUDE_CWD)
        if r.returncode != 0:
            return f"[skill error rc={r.returncode}] {r.stderr.strip()[:300]}"
        out = json.loads(r.stdout)
        return (out.get("result") or "").strip() or "[skill returned empty]"
    except subprocess.TimeoutExpired:
        return f"[skill timed out after {timeout}s]"
    except Exception as e:  # noqa: BLE001
        return f"[skill error] {e}"


async def _answer_skill(prompt: str, timeout: int = 300) -> str:
    return await asyncio.to_thread(_run_skill, prompt, "sonnet", timeout)


async def _send_chunks(interaction: discord.Interaction, text: str) -> None:
    parts = list(_chunks(text))
    await interaction.followup.send(parts[0])
    for p in parts[1:]:
        await interaction.followup.send(p)


# ─── INTERACTIVE PICK CARDS (persistent buttons) ──────────────────────────────
# A persistent View (timeout=None, static custom_ids) registered in on_ready so
# clicks keep working across bot restarts. The ticker is read back from the card
# text, so no per-message state is needed.
JOURNAL = Path.home() / ".openclaw" / "data" / "trade_journal.jsonl"


def _journal(ticker: str, action: str, user: str) -> None:
    try:
        JOURNAL.parent.mkdir(parents=True, exist_ok=True)
        rec = {"ts": datetime.now(timezone.utc).isoformat(), "ticker": ticker,
               "action": action, "user": user}
        with open(JOURNAL, "a") as f:
            f.write(json.dumps(rec) + "\n")
    except Exception as e:  # noqa: BLE001
        print(f"[pick] journal err: {e}", flush=True)


def _ticker_from_msg(msg) -> str:
    m = re.search(r"TRADE IDEA — ([A-Z.]{1,6})", (msg.content if msg else "") or "")
    return m.group(1) if m else "?"


class PickView(discord.ui.View):
    def __init__(self):
        super().__init__(timeout=None)

    @discord.ui.button(label="Took it", emoji="✅",
                       style=discord.ButtonStyle.success, custom_id="pk:took")
    async def b_took(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _ticker_from_msg(interaction.message)
        _journal(t, "took", interaction.user.display_name)
        await interaction.response.send_message(
            f"✅ Logged **{t}** as TAKEN by {interaction.user.display_name}.")

    @discord.ui.button(label="Skip", emoji="❌",
                       style=discord.ButtonStyle.danger, custom_id="pk:skip")
    async def b_skip(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _ticker_from_msg(interaction.message)
        _journal(t, "skip", interaction.user.display_name)
        await interaction.response.send_message(f"❌ **{t}** skipped.", ephemeral=True)

    @discord.ui.button(label="Analyze", emoji="📊",
                       style=discord.ButtonStyle.primary, custom_id="pk:analyze")
    async def b_analyze(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _ticker_from_msg(interaction.message)
        await interaction.response.defer(thinking=True)
        await _send_chunks(interaction, await _answer_skill(f"/ticker-research {t}"))


intents = discord.Intents.default()
# Only request the privileged message-content intent if a channel listener is configured.
if CHANNEL_ID:
    intents.message_content = True

client = discord.Client(intents=intents)
tree = app_commands.CommandTree(client)


@tree.command(name="aime", description="Ask AInvest AIME (market/stock/options intelligence)")
@app_commands.describe(question="What do you want to ask AIME?")
async def aime_cmd(interaction: discord.Interaction, question: str):
    await interaction.response.defer(thinking=True)
    ans = await _answer(question)
    parts = list(_chunks(ans))
    await interaction.followup.send(parts[0])
    for p in parts[1:]:
        await interaction.followup.send(p)


# ─── TRADING SLASH COMMANDS (each shells to a Claude skill on the subscription) ──
# Wave 1 — the daily-driver eight.
@tree.command(name="ainvest", description="AInvest copilot read on a ticker or question")
@app_commands.describe(query="ticker or question")
async def ainvest_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/ainvest {query}"))


@tree.command(name="options", description="Options-desk verdict (optionally attach a chain/position screenshot)")
@app_commands.describe(ticker="ticker or options question", screenshot="optional chain/position screenshot")
async def options_cmd(interaction: discord.Interaction, ticker: str,
                      screenshot: Optional[discord.Attachment] = None):
    await interaction.response.defer(thinking=True)
    prompt = f"/options-desk {ticker}"
    if screenshot is not None:
        path = os.path.join(tempfile.gettempdir(), f"opt_{interaction.id}_{screenshot.filename}")
        await screenshot.save(path)
        prompt = f"/options-desk {ticker} — read the attached screenshot at {path} for the chain/position."
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=420))


@tree.command(name="ticker", description="2-minute vet of the name behind a signal")
@app_commands.describe(symbol="ticker symbol")
async def ticker_cmd(interaction: discord.Interaction, symbol: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/ticker-research {symbol}"))


@tree.command(name="regime", description="Market regime / macro lens (optional ticker)")
@app_commands.describe(symbol="optional ticker for context")
async def regime_cmd(interaction: discord.Interaction, symbol: Optional[str] = None):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/market-context {symbol or ''}".strip()))


@tree.command(name="news", description="Market / company news + catalysts")
@app_commands.describe(query="ticker or topic")
async def news_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/news-search {query}"))


@tree.command(name="trades", description="What fired today — flow alerts / auto-trader / top tickers")
@app_commands.describe(query="optional filter (e.g. 'NVDA' or 'top tickers')")
async def trades_cmd(interaction: discord.Interaction, query: Optional[str] = None):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/mc-trades {query or 'what fired today'}"))


@tree.command(name="decide", description="Combined SQL+RAG buy/sell/hold decision packet")
@app_commands.describe(query="the trade question")
async def decide_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/mc-decide {query}", timeout=540))


@tree.command(name="signals", description="Signal-source liveness sweep (is anything dead?)")
async def signals_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill("/signal-liveness"))


# Wave 2 — heavier / scheduled skills, now also manually triggerable.
@tree.command(name="desk-eod", description="End-of-day desk wrap (P&L + hit-rate across pipelines)")
async def desk_eod_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill("/desk-eod", timeout=540))


@tree.command(name="morning", description="Morning note — overnight SPY/QQQ/BTC + Fed + headlines")
async def morning_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill("/morning-note", timeout=420))


@tree.command(name="crypto", description="Crypto desk read on a coin")
@app_commands.describe(coin="coin symbol (BTC, ETH, SOL...)")
async def crypto_cmd(interaction: discord.Interaction, coin: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/crypto-desk {coin}"))


@tree.command(name="recall", description="Search the Mission Control knowledge base (docs/memory/bible)")
@app_commands.describe(query="what to look up")
async def recall_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/mc-recall {query}", timeout=420))


@tree.command(name="summarize", description="TL;DR of recent activity in a channel (trader-relevant)")
@app_commands.describe(channel="channel to summarize (default: here)",
                       limit="how many recent messages (default 50, max 200)")
async def summarize_cmd(interaction: discord.Interaction,
                        channel: Optional[discord.TextChannel] = None,
                        limit: Optional[int] = None):
    await interaction.response.defer(thinking=True)
    ch = channel or interaction.channel
    chname = getattr(ch, "name", "channel")
    n = max(10, min(limit or 50, 200))
    try:
        # REST history returns message content WITHOUT the privileged intent
        msgs = [m async for m in ch.history(limit=n)]
    except discord.Forbidden:
        await interaction.followup.send(
            f"⚠️ I can't read #{chname} — missing View Channel / Read Message History permission there.")
        return
    except Exception as e:  # noqa: BLE001
        await interaction.followup.send(f"⚠️ Couldn't read #{chname}: {e}")
        return
    lines = []
    for m in reversed(msgs):  # oldest → newest
        content = (m.content or "").strip()
        if not content and m.embeds:
            e = m.embeds[0]
            content = " ".join(x for x in (e.title, e.description) if x).strip()
        if not content:
            continue
        author = getattr(m.author, "display_name", None) or m.author.name
        lines.append(f"[{author}] {content}")
    if not lines:
        await interaction.followup.send(f"Nothing readable in #{chname} (last {n} messages).")
        return
    transcript = "\n".join(lines)[-6000:]
    prompt = (f"Summarize this Discord trading channel (#{chname}) for a day trader. Tight TL;DR: "
              f"the key signals/alerts, tickers + setups mentioned, notable decisions or errors, and "
              f"the single most actionable takeaway. Bullet points, no fluff.\n\n"
              f"--- transcript (oldest→newest) ---\n{transcript}")
    summary = await _answer_skill(prompt, timeout=300)
    await _send_chunks(interaction, f"📋 **SUMMARY — #{chname}** (last {len(lines)} msgs)\n\n{summary}")


# ─── X / SOCIAL LANE (Tavily/WebSearch bridge until native Grok-on-subscription is wired) ──
@tree.command(name="x", description="What's X/Twitter saying about a ticker (social sentiment)")
@app_commands.describe(query="ticker or topic")
async def x_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    # Prefer native Grok x_search on the OAuth subscription (real X firehose); fall
    # back to the web/Tavily bridge until Mike mints the token via ~/bin/grok-sub-login.
    native = await asyncio.to_thread(x_search.x_sentiment, query)
    if native:
        await _send_chunks(interaction, f"🐦 **X SENTIMENT — {query}** _(native Grok)_\n{native}")
        return
    prompt = (f"Search X.com / Twitter for the most important trader-relevant posts about {query} "
              f"in the last 24h (use web search). Summarize the prevailing sentiment (bullish/"
              f"bearish), any notable accounts/posts, and catalysts. Keep it tight.")
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=300))


@tree.command(name="flowpicks", description="Rank today's biggest options flow by risk-adjusted setup quality")
async def flowpicks_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    prompt = ("/ainvest rank the most significant options flow today by risk-adjusted setup "
              "quality — top 5 with ticker, contract, why it stands out, and entry logic.")
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=420))


@tree.command(name="portfolio", description="Live positions + P&L across Boba + Jazzy")
async def portfolio_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    # deterministic Alpaca read (no LLM) — fast
    await _send_chunks(interaction, await asyncio.to_thread(portfolio_summary))


@tree.command(name="pick", description="Post an actionable trade-idea card with Took-it / Skip / Analyze buttons")
@app_commands.describe(ticker="ticker", note="optional thesis / contract / note")
async def pick_cmd(interaction: discord.Interaction, ticker: str, note: Optional[str] = None):
    ticker = ticker.upper().strip()
    body = f"🎯 **TRADE IDEA — {ticker}**"
    if note:
        body += f"\n{note}"
    body += "\n*Tap a button — log it, skip, or pull a full vet.*"
    await interaction.response.send_message(body, view=PickView())


@tree.command(name="watch", description="Add a ticker to your watchlist (feeds the scheduled intel)")
@app_commands.describe(ticker="ticker to watch")
async def watch_cmd(interaction: discord.Interaction, ticker: str):
    wl = await asyncio.to_thread(add_watch, ticker)
    await interaction.response.send_message(
        f"👁️ Watching **{ticker.upper().strip()}** — it'll show up in your X-sentiment, "
        f"opening read, and news feeds.\nWatchlist: {', '.join(wl) or '(empty)'}")


@tree.command(name="unwatch", description="Remove a ticker from your watchlist")
@app_commands.describe(ticker="ticker to remove")
async def unwatch_cmd(interaction: discord.Interaction, ticker: str):
    wl = await asyncio.to_thread(remove_watch, ticker)
    await interaction.response.send_message(
        f"✖️ Unwatched **{ticker.upper().strip()}**.\nWatchlist: {', '.join(wl) or '(empty)'}")


@tree.command(name="watchlist", description="Show your watchlist")
async def watchlist_cmd(interaction: discord.Interaction):
    wl = await asyncio.to_thread(get_watchlist)
    await interaction.response.send_message(f"👁️ Watchlist: {', '.join(wl) or '(empty)'}")


HELP_TEXT = (
    "⚡ **MISSION CONTROL — COMMAND DECK**\n\n"
    "**📊 Analysis (ask anytime)**\n"
    "`/ainvest <q>` read on anything · `/options <ticker>` options verdict (+screenshot)\n"
    "`/ticker <sym>` 2-min vet · `/decide <q>` buy/sell/hold · `/crypto <coin>` crypto read\n"
    "`/news <q>` catalysts · `/regime` market regime · `/recall <q>` knowledge base\n\n"
    "**💼 Portfolio, trades & planning**\n"
    "`/portfolio` live P&L · `/journal` today's recap · `/week` weekly review · `/trades` fills today\n"
    "`/levels <t>` S/R + entry/stop · `/size <t> <entry> <stop>` position size · `/pick <t>` action card\n"
    "`/flowpicks` ranked flow · `/signals` source liveness\n\n"
    "**👁️ Watchlist** (feeds your scheduled intel)\n"
    "`/watch <t>` · `/unwatch <t>` · `/watchlist`\n\n"
    "**🐦 Intel & briefs**\n"
    "`/x <ticker>` social sentiment · `/summarize [#chan]` channel TL;DR · `/desk-eod` EOD wrap · "
    "`/morning` morning note · `/aime <q>`\n\n"
    "**🛰️ Runs automatically:** morning briefing + events (8:05/8:15) · opening read (9:35) · "
    "**flow picks → #flow-picks (9:50/11/12:30/2/3:20)** · regime/news/X-sentiment (native Grok) · "
    "position-mgmt (11:30/2:00) · power hour (2:55) · portfolio snapshots (9:35/4:05) · "
    "**your-crypto alerts → #daily-crypto-pumps (24h ≥5% /30m + 15-min spike ≥3% /5m)** · "
    "risk/exit/shock alerts."
)


@tree.command(name="help", description="Show the full command deck + what runs automatically")
async def help_cmd(interaction: discord.Interaction):
    await interaction.response.send_message(HELP_TEXT)


@tree.command(name="size", description="Position size for a trade per your risk rules (equity fraction, $100-250 cap)")
@app_commands.describe(ticker="ticker", entry="entry price", stop="stop price",
                       risk="$ to risk (default 150, capped at 250)")
async def size_cmd(interaction: discord.Interaction, ticker: str, entry: float,
                   stop: float, risk: Optional[float] = None):
    await interaction.response.defer(thinking=True)
    eq = await asyncio.to_thread(total_equity)
    risk_amt = min(risk if risk else 150.0, 250.0)   # Mike's $100-250 cap
    psr = abs(entry - stop)
    if psr <= 0:
        await interaction.followup.send("⚠️ Entry and stop can't be equal.")
        return
    shares = int(risk_amt // psr)
    cost = shares * entry
    lines = [f"📐 **SIZE — {ticker.upper().strip()}**"]
    if eq:
        lines.append(f"Equity ${eq:,.0f} · risking ${risk_amt:,.0f} ({risk_amt/eq*100:.1f}% of equity)")
    else:
        lines.append(f"Risking ${risk_amt:,.0f}")
    lines.append(f"Entry ${entry:.2f} → stop ${stop:.2f} = ${psr:.2f}/share risk")
    cost_tag = f" ({cost/eq*100:.0f}% of equity)" if eq else ""
    lines.append(f"➡️ **{shares} shares** (~${cost:,.0f}{cost_tag})")
    lines.append(f"Max loss if stopped: **${shares*psr:,.0f}**")
    if shares == 0:
        lines.append("⚠️ Stop too wide for the risk budget — tighten the stop or raise risk.")
    elif eq and cost > eq:
        lines.append("⚠️ Cost exceeds account equity — reduce size.")
    elif eq and cost > eq * 0.5:
        lines.append("⚠️ >50% of equity in one name — concentration risk.")
    await interaction.followup.send("\n".join(lines))


@tree.command(name="journal", description="Today's trade recap — day P&L, fills, open book")
async def journal_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await asyncio.to_thread(daily_journal_recap))


@tree.command(name="week", description="This week's performance review (P&L, trades, most active)")
async def week_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await asyncio.to_thread(weekly_review))


@tree.command(name="levels", description="Key support/resistance + a suggested entry & stop (plug into /size)")
@app_commands.describe(ticker="ticker")
async def levels_cmd(interaction: discord.Interaction, ticker: str):
    await interaction.response.defer(thinking=True)
    t = ticker.upper().strip()
    prompt = (f"For {t}: list the key intraday and swing SUPPORT and RESISTANCE levels with the "
              f"current price, then give a concrete suggested ENTRY and STOP for a long (say clearly "
              f"if it's a no-trade / wait setup). Format tight, and put 'Entry X / Stop Y' on its own "
              f"line so it plugs into /size. End with a one-line bias. Use web search for live levels.")
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=300))


_VIEWS_ADDED = False


@client.event
async def on_ready():
    global _VIEWS_ADDED
    if not _VIEWS_ADDED:
        client.add_view(PickView())   # persistent — buttons survive restarts
        _VIEWS_ADDED = True
    try:
        gid = os.environ.get("AIME_GUILD_ID")
        if gid:
            g = discord.Object(id=int(gid))
            tree.copy_global_to(guild=g)
            await tree.sync(guild=g)
        else:
            await tree.sync()
    except Exception as e:  # noqa: BLE001
        print(f"[aime-discord] slash sync failed: {e}", flush=True)
    print(f"[aime-discord] ready as {client.user} | channel_listen={'on' if CHANNEL_ID else 'off'}",
          flush=True)


@client.event
async def on_message(message: discord.Message):
    if message.author.bot or not CHANNEL_ID or message.channel.id != CHANNEL_ID:
        return
    q = (message.content or "").strip()
    if not q or q.startswith("/"):
        return
    async with message.channel.typing():
        ans = await _answer(q)
    for p in _chunks(ans):
        await message.channel.send(p)


if __name__ == "__main__":
    client.run(TOKEN)
