#!/usr/bin/env python3
"""
Grok market brief — runs every 30 min via cron.
Uses xAI grok-4-fast with x_search to capture macro/sentiment narrative
that's not in technical data sources. Output read by Boba each cycle.

Cost: ~$0.01-0.03 per call × 48/day ≈ $0.48-1.44/day at most.
"""
import json, requests, sys
from pathlib import Path
from datetime import datetime, timezone

SECRETS = Path.home() / ".openclaw" / "secrets"
OUT = Path.home() / ".openclaw" / "workspace" / "directives" / "grok_brief.json"
OUT.parent.mkdir(parents=True, exist_ok=True)

XAI_KEY = (SECRETS / "xai_api_key").read_text().strip()
URL = "https://api.x.ai/v1/responses"
MODEL = "grok-4-fast-non-reasoning"

PROMPT = """You are Grok, embedded in a multi-agent options-trading system. Generate a CONCISE market brief (max 600 words) for use by Boba (the decision agent) right now.

Cover:
1. **Macro pulse** — what just moved markets in the last 1-3 hours (Fed/CPI/jobs/geopolitics). Cite X handles where relevant.
2. **Sentiment shift** — net bullish/bearish change vs yesterday based on real-time chatter.
3. **Hot tickers** — 3-5 names with unusual narrative momentum right now (NOT just technicals — the story).
4. **Risk-off triggers** — anything brewing that could spike VIX in the next 24h.
5. **Bottom line** — one sentence: should Boba lean aggressive, neutral, or defensive RIGHT NOW.

Be specific. No hedge language ("might"/"could"). State what you actually see in the X firehose.
"""

def main():
    try:
        r = requests.post(
            URL,
            headers={"Authorization": f"Bearer {XAI_KEY}", "Content-Type": "application/json"},
            json={"model": MODEL, "input": PROMPT, "tools": [{"type": "x_search"}]},
            timeout=180,
        )
        if r.status_code != 200:
            print(f"✗ HTTP {r.status_code}: {r.text[:300]}", file=sys.stderr)
            sys.exit(1)
        data = r.json()
        text = ""
        for block in data.get("output", []):
            for c in block.get("content", []) or []:
                if c.get("type") == "output_text":
                    text = c.get("text", "")
                    break
            if text: break
        if not text:
            print("✗ no output_text", file=sys.stderr); sys.exit(1)
        out = {
            "generated_at": datetime.now(timezone.utc).isoformat(),
            "model": MODEL,
            "brief_text": text,
        }
        OUT.write_text(json.dumps(out, indent=2))
        print(f"✓ Grok brief written: {len(text)} chars → {OUT}")
    except Exception as e:
        print(f"✗ Exception: {e}", file=sys.stderr); sys.exit(2)

if __name__ == "__main__":
    main()
