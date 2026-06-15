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
_ACCTS = [("alpaca-boba-key-id", "alpaca-boba-secret"),
          ("alpaca-jazzy-key-id", "alpaca-jazzy-secret")]


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
    if not blocks:
        return "No portfolio data (Alpaca keys missing?)"
    ta = "🟢" if total_day >= 0 else "🔴"
    header = f"💼 **PORTFOLIO** — total ${total_eq:,.0f}  {ta} day {total_day:+,.0f}"
    return header + "\n\n" + "\n\n".join(blocks)
