"""Top portfolio tickers by capital — for portfolio-aware scheduled intel.

Pulls live Alpaca paper positions (Boba + Jazzy), merges by symbol, ranks by
|market value| (most capital first). Pads with index defaults only when the book
is thin/empty/unreachable, so a scheduled post is never empty.
"""
from __future__ import annotations

import json
import os
import urllib.request
from collections import defaultdict
from pathlib import Path

SEC = Path.home() / ".openclaw" / "secrets"
WATCHLIST_FILE = Path.home() / ".openclaw" / "data" / "watchlist.json"
DEFAULTS = ["SPY", "QQQ", "NVDA"]
CRYPTO_DEFAULTS = ["BTC", "ETH", "SOL"]
STABLES = {"USD", "USDC", "USDT", "DAI", "USDD", "PYUSD", "GUSD"}
_ACCTS = [("alpaca-boba-key-id", "alpaca-boba-secret"),
          ("alpaca-jazzy-key-id", "alpaca-jazzy-secret")]
# ARIES (operator mode) is the proven read path for REAL-MONEY Robinhood + Coinbase
# crypto holdings (~/.openclaw/secrets Ed25519/ES256 keys, IP-allowlisted). We read
# it over localhost so we reuse the cached/de-duped adapters instead of re-signing.
ARIES_BASE = os.environ.get("ARIES_BASE", "http://localhost:1337")
_PRICE_CACHE: dict[str, float] = {}
_PRICE_TS = [0.0]          # last fetch epoch; TTL keeps the long-running bot fresh
_PRICE_TTL = 300           # seconds


def get_watchlist() -> list[str]:
    try:
        return [t.upper() for t in json.loads(WATCHLIST_FILE.read_text())]
    except Exception:
        return []


def _save_watchlist(items):
    WATCHLIST_FILE.parent.mkdir(parents=True, exist_ok=True)
    tmp = WATCHLIST_FILE.with_suffix(".tmp")
    tmp.write_text(json.dumps(items))
    os.replace(tmp, WATCHLIST_FILE)


def add_watch(ticker: str) -> list[str]:
    t = ticker.upper().strip()
    wl = get_watchlist()
    if t and t not in wl:
        wl.append(t)
        _save_watchlist(wl)
    return wl


def remove_watch(ticker: str) -> list[str]:
    t = ticker.upper().strip()
    wl = [x for x in get_watchlist() if x != t]
    _save_watchlist(wl)
    return wl


def _rd(*names):
    for n in names:
        p = SEC / n
        if p.exists():
            v = p.read_text().strip()
            if v:
                return v
    return None


def top_tickers(n: int = 6) -> list[str]:
    """Top-N held symbols by |market value| across Boba+Jazzy, padded with index
    defaults to keep market context when the book has fewer than N names."""
    mv: dict[str, float] = defaultdict(float)
    for kid, ksec in _ACCTS:
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        req = urllib.request.Request(
            "https://paper-api.alpaca.markets/v2/positions",
            headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s,
                     "User-Agent": "mc-portfolio/1.0"})
        try:
            with urllib.request.urlopen(req, timeout=15) as r:
                for p in json.loads(r.read()):
                    mv[p["symbol"]] += abs(float(p.get("market_value", 0) or 0))
        except Exception:
            continue
    syms = [s for s, _ in sorted(mv.items(), key=lambda x: -x[1])]   # holdings, capital-ranked
    for w in get_watchlist():               # then names you're watching
        if w not in syms:
            syms.append(w)
    for d in DEFAULTS:                       # then index padding for context
        if d not in syms:
            syms.append(d)
    return syms[:n] if syms else DEFAULTS[:n]


def top_tickers_str(n: int = 6) -> str:
    return ", ".join(top_tickers(n))


def _held_symbols() -> list[str]:
    mv: dict[str, float] = defaultdict(float)
    for kid, ksec in _ACCTS:
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        req = urllib.request.Request(
            "https://paper-api.alpaca.markets/v2/positions",
            headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s, "User-Agent": "mc-portfolio/1.0"})
        try:
            with urllib.request.urlopen(req, timeout=15) as r:
                for p in json.loads(r.read()):
                    mv[p["symbol"]] += abs(float(p.get("market_value", 0) or 0))
        except Exception:
            continue
    return [s for s, _ in sorted(mv.items(), key=lambda x: -x[1])]


def personal_tickers() -> list[str]:
    """Holdings (capital-ranked) + watchlist only — NO index padding. For 'your names' filters."""
    syms = _held_symbols()
    for w in get_watchlist():
        if w not in syms:
            syms.append(w)
    return syms


# ─── REAL-MONEY CRYPTO (Robinhood + Coinbase via ARIES operator mode) ──────────
def _crypto_prices() -> dict[str, float]:
    """USD spot for every crypto, one free Coinbase call (no key). Cached with a 5-min
    TTL so the long-running bot stays fresh (permanent cache would freeze prices)."""
    import time
    if _PRICE_CACHE and (time.time() - _PRICE_TS[0]) < _PRICE_TTL:
        return _PRICE_CACHE
    try:
        req = urllib.request.Request(
            "https://api.coinbase.com/v2/exchange-rates?currency=USD",
            headers={"User-Agent": "mc-portfolio/1.0"})
        with urllib.request.urlopen(req, timeout=12) as r:
            rates = json.loads(r.read())["data"]["rates"]
        fresh = {}
        for sym, rate in rates.items():
            try:
                rate = float(rate)
                if rate > 0:
                    fresh[sym.upper()] = 1.0 / rate
            except (TypeError, ValueError):
                continue
        if fresh:
            _PRICE_CACHE.clear()
            _PRICE_CACHE.update(fresh)
            _PRICE_TS[0] = time.time()
    except Exception:
        pass
    return _PRICE_CACHE


def _aries_broker(name: str) -> list[tuple[str, float]]:
    """(asset, qty) holdings from a connected ARIES broker (real money). [] on any error."""
    try:
        req = urllib.request.Request(
            f"{ARIES_BASE}/api/brokers/{name}",
            headers={"x-operator": "1", "User-Agent": "mc-portfolio/1.0"})
        with urllib.request.urlopen(req, timeout=20) as r:
            d = json.loads(r.read())
        if not d.get("connected"):
            return []
        out = []
        for b in d.get("balances", []):
            sym = str(b.get("asset", "")).upper().strip()
            qty = float(b.get("total", 0) or 0)
            if sym and qty > 0:
                out.append((sym, qty))
        return out
    except Exception:
        return []


def real_money_holdings() -> dict[str, float]:
    """{SYMBOL: usd_value} of LIVE Robinhood + Coinbase crypto, merged & priced.
    Stablecoins and sub-$1 dust excluded. {} if ARIES/prices unreachable."""
    prices = _crypto_prices()
    if not prices:
        return {}
    val: dict[str, float] = defaultdict(float)
    for broker in ("robinhood", "coinbase"):
        for sym, qty in _aries_broker(broker):
            if sym in STABLES:
                continue
            px = prices.get(sym)
            if px:
                val[sym] += qty * px
    return {s: v for s, v in val.items() if v >= 1.0}


def crypto_tickers(n: int = 6) -> list[str]:
    """Real-money crypto names ranked by USD value, padded with BTC/ETH/SOL for context."""
    held = real_money_holdings()
    syms = [s for s, _ in sorted(held.items(), key=lambda x: -x[1])]
    for d in CRYPTO_DEFAULTS:
        if d not in syms:
            syms.append(d)
    return syms[:n] if syms else CRYPTO_DEFAULTS[:n]


def crypto_tickers_str(n: int = 6) -> str:
    return ", ".join(crypto_tickers(n))


def personal_crypto() -> list[str]:
    """Real-money crypto names (capital-ranked, NO defaults). For crypto 'your names' filters."""
    held = real_money_holdings()
    return [s for s, _ in sorted(held.items(), key=lambda x: -x[1])]


def daily_journal_recap() -> str:
    """EOD recap: day P&L + today's fills (from the synced trade_journal) + open book."""
    import sqlite3
    from datetime import datetime
    from zoneinfo import ZoneInfo
    et = ZoneInfo("America/New_York")
    now = datetime.now(et)
    since = int(now.replace(hour=0, minute=0, second=0, microsecond=0).timestamp() * 1000)
    # day P&L + open count from Alpaca
    eq_total, day_total, open_ct = 0.0, 0.0, 0
    for kid, ksec in _ACCTS:
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        try:
            acct, pos = _acct_data(k, s)
            eq = float(acct.get("equity", 0) or 0)
            day_total += eq - float(acct.get("last_equity", eq) or eq)
            eq_total += eq
            open_ct += len(pos)
        except Exception:
            continue
    # today's fills from the synced journal
    fills = []
    db = Path.home() / "web" / "missionctrl" / "data" / "dashboard_history.sqlite"
    try:
        con = sqlite3.connect(str(db), timeout=10)
        con.execute("PRAGMA busy_timeout=5000")
        fills = con.execute(
            "SELECT account, side, qty, symbol, ref_price FROM trade_journal "
            "WHERE ts >= ? AND principal='alpaca-sync' ORDER BY ts", (since,)).fetchall()
        con.close()
    except Exception:
        pass
    arrow = "🟢" if day_total >= 0 else "🔴"
    out = [f"📓 **TRADE JOURNAL — {now:%a %b %-d}**",
           f"Day P&L {arrow} **{day_total:+,.0f}** · equity ${eq_total:,.0f} · {open_ct} open"]
    if not fills:
        out.append("No fills today.")
    else:
        out.append(f"\n**{len(fills)} fills today:**")
        for acct, side, qty, sym, px in fills[:15]:
            ic = "🟩" if side == "buy" else "🟥"
            out.append(f"  {ic} {str(side).upper()} {qty} {sym} @ ${px:.2f} ({acct})")
        if len(fills) > 15:
            out.append(f"  …+{len(fills) - 15} more")
    # idea decisions logged today via /pick buttons (took/skip)
    took, skipped = [], []
    jpath = Path.home() / ".openclaw" / "data" / "trade_journal.jsonl"
    try:
        for line in jpath.read_text().splitlines():
            r = json.loads(line)
            dt = datetime.fromisoformat(r.get("ts", "")).astimezone(et)
            if dt.date() == now.date():
                if r.get("action") == "took":
                    took.append(r.get("ticker", "?"))
                elif r.get("action") == "skip":
                    skipped.append(r.get("ticker", "?"))
    except Exception:
        pass
    if took or skipped:
        out.append("\n**Ideas logged:**")
        if took:
            out.append(f"  ✅ took: {', '.join(took)}")
        if skipped:
            out.append(f"  ❌ skipped: {', '.join(skipped)}")
    return "\n".join(out)


def weekly_review() -> str:
    """Friday recap: week P&L (Alpaca portfolio history) + the week's fills from the journal."""
    import sqlite3
    from datetime import datetime, timedelta
    from zoneinfo import ZoneInfo
    et = ZoneInfo("America/New_York")
    now = datetime.now(et)
    monday = now - timedelta(days=now.weekday())
    week_start_ms = int(monday.replace(hour=0, minute=0, second=0, microsecond=0).timestamp() * 1000)
    week_pl, eq_total = 0.0, 0.0
    for kid, ksec in _ACCTS:
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        try:
            acct, _ = _acct_data(k, s)
            eq_total += float(acct.get("equity", 0) or 0)
            req = urllib.request.Request(
                "https://paper-api.alpaca.markets/v2/account/portfolio/history?period=1W&timeframe=1D",
                headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s, "User-Agent": "mc-week/1.0"})
            with urllib.request.urlopen(req, timeout=15) as r:
                h = json.loads(r.read())
            eqs = [e for e in (h.get("equity") or []) if e]
            if len(eqs) >= 2:
                week_pl += eqs[-1] - eqs[0]
        except Exception:
            continue
    fills = []
    db = Path.home() / "web" / "missionctrl" / "data" / "dashboard_history.sqlite"
    try:
        con = sqlite3.connect(str(db), timeout=10)
        con.execute("PRAGMA busy_timeout=5000")
        fills = con.execute(
            "SELECT symbol, side, COUNT(*) FROM trade_journal "
            "WHERE ts >= ? AND principal='alpaca-sync' GROUP BY symbol, side ORDER BY COUNT(*) DESC",
            (week_start_ms,)).fetchall()
        con.close()
    except Exception:
        pass
    total_fills = sum(c for _, _, c in fills)
    syms = sorted({s for s, _, _ in fills})
    arrow = "🟢" if week_pl >= 0 else "🔴"
    out = [f"📅 **WEEKLY REVIEW — week of {monday:%b %-d}**",
           f"Week P&L {arrow} **{week_pl:+,.0f}** · equity now ${eq_total:,.0f}",
           f"Trades: **{total_fills} fills** across {len(syms)} names" if total_fills else "No trades this week."]
    if syms:
        out.append("Most active: " + ", ".join(syms[:10]))
    out.append("_Review your #trade-reviews log: what worked, what to cut next week._")
    return "\n".join(out)


def _acct_data(k: str, s: str):
    base = "https://paper-api.alpaca.markets"
    hdr = {"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s, "User-Agent": "mc-portfolio/1.0"}

    def get(path):
        req = urllib.request.Request(base + path, headers=hdr)
        with urllib.request.urlopen(req, timeout=15) as r:
            return json.loads(r.read())
    return get("/v2/account"), get("/v2/positions")


def total_equity() -> float:
    """Combined Boba+Jazzy account equity (live)."""
    tot = 0.0
    for kid, ksec in _ACCTS:
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        try:
            acct, _ = _acct_data(k, s)
            tot += float(acct.get("equity", 0) or 0)
        except Exception:
            continue
    return tot


def portfolio_summary() -> str:
    """Deterministic positions + equity + day P&L across Boba+Jazzy (no LLM)."""
    blocks, total_eq, total_day = [], 0.0, 0.0
    for name, (kid, ksec) in zip(("BOBA", "JAZZY"), _ACCTS):
        k, s = _rd(kid), _rd(ksec)
        if not k or not s:
            continue
        try:
            acct, pos = _acct_data(k, s)
        except Exception:
            blocks.append(f"**{name}** — read error")
            continue
        eq = float(acct.get("equity", 0) or 0)
        le = float(acct.get("last_equity", eq) or eq)
        day = eq - le
        dpct = (day / le * 100) if le else 0.0
        total_eq += eq
        total_day += day
        arrow = "🟢" if day >= 0 else "🔴"
        lines = [f"**{name}** — equity ${eq:,.0f}  {arrow} day {day:+,.0f} ({dpct:+.1f}%)"]
        pos = sorted(pos, key=lambda p: -abs(float(p.get("market_value", 0) or 0)))
        if not pos:
            lines.append("   (flat — no open positions)")
        for p in pos[:8]:
            mv = float(p.get("market_value", 0) or 0)
            pl = float(p.get("unrealized_pl", 0) or 0)
            plpc = float(p.get("unrealized_plpc", 0) or 0) * 100
            a = "🟢" if pl >= 0 else "🔴"
            lines.append(f"   {p['symbol']:<6} ${mv:,.0f}  {a} {pl:+,.0f} ({plpc:+.1f}%)")
        blocks.append("\n".join(lines))
    # real-money crypto (Robinhood + Coinbase) — capital-ranked, live-priced
    crypto = real_money_holdings()
    crypto_total = sum(crypto.values())
    if crypto:
        clines = [f"**REAL MONEY (crypto)** — ${crypto_total:,.0f}"]
        for sym, v in sorted(crypto.items(), key=lambda x: -x[1])[:8]:
            clines.append(f"   {sym:<6} ${v:,.0f}")
        blocks.append("\n".join(clines))
    if not blocks:
        return "No portfolio data (Alpaca keys missing?)"
    ta = "🟢" if total_day >= 0 else "🔴"
    grand = total_eq + crypto_total
    header = f"💼 **PORTFOLIO** — total ${grand:,.0f}  {ta} day {total_day:+,.0f}"
    if crypto_total:
        header += f"\n   (paper ${total_eq:,.0f} + real-money crypto ${crypto_total:,.0f})"
    return header + "\n\n" + "\n\n".join(blocks)
