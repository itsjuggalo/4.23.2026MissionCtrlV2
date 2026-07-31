#!/usr/bin/env python3
"""risk_officer.py — Mike's real-money rule enforcer (built 2026-07-31).

Enforces the 5 measured risk rules from the 2026-07-31 behavior analysis
(~/portfolio/TRADING-BEHAVIOR-FULL-ANALYSIS.md) against REAL fills in
~/portfolio/mike.sqlite (synced nightly by real_coach/fills) plus the LIVE
Robinhood session (rh-session-keeper token). Retail brokers can't hard-block
an order (SEC 15c3-5 pre-trade compliance is broker-side), so this is the
retail equivalent: intent gate BEFORE (trade-intent CLI) + fastest detection AFTER.

Modes:
  --scan    evaluate new fills since last cursor, alert violations (cron, 30min)
  --digest  EOD summary of today's verdicts + book state (cron, 16:20 ET)
  --weekly  Friday process review: grades by rule, streaks (cron, Fri 17:00 ET)
  --status  print current caps + book snapshot, no alerts

Rules (thresholds in ~/portfolio/risk_rules.json — edit there, not here):
  R1 SIZE      buy > size_cap_pct% of live equity — options tighter (option_cap_pct)
  R2 BTC-FLIP  RH BTC buy AND sell inside btc_flip_window_days (1.515% spread toll)
  R3 WORST-1ST sell of a green position while red bags stay untouched
  R4 TEMPO     more than tempo_day opens/day or tempo_week/7d (Coinbase-Mike ≈ 3/mo)
  R5 NO-PLAN   buy with no pre_trade_checks row (no written exit) → auto grade D
  R6 0DTE      same-day-expiry option opens beyond zdte_max_per_day

Read-only against brokers. Never places/cancels orders. Alerts via tg-send-msg.
"""
from __future__ import annotations

import argparse
import json
import sqlite3
import subprocess
import sys
import urllib.request
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
PF = Path.home() / "portfolio"
DB = PF / "mike.sqlite"
RULES_F = PF / "risk_rules.json"
TOKEN_F = Path.home() / ".openclaw" / "secrets" / "robinhood-brokerage-token.txt"

DEFAULT_RULES = {
    "_doc": "risk_officer.py thresholds — from the 2026-07-31 measured behavior analysis",
    "size_cap_pct": 5.0,          # max buy as % of trading equity (R1)
    "option_cap_pct": 2.0,        # max option debit as % of trading equity (R1)
    "size_floor_usd": 25.0,       # ignore dust buys below this
    "btc_flip_window_days": 5,    # RH BTC buy+sell inside this window = spread toll (R2)
    "red_bag_pct": -30.0,         # a position this far underwater is a 'bag' (R3)
    "tempo_day": 3,               # max opens per day (R4)
    "tempo_week": 10,             # max opens per rolling 7d (R4)
    "zdte_max_per_day": 2,        # max same-day-expiry option opens (R6)
    "alert": True                  # False = log only, no Telegram
}


# ---------------------------------------------------------------- helpers
def rules() -> dict:
    if not RULES_F.exists():
        RULES_F.write_text(json.dumps(DEFAULT_RULES, indent=2))
    r = dict(DEFAULT_RULES)
    try:
        r.update(json.loads(RULES_F.read_text()))
    except Exception:
        pass
    return r


def db() -> sqlite3.Connection:
    con = sqlite3.connect(DB, timeout=30)
    con.row_factory = sqlite3.Row
    con.execute("""CREATE TABLE IF NOT EXISTS risk_verdicts (
        id INTEGER PRIMARY KEY, fill_id INTEGER, ts TEXT, rule TEXT,
        severity TEXT, symbol TEXT, detail TEXT, alerted INTEGER DEFAULT 0,
        UNIQUE(fill_id, rule))""")
    con.execute("""CREATE TABLE IF NOT EXISTS risk_state (
        k TEXT PRIMARY KEY, v TEXT)""")
    return con


def rh_get(url: str):
    tok = TOKEN_F.read_text().strip()
    req = urllib.request.Request(url, headers={
        "Authorization": f"Bearer {tok}", "Accept": "application/json",
        "User-Agent": "Mozilla/5.0"})
    with urllib.request.urlopen(req, timeout=20) as r:
        return json.load(r)


def now_iso() -> str:
    return datetime.now(ET).isoformat(timespec="seconds")


def live_equity() -> tuple[float, float, str]:
    """(total equity, cash, source). Falls back to last-known on API failure."""
    try:
        p = rh_get("https://api.robinhood.com/portfolios/")["results"][0]
        a = rh_get("https://api.robinhood.com/accounts/")["results"][0]
        eq, cash = float(p["equity"]), float(a["cash"])
        con = db()
        con.execute("INSERT OR REPLACE INTO risk_state VALUES('last_equity',?)",
                    (json.dumps({"eq": eq, "cash": cash, "at": now_iso()}),))
        con.commit(); con.close()
        return eq, cash, "live"
    except Exception:
        try:
            con = db()
            row = con.execute("SELECT v FROM risk_state WHERE k='last_equity'").fetchone()
            con.close()
            if row:
                d = json.loads(row["v"])
                return d["eq"], d["cash"], f"cached@{d['at'][:16]}"
        except Exception:
            pass
        return 0.0, 0.0, "unavailable"


def tg(msg: str, cfg: dict):
    if not cfg.get("alert", True):
        print(f"[log-only] {msg}")
        return
    try:
        subprocess.run(["/home/itsju/bin/tg-send-msg", msg], timeout=30,
                       capture_output=True)
    except Exception as e:  # alerting must never crash the officer
        print(f"tg failed: {e}", file=sys.stderr)


def open_positions_pnl(con) -> list[dict]:
    """Rough open-book P&L: lots avg cost vs last fill price per symbol. No live
    quotes — good enough to tell deep-red bags from green names."""
    out = []
    lots = con.execute("""SELECT broker, asset_class, symbol,
                          SUM(qty) q, SUM(qty*price)/SUM(qty) avgpx
                          FROM lots GROUP BY broker, asset_class, symbol
                          HAVING SUM(qty) > 0.0001""").fetchall()
    for l in lots:
        last = con.execute("""SELECT price FROM fills WHERE symbol=? AND price>0
                              ORDER BY filled_at DESC LIMIT 1""",
                           (l["symbol"],)).fetchone()
        if not last or not l["avgpx"]:
            continue
        pnl = (last["price"] - l["avgpx"]) / l["avgpx"] * 100
        out.append(dict(symbol=l["symbol"], broker=l["broker"], qty=l["q"],
                        avgpx=l["avgpx"], lastpx=last["price"], pnl_pct=pnl))
    return out


def occ_expiry(occ: str, sym: str) -> str:
    """OCC symbol embeds expiry right after the padded root: SYMyymmddCPstrike."""
    occ = (occ or "").replace(" ", "")
    if not occ:
        return ""
    i = 0
    while i < len(occ) and occ[i].isalpha():
        i += 1
    ymd = occ[i:i + 6]
    if len(ymd) == 6 and ymd.isdigit():
        return f"20{ymd[:2]}-{ymd[2:4]}-{ymd[4:6]}"
    return ""


# ---------------------------------------------------------------- rule engine
def evaluate(con, cfg: dict, fills: list, eq: float) -> list[dict]:
    verdicts = []
    size_cap = eq * cfg["size_cap_pct"] / 100
    opt_cap = eq * cfg["option_cap_pct"] / 100
    book = open_positions_pnl(con)
    bags = [b for b in book if b["pnl_pct"] <= cfg["red_bag_pct"]]

    for f in fills:
        fid, sym = f["id"], f["symbol"]
        side = (f["side"] or "").lower()
        usd = abs(f["amount_usd"] or 0)
        ac = f["asset_class"]
        day = (f["filled_at"] or "")[:10]

        # R1 SIZE
        if side == "buy" and usd >= cfg["size_floor_usd"] and eq > 0:
            cap = opt_cap if ac == "option" else size_cap
            if usd > cap:
                pct = cfg["option_cap_pct"] if ac == "option" else cfg["size_cap_pct"]
                verdicts.append(dict(fill_id=fid, rule="R1-SIZE", severity="VIOLATION",
                    symbol=sym, detail=f"${usd:,.0f} {ac} buy vs cap ${cap:,.0f} "
                    f"({pct}% of ${eq:,.0f}) = {usd/eq*100:.0f}% of equity. "
                    f"LITE was 82% and cost $1,724."))

        # R2 BTC-FLIP on RH
        if sym == "BTC" and f["broker"] == "robinhood" and side in ("buy", "sell"):
            w = cfg["btc_flip_window_days"]
            opp = "sell" if side == "buy" else "buy"
            near = con.execute("""SELECT COUNT(*) c FROM fills WHERE symbol='BTC'
                AND broker='robinhood' AND lower(side)=? AND
                ABS(julianday(filled_at)-julianday(?)) <= ?""",
                (opp, f["filled_at"], w)).fetchone()["c"]
            if near:
                verdicts.append(dict(fill_id=fid, rule="R2-BTCFLIP", severity="VIOLATION",
                    symbol=sym, detail=f"BTC {side} with a {opp} inside {w}d on RH. "
                    f"Measured spread: 1.515%/round-trip — this toll took $1,065 in 2026 "
                    f"and was your ENTIRE BTC loss. Hold it, or trade on Kraken/Binance."))

        # R3 WORST-FIRST
        if side == "sell" and ac in ("stock", "crypto") and bags:
            me = next((b for b in book if b["symbol"] == sym), None)
            if me and me["pnl_pct"] > 0:
                bl = ", ".join(f"{b['symbol']} {b['pnl_pct']:.0f}%" for b in bags[:4])
                verdicts.append(dict(fill_id=fid, rule="R3-WORST1ST", severity="WARN",
                    symbol=sym, detail=f"Sold GREEN {sym} (+{me['pnl_pct']:.0f}%) while "
                    f"red bags sit untouched: {bl}. This is how AAPL/NVDA left and "
                    f"AMC/SNDL stayed 1,920 days. Raise cash worst-first."))

        # R6 0DTE
        if ac == "option" and side == "buy":
            exp = occ_expiry(f["occ_symbol"], sym)
            if exp and exp == day:
                n = con.execute("""SELECT COUNT(*) c FROM fills WHERE asset_class='option'
                    AND lower(side)='buy' AND substr(filled_at,1,10)=?""",
                    (day,)).fetchone()["c"]
                if n > cfg["zdte_max_per_day"]:
                    verdicts.append(dict(fill_id=fid, rule="R6-0DTE", severity="VIOLATION",
                        symbol=sym, detail=f"0DTE open #{n} today (max "
                        f"{cfg['zdte_max_per_day']}). Jun-24 spree: 5 opens, PDT-flagged "
                        f"FOREVER, and you didn't remember placing them. Done for today."))

        # R4 TEMPO
        if side == "buy" and usd >= cfg["size_floor_usd"]:
            nd = con.execute("""SELECT COUNT(*) c FROM fills WHERE lower(side)='buy'
                AND ABS(amount_usd) >= ? AND substr(filled_at,1,10)=?""",
                (cfg["size_floor_usd"], day)).fetchone()["c"]
            nw = con.execute("""SELECT COUNT(*) c FROM fills WHERE lower(side)='buy'
                AND ABS(amount_usd) >= ? AND julianday(?)-julianday(filled_at)
                BETWEEN 0 AND 7""",
                (cfg["size_floor_usd"], f["filled_at"])).fetchone()["c"]
            if nd > cfg["tempo_day"] or nw > cfg["tempo_week"]:
                verdicts.append(dict(fill_id=fid, rule="R4-TEMPO", severity="WARN",
                    symbol=sym, detail=f"{nd} opens today / {nw} in 7d (caps "
                    f"{cfg['tempo_day']}/{cfg['tempo_week']}). Coinbase-Mike traded "
                    f"~3x/MONTH → +$35,835. RH-2026-Mike churned → gone. Slow down."))

        # R5 NO-PLAN
        if side == "buy" and usd >= cfg["size_floor_usd"]:
            plan = con.execute("""SELECT COUNT(*) c FROM pre_trade_checks WHERE symbol=?
                AND julianday(?)-julianday(ts) BETWEEN 0 AND 3""",
                (sym, f["filled_at"])).fetchone()["c"]
            if not plan:
                verdicts.append(dict(fill_id=fid, rule="R5-NOPLAN", severity="GRADE-D",
                    symbol=sym, detail=f"{sym} ${usd:,.0f} buy with NO written plan "
                    f"(no pre_trade_checks row in the prior 3d). Your record: 85% of "
                    f"sells were bills, 1 stop order in 5 years. "
                    f"Next time run: trade-intent {sym}"))
    return verdicts


# ---------------------------------------------------------------- modes
def scan(cfg: dict):
    con = db()
    row = con.execute("SELECT v FROM risk_state WHERE k='cursor'").fetchone()
    cursor = int(row["v"]) if row else -1
    if cursor < 0:  # first run: arm at head, don't re-litigate history
        m = con.execute("SELECT COALESCE(MAX(id),0) m FROM fills").fetchone()["m"]
        con.execute("INSERT OR REPLACE INTO risk_state VALUES('cursor',?)", (str(m),))
        con.commit()
        eq, cash, src = live_equity()
        print(f"initialized cursor at fill id {m}; equity ${eq:,.2f} ({src})")
        con.close()
        return
    fills = con.execute("SELECT * FROM fills WHERE id > ? ORDER BY id",
                        (cursor,)).fetchall()
    if not fills:
        print(f"no new fills past id {cursor}")
        con.close()
        return
    eq, cash, src = live_equity()
    verdicts = evaluate(con, cfg, fills, eq)
    mx = max(f["id"] for f in fills)
    for v in verdicts:
        con.execute("""INSERT OR IGNORE INTO risk_verdicts
            (fill_id, ts, rule, severity, symbol, detail, alerted)
            VALUES (?,?,?,?,?,?,0)""",
            (v["fill_id"], now_iso(), v["rule"], v["severity"], v["symbol"], v["detail"]))
    con.execute("INSERT OR REPLACE INTO risk_state VALUES('cursor',?)", (str(mx),))
    con.commit()
    rows = con.execute("""SELECT id, rule, severity, symbol, detail FROM risk_verdicts
                          WHERE alerted=0 ORDER BY id""").fetchall()
    if rows:
        lines = ["🚨 RISK OFFICER — rule check on your REAL fills"]
        for r in rows:
            icon = {"VIOLATION": "🔴", "WARN": "🟠", "GRADE-D": "📝"}.get(r["severity"], "•")
            lines.append(f"{icon} {r['rule']} {r['symbol']}: {r['detail']}")
        lines.append(f"(equity ${eq:,.0f} {src} · caps: stock "
                     f"${eq*cfg['size_cap_pct']/100:,.0f} / option "
                     f"${eq*cfg['option_cap_pct']/100:,.0f})")
        tg("\n".join(lines), cfg)
        con.execute("UPDATE risk_verdicts SET alerted=1 WHERE alerted=0")
        con.commit()
    print(f"scanned {len(fills)} new fills -> {len(verdicts)} verdicts")
    con.close()


def digest(cfg: dict):
    con = db()
    today = datetime.now(ET).strftime("%Y-%m-%d")
    vs = con.execute("SELECT rule, severity, symbol FROM risk_verdicts "
                     "WHERE substr(ts,1,10)=?", (today,)).fetchall()
    fs = con.execute("SELECT COUNT(*) c, COALESCE(SUM(ABS(amount_usd)),0) s FROM fills "
                     "WHERE substr(filled_at,1,10)=?", (today,)).fetchone()
    eq, cash, src = live_equity()
    lines = [f"📊 RISK OFFICER EOD — {today}",
             f"equity ${eq:,.0f} ({src}) · cash ${cash:,.0f}",
             f"fills today: {fs['c']} (${fs['s']:,.0f})"]
    if vs:
        lines.append(f"verdicts: {len(vs)}")
        for v in vs[:8]:
            lines.append(f"  {v['rule']} {v['symbol']} [{v['severity']}]")
    else:
        lines.append("verdicts: 0 — clean day ✅ (Coinbase-Mike mode)")
    row = con.execute("""SELECT COUNT(DISTINCT substr(ts,1,10)) c FROM risk_verdicts
        WHERE severity='VIOLATION' AND ts >= date('now','-30 day')""").fetchone()
    lines.append(f"violation-days last 30d: {row['c']}")
    tg("\n".join(lines), cfg)
    print("\n".join(lines))
    con.close()


def weekly(cfg: dict):
    con = db()
    vs = con.execute("""SELECT rule, severity, COUNT(*) c FROM risk_verdicts
        WHERE ts >= date('now','-7 day') GROUP BY rule, severity
        ORDER BY c DESC""").fetchall()
    fs = con.execute("""SELECT COUNT(*) c FROM fills
        WHERE filled_at >= date('now','-7 day') AND lower(side)='buy'""").fetchone()
    plans = con.execute("""SELECT COUNT(*) c FROM pre_trade_checks
        WHERE ts >= date('now','-7 day')""").fetchone()
    lines = ["🗓️ WEEKLY PROCESS REVIEW (grades process, NOT P&L)",
             f"buys this week: {fs['c']} · written plans: {plans['c']}"]
    tot_viol = sum(v["c"] for v in vs if v["severity"] == "VIOLATION")
    grade = "A"
    if tot_viol >= 3: grade = "D"
    elif tot_viol >= 1: grade = "C"
    elif any(v["severity"] == "WARN" for v in vs): grade = "B"
    if fs["c"] > 0 and plans["c"] == 0 and grade in "AB": grade = "C"
    lines.append(f"PROCESS GRADE: {grade}")
    for v in vs:
        lines.append(f"  {v['rule']} [{v['severity']}] x{v['c']}")
    if not vs:
        lines.append("  no rule hits — the patient accumulator showed up 💪")
    lines.append("A disciplined loser beats a sloppy winner. The grade is the process.")
    tg("\n".join(lines), cfg)
    print("\n".join(lines))
    con.close()


def status(cfg: dict):
    eq, cash, src = live_equity()
    con = db()
    book = open_positions_pnl(con)
    bags = [b for b in book if b["pnl_pct"] <= cfg["red_bag_pct"]]
    print(f"equity ${eq:,.2f} ({src}) · cash ${cash:,.2f}")
    print(f"caps: stock ${eq*cfg['size_cap_pct']/100:,.0f} ({cfg['size_cap_pct']}%) · "
          f"option ${eq*cfg['option_cap_pct']/100:,.0f} ({cfg['option_cap_pct']}%)")
    print(f"tempo: {cfg['tempo_day']}/day {cfg['tempo_week']}/wk · "
          f"0DTE max {cfg['zdte_max_per_day']}/day · BTC-flip window "
          f"{cfg['btc_flip_window_days']}d")
    print(f"red bags (<= {cfg['red_bag_pct']}%): " +
          (", ".join(f"{b['symbol']} {b['pnl_pct']:.0f}%" for b in bags) or "none"))
    n = con.execute("SELECT COUNT(*) c FROM risk_verdicts").fetchone()["c"]
    cur = con.execute("SELECT v FROM risk_state WHERE k='cursor'").fetchone()
    print(f"verdicts on file: {n} · fill cursor: {cur['v'] if cur else 'not armed'}")
    con.close()


if __name__ == "__main__":
    ap = argparse.ArgumentParser(description="Mike's real-money rule enforcer")
    m = ap.add_mutually_exclusive_group(required=True)
    m.add_argument("--scan", action="store_true")
    m.add_argument("--digest", action="store_true")
    m.add_argument("--weekly", action="store_true")
    m.add_argument("--status", action="store_true")
    args = ap.parse_args()
    cfg = rules()
    if args.scan: scan(cfg)
    elif args.digest: digest(cfg)
    elif args.weekly: weekly(cfg)
    else: status(cfg)
