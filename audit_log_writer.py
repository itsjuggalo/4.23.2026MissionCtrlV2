#!/usr/bin/env python3
"""
Audit Log Writer (Step 4 of /silver-platter build plan, 2026-05-11).

MissionCtrl is a fully autonomous algo trading team — no human approval gates,
no manual sign-off before fills. The trust layer is therefore PROGRAMMATIC:
audit log + per-wallet drawdown caps + auto-trigger killswitches.

This script is the audit log half. It tails the existing journal files written
by Boba's decision cycle and post-trade outcomes, deduplicates, and appends one
line per event to silver_platters/audit_log/<YYYY-MM-DD>.jsonl. Does NOT touch
boba_decision_cycle.py — passive watcher only.

Schema of each audit log line:
{
  "ts": "2026-05-11T13:30:00Z",
  "ts_et": "2026-05-11 09:30:00 ET",
  "type": "execute" | "close",
  "asset_class": "options" | "crypto" | "stocks",
  "wallet": "alpaca_r2",
  "ticker_or_symbol": "NVDA",
  "details": { ...original record... },
  "source_file": "boba_daily_picks.json",
  "dedup_hash": "sha256:..."
}
"""
import hashlib, json, os, sys
from datetime import datetime, timezone, timedelta
from pathlib import Path

ET = timezone(timedelta(hours=-4))
NOW = datetime.now(timezone.utc)
NOW_ET = NOW.astimezone(ET)

PLATTERS_ROOT = Path("/home/ubuntu/.openclaw/data/silver_platters")
AUDIT_DIR = PLATTERS_ROOT / "audit_log"
STATE_FILE = Path("/home/ubuntu/.openclaw/workspace/state/audit_log_seen.json")

OPTIONS_PICKS = PLATTERS_ROOT / "boba_daily_picks_log" / "boba_daily_picks.json"
CRYPTO_PICKS = PLATTERS_ROOT / "boba_daily_picks_log" / "crypto_boba_daily.json"
OUTCOMES_DIR = PLATTERS_ROOT / "post_trade_outcomes" / "contract-outcomes"

# Wallet inference. Boba currently writes only to alpaca_r2 (paper). Update this
# table when wallets get added (Coinbase, Robinhood, Hyperliquid Personal).
WALLET_BY_SOURCE = {
    "boba_daily_picks.json": "alpaca_r2",
    "crypto_boba_daily.json": "alpaca_r2",
    "recent-30d.json": "alpaca_r2",
    "all-time.json": "alpaca_r2",
    "boba_picks_extracted.json": "alpaca_r2",
}


def load_state():
    if not STATE_FILE.exists():
        return {"seen_hashes": {}}
    try:
        return json.loads(STATE_FILE.read_text())
    except Exception:
        return {"seen_hashes": {}}


def save_state(state):
    STATE_FILE.parent.mkdir(parents=True, exist_ok=True)
    STATE_FILE.write_text(json.dumps(state))


def hash_record(record_dict, source_name):
    payload = json.dumps({"src": source_name, "rec": record_dict}, sort_keys=True)
    return "sha256:" + hashlib.sha256(payload.encode()).hexdigest()[:24]


def parse_iso_to_et(iso_str):
    if not iso_str:
        return None
    try:
        s = iso_str.replace("Z", "+00:00")
        dt = datetime.fromisoformat(s)
        if dt.tzinfo is None:
            dt = dt.replace(tzinfo=timezone.utc)
        return dt.astimezone(ET)
    except Exception:
        return None


def emit(record, day_files):
    """Append one audit line to the date's jsonl file."""
    et_dt = parse_iso_to_et(record.get("ts")) or NOW_ET
    date_str = et_dt.strftime("%Y-%m-%d")
    record["ts_et"] = et_dt.strftime("%Y-%m-%d %H:%M:%S ET")
    out_file = AUDIT_DIR / f"{date_str}.jsonl"
    if out_file not in day_files:
        day_files[out_file] = open(out_file, "a")
    day_files[out_file].write(json.dumps(record) + "\n")


def collect_options_picks(seen, day_files):
    if not OPTIONS_PICKS.exists():
        return 0
    try:
        data = json.loads(OPTIONS_PICKS.read_text())
    except Exception as e:
        return 0
    new = 0
    for pick in data.get("picks_today", []):
        h = hash_record(pick, "boba_daily_picks.json")
        if h in seen:
            continue
        seen[h] = True
        record = {
            "ts": pick.get("executed_at"),
            "type": "execute",
            "asset_class": "options",
            "wallet": WALLET_BY_SOURCE["boba_daily_picks.json"],
            "ticker_or_symbol": pick.get("ticker"),
            "details": pick,
            "source_file": "boba_daily_picks.json",
            "dedup_hash": h,
        }
        emit(record, day_files)
        new += 1
    return new


def collect_crypto_picks(seen, day_files):
    if not CRYPTO_PICKS.exists():
        return 0
    try:
        data = json.loads(CRYPTO_PICKS.read_text())
    except Exception:
        return 0
    new = 0
    for pick in data.get("picks", []):
        h = hash_record(pick, "crypto_boba_daily.json")
        if h in seen:
            continue
        seen[h] = True
        record = {
            "ts": pick.get("submitted_at"),
            "type": "execute",
            "asset_class": "crypto",
            "wallet": WALLET_BY_SOURCE["crypto_boba_daily.json"],
            "ticker_or_symbol": pick.get("symbol"),
            "details": pick,
            "source_file": "crypto_boba_daily.json",
            "dedup_hash": h,
        }
        emit(record, day_files)
        new += 1
    return new


def collect_outcomes(seen, day_files):
    if not OUTCOMES_DIR.exists():
        return 0
    new = 0
    for fp in sorted(OUTCOMES_DIR.glob("*.json")):
        try:
            data = json.loads(fp.read_text())
        except Exception:
            continue
        if not isinstance(data, list):
            continue
        for outcome in data:
            h = hash_record(outcome, fp.name)
            if h in seen:
                continue
            seen[h] = True
            kind = outcome.get("kind", "unknown")
            asset_class = "options" if outcome.get("strike") is not None else (
                "crypto" if "crypto" in (kind or "") else "stocks"
            )
            record = {
                "ts": outcome.get("exit_time"),
                "type": "close",
                "asset_class": asset_class,
                "wallet": WALLET_BY_SOURCE.get(fp.name, "alpaca_r2"),
                "ticker_or_symbol": outcome.get("symbol"),
                "details": outcome,
                "source_file": fp.name,
                "dedup_hash": h,
            }
            emit(record, day_files)
            new += 1
    return new


def write_index():
    """Refresh INDEX.md with per-day counts."""
    rows = []
    for fp in sorted(AUDIT_DIR.glob("*.jsonl")):
        try:
            with open(fp) as fh:
                lines = fh.readlines()
            execs = sum(1 for ln in lines if '"type": "execute"' in ln)
            closes = sum(1 for ln in lines if '"type": "close"' in ln)
            rows.append((fp.stem, execs, closes, len(lines)))
        except Exception:
            continue
    md = ["# Audit Log Index\n",
          f"\n_Refreshed {NOW_ET.strftime('%Y-%m-%d %H:%M ET')} by audit_log_writer.py_\n",
          "\n",
          "Each `<YYYY-MM-DD>.jsonl` file holds one event per line: agent decisions\n",
          "(executes) and post-trade outcomes (closes). MissionCtrl is autonomous, so\n",
          "this log is for post-mortem and drawdown computation, not for approval gating.\n",
          "\n| Date | Executes | Closes | Total |\n",
          "|---|---:|---:|---:|\n"]
    for date, e, c, t in sorted(rows, reverse=True):
        md.append(f"| {date} | {e} | {c} | {t} |\n")
    if not rows:
        md.append("| _no data yet_ | | | |\n")
    (AUDIT_DIR / "INDEX.md").write_text("".join(md))


def main():
    AUDIT_DIR.mkdir(parents=True, exist_ok=True)
    state = load_state()
    seen = state.get("seen_hashes", {})
    day_files = {}
    n_opt = collect_options_picks(seen, day_files)
    n_crypto = collect_crypto_picks(seen, day_files)
    n_close = collect_outcomes(seen, day_files)
    for fh in day_files.values():
        fh.close()
    state["seen_hashes"] = seen
    state["last_run_utc"] = NOW.isoformat()
    save_state(state)
    write_index()
    print(f"[audit-log] {NOW_ET.strftime('%Y-%m-%d %H:%M:%S ET')} new_options={n_opt} new_crypto={n_crypto} new_closes={n_close} total_seen={len(seen)}", flush=True)


if __name__ == "__main__":
    main()
