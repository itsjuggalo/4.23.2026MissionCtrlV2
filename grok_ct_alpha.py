#!/usr/bin/env python3
"""
Grok CT Alpha Scraper — uses xAI Responses API with built-in x_search tool.
Polls every 15min via cron, dedupes 6h, posts urgency-tagged items to Discord X-updates.
"""
import json
import sys
import time
import hashlib
import requests
from pathlib import Path
from datetime import datetime, timezone, timedelta

SECRETS = Path.home() / ".openclaw" / "secrets"
STATE_FILE = Path.home() / ".openclaw" / "workspace" / "state" / "grok_ct_alpha_seen.json"
OUTPUT_FILE = Path.home() / ".openclaw" / "workspace" / "skill_outputs" / "grok_ct_alpha.json"
STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
OUTPUT_FILE.parent.mkdir(parents=True, exist_ok=True)

DEDUPE_HOURS = 6
API_URL = "https://api.x.ai/v1/responses"
MODEL = "grok-4-latest"
WEBHOOK_NAME = "discord_webhook_x_updates"


def get_secret(name):
    p = SECRETS / name
    return p.read_text().strip() if p.exists() else ""


def load_seen():
    if not STATE_FILE.exists():
        return {"items": []}
    try:
        s = json.loads(STATE_FILE.read_text())
        cutoff = (datetime.now(timezone.utc) - timedelta(hours=DEDUPE_HOURS)).isoformat()
        s["items"] = [i for i in s.get("items", []) if i.get("ts", "") > cutoff]
        return s
    except Exception:
        return {"items": []}


def save_seen(seen):
    STATE_FILE.write_text(json.dumps(seen, indent=2))


def topic_hash(item):
    key = f"{item.get('topic','').lower()}|{','.join(sorted(item.get('tickers', [])))}"
    return hashlib.md5(key.encode()).hexdigest()[:16]


def call_grok():
    api_key = get_secret("xai_api_key")
    if not api_key:
        print("[grok-ct] FATAL: no xai_api_key in secrets")
        sys.exit(1)

    prompt = (
        "Search X for the last 60 minutes of crypto/CT activity. "
        "Surface only ACTIONABLE alpha — items a trader can act on:\n"
        "- Whale on-chain moves >$10M\n"
        "- KOL position calls from credible accounts (>50k followers, track record)\n"
        "- Breaking news affecting BTC/ETH/SOL/major alts\n"
        "- Sudden sentiment shifts or coordinated narratives\n"
        "- Exchange listing/delisting announcements\n"
        "- Regulatory news\n\n"
        "Skip: generic price chatter, low-credibility accounts, repetitive memes, NFT hype.\n\n"
        "Respond with STRICT JSON only, no preamble or markdown:\n"
        '{\n'
        '  "summary": "1-line overall vibe of the last hour",\n'
        '  "items": [\n'
        '    {\n'
        '      "urgency": "high|med|low",\n'
        '      "topic": "short phrase, max 60 chars",\n'
        '      "tickers": ["BTC", "ETH"],\n'
        '      "summary": "2-3 sentences with concrete details",\n'
        '      "source_handle": "@account_or_unknown",\n'
        '      "links": ["https://x.com/..."]\n'
        '    }\n'
        '  ]\n'
        '}\n'
        "Return at most 5 items. If nothing actionable, return items: []."
    )

    body = {
        "model": MODEL,
        "input": prompt,
        "tools": [{"type": "x_search"}],
    }

    text = ""
    try:
        r = requests.post(
            API_URL,
            headers={
                "Authorization": f"Bearer {api_key}",
                "Content-Type": "application/json",
            },
            json=body,
            timeout=180,
        )
        if r.status_code != 200:
            print(f"[grok-ct] API error {r.status_code}: {r.text[:300]}")
            return None
        data = r.json()
        # Extract output_text from the response shape
        for block in data.get("output", []):
            if block.get("type") == "message" or block.get("content"):
                for c in block.get("content", []):
                    if c.get("type") == "output_text":
                        text = c.get("text", "")
                        break
                if text:
                    break
        if not text:
            print(f"[grok-ct] no output_text found in response")
            print(json.dumps(data, indent=2)[:1500])
            return None
        usage = data.get("usage", {})
        print(f"[grok-ct] tokens used: {usage}")
        # Strip markdown if present
        text = text.strip()
        if text.startswith("```"):
            text = text.split("```")[1]
            if text.startswith("json"):
                text = text[4:]
            text = text.rsplit("```", 1)[0].strip()
        return json.loads(text)
    except json.JSONDecodeError as e:
        print(f"[grok-ct] JSON parse failed: {e}")
        print(f"  Raw text (first 500): {text[:500]}")
        return None
    except Exception as e:
        print(f"[grok-ct] Error: {e}")
        return None


def post_to_discord(item):
    webhook = get_secret(WEBHOOK_NAME)
    if not webhook:
        print(f"[grok-ct] ERROR: no {WEBHOOK_NAME}")
        return False

    color = {"high": 0xE74C3C, "med": 0xF39C12, "low": 0x3498DB}.get(item.get("urgency", "low"), 0x95A5A6)
    emoji = {"high": "🚨", "med": "⚡", "low": "📊"}.get(item.get("urgency", "low"), "•")

    fields = []
    if item.get("tickers"):
        fields.append({"name": "Tickers", "value": " ".join(f"`{t}`" for t in item["tickers"][:8]), "inline": True})
    if item.get("source_handle") and item["source_handle"] != "@unknown":
        fields.append({"name": "Source", "value": item["source_handle"], "inline": True})

    embed = {
        "title": f"{emoji} {item.get('topic', 'CT Alpha')[:200]}",
        "description": item.get("summary", "")[:1500],
        "color": color,
        "fields": fields,
        "footer": {"text": f"Grok CT Alpha • {item.get('urgency','?').upper()}"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }
    if item.get("links"):
        embed["url"] = item["links"][0]

    try:
        r = requests.post(webhook, json={"embeds": [embed]}, timeout=10)
        return r.status_code in (200, 204)
    except Exception as e:
        print(f"[grok-ct] Discord post error: {e}")
        return False


def main():
    print(f"[grok-ct] Cycle start {datetime.now(timezone.utc).isoformat()}")
    result = call_grok()
    if not result:
        print("[grok-ct] No result, exiting")
        sys.exit(1)

    items = result.get("items", [])
    print(f"[grok-ct] {len(items)} items returned")
    print(f"  Summary: {result.get('summary','')[:200]}")

    output = {
        "generated_at": datetime.now(timezone.utc).isoformat(),
        "summary": result.get("summary", ""),
        "items": items,
    }
    OUTPUT_FILE.write_text(json.dumps(output, indent=2))

    seen = load_seen()
    seen_hashes = {i.get("hash") for i in seen.get("items", [])}
    posted = 0
    for item in items:
        urgency = item.get("urgency", "low")
        if urgency == "low":
            print(f"  SKIP low: {item.get('topic','')[:60]}")
            continue
        h = topic_hash(item)
        if h in seen_hashes:
            print(f"  DEDUPE: {item.get('topic','')[:60]}")
            continue
        if post_to_discord(item):
            posted += 1
            seen["items"].append({
                "hash": h,
                "topic": item.get("topic", ""),
                "ts": datetime.now(timezone.utc).isoformat(),
            })
            print(f"  ✓ posted [{urgency}]: {item.get('topic','')[:60]}")
        else:
            print(f"  ✗ post FAILED: {item.get('topic','')[:60]}")
        time.sleep(1)

    save_seen(seen)
    print(f"[grok-ct] Posted {posted}/{len(items)}")


if __name__ == "__main__":
    main()
