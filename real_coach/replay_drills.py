#!/usr/bin/env python3
"""replay_drills.py — build the "worst-20 trades" replay drill bank.

Resurfaces Mike's worst REAL trades as blind quizzes: the chart is replayed up
to the decision moment (ticker hidden), he picks what the playbook says, then
the reveal shows what he actually did, what happened next, and what it cost.

Four drill categories, each mapped to a standing rule:
  biggest-loss   — satellite losers at the −10% hard-stop moment   (rule: hard stop)
  dead-bag-ride  — trips that hit −50% while open                  (rule 3: exit into strength)
  early-exit     — sells whose price ran hardest in the next 30d   (rule: trail, don't dump strength)
  oversize       — the >10×-median YOLO buys at the moment of buy  (rule 4: sizing)

Writes ~/portfolio/replay_drills.json (served by missionctrl /api/replay-drills).
Read-only vs brokers: mike.sqlite + yfinance only. Re-run any time; drill ids are
stable (category + symbol + entry date) so answered history survives rebuilds.
"""
from __future__ import annotations

import json
import sqlite3
import sys
from datetime import datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))

from real_coach import symbols as symmod  # noqa: E402

DB = Path.home() / "portfolio" / "mike.sqlite"
OUT = Path.home() / "portfolio" / "replay_drills.json"
DUST = 50.0          # ignore micro trips — drills should be real decisions
TARGET = 20

CHOICES = {
    "hard_stop": [
        {"key": "exit", "label": "Exit now — the −10% satellite hard stop just fired"},
        {"key": "hold", "label": "Hold — it'll come back, the thesis hasn't changed"},
        {"key": "add", "label": "Add — average down while it's cheap"},
        {"key": "widen", "label": "Widen the stop to −25% to give it room"},
    ],
    "dead_bag": [
        {"key": "strength", "label": "Plan the exit INTO the next strength bounce at resistance"},
        {"key": "dump", "label": "Market-dump it right here at the low"},
        {"key": "hold_hope", "label": "Keep holding — it has to recover eventually"},
        {"key": "double", "label": "Double down to cut the average"},
    ],
    "early_exit": [
        {"key": "trail", "label": "Hold with a trail 8% below the peak — sell only when it ratchets out"},
        {"key": "sell_all", "label": "Sell everything — lock the win before it disappears"},
        {"key": "sell_half_now", "label": "Trim half here (below the +75% trim line)"},
        {"key": "add_more", "label": "Add to the winner — momentum begets momentum"},
    ],
    "oversize": [
        {"key": "cut", "label": "Cut the ticket to ≤10× median (or write the plan FIRST)"},
        {"key": "send", "label": "Send it — conviction deserves size"},
        {"key": "split", "label": "Full size, but split across two brokers so it feels smaller"},
        {"key": "options", "label": "Same dollars, but in options for more leverage"},
    ],
}
CORRECT = {"hard_stop": "exit", "dead_bag": "strength",
           "early_exit": "trail", "oversize": "cut"}


def yf_closes(sym: str, ac: str, start: str, end: str):
    """daily Close series (auto-adjusted) or None."""
    try:
        import yfinance as yf
        t = symmod.ta_symbol(sym, "crypto") if ac == "crypto" else sym
        df = yf.download(t, start=start, end=end, interval="1d", progress=False,
                         auto_adjust=True, threads=False)
        ser = df["Close"].dropna()
        if hasattr(ser, "columns"):   # single ticker sometimes still multi-col
            ser = ser.iloc[:, 0].dropna()
        return ser if len(ser) >= 15 else None
    except Exception:
        return None


def build_series(sym, ac, entry_at, exit_at, pre_days=45, post_days=32):
    e0 = datetime.fromisoformat(entry_at[:10])
    e1 = datetime.fromisoformat(exit_at[:10]) if exit_at else e0
    ser = yf_closes(sym, ac, (e0 - timedelta(days=pre_days)).strftime("%Y-%m-%d"),
                    min(e1 + timedelta(days=post_days), datetime.now()).strftime("%Y-%m-%d"))
    if ser is None:
        return None
    dates = [d.strftime("%Y-%m-%d") for d in ser.index]
    vals = [float(v) for v in ser.values]
    # normalize to entry-date close = 100 (blind mode — no real prices shown)
    ei = min(range(len(dates)), key=lambda i: abs(
        (datetime.fromisoformat(dates[i]) - e0).days))
    base = vals[ei]
    if base <= 0:
        return None
    return {"dates": dates, "vals": [round(v / base * 100, 2) for v in vals], "entry_idx": ei}


def first_idx_below(s, entry_idx, pct):
    for i in range(entry_idx + 1, len(s["vals"])):
        if s["vals"][i] <= 100 + pct:  # pct is negative
            return i
    return None


def idx_of_date(s, date_str):
    d0 = datetime.fromisoformat(date_str[:10])
    return min(range(len(s["dates"])), key=lambda i: abs(
        (datetime.fromisoformat(s["dates"][i]) - d0).days))


def asset_label(ac):
    return {"crypto": "a crypto position", "stock": "a stock position",
            "option": "an options position"}.get(ac, "a position")


def main() -> int:
    con = sqlite3.connect(f"file:{DB}?mode=ro", uri=True, timeout=30)
    con.row_factory = sqlite3.Row
    drills = []
    used = set()   # (category-family, symbol) dedup so BTC doesn't fill the bank

    def rt_rows(sql, args=()):
        return [dict(r) for r in con.execute(sql, args)]

    # ── 1. biggest $ losers (non-option; options get the oversize/sizing drill) ──
    losers = rt_rows(
        "SELECT * FROM round_trips WHERE pnl_usd < -100 AND asset_class != 'option' "
        "AND ABS(qty*entry_px) >= ? ORDER BY pnl_usd ASC LIMIT 25", (DUST,))
    for r in losers:
        if len([d for d in drills if d["category"] == "biggest-loss"]) >= 7:
            break
        key = ("loss", r["symbol"])
        if key in used:
            continue
        s = build_series(r["symbol"], r["asset_class"], r["entry_at"], r["exit_at"])
        if not s:
            continue
        di = first_idx_below(s, s["entry_idx"], -10)
        if di is None:
            di = min(s["entry_idx"] + 5, len(s["vals"]) - 5)
        used.add(key)
        size = abs(r["qty"] * r["entry_px"])
        drills.append({
            "id": f"loss-{r['symbol']}-{r['entry_at'][:10]}",
            "category": "biggest-loss", "choice_set": "hard_stop",
            "symbol": r["symbol"], "asset_class": r["asset_class"],
            "size_usd": round(size), "pnl_usd": round(r["pnl_usd"]),
            "pnl_pct": round(r["pnl_pct"] or 0, 1),
            "max_drawdown_pct": round(r["max_drawdown_pct"] or 0, 1),
            "hold_days": round(r["hold_days"] or 0),
            "series": s, "decision_idx": di,
            "setup": f"You bought {asset_label(r['asset_class'])} — ${size:,.0f} at day 0. "
                     f"It just closed {s['vals'][di] - 100:+.0f}% from your entry.",
            "question": "Satellite position at/under the −10% hard-stop line. What does the playbook say?",
            "choices": CHOICES["hard_stop"], "correct": CORRECT["hard_stop"],
            "what_happened": f"You held {r['hold_days']:.0f} days, bottomed "
                             f"{r['max_drawdown_pct'] or 0:.0f}% mid-trip, and closed at "
                             f"{r['pnl_pct'] or 0:+.1f}% for ${r['pnl_usd']:+,.0f}.",
            "lesson": "The −10% satellite hard stop exists because 23% of your trips rode −30%+ "
                      "drawdowns. The first stop is the cheapest exit you'll ever be offered.",
            "rule": "satellite hard stop −10%",
        })

    # ── 2. dead-bag rides — closed trips that bottomed ≤ −50% while open ──
    bags = rt_rows(
        "SELECT * FROM round_trips WHERE max_drawdown_pct <= -50 AND ABS(qty*entry_px) >= ? "
        "ORDER BY max_drawdown_pct ASC LIMIT 25", (DUST,))
    for r in bags:
        if len([d for d in drills if d["category"] == "dead-bag-ride"]) >= 5:
            break
        key = ("bag", r["symbol"])
        if key in used:
            continue
        s = build_series(r["symbol"], r["asset_class"], r["entry_at"], r["exit_at"],
                         pre_days=30, post_days=40)
        if not s:
            continue
        di = first_idx_below(s, s["entry_idx"], -50)
        if di is None:
            continue
        used.add(key)
        size = abs(r["qty"] * r["entry_px"])
        drills.append({
            "id": f"bag-{r['symbol']}-{r['entry_at'][:10]}",
            "category": "dead-bag-ride", "choice_set": "dead_bag",
            "symbol": r["symbol"], "asset_class": r["asset_class"],
            "size_usd": round(size), "pnl_usd": round(r["pnl_usd"]),
            "pnl_pct": round(r["pnl_pct"] or 0, 1),
            "max_drawdown_pct": round(r["max_drawdown_pct"] or 0, 1),
            "hold_days": round(r["hold_days"] or 0),
            "series": s, "decision_idx": di,
            "setup": f"{asset_label(r['asset_class']).capitalize()}, ${size:,.0f} at day 0 — "
                     f"it just closed −50% from entry. Officially a dead bag.",
            "question": "The position crossed −50%. Rule 3 covers exactly this. What's the move?",
            "choices": CHOICES["dead_bag"], "correct": CORRECT["dead_bag"],
            "what_happened": f"You held {r['hold_days']:.0f} days total, bottomed "
                             f"{r['max_drawdown_pct']:.0f}%, closed {r['pnl_pct'] or 0:+.1f}% "
                             f"(${r['pnl_usd']:+,.0f}).",
            "lesson": "Rule 3: dead bags exit INTO strength at resistance — never market-dump the "
                      "low, never double down on hope. Plan the bounce exit the day it crosses −50%.",
            "rule": "rule 3 — dead bags exit into strength",
        })

    # ── 3. early exits — sells with the biggest 30d runup AFTER the sell ──
    early = rt_rows(
        "SELECT * FROM round_trips WHERE fwd_ret_30d >= 25 AND ABS(qty*exit_px) >= ? "
        "ORDER BY fwd_ret_30d DESC LIMIT 25", (DUST,))
    for r in early:
        if len([d for d in drills if d["category"] == "early-exit"]) >= 5:
            break
        key = ("early", r["symbol"])
        if key in used:
            continue
        s = build_series(r["symbol"], r["asset_class"], r["entry_at"], r["exit_at"],
                         pre_days=30, post_days=35)
        if not s:
            continue
        di = idx_of_date(s, r["exit_at"])
        if di >= len(s["vals"]) - 3:   # need visible "after" for the reveal
            continue
        used.add(key)
        trip = r["pnl_pct"] or 0
        drills.append({
            "id": f"early-{r['symbol']}-{r['exit_at'][:10]}",
            "category": "early-exit", "choice_set": "early_exit",
            "symbol": r["symbol"], "asset_class": r["asset_class"],
            "size_usd": round(abs(r["qty"] * r["exit_px"])),
            "pnl_usd": round(r["pnl_usd"]), "pnl_pct": round(trip, 1),
            "fwd_ret_30d": round(r["fwd_ret_30d"], 1),
            "hold_days": round(r["hold_days"] or 0),
            "series": s, "decision_idx": di,
            "setup": f"{asset_label(r['asset_class']).capitalize()}, held "
                     f"{r['hold_days']:.0f} days, currently {trip:+.1f}% on the trip. "
                     f"Your finger is on the sell button.",
            "question": "You want to sell the whole thing right here. What does the playbook say?",
            "choices": CHOICES["early_exit"], "correct": CORRECT["early_exit"],
            "what_happened": f"You sold it all. Within 30 days it ran another "
                             f"+{r['fwd_ret_30d']:.0f}% — the leg you paid for and didn't keep.",
            "lesson": "13% of your sells ran ≥+20% within 30 days. The trail ratchet (8% below "
                      "peak once +25%) keeps you in the runners and still gets you out.",
            "rule": "trail 8% below peak — don't dump strength",
        })

    # ── 4. oversize buys — the YOLO moments (>10× dust-filtered median) ──
    med_row = con.execute(
        "SELECT ABS(amount_usd) v FROM fills WHERE side='buy' AND amount_usd IS NOT NULL "
        "AND ABS(amount_usd)>=5 ORDER BY v LIMIT 1 OFFSET "
        "(SELECT COUNT(*)/2 FROM fills WHERE side='buy' AND amount_usd IS NOT NULL "
        "AND ABS(amount_usd)>=5)").fetchone()
    med = med_row[0] if med_row else 100.0
    yolos = rt_rows(
        "SELECT broker, asset_class, symbol, ABS(amount_usd) usd, filled_at FROM fills "
        "WHERE side='buy' AND ABS(amount_usd) > ? ORDER BY ABS(amount_usd) DESC LIMIT 12",
        (med * 10,))
    for r in yolos:
        if len([d for d in drills if d["category"] == "oversize"]) >= 3:
            break
        key = ("yolo", r["symbol"], r["filled_at"][:7])   # one per symbol-month
        if key in used:
            continue
        s = build_series(r["symbol"], r["asset_class"], r["filled_at"], r["filled_at"],
                         pre_days=45, post_days=35)
        if not s:
            continue
        used.add(key)
        drills.append({
            "id": f"yolo-{r['symbol']}-{r['filled_at'][:10]}",
            "category": "oversize", "choice_set": "oversize",
            "symbol": r["symbol"], "asset_class": r["asset_class"],
            "size_usd": round(r["usd"]),
            "median_buy": round(med), "size_x_median": round(r["usd"] / med),
            "series": s, "decision_idx": s["entry_idx"],
            "setup": f"You're about to buy ${r['usd']:,.0f} of {asset_label(r['asset_class'])} "
                     f"in one ticket — {r['usd'] / med:.0f}× your ${med:.0f} median buy.",
            "question": "One ticket, no written plan. What does rule 4 say before you tap buy?",
            "choices": CHOICES["oversize"], "correct": CORRECT["oversize"],
            "what_happened": f"You sent the ${r['usd']:,.0f} ticket. Sizing is the F on your "
                             "report card — one YOLO can erase months of $100 singles.",
            "lesson": "Rule 4: no single buy >10× median without a typed plan. Size is the only "
                      "variable that turns a normal loss into a catastrophic one.",
            "rule": "rule 4 — sizing",
        })

    # backfill to TARGET from remaining losers if any category came up short
    if len(drills) < TARGET:
        for r in losers:
            if len(drills) >= TARGET:
                break
            key = ("loss", r["symbol"])
            if key in used:
                continue
            s = build_series(r["symbol"], r["asset_class"], r["entry_at"], r["exit_at"])
            if not s:
                continue
            di = first_idx_below(s, s["entry_idx"], -10) or min(
                s["entry_idx"] + 5, len(s["vals"]) - 5)
            used.add(key)
            size = abs(r["qty"] * r["entry_px"])
            drills.append({
                "id": f"loss-{r['symbol']}-{r['entry_at'][:10]}",
                "category": "biggest-loss", "choice_set": "hard_stop",
                "symbol": r["symbol"], "asset_class": r["asset_class"],
                "size_usd": round(size), "pnl_usd": round(r["pnl_usd"]),
                "pnl_pct": round(r["pnl_pct"] or 0, 1),
                "max_drawdown_pct": round(r["max_drawdown_pct"] or 0, 1),
                "hold_days": round(r["hold_days"] or 0),
                "series": s, "decision_idx": di,
                "setup": f"You bought {asset_label(r['asset_class'])} — ${size:,.0f} at day 0. "
                         f"It just closed {s['vals'][di] - 100:+.0f}% from your entry.",
                "question": "Satellite position at/under the −10% hard-stop line. What does the playbook say?",
                "choices": CHOICES["hard_stop"], "correct": CORRECT["hard_stop"],
                "what_happened": f"You held {r['hold_days']:.0f} days, bottomed "
                                 f"{r['max_drawdown_pct'] or 0:.0f}%, closed "
                                 f"{r['pnl_pct'] or 0:+.1f}% (${r['pnl_usd']:+,.0f}).",
                "lesson": "The −10% satellite hard stop is the cheapest exit you'll ever be offered.",
                "rule": "satellite hard stop −10%",
            })

    OUT.write_text(json.dumps({
        "built_at": datetime.now(timezone.utc).isoformat(),
        "median_buy": round(med),
        "n": len(drills),
        "drills": drills,
    }, indent=1))
    cats = {}
    for d in drills:
        cats[d["category"]] = cats.get(d["category"], 0) + 1
    print(f"built {len(drills)} drills → {OUT}")
    for c, n in cats.items():
        print(f"  {c}: {n}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
