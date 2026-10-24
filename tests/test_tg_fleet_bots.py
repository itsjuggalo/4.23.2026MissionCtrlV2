#!/usr/bin/env python3
"""Script-standard #6/#7 (2026-10-23): lifeclaw_bot, antigravity_aime_bot, mc_control_bot, options_quiz, ping_mike and
life-engine-run send only through tg_fleet, each on the lane whose pinned bot is the token it used before. Dry-run
render (TG_DRY_RUN=1, urlopen + requests.post booby-trapped): the text reaches tg_fleet byte-identical; receiving
(getUpdates) is the one direct call left; reply_markup is sent as JSON."""
from __future__ import annotations

import contextlib
import importlib.util
import io
import json
import os
import sys
import unittest
import urllib.request
from pathlib import Path
from unittest import mock

import requests

SCRIPTS = Path.home() / "scripts"
sys.path.insert(0, str(SCRIPTS))
import tg_fleet  # noqa: E402


def load(name, path):
    spec = importlib.util.spec_from_file_location(name, path)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


def boom(*a, **k):
    raise AssertionError("network call attempted in dry-run")


def rendered(out: str) -> tuple[str, str, dict]:
    head, _, rest = out.partition("\n")
    assert head.startswith("DRY "), out
    method, _, js = rest.strip().partition(" ")
    return head.split()[1], method, json.JSONDecoder().raw_decode(js)[0]


TEXT = "🧘 <b>Check-in</b> — drink water &amp; stretch\nline two · ✓"


class Bots(unittest.TestCase):
    def setUp(self):
        self.p = [mock.patch.dict(os.environ, {"TG_DRY_RUN": "1", "TG_DIGEST_OFF": "1"}),
                  mock.patch.object(urllib.request, "urlopen", boom), mock.patch.object(requests, "post", boom)]
        for p in self.p:
            p.start()

    def tearDown(self):
        for p in reversed(self.p):
            p.stop()

    def capture(self, fn, *a, **k):
        buf = io.StringIO()
        with contextlib.redirect_stdout(buf):
            r = fn(*a, **k)
        return r, buf.getvalue()

    def check(self, out, lane, method="sendMessage", text=TEXT):
        ln, m, p = rendered(out)
        self.assertEqual((ln, m), (lane, method))
        if text is not None:
            self.assertEqual(p["text"], text)
        return p

    def test_lanes_are_the_bots_that_sent_before(self):
        sec = Path.home() / ".openclaw/secrets"
        for f, lane in (("lifeclaw_telegram_bot_token", "life_wellness"), ("telegram_antigravity_bot_token", "aime_research"),
                        ("telegram-ping-bot-token", "system_health"), ("telegram_grok_bot_token", "quiz")):
            self.assertEqual(tg_fleet._tok_id((sec / f).read_text().strip()), tg_fleet.BOT_ID[lane], f)

    def test_lifeclaw_reply_and_buttons(self):
        m = load("lifeclaw_t", SCRIPTS / "lifeclaw_bot.py")
        _, out = self.capture(m.send_reply, "123", TEXT)
        self.check(out, "life_wellness")
        kb = {"inline_keyboard": [[{"text": "A", "callback_data": "lw:done"}]]}
        _, out = self.capture(m.tg, "sendMessage", chat_id="123", text=TEXT, reply_markup=kb)
        self.assertEqual(self.check(out, "life_wellness")["reply_markup"], kb)
        with self.assertRaises(AssertionError):
            m.requests.post("x")                      # getUpdates still polls directly (booby-trapped here)

    def test_antigravity_reply(self):
        stub = mock.patch.object(Path, "read_text", lambda self, *a, **k: "x") if not (
            Path.home() / ".openclaw/secrets/ainvest_cookie.txt").exists() else contextlib.nullcontext()
        with stub:
            m = load("antigravity_t", SCRIPTS / "antigravity_aime_bot.py")
        _, out = self.capture(m.tg, "sendMessage", chat_id="123", text=TEXT)
        self.check(out, "aime_research")

    def test_mc_control_reply(self):
        m = load("mc_control_t", SCRIPTS / "mc_control_bot.py")
        _, out = self.capture(m.api, "sendMessage", {"chat_id": "123", "text": TEXT, "disable_web_page_preview": "true"})
        self.check(out, "system_health")

    def test_options_quiz_card_with_keyboard(self):
        m = load("options_quiz_t", SCRIPTS / "options_quiz.py")
        kb = {"inline_keyboard": [[{"text": "A", "callback_data": "oq:A:q1"}]]}
        _, out = self.capture(m._tg, "sendMessage", chat_id="123", text=TEXT, parse_mode="HTML", reply_markup=kb)
        p = self.check(out, "quiz")
        self.assertEqual((p["parse_mode"], p["reply_markup"]), ("HTML", kb))

    def test_ping_mike_lane_and_no_raw_fallback(self):
        m = load("ping_mike_t", SCRIPTS / "ping_mike.py")
        rc, out = self.capture(m.ping, TEXT, "trading_command")
        self.assertEqual(rc, 0)
        self.check(out, "trading_command")
        err = io.StringIO()
        with mock.patch.dict(sys.modules, {"lib.notify": mock.Mock(tg_push=lambda *a, **k: None)}), \
                contextlib.redirect_stderr(err):
            self.assertEqual(m.ping("x"), 1)
        self.assertIn("PING NOT DELIVERED", err.getvalue())

    def test_life_engine_message_and_photo(self):
        m = load("life_engine_t", SCRIPTS / "life-engine-run.py")
        ok, out = self.capture(m._telegram_post, TEXT, True)
        self.assertFalse(ok)                          # a dry render is never reported as delivered
        self.assertEqual(self.check(out, "life_wellness")["parse_mode"], "HTML")
        img = SCRIPTS / "tests" / "_tg_dry.png"
        img.write_bytes(b"\x89PNG\r\n")
        try:
            ok, out = self.capture(m.send_telegram_photo, str(img), "<b>cap</b>")
            self.assertFalse(ok)
            self.assertIn("DRY life_wellness", out)
            self.assertIn("[_tg_dry.png] cap", out)
        finally:
            img.unlink()

    def test_call_encodes_objects_and_booleans(self):
        seen = {}

        def fake(req, data=None, timeout=None):
            seen.update(dict(x.split("=", 1) for x in data.decode().split("&")))
            raise OSError("stop")
        with mock.patch.dict(os.environ, {"TG_DRY_RUN": "0"}), mock.patch.object(urllib.request, "urlopen", fake), \
                mock.patch.object(tg_fleet, "pinned_token", lambda fn: "1:x"):
            tg_fleet.call("quiz", "sendMessage", chat_id="1", text="t", disable_notification=True,
                          reply_markup={"a": 1}, _review=False)
        self.assertEqual(seen["disable_notification"], "true")
        self.assertEqual(urllib.parse.unquote_plus(seen["reply_markup"]), '{"a": 1}')

    def test_tg_gateway_lanes_route_through_their_own_pinned_bot(self):
        m = load("tg_responder_t", SCRIPTS / "tg_responder.py")
        want = {"laptopclaude": "trading_command", "pingpong": "system_health", "astrology": "astrology",
                "trendscanner": "trend_scanner"}
        for key in m.GATEWAY_LANES:
            cfg = m.BOTS[key]
            lane = cfg.get("fleet_fn") or m._fleet_lane((Path.home() / ".openclaw/secrets" / cfg["token"]).read_text().strip())
            self.assertEqual(lane, want[key], key)
            _, out = self.capture(m._tg_for("https://unused", lane), "sendMessage", chat_id="123", text=TEXT)
            self.check(out, lane)

    def test_quiz_bot_send(self):
        m = load("quiz_bot_t", SCRIPTS / "quiz_bot.py")
        m.DRY = False
        kb = {"inline_keyboard": [[{"text": "A", "callback_data": "quiz:A"}]]}
        _, out = self.capture(m.api, "sendMessage", chat_id="123", text=TEXT, parse_mode="HTML", reply_markup=kb)
        self.assertEqual(self.check(out, "quiz")["reply_markup"], kb)

    def test_best3_and_learn_quiz_on_quiz_lane(self):
        d = Path("/AIWorkWSL/trading/signals/option-scraper/pipeline/digest")
        sys.path.insert(0, str(d))
        with mock.patch.dict(os.environ, {"DRY": ""}):
            b = load("best3_quiz_t", d / "best3_quiz.py")
            ok, out = self.capture(b.coach_send, TEXT, [[{"text": "A", "callback_data": "q:A"}]])
            self.assertTrue(ok)
            p = self.check(out, "quiz")
            self.assertEqual((p["disable_notification"], json.loads(p["reply_markup"])["inline_keyboard"][0][0]["text"]),
                             ("true", "A"))
            lq = load("learn_quiz_t", d / "learn_quiz.py")
            lq.DRY = False
            ok, out = self.capture(lq.coach_send, TEXT, [[{"text": "B", "callback_data": "quiz:B"}]])
            self.assertTrue(ok)
            self.check(out, "quiz")
            img = SCRIPTS / "tests" / "_tg_dry_q.png"
            img.write_bytes(b"\x89PNG\r\n")
            try:
                ok, out = self.capture(lq.coach_send, TEXT, None, str(img))
                self.assertTrue(ok)                    # send_upload dry render returns 0
                self.assertIn("DRY quiz", out)
                self.assertIn("[_tg_dry_q.png] " + TEXT, out)
            finally:
                img.unlink()
        for f in ("best3_quiz.py", "learn_quiz.py"):
            self.assertNotIn("https://api.telegram.org", (d / f).read_text(), f)

    def test_send_upload_extra_fields(self):
        seen = {}

        def fake_post(url, data=None, files=None, timeout=None):
            seen.update(data)
            return mock.Mock(json=lambda: {"ok": True})
        img = SCRIPTS / "tests" / "_tg_up.png"
        img.write_bytes(b"\x89PNG\r\n")
        try:
            with mock.patch.dict(os.environ, {"TG_DRY_RUN": "0"}), mock.patch.object(tg_fleet.requests, "post", fake_post), \
                    mock.patch.object(tg_fleet, "pinned_token", lambda fn: "1:x"), \
                    mock.patch.object(tg_fleet, "_ledger", lambda *a, **k: None):
                rc, _ = self.capture(tg_fleet.send_upload, "quiz", str(img), "cap",
                                     extra={"disable_notification": "true", "reply_markup": {"k": [1]}})
        finally:
            img.unlink()
        self.assertEqual(rc, 0)
        self.assertEqual((seen["disable_notification"], seen["reply_markup"], seen["caption"]),
                         ("true", '{"k": [1]}', "cap"))

    def _fn(self, path, name, ns):
        """Exec one top-level function from a file that cannot be imported in a test (threads/discord at import)."""
        import ast
        tree = ast.parse(Path(path).read_text())
        node = next(n for n in tree.body if isinstance(n, ast.FunctionDef) and n.name == name)
        exec(compile(ast.Module([node], []), str(path), "exec"), ns)
        return ns[name]

    def test_transcribe_pings_on_trading_command(self):
        logs = []
        for f in ("erikdalton_transcribe.py", "vibecoding_transcribe.py", "ct_transcribe_monitor.py",
                  "ed_transcribe_monitor.py"):
            src = (SCRIPTS / f).read_text()
            self.assertNotIn("api.telegram.org", src, f)
            ns = {"SECRETS": Path.home() / ".openclaw/secrets", "Path": Path, "log": logs.append, "print": logs.append}
            tg = self._fn(SCRIPTS / f, "telegram", ns)
            _, out = self.capture(tg, TEXT)
            self.check(out, "trading_command")

    def test_grok_and_tgbridge(self):
        import logging
        ns = {"sys": sys, "Path": Path, "print": print}
        send = self._fn(SCRIPTS / "bots/grok_telegram.py", "send_message", ns)
        edit = self._fn(SCRIPTS / "bots/grok_telegram.py", "edit_message", ns)
        mid, out = self.capture(send, "123", TEXT, reply_to=7)
        self.assertEqual((mid, self.check(out, "quiz")["reply_to_message_id"]), (0, 7))
        _, out = self.capture(edit, "123", 9, TEXT)
        self.assertEqual(self.check(out, "quiz", method="editMessageText")["message_id"], 9)
        ns = {"Path": Path, "TG_CHAT_ID": "123", "logging": logging}
        fwd = self._fn(SCRIPTS / "tg-bridge/tgbridge.py", "send_to_telegram", ns)
        ok, out = self.capture(fwd, TEXT, "flow")
        self.assertTrue(ok)
        self.assertEqual(self.check(out, "flow_signals")["parse_mode"], "HTML")

    def test_real_coach_ledger_and_lane_bots(self):
        lg = load("real_coach_ledger_t", SCRIPTS / "real_coach/ledger.py")
        kb = {"inline_keyboard": [[{"text": "FOLLOW", "callback_data": "dec:1:follow"}]]}
        _, out = self.capture(lg._tg_api, "sendMessage", chat_id="123", text=TEXT, reply_markup=json.dumps(kb))
        self.assertEqual(json.loads(self.check(out, "flow_signals")["reply_markup"]), kb)
        with mock.patch.dict(os.environ, {"DRY": ""}):
            lb = load("lane_bots_t", SCRIPTS / "lane_bots.py")
            lb.DRY = False
            bot = lb.Bot("crypto_desk")
            _, out = self.capture(bot.send, TEXT)
            self.assertEqual(self.check(out, "crypto_desk")["parse_mode"], "HTML")

    def test_wellness_card_animation_with_buttons(self):
        sys.path.insert(0, str(SCRIPTS))
        wc = load("tg_wellness_card_t", SCRIPTS / "lib/tg_wellness_card.py")
        gif = SCRIPTS / "tests" / "_tg_dry.gif"
        gif.write_bytes(b"GIF89a")
        seen = {}

        def fake_post(url, data=None, files=None, timeout=None):
            seen.update(data, method=url.rsplit("/", 1)[1], field=list(files)[0])
            return mock.Mock(json=lambda: {"ok": True})
        try:
            ok, out = self.capture(wc.send_card_with_buttons, str(gif), TEXT, [[{"text": "Done", "callback_data": "x"}]],
                                   animation=True)
            self.assertFalse(ok)                      # dry render is never "sent"
            self.assertIn("DRY life_wellness", out)
            with mock.patch.dict(os.environ, {"TG_DRY_RUN": "0"}), mock.patch.object(tg_fleet.requests, "post", fake_post), \
                    mock.patch.object(tg_fleet, "_ledger", lambda *a, **k: None):
                ok, _ = self.capture(wc.send_card_with_buttons, str(gif), TEXT, [[{"text": "Done", "callback_data": "x"}]],
                                     animation=True, silent=True)
        finally:
            gif.unlink()
        self.assertTrue(ok)
        self.assertEqual((seen["method"], seen["field"], seen["caption"], seen["parse_mode"], seen["disable_notification"]),
                         ("sendAnimation", "animation", TEXT, "HTML", "true"))
        self.assertEqual(json.loads(seen["reply_markup"])["inline_keyboard"][0][0]["text"], "Done")


if __name__ == "__main__":
    unittest.main()
