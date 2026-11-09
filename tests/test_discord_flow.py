"""lib/discord_flow: parse the option-relay's Discord cards, dedupe batch re-posts, filter, render (no network)."""
from datetime import date, datetime, timezone

from lib import discord_flow as D

BATCH = {"id": "1", "timestamp": "2026-11-09T19:50:34+00:00", "content": "", "embeds": [{
    "title": "🚨 Huge Flow  ·  2 signals  ·  7:50:34 PM UTC",
    "description": "⬜📈 **TEM** `$95c` Jan21  ·  $635.0K SWEEP ask  ·  @`$0`\n"
                   "🟡📉 **SPXW** `$7520.0p` Nov18  ·  $22.43M BLOCK bid  ·  @`$0.0`"}]}
REPOST = {"id": "2", "timestamp": "2026-11-09T19:51:14+00:00", "content": "", "embeds": [{
    "title": "🚨 Huge Flow  ·  1 signal", "description": "⬜📈 **TEM** `$95.0c` Jan21  ·  $635.0K SWEEP ask  ·  @`$0.0`"}]}
SINGLE = {"id": "3", "timestamp": "2026-11-09T19:46:57+00:00", "content": "", "embeds": [{
    "title": "🔴 NVDA $215.0P 01/15/27",
    "description": "Flow Premium **$6.57M** • Size / OI 1646 / 28074 • Sweeps / Blocks 5 / 4 • Alerted Price $40.5\nDTE 67"}]}
FCM = {"id": "5", "timestamp": "2026-11-09T19:40:00+00:00", "content": "", "embeds": [{
    "title": "AMD PUT 📉 $200 exp 01/15/27", "description": "**HIGH FLOW** · 🔴 BEAR",
    "fields": [{"name": "Total Flow Value", "value": "$1.25M"}, {"name": "Sweeps/Blocks", "value": "3 / 1"},
               {"name": "OI / Volume", "value": "1,500 / 900"}, {"name": "Feed", "value": "FG"}]}]}
FCM_ZERO = {"id": "6", "timestamp": "2026-11-09T19:41:00+00:00", "content": "", "embeds": [{
    "title": "AMD PUT 📉 $200 exp 01/15/27", "description": "**HIGH FLOW** · 🔴 BEAR",
    "fields": [{"name": "Total Flow Value", "value": "$0"}]}]}
NEWS = {"id": "4", "timestamp": "2026-11-09T19:00:00+00:00",
        "content": "<t:1794250463:t> - **NVDA Stock Price Prediction: holds above trend**", "embeds": []}


def _tag(sigs, chan="flow-huge"):
    for s in sigs:
        s["chan"] = chan
    return sigs


def test_parse_premium():
    assert D.parse_premium("$632.5K") == 632_500
    assert D.parse_premium("1.5m") == 1_500_000
    assert D.parse_premium("250,000") == 250_000
    assert D.parse_premium("2B") == 2e9
    assert D.parse_premium("abc") is None and D.parse_premium("") is None and D.parse_premium(None) is None


def test_parse_batch_and_single_cards():
    b = D.parse_message(BATCH)
    # batch 📈/📉 is CALL/PUT, not a direction; the leading dot is the FlowGreeks COLOR
    assert [(s["sym"], s["strike"], s["cp"], s["exp"], s["premium"], s["kind"], s["side"], s["dir"], s["color"], s["src"])
            for s in b] == [
        ("TEM", "95", "C", "Jan21", 635_000, "SWEEP", "ask", None, "white", "fcm batch"),
        ("SPXW", "7520", "P", "Nov18", 22_430_000, "BLOCK", "bid", None, "yellow", "fcm batch")]
    (s,) = D.parse_message(SINGLE)
    assert (s["sym"], s["strike"], s["cp"], s["premium"], s["size"], s["oi"], s["sweeps"], s["dir"]) == (
        "NVDA", "215", "P", 6_570_000, 1646, 28074, 5, "bear")
    assert s["ts"].tzinfo is not None and s["ts"].hour == 14   # 19:46 UTC = 14:46 ET
    assert s["src"] == "relay card"
    assert D.parse_message(NEWS) == []
    (f,) = D.parse_message(FCM)
    assert (f["sym"], f["strike"], f["cp"], f["exp"], f["premium"], f["dir"], f["alert_type"], f["size"], f["oi"],
            f["sweeps"], f["blocks"], f["src"]) == ("AMD", "200", "P", "01/15/27", 1_250_000, "bear", "high_flow",
                                                   900, 1500, 3, 1, "fcm card")
    assert D.parse_message(FCM_ZERO) == []                    # broken $0 cards are skipped
    assert [c["view"] for c in D.parse_cards({**BATCH, "embeds": BATCH["embeds"] + FCM["embeds"]})] == ["bear"]


def test_dedupe_drops_batch_reposts_only():
    sigs = _tag(D.parse_message(BATCH) + D.parse_message(REPOST))
    assert len(sigs) == 3 and len(D.dedupe(sigs)) == 2
    other = _tag(D.parse_message(REPOST), "flow-live")       # same signal in another channel is kept
    assert len(D.dedupe(sigs + other)) == 3


def test_filter_ticker_premium_type():
    sigs = _tag(D.parse_message(BATCH) + D.parse_message(SINGLE))
    assert [s["sym"] for s in D.filt(sigs, ticker="nvda")] == ["NVDA"]
    assert {s["sym"] for s in D.filt(sigs, lo=1e6)} == {"SPXW", "NVDA"}
    assert [s["sym"] for s in D.filt(sigs, lo=1e6, hi=10e6)] == ["NVDA"]
    assert [s["sym"] for s in D.filt(sigs, cp="C")] == ["TEM"]


def test_window_rolls_back_over_weekends():
    assert D.start_of_window(1, date(2026, 11, 9)).date() == date(2026, 11, 9)    # Monday
    assert D.start_of_window(1, date(2026, 11, 8)).date() == date(2026, 11, 6)    # Sunday -> Friday
    assert D.start_of_window(2, date(2026, 11, 9)).date() == date(2026, 11, 6)    # Mon + previous weekday


def test_mentions_fallback_and_render():
    assert D.mentions(NEWS, "NVDA") and D.mentions(NEWS, "NVDA").startswith("13:54 - ")
    assert D.mentions(NEWS, "NVD") is None                     # whole-symbol match only
    since = datetime(2026, 11, 9, tzinfo=timezone.utc)
    out = D.render(_tag(D.parse_message(BATCH)), label="huge", since=since, ticker=None, lo=500_000, hi=None,
                   scanned=1, capped=[], unparsed=0)
    assert "huge flow" in out and "SPXW $7520P Nov18" in out and "$22.43M" in out and "premium $500K–any" in out
    empty = D.render([], label="#news", since=since, ticker="NVDA", lo=None, hi=None, scanned=1, capped=["#x"],
                     unparsed=1, notes=[(since, "news", "NVDA headline")])
    assert "No flow signals matched" in empty and "NVDA headline" in empty and "stopped at" in empty
