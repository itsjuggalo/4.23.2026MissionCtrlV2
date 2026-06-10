"""Batch dry-run: read a Firebase signals JSON (read-only), produce a TA verdict per
signal, optionally pipe through the real scorer+gatekeeper. Standalone — imports
nothing from the live trader. Writes verdicts to /tmp only.

Usage:
    python3 -m ta_engine.tests.batch_signals [SIGNALS_JSON] [--gate]
Default SIGNALS_JSON = /home/ubuntu/.openclaw/workspace/directives/firebase_trade_signals.json
"""
import sys
import os
import json
import time

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))

from ta_engine import verdict

DEFAULT = "/home/ubuntu/.openclaw/workspace/directives/firebase_trade_signals.json"


def _is_put(val):
    return str(val).lower() in ("1", "true", "yes") if val is not None else False


def main():
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    do_gate = "--gate" in sys.argv
    path = args[0] if args else DEFAULT

    raw = json.load(open(path))
    sigs = raw if isinstance(raw, list) else raw.get("signals", list(raw.values()))

    gate_fn = scorer_fn = None
    if do_gate:
        sys.path.insert(0, os.path.expanduser("~/.openclaw/skills/shared"))
        import signal_scorer, signal_gatekeeper, signal_memory, bypass_log
        import tempfile
        from pathlib import Path
        tmp = Path(tempfile.mkdtemp(prefix="ta_batch_"))
        signal_memory.MEMORY_FILE = tmp / "m.json"; signal_memory.CACHE_DIR = tmp
        bypass_log.LOG_FILE = tmp / "b.json"; bypass_log.CACHE_DIR = tmp
        scorer_fn, gate_fn = signal_scorer.score_signal, signal_gatekeeper.gate_signal

    cache = {}
    out = []
    t0 = time.time()
    for s in sigs:
        tkr = (s.get("ticker") or "").upper()
        if not tkr:
            continue
        side = "short" if _is_put(s.get("is_put")) else "long"
        key = (tkr, side)
        if key not in cache:
            try:
                cache[key] = verdict.analyze(
                    tkr, side=side,
                    asset_type="option" if s.get("strike") else "stock",
                    strike=s.get("strike"), buy=s.get("buy_target"),
                    sell=s.get("sell_target"), stop=s.get("stop_loss"),
                )
            except Exception as e:
                cache[key] = {"ticker": tkr, "error": str(e)}
        v = cache[key]
        row = {"ticker": tkr, "side": side, "source": s.get("source"), "category": s.get("category")}
        if "error" in v:
            row["error"] = v["error"]
        else:
            row.update({"conf": v["confidence"], "rr": v["risk_reward"], "sig_rr": v["signal_risk_reward"],
                        "lean": v["bull_bear_lean"], "type": v["signal_type"], "factors": v["factors"]})
            if do_gate:
                gsig = {"asset": tkr, "direction": side, "price": v["current"], "confidence": v["confidence"],
                        "risk_reward": v["risk_reward"], "factors": v["factors"], "trend": v["trend"],
                        "signal_type": v["signal_type"], "rsi": v["rsi"]}
                g = gate_fn(dict(scorer_fn(gsig)))
                row["gate"] = "PASS" if g["passed"] else f"reject:{g['reason']}"
        out.append(row)
    dt = time.time() - t0

    print(f"{len(sigs)} signals, {len(cache)} unique (ticker,side), {dt:.1f}s "
          f"({dt/max(len(cache),1):.2f}s/unique)\n")
    print(f"{'TKR':6}{'side':6}{'conf':>5}{'rr':>7}{'sigRR':>7}  {'type':12} {'src':10} factors / gate")
    ok = err = passed = 0
    for r in out:
        if "error" in r:
            print(f"{r['ticker']:6}{r['side']:6}  ERR {r['error'][:50]}"); err += 1; continue
        ok += 1
        g = r.get("gate", "")
        if g == "PASS":
            passed += 1
        print(f"{r['ticker']:6}{r['side']:6}{r['conf']:5d}{str(r['rr']):>7}{str(r['sig_rr']):>7}  "
              f"{r['type']:12} {str(r['source'])[:10]:10} {r['factors']} {g}")
    print(f"\nok={ok} err={err}" + (f" gate_pass={passed}" if do_gate else ""))

    outpath = "/tmp/ta_batch_verdicts.json"
    json.dump(out, open(outpath, "w"), indent=2, default=str)
    print(f"verdicts -> {outpath}")


if __name__ == "__main__":
    main()
