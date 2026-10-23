#!/usr/bin/env python3
"""Display scripts migrated off Alpaca (2026-10-22): no Alpaca host in source; news normalises Finnhub items; quiz mark
comes from price_guard.option_quotes (Robinhood) and is None when Robinhood cannot price it. No network."""
import sys, unittest
from pathlib import Path
from unittest import mock
ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
import news_to_discord as n  # noqa: E402
import options_live_quiz as q  # noqa: E402

FILES = ["news_to_discord.py", "lib/news.py", "options_live_quiz.py", "options_position_scorecard.py"]


class NoAlpaca(unittest.TestCase):
    def test_source_has_no_alpaca_host_or_keys(self):
        for f in FILES:
            src = (ROOT / f).read_text()
            self.assertNotIn("alpaca.markets", src, f)
            self.assertNotIn("APCA-API", src, f)


class News(unittest.TestCase):
    def test_company_news_shape_and_et_stamp(self):
        item = {"id": 7, "headline": "NVDA beats", "source": "Reuters", "url": "https://x/y", "datetime": 1_790_000_000}
        with mock.patch.object(n, "_fh_get", return_value=[item]):
            out = n.fetch_news(["NVDA"])
        self.assertEqual(out[0]["id"], "fh:7")
        self.assertEqual(out[0]["symbols"], ["NVDA"])
        self.assertIn("NVDA", n.fmt(out[0], True))

    def test_general_news_uses_related_tickers(self):
        item = {"id": 1, "headline": "h", "source": "s", "url": "u", "datetime": 1_790_000_000, "related": "AAPL,MSFT"}
        with mock.patch.object(n, "_fh_get", return_value=[item]):
            self.assertEqual(n.fetch_news()[0]["symbols"], ["AAPL", "MSFT"])

    def test_no_key_returns_empty(self):
        with mock.patch.object(n, "_finnhub_key", return_value=""):
            self.assertEqual(n._fh_get("news", category="general"), [])


class QuizMark(unittest.TestCase):
    def test_rh_mid_used(self):
        with mock.patch.object(q.price_guard, "option_quotes", return_value={"O": {"ok": True, "mid": 1.25}}):
            self.assertEqual(q._option_mark("O"), 1.25)

    def test_unpriced_or_stale_is_none(self):
        for res in ({"O": {"ok": False, "mid": None}}, {}):
            with mock.patch.object(q.price_guard, "option_quotes", return_value=res):
                self.assertIsNone(q._option_mark("O"))


class QuizTelegram(unittest.TestCase):
    def test_routed_through_fleet_dry_run(self):
        import os, io, contextlib
        self.assertNotIn("api.telegram.org", (ROOT / "options_live_quiz.py").read_text())
        with mock.patch.dict(os.environ, {"TG_DRY_RUN": "1"}), contextlib.redirect_stdout(io.StringIO()) as out:
            r = q._tg("sendMessage", chat_id="1", text="Q?", parse_mode="HTML",
                      reply_markup={"inline_keyboard": [[{"text": "A", "callback_data": "a"}]]})
        self.assertTrue(r and r.get("ok"))

    def test_failure_returns_none(self):
        import tg_fleet
        with mock.patch.object(tg_fleet, "call", return_value={"ok": False, "description": "x"}):
            self.assertIsNone(q._tg("sendMessage", chat_id="1", text="t"))


if __name__ == "__main__":
    unittest.main()
