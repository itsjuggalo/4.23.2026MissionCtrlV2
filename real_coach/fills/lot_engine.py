#!/usr/bin/env python3
"""lot_engine.py — FIFO over the fills vault → open lots, closed round-trips, CB basis.

Generalizes rh_crypto_basis.py's deque-FIFO (incl. reconcile-to-live and the
`partial` flag) across ALL four sources. Derived tables (lots, round_trips) are
rebuilt from scratch each run — fills are the source of truth.

Also writes Coinbase remaining-lot basis into ~/portfolio/crypto_cost_basis.json
under broker-qualified keys ("coinbase:ETH") — portfolio_book._basis_for() already
reads those, so CB basis appears in unified_book with zero changes there.
Options: long-only matching (buy/open → sell/close per OCC); expired-open lots
emit a −100% round-trip at expiry. Transfers (synthetic) open lots flagged
synthetic → "basis est." downstream; sends consume lots without a round-trip
(a transfer is not a trade decision).

Usage: lot_engine.py [--rebuild] [--write-basis]
"""
from __future__ import annotations

import argparse
import json
import re
import sys
from collections import defaultdict, deque
from datetime import datetime, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent.parent))

from real_coach.fills import db  # noqa: E402

BASIS_OUT = Path.home() / "portfolio" / "crypto_cost_basis.json"
BOOK = Path.home() / "portfolio" / "unified_book.json"
OCC_RE = re.compile(r"^(?P<root>[A-Z.]{1,6})\s*(?P<d>\d{6})(?P<k>[CP])(?P<strike>\d{8})$")


def _dt(s: str) -> datetime:
    try:
        return datetime.fromisoformat(str(s).replace("Z", "+00:00"))
    except Exception:
        return datetime(1970, 1, 1, tzinfo=timezone.utc)


def _occ_expiry(occ: str | None) -> datetime | None:
    if not occ:
        return None
    m = OCC_RE.match(occ.replace("  ", " ").strip())
    if not m:
        return None
    try:
        return datetime.strptime("20" + m.group("d"), "%Y%m%d").replace(tzinfo=timezone.utc)
    except Exception:
        return None


def rebuild(con) -> dict:
    # preserve bias grades (fwd_ret_30d / max_drawdown_pct, written by bias_report.py)
    # across the wipe — rebuild is derived-data hygiene, not grade amnesia
    saved = {(r[0], r[1], r[2], str(r[3])[:19], str(r[4])[:19], round(r[5], 6)): (r[6], r[7])
             for r in con.execute(
                 "SELECT broker, asset_class, symbol, entry_at, exit_at, qty,"
                 " fwd_ret_30d, max_drawdown_pct FROM round_trips "
                 "WHERE fwd_ret_30d IS NOT NULL OR max_drawdown_pct IS NOT NULL")}
    con.execute("DELETE FROM lots")
    con.execute("DELETE FROM round_trips")
    fills = con.execute(
        "SELECT broker, asset_class, symbol, occ_symbol, side, position_effect, qty, price,"
        " amount_usd, filled_at, synthetic FROM fills ORDER BY filled_at, id").fetchall()

    lots: dict[tuple, deque] = defaultdict(deque)   # key -> deque[[qty, px, at, synth]]
    trips = []
    skipped_short = 0
    for (broker, ac, sym, occ, side, effect, qty, px, amt, at, synth) in fills:
        mult = 100.0 if ac == "option" else 1.0
        key = (broker, ac, occ or sym) if ac == "option" else (broker, ac, sym)
        if ac == "option" and side == "sell" and (effect or "") == "open":
            skipped_short += 1          # short premium legs: not FIFO-long material
            continue
        is_open = (side == "buy") if ac != "option" else (side == "buy" and (effect or "open") != "close")
        if is_open:
            lots[key].append([qty, px, at, synth])
            continue
        # disposal: consume FIFO
        rem = qty
        dq = lots[key]
        while rem > 1e-12 and dq:
            lot = dq[0]
            take = min(rem, lot[0])
            lot[0] -= take
            rem -= take
            entry_px, entry_at, lot_synth = lot[1], lot[2], lot[3]
            if synth == 0 and not (ac == "crypto" and (effect or "") == "send"):
                pnl = (px - entry_px) * take * mult
                pnl_pct = ((px / entry_px) - 1) * 100 if entry_px else None
                hold = (_dt(at) - _dt(entry_at)).total_seconds() / 86400.0
                trips.append((broker, ac, sym, occ, take, entry_px, px, entry_at, at,
                              round(pnl, 2), round(pnl_pct, 2) if pnl_pct is not None else None,
                              round(hold, 2)))
            if lot[0] <= 1e-12:
                dq.popleft()
        # oversell (transfers FIFO never saw) — ignore remainder, reconcile handles it

    # expired-open option lots → −100% round-trips at expiry
    now = datetime.now(timezone.utc)
    for (broker, ac, key_sym), dq in list(lots.items()):
        if ac != "option":
            continue
        exp = _occ_expiry(key_sym)
        if exp and exp < now:
            for lot in dq:
                if lot[0] > 1e-12:
                    hold = (exp - _dt(lot[2])).total_seconds() / 86400.0
                    under = key_sym.split(" ")[0]
                    trips.append((broker, ac, under, key_sym, lot[0], lot[1], 0.0,
                                  lot[2], exp.isoformat(), round(-lot[1] * lot[0] * 100, 2),
                                  -100.0, round(hold, 2)))
            lots[(broker, ac, key_sym)] = deque()

    con.executemany(
        "INSERT INTO round_trips(broker,asset_class,symbol,occ_symbol,qty,entry_px,exit_px,"
        "entry_at,exit_at,pnl_usd,pnl_pct,hold_days) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", trips)
    if saved:
        regraded = 0
        for row in con.execute("SELECT id, broker, asset_class, symbol, entry_at, exit_at,"
                               " qty FROM round_trips").fetchall():
            key = (row[1], row[2], row[3], str(row[4])[:19], str(row[5])[:19],
                   round(row[6], 6))
            if key in saved:
                fwd, mdd = saved[key]
                con.execute("UPDATE round_trips SET fwd_ret_30d=?, max_drawdown_pct=? "
                            "WHERE id=?", (fwd, mdd, row[0]))
                regraded += 1
        print(f"grades preserved on {regraded}/{len(saved)} trips")
    lot_rows = [(b, a, s, l[0], l[1], l[2], l[3])
                for (b, a, s), dq in lots.items() for l in dq if l[0] > 1e-12]
    con.executemany(
        "INSERT INTO lots(broker,asset_class,symbol,qty,price,opened_at,synthetic) "
        "VALUES(?,?,?,?,?,?,?)", lot_rows)
    con.commit()
    return {"round_trips": len(trips), "open_lots": len(lot_rows),
            "skipped_short_option_legs": skipped_short}


def write_cb_basis(con) -> int:
    """Remaining-lot CB basis → crypto_cost_basis.json coinbase:* keys (reconciled to live)."""
    live = {}
    try:
        book = json.loads(BOOK.read_text())
        for p in book.get("positions", []):
            if p.get("broker") == "coinbase" and p.get("asset_class") == "crypto":
                live[p["symbol"].upper()] = float(p.get("qty") or 0)
    except Exception:
        pass
    basis = {}
    try:
        basis = json.loads(BASIS_OUT.read_text())
    except Exception:
        pass
    rows = con.execute(
        "SELECT symbol, qty, price, synthetic FROM lots WHERE broker='coinbase' "
        "AND asset_class='crypto' ORDER BY opened_at").fetchall()
    per = defaultdict(list)
    for sym, qty, px, synth in rows:
        per[sym.upper()].append([qty, px, synth])
    wrote = 0
    for sym, dq0 in per.items():
        lq = live.get(sym)
        if lq is None or lq <= 1e-9:
            continue
        dq = deque(dq0)
        fifo_qty = sum(l[0] for l in dq)
        if fifo_qty > lq + 1e-9:      # transfers off CB: drop oldest lots to match live
            drop = fifo_qty - lq
            while drop > 1e-12 and dq:
                take = min(drop, dq[0][0])
                dq[0][0] -= take
                drop -= take
                if dq[0][0] <= 1e-12:
                    dq.popleft()
        qty = sum(l[0] for l in dq)
        cost = sum(l[0] * l[1] for l in dq)
        any_synth = any(l[2] for l in dq)
        partial = (lq > qty + 1e-6) or any_synth
        if qty > 1e-9 and cost > 0:
            basis[f"coinbase:{sym}"] = {
                "qty": round(qty, 8), "cost_basis": round(cost, 2),
                **({"partial": True, "live_qty": round(lq, 8)} if partial else {})}
            wrote += 1
            tag = "  ⚠ est/partial" if partial else ""
            print(f"  coinbase:{sym}  basis-qty {qty:.6f} / held {lq:.6f}  ${cost:,.2f}{tag}")
    BASIS_OUT.write_text(json.dumps(basis, indent=2))
    return wrote


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--rebuild", action="store_true")
    ap.add_argument("--write-basis", action="store_true")
    a = ap.parse_args()
    con = db.connect()
    if a.rebuild or not (a.write_basis,):
        info = rebuild(con)
        print(f"rebuilt: {info}")
    if a.write_basis:
        n = write_cb_basis(con)
        print(f"CB basis written for {n} symbols → {BASIS_OUT}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
