#!/usr/bin/env python3
"""STAGED: entry_radar_refresh reads completed daily bars from the shared loader, never Alpaca; a loader failure degrades to Yahoo."""
import sys, unittest
from pathlib import Path
from unittest import mock
ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
# entry_radar_refresh needs missionctrl's regular `lib` package (lib.afterhours); ~/scripts/lib is a namespace package.
# Import it with the lib modules swapped out, then restore them so other test modules keep ~/scripts/lib.
_saved = {m: sys.modules.pop(m) for m in [m for m in sys.modules if m == "lib" or m.startswith("lib.")]}
try:
    import entry_radar_refresh as e  # noqa: E402
finally:
    for _m in [m for m in sys.modules if m == "lib" or m.startswith("lib.")]:
        del sys.modules[_m]
    sys.modules.update(_saved)


class NoAlpaca(unittest.TestCase):
    def test_source_has_no_alpaca_reads(self):
        src = Path(e.__file__).read_text()
        self.assertNotIn("data.alpaca.markets", src)
        self.assertNotIn("alpaca-key-id", src)

    def test_loader_failure_returns_empty_so_yahoo_fallback_runs(self):
        with mock.patch.dict(sys.modules, {"pipeline.decision.lib": None}):
            self.assertEqual(e.fetch_bars(["SPY"]), {})


if __name__ == "__main__":
    unittest.main()
