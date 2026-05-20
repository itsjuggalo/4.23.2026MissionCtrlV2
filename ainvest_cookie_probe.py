#!/usr/bin/env python3
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
"""
ainvest_cookie_probe.py
=======================

Probe AInvest's user-gated APIs using a session cookie captured from the
user's logged-in Chrome session.

Read-only. Never sends a chat (would burn the daily Fast/Expert quota).

Cookie source resolution:
  --cookie '...'        explicit cookie header string
  --cookie-file <path>  read cookie string from a file
  --har <path>          extract cookie from the first ainvest.com request in a HAR
  default               read ~/.openclaw/secrets/ainvest_cookie.txt

For each successful 200 response, the body is saved as JSON under
~/aime_research/captures/cookie-probe-<ts>/<slug>.json. A markdown SUMMARY.md
maps the AInvest internal API surface.
"""
from __future__ import annotations

import argparse, json, pathlib, sys, time, urllib.error, urllib.request

HOME = pathlib.Path.home()
DEFAULT_COOKIE_FILE = HOME / ".openclaw" / "secrets" / "ainvest_cookie.txt"
CAPTURE_ROOT = HOME / "aime_research" / "captures"


# ---------- cookie loading ----------

def load_cookie_from_file(path: pathlib.Path) -> str:
    raw = path.read_text(encoding="utf-8").strip()
    if not raw:
        raise SystemExit(f"cookie file empty: {path}")
    # Some browsers paste with `Cookie: ` prefix — strip it.
    if raw.lower().startswith("cookie:"):
        raw = raw.split(":", 1)[1].strip()
    return raw


def load_cookie_from_har(path: pathlib.Path) -> str:
    har = json.loads(path.read_text(encoding="utf-8"))
    entries = har.get("log", {}).get("entries", [])
    for entry in entries:
        req = entry.get("request", {})
        url = req.get("url", "")
        if ".ainvest.com" not in url:
            continue
        for h in req.get("headers", []):
            if h.get("name", "").lower() == "cookie":
                v = h.get("value", "").strip()
                if v:
                    return v
    raise SystemExit(f"no ainvest.com Cookie header found in HAR: {path}")


def resolve_cookie(args) -> str:
    if args.cookie:
        return args.cookie.strip()
    if args.cookie_file:
        return load_cookie_from_file(pathlib.Path(args.cookie_file))
    if args.har:
        return load_cookie_from_har(pathlib.Path(args.har))
    if DEFAULT_COOKIE_FILE.exists():
        return load_cookie_from_file(DEFAULT_COOKIE_FILE)
    raise SystemExit(
        f"No cookie source. Either:\n"
        f"  • create {DEFAULT_COOKIE_FILE}\n"
        f"  • pass --cookie-file <path>\n"
        f"  • pass --har <session.har>\n"
        f"  • pass --cookie '<raw cookie header>'\n\n"
        f"See ~/aime_research/HOW_TO_CAPTURE_COOKIE.md for the 60-second capture flow.")


# ---------- probes ----------

# Config-oracle srcList names. Built from:
#   • Confirmed in bundle: securityConfig, blockConfig, delistedConfig, transferConfig
#   • Identifier survey: shareConfig (28x), temporarilyHiddenConfig (23x),
#     systemConfig (8x), cdnConfig (8x), sidebarConfig (4x), preloadConfig (4x),
#     getOptionSecurityConfig → optionSecurityConfig, nextConfig, propsConfig, storedConfig
#   • Educated guesses for chat verticals (mirror of prompt_type taxonomy).
CONFIG_NAMES = [
    # Confirmed CSV-backed:
    "securityConfig", "blockConfig", "delistedConfig", "transferConfig",
    # High-frequency bundle identifiers:
    "shareConfig", "temporarilyHiddenConfig", "systemConfig", "cdnConfig",
    "sidebarConfig", "preloadConfig", "propsConfig", "storedConfig", "nextConfig",
    "optionSecurityConfig",
    # Vertical / chat candidates:
    "aimeConfig", "chatConfig", "promptTypeConfig", "promptConfig", "promptSquareConfig",
    "skillConfig", "skillHubConfig", "sceneConfig", "verticalConfig", "modelConfig",
    "agentConfig",
    # AInvest paid-feature candidates:
    "magicSignalConfig", "magicPortfolioConfig", "trendSightConfig", "peakSeekerConfig",
    "magicDayTradingConfig", "subscriptionConfig", "pricingConfig", "vipConfig",
    # Vertical chats:
    "dataAgentConfig", "aiScreenerConfig", "aiChartsConfig", "aiNewsConfig",
    "aiStocksConfig", "aiCryptoConfig", "aiEarningsConfig", "aiOptionsConfig",
    "aiResearchConfig", "newsConfig", "researchConfig",
    # i18n / UI:
    "i18nConfig", "translationConfig", "uiConfig", "menuConfig", "navConfig",
    "themeConfig", "layoutConfig",
]

# Gateway endpoints. These ALL returned 404 in the anonymous probe — likely
# because they need a session, not because the paths are wrong. We retry them
# all with the cookie attached, plus add candidates that target the verticals.
GATEWAY_PATHS = [
    # user / auth
    "https://user.ainvest.com/auth/user/v3/info",
    # userinfo namespace (prefix appears in our square_list endpoint that DID work)
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/me",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/profile",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/self",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/subscription/status",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/vip/status",
    # prompts
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/my_list",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/list",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/collect_list",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/prompt/share_my",
    # conversations
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/conversation/list",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/chat/history",
    # watchlist + portfolio
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/watchlist/list",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/portfolio/list",
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/magic_portfolio/list",
    # skill catalogue — true AInvest path is unknown; we try several conventions
    "https://tech.ainvest.com/gateway/userstore/iwc/userinfo/skill/list",
    "https://tech.ainvest.com/gateway/aime/iwc/skill/list",
    "https://tech.ainvest.com/gateway/aime/iwc/skill/catalogue",
    # paid features
    "https://tech.ainvest.com/gateway/aime/iwc/magic_signal/list",
    "https://tech.ainvest.com/gateway/aime/iwc/trend_sight/list",
    "https://tech.ainvest.com/gateway/aime/iwc/peak_seeker/list",
    "https://tech.ainvest.com/gateway/aime/iwc/daily_insight/list",
    "https://tech.ainvest.com/gateway/aime/iwc/fda_tracker/list",
]


def build_headers(cookie: str, extra: dict | None = None) -> dict:
    h = {
        "Accept": "application/json",
        "Accept-Language": "en-US,en;q=0.9",
        "User-Agent": ("Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                       "AppleWebKit/537.36 (KHTML, like Gecko) "
                       "Chrome/130.0.0.0 Safari/537.36"),
        "Origin": "https://www.ainvest.com",
        "Referer": "https://www.ainvest.com/aime/",
        "Cookie": cookie,
    }
    if extra:
        h.update(extra)
    return h


def http_call(url: str, *, method: str = "GET", headers: dict, body: bytes | None = None,
              timeout: float = 12.0) -> tuple[int, str, str]:
    """Return (status, content_type, body_text). Status 0 on connect error."""
    req = urllib.request.Request(url, data=body, headers=headers, method=method)
    try:
        with urllib.request.urlopen(req, timeout=timeout) as r:
            return r.status, r.headers.get("content-type", ""), r.read().decode("utf-8", "replace")
    except urllib.error.HTTPError as e:
        return e.code, e.headers.get("content-type", "") if e.headers else "", \
               e.read().decode("utf-8", "replace")
    except Exception as e:
        return 0, "", f"ERR {type(e).__name__}: {e}"


def probe_config_oracle(cookie: str, capture_dir: pathlib.Path) -> list[dict]:
    """POST the config oracle once per srcList name. Save each non-trivial
    response. Returns a list of summary dicts."""
    url = "https://api.ainvest.com/config/configuration/get"
    headers = build_headers(cookie, {
        "Content-Type": "application/json",
        "x-auth-progid": "7047",
        "x-auth-type": "ths",
        "x-auth-version": "1.0",
    })
    rows = []
    for name in CONFIG_NAMES:
        body = json.dumps({
            "platform": "PC_WEB",
            "platVersion": "1.0.0",
            "appName": "AINVEST",
            "srcList": [{"name": name, "reqVersion": "LATEST", "curVersion": "0"}],
        }).encode("utf-8")
        status, ctype, text = http_call(url, method="POST", headers=headers, body=body)
        row = {"name": name, "status": status, "len": len(text)}
        if status == 200:
            try:
                payload = json.loads(text)
                row["status_code"] = payload.get("status_code")
                data = payload.get("data") or []
                first = data[0] if isinstance(data, list) and data else None
                if first:
                    row["existNewer"] = first.get("existNewer")
                    row["version"] = first.get("version")
                    row["srcAddr"] = first.get("srcAddr")
                fpath = capture_dir / f"config_{name}.json"
                fpath.write_text(json.dumps(payload, indent=2, ensure_ascii=False), encoding="utf-8")
                row["saved"] = fpath.name
            except Exception as e:
                row["parse_error"] = str(e)
        else:
            row["body_head"] = text[:200]
        rows.append(row)
        marker = "✓" if status == 200 and row.get("status_code") == 0 else "·" if status == 200 else "✗"
        print(f"  {marker} {name:30s} → {status} (status_code={row.get('status_code')!r}) "
              f"{('srcAddr=' + (row.get('srcAddr') or '')) if row.get('srcAddr') else ''}")
        time.sleep(0.15)  # be polite
    return rows


def probe_gateway(cookie: str, capture_dir: pathlib.Path) -> list[dict]:
    headers = build_headers(cookie)
    rows = []
    for url in GATEWAY_PATHS:
        status, ctype, text = http_call(url, method="GET", headers=headers)
        row = {"url": url, "status": status, "len": len(text)}
        if status == 200:
            try:
                payload = json.loads(text)
                row["status_code"] = payload.get("status_code")
                row["status_msg"] = payload.get("status_msg")
                result = payload.get("result") or payload.get("data")
                if isinstance(result, list):
                    row["result_kind"] = f"list[{len(result)}]"
                elif isinstance(result, dict):
                    row["result_kind"] = f"dict({len(result)} keys)"
                slug = (url.rsplit("/", 1)[-1] or "root").replace("?", "_q_")
                src = url.split("//", 1)[-1].split("/", 1)[0].replace(".", "_")
                fname = f"gw_{src}_{slug}.json"
                (capture_dir / fname).write_text(
                    json.dumps(payload, indent=2, ensure_ascii=False), encoding="utf-8")
                row["saved"] = fname
            except Exception as e:
                row["parse_error"] = str(e)
        else:
            row["body_head"] = text[:200]
        rows.append(row)
        marker = "✓" if status == 200 else "✗"
        print(f"  {marker} {status:>3}  {url.replace('https://', '')}  "
              f"{'kind=' + row.get('result_kind', '') if row.get('result_kind') else ''}")
        time.sleep(0.1)
    return rows


def harvest_src_addrs(rows: list[dict], capture_dir: pathlib.Path) -> list[dict]:
    """For each config_oracle row that returned a srcAddr (URL to a config blob),
    download it. These are the actual config files."""
    out = []
    for r in rows:
        addr = r.get("srcAddr")
        if not addr or not addr.startswith("http"):
            continue
        print(f"  ↓ harvest {addr}")
        try:
            with urllib.request.urlopen(urllib.request.Request(
                    addr, headers={"User-Agent": "Mozilla/5.0"}), timeout=20) as resp:
                body = resp.read()
                ctype = resp.headers.get("content-type", "")
            ext = ".csv" if "csv" in ctype else ".json" if "json" in ctype else ".bin"
            fname = f"harvest_{r['name']}{ext}"
            (capture_dir / fname).write_bytes(body)
            out.append({"name": r["name"], "addr": addr, "size": len(body), "saved": fname})
        except Exception as e:
            out.append({"name": r["name"], "addr": addr, "error": str(e)})
    return out


# ---------- summary ----------

def write_summary(capture_dir: pathlib.Path, oracle_rows: list[dict], gw_rows: list[dict],
                  harvested: list[dict]) -> None:
    lines = [f"# AInvest cookie-probe results — {time.strftime('%Y-%m-%d %H:%M:%S %Z')}\n",
             f"Capture dir: `{capture_dir}`\n",
             f"\n## Config oracle — `POST api.ainvest.com/config/configuration/get`\n",
             "Names that return `status_code: 0` (valid) are config-oracle keys we can",
             "consume. `srcAddr` is the CDN URL to download the actual config blob.\n",
             "| name | http | status_code | srcAddr | version |",
             "|---|---:|---:|---|---|"]
    for r in sorted(oracle_rows, key=lambda x: (x.get("status") != 200, x.get("status_code") or 999, x["name"])):
        addr = (r.get("srcAddr") or "")[:80]
        lines.append(f"| `{r['name']}` | {r['status']} | "
                     f"{r.get('status_code', '—')} | "
                     f"{('`' + addr + '`') if addr else '—'} | "
                     f"{r.get('version', '—')} |")
    lines += ["\n## Gateway probes — `GET tech.ainvest.com/gateway/...`\n",
              "| status | url | result |",
              "|---:|---|---|"]
    for r in sorted(gw_rows, key=lambda x: (x.get("status") != 200, x["url"])):
        kind = r.get("result_kind") or r.get("status_msg") or r.get("body_head", "")[:60] or ""
        lines.append(f"| {r['status']} | `{r['url']}` | {kind} |")
    if harvested:
        lines += ["\n## Harvested config blobs (from srcAddr URLs)\n",
                  "| name | size | saved |",
                  "|---:|---:|---|"]
        for h in harvested:
            lines.append(f"| `{h['name']}` | {h.get('size', '—')} | `{h.get('saved') or h.get('error', '')}` |")
    (capture_dir / "SUMMARY.md").write_text("\n".join(lines), encoding="utf-8")
    print(f"\nSummary -> {capture_dir / 'SUMMARY.md'}")


# ---------- main ----------

def main(argv: list[str]) -> int:
    ap = argparse.ArgumentParser(description=__doc__)
    ap.add_argument("--cookie", help="Raw Cookie header value (overrides files)")
    ap.add_argument("--cookie-file", help="Path to a file containing the Cookie header value")
    ap.add_argument("--har", help="Path to a HAR. The first ainvest.com Cookie header is used.")
    ap.add_argument("--skip-config", action="store_true", help="Skip the config oracle probe")
    ap.add_argument("--skip-gateway", action="store_true", help="Skip the gateway probes")
    ap.add_argument("--no-harvest", action="store_true",
                    help="Don't download the srcAddr blobs (just record their URLs)")
    args = ap.parse_args(argv)

    cookie = resolve_cookie(args)
    head = cookie[:80].replace("\n", " ")
    print(f"Cookie loaded ({len(cookie)} chars): {head}...\n")

    ts = time.strftime("%Y%m%d-%H%M%S")
    capture = CAPTURE_ROOT / f"cookie-probe-{ts}"
    capture.mkdir(parents=True, exist_ok=True)
    print(f"Capture dir: {capture}\n")

    oracle_rows: list[dict] = []
    gw_rows: list[dict] = []
    harvested: list[dict] = []

    if not args.skip_config:
        print(f"=== Phase 1 — config oracle ({len(CONFIG_NAMES)} names) ===")
        oracle_rows = probe_config_oracle(cookie, capture)

    if not args.skip_gateway:
        print(f"\n=== Phase 2 — gateway endpoints ({len(GATEWAY_PATHS)} paths) ===")
        gw_rows = probe_gateway(cookie, capture)

    if oracle_rows and not args.no_harvest:
        success = [r for r in oracle_rows if r.get("srcAddr")]
        if success:
            print(f"\n=== Phase 3 — harvesting {len(success)} srcAddr blob(s) ===")
            harvested = harvest_src_addrs(success, capture)

    write_summary(capture, oracle_rows, gw_rows, harvested)

    ok_oracle = sum(1 for r in oracle_rows if r.get("status_code") == 0)
    ok_gw = sum(1 for r in gw_rows if r.get("status") == 200)
    print(f"\n==== RESULT ====")
    print(f"  config oracle:  {ok_oracle}/{len(oracle_rows)} valid")
    print(f"  gateway probes: {ok_gw}/{len(gw_rows)} 200-OK")
    print(f"  files saved:    {sum(1 for _ in capture.iterdir())}")
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv[1:]))
