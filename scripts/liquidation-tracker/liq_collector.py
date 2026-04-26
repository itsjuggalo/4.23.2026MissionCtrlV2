#!/usr/bin/env python3
"""Subscribe to Binance forceOrder stream, append all liquidations to JSONL."""
import asyncio, json, logging
from pathlib import Path
from datetime import datetime, timezone
import websockets

LOG_DIR = Path("/home/ubuntu/.openclaw/workspace/logs"); LOG_DIR.mkdir(parents=True, exist_ok=True)
STATE_DIR = Path("/home/ubuntu/.openclaw/workspace/state/liquidations"); STATE_DIR.mkdir(parents=True, exist_ok=True)
JSONL = STATE_DIR / "binance_liqs.jsonl"

logging.basicConfig(filename=LOG_DIR/"liq_collector.log", level=logging.INFO,
                    format="%(asctime)s %(levelname)s %(message)s")
log = logging.getLogger("liq")

URL = "wss://fstream.binance.com/ws/!forceOrder@arr"

async def run():
    while True:
        try:
            log.info(f"connecting {URL}")
            async with websockets.connect(URL, ping_interval=20, ping_timeout=20) as ws:
                log.info("connected")
                async for raw in ws:
                    try:
                        msg = json.loads(raw)
                        o = msg.get("o", {})
                        rec = {
                            "ts": int(o.get("T", 0)),
                            "ts_iso": datetime.fromtimestamp(int(o.get("T", 0))/1000, tz=timezone.utc).isoformat(),
                            "symbol": o.get("s", ""),
                            "side": o.get("S", ""),  # SELL=long liquidated, BUY=short liquidated
                            "price": float(o.get("p", 0)),
                            "qty": float(o.get("q", 0)),
                            "value": float(o.get("p", 0)) * float(o.get("q", 0)),
                            "order_status": o.get("X", ""),
                        }
                        with open(JSONL, "a") as f:
                            f.write(json.dumps(rec) + "\n")
                    except Exception as e:
                        log.warning(f"parse: {e}")
        except Exception as e:
            log.error(f"ws err: {e} — reconnecting in 5s")
            await asyncio.sleep(5)

if __name__ == "__main__":
    asyncio.run(run())
