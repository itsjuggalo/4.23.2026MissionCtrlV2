#!/usr/bin/env python3
"""
SuperTrend Calculator — Pure Python
No LLM calls. No pandas. Just math.
"""


def calculate_atr(highs: list, lows: list, closes: list, period: int) -> list:
    """Calculate Average True Range."""
    n = len(closes)
    tr = [0.0] * n
    atr = [0.0] * n

    # First TR is just high - low
    tr[0] = highs[0] - lows[0]

    for i in range(1, n):
        tr[i] = max(
            highs[i] - lows[i],
            abs(highs[i] - closes[i - 1]),
            abs(lows[i] - closes[i - 1])
        )

    # First ATR is simple average of first `period` TRs
    if n < period:
        return atr

    atr[period - 1] = sum(tr[:period]) / period

    # Subsequent ATR uses smoothing
    for i in range(period, n):
        atr[i] = (atr[i - 1] * (period - 1) + tr[i]) / period

    return atr


def calculate_supertrend(highs: list, lows: list, closes: list,
                          atr_period: int = 10, multiplier: float = 3.0) -> dict:
    """
    Calculate SuperTrend indicator.

    Returns dict with:
        - supertrend: list of supertrend values
        - direction: list of 1 (bullish) or -1 (bearish)
        - upper_band: list of upper band values
        - lower_band: list of lower band values
    """
    n = len(closes)
    atr = calculate_atr(highs, lows, closes, atr_period)

    upper_band = [0.0] * n
    lower_band = [0.0] * n
    supertrend = [0.0] * n
    direction = [1] * n  # 1 = bullish, -1 = bearish

    for i in range(n):
        mid = (highs[i] + lows[i]) / 2
        upper_band[i] = mid + multiplier * atr[i]
        lower_band[i] = mid - multiplier * atr[i]

    for i in range(1, n):
        # Lower band logic
        if lower_band[i] > lower_band[i - 1] or closes[i - 1] < lower_band[i - 1]:
            lower_band[i] = lower_band[i]
        else:
            lower_band[i] = lower_band[i - 1]

        # Upper band logic
        if upper_band[i] < upper_band[i - 1] or closes[i - 1] > upper_band[i - 1]:
            upper_band[i] = upper_band[i]
        else:
            upper_band[i] = upper_band[i - 1]

        # Direction
        if supertrend[i - 1] == upper_band[i - 1]:
            direction[i] = -1 if closes[i] > upper_band[i] else 1
        else:
            direction[i] = 1 if closes[i] < lower_band[i] else -1

        # Flip: -1 = bullish (price above), so supertrend = lower band
        if direction[i] == -1:
            supertrend[i] = lower_band[i]
        else:
            supertrend[i] = upper_band[i]

    return {
        "supertrend": supertrend,
        "direction": direction,
        "upper_band": upper_band,
        "lower_band": lower_band,
        "atr": atr,
    }


if __name__ == "__main__":
    # Quick test with fake data
    import random
    random.seed(42)

    price = 85000.0
    highs, lows, closes = [], [], []

    for _ in range(50):
        change = random.uniform(-500, 500)
        h = price + abs(change) + random.uniform(0, 200)
        l = price - abs(change) - random.uniform(0, 200)
        c = price + change
        highs.append(h)
        lows.append(l)
        closes.append(c)
        price = c

    result = calculate_supertrend(highs, lows, closes, atr_period=10, multiplier=3.0)

    print("Last 5 SuperTrend values:")
    for i in range(-5, 0):
        d = "BULL" if result["direction"][i] == -1 else "BEAR"
        print(f"  Close: {closes[i]:,.2f} | ST: {result['supertrend'][i]:,.2f} | {d}")
