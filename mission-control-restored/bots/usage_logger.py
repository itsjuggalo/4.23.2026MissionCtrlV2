"""
Usage Logger for Mission Control
Import and call log_usage() after every LLM API call to track spend.

Usage:
    from usage_logger import log_usage
    log_usage(source="boba", provider="anthropic", model="claude-sonnet-4-20250514", input_tokens=500, output_tokens=200)
"""

import json
import os
import fcntl
from datetime import datetime, timezone

USAGE_FILE = os.path.expanduser("~/mission-control-restored/data/api_usage.json")

# Cost per 1M tokens (input, output)
PRICING = {
    # Anthropic
    "claude-sonnet-4-20250514": (3.00, 15.00),
    "claude-sonnet-4-6": (3.00, 15.00),
    "claude-haiku-4-5-20251001": (1.00, 5.00),
    "claude-haiku-4-5": (1.00, 5.00),
    # OpenAI
    "gpt-4o-mini": (0.15, 0.60),
    "gpt-4o": (2.50, 10.00),
    # DeepSeek
    "deepseek-chat": (0.27, 1.10),
    "deepseek-reasoner": (0.55, 2.19),
    # xAI / Grok
    "grok-3-mini": (0.30, 0.50),
    "grok-3": (3.00, 15.00),
    # Gemini (free tier)
    "gemini-2.0-flash": (0.0, 0.0),
    "gemini-1.5-flash": (0.0, 0.0),
}


def calculate_cost(model: str, input_tokens: int, output_tokens: int) -> float:
    """Calculate USD cost for a given model and token counts."""
    if model in PRICING:
        input_rate, output_rate = PRICING[model]
    else:
        # Try partial match
        for key, rates in PRICING.items():
            if key in model or model in key:
                input_rate, output_rate = rates
                break
        else:
            # Unknown model, estimate conservatively
            input_rate, output_rate = 1.00, 5.00

    cost = (input_tokens / 1_000_000) * input_rate + (output_tokens / 1_000_000) * output_rate
    return round(cost, 6)


def log_usage(source: str, provider: str, model: str, input_tokens: int, output_tokens: int):
    """
    Log an API usage entry.

    Args:
        source: What made the call (boba, copilot, cron, deepseek-bot, grok-bot, etc)
        provider: API provider (anthropic, openai, deepseek, xai, google)
        model: Model string used
        input_tokens: Number of input/prompt tokens
        output_tokens: Number of output/completion tokens
    """
    cost = calculate_cost(model, input_tokens, output_tokens)

    entry = {
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "source": source,
        "provider": provider,
        "model": model,
        "input_tokens": input_tokens,
        "output_tokens": output_tokens,
        "cost_usd": cost,
    }

    os.makedirs(os.path.dirname(USAGE_FILE), exist_ok=True)

    # File-locked append
    try:
        with open(USAGE_FILE, "r+") as f:
            fcntl.flock(f, fcntl.LOCK_EX)
            try:
                data = json.load(f)
            except (json.JSONDecodeError, ValueError):
                data = []
            data.append(entry)
            f.seek(0)
            f.truncate()
            json.dump(data, f, indent=2)
            fcntl.flock(f, fcntl.LOCK_UN)
    except FileNotFoundError:
        with open(USAGE_FILE, "w") as f:
            fcntl.flock(f, fcntl.LOCK_EX)
            json.dump([entry], f, indent=2)
            fcntl.flock(f, fcntl.LOCK_UN)

    print(f"[usage] {source}/{provider}/{model} — in:{input_tokens} out:{output_tokens} cost:${cost:.4f}")


if __name__ == "__main__":
    # Test entry
    log_usage("test", "anthropic", "claude-sonnet-4-20250514", 1000, 500)
    print("Test entry logged. Check", USAGE_FILE)
