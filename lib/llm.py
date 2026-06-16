"""Multi-provider LLM caller with a fallback chain, for the paper decision cycles.

Returns the shape the cycles expect: {"ok": True, "response": <parsed dict>, "usage": {},
"model_used": <name>} on success, or {"error": "...", "model_used": None} if every provider
in the chain failed. Each provider reads its own key from ~/.openclaw/secrets (or env).

Provider policy (Mike's rule): prefer SUBSCRIPTION/OAuth/CLI over pay-per-token API billing.
  claude_cli — claude.ai subscription via the CLI (free, no API credits). Boba primary.
  grok_oauth — Grok on the SuperGrok/X-Premium+ OAuth subscription (NOT the dead API key). Jazzy primary.
  deepseek   — api.deepseek.com (cheap). SECONDARY backup only.
  gemini/openai — pay-per-token API billing; available but NOT in the default chains (avoid).
"""
from __future__ import annotations

import json
import os
import subprocess
import urllib.error
import urllib.request
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
CLAUDE_BIN = str(Path.home() / ".local/bin/claude")   # stable symlink → current version


def _read(*names):
    for n in names:
        p = SEC / n
        if p.exists():
            v = p.read_text().strip()
            if v:
                return v
    for n in names:                       # env fallback (UPPER_SNAKE of the name)
        v = os.environ.get(n.upper().replace(".", "_").replace("-", "_"))
        if v:
            return v
    return None


def _extract_json(text: str) -> dict:
    """Parse the model's JSON out of its reply (tolerates ```json fences / leading prose)."""
    t = (text or "").strip()
    if t.startswith("```"):
        t = t.split("\n", 1)[1] if "\n" in t else t[3:]
        t = t.strip()
        if t.startswith("json"):
            t = t[4:].strip()
    i = t.find("{")
    if i > 0:
        t = t[i:]
    parsed, _ = json.JSONDecoder().raw_decode(t)
    return parsed


def _claude_cli(prompt: str, timeout: int = 240):
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    r = subprocess.run(
        [CLAUDE_BIN, "-p", prompt, "--model", "sonnet", "--output-format", "json"],
        capture_output=True, text=True, timeout=timeout, env=env, cwd=str(Path.home()))
    if r.returncode != 0:
        raise RuntimeError(f"claude cli exit {r.returncode}: {r.stderr.strip()[:200]}")
    return (json.loads(r.stdout).get("result") or ""), {}


def _post(url, headers, body, timeout):
    req = urllib.request.Request(url, data=json.dumps(body).encode(), method="POST", headers=headers)
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.loads(r.read())


def _openai(prompt, timeout=90):
    key = _read("openai.key", "openai_api_key", "openai-api-key.txt")
    if not key:
        raise RuntimeError("no openai key")
    d = _post("https://api.openai.com/v1/chat/completions",
              {"Authorization": f"Bearer {key}", "Content-Type": "application/json"},
              {"model": "gpt-4o-mini", "max_tokens": 2000,
               "messages": [{"role": "user", "content": prompt}]}, timeout)
    return d["choices"][0]["message"]["content"], d.get("usage", {})


def _gemini(prompt, timeout=90):
    key = _read("gemini.key", "gemini_api_key", "gemini-api-key.txt")
    if not key:
        raise RuntimeError("no gemini key")
    # gemini-2.5-flash: the free tier on this key has limit:0 for 2.0-flash; 2.5-flash works.
    d = _post(f"https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key={key}",
              {"content-type": "application/json"},
              {"contents": [{"parts": [{"text": prompt}]}]}, timeout)
    return d["candidates"][0]["content"]["parts"][0]["text"], {}


def _claude_oauth(prompt, timeout=60):
    """Claude on the claude.ai subscription via its OAuth token, called DIRECTLY against
    the Anthropic API (no Node CLI cold-start = much faster). Bills the sub, not API credits.
    Note: shares the subscription rate-limit with interactive Claude Code use → may 429 under
    load, in which case the caller's next provider (deepseek) takes over instantly."""
    d = json.loads((Path.home() / ".claude" / ".credentials.json").read_text())
    tok = (d.get("claudeAiOauth") or {}).get("accessToken")
    if not tok:
        raise RuntimeError("no claude oauth token")
    r = _post("https://api.anthropic.com/v1/messages",
              {"Authorization": "Bearer " + tok, "anthropic-version": "2023-06-01",
               "anthropic-beta": "oauth-2025-04-20", "content-type": "application/json"},
              {"model": "claude-sonnet-4-5", "max_tokens": 2000,
               "system": "You are Claude Code, Anthropic's official CLI for Claude.",
               "messages": [{"role": "user", "content": prompt}]}, timeout)
    return r["content"][0]["text"], r.get("usage", {})


def _grok_oauth(prompt, timeout=90):
    """Grok on the SuperGrok/X-Premium+ OAuth subscription (bills the sub, not API credits).
    Token read live from Hermes (auto-refreshed) via lib.x_search."""
    from lib.x_search import oauth_token
    tok = oauth_token()
    if not tok:
        raise RuntimeError("no grok oauth token")
    d = _post("https://api.x.ai/v1/chat/completions",
              {"Authorization": f"Bearer {tok}", "Content-Type": "application/json"},
              {"model": "grok-3", "max_tokens": 2000,
               "messages": [{"role": "user", "content": prompt}]}, timeout)
    return d["choices"][0]["message"]["content"], d.get("usage", {})


def _codex_bin():
    import shutil, glob
    b = shutil.which("codex")
    if b:
        return b
    for g in sorted(glob.glob(str(Path.home() / ".nvm/versions/node/*/bin/codex"))):
        return g
    return "codex"


def _codex_cli(prompt, timeout=150):
    """OpenAI GPT on the ChatGPT subscription via the Codex CLI (OAuth in ~/.codex/auth.json,
    NO API key → bills the sub, not API credits — the OpenAI peer of _claude_cli). Cold-start
    is slow (~30s). Reads only the final assistant message via `-o`."""
    import tempfile
    env = {k: v for k, v in os.environ.items()
           if k not in ("OPENAI_API_KEY", "ANTHROPIC_API_KEY")}
    fd, out_path = tempfile.mkstemp(suffix=".txt")
    os.close(fd)
    try:
        r = subprocess.run(
            [_codex_bin(), "exec", "--skip-git-repo-check", "-s", "read-only",
             "-o", out_path, prompt],
            capture_output=True, text=True, timeout=timeout, env=env,
            stdin=subprocess.DEVNULL, cwd=str(Path.home()))
        msg = Path(out_path).read_text().strip()
        if not msg:
            raise RuntimeError(f"codex empty (exit {r.returncode}): {r.stderr.strip()[:200]}")
        return msg, {}
    finally:
        try:
            os.unlink(out_path)
        except OSError:
            pass


def _deepseek(prompt, timeout=120):
    key = _read("deepseek_api_key", "deepseek.key")
    if not key:
        raise RuntimeError("no deepseek key")
    d = _post("https://api.deepseek.com/chat/completions",
              {"Authorization": f"Bearer {key}", "Content-Type": "application/json"},
              {"model": "deepseek-chat", "max_tokens": 2000,
               "messages": [{"role": "user", "content": prompt}]}, timeout)
    return d["choices"][0]["message"]["content"], d.get("usage", {})


_PROVIDERS = {"claude_oauth": _claude_oauth, "claude_cli": _claude_cli, "grok_oauth": _grok_oauth,
              "codex_cli": _codex_cli, "openai": _openai, "gemini": _gemini, "deepseek": _deepseek}


def call_llm_text(prompt: str, providers):
    """Like call_llm but returns RAW assistant text (no JSON extraction) for conversational
    personas. Returns the first provider's non-empty text, or None if every provider fails."""
    errors = []
    for name in providers:
        fn = _PROVIDERS.get(name)
        if not fn:
            errors.append(f"{name}: unknown provider")
            continue
        try:
            text, _usage = fn(prompt)
            if text and text.strip():
                return text.strip()
        except Exception as e:  # noqa: BLE001
            errors.append(f"{name}: {str(e)[:140]}")
            continue
    return None


def call_llm(prompt: str, providers):
    """Try each provider in order; first that returns parseable JSON wins."""
    errors = []
    for name in providers:
        fn = _PROVIDERS.get(name)
        if not fn:
            errors.append(f"{name}: unknown provider")
            continue
        try:
            text, usage = fn(prompt)
            return {"ok": True, "response": _extract_json(text), "usage": usage, "model_used": name}
        except Exception as e:  # noqa: BLE001
            errors.append(f"{name}: {str(e)[:140]}")
            continue
    return {"error": "all providers failed — " + " | ".join(errors), "model_used": None}
