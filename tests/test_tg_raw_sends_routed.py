#!/usr/bin/env python3
"""Script-standard #6 (2026-10-22): the five former raw api.telegram.org senders now go through tg_fleet.call.
Dry-run render only (TG_DRY_RUN=1): nothing is sent, and urlopen is booby-trapped to prove it."""
from __future__ import annotations

import contextlib
import importlib.util
import io
import os
import sys
import unittest
import urllib.request
from pathlib import Path
from unittest import mock

HOME = Path.home()
SCRIPTS = HOME / "scripts"
sys.path.insert(0, str(SCRIPTS))
DIGEST = Path("/AIWorkWSL/trading/signals/option-scraper/pipeline/digest")
QE = Path("/AIWorkWSL/web/missionctrl/scripts/quantedge_alert_watcher.py")


def load(name, path):
    sys.path.insert(0, str(Path(path).parent))
    spec = importlib.util.spec_from_file_location(name, path)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


def boom(*a, **k):
    raise AssertionError("network call attempted in dry-run")


class Routed(unittest.TestCase):
    def setUp(self):
        self.env = mock.patch.dict(os.environ, {"TG_DRY_RUN": "1"})
        self.env.start()
        self.net = mock.patch.object(urllib.request, "urlopen", boom)
        self.net.start()

    def tearDown(self):
        self.net.stop()
        self.env.stop()

    def run_capture(self, fn, *a, **k):
        buf = io.StringIO()
        with contextlib.redirect_stdout(buf):
            r = fn(*a, **k)
        return r, buf.getvalue()

    def test_quantedge_watcher_renders_crypto_desk(self):
        m = load("qe_watcher", QE)
        ok, out = self.run_capture(m.send_tg, "unused", "123", "<b>QE test</b> BTC")
        self.assertTrue(ok)
        self.assertIn("DRY crypto_desk", out)
        self.assertIn("QE test", out)

    def test_options_scorecard_renders_trading_recaps(self):
        m = load("opt_scorecard", SCRIPTS / "options_position_scorecard.py")
        r, out = self.run_capture(m._tg, "sendMessage", chat_id="123", text="<b>card</b>", parse_mode="HTML")
        self.assertIs(r, False)            # dry message_id 0 is never an ACK
        self.assertIn("DRY trading_recaps", out)

    def test_scoreboard_auditor_renders_trading_recaps_and_quiz(self):
        m = load("scoreboard_auditor", DIGEST / "scoreboard_auditor.py")
        with mock.patch.object(m, "_creds", return_value=(None, "123")):
            r, out = self.run_capture(m._api, "sendMessage", text="score")
            self.assertTrue(r["ok"])
            self.assertIn("DRY trading_recaps", out)
            r, out = self.run_capture(m._api, "sendPoll", question="q", _quiz=True)
            self.assertIn("DRY quiz", out)

    def test_dm_responder_sends_via_flow_signals_only_getupdates_is_raw(self):
        m = load("dm_responder", DIGEST / "telegram_dm_responder.py")
        r, out = self.run_capture(m._api, "tok", "sendMessage", chat_id="123", text="hi")
        self.assertTrue(r["ok"])
        self.assertIn("DRY flow_signals", out)
        with self.assertRaises(AssertionError):   # receiving is the one raw call left
            m._api("tok", "getUpdates", offset=0, timeout=0)

    def test_shock_guard_has_no_raw_send_and_fails_loud(self):
        m = load("shock_guard", SCRIPTS / "shock_guard.py")
        src = (SCRIPTS / "shock_guard.py").read_text()
        self.assertNotIn("api.telegram.org", src)
        err = io.StringIO()
        with mock.patch.dict(sys.modules, {"lib.notify": mock.Mock(tg_push=lambda *a, **k: None)}), \
                contextlib.redirect_stderr(err):
            m.DRY = False
            m.telegram("alert", True)
        self.assertIn("TELEGRAM SEND FAILED", err.getvalue())

    def test_lib_notify_tg_push_dry_run_renders_lane_without_network(self):
        import lib.notify as n
        src = (SCRIPTS / "lib" / "notify.py").read_text()
        self.assertNotIn("api.telegram.org", src)
        r, out = self.run_capture(n.tg_push, "<b>alert</b> test", "flow_signals", loud=False, chat="123")
        self.assertEqual(r, "flow_signals")
        self.assertIn("DRY flow_signals", out)
        r, out = self.run_capture(n.tg_push, "x " * 3000, "trading_recaps", chat="123")
        self.assertIn("DRY trading_recaps", out)       # long text -> several parts, all rendered, none sent

    def test_keeper_digest_and_debt_alert_dry_run(self):
        stubs = {m: mock.Mock() for m in ("google", "google.oauth2", "google.oauth2.credentials",
                                          "google.auth", "google.auth.transport", "google.auth.transport.requests")}
        with mock.patch.dict(sys.modules, stubs):   # system python has no google libs; only tg_alert is under test
            k = load("gtk", SCRIPTS / "google_token_keeper.py")
        _, out = self.run_capture(k.tg_alert, "keeper test")
        self.assertIn("DRY system_health", out)
        d = load("tg_digest_mod", SCRIPTS / "lib" / "tg_digest.py")
        with mock.patch.dict(os.environ, {"TG_DIGEST_SEND": ""}):
            ok, out = self.run_capture(d._send, "<b>digest</b>")
        self.assertTrue(ok)
        self.assertIn("DRY trading_digest", out)
        for p in (SCRIPTS / "google_token_keeper.py", SCRIPTS / "lib" / "tg_digest.py", HOME / "05_AUTOMATION" / "debt_due_alert.py"):
            self.assertNotIn("api.telegram.org", p.read_text(), p.name)

    def test_no_raw_telegram_urls_left_except_getupdates(self):
        for p in (QE, SCRIPTS / "options_position_scorecard.py", DIGEST / "scoreboard_auditor.py"):
            self.assertNotIn("api.telegram.org", p.read_text(), p.name)
        dm = (DIGEST / "telegram_dm_responder.py").read_text()
        self.assertEqual(dm.count("api.telegram.org"), 1)


if __name__ == "__main__":
    unittest.main()
