#!/usr/bin/env python3
"""Item 36: Discord thread management helper.

For GUILD_TEXT channels (Discord type 0), webhooks alone cannot create threads.
This helper uses a bot token to create the thread, then webhook to post messages
into it via the thread_id query param. Subsequent messages for the same pick
reuse the cached thread_id.

Public function:
    post_to_pick_thread(pick_key, message, thread_name, webhook_url,
                        bot_token, channel_id) -> dict

Returns:
    {'ok': bool, 'thread_id': str|None, 'created': bool, 'error': str|None}

State:
    Pick-to-thread mapping persisted at ~/.openclaw/state/pick_threads.json
    Threads auto-archive after 1440 minutes (24h) so old picks don't clutter.
"""
import json, time, requests
from pathlib import Path

STATE_DIR = Path.home() / ".openclaw" / "state"
STATE_FILE = STATE_DIR / "pick_threads.json"
DISCORD_API = "https://discord.com/api/v10"
AUTO_ARCHIVE_MINUTES = 1440  # 24 hours
THREAD_RETENTION_DAYS = 7    # keep mapping for 7 days then garbage collect


def _load_state():
    """Load pick_key -> {thread_id, created_at} mapping."""
    if not STATE_FILE.exists():
        return {}
    try:
        return json.loads(STATE_FILE.read_text())
    except Exception:
        return {}


def _save_state(state):
    """Persist mapping. Garbage-collect entries older than retention period."""
    STATE_DIR.mkdir(parents=True, exist_ok=True)
    cutoff = time.time() - (THREAD_RETENTION_DAYS * 86400)
    pruned = {
        k: v for k, v in state.items()
        if isinstance(v, dict) and v.get("created_at", 0) > cutoff
    }
    STATE_FILE.write_text(json.dumps(pruned, indent=2))
    return pruned


def _create_thread(bot_token, channel_id, thread_name):
    """Create a thread in a GUILD_TEXT channel via bot API.
    Returns thread_id string or None on failure."""
    if not bot_token or not channel_id:
        return None
    try:
        r = requests.post(
            f"{DISCORD_API}/channels/{channel_id}/threads",
            headers={
                "Authorization": f"Bot {bot_token}",
                "Content-Type": "application/json",
            },
            json={
                "name": thread_name[:100],  # Discord limit
                "auto_archive_duration": AUTO_ARCHIVE_MINUTES,
                "type": 11,  # PUBLIC_THREAD
            },
            timeout=10,
        )
        if r.status_code in (200, 201):
            return str(r.json().get("id"))
        return None
    except Exception:
        return None


def _post_via_webhook(webhook_url, message, thread_id=None):
    """Post a message via webhook, optionally into a specific thread."""
    if not webhook_url:
        return False, "missing webhook"
    try:
        params = {"thread_id": thread_id} if thread_id else None
        r = requests.post(
            webhook_url,
            json={"content": message[:1900]},
            params=params,
            timeout=10,
        )
        if r.status_code in (200, 204):
            return True, None
        return False, f"webhook returned {r.status_code}: {r.text[:200]}"
    except Exception as e:
        return False, f"webhook exception: {e}"


def post_to_pick_thread(pick_key, message, thread_name, webhook_url,
                       bot_token=None, channel_id=None):
    """Post a message into a per-pick Discord thread.

    First call for a given pick_key creates the thread and caches the ID.
    Subsequent calls post into the same thread.

    Args:
        pick_key: stable identifier for the pick (e.g. "AAPL_290_CALL_2026-05-08")
        message: text to post (Discord-formatted)
        thread_name: name for the thread if creating (max 100 chars)
        webhook_url: Discord webhook URL for the parent channel
        bot_token: Discord bot token (required to create threads in text channels)
        channel_id: parent channel ID (required for thread creation)

    Returns:
        dict {ok, thread_id, created, error}
    """
    if not pick_key or not message:
        return {"ok": False, "thread_id": None, "created": False,
                "error": "missing pick_key or message"}

    state = _load_state()
    entry = state.get(pick_key)
    thread_id = entry.get("thread_id") if isinstance(entry, dict) else None
    created = False

    # If no cached thread_id, try to create one
    if not thread_id:
        if not bot_token or not channel_id:
            # Fallback: post flat to channel without threading
            ok, err = _post_via_webhook(webhook_url, message)
            return {"ok": ok, "thread_id": None, "created": False,
                    "error": err or "no bot_token or channel_id, posted flat"}
        thread_id = _create_thread(bot_token, channel_id, thread_name)
        if not thread_id:
            # Thread creation failed, fallback to flat post
            ok, err = _post_via_webhook(webhook_url, message)
            return {"ok": ok, "thread_id": None, "created": False,
                    "error": err or "thread creation failed, posted flat"}
        # Cache the new thread_id
        state[pick_key] = {"thread_id": thread_id, "created_at": time.time()}
        _save_state(state)
        created = True

    # Post into the thread
    ok, err = _post_via_webhook(webhook_url, message, thread_id=thread_id)
    return {"ok": ok, "thread_id": thread_id, "created": created, "error": err}


def post_to_pick_thread_bot(pick_key, message, thread_name, token, parent_channel_id):
    """Token-only variant of post_to_pick_thread — no webhook needed. Creates the
    per-pick thread on first call (cached by pick_key), then posts the message into
    it via the bot token (threads are channels). Lets a gateway-app token (e.g.
    SynthControl) own the whole entry→exit→grade thread. Returns
    {ok, thread_id, created, error}. Never raises."""
    if not pick_key or not message:
        return {"ok": False, "thread_id": None, "created": False, "error": "missing pick_key/message"}
    if not token or not parent_channel_id:
        return {"ok": False, "thread_id": None, "created": False, "error": "missing token/parent"}
    try:
        from lib import ops_card as oc
    except ImportError:
        import os, sys as _sys
        _sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
        from lib import ops_card as oc
    state = _load_state()
    entry = state.get(pick_key)
    thread_id = entry.get("thread_id") if isinstance(entry, dict) else None
    created = False
    if not thread_id:
        thread_id = _create_thread(token, parent_channel_id, thread_name)
        if not thread_id:
            return {"ok": False, "thread_id": None, "created": False, "error": "thread create failed"}
        state[pick_key] = {"thread_id": thread_id, "created_at": time.time()}
        _save_state(state)
        created = True
    ok = oc.post_message_bot(thread_id, token, content=message)
    return {"ok": bool(ok), "thread_id": thread_id, "created": created,
            "error": None if ok else "post failed"}


def make_pick_key(ticker, strike, option_type, expiry):
    """Stable key for a pick. Used by all callers to look up the thread."""
    t = str(ticker or "").upper()
    s = str(strike or "")
    o = str(option_type or "").upper()
    e = str(expiry or "")[:10]
    return f"{t}_{s}_{o}_{e}"


if __name__ == "__main__":
    import sys
    print("This module exposes post_to_pick_thread() and make_pick_key().")
    print(f"State file: {STATE_FILE}")
    print(f"Current cached threads: {len(_load_state())}")
