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
    # T9 item 9 (2026-09-27): spy_scalper SMS now says OVER CAP / TRIGGER MET <dir> /
    # SETUP INVALIDATED; the legacy tokens stay accepted for older logged texts.
    if "SIT OUT" in t or "SKIP FOR YOU" in t or "OVER CAP" in t:
        return "sitout"
    if "SPY SCALP" in t and any(k in t for k in ("GO CALLS", "GO PUTS", "TRIGGER MET CALLS", "TRIGGER MET PUTS")):
        return "go"
    if "SETUP DIED" in t or "SETUP INVALIDATED" in t:
        return "died"
    if "PRE-BELL" in t:
        return "prebell"
    if "SCALP REPORT" in t:
        return "eod"
    return "other"


def main():
    day = str(dt.date.today())
    # idempotent per day: cron + manual runs must not double-append the ledger
    try:
        for line in GRADES.read_text().splitlines():
            if json.loads(line).get("day") == day:
                print(f"[grader] {day} already graded — skipping (delete the row to re-run)")
                return
    except FileNotFoundError:
        pass
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
        gate_saved = gate_cost = 0
        for s in sigs:
            if "sl_u" not in s:   # R5 (2026-10-20): cards carry no stop/target — nothing to grade here
                continue
            oc = grade_signal(s, m1)
            muted = bool(s.get("muted"))
            if muted:
                # research-gate counterfactual: was muting the SMS the right call?
                gate_saved += oc == "SL"
                gate_cost += oc == "TP1"
            else:
                w += oc == "TP1"
                l += oc == "SL"
            verdicts.append({"ts": s["ts"], "kind": "signal", "direction": s["direction"],
                             "setup": s.get("setup"), "regime": s.get("regime"),
                             "chain": s.get("chain"), "outcome": oc, "muted": muted,
                             "spy": s["spy"], "sl_u": s["sl_u"], "tp1_u": s["tp1_u"]})
            # edge ledger: SMS rights are earned here — scalper texts a GO only
            # when its fingerprint reaches n>=20 graded at >=60% wins
            if oc in ("TP1", "SL"):
                try:
                    EDGE = HOME / "portfolio/sms_edge.json"
                    edge = json.loads(EDGE.read_text()) if EDGE.exists() else {}
                    k = f"{s.get('regime','?')}/{s['direction']}/{s.get('setup','?')}"
                    st = edge.setdefault(k, {"n": 0, "w": 0})
                    st["n"] += 1
                    st["w"] += oc == "TP1"
                    EDGE.write_text(json.dumps(edge, indent=1))
                except Exception as e:
                    print(f"[grader] edge ledger: {e}", file=sys.stderr)
        n_texted = sum(1 for s in sigs if not s.get("muted"))
        lines.append(f"Texted signals: {w} hit target / {l} stopped / {n_texted-w-l} timed out")
        if gate_saved + gate_cost:
            lines.append(f"Research gate: muted {gate_saved+gate_cost} card(s) — "
                         f"{gate_saved} would have LOST (gate saved you), {gate_cost} would have won")
        so = counts.get("sitout", 0)
        if so:
            # counterfactual honesty: R1 skips graded like any other signal above —
            # if skipped setups keep winning, the cap wording (not the cap) needs review
            lines.append(f"R1 sat out {so} oversized card(s) — outcomes above include them; watch whether skips keep 'winning'")

    # 3: pre-bell playbook vs reality — a real RIGHT/WRONG verdict, not just drift
    # (2026-07-31, Mike: "test the decisions that you give me at the morning to
    # find out its accuracy by end of day"). Rules stated up front:
    #   FADE call   RIGHT if SPY traded back to prior close (gap filled) intraday.
    #   LET-DECIDE  graded by whether holding past 9:45 direction persisted to close.
    #   NEWS GAP    RIGHT if gap direction held into the close (gap-and-go).
    #   NO GAP      no directional call — not graded.
    pb = [t for t in texts if classify(t["text"]) == "prebell"]
    if pb and m1 is not None and len(m1):
        o, c = float(m1.iloc[0]["Open"]), float(m1.iloc[-1]["Close"])
        hi, lo = float(m1["High"].max()), float(m1["Low"].min())
        drift = (c - o) / o * 100
        txt = pb[0]["text"]
        call, result = "none", "ungraded"
        try:
            gapf = json.load(open("/AIWorkWSL/trading/signals/prebell/data/prebell_today.json"))
            gp = gapf["gap"]
            prior, gpct = float(gp["prior_close"]), float(gp["gap_pct"])
        except Exception:
            prior, gpct = None, None
        if "FADE" in txt and prior is not None:
            call = f"FADE (fill to {prior:.2f})"
            filled = (lo <= prior) if gpct > 0 else (hi >= prior)
            result = "RIGHT" if filled else "WRONG"
        elif "NEWS GAP" in txt and gpct is not None:
            call = "GO-WITH (news gap)"
            result = "RIGHT" if (gpct > 0) == (c > o) else "WRONG"
        elif "LET 9:30-9:45 DECIDE" in txt:
            call = "LET-DECIDE"
            try:
                p945 = float(m1.between_time("09:45", "09:50")["Close"].iloc[0])
                result = "RIGHT" if (p945 > o) == (c > o) else "WRONG"
            except Exception:
                result = "ungraded"
        elif "NO GAP" in txt:
            call = "NO-GAP (no directional call)"
        lines.append(f"9:00 call: {call} → {result} · SPY drifted {drift:+.2f}% open→close")
        verdicts.append({"ts": pb[0]["ts"], "kind": "prebell", "call": call,
                         "result": result, "drift_pct": round(drift, 2)})

    # headline accuracy: every graded call today, right vs wrong
    right = sum(1 for v in verdicts if v.get("outcome") == "TP1" or v.get("result") == "RIGHT")
    wrong = sum(1 for v in verdicts if v.get("outcome") == "SL" or v.get("result") == "WRONG")
    if right + wrong:
        lines.insert(1, f"DAY ACCURACY: {right}/{right+wrong} calls right ({right/(right+wrong)*100:.0f}%)")

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
