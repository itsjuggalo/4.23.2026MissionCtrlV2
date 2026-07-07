"""cards.py — render the coach output: Telegram digest text + per-holding chart cards.

Digest = compact ADHD-first text (sections, one line per holding, verdict icon + top
reason + level). Chart cards reuse lib/chart_renderer primitives (same Terran palette
as every other Mission Control card): candles + EMA20/50 + stop/target lines + verdict
badge + confidence gauge + WHY/PLAY text. Telegram messages chunk at ~3500 chars.
"""
from __future__ import annotations

import sys
import traceback
from pathlib import Path

SCRIPTS = Path(__file__).resolve().parent.parent
sys.path.insert(0, str(SCRIPTS))

from real_coach.verdict import ICON  # noqa: E402

TG_CHUNK = 3500


def _line(r: dict) -> str:
    pnl = r.get("pnl_pct")
    pnl_s = f"{pnl:+.0f}%" if pnl is not None else "?%"
    bits = [f"{ICON.get(r['verdict'], '·')} {r['symbol']} ${r['mv']:,.0f} {pnl_s} → {r['verdict']}"]
    if r.get("reasons"):
        bits.append(f"   {r['reasons'][0]}")
    lvl = []
    if r.get("stop"):
        lvl.append(f"stop {r['stop']:g}")
    if r.get("trail_stop"):
        lvl.append(f"trail {r['trail_stop']:g}")
    if r.get("target"):
        lvl.append(f"tgt {r['target']:g}")
    if lvl:
        bits.append("   " + " · ".join(lvl))
    return "\n".join(bits)


def digest_text(results: list[dict], book: dict, now_et: str, title="REAL BOOK COACH") -> list[str]:
    """Chunked Telegram messages. Sections: actions first, then core, satellites, dust."""
    total = book.get("total_value")
    inv = book.get("invested_value")
    hdr = [f"🧭 {title} — {now_et}",
           f"book ${total:,.0f} · invested ${inv:,.0f} · {len(results)} positions"]
    actions = [r for r in results if r["verdict"] in ("TRIM", "EXIT_ON_BOUNCE", "ADD", "EXIT")]
    core = [r for r in results if r["bucket"] == "core" and r not in actions and r["mode"] == "ta"]
    holds = [r for r in results if r["bucket"] != "core" and r not in actions and r["mode"] == "ta"]
    triage = [r for r in results if r["mode"] == "triage"]
    dust = [r for r in results if r["mode"] == "dust"]

    sections: list[str] = ["\n".join(hdr)]
    if actions:
        sections.append("⚡ ACTION NEEDED\n" + "\n".join(_line(r) for r in actions))
    if core:
        sections.append("🏛 CORE (let winners run)\n" + "\n".join(_line(r) for r in core))
    if holds:
        sections.append("🎯 SATELLITE\n" + "\n".join(_line(r) for r in holds))
    if triage:
        sections.append("👀 TRIAGE (no chart history — price-only)\n"
                        + "\n".join(_line(r) for r in triage))
    if dust:
        syms = ", ".join(r["symbol"] for r in dust)
        tot = sum(r["mv"] for r in dust)
        sections.append(f"🧹 DUST — {len(dust)} positions worth ${tot:.0f} total: {syms}\n"
                        f"   one cleanup session, sell all, stop tracking ghosts")
    sections.append("reply with a ticker for the full detailed read · overrides tracked from P3")

    # chunk
    msgs, cur = [], ""
    for s in sections:
        if cur and len(cur) + len(s) + 2 > TG_CHUNK:
            msgs.append(cur)
            cur = s
        else:
            cur = f"{cur}\n\n{s}" if cur else s
    if cur:
        msgs.append(cur)
    return msgs


def coach_card(r: dict) -> str | None:
    """Chart card PNG for one holding verdict. Returns path or None (never raises)."""
    try:
        from lib import chart_renderer as cr
        import matplotlib.pyplot as plt
        from matplotlib.patches import FancyBboxPatch

        sym_chart = r["symbol"] if r["asset_class"] == "stock" else f"{r['symbol']}-USD"
        df = cr.ohlc(sym_chart, days=120, interval="1d")
        fig = plt.figure(figsize=(11, 6.9))
        gs = fig.add_gridspec(3, 2, height_ratios=[0.55, 3.0, 1.35],
                              width_ratios=[2.15, 1.0], hspace=0.30, wspace=0.16)
        axt = fig.add_subplot(gs[0, :]); axt.axis("off")
        pnl = r.get("pnl_pct")
        axt.text(0.0, 0.5, r["symbol"], transform=axt.transAxes, va="center",
                 fontsize=21, fontweight="bold", color=cr.PAL["text"])
        axt.text(0.16, 0.5, f"${r['mv']:,.0f} · {pnl:+.0f}%" if pnl is not None
                 else f"${r['mv']:,.0f}", transform=axt.transAxes, va="center",
                 fontsize=13, color=cr.PAL["muted"])
        vcol = {"HOLD": cr.PAL["up"], "ADD": cr.PAL["up"], "TRIM": cr.PAL["neutral"],
                "EXIT_ON_BOUNCE": cr.PAL["down"], "EXIT": cr.PAL["down"]}.get(
                    r["verdict"], cr.PAL["neutral"])
        cr._badge(axt, 0.74, 0.5, r["bucket"].upper(), cr.PAL["edge"], axt.transAxes)
        cr._badge(axt, 0.88, 0.5, r["verdict"].replace("_", " "), vcol, axt.transAxes)

        axc = fig.add_subplot(gs[1, 0])
        if df is not None:
            marks = []
            if r.get("stop"):
                marks.append({"y": float(r["stop"]), "color": cr.PAL["down"]})
            if r.get("trail_stop"):
                marks.append({"y": float(r["trail_stop"]), "color": cr.PAL["neutral"]})
            if r.get("target"):
                marks.append({"y": float(r["target"]), "color": cr.PAL["up"]})
            cr.draw_candles(axc, df, emas=(20, 50), marks=marks)
            axc.set_title(f"{r['symbol']} · daily · EMA20/50 · red=stop amber=trail green=target",
                          fontsize=9.5, color=cr.PAL["muted"], loc="left")
        else:
            axc.axis("off")
            axc.text(0.5, 0.5, "no chart data", ha="center", va="center", color=cr.PAL["muted"])

        gsr = gs[1, 1].subgridspec(2, 2, height_ratios=[1.0, 1.05], hspace=0.05, wspace=0.1)
        cr.draw_gauge(fig.add_subplot(gsr[0, 0]), float(r.get("confidence") or 0), 100,
                      "TA conf", fmt="{:.0f}")
        cr.draw_gauge(fig.add_subplot(gsr[0, 1]), float(r.get("rsi") or 0), 100, "RSI",
                      fmt="{:.0f}")
        axf = fig.add_subplot(gsr[1, :]); axf.axis("off")
        facts = [("Value", f"${r['mv']:,.0f}"),
                 ("P&L", f"{pnl:+.1f}%" if pnl is not None else "unknown"),
                 ("Stop", f"{r['stop']:g}" if r.get("stop") else "—"),
                 ("Target", f"{r['target']:g}" if r.get("target") else "—")]
        for i, (k, v) in enumerate(facts):
            yy = 0.92 - i * 0.25
            axf.text(0.02, yy, k, transform=axf.transAxes, fontsize=10, color=cr.PAL["muted"])
            axf.text(0.98, yy, v, transform=axf.transAxes, fontsize=11.5, ha="right",
                     fontweight="bold", color=cr.PAL["text"])

        axb = fig.add_subplot(gs[2, :]); axb.axis("off")
        axb.add_patch(FancyBboxPatch((0.0, 0.0), 1.0, 1.0, transform=axb.transAxes,
                      boxstyle="round,pad=0.01", fc=cr.PAL["panel"], ec=cr.PAL["edge"],
                      lw=0.8, zorder=0))
        # matplotlib mathtext eats $…$ pairs — escape every dollar sign
        why = " · ".join(r.get("reasons", [])[:2])[:220].replace("$", r"\$")
        verb = {"HOLD": "hold — keep the stop honest", "ADD": "add small, stop set FIRST",
                "TRIM": "sell half, trail the rest", "EXIT_ON_BOUNCE": "sell the next pop",
                "EXIT": "exit now"}.get(r["verdict"], "")
        lvl = []
        if r.get("target"):
            lvl.append(f"target {r['target']:g}")
        if r.get("trail_stop"):
            lvl.append(f"trail {r['trail_stop']:g}")
        if r.get("stop"):
            lvl.append(f"hard line {r['stop']:g} (daily close below = out)")
        play = (f"{verb} · " + " · ".join(lvl) if lvl else verb).replace("$", r"\$")[:220]
        axb.text(0.02, 0.72, "WHY", transform=axb.transAxes, fontsize=8.5,
                 color=cr.PAL["accent"], fontweight="bold")
        axb.text(0.02, 0.44, why, transform=axb.transAxes, fontsize=9.8,
                 color=cr.PAL["text"], wrap=True)
        axb.text(0.02, 0.22, "PLAY", transform=axb.transAxes, fontsize=8.5,
                 color=cr.PAL["accent"], fontweight="bold")
        axb.text(0.02, 0.03, play, transform=axb.transAxes, fontsize=9.8,
                 color=cr.PAL["text"], wrap=True)
        return cr._save(fig, f"coach_{r['symbol']}")
    except Exception:
        print("cards.coach_card error:\n" + traceback.format_exc())
        return None
