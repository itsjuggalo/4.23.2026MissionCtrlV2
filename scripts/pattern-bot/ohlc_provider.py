"""OHLC data provider abstraction.
Active: TradierProvider (uses ~/.openclaw/secrets/tradier-sandbox-key)
Stubbed: FinnhubProvider, YFinanceProvider, AlphaVantageProvider
Switch active provider by editing get_active_provider() at bottom.
"""
import os, time, json, logging
from pathlib import Path
from datetime import datetime, timedelta
import requests

SECRETS = Path.home() / ".openclaw" / "secrets"
CACHE_DIR = Path.home() / ".openclaw" / "workspace" / "state" / "ohlc_cache"
CACHE_DIR.mkdir(parents=True, exist_ok=True)
QUOTE_TTL = 60   # 60 sec for live quote
HIST_TTL = 600   # 10 min for daily history


def _cache_get(key, ttl):
    f = CACHE_DIR / f"{key}.json"
    if not f.exists() or time.time() - f.stat().st_mtime > ttl:
        return None
    try:
        return json.loads(f.read_text())
    except Exception:
        return None


def _cache_set(key, data):
    try:
        (CACHE_DIR / f"{key}.json").write_text(json.dumps(data))
    except Exception:
        pass


class OHLCProvider:
    """Base class. Subclass and implement get_quote + get_history."""
    name = "abstract"

    def get_quote(self, symbol):
        """Returns {symbol, last, open, high, low, prev_close, volume} or None."""
        raise NotImplementedError

    def get_history(self, symbol, days=10):
        """Returns list of {date, open, high, low, close, volume}, oldest first.
        Returns None on failure."""
        raise NotImplementedError


# ─── Tradier (ACTIVE) ────────────────────────────────────────────────
class TradierProvider(OHLCProvider):
    name = "tradier"
    BASE = "https://sandbox.tradier.com/v1"

    def _key(self):
        p = SECRETS / "tradier-sandbox-key"
        return p.read_text().strip() if p.exists() else ""

    def _headers(self):
        return {"Authorization": f"Bearer {self._key()}", "Accept": "application/json"}

    def get_quote(self, symbol):
        cache_key = f"tradier_quote_{symbol}"
        cached = _cache_get(cache_key, QUOTE_TTL)
        if cached is not None:
            return cached
        try:
            r = requests.get(f"{self.BASE}/markets/quotes",
                             headers=self._headers(), params={"symbols": symbol}, timeout=10)
            if r.status_code != 200:
                logging.warning(f"tradier quote {symbol} HTTP {r.status_code}")
                return None
            q = (r.json().get("quotes", {}) or {}).get("quote")
            if not q: return None
            if isinstance(q, list): q = q[0]
            data = {
                "symbol": q.get("symbol"),
                "last": float(q.get("last", 0) or 0),
                "open": float(q.get("open", 0) or 0),
                "high": float(q.get("high", 0) or 0),
                "low": float(q.get("low", 0) or 0),
                "prev_close": float(q.get("prevclose", 0) or 0),
                "volume": int(q.get("volume", 0) or 0),
            }
            _cache_set(cache_key, data)
            return data
        except Exception as e:
            logging.error(f"tradier quote {symbol}: {e}")
            return None

    def get_history(self, symbol, days=10):
        cache_key = f"tradier_hist_{symbol}_{days}"
        cached = _cache_get(cache_key, HIST_TTL)
        if cached is not None:
            return cached
        try:
            end = datetime.now().date()
            start = end - timedelta(days=days + 5)  # buffer for weekends
            r = requests.get(f"{self.BASE}/markets/history",
                             headers=self._headers(),
                             params={"symbol": symbol, "interval": "daily",
                                     "start": str(start), "end": str(end)},
                             timeout=10)
            if r.status_code != 200:
                logging.warning(f"tradier history {symbol} HTTP {r.status_code}")
                return None
            days_data = (r.json().get("history", {}) or {}).get("day", [])
            if isinstance(days_data, dict): days_data = [days_data]
            if not days_data: return None
            out = [{
                "date": d.get("date"),
                "open": float(d.get("open", 0) or 0),
                "high": float(d.get("high", 0) or 0),
                "low": float(d.get("low", 0) or 0),
                "close": float(d.get("close", 0) or 0),
                "volume": int(d.get("volume", 0) or 0),
            } for d in days_data]
            out.sort(key=lambda x: x["date"])
            _cache_set(cache_key, out)
            return out
        except Exception as e:
            logging.error(f"tradier history {symbol}: {e}")
            return None


# ─── Finnhub (STUB - swap in when key is restored) ───────────────────
class FinnhubProvider(OHLCProvider):
    name = "finnhub"
    BASE = "https://finnhub.io/api/v1"

    def _key(self):
        p = SECRETS / "finnhub_api_key"
        return p.read_text().strip() if p.exists() else ""

    def get_quote(self, symbol):
        # TODO: GET /quote?symbol=X&token=KEY
        # Returns {c, o, h, l, pc, v}
        return None

    def get_history(self, symbol, days=10):
        # TODO: GET /stock/candle?symbol=X&resolution=D&from=&to=&token=KEY
        return None


# ─── yfinance (STUB - rate-limited but no key) ───────────────────────
class YFinanceProvider(OHLCProvider):
    name = "yfinance"

    def get_quote(self, symbol):
        # TODO: import yfinance as yf; yf.Ticker(symbol).info
        return None

    def get_history(self, symbol, days=10):
        # TODO: yf.Ticker(symbol).history(period=f"{days}d")
        return None


# ─── Alpha Vantage (STUB) ────────────────────────────────────────────
class AlphaVantageProvider(OHLCProvider):
    name = "alpha_vantage"
    BASE = "https://www.alphavantage.co/query"

    def get_quote(self, symbol):
        # TODO: function=GLOBAL_QUOTE&symbol=X&apikey=KEY
        return None

    def get_history(self, symbol, days=10):
        # TODO: function=TIME_SERIES_DAILY&symbol=X&apikey=KEY
        return None


# ═══ ACTIVE PROVIDER — change this line to swap source ═══
def get_active_provider():
    return TradierProvider()
