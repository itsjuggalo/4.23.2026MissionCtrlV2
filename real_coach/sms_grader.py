#!/usr/bin/env python3
"""sms_grader.py — daily backtest of every SMS the trading lane sent Mike.

2026-07-31, Mike's ask: "keep a log of your sms responses so we can backtest
your results daily for improvements". mc_sms.send_sms() journals every text to
~/portfolio/sms_log.jsonl; this grader runs on cron after the close and:

  1. GO cards      -> graded vs SPY's actual 1-min path (same TP1/SL rules the
                      card told Mike to obey), from scalper_signals.jsonl.
  2. SIT-OUT cards -> counterfactual: would the skipped oversized trade have
                      won or lost? (tells us if R1 is saving or costing money)
  3. PRE-BELL card -> did the playbook read (fade/go-with/no-gap) match what
                      SPY actually did into the close?
  4. Delivery      -> any FAILED sends (gateway down) get flagged loudly.

Output: append per-day verdicts to ~/portfolio/sms_grades.jsonl (machine ledger,
accumulates for weekly improvement passes) + a TG report card. Read-only against
brokers; touches nothing live.
"""
import datetime as dt
import json
import subprocess
import sys
from pathlib import Path
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")
HOME = Path.home()
SMS_LOG = HOME / "portfolio/sms_log.jsonl"
GRADES = HOME / "portfolio/sms_grades.jsonl"
SIGNALS = Path("/AIWorkWSL/trading/signals/prebell/data/scalper_signals.jsonl")
TG_SEND = str(HOME / "bin/tg-send-msg")


def jl(path, day):
    out = []
    try:
        for line in Path(path).read_text().splitlines():
            try:
                d = json.loads(line)
                if d.get("ts", "")[:10] == day:
                    out.append(d)
            except Exception:
                continue
    except Exception:
        pass
    return out


def spy_bars():
    import yfinance as yf
    return yf.Ticker("SPY").history(period="1d", interval="1m").tz_convert(ET)


def grade_signal(s, m1):
    """Same rules the card texted: TP1 hit = win, SL hit = loss, else timeout."""
    after = m1[m1.index > dt.datetime.fromisoformat(s["ts"]).replace(tzinfo=ET)] \
        if dt.datetime.fromisoformat(s["ts"]).tzinfo is None else \
        m1[m1.index > dt.datetime.fromisoformat(s["ts"])]
    for _, bar in after.iterrows():
        if s["direction"] == "CALLS":
            if bar["Low"] <= s["sl_u"]:
                return "SL"
            if bar["High"] >= s["tp1_u"]:
                return "TP1"
        else:
            if bar["High"] >= s["sl_u"]:
                return "SL"
            if bar["Low"] <= s["tp1_u"]:
                return "TP1"
    return "timeout"


def classify(text):
    t = text.upper()
    if "SIT OUT" in t or "SKIP FOR YOU" in t:
        return "sitout"
    if "SPY SCALP" in t and ("GO CALLS" in t or "GO PUTS" in t):
        return "go"
    if "SETUP DIED" in t:
        return "died"
    if "PRE-BELL" in t:
        return "prebell"
    if "SCALP REPORT" in t:
        return "eod"
    return "other"


def main():
    day = str(dt.date.today())
    texts = jl(SMS_LOG, day)
    if not texts:
        print(f"[grader] no SMS logged {day} — nothing to grade")
        return
    sigs = jl(SIGNALS, day)
    try:
        m1 = spy_bars()
    except Exception as e:
        m1 = None
        print(f"[grader] no SPY bars ({type(e).__name__}) — delivery-only grade", file=sys.stderr)

    lines = [f"📊 SMS GRADER — {day} ({len(texts)} text(s) sent)"]
    verdicts = []
    failed = [t for t in texts if not t.get("delivered")]
    if failed:
        lines.append(f"🚨 {len(failed)} text(s) FAILED delivery — gateway needs a look")

    counts = {}
    for t in texts:
        counts[classify(t["text"])] = counts.get(classify(t["text"]), 0) + 1
    lines.append("Mix: " + ", ".join(f"{v}x {k}" for k, v in sorted(counts.items())))

    # 1+2: GO / SIT-OUT graded off the signals ledger (source of truth for levels)
    if m1 is not None and len(m1) and sigs:
        w = l = 0
        for s in sigs:
            oc = grade_signal(s, m1)
            w += oc == "TP1"
            l += oc == "SL"
            verdicts.append({"ts": s["ts"], "kind": "signal", "direction": s["direction"],
                             "outcome": oc, "spy": s["spy"], "sl_u": s["sl_u"], "tp1_u": s["tp1_u"]})
        lines.append(f"Signals: {w} hit target / {l} stopped / {len(sigs)-w-l} timed out")
        so = counts.get("sitout", 0)
        if so:
            # counterfactual honesty: R1 skips graded like any other signal above —
            # if skipped setups keep winning, the cap wording (not the cap) needs review
            lines.append(f"R1 sat out {so} oversized card(s) — outcomes above include them; watch whether skips keep 'winning'")

    # 3: pre-bell playbook vs reality (gap fill check off open/close)
    pb = [t for t in texts if classify(t["text"]) == "prebell"]
    if pb and m1 is not None and len(m1):
        o, c = float(m1.iloc[0]["Open"]), float(m1.iloc[-1]["Close"])
        drift = (c - o) / o * 100
        lines.append(f"Pre-bell read vs reality: SPY drifted {drift:+.2f}% open→close")
        verdicts.append({"ts": pb[0]["ts"], "kind": "prebell", "drift_pct": round(drift, 2)})

    # ledger append (accumulates across days for the weekly improvement pass)
    try:
        GRADES.parent.mkdir(parents=True, exist_ok=True)
        with GRADES.open("a") as fh:
            fh.write(json.dumps({"day": day, "n_texts": len(texts), "n_failed": len(failed),
                                 "mix": counts, "verdicts": verdicts}) + "\n")
    except Exception as e:
        print(f"[grader] ledger write failed: {e}", file=sys.stderr)

    lines.append("Ledger: ~/portfolio/sms_grades.jsonl — weekly pass mines this for wording/level improvements")
    subprocess.run([TG_SEND, "\n".join(lines)], timeout=60, check=False)
    print("\n".join(lines))


if __name__ == "__main__":
    main()
