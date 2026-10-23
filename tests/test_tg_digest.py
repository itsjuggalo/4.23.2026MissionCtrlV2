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
        self.assertTrue(self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("FSLR", "-38%"))))
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

    def test_recap_and_crypto_sources_go_to_their_own_bot_immediately(self):
        self.assertTrue(self.q("eod_scorecard.py", "📊 <b>EOD SCORECARD</b>", fn="flow_digest"))
        self.assertTrue(self.q("btc_monitor.py", "🔴 BTC BREAKDOWN $58,000"))
        self.assertTrue(self.q("report_card.py", "weekly report card"))
        out = self.sent.read_text()
        self.assertIn("[trading_recaps] 📊 <b>EOD SCORECARD</b>", out)
        self.assertIn("[crypto_desk] 🔴 BTC BREAKDOWN", out)
        self.assertIn("[trading_recaps] weekly report card", out)
        self.assertEqual(self.dg.flush(), 0)                           # nothing was queued
        self.assertEqual(out, self.sent.read_text())
        self.assertFalse(self.q("btc_monitor.py", "x", fn="system_health"))   # only trading lanes re-lane

    def test_failed_send_keeps_items_queued(self):
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("IONQ", "+18%", "$41.20")))
        os.environ["TG_DIGEST_SEND"] = "/bin/false"
        self.assertEqual(self.dg.flush(), 1)
        os.environ["TG_DIGEST_SEND"] = str(Path(self.tmp.name) / "send")
        self.assertEqual(self.dg.flush(), 0)
        self.assertIn("IONQ", self.sent.read_text())

    # ── audit W5 MC-AUD-080 (2026-10-21) ─────────────────────────────────────────────────────
    def test_partial_send_does_not_resend_delivered_chunks(self):
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("IONQ", "+18%")))
        self.dg.build = lambda *a, **k: ["chunk one", "chunk two", "chunk three"]
        d = Path(self.tmp.name)
        flaky = d / "flaky"     # delivers the first chunk, fails the second
        flaky.write_text(f"#!/bin/sh\nn=$(cat {d}/n 2>/dev/null || echo 0); n=$((n+1)); echo $n > {d}/n\n"
                         f"[ $n -eq 2 ] && exit 1\nprintf '%s\\n=====\\n' \"$1\" >> {self.sent}\n")
        flaky.chmod(flaky.stat().st_mode | stat.S_IEXEC)
        os.environ["TG_DIGEST_SEND"] = str(flaky)
        self.assertEqual(self.dg.flush(), 1)
        self.assertEqual(self.dg.flush(), 0)
        chunks = [c for c in self.sent.read_text().split("\n=====\n") if c.strip()]
        self.assertEqual(chunks, ["chunk one", "chunk two", "chunk three"])   # each delivered exactly once

    def test_clip_keeps_occ_asof_and_missing_warnings(self):
        rest = ("calls heavy into the print with a very long explanation that keeps going past the clip point "
                "SPY261120C00700000 · as_of 10:31 ET · IV STALE")
        out = self.dg._clip_keep(rest)
        for token in ("SPY261120C00700000", "as_of 10:31 ET", "STALE"):
            self.assertIn(token, out)

    def test_put_and_call_rows_for_one_ticker_both_survive(self):
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("NVDA", "CALLS $2.1M")))
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("NVDA", "PUTS $1.4M")))
        self.assertEqual(self.dg.flush(), 0)
        txt = self.sent.read_text()
        self.assertIn("CALLS", txt)
        self.assertIn("PUTS", txt)

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

    # ── 2026-10-07 audit: ledger ids 2346/2377/2427 (real 10-06 queue rows) ────────────────
    HEADLINES_MSG = ("🟡 WATCH ONLY — AVGO calls heavy\n\n📰 <b>HEADLINES</b>\n"
                     "• [NBIS] Watching Nebius Group; Hearing Investor Business Daily Buys Stock — benzinga · 4m\n"
                     "• [AVGO] Broadcom Pairs Custom TPU Chips with $60 Billion Debt Pack… — benzinga · 24m\n"
                     "• [NBIS] 10 IT Stocks Whale Activity In Today’s Session — benzinga · 24m\n"
                     "• [AMD] fourth headline is dropped — benzinga · 30m\n"
                     "\n<i>💵 LLM cost today: $0.0000</i>")

    def test_headlines_never_a_dangling_header(self):
        self.q("flow_digest_send.py", self.HEADLINES_MSG, fn="flow_digest")
        self.dg.flush()
        out = self.sent.read_text()
        self.assertNotIn("<b>HEADLINES</b>", out)                      # bare header gone
        self.assertIn("📰 <b>NBIS</b> Watching Nebius", out)
        self.assertEqual(out.count("📰"), 3)                           # up to 3 bullets
        self.assertNotIn("fourth headline", out)

    def test_section_with_no_rows_is_not_emitted(self):
        self.q("flow_digest_send.py", "🔁 REPEAT — META flow again", fn="flow_digest")
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("IONQ", "+18%")))
        self.dg.flush()
        out = self.sent.read_text()
        self.assertNotIn("FLOW DIGEST", out)                           # nothing under it → no header
        self.assertIn("RUNNER RADAR", out)
        self.assertIn("2 FYI updates folded", out)                     # but the count still includes it

    def test_singular_update_grammar(self):
        self.q("runner_radar.py", join(hdr("📡", "Runner Radar"), row("IONQ", "+18%")))
        self.dg.flush()
        self.assertIn("1 FYI update folded", self.sent.read_text())
        self.assertNotIn("1 FYI updates", self.sent.read_text())

    def test_trigger_ids_stripped_from_reader_text(self):
        t = self.dg.strip_internal_ids
        self.assertEqual(t("LITE 55 · LITE:WATCH:202610061436 — 30w rising"), "LITE 55 — 30w rising")
        self.assertEqual(t("1. MU 1050P · comp 9.1\n   id MU:DECIPHER:202610061330"), "1. MU 1050P · comp 9.1")
        self.assertEqual(t("WHY: bought out · UNP:SETUP:202610061330"), "WHY: bought out")
        self.assertEqual(t("plain text, no ids at 13:30"), "plain text, no ids at 13:30")
        self.q("explosion_score.py", "👀 <b>EXPLOSION WATCH</b>\n<b>LITE</b> 55 · LITE:WATCH:202610061436 — 30w rising; 1% off 52wH")
        self.dg.flush()
        out = self.sent.read_text()
        self.assertIn("<b>LITE</b> 55 — 30w rising", out)
        self.assertNotIn("202610061436", out)

    # ── 2026-10-08 audit: GATE BLOCKED spam, mid-sentence clips, repeated headlines/header ──
    GATES = ["🔴 GATE BLOCKED — 9:00 ET — No qualifying contract in this window.",
             "🔴 GATE BLOCKED — 10:00 ET — No qualifying contract in this window. The NVDA call costs $491.",
             "🔴 GATE BLOCKED — 1:00 PM ET — The only setup costs $571 for one contract, which fails the quality gate."]

    def test_gate_blocked_collapses_to_one_line(self):
        for g in self.GATES:
            self.q("flow_digest_send.py", g, fn="flow_digest")
        self.dg.flush()
        out = self.sent.read_text()
        self.assertEqual(out.count("GATE BLOCKED"), 0)
        self.assertIn("🔴 3 blocked (no qualifying contract): NVDA", out)
        self.assertEqual(out.count("blocked"), 1)

    def test_clip_cuts_at_word_boundary(self):
        c = self.dg._clip("Every contract in this window costs more than your cap and a fitting reference needs an option price of four dollars or less today", 60)
        self.assertTrue(c.endswith("…"))
        self.assertNotIn("ref…", c)
        self.assertTrue(c[:-1].rstrip() in "Every contract in this window costs more than your cap and a fitting reference needs an option price of four dollars or less today")
        self.assertEqual(self.dg._clip("short text", 60), "short text")

    def test_headline_sent_earlier_today_is_dropped_and_header_once(self):
        m1 = "🟡 WATCH ONLY — SPY\n\n📰 <b>HEADLINES</b>\n• [SPY] Fed Chairman Warsh To Speak On October 16 At IMF — benzinga · 3m\n"
        m2 = "🟡 WATCH ONLY — SPY\n\n📰 <b>HEADLINES</b>\n• [SPY] Fed Chairman Warsh To Speak On October 16 At IMF — benzinga · 1h\n• [SPY] Other story — benzinga · 2m\n"
        self.q("flow_digest_send.py", m1, fn="flow_digest")
        self.dg.flush()
        self.q("flow_digest_send.py", m2, fn="flow_digest")
        self.dg.flush()
        first, second = self.sent.read_text().split("\n=====\n")[:2]
        self.assertIn("Warsh", first)
        self.assertIn("arrive instantly in Trading Command", first)
        self.assertNotIn("Warsh", second)
        self.assertIn("Other story", second)
        self.assertNotIn("arrive instantly", second)
        self.assertRegex(second, r"since \d{1,2}:\d\d [AP]M ET")


if __name__ == "__main__":
    unittest.main()
