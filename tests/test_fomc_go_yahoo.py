#!/usr/bin/env python3
"""fomc_go: the tape comes from Yahoo 1-min bars (no Alpaca), labelled 'not Robinhood' with its as_of. Stubbed fetch, no network."""
import sys, unittest
from datetime import datetime, timezone, timedelta
from pathlib import Path
from unittest import mock
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import fomc_go as m  # noqa: E402


def fake(move):
    now = datetime.now(timezone.utc).astimezone(m.ET).replace(hour=14, minute=0, second=0, microsecond=0)
    ts = [int((now + timedelta(minutes=i)).timestamp()) for i in range(0, 46)]
    closes = [100.0] + [100.0 * (1 + move)] * 45
    return {"chart": {"result": [{"timestamp": ts, "indicators": {"quote": [{"close": closes}]}}]}}


class Tape(unittest.TestCase):
    def test_moves_and_label(self):
        with mock.patch.object(m, "_get", lambda url: fake(-0.006)), \
                mock.patch.object(m, "datetime", wraps=datetime) as dt:
            dt.now.return_value = datetime.now(timezone.utc).astimezone(m.ET).replace(hour=14, minute=50).astimezone(timezone.utc)
            dt.fromisoformat = datetime.fromisoformat
            mv = m.moves_since_2pm()
        self.assertAlmostEqual(mv["SPY"], -0.6, places=1)
        self.assertEqual(m.classify(mv), "hawkish")

    def test_no_alpaca_and_label(self):
        src = Path(m.__file__).read_text()
        self.assertNotIn("data.alpaca.markets", src)
        self.assertNotIn("alpaca-boba", src)
        with mock.patch.object(m, "moves_since_2pm", lambda: {"SPY": 0.1}):
            m._AS_OF["SPY"] = "2026-10-22T19:00:00Z"
            msg, _ = m.build(False)
        self.assertIn("src Yahoo 1-min bars, not Robinhood, as of 15:00 ET", msg)

    def test_fetch_failure_is_a_visible_gap(self):
        with mock.patch.object(m, "_get", lambda url: None):
            self.assertEqual(m.moves_since_2pm(), {})
            m._AS_OF.clear()
            msg, verdict = m.build(False)
        self.assertEqual(verdict, "unknown")
        self.assertIn("Data gap", msg)


if __name__ == "__main__":
    unittest.main()
