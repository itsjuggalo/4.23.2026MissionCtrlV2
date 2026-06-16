#!/usr/bin/env python3
"""flow_visual_post.py — VISUAL flow cards (the flow-wall replacement).

Reads the LIVE option-flow JSON (READ-ONLY — never writes, never touches the
scraper/relay), ranks standout contracts, and renders compact novice-friendly
cards (chart_renderer.pick_card: candles + EMAs + conviction/V-OI gauges +
"what this means / how to play it") with the action buttons, posted AS
SynthControl to a channel we own (#flow-cards). Replaces the text-wall reading
experience of #flow-wins without modifying the off-limits stream. Honors card_mute.

  flow_visual_post.py                      # post top-N visual cards → #flow-cards
  flow_visual_post.py --print              # list what it would post (no post)
  flow_visual_post.py --channel flow-cards --top 3
Run with ~/.venv/bin/python (yfinance + matplotlib).
"""
from __future__ import annotations

import argparse
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from flow_picks_post import _load, _score                  # noqa: E402  (pure, read-only ranking)
from lib import explain, card_mute                          # noqa: E402
from lib import chart_renderer as cr                        # noqa: E402
from lib import ops_card as oc                              # noqa: E402
from skill_to_discord import GUILD                          # noqa: E402

SYNTH_TOKEN = (Path.home() / ".openclaw" / "secrets" / "discord_synthcontrol_token").read_text().strip()
MIN_FLOW = 500_000          # standout floor — real money only
DTE_MIN, DTE_MAX = 5, 120   # swing-able window — skip 0DTE lotto + long-dated LEAP hedges


def standouts(top: int = 3) -> list[dict]:
    """Top distinct-ticker standout contracts from the live flow (read-only)."""
    merged = _load()
    if not merged:
        return []
    scored = sorted(((_score(a), a) for a in merged.values()), key=lambda x: -x[0][0])
    out, used = [], set()
    for (s, fv, voi, dte), a in scored:
        sym = str(a.get("Symbol", "")).upper()
        if not sym or sym in used or card_mute.is_muted(sym):
            continue
        if fv < MIN_FLOW or not (DTE_MIN <= int(dte) <= DTE_MAX):
            continue
        used.add(sym)
        out.append(a)
        if len(out) >= top:
            break
    return out


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--channel", default="flow-cards")
    ap.add_argument("--top", type=int, default=3)
    ap.add_argument("--print", action="store_true", dest="print_only")
    args = ap.parse_args()

    picks = standouts(args.top)
    if not picks:
        print("[flow-visual] no standout flow; skip", flush=True)
        return
    if args.print_only:
        for a in picks:
            sp = explain.card_spec(a)
            print(f"{sp['contract']} | {sp['tier']} | conv {sp['conviction']} | {sp['what']}")
        return

    cid = oc.resolve_channel(GUILD, SYNTH_TOKEN, args.channel)
    if not cid:
        print(f"[flow-visual] #{args.channel} not found — create it (one-time) and re-run.", flush=True)
        return

    posted = 0
    for a in picks:
        if not a.get("Spot"):                      # backfill spot for the chart mark
            sp = cr.last_price(str(a.get("Symbol", "")))
            if sp:
                a = {**a, "Spot": sp}
        spec = explain.card_spec(a)
        png = cr.pick_card(spec)
        cap = f"🎯 **{spec['contract']}** · {spec['tier']} · conviction {spec['conviction']}/10"
        ok = png and oc.post_image_bot(cid, SYNTH_TOKEN, png, content=cap,
                                       components=oc.pick_action_rows())
        posted += 1 if ok else 0
        print(f"[flow-visual] {spec['contract']}: {'ok' if ok else 'FAILED'}", flush=True)
    print(f"[flow-visual] posted {posted}/{len(picks)} cards → #{args.channel}", flush=True)


if __name__ == "__main__":
    main()
