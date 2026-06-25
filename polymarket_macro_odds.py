#!/usr/bin/env python3
"""Polymarket macro/event odds -> tight ADHD line for the trading Telegram.

FREE official gamma API (no key, no RapidAPI quota). Pulls the highest-volume
prediction markets relevant to the trading operation (Fed/rates/macro + crypto +
big-tech + market-moving geopolitics), shows the LEADING outcome + implied
probability for each, ranked by 24h volume. Read-only context — never trades.
"""
import argparse
import html
import json
import os
import sys
import urllib.request

GAMMA = "https://gamma-api.polymarket.com/events"
UA = "Mozilla/5.0 (MissionControl PolymarketBrief)"

# Tags that map to operation-relevant markets on Polymarket. (Crypto + geopolitics
# tags dropped on purpose — crypto = price-ladder/"up or down" noise; geopolitics =
# election/leadership markets that don't move an equities/options desk. Market-moving
# geopolitics like oil/Hormuz/tariffs come through `economy` + the keyword sweep.)
TAGS = ["economy"]
# Extra keyword sweep over a broad volume-sorted pull (catches market-moving
# events not tagged economy/geopolitics).
KW = ["fed ", "rate cut", "rate hike", "interest rate", "cpi", "ppi", "inflat",
      "recess", "gdp", "jobless", "nonfarm", "unemploy", "shutdown", "debt ceiling",
      "tariff", "powell", "treasury", "s&p", "nasdaq", "oil price", "opec"]
# Markets we DON'T want cluttering a trading brief: sports/entertainment noise,
# plus crypto "price ladder" markets (what-price/above-X buckets) that collapse
# to trivially-true thresholds and carry ~no information.
DROP = ["world cup", "super bowl", "nba", "nfl", "ufc", "grammy", "oscar",
        "album", "movie", "rotten tomatoes", "gta", "fifa", "premier league",
        "ballon", "wimbledon", "olympic",
        "what price", "hit in", "above $", "above ___", "price on", "reach $",
        "dip to", "close above", "close below", "largest company",
        "up or down", "satoshi", "laso", "commitments", "airdrop", "memecoin",
        " pub ", "all-time high", "ath in",
        # political/leadership noise (not desk-actionable)
        "prime minister", "next leader", "out of power", "withdraw", "nuclear deal",
        "president", "election", "minister", "ceasefire", "pope", "mayor"]


def fetch(url, timeout=20):
    req = urllib.request.Request(url, headers={"User-Agent": UA})
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.load(r)


def jloads(v):
    if isinstance(v, str):
        try:
            return json.loads(v)
        except Exception:
            return v
    return v


def yes_prob(market):
    """The YES-side implied probability (0-1) of a binary market, or None."""
    outs = jloads(market.get("outcomes")) or []
    prices = jloads(market.get("outcomePrices")) or []
    yi = outs.index("Yes") if "Yes" in outs else 0
    if yi >= len(prices):
        return None
    try:
        return float(prices[yi])
    except Exception:
        return None


def shorten(s):
    s = (s or "").strip()
    for p in ("Will there be ", "Will the ", "Will ", "How many "):
        if s.startswith(p):
            s = s[len(p):]
    return s.rstrip("?").strip()


def event_line(e):
    """Compact 'topic: read NN%' for an event. For a binary event = its Yes%;
    for a multi-outcome event = the consensus (highest-Yes) scenario."""
    title = (e.get("title") or "").strip()
    mks = e.get("markets") or []
    cand = []  # (yes_prob, scenario_label)
    for m in mks:
        yp = yes_prob(m)
        if yp is None:
            continue
        scen = (m.get("groupItemTitle") or shorten(m.get("question") or "")).strip()
        cand.append((yp, scen))
    if not cand:
        return None
    vol = float(e.get("volume24hr") or 0)
    topic = shorten(title)[:42]
    if len(mks) == 1:
        pct = round(cand[0][0] * 100)
        return f"{topic}: {pct}%", vol, pct
    cand.sort(reverse=True)  # consensus = highest-Yes scenario
    yp, scen = cand[0]
    pct = round(yp * 100)
    scen = (scen or "?")[:24]
    return f"{topic}: {scen} {pct}%", vol, pct


def collect():
    seen_id, seen_topic, rows = set(), set(), []
    pulls = [f"{GAMMA}?closed=false&limit=40&order=volume24hr&ascending=false&tag_slug={t}" for t in TAGS]
    pulls.append(f"{GAMMA}?closed=false&limit=120&order=volume24hr&ascending=false")
    for url in pulls:
        try:
            evs = fetch(url)
        except Exception:
            continue
        for e in evs if isinstance(evs, list) else []:
            title = (e.get("title") or "").lower()
            eid = e.get("id")
            if eid in seen_id:
                continue
            tagged = "tag_slug=" in url  # economy/crypto pulls are pre-relevant
            if not tagged and not any(k in title for k in KW):
                continue
            if any(d in title for d in DROP):
                continue
            res = event_line(e)
            if not res:
                continue
            text, vol, pct = res
            if pct >= 99 or pct <= 1:   # drop trivially-certain markets (no info)
                continue
            tkey = title[:18]            # collapse near-identical topics (e.g. Hormuz x2)
            if tkey in seen_topic:
                continue
            seen_id.add(eid)
            seen_topic.add(tkey)
            rows.append((text, vol))
    rows.sort(key=lambda r: r[1], reverse=True)
    return [r[0] for r in rows]


def build(n=7):
    """Telegram-HTML brief, or None if nothing relevant is live."""
    rows = collect()[:n]
    if not rows:
        return None
    body = "\n".join(f"• {html.escape(r)}" for r in rows)
    return ("<b>📊 Polymarket — crowd odds</b>\n" + body +
            "\n<i>real-money implied probabilities · context only</i>")


def one_liner(n=3):
    """Compact single-line macro read for embedding in another brief (e.g. the
    8:15a Morning Command). ONE fast economy-tag fetch (8s) so it can't stall the
    host brief; returns 'topic NN% · topic NN% · …' or None. Never raises."""
    try:
        evs = fetch(f"{GAMMA}?closed=false&limit=30&order=volume24hr&ascending=false&tag_slug=economy", timeout=8)
    except Exception:
        return None
    rows = []
    for e in evs if isinstance(evs, list) else []:
        title = (e.get("title") or "").lower()
        if any(d in title for d in DROP):
            continue
        res = event_line(e)
        if not res:
            continue
        text, vol, pct = res
        if pct >= 99 or pct <= 1:
            continue
        rows.append((text, vol))
    rows.sort(key=lambda r: r[1], reverse=True)
    return " · ".join(r[0] for r in rows[:n]) if rows else None


def send(text):
    """Send via the house vault-backed helper (trading_command = LaptopClaude bot),
    silent/informational. Returns the route used, or None."""
    sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), "lib"))
    sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
    try:
        from lib.notify import tg_push  # type: ignore
    except Exception:
        from notify import tg_push  # type: ignore
    return tg_push(text, "trading_command", loud=False, html=True,
                   fallback_token_file="telegram_laptopclaude_bot_token")


if __name__ == "__main__":
    ap = argparse.ArgumentParser(description="Polymarket macro odds -> trading Telegram")
    ap.add_argument("--send", action="store_true", help="push to Telegram (else print)")
    a = ap.parse_args()
    txt = build()
    if not txt:
        print("(no relevant markets — nothing sent)")
        sys.exit(0)
    if a.send:
        route = send(txt)
        print(f"sent via: {route}" if route else "SEND FAILED")
        sys.exit(0 if route else 1)
    print(txt)
