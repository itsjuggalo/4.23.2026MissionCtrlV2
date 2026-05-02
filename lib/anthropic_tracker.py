"""
anthropic_tracker — drop-in wrapper that logs every Anthropic API call.

Usage in any script:
    from lib.anthropic_tracker import call_anthropic
    response = call_anthropic(model, messages, system, max_tokens, caller="boba_decision_cycle")

Logs to ~/.openclaw/data/anthropic_usage/YYYY-MM-DD.jsonl
Each line: {ts, caller, model, input_tokens, cache_creation_tokens, cache_read_tokens,
            output_tokens, cost_usd, duration_ms, success}

Pricing (May 2026, per million tokens):
  Sonnet 4.6:  $3 / $15
  Opus 4.7:    $5 / $25
  Opus 4.6:    $5 / $25
  Haiku 4.5:   $1 / $5
  Cache hit:   10% of input cost
  Cache write 5min: 1.25x input cost
  Cache write 1hr:  2x input cost
"""
import json
import time
import requests
from datetime import datetime, timezone, timedelta
from pathlib import Path

DATA_DIR = Path.home() / ".openclaw" / "data" / "anthropic_usage"
DATA_DIR.mkdir(parents=True, exist_ok=True)

# Pricing per million tokens [input, output]
PRICING = {
    "claude-sonnet-4-5":     [3.00, 15.00],
    "claude-sonnet-4-6":     [3.00, 15.00],
    "claude-sonnet-4-6-20250929": [3.00, 15.00],
    "claude-3-5-sonnet-20241022": [3.00, 15.00],
    "claude-3-5-sonnet-latest":   [3.00, 15.00],
    "claude-opus-4-7":       [5.00, 25.00],
    "claude-opus-4-6":       [5.00, 25.00],
    "claude-haiku-4-5-20251001": [1.00, 5.00],
    "claude-3-5-haiku-latest":   [0.80, 4.00],
}

def _et_now():
    return datetime.now(timezone.utc) + timedelta(hours=-4)

def _today_str():
    return _et_now().strftime("%Y-%m-%d")

def _log_path():
    return DATA_DIR / f"{_today_str()}.jsonl"

def _compute_cost(model, in_tok, out_tok, cache_create, cache_read):
    """Compute USD cost given token counts. Cache hits are 10% of input price.
    Cache writes default to 5-min (1.25x input)."""
    if model not in PRICING:
        # Unknown model — estimate at Sonnet rate
        in_rate, out_rate = 3.00, 15.00
    else:
        in_rate, out_rate = PRICING[model]
    # Standard input
    in_cost = (in_tok / 1_000_000) * in_rate
    # Cache writes (5-min default, 1.25x input)
    cache_write_cost = (cache_create / 1_000_000) * in_rate * 1.25
    # Cache reads (10% of input price)
    cache_read_cost = (cache_read / 1_000_000) * in_rate * 0.10
    # Output
    out_cost = (out_tok / 1_000_000) * out_rate
    return round(in_cost + cache_write_cost + cache_read_cost + out_cost, 6)

def log_call(caller, model, response_data, duration_ms, success=True, error=None):
    """Append a single call entry to today's JSONL log."""
    usage = (response_data or {}).get("usage", {}) if response_data else {}
    in_tok = usage.get("input_tokens", 0)
    out_tok = usage.get("output_tokens", 0)
    cache_create = usage.get("cache_creation_input_tokens", 0)
    cache_read = usage.get("cache_read_input_tokens", 0)
    cost = _compute_cost(model, in_tok, out_tok, cache_create, cache_read)
    entry = {
        "ts": datetime.now(timezone.utc).isoformat(),
        "caller": caller,
        "model": model,
        "input_tokens": in_tok,
        "cache_creation_tokens": cache_create,
        "cache_read_tokens": cache_read,
        "output_tokens": out_tok,
        "cost_usd": cost,
        "duration_ms": duration_ms,
        "success": success,
    }
    if error:
        entry["error"] = str(error)[:300]
    try:
        with _log_path().open("a") as f:
            f.write(json.dumps(entry) + "\n")
    except Exception:
        pass
    return entry

def call_anthropic(model, messages, system=None, max_tokens=4096,
                   caller="unknown", api_key=None, **kwargs):
    """Wrapped Anthropic API call. Returns the parsed response dict.
    Auto-logs token usage and cost.
    Optional kwargs passed through (e.g. tools, temperature).
    """
    if api_key is None:
        try:
            api_key = (Path.home() / ".openclaw" / "secrets" / "anthropic-api-key").read_text().strip()
        except Exception:
            api_key = None
    body = {"model": model, "messages": messages, "max_tokens": max_tokens}
    if system:
        body["system"] = system
    body.update(kwargs)
    headers = {
        "x-api-key": api_key or "",
        "anthropic-version": "2023-06-01",
        "content-type": "application/json",
    }
    t0 = time.time()
    try:
        r = requests.post("https://api.anthropic.com/v1/messages",
                          headers=headers, json=body, timeout=120)
        dur_ms = int((time.time() - t0) * 1000)
        if r.status_code == 200:
            data = r.json()
            log_call(caller, model, data, dur_ms, success=True)
            return data
        else:
            log_call(caller, model, None, dur_ms, success=False,
                     error=f"HTTP {r.status_code}: {r.text[:200]}")
            return {"error": r.text, "status": r.status_code}
    except Exception as e:
        dur_ms = int((time.time() - t0) * 1000)
        log_call(caller, model, None, dur_ms, success=False, error=e)
        return {"error": str(e)}
