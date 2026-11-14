"""Image cards for Synth Control slash replies (Mike 2026-11-14): the renderer's output and the bot's card-or-text gate.
Offline: no Discord connection, no LLM, no network. The bot module is imported, never run."""
import asyncio
import importlib.util
import sys
from pathlib import Path

from PIL import Image

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "trade_charts"))
sys.path.insert(0, str(ROOT))
import text_card  # noqa: E402
import text_card_parse  # noqa: E402

REPLY = """**NVDA flow** · since Fri 11/13 ET · 3 prints
**Biggest**
• NVDA $160C 11/16/26 · $1.2M · SWEEP ask · vol 5,158 / OI 3,444 · 11/13 15:19 ET [FG LiveFlows → #flow-huge]
• NVDA $150P 11/20/26 · $900K · BLOCK bid · vol 810 / OI 18,963 · 11/13 15:18 ET [FG LiveFlows → #flow-huge]
Docs: https://example.com/flow and a cut-off one https://signal8)
"""


def test_render_writes_png_and_keeps_only_whole_links(tmp_path):
    r = text_card.render_cards("/flow NVDA", REPLY, out_dir=tmp_path)
    assert len(r["pngs"]) == 1 and Path(r["pngs"][0]).parent == tmp_path
    with Image.open(r["pngs"][0]) as im:
        assert im.width == 1800 and im.height > 300
    assert r["links"] == ["https://example.com/flow"]


def test_flow_prints_become_a_table():
    _title, _meta, blocks = text_card_parse.parse("/flow NVDA", REPLY)
    dump = repr(blocks)
    assert "Contract" in dump and "Premium" in dump and "NVDA $160C 11/16/26" in dump


def _bot():
    spec = importlib.util.spec_from_file_location("aime_bot_cards", ROOT / "aime_discord_bot.py")
    bot = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(bot)
    return bot


class _Rec:
    def __init__(self):
        self.files, self.texts = [], []

    async def send(self, content=None, file=None, **_k):
        if file is not None:
            self.files.append(Path(file.fp.name).name)
            file.close()
        else:
            self.texts.append(content)


class _I:
    def __init__(self, command, ns=()):
        self.command, self.namespace, self.followup = command, list(ns), _Rec()


def test_bot_sends_cards_for_slash_commands_and_text_otherwise(tmp_path, monkeypatch):
    bot = _bot()
    real = text_card.render_cards
    monkeypatch.setattr(bot, "_render_cards", lambda label, text: real(label, text, out_dir=tmp_path))
    cmd = bot.tree.get_command("flow")

    it = _I(cmd, [("ticker", "NVDA"), ("days", None)])
    assert bot._card_label(it) == "/flow NVDA"
    asyncio.run(bot._send_lines(it, REPLY))
    assert len(it.followup.files) == 1 and it.followup.texts == []          # slash command -> card, no text

    it = _I(None)                                                           # button / right-click menu -> text
    asyncio.run(bot._send_lines(it, REPLY))
    assert it.followup.files == [] and it.followup.texts

    it = _I(cmd)                                                            # one-line error -> text
    asyncio.run(bot._send_chunks(it, "[skill error rc=1] llm-route: codex failed"))
    assert it.followup.files == [] and it.followup.texts == ["[skill error rc=1] llm-route: codex failed"]

    def boom(_label, _text):
        raise RuntimeError("forced")
    monkeypatch.setattr(bot, "_render_cards", boom)                         # render failure -> the full text reply
    it = _I(cmd)
    asyncio.run(bot._send_lines(it, REPLY))
    assert it.followup.files == [] and "NVDA $160C" in "".join(it.followup.texts)

    monkeypatch.setattr(bot, "CARDS_ON", False)                             # SYNTH_CARDS=0
    assert bot._card_label(_I(cmd)) is None
    monkeypatch.setattr(bot, "CARDS_ON", True)
    monkeypatch.setattr(bot, "CARDS_OFF", {"flow"})                         # SYNTH_CARDS_OFF=flow
    assert bot._card_label(_I(cmd)) is None
