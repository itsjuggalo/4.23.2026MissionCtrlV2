#!/usr/bin/env python3
"""Performance tracker - Path A v2.
Auto-discovers all closed_*.json files in data/, buckets by source prefix
(ts_/ss_/analyst_name/analyst_vivid2/etc) and category (SWING/SCALP).
Win/loss from status text primary + buyTarget vs exit price math fallback.
"""
import json, os, sys, time, logging, re
from datetime import datetime, timezone, timedelta
from pathlib import Path
from collections import defaultdict
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
WEBHOOK = (SECRETS / "discord_performance_webhook").read_text().strip()
RELAY_DIR = Path.home() / "mission-control-restored" / "Option-Signals-Scraper"
DATA_DIR = RELAY_DIR / "data"

LOG_DIR = Path.home() / ".openclaw" / "workspace" / "logs"
LOG_DIR.mkdir(parents=True, exist_ok=True)
logging.basicConfig(
    filename=LOG_DIR / "performance_tracker.log",
    level=logging.INFO,
    format="%(asctime)s %(levelname)s %(message)s",
)

# Source files: filename → display label
SOURCES = {
    # Main / merged feed (treat as TS-primary based on field naming)
    "closed_options": ("TS-MAIN", "OPTION"),
    "closed_stocks": ("TS-MAIN", "STOCK"),
    # TS specific (if separate)
    "ts_closed_options": ("TS", "OPTION"),
    "ts_closed_stocks": ("TS", "STOCK"),
    # SS
    "ss_closed_options": ("SS", "OPTION"),
    "ss_closed_stocks": ("SS", "STOCK"),
    # Analyst feeds
    "analyst_name_closedoptions": ("ANALYST1", "OPTION"),
    "analyst_name2_closedoptions": ("ANALYST2", "OPTION"),
    "analyst_vivid2_closedoptions": ("VIVID2", "OPTION"),
}

WIN_PHRASES = ("profit", "locked", "booked")
LOSS_PHRASES = ("stop", "loss")


def read_data(name):
    p = DATA_DIR / f"{name}.json"
    if not p.exists():
        return None
    try:
        return json.loads(p.read_text())
    except Exception as e:
        logging.error(f"read {name}: {e}")
        return None


def safe_float(v):
    try:
        return float(v) if v not in (None, "", "MISSING") else None
    except (TypeError, ValueError):
        return None


def status_outcome(status):
    """Returns 'WIN', 'LOSS', or 'UNK'."""
    if not status:
        return "UNK"
    s = status.lower()
    if any(p in s for p in WIN_PHRASES):
        return "WIN"
    if any(p in s for p in LOSS_PHRASES):
        return "LOSS"
    return "UNK"


def compute_exit_price(entry, kind):
    """Best-effort exit price."""
    # Pick whichever sellTargetN was actually hit (latest non-null)
    for k in ("sellTarget3", "sellTarget2", "sellTarget", "exit2", "exit1"):
        v = safe_float(entry.get(k))
        if v is not None:
            return v
    if kind == "STOCK":
        q = entry.get("quote", {})
        if isinstance(q, dict):
            v = safe_float(q.get("lastPrice") or q.get("closePrice"))
            if v is not None:
                return v
    return None


def compute_pnl_pct(entry, kind, outcome):
    """Returns pnl % or None."""
    entry_p = safe_float(entry.get("buyTarget"))
    if entry_p is None or entry_p <= 0:
        return None
    exit_p = compute_exit_price(entry, kind)
    if exit_p is None:
        # Fallback: if loss, assume reduceLoss (stop) was hit
        if outcome == "LOSS":
            exit_p = safe_float(entry.get("reduceLoss")) or safe_float(entry.get("stopLoss"))
        if exit_p is None:
            return None
    return ((exit_p - entry_p) / entry_p) * 100


def get_close_ts(entry):
    v = entry.get("exitTime")
    if v is None:
        return None
    try:
        v = int(v)
        return v if v < 1e12 else v // 1000
    except (TypeError, ValueError):
        return None


def collect_trades(window_days):
    cutoff = time.time() - (window_days * 86400)
    trades = []
    for fname, (source_label, kind) in SOURCES.items():
        d = read_data(fname)
        if d is None:
            continue
        if isinstance(d, dict):
            d = list(d.values())
        if not isinstance(d, list):
            continue

        for entry in d:
            if not isinstance(entry, dict):
                continue
            ts = get_close_ts(entry)
            if ts is None or ts < cutoff:
                continue
            status = entry.get("status", "")
            outcome = status_outcome(status)
            pnl = compute_pnl_pct(entry, kind, outcome)
            # If pnl math succeeded and disagrees with status, trust math
            if pnl is not None and outcome == "UNK":
                outcome = "WIN" if pnl > 0 else "LOSS"
            elif pnl is None and outcome == "UNK":
                continue  # skip ambiguous
            trades.append({
                "source": source_label,
                "kind": kind,
                "category": entry.get("category", "?").upper(),
                "ticker": entry.get("symbol", "?"),
                "outcome": outcome,
                "pnl_pct": pnl,
                "status": status,
                "ts": ts,
            })
    return trades


def stats_for(trades):
    n = len(trades)
    if n == 0:
        return None
    wins = sum(1 for t in trades if t["outcome"] == "WIN")
    win_rate = wins / n * 100
    pnls = [t["pnl_pct"] for t in trades if t["pnl_pct"] is not None]
    avg = sum(pnls) / len(pnls) if pnls else 0.0
    if pnls:
        sorted_p = sorted(pnls)
        median = sorted_p[len(sorted_p) // 2]
        best = max(pnls)
        worst = min(pnls)
    else:
        median = best = worst = 0.0
    return {
        "n": n,
        "wins": wins,
        "win_rate": win_rate,
        "avg": avg,
        "median": median,
        "best": best,
        "worst": worst,
    }


def medal(rank):
    return ["🥇", "🥈", "🥉"][rank] if rank < 3 else f"#{rank+1}"


def build_embed(trades, window):
    if not trades:
        return {
            "title": "📊 Performance Leaderboard",
            "description": f"_No closed trades found in last {window} days_",
            "color": 0x95a5a6,
            "timestamp": datetime.now(timezone.utc).isoformat(),
        }

    # Per-source rollup
    by_source = defaultdict(list)
    for t in trades:
        by_source[t["source"]].append(t)
    source_rows = []
    for src, src_trades in by_source.items():
        s = stats_for(src_trades)
        source_rows.append((src, s))
    source_rows.sort(key=lambda r: (r[1]["win_rate"], r[1]["avg"]), reverse=True)

    src_lines = ["`RANK SOURCE     N   WIN%  AVG%   BEST   WORST`"]
    for i, (src, s) in enumerate(source_rows):
        src_lines.append(
            f"`{medal(i):<5}{src:<11}{s['n']:>3}{s['win_rate']:>6.0f}%{s['avg']:>+6.1f}%{s['best']:>+6.0f}%{s['worst']:>+6.0f}%`"
        )

    # Per-category rollup (across all sources)
    by_cat = defaultdict(list)
    for t in trades:
        by_cat[t["category"]].append(t)
    cat_rows = []
    for cat, cat_trades in by_cat.items():
        s = stats_for(cat_trades)
        cat_rows.append((cat, s))
    cat_rows.sort(key=lambda r: r[1]["n"], reverse=True)
    cat_lines = ["`CATEGORY       N   WIN%  AVG%   BEST   WORST`"]
    for cat, s in cat_rows:
        cat_lines.append(
            f"`{cat:<14}{s['n']:>3}{s['win_rate']:>6.0f}%{s['avg']:>+6.1f}%{s['best']:>+6.0f}%{s['worst']:>+6.0f}%`"
        )

    leader_src, leader_stats = source_rows[0]
    overall_n = len(trades)
    overall_wins = sum(1 for t in trades if t["outcome"] == "WIN")
    overall_wr = overall_wins / overall_n * 100

    color = 0x2ecc71 if overall_wr >= 60 else (0xe74c3c if overall_wr <= 40 else 0xf1c40f)

    return {
        "title": f"📊 Performance Leaderboard ({window}d)",
        "description": (
            f"**{overall_n}** trades closed • **{overall_wr:.0f}% overall win rate**\n"
            f"🏆 Top source: **{leader_src}** — {leader_stats['win_rate']:.0f}% wr on {leader_stats['n']} trades"
        ),
        "color": color,
        "fields": [
            {"name": "By Source", "value": "\n".join(src_lines)[:1024], "inline": False},
            {"name": "By Category (SWING vs SCALP)", "value": "\n".join(cat_lines)[:1024], "inline": False},
        ],
        "footer": {"text": f"Path A: closed_*.json files • status text + price math"},
        "timestamp": datetime.now(timezone.utc).isoformat(),
    }


def post_embed(embed):
    try:
        r = requests.post(WEBHOOK, json={"embeds": [embed]}, timeout=15)
        if r.status_code in (200, 204):
            logging.info(f"posted leaderboard")
            return True
        logging.error(f"webhook {r.status_code}: {r.text[:300]}")
        return False
    except Exception as e:
        logging.error(f"post failed: {e}")
        return False


def main():
    window = 7
    if len(sys.argv) > 1:
        try:
            window = int(sys.argv[1])
        except (ValueError, IndexError):
            pass
    trades = collect_trades(window)
    embed = build_embed(trades, window)
    success = post_embed(embed)
    print(f"window={window}d trades={len(trades)} posted={success}")
    sys.exit(0 if success else 1)


if __name__ == "__main__":
    main()
