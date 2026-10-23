#!/usr/bin/env python3
"""Staged (2026-10-22): flow_chase, breakout_scanner and pre_breakout_scan have no Alpaca read; daily bars come from the
shared loader adapter; flow_chase with no Robinhood quote returns the NO LIVE QUOTE shape. No network."""
import sys, unittest
from pathlib import Path
from unittest import mock
ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
for _m in [m for m in sys.modules if m == "lib" or m.startswith("lib.")]:   # another test's `lib` (pipeline) can shadow ~/scripts/lib
    if str(ROOT / "lib") not in [str(x) for x in getattr(sys.modules[_m], "__path__", [str(ROOT / "lib")])]:
        del sys.modules[_m]
from lib import daily_bars  # noqa: E402
import flow_chase as fc  # noqa: E402


class NoAlpaca(unittest.TestCase):
    def test_sources(self):
        for f in ("flow_chase.py", "breakout_scanner.py", "pre_breakout_scan.py", "lib/daily_bars.py"):
            src = (ROOT / f).read_text()
            self.assertNotIn("alpaca.markets", src, f)
            self.assertNotIn("APCA-API", src, f)


class Adapter(unittest.TestCase):
    def test_shape_and_drop(self):
        import pandas as pd
        df = pd.DataFrame({"t": pd.to_datetime(["2026-10-21", "2026-10-22"]).tz_localize("America/New_York"),
                           "o": [1, 2], "h": [2, 3], "l": [0.5, 1], "c": [1.5, 2.5], "v": [10, 20]})

        def get(sym, tf, lookback_period=None):
            if sym == "BAD":
                raise RuntimeError("no bars")
            return mock.Mock(df=df, source="stub")
        out, src = daily_bars.fetch_daily(["AAA", "BAD", "BRK.B"], 380, _get=get)
        self.assertEqual(sorted(out), ["AAA", "BRK.B"])
        self.assertEqual(set(out["AAA"][0]), {"t", "o", "h", "l", "c", "v"})
        self.assertTrue(out["AAA"][-1]["t"].endswith("Z"))
        self.assertEqual(src["AAA"], "stub")


class Chase(unittest.TestCase):
    def test_no_rh_quote_is_no_live_quote(self):
        with mock.patch.object(fc, "option_mid", return_value=(None, {"ok": False}, None, {"rh_reason": "x"})):
            s = fc.option_snapshot("SPY261120C00600000")
        self.assertIsNone(s["mid"])
        self.assertIsNone(s["src"])


if __name__ == "__main__":
    unittest.main()
