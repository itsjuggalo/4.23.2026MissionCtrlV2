#!/usr/bin/env python3
"""coach.py — sweep Mike's REAL book (RH+CB) → verdicts → Telegram digest + cards.

Usage:
  coach.py --sweep                      # full sweep, print digest
  coach.py --sweep --send               # ...and Telegram it (trading_command lane)
  coach.py --sweep --changes-only       # only report verdict flips since last sweep
  coach.py --sweep --crypto-only        # weekend crypto pass
  coach.py --symbol DOGE                # one-name deep read (full reasons)
  coach.py --triage-cb                  # Coinbase bag triage only
  coach.py --selftest                   # advisory-only guard: forbid order endpoints
  coach.py --json                       # machine output (coach_verdicts.json shape)

Advisory only. Writes ~/portfolio/coach_verdicts.json (atomic) for dashboards/alerts.
Cron-safe: never raises, exit 0, logs to stdout.
"""
from __future__ import annotations

import argparse
import json
import subprocess
import sys
import traceback
from pathlib import Path

SCRIPTS = Path(__file__).resolve().parent.parent
sys.path.insert(0, str(SCRIPTS))

from real_coach import book as bookmod  # noqa: E402
from real_coach.verdict import assess_position  # noqa: E402
from real_coach import cards  # noqa: E402

TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
TG_FN = "trading_command"
MAX_CARDS = 3


def tg_send(msg: str) -> bool:
    try:
        out = subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, msg],
                             capture_output=True, text=True, timeout=30)
        ok = out.returncode == 0 and "sent" in (out.stdout or "")
        if not ok:
            print(f"tg_send failed: {out.stdout} {out.stderr}".strip())
        return ok
    except Exception:
        print("tg_send error:\n" + traceback.format_exc())
        return False


def tg_photo(path: str, caption: str) -> bool:
    try:
        out = subprocess.run([sys.executable, str(TG_FLEET), "sendmedia", TG_FN, path, caption],
                             capture_output=True, text=True, timeout=60)
        ok = out.returncode == 0
        if not ok:
            print(f"tg_photo failed: {out.stdout} {out.stderr}".strip())
        return ok
    except Exception:
        print("tg_photo error:\n" + traceback.format_exc())
        return False


def selftest() -> int:
    """Advisory-only guard: no ORDER-PLACING code may exist anywhere in this package.

    Reads are fine (the fills vault pages GET /orders/ history); what's banned is any
    write verb or a request built with a POST body.
    """
    banned = ("submit_order", "place_order", "create_order", "sendOrder",  # banlist
              "market_buy", "market_sell", 'method="POST"', "method='POST'",  # banlist
              "orders create", ".post(")  # banlist
    bad = []
    pkg = Path(__file__).resolve().parent
    files = sorted(pkg.rglob("*.py"))
    for f in files:
        for ln, line in enumerate(f.read_text().splitlines(), 1):
            if "# banlist" in line or "Request(\" in line" in line:
                continue  # the banlist / scanner itself
            for b in banned:
                if b in line:
                    bad.append(f"{f.relative_to(pkg)}:{ln}: contains '{b}'")
            if ("Request(" in line and "data=" in line
                    and "api.telegram.org" not in line):  # TG sends are fine; brokers aren't
                bad.append(f"{f.relative_to(pkg)}:{ln}: HTTP request with a body")
    if bad:
        print("SELFTEST FAIL (advisory-only violated):\n" + "\n".join(bad))
        return 1
    print(f"selftest OK — {len(files)} files (recursive), zero order-placing code")
    return 0


def run_sweep(crypto_only=False, changes_only=False, one_symbol=None,
              triage_cb=False, with_fund=True) -> dict:
    cfg = bookmod.load_config()
    state = bookmod.load_state()
    book = bookmod.load_book()
    invested = float(book.get("invested_value") or 0)
    rows = bookmod.positions(book, crypto_only=crypto_only)
    if one_symbol:
        rows = [p for p in rows if p["symbol"].upper() == one_symbol.upper()]
    if triage_cb:
        rows = [p for p in rows if p.get("broker") == "coinbase"]

    results = []
    for p in rows:
        try:
            results.append(assess_position(p, cfg, state, invested, with_fundamentals=with_fund))
        except Exception:
            print(f"assess failed for {p.get('symbol')}:\n" + traceback.format_exc())

    # verdict-flip diff vs last sweep
    last = state.get("last_verdicts", {})
    flips = [r for r in results if last.get(r["key"]) and last[r["key"]] != r["verdict"]]
    for r in results:
        state.setdefault("last_verdicts", {})[r["key"]] = r["verdict"]
    bookmod.save_state(state)

    out = {"as_of": bookmod.now_et(), "book_total": book.get("total_value"),
           "invested": invested, "n": len(results),
           "results": results, "flips": [r["key"] for r in flips]}
    bookmod.atomic_write(bookmod.VERDICTS, out)
    # decision ledger (P3): record every TA verdict for outcome scoring
    try:
        from real_coach import ledger
        out["decision_ids"] = ledger.insert_decisions(results, out["as_of"])
    except Exception:
        print("ledger insert failed:\n" + traceback.format_exc())
        out["decision_ids"] = {}
    return out


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--sweep", action="store_true")
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--changes-only", action="store_true")
    ap.add_argument("--crypto-only", action="store_true")
    ap.add_argument("--symbol")
    ap.add_argument("--triage-cb", action="store_true")
    ap.add_argument("--json", action="store_true")
    ap.add_argument("--no-fund", action="store_true", help="skip fundamentals (faster)")
    ap.add_argument("--no-cards", action="store_true", help="text only, no chart PNGs")
    ap.add_argument("--selftest", action="store_true")
    a = ap.parse_args()

    if a.selftest:
        return selftest()
    if not (a.sweep or a.symbol or a.triage_cb):
        ap.print_help()
        return 0

    try:
        out = run_sweep(crypto_only=a.crypto_only, changes_only=a.changes_only,
                        one_symbol=a.symbol, triage_cb=a.triage_cb,
                        with_fund=not a.no_fund)
    except Exception:
        print("sweep failed:\n" + traceback.format_exc())
        return 0  # cron-safe

    results = out["results"]
    if a.json:
        print(json.dumps(out, indent=1, default=str))
        return 0

    if a.symbol and results:
        r = results[0]
        print(f"{r['symbol']} [{r['bucket']}] → {r['verdict']}")
        for reason in r["reasons"]:
            print(f"  • {reason}")
        print(f"  levels: stop={r.get('stop')} trail={r.get('trail_stop')} tgt={r.get('target')}")
        if a.send:
            msg = (f"{cards.ICON.get(r['verdict'],'·')} {r['symbol']} [{r['bucket']}] → "
                   f"{r['verdict']}\n" + "\n".join(f"• {x}" for x in r["reasons"]))
            tg_send(msg[:4000])
            if not a.no_cards:
                png = cards.coach_card(r)
                if png:
                    tg_photo(png, f"{r['symbol']} → {r['verdict']}")
        return 0

    if a.changes_only:
        flipped = [r for r in results if r["key"] in set(out["flips"])]
        if not flipped:
            print(f"{out['as_of']} — no verdict changes ({len(results)} positions checked)")
            return 0
        title = "COACH — VERDICT CHANGES"
        msgs = cards.digest_text(flipped, {"total_value": out["book_total"],
                                           "invested_value": out["invested"]},
                                 out["as_of"], title=title)
    else:
        msgs = cards.digest_text(results, {"total_value": out["book_total"],
                                           "invested_value": out["invested"]},
                                 out["as_of"],
                                 title="CB BAG TRIAGE" if a.triage_cb else "REAL BOOK COACH")

    for m in msgs:
        print(m + "\n" + "─" * 40)
    if a.send:
        for m in msgs:
            tg_send(m)
        if not a.no_cards:
            actionable = [r for r in results
                          if r["verdict"] in ("TRIM", "EXIT_ON_BOUNCE", "ADD", "EXIT")
                          and r["mode"] == "ta"]
            actionable.sort(key=lambda r: -r["mv"])
            for r in actionable[:MAX_CARDS]:
                png = cards.coach_card(r)
                if png:
                    tg_photo(png, f"{r['symbol']} → {r['verdict']} · {r['reasons'][0][:120]}")
            # FOLLOW/OVERRIDE buttons on the top actionables (PipelineSignals lane)
            try:
                from real_coach import ledger
                dids = out.get("decision_ids") or {}
                for r in actionable[:MAX_CARDS]:
                    did = dids.get(r["key"])
                    if did:
                        ledger.send_decision_buttons(r, did)
            except Exception:
                print("decision buttons failed:\n" + traceback.format_exc())
    return 0


if __name__ == "__main__":
    sys.exit(main())
