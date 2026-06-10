#!/usr/bin/env python3
"""
pw_cookies_import.py — convert browser cookies to Playwright storage_state JSON

Accepts:
  --netscape  cookies.txt in Netscape format (from "Get cookies.txt LOCALLY" extension)
  --header    raw "Cookie: name=val; name2=val2" string
  --domain    target domain (e.g. claytrader.com) to filter when using --netscape

Usage:
  python3 pw_cookies_import.py --netscape /mnt/c/Users/itsju/Downloads/claytrader.txt --out ~/claytrader-scrape/ct_auth.json
  python3 pw_cookies_import.py --header "wordpress_logged_in_xxx=yyy; ct_session=zzz" --domain claytrader.com --out ~/claytrader-scrape/ct_auth.json
"""

import argparse
import json
import sys
import time

def parse_netscape(path: str, domain_filter: str | None = None) -> list[dict]:
    cookies = []
    with open(path) as f:
        for line in f:
            line = line.strip()
            if not line or line.startswith("#") and "HttpOnly" not in line:
                continue
            http_only = line.startswith("#HttpOnly_")
            if http_only:
                line = line[len("#HttpOnly_"):]
            parts = line.split("\t")
            if len(parts) < 7:
                continue
            domain, flag, path_, secure, expires, name, value = parts[:7]
            if domain_filter and domain_filter not in domain:
                continue
            cookies.append({
                "name": name,
                "value": value,
                "domain": domain.lstrip("."),
                "path": path_,
                "expires": int(expires) if expires.isdigit() else -1,
                "httpOnly": http_only,
                "secure": secure.upper() == "TRUE",
                "sameSite": "Lax",
            })
    return cookies


def parse_header(header: str, domain: str) -> list[dict]:
    header = header.removeprefix("Cookie:").strip()
    cookies = []
    for part in header.split(";"):
        part = part.strip()
        if "=" not in part:
            continue
        name, _, value = part.partition("=")
        cookies.append({
            "name": name.strip(),
            "value": value.strip(),
            "domain": domain,
            "path": "/",
            "expires": -1,
            "httpOnly": False,
            "secure": True,
            "sameSite": "Lax",
        })
    return cookies


def build_state(cookies: list[dict]) -> dict:
    return {"cookies": cookies, "origins": []}


def main():
    ap = argparse.ArgumentParser()
    src = ap.add_mutually_exclusive_group(required=True)
    src.add_argument("--netscape", help="Netscape cookies.txt file path")
    src.add_argument("--header", help='Raw Cookie header string')
    ap.add_argument("--domain", default="claytrader.com", help="Domain filter / target domain")
    ap.add_argument("--out", default="/tmp/pw_auth.json", help="Output storage_state JSON path")
    args = ap.parse_args()

    if args.netscape:
        cookies = parse_netscape(args.netscape, args.domain)
    else:
        cookies = parse_header(args.header, args.domain)

    if not cookies:
        print("✗ No cookies found — check your input / domain filter")
        sys.exit(1)

    state = build_state(cookies)
    with open(args.out, "w") as f:
        json.dump(state, f, indent=2)

    print(f"✓ {len(cookies)} cookies → {args.out}")
    for c in cookies:
        print(f"  {c['name']} ({c['domain']})")


if __name__ == "__main__":
    main()
