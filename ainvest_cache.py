#!/usr/bin/env python3
"""
AInvest cron-cache writer  (Phase-4 of the MissionCtrl block overhaul).

Pulls AInvest-grade data (analyst consensus + Congress/PTR trades) for a
watchlist of liquid tickers via the AInvest MCP gateway, and writes a single
freshness-stamped JSON the Next.js routes read. This is the "cron-cache"
approach Mike picked: a plain HTTP client (no `claude -p` token burn, no
fragile tech.ainvest.com web-gateway reverse-engineering) talking MCP
Streamable-HTTP directly with the operator's Bearer key.

Transport: POST initialize -> get Mcp-Session-Id -> tools/call. Responses are
SSE-framed (`event: message\\ndata: {...}`); we parse the `data:` line, then the
tool payload lives in result.content[0].text as a JSON string.

Output: ~/web/missionctrl/data/ainvest_cache.json  (data/*.json is gitignored)
  { asOf, generatedMs, tickers[], analyst:{TICKER:{...}}, congress:{TICKER:[...]},
    errors:{TICKER:msg} }

Never raises; on a partial/failed run it MERGES over the prior cache so the
routes never lose good data. Run: python3 ~/scripts/ainvest_cache.py
"""
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
from __future__ import annotations

import json
import os
import sys
import time
import urllib.request
import urllib.error
from datetime import datetime, timezone
from pathlib import Path

KEY_PATH = Path.home() / ".openclaw" / "secrets" / "ainvest_api_key.txt"
GATEWAY = os.environ.get("AINVEST_MCP_URL", "https://docsmcp.ainvest.com")
OUT_PATH = Path(os.environ.get(
    "AINVEST_CACHE_PATH",
    str(Path.home() / "web" / "missionctrl" / "data" / "ainvest_cache.json"),
))

# Liquid universe: indices + mega-caps + the popular flow names. Override with
# AINVEST_CACHE_TICKERS="A,B,C". Kept lean (16) — the gateway rate-limits hard
# (~5 calls / 30s), so we pace + back off; merge-over-prior refills throttled
# tickers next run. Cron runs 2x/day, so a partial run is harmless.
DEFAULT_TICKERS = [
    "SPY", "QQQ", "IWM", "NVDA", "TSLA", "AAPL", "MSFT", "AMZN",
    "META", "GOOGL", "AMD", "AVGO", "PLTR", "COIN", "MSTR", "JPM",
]

RATE_SLEEP = float(os.environ.get("AINVEST_RATE_SLEEP", "7"))   # base pace between calls
RATE_BACKOFF = float(os.environ.get("AINVEST_RATE_BACKOFF", "30"))  # wait on a 4014
RATE_RETRIES = int(os.environ.get("AINVEST_RATE_RETRIES", "2"))
MAX_SECONDS = float(os.environ.get("AINVEST_MAX_SECONDS", "600"))  # hard runtime cap


def load_key() -> str:
    return KEY_PATH.read_text().strip()


def _parse_sse_json(raw: str) -> dict | None:
    """Pull the JSON object out of an SSE `data:` frame (or plain JSON body)."""
    raw = raw.strip()
    if not raw:
        return None
    if raw[0] == "{":
        try:
            return json.loads(raw)
        except Exception:
            return None
    payload = None
    for line in raw.splitlines():
        line = line.strip()
        if line.startswith("data:"):
            payload = line[5:].strip()
    if not payload:
        return None
    try:
        return json.loads(payload)
    except Exception:
        return None


class McpClient:
    def __init__(self, url: str, key: str):
        self.url = url
        self.key = key
        self.sid: str | None = None

    def _post(self, method: str, params: dict) -> tuple[int, dict, str]:
        body = json.dumps({"jsonrpc": "2.0", "id": 1, "method": method, "params": params}).encode()
        h = {
            "Authorization": f"Bearer {self.key}",
            "Content-Type": "application/json",
            "Accept": "application/json, text/event-stream",
        }
        if self.sid:
            h["Mcp-Session-Id"] = self.sid
        req = urllib.request.Request(self.url, data=body, headers=h, method="POST")
        try:
            with urllib.request.urlopen(req, timeout=30) as r:
                return r.status, dict(r.headers), r.read().decode("utf-8", "replace")
        except urllib.error.HTTPError as e:
            return e.code, dict(e.headers or {}), (e.read().decode("utf-8", "replace") if e.fp else "")
        except Exception as e:
            return 0, {}, f"EXC {e}"

    def connect(self) -> bool:
        s, hd, _ = self._post("initialize", {
            "protocolVersion": "2024-11-05", "capabilities": {},
            "clientInfo": {"name": "missionctrl-cron", "version": "1"},
        })
        self.sid = hd.get("Mcp-Session-Id") or hd.get("mcp-session-id")
        if s == 200 and self.sid:
            self._post("notifications/initialized", {})  # best-effort
            return True
        return False

    def _raw(self, name: str, args: dict) -> dict | None:
        """One tool call; return the parsed inner payload (content[0].text object)."""
        s, _, raw = self._post("tools/call", {"name": name, "arguments": args})
        if s != 200:
            return None
        env = _parse_sse_json(raw)
        if not isinstance(env, dict):
            return None
        try:
            return json.loads(env["result"]["content"][0]["text"])
        except Exception:
            return None

    def tool(self, name: str, args: dict) -> dict | None:
        """Call a tool, retrying on the gateway's 4014 frequency limit with backoff."""
        for attempt in range(RATE_RETRIES + 1):
            d = self._raw(name, args)
            if isinstance(d, dict) and d.get("status_code") == 4014:
                if attempt < RATE_RETRIES:
                    time.sleep(RATE_BACKOFF)
                    continue
                return d  # exhausted — caller treats as no-data
            return d


def fetch_analyst(c: McpClient, tk: str) -> dict | None:
    d = c.tool("get-analyst-ratings", {"ticker": tk})
    if not isinstance(d, dict) or d.get("status_code") not in (0, None):
        return None
    body = d.get("data") or {}
    ar = body.get("analysts_ratings") or {}
    tp = body.get("target_price") or {}
    if not ar and not tp:
        return None
    return {
        "count": ar.get("count"),
        "buy": ar.get("buy"), "hold": ar.get("hold"), "sell": ar.get("sell"),
        "average_rating": ar.get("average_rating"),
        "target": {
            "count": tp.get("count"), "high": tp.get("high"),
            "average": tp.get("average"), "low": tp.get("low"),
        },
    }


def fetch_congress(c: McpClient, tk: str, size: int = 12) -> list | None:
    d = c.tool("get-ownership-congress", {"ticker": tk, "size": size})
    if not isinstance(d, dict):
        return None
    rows = (((d.get("data") or {}).get("data")) if isinstance(d.get("data"), dict) else None) or []
    out = []
    for r in rows:
        if not isinstance(r, dict):
            continue
        out.append({
            "name": r.get("name"), "party": r.get("party"), "state": r.get("state"),
            "trade_type": r.get("trade_type"), "size": r.get("size"),
            "trade_date": r.get("trade_date"), "filing_date": r.get("filing_date"),
            "reporting_gap": r.get("reporting_gap"),
        })
    return out


def load_prior() -> dict:
    try:
        return json.loads(OUT_PATH.read_text())
    except Exception:
        return {"analyst": {}, "congress": {}}


def main() -> int:
    tickers = os.environ.get("AINVEST_CACHE_TICKERS")
    tickers = [t.strip().upper() for t in tickers.split(",") if t.strip()] if tickers else DEFAULT_TICKERS

    key = load_key()
    c = McpClient(GATEWAY, key)
    if not c.connect():
        print("FATAL: MCP initialize failed (gateway/key).", file=sys.stderr)
        return 2

    prior = load_prior()
    analyst = dict(prior.get("analyst") or {})
    congress = dict(prior.get("congress") or {})
    errors: dict[str, str] = {}
    ok_a = ok_c = 0
    t0 = time.monotonic()

    for tk in tickers:
        if time.monotonic() - t0 > MAX_SECONDS:
            print(f"  [runtime cap {MAX_SECONDS}s hit — remaining tickers keep prior cache]")
            break

        a = fetch_analyst(c, tk)
        if a:
            analyst[tk] = a
            ok_a += 1
        else:
            errors[tk] = errors.get(tk, "") + "analyst;"
        time.sleep(RATE_SLEEP)

        g = fetch_congress(c, tk)
        if g is not None:
            congress[tk] = g            # [] is valid (no trades) — overwrite stale
            ok_c += 1
        else:
            errors[tk] = errors.get(tk, "") + "congress;"
        time.sleep(RATE_SLEEP)
        print(f"  {tk:6} analyst={'ok' if a else '—'} congress={len(g) if g is not None else '—'}")

    now = datetime.now(timezone.utc)
    out = {
        "asOf": now.isoformat(timespec="seconds"),
        "generatedMs": int(now.timestamp() * 1000),
        "source": "ainvest-mcp",
        "tickers": tickers,
        "analyst": analyst,
        "congress": congress,
        "errors": errors,
        "stats": {"analyst_ok": ok_a, "congress_ok": ok_c, "tickers": len(tickers)},
    }
    OUT_PATH.parent.mkdir(parents=True, exist_ok=True)
    tmp = OUT_PATH.with_suffix(".json.tmp")
    tmp.write_text(json.dumps(out, indent=2, default=str))
    tmp.replace(OUT_PATH)
    print(f"\nwrote {OUT_PATH}  analyst_ok={ok_a}/{len(tickers)} congress_ok={ok_c}/{len(tickers)}")
    return 0 if (ok_a or ok_c) else 1


if __name__ == "__main__":
    sys.exit(main())
