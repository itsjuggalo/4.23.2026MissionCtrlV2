#!/usr/bin/env python3
"""tg_digest (2026-09-28): FYI trading pushes fold into one compact digest; act-now
messages still go instantly. Hermetic — temp DB, send stubbed, no Telegram."""
from __future__ import annotations

import os
import stat
import sys
import tempfile
import unittest
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from tg_format import hdr, row, footer, join, b  # noqa: E402


def pullback(*syms):
    lines = ["🎯 " + b("PULLBACK WATCH") + " — pulled back to a normal buy area:"]
    for s, px, lo, hi in syms:
        lines.append(f"▸ <b>{s}</b> is ${px} — the area it usually bounces from is ${lo}–${hi}, "
                     f"so it's in range now. Buying it when it was hot instead would have cost you +4%. "
                     f"· hub S $1 / R $2 · {s}:PULLBACK:202609281000")
    lines.append("<i>This is why waiting beats chasing — reply GATE SYMBOL dollars</i>")
    return "\n".join(lines)


class DigestTest(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        d = Path(self.tmp.name)
        os.environ["TG_LEDGER_DB"] = str(d / "l.sqlite")
        self.sent = d / "sent.txt"
        stub = d / "send"
        stub.write_text(f"#!/bin/sh\nprintf '%s\\n=====\\n' \"$1\" >> {self.sent}\n")
        stub.chmod(stub.stat().st_mode | stat.S_IEXEC)
        os.environ["TG_DIGEST_SEND"] = str(stub)
        os.environ.pop("TG_DIGEST_OFF", None)
        import importlib
        import lib.tg_digest as dg
        self.dg = importlib.reload(dg)
        self.argv0 = sys.argv[0]

    def tearDown(self):
        sys.argv[0] = self.argv0
        for k in ("TG_LEDGER_DB", "TG_DIGEST_SEND", "TG_DIGEST_OFF"):
            os.environ.pop(k, None)
        self.tmp.cleanup()

    def q(self, script, text, fn="trading_command"):
        sys.argv[0] = f"/x/{script}"
        return self.dg.intercept(fn, text, True)

    def test_act_now_messages_stay_instant(self):
        self.assertFalse(self.q("setup_scanner.py", hdr("🎯", "Setups") + "\n1. LLY buy-stop $1151"))
        self.assertFalse(self.q("rebound_trigger_ping.py", "🏗 <b>Structure Trigger</b>"))
        self.assertFalse(self.q("explosion_score.py", hdr("💥", "Explosion Setup", sub="NVDA 81/100")))
        self.assertFalse(self.q("flow_digest_send.py", "🟢 TRADE NVDA 250C", fn="flow_digest"))
        self.assertFalse(self.q("best3_digest.py", "BEST-3 card", fn="flow_digest"))
        self.assertFalse(self.q("some_new_script.py", "anything"))
        self.assertFalse(self.q("flow_picks_post.py", "🎯 **FLOW PICKS — live contracts**", fn="flow_digest"))           # unknown → instant
        self.assertFalse(self.q("pullback_autowatch.py", pullback(("NVDA", 1, 1, 2)), fn="system_health"))

    def test_fyi_messages_fold_into_one_compact_digest(self):
        self.assertTrue(self.q("pullback_autowatch.py", pullback(("NVDA", "222.39", "214.61", "223.12"),
                                                                 ("AVGO", "301.10", "290.00", "305.50"))))
        self.assertTrue(self.q("pullback_autowatch.py", pullback(("NVDA", "220.00", "214.61", "223.12"))))
        self.assertTrue(self.q("explosion_score.py", join(hdr("👀", "Explosion Watch"),
                                                          "▸ SMCI 62 — vol 3x; coil",
                                                          "▸ PLTR 58 — base breakout")))
        self.assertTrue(self.q("flow_digest_send.py", "🟡 WATCH ONLY — META calls heavy but no entry", fn="flow_digest"))
        self.assertTrue(self.q("flow_pulse.py", join(hdr("💓", "Flow Pulse"), row("TSLA", "$2.1M", "calls"),
                                                     footer("awareness only")), fn="flow_digest"))
        self.assertTrue(self.q("flow_digest_send.py", "🔁 REPEAT — META flow again", fn="flow_digest"))
        self.assertTrue(self.q("eod_scorecard.py", join(hdr("📊", "EOD Scorecard"), row("FSLR", "-38%")),
                               fn="flow_digest"))
        self.assertEqual(self.dg.flush(), 0)
        out = self.sent.read_text()
        self.assertEqual(out.count("====="), 1)                      # ONE message
        self.assertIn("<b>FSLR</b> -38%", out)                         # sign kept
        self.assertNotIn("REPEAT", out)                                # no-new-info hidden
        self.assertNotIn("223.12,", out)
        self.assertIn("TRADING DIGEST", out)
        self.assertIn("<b>NVDA</b> $220.00 · buy zone $214.61–$223.12", out)   # newest NVDA wins
        self.assertEqual(out.count("<b>NVDA</b>"), 1)                  # deduped
        self.assertIn("<b>AVGO</b>", out)
        self.assertIn("<b>SMCI</b> 62 — vol 3x; coil", out)
        self.assertIn("<b>PLTR</b>", out)
        self.assertIn("META calls heavy", out)
        self.assertIn("TSLA", out)
        self.assertNotIn("waiting beats chasing", out)                 # footers dropped
        self.assertNotIn("awareness only", out)
        self.assertEqual(self.dg.flush(), 0)                           # nothing left
        self.assertEqual(out, self.sent.read_text())

    def test_failed_send_keeps_items_queued(self):
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("IONQ", "+18%", "$41.20")))
        os.environ["TG_DIGEST_SEND"] = "/bin/false"
        self.assertEqual(self.dg.flush(), 1)
        os.environ["TG_DIGEST_SEND"] = str(Path(self.tmp.name) / "send")
        self.assertEqual(self.dg.flush(), 0)
        self.assertIn("IONQ", self.sent.read_text())

    def test_kill_switch_sends_everything_instantly(self):
        os.environ["TG_DIGEST_OFF"] = "1"
        self.assertFalse(self.q("pullback_autowatch.py", pullback(("NVDA", 1, 1, 2))))

    def test_long_digest_is_chunked_under_telegram_limit(self):
        for i in range(12):
            syms = [(f"T{i}{j}", "10.00", "9.00", "11.00") for j in range(9)]
            self.q("pullback_autowatch.py", pullback(*syms))
            self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), *[row(f"R{i}{j}", "+9%") for j in range(9)]))
            self.q("flow_pulse.py", join(hdr("💓", "Flow Pulse"), *[row(f"P{i}{j}", "$1M") for j in range(9)]))
        self.assertEqual(self.dg.flush(), 0)
        for chunk in self.sent.read_text().split("\n=====\n"):
            self.assertLessEqual(len(chunk), 4096)
        self.assertIn("more — dashboard", self.sent.read_text())


if __name__ == "__main__":
    unittest.main()
