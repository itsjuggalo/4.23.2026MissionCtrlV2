"""CLI: python3 -m ta_engine TICKER [--side long|short] [--type option|stock]
                                  [--strike S] [--buy B] [--stop S] [--sell S] [--json]

Or feed a raw Firebase signal dict:
    python3 -m ta_engine --signal '{"ticker":"QCOM","is_put":0,"buy_target":"5.0",...}'
"""
import argparse
import json
import sys

from . import verdict


def _from_signal(sig):
    """Map a raw Firebase signal dict -> analyze() kwargs."""
    is_put = sig.get("is_put")
    is_put = str(is_put).lower() in ("1", "true", "yes") if is_put is not None else False
    return {
        "ticker": sig.get("ticker"),
        "side": "short" if is_put else "long",
        "asset_type": "option" if sig.get("strike") else "stock",
        "strike": sig.get("strike"),
        "buy": sig.get("buy_target"),
        "sell": sig.get("sell_target"),
        "stop": sig.get("stop_loss"),
    }


def main(argv=None):
    ap = argparse.ArgumentParser(prog="ta_engine")
    ap.add_argument("ticker", nargs="?")
    ap.add_argument("--side", default="long", choices=["long", "short"])
    ap.add_argument("--type", dest="asset_type", default="stock", choices=["option", "stock"])
    ap.add_argument("--strike")
    ap.add_argument("--buy")
    ap.add_argument("--stop")
    ap.add_argument("--sell")
    ap.add_argument("--signal", help="raw Firebase signal JSON")
    ap.add_argument("--json", action="store_true", help="emit full JSON (default: compact summary)")
    a = ap.parse_args(argv)

    if a.signal:
        kwargs = _from_signal(json.loads(a.signal))
    elif a.ticker:
        kwargs = {"ticker": a.ticker, "side": a.side, "asset_type": a.asset_type,
                  "strike": a.strike, "buy": a.buy, "stop": a.stop, "sell": a.sell}
    else:
        ap.error("provide a TICKER or --signal")

    try:
        v = verdict.analyze(**kwargs)
    except Exception as e:
        print(json.dumps({"ticker": kwargs.get("ticker"), "error": str(e)}))
        sys.exit(1)

    if a.json:
        print(json.dumps(v, indent=2, default=str))
    else:
        if "error" in v:
            print(f"{v['ticker']}: ERROR {v['error']}")
        else:
            print(f"{v['ticker']} [{v['direction']}/{v['type']}] @ {v['current']}")
            print(f"  lean={v['bull_bear_lean']} conf={v['confidence']} rr={v['risk_reward']} "
                  f"sig_rr={v['signal_risk_reward']} type={v['signal_type']}")
            print(f"  trend={v['trend']} rsi={v['rsi']} factors={v['factors']}")
            print(f"  read: {v['ta_read']}")


if __name__ == "__main__":
    main()
