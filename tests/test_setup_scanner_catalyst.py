"""setup_scanner M&A wording: say what the headline says, never "being bought out" by default.

2026-10-07 Telegram audit. On 10-06 the M&A tag rendered "being bought out" for every symbol
on the headline: SBUX/CMG (a columnist's "might" tie-up, no offer received), UNP (the would-be
BUYER of NSC, contested proposal), VIVK (the buyer, non-binding), PSKY/WBD (merger already
done, story was layoffs). deal_role()/deal_text() now read stage + role from the headline.

The change is DISPLAY ONLY. The last test runs scan() on 10-06 fixtures through both the
current module and the pre-change backup and asserts identical tag/score/direction — proof
that no gate, weight or direction rule moved.
"""
import copy
import importlib.machinery
import importlib.util
import os
import sys
from datetime import datetime, timezone
from pathlib import Path

import pytest

sys.path.insert(0, "/AIWorkWSL/trading/analysis")
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import setup_scanner as SS  # noqa: E402

BACKUP = Path.home() / "backups/setup_scanner.py.202610070216"

# Real 10-06 headlines, exactly as the ledger shows them (scanner truncates to 140 chars).
SBUX_CMG = ("'A Starbucks-Chipotle Tie-up Might Be Crazy Enough To Work; People Close To The "
            "Company Tell Semafor That Chipotle Hasn’t Received A Takeove")
UNP_NSC = "'Union Pacific CEO makes case for $85B Norfolk Southern merger amid pushback' - Fox Business"
VIVK = ("Vivakor Agrees Inks Indication Of Interest To Acquire 100% Of Outstanding Membership "
        "Interests Of Direct Midstream; Financial Terms Not Disc")
PSKY_WBD = "'Skydance CEOs Acknowledge Layoffs Will Be Coming After Paramount-Warner Bros. Merger'- Variety"

CASES = [
    # sym, headline, stage, role, WHY substrings
    ("SBUX", SBUX_CMG, "SPECULATION", "UNCLEAR",
     ["deal talk only, not confirmed", "SBUX", "no offer has been received"]),
    ("CMG", SBUX_CMG, "SPECULATION", "TARGET",
     ["deal talk only, not confirmed", "possible takeover target", "no offer has been received"]),
    ("UNP", UNP_NSC, "PROPOSAL", "ACQUIRER",
     ["UNP is the would-be acquirer", "proposed $85B merger", "Norfolk Southern",
      "proposal, not agreed", "facing pushback"]),
    ("NSC", UNP_NSC, "PROPOSAL", "TARGET",
     ["NSC is the target of Union Pacific's proposed $85B merger", "proposal, not approved"]),
    ("VIVK", VIVK, "PROPOSAL", "ACQUIRER",
     ["VIVK is the would-be acquirer", "Direct Midstream", "non-binding indication of interest"]),
    ("PSKY", PSKY_WBD, "CLOSED", "UNCLEAR",
     ["no new deal for PSKY", "already done", "post-merger layoffs"]),
    ("WBD", PSKY_WBD, "CLOSED", "UNCLEAR",
     ["no new deal for WBD", "already done", "post-merger layoffs"]),
]


@pytest.mark.parametrize("sym,headline,stage,role,_why", CASES)
def test_stage_and_role(sym, headline, stage, role, _why):
    r = SS.deal_role(sym, headline)
    assert (r["stage"], r["role"]) == (stage, role), r


@pytest.mark.parametrize("sym,headline,_stage,_role,why", CASES)
def test_why_text(sym, headline, _stage, _role, why):
    text = SS.deal_text(sym, headline, SS.dollar_size(headline))
    for frag in why:
        assert frag in text, f"{frag!r} missing from {text!r}"
    assert "being bought out" not in text
    # fit_sms keeps only the first sentence of WHY when it squeezes — the caveat must be in it
    assert ". " not in text, text


@pytest.mark.parametrize("headline", [
    "Acme Reportedly Weighs Takeover Of Beta Corp",
    "Beta Corp Shares Jump On Takeover Speculation",
    "Acme Could Explore Merger With Beta, People Familiar Say",
    "Acme Makes $5B Offer For Beta Corp",
    "Acme Proposes Merger With Beta Amid Shareholder Pushback",
    "Beta Corp Rejects Unsolicited Buyout Bid",
    "Traders Circulate Unconfirmed M&A Blog Comments On Beta",
    "Acme Agrees Inks Indication Of Interest To Acquire Beta",
])
def test_speculation_and_proposal_never_say_bought_out(headline):
    r = SS.deal_role("BETA", headline, names=["BETA", "Beta Corp", "Beta"])
    assert r["stage"] in ("SPECULATION", "PROPOSAL"), (headline, r)
    text = SS.deal_text("BETA", headline, names=["BETA", "Beta Corp", "Beta"])
    assert "being bought out" not in text and "agreed to be acquired" not in text
    if r["stage"] == "SPECULATION":
        assert "not confirmed" in text


def test_speculation_is_never_upgraded():
    """'reportedly agrees to acquire' stays SPECULATION — the weaker reading wins."""
    r = SS.deal_role("BETA", "Acme Reportedly Agrees To Acquire Beta Corp", names=["Beta Corp"])
    assert r["stage"] == "SPECULATION"


def test_agreed_target_and_acquirer():
    h = "Beta Corp To Be Acquired By Acme Holdings For $2.1B"
    assert SS.deal_role("BETA", h, names=["Beta Corp"])["role"] == "TARGET"
    assert SS.deal_role("ACME", h, names=["Acme Holdings", "Acme"])["role"] == "ACQUIRER"
    assert SS.deal_role("BETA", h, names=["Beta Corp"])["stage"] == "AGREED"
    t = SS.deal_text("ACME", "Acme Agrees To Acquire Beta Corp For $2B", 2e9, names=["Acme"])
    assert "BUYER" in t and "not the one being bought" in t


def test_bare_ticker_is_case_sensitive():
    """'LW' must not match inside 'flow' — an accidental mention would invent a role."""
    assert SS._mentions(["LW"], "Cash flow merger with Acme") == []


def _setup(sym, headline, gap, last, size=0.0, ts="12:15"):
    pc = last / (1 + gap / 100)
    return {"sym": sym, "tag": "M&A", "headline": headline, "gap": gap, "last": last,
            "prev_high": last, "prev_low": last * 0.98, "prev_close": pc, "volx": 80,
            "size": size, "ts_et": ts, "symp": [], "dir": "LONG",
            "trigger_id": f"{sym}:SETUP:202610061230"}


@pytest.mark.parametrize("sym,headline,_s,_r,why", CASES)
def test_card_renders_deal_text_and_moves_trigger_id(sym, headline, _s, _r, why):
    s = _setup(sym, headline, 1.0, 50.0, SS.dollar_size(headline))
    out = SS.card(s, 400.0)
    why_line = next(ln for ln in out.splitlines() if ln.startswith("WHY:"))
    assert "being bought out" not in out
    assert why[0] in why_line
    assert "SETUP:" not in why_line, "trigger id belongs in the reference footer, not WHY"
    assert s["rest"].endswith(f"id {sym}:SETUP:202610061230")


def test_sms_squeeze_keeps_the_caveat():
    """fit_sms squeezes WHY to its first sentence before dropping anything else; the old
    trailing 'This is a RUMOUR' sentence was the first casualty."""
    s = _setup("CMG", SBUX_CMG, 1.1, 32.12)
    card = "\n".join(ln + " " + "y" * 200 if ln.startswith("WHY:") else ln
                     for ln in SS.card(s, 400.0).splitlines())
    head = "12:30 — here's one you can take."
    assert len(SS.fit_sms(head, card, 1)) <= SS.SMS_MAX
    assert len("\n".join([head, card])) > SS.SMS_MAX, "fixture must force the squeeze"
    sms = SS.fit_sms(head, card, 1)
    assert "y" * 50 not in sms
    assert "WHY: deal talk only, not confirmed" in sms


def test_non_ma_rumour_caveat_leads_the_line():
    s = _setup("AAA", "AAA Reportedly Wins $2B Contract", 2.0, 20.0)
    s["tag"] = "CONTRACT"
    why_line = SS.card(s, 400.0).splitlines()[1]
    assert why_line.startswith("WHY: rumour, not confirmed — won a contract")


# ── no gate change: scan() on 10-06 fixtures, current vs pre-change backup ──────────────
NOW = datetime(2026, 10, 6, 17, 31, tzinfo=timezone.utc)   # 13:31 ET
NEWS = [
    {"headline": VIVK, "symbols": ["VIVK"], "created_at": "2026-10-06T13:01:00Z"},
    {"headline": PSKY_WBD, "symbols": ["PSKY", "WBD"], "created_at": "2026-10-06T15:41:00Z"},
    # the ledger copy is cut at 140 chars mid-"Takeover"; the live feed had the full word
    {"headline": SBUX_CMG + "r Offer", "symbols": ["SBUX", "CMG"],
     "created_at": "2026-10-06T16:15:00Z"},
    {"headline": UNP_NSC, "symbols": ["UNP", "NSC"], "created_at": "2026-10-06T17:03:00Z"},
]
# (last, gap%) as the 10-06 cards printed them; prev high = the printed entry ref
TAPE = {"VIVK": (5.34, 8.9), "PSKY": (9.78, 2.8), "WBD": (30.99, 0.2), "SBUX": (96.05, 1.7),
        "CMG": (32.12, 1.1), "UNP": (277.0, -0.4), "NSC": (316.0, -0.3)}


def _snaps(symbols):
    out = {}
    for s in symbols:
        if s in TAPE:
            last, gap = TAPE[s]
            out[s] = {"latestTrade": {"p": last}, "dailyBar": {"v": 900_000},
                      "prevDailyBar": {"c": last / (1 + gap / 100), "h": last * 1.004,
                                       "l": last * 0.97, "v": 1_000_000}}
    return out


def _run_scan(mod, monkeypatch):
    monkeypatch.setattr(mod, "alpaca_news", lambda *a, **k: copy.deepcopy(NEWS))
    monkeypatch.setattr(mod, "most_actives", lambda *a, **k: ["UNP"])
    monkeypatch.setattr(mod, "snapshots", _snaps)
    monkeypatch.setattr(mod, "btc_candidate", lambda now: None)
    return {s["sym"]: (s["tag"], round(s["score"], 9), round(s["final"], 9), s["dir"])
            for s in mod.scan(now=NOW)}


@pytest.mark.skipif(not BACKUP.exists(), reason="pre-change backup missing")
def test_scores_and_direction_unchanged_vs_backup(monkeypatch):
    loader = importlib.machinery.SourceFileLoader("setup_scanner_orig", str(BACKUP))
    spec = importlib.util.spec_from_loader("setup_scanner_orig", loader)
    orig = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(orig)
    new, old = _run_scan(SS, monkeypatch), _run_scan(orig, monkeypatch)
    assert set(new) == set(TAPE) and new == old
    assert {v[0] for v in new.values()} == {"M&A"}
    # same classification for every fixture headline
    for n in NEWS:
        assert SS.classify(n["headline"]) == orig.classify(n["headline"])
