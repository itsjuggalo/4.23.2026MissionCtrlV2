#!/home/itsju/labs/quantum/.venv/bin/python
"""reserve_persona_push.py — proactive daily/weekly heartbeats for the 4 RESERVE personas.

Each reserve bot is an interactive (pull) daemon under tg_responder.py; this gives each one a
light, REAL-DATA-anchored proactive push so it isn't dead weight. Sends via the persona's own
fleet bot (lib.notify.tg_push → vault token). NEVER ships hallucinated market data — every push
is anchored to a real source (live X search / yfinance moves / the day's top flow pick); the
LLM only adds framing, clearly labeled.

  grok_scout    — pre-open live-X buzz (x_search, grok-3 OAuth)        cron 0 9  * * 1-5
  trend_scanner — post-open momentum movers (yfinance + deepseek)      cron 15 10 * * 1-5
  jazzy_relay   — EOD GPT second-opinion on today's top flow pick      cron 15 16 * * 1-5
  orion_relay   — weekly Gemini research read on the week's standout   cron 0 11 * * 0

Run:  reserve_persona_push.py <grok_scout|trend_scanner|jazzy_relay|orion_relay>   (DRY=1 to print)
"""
from __future__ import annotations

import json
import os
import sys
from pathlib import Path

sys.path.insert(0, "/home/itsju/05_AUTOMATION/scripts")
from lib.notify import tg_push            # noqa: E402
from lib import llm                       # noqa: E402

DRY = os.environ.get("DRY") == "1"
BEST = Path.home() / "labs/quantum/out/best_contracts.json"
WATCH = ["SPY", "QQQ", "NVDA", "TSLA", "AAPL", "MSFT", "AMZN", "META", "GOOGL", "AMD",
         "PLTR", "COIN", "MSTR", "AVGO", "NFLX", "SMCI", "SOFI", "HOOD", "MARA", "RIOT",
         "BABA", "UBER", "DIS", "BA", "INTC", "MU", "CRM", "GME", "AMC", "F"]


def _send(fn: str, text: str):
    if DRY:
        print(f"--- DRY {fn} ---\n{text}\n"); return
    ok = tg_push(text, fn, loud=False, html=True)
    print(f"[{fn}] sent={ok}")


def _movers(top: int = 6):
    """Real 1-day % moves over the watchlist via yfinance. Returns sorted [(tkr, last, pct)]."""
    import yfinance as yf
    df = yf.download(WATCH, period="5d", interval="1d", progress=False,
                     auto_adjust=True, threads=True)["Close"]
    rows = []
    for t in WATCH:
        try:
            s = df[t].dropna()
            if len(s) >= 2:
                rows.append((t, float(s.iloc[-1]), (s.iloc[-1] / s.iloc[-2] - 1) * 100))
        except Exception:
            continue
    rows.sort(key=lambda r: abs(r[2]), reverse=True)
    return rows[:top]


# ───────────────────────────── persona handlers ─────────────────────────────
def grok_scout():
    from lib.x_search import x_search_summary
    out = x_search_summary(
        "Pre-market: search X for the 3 most talked-about stock or crypto tickers right now. "
        "For each: ticker, the bull/bear lean, and the catalyst driving the chatter. Tight "
        "bullets, no preamble.", model="grok-3", timeout=90)
    if not out:
        print("[grok_scout] no live X result — skipping (won't fabricate)"); return
    _send("grok_scout", "🛰️ <b>Grok Scout</b> — pre-open X buzz\n\n" + out)


def trend_scanner():
    try:
        rows = _movers(6)
    except Exception as e:
        print(f"[trend_scanner] yfinance failed: {e}"); return
    if not rows:
        print("[trend_scanner] no data"); return
    table = "\n".join(f"{'🟢' if p >= 0 else '🔴'} <b>{t}</b>  {last:,.2f}  ({p:+.1f}%)"
                      for t, last, p in rows)
    note = llm.call_llm_text(
        "These are today's real 1-day % moves for a liquid watchlist:\n"
        + "\n".join(f"{t} {p:+.1f}%" for t, _, p in rows)
        + "\n\nIn 2-3 tight lines, read ONLY the momentum/relative-strength tape these moves "
          "imply (who's leading/lagging, risk-on vs risk-off). Do NOT invent news or catalysts.",
        ["deepseek"])
    msg = "📡 <b>Trend Scanner</b> — today's movers\n\n" + table
    if note:
        msg += "\n\n" + note.strip()
    _send("trend_scanner", msg)


def jazzy_relay():
    try:
        d = json.loads(BEST.read_text())
        pick = (d.get("picks") or [d])[0] if isinstance(d, dict) else d[0]
    except Exception as e:
        print(f"[jazzy_relay] no top pick: {e}"); return
    if not pick.get("ticker"):
        print("[jazzy_relay] empty pick"); return
    desc = (f"{pick.get('ticker')} {str(pick.get('type','')).upper()} ${pick.get('strike')} "
            f"exp {pick.get('expiry')} ({pick.get('days')} DTE), confidence "
            f"{pick.get('confidence')}, quality {pick.get('quality')}")
    out = llm.call_llm_text(
        f"Today's top options-flow pick is: {desc}. Give a GPT SECOND OPINION for a paper "
        f"trade: is the structure/DTE sound, the single biggest risk, and a clear take/pass — "
        f"sized as a fraction of equity with a $800 max risk cap. 5 lines max, plain.",
        ["codex_cli", "deepseek"])
    if not out:
        print("[jazzy_relay] no LLM output"); return
    _send("jazzy_relay", f"🧮 <b>Jazzy Relay</b> — GPT 2nd opinion on today's top pick\n"
                         f"<i>{desc}</i>\n\n{out.strip()}\n\n<i>Paper-only · independent check</i>")


def orion_relay():
    try:
        rows = _movers(20)
    except Exception:
        rows = []
    # this week's standout = biggest absolute mover we have data for (real anchor)
    tkr = rows[0][0] if rows else "NVDA"
    move = (f" (currently ${rows[0][1]:,.2f}, moved {rows[0][2]:+.1f}% on the day)"
            if rows else "")
    out = llm.call_llm_text(
        f"Write a concise weekly RESEARCH read on {tkr}{move}. IMPORTANT: use the current price "
        f"I gave you — do NOT cite a different price from memory. Cover the setup, 2 bull points, "
        f"2 bear points, key catalysts to watch, and a one-line take. Clearly a research thesis "
        f"to investigate — not financial advice. 8 lines max.",
        ["gemini", "deepseek"])
    if not out:
        print("[orion_relay] no LLM output"); return
    _send("orion_relay", f"🔭 <b>Orion Relay</b> — weekly research read: <b>{tkr}</b>\n\n"
                        f"{out.strip()}\n\n<i>Gemini's read — verify before trading</i>")


HANDLERS = {"grok_scout": grok_scout, "trend_scanner": trend_scanner,
            "jazzy_relay": jazzy_relay, "orion_relay": orion_relay}


def main() -> int:
    if len(sys.argv) < 2 or sys.argv[1] not in HANDLERS:
        print(f"usage: reserve_persona_push.py <{'|'.join(HANDLERS)}>"); return 1
    HANDLERS[sys.argv[1]]()
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
