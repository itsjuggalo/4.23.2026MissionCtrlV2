#!/usr/bin/env python3
"""consensus_gate.py — read-only consensus over scout-agent JSON trailers.

Each scout agent (signal-filter / research-desk / macro-strategist) ends its analysis with a
strict-JSON trailer {ticker,direction,confidence,reason}. This gate parses those trailers from
the agents' outputs and surfaces a CONSENSUS candidate only when >= N DISTINCT scouts agree on
the same ticker + direction.

PURELY OBSERVATIONAL — it never sizes, gates, or places a trade. Output is a ranked list of
consensus candidates for a human / the dashboard to look at. Wiring it into sizing or execution
is a separate, trade-changing step that requires Mike's explicit go.

Usage:
  consensus_gate.py sf.txt rd.txt ms.txt        # one file per scout (source = filename stem)
  consensus_gate.py --stdin                      # read one blob from stdin (source = 'stdin')
  consensus_gate.py sf.txt rd.txt --min 2 --json
  consensus_gate.py --self-test
"""
import argparse, json, re, sys
from pathlib import Path

VALID_DIR = {"long", "short", "flat"}


def extract_objs(text):
    """Yield every balanced {...} substring that parses as a JSON object (brace-in-string safe)."""
    i, n = 0, len(text or "")
    while i < n:
        if text[i] != "{":
            i += 1
            continue
        depth, instr, esc, j = 0, False, False, i
        while j < n:
            c = text[j]
            if instr:
                if esc:        esc = False
                elif c == "\\": esc = True
                elif c == '"':  instr = False
            else:
                if c == '"':   instr = True
                elif c == "{":  depth += 1
                elif c == "}":
                    depth -= 1
                    if depth == 0:
                        break
            j += 1
        chunk = text[i:j + 1]
        try:
            o = json.loads(chunk)
            if isinstance(o, dict):
                yield o
        except Exception:
            pass
        i = j + 1


def parse_trailers(text, source):
    out = []
    for o in extract_objs(text):
        t = str(o.get("ticker", "")).strip().upper()
        d = str(o.get("direction", "")).strip().lower()
        if not t or d not in VALID_DIR:
            continue
        try:
            conf = float(o.get("confidence", 0))
        except Exception:
            conf = 0.0
        out.append({"ticker": t, "direction": d, "confidence": conf,
                    "reason": str(o.get("reason", ""))[:80], "source": source})
    return out


def consensus(verdicts, min_agree=2):
    groups = {}
    for v in verdicts:
        if v["direction"] == "flat":
            continue                         # flat never forms an actionable consensus
        groups.setdefault((v["ticker"], v["direction"]), []).append(v)
    out = []
    for (ticker, direction), vs in groups.items():
        sources = sorted({v["source"] for v in vs})   # DISTINCT scouts only
        if len(sources) < min_agree:
            continue
        confs = [v["confidence"] for v in vs]
        out.append({
            "ticker": ticker, "direction": direction,
            "n_agree": len(sources), "sources": sources,
            "avg_confidence": round(sum(confs) / len(confs), 1),
            "reasons": [f"{v['source']}: {v['reason']}" for v in vs],
        })
    out.sort(key=lambda c: (c["n_agree"], c["avg_confidence"]), reverse=True)
    return out


def _self_test():
    ok = True
    def chk(n, c):
        nonlocal ok; print(f"  [{'PASS' if c else 'FAIL'}] {n}"); ok = ok and c
    sf = 'NVDA looks strong.\n```json\n{"ticker":"NVDA","direction":"long","confidence":70,"reason":"sweeps"}\n```'
    rd = 'analysis...\n{"ticker":"nvda","direction":"long","confidence":80,"reason":"cheap"}\nalso {"ticker":"TSLA","direction":"short","confidence":55,"reason":"weak"}'
    ms = '{"ticker":"NVDA","direction":"flat","confidence":40,"reason":"regime murky"}'
    vs = parse_trailers(sf, "signal-filter") + parse_trailers(rd, "research-desk") + parse_trailers(ms, "macro-strategist")
    chk("parsed 4 trailers", len(vs) == 4)
    chk("ticker uppercased", all(v["ticker"] == v["ticker"].upper() for v in vs))
    c = consensus(vs, min_agree=2)
    nvda = [x for x in c if x["ticker"] == "NVDA"]
    chk("NVDA long = consensus (2 distinct scouts)", len(nvda) == 1 and nvda[0]["n_agree"] == 2)
    chk("NVDA avg confidence = 75", nvda and nvda[0]["avg_confidence"] == 75.0)
    chk("TSLA short NOT consensus (1 scout)", not any(x["ticker"] == "TSLA" for x in c))
    chk("flat excluded from consensus", not any(x["direction"] == "flat" for x in c))
    # dup source must not fake consensus
    dup = parse_trailers(sf, "signal-filter") + parse_trailers(sf, "signal-filter")
    chk("same scout twice != consensus", len(consensus(dup, 2)) == 0)
    print("SELF-TEST:", "PASS" if ok else "FAIL")
    return 0 if ok else 1


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("files", nargs="*")
    ap.add_argument("--stdin", action="store_true")
    ap.add_argument("--min", type=int, default=2)
    ap.add_argument("--json", action="store_true")
    ap.add_argument("--self-test", action="store_true")
    a = ap.parse_args()
    if a.self_test:
        return _self_test()

    verdicts = []
    if a.stdin:
        verdicts += parse_trailers(sys.stdin.read(), "stdin")
    for f in a.files:
        p = Path(f)
        if p.exists():
            verdicts += parse_trailers(p.read_text(), p.stem)
        else:
            print(f"(skip missing {f})", file=sys.stderr)
    if not verdicts:
        print("No JSON trailers found.", file=sys.stderr)
        return 1
    cands = consensus(verdicts, a.min)
    if a.json:
        print(json.dumps(cands, indent=2))
        return 0
    if not cands:
        print(f"No consensus (>= {a.min} scouts agreeing) among {len(verdicts)} verdict(s).")
        return 0
    print(f"CONSENSUS candidates ({len(cands)}) — read-only, not wired to sizing/execution:")
    for c in cands:
        print(f"  {c['ticker']:6} {c['direction']:5} | {c['n_agree']} scouts | "
              f"avg conf {c['avg_confidence']} | {'; '.join(c['reasons'])}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
