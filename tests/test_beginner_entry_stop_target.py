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
    # T9 item 9: levels are reference levels (evidence), never BUY/SELL commands.
    assert "entry ref" in a and "stop ref" in a and "target ref" in a, f"action missing a level: {a}"
    assert "BUY" not in a and "SELL" not in a, f"trade-call wording leaked: {a}"


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


# ── Bitcoin (added 2026-07-29) ──────────────────────────────────────────────
def _btc(**over):
    s = dict(sym="BTC", is_crypto=True, size=0.0, volx=161.5, ts_et="09:14", tag="ETF-IN",
             dir="LONG", gap=2.4, last=64010.85, prev_high=64662.51, prev_low=63489.55,
             prev_close=63846.55, headline="Bitcoin ETFs approach $1B in 7-session inflow run")
    s.update(over)
    return s


def test_btc_card_is_priced_in_fractions_not_shares():
    """A whole coin is $64k — integer sizing would floor to 0 and skip BTC forever."""
    s = _btc()
    out = SS.card(s, 285.0)
    assert "BTC," in out and "shares" not in out
    assert 0 < s["shares"] < 1, f"expected a fraction of a coin, got {s['shares']}"


def test_btc_has_all_three_prices_correctly_ordered():
    s = _btc()
    out = SS.card(s, 285.0)
    assert "1) Entry ref" in out and "2) Stop ref" in out and "3) Target ref" in out
    assert s["stop"] < s["trig"] < s["target"]


def test_btc_uses_the_wider_stop():
    """2% sits inside Bitcoin's ordinary daily range and gets hit for no reason."""
    s = _btc()
    SS.card(s, 285.0)
    pct = 1 - s["stop"] / s["trig"]
    assert abs(pct - SS.BTC_STOP_PCT) < 1e-6, f"BTC stop is {pct:.3%}, expected 3%"


def test_btc_card_never_says_the_market_closes():
    """Crypto trades 24/7 — 'out by 3:55pm' would make a beginner exit for no reason."""
    out = SS.card(_btc(), 285.0)
    assert "3:55" not in out
    assert "never closes" in out


def test_btc_short_never_tells_a_beginner_to_short_spot():
    """Superseded 2026-07-29 (Mike: "should we include moments where we should be buying an
    inverse btc on robinhood?"). This used to assert a flat SKIP. A bearish BTC read is now
    actionable via the inverse ETF — but it must STILL never imply shorting spot BTC, which
    a normal Robinhood account cannot do."""
    out = SS.card(_btc(tag="ETF-OUT", dir="SHORT", gap=-2.4), 285.0)
    assert "1) Entry ref BTC" not in out and "BTC," not in out, "must not size a spot BTC short"
    assert ("SKIP" in out) or (SS.INVERSE_BTC in out), \
        "a bearish read is either refused or routed to the inverse ETF — never left dangling"


def test_btc_sms_fits_with_six_figure_prices():
    """$64,662.51 is 4 chars longer than a stock price — the cap has to survive it."""
    s = _btc()
    out = SS.fit_sms("09:20 — here's one you can take.", SS.card(s, 285.0), 2)
    assert len(out) <= SS.SMS_MAX
    for tag in ("1) Entry ref", "2) Stop ref", "3) Target ref"):
        assert tag in out


def test_crypto_classifier_does_not_invert_etf_flows():
    """'snap inflow streak with $225M in outflows' scored BULLISH — it's an outflow."""
    assert SS.classify_crypto("Bitcoin ETFs snap 7-day inflow streak with $225M in outflows")[1] == "ETF-OUT"
    assert SS.classify_crypto("Bitcoin ETFs extend outflow streak as BTC fails to hold $65K")[1] == "ETF-OUT"
    assert SS.classify_crypto("Bitcoin ETFs approach $1B in 7-session inflow run")[1] == "ETF-IN"
    assert SS.classify_crypto("Bitcoin ETF outflows slow as buyers return")[1] is None


def test_crypto_classifier_rejects_commentary():
    """Explainers and digests carry every keyword and no event."""
    for h in ("Crypto Long & Short: What this year's $972M crypto hacks tell us",
              "3 reasons Wednesday's Fed meeting is pivotal for BTC",
              "CLARITY hopes fade, BitMEX shuts as lawsuit looms: Hodler's Digest",
              "Bitcoin, Ethereum Face Crucial Monthly Close: These Are the Levels to Watch"):
        assert SS.classify_crypto(h)[1] is None, f"commentary classified as news: {h}"


def test_crypto_classifier_reads_enforcement_ending_as_bullish():
    assert SS.classify_crypto("SEC drops lawsuit against Bitcoin miner")[1] == "REG+"
    assert SS.classify_crypto("SEC sues Bitcoin exchange over unregistered sales")[1] == "REG-"


def test_every_crypto_tag_has_plain_english_and_a_bias():
    """A tag with no CRYPTO_EN entry prints its raw code at Mike; one with no bias entry
    silently defaults to direction-agnostic."""
    tags = {t for _, _, t in SS.CRYPTO_CATALYSTS}
    assert tags <= set(SS.CRYPTO_EN), f"no plain English for {tags - set(SS.CRYPTO_EN)}"
    assert tags <= set(SS.CRYPTO_BIAS), f"no bias set for {tags - set(SS.CRYPTO_BIAS)}"


def test_btc_skips_the_equity_chart_check():
    """Yahoo's 'BTC' is the Grayscale Bitcoin Mini Trust ETF, not bitcoin."""
    import inspect
    src = inspect.getsource(SS.main)
    assert 'is_crypto' in src and 'struct' in src, "crypto must bypass explosion_score"


def test_crypto_only_scan_makes_no_equity_calls():
    """The weekend cron must not touch the stock endpoints — with the market shut, Alpaca
    still serves Friday's closing prints and scanning them manufactures stale setups."""
    called = []
    orig_news, orig_actives = SS.alpaca_news, SS.most_actives
    orig_cand, orig_snap = SS.btc_candidate, SS.btc_snapshot
    try:
        SS.alpaca_news = lambda *a, **k: called.append("news") or []
        SS.most_actives = lambda *a, **k: called.append("actives") or []
        SS.btc_candidate = lambda now: None      # no catalyst → empty, but no equity calls
        SS.btc_snapshot = lambda: {}
        SS.scan(crypto_only=True)
    finally:
        SS.alpaca_news, SS.most_actives = orig_news, orig_actives
        SS.btc_candidate, SS.btc_snapshot = orig_cand, orig_snap
    assert called == [], f"crypto-only run hit the equity endpoints: {called}"


def test_btc_survives_the_empty_equity_candidates_guard():
    """`if not cands: return []` used to fire before BTC was injected, so a crypto-only
    run could never produce a setup at all."""
    orig_news, orig_actives = SS.alpaca_news, SS.most_actives
    orig_cand, orig_snap = SS.btc_candidate, SS.btc_snapshot
    try:
        SS.alpaca_news = lambda *a, **k: []
        SS.most_actives = lambda *a, **k: []
        SS.btc_candidate = lambda now: dict(
            sym="BTC", score=9.0, tag="ETF-IN", w=9, size=0.0, age_h=1.2,
            headline="Bitcoin ETFs approach $1B in 7-session inflow run",
            ts_et="09:14", is_crypto=True, source="Cointelegraph")
        SS.btc_snapshot = lambda: {
            "latestTrade": {"p": 65400.0}, "dailyBar": {"v": 3.0},
            "prevDailyBar": {"c": 63846.55, "h": 64662.51, "l": 63489.55, "v": 1.16}}
        out = SS.scan(crypto_only=True)
    finally:
        SS.alpaca_news, SS.most_actives = orig_news, orig_actives
        SS.btc_candidate, SS.btc_snapshot = orig_cand, orig_snap
    assert [s["sym"] for s in out] == ["BTC"], f"expected a BTC setup, got {out}"


def _short_btc():
    return _btc(tag="ETF-OUT", dir="SHORT", gap=-2.4, last=62800.0,
                headline="Bitcoin ETFs extend outflow streak as BTC fails to hold $65K")


def test_bearish_btc_offers_the_inverse_etf_not_a_shrug():
    """You can't short spot BTC on Robinhood, so a bearish read used to dead-end in
    'sit it out'. It should name the instrument that DOES work there."""
    s = _short_btc()
    out = SS.card(s, 285.0)
    if "SKIP" in out:                       # acceptable only when BITI can't be priced
        return
    assert SS.INVERSE_BTC in out
    assert "1) Entry ref" in out and "2) Stop ref" in out and "3) Target ref" in out
    assert s.get("takeable"), "a priced inverse plan must count as takeable"


def test_inverse_card_always_carries_the_time_stop():
    """BITI resets daily: it tracks for ~a week then bleeds. Measured over 6 months it
    returned +12.4% on a −27.7% BTC move. The time stop is what makes it valid at all."""
    out = SS.card(_short_btc(), 285.0)
    if "SKIP" in out:
        return
    assert "trading days" in out, "inverse plan shipped with no holding limit"
    assert SS.INVERSE_MAX_DAYS <= 10, "a limit past ~a week reintroduces the decay"


def test_inverse_plan_prices_are_ordered_and_capped():
    s = _short_btc()
    lines, rest = SS.inverse_btc_plan(62800.0, 285.0, 1500.0)
    if lines is None:
        return
    import re
    px = float(re.search(r"Entry ref BITI \$([\d.]+)", "\n".join(lines)).group(1))
    stop = float(re.search(r"2\) Stop ref \$([\d.]+)", "\n".join(lines)).group(1))
    targ = float(re.search(r"3\) Target ref \$([\d.]+)", "\n".join(lines)).group(1))
    assert stop < px < targ, f"{stop} / {px} / {targ} out of order"
    loss = float(re.search(r"risk \$(\d+)", "\n".join(lines)).group(1))
    assert loss <= 285.0, f"risk ${loss} exceeds the cap"


def test_inverse_plan_degrades_when_unpriceable():
    """No quote must mean 'sit it out', never a made-up entry."""
    orig = SS.snapshots
    try:
        SS.snapshots = lambda syms: {}
        lines, rest = SS.inverse_btc_plan(62800.0, 285.0, 1500.0)
    finally:
        SS.snapshots = orig
    assert lines is None and rest is None


def test_sms_never_cuts_a_line_in_half():
    """A hard [:480] once ended the text mid-sentence, on the clause explaining why the
    position has a deadline. Drop whole lines instead."""
    head = "09:20 — here's one you can take."
    card = ("BTC -2.4%\n"
            "WHY: " + "w" * 120 + ".\n"
            "1) BUY BITI at $25.38 or better — 58 shares, $1,472.\n"
            "2) SELL at $24.62 if Bitcoin bounces — you lose $44.\n"
            "3) SELL at $26.90 if it works — you make $88.\n"
            "Sell within 5 trading days no matter what — " + "x" * 200 + ".")
    out = SS.fit_sms(head, card, 2)
    assert len(out) <= SS.SMS_MAX
    for line in out.split("\n"):
        assert not line.endswith("x"), "a line was truncated mid-word"
    for t in ("1) BUY", "2) SELL", "3) SELL"):
        assert t in out


def test_a_fractional_btc_card_counts_as_takeable():
    """The header test was `shares >= 1`, false for every BTC card by definition — a good
    Bitcoin setup got 'nothing you can take right now' printed above its own buy order."""
    s = _btc()
    SS.card(s, 285.0)
    assert str(s.get("rest", "")).startswith("buy-stop"), \
        "card() must mark a takeable fractional setup the same way it marks a stock"


# ── morning_command: the 8:15 brief ─────────────────────────────────────────
def _plan(**over):
    p = {"ticker": "SOFI", "entry": 12.50, "stop": 12.00, "target": 13.50, "shares": 100,
         "why": "base break"}
    p.update(over)
    return p


def test_brief_plan_renders_three_reference_levels():
    # T9 item 9: entry/stop/target survive as reference levels, not numbered BUY/SELL orders.
    out = MC._plan_orders(_plan())
    assert "entry ref $12.5" in out and "stop ref $12" in out and "target ref $13.5" in out
    assert "risk $50" in out and "reward $100" in out
    assert "1) BUY" not in out and "SELL" not in out


def test_brief_plan_rejects_a_hallucinated_ordering():
    """An LLM naming a stop above the entry, or a target below it, must not reach Mike."""
    assert MC._plan_orders(_plan(stop=13.00)) == ""
    assert MC._plan_orders(_plan(target=12.00)) == ""
    assert MC._plan_orders(_plan(target=None)) == ""
    assert MC._plan_orders({}) == ""


def test_brief_plan_respects_the_risk_cap():
    assert MC._plan_orders(_plan(stop=8.00, shares=1000)) == "", "over-cap risk must be dropped"


def test_brief_plan_no_longer_clamps_by_buying_power():
    """2026-09-15: the equity-derived 'half the book' notional clamp was retired with
    the portfolio-view doctrine (2026-09-12) — no live holdings feed exists to derive
    a buying-power ceiling from. The flat $400 RISK cap (loss, not notional) is the
    only sizing rule now, so a plan inside the risk cap keeps its full share count
    even though the notional (15 QQQ = $10,005) is several times a small book."""
    import re
    out = MC._plan_orders(_plan(ticker="QQQ", entry=667, stop=664, target=676, shares=15))
    assert out, "a plan within the $400 risk cap should render"
    sh = int(re.search(r"size ref (\d+) sh", out).group(1))
    assert sh == 15, f"share count must not be clamped by a retired buying-power check, got {sh}"
