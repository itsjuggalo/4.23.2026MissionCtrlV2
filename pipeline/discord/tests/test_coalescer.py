from pipeline.discord.coalescer import Coalescer


def _clock(start: float = 1_000_000.0):
    t = [start]

    def now():
        return t[0]

    def advance(seconds: float):
        t[0] += seconds

    return now, advance


def test_first_hit_marks_is_first():
    now, _ = _clock()
    c = Coalescer(window_seconds=600, now_fn=now)
    r = c.observe("TSLA", 480.0, "C", 1_700_000_000, 50_000.0)
    assert r.is_first is True
    assert r.hits == 1
    assert r.cumulative_premium == 50_000.0


def test_repeated_hits_within_window_accumulate():
    now, advance = _clock()
    c = Coalescer(window_seconds=600, now_fn=now)
    c.observe("TSLA", 480.0, "C", 1_700_000_000, 50_000.0)
    advance(60)
    c.observe("TSLA", 480.0, "C", 1_700_000_000, 30_000.0)
    advance(60)
    r = c.observe("TSLA", 480.0, "C", 1_700_000_000, 20_000.0)
    assert r.is_first is False
    assert r.hits == 3
    assert r.cumulative_premium == 100_000.0


def test_hits_outside_window_drop():
    now, advance = _clock()
    c = Coalescer(window_seconds=600, now_fn=now)
    c.observe("TSLA", 480.0, "C", 1_700_000_000, 50_000.0)
    advance(601)
    r = c.observe("TSLA", 480.0, "C", 1_700_000_000, 10_000.0)
    assert r.is_first is True
    assert r.hits == 1
    assert r.cumulative_premium == 10_000.0


def test_different_strikes_are_independent_keys():
    now, _ = _clock()
    c = Coalescer(window_seconds=600, now_fn=now)
    a = c.observe("TSLA", 480.0, "C", 1_700_000_000, 50_000.0)
    b = c.observe("TSLA", 485.0, "C", 1_700_000_000, 20_000.0)
    assert a.is_first and b.is_first
    assert a.hits == 1 and b.hits == 1


def test_sweep_drops_expired_keys():
    now, advance = _clock()
    c = Coalescer(window_seconds=600, now_fn=now)
    c.observe("TSLA", 480.0, "C", 1_700_000_000, 50_000.0)
    c.observe("NVDA", 145.0, "P", 1_700_000_000, 20_000.0)
    advance(601)
    remaining = c.sweep()
    assert remaining == 0
