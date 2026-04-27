#!/usr/bin/env python3
"""
TradingView Webhook Receiver — Mission Control Signal Pipeline
Port 8420 | Zero LLM calls | Pure Python
"""

import json
import os
import sys
from datetime import datetime, timezone

from fastapi import FastAPI, Request, HTTPException, Header
from fastapi.responses import JSONResponse
import uvicorn

# Add shared skills to path
sys.path.insert(0, os.path.expanduser("~/.openclaw/workspace/skills/shared"))

try:
    from mc_utils import get_secret
except ImportError:
    # Fallback if mc_utils not available
    def get_secret(name):
        path = os.path.expanduser(f"~/.openclaw/secrets/{name}")
        with open(path, "r") as f:
            return f.read().strip()

from signal_parser import parse_signal
from discord_relay import post_signal_to_discord
from signal_store import store_signal

app = FastAPI(title="TV Signal Receiver", version="1.0.0")

# Dirs
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
LOG_DIR = os.path.join(BASE_DIR, "logs")
os.makedirs(LOG_DIR, exist_ok=True)

# Load auth token
WEBHOOK_SECRET = None

def get_webhook_secret():
    global WEBHOOK_SECRET
    if WEBHOOK_SECRET is None:
        secret_path = os.path.expanduser("~/.openclaw/secrets/tradingview_webhook_secret")
        if not os.path.exists(secret_path):
            import secrets
            token = secrets.token_urlsafe(32)
            os.makedirs(os.path.dirname(secret_path), exist_ok=True)
            with open(secret_path, "w") as f:
                f.write(token)
            os.chmod(secret_path, 0o600)
            print(f"\n{'='*60}")
            print(f"GENERATED WEBHOOK SECRET — copy this into TradingView:")
            print(f"{token}")
            print(f"{'='*60}\n")
        WEBHOOK_SECRET = get_secret("tradingview_webhook_secret")
    return WEBHOOK_SECRET


@app.on_event("startup")
async def startup():
    secret = get_webhook_secret()
    print(f"[signal-receiver] Running on port 8420")
    print(f"[signal-receiver] Webhook secret loaded ({len(secret)} chars)")
    print(f"[signal-receiver] POST http://<server-ip>:8420/webhook/tradingview")


@app.post("/webhook/tradingview")
async def receive_webhook(request: Request, authorization: str = Header(default=None)):
    """Receive and process TradingView webhook alerts."""
    
    # Auth check — supports "Bearer <token>" or raw token
    secret = get_webhook_secret()
    token = None
    if authorization:
        token = authorization.replace("Bearer ", "").strip()
    
    # Also check query param as fallback (some TV setups use ?token=)
    if not token:
        token = request.query_params.get("token")
    
    if token != secret:
        raise HTTPException(status_code=401, detail="Invalid token")
    
    # Parse body — handle both JSON and plain text
    content_type = request.headers.get("content-type", "")
    raw_body = await request.body()
    raw_text = raw_body.decode("utf-8").strip()
    
    try:
        if "json" in content_type:
            payload = json.loads(raw_text)
        else:
            # Try JSON first, fall back to plain text
            try:
                payload = json.loads(raw_text)
            except json.JSONDecodeError:
                payload = {"message": raw_text}
    except Exception as e:
        payload = {"message": raw_text, "parse_error": str(e)}
    
    # Log raw
    raw_log = {
        "received_at": datetime.now(timezone.utc).isoformat(),
        "payload": payload,
        "raw": raw_text
    }
    raw_log_path = os.path.join(LOG_DIR, "raw_signals.jsonl")
    with open(raw_log_path, "a") as f:
        f.write(json.dumps(raw_log) + "\n")
    
    # Parse signal
    parsed = parse_signal(payload, raw_text)
    
    # Store
    store_signal(parsed)
    
    # Discord relay (fire and forget, don't block response)
    try:
        post_signal_to_discord(parsed)
    except Exception as e:
        print(f"[signal-receiver] Discord relay error: {e}")
    
    return JSONResponse(content={
        "status": "received",
        "parsed": parsed
    })


@app.get("/signals/latest")
async def get_latest():
    """Return current position state per ticker."""
    from signal_store import get_latest_state
    return JSONResponse(content=get_latest_state())


@app.get("/signals/history/{ticker}")
async def get_history(ticker: str, limit: int = 50):
    """Return signal history for a ticker."""
    from signal_store import get_signal_history
    return JSONResponse(content=get_signal_history(ticker.upper(), limit))


@app.get("/health")
async def health():
    return {"status": "ok", "service": "signal-receiver", "port": 8420}


if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8420)
