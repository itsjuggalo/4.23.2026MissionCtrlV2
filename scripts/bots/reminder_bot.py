"""
ReminderBot — Discord bot with persistent control panel buttons.
Initial action: DNS Renewed (resets the watchdog state + fires confirmation post).
Add more buttons here over time (restart Boba, pause trading, etc.).

Run as PM2 process. Token at ~/.openclaw/secrets/discord_ops_bot_token.
"""
import asyncio
import json
import os
import subprocess
import sys
from datetime import date, datetime, timezone
from pathlib import Path

import discord
from discord import app_commands
from discord.ext import commands

TOKEN_FILE = Path.home() / ".openclaw/secrets/discord_ops_bot_token"
STATE_DIR = Path.home() / ".openclaw/state/watchdogs"
DNS_STATE = STATE_DIR / "dns_last_renewed.txt"
RENEWAL_DAYS = 30

TOKEN = TOKEN_FILE.read_text().strip()
if not TOKEN:
    print("No bot token", file=sys.stderr)
    sys.exit(1)

intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix="!", intents=intents)


class OpsPanel(discord.ui.View):
    """Persistent control panel. timeout=None keeps buttons working forever."""
    def __init__(self):
        super().__init__(timeout=None)

    @discord.ui.button(
        label="DNS Renewed",
        emoji="🔄",
        style=discord.ButtonStyle.success,
        custom_id="mc_ops:dns_renewed",
    )
    async def dns_renewed(self, interaction: discord.Interaction, button: discord.ui.Button):
        today = date.today().isoformat()
        STATE_DIR.mkdir(parents=True, exist_ok=True)
        DNS_STATE.write_text(today)

        embed = discord.Embed(
            title="✓ DNS Renewal Reset",
            description=(
                f"**missionctrl.serveftp.com** marked renewed today.\n\n"
                f"**Next expiry**: {date.fromordinal(date.today().toordinal() + RENEWAL_DAYS).isoformat()}\n"
                f"**Reset by**: {interaction.user.mention}"
            ),
            color=0x00d2a0,
            timestamp=datetime.now(timezone.utc),
        )
        await interaction.response.send_message(embed=embed)

    @discord.ui.button(
        label="Check Status",
        emoji="📊",
        style=discord.ButtonStyle.secondary,
        custom_id="mc_ops:status",
    )
    async def check_status(self, interaction: discord.Interaction, button: discord.ui.Button):
        lines = []
        # DNS status
        if DNS_STATE.exists():
            last = date.fromisoformat(DNS_STATE.read_text().strip())
            days_since = (date.today() - last).days
            days_left = RENEWAL_DAYS - days_since
            status_emoji = "🟢" if days_left > 10 else "🟡" if days_left > 5 else "🔴"
            lines.append(f"{status_emoji} **DNS**: {days_left}d left (last renewed {last.isoformat()})")
        else:
            lines.append("⚫ **DNS**: no state file")

        # PM2 mission-control status
        try:
            out = subprocess.check_output(["pm2", "jlist"], timeout=5, stderr=subprocess.DEVNULL)
            procs = json.loads(out)
            mc = next((p for p in procs if p.get("name") == "mission-control"), None)
            if mc:
                s = mc.get("pm2_env", {}).get("status", "unknown")
                uptime_ms = datetime.now(timezone.utc).timestamp() * 1000 - mc.get("pm2_env", {}).get("pm_uptime", 0)
                uptime_min = int(uptime_ms / 60000)
                emoji = "🟢" if s == "online" else "🔴"
                lines.append(f"{emoji} **Dashboard**: {s} · up {uptime_min}m · restarts {mc.get('pm2_env',{}).get('restart_time','?')}")
            else:
                lines.append("🔴 **Dashboard**: not found in PM2")
        except Exception as e:
            lines.append(f"⚠ **PM2 check failed**: {e}")

        embed = discord.Embed(
            title="Mission Control Ops Status",
            description="\n".join(lines),
            color=0x00d2a0,
            timestamp=datetime.now(timezone.utc),
        )
        await interaction.response.send_message(embed=embed, ephemeral=True)


@bot.event
async def on_ready():
    # Register persistent view so buttons survive bot restarts
    bot.add_view(OpsPanel())
    try:
        synced = await bot.tree.sync()
        print(f"Logged in as {bot.user} · synced {len(synced)} command(s)")
    except Exception as e:
        print(f"Sync error: {e}")


@bot.tree.command(name="mc-panel", description="Spawn the Mission Control ops panel (one-time setup)")
async def mc_panel(interaction: discord.Interaction):
    embed = discord.Embed(
        title="🛠 Mission Control Ops Panel",
        description=(
            "**DNS Renewed** — Click after renewing missionctrl.serveftp.com at your serveftp control panel.\n"
            "**Check Status** — Instant health check (DNS countdown + dashboard uptime)."
        ),
        color=0x00d2a0,
    )
    await interaction.response.send_message(embed=embed, view=OpsPanel())


bot.run(TOKEN)
