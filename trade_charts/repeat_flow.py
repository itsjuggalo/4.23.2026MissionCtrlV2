#!/usr/bin/env python3
"""
repeat_flow.py — REPEAT / STACKING flow detector for #ta-charts.

The highest-quality flow signal: when the SAME ticker keeps getting hit in the SAME
direction on the SAME expiry, that's institutions ACCUMULATING — not a one-off lottery
ticket. We group today's live options-flow by (Symbol, direction, Expiry), count repeat
hits, sum the premium (Volume * AlertPrice * 100), and rank only the groups with >= 2
stacked same-direction hits.

Stacking score = repeat-hits * total-premium  (so it rewards BOTH conviction and size).
Renders a horizontal bar chart of the top ~12 stacked contract-groups, green=bullish /
red=bearish, and posts to BOTH Discord (SynthControl bot) and Telegram automatically.

Read-only on all data. Usage: python3 repeat_flow.py [--channel ta-charts] [--top 12] [--min-hits 2] [--dry]
"""
from __future__ import annotations
import sys, json, argparse, time, datetime as dt
from pathlib import Path
from collections import defaultdict

import matplotlib; matplotlib.use("Agg")
import matplotlib.pyplot as plt

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))  # 05_AUTOMATION/scripts
import chartlib                              # noqa: E402
import deliver                               # noqa: E402

FLOW = Path.home() / "trading/signals/option-scraper/data/flow_alerts_today.json"
OUT = chartlib.OUT
BG = chartlib.BG if hasattr(chartlib, "BG") else "#0d1117"
GREEN, RED, TEXT, MUTE, GRID = "#3fb950", "#f85149", "#c9d1d9", "#8b949e", "#21262d"


def _direction(a: dict) -> str:
    """Bullish vs bearish call. isBullish is authoritative; fall back to CALL/PUT."""
    if a.get("isBullish") is True:
        return "bull"
    if a.get("isBullish") is False:
        return "bear"
    return "bull" if (a.get("OptionType") or "").upper() == "CALL" else "bear"


def load_groups(min_hits: int):
    """Group live stock-option flow by (Symbol, direction, Expiry) -> stacked hits + premium."""
    raw = json.loads(FLOW.read_text())
    items = raw.values() if isinstance(raw, dict) else raw
    groups = defaultdict(lambda: {"hits": 0, "prem": 0.0, "sweeps": 0, "blocks": 0,
                                  "otype": None, "strikes": set()})
    for it in items:
        a = it.get("alert", it) if isinstance(it, dict) else None
        if not a or not a.get("Symbol") or a.get("UnderlyingType") != "stock":
            continue
        exp = a.get("Expiry")
        if exp is None:
            continue
        direction = _direction(a)
        key = (a["Symbol"], direction, exp)
        g = groups[key]
        g["hits"] += 1
        g["prem"] += (a.get("Volume", 0) or 0) * (a.get("AlertPrice", 0) or 0) * 100
        g["sweeps"] += a.get("SWEEPS", 0) or 0
        g["blocks"] += a.get("BLOCKS", 0) or 0
        g["otype"] = a.get("OptionType") or g["otype"]
        if a.get("Strike"):
            g["strikes"].add(a["Strike"])

    stacked = []
    for (sym, direction, exp), g in groups.items():
        if g["hits"] < min_hits or g["prem"] <= 0:
            continue
        score = g["hits"] * g["prem"]           # conviction (repeat) x size (premium)
        stacked.append({
            "sym": sym, "direction": direction, "exp": exp,
            "hits": g["hits"], "prem": g["prem"], "score": score,
            "sweeps": g["sweeps"], "blocks": g["blocks"],
            "otype": g["otype"] or ("CALL" if direction == "bull" else "PUT"),
            "strikes": sorted(g["strikes"]),
        })
    stacked.sort(key=lambda x: x["score"], reverse=True)
    return stacked


def _exp_str(epoch) -> str:
    try:
        return dt.datetime.fromtimestamp(epoch).strftime("%-m/%-d")
    except Exception:
        return "?"


def _label(s: dict) -> str:
    kind = "C" if s["direction"] == "bull" else "P"
    n = len(s["strikes"])
    if n == 1:
        strike = f"${s['strikes'][0]:g}"
    elif n > 1:
        strike = f"${s['strikes'][0]:g}-{s['strikes'][-1]:g}"
    else:
        strike = ""
    return f"{s['sym']} {strike}{kind} {_exp_str(s['exp'])}"


def render(stacked: list[dict], top: int) -> str | None:
    rows = stacked[:top][::-1]                  # biggest at TOP of barh
    if not rows:
        return None
    labels = [_label(s) for s in rows]
    scores = [s["score"] / 1e6 for s in rows]   # premium-weighted, $M units on score
    cols = [GREEN if s["direction"] == "bull" else RED for s in rows]

    fig, ax = plt.subplots(figsize=(11, max(5, 0.55 * len(rows) + 2)), facecolor=BG)
    ax.set_facecolor(BG)
    ax.barh(labels, scores, color=cols, edgecolor="#30363d", linewidth=0.4)
    for i, s in enumerate(rows):
        ax.text(scores[i], i,
                f"  {s['hits']}x · ${s['prem']/1e6:.1f}M",
                va="center", color=TEXT, fontsize=8.5)
    ax.tick_params(colors=MUTE, labelsize=9)
    for sp in ax.spines.values():
        sp.set_color("#30363d")
    ax.grid(color=GRID, lw=0.5, axis="x")
    ax.set_xlim(0, max(scores) * 1.22)
    ax.set_xlabel("stacking score  (repeat hits x premium, $M)", color=MUTE, fontsize=9)
    ax.set_title("Repeat / Stacking Flow  -  same ticker, same direction, same expiry "
                 "(green=bullish accumulation / red=bearish)",
                 color="#e6edf3", loc="left", fontsize=12)
    path = str(OUT / "repeat_flow.png")
    fig.savefig(path, dpi=120, bbox_inches="tight", facecolor=BG)
    plt.close(fig)
    return path


def caption(stacked: list[dict]) -> str:
    top3 = stacked[:3]
    parts = []
    for s in top3:
        arrow = "🟢" if s["direction"] == "bull" else "🔴"
        agg = ""
        if s["sweeps"]:
            agg = f", {s['sweeps']} sweeps"
        elif s["blocks"]:
            agg = f", {s['blocks']} blocks"
        parts.append(f"{arrow} **{s['sym']}** {s['hits']}x stacked "
                     f"({_exp_str(s['exp'])} {'calls' if s['direction']=='bull' else 'puts'}, "
                     f"${s['prem']/1e6:.1f}M{agg})")
    head = "📚 **Repeat / Stacking Flow** — the highest-quality flow signal\n" + "\n".join(parts)
    body = ("\n\n_Stacking = the same name getting hit again and again in the SAME direction "
            "on the SAME expiry. One sweep is a guess; 4+ repeat hits on one contract group is "
            "an institution ACCUMULATING a position — follow the repeats, fade the one-offs._")
    return head + body


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="ta-charts")
    ap.add_argument("--top", type=int, default=12)
    ap.add_argument("--min-hits", type=int, default=2, dest="min_hits")
    ap.add_argument("--dry", action="store_true")
    args = ap.parse_args()

    stacked = load_groups(args.min_hits)
    print(f"[repeat-flow] {len(stacked)} stacked groups (>={args.min_hits} same-dir hits)")
    if not stacked:
        print("[repeat-flow] nothing stacked today — no chart posted")
        return

    png = render(stacked, args.top)
    if not png:
        print("[repeat-flow] render produced no chart")
        return
    cap = caption(stacked)
    dok, tok = deliver.post_chart(args.channel, png, cap, dry=args.dry)
    print(f"  discord={'✓' if dok else '✗'} tg={'✓' if tok else '✗'}  -> #{args.channel}")
    for s in stacked[:args.top]:
        print(f"    {_label(s):<26} {s['hits']}x ${s['prem']/1e6:.2f}M  score={s['score']/1e6:.1f}")


if __name__ == "__main__":
    main()
