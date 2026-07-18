#!/usr/bin/env python3
"""
Cross-agent debate channel poster.

post_to_debate(agent_name, content, related_symbol=None, color=None)
Sends embed to #agent-debate (channel 1498788205544214619) using each agent's own bot identity.

Agents: boba, orion, grok, jazzyhazzy, deepseek
"""
import requests
from pathlib import Path

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
DEBATE_CHANNEL_ID = "1498788205544214619"

# Each agent uses their own bot token so messages appear under their identity
AGENT_TOKEN_MAP = {
    "boba":       "discord_boba_token",
    "orion":      "discord_orion_token",
    "grok":       "discord_askgrok_token",  # reuse AskGrok's token (existing bot)
    "jazzyhazzy": "discord_jazzyhazzy_token",
    "deepseek":   "discord_deepseek_token",
}

# Color per agent for visual disambiguation in #agent-debate
AGENT_COLORS = {
    "boba":       0xff6b35,  # orange
    "orion":      0x4dabf7,  # blue
    "grok":       0x9c27b0,  # purple
    "jazzyhazzy": 0xff69b4,  # pink
    "deepseek":   0x00d2a0,  # teal
}

def post_to_debate(agent_name, content, related_symbol=None, color=None, embed_title=None):
    """
    Post to #agent-debate as the given agent.
    Returns True on success, False on failure.
    """
    token_file = AGENT_TOKEN_MAP.get(agent_name.lower())
    if not token_file:
        return False
    p = SECRETS / token_file
    if not p.exists():
        return False
    token = p.read_text().strip()
    
    if color is None:
        color = AGENT_COLORS.get(agent_name.lower(), 0x808080)
    
    if embed_title is None:
        embed_title = f"{agent_name.title()}"
        if related_symbol:
            embed_title += f" — {related_symbol}"
    
    embed = {
        "title": embed_title[:256],
        "description": content[:4000],
        "color": color,
    }
    if related_symbol:
        embed["footer"] = {"text": f"ticker: {related_symbol}"}
    
    try:
        r = requests.post(
            f"https://discord.com/api/v10/channels/{DEBATE_CHANNEL_ID}/messages",
            headers={"Authorization": f"Bot {token}", "Content-Type": "application/json"},
            json={"embeds": [embed]},
            timeout=15)
        return r.status_code in (200, 201)
    except Exception:
        return False

if __name__ == "__main__":
    import sys
    agent = sys.argv[1] if len(sys.argv) > 1 else "boba"
    msg = sys.argv[2] if len(sys.argv) > 2 else "test message from agent_debate.py"
    sym = sys.argv[3] if len(sys.argv) > 3 else None
    ok = post_to_debate(agent, msg, related_symbol=sym)
    print(f"{'✓' if ok else '✗'} posted as {agent}")
