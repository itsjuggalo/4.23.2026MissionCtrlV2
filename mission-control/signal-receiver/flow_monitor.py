#!/usr/bin/env python3
"""
Flow Greeks Monitor — Watches Discord channels, scores signals, posts top picks
Zero LLM calls. Uses Discord Gateway (websocket) to read messages in real-time.
"""

import json
import os
import sys
import threading
import time
import urllib.request
import websocket

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
sys.path.insert(0, os.path.expanduser("~/.openclaw/workspace/skills/shared"))

from flow_scorer import process_and_score, post_top_pick

try:
    from mc_utils import get_secret
except ImportError:
    def get_secret(name):
        path = os.path.expanduser(f"~/.openclaw/secrets/{name}")
        with open(path, "r") as f:
            return f.read().strip()

# Channels to monitor
FLOW_CHANNELS = [
    "1493401196268880113",
    "1493401228082680018",
    "1493401288929444013",
    "1493401432634691726",
]

# Minimum score to post to Discord
MIN_SCORE_TO_POST = 40

TOKEN = None
HEARTBEAT_INTERVAL = None
SEQUENCE = None


def get_token():
    global TOKEN
    if TOKEN is None:
        TOKEN = get_secret("discord_bot_token")
    return TOKEN


def identify_payload():
    return json.dumps({
        "op": 2,
        "d": {
            "token": get_token(),
            "intents": 33280,  # GUILD_MESSAGES + MESSAGE_CONTENT
            "properties": {
                "os": "linux",
                "browser": "flow-scorer",
                "device": "flow-scorer"
            }
        }
    })


def heartbeat_payload():
    return json.dumps({"op": 1, "d": SEQUENCE})


def process_message(data):
    """Process a Discord message from a flow channel."""
    channel_id = data.get("channel_id", "")
    content = data.get("content", "")

    if channel_id not in FLOW_CHANNELS:
        return

    if not content:
        # Check embeds
        embeds = data.get("embeds", [])
        for embed in embeds:
            title = embed.get("title", "")
            desc = embed.get("description", "")
            fields_text = ""
            for field in embed.get("fields", []):
                fields_text += f"\n{field.get('name', '')} {field.get('value', '')}"
            content = f"{title}\n{desc}{fields_text}"

    if not content or len(content) < 20:
        return

    # Check if it looks like a flow signal
    has_ticker = bool(re.search(r'[A-Z]{1,5}\s+\$\d+', content))
    has_flow = any(k in content.lower() for k in ['flow', 'sweep', 'block', 'volume', 'oi', 'alert type'])

    if not has_ticker and not has_flow:
        return

    print(f"\n[flow-monitor] Signal detected in channel {channel_id}")
    print(f"[flow-monitor] Content: {content[:100]}...")

    try:
        result = process_and_score(content)
        score = result["scoring"]["score"]
        grade = result["scoring"]["grade"]
        ticker = result["parsed"].get("ticker", "?")

        print(f"[flow-monitor] {ticker} scored {score}/100 ({grade})")

        if score >= MIN_SCORE_TO_POST:
            post_top_pick(result)
            print(f"[flow-monitor] Posted to Discord!")
        else:
            print(f"[flow-monitor] Below threshold ({MIN_SCORE_TO_POST}), skipped")

    except Exception as e:
        print(f"[flow-monitor] Scoring error: {e}")


def on_message(ws, message):
    global HEARTBEAT_INTERVAL, SEQUENCE

    data = json.loads(message)
    op = data.get("op")

    if op == 10:  # Hello
        HEARTBEAT_INTERVAL = data["d"]["heartbeat_interval"] / 1000
        ws.send(identify_payload())
        # Start heartbeat thread
        def heartbeat():
            while True:
                time.sleep(HEARTBEAT_INTERVAL)
                try:
                    ws.send(heartbeat_payload())
                except Exception:
                    break
        t = threading.Thread(target=heartbeat, daemon=True)
        t.start()

    elif op == 0:  # Dispatch
        SEQUENCE = data.get("s")
        event = data.get("t")

        if event == "READY":
            user = data["d"]["user"]
            print(f"[flow-monitor] Connected as {user['username']}#{user.get('discriminator', '0')}")
            print(f"[flow-monitor] Watching {len(FLOW_CHANNELS)} channels")
            print(f"[flow-monitor] Min score to post: {MIN_SCORE_TO_POST}")

        elif event == "MESSAGE_CREATE":
            process_message(data["d"])

    elif op == 11:  # Heartbeat ACK
        pass

    elif op == 7:  # Reconnect
        print("[flow-monitor] Reconnect requested")
        ws.close()

    elif op == 9:  # Invalid session
        print("[flow-monitor] Invalid session, reconnecting...")
        time.sleep(3)
        ws.close()


def on_error(ws, error):
    print(f"[flow-monitor] WebSocket error: {error}")


def on_close(ws, close_status, close_msg):
    print(f"[flow-monitor] Connection closed: {close_status} {close_msg}")


def on_open(ws):
    print("[flow-monitor] WebSocket connected")


import re  # needed for process_message


def run():
    """Run the flow monitor with auto-reconnect."""
    print(f"[flow-monitor] Starting Flow Greeks Monitor")
    print(f"[flow-monitor] Channels: {FLOW_CHANNELS}")

    while True:
        try:
            ws = websocket.WebSocketApp(
                "wss://gateway.discord.gg/?v=10&encoding=json",
                on_message=on_message,
                on_error=on_error,
                on_close=on_close,
                on_open=on_open,
            )
            ws.run_forever()
        except Exception as e:
            print(f"[flow-monitor] Error: {e}")

        print("[flow-monitor] Reconnecting in 5s...")
        time.sleep(5)


if __name__ == "__main__":
    run()
