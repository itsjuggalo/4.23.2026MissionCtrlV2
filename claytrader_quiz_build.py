#!/home/itsju/.venv/bin/python
"""claytrader_quiz_build.py — topic-tag + VISION-CURATE ClayTrader chart stills into a quiz bank.

Mirror of erikdalton_quiz_build.py, for trading: per lesson, assign a trading TOPIC (taxonomy
match on title/course/transcript), then ask Claude vision whether each still CLEARLY shows a
chart / trade setup / TA (reject talking-head, title slides, plain desktop) and to name the
concept + write a caption. Keeps the on-topic chart frames → quiz_bank.json, and writes the
lesson topic back into frames.json + _index.json (so the ClaudeClaw page can group by topic).

  claytrader_quiz_build.py [--limit N] [--max-per-lesson K] [--dry]
Resumable: skips lessons already processed.
"""
from __future__ import annotations

import argparse
import base64
import glob
import json
import re
import sys
import time
from pathlib import Path

KB = Path.home() / "claytrader-kb"
FRAMES = KB / "frames"
BANK = KB / "quiz_bank.json"
PROCESSED = KB / "quiz_build_processed.json"
INDEX = FRAMES / "_index.json"
CRED = Path.home() / ".claude" / ".credentials.json"

# Trading topic taxonomy — most-specific (named ClayTrader setups) first, longest keyword wins.
TOPICS: list[tuple[str, list[str]]] = [
    ("Panic Buy",          ["panic buy", "panic-buy", "capitulation"]),
    ("Momentum Buy",       ["momentum buy", "momentum-buy"]),
    ("Speculation Buy",    ["speculation buy", "speculation-buy", "massively right"]),
    ("Volcano",            ["volcano"]),
    ("Trampoline",         ["trampoline"]),
    ("Options Greeks",     ["delta", "gamma", "theta", "vega", "greek", "intrinsic", "extrinsic", "option premium"]),
    ("Options Spreads",    ["vertical spread", "credit spread", "debit spread", "butterfly", "straddle",
                            "strangle", "calendar spread", "covered call", "married put", "iron condor"]),
    ("Candlesticks",       ["candlestick", "candle", "doji", "hammer", "engulfing", "wick"]),
    ("Support/Resistance", ["support and resistance", "resistance", "support level", "support"]),
    ("Moving Averages",    ["moving average", "200 day", "50 day", "20 day", " ema", " sma"]),
    ("Indicators",         ["macd", "rsi", "bollinger", "stochastic", "indicator"]),
    ("Volume",             ["volume"]),
    ("Chart Patterns",     ["head and shoulders", "double top", "double bottom", "triangle",
                            "breakout", "wedge", "channel", "chart pattern"]),
    ("Trend Analysis",     ["uptrend", "downtrend", "higher high", "lower low", "trend line", "trendline", "trend"]),
    ("Level 2",            ["level 2", "level two", "order flow", "market depth", "bid ask"]),
    ("Penny Stocks",       ["penny stock", "dilution", "basher"]),
    ("Shorting",           ["shorting", "short selling", "disgruntled", "ruthless short"]),
    ("Risk Management",    ["risk to reward", "stop loss", "stop-loss", "position size", "risk reward", "capital"]),
    ("Technical Analysis", ["technical analysis", "chart"]),
]
_COMPILED = [(name, [re.compile(r"\b" + re.escape(k) + r"\b", re.I) for k in kws]) for name, kws in TOPICS]


def _topic(*texts: str) -> str:
    blob = " ".join(t or "" for t in texts).lower()
    for name, pats in _COMPILED:
        if any(p.search(blob) for p in pats):
            return name
    return "Technical Analysis"


def _oauth_token() -> str | None:
    try:
        return (json.loads(CRED.read_text()).get("claudeAiOauth") or {}).get("accessToken")
    except Exception:
        return None


def _vision(still: Path, topic: str, title: str, transcript: str) -> dict | None:
    tok = _oauth_token()
    if not tok or not still.exists():
        return None
    try:
        import urllib.request
        b64 = base64.b64encode(still.read_bytes()).decode()
        prompt = (
            "This is a still from a ClayTrader stock-trading course video. Decide if it CLEARLY "
            "shows a PRICE CHART, a trade setup, or a technical-analysis / options visual on screen "
            "(reject talking-head webcam, title cards, slides of plain text, or an empty desktop).\n"
            f"Lesson title: {title!r}\nLikely topic: {topic!r}\n"
            f"Transcript near here: {transcript[:500]!r}\n\n"
            "Reply ONLY compact JSON: {\"keep\": true|false, \"concept\": \"<clean concept/setup name, "
            "<=6 words>\", \"caption\": \"<one short sentence on what the chart shows>\", "
            "\"difficulty\": \"easy|medium|hard\"}")
        body = {"model": "claude-sonnet-4-5", "max_tokens": 400,
                "system": "You are Claude Code, Anthropic's official CLI for Claude.",
                "messages": [{"role": "user", "content": [
                    {"type": "image", "source": {"type": "base64", "media_type": "image/jpeg", "data": b64}},
                    {"type": "text", "text": prompt}]}]}
        req = urllib.request.Request("https://api.anthropic.com/v1/messages",
                                     data=json.dumps(body).encode(), method="POST",
                                     headers={"Authorization": "Bearer " + tok,
                                              "anthropic-version": "2023-06-01",
                                              "anthropic-beta": "oauth-2025-04-20",
                                              "content-type": "application/json"})
        with urllib.request.urlopen(req, timeout=60) as r:
            txt = json.loads(r.read())["content"][0]["text"].strip()
        i, j = txt.find("{"), txt.rfind("}")
        return json.loads(txt[i:j + 1]) if i >= 0 else None
    except Exception as e:
        print(f"  vision error: {str(e)[:140]}", file=sys.stderr)
        return None


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--limit", type=int, default=300)
    ap.add_argument("--max-per-lesson", type=int, default=2)
    ap.add_argument("--dry", action="store_true")
    args = ap.parse_args()

    bank = json.loads(BANK.read_text()) if BANK.exists() else []
    processed = set(json.loads(PROCESSED.read_text())) if PROCESSED.exists() else set()
    index = json.loads(INDEX.read_text()) if INDEX.exists() else {}
    fjs = sorted(glob.glob(str(FRAMES / "*" / "frames.json")))
    done = kept = 0
    for fj in fjs:
        vid = Path(fj).parent.name
        if vid in processed or done >= args.limit:
            continue
        try:
            d = json.load(open(fj))
        except Exception:
            processed.add(vid); continue
        title, course = d.get("title", ""), d.get("course", "")
        prose = " ".join(f.get("text", "") for f in d.get("frames", []))
        topic = _topic(title, course, prose)
        done += 1
        print(f"[{done}] {vid} [{topic}] — {title[:44]}", flush=True)
        # write lesson topic back into frames.json + _index
        for f in d.get("frames", []):
            f["topic"] = topic
        if not args.dry:
            Path(fj).write_text(json.dumps(d, indent=1))
            index[vid] = {"title": title, "course": course, "topic": topic, "n_frames": d.get("n_frames", 0)}
        keptN = 0
        for f in d.get("frames", []):
            if keptN >= args.max_per_lesson:
                break
            still = KB / f["file"]
            if args.dry:
                print(f"  DRY would vision {still.name}"); continue
            v = _vision(still, topic, title, f.get("text", ""))
            time.sleep(1.0)
            if not v or not v.get("keep"):
                continue
            entry = {"still": str(still), "topic": topic,
                     "concept": (v.get("concept") or topic).strip(),
                     "caption": (v.get("caption") or "").strip(),
                     "difficulty": (v.get("difficulty") or "medium").strip(),
                     "lesson": title, "course": course, "vimeo_id": vid, "t": f.get("t")}
            if any(e.get("still") == entry["still"] for e in bank):
                continue
            bank.append(entry); keptN += 1; kept += 1
            BANK.write_text(json.dumps(bank, indent=1))
            print(f"  KEEP: {entry['concept']} (bank={len(bank)})")
        if not args.dry:
            processed.add(vid)
            PROCESSED.write_text(json.dumps(sorted(processed)))
            INDEX.write_text(json.dumps(index, indent=1))
    print(f"\nDone: {done} lessons, kept {kept}. Bank total: {len(bank)}.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
