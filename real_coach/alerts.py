#!/usr/bin/env python3
"""alerts.py — 30-min market-hours watcher on the REAL book coach levels.

Cheap by design (cb_rh_crypto_watch pattern): no TA re-run — reads the levels the
last sweep wrote to coach_verdicts.json, pulls CURRENT prices only (yfinance batch
for stocks, CoinGecko for crypto), and fires ONE loud Telegram ping per event per
day: 🛑 stop breach · 🏃 bounce-target reached (dead bag: SELL THE POP) · 🎯 target
hit · ⚠️ big single-day move ≥8%. Also ratchets the peak store so trails climb
intraday. Advisory only, dedup via ~/portfolio/.coach_state.json. Never raises.
"""
from __future__ import annotations

import subprocess
import sys
import traceback
from datetime import datetime
from pathlib import Path

SCRIPTS = Path(__file__).resolve().parent.parent
sys.path.insert(0, str(SCRIPTS))

from real_coach import book as bookmod  # noqa: E402
from real_coach import symbols as symmod  # noqa: E402

TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
TG_FN = "trading_command"


def tg(msg: str) -> None:
    try:
        subprocess.run([sys.executable, str(TG_FLEET), "send", TG_FN, msg],
                       capture_output=True, timeout=30)
    except Exception:
        pass


def live_prices(results: list[dict]) -> dict[str, float]:
    """key -> live price. Stocks batched via yfinance download; crypto via CoinGecko."""
    px: dict[str, float] = {}
    stocks = sorted({r["symbol"] for r in results if r["asset_class"] == "stock"})
    cryptos = sorted({r["symbol"] for r in results if r["asset_class"] == "crypto"})
    if stocks:
        try:
            import yfinance as yf
            df = yf.download(" ".join(stocks), period="1d", interval="1m",
                             progress=False, threads=True)["Close"]
            if hasattr(df, "columns"):
                for s in stocks:
                    try:
                        v = df[s].dropna()
                        if len(v):
                            px[f"stock:{s}"] = float(v.iloc[-1])
                    except Exception:
                        pass
            elif len(df.dropna()):
                px[f"stock:{stocks[0]}"] = float(df.dropna().iloc[-1])
        except Exception:
            pass
    if cryptos:
        for sym, d in symmod.cg_prices(cryptos).items():
            if d.get("usd"):
                px[f"crypto:{sym}"] = float(d["usd"])
                px[f"chg:{sym}"] = float(d.get("usd_24h_change") or 0)
    return px


def main() -> int:
    try:
        verd = bookmod._load_json(bookmod.VERDICTS, None)
        if not verd:
            print("no coach_verdicts.json yet — run coach.py --sweep first")
            return 0
        results = [r for r in verd["results"] if r.get("mode") == "ta"]
        state = bookmod.load_state()
        cfg = bookmod.load_config()
        big = float(cfg["rules"].get("big_move_alert_pct", 8))
        today = datetime.now().strftime("%Y-%m-%d")
        alerted = state.setdefault("alerted", {})
        if alerted.get("_day") != today:            # daily dedup reset
            state["alerted"] = alerted = {"_day": today}
        px = live_prices(results)

        fired = 0
        for r in results:
            key, sym, ac = r["key"], r["symbol"], r["asset_class"]
            cur = px.get(f"{ac}:{sym}")
            if not cur:
                continue
            peak = bookmod.peak_update(state, key, cur)

            def fire(event: str, msg: str):
                nonlocal fired
                k = f"{key}:{event}"
                if alerted.get(k):
                    return
                alerted[k] = bookmod.now_et()
                tg(msg)
                print(f"ALERT {k}: {msg.splitlines()[0]}")
                fired += 1

            stop = r.get("stop")
            trail = r.get("trail_stop")
            tgt = r.get("target")
            eff_stop = max([x for x in (stop, trail) if x], default=None)
            if eff_stop and cur <= float(eff_stop):
                fire("stop", f"🛑 {sym} ${cur:g} broke your stop ${eff_stop:g} "
                             f"[{r['bucket']}] — coach said: {r['reasons'][0][:150]}\n"
                             f"Rule: losers get CUT here, not held to −50%. Sell or type WHY you're overriding.")
            elif r["verdict"] == "EXIT_ON_BOUNCE" and tgt and cur >= float(tgt):
                fire("bounce", f"🏃 {sym} popped to ${cur:g} — your dead-bag EXIT level "
                               f"${tgt:g} is HERE. This is the strength you were waiting for: SELL IT.")
            elif r["verdict"] in ("HOLD", "ADD") and tgt and cur >= float(tgt):
                fire("target", f"🎯 {sym} hit target ${tgt:g} (now ${cur:g}) — "
                               f"trim half or raise the trail; don't round-trip a winner.")
            chg = px.get(f"chg:{sym}")
            if chg is not None and abs(chg) >= big:
                fire("bigmove", f"⚠️ {sym} {chg:+.1f}% in 24h (${cur:g}) — "
                               f"{'strength: consider trimming into it' if chg > 0 else 'check the stop line'}"
                               f" [{r['verdict']}]")
        bookmod.save_state(state)
        print(f"{bookmod.now_et()} — {len(results)} watched, {fired} alerts")
        return 0
    except Exception:
        print("alerts error:\n" + traceback.format_exc())
        return 0


if __name__ == "__main__":
    sys.exit(main())
