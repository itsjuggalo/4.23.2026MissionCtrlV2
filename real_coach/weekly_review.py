#!/usr/bin/env python3
"""weekly_review.py — Sunday graded review of the week's REAL fills vs the standing rules.

Every fill from the last N days (default 7) is graded against the contract the
coach enforces (PROFILE.md standing rules):
  rule 4  sizing    — no buy >10x the (dust-filtered) median buy without a plan
  rule 5  chasing   — no buy after a +15%/5-day run
  rule 3  dead bags — never average into a −50% position
  rule 1  core      — core positions don't get sold without ≥3 bear factors
  options — premium ticket ≤ $300 (one oversized loser ate all 14 wins)
  process — buys should have a Trade Ticket written BEFORE the fill

Output: per-fill grades + a week GPA, Telegram'd to trading_command and written
to ~/portfolio/weekly_reviews/YYYY-MM-DD.md. Read-only vs brokers (mike.sqlite,
unified_book.json, trade_tickets.json, yfinance). Advisory only — never trades.

Cron (Sunday 11:00 ET): weekly_review.py --send
"""
from __future__ import annotations

import argparse
import json
import sqlite3
import subprocess
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))

from real_coach import symbols as symmod  # noqa: E402

DB = Path.home() / "portfolio" / "mike.sqlite"
UNIFIED_BOOK = Path.home() / "portfolio" / "unified_book.json"
TICKETS_FILE = Path.home() / "portfolio" / "trade_tickets.json"
COACH_CONFIG = Path.home() / "portfolio" / "coach_config.json"
OUT_DIR = Path.home() / "portfolio" / "weekly_reviews"
TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
TG_FN = "trading_command"

DUST_MAX_USD = 5.0
CHASE_RUNUP_PCT = 15.0
DEAD_BAG_PCT = -50.0
OPTION_MAX_TICKET = 300.0
GPA = {"A": 4.0, "B": 3.0, "C": 2.0, "F": 0.0}


def tg(msg: str) -> None:
    try:
        subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, msg],
                       capture_output=True, timeout=30)
    except Exception:
        pass


def core_symbols() -> set[str]:
    try:
        cfg = json.loads(COACH_CONFIG.read_text())
        return {k.split(":")[-1].upper() for k in cfg.get("buckets", {}).get("core", [])}
    except Exception:
        return {"BTC", "ETH", "QQQ", "IBIT"}


def book_positions() -> dict[str, dict]:
    """symbol -> aggregated {unrealized_pct, mkt_value} from unified_book."""
    try:
        book = json.loads(UNIFIED_BOOK.read_text())
        agg: dict[str, dict] = {}
        for p in book.get("positions", []):
            s = (p.get("symbol") or "").upper()
            if not s:
                continue
            a = agg.setdefault(s, {"mkt": 0.0, "unreal": 0.0})
            a["mkt"] += p.get("mkt_value") or 0.0
            a["unreal"] += p.get("unrealized_usd") or 0.0
        out = {}
        for s, a in agg.items():
            basis = a["mkt"] - a["unreal"]
            out[s] = {"mkt_value": a["mkt"],
                      "unrealized_pct": (a["unreal"] / basis * 100.0) if basis > 0 else None}
        return out
    except Exception:
        return {}


def tickets() -> list[dict]:
    try:
        t = json.loads(TICKETS_FILE.read_text())
        return t if isinstance(t, list) else []
    except Exception:
        return []


def median_buy(con: sqlite3.Connection) -> float:
    rows = [r[0] for r in con.execute(
        "SELECT ABS(amount_usd) FROM fills WHERE side='buy' AND amount_usd IS NOT NULL "
        "AND ABS(amount_usd) >= ? ORDER BY ABS(amount_usd)", (DUST_MAX_USD,))]
    if not rows:
        return 100.0
    mid = len(rows) // 2
    return rows[mid] if len(rows) % 2 else (rows[mid - 1] + rows[mid]) / 2


def week_fills(con: sqlite3.Connection, days: int) -> list[dict]:
    since = (datetime.now(timezone.utc) - timedelta(days=days)).strftime("%Y-%m-%dT%H:%M:%S")
    cols = ("id", "broker", "asset_class", "symbol", "occ_symbol", "side",
            "qty", "price", "amount_usd", "filled_at", "position_effect")
    rows = con.execute(
        f"SELECT {','.join(cols)} FROM fills WHERE filled_at >= ? "
        "AND (position_effect IS NULL OR position_effect NOT IN ('receive','send')) "
        "ORDER BY filled_at", (since,)).fetchall()
    return [dict(zip(cols, r)) for r in rows]


def load_closes(pairs: set[tuple[str, str]]) -> dict[str, "object"]:
    """(sym, asset_class) -> yf close Series (1mo daily). Batched, fail-soft."""
    try:
        import yfinance as yf
    except Exception:
        return {}
    want = sorted({symmod.ta_symbol(s, "crypto") if a == "crypto" else s for s, a in pairs})
    if not want:
        return {}
    out: dict[str, object] = {}
    try:
        raw = yf.download(" ".join(want), period="2mo", interval="1d", progress=False,
                          threads=True, auto_adjust=True, group_by="ticker")
        for t in want:
            try:
                ser = (raw[t]["Close"] if len(want) > 1 else raw["Close"]).dropna()
                if len(ser):
                    out[t] = ser
            except Exception:
                pass
    except Exception:
        pass
    return out


def runup_before(closes, fill_dt: datetime) -> float | None:
    """% change over the 5 trading days BEFORE the fill date."""
    try:
        upto = closes[closes.index.tz_localize(None) <= fill_dt.replace(tzinfo=None)]
        if len(upto) < 6:
            return None
        last, ago5 = float(upto.iloc[-1]), float(upto.iloc[-6])
        return (last - ago5) / ago5 * 100.0 if ago5 > 0 else None
    except Exception:
        return None


def had_ticket(tix: list[dict], symbol: str, fill_dt: datetime) -> bool:
    """A planned/filled ticket for this symbol written up to 48h before the fill."""
    for t in tix:
        if (t.get("symbol") or "").upper() != symbol:
            continue
        try:  # ts format: 'YYYY-MM-DDTHH:MM:SS ET'
            ts = datetime.strptime(t["ts"].replace(" ET", ""), "%Y-%m-%dT%H:%M:%S")
        except Exception:
            continue
        # fills are UTC; ET ≈ UTC−4/−5 — 48h window makes the offset immaterial
        delta = fill_dt.replace(tzinfo=None) - ts
        if timedelta(hours=-6) <= delta <= timedelta(hours=48):
            return True
    return False


def grade_fill(f: dict, med: float, closes_map: dict, book: dict[str, dict],
               core: set[str], tix: list[dict]) -> tuple[str, list[str]]:
    """-> (letter grade, list of flag strings). A = clean, C = caution(s), F = rule broken."""
    flags: list[str] = []
    fails = 0
    sym = f["symbol"].upper()
    usd = abs(f["amount_usd"] or (f["qty"] * f["price"]) or 0)
    is_buy = f["side"] == "buy"
    is_option = f["asset_class"] == "option"
    fill_dt = datetime.fromisoformat(f["filled_at"].replace("Z", "+00:00")) \
        if "T" in f["filled_at"] else datetime.strptime(f["filled_at"], "%Y-%m-%d %H:%M:%S")

    ysym = symmod.ta_symbol(sym, "crypto") if f["asset_class"] == "crypto" else sym
    closes = closes_map.get(ysym)

    if is_buy:
        # rule 4 — sizing
        cap = med * 10
        if usd > cap and usd >= DUST_MAX_USD:
            fails += 1
            flags.append(f"OVERSIZE ${usd:,.0f} > ${cap:,.0f} cap (10× ${med:.0f} median) — rule 4")
        # options premium cap
        if is_option and usd > OPTION_MAX_TICKET:
            fails += 1
            flags.append(f"OPTION ticket ${usd:,.0f} > ${OPTION_MAX_TICKET:.0f} cap")
        # rule 5 — chasing
        if closes is not None:
            r = runup_before(closes, fill_dt)
            if r is not None and r >= CHASE_RUNUP_PCT:
                fails += 1
                flags.append(f"CHASED +{r:.0f}%/5d run — rule 5 says wait for the pullback")
            elif r is not None and r >= CHASE_RUNUP_PCT * 0.6:
                flags.append(f"warm entry (+{r:.0f}%/5d)")
        # rule 3 — averaging into a dead bag (approx: current book state)
        pos = book.get(sym)
        if pos and pos.get("unrealized_pct") is not None and pos["unrealized_pct"] <= DEAD_BAG_PCT:
            fails += 1
            flags.append(f"ADDED to a {pos['unrealized_pct']:.0f}% dead bag — rule 3: exit into strength, don't average")
        # process — ticket-first
        if not is_option and usd >= 50 and not had_ticket(tix, sym, fill_dt):
            flags.append("no Trade Ticket written before the fill")
    else:
        # rule 1 — core sells get scrutiny (factors need the gate; here we flag for review)
        if sym in core:
            flags.append("CORE sell — needs ≥3 bear factors (review: was this strength-selling?)")
        # sells graded for early-exit next month via fwd_ret_30d (needs 30d of future)

    if fails:
        return "F", flags
    if flags:
        return "C", flags
    return "A", flags


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--days", type=int, default=7)
    ap.add_argument("--send", action="store_true", help="Telegram the review")
    args = ap.parse_args()

    con = sqlite3.connect(f"file:{DB}?mode=ro", uri=True, timeout=30)
    med = median_buy(con)
    fills = week_fills(con, args.days)
    core = core_symbols()
    book = book_positions()
    tix = tickets()

    now_et = datetime.now(timezone.utc) - timedelta(hours=4)
    header = f"📋 WEEKLY FILL REVIEW — {args.days}d ending {now_et:%a %b %-d}"

    if not fills:
        msg = f"{header}\n\nNo fills this week. Flat is a position — 0 rule breaks, GPA 4.0 by default. 🎯"
        print(msg)
        if args.send:
            tg(msg)
        return 0

    # dust filter — micro recurring crypto buys (median $0.16) aren't decisions;
    # grading them buries the real fills in noise (same cutoff as the report card).
    dust = [f for f in fills
            if abs(f["amount_usd"] or (f["qty"] * f["price"]) or 0) < DUST_MAX_USD]
    fills = [f for f in fills if f not in dust]
    if not fills:
        msg = (f"{header}\n\nOnly {len(dust)} dust fills (<${DUST_MAX_USD:.0f}) this week — "
               "no real decisions to grade. GPA 4.0 by default. 🎯")
        print(msg)
        if args.send:
            tg(msg)
        return 0

    closes_map = load_closes({(f["symbol"].upper(), f["asset_class"]) for f in fills})

    lines: list[str] = []
    grades: list[str] = []
    fail_count = 0
    for f in fills:
        g, flags = grade_fill(f, med, closes_map, book, core, tix)
        grades.append(g)
        if g == "F":
            fail_count += 1
        usd = abs(f["amount_usd"] or (f["qty"] * f["price"]) or 0)
        day = f["filled_at"][:10]
        badge = {"A": "🟢", "C": "🟡", "F": "🔴"}[g]
        line = f"{badge} {g} · {day} {f['side'].upper()} {f['symbol']} ${usd:,.0f} ({f['asset_class']})"
        lines.append(line)
        for fl in flags:
            lines.append(f"      ↳ {fl}")

    gpa = sum(GPA[g] for g in grades) / len(grades)
    n = len(grades)
    counts = {g: grades.count(g) for g in "ACF" if grades.count(g)}
    summary = ((f"{n} fills ({len(dust)} dust skipped) · " if dust else f"{n} fills · ") +
               f"GPA {gpa:.2f} · " +
               " ".join(f"{v}×{k}" for k, v in counts.items()) +
               (f" · {fail_count} rule break{'s' if fail_count != 1 else ''}" if fail_count else " · zero rule breaks 🎯"))

    msg = f"{header}\n{summary}\n\n" + "\n".join(lines)
    msg += ("\n\nRules: 4=sizing 5=chase 3=dead-bag 1=core · sells graded for "
            "early-exit once 30d of future exists · gate first: /?page=gate")

    print(msg)

    OUT_DIR.mkdir(exist_ok=True)
    out_md = OUT_DIR / f"{now_et:%Y-%m-%d}.md"
    out_md.write_text(f"# Weekly Fill Review — {now_et:%Y-%m-%d}\n\n```\n{msg}\n```\n")

    if args.send:
        # Telegram hard-caps messages at 4096 chars — split on line boundaries
        chunk: list[str] = []
        size = 0
        for ln in msg.split("\n"):
            if size + len(ln) + 1 > 3900:
                tg("\n".join(chunk))
                chunk, size = [], 0
            chunk.append(ln)
            size += len(ln) + 1
        if chunk:
            tg("\n".join(chunk))
    return 0


if __name__ == "__main__":
    sys.exit(main())
