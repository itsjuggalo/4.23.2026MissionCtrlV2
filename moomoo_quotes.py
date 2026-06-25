#!/usr/bin/env python3
"""Moomoo OpenD → MissionCtrl real-time quote bridge.

WHY: Alpaca's free feed is IEX-only (~2-3% of volume). Moomoo/Futu give FULL
real-time Nasdaq (SIP-grade) for free once you sign their non-professional
subscriber agreement. This daemon connects to the locally-running OpenD gateway
(Mike's logged-in Moomoo session) and writes a JSON file that MissionCtrl's
/api/live-quotes overlays ON TOP of Alpaca IEX — so the dashboard shows the
full-Nasdaq price when OpenD is up, and silently falls back to Alpaca IEX when
it isn't. Read-only / display-only. No trade path.

OpenD host:
  - WSL "mirrored" networking  → 127.0.0.1:11111
  - WSL "NAT" networking       → the Windows gateway IP (e.g. 172.17.64.1):11111
  Set MOOMOO_HOST / MOOMOO_PORT to override (defaults 127.0.0.1 / 11111).

Universe = core ETFs/indices + the AI-Themes constituents (data/ainvest-themes.json,
auto-refreshed daily) + optional data/moomoo-watchlist.txt, deduped + capped at
MOOMOO_MAX (default 100, respects free-tier subscription quota).

Run via PM2 (idles harmlessly until OpenD is reachable):
  pm2 start ~/.venv/bin/python --name moomoo-quotes -- /home/itsju/scripts/moomoo_quotes.py
"""
import json, os, time, sys
from pathlib import Path

REPO_DATA = Path("/AIWorkWSL/web/missionctrl/data")
OUT = REPO_DATA / "moomoo-quotes.json"
THEMES = REPO_DATA / "ainvest-themes.json"
WATCHLIST = REPO_DATA / "moomoo-watchlist.txt"

HOST = os.environ.get("MOOMOO_HOST", "127.0.0.1")
PORT = int(os.environ.get("MOOMOO_PORT", "11111"))
MAX_SYMS = int(os.environ.get("MOOMOO_MAX", "100"))
POLL_SEC = int(os.environ.get("MOOMOO_POLL", "5"))

CORE = ["SPY","QQQ","IWM","DIA","VOO","SMH","XLK","XLF","XLE","ARKK",
        "AAPL","MSFT","NVDA","AMZN","GOOGL","META","TSLA","AVGO","AMD","NFLX"]


def to_moomoo(sym):  # NVDA -> US.NVDA  (skip already-prefixed / crypto)
    s = sym.strip().upper()
    if not s or "." in s or "/" in s:
        return None
    return f"US.{s}"


def build_universe():
    syms = list(CORE)
    try:
        d = json.loads(THEMES.read_text())
        for b in d.get("baskets", []):
            syms += [t for t in b.get("tickers", [])]
    except Exception:
        pass
    try:
        syms += [l.strip() for l in WATCHLIST.read_text().splitlines() if l.strip() and not l.startswith("#")]
    except Exception:
        pass
    seen, out = set(), []
    for s in syms:
        m = to_moomoo(s)
        if m and m not in seen:
            seen.add(m); out.append(m)
    return out[:MAX_SYMS]


def write_status(connected, prices, note=""):
    OUT.write_text(json.dumps({
        "source": "moomoo-sip", "host": f"{HOST}:{PORT}",
        "connected": connected, "note": note,
        "asOf": int(time.time() * 1000), "count": len(prices),
        "prices": prices,
    }))


def opend_reachable():
    """Cheap TCP probe so we never spin up the SDK's noisy reconnect thread while
    OpenD is down. Returns True only when something is listening on HOST:PORT."""
    import socket
    try:
        with socket.create_connection((HOST, PORT), timeout=2):
            return True
    except Exception:
        return False


def run_once():
    """One connect→subscribe→poll session. Returns when the link drops."""
    if not opend_reachable():
        write_status(False, {}, f"OpenD not reachable on {HOST}:{PORT} — on Alpaca IEX")
        time.sleep(15)
        return
    from moomoo import OpenQuoteContext, RET_OK, SubType
    codes = build_universe()
    ctx = OpenQuoteContext(host=HOST, port=PORT)
    try:
        # subscribe in chunks so a quota error on one chunk doesn't kill the rest
        live = []
        for i in range(0, len(codes), 50):
            chunk = codes[i:i + 50]
            ret, err = ctx.subscribe(chunk, [SubType.QUOTE], subscribe_push=False)
            if ret == RET_OK:
                live += chunk
            else:
                print(f"[moomoo] subscribe chunk failed ({len(chunk)}): {err}", flush=True)
        if not live:
            write_status(False, {}, "subscribed 0 symbols (quota? US LV1 not enabled?)")
            print("[moomoo] no symbols subscribed — check US LV1 real-time entitlement", flush=True)
            time.sleep(30)
            return
        print(f"[moomoo] subscribed {len(live)}/{len(codes)} symbols on {HOST}:{PORT}", flush=True)
        fails = 0
        while True:
            ret, data = ctx.get_stock_quote(live)
            if ret != RET_OK:
                fails += 1
                print(f"[moomoo] get_stock_quote err: {data}", flush=True)
                if fails > 3:
                    write_status(False, {}, f"quote error: {data}")
                    return
                time.sleep(POLL_SEC); continue
            fails = 0
            prices = {}
            for _, row in data.iterrows():
                code = row.get("code", "")             # 'US.NVDA'
                sym = code.split(".")[-1]
                last = row.get("last_price")
                prev = row.get("prev_close_price") or last
                if last is None:
                    continue
                chg = (last - prev) if prev else 0.0
                prices[sym] = {
                    "price": round(float(last), 4),
                    "change": round(float(chg), 4),
                    "changePct": round(float(chg / prev * 100), 2) if prev else 0.0,
                    "ts": row.get("update_time") or row.get("data_date"),
                }
            write_status(True, prices)
            time.sleep(POLL_SEC)
    finally:
        try: ctx.close()
        except Exception: pass


def main():
    # Write a fallback marker IMMEDIATELY so MC's /api/live-quotes always finds a
    # file and cleanly stays on Alpaca IEX until OpenD actually connects.
    write_status(False, {}, "starting — waiting for OpenD")
    import logging
    logging.getLogger("moomoo").setLevel(logging.ERROR)
    backoff = 5
    while True:
        try:
            run_once()
            backoff = 5
        except Exception as e:
            # OpenD down / not installed / login expired → idle, keep last file's
            # 'connected:false' so MC cleanly falls back to Alpaca IEX.
            write_status(False, {}, f"OpenD unreachable: {e}")
            print(f"[moomoo] OpenD unreachable ({e}); retry in {backoff}s", flush=True)
            time.sleep(backoff)
            backoff = min(backoff * 2, 120)


if __name__ == "__main__":
    main()
