#!/usr/bin/env python3
"""options.py — AUTOFILL an option contract from minimal input (just a ticker, or a
ticker+strike+type), so the payoff diagram needs almost nothing typed. Uses the live
yfinance chain for strike/premium/spot/expiry; Black-Scholes IV + greeks are computed
self-contained with stdlib math (no scipy/options_engine dependency).

    autofill(ticker, strike=None, opt_type=None, expiry=None, contracts=1) -> spec | None
spec = {symbol, opt_type, strike, expiry, dte, spot, premium, contracts, iv, delta,
        theta, breakeven}  → feeds chart_renderer.payoff_card.
"""
from __future__ import annotations

import math
from datetime import datetime, date

R = 0.045   # risk-free rate


def _ncdf(x):
    return 0.5 * (1 + math.erf(x / math.sqrt(2)))


def _npdf(x):
    return math.exp(-0.5 * x * x) / math.sqrt(2 * math.pi)


def _bs(S, K, T, r, sig, call=True):
    if T <= 0 or sig <= 0:
        return max(0.0, (S - K) if call else (K - S))
    d1 = (math.log(S / K) + (r + 0.5 * sig * sig) * T) / (sig * math.sqrt(T))
    d2 = d1 - sig * math.sqrt(T)
    if call:
        return S * _ncdf(d1) - K * math.exp(-r * T) * _ncdf(d2)
    return K * math.exp(-r * T) * _ncdf(-d2) - S * _ncdf(-d1)


def _greeks(S, K, T, r, sig, call=True):
    if T <= 0 or sig <= 0:
        return {"delta": 0.0, "theta": 0.0}
    d1 = (math.log(S / K) + (r + 0.5 * sig * sig) * T) / (sig * math.sqrt(T))
    d2 = d1 - sig * math.sqrt(T)
    nd1 = _npdf(d1)
    if call:
        delta = _ncdf(d1)
        theta = (-(S * nd1 * sig) / (2 * math.sqrt(T)) - r * K * math.exp(-r * T) * _ncdf(d2)) / 365
    else:
        delta = _ncdf(d1) - 1
        theta = (-(S * nd1 * sig) / (2 * math.sqrt(T)) + r * K * math.exp(-r * T) * _ncdf(-d2)) / 365
    return {"delta": round(delta, 3), "theta": round(theta, 3)}


def _iv(mkt, S, K, T, r, call=True):
    if T <= 0 or mkt <= 0:
        return None
    lo, hi, mid = 1e-4, 5.0, 0.3
    for _ in range(60):
        mid = (lo + hi) / 2
        p = _bs(S, K, T, r, mid, call)
        if abs(p - mkt) < 1e-4:
            return mid
        if p > mkt:
            hi = mid
        else:
            lo = mid
    return mid


def _dte(expiry_str):
    return (datetime.strptime(expiry_str, "%Y-%m-%d").date() - date.today()).days


def _nearest_expiry(t, target_dte=35):
    best = None
    for e in (t.options or ()):
        try:
            dte = _dte(e)
        except Exception:
            continue
        if dte < 2:
            continue
        if best is None or abs(dte - target_dte) < abs(best[1] - target_dte):
            best = (e, dte)
    return best


def autofill(ticker, strike=None, opt_type=None, expiry=None, contracts=1, target_dte=35):
    """Fully-specified contract from minimal input. None on failure (never raises)."""
    try:
        import yfinance as yf
        t = yf.Ticker(ticker)
        h = t.history(period="1d", interval="5m")
        spot = float(h["Close"].iloc[-1]) if len(h) else None
        if not spot:
            h = t.history(period="1d")
            spot = float(h["Close"].iloc[-1]) if len(h) else None
        if not spot:
            return None
        opt_type = "put" if str(opt_type or "").lower().startswith("p") else "call"
        if expiry:
            dte = _dte(expiry)
        else:
            ne = _nearest_expiry(t, target_dte)
            if not ne:
                return None
            expiry, dte = ne
        chain = t.option_chain(expiry)
        df = chain.calls if opt_type == "call" else chain.puts
        if df is None or len(df) == 0:
            return None
        if strike is None:                              # ATM
            row = df.iloc[(df["strike"] - spot).abs().argsort().iloc[0]]
        else:
            exact = df[df["strike"] == float(strike)]
            row = exact.iloc[0] if len(exact) else df.iloc[(df["strike"] - float(strike)).abs().argsort().iloc[0]]
        K = float(row["strike"])
        bid = float(row.get("bid", 0) or 0); ask = float(row.get("ask", 0) or 0)
        last = float(row.get("lastPrice", 0) or 0)
        premium = (bid + ask) / 2 if (bid and ask) else last
        if premium <= 0:
            premium = last or 0.05
        call = opt_type == "call"
        T = max(dte, 0) / 365.0
        iv = _iv(premium, spot, K, T, R, call) or float(row.get("impliedVolatility", 0) or 0) or 0.3
        g = _greeks(spot, K, T, R, iv, call)
        be = round(K + premium, 2) if call else round(K - premium, 2)
        return {"symbol": str(ticker).upper(), "opt_type": opt_type, "strike": K,
                "expiry": expiry, "dte": dte, "spot": round(spot, 2),
                "premium": round(premium, 2), "contracts": int(contracts or 1),
                "iv": round(iv * 100, 1), "delta": g["delta"], "theta": g["theta"],
                "breakeven": be}
    except Exception as e:  # noqa: BLE001
        print(f"options.autofill error: {e}")
        return None


if __name__ == "__main__":
    import json
    print(json.dumps(autofill("NVDA"), indent=2))
