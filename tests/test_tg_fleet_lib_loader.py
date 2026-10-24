#!/usr/bin/env python3
"""tg_fleet loads its own lib helpers by file path (2026-10-23). In a process with MissionCtrl pipeline/decision/ on
sys.path (lane_consistency) `lib` is MissionCtrl's regular package: before, send() raised "No module named
'lib.tg_split'" and call()'s tg_lint + ledger silently skipped. A fresh /usr/bin/python3 (cron's interpreter) with
that path; Telegram is a stub; ledger and lint go to temp files, never the real ones."""
from __future__ import annotations

import json
import os
import sqlite3
import subprocess
import tempfile
import unittest
from pathlib import Path

FLEET_DIR = Path(__file__).resolve().parents[1]
MC_DECISION = "/AIWorkWSL/web/missionctrl/pipeline/decision"
CHILD = r'''
import io, json, sys, urllib.request
sys.path.insert(0, sys.argv[2]); sys.path.insert(0, sys.argv[1])           # like lane_consistency: MC first
import lib, importlib.util
assert "missionctrl" in (lib.__file__ or ""), lib                            # the shadow is real
sent = []
class R(io.BytesIO): pass
def fake(url, data=None, timeout=None):
    sent.append((url.rsplit("/", 1)[1], data.decode()))
    return R(json.dumps({"ok": True, "result": {"message_id": 7, "chat": {"id": 1}}}).encode())
urllib.request.urlopen = fake
import tg_fleet
tg_fleet.pinned_token = lambda fn: "1:x"
tg_fleet.CHAT_FILE = sys.argv[3]
mode = sys.argv[4]
if mode == "send":
    rc = tg_fleet.send("trading_command", "LANE CHECK — FAIL on 1 lane(s): x")
elif mode == "send_repeat":
    rc = [tg_fleet.send("trading_command", "same text twice"), tg_fleet.send("trading_command", "same text twice")]
else:
    rc = tg_fleet.call("trading_command", "sendMessage", text="hello", _review=(mode != "call_noreview"))
print("\nRESULT " + json.dumps({"rc": rc, "sent": len(sent)}, default=str))
'''


class LoaderUnderShadow(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory()
        t = Path(self.tmp.name)
        (t / "chat").write_text("1")
        self.env = {**os.environ, "TG_DRY_RUN": "0", "TG_DIGEST_OFF": "1", "TG_LEDGER_DB": str(t / "ledger.sqlite"),
                    "TG_LINT_LOG": str(t / "lint.jsonl")}
        self.chat, self.db = str(t / "chat"), t / "ledger.sqlite"

    def tearDown(self):
        self.tmp.cleanup()

    def run_child(self, mode):
        r = subprocess.run(["/usr/bin/python3", "-c", CHILD, MC_DECISION, str(FLEET_DIR), self.chat, mode],
                           capture_output=True, text=True, env=self.env, timeout=60)
        self.assertIn("RESULT ", r.stdout, r.stdout + r.stderr)
        return json.loads(r.stdout.rpartition("RESULT ")[2])

    def rows(self):
        if not self.db.exists():
            return 0
        con = sqlite3.connect(self.db)
        try:
            return con.execute("select count(*) from sends").fetchone()[0]
        finally:
            con.close()

    def test_send_works_and_is_ledgered(self):
        res = self.run_child("send")
        self.assertEqual((res["rc"], res["sent"]), (0, 1))
        self.assertEqual(self.rows(), 1)

    def test_tg_lint_runs_on_send_now(self):
        res = self.run_child("send_repeat")
        self.assertEqual(res["rc"], [0, 0])
        self.assertEqual(res["sent"], 1)                 # the exact repeat is held by tg_lint

    def test_call_review_off_stays_off(self):
        self.assertEqual(self.run_child("call_noreview")["sent"], 1)
        self.assertEqual(self.rows(), 1)


if __name__ == "__main__":
    unittest.main()
