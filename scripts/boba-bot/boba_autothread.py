#!/usr/bin/env python3
"""Boba auto-thread bot.
Watches flow_huge, flow_unusual, ts_picks, ss_picks for >=$1M premium signals.
Creates a thread on the message and posts ticker context inside.
"""
import asyncio, json, os, re, time, logging
from datetime import datetime, timezone
from pathlib import Path
from collections import defaultdict
import discord, requests

SECRETS = Path.home() / ".openclaw" / "secrets"
TOKEN = (SECRETS / "discord_boba_token").read_text().strip()
WATCH_CHANNELS = {
    int((SECRETS / f"discord_{name}_channel").read_text().strip()): name
    for name in ("flow_huge", "flow_unusual", "ts_picks", "ss_picks")
}
RELAY_DATA = Path.home() / "mission-control-restored" / "Option-Signals-Scraper" / "data"
PREMIUM_THRESHOLD = 1_000_000

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "boba_autothread.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)
console = logging.StreamHandler()
console.setLevel(logging.INFO)
logging.getLogger().addHandler(console)


def fmt_prem(v):
    if v >= 1_000_000: return f"${v/1_000_000:.2f}M"
    if v >= 1_000: return f"${v/1_000:.0f}K"
    return f"${v:.0f}"


def parse_premium(text):
    """Find largest $X.XM or $XK or $X,XXX,XXX value in text. Returns float or None."""
    if not text:
        return None
    # $1.5M or $1.5m
    m_pattern = re.findall(r"\$(\d+(?:\.\d+)?)\s*[Mm]\b", text)
    # $500K or $500k
    k_pattern = re.findall(r"\$(\d+(?:\.\d+)?)\s*[Kk]\b", text)
    # $1,234,567 or $1234567
    raw_pattern = re.findall(r"\$([\d,]+(?:\.\d+)?)(?!\s*[KkMm])", text)
    candidates = []
    for v in m_pattern:
        try: candidates.append(float(v) * 1_000_000)
        except: pass
    for v in k_pattern:
        try: candidates.append(float(v) * 1_000)
        except: pass
    for v in raw_pattern:
        try:
            n = float(v.replace(",", ""))
            if n > 100:  # filter noise like "$1" share prices
                candidates.append(n)
        except: pass
    return max(candidates) if candidates else None


def parse_ticker(text):
    """Find the most likely ticker symbol in the text."""
    if not text:
        return None
    # Look for $TICKER first
    m = re.search(r"\$([A-Z]{1,6})\b", text)
    if m:
        return m.group(1)
    # Standalone uppercase 1-5 letter words (not common english words)
    EXCLUDE = {"BUY", "SELL", "CALL", "PUT", "ETF", "IPO", "CEO", "USD", "OTM", "ITM",
               "ATM", "FOMC", "CPI", "AI", "API", "NEW", "ALL", "PER", "ICE", "AT"}
    candidates = re.findall(r"\b([A-Z]{1,5})\b", text)
    for c in candidates:
        if c not in EXCLUDE and len(c) >= 2:
            return c
    return None


def extract_signal_text(message):
    """Combine all text content + embed fields into one string."""
    parts = [message.content or ""]
    for emb in (message.embeds or []):
        if emb.title: parts.append(emb.title)
        if emb.description: parts.append(emb.description)
        for f in (emb.fields or []):
            parts.append(f.name or "")
            parts.append(f.value or "")
        if emb.footer and emb.footer.text:
            parts.append(emb.footer.text)
    return "\n".join(parts)


# ─── ticker context helpers ─────────────────────────────────────────────

def read_data(name):
    p = RELAY_DATA / f"{name}.json"
    if not p.exists(): return None
    try: return json.loads(p.read_text())
    except: return None


def ticker_flow_24h(symbol):
    """Today's flow stats for this ticker from FG1 LiveFlows."""
    d = read_data("flow_liveflows_today") or {}
    if not isinstance(d, dict):
        return None
    bull, bear, total, n = 0.0, 0.0, 0.0, 0
    sweep_count = 0
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
        if entry.get("BlockType") == "SWEEP": sweep_count += 1
    if n == 0:
        return None
    bull_pct = (bull / total * 100) if total > 0 else 50
    return {"n": n, "total": total, "bull": bull, "bear": bear, "bull_pct": bull_pct, "sweeps": sweep_count}


def ticker_win_rate(symbol):
    """Recent closed-trade record for this ticker across all source files."""
    files = ["closed_options", "closed_stocks", "ts_closed_options", "ts_closed_stocks",
             "ss_closed_options", "ss_closed_stocks"]
    wins = 0; losses = 0
    for fname in files:
        d = read_data(fname) or {}
        entries = list(d.values()) if isinstance(d, dict) else (d if isinstance(d, list) else [])
        for e in entries:
            if not isinstance(e, dict): continue
            if e.get("symbol") != symbol: continue
            status = (e.get("status") or "").lower()
            if any(p in status for p in ("profit", "locked", "booked")): wins += 1
            elif any(p in status for p in ("stop", "loss")): losses += 1
    n = wins + losses
    if n == 0:
        return None
    return {"n": n, "wins": wins, "losses": losses, "win_rate": wins / n * 100}


def ticker_quote(symbol):
    """Best-effort current quote via Finnhub."""
    try:
        key_path = SECRETS / "finnhub_api_key"
        if key_path.exists():
            key = key_path.read_text().strip()
        else:
            return None
        r = requests.get(f"https://finnhub.io/api/v1/quote",
                        params={"symbol": symbol, "token": key}, timeout=5)
        if r.status_code != 200: return None
        d = r.json()
        c = d.get("c", 0)
        pc = d.get("pc", 0)
        if c <= 0 or pc <= 0: return None
        chg_pct = ((c - pc) / pc) * 100
        return {"price": c, "change_pct": chg_pct}
    except Exception:
        return None


def build_thread_post(symbol, premium, source_label):
    """Build the context message that goes inside the new thread."""
    lines = [f"## 🔥 {symbol} • {fmt_prem(premium)} flow detected"]
    lines.append(f"_Source: `{source_label}` • {datetime.now().strftime('%-I:%M %p ET')}_")

    # Today's flow
    flow = ticker_flow_24h(symbol)
    if flow:
        lines.append("")
        lines.append("**Today's Options Flow**")
        lines.append(f"`Total premium: {fmt_prem(flow['total'])} across {flow['n']} fills`")
        lines.append(f"`Bull/Bear:     {flow['bull_pct']:.0f}% bull ({fmt_prem(flow['bull'])} / {fmt_prem(flow['bear'])})`")
        lines.append(f"`Sweeps:        {flow['sweeps']}`")
    else:
        lines.append("")
        lines.append("_No FG1 flow data for this ticker today_")

    # Win rate
    wr = ticker_win_rate(symbol)
    if wr:
        lines.append("")
        lines.append("**Historical Win Rate (closed trades)**")
        lines.append(f"`{wr['wins']} wins / {wr['losses']} losses ({wr['win_rate']:.0f}% wr) over {wr['n']} closed trades`")
    else:
        lines.append("")
        lines.append("_No closed trade history for this ticker_")

    # Live quote
    q = ticker_quote(symbol)
    if q:
        sign = "+" if q["change_pct"] >= 0 else ""
        emoji = "🟢" if q["change_pct"] >= 0 else "🔴"
        lines.append("")
        lines.append(f"{emoji} **Last:** ${q['price']:.2f}  ({sign}{q['change_pct']:.2f}% today)")

    return "\n".join(lines)[:2000]


# ─── discord client ────────────────────────────────────────────────────

intents = discord.Intents.default()
intents.message_content = True
intents.messages = True
intents.guilds = True
client = discord.Client(intents=intents)

# Cooldown: don't re-thread the same ticker within 10 min
recent_threads = {}  # ticker -> ts


@client.event
async def on_ready():
    print(f"[boba] logged in as {client.user} (id={client.user.id})", flush=True)
    print(f"[boba] watching {len(WATCH_CHANNELS)} channels for premium >= {fmt_prem(PREMIUM_THRESHOLD)}", flush=True)
    for cid, name in WATCH_CHANNELS.items():
        print(f"[boba]   - {name}: {cid}", flush=True)


@client.event
async def on_message(message):
    if message.author.id == client.user.id:
        return
    if message.channel.id not in WATCH_CHANNELS:
        return

    source = WATCH_CHANNELS[message.channel.id]
    text = extract_signal_text(message)
    premium = parse_premium(text)
    ticker = parse_ticker(text)

    if not premium or premium < PREMIUM_THRESHOLD:
        return
    if not ticker:
        logging.info(f"[{source}] big premium {fmt_prem(premium)} but no ticker parsed")
        return

    # Cooldown
    last = recent_threads.get(ticker, 0)
    if time.time() - last < 600:  # 10 min
        logging.info(f"[{source}] {ticker} {fmt_prem(premium)} skipped (cooldown)")
        return

    logging.info(f"[{source}] BIG: {ticker} {fmt_prem(premium)} → creating thread")
    try:
        thread_name = f"🔥 {ticker} • {fmt_prem(premium)} • {source}"[:100]
        thread = await message.create_thread(name=thread_name, auto_archive_duration=1440)
        post = build_thread_post(ticker, premium, source)
        await thread.send(post)
        recent_threads[ticker] = time.time()
        logging.info(f"[{source}] thread created: {thread.id}")
    except discord.Forbidden:
        logging.error(f"[{source}] no perms to create thread in {message.channel.name}")
    except discord.HTTPException as e:
        logging.error(f"[{source}] thread create failed: {e}")
    except Exception as e:
        logging.error(f"[{source}] unexpected error: {e}")


if __name__ == "__main__":
    client.run(TOKEN)
