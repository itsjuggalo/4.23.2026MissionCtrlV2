#!/usr/bin/env python3
"""Smoke-test the new `vertical` field on /api/copilot.

Exercises three paths:
  1. /screen <q>          → slash shortcut sets vertical=screen
  2. body.vertical=charts → explicit body field
  3. /aladdin + body.vertical=screen → agent + vertical orthogonal

For each case the test asserts:
  - the `thread` SSE event carries the expected vertical
  - the X-Vertical response header matches
  - if vertical=screen, a ```screener fenced card appears
"""
import json, re, sys, urllib.request, urllib.error

URL = "http://localhost:3000/api/copilot?stream=1"

CASES = [
    {
        "name": "slash shortcut /screen",
        "body": {
            "message": "/screen FINRA short>50% AND ADV>500K. Pull from alt_signals_top_24h. Skip illiquid.",
            "mode": "copilot",
        },
        "expect_vertical": "screen",
        "expect_card": "screener",
        "expect_agent": None,
    },
    {
        "name": "body.vertical=charts",
        "body": {
            "message": "Give me chart structure on NVDA for the next 2 weeks.",
            "mode": "copilot",
            "vertical": "charts",
        },
        "expect_vertical": "charts",
        "expect_card": "chart",
        "expect_agent": None,
    },
    {
        "name": "orthogonal /aladdin + vertical=screen",
        "body": {
            "message": "/aladdin Rank alt_signals_top_24h by edge.",
            "mode": "copilot",
            "vertical": "screen",
        },
        "expect_vertical": "screen",
        "expect_card": "screener",
        "expect_agent": "signal-filter",
    },
]


def run_one(case):
    print(f"\n========= {case['name']} =========")
    body = json.dumps(case["body"]).encode("utf-8")
    req = urllib.request.Request(
        URL,
        data=body,
        headers={"Content-Type": "application/json", "Accept": "text/event-stream"},
    )

    thread_id, vertical_meta, agent_meta = None, None, None
    deltas, errors, tools = [], [], []
    x_vertical_hdr, x_agent_hdr = "", ""

    try:
        with urllib.request.urlopen(req, timeout=240) as resp:
            x_vertical_hdr = resp.headers.get("X-Vertical", "")
            x_agent_hdr = resp.headers.get("X-Agent", "")
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
                    vertical_meta = ev.get("vertical")
                    agent_meta = ev.get("agent")
                elif t == "delta":
                    deltas.append(ev.get("text", ""))
                elif t == "tool_use":
                    tools.append(ev.get("name") or ev.get("tool") or "?")
                elif t == "error":
                    errors.append(ev.get("message", "(no msg)"))
                elif t == "done":
                    break
    except urllib.error.URLError as e:
        print(f"  FAIL: route unreachable: {e}")
        return False

    assistant = "".join(deltas)
    has_card = bool(re.search(rf"```{re.escape(case['expect_card'])}\b", assistant))

    print(f"  thread        = {thread_id}")
    print(f"  ev.vertical   = {vertical_meta!r}")
    print(f"  hdr.X-Vert    = {x_vertical_hdr!r}")
    print(f"  ev.agent      = {agent_meta!r}")
    print(f"  hdr.X-Agent   = {x_agent_hdr!r}")
    print(f"  tools_used    = {tools}")
    print(f"  has `{case['expect_card']}` card = {has_card}")
    print(f"  response (head): {assistant[:240]!r}")
    if errors:
        print(f"  errors        = {errors}")

    fails = []
    if vertical_meta != case["expect_vertical"]:
        fails.append(f"thread.vertical {vertical_meta!r} != {case['expect_vertical']!r}")
    if x_vertical_hdr != case["expect_vertical"]:
        fails.append(f"X-Vertical {x_vertical_hdr!r} != {case['expect_vertical']!r}")
    if case["expect_agent"] and agent_meta != case["expect_agent"]:
        fails.append(f"thread.agent {agent_meta!r} != {case['expect_agent']!r}")
    if not has_card:
        fails.append(f"missing expected `{case['expect_card']}` card")
    unsafe = [t for t in tools if t in {"Bash", "WebFetch", "Edit", "Write"}]
    if unsafe:
        fails.append(f"unsafe tool(s): {unsafe}")
    if fails:
        for f in fails:
            print(f"  ✗ {f}")
        return False
    print("  ✓ PASS")
    return True


if __name__ == "__main__":
    results = [run_one(c) for c in CASES]
    ok = all(results)
    print("\n==== OVERALL ====")
    print(f"  passed: {sum(results)}/{len(results)}")
    sys.exit(0 if ok else 1)
