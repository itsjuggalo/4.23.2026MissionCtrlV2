#!/usr/bin/env python3
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
"""Round-3 probe: correct namespace pattern.
   GET /gateway/userstore/iwc/userinfo/prompt/share_query/<verb>?<query>

v2 surfaced two facts:
  1. `prompt/share_query/my_list` returns 500 'POST not supported' — the path
     exists, wants GET, and is the user's own prompts.
  2. The real square_list URL takes prompt_type + scene + source + page params.

This pull does:
  A. square_list per prompt_type → up to 10 × 40 = 400 user prompts segmented
     by vertical. Lets us see which verticals have content and confirms the
     taxonomy is server-recognised.
  B. share_query/* verb enumeration (my_list, collect_list, like_list,
     ask_history, recommend, hot, top, search) — find every verb that returns 200.
  C. Alternate scenes (since prompt_competition_square is one scene value).
"""
from __future__ import annotations

import json, pathlib, time, urllib.error, urllib.parse, urllib.request

HOME = pathlib.Path.home()
COOKIE = (HOME / ".openclaw/secrets/ainvest_cookie.txt").read_text().strip()
csrf = next((c.split("=", 1)[1] for c in COOKIE.split(";")
             if c.strip().startswith("csrf_token=")), "")

CAPTURE = HOME / "aime_research" / "captures" / ("cookie-probe-v3-" + time.strftime("%Y%m%d-%H%M%S"))
CAPTURE.mkdir(parents=True, exist_ok=True)

BASE = "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query"
SOURCE = "ths_wencai_international_pc_robot"

PROMPT_TYPES = [
    "All", "analysis", "screen", "charts", "news", "Crypto",
    "educate", "Explanation", "Prediction", "Help", "Wiki",
]
SHARE_QUERY_VERBS = [
    "square_list", "my_list", "collect_list", "like_list", "ask_history",
    "recommend", "hot", "top", "search", "category", "trend", "feed",
]
ALT_SCENES = [
    "prompt_competition_square", "prompt_my_square", "prompt_collect_square",
    "prompt_recommend_square", "prompt_trend_square", "prompt_hot_square",
]

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


def call(url: str) -> tuple[int, str]:
    req = urllib.request.Request(url, headers=base_headers)
    try:
        with urllib.request.urlopen(req, timeout=12) as r:
            return r.status, r.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.read().decode("utf-8", "replace")
    except Exception as e:
        return 0, f"ERR: {e}"


# ============================================================
# A) square_list per prompt_type
# ============================================================
print("=== A) square_list per prompt_type ===")
type_results = {}
for pt in PROMPT_TYPES:
    q = urllib.parse.urlencode({
        "prompt_type": pt, "page": 0, "pageSize": 40,
        "scene": "prompt_competition_square", "source": SOURCE,
    })
    url = f"{BASE}/square_list?{q}"
    status, body = call(url)
    summary = ""
    if status == 200:
        try:
            payload = json.loads(body)
            result = payload.get("result") or []
            summary = f"status_code={payload.get('status_code')} result[{len(result)}]"
            (CAPTURE / f"A_square_{pt}.json").write_text(
                json.dumps(payload, indent=2, ensure_ascii=False), encoding="utf-8")
            type_results[pt] = len(result)
        except Exception as e:
            summary = f"parse-err {e}"
    else:
        summary = body[:140].replace("\n", " ")
    print(f"  prompt_type={pt:14s} → {status} {summary}")
    time.sleep(0.12)

# ============================================================
# B) share_query verb enumeration
# ============================================================
print("\n=== B) share_query verb enumeration ===")
verb_results = {}
for verb in SHARE_QUERY_VERBS:
    q = urllib.parse.urlencode({
        "prompt_type": "All", "page": 0, "pageSize": 5,
        "scene": "prompt_competition_square", "source": SOURCE,
    })
    url = f"{BASE}/{verb}?{q}"
    status, body = call(url)
    summary = ""
    if status == 200:
        try:
            payload = json.loads(body)
            result = payload.get("result") or []
            kind = "list" if isinstance(result, list) else type(result).__name__
            n = len(result) if isinstance(result, (list, dict)) else 0
            summary = f"status_code={payload.get('status_code')} {kind}[{n}]"
            (CAPTURE / f"B_verb_{verb}.json").write_text(
                json.dumps(payload, indent=2, ensure_ascii=False), encoding="utf-8")
            verb_results[verb] = n
        except Exception as e:
            summary = f"parse-err {e}"
    elif status == 500:
        # 500 with "method not supported" still means the path exists
        summary = f"EXISTS (wrong method?): {body[:120]}"
    else:
        summary = body[:120].replace("\n", " ")
    print(f"  share_query/{verb:14s} → {status} {summary}")
    time.sleep(0.12)

# ============================================================
# C) Alternate scenes against square_list
# ============================================================
print("\n=== C) alternate scenes against square_list ===")
scene_results = {}
for sc in ALT_SCENES:
    q = urllib.parse.urlencode({
        "prompt_type": "All", "page": 0, "pageSize": 5,
        "scene": sc, "source": SOURCE,
    })
    url = f"{BASE}/square_list?{q}"
    status, body = call(url)
    summary = ""
    if status == 200:
        try:
            payload = json.loads(body)
            result = payload.get("result") or []
            n = len(result) if isinstance(result, list) else 0
            summary = f"status_code={payload.get('status_code')} list[{n}]"
            (CAPTURE / f"C_scene_{sc}.json").write_text(
                json.dumps(payload, indent=2, ensure_ascii=False), encoding="utf-8")
            scene_results[sc] = n
        except Exception as e:
            summary = f"parse-err {e}"
    else:
        summary = body[:120].replace("\n", " ")
    print(f"  scene={sc:30s} → {status} {summary}")
    time.sleep(0.12)

# ============================================================
# Summary
# ============================================================
total_prompts = sum(type_results.values())
print(f"\n==== RESULT ====")
print(f"  prompt_type coverage: {sum(1 for v in type_results.values() if v) }/{len(PROMPT_TYPES)} non-empty")
print(f"  total prompts pulled (A): {total_prompts}")
print(f"  share_query verbs found:  {len(verb_results)} → {list(verb_results.keys())}")
print(f"  alternate scenes found:   {len(scene_results)} → {list(scene_results.keys())}")
print(f"  capture dir: {CAPTURE}")
