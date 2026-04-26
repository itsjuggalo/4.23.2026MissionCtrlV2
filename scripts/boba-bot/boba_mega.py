#!/usr/bin/env python3
"""Boba mega-bot — slash commands + !boba Q&A.
Block 1: scaffold + slash registration. Stub handlers only.
Block 2 will fill in /scan + !boba Q&A logic.
Block 3 will add /backtest.
Block 4 will add /trade with arm/disarm safety.

Locked to OWNER_ID. Slash commands sync to GUILD_ID for instant availability.
"""
import asyncio, json, os, sys, time, logging
from datetime import datetime, timezone
from pathlib import Path
import discord
from discord import app_commands
from discord.ext import commands

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
    await interaction.response.send_message(
        f"🔍 /scan {ticker} — handler not yet implemented (Block 2 ships next)",
        ephemeral=True,
    )
    logging.info(f"/scan {ticker} by {interaction.user.id}")


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
    await ctx.reply(f"🍵 received: _{question}_\n\nQ&A handler ships in Block 2 (Anthropic claude-sonnet-4-6).")
    logging.info(f"!boba: {question[:80]}")


# ─── lifecycle ───────────────────────────────────────────────────────
@bot.event
async def on_ready():
    print(f"[boba-mega] logged in as {bot.user} (id={bot.user.id})", flush=True)
    print(f"[boba-mega] owner: {OWNER_ID}", flush=True)
    print(f"[boba-mega] guild: {GUILD_ID}", flush=True)
    print(f"[boba-mega] channels: {CHAN}", flush=True)


if __name__ == "__main__":
    bot.run(TOKEN)
