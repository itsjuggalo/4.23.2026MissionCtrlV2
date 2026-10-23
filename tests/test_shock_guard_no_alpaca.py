#!/usr/bin/env python3
"""STAGED (Alpaca bar-read migration): shock_guard reads no Alpaca (bars, news, paper positions). Yahoo query1 -> query2."""
import sys, unittest
from pathlib import Path
from unittest import mock
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import shock_guard as g  # noqa: E402


def yahoo(closes):
    ts = list(range(1_760_000_000, 1_760_000_000 + 60 * len(closes), 60))
    return {"chart": {"result": [{"timestamp": ts, "indicators": {"quote": [{"close": closes}]}}]}}


CLOSES = [100 + 0.01 * (i % 3) for i in range(38)] + [99.4, 98.8]   # a sharp last-minute drop


class NoAlpaca(unittest.TestCase):
    def test_source_has_no_alpaca_reads(self):
        src = Path(g.__file__).read_text()
        for needle in ("data.alpaca.markets", "paper-api.alpaca.markets", "alpaca-boba", "alpaca_trade", "_alpaca_spy_bars", "_alpaca_news"):
            self.assertNotIn(needle, src)

    def test_second_yahoo_host_when_first_is_empty(self):
        def fake(url, *a, **k):
            return yahoo(CLOSES) if "query2" in url else None
        with mock.patch.object(g, "_get", fake):
            r = g.check_spy_z()
        self.assertEqual(r["source"], "yahoo-q2")
        self.assertFalse(r["blind"])
        self.assertIsNotNone(r["z"])

    def test_both_hosts_empty_is_blind_not_silent(self):
        with mock.patch.object(g, "_get", lambda *a, **k: None):
            r = g.check_spy_z()
        self.assertTrue(r["blind"])
        self.assertIsNone(r["z"])

    def test_crisis_text_reads_no_account(self):
        with mock.patch.object(g, "log_event", lambda *a, **k: None):
            self.assertIn("Robinhood", g.crisis_close_l3("x"))


if __name__ == "__main__":
    unittest.main()
