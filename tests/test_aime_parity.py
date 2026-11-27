"""aime Discord parity (2026-10-22): /levels reads levels.v1 through the intel CLI (R32: no LLM, no web search),
/dossier exists, and /sweeps /odte /winners reuse Telegram's deterministic readers."""
import ast
import re
from pathlib import Path

SRC = (Path(__file__).resolve().parents[1] / "aime_discord_bot.py").read_text()
TREE = ast.parse(SRC)


def _fn(name):
    return next(n for n in ast.walk(TREE) if isinstance(n, (ast.FunctionDef, ast.AsyncFunctionDef)) and n.name == name)


def test_levels_is_levels_v1_not_llm():
    body = ast.get_source_segment(SRC, _fn("levels_cmd"))
    assert '_intel(interaction, "levels"' in body
    assert "_answer_skill" not in body and "web search" not in body.lower()


def test_new_commands_registered():
    for name in ("dossier", "sweeps", "odte", "winners", "levels"):
        assert re.search(rf'@tree\.command\(name="{name}"', SRC), name


def test_html_to_md():
    ns = {"re": re}
    exec(compile(ast.Module([n for n in TREE.body if (isinstance(n, ast.Assign) and any(
        getattr(t, "id", "") == "_TAGS" for t in n.targets)) or (isinstance(n, ast.FunctionDef) and n.name == "_html_to_md")],
        type_ignores=[]), "x", "exec"), ns)
    out = ns["_html_to_md"]('🔪 <b>TSLA</b> · <i>bull</i> &amp; <a href="https://x.y">link</a>')
    assert out == "🔪 **TSLA** · *bull* & link (<https://x.y>)"


def test_telegram_intel_commands_use_the_intel_cli():
    tg = (Path(__file__).resolve().parents[1] / "tg_responder.py").read_text()
    t = ast.parse(tg)
    cmds = next(ast.literal_eval(n.value) for n in t.body if isinstance(n, ast.Assign)
                and any(getattr(x, "id", "") == "INTEL_CMDS" for x in n.targets))
    assert cmds == {"/levels": "levels", "/dossier": "dossier", "/intel": "intel", "/gex": "gex", "/oi": "oi", "/iv": "iv"}
    trading = next(ast.literal_eval(n.value) for n in t.body if isinstance(n, ast.Assign)
                   and any(getattr(x, "id", "") == "TRADING_CMDS" for x in n.targets))
    assert set(cmds) <= trading                     # the astrology lane refuses them
    assert '"pipeline.intel.query"' in tg


def test_voloi_command_runs_the_voloi_module_without_llm():
    """Mike 2026-11-25: /voloi <ticker> = pipeline.intel.voloi (Robinhood + OCC + flow.db), deterministic, in /help."""
    i = SRC.index('@tree.command(name="voloi"')
    body = SRC[i:SRC.index("@tree.command", i + 10)]
    assert '"pipeline.intel.voloi"' in body and "_run_intel" in body and "llm" not in body.lower()
    assert '"--max-dte", "0"' in body and "`/voloi <t>`" in SRC
    assert SRC.count('@tree.command(name="voloi"') == 1


def test_analyze_command_posts_pack_then_one_message_per_model_then_tally():
    """Mike 2026-11-27: /analyze <ticker> = pipeline.intel.analyze pack, one message per AI lane, tally; in /help."""
    i = SRC.index('@tree.command(name="analyze"')
    body = SRC[i:SRC.index("@tree.command", i + 10)]
    assert SRC.count('@tree.command(name="analyze"') == 1 and 'ANALYZE_LANES = ("claude", "codex", "rallies")' in SRC
    assert '"pipeline.intel.analyze"' in body and '[ticker, "--pack"]' in body and 'startswith("PACK_DIR ")' in body
    assert '["--lane", name, "--dir", pack_dir]' in body and "asyncio.as_completed" in body      # each lane its own message
    assert '["--tally", "--dir", pack_dir]' in body and body.index("--lane") < body.index("--tally")
    assert "_run_skill" not in body and "_answer_skill" not in body       # no model call hidden in the bot: lanes are named
    assert "`/analyze <t>`" in SRC
