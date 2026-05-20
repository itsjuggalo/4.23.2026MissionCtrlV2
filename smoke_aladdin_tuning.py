#!/usr/bin/env python3
"""Smoke-test the two tuning fixes on the live /api/copilot endpoint.

SSE event names per route.ts (line 193):
  thread | delta | tool_use | tool_result | status | done | error
"""
import json, re, sys, urllib.request, urllib.error

URL = "http://localhost:3000/api/copilot?stream=1"
QUERY = (
    "/aladdin scan alt_signals_top_24h. "
    "Pick the single highest-conviction US equity setup (skip illiquid SPACs/warrants). "
    "Give a 2-sentence verdict, THEN emit a trade-frame JSON card with realistic entry/stop/target "
    "relative to the signal. Be tight."
)

body = json.dumps({"message": QUERY, "mode": "copilot"}).encode("utf-8")
req = urllib.request.Request(
    URL, data=body, headers={"Content-Type": "application/json", "Accept": "text/event-stream"}
)

print(f"POST {URL}")
print(f"query: {QUERY[:90]}...\n")

tools_used = []
agent_slug = None
thread_id = None
deltas = []
errors = []

try:
    with urllib.request.urlopen(req, timeout=240) as resp:
        for raw in resp:
            line = raw.decode("utf-8", "replace").rstrip("\n").rstrip("\r")
            if not line.startswith("data:"):
                continue
            payload = line[5:].strip()
            if not payload:
                continue
            try:
                ev = json.loads(payload)
            except json.JSONDecodeError:
                continue
            t = ev.get("type")
            if t == "thread":
                thread_id = ev.get("thread_id") or thread_id
                agent_slug = ev.get("agent") or agent_slug
            elif t == "delta":
                deltas.append(ev.get("text", ""))
            elif t == "tool_use":
                tools_used.append(ev.get("name") or ev.get("tool") or "?")
            elif t == "error":
                errors.append(ev.get("message", "(no msg)"))
            elif t == "done":
                break
except urllib.error.URLError as e:
    print(f"FAIL: could not reach copilot route: {e}")
    sys.exit(2)

assistant = "".join(deltas)

print(f"[thread] id    = {thread_id}")
print(f"[thread] agent = {agent_slug}")
print(f"[tools]        = {tools_used}")
if errors:
    print(f"[errors]       = {errors}")
print()
print("=== assistant response (first 2000 chars) ===")
print(assistant[:2000])
print("=== end ===\n")

unsafe_tools = [t for t in tools_used if t in {"Bash", "WebFetch", "Edit", "Write", "NotebookEdit"}]
print(f"unsafe tool usage: {unsafe_tools}")

match = re.search(r"```trade-frame\s*\n(.+?)\n```", assistant, re.S)
card = None
if match:
    try:
        card = json.loads(match.group(1).strip())
    except json.JSONDecodeError as e:
        print(f"trade-frame card: INVALID JSON ({e})")

if card is None:
    print("trade-frame card: NOT EMITTED (acceptable — discipline rule allows skip)")
else:
    print(f"trade-frame card: {json.dumps(card, indent=2)}")
    has_numeric_levels = any(card.get(f) not in (None, 0) for f in ("entry", "stop", "target"))
    rationale = (card.get("rationale") or "").lower()
    if has_numeric_levels:
        verified = any(p in rationale for p in ("price reference needed", "verify quote", "unverified", "live quote"))
        if verified:
            print("  ✓ has numeric levels with verification caveat")
        else:
            print("  ✗ FAIL: numeric levels without verification caveat (invented prices)")
    else:
        print("  ✓ nulls present — price discipline respected")

print()
print("==== SMOKE-TEST RESULT ====")
fails = []
if not deltas and not card:
    fails.append("empty response — route may have errored silently")
if unsafe_tools:
    fails.append(f"unsafe tool(s) leaked: {unsafe_tools}")
if card and any(card.get(f) not in (None, 0) for f in ("entry", "stop", "target")):
    r = (card.get("rationale") or "").lower()
    if not any(p in r for p in ("price reference needed", "verify quote", "unverified", "live quote")):
        fails.append("trade-frame card has invented prices without verification caveat")
if fails:
    print("FAIL")
    for f in fails:
        print(f"  - {f}")
    sys.exit(1)
print("PASS")
