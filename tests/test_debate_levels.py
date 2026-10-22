"""debate_daily levels (DECISIONS R32, 2026-10-21): the facts carry each name's levels.v1 menu, the post shows the
computed Long/Short lines, and the validator redacts any price on neither the menu nor the facts. Dry, no network:
the missionctrl CLI calls are stubbed (the CLI itself is tested in missionctrl test_levels.py)."""
import json, sys, unittest
from pathlib import Path
from unittest import mock
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
import debate_daily as d  # noqa: E402

LV = {"symbols": {"NVDA": {"status": "OK", "long": "Entry: 221.27–221.97 (Long) · TP1 225.29 · TP2 231.49 · Final TP 235.04 · SL 217.37",
                           "short": "Entry: 221.97–223.45 (Short) · TP1 217.37 · TP2 213.62 · Final TP 210.56 · SL 225.29",
                           "menu": [{"id": "L0", "price": 221.97}]},
                  "XYZ": {"status": "UNAVAILABLE", "missing": [{"input": "spot", "reason": "no price returned"}], "menu": []}},
      "block": "LEVELS RULE (R32): ..."}


class Levels(unittest.TestCase):
    def test_menus_cli_and_failure_line(self):
        with mock.patch.object(d, "run", return_value=(0, "noise\n" + json.dumps(LV))) as r:
            self.assertEqual(d.levels(["NVDA", "XYZ"]), LV)
            self.assertEqual(r.call_args[0][0][1:5], ["-m", "pipeline.decision.levels.prompt", "menus", "NVDA,XYZ"])
        with mock.patch.object(d, "run", return_value=(1, "Traceback")):
            self.assertTrue(d.levels(["NVDA"])["block"].startswith("LEVELS UNAVAILABLE (levels.v1 engine rc 1)"))
        self.assertEqual(d.levels([]), {"symbols": {}, "block": ""})

    def test_levels_chunk_lines(self):
        c = d.levels_chunk(LV)
        self.assertIn("**NVDA** Entry: 221.27–221.97 (Long) · TP1 225.29", c)
        self.assertIn("**XYZ** levels UNAVAILABLE (no price returned)", c)
        self.assertIsNone(d.levels_chunk({"symbols": {}}))

    def test_validator_redacts_and_names(self):
        v = {"ok": False, "unknown_numbers": [240.0], "unknown_ids": ["NVDA:L99"], "redacted": "TP [rejected]"}
        with mock.patch.object(d, "run", return_value=(0, json.dumps(v))) as r:
            out = d.check_levels("TP 240", LV, "facts")
            sent = json.loads(r.call_args[1]["inp"])
        self.assertEqual(sent["text"], "TP 240")
        self.assertEqual(out, "TP [rejected]\n_⚠️ levels validator rejected (not on the level menu or in the facts): 240, NVDA:L99_")
        with mock.patch.object(d, "run", return_value=(0, json.dumps({"ok": True, "unknown_numbers": [], "unknown_ids": [], "redacted": "x"}))):
            self.assertEqual(d.check_levels("TP1 NVDA:L0 221.97", LV, ""), "TP1 NVDA:L0 221.97")
        with mock.patch.object(d, "run", return_value=(124, "timed out")):
            self.assertIn("levels validator unavailable", d.check_levels("x", LV, ""))

    def test_rules_say_r32_not_r5(self):
        self.assertIn("R32", d.RULES)
        self.assertNotIn("No stop-loss, no price target", d.RULES)


if __name__ == "__main__":
    unittest.main()
