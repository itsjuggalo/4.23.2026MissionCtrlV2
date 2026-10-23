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

--edge [--dry-run] (W7, DECISIONS R6, 2026-10-21): grades every scalper card by momentum follow-through vs SPY
(no stop/target) into ~/portfolio/sms_grades_r6.jsonl and writes the edge report ~/portfolio/sms_edge_r6.json
(bootstrap CI, shuffled same-day baseline, out-of-sample split). No message is sent; the live SMS gate file
sms_edge.json is not touched (switching the gate is staged for Mike).
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
            if str(gapf.get("asof", ""))[:10] != day:   # standard #4: only today's pre-bell gap grades today's call
                raise ValueError(f"prebell_today.json as_of {gapf.get('asof')} is not {day}")
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


# ── W7 (DECISIONS R6): momentum follow-through edge ledger ───────────────────────────────────────────────────────
# Every scalper TRIGGER MET card is graded by the SPY move in its direction at +15 m / +1 h / close (plus best/worst),
# never by stop/target. Bars: Yahoo SPY via yfinance (bars rule, market-data §4; "not Robinhood"), the finest
# interval Yahoo still serves for that day (1 m ≤ 29 d, 5 m ≤ 59 d, else 1 h). Per-signal grades accumulate in
# GRADES_R6 so the 1-minute grade survives after Yahoo drops the 1-minute bars. Stats per fingerprint
# (regime/direction/setup): bootstrap 95 % CI of the mean, a same-day shuffled-entry baseline, and an
# out-of-sample split. Output EDGE_R6. Nothing here sends a message, and the scalper's live gate (sms_edge.json,
# TP1/SL counts) is NOT touched: switching the gate to these numbers is staged for Mike.
GRADES_R6 = HOME / "portfolio/sms_grades_r6.jsonl"
EDGE_R6 = HOME / "portfolio/sms_edge_r6.json"
BARS_SOURCE = "Yahoo SPY bars via yfinance (not Robinhood)"
HORIZONS = {"m15": 15, "h1": 60}
MIN_N, ALPHA, BOOT, SHUFFLE, OOS_FRAC = 20, 0.05, 5000, 200, 0.6


def _interval_for(day: dt.date, today: dt.date) -> str | None:
    age = (today - day).days
    return "1m" if age <= 28 else "5m" if age <= 58 else "1h" if age <= 700 else None


def _day_bars(day: dt.date, interval: str):
    import yfinance as yf
    h = yf.Ticker("SPY").history(start=str(day), end=str(day + dt.timedelta(days=1)), interval=interval,
                                 prepost=False, auto_adjust=False)
    if h is None or h.empty:
        return None
    h = h.tz_convert(ET)
    return h[(h.index.time >= dt.time(9, 30)) & (h.index.time < dt.time(16, 0))]


def follow_through_r6(t0: dt.datetime, entry: float, sign: int, bars, interval: str) -> dict | None:
    """Signed % SPY move after t0. A horizon reads the close of the last bar that ENDS by t0+H (no peeking past
    the horizon); a horizon no bar fits is None (UNAVAILABLE), never interpolated."""
    step = {"1m": 1, "5m": 5, "1h": 60}[interval]
    after = bars[bars.index >= t0]
    if after.empty or not entry:
        return None
    ends = after.index + dt.timedelta(minutes=step)
    pct = lambda px: round(sign * (float(px) - entry) / entry * 100, 4)
    out = {}
    for k, m in HORIZONS.items():
        fit = after[ends <= t0 + dt.timedelta(minutes=m)]
        out[k] = pct(fit["Close"].iloc[-1]) if len(fit) else None
    out["close"] = pct(after["Close"].iloc[-1])
    hi, lo = pct(after["High"].max()), pct(after["Low"].min())
    out["best"], out["worst"] = max(hi, lo), min(hi, lo)
    out["last_bar_et"] = (after.index[-1] + dt.timedelta(minutes=step)).strftime("%Y-%m-%d %H:%M ET")
    return out


def _shuffled(bars, interval: str, sign: int, rng, k: int) -> list[float]:
    """Same-day, same-direction entries at random bar opens 09:45-15:00 → h1 % move (the 'no skill' baseline)."""
    step = {"1m": 1, "5m": 5, "1h": 60}[interval]
    opens = bars[(bars.index.time >= dt.time(9, 45)) & (bars.index.time <= dt.time(15, 0))]
    out = []
    for i in rng.integers(0, len(opens), size=k) if len(opens) else []:
        t0 = opens.index[i]
        ft = follow_through_r6(t0, float(opens["Open"].iloc[i]), sign, bars, interval)
        if ft and ft["h1"] is not None:
            out.append(ft["h1"])
    return out


def edge_stats(rows: list[dict], metric: str, rng) -> dict:
    import numpy as np
    rows = sorted((r for r in rows if r.get(metric) is not None), key=lambda r: r["ts"])
    x = np.array([r[metric] for r in rows], dtype=float)
    n = len(x)
    st = {"n": n, "metric": metric}
    if n == 0:
        st["verdict"] = "UNAVAILABLE: no graded signals"
        return st
    st.update(mean_pct=round(float(x.mean()), 4), median_pct=round(float(np.median(x)), 4),
              hit_rate=round(float((x > 0).mean()), 3))
    if n >= 2:
        bm = x[rng.integers(0, n, size=(BOOT, n))].mean(axis=1)
        st["ci95_mean_pct"] = [round(float(np.quantile(bm, ALPHA / 2)), 4), round(float(np.quantile(bm, 1 - ALPHA / 2)), 4)]
    base = [r.get("baseline_h1") or [] for r in rows] if metric == "h1" else []
    if base and all(base):   # each bootstrap draw: one random same-day entry per card, averaged over the n cards
        bmeans = np.array([np.mean([b[i] for b, i in zip(base, (rng.integers(0, len(b)) for b in base))]) for _ in range(BOOT)])
        st["baseline_mean_pct"] = round(float(bmeans.mean()), 4)
        st["baseline_p"] = round(float((bmeans >= x.mean()).mean()), 4)
    elif metric == "h1":
        st["baseline_note"] = "UNAVAILABLE: a graded card has no same-day baseline entries"
    cut = max(1, int(n * OOS_FRAC))
    if n - cut >= 1:
        st["in_sample"] = {"n": cut, "mean_pct": round(float(x[:cut].mean()), 4), "hit_rate": round(float((x[:cut] > 0).mean()), 3),
                           "through": rows[cut - 1]["ts"][:10]}
        st["out_of_sample"] = {"n": n - cut, "mean_pct": round(float(x[cut:].mean()), 4),
                               "hit_rate": round(float((x[cut:] > 0).mean()), 3), "from": rows[cut]["ts"][:10]}
    why = []
    if n < MIN_N:
        why.append(f"n={n} < {MIN_N}")
    if "ci95_mean_pct" in st and st["ci95_mean_pct"][0] <= 0:
        why.append("95% CI of the mean includes 0")
    if "baseline_p" in st and st["baseline_p"] >= ALPHA:
        why.append(f"not better than random same-day entries (p={st['baseline_p']})")
    if "out_of_sample" in st and st["out_of_sample"]["mean_pct"] <= 0:
        why.append("out-of-sample mean ≤ 0")
    st["verdict"] = "EDGE" if not why else "NO PROVEN EDGE: " + "; ".join(why)
    return st


def edge_r6(dry_run: bool) -> int:
    import numpy as np
    now = dt.datetime.now(ET)
    today = now.date()
    done = {}
    try:
        for line in GRADES_R6.read_text().splitlines():
            r = json.loads(line)
            done[r["ts"]] = r
    except FileNotFoundError:
        pass
    try:
        sigs = [json.loads(l) for l in SIGNALS.read_text().splitlines() if l.strip()]
    except Exception as e:
        print(f"[grader --edge] FAIL: cannot read {SIGNALS}: {e}", file=sys.stderr)
        return 2
    rng = np.random.default_rng(7)
    new, missing, cache = [], [], {}
    for s in sigs:
        t0 = dt.datetime.fromisoformat(s["ts"])
        t0 = t0.replace(tzinfo=ET) if t0.tzinfo is None else t0.astimezone(ET)
        if s["ts"] in done or (t0.date() == today and now.time() < dt.time(16, 5)):
            continue   # graded already, or today's session is not closed yet
        iv = _interval_for(t0.date(), today)
        if iv is None:
            missing.append(f"{s['ts'][:16]}: older than any Yahoo intraday history")
            continue
        key = (t0.date(), iv)
        if key not in cache:
            try:
                cache[key] = _day_bars(t0.date(), iv)
            except Exception as e:
                cache[key] = None
                missing.append(f"{t0.date()} {iv}: {type(e).__name__}")
        bars = cache[key]
        sign = 1 if s["direction"] == "CALLS" else -1
        ft = follow_through_r6(t0, float(s.get("spy") or 0), sign, bars, iv) if bars is not None else None
        if ft is None:
            missing.append(f"{s['ts'][:16]}: no {iv} SPY bars after the card")
            continue
        new.append({"ts": s["ts"], "fp": f"{s.get('regime', '?')}/{s['direction']}/{s.get('setup', '?')}",
                    "direction": s["direction"], "muted": bool(s.get("muted")), "entry_spy": s.get("spy"),
                    "interval": iv, "source": BARS_SOURCE, **ft,
                    "baseline_h1": _shuffled(bars, iv, sign, rng, SHUFFLE),
                    "graded_at_et": now.isoformat(timespec="seconds")})
    rows = list(done.values()) + new
    fps = sorted({r["fp"] for r in rows})
    out = {"as_of_et": now.isoformat(timespec="seconds"), "source": BARS_SOURCE, "rule": "DECISIONS R6 follow-through; no stop/target, no win/loss",
           "primary_metric": "h1 (signed % SPY move 1 h after the card)",
           "method": {"bootstrap": BOOT, "ci": 1 - ALPHA, "baseline": f"{SHUFFLE} random same-day 09:45-15:00 entries per card, same direction",
                      "oos": f"chronological: first {int(OOS_FRAC * 100)}% in-sample, rest out-of-sample", "edge_needs": f"n≥{MIN_N}, CI>0, p<{ALPHA}, OOS mean>0"},
           "all": {m: edge_stats(rows, m, rng) for m in ("h1", "close", "m15")},
           "fingerprints": {fp: {m: edge_stats([r for r in rows if r["fp"] == fp], m, rng) for m in ("h1", "close")} for fp in fps},
           "missing": missing,
           "gate_status": "STAGED: spy_scalper still gates SMS on sms_edge.json (TP1/SL counts frozen 2026-08-28); switching it to this file is Mike's call"}
    a = out["all"]["h1"]
    print(f"[grader --edge] {len(rows)} graded ({len(new)} new), h1 n={a['n']} mean={a.get('mean_pct')}% CI={a.get('ci95_mean_pct')} "
          f"p={a.get('baseline_p')} → {a['verdict']}")
    for m in missing:
        print(f"[grader --edge] MISSING {m}", file=sys.stderr)
    if dry_run:
        print("[grader --edge] dry-run: nothing written")
        return 0
    if new:
        with GRADES_R6.open("a") as fh:
            for r in new:
                fh.write(json.dumps(r) + "\n")
    EDGE_R6.write_text(json.dumps(out, indent=1))
    return 1 if missing and not rows else 0


if __name__ == "__main__":
    if "--edge" in sys.argv:
        sys.exit(edge_r6("--dry-run" in sys.argv))
    main()
