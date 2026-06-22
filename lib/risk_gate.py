#!/usr/bin/env python3
"""risk_gate.py — read-only ADVISORY risk sign-off over candidate trades.

For each READY candidate in decipher_picks it computes a Risk verdict — APPROVE / RESIZE(to N) /
REJECT(reason) — against:
  - per-trade risk cap (max-loss = est_cost x stop_loss_pct) <= $250 (current acct),
  - portfolio-fraction cap (est_cost <= max_pos_pct x equity),
  - intra-batch concentration (same ticker appearing more than once),
and prints a one-line max-loss statement per pick.

ADVISORY ONLY: it READS decipher_picks and LOGS its verdicts to a separate jsonl. It does NOT
modify decipher_picks, does NOT block execution, and is NOT imported by select_and_size.py. Making
execution HONOR these verdicts is a separate, trade-changing step that needs Mike's explicit go.

Usage:
  risk_gate.py                       # latest READY candidates from the desk DB
  risk_gate.py --equity 3000 --max-risk 250 --max-pos-pct 0.5
  risk_gate.py --demo                # sample candidates (offline; shows APPROVE/RESIZE/REJECT)
  risk_gate.py --no-log
  risk_gate.py --self-test
"""
import argparse, json, math, os, sqlite3, sys, datetime
from pathlib import Path

DB  = Path(os.path.expanduser("~/LapClaw/pipeline/desk_pipeline.sqlite"))
LOG = Path(os.path.expanduser("~/.openclaw/workspace/memory/risk_gate_verdicts.jsonl"))

DEMO = [
    {"ticker": "NVDA", "account": "Boba", "contracts": 1, "ask": 2.04, "est_cost": 204.0, "stop_loss_pct": 30.0, "composite": 8.1},
    {"ticker": "TSLA", "account": "Boba", "contracts": 3, "ask": 4.20, "est_cost": 1260.0, "stop_loss_pct": 35.0, "composite": 9.4},  # oversized → RESIZE/REJECT
    {"ticker": "NVDA", "account": "Boba", "contracts": 2, "ask": 1.10, "est_cost": 220.0, "stop_loss_pct": 30.0, "composite": 7.0},  # 2nd NVDA → concentration
]


def now_et():
    try:
        from zoneinfo import ZoneInfo
        return datetime.datetime.now(ZoneInfo("America/New_York")).strftime("%Y-%m-%d %H:%M ET")
    except Exception:
        return datetime.datetime.now().strftime("%Y-%m-%d %H:%M")


def verdict_for(p, equity, max_risk, max_pos_pct, ticker_counts):
    """Return dict {verdict, detail, max_loss, suggested_contracts}. Pure; never mutates input."""
    ask = float(p.get("ask") or 0)
    contracts = int(p.get("contracts") or 0)
    est_cost = float(p.get("est_cost") or (ask * 100 * contracts))
    stop_pct = float(p.get("stop_loss_pct") or 100) / 100.0
    per_contract_cost = ask * 100 if ask > 0 else (est_cost / max(contracts, 1))
    per_contract_risk = per_contract_cost * stop_pct
    max_loss = est_cost * stop_pct

    pos_cap_cost = max_pos_pct * equity
    # contracts allowed by each constraint
    by_risk = math.floor(max_risk / per_contract_risk) if per_contract_risk > 0 else contracts
    by_pos  = math.floor(pos_cap_cost / per_contract_cost) if per_contract_cost > 0 else contracts
    allowed = max(0, min(contracts, by_risk, by_pos))

    notes = []
    if ticker_counts.get(p.get("ticker"), 0) > 1:
        notes.append(f"concentration: {ticker_counts[p['ticker']]}x {p.get('ticker')} in batch")

    if allowed == 0:
        binding = "per-trade risk" if by_risk == 0 else "position cap"
        v, detail = "REJECT", f"{binding} can't fit even 1 contract (1-lot risk ${per_contract_risk:.0f}, cap ${max_risk})"
    elif allowed < contracts:
        binding = "per-trade $250 risk" if by_risk < by_pos else f"{int(max_pos_pct*100)}% position cap"
        v, detail = "RESIZE", f"to {allowed} contract(s) — {binding} (was {contracts}, max-loss ${max_loss:.0f})"
    else:
        v, detail = "APPROVE", f"max-loss ${max_loss:.0f} <= ${max_risk}; cost ${est_cost:.0f} <= ${pos_cap_cost:.0f} cap"
    if notes:
        detail += " | " + "; ".join(notes)
    return {"verdict": v, "detail": detail, "max_loss": round(max_loss, 2), "suggested_contracts": allowed}


def read_ready():
    if not DB.exists():
        return []
    con = sqlite3.connect(f"file:{DB}?mode=ro", uri=True)
    con.row_factory = sqlite3.Row
    try:
        wid = con.execute("SELECT window_id FROM decipher_picks WHERE status='READY' "
                          "ORDER BY rowid DESC LIMIT 1").fetchone()
        if not wid:
            return []
        rows = con.execute(
            "SELECT ticker,account,contracts,ask,est_cost,stop_loss_pct,composite "
            "FROM decipher_picks WHERE status='READY' AND window_id=?", (wid[0],)).fetchall()
        return [dict(r) for r in rows]
    except Exception:
        return []
    finally:
        con.close()


def assess(picks, equity, max_risk, max_pos_pct):
    counts = {}
    for p in picks:
        counts[p.get("ticker")] = counts.get(p.get("ticker"), 0) + 1
    out = []
    for p in picks:
        out.append({**p, **verdict_for(p, equity, max_risk, max_pos_pct, counts)})
    return out


def _self_test():
    ok = True
    def chk(n, c):
        nonlocal ok; print(f"  [{'PASS' if c else 'FAIL'}] {n}"); ok = ok and c
    res = assess(DEMO, equity=3000, max_risk=250, max_pos_pct=0.5)
    by_t = {(r["ticker"], r["contracts"]): r for r in res}
    chk("small NVDA 1-lot APPROVE", by_t[("NVDA", 1)]["verdict"] == "APPROVE")
    tsla = by_t[("TSLA", 3)]
    chk("oversized TSLA not APPROVE", tsla["verdict"] in ("RESIZE", "REJECT"))
    chk("TSLA resized down", tsla["suggested_contracts"] < 3)
    chk("NVDA concentration noted", "concentration" in by_t[("NVDA", 2)]["detail"])
    chk("read-only: inputs unmutated", "verdict" not in DEMO[0])
    print("SELF-TEST:", "PASS" if ok else "FAIL")
    return 0 if ok else 1


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--equity", type=float, default=3000)
    ap.add_argument("--max-risk", type=float, default=250)
    ap.add_argument("--max-pos-pct", type=float, default=0.5)
    ap.add_argument("--demo", action="store_true")
    ap.add_argument("--no-log", action="store_true")
    ap.add_argument("--self-test", action="store_true")
    a = ap.parse_args()
    if a.self_test:
        return _self_test()

    picks = DEMO if a.demo else read_ready()
    if not picks:
        print("No READY candidates in the desk DB (market closed or none staged). Use --demo to dry-run.")
        return 0
    res = assess(picks, a.equity, a.max_risk, a.max_pos_pct)
    stamp = now_et()
    print(f"RISK GATE (advisory — not wired to execution) · {stamp} · equity ${a.equity:.0f} "
          f"· per-trade <= ${a.max_risk:.0f} · pos <= {int(a.max_pos_pct*100)}%")
    for r in res:
        print(f"  {r['verdict']:7} {r['ticker']:6} {r.get('account','?'):5} "
              f"{r.get('contracts')}x@{r.get('ask')} | {r['detail']}")
    if not a.no_log and not a.demo:
        LOG.parent.mkdir(parents=True, exist_ok=True)
        with open(LOG, "a") as f:
            f.write(json.dumps({"ts": stamp, "verdicts": res}) + "\n")
        print(f"(logged to {LOG} — advisory; execution not blocked)")
    return 0


if __name__ == "__main__":
    sys.exit(main())
