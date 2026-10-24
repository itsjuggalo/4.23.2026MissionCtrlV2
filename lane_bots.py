#!/home/itsju/.venv/bin/python
"""lane_bots.py — makes the three re-used idle bots two-way (2026-09-28, Mike: "improve idle bots").

One process, one long-poll thread per bot (tg_fleet fn → bot):
  trading_digest  @Boba2Telegram_Bot "Trading Digest"   /now (send the pending digest now) · /queue
  trading_recaps  @MMCTRL727_Bot     "Trading Recaps"   /eod /scoreboard /grades /contracts /week
  crypto_desk     @Grootk_Bot        "Crypto Desk"      /btc /eth /sol /price SYM · /signals · /x topic

Every on-demand recap runs the lane's OWN script in its verified dry-run mode (flags from
tg_fleet CHARTER) and relays the rendered text — nothing is re-derived here, nothing is sent
by those scripts. Crypto quotes come from Coinbase's free public API. Advice only; no orders.

Only ONE getUpdates consumer per token: PM2 `lane-bots` owns these three tokens (tg_responder
refuses `grokscout`; tg-fleet-audit flags a second poller as CONFLICT).
"""
from __future__ import annotations

import html
import json
import os
import re
import subprocess
import sys
import threading
import time
from pathlib import Path

import requests

HERE = Path(__file__).resolve().parent
sys.path.insert(0, str(HERE))
import tg_fleet  # noqa: E402

VENV = str(Path.home() / ".venv/bin/python")
SYS_PY = "/usr/bin/python3"
DIGEST_DIR = "/AIWorkWSL/trading/signals/option-scraper/pipeline/digest"
QE_STATE = Path.home() / "web/missionctrl/scripts/quantedge_alert_state.json"
OWNER = (Path.home() / ".openclaw/secrets/telegram-chat-id.txt").read_text().strip()
STALE_S = 3600
DRY = os.environ.get("DRY") == "1"


# ── Telegram plumbing ─────────────────────────────────────────────────────────
class Bot:
    def __init__(self, fn: str):
        self.fn, self.tok = fn, tg_fleet.token(fn)

    def api(self, method: str, **kw):
        if DRY and method not in ("getUpdates", "getMe", "getWebhookInfo"):
            print(f"DRY {self.fn} {method}: {json.dumps(kw)[:400]}")
            return {"ok": True}
        try:   # sends through tg_fleet.call as this lane (pinned bot, ledgered, no tg_lint hold) — script-standard #6
            if method not in ("getUpdates", "getMe", "getWebhookInfo", "deleteWebhook", "getFile"):
                return tg_fleet.call(self.fn, method, _review=False, **kw)
            return requests.post(f"https://api.telegram.org/bot{self.tok}/{method}", json=kw,
                                 timeout=kw.get("timeout", 0) + 20).json()
        except Exception as e:  # noqa: BLE001
            print(f"[lane-bots:{self.fn}] {method} {type(e).__name__}", flush=True)
            return {"ok": False}

    def send(self, text: str, html_mode: bool = True) -> None:
        text = text.strip() or "(nothing to show)"
        for i in range(0, len(text), 3900):          # Telegram cap 4096
            part = text[i:i + 3900]
            kw = {"chat_id": OWNER, "text": part, "disable_web_page_preview": True}
            if html_mode:
                kw["parse_mode"] = "HTML"
            r = self.api("sendMessage", **kw)
            if not r.get("ok") and html_mode and not DRY:
                kw.pop("parse_mode"); kw["text"] = re.sub(r"<[^>]+>", "", part)
                self.api("sendMessage", **kw)
        # the send ledger row is written by tg_fleet.call per message (2026-10-23; was one row here, always ok=True)


def run(cmd: list[str], env: dict | None = None, cwd: str | None = None, timeout: int = 150) -> str:
    try:
        r = subprocess.run(cmd, env={**os.environ, **(env or {})}, cwd=cwd,
                           capture_output=True, text=True, timeout=timeout)
        return r.stdout.strip() or r.stderr.strip()
    except subprocess.TimeoutExpired:
        return "⏱ timed out — try again in a minute."
    except Exception as e:  # noqa: BLE001
        return f"error: {e}"


def pre(text: str) -> str:
    """Log-style output → monospace block (escaped)."""
    return f"<pre>{html.escape(text[:3700])}</pre>"


# ── Trading Digest ────────────────────────────────────────────────────────────
DIGEST_HELP = ("🧾 <b>TRADING DIGEST</b> — watchlists, radars, pulses and FYI flow, folded into a "
               "few silent digests a day (10:00 · 11:30 · 13:00 · 14:30 · 16:00 · 16:50 ET + 21:00).\n\n"
               "▸ /now — send what's queued right now\n▸ /queue — what's waiting, by source\n"
               "Or just type: <i>send it · what's waiting</i>\n"
               "<i>Entries, exits and 🟢 TRADE never wait — they go to Trading Command.</i>")


def digest_cmd(bot: Bot, cmd: str, arg: str) -> None:
    script = str(HERE / "lib/tg_digest.py")
    if cmd in ("now", "flush", "digest"):
        out = run([VENV, script, "flush"])
        if "nothing queued" in out:
            bot.send("🧾 Nothing queued — every FYI update has already been delivered.")
        elif "send failed" in out:
            bot.send("🧾 Couldn't send the digest just now — it stays queued for the next slot.")
    elif cmd in ("queue", "status"):
        out = run([VENV, script, "status"])
        rows = [ln.strip() for ln in out.splitlines() if "queued" in ln]
        bot.send("🧾 <b>QUEUED</b>\n" + "\n".join(f"▸ {html.escape(r)}" for r in rows) if rows
                 else "🧾 Nothing queued — the next digest has nothing new yet.")
    else:
        bot.send(DIGEST_HELP)


# ── Trading Recaps ────────────────────────────────────────────────────────────
RECAPS_HELP = ("📊 <b>TRADING RECAPS</b> — how the signals did. Scheduled recaps land here; pull any "
               "of them now:\n\n▸ /eod — EOD scorecard (flow picks graded)\n"
               "▸ /scoreboard — open paper positions vs their plan\n"
               "▸ /grades — best-3 win rate + score-floor calibration\n"
               "▸ /contracts — live relay contracts through the Academy grid\n"
               "▸ /week — 30-day report card per alert lane\n\n"
               "Or just type: <i>how did today go · positions · win rate · weekly report</i>")


def _dry_messages(out: str) -> str:
    """Pull the rendered message text out of 'DRY sendMessage: {json}' lines."""
    texts = []
    for m in re.finditer(r"DRY sendMessage: (\{.*?\})\s*$", out, re.M):
        try:
            texts.append(json.loads(m.group(1))["text"])
        except Exception:
            pass
    return "\n\n".join(texts)


def recaps_cmd(bot: Bot, cmd: str, arg: str) -> None:
    if cmd == "eod":
        bot.send(run([VENV, str(HERE / "eod_scorecard.py"), "--dry-run"]))
    elif cmd in ("scoreboard", "positions"):
        out = run([SYS_PY, "scoreboard_auditor.py", "--eod", "--dry-run"], cwd=DIGEST_DIR)
        bot.send(_dry_messages(out) or "📊 Scoreboard: no open virtual trades.")
    elif cmd in ("grades", "best3"):
        out = run([SYS_PY, "best3_grader.py", "--eod", "--dry-run"], cwd=DIGEST_DIR)
        keep = [ln.replace("[best3-grade] ", "") for ln in out.splitlines()
                if "fetch failed" not in ln and ln.strip()]
        bot.send("🏅 <b>BEST-3 GRADES</b>\n" + pre("\n".join(keep[:30])))
    elif cmd in ("contracts", "scorecard"):
        bot.send(pre(run([VENV, str(HERE / "options_position_scorecard.py")], env={"DRY": "1"})),)
    elif cmd in ("week", "report", "reportcard"):
        bot.send(pre(run([SYS_PY, "/AIWorkWSL/trading/analysis/report_card.py", "--dry"])))
    else:
        bot.send(RECAPS_HELP)


# ── Crypto Desk ───────────────────────────────────────────────────────────────
CRYPTO_HELP = ("🪙 <b>CRYPTO DESK</b> — BTC/ETH move alerts, crypto news and QuantEdge perp signals "
               "land here. Pull any time:\n\n▸ /btc · /eth · /sol — price, 24h range + change\n"
               "▸ /price SYM — any Coinbase pair (e.g. /price XRP)\n"
               "▸ /signals — QuantEdge perp signals in play (side / since)\n"
               "▸ /x TOPIC — what crypto X is saying (Grok)\n\n"
               "Or just type: <i>bitcoin · how's eth · any signals · what's X saying about sol</i>\n"
               "<i>Advice only — you place Coinbase orders yourself.</i>")


def quote(sym: str) -> str:
    sym = re.sub(r"[^A-Z0-9]", "", sym.upper())[:10] or "BTC"
    try:
        st = requests.get(f"https://api.exchange.coinbase.com/products/{sym}-USD/stats", timeout=10).json()
        last, opn = float(st["last"]), float(st["open"])
        hi, lo = float(st["high"]), float(st["low"])
    except Exception:
        return f"🪙 No Coinbase USD pair for {html.escape(sym)} (or the API is down)."
    chg = (last - opn) / opn * 100 if opn else 0
    pos = (last - lo) / (hi - lo) * 100 if hi > lo else 50
    fmt = (lambda v: f"${v:,.0f}") if last >= 1000 else ((lambda v: f"${v:,.2f}") if last >= 1 else (lambda v: f"${v:.4f}"))
    arrow = "🟢" if chg >= 0 else "🔴"
    et = time.strftime("%a %m-%d %H:%M ET")
    return (f"{arrow} <b>{sym}</b> {fmt(last)} · {chg:+.2f}% 24h\n"
            f"▸ 24h range {fmt(lo)} – {fmt(hi)} · sitting at {pos:.0f}% of it\n"
            f"<i>Coinbase · {et}</i>")


def signals() -> str:
    try:
        st = json.loads(QE_STATE.read_text())
    except Exception:
        return "🪙 QuantEdge state unavailable."
    if not st:
        return "🪙 No QuantEdge perp signal in play right now."
    rows = ["🪙 <b>QUANTEDGE — IN PLAY</b>"]
    for s in st.values():
        rows.append(f"▸ <b>{html.escape(s.get('display', s.get('symbol', '?')))}</b> {s.get('side')} "
                    f"from {s.get('entry')}"
                    f"\n   <i>since {s.get('activated_at', '?')} ET</i>")
    rows.append("<i>Perp signals — on Coinbase, trade spot or skip.</i>")
    return "\n".join(rows)


def x_read(topic: str) -> str:
    topic = topic.strip()[:200]
    if not topic:
        return "Usage: /x BTC  (or any coin / crypto topic)"
    try:
        from lib import llm
        out = llm.call_llm_text(
            "You are Crypto Desk — Mike's crypto scout. Using live X/Twitter, say what crypto traders "
            f"are saying right now about: {topic}. Bull/bear lean, notable posts, any fresh catalyst. "
            "4-5 lines, plain text, Eastern Time. Advice only.", ["grok_oauth", "codex_cli"])
    except Exception as e:  # noqa: BLE001
        out = None
        print(f"[lane-bots:crypto] llm {type(e).__name__}", flush=True)
    return html.escape(out) if out else "🪙 X read unavailable right now (Grok + Codex both down)."


def crypto_cmd(bot: Bot, cmd: str, arg: str) -> None:
    if cmd in ("btc", "eth", "sol", "xrp", "doge", "ada"):
        bot.send(quote(cmd))
    elif cmd in ("price", "p", "q"):
        bot.send(quote(arg or "BTC"))
    elif cmd in ("signals", "quantedge", "perps"):
        bot.send(signals())
    elif cmd in ("x", "sentiment"):
        bot.send(x_read(arg))
    else:
        bot.send(CRYPTO_HELP)


LANES = {
    "trading_digest": (digest_cmd, [("now", "Send the pending digest now"), ("queue", "What's waiting"),
                                    ("help", "How this bot works")]),
    "trading_recaps": (recaps_cmd, [("eod", "EOD scorecard"), ("scoreboard", "Paper positions vs plan"),
                                    ("grades", "Best-3 win rate + calibration"),
                                    ("contracts", "Live contracts through the grid"),
                                    ("week", "30-day report card"), ("help", "How this bot works")]),
    "crypto_desk": (crypto_cmd, [("btc", "BTC price + 24h"), ("eth", "ETH price + 24h"), ("sol", "SOL price + 24h"),
                                 ("price", "Any coin: /price XRP"), ("signals", "QuantEdge perps in play"),
                                 ("x", "Crypto X sentiment: /x BTC"), ("help", "How this bot works")]),
}


# ── plain-words routing (Mike: "they should work by keywords", 2026-09-28) ────
# Deterministic keyword → command, checked in order; slash commands still work as-is.
COINS = {"bitcoin": "BTC", "btc": "BTC", "ethereum": "ETH", "ether": "ETH", "eth": "ETH",
         "solana": "SOL", "sol": "SOL", "ripple": "XRP", "xrp": "XRP", "dogecoin": "DOGE",
         "doge": "DOGE", "cardano": "ADA", "ada": "ADA", "litecoin": "LTC", "ltc": "LTC",
         "chainlink": "LINK", "link": "LINK", "avalanche": "AVAX", "avax": "AVAX", "sui": "SUI"}
KEYWORDS = {
    "trading_digest": [(r"\b(send|now|flush|push|deliver|give me)\b|\bdigest\b", "now"),
                       (r"\b(queue|queued|waiting|pending|status|anything new|what'?s new|how many)\b", "queue")],
    "trading_recaps": [(r"score ?board|\bpositions?\b|\bpaper\b|\bopen trades?\b", "scoreboard"),
                       (r"\bgrades?\b|best ?-?3|win ?rate|calibrat|\bfloor\b", "grades"),
                       (r"\bcontracts?\b|\brelay\b|\bgrid\b|\bgreeks?\b", "contracts"),
                       (r"\bweek(ly)?\b|report ?card|30 ?d|\blanes?\b|\bcut\b", "week"),
                       (r"\beod\b|end of (the )?day|score ?card|\btoday\b|\bpicks?\b|how did", "eod")],
    "crypto_desk": [(r"saying|sentiment|twitter|\bx\b|chatter|buzz|\bnews\b|\bwhy\b|narrative|hype", "x"),
                    (r"\bsignals?\b|quant ?edge|\bperps?\b|in play|\bsetups?\b|\blong\b|\bshort\b", "signals"),
                    (r"\bprice\b|how'?s|how is|\bquote\b|doing|\bat\b|\bup\b|\bdown\b|\bcheck\b", "price")],
}


def route_words(fn: str, text: str) -> tuple[str, str]:
    """Plain text → (command, arg). Coins resolve to a price unless another intent wins."""
    low = text.lower()
    words = re.findall(r"[a-z0-9]+", low)
    coin = next((COINS[w] for w in words if w in COINS), None)
    if fn == "crypto_desk" and not coin:           # bare ticker like "PEPE" / "hbar"
        t = re.fullmatch(r"\$?([A-Za-z]{2,6})", text.strip())
        coin = t.group(1).upper() if t else None
        if coin in {"HI", "HEY", "HELLO", "HELP", "MENU", "THANKS", "THX", "START", "OK", "YO", "SUP"}:
            coin = None
    for pat, cmd in KEYWORDS.get(fn, []):
        if re.search(pat, low):
            if fn == "crypto_desk" and cmd == "x":
                return "x", text
            if fn == "crypto_desk" and cmd == "price":
                return "price", coin or "BTC"
            return cmd, ""
    if coin:
        return "price", coin
    return "help", ""


def handle(bot: Bot, handler, m: dict) -> None:
    if str((m.get("chat") or {}).get("id", "")) != OWNER:
        return
    text = (m.get("text") or "").strip()
    if not text:
        return
    if text.startswith("/"):
        cmd, _, arg = text.partition(" ")
        cmd = cmd.lower().split("@")[0].lstrip("/")
    else:
        cmd, arg = route_words(bot.fn, text)
    bot.api("sendChatAction", chat_id=OWNER, action="typing")
    handler(bot, cmd, arg.strip())
    print(f"[lane-bots:{bot.fn}] /{cmd}", flush=True)


def poll(fn: str) -> None:
    bot = Bot(fn)
    handler, cmds = LANES[fn]
    if (bot.api("getWebhookInfo").get("result") or {}).get("url"):
        print(f"[lane-bots:{fn}] webhook set — not polling", flush=True); return
    if not DRY:
        bot.api("setMyCommands", commands=[{"command": c, "description": d} for c, d in cmds])
    print(f"[lane-bots:{fn}] polling as @{(bot.api('getMe').get('result') or {}).get('username')}", flush=True)
    offset = 0
    while True:
        r = bot.api("getUpdates", offset=offset, timeout=25, allowed_updates=["message"])
        if not r.get("ok"):
            time.sleep(5); continue
        for u in r.get("result", []):
            offset = u["update_id"] + 1
            m = u.get("message") or {}
            if time.time() - m.get("date", 0) > STALE_S:
                continue                                  # old backlog from the bot's past life
            try:
                handle(bot, handler, m)
            except Exception as e:  # noqa: BLE001
                print(f"[lane-bots:{fn}] handler {type(e).__name__}: {e}", flush=True)


def main() -> int:
    fns = sys.argv[1:] or list(LANES)
    threads = [threading.Thread(target=poll, args=(fn,), name=fn, daemon=True) for fn in fns]
    for t in threads:
        t.start()
    while True:                                           # a dead lane → exit so PM2 restarts us
        time.sleep(60)
        dead = [t.name for t in threads if not t.is_alive()]
        if dead:
            print(f"[lane-bots] dead lanes {dead} — exiting for PM2 restart", flush=True)
            return 1


if __name__ == "__main__":
    raise SystemExit(main())
