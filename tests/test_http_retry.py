"""Unit tests for lib/http_retry.py — the shared daemon HTTP path.

These pin the safety invariants a refactor must never break:
  1. Non-idempotent verbs with retries>0 raise ValueError (double-submit guard).
  2. post_once() performs exactly ONE attempt, even on 429/5xx.
  3. 429 GETs retry with backoff, then surface CAT_RATELIMIT after exhaustion.
  4. Retry-After is honored but capped at RETRY_AFTER_CAP.
  5. requests_session() never auto-retries POST (allowed_methods excludes it).

No network: urlopen is monkeypatched, sleeps are captured via the injectable
`sleep=` hook.

Run: cd ~/scripts && python3 -m pytest tests/test_http_retry.py -q
"""
from __future__ import annotations

import io
import os
import sys
import urllib.error

import pytest

sys.path.insert(0, os.path.expanduser("~/scripts"))
from lib import http_retry  # noqa: E402
from lib.http_retry import (  # noqa: E402
    CAT_NETWORK,
    CAT_OK,
    CAT_RATELIMIT,
    RETRY_AFTER_CAP,
    post_once,
    request,
)


class _FakeResp:
    """Minimal context-manager stand-in for urlopen's response."""

    def __init__(self, body: bytes = b"{}", status: int = 200, headers=None):
        self._body = body
        self.status = status
        self.headers = headers or {}

    def read(self):
        return self._body

    def __enter__(self):
        return self

    def __exit__(self, *exc):
        return False


def _http_error(code: int, headers=None):
    return urllib.error.HTTPError(
        url="https://paper-api.test/v2/orders", code=code, msg="err",
        hdrs=headers or {}, fp=io.BytesIO(b"rate limited"))


def test_post_with_retries_raises_valueerror():
    for method in ("POST", "PUT", "PATCH"):
        with pytest.raises(ValueError):
            request("https://x.test", method=method, retries=3)


def test_post_once_single_attempt_on_429(monkeypatch):
    calls = []

    def fake_urlopen(req, timeout=0):
        calls.append(req)
        raise _http_error(429)

    monkeypatch.setattr(http_retry.urllib.request, "urlopen", fake_urlopen)
    res = post_once("https://paper-api.test/v2/orders", data=b"{}")
    assert len(calls) == 1, "order submit must never be retried"
    assert not res.ok and res.status == 429 and res.category == CAT_RATELIMIT
    assert res.attempts == 1


def test_get_429_retries_then_ratelimit(monkeypatch):
    calls, sleeps = [], []

    def fake_urlopen(req, timeout=0):
        calls.append(req)
        raise _http_error(429)

    monkeypatch.setattr(http_retry.urllib.request, "urlopen", fake_urlopen)
    res = request("https://data.test/q", retries=3, jitter=False,
                  sleep=sleeps.append)
    assert len(calls) == 4  # 1 initial + 3 retries
    assert len(sleeps) == 3 and all(s > 0 for s in sleeps)
    assert not res.ok and res.category == CAT_RATELIMIT and res.attempts == 4


def test_get_recovers_after_transient_failure(monkeypatch):
    attempts = {"n": 0}

    def fake_urlopen(req, timeout=0):
        attempts["n"] += 1
        if attempts["n"] < 3:
            raise _http_error(503)
        return _FakeResp(b'{"ok": true}')

    monkeypatch.setattr(http_retry.urllib.request, "urlopen", fake_urlopen)
    res = request("https://data.test/q", retries=3, jitter=False,
                  sleep=lambda _s: None)
    assert res.ok and res.category == CAT_OK and res.json == {"ok": True}
    assert res.attempts == 3


def test_retry_after_capped(monkeypatch):
    sleeps = []

    def fake_urlopen(req, timeout=0):
        raise _http_error(429, headers={"Retry-After": "600"})

    monkeypatch.setattr(http_retry.urllib.request, "urlopen", fake_urlopen)
    request("https://data.test/q", retries=2, jitter=False, sleep=sleeps.append)
    assert sleeps and all(s <= RETRY_AFTER_CAP for s in sleeps), \
        f"Retry-After must be capped at {RETRY_AFTER_CAP}s, slept {sleeps}"


def test_non_retryable_http_returns_immediately(monkeypatch):
    calls = []

    def fake_urlopen(req, timeout=0):
        calls.append(req)
        raise _http_error(403)

    monkeypatch.setattr(http_retry.urllib.request, "urlopen", fake_urlopen)
    res = request("https://data.test/q", retries=3, sleep=lambda _s: None)
    assert len(calls) == 1 and res.status == 403 and res.attempts == 1


def test_network_error_retries(monkeypatch):
    calls = []

    def fake_urlopen(req, timeout=0):
        calls.append(req)
        raise urllib.error.URLError("dns fail")

    monkeypatch.setattr(http_retry.urllib.request, "urlopen", fake_urlopen)
    res = request("https://data.test/q", retries=2, jitter=False,
                  sleep=lambda _s: None)
    assert len(calls) == 3
    assert not res.ok and res.category == CAT_NETWORK


def test_requests_session_excludes_post():
    pytest.importorskip("requests")
    s = http_retry.requests_session()
    retry = s.get_adapter("https://x.test").max_retries
    allowed = {m.upper() for m in retry.allowed_methods}
    assert "POST" not in allowed and "PUT" not in allowed and "PATCH" not in allowed
    assert {"GET", "DELETE"} <= allowed
