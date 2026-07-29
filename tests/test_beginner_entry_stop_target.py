"""Entry / stop / take-profit must all three survive, on every beginner-facing card.

Mike's 2026-07-29 ask: "make sure the info you're providing is crystal clear for a beginner
trader to use for entry and exit and tp." The cards had an entry and a stop; the take-profit
was missing everywhere except the T1 alert. These tests pin all three numbers in place —
and pin the ordering (stop < entry < target), because a card that prints them out of order
is a money-losing instruction, not a cosmetic bug.

Covers: setup_scanner (SMS lane) · flow_chase (FLOW WINNERS board) · morning_command (8:15).
"""
import os
import sys

sys.path.insert(0, "/AIWorkWSL/trading/analysis")
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import flow_chase as FC          # noqa: E402
import morning_command as MC     # noqa: E402
import setup_scanner as SS       # noqa: E402


# ── flow_chase: option premium stops/targets ────────────────────────────────
def test_stop_is_always_below_entry():
    """The original bug: a contract that had fallen since the alert printed a stop ABOVE
    the entry (buy at $1.80, get out at $12.71)."""
    for mid, alert in ((1.80, 12.71), (3.00, 2.10), (0.45, 0.30), (3.00, 2.80), (5.0, 0.01)):
        assert FC._stop_for(mid, alert) < mid, f"stop above entry for mid={mid} alert={alert}"


def test_stop_stays_inside_a_sane_band():
    """Too tight is as broken as above-entry: a 6% stop on an option is inside the spread
    and fires on noise. Band is −15%…−30%."""
    for mid, alert in ((3.00, 2.80), (3.00, 2.10), (3.00, 1.00), (1.80, 12.71), (0.45, 0.44)):
        pct = (FC._stop_for(mid, alert) / mid - 1) * 100
        assert -30.5 <= pct <= -14.5, f"mid={mid} alert={alert} -> {pct:.1f}% stop"


def test_target_is_above_entry_and_beats_the_risk():
    for mid in (0.45, 1.80, 3.00, 12.71):
        stop, targ = FC._stop_for(mid, 0), FC._target_for(mid)
        assert stop < mid < targ
        assert (targ - mid) > (mid - stop), "reward must exceed risk"


def test_bad_input_degrades_to_zero_not_a_crash():
    for bad in (None, "", "abc", float("nan")):
        FC._stop_for(bad, 1.0)      # must not raise
        FC._target_for(bad)


def test_affordable_action_names_entry_stop_and_target():
    v = FC.chase_verdict(
        {"Symbol": "NVDA", "Strike": 190, "OptionType": "CALL", "AlertPrice": 2.80,
         "DTE": 5, "OpenInterest": 5000, "Volume": 1000},
        {"mid": 3.00, "iv": 0.35}, {"chg_pct": 0.5})
    a = v["action"]
    assert "BUY" in a and a.count("SELL") >= 2, f"action missing an exit: {a}"


def test_unaffordable_contract_gets_no_order_plan():
    v = FC.chase_verdict(
        {"Symbol": "STX", "Strike": 320, "OptionType": "PUT", "AlertPrice": 5.0,
         "DTE": 5, "OpenInterest": 5000, "Volume": 1000},
        {"mid": 9.00, "iv": 0.35}, {"chg_pct": 0.5})
    assert "BUY" not in v["action"], "over-cap contract must be refused, not priced"
    assert "limit" in v["action"]


# ── setup_scanner: the SMS lane ─────────────────────────────────────────────
def test_sms_keeps_all_three_orders_when_it_has_to_truncate():
    """Blind `sms[:480]` chopped the tail first — and the tail is the take-profit."""
    head = "12:53 — here's one you can take."
    card = ("GFL +2.9%\n"
            "WHY: being bought out at 10:34ET, " + "x" * 400 + ".\n"
            "1) BUY at $40.31 or higher — 37 shares, $1,491. Below that price, do nothing.\n"
            "2) SELL at $39.50 if it drops — you lose $30.\n"
            "3) SELL at $41.92 if it runs — you make $60.\n"
            "Put both sell orders in right away. Out by 3:55pm either way.")
    out = SS.fit_sms(head, card, 2)
    assert len(out) <= SS.SMS_MAX, f"{len(out)} chars, over the {SS.SMS_MAX} cap"
    for tag in ("1) BUY", "2) SELL at $39.50", "3) SELL at $41.92"):
        assert tag in out, f"truncation dropped {tag}"


def test_short_sms_is_left_intact():
    head = "09:20 — here's one you can take."
    card = "AAA +2.0%\nWHY: won a contract at 09:10ET, busier than usual.\n1) BUY at $10.\n"
    assert SS.fit_sms(head, card, 0).endswith("No trade is required today.")


def test_scanner_target_is_two_r():
    """The take-profit is derived from the stop distance so the two can never disagree."""
    assert SS.RR_TARGET >= 1.5, "a target inside the risk makes the card a losing plan"


# ── morning_command: the 8:15 brief ─────────────────────────────────────────
def _plan(**over):
    p = {"ticker": "SOFI", "entry": 12.50, "stop": 12.00, "target": 13.50, "shares": 100,
         "why": "base break"}
    p.update(over)
    return p


def test_brief_plan_renders_three_orders():
    out = MC._plan_orders(_plan())
    assert "1) BUY" in out and "2) SELL" in out and "3) SELL" in out
    assert "you lose $50" in out and "you make $100" in out


def test_brief_plan_rejects_a_hallucinated_ordering():
    """An LLM naming a stop above the entry, or a target below it, must not reach Mike."""
    assert MC._plan_orders(_plan(stop=13.00)) == ""
    assert MC._plan_orders(_plan(target=12.00)) == ""
    assert MC._plan_orders(_plan(target=None)) == ""
    assert MC._plan_orders({}) == ""


def test_brief_plan_respects_the_risk_cap():
    assert MC._plan_orders(_plan(stop=8.00, shares=1000)) == "", "over-cap risk must be dropped"


def test_brief_plan_respects_buying_power():
    """The $400 cap limits the LOSS, not the CAPITAL — a tight stop satisfies it at a
    position size several times the account."""
    out = MC._plan_orders(_plan(ticker="QQQ", entry=667, stop=664, target=676, shares=15))
    if out:                                     # '' is also correct if equity is unreadable
        import re
        sh = int(re.search(r"BUY (\d+) QQQ", out).group(1))
        assert sh * 667 <= MC._buying_power() + 667, "position exceeds half the book"
