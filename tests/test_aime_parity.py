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
