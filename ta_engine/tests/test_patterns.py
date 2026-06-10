"""Hand-built bar asserts for candle + FVG logic, plus a live SMC smoke check."""
import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))))

from ta_engine import patterns, smc, data, indicators as ind


def names(o, h, l, c):
    return {p["pattern"] for p in patterns.detect_candles(o, h, l, c)}


def test_candles():
    # bullish engulfing: prev bearish, cur bullish body engulfs prev
    assert "bullish_engulfing" in names([10, 7.5], [10.1, 10.6], [7.9, 7.4], [8, 10.5])
    # bearish engulfing
    assert "bearish_engulfing" in names([8, 10.5], [10.1, 10.6], [7.9, 7.4], [10, 7.5])
    # doji
    assert "doji" in names([10, 10.0], [10.1, 11.0], [9.9, 9.0], [10, 10.02])
    # hammer: small body top, long lower wick
    assert "hammer" in names([10, 10.0], [10.1, 10.3], [9.9, 8.5], [10, 10.2])
    # inverted hammer: small body bottom, long upper wick
    assert "inverted_hammer" in names([10, 10.0], [10.1, 11.5], [9.9, 9.95], [10, 10.2])
    # piercing line: prev bearish, cur opens below prev close, closes into >50% of prev body
    assert "piercing_line" in names([11, 8.5], [11.1, 10.3], [8.9, 8.4], [9, 10.2])
    # dark cloud cover: prev bullish, cur opens above prev close, closes into >50% of prev body
    assert "dark_cloud_cover" in names([9, 11.5], [11.1, 11.6], [8.9, 9.7], [11, 9.8])
    print("test_candles PASS")


def test_fvg():
    # bullish FVG: low[2]=10.5 > high[0]=10.0
    o = [9.5, 10.5, 10.6]
    h = [10.0, 11.0, 11.2]
    l = [9.0, 10.0, 10.5]
    c = [9.8, 10.8, 11.0]
    fv = smc._fvgs(o, h, l, c)
    assert any(f["type"] == "bullish" and f["bottom"] == 10.0 and f["top"] == 10.5 for f in fv), fv
    # bearish FVG: high[2]=9.0 < low[0]=10.0
    o2 = [10.5, 9.5, 8.8]
    h2 = [11.0, 10.0, 9.0]
    l2 = [10.0, 9.0, 8.5]
    c2 = [10.2, 9.2, 8.6]
    fv2 = smc._fvgs(o2, h2, l2, c2)
    assert any(f["type"] == "bearish" and f["top"] == 10.0 and f["bottom"] == 9.0 for f in fv2), fv2
    print("test_fvg PASS")


def test_smc_live():
    for t in ["QCOM", "TSLA", "SPY"]:
        b = data.fetch_ohlcv(t)
        s = smc.analyze_smc(b["open"], b["high"], b["low"], b["close"])
        assert s["structure"] in ("bullish", "bearish", "neutral")
        assert set(s.keys()) == {"structure", "event", "last_swing_high", "last_swing_low", "fvg", "order_block"}
        print(f"  {t}: structure={s['structure']} event={s['event']} sh={s['last_swing_high']} sl={s['last_swing_low']} "
              f"fvg={len(s['fvg'])} ob={s['order_block']['type'] if s['order_block'] else None}")
    print("test_smc_live PASS")


if __name__ == "__main__":
    test_candles()
    test_fvg()
    test_smc_live()
    print("ALL PATTERN TESTS PASS")
