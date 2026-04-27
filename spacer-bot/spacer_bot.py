#!/usr/bin/env python3
"""SpacerBot v2 — channel divider AND channel management.

OWNER-LOCKED to user 733531188752285716. All commands silently ignored from
anyone else.

═══ DIVIDER COMMANDS ═══
  !spacer <#channel> [style]      Post a divider line. Auto-picks style by category if omitted.
  !divider <#channel> "TITLE"     Post a centered title divider (uses double style).
  !spacers                        List all available divider styles with previews.

═══ CHANNEL MANAGEMENT ═══
  !addchannel <name> [category] [text|voice|forum]   Create a new channel.
  !deletechannel <#channel>                          Delete a channel (with confirm).
  !blockchannel <#channel> [reason]                  Lock channel: @everyone can't send.
  !unblockchannel <#channel>                         Unlock channel.
  !hidechannel <#channel>                            Hide from @everyone.
  !showchannel <#channel>                            Make visible to @everyone.
  !listchannels [category]                           Inventory of all channels.
  !info <#channel>                                   Channel ID, perms, topic, member count.
  !purge <#channel> <count>                          Bulk-delete N recent messages (max 100).
  !rename <#channel> <new_name>                      Rename a channel.
  !topic <#channel> "new topic"                      Set channel topic.
  !help                                              Show this help.

═══ STYLE LIBRARY ═══
  Per-category auto-styles:
    flow_*     → flame    🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
    *_picks    → chart    📊📊📊📊📊📊📊📊📊📊📊📊
    boba_*     → gem      💎💎💎💎💎💎💎💎💎💎💎💎
    *_brief*   → bell     🔔🔔🔔🔔🔔🔔🔔🔔🔔🔔🔔🔔
    trade_*    → arrows   ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶
    sentiment_* → wave    ∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿
    pattern_*  → arrows   ▶▶▶▶▶▶▶▶▶▶▶▶▒▒▒▒▒▒
    whale_*    → wave     ∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿∿
    daily_*    → bell     🔔🔔🔔🔔🔔🔔🔔🔔🔔🔔🔔🔔
    fallback   → solid    ━━━━━━━━━━━━━━━━━━━━
"""
import asyncio, json, os, time, logging
from pathlib import Path
from datetime import datetime
import discord
from discord.ext import commands

SECRETS = Path.home() / ".openclaw" / "secrets"
TOKEN = (SECRETS / "spacer_bot_token.txt").read_text().strip()
GUILD_ID = int((SECRETS / "discord_guild_id").read_text().strip())
OWNER_ID = 733531188752285716

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "spacer_bot.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)
console = logging.StreamHandler()
console.setLevel(logging.INFO)
logging.getLogger().addHandler(console)

# ─── Spacer style library ─────────────────────────────────────────
STYLES = {
    "solid":   "━" * 30,
    "dotted":  "┄" * 30,
    "double":  "═" * 30,
    "wave":    "∿" * 18,
    "dashes":  "— " * 15,
    "dots":    "• " * 15,
    "arrows":  "▶" * 18,
    "block":   "█" * 20,
    "flame":   "🔥" * 12,
    "gem":     "💎" * 12,
    "chart":   "📊" * 12,
    "bell":    "🔔" * 12,
    "siren":   "🚨" * 10,
    "rocket":  "🚀" * 12,
    "moneybag":"💰" * 12,
    "shield":  "🛡️" * 10,
    "lightning":"⚡" * 14,
    "star":    "⭐" * 12,
}

# Category prefix → default style
CATEGORY_DEFAULTS = [
    ("flow_",      "flame"),
    ("ts_picks",   "chart"),
    ("ss_picks",   "chart"),
    ("boba_",      "gem"),
    ("trade_paper","arrows"),
    ("trade_live", "siren"),
    ("morning_brief",   "bell"),
    ("midday_brief",    "bell"),
    ("eod_brief",       "bell"),
    ("afterhours_brief","bell"),
    ("sentiment_", "wave"),
    ("pattern_",   "lightning"),
    ("whale_",     "moneybag"),
    ("daily_",     "bell"),
    ("performance","star"),
    ("verify",     "shield"),
    ("signal_",    "chart"),
]

def pick_style_for_channel(channel_name: str) -> str:
    """Auto-pick a divider style based on channel name prefix."""
    n = channel_name.lower()
    for prefix, style in CATEGORY_DEFAULTS:
        if n.startswith(prefix) or prefix in n:
            return style
    return "solid"


def is_owner(ctx) -> bool:
    return ctx.author.id == OWNER_ID


# ─── Bot setup ────────────────────────────────────────────────────
intents = discord.Intents.default()
intents.message_content = True
intents.members = True
intents.guilds = True

bot = commands.Bot(command_prefix="!", intents=intents, help_command=None)


@bot.event
async def on_ready():
    logging.info(f"[spacer] logged in as {bot.user} (id={bot.user.id})")
    logging.info(f"[spacer] guild: {GUILD_ID}")
    logging.info(f"[spacer] owner: {OWNER_ID}")
    logging.info(f"[spacer] {len(STYLES)} divider styles loaded")
    # Permission check
    guild = bot.get_guild(GUILD_ID)
    if guild:
        me = guild.me
        perms = me.guild_permissions
        needed = {
            "manage_channels": perms.manage_channels,
            "manage_roles":    perms.manage_roles,
            "view_channel":    perms.view_channel,
            "manage_messages": perms.manage_messages,
            "send_messages":   perms.send_messages,
        }
        for k, v in needed.items():
            symbol = "✓" if v else "❌"
            logging.info(f"[spacer]   {symbol} {k}: {v}")
        if not all(needed.values()):
            logging.warning("[spacer] ⚠️ Some permissions missing — see Server Settings → Roles → SpacerBot")
        logging.info(f"[spacer] visible channels: {len(guild.channels)}")


# ─── Divider commands ─────────────────────────────────────────────
@bot.command(name="spacer")
async def cmd_spacer(ctx, channel: discord.TextChannel = None, style: str = None):
    if not is_owner(ctx):
        return
    if channel is None:
        await ctx.send("Usage: `!spacer <#channel> [style]` — see `!spacers` for styles")
        return
    if style is None:
        style = pick_style_for_channel(channel.name)
    style = style.lower()
    if style not in STYLES:
        await ctx.send(f"Unknown style `{style}`. Try `!spacers`.")
        return
    try:
        await channel.send(STYLES[style])
        await ctx.message.add_reaction("✓")
        logging.info(f"[spacer] posted '{style}' divider in #{channel.name}")
    except discord.Forbidden:
        await ctx.send(f"❌ No permission to post in {channel.mention}")


@bot.command(name="divider")
async def cmd_divider(ctx, channel: discord.TextChannel = None, *, title: str = None):
    if not is_owner(ctx):
        return
    if channel is None or title is None:
        await ctx.send('Usage: `!divider <#channel> "TITLE TEXT"`')
        return
    # Strip surrounding quotes if present
    title = title.strip().strip('"').strip("'").upper()
    bar = "═" * 8
    msg = f"{bar} **{title}** {bar}"
    try:
        await channel.send(msg)
        await ctx.message.add_reaction("✓")
        logging.info(f"[divider] '{title}' in #{channel.name}")
    except discord.Forbidden:
        await ctx.send(f"❌ No permission to post in {channel.mention}")


@bot.command(name="spacers")
async def cmd_spacers(ctx):
    if not is_owner(ctx):
        return
    lines = ["**Available divider styles:**"]
    for name, sample in STYLES.items():
        # Truncate to ~30 char preview
        preview = sample if len(sample) <= 35 else sample[:35]
        lines.append(f"`{name:>10}` → {preview}")
    lines.append("")
    lines.append("**Auto-style by channel name:**")
    for prefix, style in CATEGORY_DEFAULTS[:10]:
        lines.append(f"  `{prefix}*` → {style}")
    await ctx.send("\n".join(lines)[:1900])


# ─── Channel management ──────────────────────────────────────────
@bot.command(name="addchannel")
async def cmd_addchannel(ctx, name: str = None, category: str = None, kind: str = "text"):
    if not is_owner(ctx):
        return
    if not name:
        await ctx.send("Usage: `!addchannel <name> [category] [text|voice|forum]`")
        return
    guild = ctx.guild
    cat_obj = None
    if category:
        cat_obj = discord.utils.get(guild.categories, name=category)
        if not cat_obj:
            await ctx.send(f"Category `{category}` not found. Available: {', '.join(c.name for c in guild.categories) or '(none)'}")
            return
    try:
        if kind == "voice":
            ch = await guild.create_voice_channel(name, category=cat_obj)
        elif kind == "forum":
            ch = await guild.create_forum_channel(name, category=cat_obj)
        else:
            ch = await guild.create_text_channel(name, category=cat_obj)
        await ctx.send(f"✓ Created {ch.mention} (id `{ch.id}`)")
        logging.info(f"[addchannel] created {kind} #{name} in {category or 'no-category'}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Channels permission")
    except Exception as e:
        await ctx.send(f"❌ Failed: {e}")


@bot.command(name="deletechannel")
async def cmd_deletechannel(ctx, channel: discord.abc.GuildChannel = None):
    if not is_owner(ctx):
        return
    if channel is None:
        await ctx.send("Usage: `!deletechannel <#channel>` — react ✓ within 30s to confirm")
        return
    confirm_msg = await ctx.send(
        f"⚠️ About to delete **#{channel.name}** ({channel.id}). React ✓ within 30s to confirm."
    )
    await confirm_msg.add_reaction("✓")
    def check(reaction, user):
        return (user.id == OWNER_ID and str(reaction.emoji) == "✓"
                and reaction.message.id == confirm_msg.id)
    try:
        await bot.wait_for("reaction_add", timeout=30.0, check=check)
        name = channel.name
        await channel.delete(reason=f"Deleted by SpacerBot at {OWNER_ID}'s request")
        await ctx.send(f"✓ Deleted **#{name}**")
        logging.info(f"[deletechannel] deleted #{name}")
    except asyncio.TimeoutError:
        await ctx.send("Cancelled (no confirmation).")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Channels permission")


@bot.command(name="blockchannel", aliases=["lockchannel"])
async def cmd_blockchannel(ctx, channel: discord.TextChannel = None, *, reason: str = "blocked by SpacerBot"):
    if not is_owner(ctx):
        return
    if channel is None:
        await ctx.send("Usage: `!blockchannel <#channel> [reason]`")
        return
    try:
        overwrite = channel.overwrites_for(ctx.guild.default_role)
        overwrite.send_messages = False
        overwrite.add_reactions = False
        overwrite.create_public_threads = False
        await channel.set_permissions(ctx.guild.default_role, overwrite=overwrite, reason=reason)
        await ctx.send(f"🔒 Locked {channel.mention} — @everyone cannot send")
        logging.info(f"[block] locked #{channel.name}: {reason}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Roles permission")


@bot.command(name="unblockchannel", aliases=["unlockchannel"])
async def cmd_unblockchannel(ctx, channel: discord.TextChannel = None):
    if not is_owner(ctx):
        return
    if channel is None:
        await ctx.send("Usage: `!unblockchannel <#channel>`")
        return
    try:
        overwrite = channel.overwrites_for(ctx.guild.default_role)
        overwrite.send_messages = None
        overwrite.add_reactions = None
        overwrite.create_public_threads = None
        await channel.set_permissions(ctx.guild.default_role, overwrite=overwrite, reason="unblocked by SpacerBot")
        await ctx.send(f"🔓 Unlocked {channel.mention}")
        logging.info(f"[unblock] unlocked #{channel.name}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Roles permission")


@bot.command(name="hidechannel")
async def cmd_hidechannel(ctx, channel: discord.TextChannel = None):
    if not is_owner(ctx):
        return
    if channel is None:
        await ctx.send("Usage: `!hidechannel <#channel>`")
        return
    try:
        overwrite = channel.overwrites_for(ctx.guild.default_role)
        overwrite.view_channel = False
        await channel.set_permissions(ctx.guild.default_role, overwrite=overwrite, reason="hidden by SpacerBot")
        await ctx.send(f"👻 Hidden {channel.mention} from @everyone")
        logging.info(f"[hide] hid #{channel.name}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Roles permission")


@bot.command(name="showchannel")
async def cmd_showchannel(ctx, channel: discord.TextChannel = None):
    if not is_owner(ctx):
        return
    if channel is None:
        await ctx.send("Usage: `!showchannel <#channel>`")
        return
    try:
        overwrite = channel.overwrites_for(ctx.guild.default_role)
        overwrite.view_channel = None
        await channel.set_permissions(ctx.guild.default_role, overwrite=overwrite, reason="shown by SpacerBot")
        await ctx.send(f"👁️ Revealed {channel.mention} to @everyone")
        logging.info(f"[show] showed #{channel.name}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Roles permission")


@bot.command(name="listchannels")
async def cmd_listchannels(ctx, *, category: str = None):
    if not is_owner(ctx):
        return
    guild = ctx.guild
    lines = []
    if category:
        cat = discord.utils.get(guild.categories, name=category)
        if not cat:
            await ctx.send(f"Category `{category}` not found")
            return
        lines.append(f"**{cat.name}** ({len(cat.channels)} channels)")
        for ch in cat.channels:
            kind = "🔊" if isinstance(ch, discord.VoiceChannel) else "📝"
            lines.append(f"  {kind} {ch.name} `{ch.id}`")
    else:
        # All channels grouped by category
        for cat in sorted(guild.categories, key=lambda c: c.position):
            lines.append(f"\n**{cat.name}** ({len(cat.channels)})")
            for ch in cat.channels:
                kind = "🔊" if isinstance(ch, discord.VoiceChannel) else "📝"
                lines.append(f"  {kind} {ch.name} `{ch.id}`")
        # Uncategorized
        uncat = [c for c in guild.channels if c.category is None and not isinstance(c, discord.CategoryChannel)]
        if uncat:
            lines.append(f"\n**(uncategorized)** ({len(uncat)})")
            for ch in uncat:
                kind = "🔊" if isinstance(ch, discord.VoiceChannel) else "📝"
                lines.append(f"  {kind} {ch.name} `{ch.id}`")
    # Discord 2000-char limit per message
    output = "\n".join(lines)
    for i in range(0, len(output), 1900):
        await ctx.send(output[i:i+1900])


@bot.command(name="info")
async def cmd_info(ctx, channel: discord.abc.GuildChannel = None):
    if not is_owner(ctx):
        return
    if channel is None:
        channel = ctx.channel
    embed = discord.Embed(title=f"#{channel.name}", color=0x4FC3F7)
    embed.add_field(name="ID", value=f"`{channel.id}`", inline=True)
    embed.add_field(name="Type", value=channel.type.name, inline=True)
    if channel.category:
        embed.add_field(name="Category", value=channel.category.name, inline=True)
    if hasattr(channel, "topic") and channel.topic:
        embed.add_field(name="Topic", value=channel.topic[:200], inline=False)
    if hasattr(channel, "members"):
        embed.add_field(name="Members", value=str(len(channel.members)), inline=True)
    if hasattr(channel, "slowmode_delay") and channel.slowmode_delay:
        embed.add_field(name="Slowmode", value=f"{channel.slowmode_delay}s", inline=True)
    embed.add_field(name="Position", value=str(channel.position), inline=True)
    embed.add_field(name="Created", value=channel.created_at.strftime("%Y-%m-%d"), inline=True)
    await ctx.send(embed=embed)


@bot.command(name="purge")
async def cmd_purge(ctx, channel: discord.TextChannel = None, count: int = None):
    if not is_owner(ctx):
        return
    if channel is None or count is None:
        await ctx.send("Usage: `!purge <#channel> <count>` (max 100)")
        return
    count = max(1, min(count, 100))
    try:
        deleted = await channel.purge(limit=count)
        await ctx.send(f"🧹 Deleted {len(deleted)} messages from {channel.mention}")
        logging.info(f"[purge] deleted {len(deleted)} from #{channel.name}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Messages permission")


@bot.command(name="rename")
async def cmd_rename(ctx, channel: discord.abc.GuildChannel = None, *, new_name: str = None):
    if not is_owner(ctx):
        return
    if channel is None or not new_name:
        await ctx.send("Usage: `!rename <#channel> <new_name>`")
        return
    old = channel.name
    try:
        await channel.edit(name=new_name, reason="renamed by SpacerBot")
        await ctx.send(f"✓ Renamed **#{old}** → **#{new_name}**")
        logging.info(f"[rename] #{old} → #{new_name}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Channels permission")


@bot.command(name="topic")
async def cmd_topic(ctx, channel: discord.TextChannel = None, *, topic: str = None):
    if not is_owner(ctx):
        return
    if channel is None or topic is None:
        await ctx.send('Usage: `!topic <#channel> "new topic text"`')
        return
    topic = topic.strip().strip('"').strip("'")
    try:
        await channel.edit(topic=topic, reason="topic set by SpacerBot")
        await ctx.send(f"✓ Topic for {channel.mention} updated")
        logging.info(f"[topic] set #{channel.name}")
    except discord.Forbidden:
        await ctx.send("❌ Missing Manage Channels permission")


@bot.command(name="help")
async def cmd_help(ctx):
    if not is_owner(ctx):
        return
    text = """**SpacerBot v2 Commands** (owner-only)

**Dividers:**
`!spacer <#channel> [style]` — auto-picks style by channel name
`!divider <#channel> "TITLE"` — centered title bar
`!spacers` — list all 18 styles

**Channel ops:**
`!addchannel <name> [category] [text|voice|forum]`
`!deletechannel <#channel>` (requires ✓ confirm)
`!blockchannel <#channel> [reason]` / `!unblockchannel`
`!hidechannel <#channel>` / `!showchannel`
`!rename <#channel> <new_name>`
`!topic <#channel> "text"`
`!purge <#channel> <1-100>`
`!listchannels [category]`
`!info <#channel>`
`!help` — this message
"""
    await ctx.send(text)


@bot.event
async def on_command_error(ctx, error):
    if isinstance(error, commands.CommandNotFound):
        return  # silently ignore unknown commands
    if not is_owner(ctx):
        return
    logging.error(f"[cmd_error] {error}")
    try:
        await ctx.send(f"❌ Error: {str(error)[:300]}")
    except Exception:
        pass


if __name__ == "__main__":
    bot.run(TOKEN)
