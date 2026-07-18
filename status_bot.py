#!/usr/bin/env python3
"""Discord MC ops bot — focused commands for monitoring Mission Control."""
import subprocess
import json
import re
from pathlib import Path
from datetime import datetime
import discord

TOKEN = Path("/home/ubuntu/.openclaw/secrets/discord_status_bot_token").read_text().strip()
intents = discord.Intents.default()
intents.message_content = True
client = discord.Client(intents=intents)

CRITICAL_SERVICES = ["mission-control", "firebase-signal-relay", "signal-receiver",
                     "flow-monitor", "trail-daemon", "option-signals", "option-signals-relay",
                     "boba-mega", "telegram-listener", "tgbridge"]

DECISIONS_LOG = Path("/home/ubuntu/.openclaw/workspace/state/boba_decisions.json")


def run(cmd, timeout=10):
    try:
        r = subprocess.run(cmd, capture_output=True, text=True, timeout=timeout)
        return r.stdout
    except Exception as e:
        return f"Error: {e}"


def parse_occ_symbol(sym):
    """Parse OCC option symbol like META260515P00667500 → 'META 5/15/26 $667.50P'."""
    m = re.match(r"^([A-Z]+)(\d{2})(\d{2})(\d{2})([CP])(\d{8})$", sym)
    if not m:
        return sym  # not an option, return as-is (e.g. plain stock ticker)
    ticker, yy, mm, dd, cp, strike_raw = m.groups()
    strike = int(strike_raw) / 1000
    cp_label = "PUT" if cp == "P" else "CALL"
    return f"{ticker} {int(mm)}/{int(dd)}/{yy} ${strike:.2f} {cp_label}"


def get_pm2_status():
    raw = run(["pm2", "jlist"], timeout=5)
    try:
        data = json.loads(raw)
    except Exception:
        return []
    out = []
    for p in data:
        name = p.get("name", "?")
        if name not in CRITICAL_SERVICES:
            continue
        env = p.get("pm2_env", {})
        status = env.get("status", "?")
        restarts = env.get("restart_time", 0)
        mem_mb = p.get("monit", {}).get("memory", 0) / (1024 * 1024)
        out.append((name, status, restarts, mem_mb))
    return out


def get_last_cycle_full():
    """Pull the most recent decision from the structured decisions log (richer than text log)."""
    if not DECISIONS_LOG.exists():
        return None
    try:
        decisions = json.loads(DECISIONS_LOG.read_text())
        if not decisions:
            return None
        return decisions[-1]   # most recent
    except Exception:
        return None


def get_daily_budget():
    p = Path("/home/ubuntu/.openclaw/workspace/state/daily_picks_state.json")
    if not p.exists():
        return None
    try:
        return json.loads(p.read_text())
    except Exception:
        return None


def fmt_time():
    utc = datetime.utcnow().strftime("%H:%M UTC")
    et = subprocess.run(["bash", "-c", "TZ=America/New_York date '+%I:%M %p ET'"],
                        capture_output=True, text=True).stdout.strip()
    return f"{utc} | {et}"


def fmt_position_action(action):
    """Format a single position action dict into readable Discord line."""
    sym_raw = action.get("symbol", action.get("ticker", "?"))
    sym_pretty = parse_occ_symbol(sym_raw)
    act = action.get("action", "?").upper()
    pnl = action.get("pnl_pct")
    dte = action.get("dte")
    reason = action.get("reason", action.get("rationale", ""))[:200]
    
    # Build header
    header = f"**{sym_pretty}** [{act}]"
    parts = []
    if pnl is not None:
        sign = "+" if pnl >= 0 else ""
        parts.append(f"{sign}{pnl:.1f}%")
    if dte is not None:
        parts.append(f"{dte} DTE")
    if parts:
        header += f" — {' · '.join(parts)}"
    
    return f"{header}\n  └ {reason}"


@client.event
async def on_ready():
    print(f"[status_bot] Logged in as {client.user}", flush=True)
    print(f"[status_bot] Commands: !status !services !cycle !positions !budget !logs !help", flush=True)


@client.event
async def on_message(message):
    if message.author == client.user:
        return
    cmd = message.content.strip().lower()

    if cmd == "!status":
        services = get_pm2_status()
        cycle = get_last_cycle_full()
        budget = get_daily_budget()
        lines = [f"**Mission Control — {fmt_time()}**", ""]
        online = sum(1 for s in services if s[1] == "online")
        problem = [s for s in services if s[1] != "online"]
        if problem:
            lines.append(f"⚠️ Services: {online}/{len(services)} online")
            for n, st, r, m in problem:
                lines.append(f"   ✗ {n}: {st}")
        else:
            lines.append(f"✓ Services: {online}/{len(services)} online")
        if cycle:
            picks = cycle.get("picks_executed", [])
            passed = cycle.get("passed_on", [])
            lines.append(f"✓ Last cycle: {len(picks)} executed, {len(passed)} passed")
        if budget:
            picks = budget.get("new_picks_count", 0)
            lines.append(f"📊 Daily picks: {picks}/3 used")
        else:
            lines.append("📊 Daily picks: none today")
        await message.channel.send("\n".join(lines))

    elif cmd == "!services":
        services = get_pm2_status()
        lines = [f"**Critical Services — {fmt_time()}**", "```"]
        for n, st, r, m in services:
            icon = "✓" if st == "online" else "✗"
            lines.append(f"{icon} {n:<26} {st:<8} {r:>3}↺ {m:>5.0f}MB")
        lines.append("```")
        await message.channel.send("\n".join(lines))

    elif cmd == "!cycle":
        cycle = get_last_cycle_full()
        if not cycle:
            await message.channel.send("No cycle data yet (decisions log empty)")
            return
        
        cycle_time = cycle.get("cycle_time", "?")[:16].replace("T", " ")
        picks = cycle.get("picks_executed", [])
        passed = cycle.get("passed_on", [])
        actions = cycle.get("position_actions", [])
        
        lines = [f"**Last Boba Cycle — {cycle_time} UTC**", ""]
        
        # New picks (executed)
        if picks:
            lines.append(f"**🟢 New Picks Executed ({len(picks)}):**")
            for p in picks[:3]:
                sym = parse_occ_symbol(p.get("symbol", p.get("ticker", "?")))
                entry = p.get("entry_price")
                tp = p.get("take_profit")
                sl = p.get("stop_loss")
                premium = p.get("premium")
                line = f"• **{sym}**"
                if entry: line += f" @ ${entry:.2f}"
                if tp: line += f" → TP ${tp:.2f}"
                if sl: line += f" / SL ${sl:.2f}"
                if premium: line += f" [{premium}]"
                lines.append(line)
            lines.append("")
        
        # Position management decisions on EXISTING positions
        if actions:
            lines.append(f"**🟡 Position Actions ({len(actions)}):**")
            for a in actions[:5]:
                lines.append(fmt_position_action(a))
            lines.append("")
        
        # Passed-on tickers
        if passed:
            ticker_list = ", ".join(p.get("ticker", p.get("symbol", "?")) for p in passed[:8])
            lines.append(f"**⚪ Passed on:** {ticker_list}")
        
        text = "\n".join(lines)
        if len(text) > 1900:
            text = text[:1900] + "\n... (truncated)"
        await message.channel.send(text)

    elif cmd == "!positions":
        # Pull current open positions from latest cycle's position_actions
        cycle = get_last_cycle_full()
        if not cycle:
            await message.channel.send("No position data available")
            return
        actions = cycle.get("position_actions", [])
        if not actions:
            await message.channel.send("No open positions in last cycle")
            return
        lines = [f"**Current Positions — {fmt_time()}**", ""]
        for a in actions:
            lines.append(fmt_position_action(a))
        text = "\n".join(lines)
        await message.channel.send(text[:1900])

    elif cmd == "!budget":
        b = get_daily_budget()
        if not b:
            await message.channel.send("📊 No picks today yet")
            return
        picks = b.get("new_picks_count", 0)
        lines = [f"**Daily Budget — {b.get('date', '?')}**",
                 f"Used: {picks}/3", f"Remaining: {3 - picks}"]
        if b.get("picks_today"):
            lines.append("\n**Today's picks:**")
            for p in b["picks_today"][:5]:
                lines.append(f"• {p}")
        await message.channel.send("\n".join(lines))

    elif cmd == "!logs":
        out = run(["tail", "-25", "/tmp/boba_cycle.log"], timeout=5)
        await message.channel.send(f"**Last 25 log lines:**\n```\n{out[:1850]}\n```")

    elif cmd in ("!help", "!commands"):
        await message.channel.send(
            "**MC Ops Bot — Mission Control health & cycle monitoring**\n\n"
            "`!status` — quick health summary (services + last cycle + budget)\n"
            "`!services` — PM2 critical services detail\n"
            "`!cycle` — last Boba cycle: new picks + position actions + passed tickers\n"
            "`!positions` — current open positions with formatted symbols\n"
            "`!budget` — daily pick budget (3/day cap)\n"
            "`!logs` — last 25 lines of raw cycle log\n\n"
            "_For agent reasoning (Orion/Grok/DeepSeek), see #agent-debate channel._"
        )


client.run(TOKEN)
