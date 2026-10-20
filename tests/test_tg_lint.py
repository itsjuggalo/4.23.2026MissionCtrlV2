import sqlite3, time, importlib, sys, os
sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))


def _lint(tmp_path, monkeypatch, rows=()):
    db = tmp_path / "ledger.sqlite"
    con = sqlite3.connect(db)
    con.execute("create table sends (id integer primary key, ts real, day text, fn text, source text, ok integer,"
                " html integer, chars integer, lines integer, head text, text text)")
    for fn, text, age in rows:
        con.execute("insert into sends (ts, day, fn, ok, text) values (?,?,?,1,?)", (time.time() - age, "d", fn, text))
    con.commit(); con.close()
    monkeypatch.setenv("TG_LEDGER_DB", str(db))
    monkeypatch.setenv("TG_LINT_LOG", str(tmp_path / "lint.jsonl"))
    import lib.tg_lint as m
    return importlib.reload(m)


def test_exact_repeat_within_30_min_is_held(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch, [("trading_command", "SPY lean UP", 600)])
    out, notes = m.review("trading_command", "SPY lean UP")
    assert out is None and "repeat" in notes[0]


def test_repeat_after_window_or_other_lane_is_sent(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch, [("trading_command", "SPY lean UP", 3600), ("flow_signals", "X", 60)])
    assert m.review("trading_command", "SPY lean UP")[0] == "SPY lean UP"
    assert m.review("trading_command", "X")[0] == "X"


def test_internal_ids_removed(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    out, _ = m.review("trading_command", "MU 1080C · id MU:DECIPHER:202610061601\nPCRX plan PCRX:SETUP:202610080912 done")
    assert "DECIPHER:" not in out and "SETUP:" not in out and out.startswith("MU 1080C")


def test_broken_render_held_on_trading_lane_only(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    assert m.review("trading_command", "rh-leg-watch SPY <DATE> <PRICE>")[0] is None
    assert m.review("trading_command", "premium $nan")[0] is None
    assert m.review("system_health", "Traceback (most recent call last)")[0] is not None


def test_fail_open(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    monkeypatch.setattr(m, "_recent_identical", lambda *a: 1 / 0)
    assert m.review("trading_command", "hello") == ("hello", [])


# Remedial W4 item 19 (Mike 10-09 #2/#3; plan Q2a): a STALE price line is held; a price with no source/time gets a footer.
def test_stale_price_line_is_held_on_trading_lane(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    out, notes = m.review("flow_signals", "PCRX 25C\nQuote STALE (5 min old): bid $48.00 / ask $49.55")
    assert out is None and "stale price line" in notes[0]


def test_stale_word_without_a_price_is_not_held(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    text = "Quantum EOD 16:05 ET\nTrack record STALE — last graded 09-30"
    assert m.review("trading_command", text)[0] == text


def test_price_without_source_or_time_gets_unverified_footer(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    out, notes = m.review("trading_command", "NVDA $1.2M call flow. Stock at $182.40.")
    assert out.endswith(m.UNVERIFIED) and "unverified" in notes[0]
    for ok in ("NVDA stock $182.40 · src Robinhood 10:02 ET", "SPY $777 PUT — 10:12 AM ET\nNow $0.61",
               "NVDA $1.2M call flow at the $230 strike"):   # sourced / timed / premium + strike only
        assert m.review("trading_command", ok)[0] == ok


def test_non_trading_lane_untouched_by_price_rules(tmp_path, monkeypatch):
    m = _lint(tmp_path, monkeypatch)
    assert m.review("life_wellness", "Rent $1,200 due — STALE $5 reminder")[0] == "Rent $1,200 due — STALE $5 reminder"
