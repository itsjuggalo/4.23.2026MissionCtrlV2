"""W7 MC-AUD-095: a replay drill's decision point lies inside the holding period — never after the exit."""
from real_coach import replay_drills as R


def _s(vals, entry_idx=0):
    dates = [f"2026-01-{i + 2:02d}" for i in range(len(vals))]
    return {"dates": dates, "vals": vals, "entry_idx": entry_idx}


def test_crossing_after_exit_is_not_a_decision():
    s = _s([100, 97, 95, 92, 85, 40])                     # exit on day index 2 (2026-01-04)
    assert R.first_idx_below(s, 0, -10) == 4               # unbounded: finds the post-exit crash
    assert R.first_idx_below(s, 0, -10, end_idx=2) is None
    assert R.first_idx_below(s, 0, -50, end_idx=2) is None


def test_fallback_decision_never_past_exit():
    s = _s([100, 99, 98, 97, 96, 95, 94, 93, 92, 91])
    assert R.hold_decision_idx(s, "2026-01-04", -10) == 2  # exit index 2 < entry+5
    assert R.hold_decision_idx(s, "2026-01-11", -10) == 5
    assert R.hold_decision_idx(s, "2026-01-11", -5) == 5   # 95 at index 5 is the first close ≤ −5 %
