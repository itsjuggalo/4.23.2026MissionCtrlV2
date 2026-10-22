"""
tastytrade REST quotes client — GET /market-data/by-type (real-time, funded accounts only).

Read-only market data for Mission Control. Never places orders.

Auth: OAuth2 personal grant. The refresh token is exchanged for a 15-minute access token
(POST /oauth/token), cached in memory until ~60s before expiry, refreshed automatically.
Secrets (never printed): ~/.openclaw/secrets/tastytrade-client-id,
tastytrade-client-secret, tastytrade-refresh-token.

Quotes are cached for 60 seconds per symbol (file cache, same pattern as tradier_client.py).
Prices/sizes come back as decimal strings; they are parsed to Decimal, "NaN"/null -> None.
No fallback data: a 403 (account not permitted / not funded) raises, it never fakes a quote.

TT_ENV=prod (default) -> https://api.tastyworks.com
TT_ENV=sandbox        -> https://api.cert.tastyworks.com (separate credentials; delayed quotes)

CLI:
  python3 tastytrade_client.py equity:AAPL,TSLA index:SPX future:/ESZ6 cryptocurrency:BTC/USD \
      equity-option:SPY251031C00670000
"""
import json
import os
import re
import sys
import time
from decimal import Decimal, InvalidOperation
from pathlib import Path
from urllib.parse import quote

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
SECRET_FILES = {
    "client_id": "tastytrade-client-id",
    "client_secret": "tastytrade-client-secret",
    "refresh_token": "tastytrade-refresh-token",
}
CACHE_DIR = Path("/home/ubuntu/.openclaw/workspace/state/tastytrade_cache")
CACHE_DIR.mkdir(parents=True, exist_ok=True)
CACHE_TTL_SEC = 60

BASES = {"prod": "https://api.tastyworks.com", "sandbox": "https://api.cert.tastyworks.com"}
USER_AGENT = "mission-control/1.0"
INSTRUMENT_TYPES = ("equity", "equity-option", "index", "future", "future-option", "cryptocurrency")
MAX_SYMBOLS_PER_REQUEST = 100
BACKOFF_SEC = (1, 2, 4)          # 429 -> 1s, 2s, 4s, then give up (3 retries)
TOKEN_SKEW_SEC = 60              # refresh ~60s before the access token expires

NUMERIC_KEYS = {
    "bid", "bid-size", "ask", "ask-size", "mid", "mark", "last", "last-ext", "last-mkt",
    "beta", "dividend-amount", "dividend-frequency", "open", "day-high-price", "day-low-price",
    "close", "prev-close", "low-limit-price", "high-limit-price", "year-low-price",
    "year-high-price", "volume", "day-open", "day-high", "day-low", "day-close", "prev-day-close",
}


class TastytradeError(RuntimeError):
    pass


class TastytradeAuthError(TastytradeError):
    """Missing secrets or the token exchange was rejected."""


class TastytradeForbidden(TastytradeError):
    """403 — the account/token is not permitted (unfunded account or missing `read` scope)."""


class TastytradeBadRequest(TastytradeError):
    """400 — usually bad symbology."""


def env() -> str:
    e = (os.environ.get("TT_ENV") or "prod").strip().lower()
    if e not in BASES:
        raise TastytradeError(f"TT_ENV must be prod or sandbox, got {e!r}")
    return e


def base_url() -> str:
    return BASES[env()]


def _secret(name: str) -> str:
    p = SECRETS / SECRET_FILES[name]
    return p.read_text().strip() if p.exists() else ""


def missing_secrets() -> list:
    """Secret file names that are absent or empty (names only — values are never read out)."""
    return [f for k, f in SECRET_FILES.items() if not _secret(k)]


def assert_configured():
    """Account assertion: refuse to run without all three OAuth secrets."""
    missing = missing_secrets()
    if missing:
        raise TastytradeAuthError(
            "tastytrade OAuth secrets missing in ~/.openclaw/secrets/: " + ", ".join(missing))


# ── access token (memory only) ──────────────────────────────────────────────
_TOKEN = {"value": None, "expires_at": 0.0, "env": None}


def get_access_token(force: bool = False) -> str:
    """Return a valid access token; exchange the refresh token when missing/near expiry."""
    import requests
    e = env()
    now = time.time()
    if (not force and _TOKEN["value"] and _TOKEN["env"] == e
            and now < _TOKEN["expires_at"] - TOKEN_SKEW_SEC):
        return _TOKEN["value"]
    assert_configured()
    body = {
        "grant_type": "refresh_token",
        "refresh_token": _secret("refresh_token"),
        "client_secret": _secret("client_secret"),
        "client_id": _secret("client_id"),
    }
    r = requests.post(
        f"{BASES[e]}/oauth/token",
        headers={"User-Agent": USER_AGENT, "Content-Type": "application/json",
                 "Accept": "application/json"},
        data=json.dumps(body),
        timeout=15,
    )
    if r.status_code != 200:
        # error body carries code/message only; it never echoes the secret
        raise TastytradeAuthError(f"token refresh failed HTTP {r.status_code}: {_err_text(r)}")
    j = r.json()
    tok = j.get("access_token")
    if not tok:
        raise TastytradeAuthError("token refresh returned no access_token")
    _TOKEN.update(value=tok, env=e, expires_at=now + float(j.get("expires_in") or 900))
    return tok


def _err_text(r) -> str:
    try:
        j = r.json()
        err = j.get("error") or {}
        if isinstance(err, dict):
            parts = [err.get("code"), err.get("message")]
            parts += [x.get("message") for x in (err.get("errors") or []) if isinstance(x, dict)]
            return " | ".join(str(p) for p in parts if p) or r.text[:500]
        return str(err)[:500]
    except Exception:
        return (r.text or "")[:500]


# ── parsing ─────────────────────────────────────────────────────────────────
def _dec(v):
    if v is None:
        return None
    s = str(v).strip()
    if not s or s.lower() in ("nan", "null", "none", "-nan", "inf", "-inf", "infinity"):
        return None
    try:
        d = Decimal(s)
    except InvalidOperation:
        return None
    return d if d.is_finite() else None


def parse_item(item: dict) -> dict:
    out = {}
    for k, v in item.items():
        out[k] = _dec(v) if k in NUMERIC_KEYS else v
    halted = item.get("is-trading-halted", item.get("trading-halted"))
    out["is-trading-halted"] = bool(halted) if halted is not None else None
    return out


# ── symbology ───────────────────────────────────────────────────────────────
_OCC = re.compile(r"^([A-Z0-9.]{1,6})\s*(\d{6}[CP]\d{8})$")


def normalize_symbol(sym: str, instrument_type: str) -> str:
    s = sym.strip().upper() if instrument_type != "future-option" else sym.strip()
    if instrument_type == "equity-option":
        m = _OCC.match(s)
        if m:
            return f"{m.group(1):<6}{m.group(2)}"   # OCC root padded to 6 chars
    return s


# ── 60s per-symbol cache (raw items, parsed on read) ─────────────────────────
def _cache_file(instrument_type: str, sym: str) -> Path:
    safe = re.sub(r"[^A-Za-z0-9._-]", "_", f"{env()}_{instrument_type}_{sym}")
    return CACHE_DIR / f"{safe}.json"


def _cache_get(instrument_type: str, sym: str):
    f = _cache_file(instrument_type, sym)
    try:
        if f.exists() and time.time() - f.stat().st_mtime <= CACHE_TTL_SEC:
            return json.loads(f.read_text())
    except Exception:
        pass
    return None


def _cache_set(instrument_type: str, sym: str, item: dict):
    try:
        _cache_file(instrument_type, sym).write_text(json.dumps(item))
    except Exception:
        pass


# ── HTTP ────────────────────────────────────────────────────────────────────
def _query_string(pairs) -> str:
    # tastytrade's own example: index[]=SPX&equity[]=AAPL&future[]=%2FCLM5 (brackets literal)
    return "&".join(f"{t}[]={quote(s, safe='')}" for t, s in pairs)


def _fetch_batch(pairs) -> list:
    import requests
    url = f"{base_url()}/market-data/by-type?{_query_string(pairs)}"
    refreshed = False
    attempt = 0
    while True:
        r = requests.get(url, headers={
            "Authorization": f"Bearer {get_access_token()}",
            "User-Agent": USER_AGENT,
            "Accept": "application/json",
        }, timeout=15)
        if r.status_code == 200:
            return ((r.json().get("data") or {}).get("items")) or []
        if r.status_code == 401 and not refreshed:
            get_access_token(force=True)
            refreshed = True
            continue
        if r.status_code == 429 and attempt < len(BACKOFF_SEC):
            time.sleep(BACKOFF_SEC[attempt])
            attempt += 1
            continue
        if r.status_code == 400:
            body = _err_text(r)
            print(f"tastytrade 400 (check symbology): {body}", file=sys.stderr)
            raise TastytradeBadRequest(f"HTTP 400: {body}")
        if r.status_code == 403:
            raise TastytradeForbidden(
                "HTTP 403: account/token not permitted for market data "
                "(funded account + 'read' scope required; no delayed fallback). "
                + _err_text(r))
        if r.status_code == 401:
            raise TastytradeAuthError(f"HTTP 401 after token refresh: {_err_text(r)}")
        raise TastytradeError(f"HTTP {r.status_code}: {_err_text(r)}")


# ── market metrics: IV rank / IV percentile (R1a, Mike 2026-10-20) ────────────────────────────────────────────────
# GET /market-metrics?symbols=A,B — tastytrade's own IV index, IV rank and IV percentile per underlying. The rank and
# percentile arrive as 0-1 decimal strings and are returned on a 0-100 scale. Field names follow tastytrade's public
# API docs; they were not yet confirmed against a live authenticated response (the refresh-token exchange failed with
# "Client secret mismatch" on 2026-10-21), so a missing field is None, never a guess.
METRICS_BATCH = 50


def _pct(v):
    d = _dec(v)
    return float(d * 100) if d is not None else None


def parse_metrics(item: dict) -> dict:
    return {"symbol": item.get("symbol"),
            "iv_index": float(d) if (d := _dec(item.get("implied-volatility-index"))) is not None else None,
            "iv_rank": _pct(item.get("implied-volatility-index-rank")),
            "iv_percentile": _pct(item.get("implied-volatility-percentile")),
            "as_of": item.get("implied-volatility-updated-at"),
            "source": "tastytrade /market-metrics"}


def get_market_metrics(symbols) -> dict:
    """{SYMBOL: parse_metrics(item)} for the symbols tastytrade answered. Raises TastytradeAuthError when the
    credentials are missing or rejected (callers raise the loud not-configured alert; nothing is faked)."""
    import requests
    syms = sorted({s.strip().upper() for s in symbols if s and s.strip()})
    out: dict = {}
    for i in range(0, len(syms), METRICS_BATCH):
        url = f"{base_url()}/market-metrics?symbols={','.join(quote(s) for s in syms[i:i + METRICS_BATCH])}"
        r = requests.get(url, headers={"Authorization": f"Bearer {get_access_token()}", "User-Agent": USER_AGENT,
                                       "Accept": "application/json"}, timeout=20)
        if r.status_code == 401:
            r = requests.get(url, headers={"Authorization": f"Bearer {get_access_token(force=True)}",
                                           "User-Agent": USER_AGENT, "Accept": "application/json"}, timeout=20)
        if r.status_code in (401, 403):
            raise TastytradeAuthError(f"market-metrics HTTP {r.status_code}: {_err_text(r)}")
        if r.status_code != 200:
            raise TastytradeError(f"market-metrics HTTP {r.status_code}: {_err_text(r)}")
        for it in ((r.json().get("data") or {}).get("items")) or []:
            m = parse_metrics(it)
            if m["symbol"]:
                out[m["symbol"].upper()] = m
    return out


def get_quotes(by_type: dict) -> dict:
    """{'equity': ['AAPL'], 'index': ['SPX'], ...} -> {symbol: parsed quote dict}.

    Symbols with no quote in the response are simply absent from the result.
    """
    want = []
    for t, syms in (by_type or {}).items():
        if t not in INSTRUMENT_TYPES:
            raise TastytradeError(f"unknown instrument type {t!r}; use one of {INSTRUMENT_TYPES}")
        for s in syms or []:
            if s and s.strip():
                want.append((t, normalize_symbol(s, t)))
    want = list(dict.fromkeys(want))
    out, todo = {}, []
    for t, s in want:
        hit = _cache_get(t, s)
        if hit is not None:
            out[s] = parse_item(hit)
        else:
            todo.append((t, s))
    for i in range(0, len(todo), MAX_SYMBOLS_PER_REQUEST):
        chunk = todo[i:i + MAX_SYMBOLS_PER_REQUEST]
        types = dict((s, t) for t, s in chunk)
        for item in _fetch_batch(chunk):
            sym = item.get("symbol")
            if not sym:
                continue
            t = types.get(sym) or item.get("instrument-type") or "unknown"
            _cache_set(t, sym, item)
            out[sym] = parse_item(item)
    return out


def get_quote(symbol: str, instrument_type: str = "equity"):
    sym = normalize_symbol(symbol, instrument_type)
    return get_quotes({instrument_type: [sym]}).get(sym)


# ── CLI ─────────────────────────────────────────────────────────────────────
def _parse_args(args) -> dict:
    by_type = {}
    for a in args:
        if ":" not in a:
            raise SystemExit(f"bad arg {a!r}: use type:SYM1,SYM2 (types: {', '.join(INSTRUMENT_TYPES)})")
        t, syms = a.split(":", 1)
        by_type.setdefault(t.strip().lower(), []).extend(x for x in syms.split(",") if x.strip())
    return by_type


def _fmt(v) -> str:
    return "—" if v is None else str(v)


def main(argv=None) -> int:
    argv = sys.argv[1:] if argv is None else argv
    if not argv or argv[0] in ("-h", "--help"):
        print(__doc__)
        return 0
    by_type = _parse_args(argv)
    missing = missing_secrets()
    if missing:
        print("tastytrade: missing secret files in ~/.openclaw/secrets/: " + ", ".join(missing),
              file=sys.stderr)
        return 2
    try:
        quotes = get_quotes(by_type)
    except TastytradeError as e:
        print(f"tastytrade error ({env()}): {e}", file=sys.stderr)
        return 1
    cols = ("symbol", "bid", "ask", "mid", "last", "prev-close", "volume", "halted")
    rows = []
    for t, syms in by_type.items():
        for s in syms:
            sym = normalize_symbol(s, t)
            q = quotes.get(sym)
            if q is None:
                rows.append((sym, "NO QUOTE", "", "", "", "", "", ""))
            else:
                rows.append((sym, _fmt(q.get("bid")), _fmt(q.get("ask")), _fmt(q.get("mid")),
                             _fmt(q.get("last")), _fmt(q.get("prev-close")), _fmt(q.get("volume")),
                             _fmt(q.get("is-trading-halted"))))
    w = [max(len(str(r[i])) for r in rows + [cols]) for i in range(len(cols))]
    print(f"tastytrade {env()} · {time.strftime('%Y-%m-%d %H:%M:%S %Z')}")
    print("  ".join(c.ljust(w[i]) for i, c in enumerate(cols)))
    for r in rows:
        print("  ".join(str(c).ljust(w[i]) for i, c in enumerate(r)))
    return 0 if all(r[1] != "NO QUOTE" for r in rows) else 3


if __name__ == "__main__":
    os.environ.setdefault("TZ", "America/New_York")
    time.tzset()
    sys.exit(main())
