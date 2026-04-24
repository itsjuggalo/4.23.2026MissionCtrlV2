#!/usr/bin/env python3
"""
Token Usage Tracker
Wraps every OpenAI call across the system and logs cost to token_usage.json
Import this instead of calling requests directly.

Also provides: daily_report(), monthly_report(), check_budget()
"""

import json
import os
import time
from datetime import datetime, timezone, date
from pathlib import Path

LOG_FILE = Path(__file__).parent.parent / "memory" / "token_usage.json"

# Pricing per 1M tokens (as of 2026) — update if OpenAI changes pricing
PRICING = {
    # GPT-5 family
    "gpt-5":              {"input": 15.00, "output": 60.00},
    "gpt-5-mini":         {"input": 1.00,  "output": 4.00},
    "gpt-5-nano":         {"input": 0.30,  "output": 1.20},
    "gpt-5.4":            {"input": 15.00, "output": 60.00},
    "gpt-5.4-mini":       {"input": 1.00,  "output": 4.00},
    "gpt-5.4-nano":       {"input": 0.30,  "output": 1.20},
    # GPT-4o family
    "gpt-4o":             {"input": 2.50,  "output": 10.00},
    "gpt-4o-mini":        {"input": 0.15,  "output": 0.60},
    "gpt-4.1":            {"input": 2.00,  "output": 8.00},
    "gpt-4.1-mini":       {"input": 0.40,  "output": 1.60},
    "gpt-4.1-nano":       {"input": 0.10,  "output": 0.40},
    # o3/o4 reasoning
    "o3":                 {"input": 10.00, "output": 40.00},
    "o4-mini":            {"input": 1.10,  "output": 4.40},
    "o3-mini":            {"input": 1.10,  "output": 4.40},
    # Legacy
    "gpt-4":              {"input": 30.00, "output": 60.00},
    "gpt-3.5-turbo":      {"input": 0.50,  "output": 1.50},
}

DAILY_BUDGET  = float(os.getenv("OPENAI_DAILY_BUDGET",  "2.00"))   # $ per day
MONTHLY_BUDGET = float(os.getenv("OPENAI_MONTHLY_BUDGET", "30.00")) # $ per month


def _load_log() -> list:
    try:
        if LOG_FILE.exists():
            return json.loads(LOG_FILE.read_text())
    except Exception:
        pass
    return []


def _save_log(entries: list) -> None:
    LOG_FILE.parent.mkdir(parents=True, exist_ok=True)
    LOG_FILE.write_text(json.dumps(entries, indent=2))


def _get_price(model: str) -> dict:
    """Find pricing for model by prefix match."""
    model_lower = model.lower()
    # Exact match first
    if model_lower in PRICING:
        return PRICING[model_lower]
    # Prefix match (longest first)
    for key in sorted(PRICING.keys(), key=len, reverse=True):
        if model_lower.startswith(key):
            return PRICING[key]
    return {"input": 1.00, "output": 4.00}  # fallback


def log_usage(model: str, input_tokens: int, output_tokens: int,
              source: str = "unknown", purpose: str = "") -> dict:
    """Log a single OpenAI API call and return cost info."""
    pricing = _get_price(model)
    input_cost  = (input_tokens  / 1_000_000) * pricing["input"]
    output_cost = (output_tokens / 1_000_000) * pricing["output"]
    total_cost  = round(input_cost + output_cost, 6)

    entry = {
        "ts":           datetime.now(timezone.utc).isoformat(),
        "date":         date.today().isoformat(),
        "model":        model,
        "input_tokens": input_tokens,
        "output_tokens": output_tokens,
        "total_tokens": input_tokens + output_tokens,
        "cost_usd":     total_cost,
        "source":       source,      # which agent/script made the call
        "purpose":      purpose,     # what was it for
    }

    entries = _load_log()
    entries.append(entry)
    # Keep last 10k entries
    if len(entries) > 10000:
        entries = entries[-10000:]
    _save_log(entries)
    return entry


def daily_report(target_date: str | None = None) -> dict:
    """Usage summary for a given date (default: today)."""
    target = target_date or date.today().isoformat()
    entries = [e for e in _load_log() if e.get("date") == target]

    total_cost   = sum(e["cost_usd"] for e in entries)
    total_tokens = sum(e["total_tokens"] for e in entries)
    calls        = len(entries)

    by_source = {}
    for e in entries:
        src = e.get("source", "unknown")
        by_source.setdefault(src, {"calls": 0, "tokens": 0, "cost": 0.0})
        by_source[src]["calls"]  += 1
        by_source[src]["tokens"] += e["total_tokens"]
        by_source[src]["cost"]   = round(by_source[src]["cost"] + e["cost_usd"], 6)

    budget_used_pct = round((total_cost / DAILY_BUDGET) * 100, 1) if DAILY_BUDGET else 0

    return {
        "date":            target,
        "total_cost_usd":  round(total_cost, 4),
        "total_tokens":    total_tokens,
        "calls":           calls,
        "daily_budget":    DAILY_BUDGET,
        "budget_used_pct": budget_used_pct,
        "over_budget":     total_cost > DAILY_BUDGET,
        "by_source":       by_source,
    }


def monthly_report(year_month: str | None = None) -> dict:
    """Usage summary for a given month (default: current month)."""
    prefix = year_month or date.today().isoformat()[:7]
    entries = [e for e in _load_log() if e.get("date", "").startswith(prefix)]

    total_cost   = sum(e["cost_usd"] for e in entries)
    total_tokens = sum(e["total_tokens"] for e in entries)

    by_day = {}
    for e in entries:
        d = e.get("date", "?")
        by_day.setdefault(d, 0.0)
        by_day[d] = round(by_day[d] + e["cost_usd"], 4)

    by_model = {}
    for e in entries:
        m = e.get("model", "?")
        by_model.setdefault(m, {"calls": 0, "cost": 0.0})
        by_model[m]["calls"] += 1
        by_model[m]["cost"]   = round(by_model[m]["cost"] + e["cost_usd"], 4)

    return {
        "month":            prefix,
        "total_cost_usd":   round(total_cost, 4),
        "total_tokens":     total_tokens,
        "monthly_budget":   MONTHLY_BUDGET,
        "over_budget":      total_cost > MONTHLY_BUDGET,
        "budget_used_pct":  round((total_cost / MONTHLY_BUDGET) * 100, 1) if MONTHLY_BUDGET else 0,
        "by_day":           dict(sorted(by_day.items())),
        "by_model":         by_model,
    }


def check_budget() -> tuple[bool, str]:
    """
    Returns (ok, message). Call before expensive operations.
    Returns False if over daily or monthly budget.
    """
    daily = daily_report()
    if daily["over_budget"]:
        return False, f"Daily budget exceeded: ${daily['total_cost_usd']:.4f} / ${DAILY_BUDGET}"

    monthly = monthly_report()
    if monthly["over_budget"]:
        return False, f"Monthly budget exceeded: ${monthly['total_cost_usd']:.4f} / ${MONTHLY_BUDGET}"

    remaining_daily = round(DAILY_BUDGET - daily["total_cost_usd"], 4)
    return True, f"OK — ${daily['total_cost_usd']:.4f} used today, ${remaining_daily:.4f} remaining"


def openai_call(prompt: str, model: str = "gpt-4o-mini", max_tokens: int = 300,
                source: str = "unknown", purpose: str = "",
                system: str | None = None, temperature: float = 0.2) -> str | None:
    """
    Drop-in wrapper for OpenAI calls with automatic token logging and budget check.
    Returns the response text or None if budget exceeded / error.
    """
    import requests

    # Check budget before calling
    ok, msg = check_budget()
    if not ok:
        print(f"[TOKEN_TRACKER] BLOCKED — {msg}")
        return None

    key_path = Path.home() / ".openclaw" / "secrets" / "openai.key"
    try:
        key = key_path.read_text().strip()
    except Exception:
        return None

    messages = []
    if system:
        messages.append({"role": "system", "content": system})
    messages.append({"role": "user", "content": prompt})

    try:
        r = requests.post(
            "https://api.openai.com/v1/chat/completions",
            headers={"Authorization": f"Bearer {key}", "Content-Type": "application/json"},
            json={"model": model, "messages": messages,
                  "max_tokens": max_tokens, "temperature": temperature},
            timeout=20,
        )
        data = r.json()
        content = data["choices"][0]["message"]["content"].strip()
        usage = data.get("usage", {})
        entry = log_usage(
            model=model,
            input_tokens=usage.get("prompt_tokens", 0),
            output_tokens=usage.get("completion_tokens", 0),
            source=source,
            purpose=purpose,
        )
        print(f"[TOKEN_TRACKER] {source} | {model} | ${entry['cost_usd']:.5f} | {entry['total_tokens']} tokens")
        return content
    except Exception as e:
        print(f"[TOKEN_TRACKER] Error in openai_call: {e}")
        return None


if __name__ == "__main__":
    import sys
    if len(sys.argv) > 1 and sys.argv[1] == "report":
        daily = daily_report()
        monthly = monthly_report()
        print(f"\n=== TODAY ({daily['date']}) ===")
        print(f"Cost: ${daily['total_cost_usd']:.4f} / ${daily['daily_budget']} ({daily['budget_used_pct']}% of budget)")
        print(f"Calls: {daily['calls']} | Tokens: {daily['total_tokens']:,}")
        if daily["by_source"]:
            print("By source:")
            for src, d in sorted(daily["by_source"].items(), key=lambda x: -x[1]["cost"]):
                print(f"  {src}: ${d['cost']:.4f} ({d['calls']} calls, {d['tokens']:,} tokens)")
        print(f"\n=== THIS MONTH ({monthly['month']}) ===")
        print(f"Cost: ${monthly['total_cost_usd']:.4f} / ${monthly['monthly_budget']} ({monthly['budget_used_pct']}% of budget)")
        if monthly["by_model"]:
            print("By model:")
            for model, d in sorted(monthly["by_model"].items(), key=lambda x: -x[1]["cost"]):
                print(f"  {model}: ${d['cost']:.4f} ({d['calls']} calls)")
        ok, msg = check_budget()
        print(f"\nBudget status: {'✅' if ok else '🚨'} {msg}")
    else:
        print("Usage: python3 token_tracker.py report")
        ok, msg = check_budget()
        print(f"Budget status: {'✅' if ok else '🚨'} {msg}")
