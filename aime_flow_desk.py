#!/usr/bin/env python3
"""AIME Flow Desk — a permanent agent that turns the live options-flow signals
into an AIME read and posts it to Discord.

Reads the deterministic digest_context.json (built every 30 min by the option
scraper), asks AInvest AIME for a pro-trader read on the top flow tickers, garnishes
each with a structured forecast/consensus score, and posts a clean card to the
flow-alerts Discord channel.

Modes:
  --digest      full 30-min flow read on the top tickers (the scheduled note)
  --t0          only react to NEW T0/T1 mega-flows since last run (instant ping)
  --dry         render + print, do NOT post to Discord (default is --post)
  --post        actually post to Discord

Invoked from cron (subscription path, market hours). AIME chat uses the logged-in
cookie via aime_client; forecast garnish uses ainvest_client (REST, degrades).
"""
from __future__ import annotations

import argparse
import json
import re
import sys
import time
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))           # aime_client
sys.path.insert(0, str(Path.home() / "web" / "missionctrl" / "pipeline"))  # ainvest_client

import aime_client  # noqa: E402
try:
    import ainvest_client  # noqa: E402
except Exception:
    ainvest_client = None

import requests  # noqa: E402

DIGEST = Path("/AIWorkWSL/trading/signals/option-scraper/data/digest_context.json")
WEBHOOK_FILE = Path.home() / ".openclaw" / "secrets" / "discord_webhook_flow_alerts"
STATE = Path.home() / ".openclaw" / "workspace" / "directives" / "aime_flow_desk_state.json"
UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124.0 Safari/537.36"
T0_TIERS = {"T0", "T1"}   # mega-flow tiers that trigger an instant ping
MAX_TICKERS = 5


def load_digest() -> dict:
    try:
        return json.loads(DIGEST.read_text())
    except Exception:
        return {}


def top_flow_tickers(d: dict) -> list[dict]:
    """Pick the tickers worth an AIME read: strongest directional net-premium names,
    union the symbols carrying T0/T1 repeating flows."""
    dirs = d.get("direction_per_ticker", []) or []
    big = d.get("repeating_large_flows", []) or []
    picked: dict[str, dict] = {}
    for row in dirs[:MAX_TICKERS]:
        sym = row.get("symbol")
        if sym:
            picked[sym] = {"symbol": sym, "lean": row.get("lean"), "net_premium": row.get("net_premium"),
                           "conviction_pct": row.get("conviction_pct"), "big": []}
    for f in big:
        sym = f.get("symbol")
        if not sym:
            continue
        picked.setdefault(sym, {"symbol": sym, "lean": None, "big": []})
        picked[sym].setdefault("big", []).append(f)
    return list(picked.values())[:MAX_TICKERS]


def t0_flows(d: dict) -> list[dict]:
    out = []
    for f in (d.get("repeating_large_flows", []) or []):
        if str(f.get("premium_tier") or f.get("tier") or "").upper() in T0_TIERS:
            out.append(f)
    return out


def _insider_net(symbol: str) -> str:
    """Recent insider net direction — buying alongside bullish flow is a strong confirm."""
    if ainvest_client is None:
        return ""
    rows = ainvest_client.insider_trades(symbol)
    data = rows.get("data") if isinstance(rows, dict) else (rows if isinstance(rows, list) else None)
    if not data:
        return ""
    buys = sum(1 for r in data[:20] if str(r.get("trade_type", "")).lower() == "buy")
    sells = sum(1 for r in data[:20] if str(r.get("trade_type", "")).lower() == "sell")
    if not (buys or sells):
        return ""
    tag = "net BUY" if buys > sells else ("net SELL" if sells > buys else "mixed")
    return f"insiders {tag} ({buys}B/{sells}S)"


def forecast_garnish(symbol: str) -> str:
    """One structured line per ticker: analyst consensus + insider net (the confirmers).
    Paced to respect the AInvest free-tier rate limit."""
    if ainvest_client is None:
        return ""
    parts = []
    con = ainvest_client.analyst_consensus(symbol)
    if isinstance(con, dict) and not con.get("error"):
        ar, tp = con.get("analysts_ratings", {}), con.get("target_price", {})
        if ar:
            parts.append(f"{ar.get('average_rating','?')} ({ar.get('buy',0)}B/{ar.get('hold',0)}H/{ar.get('sell',0)}S)"
                         + (f", tgt ${tp.get('average'):.0f}" if tp.get("average") else ""))
    ins = _insider_net(symbol)
    if ins:
        parts.append(ins)
    time.sleep(8)  # pace under the 4014 rate limiter
    return f"**{symbol}**: " + " · ".join(parts) if parts else ""


def build_flow_context(tickers: list[dict], d: dict) -> tuple[str, list[str]]:
    """Return (context_text, symbols) — symbols drive the AIME-answer cleanup."""
    lines, syms = [], []
    for t in tickers:
        s = t["symbol"]
        syms.append(s)
        bits = [s]
        if t.get("lean"):
            bits.append(f"{t['lean']} net ${(t.get('net_premium') or 0)/1e6:.1f}M ({t.get('conviction_pct')}% conv)")
        for f in (t.get("big") or [])[:2]:
            bits.append(f"{f.get('repeat_count','?')}x {f.get('aggressor','')} {f.get('block_type','')} "
                        f"{f.get('type','')} ${f.get('strike','')} ~${(f.get('premium_usd') or 0)/1e6:.1f}M "
                        f"[{f.get('premium_tier') or f.get('tier','')}]")
        lines.append(" — ".join(bits))
    picks = d.get("top_app_picks", []) or []
    if picks and not lines:  # off-hours / thin flow: fall back to app picks so the read isn't empty
        for p in picks[:MAX_TICKERS]:
            sym = p.get("symbol")
            if sym:
                syms.append(sym)
            lines.append(f"{sym} {p.get('type')} ${p.get('strike')} ({p.get('source')}, {p.get('category')})")
    return ("\n".join(lines) if lines else "(no significant flow this window)"), syms


def _clean_aime(ans: str, symbols: list[str]) -> str:
    """Drop AIME's deep-research reasoning preamble + code fences, keep the answer.
    Heuristic: the answer leads each ticker with a bold symbol, so cut everything
    before the first bolded known symbol."""
    if not ans:
        return ""
    ans = ans.strip()
    ans = re.sub(r"^```[a-z]*\n?", "", ans)
    ans = re.sub(r"\n?```$", "", ans).strip()
    idxs = [i for s in symbols for i in (ans.find(f"**{s}"),) if i >= 0]
    if idxs:
        ans = ans[min(idxs):]
    return ans.strip()


def _condense(ans: str, symbols: list[str], max_sentences: int = 2) -> str:
    """Trim AIME's wordy answer to ~max_sentences per ticker. Finds EVERY covered
    symbol (bold preferred, else first plain word-boundary hit) so no ticker is
    dropped, segments between consecutive positions, trims each block."""
    if not ans:
        return ans
    pos: dict[int, str] = {}
    for s in symbols:
        i = ans.find(f"**{s}")
        if i < 0:
            m = re.search(rf"\b{re.escape(s)}\b", ans)
            i = m.start() if m else -1
        if i >= 0 and i not in pos:
            pos[i] = s
    bounds = sorted(pos)
    if len(bounds) < 2:
        # not ticker-segmented — just cap the wall of text
        sents = re.split(r"(?<=[.!?])\s+", ans.strip())
        return " ".join(sents[:max_sentences + 2]).strip()
    blocks = []
    for n, start in enumerate(bounds):
        end = bounds[n + 1] if n + 1 < len(bounds) else len(ans)
        block = ans[start:end].strip()
        sents = re.split(r"(?<=[.!?])\s+", block)
        block = " ".join(sents[:max_sentences]).strip()
        if not block.startswith("**"):
            block = f"**{pos[start]}** — {block}"
        blocks.append(block)
    return "\n".join(b for b in blocks if b)


def _flow_verdict(d: dict) -> str:
    """One-line desk verdict from the net-premium tally."""
    dirs = d.get("direction_per_ticker", []) or []
    if not dirs:
        return ""
    bull = [r["symbol"] for r in dirs if r.get("lean") == "BULLISH"][:4]
    bear = [r["symbol"] for r in dirs if r.get("lean") == "BEARISH"][:4]
    bits = []
    if bull:
        bits.append("🟢 " + ", ".join(bull))
    if bear:
        bits.append("🔴 " + ", ".join(bear))
    return "  ·  ".join(bits)


def ask_aime_on_flow(flow_ctx: str, symbols: list[str], instant: bool) -> str:
    kind = "a single mega T0/T1 flow just printed" if instant else "this 30-minute options-flow window"
    q = (
        f"You are a professional options-flow trader. Here is {kind}:\n\n{flow_ctx}\n\n"
        "Cover EVERY ticker. Format as ONE line per ticker, exactly:\n"
        "**SYMBOL** — smart-money or noise; directional bias; key catalyst/risk (one sentence).\n"
        "Output ONLY those lines — no reasoning, no preamble, no disclaimers, no headers. "
        "Start immediately with the first ticker."
    )
    try:
        ans = aime_client.ask_aime(q)
    except Exception as e:
        return f"[AIME error: {e}]"
    cleaned = _clean_aime(ans, symbols)
    cleaned = _condense(cleaned, symbols) or cleaned
    return (cleaned or (ans or "").strip())[:1700]


def render(tickers: list[dict], d: dict, instant: bool) -> str:
    header = "🟣 **AIME Flow Read — instant T0**" if instant else "🟣 **AIME Flow Desk — 30-min read**"
    ts = d.get("generated_at_et", "")
    flow_ctx, syms = build_flow_context(tickers, d)
    aime = ask_aime_on_flow(flow_ctx, syms, instant)
    garnish = "\n".join(g for g in (forecast_garnish(t["symbol"]) for t in tickers) if g)
    verdict = _flow_verdict(d)
    parts = [f"{header}  ·  _{ts}_"]
    if verdict:
        parts += [verdict]
    parts += ["", aime]
    if garnish:
        parts += ["", "**Confirmers** _(analysts · insiders)_", garnish]
    parts += ["", "_AIME = AInvest AI; secondary signal, verify before acting._"]
    return "\n".join(parts)


ALERT_WEBHOOK = Path.home() / ".openclaw" / "secrets" / "discord_pipeline_alerts_webhook"
BENCH_DIR = Path.home() / "04_RESEARCH" / "aime_research" / "benchmark"
LOGIN_JS = Path.home() / "05_AUTOMATION" / "scripts" / "ainvest_login.js"


def _alert(msg: str) -> None:
    try:
        url = ALERT_WEBHOOK.read_text().strip()
        requests.post(url, json={"username": "AIME Flow Desk", "content": msg},
                      headers={"User-Agent": UA}, timeout=10)
    except Exception:
        pass


def _attempt_remint() -> bool:
    """Try to self-heal an expired cookie via the OTP+Gmail login (needs GMAIL_APP_PASSWORD).
    Returns True if AIME is healthy afterward."""
    import subprocess
    try:
        subprocess.run(["node", str(LOGIN_JS), "--auto"],
                       cwd=str(BENCH_DIR),
                       env={**__import__("os").environ, "NODE_PATH": str(BENCH_DIR / "node_modules")},
                       timeout=120, capture_output=True)
    except Exception:
        return False
    ok, _ = aime_client.is_healthy()
    return ok


def ensure_aime_alive() -> bool:
    """Health gate: if the cookie is dead, try to re-mint; alert + bail if still dead."""
    ok, detail = aime_client.is_healthy()
    if ok:
        return True
    if _attempt_remint():
        return True
    _alert(f":warning: **AIME Flow Desk** — cookie dead and auto re-mint failed ({detail}). "
           "Re-mint: `node ~/05_AUTOMATION/scripts/ainvest_login.js --send` then `--code <NNNNNN>`.")
    return False


def post_discord(msg: str) -> int:
    url = WEBHOOK_FILE.read_text().strip()
    sent = 0
    # Discord 2000-char cap → chunk
    for i in range(0, len(msg), 1900):
        r = requests.post(url, json={"username": "AIME Flow Desk", "content": msg[i:i + 1900]},
                          headers={"User-Agent": UA}, timeout=15)
        sent += 1 if r.status_code in (200, 204) else 0
        time.sleep(0.4)
    return sent


def load_state() -> dict:
    try:
        return json.loads(STATE.read_text())
    except Exception:
        return {}


def save_state(s: dict) -> None:
    STATE.parent.mkdir(parents=True, exist_ok=True)
    STATE.write_text(json.dumps(s))


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--digest", action="store_true")
    ap.add_argument("--t0", action="store_true")
    ap.add_argument("--dry", action="store_true")
    ap.add_argument("--post", action="store_true")
    a = ap.parse_args()
    instant = a.t0 and not a.digest
    d = load_digest()
    if not d:
        print("no digest_context.json — nothing to do")
        return 0

    if (a.post and not a.dry) and not ensure_aime_alive():
        print("AIME cookie dead — alerted, skipping post")
        return 0

    if instant:
        flows = t0_flows(d)
        state = load_state()
        seen = set(state.get("seen_t0", []))
        fresh = [f for f in flows if f"{f.get('symbol')}:{f.get('strike')}:{f.get('repeat_count')}" not in seen]
        if not fresh:
            print("no new T0/T1 flow")
            return 0
        syms = {f["symbol"] for f in fresh if f.get("symbol")}
        tickers = [{"symbol": s, "big": [f for f in fresh if f.get("symbol") == s]} for s in syms]
        state["seen_t0"] = list(seen | {f"{f.get('symbol')}:{f.get('strike')}:{f.get('repeat_count')}" for f in fresh})
        save_state(state)
    else:
        tickers = top_flow_tickers(d)
        if not tickers and not (d.get("top_app_picks")):
            print("no flow tickers this window")
            return 0

    msg = render(tickers, d, instant)
    if a.dry or not a.post:
        print("===== DRY RUN — would post to flow-alerts =====\n")
        print(msg)
        return 0
    n = post_discord(msg)
    print(f"posted {n} chunk(s) to flow-alerts")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
