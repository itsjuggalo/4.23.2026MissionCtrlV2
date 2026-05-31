"""Send a synthetic outcome through relay_v2_outcomes end-to-end.

Posts ONE closure + ONE peak-gain crossing to #flow-v2-shadow AND writes to
~/.openclaw/workspace/directives/options_outcomes_feed.json.

Run on Oracle (or anywhere the pipeline is deployed):
    python3 -m pipeline.discord.send_test_outcome

Use to verify the agent feed pipeline end-to-end on a closed-market day.
"""
from __future__ import annotations

import json
import os
import sys
import time

import requests

from pipeline.discord.agent_feed import AgentFeed
from pipeline.discord.outcomes_mirror import relay_v2_outcomes


SHADOW_WEBHOOK = (
    "https://discord.com/api/webhooks/1510524159812304947/"
    "kKSKyF5-MP9TsKCMNVsY1qTR2-XqXgERldOCjMOTf9iWvGyS6O0-nVn3FKzNyYxu0RUV"
)


def post(webhook_key: str, embed: dict) -> bool:
    if webhook_key != "flow_v2_shadow":
        print(f"  (route '{webhook_key}' — not posting)")
        return False
    r = requests.post(SHADOW_WEBHOOK, json={"embeds": [embed]}, timeout=10)
    print(f"  POST {webhook_key} -> HTTP {r.status_code}  (title: {embed.get('title','')[:60]})")
    return r.status_code in (200, 204)


def main() -> int:
    expiry = int(time.time()) + 86400 * 5  # 5 days out

    synthetic = {
        "closed_options": {
            "synthetic-closure-1": {
                "symbol": "TSLA",
                "strike": 480,
                "isPut": 0,
                "status": "Profit target reached +85%",
                "buyTarget": "2.10",
                "sellTarget": "3.89",
                "category": "SCALP",
                "shortName": "Tesla scalp (synthetic test)",
                "expiry": expiry,
            },
        },
        "closed_stocks": None,
        "flow_alerts_today": {
            "synthetic-peak-1": {
                "alert": {
                    "Symbol": "NVDA",
                    "Strike": 145,
                    "OptionType": "CALL",
                    "Expiry": expiry,
                    "AlertPrice": 1.80,
                    "isBullish": True,
                    "AlertType": "high_flow",
                    "UnderlyingType": "STOCK",
                },
                "quote": {
                    "DayHigh": 5.40,  # +200% from AlertPrice -> crosses 100% tier
                },
            },
        },
    }

    def read(name: str):
        return synthetic.get(name)

    print("v2 outcomes test — synthetic closure + peak-gain")
    print(f"  feed -> {AgentFeed().feed_path}")
    state: dict = {}
    state = relay_v2_outcomes(state, read, post)
    print()

    feed_path = AgentFeed().feed_path
    if feed_path.exists():
        raw = json.loads(feed_path.read_text())
        print(f"feed snapshot: {len(raw)} entries")
        for entry in raw[-3:]:
            ident = f"{entry.get('symbol','?')} {entry.get('strike','')}{entry.get('opt_type','')}"
            t = entry.get("type", "?")
            extra = (
                f"+{entry.get('outcome_pct','?')}%"
                if t == "closure"
                else f"+{entry.get('threshold_pct','?')}% (peak {entry.get('actual_peak_pct','?')}%)"
            )
            print(f"  [{t}] {ident} {extra}")
    else:
        print(f"FEED NOT CREATED — expected at {feed_path}")
        return 1

    print("\ndone.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
