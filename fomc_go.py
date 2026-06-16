#!/usr/bin/env python3
"""fomc_go.py — post-FOMC "which branch fired + GO" nudge. Fires ~45 min after the
2:00 PM decision, reads the market's reaction, classifies hawkish/dovish/muted, and
pushes the matching buy list from Mike's FOMC battle plan. ALERT-ONLY, READ-ONLY.

Self-gating: no-ops unless today is an FOMC decision day (embedded FOMC_2026 from
macro_calendar_alert), so a standing `45 14 * * 3` cron auto-fires only the 8 Fed days
a year. Reaction = avg SPY/QQQ move off the 14:00 bar (+ TLT yields, SMH semis as
confirmation). Share sizes live-quoted at run time.

  fomc_go.py            # print (no send) — default
  fomc_go.py --send     # push to trading_command Telegram (loud)
  fomc_go.py --force    # bypass the FOMC-day gate (for testing)
Run with ~/.venv/bin/python.
"""
from __future__ import annotations

import argparse
import json
import sys
import urllib.request
from datetime import datetime, timedelta, timezone
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from macro_calendar_alert import FOMC_2026, et_today  # reuse embedded Fed calendar

SEC = Path.home() / ".openclaw" / "secrets"
ET = timezone(timedelta(hours=-4))
KID = (SEC / "alpaca-boba-key-id").read_text().strip()
SECK = (SEC / "alpaca-boba-secret").read_text().strip()
DATA = "https://data.alpaca.markets"
HDR = {"APCA-API-KEY-ID": KID, "APCA-API-SECRET-KEY": SECK}


def _get(url: str):
    try:
        req = urllib.request.Request(url, headers=HDR)
        with urllib.request.urlopen(req, timeout=12) as r:
            return json.loads(r.read())
    except Exception:
        return None


def moves_since_2pm() -> dict[str, float]:
    """% move from the 14:00 ET bar close to the latest, per symbol."""
    syms = "SPY,QQQ,SMH,TLT"
    start = datetime.now(timezone.utc).astimezone(ET).replace(
        hour=13, minute=55, second=0, microsecond=0).astimezone(timezone.utc)
    url = (f"{DATA}/v2/stocks/bars?symbols={syms}&timeframe=1Min"
           f"&start={start.strftime('%Y-%m-%dT%H:%M:%SZ')}&limit=2000&feed=iex")
    j = _get(url)
    out = {}
    if not j or "bars" not in j:
        return out
    for s, bars in j["bars"].items():
        if not bars:
            continue
        base = None
        for b in bars:
            t = datetime.fromisoformat(b["t"].replace("Z", "+00:00")).astimezone(ET)
            if t.hour == 14 and t.minute == 0:
                base = b["c"]
                break
        base = base if base is not None else bars[0]["c"]
        last = bars[-1]["c"]
        out[s] = (last / base - 1) * 100 if base else 0.0
    return out


def px(symbols: str) -> dict[str, float]:
    j = _get(f"{DATA}/v2/stocks/snapshots?symbols={symbols}")
    out = {}
    if j:
        for s, v in j.items():
            p = (v.get("latestTrade") or {}).get("p")
            if p:
                out[s] = float(p)
    cj = _get(f"{DATA}/v1beta3/crypto/us/snapshots?symbols=ETH/USD")
    if cj:
        e = (cj.get("snapshots", {}).get("ETH/USD", {}).get("latestTrade") or {}).get("p")
        if e:
            out["ETH"] = float(e)
    return out


def classify(m: dict[str, float]) -> str:
    if not m:
        return "unknown"
    eq = (m.get("SPY", 0) + m.get("QQQ", 0)) / 2
    if eq <= -0.4:
        return "hawkish"
    if eq >= 0.4:
        return "dovish"
    return "muted"


def build(send: bool):
    m = moves_since_2pm()
    verdict = classify(m)
    p = px("NFLX,MRVL,QQQ,SPCX,MU")
    def sh(usd, sym):
        q = p.get(sym)
        return f"{usd/q:.0f} sh @ ${q:,.0f}" if q else "(quote n/a)"
    def eth(usd):
        q = p.get("ETH")
        return f"{usd/q:.2f} ETH @ ${q:,.0f}" if q else "(quote n/a)"

    tape = (f"SPY {m.get('SPY',0):+.1f}% · QQQ {m.get('QQQ',0):+.1f}% · "
            f"SMH {m.get('SMH',0):+.1f}% · TLT {m.get('TLT',0):+.1f}% (since 2:00)")
    L = [f"🏛️ <b>FOMC REACTION — {verdict.upper()}</b>", tape, ""]
    core = [f"• <b>ETH</b> ~$700 → {eth(700)} (stake, 8–12% APR)",
            f"• <b>NFLX</b> ~$630 → {sh(630,'NFLX')} (strongest hold)"]
    if verdict == "hawkish":
        L += ["🔴 <b>Hawkish — buy the dip in quality:</b>"] + core
        L += [f"• <b>MRVL</b> ~$586 → {sh(586,'MRVL')} (swept flow, on sale)",
              f"• <b>MU</b> ~$300 add (optional, into 6/24 earnings)"]
    elif verdict == "dovish":
        L += ["🟢 <b>Dovish — add into strength (don't chase the open):</b>"] + core
        L += [f"• <b>QQQ</b> 1 sh → {sh(p.get('QQQ',1),'QQQ')} (risk-on)",
              f"• <b>SPCX</b> ~$216 → {sh(216,'SPCX')} (spec, optional small)"]
    elif verdict == "muted":
        L += ["🟡 <b>Muted reaction</b> — no clear branch. Half-size the core (ETH/NFLX) "
              "or wait for tomorrow's follow-through.", *core]
    else:
        L += ["⚠️ Couldn't read the tape (data gap) — check SPY/QQQ manually before deploying."]
    L += ["", "✅ <b>GO</b> — let the 2:00–2:30 whipsaw settle first, then deploy. "
          "Keep ~$1k reserve for a second leg. Real money = your taps."]
    return "\n".join(L), verdict


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    ap.add_argument("--force", action="store_true", help="bypass FOMC-day gate (testing)")
    a = ap.parse_args()
    today = et_today().isoformat()
    if not a.force and today not in FOMC_2026:
        print(f"[fomc_go] {today} not an FOMC decision day — no-op", flush=True)
        return
    msg, verdict = build(a.send)
    if not a.send:
        print(msg.replace("<b>", "").replace("</b>", ""))
        print(f"\n[dry-run] verdict={verdict} · would send LOUD", flush=True)
        return
    try:
        from lib.notify import tg_push
        fn = tg_push(msg, "trading_command", loud=True,
                     fallback_token_file="telegram_laptopclaude_bot_token")
        print(f"[fomc_go] sent via {fn} (verdict={verdict})", flush=True)
    except Exception as e:
        print(f"[fomc_go] send FAILED: {e}", flush=True)


if __name__ == "__main__":
    main()
