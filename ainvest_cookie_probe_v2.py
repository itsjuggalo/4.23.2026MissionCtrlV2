#!/usr/bin/env python3
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
"""Round-2 cookie probe: try POST + CSRF header for the gateway endpoints
that 404'd in the v1 probe. Also pulls userinfo/share_query/square_list_p0
(known good) and tries variations under the userinfo namespace."""
from __future__ import annotations

import json, pathlib, time, urllib.error, urllib.request

HOME = pathlib.Path.home()
COOKIE = (HOME / ".openclaw/secrets/ainvest_cookie.txt").read_text().strip()

# Parse csrf_token out of the cookie
csrf = ""
for c in COOKIE.split(";"):
    c = c.strip()
    if c.startswith("csrf_token="):
        csrf = c.split("=", 1)[1]
        break

print(f"cookie chars: {len(COOKIE)}")
print(f"csrf_token   : {'(found, ' + str(len(csrf)) + ' chars)' if csrf else '(not found)'}")
print()

CAPTURE = HOME / "aime_research" / "captures" / ("cookie-probe-v2-" + time.strftime("%Y%m%d-%H%M%S"))
CAPTURE.mkdir(parents=True, exist_ok=True)

base_headers = {
    "Accept": "application/json",
    "Accept-Language": "en-US,en;q=0.9",
    "User-Agent": ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                   "AppleWebKit/537.36 (KHTML, like Gecko) "
                   "Chrome/130.0.0.0 Safari/537.36"),
    "Origin": "https://www.ainvest.com",
    "Referer": "https://www.ainvest.com/aime/",
    "Cookie": COOKIE,
}
if csrf:
    base_headers["X-Csrf-Token"] = csrf
    base_headers["X-CSRF-Token"] = csrf

# (method, url, body) tuples. Empty body becomes b"" for POST.
PROBES = [
    # Known-good anonymous endpoint (sanity check the cookie path doesn't break it)
    ("GET", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/square_list_p0?page=1&size=2", None),

    # Userinfo endpoints — try POST instead of GET
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/me", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/profile", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/info", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/get", {}),

    # Prompt — list/my variants with POST
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/my_list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/my_list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/collect_list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/ask_history", {"page": 1, "size": 20}),

    # Conversation / chat history
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/conversation/list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/chat/history", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/conversation/list", {"page": 1, "size": 20}),

    # Watchlist / portfolio
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/watchlist/list", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/portfolio/list", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/portfolio/get", {}),

    # Subscription / VIP / user-level config
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/subscription/status", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/vip/status", {}),
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/usage/quota", {}),

    # Skill catalogue — multiple guesses
    ("POST", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/skill/list", {}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/skill/list", {}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/skill_hub/list", {}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/marketplace/list", {}),

    # Paid feature lists
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/magic_signal/list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/trend_sight/list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/peak_seeker/list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/daily_insight/list", {"page": 1, "size": 20}),
    ("POST", "https://tech.ainvest.com/gateway/aime/iwc/fda_tracker/list", {"page": 1, "size": 20}),
]

rows = []
for method, url, body in PROBES:
    data = json.dumps(body).encode("utf-8") if body is not None else None
    headers = dict(base_headers)
    if data is not None:
        headers["Content-Type"] = "application/json"
    req = urllib.request.Request(url, data=data, headers=headers, method=method)
    try:
        with urllib.request.urlopen(req, timeout=12) as r:
            status = r.status
            body_text = r.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        status = e.code
        body_text = e.read().decode("utf-8", "replace")
    except Exception as e:
        status = 0
        body_text = f"ERR: {e}"

    short = url.replace("https://tech.ainvest.com/gateway/", "g:")
    short = short.replace("https://", "").replace("?page=1&size=2", "?p")
    marker = "✓" if status == 200 else "·" if status == 0 else "✗"
    summary = ""
    if status == 200:
        try:
            payload = json.loads(body_text)
            sc = payload.get("status_code")
            result = payload.get("result") or payload.get("data")
            if isinstance(result, list):
                summary = f"status_code={sc} list[{len(result)}]"
            elif isinstance(result, dict):
                summary = f"status_code={sc} dict({len(result)} keys)"
            else:
                summary = f"status_code={sc} no result"
            # Save
            slug = url.rsplit("/", 1)[-1].split("?")[0]
            (CAPTURE / f"{method}_{slug}.json").write_text(
                json.dumps(payload, indent=2, ensure_ascii=False), encoding="utf-8")
        except Exception as e:
            summary = f"parse-err: {e}"
    else:
        summary = body_text[:120].replace("\n", " ")
    rows.append((marker, status, method, short, summary))
    print(f"  {marker} {status:>3}  {method:<4} {short:<88s} {summary}")
    time.sleep(0.1)

print(f"\ncapture dir: {CAPTURE}")
ok = sum(1 for r in rows if r[0] == "✓")
print(f"==== {ok}/{len(rows)} 200-OK ====")
