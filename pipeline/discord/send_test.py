"""Send a synthetic flow event through the v2 pipeline to the shadow webhook.

Run on Oracle (or anywhere with internet + the pipeline installed):
    python3 pipeline/discord/send_test.py

Posts ONE scored embed to #flow-v2-shadow. Use to verify deployment.
"""
from __future__ import annotations

import sys
import time

import requests

from pipeline.discord.integration_example import relay_v2_shadow


SHADOW_WEBHOOK = (
    "https://discord.com/api/webhooks/1510524159812304947/"
    "kKSKyF5-MP9TsKCMNVsY1qTR2-XqXgERldOCjMOTf9iWvGyS6O0-nVn3FKzNyYxu0RUV"
)


def post(webhook_key: str, embed: dict) -> bool:
    if webhook_key != "flow_v2_shadow":
        print(f"  (route '{webhook_key}' — not posting, only shadow is wired)")
        return False
    r = requests.post(SHADOW_WEBHOOK, json={"embeds": [embed]}, timeout=10)
    print(f"  POST {webhook_key} -> HTTP {r.status_code}")
    return r.status_code in (200, 204)


def main() -> int:
    expiry = int(time.time()) + 86400  # 1 day from now
    alert = {
        "Symbol": "TSLA",
        "Strike": 480,
        "OptionType": "CALL",
        "Expiry": expiry,
        "DTE": 1,
        "isBullish": True,
        "totalFlowValue": 320_000,
        "Volume": 1500,
        "OI": 500,
        "Spot": 478.50,
        "BlockType": "SWEEP",
        "BidAskType": "A",
        "AlertType": "high_flow",
        "UnderlyingType": "STOCK",
        "Time": int(time.time()),
        "SWEEPS": 4,
        "BLOCKS": 1,
    }

    print("v2 pipeline test — posting synthetic TSLA 480C sweep to #flow-v2-shadow")
    relay_v2_shadow("synthetic-test-1", alert, {}, post)
    print("done. Check Discord #flow-v2-shadow.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
