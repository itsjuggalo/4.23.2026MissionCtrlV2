#!/usr/bin/env python3
"""command_center.py — ONE live, edit-in-place desk dashboard per channel.

Instead of re-posting a fresh status every cycle (chat spam), this keeps a single
pinned embed and PATCHes it each run: regime + tape + live portfolio P&L + muted
names + an ET timestamp. Posts AS SynthControl (the aime-discord app — it can edit
its own message) into #command-center, created + pinned on first run. Cron every
~2 min in market hours. Edit-in-place = instant + cheap (no image render).

  command_center.py            # refresh (create+pin first run, edit thereafter)
  command_center.py --print    # print the embed payload only, don't post
  command_center.py --channel command-center
"""
from __future__ import annotations

import argparse
import json
import sys
import time
from datetime import datetime
from zoneinfo import ZoneInfo
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from lib import ops_card as oc            # noqa: E402
from lib import regime as regime_lib      # noqa: E402
from lib import card_mute                 # noqa: E402
from lib.portfolio import portfolio_summary  # noqa: E402

ET = ZoneInfo("America/New_York")
GUILD = "1486025777970548908"
SYNTH_TOKEN = (Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token").read_text().strip()
STATE = Path.home() / ".openclaw" / "state" / "command_center.json"


def _load_state() -> dict:
    try:
        return json.loads(STATE.read_text())
    except Exception:
        return {}


def _save_state(d: dict) -> None:
    try:
        STATE.parent.mkdir(parents=True, exist_ok=True)
        STATE.write_text(json.dumps(d, indent=2))
    except Exception:
        pass


def build_embed() -> dict:
    r = regime_lib.regime()
    try:
        pf = portfolio_summary()
    except Exception as e:  # noqa: BLE001
        pf = f"(portfolio unavailable: {e})"
    muted = card_mute.active()
    now = datetime.now(ET)
    fields = [
        {"name": "📡 Regime / Tape", "value": (r.get("line") or "—")[:1024], "inline": False},
        {"name": "💼 Book / P&L", "value": (pf or "—")[:1024], "inline": False},
    ]
    if muted:
        fields.append({"name": "🔇 Muted",
                       "value": ", ".join(f"{k} (~{v}m)" for k, v in muted.items())[:1024],
                       "inline": False})
    color = {"RISK-ON": 0x2ECC71, "RISK-OFF": 0xE74C3C}.get(r.get("state"), 0xF1C40F)
    return {
        "title": "🛰️ MISSION CONTROL — COMMAND CENTER",
        "color": color,
        "description": f"**{r.get('emoji', '')} {r.get('label', '')}** · live desk state",
        "fields": fields,
        "footer": {"text": f"updated {now:%-I:%M:%S %p ET} · auto-refresh ~2 min"},
    }


def _market_spec() -> dict:
    """Tiles (SPY/QQQ/VIX) + regime dial for the live market dashboard image."""
    from lib import chart_renderer as cr
    r = regime_lib.regime()
    tiles = []
    for sym, lbl in (("SPY", "SPY"), ("QQQ", "QQQ"), ("^VIX", "VIX")):
        df = cr.ohlc(sym, days=15, interval="1d")
        if df is None or len(df) < 2:
            continue
        price = float(df["Close"].iloc[-1]); prev = float(df["Close"].iloc[-2])
        tiles.append({"ticker": lbl, "price": price,
                      "chg": (price - prev) / prev * 100 if prev else 0.0,
                      "series": list(df["Close"].values[-20:])})
    score = {"RISK-ON": 8, "NEUTRAL": 5, "RISK-OFF": 2}.get(r.get("state"), 5)
    color = {"RISK-ON": cr.PAL["up"], "RISK-OFF": cr.PAL["down"]}.get(r.get("state"), cr.PAL["neutral"])
    return {"title": "MISSION CONTROL — MARKET", "tiles": tiles,
            "regime": {"label": r.get("label", ""), "score": score, "color": color}}


def _refresh_market_image(cid: str, state: dict) -> None:
    """Maintain a live market-dashboard IMAGE in the channel, edited in place.
    Throttled to ~5 min (image render + re-upload is heavier than the text embed)."""
    try:
        from lib import chart_renderer as cr
        mid = state.get(f"img::{cid}")
        if mid and (time.time() - state.get(f"imgts::{cid}", 0) < 300):
            return                                  # within throttle window — leave existing image
        png = cr.market_card(_market_spec())
        if not png:
            return
        if mid and oc.edit_message_image_bot(cid, SYNTH_TOKEN, mid, png, content="🛰️ live market dashboard"):
            pass
        else:
            m = oc.post_image_bot(cid, SYNTH_TOKEN, png, content="🛰️ live market dashboard", return_msg=True)
            if not m:
                return
            state[f"img::{cid}"] = m["id"]
            oc.pin_message_bot(cid, SYNTH_TOKEN, m["id"])
        state[f"imgts::{cid}"] = time.time()
        _save_state(state)
        print("[command-center] market image refreshed", flush=True)
    except Exception as e:  # noqa: BLE001
        print(f"[command-center] image err: {e}", flush=True)


def refresh(channel_name: str, print_only: bool = False) -> None:
    embed = build_embed()
    if print_only:
        print(json.dumps(embed, indent=2))
        return
    state = _load_state()
    cid = state.get(f"channel::{channel_name}")
    if not cid:
        cid = oc.create_text_channel(GUILD, SYNTH_TOKEN, channel_name,
                                     topic="Live desk dashboard — auto-updated, edited in place")
        if not cid:
            print("[command-center] channel resolve/create failed", flush=True)
            return
        state[f"channel::{channel_name}"] = cid
        _save_state(state)

    mid = state.get(f"msg::{cid}")
    if mid and oc.edit_message_bot(cid, SYNTH_TOKEN, mid, embeds=[embed]):
        print(f"[command-center] edited {mid} in #{channel_name}", flush=True)
    else:
        if mid:
            print("[command-center] edit failed (message gone?) — recreating", flush=True)
        msg = oc.post_message_bot(cid, SYNTH_TOKEN, embeds=[embed], return_msg=True)
        if not msg:
            print("[command-center] post failed", flush=True)
            return
        state[f"msg::{cid}"] = msg["id"]
        _save_state(state)
        pinned = oc.pin_message_bot(cid, SYNTH_TOKEN, msg["id"])
        print(f"[command-center] created {msg['id']} in #{channel_name} (pinned={pinned})", flush=True)

    _refresh_market_image(cid, state)               # live market dashboard image (throttled)


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="synth-control")
    ap.add_argument("--print", action="store_true", dest="print_only")
    a = ap.parse_args()
    refresh(a.channel, a.print_only)


if __name__ == "__main__":
    main()
