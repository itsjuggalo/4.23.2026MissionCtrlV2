#!/usr/bin/env python3
"""Alert-flood fix (Mike GO 2026-10-22, staged): FYI charts → digest bot, polymarket → digest, per-source daily cap,
flow TA run → one album, one-week replay. Hermetic: temp ledger DB, TG_DRY_RUN, no Telegram, no real ledger."""
from __future__ import annotations

import os
import sqlite3
import sys
import tempfile
import time
import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT))
sys.path.insert(0, str(ROOT / "trade_charts"))
from lib import tg_digest as D  # noqa: E402
from lib import tg_ledger as L  # noqa: E402


class FloodPolicyTest(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        self.db = Path(self.tmp.name) / "ledger.sqlite"
        self._db, D.DB = D.DB, self.db
        con = sqlite3.connect(self.db)
        con.execute(L._SCHEMA)
        con.commit(); con.close()
        self._src, L.source = L.source, lambda: "flow_winners_push.py"
        self._en = D.enabled
        D.enabled = lambda: True

    def tearDown(self):
        D.DB, L.source, D.enabled = self._db, self._src, self._en
        self.tmp.cleanup()

    def _sent(self, src, n, fn="trading_command"):
        con = sqlite3.connect(self.db)
        for _ in range(n):
            con.execute("INSERT INTO sends (ts, day, fn, source, ok) VALUES (?,?,?,?,1)",
                        (time.time(), time.strftime("%Y-%m-%d"), fn, src))
        con.commit(); con.close()

    def test_cap_counts_only_this_source_lane_and_day(self):
        self._sent("flow_winners_push.py", D.DAILY_CAP - 1)
        self._sent("flow_winners_push.py", 5, fn="trading_digest")
        self._sent("other.py", 20)
        self.assertFalse(D.over_cap("trading_command", "flow_winners_push.py"))
        self._sent("flow_winners_push.py", 1)
        self.assertTrue(D.over_cap("trading_command", "flow_winners_push.py"))
        self.assertFalse(D.over_cap("flow_signals", "flow_winners_push.py"))   # other lanes never capped

    def test_exits_and_stops_are_never_capped(self):
        self._sent("spy_scalp_monitor.py", 50)
        self.assertFalse(D.over_cap("trading_command", "spy_scalp_monitor.py"))

    def test_ledger_error_fails_open(self):
        D.DB = Path(self.tmp.name) / "missing" / "no.sqlite"
        self.assertFalse(D.over_cap("trading_command", "flow_winners_push.py"))

    def test_polymarket_is_digest_text(self):
        self.assertEqual(D.mode("polymarket_macro_odds.py", "<b>📊 Polymarket — crowd odds</b>"), "digest")
        self.assertEqual(D.mode("spy_scalp_pickpush.py", "⚡ <b>SPY 0DTE Pick</b>"), "instant")

    def test_upload_lane(self):
        L.source = lambda: "max_pain.py"
        self.assertEqual(D.upload_lane("trading_command"), D.DELIVER_FN)
        L.source = lambda: "flow_ta_cards.py"
        self.assertEqual(D.upload_lane("trading_command"), "trading_command")
        self._sent("flow_ta_cards.py", D.DAILY_CAP)
        self.assertEqual(D.upload_lane("trading_command"), D.DELIVER_FN)        # over cap
        self.assertEqual(D.upload_lane("screener"), "screener")                  # other lanes untouched
        D.enabled = lambda: False
        L.source = lambda: "max_pain.py"
        self.assertEqual(D.upload_lane("trading_command"), "trading_command")    # kill switch

    def test_over_cap_text_is_queued_not_dropped(self):
        L.source = lambda: "flow_winners_push.py"
        self._sent("flow_winners_push.py", D.DAILY_CAP)
        self.assertTrue(D.intercept("trading_command", "🔔 <b>FLOW WINNERS</b>\n▸ <b>NVDA</b> +40%", True))
        n = sqlite3.connect(self.db).execute("SELECT COUNT(*) FROM digest_queue").fetchone()[0]
        self.assertEqual(n, 1)


class AlbumTest(unittest.TestCase):
    def test_caption_fits_and_keeps_source_and_time(self):
        import deliver
        cap = ("🔴 MRNA — 12 flow hits ($64.7M), 1🟢/11🔴 · biggest: $200P 10/23 (SWEEP)\nflow: option-scraper stream, "
               "latest alert 10-22 15:52 ET · spot $202.63 src Robinhood 22:13 ET · chart: Yahoo bars (not Robinhood)")
        out = deliver.album_caption([cap] * 6)
        self.assertLessEqual(len(out), 1024)
        self.assertIn("spot $202.63 src Robinhood 22:13 ET", out)
        self.assertIn("alert 10-22 15:52 ET", out)
        self.assertTrue(out.endswith("chart: Yahoo bars (not Robinhood)"))

    def test_send_album_dry_run_is_one_message(self):
        import io
        from contextlib import redirect_stdout
        import tg_fleet
        os.environ["TG_DRY_RUN"] = "1"
        tmp = tempfile.TemporaryDirectory()
        paths = []
        for i in range(3):
            p = Path(tmp.name) / f"ta_{i}.png"; p.write_bytes(b"\x89PNG"); paths.append(str(p))
        pin, lane = tg_fleet.pinned_token, tg_fleet._upload_lane
        tg_fleet.pinned_token, tg_fleet._upload_lane = (lambda fn: "1:x"), (lambda fn, path="": fn)
        try:
            buf = io.StringIO()
            with redirect_stdout(buf):
                rc = tg_fleet.send_album("trading_command", paths, "cap")
        finally:
            tg_fleet.pinned_token, tg_fleet._upload_lane = pin, lane
            os.environ.pop("TG_DRY_RUN", None)
            tmp.cleanup()
        self.assertEqual(rc, 0)
        self.assertEqual(buf.getvalue().count("DRY trading_command"), 1)
        self.assertIn("[album 3: ta_0.png, ta_1.png, ta_2.png] cap", buf.getvalue())


class ReplayTest(unittest.TestCase):
    def test_replay_outcomes(self):
        import tg_alert_flood_sim as S
        t, d = 1_000_000.0, "2026-10-22"
        rows = [(t, d, "max_pain.py", 0, "[photo]"),
                (t + 1, d, "polymarket_macro_odds.py", 1, "<b>📊 Polymarket</b>"),
                (t + 2, d, "flow_ta_cards.py", 0, "[photo a]"), (t + 7, d, "flow_ta_cards.py", 0, "[photo b]"),
                (t + 9000, d, "flow_ta_cards.py", 0, "[photo c]")]
        rows += [(t + 10 + i, d, "flow_winners_push.py", 1, "🔔 <b>FLOW WINNERS</b>") for i in range(D.DAILY_CAP + 2)]
        out = [o for *_, o in S.replay(rows)]
        self.assertEqual(out[:5], ["digest_bot", "digest_fold", "kept", "album_merged", "kept"])
        self.assertEqual(out[5:].count("kept"), D.DAILY_CAP)
        self.assertEqual(out[5:].count("cap_fold"), 2)


if __name__ == "__main__":
    unittest.main()
