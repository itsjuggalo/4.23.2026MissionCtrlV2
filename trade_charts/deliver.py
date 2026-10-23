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
        print(f"  [dry] {channel}: {png}\n{caption}")   # full caption: the dry run IS the render check
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


def album_caption(caps: list[str]) -> str:
    """One compact block per chart that fits Telegram's 1024-char album caption: the chart's first line, then its
    flow alert time and spot (with source + data time) pulled from the caption's source line; full captions stay on
    Discord. Text without those fields keeps its first line only."""
    import re
    out, foot = [], ""
    for c in caps:
        lines = c.strip().split("\n")
        meta = " ".join(lines[1:])
        bits = []
        if (m := re.search(r"latest alert ([^·]+?ET)", meta)):
            bits.append(f"alert {m.group(1).strip()}")
        if (m := re.search(r"spot (\$[\d.,]+ src [^·]+?ET)", meta)):
            bits.append(f"spot {m.group(1).strip()}")
        if (m := re.search(r"chart: ([^·]+)$", meta.strip())):
            foot = f"flow: option-scraper stream · chart: {m.group(1).strip()}"
        out.append(lines[0] + ("\n   " + " · ".join(bits) if bits else ""))
    return "\n".join(out + ([foot] if foot else []))


def post_album_tg(items: list[tuple[str, str]], dry: bool = False) -> bool:
    """Telegram half for a multi-chart run: ONE album on trading_command instead of one photo per chart (alert-flood
    fix 2026-10-22). items = [(png, caption)]; the album caption is every chart's caption, one block each."""
    if not items:
        return False
    cap = album_caption([c.replace("**", "").replace("__", "") for _, c in items])
    if dry:
        print(f"  [dry] telegram album of {len(items)}:\n{cap}")
        return True
    try:
        import tg_fleet
        return tg_fleet.send_album("trading_command", [p for p, _ in items], cap) == 0
    except Exception as e:
        print(f"  telegram album fail: {e}")
        return False
