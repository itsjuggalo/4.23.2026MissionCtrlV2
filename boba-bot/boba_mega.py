#!/usr/bin/env python3
"""Boba mega-bot — slash commands + !boba Q&A.
Block 1: scaffold + slash registration. Stub handlers only.
Block 2 will fill in /scan + !boba Q&A logic.
Block 3 will add /backtest.
Block 4 will add /trade with arm/disarm safety.

Locked to OWNER_ID. Slash commands sync to GUILD_ID for instant availability.
"""
import asyncio
import sys as _sys_t; _sys_t.path.insert(0, '/home/ubuntu/scripts/lib')
from anthropic_tracker import log_call as _log_anthropic_call
import time as _time_t, json, os, sys, time, logging, re
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
ANTHROPIC_MODEL = "claude-haiku-4-5-20251001"


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



def _load_best_options_archive(min_age_min=0, max_age_min=240, max_show=10, min_premium=500_000):
    """Read today's whale flow archive. Returns formatted text + list for prompts.
    
    Args:
        min_age_min: only include contracts updated AT LEAST this many min ago (0 = all)
        max_age_min: drop contracts updated more than this many min ago (default 4h)
        max_show: cap on returned contracts
        min_premium: floor on totalFlowValue (default $500K = T2+)
    """
    from datetime import datetime as _dt, timezone as _tz, timedelta as _td
    et_now = _dt.now(_tz.utc) + _td(hours=-4)
    date_str = et_now.strftime("%Y-%m-%d")
    fp = Path.home() / ".openclaw" / "data" / "best-options" / f"{date_str}.json"
    if not fp.exists():
        return ("", [])
    try:
        snap = json.loads(fp.read_text())
    except Exception:
        return ("", [])
    contracts = snap.get("sorted_by_premium", []) or []
    now_ms = int(_dt.now(_tz.utc).timestamp() * 1000)
    rows = []
    for c in contracts:
        if c.get("premium", 0) < min_premium:
            continue
        last_ms = c.get("last_updated_ms") or c.get("first_seen_ms") or 0
        if not last_ms:
            continue
        age_min = (now_ms - last_ms) / 60000
        if age_min < min_age_min or age_min > max_age_min:
            continue
        rows.append({**c, "_age_min": age_min})
        if len(rows) >= max_show:
            break
    if not rows:
        return ("", [])
    last_run = snap.get("last_run_human", "?")
    tier_counts = snap.get("tier_counts", {})
    lines = [f"# Whale flow archive (snapshot {last_run}, age <= {max_age_min}min, premium >= ${min_premium:,})"]
    lines.append(f"# T1 today: {tier_counts.get('T1_HUGE',0)} | T2: {tier_counts.get('T2_UNUSUAL_HUGE',0)} | showing {len(rows)} fresh")
    for c in rows:
        bull = "BULL" if c.get("is_bullish") else "BEAR"
        age = c.get("_age_min", 0)
        age_str = f"{int(age)}m ago" if age < 60 else f"{age/60:.1f}h ago"
        lines.append(
            f"  ${c.get('premium',0):>11,}  {c.get('ticker','?'):5s} ${c.get('strike',0):>6.0f} {c.get('option_type','?'):4s} "
            f"{c.get('expiry','?'):10s} {bull} | V:{c.get('volume',0):>5} OI:{c.get('oi',0):>5} "
            f"SW:{c.get('sweeps',0):>3} BL:{c.get('blocks',0):>2} | {c.get('tier','?'):16s} | {age_str}"
        )
    return ("\n".join(lines) + "\n", rows)


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
        _t0 = _time_tracker.time()
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
        _dur_ms = int((_time_tracker.time() - _t0) * 1000)
        if r.status_code != 200:
            _log_anthropic_call("boba_mega", ANTHROPIC_MODEL, None, _dur_ms, success=False, error=f"HTTP {r.status_code}")
            logging.error(f"anthropic {r.status_code}: {r.text[:300]}")
            return f"[Boba] API error {r.status_code}"
        _data = r.json()
        _log_anthropic_call("boba_mega", ANTHROPIC_MODEL, _data, _dur_ms, success=True)
        return _data.get("content", [{}])[0].get("text", "").strip()
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

# ─── Alpaca trade execution ─────────────────────────────────────────
ALPACA_PAPER_BASE = "https://paper-api.alpaca.markets"
ALPACA_LIVE_BASE = "https://api.alpaca.markets"

# State file for !arm/!disarm
ARM_STATE_FILE = Path.home() / ".openclaw" / "workspace" / "boba_arm_state.json"
ARM_STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
ARM_DURATION_SECS = 15 * 60  # 15 minutes


def _alpaca_keys(live=False):
    """Returns (key, secret, base_url) tuple. None if live keys unavailable."""
    paper_key = (SECRETS / "alpaca-key-id").read_text().strip()
    paper_secret = (SECRETS / "alpaca-secret").read_text().strip()
    if not live:
        return paper_key, paper_secret, ALPACA_PAPER_BASE
    # Live keys
    live_key_path = SECRETS / "alpaca-live-key-id"
    live_secret_path = SECRETS / "alpaca-live-secret"
    if live_key_path.exists() and live_secret_path.exists():
        return live_key_path.read_text().strip(), live_secret_path.read_text().strip(), ALPACA_LIVE_BASE
    return None, None, None


def _alpaca_headers(key, secret):
    return {
        "APCA-API-KEY-ID": key,
        "APCA-API-SECRET-KEY": secret,
        "Content-Type": "application/json",
    }


def _is_armed():
    if not ARM_STATE_FILE.exists():
        return False
    try:
        s = json.loads(ARM_STATE_FILE.read_text())
        armed_until = s.get("armed_until", 0)
        return time.time() < armed_until
    except Exception:
        return False


def _arm(seconds=ARM_DURATION_SECS):
    state = {"armed_until": int(time.time()) + seconds, "armed_at": int(time.time())}
    ARM_STATE_FILE.write_text(json.dumps(state))


def _disarm():
    ARM_STATE_FILE.write_text(json.dumps({"armed_until": 0}))


def _arm_remaining_secs():
    if not ARM_STATE_FILE.exists():
        return 0
    try:
        s = json.loads(ARM_STATE_FILE.read_text())
        return max(0, int(s.get("armed_until", 0) - time.time()))
    except Exception:
        return 0


def _build_occ_symbol(ticker, expiry_mmdd, strike, side):
    """Build OCC option symbol from MM/DD expiry + strike + side (call/put).
    Assumes current year for now. e.g. NVDA + 5/15 + 200 + call → NVDA260515C00200000"""
    try:
        mm, dd = expiry_mmdd.split("/")
        year_short = datetime.now().strftime("%y")
        # Handle year rollover: if expiry month < current month, assume next year
        cur_month = int(datetime.now().strftime("%m"))
        if int(mm) < cur_month:
            year_short = str(int(year_short) + 1).zfill(2)
        side_char = "C" if side.lower() == "call" else "P"
        strike_str = f"{int(round(float(strike) * 1000)):08d}"
        return f"{ticker.upper()}{year_short}{int(mm):02d}{int(dd):02d}{side_char}{strike_str}"
    except Exception as e:
        logging.error(f"build_occ {ticker} {expiry_mmdd} {strike} {side}: {e}")
        return None


def _submit_alpaca_order(symbol, side, qty, take_profit_price, stop_loss_price,
                         asset_type="stock", live=False):
    """Submit OCO bracket order. Returns (success, response_dict_or_error)."""
    key, secret, base = _alpaca_keys(live=live)
    if key is None:
        return False, {"error": "Live Alpaca keys not configured"}

    payload = {
        "symbol": symbol,
        "qty": str(qty),
        "side": side.lower(),
        "type": "market",
        "time_in_force": "day",
        "order_class": "bracket",
        "take_profit": {"limit_price": str(round(take_profit_price, 2))},
        "stop_loss": {"stop_price": str(round(stop_loss_price, 2))},
    }
    try:
        r = requests.post(
            f"{base}/v2/orders",
            headers=_alpaca_headers(key, secret),
            json=payload,
            timeout=15,
        )
        if r.status_code in (200, 201):
            return True, r.json()
        return False, {"error": f"HTTP {r.status_code}", "body": r.text[:500]}
    except Exception as e:
        return False, {"error": str(e)}


def _last_price(symbol, asset_type="stock"):
    """Best-effort last price for stop/TP defaults."""
    if asset_type == "stock":
        q = _ticker_quote(symbol)
        return q["last"] if q and q["last"] > 0 else None
    return None



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
async def backtest(interaction: discord.Interaction, strategy: str, symbol: str, timeframe: str = "1H", months: int = 6):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return

    # Defer because subprocess can take 5-15s
    await interaction.response.defer(thinking=True)
    logging.info(f"/backtest {strategy} {symbol} {timeframe} {months}mo by {interaction.user.id}")

    # Validate strategy
    if strategy.lower() not in ("supertrend", "st"):
        await interaction.followup.send(
            f"⚠️ Strategy `{strategy}` not in registry. Available: `supertrend`",
            ephemeral=True,
        )
        return

    # Run subprocess (asyncio so we don't block the event loop)
    import subprocess
    runner = "/home/ubuntu/scripts/backtest-runner/run.py"
    cmd = ["python3", runner, symbol.upper(), timeframe, str(months), "supertrend"]

    try:
        proc = await asyncio.create_subprocess_exec(
            *cmd,
            stdout=asyncio.subprocess.PIPE,
            stderr=asyncio.subprocess.PIPE,
        )
        stdout_b, stderr_b = await asyncio.wait_for(proc.communicate(), timeout=60)
        stdout = stdout_b.decode("utf-8", errors="replace")
        stderr = stderr_b.decode("utf-8", errors="replace")
    except asyncio.TimeoutError:
        await interaction.followup.send("⏱️ Backtest timed out after 60s.", ephemeral=True)
        return
    except Exception as e:
        await interaction.followup.send(f"❌ Subprocess error: `{e}`", ephemeral=True)
        return

    # Parse JSON output
    try:
        result = json.loads(stdout.strip())
    except Exception as e:
        # First 1500 chars of stdout for debug
        msg = f"❌ Backtest output not valid JSON: `{e}`\n```\n{stdout[:1500]}\n```"
        await interaction.followup.send(msg, ephemeral=True)
        return

    # Error case
    if "error" in result:
        await interaction.followup.send(
            f"❌ Backtest error: `{result['error']}`",
            ephemeral=True,
        )
        return

    # Build embed
    gate_pass = result.get("gate_pass", False)
    color = 0x00FF00 if gate_pass else 0xFF4444
    gate_emoji = "✅" if gate_pass else "❌"
    bh_str = f"{result['buy_hold_pct']:+.2f}%"
    ret_str = f"{result['strategy_return_pct']:+.2f}%"

    embed = discord.Embed(
        title=f"📊 Backtest — {result['symbol']} {result['timeframe']} ({result['months']}mo)",
        description=f"Strategy: `{result['strategy']}` · {result['candles_used']} candles\nFirst→Last: ${result['first_close']:,.2f} → ${result['last_close']:,.2f}",
        color=color,
        timestamp=datetime.now(timezone.utc),
    )
    embed.add_field(name="Strategy Return", value=f"**{ret_str}**", inline=True)
    embed.add_field(name="Buy & Hold", value=bh_str, inline=True)
    embed.add_field(name="Beats B&H", value="✅ Yes" if result["beats_buy_hold"] else "❌ No", inline=True)
    embed.add_field(name="Win Rate", value=f"{result['win_rate_pct']:.1f}%", inline=True)
    embed.add_field(name="Max DD", value=f"{result['max_drawdown_pct']:.2f}%", inline=True)
    embed.add_field(name="Trades", value=str(result["total_trades"]), inline=True)
    embed.add_field(name="Profit Factor", value=f"{result['profit_factor']:.3f}", inline=True)
    embed.add_field(name="Gate (DD<25 · WR>40 · Beats BH)",
                    value=f"{gate_emoji} {'PASS' if gate_pass else 'FAIL'}", inline=True)
    embed.set_footer(text="Mission Control · /backtest")

    # Send to #backtest channel + ephemeral confirmation
    bt_channel = bot.get_channel(CHAN["backtest"])
    if bt_channel:
        await bt_channel.send(embed=embed)
        await interaction.followup.send(f"📊 Posted to <#{CHAN['backtest']}>", ephemeral=True)
    else:
        await interaction.followup.send(embed=embed)


# ─── /trade ──────────────────────────────────────────────────────────
@bot.tree.command(name="trade", description="Place a trade (paper auto, live needs !arm + 👍)")
@app_commands.describe(
    ticker="Stock ticker (e.g. NVDA)",
    side="buy or sell",
    qty="Quantity (shares or contracts)",
    asset_type="stock, call, or put",
    take_profit="TP price (optional - defaults to +4%)",
    stop_loss="SL price (optional - defaults to -2%)",
    strike="Strike price (options only)",
    expiry="Expiry MM/DD (options only, e.g. 5/15)",
)
async def trade(
    interaction: discord.Interaction,
    ticker: str,
    side: str,
    qty: int,
    asset_type: str = "stock",
    take_profit: float = None,
    stop_loss: float = None,
    strike: float = None,
    expiry: str = None,
):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return

    ticker = ticker.upper().strip()
    side = side.lower().strip()
    asset_type = asset_type.lower().strip()

    if side not in ("buy", "sell"):
        await interaction.response.send_message("❌ side must be `buy` or `sell`", ephemeral=True)
        return
    if asset_type not in ("stock", "call", "put"):
        await interaction.response.send_message("❌ asset_type must be `stock`, `call`, or `put`", ephemeral=True)
        return
    if asset_type in ("call", "put") and (strike is None or expiry is None):
        await interaction.response.send_message("❌ options require both `strike` and `expiry`", ephemeral=True)
        return

    # Determine mode (paper/live)
    armed = _is_armed()
    mode = "LIVE" if armed else "PAPER"

    # Build symbol
    if asset_type == "stock":
        symbol = ticker
    else:
        symbol = _build_occ_symbol(ticker, expiry, strike, asset_type)
        if not symbol:
            await interaction.response.send_message(f"❌ could not build OCC symbol from {ticker} {expiry} {strike} {asset_type}", ephemeral=True)
            return

    # Get last price for defaults
    if asset_type == "stock":
        ref_price_data = await asyncio.get_event_loop().run_in_executor(None, _ticker_quote, ticker)
        ref_price = ref_price_data["last"] if ref_price_data and ref_price_data["last"] > 0 else None
    else:
        # For options, use Tradier client to get last price
        ref_price = None
        if tc:
            try:
                opt = await asyncio.get_event_loop().run_in_executor(None, tc.fetch_option_quote, symbol)
                if opt:
                    ref_price = (opt["bid"] + opt["ask"]) / 2 if (opt["bid"] > 0 and opt["ask"] > 0) else opt["last"]
            except Exception as e:
                logging.error(f"option quote {symbol}: {e}")

    if ref_price is None or ref_price <= 0:
        await interaction.response.send_message(
            f"❌ Could not fetch reference price for {symbol}. Provide explicit `take_profit` and `stop_loss`.",
            ephemeral=True,
        )
        return

    # Compute TP/SL defaults if not provided
    if side == "buy":
        tp = take_profit if take_profit else round(ref_price * 1.04, 2)
        sl = stop_loss if stop_loss else round(ref_price * 0.98, 2)
    else:  # sell/short
        tp = take_profit if take_profit else round(ref_price * 0.96, 2)
        sl = stop_loss if stop_loss else round(ref_price * 1.02, 2)

    # Build summary embed
    color = 0xe74c3c if mode == "LIVE" else 0x3498db
    embed = discord.Embed(
        title=f"💼 {mode} Trade: {side.upper()} {qty} {symbol}",
        color=color,
        timestamp=datetime.now(timezone.utc),
    )
    embed.add_field(name="Ref Price", value=f"${ref_price:.2f}", inline=True)
    embed.add_field(name="Take Profit", value=f"${tp:.2f}", inline=True)
    embed.add_field(name="Stop Loss", value=f"${sl:.2f}", inline=True)
    embed.add_field(name="Mode", value=mode, inline=True)
    embed.add_field(name="Asset", value=asset_type.upper(), inline=True)
    embed.add_field(name="Time in Force", value="DAY", inline=True)

    # PAPER: auto-execute
    if mode == "PAPER":
        await interaction.response.defer(thinking=True)
        success, result = await asyncio.get_event_loop().run_in_executor(
            None, _submit_alpaca_order, symbol, side, qty, tp, sl, asset_type, False,
        )
        if success:
            embed.add_field(name="Order ID", value=result.get("id", "?")[:18], inline=False)
            embed.add_field(name="Status", value=f"✅ Submitted: {result.get('status', 'pending')}", inline=False)
            logging.info(f"PAPER /trade {side} {qty} {symbol} → {result.get('id')}")
        else:
            embed.color = 0xe74c3c
            embed.add_field(name="❌ Error", value=str(result.get("error", "unknown"))[:1024], inline=False)
            if "body" in result:
                embed.add_field(name="Details", value=str(result["body"])[:1024], inline=False)
            logging.error(f"PAPER /trade FAILED: {result}")

        # Send to #trade-paper channel
        paper_chan = bot.get_channel(CHAN["trade_paper"])
        if paper_chan:
            await paper_chan.send(embed=embed)
        await interaction.followup.send("✅ Paper trade submitted (see #trade-paper)", ephemeral=True)
        return

    # LIVE: require 👍 confirmation reaction within 60s
    embed.add_field(name="⚠️ CONFIRMATION REQUIRED", value="React 👍 within 60s to execute", inline=False)
    await interaction.response.send_message(embed=embed)
    msg = await interaction.original_response()
    await msg.add_reaction("👍")

    def check(reaction, user):
        return (user.id == OWNER_ID
                and str(reaction.emoji) == "👍"
                and reaction.message.id == msg.id)

    try:
        await bot.wait_for("reaction_add", timeout=60.0, check=check)
    except asyncio.TimeoutError:
        await msg.edit(embed=discord.Embed(
            title="⏱ LIVE trade CANCELLED (no confirmation)",
            color=0x95a5a6,
        ))
        return

    # Confirmed - execute live
    success, result = await asyncio.get_event_loop().run_in_executor(
        None, _submit_alpaca_order, symbol, side, qty, tp, sl, asset_type, True,
    )
    confirm_embed = discord.Embed(
        title=f"💼 LIVE Trade: {side.upper()} {qty} {symbol}",
        color=0x27ae60 if success else 0xe74c3c,
        timestamp=datetime.now(timezone.utc),
    )
    if success:
        confirm_embed.add_field(name="Order ID", value=result.get("id", "?")[:18], inline=False)
        confirm_embed.add_field(name="Status", value=f"✅ Submitted: {result.get('status', 'pending')}", inline=False)
        logging.info(f"LIVE /trade {side} {qty} {symbol} → {result.get('id')}")
    else:
        confirm_embed.add_field(name="❌ Error", value=str(result.get("error", "unknown"))[:1024], inline=False)
        if "body" in result:
            confirm_embed.add_field(name="Details", value=str(result["body"])[:1024], inline=False)
        logging.error(f"LIVE /trade FAILED: {result}")

    live_chan = bot.get_channel(CHAN["trade_live"])
    if live_chan:
        await live_chan.send(embed=confirm_embed)
    await msg.edit(embed=confirm_embed)


# ─── /boba_help ──────────────────────────────────────────────────────

@bot.tree.command(name="flowtop", description="Best whale flow signal of the day (Boba's read on T1/T2 unusual flow)")
@app_commands.describe(
    max_age_hours="Only include contracts updated within last N hours (default 4)",
    min_premium_k="Minimum premium in $K to consider (default 500 = $500K, use 1000 for T1 only)",
    show_count="How many contracts to feed Boba (default 10, max 20)",
)
async def flowtop_cmd(interaction: discord.Interaction, max_age_hours: int = 4, min_premium_k: int = 500, show_count: int = 10):
    if interaction.user.id != OWNER_ID:
        await interaction.response.send_message("Owner only", ephemeral=True)
        return
    await interaction.response.defer()
    
    show_count = max(1, min(show_count, 20))
    text, rows = _load_best_options_archive(
        min_age_min=0,
        max_age_min=max_age_hours * 60,
        max_show=show_count,
        min_premium=min_premium_k * 1000,
    )
    if not rows:
        await interaction.followup.send(
            f"No fresh whale flow in last {max_age_hours}h with premium >= ${min_premium_k}K. "
            f"Either market's quiet or logger hasn't seen anything new — check `/api/best-options-history` directly."
        )
        return
    
    # Ask Boba to pick the best signal
    question = (
        f"Below is today's whale flow archive — only contracts updated in the last {max_age_hours}h "
        f"with premium at least ${min_premium_k}K. Apply our priority rules:\n"
        f"- T1 Huge ($1M+ premium, SWEEP, Vol>OI) RANKS FIRST\n"
        f"- T2 Unusual Huge ($500K+, SWEEP, Vol>OI) RANKS SECOND\n"
        f"- Within tier, freshness (recently updated) and conviction (sweeps/blocks count) decide\n\n"
        f"Pick the SINGLE strongest signal and tell me:\n"
        f"1. The contract (ticker / strike / type / expiry)\n"
        f"2. Why it's the strongest (tier, premium, sweeps, freshness)\n"
        f"3. Bull or bear thesis based on Bid/Ask sentiment\n"
        f"4. ONE concrete trade idea (entry / stop / target) IF you'd trade it, or 'pass' with reason\n"
        f"Be terse — under 200 words total."
    )
    loop = asyncio.get_running_loop()
    answer = await loop.run_in_executor(None, _ask_anthropic, question, text)
    
    # Send Boba's pick
    header = f"**Whale flow pick** (top {len(rows)} fresh, last {max_age_hours}h, >${min_premium_k}K):\n"
    msg = header + answer
    # Discord 2000 char limit
    if len(msg) > 1900:
        msg = msg[:1880] + "\n...(truncated)"
    await interaction.followup.send(msg)


@bot.tree.command(name="boba_help", description="Show Boba's available commands")
async def boba_help(interaction: discord.Interaction):
    if not is_owner(interaction):
        await interaction.response.send_message("⛔ unauthorized", ephemeral=True)
        return
    armed = _is_armed()
    rem = _arm_remaining_secs()
    arm_line = f"🔫 **LIVE armed** ({rem//60}m {rem%60}s left)" if armed else "🔒 PAPER mode (R2 sandbox)"
    msg = (
        f"🤖 **Boba's Command Reference**  •  {arm_line}\n"
        "\n"
        "**Slash commands:**\n"
        "• `/scan TICKER` — full context (price, flow, win rate, news)\n"
        "• `/trade ticker side qty asset_type [tp] [sl] [strike] [expiry]` — submit order\n"
        "    paper auto-executes • live needs 🔫!arm + 👍 confirmation\n"
        "• `/backtest <strategy> <symbol> <timeframe> [months]` — Run SuperTrend backtest, posts to #backtest\n"
        "• `/boba_help` — this menu\n"
        "\n"
        "**Text commands:**\n"
        "• `!boba <question>` — Q&A via Anthropic claude-haiku-4-5-20251001\n"
        "• `!arm` — switch /trade to LIVE mode for 15 min\n"
        "• `!disarm` — back to PAPER\n"
        "• `!armstatus` — check current mode\n"
        "\n"
        "**Examples:**\n"
        "• `/trade ticker:NVDA side:buy qty:10 asset_type:stock`\n"
        "• `/trade ticker:NVDA side:buy qty:5 asset_type:call strike:200 expiry:5/15`\n"
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
        # Auto-inject whale flow archive if question mentions flow/whale/unusual
        flow_kw = re.search(r"\b(flow|whale|unusual|sweep|premium|biggest|best.*signal|t1|t2)\b", question, re.IGNORECASE)
        if flow_kw:
            flow_text, flow_rows = _load_best_options_archive(max_age_min=240, max_show=10, min_premium=500_000)
            if flow_rows:
                context_blob = (context_blob or "") + "\n\n" + flow_text
        answer = await loop.run_in_executor(None, _ask_anthropic, question, context_blob)

    chunks = _chunk_message(answer)
    for i, chunk in enumerate(chunks):
        if i == 0:
            await ctx.reply(chunk)
        else:
            await ctx.send(chunk)

@bot.command(name="arm")
async def arm_cmd(ctx):
    if ctx.author.id != OWNER_ID:
        return
    # Check live keys exist
    key, secret, base = _alpaca_keys(live=True)
    if key is None:
        await ctx.reply("⚠️ Cannot arm — no LIVE Alpaca keys on server.\n"
                        "Add `~/.openclaw/secrets/alpaca-live-key-id` and "
                        "`~/.openclaw/secrets/alpaca-live-secret` to enable.")
        return
    _arm()
    remaining_min = ARM_DURATION_SECS // 60
    await ctx.reply(f"🔫 **LIVE MODE ARMED** for {remaining_min} min.\n"
                    f"`/trade` will route to LIVE Alpaca account. "
                    f"All live trades require 👍 confirmation. Auto-disarm at "
                    f"<t:{int(time.time()) + ARM_DURATION_SECS}:t>.")
    logging.info(f"!arm by {ctx.author.id}")


@bot.command(name="disarm")
async def disarm_cmd(ctx):
    if ctx.author.id != OWNER_ID:
        return
    if not _is_armed():
        await ctx.reply("ℹ️ Not currently armed (already in PAPER mode).")
        return
    _disarm()
    await ctx.reply("🔒 **DISARMED** — back to PAPER mode (R2 sandbox).")
    logging.info(f"!disarm by {ctx.author.id}")


@bot.command(name="armstatus")
async def armstatus_cmd(ctx):
    if ctx.author.id != OWNER_ID:
        return
    if _is_armed():
        rem = _arm_remaining_secs()
        await ctx.reply(f"🔫 ARMED — LIVE mode active. Auto-disarm in {rem//60}m {rem%60}s.")
    else:
        await ctx.reply("🔒 PAPER mode (R2 sandbox).")



# ─── lifecycle ───────────────────────────────────────────────────────
@bot.event
async def on_ready():
    print(f"[boba-mega] logged in as {bot.user} (id={bot.user.id})", flush=True)
    print(f"[boba-mega] owner: {OWNER_ID}", flush=True)
    print(f"[boba-mega] guild: {GUILD_ID}", flush=True)
    print(f"[boba-mega] channels: {CHAN}", flush=True)


if __name__ == "__main__":
    bot.run(TOKEN)
