#!/usr/bin/env python3
"""Script-standard #6/#7 (2026-10-23): option-scraper flow_pulse / best3_core / exit_watcher send only through
tg_fleet (lib.notify.tg_push → tg_fleet.call). Dry-run render (TG_DRY_RUN=1, digest fold off, urlopen booby-trapped):
the text that reaches tg_fleet is byte-identical to what the sender was given, on the sender's own lane and buzz."""
from __future__ import annotations

import contextlib
import importlib.util
import io
import json
import os
import sys
import time
import unittest
import urllib.request
from pathlib import Path
from unittest import mock

SCRIPTS = Path.home() / "scripts"
sys.path.insert(0, str(SCRIPTS))
DIGEST = Path("/AIWorkWSL/trading/signals/option-scraper/pipeline/digest")


def load(name, path):
    sys.path.insert(0, str(Path(path).parent))
    spec = importlib.util.spec_from_file_location(name, path)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


def boom(*a, **k):
    raise AssertionError("network call attempted in dry-run")


def rendered(out: str) -> tuple[str, dict]:
    """(lane, sendMessage params) from tg_fleet's DRY render."""
    head, _, rest = out.partition("\n")
    assert head.startswith("DRY "), out
    method, _, js = rest.strip().partition(" ")
    assert method == "sendMessage", rest
    return head.split()[1], json.loads(js)


class DigestSenders(unittest.TestCase):
    def setUp(self):
        self.env = mock.patch.dict(os.environ, {"TG_DRY_RUN": "1", "TG_DIGEST_OFF": "1", "DRY": ""})
        self.env.start()
        self.net = mock.patch.object(urllib.request, "urlopen", boom)
        self.net.start()
        self.text = (f"🟢 <b>SPY</b> 600C 11/20 · $2.1M sweep · test {time.time_ns()}\n"
                     "<i>timing context only</i> &amp; a second line")

    def tearDown(self):
        self.net.stop()
        self.env.stop()

    def capture(self, fn, *a, **k):
        buf = io.StringIO()
        with contextlib.redirect_stdout(buf):
            r = fn(*a, **k)
        return r, buf.getvalue()

    def test_flow_pulse_is_silent_on_trading_command(self):
        m = load("flow_pulse_t", DIGEST / "flow_pulse.py")
        ok, out = self.capture(m.send, self.text)
        lane, p = rendered(out)
        self.assertTrue(ok)
        self.assertEqual((lane, p["text"], p["parse_mode"], p["disable_notification"]),
                         ("trading_command", self.text, "HTML", "true"))

    def test_best3_loud_and_silent_on_trading_command(self):
        m = load("best3_core_t", DIGEST / "best3_core.py")
        for loud, flag in ((True, "false"), (False, "true")):
            ok, out = self.capture(m.tg_send, self.text, loud)
            lane, p = rendered(out)
            self.assertTrue(ok)
            self.assertEqual((lane, p["text"], p["disable_notification"]), ("trading_command", self.text, flag))

    def test_exit_watcher_on_flow_signals(self):
        m = load("exit_watcher_t", DIGEST / "exit_watcher.py")
        ok, out = self.capture(m.send, self.text, loud=True)
        lane, p = rendered(out)
        self.assertTrue(ok)
        self.assertEqual((lane, p["text"], p["disable_notification"]), ("flow_signals", self.text, "false"))

    def test_fleet_failure_is_loud_and_never_raw(self):
        err = io.StringIO()
        with mock.patch.dict(sys.modules, {"lib.notify": mock.Mock(tg_push=lambda *a, **k: None)}), \
                contextlib.redirect_stderr(err):
            for name, f, call in (("flow_pulse_f", "flow_pulse.py", lambda m: m.send("x")),
                                  ("best3_core_f", "best3_core.py", lambda m: m.tg_send("x", True)),
                                  ("exit_watcher_f", "exit_watcher.py", lambda m: m.send("x"))):
                self.assertIs(call(load(name, DIGEST / f)), False, f)
        self.assertEqual(err.getvalue().count("not sent"), 3)
        for f in ("flow_pulse.py", "best3_core.py", "exit_watcher.py"):
            src = (DIGEST / f).read_text()
            self.assertNotIn("https://api.telegram.org", src, f)


if __name__ == "__main__":
    unittest.main()
