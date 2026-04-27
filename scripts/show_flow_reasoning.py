"""
Quick CLI to inspect why any recent flow signal scored what it did.
Reads the flow_scorer sidecar (scored_signals_recent.json).

Usage:
    show_flow_reasoning.py              # show last 5 scored signals
    show_flow_reasoning.py --top 10     # top 10 by score
    show_flow_reasoning.py --ticker NVDA  # all NVDA signals
    show_flow_reasoning.py --min 70     # signals >= 70 score
"""
import argparse
import json
from pathlib import Path

SIDECAR = Path("/home/ubuntu/mission-control/signal-receiver/data/scored_signals_recent.json")

def main():
    p = argparse.ArgumentParser()
    p.add_argument("--top", type=int, default=5)
    p.add_argument("--ticker", type=str, default="")
    p.add_argument("--min", type=int, default=0, dest="min_score")
    args = p.parse_args()

    if not SIDECAR.exists():
        print(f"No sidecar file at {SIDECAR}")
        print("Flow scorer hasn't processed any signals yet — check flow-monitor PM2 logs.")
        return 1

    data = json.loads(SIDECAR.read_text())
    if args.ticker:
        data = [d for d in data if (d.get("ticker") or "").upper() == args.ticker.upper()]
    if args.min_score:
        data = [d for d in data if d.get("score", 0) >= args.min_score]

    data = sorted(data, key=lambda x: -x.get("score", 0))[:args.top]

    if not data:
        print("(no matching signals)")
        return 0

    for d in data:
        ot = (d.get("option_type") or "?")[:1]
        print("=" * 70)
        print(f"{d.get('ticker','?')} ${d.get('strike','?')}{ot} exp {d.get('expiry','?')} ({d.get('dte','?')} DTE)")
        print(f"  SCORE: {d.get('score','?')}/100 ({d.get('grade','?')})")
        print(f"  Flow: {d.get('flow_value_raw','?')}  Vol/OI: {d.get('volume','?')}/{d.get('oi','?')} ({d.get('vol_oi_ratio','?')}x)")
        print(f"  Sweeps/Blocks: {d.get('sweeps',0)}/{d.get('blocks',0)}  Spot: ${d.get('spot','?')}")
        print(f"  Alert: {d.get('alert_type','?')}")
        print(f"  REASONS:")
        for r in d.get("reasons", []):
            print(f"    • {r}")
        print(f"  REC: {d.get('recommendation','?')}")
        print(f"  Seen: {d.get('timestamp','?')}")
        print()

    return 0

if __name__ == "__main__":
    import sys
    sys.exit(main())
