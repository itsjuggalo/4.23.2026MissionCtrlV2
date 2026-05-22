#!/usr/bin/env python3
"""
AInvest API scraper.

Uses the operator's API key (stashed at ~/.openclaw/secrets/ainvest_api_key.txt)
to walk the AInvest gateway endpoints and dump everything we can grab.

Strategy:
  1. Auth probe — try common header patterns against the known-anonymous
     `square_list` endpoint and see if any of them returns "richer" data
     (different shape, more fields, higher rate limit) than the anon call.
     Pick the winning pattern.
  2. Endpoint walk — for each candidate userstore/aime endpoint, fire with
     the winning auth pattern, dump JSON to disk.
  3. Skill catalog — pull the full /skills.json list (already public), plus
     try to fetch user-specific skill state.
  4. NO chat-send. We don't burn the daily Fast/Expert quota on probing.

Outputs:
  ~/aime_research/scraper/auth_probe.json
  ~/aime_research/scraper/walk_<endpoint-slug>.json
  ~/aime_research/scraper/SUMMARY.md

Run:
  python3 ~/scripts/ainvest_scraper.py
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
from urllib.parse import urlencode

KEY_PATH = Path.home() / ".openclaw" / "secrets" / "ainvest_api_key.txt"
OUT_DIR = Path.home() / "aime_research" / "scraper"
OUT_DIR.mkdir(parents=True, exist_ok=True)

UA = (
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 "
    "(KHTML, like Gecko) Chrome/126.0 Safari/537.36"
)
COMMON_HEADERS = {
    "User-Agent": UA,
    "Accept": "application/json, text/plain, */*",
    "Accept-Language": "en-US,en;q=0.9",
    "Origin": "https://www.ainvest.com",
    "Referer": "https://www.ainvest.com/",
}

SOURCE_PARAM = "ths_wencai_international_pc_robot"


def load_key() -> str:
    if not KEY_PATH.exists():
        print(f"FATAL: key file not found at {KEY_PATH}", file=sys.stderr)
        sys.exit(2)
    return KEY_PATH.read_text().strip()


def http_call(
    url: str,
    *,
    method: str = "GET",
    headers: dict | None = None,
    body: dict | str | None = None,
    timeout: int = 20,
) -> tuple[int, dict, bytes]:
    """Returns (status, response_headers, raw_body). Never raises on HTTP errors."""
    hdrs = dict(COMMON_HEADERS)
    if headers:
        hdrs.update(headers)
    data = None
    if body is not None:
        if isinstance(body, dict):
            data = json.dumps(body).encode("utf-8")
            hdrs.setdefault("Content-Type", "application/json")
        else:
            data = body.encode("utf-8") if isinstance(body, str) else body
    req = urllib.request.Request(url, data=data, headers=hdrs, method=method)
    try:
        with urllib.request.urlopen(req, timeout=timeout) as resp:
            return resp.status, dict(resp.headers), resp.read()
    except urllib.error.HTTPError as e:
        body_bytes = e.read() if e.fp else b""
        return e.code, dict(e.headers or {}), body_bytes
    except Exception as e:
        return 0, {}, f"EXCEPTION: {e}".encode()


def try_parse_json(body: bytes) -> dict | list | None:
    try:
        return json.loads(body.decode("utf-8", errors="replace"))
    except Exception:
        return None


def save_dump(name: str, payload: dict) -> Path:
    safe = name.replace("/", "__").replace("?", "_").strip("_")[:120]
    p = OUT_DIR / f"{safe}.json"
    p.write_text(json.dumps(payload, indent=2, default=str))
    return p


# ----------------------------------------------------------------------
# Phase 1 — auth probe
# ----------------------------------------------------------------------

def auth_probe(key: str) -> dict:
    """
    Hit a known endpoint with each header pattern and compare responses.
    The pattern that delivers a non-anonymous shape wins.
    """
    probe_url = (
        "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/"
        f"square_list?prompt_type=All&page=0&scene=prompt_competition_square&"
        f"source={SOURCE_PARAM}&pageSize=5"
    )

    patterns = [
        ("anon",             {}),
        ("bearer",           {"Authorization": f"Bearer {key}"}),
        ("x-api-key",        {"X-API-Key": key}),
        ("apikey",           {"apikey": key}),
        ("x-auth-token",     {"X-Auth-Token": key}),
        ("authorization-raw",{"Authorization": key}),
        ("token-header",     {"token": key}),
        ("cookie-token",     {"Cookie": f"token={key}"}),
        ("cookie-sess",      {"Cookie": f"sessionid={key}"}),
        ("query-token",      {"_qparam": f"token={key}"}),
        ("query-apikey",     {"_qparam": f"apikey={key}"}),
        ("user-token-hdr",   {"user-token": key}),
        ("hexin-token",      {"hexin-v": key}),
    ]
    probe = []
    for name, hdrs in patterns:
        url = probe_url
        h = {k: v for k, v in hdrs.items() if not k.startswith("_")}
        qparam = hdrs.get("_qparam")
        if qparam:
            url = url + "&" + qparam
        status, resp_hdrs, body = http_call(url, headers=h)
        data = try_parse_json(body)
        # Fingerprint the response
        sig = {
            "pattern": name,
            "status": status,
            "body_len": len(body),
            "is_json": data is not None,
            "top_keys": list(data.keys()) if isinstance(data, dict) else None,
            "result_count": (len(data.get("result", [])) if isinstance(data, dict) and isinstance(data.get("result"), list) else None),
            "status_code": (data.get("status_code") if isinstance(data, dict) else None),
            "status_msg": (data.get("status_msg") if isinstance(data, dict) else None),
            "first_result_keys": (list(data["result"][0].keys()) if isinstance(data, dict) and data.get("result") and isinstance(data["result"][0], dict) else None),
        }
        probe.append(sig)
        print(f"  [{name:24}] status={status} body={len(body)}B json={data is not None} "
              f"result_count={sig['result_count']}")
        time.sleep(0.4)
    return {"probe_url": probe_url, "ts": datetime.now(timezone.utc).isoformat(), "patterns": probe}


def pick_winning_pattern(probe_result: dict) -> tuple[str, dict]:
    """
    Choose the first pattern that returned a richer response than 'anon'.
    'Richer' = larger body OR result_count > anon's OR new top-level keys.
    """
    by_name = {p["pattern"]: p for p in probe_result["patterns"]}
    anon = by_name.get("anon", {})
    anon_len = anon.get("body_len", 0)
    anon_keys = set(anon.get("top_keys") or [])
    anon_count = anon.get("result_count") or 0

    winners = []
    for p in probe_result["patterns"]:
        if p["pattern"] == "anon":
            continue
        if p["status"] != 200:
            continue
        keys = set(p.get("top_keys") or [])
        bigger = p["body_len"] > int(anon_len * 1.10)
        more_keys = bool(keys - anon_keys)
        more_results = (p.get("result_count") or 0) > anon_count
        if bigger or more_keys or more_results:
            winners.append((p["pattern"], bigger, more_keys, more_results, p["body_len"]))
    if winners:
        winners.sort(key=lambda w: (-w[4], w[0]))
        name = winners[0][0]
        hdrs = next((h for n, h in [
            ("bearer", {"Authorization": "Bearer KEYHERE"}),
            ("x-api-key", {"X-API-Key": "KEYHERE"}),
            ("apikey", {"apikey": "KEYHERE"}),
            ("x-auth-token", {"X-Auth-Token": "KEYHERE"}),
            ("authorization-raw", {"Authorization": "KEYHERE"}),
            ("token-header", {"token": "KEYHERE"}),
            ("cookie-token", {"Cookie": "token=KEYHERE"}),
            ("cookie-sess", {"Cookie": "sessionid=KEYHERE"}),
            ("user-token-hdr", {"user-token": "KEYHERE"}),
            ("hexin-token", {"hexin-v": "KEYHERE"}),
        ] if n == name), {})
        return name, hdrs
    return "anon", {}


# ----------------------------------------------------------------------
# Phase 2 — endpoint walk
# ----------------------------------------------------------------------

# Endpoint candidates. Each entry: (slug, url, optional body for POST).
ENDPOINTS: list[tuple[str, str, dict | None]] = [
    # Known anonymous
    ("square_list_p0", f"https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/square_list?prompt_type=All&page=0&scene=prompt_competition_square&source={SOURCE_PARAM}&pageSize=40", None),
    ("square_list_crypto", f"https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_query/square_list?prompt_type=Crypto&page=0&scene=prompt_competition_square&source={SOURCE_PARAM}&pageSize=40", None),

    # Auth-likely
    ("userinfo_me", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/me", None),
    ("userinfo_profile", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/profile", None),
    ("userinfo_self", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/self", None),
    ("user_v3_info", "https://user.ainvest.com/auth/user/v3/info", None),

    # Catalogs
    ("skill_list_userstore", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/skill/list", None),
    ("skill_list_aime", "https://tech.ainvest.com/gateway/aime/iwc/skill/list", None),
    ("prompt_my_list", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/my_list", None),
    ("prompt_list", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/list", None),
    ("prompt_collected", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/collect_list", None),
    ("prompt_share_my", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_my", None),

    # Conversation history
    ("conversation_list", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/conversation/list", None),
    ("chat_history", "https://tech.ainvest.com/gateway/aime/iwc/chat/history", None),

    # Config + feature flags
    ("config_get", "https://api.ainvest.com/config/configuration/get", None),

    # Watchlist / portfolio
    ("watchlist", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/watchlist/list", None),
    ("portfolio", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/portfolio/list", None),
    ("magic_portfolio", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/magic_portfolio/list", None),

    # Magic Signal / Trend Sight / Peak Seeker — the paid features
    ("magic_signal", "https://tech.ainvest.com/gateway/aime/iwc/magic_signal/list", None),
    ("trend_sight", "https://tech.ainvest.com/gateway/aime/iwc/trend_sight/list", None),
    ("peak_seeker", "https://tech.ainvest.com/gateway/aime/iwc/peak_seeker/list", None),

    # Vertical chats (the /aime/data/ sidebar items)
    ("data_agent_meta", "https://tech.ainvest.com/gateway/aime/iwc/data_agent/meta", None),
    ("ai_screener_meta", "https://tech.ainvest.com/gateway/aime/iwc/screener/meta", None),
    ("ai_charts_meta", "https://tech.ainvest.com/gateway/aime/iwc/charts/meta", None),

    # SkillHub COS bucket (already known but capture for completeness)
    ("skills_json_cos", "https://skillhub-1388575217.cos.ap-guangzhou.myqcloud.com/skills.json", None),

    # Daily insight / FDA tracker
    ("daily_insight", "https://tech.ainvest.com/gateway/aime/iwc/daily_insight/list", None),
    ("fda_tracker", "https://tech.ainvest.com/gateway/aime/iwc/fda_tracker/list", None),

    # Subscription state
    ("subscription_status", "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/subscription/status", None),
]


def walk(key: str, header_template: dict[str, str]) -> list[dict]:
    real_headers = {k: v.replace("KEYHERE", key) for k, v in header_template.items()}
    rows = []
    print(f"\n=== Walking {len(ENDPOINTS)} endpoints with pattern: {list(header_template.keys()) or 'anonymous'}")
    for slug, url, body in ENDPOINTS:
        method = "POST" if body is not None else "GET"
        status, resp_hdrs, raw = http_call(url, method=method, headers=real_headers, body=body)
        data = try_parse_json(raw)
        record = {
            "slug": slug,
            "url": url,
            "method": method,
            "status": status,
            "body_len": len(raw),
            "is_json": data is not None,
            "top_keys": list(data.keys()) if isinstance(data, dict) else None,
            "status_code": (data.get("status_code") if isinstance(data, dict) else None),
            "status_msg": (data.get("status_msg") if isinstance(data, dict) else None),
            "result_preview": None,
        }
        if isinstance(data, dict):
            for candidate in ("result", "data", "list", "items"):
                v = data.get(candidate)
                if isinstance(v, list) and v:
                    record["result_preview"] = {
                        "count": len(v),
                        "first_item_keys": list(v[0].keys()) if isinstance(v[0], dict) else None,
                    }
                    break
        rows.append(record)
        # Save full payload if interesting (200 + json + has data)
        if status == 200 and data is not None:
            save_dump(f"walk_{slug}", {"url": url, "method": method, "data": data})
        elif status == 200:
            save_dump(f"walk_{slug}", {"url": url, "method": method, "raw": raw.decode("utf-8", errors="replace")[:4000]})
        status_indicator = "OK " if status == 200 else "ERR" if status >= 400 else "NEW"
        preview = ""
        if record["result_preview"]:
            preview = f" → {record['result_preview']['count']} items, keys={record['result_preview']['first_item_keys'][:6] if record['result_preview']['first_item_keys'] else None}"
        elif data and isinstance(data, dict) and data.get("status_msg") and data.get("status_msg") != "OK":
            preview = f" → '{data['status_msg'][:60]}'"
        print(f"  [{status_indicator}] {status:>3} {slug:32} {url[:80]}{preview}")
        time.sleep(0.5)
    return rows


# ----------------------------------------------------------------------
# Phase 3 — summary
# ----------------------------------------------------------------------

def write_summary(probe: dict, winning_pattern: str, walk_rows: list[dict]) -> Path:
    lines = []
    lines.append(f"# AInvest API Scraper Run — {datetime.now(timezone.utc).isoformat(timespec='seconds')}")
    lines.append("")
    lines.append("## Auth probe")
    lines.append("")
    lines.append("| Pattern | Status | Body | result_count | top_keys |")
    lines.append("|---|---:|---:|---:|---|")
    for p in probe["patterns"]:
        lines.append(f"| {p['pattern']} | {p['status']} | {p['body_len']} | {p.get('result_count') or '—'} | {p.get('top_keys') or '—'} |")
    lines.append("")
    lines.append(f"**Winning pattern:** `{winning_pattern}`")
    lines.append("")
    lines.append("## Endpoint walk")
    lines.append("")
    lines.append("| Status | Endpoint | URL | Preview |")
    lines.append("|---:|---|---|---|")
    for r in walk_rows:
        prev = ""
        if r["result_preview"]:
            prev = f"{r['result_preview']['count']} items"
        elif r["status_msg"] and r["status_msg"] != "OK":
            prev = r["status_msg"][:60]
        lines.append(f"| {r['status']} | `{r['slug']}` | `{r['url'][:80]}` | {prev} |")
    lines.append("")
    lines.append("## Files written")
    lines.append("")
    for f in sorted(OUT_DIR.glob("*.json")):
        lines.append(f"- `{f}`")

    summary_path = OUT_DIR / "SUMMARY.md"
    summary_path.write_text("\n".join(lines))
    return summary_path


def main() -> int:
    key = load_key()
    print(f"Key loaded ({len(key)} chars). Output dir: {OUT_DIR}")
    print()
    print("=== Phase 1 — auth probe ===")
    probe = auth_probe(key)
    save_dump("auth_probe", probe)
    pattern_name, header_template = pick_winning_pattern(probe)
    print(f"\n→ Winning auth pattern: '{pattern_name}'")
    print(f"  Header template: {header_template}")

    print()
    print("=== Phase 2 — endpoint walk ===")
    walk_rows = walk(key, header_template)
    save_dump("walk_summary", {"pattern": pattern_name, "endpoints": walk_rows})

    summary_path = write_summary(probe, pattern_name, walk_rows)
    print(f"\nSummary written: {summary_path}")
    print()
    print("--- Top successes ---")
    for r in walk_rows:
        if r["status"] == 200 and r["result_preview"]:
            print(f"  ✓ {r['slug']}: {r['result_preview']['count']} items")
    return 0


if __name__ == "__main__":
    sys.exit(main())
