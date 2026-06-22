#!/usr/bin/env python3
"""
DeepSeek flow observer — reads flow channels every 30 min during market hours,
forms an independent take using DeepSeek API, posts to #agent-debate.

Provides a 5th voice independent of Boba/Orion/Grok/JazzyHazzy.
"""
import sys, json, requests
from pathlib import Path
from datetime import datetime, timezone

sys.path.insert(0, "/home/ubuntu/scripts")
from lib.flow_channel_reader import get_recent_flow_context, format_for_prompt
from lib.agent_debate import post_to_debate

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
DEEPSEEK_KEY = (SECRETS / "deepseek_api_key").read_text().strip()
DEEPSEEK_URL = "https://api.deepseek.com/v1/chat/completions"
DEEPSEEK_MODEL = "deepseek-chat"

def call_deepseek(flow_text):
    prompt = f"""You are DeepSeek, a contrarian options-flow analyst in a multi-agent trading team.
Other agents (Boba, Orion, Grok, JazzyHazzy, Kronos) all see the same flow data.
Your job: find what THEY might miss. Look for:
- Tickers showing repeated unusual flow that may be sustained institutional positioning vs noise
- Sector clustering (multiple tickers in same sector = thematic move)
- Flow contradicting recent price action (smart money fading the move)
- Hidden gems below the T0/T1 huge-flow tier that have setup quality

Flow channel snapshot (last 30 min):
{flow_text}

Output format (max 6 lines, no preamble):
**DeepSeek take:**
1. [Most interesting observation, 1 line]
2. [Second observation, 1 line]  
3. [Contrarian angle if any, 1 line]

Tickers: <comma-separated list of tickers you mentioned>

Be specific, terse, and skip if nothing interesting — say "Nothing edge-worthy this window" rather than padding."""
    
    try:
        r = requests.post(DEEPSEEK_URL,
            headers={"Authorization": f"Bearer {DEEPSEEK_KEY}", "Content-Type": "application/json"},
            json={"model": DEEPSEEK_MODEL, "messages": [{"role": "user", "content": prompt}], "max_tokens": 500},
            timeout=60)
        if r.status_code != 200:
            return f"(DeepSeek API error {r.status_code})"
        return r.json()["choices"][0]["message"]["content"].strip()
    except Exception as e:
        return f"(DeepSeek error: {e})"

def main():
    ctx = get_recent_flow_context(agent_token_file="discord_deepseek_token", lookback_min=30, max_per_channel=15)
    flow_text = format_for_prompt(ctx, max_show=15)
    
    if "no recent flow" in flow_text.lower():
        print("(no flow activity to observe)")
        return
    
    take = call_deepseek(flow_text)
    if not take or "Nothing edge-worthy" in take:
        print("[deepseek] nothing edge-worthy this window")
        return
    
    # Extract first ticker from take if present (for embed footer)
    import re
    tickers = re.findall(r"\$?([A-Z]{2,5})\b", take.upper())
    primary_ticker = tickers[0] if tickers else None
    
    ok = post_to_debate("deepseek", take, related_symbol=primary_ticker)
    print(f"[deepseek] {'✓ posted' if ok else '✗ post failed'}")

if __name__ == "__main__":
    main()
