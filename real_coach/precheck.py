#!/usr/bin/env python3
"""precheck.py — the coach's pre-trade checklist authority (entry/stop/target/size).

Mike's #1 leak-guard turned MECHANICAL instead of willpower: no SATELLITE entry
may be logged without a hard stop. If Mike doesn't supply one, the coach COMPUTES
a structural stop from the same TA the sweep uses (support / swing-low floored to
1.5·ATR, never looser than the satellite hard-stop %). If not even a percent stop
can be pinned (no entry price and no candle history) the entry is HARD-BLOCKED —
fail-closed: you cannot size risk without a stop.

Core positions ride the thesis / EMA50 rule (verdict.py) and are NOT force-stopped
to a tight %, but a buy with NO resolvable stop is still blocked for any bucket.

Every check is written to mike.sqlite:pre_trade_checks — a DEDICATED table, kept
out of decision_ledger so it never pollutes the sweep-verdict scorers
(score_decisions.py / scoreboard.py). Advisory: never places or cancels an order.

CLI:
  precheck.py --symbol TSLA --class stock --side buy --size 250 --entry 340 \
              [--stop 325] [--target 370] [--broker rh] [--thesis "..."] [--json]
  precheck.py --symbol DOGE --class crypto --entry 0.16 --compute-stop-only --json
"""
from __future__ import annotations

import argparse
import json
import sqlite3
import sys
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

SCRIPTS = Path(__file__).resolve().parent.parent  # 05_AUTOMATION/scripts
sys.path.insert(0, str(SCRIPTS))

from real_coach import book as bookmod  # noqa: E402
from real_coach import symbols as symmod  # noqa: E402

DB = Path.home() / "portfolio" / "mike.sqlite"
ET = ZoneInfo("America/New_York")

# risk caps mirror the missionctrl Trade Ticket route (single source of truth for
# the numbers Mike sees on the dashboard).
MAX_LOSS_PER_TRADE = 75      # hard $ risk cap per trade (stock/crypto)
OPTION_MAX_TICKET = 300      # premium ticket cap (options)
OPTION_STOP_PCT = 50         # fixed −50% of premium stop (options)
RR_WARN = 1.5                # warn (allow) below this reward:risk


def _et_iso() -> str:
    return datetime.now(ET).strftime("%Y-%m-%dT%H:%M:%S ET")


def connect() -> sqlite3.Connection:
    con = sqlite3.connect(str(DB), timeout=30)
    ensure_table(con)
    return con


def ensure_table(con: sqlite3.Connection) -> None:
    con.execute(
        "CREATE TABLE IF NOT EXISTS pre_trade_checks("
        " id INTEGER PRIMARY KEY, ts TEXT NOT NULL, source TEXT,"
        " symbol TEXT, asset_class TEXT, broker TEXT, bucket TEXT,"
        " side TEXT, size_usd REAL, entry REAL, stop REAL, stop_source TEXT,"
        " computed_stop REAL, target REAL, risk_usd REAL, rr REAL,"
        " verdict TEXT, blocked INTEGER, reasons TEXT)")
    con.commit()


# ── structural stop, the same shape the sweep uses (verdict.py) ────────────────
def compute_stop(symbol: str, asset_class: str, entry: float | None,
                 direction: str = "long", cfg: dict | None = None) -> tuple:
    """(stop, source, meta). Fail-open: returns (None, 'none', …) only when neither
    a structural, a %-hard, nor even a reference price can be established."""
    cfg = cfg or bookmod.load_config()
    hard_pct = cfg["rules"].get("satellite_hard_stop_pct", 10)
    direction = "short" if str(direction).lower() == "short" else "long"

    ref = float(entry) if entry not in (None, "") and float(entry) > 0 else None

    ta = None
    try:
        from ta_engine.verdict import analyze  # local import: heavy, network
        tsym = symmod.ta_symbol(symbol, asset_class)
        ta = analyze(tsym, side=direction, asset_type=asset_class, period="1y")
        if ta.get("error"):
            ta = None
        elif float(ta.get("current") or 0) < 0.05:  # sub-nickel alts → TA is noise
            ta = None
    except Exception:
        ta = None

    if ref is None and ta:
        ref = float(ta["current"])
    if ref is None or ref <= 0:
        return None, "none", {"ta": bool(ta), "ref": None}

    # structural candidate (below entry for a long / above for a short)
    struct = None
    if ta:
        ind, lv = ta.get("indicators", {}), ta.get("levels", {})
        atr = ind.get("atr14")
        if direction == "long":
            sup = (lv.get("supports") or [])
            cands = [x for x in ((sup[-1] if sup else None), lv.get("swing_low")) if x and x < ref]
            if cands:
                struct = max(cands)
            if atr:
                struct = max(struct or 0, ref - 1.5 * atr) if struct else ref - 1.5 * atr
        else:
            res = (lv.get("resistances") or [])
            cands = [x for x in ((res[0] if res else None), lv.get("swing_high")) if x and x > ref]
            if cands:
                struct = min(cands)
            if atr:
                struct = min(struct if struct is not None else 1e18, ref + 1.5 * atr)
        if struct is not None and struct <= 0:
            struct = None

    # %-hard floor: a stop no looser than hard_pct from entry (satellite discipline)
    hard = ref * (1 - hard_pct / 100) if direction == "long" else ref * (1 + hard_pct / 100)

    if struct is not None:
        # tighter-risk of the two: for a long that's the HIGHER stop, for a short the LOWER
        stop = max(struct, hard) if direction == "long" else min(struct, hard)
        source = "structural+hardfloor"
    else:
        stop = hard
        source = f"hard-{hard_pct}pct" + ("" if ta else "(no-ta)")

    return round(float(stop), 6), source, {"ta": bool(ta), "ref": ref}


# ── the checklist ──────────────────────────────────────────────────────────────
def precheck(symbol: str, asset_class: str, side: str = "buy",
             size_usd: float | None = None, entry: float | None = None,
             stop: float | None = None, target: float | None = None,
             thesis: str | None = None, broker: str | None = None,
             direction: str | None = None, cfg: dict | None = None) -> dict:
    cfg = cfg or bookmod.load_config()
    symbol = symbol.upper().strip()
    asset_class = (asset_class or "stock").lower()
    side = "sell" if str(side).lower() == "sell" else "buy"
    is_option = asset_class == "option"
    direction = direction or ("short" if side == "sell" and not is_option else "long")
    # precheck governs pre-trade ENTRIES — a buy opens a long, a sell opens a short.
    # BOTH must clear the stop gate; only a buy gets the fixed −50% option-premium stop.
    is_entry = side in ("buy", "sell")
    bucket = bookmod.bucket_of(symbol, "stock" if is_option else asset_class, cfg)

    entry = float(entry) if entry not in (None, "") else None
    manual_stop = float(stop) if stop not in (None, "") else None
    target = float(target) if target not in (None, "") else None
    size_usd = float(size_usd) if size_usd not in (None, "") else None

    checks: list[dict] = []
    computed_stop = None
    stop_source = "manual" if manual_stop is not None else None
    resolved_stop = manual_stop

    # ── STOP gate — the #1 rule, mechanical (runs for every entry, long or short) ──
    if is_entry:
        if is_option and side == "buy":
            # long option: stop is a fixed −50% of premium — always defined once entry set.
            if entry is not None:
                resolved_stop = round(entry * (1 - OPTION_STOP_PCT / 100), 6)
                stop_source = stop_source or f"option-{OPTION_STOP_PCT}pct"
        if resolved_stop is None:
            computed_stop, csrc, _ = compute_stop(symbol, asset_class, entry, direction, cfg)
            if computed_stop is not None:
                resolved_stop, stop_source = computed_stop, csrc
        # hard-block: an entry with NO stop and none computable → cannot log
        if resolved_stop is None:
            checks.append({
                "name": "Hard stop", "level": "STOP",
                "detail": (f"{bucket.upper()} {symbol} {side} has no stop and none could be "
                           f"computed (give an entry price so a {cfg['rules'].get('satellite_hard_stop_pct',10)}% "
                           f"stop can be pinned, or type a stop). Rule #1: no entry without a stop.")})
        elif manual_stop is None:
            checks.append({
                "name": "Hard stop", "level": "GO",
                "detail": (f"No stop given — coach computed one at ${_fmt(resolved_stop)} "
                           f"({stop_source}). Set this (or tighter) before you fill.")})
        else:
            # validate manual stop sits on the protective side
            if entry is not None and direction == "long" and manual_stop >= entry:
                checks.append({"name": "Hard stop", "level": "STOP",
                               "detail": f"Long stop ${_fmt(manual_stop)} must be BELOW entry ${_fmt(entry)}."})
            elif entry is not None and direction == "short" and manual_stop <= entry:
                checks.append({"name": "Hard stop", "level": "STOP",
                               "detail": f"Short stop ${_fmt(manual_stop)} must be ABOVE entry ${_fmt(entry)}."})
            else:
                checks.append({"name": "Hard stop", "level": "GO",
                               "detail": f"Stop ${_fmt(manual_stop)} set — risk is defined before the fill."})

    # ── risk $, R:R, sizing (advisory warnings; the STOP block is what gates) ──
    risk_usd = None
    rr = None
    if is_entry and entry and resolved_stop and entry > 0:
        risk_per_unit = abs(entry - resolved_stop) / entry
        if is_option:
            risk_usd = round((size_usd or 0) * OPTION_STOP_PCT / 100, 2) if size_usd else None
            if size_usd and size_usd > OPTION_MAX_TICKET:
                checks.append({"name": "Option ticket", "level": "STOP",
                               "detail": f"Premium ticket ${size_usd:.0f} over the ${OPTION_MAX_TICKET} cap."})
        else:
            risk_usd = round((size_usd or 0) * risk_per_unit, 2) if size_usd else None
            if risk_usd is not None and risk_usd > MAX_LOSS_PER_TRADE:
                max_size = int(MAX_LOSS_PER_TRADE / risk_per_unit) if risk_per_unit > 0 else 0
                checks.append({"name": "Risk cap", "level": "STOP",
                               "detail": f"Risk ${risk_usd:.2f} over the ${MAX_LOSS_PER_TRADE} cap — cut size to ≤ ${max_size} or tighten the stop."})
            med = _median_buy(cfg)
            size_cap = round(med * 10, 2)
            if size_usd and size_usd > size_cap:
                checks.append({"name": "Sizing", "level": "CAUTION",
                               "detail": f"${size_usd:.0f} over your ${size_cap:.0f} cap (10× ${med} median buy) — needs a typed plan."})
        if target and resolved_stop != entry:
            rr = round((target - entry) / (entry - resolved_stop), 2)
            if rr > 0 and rr < RR_WARN:
                checks.append({"name": "Reward:risk", "level": "CAUTION",
                               "detail": f"R:R {rr:.2f} below {RR_WARN} — allowed, but thin."})

    if not checks:
        checks.append({"name": "Pre-check", "level": "GO",
                       "detail": f"{bucket} {symbol} {side} — checklist clear."})

    verdict = "GO"
    for c in checks:
        if c["level"] == "STOP":
            verdict = "STOP"
            break
        if c["level"] == "CAUTION":
            verdict = "CAUTION"
    blocked = verdict == "STOP"

    return {
        "ok": True, "symbol": symbol, "asset_class": asset_class, "bucket": bucket,
        "side": side, "direction": direction, "size_usd": size_usd, "entry": entry,
        "stop": resolved_stop, "manual_stop": manual_stop, "computed_stop": computed_stop,
        "stop_source": stop_source, "target": target, "risk_usd": risk_usd, "rr": rr,
        "verdict": verdict, "blocked": blocked, "checks": checks,
    }


def _fmt(x) -> str:
    if x is None:
        return "?"
    if abs(x) < 1:
        return f"{x:,.4f}"
    return f"{x:,.2f}"


def _median_buy(cfg: dict) -> float:
    try:
        con = sqlite3.connect(str(DB), timeout=5)
        dust = float(cfg.get("dust_max_usd", 5))
        rows = con.execute(
            "SELECT ABS(amount_usd) v FROM fills WHERE side='buy' AND amount_usd IS NOT NULL"
            " AND ABS(amount_usd) >= ? ORDER BY v", (dust,)).fetchall()
        con.close()
        if not rows:
            return 100.0
        vals = [r[0] for r in rows]
        mid = len(vals) // 2
        med = vals[mid] if len(vals) % 2 else (vals[mid - 1] + vals[mid]) / 2
        return round(med, 2) or 100.0
    except Exception:
        return 100.0


def log_check(result: dict, source: str = "cli", broker: str | None = None) -> int | None:
    try:
        con = connect()
        cur = con.execute(
            "INSERT INTO pre_trade_checks(ts, source, symbol, asset_class, broker, bucket,"
            " side, size_usd, entry, stop, stop_source, computed_stop, target, risk_usd, rr,"
            " verdict, blocked, reasons) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
            (_et_iso(), source, result["symbol"], result["asset_class"], broker,
             result["bucket"], result["side"], result["size_usd"], result["entry"],
             result["stop"], result["stop_source"], result["computed_stop"], result["target"],
             result["risk_usd"], result["rr"], result["verdict"],
             1 if result["blocked"] else 0,
             json.dumps([f"{c['level']}:{c['name']}" for c in result["checks"]])))
        con.commit()
        rid = cur.lastrowid
        con.close()
        return rid
    except Exception as e:
        print(f"log_check failed: {e}", file=sys.stderr)
        return None


def main() -> int:
    ap = argparse.ArgumentParser(description="coach pre-trade checklist")
    ap.add_argument("--symbol", required=True)
    ap.add_argument("--class", dest="asset_class", default="stock",
                    help="stock | crypto | option")
    ap.add_argument("--side", default="buy")
    ap.add_argument("--size", dest="size_usd", type=float)
    ap.add_argument("--entry", type=float)
    ap.add_argument("--stop", type=float)
    ap.add_argument("--target", type=float)
    ap.add_argument("--direction")
    ap.add_argument("--thesis")
    ap.add_argument("--broker")
    ap.add_argument("--source", default="cli")
    ap.add_argument("--compute-stop-only", action="store_true")
    ap.add_argument("--no-log", action="store_true")
    ap.add_argument("--json", action="store_true")
    a = ap.parse_args()

    if a.compute_stop_only:
        stop, source, meta = compute_stop(a.symbol, a.asset_class, a.entry,
                                          a.direction or "long")
        out = {"ok": True, "symbol": a.symbol.upper(), "stop": stop,
               "stop_source": source, "ref": meta.get("ref"), "ta": meta.get("ta")}
        print(json.dumps(out) if a.json else f"stop ${_fmt(stop)} ({source})")
        return 0

    r = precheck(a.symbol, a.asset_class, a.side, a.size_usd, a.entry, a.stop,
                 a.target, a.thesis, a.broker, a.direction)
    if not a.no_log:
        r["logged_id"] = log_check(r, a.source, a.broker)

    if a.json:
        print(json.dumps(r))
    else:
        icon = {"GO": "✓", "CAUTION": "⚠", "STOP": "✕"}[r["verdict"]]
        print(f"{icon} {r['verdict']} — {r['bucket']} {r['symbol']} {r['side']}"
              f"{' [BLOCKED]' if r['blocked'] else ''}")
        if r["stop"] is not None:
            print(f"   stop ${_fmt(r['stop'])} ({r['stop_source']})"
                  + (f" · risk ${r['risk_usd']:.2f}" if r['risk_usd'] is not None else "")
                  + (f" · R:R {r['rr']:.2f}" if r['rr'] is not None else ""))
        for c in r["checks"]:
            print(f"   [{c['level']}] {c['name']}: {c['detail']}")
    return 2 if r["blocked"] else 0


if __name__ == "__main__":
    raise SystemExit(main())
