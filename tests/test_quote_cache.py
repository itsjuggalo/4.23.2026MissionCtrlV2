"""Tests for lib.quote_cache — TTL semantics, freshness, isolation, robustness."""
import os
import sys
import time

import pytest

sys.path.insert(0, os.path.expanduser("~/scripts"))
from lib.quote_cache import QuoteCache  # noqa: E402


@pytest.fixture()
def cache(tmp_path):
    return QuoteCache("test_quotes", ttl=10, cache_dir=tmp_path)


def test_put_then_get_within_ttl(cache):
    cache.put({"NVDA260618C00220000": 12.5})
    assert cache.get("NVDA260618C00220000") == 12.5


def test_get_missing_returns_none(cache):
    assert cache.get("NOPE") is None


def test_expired_entry_is_none(cache):
    now = 1000.0
    cache.put({"AMD": 3.3}, now=now)
    # Same instant: fresh. Past TTL: gone.
    assert cache.get("AMD", now=now + 5) == 3.3
    assert cache.get("AMD", now=now + 11) is None


def test_get_fresh_only_returns_unexpired(cache):
    now = 500.0
    cache.put({"A": 1.0}, now=now)
    cache.put({"B": 2.0}, now=now + 8)  # newer
    fresh = cache.get_fresh(["A", "B", "C"], now=now + 9)
    # A is 9s old (< ttl 10) fresh; B is 1s old fresh; C absent.
    assert fresh == {"A": 1.0, "B": 2.0}
    later = cache.get_fresh(["A", "B"], now=now + 12)
    # A now 12s old (expired), B 4s old (fresh).
    assert later == {"B": 2.0}


def test_put_empty_is_noop(cache):
    cache.put({})
    assert cache.get_fresh(["x"]) == {}


def test_set_single(cache):
    cache.set("SPY", 4.2)
    assert cache.get("SPY") == 4.2


def test_corrupt_file_degrades_to_empty(cache):
    with open(cache.path, "w", encoding="utf-8") as fh:
        fh.write("{not json")
    assert cache.get("anything") is None
    # And a subsequent put still works (overwrites the garbage).
    cache.put({"ok": 1.0})
    assert cache.get("ok") == 1.0


def test_ttl_must_be_positive(tmp_path):
    with pytest.raises(ValueError):
        QuoteCache("bad", ttl=0, cache_dir=tmp_path)


def test_prune_drops_ancient_entries(cache):
    now = 0.0
    cache.put({"old": 1.0}, now=now)
    # A much later put should prune the ancient 'old' entry (> ttl*3).
    cache.put({"new": 2.0}, now=now + 100)
    raw = cache._load()
    assert "new" in raw and "old" not in raw


def test_separate_names_isolated(tmp_path):
    a = QuoteCache("poller_a", ttl=10, cache_dir=tmp_path)
    b = QuoteCache("poller_b", ttl=10, cache_dir=tmp_path)
    a.put({"X": 9.9})
    assert a.get("X") == 9.9
    assert b.get("X") is None


def test_clear_removes_backing_file(cache):
    cache.put({"X": 1.0})
    cache.clear()
    assert cache.get("X") is None


if __name__ == "__main__":
    raise SystemExit(pytest.main([__file__, "-v"]))
