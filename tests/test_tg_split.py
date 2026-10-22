#!/usr/bin/env python3
"""tg_split (2026-09-28): long messages arrive in parts, bad HTML arrives as plain text —
through BOTH shared send points. Hermetic: network stubbed, temp ledger."""
from __future__ import annotations

import io
import json
import os
import sys
import tempfile
import unittest
import urllib.error
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from lib.tg_split import chunks, plain  # noqa: E402


class SplitTest(unittest.TestCase):
    def test_chunks_respect_limit_and_keep_every_line(self):
        text = "\n".join(f"<b>ROW {i}</b> " + "x" * 90 for i in range(200))   # ~20k chars
        parts = chunks(text)
        self.assertGreater(len(parts), 4)
        self.assertTrue(all(len(p) <= 4000 for p in parts))
        self.assertEqual("\n".join(parts), text)
        self.assertEqual(chunks("short"), ["short"])
        self.assertTrue(all(len(p) <= 4000 for p in chunks("y" * 9000)))

    def test_plain_strips_tags_and_unescapes(self):
        self.assertEqual(plain("<b>A&amp;B</b> <i>x&lt;y</i>"), "A&B x<y")


class _Resp(io.BytesIO):
    def __enter__(self): return self
    def __exit__(self, *a): pass


class SendPointsTest(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        os.environ["TG_LEDGER_DB"] = str(Path(self.tmp.name) / "l.sqlite")
        os.environ["TG_DIGEST_OFF"] = "1"
        self.calls = []

    def tearDown(self):
        os.environ.pop("TG_LEDGER_DB", None); os.environ.pop("TG_DIGEST_OFF", None)
        self.tmp.cleanup()

    def fake_urlopen(self, req, *a, **k):
        import urllib.parse
        body = req.data if hasattr(req, "data") and req.data else a[0] if a else k.get("data")
        d = dict(urllib.parse.parse_qsl(body.decode()))
        self.calls.append(d)
        if len(d["text"]) > 4096:
            raise urllib.error.HTTPError("u", 400, "too long", {}, io.BytesIO(b'{"ok":false,"description":"Bad Request: message is too long"}'))
        if d.get("parse_mode") == "HTML" and "<b>" in d["text"] and "</b>" not in d["text"]:
            raise urllib.error.HTTPError("u", 400, "parse", {}, io.BytesIO(b'{"ok":false,"description":"Bad Request: can\'t parse entities"}'))
        return _Resp(json.dumps({"ok": True}).encode())

    def test_notify_splits_long_and_recovers_bad_html(self):
        import lib.notify as n
        old = n.urllib.request.urlopen
        n.urllib.request.urlopen = self.fake_urlopen
        try:
            self.assertTrue(n._send_message("t", "c", "line\n" * 3000, loud=False, html=True))
            self.assertTrue(all(len(c["text"]) <= 4000 for c in self.calls))
            self.calls.clear()
            self.assertTrue(n._send_message("t", "c", "<b>broken", loud=False, html=True))
            self.assertEqual(self.calls[-1]["text"], "broken")
            self.assertNotIn("parse_mode", self.calls[-1])
        finally:
            n.urllib.request.urlopen = old

    def test_tg_fleet_send_splits_long(self):
        import tg_fleet as f
        old_urlopen, old_tok = f.urllib.request.urlopen, f.token
        f.urllib.request.urlopen = lambda url, data=None, timeout=None: self.fake_urlopen(type("R", (), {"data": data})())
        f.token = lambda fn: f"{f.BOT_ID[fn]}:t"   # pinned id prefix (MC-AUD-084)
        try:
            self.assertEqual(f.send("system_health", "row\n" * 5000), 0)
            self.assertGreaterEqual(len(self.calls), 5)
            self.assertTrue(all(len(c["text"]) <= 4000 for c in self.calls))
        finally:
            f.urllib.request.urlopen, f.token = old_urlopen, old_tok


if __name__ == "__main__":
    unittest.main()
