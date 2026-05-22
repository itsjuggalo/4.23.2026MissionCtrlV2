#!/usr/bin/env -S uv run --quiet --script
# /// script
# dependencies = ["yfinance"]
# ///
"""Standalone yfinance info fetcher used by /api/stock/[ticker].

Returns the same JSON shape the old inline-python heredoc returned, so the
Next.js route can drop in unchanged. We split it out of the heredoc so the
route doesn't depend on yfinance being importable from system python — uv
runs the script in its own ephemeral venv.

Usage: stock-info.py TICKER
"""
import json
import sys


def main() -> int:
    ticker = (sys.argv[1] if len(sys.argv) > 1 else "").upper()
    if not ticker:
        print(json.dumps({"err": "missing ticker"}))
        return 0
    try:
        import yfinance as yf

        t = yf.Ticker(ticker)
        info = t.info or {}

        # earnings history — best-effort, never fatal
        rows = []
        try:
            ed = t.earnings_dates
            if ed is not None:
                for ts, row in ed.head(10).iterrows():
                    est = row.get("EPS Estimate")
                    act = row.get("Reported EPS")
                    rows.append({
                        "date": ts.strftime("%Y-%m-%d") if hasattr(ts, "strftime") else str(ts)[:10],
                        "est": float(est) if est is not None and str(est) != "nan" else None,
                        "act": float(act) if act is not None and str(act) != "nan" else None,
                    })
        except Exception:
            pass

        next_eps = None
        try:
            cal = t.calendar
            if cal and "Earnings Date" in cal:
                d = cal["Earnings Date"]
                if isinstance(d, list) and d:
                    next_eps = str(d[0])[:10]
        except Exception:
            pass

        out = {
            "description": info.get("longBusinessSummary", ""),
            "exchange": info.get("exchange", ""),
            "industry": info.get("industry", "") or info.get("sector", ""),
            "website": info.get("website", ""),
            "marketCap": info.get("marketCap"),
            "pe": info.get("trailingPE"),
            "eps": info.get("trailingEps"),
            "avgVol": info.get("averageVolume"),
            "volume": info.get("volume"),
            "targetPrice": info.get("targetMeanPrice"),
            "recommendation": info.get("recommendationKey", ""),
            "wk52High": info.get("fiftyTwoWeekHigh"),
            "wk52Low": info.get("fiftyTwoWeekLow"),
            "bookValue": info.get("bookValue"),
            "open": info.get("open"),
            "dayHigh": info.get("dayHigh"),
            "dayLow": info.get("dayLow"),
            "prevClose": info.get("previousClose"),
            "regularPrice": info.get("regularMarketPrice"),
            "regularChange": info.get("regularMarketChange"),
            "regularChangePct": info.get("regularMarketChangePercent"),
            "postPrice": info.get("postMarketPrice"),
            "postChange": info.get("postMarketChange"),
            "postChangePct": info.get("postMarketChangePercent"),
            "earnings": rows,
            "nextEarnings": next_eps,
        }
        print(json.dumps(out, default=str))
    except Exception as e:
        print(json.dumps({"err": str(e)[:200]}))
    return 0


if __name__ == "__main__":
    sys.exit(main())
