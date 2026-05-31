from pipeline.discord.outcomes_mirror import (
    build_closure_embed,
    build_peak_gain_embed,
    relay_v2_outcomes,
)


def test_winning_closure_uses_green():
    e = {
        "symbol": "TSLA", "strike": 480, "isPut": 0,
        "status": "Profit target reached +85%",
        "shortName": "Tesla call",
    }
    emb = build_closure_embed(e, "OPTION")
    assert "+85%" in emb["title"]
    assert "TSLA 480C" in emb["title"]
    assert emb["color"] == 0x00D2A0


def test_losing_closure_uses_red():
    e = {
        "symbol": "NVDA", "strike": 145, "isPut": 1,
        "status": "Stop loss hit -40%",
    }
    emb = build_closure_embed(e, "OPTION")
    assert emb["color"] == 0xFF4757
    assert "NVDA 145P" in emb["title"]


def test_closure_with_no_pct_computes_from_buy_sell():
    e = {
        "symbol": "SPY", "strike": 500, "isPut": 0,
        "status": "Closed",
        "buyTarget": "2.00", "sellTarget": "3.00",
    }
    emb = build_closure_embed(e, "OPTION")
    assert "+50" in emb["title"]


def test_closure_skipped_when_no_status():
    assert build_closure_embed({"symbol": "X"}, "OPTION") is None


def test_peak_gain_embed_uses_threshold_color():
    alert = {"Symbol": "TSLA", "Strike": 480, "OptionType": "CALL", "Expiry": 1748563200}
    emb_500 = build_peak_gain_embed(alert, 600, 500, 2.0, 14.0)
    assert emb_500["color"] == 0xFFD700
    assert "LEGENDARY" in emb_500["description"]
    emb_100 = build_peak_gain_embed(alert, 150, 100, 2.0, 5.0)
    assert emb_100["color"] == 0xAA00FF


def test_relay_dedups_across_cycles():
    closed_options = {
        "abc": {"symbol": "TSLA", "strike": 480, "isPut": 0,
                "status": "Profit +85%"},
    }

    def read_data(name):
        return {"closed_options": closed_options}.get(name)

    posted = []
    def post(key, embed):
        posted.append((key, embed["title"]))
        return True

    state: dict = {}
    state = relay_v2_outcomes(state, read_data, post)
    assert len(posted) == 1

    # Second cycle: same data, no new posts
    state = relay_v2_outcomes(state, read_data, post)
    assert len(posted) == 1


def test_relay_handles_missing_files_gracefully():
    state: dict = {}
    state = relay_v2_outcomes(state, lambda _: None, lambda _k, _e: True)
    assert state.get("v2_outcomes_sent") in (None, [])
