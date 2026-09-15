#!/usr/bin/env python3
"""ainvest_mcp.py — cron-callable client for the keyed AInvest MCP (docsmcp.ainvest.com).

Replaces the dead AIME browser-cookie scrape (~/scripts/aime_client.py, 401 since 2026-07-11)
with the official structured API Mike already holds a key for. Plain stdlib, no Claude session
needed: MCP Streamable-HTTP (JSON-RPC over POST, JSON or SSE replies).

  ainvest_mcp.py tools                          # list tools + arg schemas
  ainvest_mcp.py call get-news-headlines '{"symbol":"NVDA"}'
  from ainvest_mcp import call; call("get-analyst-ratings", {"symbol": "NVDA"})

Key: ~/.openclaw/secrets/ainvest_api_key.txt (never printed, never in argv). Read-only data feed —
nothing here sizes, gates, or sends.
"""
from __future__ import annotations
import json, sys, urllib.request, urllib.error
from pathlib import Path

URL = "https://docsmcp.ainvest.com"
KEY_FILE = Path.home() / ".openclaw/secrets/ainvest_api_key.txt"
_session: dict = {"id": None, "rpc": 0}


def _key() -> str:
    return KEY_FILE.read_text().strip()


def _post(payload: dict, timeout: int = 30) -> dict | None:
    _session["rpc"] += 1
    payload = {"jsonrpc": "2.0", "id": _session["rpc"], **payload}
    hdrs = {"Authorization": f"Bearer {_key()}", "Content-Type": "application/json",
            "Accept": "application/json, text/event-stream"}
    if _session["id"]:
        hdrs["Mcp-Session-Id"] = _session["id"]
    req = urllib.request.Request(URL, data=json.dumps(payload).encode(), headers=hdrs, method="POST")
    with urllib.request.urlopen(req, timeout=timeout) as r:
        sid = r.headers.get("Mcp-Session-Id")
        if sid:
            _session["id"] = sid
        body = r.read().decode("utf-8", "replace")
        ctype = r.headers.get("Content-Type", "")
    if "text/event-stream" in ctype:
        last = None
        for line in body.splitlines():
            if line.startswith("data:"):
                try:
                    last = json.loads(line[5:].strip())
                except json.JSONDecodeError:
                    pass
        return last
    return json.loads(body) if body.strip() else None


def _ensure_init() -> None:
    if _session["id"] or _session.get("init"):
        return
    _post({"method": "initialize", "params": {"protocolVersion": "2025-03-26",
           "capabilities": {}, "clientInfo": {"name": "missionctrl-cron", "version": "1.0"}}})
    _session["init"] = True
    try:
        _post({"method": "notifications/initialized", "params": {}})
    except Exception:  # noqa: BLE001 — notification replies vary by server; not fatal
        pass


def tools() -> list[dict]:
    _ensure_init()
    r = _post({"method": "tools/list", "params": {}}) or {}
    return (r.get("result") or {}).get("tools", [])


def call(name: str, args: dict | None = None, timeout: int = 30):
    """Returns the tool's parsed content: JSON if the text content is JSON, else the raw text."""
    _ensure_init()
    r = _post({"method": "tools/call", "params": {"name": name, "arguments": args or {}}}, timeout) or {}
    if "error" in r:
        raise RuntimeError(f"{name}: {r['error']}")
    content = (r.get("result") or {}).get("content") or []
    texts = [c.get("text", "") for c in content if c.get("type") == "text"]
    out = "\n".join(texts)
    try:
        return json.loads(out)
    except json.JSONDecodeError:
        return out


def main(argv: list[str]) -> int:
    if len(argv) < 2 or argv[1] not in ("tools", "call"):
        print(__doc__); return 2
    try:
        if argv[1] == "tools":
            for t in tools():
                props = ((t.get("inputSchema") or {}).get("properties") or {})
                req = (t.get("inputSchema") or {}).get("required") or []
                print(f"{t['name']}  args={list(props)} required={req}\n    {t.get('description','')[:160]}")
        else:
            name = argv[2]; args = json.loads(argv[3]) if len(argv) > 3 else {}
            res = call(name, args)
            print(json.dumps(res, indent=1)[:6000] if not isinstance(res, str) else res[:6000])
    except urllib.error.HTTPError as e:
        print(f"HTTP {e.code}: {e.read()[:300]!r}", file=sys.stderr); return 1
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv))
