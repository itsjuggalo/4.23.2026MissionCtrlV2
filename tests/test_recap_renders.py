#!/usr/bin/env python3
"""2026-10-07 audit: signal_outcomes + eod_scorecard recap renders (pure text builders, no network,
no sends). Fixtures are real 10-06 rows (ledger ids 2449 / 2438)."""
from __future__ import annotations

import sys
import unittest
from datetime import datetime
from pathlib import Path

sys.path.insert(0, "/AIWorkWSL/trading/analysis")
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import signal_outcomes as so  # noqa: E402
import eod_scorecard as eod  # noqa: E402

# (sent_ts, source, symbol, direction, grade, r15, r60, reod, mfe, mae, stop_hit, t1_hit, t2_hit, earnings_days, graded, entered)
R = lambda hhmm, src, sym, reod, **k: (f"2026-10-06T{hhmm}:00-04:00", src, sym, k.get("d", "LONG"), k.get("g", "WATCH"),
                                       0.1, 0.2, reod, k.get("mfe", 1.0), k.get("mae", -1.0), k.get("sh"), k.get("t1"), None,
                                       k.get("ed"), k.get("ok", 1), k.get("ent", 1))


class SignalOutcomesRender(unittest.TestCase):
    def rows(self):
        rs = [R("08:20", "rocket_watch", "MI", -64.5, ent=0), R("08:20", "rocket_watch", "XNDU", 3.5),
              R("08:20", "setup_scanner", "CEG", 2.8, g="SETUP", t1=1), R("09:16", "ma_radar", "JAGX", -12.8),
              R("09:50", "rocket_watch", "IPDN", -21.4, sh=1), R("10:37", "desk2-nollm", "MU", -1.5)]
        rs += [R(f"13:0{i}", "fvg_scan", f"S{i}", 0.0) for i in range(8)]
        rs += [R("11:50", "setup_scanner", "PSKY", None, ok=0, g="SETUP"), R("17:46", "ma_radar", "CLAR", None, ok=0)]
        return rs

    def test_bottom_line_first_and_basis_stated(self):
        m = so.build_report("2026-10-06", self.rows())
        lines = m.split("\n")
        self.assertTrue(lines[2].startswith("📊 Bottom line"))          # takeaway before any alert line
        self.assertLess(m.index("Bottom line"), m.index("• "))
        self.assertIn("SINCE ALERT", lines[1])
        self.assertIn("not option P&L", lines[1])

    def test_never_triggered_excluded_from_wins_and_avg(self):
        m = so.build_report("2026-10-06", self.rows())
        self.assertIn("of 13 alerts finished green", m)                  # 14 graded - MI (never triggered)
        self.assertIn("1 plan(s) never triggered — no trade, not counted in wins/avg: MI", m)
        self.assertNotIn("MI (pre-market gap runners)", m)               # no ✅/❌ line for it

    def test_top_n_and_more_pointer(self):
        m = so.build_report("2026-10-06", self.rows())
        self.assertIn("Best 5:", m)
        self.assertIn("Worst 5:", m)
        self.assertIn("+3 more graded", m)
        self.assertLess(len([ln for ln in m.split("\n") if ln.startswith("• ")]), 12)
        full = so.build_report("2026-10-06", self.rows(), full=True)
        self.assertEqual(len([ln for ln in full.split("\n") if ln.startswith("• ")]), 13)

    def test_friendly_lane_names_no_raw_keys(self):
        m = so.build_report("2026-10-06", self.rows())
        for raw in ("desk2-nollm", "rocket_watch", "ma_radar", "fvg_scan"):
            self.assertNotIn(raw, m)
        for src in ("desk2-nollm", "rocket_watch", "ma_radar", "fvg_scan", "fund_momo", "runner_radar", "hzo_footprint"):
            self.assertIn(src, so.SRC)

    def test_ungraded_has_reason(self):
        m = so.build_report("2026-10-06", self.rows())
        self.assertNotIn("grading tonight/tomorrow", m)
        self.assertIn("1 not graded yet — no price bars at grading time", m)
        self.assertIn("1 after-hours alert(s) — graded next session, not in today's totals: CLAR", m)

    def test_short_shows_real_stock_move_and_honest_target_flag(self):
        # SOS 10-08: short, stock ROSE 3.4% (0.2876->0.2974); best excursion +0.0%
        sos = ("2026-10-08T10:05:24-04:00", "fvg_scan", "SOS", "SHORT", "WATCH", -0.3, -4.3, -3.41, 0.0, -4.31,
               0, 1, None, None, 1, 1, 0.2876, 0.29, None)
        line = so._alert_line(sos)
        self.assertIn("stock +3.4% since alert", line)
        self.assertIn("(short: unfavorable)", line)
        self.assertNotIn("touched first target", line)
        ok = ("2026-10-08T08:20:17-04:00", "setup_scanner", "ACN", "LONG", "SETUP", -1.0, 1.0, 4.75, 5.06, -2.9,
              0, 1, None, None, 1, 1, 199.0, 205.0, None)
        self.assertIn("touched first target", so._alert_line(ok))

    def test_never_triggered_count_equals_names_listed(self):
        rs = [R("08:20", "rocket_watch", "AAA", 0.0, ent=0), R("09:20", "rocket_watch", "AAA", 0.0, ent=0),
              R("08:21", "rocket_watch", "BBB", 0.0, ent=0)]
        m = so.build_report("2026-10-08", rs)
        self.assertIn("2 plan(s) never triggered — no trade, not counted in wins/avg: AAA, BBB", m)

    def test_nothing_graded(self):
        m = so.build_report("2026-10-06", [R("08:20", "ma_radar", "X", None, ok=0)])
        self.assertIn("nothing graded yet (1 waiting)", m)


class EodRender(unittest.TestCase):
    NOW = datetime(2026, 10, 6, 16, 35, tzinfo=eod.ET)

    def msg(self, scan=None):
        flow = [({"symbol": "SPY", "strike": 790.0, "type": "C"}, (0.0, 0.0, 779.04, 779.14)),
                ({"symbol": "MU", "strike": 1050.0, "type": "P"}, (-1.5, 1.5, 1061.56, 1045.56)),
                ({"symbol": "ZZZ", "strike": 5.0, "type": "C"}, None)]
        scan = scan or [({"symbol": "OPCH", "direction": "LONG", "triggered": True}, (32.5, 32.5, 23.40, 31.01)),
                        ({"symbol": "UBER", "direction": "LONG", "triggered": False}, (-0.6, -0.6, 69.50, 69.08)),
                        ({"symbol": "NBIS", "direction": "LONG", "triggered": True}, (-1.9, -1.9, 254.74, 249.78)),
                        ({"symbol": "QQ", "direction": "LONG", "triggered": None}, None)]
        reb = [({"symbol": "DIA", "option": "534C Nov 20 ~$347"}, (1.3, 1.3, 507.84, 514.54)),
               ({"symbol": "HYG", "option": "76P Nov 20 ~$27"}, (2.2, -2.2, 75.63, 77.28))]
        return eod._build_tg_msg(flow, scan, reb, "", now=self.NOW)

    def test_takeaway_on_second_line(self):
        m = self.msg().split("\n")
        self.assertTrue(m[1].startswith("Takeaway:"))
        self.assertIn("setups 1/2 working (1 never triggered)", m[1])

    def test_underlying_move_not_beside_strike_pair(self):
        m = self.msg()
        self.assertIn("<b>SPY</b> · stock 779.04→779.14 · +0.0% · pick $790C", m)
        self.assertNotIn("$790C</b> · 779.04", m)

    def test_never_triggered_no_glyph_and_excluded(self):
        m = self.msg()
        self.assertIn("⏸ <b>UBER LONG</b> · plan never triggered — no trade", m)
        self.assertIn("SETUP/EXPLOSION ALERTS · 1/2 WORKING", m)

    def test_structure_graded_on_favorable_direction(self):
        m = self.msg()
        self.assertIn("✅ <b>DIA</b>", m)
        self.assertIn("❌ <b>HYG</b>", m)                                # put: underlying up = unfavorable
        self.assertIn("STRUCTURE TRIGGERS · 1/2 HOLDING", m)

    def test_missing_grades_state_reason(self):
        m = self.msg()
        self.assertNotIn("· no data<", m)
        self.assertIn("no data: no spot at post or no live price at 16:35 ET", m)
        self.assertIn("no data: no live price from Yahoo at 16:35 ET", m)

    def test_basis_and_pnl_labels(self):
        m = self.msg()
        self.assertIn("Basis: the stock's move since the alert price", m)
        self.assertIn("since the pick posted", m)
        self.assertIn("Option P&amp;L: not tracked (no fills)", m)


if __name__ == "__main__":
    unittest.main()
