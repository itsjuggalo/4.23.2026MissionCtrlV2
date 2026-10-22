"""MC-AUD-084/088 lane split (Mike GO 2026-10-22): pinned numeric bot ids, no bot mixing trading with
another kind, dry-run renders, and bot_id stamped on every ledger row. Hermetic: fake tokens only."""
import importlib, json, os, sqlite3, sys
sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))
import tg_fleet as F


def _fake_tokens(monkeypatch, override=None):
    """token(fn) → '<pin>:x' (a fake with the right prefix), or the override for one lane."""
    override = override or {}
    monkeypatch.setattr(F, "token", lambda fn: override.get(fn, f"{F.BOT_ID[fn]}:x" if F.BOT_ID.get(fn) else None))


def test_every_lane_is_pinned_and_kinded():
    for fn in F.FLEET:
        assert fn in F.KIND, fn
        if fn != "laptop_control":            # reserved slot, no bot yet
            assert isinstance(F.BOT_ID.get(fn), int), fn


def test_no_bot_mixes_trading_with_another_kind():
    by_bot = {}
    for fn in F.FLEET:
        by_bot.setdefault(F.BOT_ID.get(fn), set()).add(F.KIND[fn])
    mixed = {b: k for b, k in by_bot.items() if "trading" in k and len(k) > 1}
    assert not mixed, mixed


def test_moved_lanes_left_their_old_bots():
    assert F.BOT_ID["screener"] == 8520537147 and F.BOT_ID["trend_scanner"] == 8519775882
    for fn, olds in F.MOVED.items():
        for o in olds:
            assert o["bot_id"] != F.BOT_ID[fn]
            # the old bot carries no trading lane any more (ClaudeClaw OS / WinMeals)
            assert all(F.KIND[f] != "trading" for f in F.FLEET if F.BOT_ID.get(f) == o["bot_id"]), fn
    assert [f for f in F.FLEET if F.BOT_ID.get(f) == 8950043596] == ["winmeals"]
    assert "media_gens" not in F.FLEET


def test_lanes_ok_then_flags_a_mix_and_a_wrong_token(monkeypatch):
    _fake_tokens(monkeypatch)
    out = []
    assert F.lanes(out.append) == [] and out[-1].startswith("OK")
    monkeypatch.setitem(F.KIND, "trend_scanner", "app")          # a non-trading lane on a trading bot
    _fake_tokens(monkeypatch, {"screener": "8442367980:x"})       # the old ClaudeClaw OS token
    problems = F.lanes(lambda *_: None)
    assert any("mixes" in p and "8519775882" in p for p in problems)
    assert any(p.startswith("screener: token is bot 8442367980") for p in problems)


def test_pinned_token_refuses_another_bot(monkeypatch, capsys):
    _fake_tokens(monkeypatch, {"screener": "8442367980:secret"})
    assert F.pinned_token("screener") is None
    err = capsys.readouterr().err
    assert "refused" in err and "secret" not in err
    assert F.pinned_token("winmeals") == "8950043596:x"


def test_set_token_refuses_wrong_id_before_any_network(monkeypatch, capsys):
    monkeypatch.setattr(F, "_getme", lambda t: (_ for _ in ()).throw(AssertionError("network")))
    monkeypatch.setattr(F, "_vault", lambda: (_ for _ in ()).throw(AssertionError("vault write")))
    F.set_token("trend_scanner", "8950043596:abc")
    assert "not stored" in capsys.readouterr().out


def test_dry_run_renders_lane_and_bot_without_sending(monkeypatch, capsys):
    _fake_tokens(monkeypatch)
    monkeypatch.setenv("TG_DRY_RUN", "1")
    monkeypatch.setattr(F, "_ledger", lambda *a, **k: (_ for _ in ()).throw(AssertionError("recorded")))
    import urllib.request
    monkeypatch.setattr(urllib.request, "urlopen", lambda *a, **k: (_ for _ in ()).throw(AssertionError("sent")))
    assert F.send("life_wellness", "🟣 Discord DM from x: hi") == 0
    assert F.send_upload("screener", __file__, "📈 TA — SPY") == 0
    out = capsys.readouterr().out
    assert "DRY life_wellness → bot 8625099101 @LifeClaw727_Bot (personal)" in out
    assert "DRY screener → bot 8520537147 @JazzyHazzyTelegram_Bot (trading)" in out


def test_lint_non_trading_covers_every_chat_lane_that_is_not_trading():
    import lib.tg_lint as L
    chat = {fn for fn in F.FLEET if F.KIND[fn] in ("ops", "personal", "app")}
    assert chat <= L.NON_TRADING


def test_ledger_stamps_the_pinned_bot_id(tmp_path, monkeypatch):
    db, man = tmp_path / "ledger.sqlite", tmp_path / "fleet.json"
    con = sqlite3.connect(db)              # a pre-2026-10-22 ledger (no bot_id column) is migrated in place
    con.execute("create table sends (id integer primary key, ts real not null, day text not null, fn text, source text,"
                " ok integer, html integer, chars integer, lines integer, head text, text text)")
    con.commit(); con.close()
    man.write_text(json.dumps({"screener": {"bot_id": 8520537147}}))
    monkeypatch.setenv("TG_LEDGER_DB", str(db))
    monkeypatch.setenv("TG_FLEET_MANIFEST", str(man))
    import lib.tg_ledger as G
    G = importlib.reload(G)
    G.record("screener", "📈 TA — SPY", True, src="ta_chart.py")
    G.record("unknown_lane", "x", True, src="t")
    rows = sqlite3.connect(db).execute("select fn, bot_id from sends order by id").fetchall()
    assert rows == [("screener", 8520537147), ("unknown_lane", None)]


def test_boba_desk_has_its_own_unused_bot():
    """Mike 2026-10-22: Boba's Q&A lane on a bot nothing else polls or sends through (not @Boba2: lane-bots polls it)."""
    assert F.BOT_ID["boba_desk"] == 8637552667 and F.KIND["boba_desk"] == "trading"
    assert F.FLEET["boba_desk"]["role"] == "interactive"
    assert [f for f in F.FLEET if F.BOT_ID.get(f) == 8637552667] == ["boba_desk"]
    assert "hermes_relay" not in F.FLEET and F.BOT_ID["boba_desk"] != F.BOT_ID["trading_digest"]
