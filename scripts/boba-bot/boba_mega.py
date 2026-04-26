#!/usr/bin/env python3
"""Boba mega-bot — slash commands + !boba Q&A.
Block 1: scaffold + slash registration. Stub handlers only.
Block 2 will fill in /scan + !boba Q&A logic.
Block 3 will add /backtest.
Block 4 will add /trade with arm/disarm safety.

Locked to OWNER_ID. Slash commands sync to GUILD_ID for instant availability.
"""
import asyncio, json, os, sys, time, logging, re
from datetime import datetime, timezone, timedelta
from pathlib import Path
from collections import defaultdict
import discord
from discord import app_commands
from discord.ext import commands
import requests

sys.path.insert(0, '/home/ubuntu/scripts/lib')
try:
    import tradier_client as tc
except ImportError:
    tc = None

SECRETS = Path.home() / ".openclaw" / "secrets"
TOKEN = (SECRETS / "discord_boba_token").read_text().strip()
GUILD_ID = int((SECRETS / "discord_guild_id").read_text().strip())
OWNER_ID = 733531188752285716

# Channel IDs Boba can output to
CHAN = {
    "boba_cmd":      int((SECRETS / "discord_boba_cmd_channel").read_text().strip()),
    "trade_paper":   int((SECRETS / "discord_trade_paper_channel").read_text().strip()),
    "trade_live":    int((SECRETS / "discord_trade_live_channel").read_text().strip()),
    "backtest":      int((SECRETS / "discord_backtest_channel").read_text().strip()),
}


RELAY_DATA = Path.home() / "mission-control-restored" / "Option-Signals-Scraper" / "data"
ANTHROPIC_KEY = (SECRETS / "anthropic_api_key").read_text().strip()
GROK_KEY_FILE = SECRETS / "xai_api_key"
GROK_KEY = GROK_KEY_FILE.read_text().strip() if GROK_KEY_FILE.exists() else None
ANTHROPIC_MODEL = "claude-sonnet-4-6"


def _fmt_prem(v):
    if v >= 1_000_000: return f"${v/1_000_000:.2f}M"
    if v >= 1_000: return f"${v/1_000:.0f}K"
    return f"${v:.0f}"


def _read_data(name):
    f = RELAY_DATA / f"{name}.json"
    if not f.exists(): return None
    try: return json.loads(f.read_text())
    except: return None


def _ticker_quote(symbol):
    """Tradier real-time quote."""
    try:
        key = (SECRETS / "tradier-sandbox-key").read_text().strip()
        r = requests.get(
            "https://sandbox.tradier.com/v1/markets/quotes",
            headers={"Authorization": f"Bearer {key}", "Accept": "application/json"},
            params={"symbols": symbol}, timeout=8,
        )
        if r.status_code != 200: return None
        q = (r.json().get("quotes", {}) or {}).get("quote")
        if not q: return None
        if isinstance(q, list): q = q[0]
        last = float(q.get("last", 0) or 0)
        prev = float(q.get("prevclose", 0) or 0)
        chg_pct = ((last - prev) / prev * 100) if prev > 0 else 0
        return {
            "last": last, "prev": prev, "chg_pct": chg_pct,
            "open": float(q.get("open", 0) or 0),
            "high": float(q.get("high", 0) or 0),
            "low": float(q.get("low", 0) or 0),
            "volume": int(q.get("volume", 0) or 0),
        }
    except Exception as e:
        logging.error(f"quote {symbol}: {e}")
        return None


def _ticker_flow_today(symbol):
    """Today's options flow stats for a single ticker."""
    d = _read_data("flow_liveflows_today") or {}
    if not isinstance(d, dict): return None
    bull, bear, total, n, sweeps = 0.0, 0.0, 0.0, 0, 0
    for entry in d.values():
        if not isinstance(entry, dict): continue
        if entry.get("Symbol") != symbol: continue
        opt = entry.get("OptionType", "")
        ba = entry.get("BidAskType", "")
        val = float(entry.get("Value", 0) or 0)
        if val <= 0: continue
        is_bull = (opt == "CALL" and ba == "A") or (opt == "PUT" and ba == "B")
        is_bear = (opt == "CALL" and ba == "B") or (opt == "PUT" and ba == "A")
        if is_bull: bull += val
        elif is_bear: bear += val
        else: continue
        total += val
        n += 1
        if entry.get("BlockType") == "SWEEP": sweeps += 1
    if n == 0: return None
    bull_pct = (bull / total * 100) if total > 0 else 50
    return {"n": n, "total": total, "bull": bull, "bear": bear,
            "bull_pct": bull_pct, "sweeps": sweeps}


def _ticker_win_rate(symbol):
    """Historical W/L for symbol across all closed files."""
    files = ["closed_options", "closed_stocks", "ts_closed_options",
             "ts_closed_stocks", "ss_closed_options", "ss_closed_stocks"]
    wins = losses = 0
    last_pnls = []
    for fname in files:
        d = _read_data(fname) or {}
        entries = list(d.values()) if isinstance(d, dict) else (d if isinstance(d, list) else [])
        for e in entries:
            if not isinstance(e, dict): continue
            if e.get("symbol") != symbol: continue
            status = (e.get("status") or "").lower()
            if any(p in status for p in ("profit", "locked", "booked")):
                wins += 1
            elif any(p in status for p in ("stop", "loss")):
                losses += 1
    n = wins + losses
    if n == 0: return None
    return {"n": n, "wins": wins, "losses": losses,
            "win_rate": wins / n * 100}


def _grok_news(symbol, limit=4):
    """Get recent news via Grok x_search if key available."""
    if not GROK_KEY:
        return None
    try:
        r = requests.post(
            "https://api.x.ai/v1/responses",
            headers={"Authorization": f"Bearer {GROK_KEY}", "Content-Type": "application/json"},
            json={
                "model": "grok-4-fast-non-reasoning",
                "input": f"Top {limit} most recent news headlines about ${symbol} stock from last 24 hours. Just headlines, one per line, no commentary.",
                "tools": [{"type": "x_search"}],
                "max_output_tokens": 400,
            },
            timeout=20,
        )
        if r.status_code != 200: return None
        data = r.json()
        # Extract output text
        for item in data.get("output", []):
            if item.get("type") == "message":
                for c in item.get("content", []):
                    if c.get("type") == "output_text":
                        return c.get("text", "").strip()
        return None
    except Exception as e:
        logging.error(f"grok news {symbol}: {e}")
        return None


def _ask_anthropic(question, context_blob=""):
    """Send question to Claude with current MC context. Returns text response."""
    system = (
        "You are Boba, the AI orchestrator for Mike's Mission Control trading system. "
        "Mike runs an algorithmic trading operation with multi-agent intelligence "
        "(you, Orion for technicals, JazzyHazzy for news/sentiment, Grok for X data). "
        "Be direct, specific, and trade-focused. Cite numbers when you have them. "
        "Mike trades stocks, crypto, options on Alpaca + Hyperliquid + Robinhood. "
        "Default account: PA3R6MOPBWF7 ($500K paper, Level 3, OCO supported). "
        "When making trade calls, give clear setup: entry / stop / TP. "
        "When uncertain, say so. Never invent numbers."
    )
    if context_blob:
        system += f"\n\nCurrent Mission Control context:\n{context_blob}"
    try:
        r = requests.post(
            "https://api.anthropic.com/v1/messages",
            headers={
                "x-api-key": ANTHROPIC_KEY,
                "anthropic-version": "2023-06-01",
                "content-type": "application/json",
            },
            json={
                "model": ANTHROPIC_MODEL,
                "max_tokens": 1024,
                "system": system,
                "messages": [{"role": "user", "content": question}],
            },
            timeout=45,
        )
        if r.status_code != 200:
            logging.error(f"anthropic {r.status_code}: {r.text[:300]}")
            return f"[Boba] API error {r.status_code}"
        return r.json().get("content", [{}])[0].get("text", "").strip()
    except Exception as e:
        logging.error(f"anthropic {e}")
        return f"[Boba] error: {e}"


def _build_context_blob():
    """Snapshot of current MC state for !boba prompt context."""
    parts = []
    flow = _read_data("flow_liveflows_today") or {}
    if isinstance(flow, dict) and flow:
        bull, bear = 0, 0
        for e in flow.values():
            if not isinstance(e, dict): continue
            v = float(e.get("Value", 0) or 0)
            if v <= 0: continue
            opt = e.get("OptionType", "")
            ba = e.get("BidAskType", "")
            if (opt == "CALL" and ba == "A") or (opt == "PUT" and ba == "B"):
                bull += v
            elif (opt == "CALL" and ba == "B") or (opt == "PUT" and ba == "A"):
                bear += v
        total = bull + bear
        bull_pct = (bull / total * 100) if total > 0 else 50
        parts.append(f"Today's overall options flow: {bull_pct:.0f}% bull "
                     f"({_fmt_prem(bull)} / {_fmt_prem(bear)} bear), "
                     f"{len(flow)} fills tracked.")

    return "\n".join(parts) if parts else "No live state snapshot available."


def _chunk_message(text, limit=1900):
    """Split long messages into Discord-friendly chunks."""
    if len(text) <= limit:
        return [text]
    chunks = []
    while text:
        if len(text) <= limit:
            chunks.append(text); break
        cut = text.rfind("\n", 0, limit)
        if cut < 0: cut = limit
        chunks.append(text[:cut])
        text = text[cut:].lstrip("\n")
    return chunks


LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "boba_mega.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)

intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True


class BobaBot(commands.Bot):
    def __init__(self):
        super().__init__(command_prefix="!", intents=intents)

    async def setup_hook(self):
        guild = discord.Object(id=GUILD_ID)
        # Sync slash commands to this guild (instant; global takes up to 1hr)
        self.tree.copy_global_to(guild=guild)
        synced = await self.tree.sync(guild=guild)
        print(f"[boba-mega] synced {len(synced)} slash commands to guild {GUILD_ID}", flush=True)
        for cmd in synced:
            print(f"[boba-mega]   /{cmd.name}: {cmd.description}", flush=True)


bot = BobaBot()


def is_owner(interaction: discord.Interaction) -> bool:
    return interaction.user.id == OWNER_ID


# ─── /scan ────────────────────────────────────────────────────────────
@bot.tree.command(name="scan", description="Get full context on a ticker")
@app_commands.describe(ticker="Stock ticker symbol (e.g. NVDA, BTC, AAPL)")
async def scan(interaction: discord.Interaction, ticker: str):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return
    ticker = ticker.upper().strip()
    await interaction.response.defer(thinking=True)
    logging.info(f"/scan {ticker} by {interaction.user.id}")

    # Run all data fetches in thread pool (don't block event loop)
    loop = asyncio.get_event_loop()
    quote = await loop.run_in_executor(None, _ticker_quote, ticker)
    flow = await loop.run_in_executor(None, _ticker_flow_today, ticker)
    wr = await loop.run_in_executor(None, _ticker_win_rate, ticker)
    news = await loop.run_in_executor(None, _grok_news, ticker, 4)

    embed = discord.Embed(
        title=f"🔍 Scan: {ticker}",
        color=0x3498db,
        timestamp=datetime.now(timezone.utc),
    )

    # Quote
    if quote and quote["last"] > 0:
        sign = "+" if quote["chg_pct"] >= 0 else ""
        emoji = "🟢" if quote["chg_pct"] >= 0 else "🔴"
        embed.add_field(
            name="📈 Quote",
            value=(f"{emoji} **${quote['last']:.2f}** ({sign}{quote['chg_pct']:.2f}%)\n"
                   f"O ${quote['open']:.2f} • H ${quote['high']:.2f} • "
                   f"L ${quote['low']:.2f} • Vol {quote['volume']:,}"),
            inline=False,
        )
    else:
        embed.add_field(name="📈 Quote", value="_Tradier returned no data_", inline=False)

    # Today's flow
    if flow:
        embed.add_field(
            name="🌊 Today's Options Flow",
            value=(f"Total: **{_fmt_prem(flow['total'])}** across {flow['n']} fills\n"
                   f"Direction: **{flow['bull_pct']:.0f}% bull** "
                   f"({_fmt_prem(flow['bull'])} / {_fmt_prem(flow['bear'])} bear)\n"
                   f"Sweeps: {flow['sweeps']}"),
            inline=False,
        )
    else:
        embed.add_field(name="🌊 Today's Options Flow", value="_No flow data for this ticker today_", inline=False)

    # Historical win rate
    if wr:
        embed.add_field(
            name="🎯 Historical Performance",
            value=(f"**{wr['win_rate']:.0f}% win rate** "
                   f"({wr['wins']}W / {wr['losses']}L over {wr['n']} closed trades)"),
            inline=False,
        )
    else:
        embed.add_field(name="🎯 Historical Performance", value="_No closed trade history for this ticker_", inline=False)

    # News
    if news:
        embed.add_field(
            name="📰 Recent News (via Grok)",
            value=news[:1024],
            inline=False,
        )

    embed.set_footer(text=f"Boba scan • {datetime.now().strftime('%-I:%M %p ET')}")
    await interaction.followup.send(embed=embed)


# ─── /backtest ───────────────────────────────────────────────────────
@bot.tree.command(name="backtest", description="Run a backtest of a strategy")
@app_commands.describe(
    strategy="Strategy name (e.g. supertrend, whale_catcher)",
    symbol="Symbol (e.g. BTCUSD, SPY)",
    timeframe="Timeframe (e.g. 1h, 4h, 1d)",
)
async def backtest(interaction: discord.Interaction, strategy: str, symbol: str, timeframe: str = "1h"):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return
    await interaction.response.send_message(
        f"📊 /backtest {strategy} {symbol} {timeframe} — handler not yet implemented (Block 3 ships later)",
        ephemeral=True,
    )
    logging.info(f"/backtest {strategy} {symbol} {timeframe} by {interaction.user.id}")


# ─── /trade ──────────────────────────────────────────────────────────
@bot.tree.command(name="trade", description="Place a trade (paper by default)")
@app_commands.describe(
    ticker="Stock ticker (e.g. NVDA)",
    side="Order side: buy or sell",
    qty="Quantity",
    asset_type="stock, call, or put",
    strike="Strike price (for options only)",
    expiry="Expiry MM/DD (for options only, e.g. 5/15)",
)
async def trade(
    interaction: discord.Interaction,
    ticker: str,
    side: str,
    qty: int,
    asset_type: str = "stock",
    strike: float = None,
    expiry: str = None,
):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return
    await interaction.response.send_message(
        f"💼 /trade {side} {qty} {ticker} {asset_type} — handler not yet implemented (Block 4 ships later)\n"
        f"_Will default to PAPER mode (R2 sandbox). Use !arm to enable LIVE._",
        ephemeral=True,
    )
    logging.info(f"/trade {side} {qty} {ticker} by {interaction.user.id}")


# ─── /boba_help ──────────────────────────────────────────────────────
@bot.tree.command(name="boba_help", description="Show Boba's available commands")
async def boba_help(interaction: discord.Interaction):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return
    msg = (
        "🤖 **Boba's Command Reference**\n"
        "\n"
        "**Slash commands:**\n"
        "• `/scan TICKER` — full context on a ticker (Block 2)\n"
        "• `/backtest STRATEGY SYMBOL TIMEFRAME` — backtest a strategy (Block 3)\n"
        "• `/trade TICKER SIDE QTY` — place a paper trade (Block 4)\n"
        "• `/boba_help` — this menu\n"
        "\n"
        "**Text commands:**\n"
        "• `!boba <question>` — ask Boba anything (Block 2)\n"
        "• `!arm` — switch /trade to LIVE mode for 15 min (Block 4)\n"
        "• `!disarm` — back to PAPER mode (Block 4)\n"
        "\n"
        "_Currently: scaffold deployed (Block 1). Handlers stubbed; full impl rolls out across Blocks 2-4._"
    )
    await interaction.response.send_message(msg, ephemeral=True)


# ─── !boba Q&A (placeholder) ─────────────────────────────────────────
@bot.command(name="boba")
async def boba_qa(ctx, *, question: str = None):
    if ctx.author.id != OWNER_ID:
        return
    if not question:
        await ctx.reply("ask me something: `!boba should I buy AMD?`")
        return

    logging.info(f"!boba: {question[:80]}")
    async with ctx.typing():
        loop = asyncio.get_event_loop()
        context_blob = await loop.run_in_executor(None, _build_context_blob)
        answer = await loop.run_in_executor(None, _ask_anthropic, question, context_blob)

    chunks = _chunk_message(answer)
    for i, chunk in enumerate(chunks):
        if i == 0:
            await ctx.reply(chunk)
        else:
            await ctx.send(chunk)


# ─── lifecycle ───────────────────────────────────────────────────────
@bot.event
async def on_ready():
    print(f"[boba-mega] logged in as {bot.user} (id={bot.user.id})", flush=True)
    print(f"[boba-mega] owner: {OWNER_ID}", flush=True)
    print(f"[boba-mega] guild: {GUILD_ID}", flush=True)
    print(f"[boba-mega] channels: {CHAN}", flush=True)


if __name__ == "__main__":
    bot.run(TOKEN)
