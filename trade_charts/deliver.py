#!/usr/bin/env python3
"""
deliver.py — dual-post a chart PNG to BOTH Discord (SynthControl bot) and Telegram
(trading_command chat, as an inline photo). Shared by every trade_charts generator.
"""
import os, sys, subprocess
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent))  # 05_AUTOMATION/scripts
from lib import ops_card as oc            # noqa: E402
from skill_to_discord import GUILD         # noqa: E402

SYNTH_TOKEN = (Path.home() / ".openclaw/secrets/discord_synthcontrol_token").read_text().strip()
TG_SEND = str(Path.home() / "bin/tg-send-media")


def post_chart(channel: str, png: str, caption: str, tg: bool = True, dry: bool = False) -> tuple[bool, bool]:
    """Returns (discord_ok, telegram_ok)."""
    if dry:
        print(f"  [dry] {channel}: {png} :: {caption[:80]}")
        return True, True
    # Discord
    dok = False
    try:
        cid = oc.resolve_channel(GUILD, SYNTH_TOKEN, channel)
        if cid:
            dok = bool(oc.post_image_bot(cid, SYNTH_TOKEN, png, content=caption))
    except Exception as e:
        print(f"  discord fail: {e}")
    # Telegram (inline photo, trading chat) — strip Discord markdown
    tok = False
    if tg:
        cap = caption.replace("**", "").replace("__", "")
        try:
            env = dict(os.environ, TG_FN="trading_command")
            r = subprocess.run([TG_SEND, png, cap], env=env, capture_output=True, text=True, timeout=60)
            tok = (r.returncode == 0) and ("sent" in (r.stdout + r.stderr))
        except Exception as e:
            print(f"  telegram fail: {e}")
    return dok, tok
