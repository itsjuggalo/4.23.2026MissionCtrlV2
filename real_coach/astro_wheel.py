#!/usr/bin/env python3
"""astro_wheel.py — natal wheel + today's transits as a PNG (matplotlib, $0).

  astro_wheel.py [YYYY-MM-DD] [--out path]   default out: ~/portfolio/astrology/wheel.png
Outer ring: signs. Inner: Placidus houses (Mike's). Natal bodies inside the wheel (gold),
transiting bodies on the outer band (teal). Aspect lines: transit→natal within orb
(hard = red, easy = green, conjunction = gold).
"""
from __future__ import annotations

import sys
from datetime import datetime
from pathlib import Path

import matplotlib
matplotlib.use("Agg")
import matplotlib.pyplot as plt
import numpy as np

sys.path.insert(0, str(Path(__file__).resolve().parent))
import astro_truth as T  # noqa: E402

GLYPH = {"Sun": "☉", "Moon": "☽", "Mercury": "☿", "Venus": "♀", "Mars": "♂", "Jupiter": "♃",
         "Saturn": "♄", "Uranus": "♅", "Neptune": "♆", "Pluto": "♇", "Chiron": "⚷", "Ceres": "⚳",
         "Juno": "⚵", "Hades": "H", "Apollon": "A", "ASC": "AC", "MC": "MC", "DSC": "DC", "IC": "IC"}
SIGN_GLYPH = ["♈", "♉", "♊", "♋", "♌", "♍", "♎", "♏", "♐", "♑", "♒", "♓"]
BG, INK, GOLD, TEAL, EDGE = "#0b0e1a", "#e8e6f2", "#e8b64c", "#5eead4", "#232c4a"


def _theta(lon: float, asc: float) -> float:
    """Chart angle: ASC on the left (180°), zodiac counter-clockwise."""
    return np.radians(180 + (lon - asc))


def draw(when: datetime, out: Path) -> Path:
    nat, tr = T.natal(), T.transits(when)
    asc = T.CUSPS[0]
    fig = plt.figure(figsize=(9, 9), facecolor=BG)
    ax = fig.add_subplot(111, projection="polar", facecolor=BG)
    ax.set_theta_direction(1); ax.set_theta_zero_location("E")
    ax.set_ylim(0, 1.0); ax.set_yticks([]); ax.set_xticks([]); ax.spines["polar"].set_visible(False)
    # sign ring
    for i in range(12):
        t0 = _theta(i * 30, asc)
        ax.bar(t0 + np.radians(15), 0.12, width=np.radians(30), bottom=0.86,
               color="#141a2e" if i % 2 else "#1a2140", edgecolor=EDGE, linewidth=0.8)
        ax.text(t0 + np.radians(15), 0.92, SIGN_GLYPH[i], ha="center", va="center", color=GOLD, fontsize=15)
    # houses (Placidus)
    for i, c in enumerate(T.CUSPS):
        th = _theta(c, asc)
        lw, col = (2.2, GOLD) if i in (0, 3, 6, 9) else (0.8, EDGE)
        ax.plot([th, th], [0.18, 0.86], color=col, linewidth=lw)
        nxt = T.CUSPS[(i + 1) % 12]
        mid = c + ((nxt - c) % 360) / 2
        ax.text(_theta(mid, asc), 0.23, str(i + 1), ha="center", va="center", color="#9a96b8", fontsize=9)
    ax.plot(np.linspace(0, 2 * np.pi, 361), [0.86] * 361, color=EDGE, linewidth=1)
    ax.plot(np.linspace(0, 2 * np.pi, 361), [0.18] * 361, color=EDGE, linewidth=1)
    # aspects transit→natal
    col = {"square": "#fb7185", "opposite": "#fb7185", "trine": "#63e6a8", "sextile": "#63e6a8", "conjunct": GOLD}
    for h in T.aspects(when):
        if h["t"] == "Moon":
            continue
        a, b = _theta(tr[h["t"]]["lon"], asc), _theta(nat[h["n"]]["lon"], asc)
        ax.plot([a, b], [0.80, 0.60], color=col[h["aspect"]], linewidth=1.2, alpha=0.85)
    # natal bodies (spread overlapping glyphs)
    def place(items, r, color, size):
        items = sorted(items, key=lambda kv: kv[1])
        last = -99
        for name, lon in items:
            if abs(lon - last) < 4:
                lon_draw = last + 4
            else:
                lon_draw = lon
            last = lon_draw
            ax.text(_theta(lon_draw, asc), r, GLYPH[name], ha="center", va="center", color=color, fontsize=size, fontweight="bold")
            ax.text(_theta(lon_draw, asc), r - 0.07, f"{int(lon % 30)}°", ha="center", va="center", color=color, fontsize=7)
    place([(n, v["lon"]) for n, v in nat.items() if n not in ("IC", "DSC")], 0.62, GOLD, 13)
    place([(n, v["lon"]) for n, v in tr.items()], 0.80, TEAL, 11)
    ax.set_title(f"Mike · natal (gold) + transits (teal) · {when:%a %b %-d %Y %-I:%M %p} ET · Placidus",
                 color=INK, fontsize=11, pad=14)
    out.parent.mkdir(parents=True, exist_ok=True)
    fig.savefig(out, dpi=140, facecolor=BG, bbox_inches="tight")
    plt.close(fig)
    return out


if __name__ == "__main__":
    argv = sys.argv[1:]
    if "--out" in argv:                      # drop the flag AND its value — the path was being parsed as
        i = argv.index("--out")              # the date (ValueError), so the live page kept a Sep 15 wheel
        argv = argv[:i] + argv[i + 2:]
    args = [a for a in argv if not a.startswith("--")]
    when = datetime.now(T.ET) if not args else datetime.fromisoformat(args[0]).replace(hour=12, tzinfo=T.ET)
    out = Path(sys.argv[sys.argv.index("--out") + 1]) if "--out" in sys.argv else Path.home() / "portfolio/astrology/wheel.png"
    print(draw(when, out))
