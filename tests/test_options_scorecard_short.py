#!/usr/bin/env python3
"""options_position_scorecard (TG audit 10-08): one short message, fresh unexpired quotes only. Pure render, no I/O."""
from __future__ import annotations

import sys
import unittest
from datetime import datetime, date
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import options_position_scorecard as m  # noqa: E402

NOW = datetime(2026, 10, 8, 15, 40, tzinfo=m.ET)


def card(sym, age_min, vol=100, exp=date(2026, 11, 20), valid=True, cap="auto"):
    cap_ms = (NOW.timestamp() - age_min * 60) * 1000 if cap == "auto" else cap
    pos = {"root": sym, "strike": 100.0, "kind": "put", "exp": exp, "_side_known": True, "_quote_valid": valid,
           "_captured_ms": cap_ms, "_volume": vol, "_oi": 5}
    return {"pos": pos, "spot": 101.2, "mark": 1.58, "be": 98.42, "pop": 0.31}


class Short(unittest.TestCase):
    def test_top5_fresh_unexpired_under_1200(self):
        cards = [card(f"S{i}", 3, vol=i) for i in range(12)]
        msg = m.fmt_short(cards, NOW, 40)
        self.assertLess(len(msg), 1200)
        self.assertEqual(msg.count("mid $"), 5)
        self.assertIn("S11", msg)
        self.assertIn("not your positions", msg)
        self.assertIn("quote 3:37 PM ET", msg)
        self.assertEqual(msg.count("Model-only"), 1)

    def test_drops_stale_unknown_expired_invalid(self):
        cards = [card("OLD", 20), card("UNK", 1, cap=None), card("EXP", 1, exp=date(2026, 10, 7)),
                 card("BAD", 1, valid=False), card("OK", 14)]
        msg = m.fmt_short(cards, NOW, 5)
        self.assertIn("OK", msg)
        for s in ("OLD", "UNK", "EXP", "BAD"):
            self.assertNotIn(s, msg)

    def test_nothing_fresh_means_no_message(self):
        self.assertIsNone(m.fmt_short([card("OLD", 400)], NOW, 1))

    def test_dry_run_never_sends(self):
        src = Path(m.__file__).read_text()
        self.assertLess(src.index("if DRY:"), src.index('_tg("sendMessage"'))
        self.assertLess(src.index("if DRY:"), src.index("write_text"))


if __name__ == "__main__":
    unittest.main()
