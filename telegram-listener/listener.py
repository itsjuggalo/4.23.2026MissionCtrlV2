#!/usr/bin/env python3
"""
Mission Control - Telegram Signal Listener
Monitors 7 channels and parses trading signals into signals.json

v2: adds signal quality scoring, duplicate detection, Discord webhooks,
    and per-channel stats tracking.
"""
import asyncio
import json
import os
import re
import sys
import uuid
from datetime import datetime, timezone, timedelta

import aiohttp
import websockets

import sys as _sys
_sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), ".."))

from dotenv import load_dotenv
from shared.archiver import maybe_rotate
from telethon import TelegramClient, events

# Load .env from the same directory as this file
load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

API_ID = 31236866
API_HASH = "ee3934cfcd4a6c5ab575dd0f59016330"

_DIR = os.path.dirname(os.path.abspath(__file__))
SESSION_FILE      = os.path.join(_DIR, "mc_feed")
SIGNALS_FILE      = os.path.join(_DIR, "signals.json")
ARCHIVE_SIGNALS_URL = os.getenv("DISCORD_ARCHIVE_ERIC_WEBHOOK", "")
SIGNALS_MAX       = 500
CHANNEL_STATS_FILE = os.path.join(_DIR, "channel_stats.json")

DISCORD_SIGNALS_URL  = os.getenv("DISCORD_ERIC_SIGNALS_WEBHOOK", "")
DISCORD_REJECTED_URL = os.getenv("DISCORD_ERIC_REJECTED_WEBHOOK", "")

# ── Additional sources ───────────────────────────────────────────────────────
FIREBASE_URL         = "https://stock-signal-72772-default-rtdb.firebaseio.com/Vivid2.json"
FIREBASE_POLL_SEC    = 60
FIREBASE_LIVE_KEYS   = ("ShortTermOptions", "LongTermOptions", "ShortTermStocks", "LongTermStocks")
FIREBASE_SOURCE      = "Firebase-Vivid2"

WS_URL               = "wss://ws.aicryptosignals.pro:8766"
WS_SOURCE            = "AICryptoSignals"
WS_BACKOFF           = [5, 10, 30, 60]  # reconnect delays

CHANNEL_IDS = [
    -1002139755277,
    -1001811830204,
    -1001768716068,
    -1001314221782,
    -1002315467756,
    -1001498307336,
    -1001853036360,
]

DUPLICATE_WINDOW_MINUTES = 30


# ─── Existing parsing helpers (unchanged) ───────────────────────────────────

def parse_symbol(text: str) -> str | None:
    # Explicit labels first
    m = re.search(r'(?:symbol|pair|coin|ticker)[:\s]+([A-Z]{2,10}(?:USDT|USD|BTC|ETH|BNB)?)', text, re.IGNORECASE)
    if m:
        raw = m.group(1).upper()
        return re.sub(r'(USDT|USD|BTC|ETH|BNB)$', '', raw) or raw
    # AICryptoSignals / Firebase line-1 format: first line is bare symbol like RENDERUSDT or DYDXUSDT
    first_line = text.strip().split('\n')[0].strip().upper()
    if re.match(r'^[A-Z]{2,12}(?:USDT|USD|BTC|ETH)$', first_line):
        return re.sub(r'(USDT|USD|BTC|ETH)$', '', first_line) or first_line
    # Forex pair (exactly 6 uppercase letters like EURUSD)
    m = re.search(r'\b([A-Z]{6})\b', text)
    if m:
        return m.group(1)
    # Common crypto tickers followed by USDT/USD (with or without slash, any length 2-8)
    m = re.search(r'\b([A-Z]{2,8})(?:/USDT|/USD|USDT|USD)\b', text)
    if m:
        return m.group(1)
    # Standalone uppercase ticker (2-5 chars) - avoid common words
    exclude = {'BUY', 'SELL', 'LONG', 'SHORT', 'CALL', 'PUT', 'STOP', 'LOSS', 'TARGET',
               'TP', 'SL', 'USD', 'USDT', 'THE', 'FOR', 'NEW', 'ALL', 'NOW', 'NOT'}
    m = re.search(r'\b([A-Z]{2,5})\b', text)
    if m and m.group(1) not in exclude:
        return m.group(1)
    return None


def parse_direction(text: str) -> str | None:
    t = text.upper()
    for word in ['LONG', 'SHORT', 'BUY', 'SELL', 'CALL', 'PUT']:
        if re.search(r'\b' + word + r'\b', t):
            return word
    return None


def parse_price(text: str, labels: list[str]) -> float | None:
    for label in labels:
        pattern = rf'(?:{label})[:\s]*\$?([\d,]+(?:\.\d+)?)'
        m = re.search(pattern, text, re.IGNORECASE)
        if m:
            try:
                return float(m.group(1).replace(',', ''))
            except ValueError:
                pass
    return None


def parse_targets(text: str) -> list[float]:
    targets = []
    # Named targets: T1, TP1, Target 1, Target:
    patterns = [
        r'(?:T|TP|Target)\s*(\d)\s*[:\-=]?\s*\$?([\d,]+(?:\.\d+)?)',
        r'(?:Targets?)[:\s]+((?:\$?[\d,]+(?:\.\d+)?[\s,/]+)+)',
    ]
    for pat in patterns:
        for m in re.finditer(pat, text, re.IGNORECASE):
            try:
                val = float(m.group(m.lastindex).replace(',', '').strip())
                if val not in targets:
                    targets.append(val)
            except (ValueError, IndexError):
                pass
    # Fallback: "Targets: 100 200 300"
    if not targets:
        m = re.search(r'targets?\s*[:\-]\s*([\d\s,./]+)', text, re.IGNORECASE)
        if m:
            for part in re.split(r'[\s,/]+', m.group(1)):
                try:
                    targets.append(float(part))
                except ValueError:
                    pass
    return targets[:5]


def parse_leverage(text: str) -> str | None:
    m = re.search(r'(?:leverage|lev)[:\s]*(\d+\.?\d*)\s*[xX]?', text, re.IGNORECASE)
    if m:
        return f"{m.group(1)}x"
    m = re.search(r'(\d+\.?\d*)\s*[xX]\s*(?:leverage|lev)?', text, re.IGNORECASE)
    if m:
        return f"{m.group(1)}x"
    return None


def parse_price_change(text: str) -> str | None:
    """Extract 'Price change: +5.03%' style annotation."""
    m = re.search(r'price\s+change[:\s]+([+-]?[\d.]+%)', text, re.IGNORECASE)
    return m.group(1) if m else None


def parse_signal(text: str) -> dict:
    return {
        "symbol":       parse_symbol(text),
        "direction":    parse_direction(text),
        "entry":        parse_price(text, ['entry', 'entry price', 'buy at', 'buy', 'price', 'open']),
        "stop_loss":    parse_price(text, ['stop loss', 'stop', 'sl', 'stoploss']),
        "targets":      parse_targets(text),
        "leverage":     parse_leverage(text),
        "price_change": parse_price_change(text),
    }


# ─── Signal quality scorer (new) ────────────────────────────────────────────

def calc_risk_reward(entry: float | None, stop_loss: float | None, targets: list[float]) -> float | None:
    """Returns R:R ratio or None if it can't be calculated."""
    if entry is None or stop_loss is None or not targets:
        return None
    risk = abs(entry - stop_loss)
    if risk == 0:
        return None
    reward = abs(targets[0] - entry)
    return round(reward / risk, 2)


def score_signal(parsed: dict) -> tuple[int, float | None]:
    """
    Returns (score 0-100, risk_reward_ratio | None).
    Breakdown:
      +15  has symbol
      +15  has direction
      +20  has entry price
      +20  has stop loss
      +15  has at least one target
      +5   has leverage
      +10  R:R > 2:1 (bonus)
    """
    score = 0
    if parsed.get("symbol"):    score += 15
    if parsed.get("direction"): score += 15
    if parsed.get("entry"):     score += 20
    if parsed.get("stop_loss"): score += 20
    if parsed.get("targets"):   score += 15
    if parsed.get("leverage"):  score += 5

    rr = calc_risk_reward(parsed.get("entry"), parsed.get("stop_loss"), parsed.get("targets", []))
    if rr is not None and rr > 2.0:
        score += 10

    return min(score, 100), rr


def classify_status(score: int) -> str:
    if score >= 70: return "actionable"
    if score >= 40: return "review"
    return "rejected"


# ─── Storage ────────────────────────────────────────────────────────────────

def load_signals() -> list:
    if os.path.exists(SIGNALS_FILE):
        try:
            with open(SIGNALS_FILE, 'r') as f:
                return json.load(f)
        except (json.JSONDecodeError, IOError):
            return []
    return []


def save_signals(signals: list) -> None:
    with open(SIGNALS_FILE, 'w') as f:
        json.dump(signals, f, indent=2, default=str)


def load_channel_stats() -> dict:
    if os.path.exists(CHANNEL_STATS_FILE):
        try:
            with open(CHANNEL_STATS_FILE, 'r') as f:
                return json.load(f)
        except (json.JSONDecodeError, IOError):
            return {}
    return {}


def save_channel_stats(stats: dict) -> None:
    with open(CHANNEL_STATS_FILE, 'w') as f:
        json.dump(stats, f, indent=2)


def update_channel_stats(channel_name: str, is_actionable: bool) -> None:
    stats = load_channel_stats()
    if channel_name not in stats:
        stats[channel_name] = {"total_signals": 0, "actionable_signals": 0, "hit_rate": 0.0}
    stats[channel_name]["total_signals"] += 1
    if is_actionable:
        stats[channel_name]["actionable_signals"] += 1
    total = stats[channel_name]["total_signals"]
    actionable = stats[channel_name]["actionable_signals"]
    stats[channel_name]["hit_rate"] = round((actionable / total) * 100, 1) if total > 0 else 0.0
    save_channel_stats(stats)


# ─── Duplicate detection (new) ──────────────────────────────────────────────

def find_duplicate(signals: list, symbol: str | None, direction: str | None) -> dict | None:
    """
    Find an existing signal with the same symbol+direction within the last
    DUPLICATE_WINDOW_MINUTES. Returns the signal dict or None.
    """
    if not symbol or not direction:
        return None
    cutoff = datetime.now(timezone.utc) - timedelta(minutes=DUPLICATE_WINDOW_MINUTES)
    for sig in reversed(signals):  # most recent first
        if sig.get("symbol") != symbol or sig.get("direction") != direction:
            continue
        try:
            ts = datetime.fromisoformat(sig["timestamp"])
            # Make timezone-aware if naive
            if ts.tzinfo is None:
                ts = ts.replace(tzinfo=timezone.utc)
            if ts >= cutoff:
                return sig
        except (KeyError, ValueError):
            pass
    return None


# ─── Discord webhook poster (new, async, non-blocking) ──────────────────────

async def post_discord(url: str, payload: dict) -> None:
    """Fire-and-forget Discord webhook POST using aiohttp."""
    if not url:
        return
    try:
        import aiohttp
        async with aiohttp.ClientSession() as session:
            async with session.post(url, json=payload, timeout=aiohttp.ClientTimeout(total=8)) as resp:
                if resp.status not in (200, 204):
                    body = await resp.text()
                    print(f"  [WARN] Discord webhook {resp.status}: {body[:120]}", file=sys.stderr)
    except Exception as e:
        print(f"  [WARN] Discord post failed: {e}", file=sys.stderr)


def build_actionable_embed(sig: dict) -> dict:
    targets_str = ", ".join(f"${t:,.2f}" for t in (sig.get("targets") or []))
    rr = sig.get("risk_reward")
    rr_str = f"{rr}:1" if rr is not None else "N/A"
    lev = sig.get("leverage") or "—"
    confirmations = sig.get("confirmations", 1)
    conf_note = f" (+{confirmations-1} confirmation{'s' if confirmations > 2 else ''})" if confirmations > 1 else ""

    description = (
        f"**Symbol:** {sig.get('symbol') or '?'}\n"
        f"**Direction:** {sig.get('direction') or '?'}\n"
        f"**Entry:** ${sig.get('entry'):,.2f}\n" if sig.get('entry') else ""
        f"**Stop Loss:** ${sig.get('stop_loss'):,.2f}\n" if sig.get('stop_loss') else ""
        f"**Targets:** {targets_str or '—'}\n"
        f"**R:R Ratio:** {rr_str}\n"
        f"**Leverage:** {lev}\n"
        f"**Source:** {sig.get('channel_name', '?')}{conf_note}"
    )

    return {
        "embeds": [{
            "title": f"🟢 ACTIONABLE SIGNAL (Score: {sig.get('score', 0)}/100)",
            "description": description,
            "color": 0x00d2a0,
            "footer": {"text": f"Mission Control • {sig.get('timestamp', '')[:19].replace('T', ' ')} UTC"},
        }]
    }


def build_rejected_embed(sig: dict, parsed: dict) -> dict:
    missing = []
    if not parsed.get("symbol"):    missing.append("symbol")
    if not parsed.get("direction"): missing.append("direction")
    if not parsed.get("entry"):     missing.append("entry")
    if not parsed.get("stop_loss"): missing.append("stop loss")
    if not parsed.get("targets"):   missing.append("targets")
    raw_preview = (sig.get("raw_text") or "")[:100].replace("\n", " ")

    return {
        "embeds": [{
            "title": f"🔴 REJECTED (Score: {sig.get('score', 0)}/100)",
            "description": (
                f"**Symbol:** {parsed.get('symbol') or '?'}\n"
                f"**Missing:** {', '.join(missing) or 'none'}\n"
                f"**Source:** {sig.get('channel_name', '?')}\n"
                f"**Raw:** {raw_preview}…"
            ),
            "color": 0xff4757,
            "footer": {"text": f"Mission Control • {sig.get('timestamp', '')[:19].replace('T', ' ')} UTC"},
        }]
    }


# ─── Main ───────────────────────────────────────────────────────────────────

client = TelegramClient(SESSION_FILE, API_ID, API_HASH)
channel_name_cache: dict[int, str] = {}
_archive_session: "aiohttp.ClientSession | None" = None


async def get_channel_name(chat_id: int) -> str:
    if chat_id in channel_name_cache:
        return channel_name_cache[chat_id]
    try:
        entity = await client.get_entity(chat_id)
        name = getattr(entity, 'title', None) or getattr(entity, 'username', None) or str(chat_id)
        channel_name_cache[chat_id] = name
        return name
    except Exception:
        return str(chat_id)


@client.on(events.NewMessage(chats=CHANNEL_IDS))
async def handler(event):
    text = event.raw_text or ""
    if not text.strip():
        return

    channel_name = await get_channel_name(event.chat_id)
    timestamp    = datetime.now(timezone.utc).isoformat()
    parsed       = parse_signal(text)
    score, rr    = score_signal(parsed)
    status       = classify_status(score)

    signals = load_signals()

    # ── Duplicate detection ─────────────────────────────────────────────────
    duplicate = find_duplicate(signals, parsed.get("symbol"), parsed.get("direction"))
    if duplicate:
        # Increment confirmation on existing signal
        duplicate["confirmations"] = duplicate.get("confirmations", 1) + 1
        confirmed_by = duplicate.get("confirmed_by", [duplicate.get("channel_name", "?")])
        if channel_name not in confirmed_by:
            confirmed_by.append(channel_name)
        duplicate["confirmed_by"] = confirmed_by
        # Bump score (max +30 total bonus)
        bonus = min((duplicate["confirmations"] - 1) * 10, 30)
        duplicate["score"] = min(score + bonus, 100)
        # Re-classify after score bump
        duplicate["status"] = classify_status(duplicate["score"])
        save_signals(signals)

        sym = parsed['symbol'] or '???'
        direction = parsed['direction'] or '---'
        print(f"[{channel_name}] {sym} {direction} — DUPLICATE, confirmations: {duplicate['confirmations']}  |  {timestamp}")
        return  # don't post a new Discord embed for dupes

    # ── New signal ──────────────────────────────────────────────────────────
    signal = {
        "id":           str(uuid.uuid4()),
        "channel_id":   str(event.chat_id),
        "channel_name": channel_name,
        "timestamp":    timestamp,
        "raw_text":     text,
        **parsed,
        "score":         score,
        "status":        status,
        "risk_reward":   rr,
        "confirmations": 1,
        "confirmed_by":  [channel_name],
        "price_change":  parsed.get("price_change"),
    }

    signals.append(signal)
    signals = await maybe_rotate(
        _archive_session, "signals", signals, SIGNALS_FILE,
        max_entries=SIGNALS_MAX, webhook_url=ARCHIVE_SIGNALS_URL
    )
    save_signals(signals)

    # ── Channel stats ───────────────────────────────────────────────────────
    update_channel_stats(channel_name, is_actionable=(status == "actionable"))

    # ── Discord (fire and forget) ───────────────────────────────────────────
    if status == "actionable" and DISCORD_SIGNALS_URL:
        asyncio.create_task(post_discord(DISCORD_SIGNALS_URL, build_actionable_embed(signal)))
    elif status == "rejected" and DISCORD_REJECTED_URL:
        asyncio.create_task(post_discord(DISCORD_REJECTED_URL, build_rejected_embed(signal, parsed)))

    # ── Log line ────────────────────────────────────────────────────────────
    sym       = parsed['symbol'] or '???'
    direction = parsed['direction'] or '---'
    entry     = parsed['entry']
    entry_str = f"@ {entry}" if entry else ""
    status_icon = {"actionable": "🟢", "review": "🟡", "rejected": "🔴"}.get(status, "⚪")
    print(f"{status_icon} [{channel_name}] {sym} {direction} {entry_str}  score={score}  |  {timestamp}")


# ── Shared signal ingestion (used by all 3 sources) ──────────────────────────

async def ingest_signal(text: str, channel_name: str, source_type: str = "telegram") -> None:
    """
    Parse, score, dedup-check, save, and Discord-post a signal from any source.
    Mirrors the Telegram handler logic exactly.
    """
    if not text or not text.strip():
        return

    timestamp = datetime.now(timezone.utc).isoformat()
    parsed    = parse_signal(text)
    score, rr = score_signal(parsed)
    status    = classify_status(score)

    signals  = load_signals()
    duplicate = find_duplicate(signals, parsed.get("symbol"), parsed.get("direction"))
    if duplicate:
        duplicate["confirmations"] = duplicate.get("confirmations", 1) + 1
        confirmed_by = duplicate.get("confirmed_by", [duplicate.get("channel_name", "?")])
        if channel_name not in confirmed_by:
            confirmed_by.append(channel_name)
        duplicate["confirmed_by"] = confirmed_by
        bonus = min((duplicate["confirmations"] - 1) * 10, 30)
        duplicate["score"]  = min(score + bonus, 100)
        duplicate["status"] = classify_status(duplicate["score"])
        signals = await maybe_rotate(
            _archive_session, "signals", signals, SIGNALS_FILE,
            max_entries=SIGNALS_MAX, webhook_url=ARCHIVE_SIGNALS_URL
        )
        save_signals(signals)
        sym = parsed["symbol"] or "???"
        print(f"[{channel_name}] {sym} — DUPLICATE, confirmations: {duplicate['confirmations']}  |  {timestamp}")
        return

    signal = {
        "id":           str(uuid.uuid4()),
        "channel_id":   source_type,
        "channel_name": channel_name,
        "timestamp":    timestamp,
        "raw_text":     text,
        **parsed,
        "score":         score,
        "status":        status,
        "risk_reward":   rr,
        "confirmations": 1,
        "confirmed_by":  [channel_name],
        "price_change":  parsed.get("price_change"),
    }

    signals.append(signal)
    signals = await maybe_rotate(
        _archive_session, "signals", signals, SIGNALS_FILE,
        max_entries=SIGNALS_MAX, webhook_url=ARCHIVE_SIGNALS_URL
    )
    save_signals(signals)
    update_channel_stats(channel_name, is_actionable=(status == "actionable"))

    if status == "actionable" and DISCORD_SIGNALS_URL:
        asyncio.create_task(post_discord(DISCORD_SIGNALS_URL, build_actionable_embed(signal)))
    elif status == "rejected" and DISCORD_REJECTED_URL:
        asyncio.create_task(post_discord(DISCORD_REJECTED_URL, build_rejected_embed(signal, parsed)))

    sym       = parsed["symbol"] or "???"
    direction = parsed["direction"] or "---"
    entry_str = f"@ {parsed['entry']}" if parsed.get("entry") else ""
    icon = {"actionable": "🟢", "review": "🟡", "rejected": "🔴"}.get(status, "⚪")
    print(f"{icon} [{channel_name}] {sym} {direction} {entry_str}  score={score}  |  {timestamp}")


# ── Firebase source ───────────────────────────────────────────────────────────

def _firebase_to_text(symbol: str, item: dict) -> str:
    """Convert a Firebase signal dict to a text string for parse_signal()."""
    parts = [symbol]
    # Direction: isPut=1 → PUT, otherwise CALL for options; stocks get BUY
    is_put  = item.get("isPut", 0)
    cat     = str(item.get("category", "")).lower()
    if "option" in cat or item.get("expiry"):
        parts.append("PUT" if is_put else "CALL")
    else:
        parts.append("BUY")
    buy  = item.get("buyTarget")
    sl   = item.get("stopLoss")
    t1   = item.get("sellTarget") or item.get("earlyTarget")
    t2   = item.get("sellTarget2")
    t3   = item.get("sellTarget3")
    if buy:  parts.append(f"Entry: {buy}")
    if sl:   parts.append(f"Stop Loss: {sl}")
    if t1:   parts.append(f"Target 1: {t1}")
    if t2:   parts.append(f"Target 2: {t2}")
    if t3:   parts.append(f"Target 3: {t3}")
    expiry = item.get("expiry")
    if expiry: parts.append(f"Expiry: {expiry}")
    return "\n".join(parts)


async def firebase_poller() -> None:
    """Poll Firebase Vivid2 endpoint every 60s, ingest new signals."""
    print(f"[Firebase] Starting poller → {FIREBASE_URL}")
    seen_ids: set[str] = set()

    # Pre-populate seen_ids from existing signals to avoid re-ingesting on restart
    for sig in load_signals():
        if sig.get("channel_id") == "firebase":
            seen_ids.add(sig.get("raw_text", "")[:40])  # use raw_text prefix as key

    while True:
        try:
            async with aiohttp.ClientSession() as sess:
                async with sess.get(FIREBASE_URL, timeout=aiohttp.ClientTimeout(total=12)) as resp:
                    if resp.status != 200:
                        print(f"[Firebase] HTTP {resp.status}", file=sys.stderr)
                    else:
                        data = await resp.json(content_type=None)
                        new_count = 0
                        for section_key in FIREBASE_LIVE_KEYS:
                            section = data.get(section_key, {})
                            if not isinstance(section, dict):
                                continue
                            for item_id, item in section.items():
                                if not isinstance(item, dict):
                                    continue
                                # Skip closed signals
                                status_str = str(item.get("status","")).lower()
                                if any(x in status_str for x in ("closed","stopped","expired")):
                                    continue
                                sym = item.get("symbol","")
                                if not sym:
                                    continue
                                uid = f"{section_key}_{item_id}"
                                if uid in seen_ids:
                                    continue
                                seen_ids.add(uid)
                                text = _firebase_to_text(sym, item)
                                await ingest_signal(text, FIREBASE_SOURCE, "firebase")
                                new_count += 1
                        if new_count:
                            print(f"[Firebase] {new_count} new signal(s) ingested")
        except Exception as e:
            print(f"[Firebase] Poll error: {e}", file=sys.stderr)

        await asyncio.sleep(FIREBASE_POLL_SEC)


# ── WebSocket source ──────────────────────────────────────────────────────────

def _ws_msg_to_signals(raw: str) -> list[tuple[str, str]]:
    """
    Parse a WebSocket message from AICryptoSignals.
    The feed sends two types:
      1. Price ticker array: [{"s":"BTCUSDT","c":"70284","P":"-0.5",...}, ...]
         → extract symbols with unusual price change as potential signals
      2. Signal object: {"symbol":..., "direction":..., "entry":..., ...}
    Returns list of (text, symbol) tuples for ingestion.
    """
    results = []
    try:
        data = json.loads(raw)
    except json.JSONDecodeError:
        return results

    # Array of price tickers
    if isinstance(data, list):
        for item in data:
            if not isinstance(item, dict):
                continue
            sym = item.get("s","")
            price = item.get("c","")
            pct   = float(item.get("P", 0) or 0)
            # Only flag significant moves (>5% in either direction) as signals
            # Lower threshold produces too much noise from continuous ticker feed
            if abs(pct) >= 5.0 and sym and price:
                direction = "LONG" if pct > 0 else "SHORT"
                text = f"{sym}\n{direction}\nEntry: {price}\nPrice change: {pct:+.2f}%"
                results.append((text, sym))
        return results

    # Single signal object
    if isinstance(data, dict):
        sym  = data.get("symbol") or data.get("s","")
        dire = data.get("direction") or data.get("side","")
        entry = data.get("entry") or data.get("price") or data.get("c","")
        sl    = data.get("stopLoss") or data.get("stop_loss") or data.get("sl","")
        t1    = data.get("target") or data.get("tp1") or data.get("takeProfit","")
        if sym:
            parts = [sym]
            if dire:  parts.append(dire.upper())
            if entry: parts.append(f"Entry: {entry}")
            if sl:    parts.append(f"Stop Loss: {sl}")
            if t1:    parts.append(f"Target 1: {t1}")
            results.append(("\n".join(parts), sym))

    return results


async def ws_listener() -> None:
    """Connect to AICryptoSignals WebSocket, ingest signals, auto-reconnect."""
    import ssl as _ssl
    import time as _time
    backoff_idx = 0
    # Per-symbol cooldown — don't re-fire same ticker signal within 30 min
    _ws_last_fired: dict[str, float] = {}
    WS_COOLDOWN = 30 * 60
    print(f"[WS] Starting listener → {WS_URL}")

    while True:
        try:
            ssl_ctx = _ssl.create_default_context()
            async with websockets.connect(
                WS_URL, ssl=ssl_ctx, open_timeout=15,
                additional_headers={"User-Agent": "MissionControl/1.0"},
                ping_interval=30, ping_timeout=20,
            ) as ws:
                print(f"[WS] ✅ Connected to {WS_URL}")
                backoff_idx = 0  # reset backoff on successful connect
                async for raw in ws:
                    signals_to_process = _ws_msg_to_signals(str(raw))
                    for text, sym in signals_to_process:
                        # Cooldown: skip if same symbol fired recently
                        now_t = _time.monotonic()
                        last  = _ws_last_fired.get(sym, 0)
                        if now_t - last < WS_COOLDOWN:
                            continue
                        _ws_last_fired[sym] = now_t
                        await ingest_signal(text, WS_SOURCE, "websocket")

        except (websockets.exceptions.ConnectionClosedError,
                websockets.exceptions.ConnectionClosedOK) as e:
            print(f"[WS] Connection closed: {e}")
        except Exception as e:
            print(f"[WS] Error: {e}", file=sys.stderr)

        delay = WS_BACKOFF[min(backoff_idx, len(WS_BACKOFF) - 1)]
        print(f"[WS] Reconnecting in {delay}s... (attempt {backoff_idx + 1})")
        await asyncio.sleep(delay)
        backoff_idx = min(backoff_idx + 1, len(WS_BACKOFF) - 1)


async def main():
    global _archive_session
    print("=== Mission Control Signal Listener v3 ===")
    print(f"Session : {SESSION_FILE}.session")
    print(f"Signals : {SIGNALS_FILE}")
    print(f"Stats   : {CHANNEL_STATS_FILE}")
    print(f"Discord : signals={'✅' if DISCORD_SIGNALS_URL else '❌'}  rejected={'✅' if DISCORD_REJECTED_URL else '❌'}")
    print(f"Archive : {'✅' if ARCHIVE_SIGNALS_URL else '❌'}  (rotate at {SIGNALS_MAX} entries)")
    print(f"Sources :")
    print(f"  [1] Telegram   — {len(CHANNEL_IDS)} channels (active)")
    print(f"  [2] Firebase   — {FIREBASE_URL[:50]}... (poll {FIREBASE_POLL_SEC}s)")
    print(f"  [3] WebSocket  — {WS_URL} (active)")
    print()

    async with aiohttp.ClientSession() as session:
        _archive_session = session
        await client.start()
        me = await client.get_me()
        print(f"✅ Connected as {me.first_name} (@{me.username})")
        print("Listening for signals...\n")

        # Run all three sources concurrently
        await asyncio.gather(
            client.run_until_disconnected(),
            firebase_poller(),
            ws_listener(),
            return_exceptions=True,
        )


if __name__ == "__main__":
    asyncio.run(main())
