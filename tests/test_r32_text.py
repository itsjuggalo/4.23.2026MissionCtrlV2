"""lib/r32_text — the R32 validator for LLM free text (audit P1 2026-10-22: the 08:55 pre-market brief said
"trade small … use a stop"). Pure tests on the real 10-21 / 10-22 brief text plus edge cases; nothing is sent.
Run: ~/.venv/bin/python -m pytest -q -p no:anyio tests/test_r32_text.py
"""
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from lib.r32_text import note, scrub  # noqa: E402

BRIEF_1022 = """RISK-OFF — oil surges; Nasdaq futures sink.
Data: Jobless claims fell to 194,000, a three-month low (AP).
Earnings: PG, UNP, HON, CMCSA and SPOT report before the open.
Geopolitics: Houthi attacks in Saudi Arabia push Brent near $112 (Reuters).
Watchlist: TSLA/META react to earnings; SPCX has merger talk; SMH/MU/MRVL/INTC face chip selling.
PLAN: Wait 15 minutes, then trade small only if SMH confirms a direction; use a stop."""

BRIEF_1021_PLAN = "PLAN: Trade SMALL; wait for the first 15 minutes, then follow a confirmed SPY or QQQ trend."


def test_real_1022_brief_loses_only_the_sizing_and_stop_sentence():
    clean, removed = scrub(BRIEF_1022)
    lines = clean.splitlines()
    assert lines[:5] == BRIEF_1022.splitlines()[:5]                    # catalysts untouched (194,000 / $112 are data)
    assert "trade small" not in clean.lower() and "use a stop" not in clean.lower()
    assert lines[5] == "PLAN: [removed: sizing / stop / level advice is not allowed (R32)]"
    assert {k for r in removed for k in r["kind"]} >= {"size", "stop"}
    assert "R32 check removed" in note(removed) and note([]) == ""


def test_1021_plan_keeps_the_non_sizing_part():
    clean, removed = scrub(BRIEF_1021_PLAN)
    assert clean == "PLAN: wait for the first 15 minutes, then follow a confirmed SPY or QQQ trend."
    assert removed[0]["kind"] == ["size"]


def test_whole_line_removed_keeps_label_and_says_so():
    clean, _ = scrub("PLAN: Buy SPY calls above $770 with a tight stop at 765.")
    assert clean.startswith("PLAN: [removed:") and "770" not in clean


def test_invented_levels_go_but_data_numbers_stay():
    for bad in ("Watch support at 580 on SPY.", "QQQ breaks above 705 → momentum.", "Entry near 212.5 looks good.",
                "Use half size today.", "Risk no more than 2% of your account.", "Buy 3 contracts.",
                "Scale in over the morning.", "Take profits into strength."):
        clean, removed = scrub(bad)
        assert removed and clean.strip() == "", bad
    for ok in ("CPI came in at 3.1% vs 3.0% expected.", "10Y yield above 4.2% weighs on tech.",
               "Fed decision at 2:00 ET; Powell at 2:30.", "Apple event on 10/28.", "Brent near $112 (Reuters).",
               "NVDA guidance $54B vs $52B est.", "Futures down 0.6%."):
        clean, removed = scrub(ok)
        assert not removed and clean == ok, ok
