"""lib/http_retry.py — one hardened HTTP path for the trading daemons.

Every daemon hand-rolls the same `urllib.request.urlopen(Request(url, headers), timeout)`
try/except that returns None on any failure. That silently drops transient 429s / read
timeouts / connection resets (see profit_lock_jazzy's cycle_errors), and there is no shared
place to add backoff. This module centralises it.

CONTRACT (non-negotiable):
  * Retries ONLY idempotent verbs: GET, DELETE, HEAD. Exponential backoff + jitter, honouring
    a server `Retry-After` header. Retryable conditions: 429, 500, 502, 503, 504, DNS failure
    (URLError), socket/read timeout, connection reset.
  * POST / PUT / PATCH are NEVER auto-retried — a retried order submit could double-fill.
    Passing retries>0 with a non-idempotent method raises ValueError (loud misuse guard), so no
    caller can accidentally arm a retrying order path. Use `post_once()` for order submits.
  * Returns a structured `HttpResult` so callers stop hand-parsing; `get_json()` is a drop-in
    for the old `_get` (parsed body or None).

Stdlib only (urllib) — importable from anywhere after `sys.path` includes ~/scripts:
    from lib.http_retry import get_json, request, post_once, HttpResult
"""
from __future__ import annotations

import json
import random
import socket
import time
import urllib.error
import urllib.request
from dataclasses import dataclass, field
from email.utils import parsedate_to_datetime

# Never sleep longer than this on a single retry, even if the server asks for more via
# Retry-After — a cron poller that blocks for minutes has already missed its window.
RETRY_AFTER_CAP = 30.0

RETRYABLE_STATUS = {429, 500, 502, 503, 504}
IDEMPOTENT = {"GET", "DELETE", "HEAD", "OPTIONS"}

# Categories a caller may branch on without string-matching exceptions.
CAT_OK = "ok"
CAT_HTTP = "http_error"        # got an HTTP status >= 400
CAT_RATELIMIT = "rate_limit"   # 429 specifically (after retries exhausted)
CAT_TIMEOUT = "timeout"        # socket/read timeout
CAT_NETWORK = "network"        # DNS / connection reset / URLError
CAT_BADRESP = "bad_response"   # 2xx but body wasn't the expected JSON


@dataclass
class HttpResult:
    ok: bool
    status: int | None = None
    category: str = CAT_OK
    json: object = None
    body: str = ""
    error: str = ""
    attempts: int = 1
    headers: dict = field(default_factory=dict)

    def __bool__(self) -> bool:  # `if result:` == success
        return self.ok


def _sleep_for(attempt: int, base: float, cap: float, jitter: bool,
               retry_after: float | None) -> float:
    delay = min(cap, base * (2 ** attempt))
    if jitter:
        delay += random.random() * base
    if retry_after is not None:
        # Honor the server hint, but never block past RETRY_AFTER_CAP (contract: cap respected).
        delay = min(max(delay, retry_after), RETRY_AFTER_CAP)
    return delay


def _retry_after(headers) -> float | None:
    """Parse a Retry-After header (RFC 7231: delta-seconds OR an HTTP-date)."""
    if not headers:
        return None
    raw = headers.get("Retry-After")
    if raw is None:
        return None
    try:
        return max(0.0, float(raw))
    except (TypeError, ValueError):
        pass
    try:  # HTTP-date form, e.g. "Wed, 01 Jul 2026 18:30:00 GMT"
        import datetime as _dt
        dt = parsedate_to_datetime(raw)
        if dt is not None:
            if dt.tzinfo is None:
                dt = dt.replace(tzinfo=_dt.timezone.utc)
            return max(0.0, (dt - _dt.datetime.now(_dt.timezone.utc)).total_seconds())
    except (TypeError, ValueError):
        pass
    return None


def request(url: str, *, method: str = "GET", headers: dict | None = None,
            data: bytes | None = None, timeout: float = 15.0,
            retries: int = 3, backoff_base: float = 0.5, backoff_cap: float = 8.0,
            jitter: bool = True, parse_json: bool = True,
            sleep=time.sleep) -> HttpResult:
    """Perform an HTTP request with retry/backoff for idempotent verbs only.

    Raises ValueError if a non-idempotent method is given retries>0 (double-submit guard).
    Never raises on network/HTTP failure — always returns an HttpResult.
    """
    method = method.upper()
    if method not in IDEMPOTENT and retries != 0:
        raise ValueError(
            f"{method} is not idempotent — refusing to auto-retry (would risk a "
            f"double submit). Call with retries=0 or use post_once().")

    max_attempts = retries + 1
    last = HttpResult(ok=False, category=CAT_NETWORK, error="no attempt made")

    for attempt in range(max_attempts):
        try:
            req = urllib.request.Request(url, data=data, headers=headers or {}, method=method)
            with urllib.request.urlopen(req, timeout=timeout) as r:
                raw = r.read()
                body = raw.decode("utf-8", "replace")
                parsed = None
                cat = CAT_OK
                if parse_json and body:
                    try:
                        parsed = json.loads(body)
                    except json.JSONDecodeError:
                        cat = CAT_BADRESP
                return HttpResult(ok=(cat == CAT_OK), status=getattr(r, "status", 200),
                                  category=cat, json=parsed, body=body,
                                  attempts=attempt + 1, headers=dict(r.headers or {}))
        except urllib.error.HTTPError as e:
            body = ""
            try:
                body = e.read(1000).decode("utf-8", "replace")
            except Exception:  # noqa: BLE001
                pass
            cat = CAT_RATELIMIT if e.code == 429 else CAT_HTTP
            last = HttpResult(ok=False, status=e.code, category=cat, body=body,
                              error=f"HTTP {e.code} {e.reason}", attempts=attempt + 1,
                              headers=dict(getattr(e, "headers", {}) or {}))
            if e.code in RETRYABLE_STATUS and attempt < max_attempts - 1:
                sleep(_sleep_for(attempt, backoff_base, backoff_cap, jitter,
                                 _retry_after(getattr(e, "headers", None))))
                continue
            return last
        except (socket.timeout, TimeoutError) as e:
            last = HttpResult(ok=False, category=CAT_TIMEOUT, error=str(e) or "timeout",
                              attempts=attempt + 1)
            if attempt < max_attempts - 1:
                sleep(_sleep_for(attempt, backoff_base, backoff_cap, jitter, None))
                continue
            return last
        except urllib.error.URLError as e:
            # DNS failure, connection refused/reset surface here.
            last = HttpResult(ok=False, category=CAT_NETWORK, error=str(e.reason),
                              attempts=attempt + 1)
            if attempt < max_attempts - 1:
                sleep(_sleep_for(attempt, backoff_base, backoff_cap, jitter, None))
                continue
            return last
        except (ConnectionError, OSError) as e:
            last = HttpResult(ok=False, category=CAT_NETWORK, error=str(e),
                              attempts=attempt + 1)
            if attempt < max_attempts - 1:
                sleep(_sleep_for(attempt, backoff_base, backoff_cap, jitter, None))
                continue
            return last
    return last


def get_json(url: str, headers: dict | None = None, timeout: float = 15.0,
             retries: int = 3, **kw):
    """Drop-in for the old hand-rolled `_get`: parsed JSON body, or None on any failure.

    Retries transient GET failures (429/5xx/DNS/timeout) with backoff first.
    """
    res = request(url, method="GET", headers=headers, timeout=timeout, retries=retries, **kw)
    return res.json if res.ok else None


def delete(url: str, headers: dict | None = None, timeout: float = 15.0,
           retries: int = 3, **kw) -> HttpResult:
    """DELETE with retry (idempotent — cancelling an already-cancelled order is a no-op)."""
    return request(url, method="DELETE", headers=headers, timeout=timeout,
                   retries=retries, **kw)


def post_once(url: str, data: bytes | None = None, headers: dict | None = None,
              timeout: float = 15.0, **kw) -> HttpResult:
    """POST with NO retry — the only safe way to submit an order. One attempt, structured result."""
    return request(url, method="POST", data=data, headers=headers, timeout=timeout,
                   retries=0, **kw)


def requests_session(total: int = 3, backoff: float = 0.5,
                     status_forcelist=(429, 500, 502, 503, 504)):
    """A `requests.Session` with a urllib3 Retry adapter for the daemons that use `requests`.

    Retries ONLY idempotent verbs (GET/DELETE/HEAD/OPTIONS/PUT-is-excluded) — POST is NOT in
    `allowed_methods`, so an order submit through `session.post(...)` is never auto-retried
    (same double-submit guarantee as post_once). Returns requests.Response objects unchanged,
    so callers keep using `.json()` / `.status_code` — a drop-in for the `requests` module.
    """
    import requests
    from requests.adapters import HTTPAdapter
    try:
        from urllib3.util.retry import Retry
    except ImportError:  # very old urllib3
        from requests.packages.urllib3.util.retry import Retry
    retry = Retry(
        total=total, connect=total, read=total, status=total,
        backoff_factor=backoff, status_forcelist=status_forcelist,
        allowed_methods=frozenset({"GET", "DELETE", "HEAD", "OPTIONS"}),  # POST deliberately absent
        raise_on_status=False, respect_retry_after_header=True,
    )
    s = requests.Session()
    adapter = HTTPAdapter(max_retries=retry)
    s.mount("https://", adapter)
    s.mount("http://", adapter)
    return s
