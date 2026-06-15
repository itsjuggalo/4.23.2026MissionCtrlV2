"""x_search — native Grok x_search on the SuperGrok/X-Premium+ OAuth subscription,
with graceful fallback to the web bridge when no OAuth token is present.

The xAI API-key wallet is credit-dead (403). The only way to bill x_search to the
consumer subscription is the OAuth (loopback-PKCE) path. Mike mints the token ONCE
via `~/bin/grok-sub-login` (browser, ~180s). Hermes stores/refreshes it in
~/.hermes/auth.json; we also accept a flat token at ~/.openclaw/secrets/xai_oauth_token.

`x_sentiment(query)` returns native Grok text when a token works, else None — callers
fall back to their existing Tavily/WebSearch prompt, so /x never goes dark.
"""
from __future__ import annotations

import json
import urllib.error
import urllib.request
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
HERMES_AUTH = Path.home() / ".hermes" / "auth.json"
TOKEN_FILE = SEC / "xai_oauth_token"


def oauth_token() -> str | None:
    """Current xAI OAuth access token, read live from Hermes (which auto-refreshes it).
    Hermes 0.15.x stores it under credential_pool.xai-oauth[0].access_token; older builds
    used providers.xai-oauth. Falls back to a flat secret file. None if never minted."""
    try:
        a = json.loads(HERMES_AUTH.read_text())
        pool = (a.get("credential_pool", {}) or {}).get("xai-oauth") or []
        for c in pool:
            tok = (c or {}).get("access_token")
            if tok:
                return tok.strip()
        x = (a.get("providers", {}) or {}).get("xai-oauth") or {}   # legacy path
        if x.get("access_token"):
            return x["access_token"].strip()
    except Exception:
        pass
    try:
        tok = TOKEN_FILE.read_text().strip()
        return tok or None
    except Exception:
        return None


def _extract(d: dict) -> str | None:
    """Pull text out of an xAI /v1/responses payload (shape-tolerant)."""
    if not isinstance(d, dict):
        return None
    if d.get("output_text"):
        return d["output_text"]
    chunks = []
    for item in d.get("output") or []:
        for c in item.get("content") or []:
            if c.get("type") in ("output_text", "text") and c.get("text"):
                chunks.append(c["text"])
    if chunks:
        return "\n".join(chunks)
    # chat-completions shape, just in case
    try:
        return d["choices"][0]["message"]["content"]
    except Exception:
        return None


def x_sentiment(query: str, model: str = "grok-3", timeout: int = 45) -> str | None:
    """Native Grok x_search read. Returns text, or None on no-token / any error
    (caller should fall back to the web bridge)."""
    tok = oauth_token()
    if not tok:
        return None
    body = {"model": model,
            "input": (f"Summarize trader-relevant X/Twitter activity on {query} in the last 24h: "
                      f"prevailing sentiment (bullish/bearish), notable posts or accounts, and any "
                      f"catalysts. Tight, scannable."),
            "tools": [{"type": "x_search"}]}
    req = urllib.request.Request(
        "https://api.x.ai/v1/responses", data=json.dumps(body).encode(), method="POST",
        headers={"Authorization": "Bearer " + tok, "Content-Type": "application/json",
                 "User-Agent": "mc/1.0"})
    try:
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return _extract(json.loads(r.read()))
    except Exception:
        return None


def status() -> str:
    tok = oauth_token()
    if not tok:
        return "no OAuth token — run ~/bin/grok-sub-login (falls back to web search meanwhile)"
    res = x_sentiment("NVDA", timeout=40)
    return f"OAuth token present; native x_search {'WORKS ✅' if res else 'FAILED (token expired/tier-blocked) — using fallback'}"


if __name__ == "__main__":
    import sys
    if len(sys.argv) > 1:
        q = " ".join(sys.argv[1:])
        out = x_sentiment(q)
        print(out if out else "[no native result — no/invalid OAuth token; caller falls back to web]")
    else:
        print(status())
