"""R32 protective strip for breakout_cron's LLM enrichment: model-invented entry/stop/target numbers are removed."""
import sys, unittest
from pathlib import Path
sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "lib"))
import llm_level_strip as S  # noqa: E402


class Strip(unittest.TestCase):
    def test_removes_level_clauses_keeps_the_rest(self):
        t = ("📈 BREAKOUTS\nAAPL — long, entry 231.50, stop 224, earnings Thu\n"
             "MU — long; trigger > $125 · SL: 117.50 · target 140-145 · HBM demand\n"
             "XOM — avoid (buy above 120) oil weak\nNVDA — long, catalyst GTC 10/28")
        out, n = S.strip(t)
        self.assertEqual(n, 6)
        self.assertEqual(out.splitlines(), ["📈 BREAKOUTS", "AAPL — long, earnings Thu", "MU — long · HBM demand",
                                            "XOM — avoid oil weak", "NVDA — long, catalyst GTC 10/28"])
        for w in ("231", "224", "125", "117", "140", "120"):
            self.assertNotIn(w, out)

    def test_untouched_when_no_levels(self):
        t = "TSLA — short, 20-day low on 1.8x RVOL, deliveries miss"
        self.assertEqual(S.strip(t), (t, 0))


if __name__ == "__main__":
    unittest.main()
