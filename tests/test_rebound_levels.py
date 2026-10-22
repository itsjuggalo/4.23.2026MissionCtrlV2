"""R32 (Mike 2026-10-21): the rebound Structure Trigger ping carries the levels.v1 block, never a size or a cap.
The engine is monkeypatched (offline); dry render only — nothing is sent."""
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.insert(0, ROOT)
import rebound_trigger_ping as R  # noqa: E402

BANNED = re.compile(r"\$400|risk cap|position siz|\b\d+ (shares|contracts)\b|DECISIONS R5", re.I)


def test_ping_prints_levels_per_name(monkeypatch):
    calls = []

    def lines(sym, side="long", horizon="swing", occ=None, footer=True):
        calls.append((sym, side, horizon, footer))
        return [f"Levels: Entry: 10–10.2 (Long) · TP1 11 · TP2 12 · Final TP UNAVAILABLE · SL 9.5",
                "Final TP UNAVAILABLE — no level ≥ 0.5×ATR beyond TP2 within 4×ATR of spot (the horizon cap)"]
    monkeypatch.setattr(R.LB, "lines", lines)
    rows = [{"key": "ACME|t", "symbol": "ACME", "row": {"read": "ACME held 10 & turned", "score": 72}}]
    msg = R.format_message(rows, "2026-10-22T10:00:00-04:00")
    assert "Levels: Entry: 10–10.2 (Long)" in msg and "Final TP UNAVAILABLE — no level" in msg
    assert "No size, no cap" in msg and calls == [("ACME", "long", "swing", False)]
    assert not BANNED.search(msg), msg
