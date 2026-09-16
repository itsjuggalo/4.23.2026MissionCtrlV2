#!/usr/bin/env python3
"""tg_format — shared layout helpers for the trading Telegram lanes (2026-09-15 format sweep).

Telegram renders these with parse_mode=HTML (tg_fleet.send(fn, msg, html=True) /
`tg_fleet.py sendhtml`). Rules the sweep settled on so every lane reads the same on a phone:

  • line 1  = glyph + LANE NAME (bold caps) + "· Tue 09-15 08:15 ET"
  • sections = bold caps label on its own line, one blank line between sections
  • one item per line, ticker first in bold, then "·"-separated facts, ≤ ~40 chars/line
  • numbers: $ and % consistently, ≤2 decimals, no trailing zeros noise
  • one footer line for the advisory / source note — never repeat it per item
  • ALWAYS pass dynamic text through esc() — Telegram HTML rejects a stray "<" or "&"
"""
from __future__ import annotations
import html as _html
from datetime import datetime
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
SEP = " · "


def esc(x) -> str:
    """Escape user/market text for Telegram HTML."""
    return _html.escape("" if x is None else str(x), quote=False)


def b(x) -> str:
    return f"<b>{esc(x)}</b>"


def code(x) -> str:
    return f"<code>{esc(x)}</code>"


def stamp(now: datetime | None = None) -> str:
    now = now or datetime.now(ET)
    return now.strftime("%a %m-%d %H:%M ET")


def hdr(glyph: str, lane: str, now: datetime | None = None, sub: str | None = None) -> str:
    """'🧭 <b>TRADING COMMAND</b> · Tue 09-15 08:15 ET' (+ optional second line)."""
    line = f"{glyph} <b>{esc(lane).upper()}</b>{SEP}{stamp(now)}"
    return line + (f"\n{esc(sub)}" if sub else "")


def section(label: str) -> str:
    return f"\n<b>{esc(label).upper()}</b>"


def row(ticker: str, *facts, glyph: str = "") -> str:
    """'▸ <b>NVDA</b> · $182.40 · +3.1% · 14 DTE'  — empty facts are dropped."""
    parts = [f for f in facts if f not in (None, "", False)]
    lead = f"{glyph} " if glyph else "▸ "
    return lead + b(ticker) + (SEP + SEP.join(esc(p) for p in parts) if parts else "")


def kv(*pairs) -> str:
    """kv(("SPY", "661.20"), ("VIX", "16.4")) → 'SPY 661.20 · VIX 16.4'."""
    return SEP.join(f"{esc(k)} {esc(v)}" for k, v in pairs if v not in (None, ""))


def money(x, digits: int = 2) -> str:
    try:
        v = float(x)
    except (TypeError, ValueError):
        return esc(x)
    if abs(v) >= 1_000_000:
        return f"${v/1_000_000:.1f}M"
    if abs(v) >= 10_000:
        return f"${v/1_000:.0f}K"
    return f"${v:,.{digits}f}"


def pct(x, digits: int = 1, signed: bool = True) -> str:
    try:
        v = float(x)
    except (TypeError, ValueError):
        return esc(x)
    return f"{v:+.{digits}f}%" if signed else f"{v:.{digits}f}%"


def footer(text: str) -> str:
    return f"\n<i>{esc(text)}</i>"


def join(*blocks) -> str:
    """Join non-empty blocks with newlines (blocks may already contain their own blank line)."""
    return "\n".join(str(x) for x in blocks if x not in (None, ""))


if __name__ == "__main__":  # smoke render
    print(join(hdr("🧭", "Trading Command", sub="risk-on · VIX 16.4 · CPI 08:30"),
               section("Setups"), row("NVDA", money(182.4), pct(3.1), "14 DTE", glyph="🟢"),
               row("AAPL", money(231.02), pct(-0.8)), footer("advisory — nothing is executed")))
