#!/usr/bin/env python3
"""aime_discord_bot.py — AIME in Discord (browserless, no window).

Mirrors the Telegram AIME bot for Discord. Ask AIME two ways:
  - Slash command:  /aime question:<text>        (works with no privileged intents)
  - Dedicated channel: set AIME_CHANNEL_ID and every message there is an AIME query
    (requires the Message Content intent enabled on the bot).

Uses the shared browserless client (~/scripts/aime_client.py) — pure HTTP + ainvest
cookie, never a browser. Bot token from ~/.openclaw/secrets/<DISCORD_AIME_TOKEN_FILE>.
"""
from __future__ import annotations

import asyncio
import json
import os
import re
import subprocess
import sys
import tempfile
from datetime import datetime, timezone, timedelta
from pathlib import Path
from typing import Optional
from zoneinfo import ZoneInfo

sys.path.insert(0, str(Path.home() / "scripts"))
sys.path.insert(0, str(Path.home() / "05_AUTOMATION" / "scripts"))
import aime_client as aime  # noqa: E402
import discord  # noqa: E402
from discord import app_commands  # noqa: E402
from discord.ext import tasks  # noqa: E402
from lib.portfolio import (portfolio_summary, add_watch, remove_watch,  # noqa: E402
                           get_watchlist, total_equity, daily_journal_recap, weekly_review)
from lib import x_search  # noqa: E402  — native Grok x_search w/ web fallback
from lib import alerts as price_alerts  # noqa: E402  — user-set price alerts (Set Alert btn)
from lib import card_mute  # noqa: E402  — per-ticker mute (Mute btn)
from lib import regime as regime_lib  # noqa: E402  — VIX+SPY+BTC regime read (presence/events)

ET = ZoneInfo("America/New_York")

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = os.environ.get("DISCORD_AIME_TOKEN_FILE", "discord_ops_bot_token")
TOKEN = (SEC / TOKEN_FILE).read_text(encoding="utf-8").strip()
CHANNEL_ID = int(os.environ.get("AIME_CHANNEL_ID", "0") or 0)
DISCORD_MAX = 2000


def _chunks(text: str):
    text = text or "[empty]"
    for i in range(0, len(text), DISCORD_MAX):
        yield text[i:i + DISCORD_MAX]


async def _answer(question: str) -> str:
    # ask_aime is blocking HTTP — run off the event loop
    return await asyncio.to_thread(aime.ask_aime, question)


# ─── HEADLESS SKILL BRIDGE ────────────────────────────────────────────────────
# Run any Claude skill via `claude -p`, billed to the claude.ai SUBSCRIPTION (the
# ANTHROPIC_API_KEY is stripped). Same proven pattern as antigravity_aime_bot.ask_local
# and flow_digest_cron.sh — cwd=$HOME + --allowedTools are mandatory or it's
# permission-blocked at runtime; use ~/.local/bin/claude (the sub CLI, not ~/bin wrapper).
CLAUDE_BIN = str(Path.home() / ".local/bin/claude")
CLAUDE_CWD = str(Path.home())
CLAUDE_TOOLS = "Bash,Read,Grep,Glob,WebFetch,WebSearch,Skill,Agent,TodoWrite"


def _run_skill(prompt: str, model: str = "sonnet", timeout: int = 300) -> str:
    env = {k: v for k, v in os.environ.items() if k != "ANTHROPIC_API_KEY"}
    try:
        r = subprocess.run(
            [CLAUDE_BIN, "-p", prompt, "--model", model, "--effort", "high",
             "--output-format", "json", "--allowedTools", CLAUDE_TOOLS],
            capture_output=True, text=True, timeout=timeout, env=env, cwd=CLAUDE_CWD)
        if r.returncode != 0:
            return f"[skill error rc={r.returncode}] {r.stderr.strip()[:300]}"
        out = json.loads(r.stdout)
        return (out.get("result") or "").strip() or "[skill returned empty]"
    except subprocess.TimeoutExpired:
        return f"[skill timed out after {timeout}s]"
    except Exception as e:  # noqa: BLE001
        return f"[skill error] {e}"


async def _answer_skill(prompt: str, timeout: int = 300) -> str:
    return await asyncio.to_thread(_run_skill, prompt, "sonnet", timeout)


async def _send_chunks(interaction: discord.Interaction, text: str) -> None:
    parts = list(_chunks(text))
    await interaction.followup.send(parts[0])
    for p in parts[1:]:
        await interaction.followup.send(p)


# ─── INTERACTIVE PICK CARDS (persistent buttons) ──────────────────────────────
# A persistent View (timeout=None, static custom_ids) registered in on_ready so
# clicks keep working across bot restarts. The ticker is read back from the card
# text, so no per-message state is needed.
JOURNAL = Path.home() / ".openclaw" / "data" / "trade_journal.jsonl"


def _journal(ticker: str, action: str, user: str) -> None:
    try:
        JOURNAL.parent.mkdir(parents=True, exist_ok=True)
        rec = {"ts": datetime.now(timezone.utc).isoformat(), "ticker": ticker,
               "action": action, "user": user}
        with open(JOURNAL, "a") as f:
            f.write(json.dumps(rec) + "\n")
    except Exception as e:  # noqa: BLE001
        print(f"[pick] journal err: {e}", flush=True)


def _ticker_from_msg(msg) -> str:
    m = re.search(r"TRADE IDEA — ([A-Z.]{1,6})", (msg.content if msg else "") or "")
    return m.group(1) if m else "?"


class PickView(discord.ui.View):
    def __init__(self):
        super().__init__(timeout=None)

    @discord.ui.button(label="Took it", emoji="✅",
                       style=discord.ButtonStyle.success, custom_id="pk:took")
    async def b_took(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _ticker_from_msg(interaction.message)
        _journal(t, "took", interaction.user.display_name)
        await interaction.response.send_message(
            f"✅ Logged **{t}** as TAKEN by {interaction.user.display_name}.")

    @discord.ui.button(label="Skip", emoji="❌",
                       style=discord.ButtonStyle.danger, custom_id="pk:skip")
    async def b_skip(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _ticker_from_msg(interaction.message)
        _journal(t, "skip", interaction.user.display_name)
        await interaction.response.send_message(f"❌ **{t}** skipped.", ephemeral=True)

    @discord.ui.button(label="Analyze", emoji="📊",
                       style=discord.ButtonStyle.primary, custom_id="pk:analyze")
    async def b_analyze(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _ticker_from_msg(interaction.message)
        await interaction.response.defer(thinking=True)
        await _send_chunks(interaction, await _answer_skill(f"/ticker-research {t}"))


# ─── ACTION CARDS (Paper Buy / Set Alert / Explain / Grade / Mute) ────────────
# A second persistent View whose buttons carry the heavier actions. Static
# custom_ids so a card posted by cron (via the SAME SynthControl app token, with
# a raw components action-row) routes its clicks to this registered View. The
# ticker is read back from the card so no per-message state is needed.
ACT_BUY, ACT_ALERT, ACT_EXPLAIN, ACT_GRADE, ACT_MUTE = (
    "act:buy", "act:alert", "act:explain", "act:grade", "act:mute")
ACT_PAYOFF = "act:payoff"

# ARMED 2026-06-15 on Mike's explicit "arm paper buy" go. PAPER accounts ONLY, hard
# $800 AND ≤50%-of-equity cap, killswitch-guarded (~/.openclaw/workspace/state/
# {acct}_killswitch), and market-hours guarded (_market_open — Alpaca QUEUES off-hours
# market orders rather than rejecting, so we refuse when closed to avoid surprise fills).
# The confirm Modal (account + $ entry) is the deliberate gate. Set False to disarm.
_ARM_PAPER_BUY = True
PAPER_INTENTS = Path.home() / ".openclaw" / "state" / "paper_buy_intents.jsonl"


def _card_ticker(msg) -> str:
    """Read the ticker off an action/pick card (embed footer token first, then
    title, then content). Returns '?' if none found."""
    if not msg:
        return "?"
    try:
        for e in (msg.embeds or []):
            foot = (e.footer.text if e.footer else "") or ""
            m = re.search(r"tk:([A-Z.]{1,6})", foot)
            if m:
                return m.group(1)
            m = re.search(r"\b([A-Z]{2,5})\b", e.title or "")
            if m and m.group(1) not in ("ACTION", "TRADE", "IDEA"):
                return m.group(1)
    except Exception:
        pass
    c = msg.content or ""
    for pat in (r"TRADE IDEA — ([A-Z.]{1,6})", r"ACTION[^A-Za-z]+([A-Z.]{1,6})",
                r"\$([A-Z]{1,5})\b"):
        m = re.search(pat, c)
        if m:
            return m.group(1)
    return "?"


def _last_price(ticker: str):
    """Live underlying price (yfinance). None on failure."""
    try:
        import yfinance as yf
        i = yf.Ticker(ticker).history(period="1d", interval="5m")
        if len(i):
            return float(i["Close"].iloc[-1])
        h = yf.Ticker(ticker).history(period="1d")
        return float(h["Close"].iloc[-1]) if len(h) else None
    except Exception:
        return None


def _grade_ticker(ticker: str) -> str:
    """Grade a name vs today's logged flow-pick entry (underlying move in the
    pick's direction). Falls back to a plain live read when not in the log."""
    t = ticker.upper().strip()
    date = datetime.now(ET).strftime("%Y-%m-%d")
    log = Path.home() / ".openclaw" / "state" / f"flow_picks_log_{date}.jsonl"
    entry, rec = None, None
    if log.exists():
        try:
            for ln in log.read_text().splitlines():
                r = json.loads(ln)
                if str(r.get("symbol", "")).upper() == t and r.get("spot"):
                    entry, rec = float(r["spot"]), r
                    break
        except Exception:
            pass
    now = _last_price(t)
    if not now:
        return f"📊 {t}: couldn't fetch a live price right now."
    if entry and rec:
        move = (now - entry) / entry * 100
        is_call = str(rec.get("type", "C")).upper().startswith("C")
        fav = move if is_call else -move
        arrow = "🟢" if fav >= 0 else "🔴"
        return (f"📊 **GRADE — {t}**\nPicked at ${entry:,.2f} → now ${now:,.2f} = "
                f"**{move:+.1f}%** underlying\n{arrow} {'favorable' if fav >= 0 else 'against'} the "
                f"{'bullish' if is_call else 'bearish'} pick (**{fav:+.1f}%** in your direction)")
    return (f"📊 **{t}** ${now:,.2f} — not in today's pick log, no entry to grade against. "
            f"Use `/ticker {t}` for a fresh read.")


def _paper_keys(acct: str):
    # current paper keys post-2026-06-04 reset (alpaca-r1-* was deleted May 3)
    sec = Path.home() / ".openclaw" / "secrets"
    pairs = {"boba": ("alpaca-boba-key-id", "alpaca-boba-secret"),
             "jazzy": ("alpaca-jazzy-key-id", "alpaca-jazzy-secret")}
    a, b = pairs.get(acct, pairs["boba"])
    try:
        return (sec / a).read_text().strip(), (sec / b).read_text().strip()
    except Exception:
        return None, None


def _killswitch_on(acct: str) -> bool:
    return (Path.home() / ".openclaw" / "workspace" / "state" / f"{acct}_killswitch").exists()


def _log_paper_intent(ticker, acct, shares, price, cost, user):
    try:
        PAPER_INTENTS.parent.mkdir(parents=True, exist_ok=True)
        with open(PAPER_INTENTS, "a") as f:
            f.write(json.dumps({"ts": datetime.now(timezone.utc).isoformat(), "ticker": ticker,
                                "acct": acct, "shares": shares, "price": price, "cost": cost,
                                "user": user, "armed": _ARM_PAPER_BUY}) + "\n")
    except Exception as e:  # noqa: BLE001
        print(f"[paper-intent] {e}", flush=True)
    _journal(ticker, f"paper-buy-intent:{acct}:{shares}", user)


def _market_open(kid, ksec) -> bool:
    """Alpaca market clock. Fail-safe: if we can't confirm OPEN, treat as closed."""
    try:
        import urllib.request
        req = urllib.request.Request("https://paper-api.alpaca.markets/v2/clock",
            headers={"APCA-API-KEY-ID": kid, "APCA-API-SECRET-KEY": ksec})
        with urllib.request.urlopen(req, timeout=8) as r:
            return bool(json.loads(r.read()).get("is_open"))
    except Exception:
        return False


def _poll_fill(order_id, kid, ksec, tries=20, delay=0.5):
    """Poll an Alpaca order toward a terminal state. Returns (status, filled_qty,
    filled_avg_price). Same shape as the boba/jazzy decision-cycle fill loop."""
    import time
    import urllib.request
    status, fqty, favg = "accepted", 0, 0.0
    for _ in range(tries):
        time.sleep(delay)
        try:
            req = urllib.request.Request(
                f"https://paper-api.alpaca.markets/v2/orders/{order_id}",
                headers={"APCA-API-KEY-ID": kid, "APCA-API-SECRET-KEY": ksec})
            with urllib.request.urlopen(req, timeout=5) as r:
                o = json.loads(r.read())
            status = o.get("status", status)
            fqty = int(float(o.get("filled_qty") or 0))
            favg = float(o.get("filled_avg_price") or 0)
            if status in ("filled", "canceled", "rejected", "expired"):
                break
        except Exception:  # noqa: BLE001  — transient poll error, keep trying
            pass
    return status, fqty, favg


def _submit_paper_buy(acct, ticker, shares):
    """ARMED paper-order submit — Alpaca PAPER only. Reached ONLY when
    _ARM_PAPER_BUY is True (Mike's explicit go) AND the user taps ✅ Confirm.
    Idempotent: client_order_id is keyed to a 5-min bucket so a duplicate within
    that window is 422-rejected by Alpaca (the server-side double-tap backstop).
    Polls for the fill so the user sees a real FILLED price, not just 'submitted'."""
    if shares < 1:
        return "↳ nothing submitted (size < 1 share)."
    if _killswitch_on(acct):
        return f"🛑 {acct} killswitch is ON — order NOT submitted."
    kid, ksec = _paper_keys(acct)
    if not kid:
        return f"↳ no paper keys for '{acct}' — not submitted."
    if not _market_open(kid, ksec):
        return ("🕒 Market is CLOSED — a market order would queue and fill at the next open. "
                "NOT submitted. Use 🔔 Set Alert, or tap Paper Buy during market hours.")
    import urllib.error
    import urllib.request
    bucket = int(datetime.now(timezone.utc).timestamp()) // 300   # 5-min idempotency window
    coid = f"pb-{acct}-{ticker}-{shares}-{bucket}"
    body = json.dumps({"symbol": ticker, "qty": str(shares), "side": "buy",
                       "type": "market", "time_in_force": "day",
                       "client_order_id": coid}).encode()
    req = urllib.request.Request("https://paper-api.alpaca.markets/v2/orders", data=body,
        headers={"APCA-API-KEY-ID": kid, "APCA-API-SECRET-KEY": ksec,
                 "Content-Type": "application/json"})
    try:
        with urllib.request.urlopen(req, timeout=15) as r:
            o = json.loads(r.read())
    except urllib.error.HTTPError as e:
        if e.code == 422:
            return (f"⚠️ **{ticker} ({acct})** was already submitted in the last 5 min — "
                    "not sent again. Check your Alpaca orders/positions.")
        try:
            detail = e.read().decode()[:200]
        except Exception:  # noqa: BLE001
            detail = str(e)
        return f"↳ submit rejected ({e.code}): {detail}"
    except Exception as e:  # noqa: BLE001
        return f"↳ submit error: {e}"
    oid = str(o.get("id", ""))
    status, fqty, favg = _poll_fill(oid, kid, ksec)
    if status == "filled" and favg:
        return f"✅ **FILLED** — BUY {fqty} {ticker} @ ${favg:,.2f} ({acct}) · order {oid[:8]}"
    if status in ("rejected", "canceled", "expired"):
        return f"⚠️ order {oid[:8]} {status} ({ticker} · {acct}) — nothing is held."
    return (f"✅ Submitted PAPER order {oid[:8]} — BUY {shares} {ticker} ({acct})\n"
            f"⏳ not filled within 10s ({status}); it should fill on the next tick — "
            "📊 Grade or #main-portfolios will confirm.")


def _paper_buy_preview(ticker, account, deploy_str, user):
    """PREVIEW ONLY — sizes the trade against the caps, logs the intent, and returns
    (preview_text, params). params is None when there's nothing to confirm (sub-1-share,
    no live price, or disarmed); otherwise it's the dict ConfirmBuyView needs to place
    the order. The order is NEVER submitted here — only on an explicit ✅ Confirm tap."""
    t = ticker.upper().strip()
    acct = "jazzy" if str(account).lower().startswith("j") else "boba"
    try:
        want = float(str(deploy_str).replace("$", "").replace(",", ""))
    except ValueError:
        want = 150.0
    price = _last_price(t)
    eq = total_equity()
    if not price:
        return f"⚠️ Couldn't fetch a live price for {t}; preview aborted.", None
    cap = 800.0                                   # Mike's hard $800/trade cap
    if eq:
        cap = min(cap, 0.5 * eq)                  # never >50% of equity in one paper name
    deploy = min(max(want, 0.0), cap)
    capped = deploy < want
    shares = int(deploy // price)
    cost = shares * price
    lines = [f"🧾 **PAPER BUY PREVIEW — {t}** · acct `{acct}`",
             f"Live ~${price:,.2f} · deploy ${deploy:,.0f}"
             + (f" ({deploy/eq*100:.1f}% of ${eq:,.0f} equity)" if eq else "")
             + (f"  _(capped from ${want:,.0f})_" if capped else "")]
    if shares < 1:
        lines.append(f"➡️ ${deploy:,.0f} buys <1 share at ${price:,.2f} — raise the amount or pick a cheaper name.")
        _log_paper_intent(t, acct, shares, price, cost, user)
        return "\n".join(lines), None
    lines.append(f"➡️ will submit **BUY {shares} {t}** (~${cost:,.0f}"
                 + (f", {cost/eq*100:.0f}% of equity" if eq else "") + ")")
    if eq and cost > eq * 0.5:
        lines.append("⚠️ >50% of equity in one name — concentration risk.")
    _log_paper_intent(t, acct, shares, price, cost, user)
    if not _ARM_PAPER_BUY:
        lines.append("🔒 **Paper-buy submit is NOT armed** — logged as an intent only, no order placed.")
        return "\n".join(lines), None
    lines.append("\n**Tap ✅ Confirm to place this PAPER order — or ✖ Cancel.**")
    return "\n".join(lines), {"acct": acct, "ticker": t, "shares": shares, "price": price}


class BuyModal(discord.ui.Modal):
    def __init__(self, ticker: str):
        super().__init__(title=f"Paper Buy — {ticker}"[:45])
        self.ticker = ticker
        self.account = discord.ui.TextInput(label="Account (boba / jazzy)", default="boba",
                                            required=True, max_length=10)
        self.deploy = discord.ui.TextInput(label="$ to deploy (max 800)", default="150",
                                           required=True, max_length=6)
        self.add_item(self.account)
        self.add_item(self.deploy)

    async def on_submit(self, interaction: discord.Interaction):
        await interaction.response.defer(thinking=True, ephemeral=True)
        text, params = await asyncio.to_thread(_paper_buy_preview, self.ticker, str(self.account),
                                               str(self.deploy), interaction.user.display_name)
        if not params:
            await interaction.followup.send(text, ephemeral=True)
            return
        bucket = int(datetime.now(timezone.utc).timestamp()) // 300
        token = (f"cb:{params['acct']}|{params['ticker']}|{params['shares']}"
                 f"|{params['price']:.2f}|{bucket}")
        # ephemeral preview + Confirm/Cancel; order params ride in the content token
        await interaction.followup.send(f"{text}\n`{token}`", view=ConfirmBuyView(), ephemeral=True)


class AlertModal(discord.ui.Modal):
    def __init__(self, ticker: str):
        super().__init__(title=f"Set Alert — {ticker}"[:45])
        self.ticker = ticker
        self.price = discord.ui.TextInput(label="Trigger price", required=True, max_length=12)
        self.direction = discord.ui.TextInput(label="Direction: above / below", default="above",
                                              required=True, max_length=6)
        self.note = discord.ui.TextInput(label="Note (optional)", required=False,
                                         style=discord.TextStyle.paragraph, max_length=120)
        for it in (self.price, self.direction, self.note):
            self.add_item(it)

    async def on_submit(self, interaction: discord.Interaction):
        try:
            p = float(str(self.price).replace("$", "").replace(",", ""))
        except ValueError:
            await interaction.response.send_message("⚠️ Couldn't read that price.", ephemeral=True)
            return
        d = "below" if str(self.direction).lower().startswith("b") else "above"
        await asyncio.to_thread(price_alerts.add_alert, self.ticker, p, d,
                                str(self.note), interaction.user.display_name)
        await interaction.response.send_message(
            f"🔔 Alert set: **{self.ticker}** {d} **${p:,.2f}**. I'll ping you when it crosses.",
            ephemeral=True)


# ─── OPTIONS PAYOFF (autofilled + interactive) ────────────────────────────────
def _card_contract(msg) -> dict:
    """Parse (ticker, strike, opt_type, expiry) off a card; missing fields → autofill defaults."""
    t = _card_ticker(msg)
    text = msg.content or ""
    if not text and getattr(msg, "embeds", None):
        e = msg.embeds[0]
        text = " ".join(x for x in (e.title, e.description,
                        (e.footer.text if e.footer else "")) if x)
    strike = opt_type = expiry = None
    m = re.search(r"\$([\d.]+)\s*([CP])\b", text)
    if m:
        strike = float(m.group(1)); opt_type = "call" if m.group(2) == "C" else "put"
    m2 = re.search(r"\b(\d{1,2})/(\d{1,2})\b", text)
    if m2:
        try:
            expiry = f"{datetime.now(ET).year}-{int(m2.group(1)):02d}-{int(m2.group(2)):02d}"
        except Exception:
            expiry = None
    return {"ticker": t, "strike": strike, "opt_type": opt_type, "expiry": expiry}


def _build_payoff(ticker, strike=None, opt_type=None, expiry=None, contracts=1):
    from lib import options
    return options.autofill(ticker, strike, opt_type, expiry, contracts)


def _payoff_token(spec) -> str:
    return f"pf:{spec['symbol']}|{spec['strike']:g}|{spec['opt_type']}|{spec['expiry']}|{spec['contracts']}"


def _parse_payoff_token(text):
    m = re.search(r"pf:([A-Z.]{1,6})\|([\d.]+)\|(call|put)\|([\d-]+)\|(\d+)", text or "")
    if not m:
        return None
    return {"symbol": m.group(1), "strike": float(m.group(2)), "opt_type": m.group(3),
            "expiry": m.group(4), "contracts": int(m.group(5))}


def _payoff_png_caption(spec):
    from lib import chart_renderer as cr
    png = cr.payoff_card(spec)
    cp = "C" if spec["opt_type"] == "call" else "P"
    cap = (f"📈 **{spec['symbol']} ${spec['strike']:g}{cp} {spec['expiry']}** · {spec['contracts']}x "
           f"· B/E ${spec['breakeven']} · Δ{spec['delta']} · θ{spec['theta']}\n`{_payoff_token(spec)}`")
    return png, cap


PAY_DEC, PAY_INC, PAY_FLIP = "pf:dec", "pf:inc", "pf:flip"


class PayoffView(discord.ui.View):
    """Interactive payoff — tweak contracts / flip C/P; the diagram re-renders in place."""
    def __init__(self):
        super().__init__(timeout=None)

    async def _adjust(self, interaction, dcontracts=0, flip=False):
        await interaction.response.defer()
        cur = _parse_payoff_token(interaction.message.content)
        if not cur:
            await interaction.followup.send("Can't read this payoff's parameters.", ephemeral=True)
            return
        ot = ("put" if cur["opt_type"] == "call" else "call") if flip else cur["opt_type"]
        ct = max(1, cur["contracts"] + dcontracts)
        spec = await asyncio.to_thread(_build_payoff, cur["symbol"], cur["strike"], ot, cur["expiry"], ct)
        if not spec:
            await interaction.followup.send("Couldn't rebuild the payoff.", ephemeral=True)
            return
        png, cap = _payoff_png_caption(spec)
        if png:
            from lib import ops_card as oc
            await asyncio.to_thread(oc.edit_message_image_bot, str(interaction.channel_id),
                                    TOKEN, str(interaction.message.id), png, cap)

    @discord.ui.button(label="−1", style=discord.ButtonStyle.secondary, custom_id=PAY_DEC)
    async def b_dec(self, interaction: discord.Interaction, button: discord.ui.Button):
        await self._adjust(interaction, dcontracts=-1)

    @discord.ui.button(label="+1", style=discord.ButtonStyle.secondary, custom_id=PAY_INC)
    async def b_inc(self, interaction: discord.Interaction, button: discord.ui.Button):
        await self._adjust(interaction, dcontracts=+1)

    @discord.ui.button(label="Flip C/P", emoji="🔁", style=discord.ButtonStyle.primary, custom_id=PAY_FLIP)
    async def b_flip(self, interaction: discord.Interaction, button: discord.ui.Button):
        await self._adjust(interaction, flip=True)


CB_CONFIRM, CB_CANCEL = "cb:confirm", "cb:cancel"


def _parse_buy_token(text):
    """Read the order params off a Paper Buy preview's `cb:acct|TICKER|shares|price|bucket` token."""
    m = re.search(r"cb:(boba|jazzy)\|([A-Z.]{1,6})\|(\d+)\|([\d.]+)\|(\d+)", text or "")
    if not m:
        return None
    return {"acct": m.group(1), "ticker": m.group(2), "shares": int(m.group(3)),
            "price": float(m.group(4)), "bucket": int(m.group(5))}


class ConfirmBuyView(discord.ui.View):
    """Two-step paper-buy gate: the order is placed ONLY when ✅ Confirm is tapped,
    and both buttons disable on the first tap so a second click is a no-op. The 5-min
    client_order_id in _submit_paper_buy is the server-side duplicate backstop."""
    def __init__(self):
        super().__init__(timeout=None)

    async def _disable(self, interaction, note):
        for c in self.children:
            c.disabled = True
        try:
            await interaction.response.edit_message(content=note, view=self)
        except Exception:  # noqa: BLE001  — already edited / expired; non-fatal
            pass

    @discord.ui.button(label="Confirm", emoji="✅",
                       style=discord.ButtonStyle.success, custom_id=CB_CONFIRM)
    async def b_confirm(self, interaction: discord.Interaction, button: discord.ui.Button):
        p = _parse_buy_token(interaction.message.content if interaction.message else "")
        if not p:
            await self._disable(interaction, "↳ couldn't read the order — tap 🧾 Paper Buy again.")
            return
        await self._disable(interaction, f"⏳ Placing **BUY {p['shares']} {p['ticker']}** ({p['acct']})…")
        res = await asyncio.to_thread(_submit_paper_buy, p["acct"], p["ticker"], p["shares"])
        await interaction.followup.send(res, ephemeral=True)

    @discord.ui.button(label="Cancel", emoji="✖",
                       style=discord.ButtonStyle.secondary, custom_id=CB_CANCEL)
    async def b_cancel(self, interaction: discord.Interaction, button: discord.ui.Button):
        await self._disable(interaction, "✖ Cancelled — no order placed.")


class ActionView(discord.ui.View):
    def __init__(self):
        super().__init__(timeout=None)

    @discord.ui.button(label="Paper Buy", emoji="🧾",
                       style=discord.ButtonStyle.success, custom_id=ACT_BUY)
    async def b_buy(self, interaction: discord.Interaction, button: discord.ui.Button):
        await interaction.response.send_modal(BuyModal(_card_ticker(interaction.message)))

    @discord.ui.button(label="Set Alert", emoji="🔔",
                       style=discord.ButtonStyle.secondary, custom_id=ACT_ALERT)
    async def b_alert(self, interaction: discord.Interaction, button: discord.ui.Button):
        await interaction.response.send_modal(AlertModal(_card_ticker(interaction.message)))

    @discord.ui.button(label="Explain", emoji="📖",
                       style=discord.ButtonStyle.primary, custom_id=ACT_EXPLAIN)
    async def b_explain(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _card_ticker(interaction.message)
        await interaction.response.defer(thinking=True)
        await _send_chunks(interaction, await _answer_skill(f"/options-desk {t}", timeout=300))

    @discord.ui.button(label="Grade", emoji="📊",
                       style=discord.ButtonStyle.secondary, custom_id=ACT_GRADE)
    async def b_grade(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _card_ticker(interaction.message)
        await interaction.response.defer(thinking=True)
        await interaction.followup.send(await asyncio.to_thread(_grade_ticker, t))

    @discord.ui.button(label="Mute", emoji="🔇",
                       style=discord.ButtonStyle.danger, custom_id=ACT_MUTE)
    async def b_mute(self, interaction: discord.Interaction, button: discord.ui.Button):
        t = _card_ticker(interaction.message)
        await asyncio.to_thread(card_mute.mute, t, 6)
        await interaction.response.send_message(
            f"🔇 Muted **{t}** for ~6h — posters will skip it.", ephemeral=True)

    @discord.ui.button(label="Payoff", emoji="📈", row=1,
                       style=discord.ButtonStyle.primary, custom_id=ACT_PAYOFF)
    async def b_payoff(self, interaction: discord.Interaction, button: discord.ui.Button):
        await interaction.response.defer(thinking=True)
        c = _card_contract(interaction.message)
        spec = await asyncio.to_thread(_build_payoff, c["ticker"], c.get("strike"),
                                       c.get("opt_type"), c.get("expiry"), 1)
        if not spec:
            await interaction.followup.send(f"Couldn't build a payoff for {c['ticker']}.")
            return
        png, cap = _payoff_png_caption(spec)
        if not png:
            await interaction.followup.send("Payoff render failed.")
            return
        await interaction.followup.send(content=cap, file=discord.File(png), view=PayoffView())


intents = discord.Intents.default()
# Only request the privileged message-content intent if a channel listener is configured.
if CHANNEL_ID:
    intents.message_content = True

client = discord.Client(intents=intents)
tree = app_commands.CommandTree(client)


@tree.command(name="aime", description="Ask AInvest AIME (market/stock/options intelligence)")
@app_commands.describe(question="What do you want to ask AIME?")
async def aime_cmd(interaction: discord.Interaction, question: str):
    await interaction.response.defer(thinking=True)
    ans = await _answer(question)
    parts = list(_chunks(ans))
    await interaction.followup.send(parts[0])
    for p in parts[1:]:
        await interaction.followup.send(p)


# ─── TRADING SLASH COMMANDS (each shells to a Claude skill on the subscription) ──
# Wave 1 — the daily-driver eight.
@tree.command(name="ainvest", description="AInvest copilot read on a ticker or question")
@app_commands.describe(query="ticker or question")
async def ainvest_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/ainvest {query}"))


@tree.command(name="options", description="Options-desk verdict (optionally attach a chain/position screenshot)")
@app_commands.describe(ticker="ticker or options question", screenshot="optional chain/position screenshot")
async def options_cmd(interaction: discord.Interaction, ticker: str,
                      screenshot: Optional[discord.Attachment] = None):
    await interaction.response.defer(thinking=True)
    prompt = f"/options-desk {ticker}"
    if screenshot is not None:
        path = os.path.join(tempfile.gettempdir(), f"opt_{interaction.id}_{screenshot.filename}")
        await screenshot.save(path)
        prompt = f"/options-desk {ticker} — read the attached screenshot at {path} for the chain/position."
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=420))


@tree.command(name="ticker", description="2-minute vet of the name behind a signal")
@app_commands.describe(symbol="ticker symbol")
async def ticker_cmd(interaction: discord.Interaction, symbol: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/ticker-research {symbol}"))


@tree.command(name="regime", description="Market regime / macro lens (optional ticker)")
@app_commands.describe(symbol="optional ticker for context")
async def regime_cmd(interaction: discord.Interaction, symbol: Optional[str] = None):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/market-context {symbol or ''}".strip()))


@tree.command(name="news", description="Market / company news + catalysts")
@app_commands.describe(query="ticker or topic")
async def news_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/news-search {query}"))


@tree.command(name="trades", description="What fired today — flow alerts / auto-trader / top tickers")
@app_commands.describe(query="optional filter (e.g. 'NVDA' or 'top tickers')")
async def trades_cmd(interaction: discord.Interaction, query: Optional[str] = None):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/mc-trades {query or 'what fired today'}"))


@tree.command(name="decide", description="Combined SQL+RAG buy/sell/hold decision packet")
@app_commands.describe(query="the trade question")
async def decide_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/mc-decide {query}", timeout=540))


@tree.command(name="signals", description="Signal-source liveness sweep (is anything dead?)")
async def signals_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill("/signal-liveness"))


# Wave 2 — heavier / scheduled skills, now also manually triggerable.
@tree.command(name="desk-eod", description="End-of-day desk wrap (P&L + hit-rate across pipelines)")
async def desk_eod_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill("/desk-eod", timeout=540))


@tree.command(name="morning", description="Morning note — overnight SPY/QQQ/BTC + Fed + headlines")
async def morning_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill("/morning-note", timeout=420))


@tree.command(name="crypto", description="Crypto desk read on a coin")
@app_commands.describe(coin="coin symbol (BTC, ETH, SOL...)")
async def crypto_cmd(interaction: discord.Interaction, coin: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/crypto-desk {coin}"))


@tree.command(name="recall", description="Search the Mission Control knowledge base (docs/memory/bible)")
@app_commands.describe(query="what to look up")
async def recall_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/mc-recall {query}", timeout=420))


@tree.command(name="summarize", description="TL;DR of recent activity in a channel (trader-relevant)")
@app_commands.describe(channel="channel to summarize (default: here)",
                       limit="how many recent messages (default 50, max 200)")
async def summarize_cmd(interaction: discord.Interaction,
                        channel: Optional[discord.TextChannel] = None,
                        limit: Optional[int] = None):
    await interaction.response.defer(thinking=True)
    ch = channel or interaction.channel
    chname = getattr(ch, "name", "channel")
    n = max(10, min(limit or 50, 200))
    try:
        # REST history returns message content WITHOUT the privileged intent
        msgs = [m async for m in ch.history(limit=n)]
    except discord.Forbidden:
        await interaction.followup.send(
            f"⚠️ I can't read #{chname} — missing View Channel / Read Message History permission there.")
        return
    except Exception as e:  # noqa: BLE001
        await interaction.followup.send(f"⚠️ Couldn't read #{chname}: {e}")
        return
    lines = []
    for m in reversed(msgs):  # oldest → newest
        content = (m.content or "").strip()
        if not content and m.embeds:
            e = m.embeds[0]
            content = " ".join(x for x in (e.title, e.description) if x).strip()
        if not content:
            continue
        author = getattr(m.author, "display_name", None) or m.author.name
        lines.append(f"[{author}] {content}")
    if not lines:
        await interaction.followup.send(f"Nothing readable in #{chname} (last {n} messages).")
        return
    transcript = "\n".join(lines)[-6000:]
    prompt = (f"Summarize this Discord trading channel (#{chname}) for a day trader. Tight TL;DR: "
              f"the key signals/alerts, tickers + setups mentioned, notable decisions or errors, and "
              f"the single most actionable takeaway. Bullet points, no fluff.\n\n"
              f"--- transcript (oldest→newest) ---\n{transcript}")
    summary = await _answer_skill(prompt, timeout=300)
    await _send_chunks(interaction, f"📋 **SUMMARY — #{chname}** (last {len(lines)} msgs)\n\n{summary}")


# ─── X / SOCIAL LANE (Tavily/WebSearch bridge until native Grok-on-subscription is wired) ──
@tree.command(name="x", description="What's X/Twitter saying about a ticker (social sentiment)")
@app_commands.describe(query="ticker or topic")
async def x_cmd(interaction: discord.Interaction, query: str):
    await interaction.response.defer(thinking=True)
    # Prefer native Grok x_search on the OAuth subscription (real X firehose); fall
    # back to the web/Tavily bridge until Mike mints the token via ~/bin/grok-sub-login.
    native = await asyncio.to_thread(x_search.x_sentiment, query)
    if native:
        await _send_chunks(interaction, f"🐦 **X SENTIMENT — {query}** _(native Grok)_\n{native}")
        return
    prompt = (f"Search X.com / Twitter for the most important trader-relevant posts about {query} "
              f"in the last 24h (use web search). Summarize the prevailing sentiment (bullish/"
              f"bearish), any notable accounts/posts, and catalysts. Keep it tight.")
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=300))


@tree.command(name="flowpicks", description="Rank today's biggest options flow by risk-adjusted setup quality")
async def flowpicks_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    prompt = ("/ainvest rank the most significant options flow today by risk-adjusted setup "
              "quality — top 5 with ticker, contract, why it stands out, and entry logic.")
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=420))


@tree.command(name="portfolio", description="Live positions + P&L across Boba + Jazzy")
async def portfolio_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    # deterministic Alpaca read (no LLM) — fast
    await _send_chunks(interaction, await asyncio.to_thread(portfolio_summary))


@tree.command(name="pick", description="Post an actionable trade-idea card with Took-it / Skip / Analyze buttons")
@app_commands.describe(ticker="ticker", note="optional thesis / contract / note")
async def pick_cmd(interaction: discord.Interaction, ticker: str, note: Optional[str] = None):
    ticker = ticker.upper().strip()
    body = f"🎯 **TRADE IDEA — {ticker}**"
    if note:
        body += f"\n{note}"
    body += "\n*Tap a button — log it, skip, or pull a full vet.*"
    await interaction.response.send_message(body, view=PickView())


@tree.command(name="deck", description="Action card for a ticker — Paper Buy / Set Alert / Explain / Grade / Mute")
@app_commands.describe(ticker="ticker", note="optional context / contract")
async def deck_cmd(interaction: discord.Interaction, ticker: str, note: Optional[str] = None):
    t = ticker.upper().strip()
    body = f"⚡ **ACTION — {t}**"
    if note:
        body += f"\n{note}"
    body += "\n*Tap to act — paper-buy preview · price alert · explain · grade · mute · payoff.*"
    await interaction.response.send_message(body, view=ActionView())


@tree.command(name="payoff", description="Options payoff diagram — autofilled from the live chain (just give a ticker)")
@app_commands.describe(ticker="ticker", strike="optional strike (default ATM)",
                       option_type="call or put (default call)", contracts="contracts (default 1)")
async def payoff_cmd(interaction: discord.Interaction, ticker: str, strike: Optional[float] = None,
                     option_type: Optional[str] = None, contracts: Optional[int] = 1):
    await interaction.response.defer(thinking=True)
    spec = await asyncio.to_thread(_build_payoff, ticker, strike, option_type, None, contracts or 1)
    if not spec:
        await interaction.followup.send(f"Couldn't build a payoff for {ticker.upper().strip()} "
                                        f"(no option chain / price).")
        return
    png, cap = _payoff_png_caption(spec)
    if not png:
        await interaction.followup.send("Payoff render failed.")
        return
    await interaction.followup.send(content=cap, file=discord.File(png), view=PayoffView())


@tree.command(name="positions", description="Real-money holdings review (Robinhood + Coinbase) — allocation card")
async def positions_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)

    def _run():
        import positions_review as pr
        from lib import chart_renderer as cr
        r = pr.review()
        if not r:
            return None, "No real-money holdings right now (ARIES broker reads unreachable?)."
        spec, holdings, total, flags = r
        return cr.holdings_card(spec), pr.text_read(holdings, total, flags)

    png, txt = await asyncio.to_thread(_run)
    if png:
        await interaction.followup.send(content=txt[:1900], file=discord.File(png))
    else:
        await interaction.followup.send(txt)


@tree.command(name="watch", description="Add a ticker to your watchlist (feeds the scheduled intel)")
@app_commands.describe(ticker="ticker to watch")
async def watch_cmd(interaction: discord.Interaction, ticker: str):
    wl = await asyncio.to_thread(add_watch, ticker)
    await interaction.response.send_message(
        f"👁️ Watching **{ticker.upper().strip()}** — it'll show up in your X-sentiment, "
        f"opening read, and news feeds.\nWatchlist: {', '.join(wl) or '(empty)'}")


@tree.command(name="unwatch", description="Remove a ticker from your watchlist")
@app_commands.describe(ticker="ticker to remove")
async def unwatch_cmd(interaction: discord.Interaction, ticker: str):
    wl = await asyncio.to_thread(remove_watch, ticker)
    await interaction.response.send_message(
        f"✖️ Unwatched **{ticker.upper().strip()}**.\nWatchlist: {', '.join(wl) or '(empty)'}")


@tree.command(name="watchlist", description="Show your watchlist")
async def watchlist_cmd(interaction: discord.Interaction):
    wl = await asyncio.to_thread(get_watchlist)
    await interaction.response.send_message(f"👁️ Watchlist: {', '.join(wl) or '(empty)'}")


HELP_TEXT = (
    "⚡ **MISSION CONTROL — COMMAND DECK**\n\n"
    "**📊 Analysis (ask anytime)**\n"
    "`/ainvest <q>` read on anything · `/options <ticker>` options verdict (+screenshot)\n"
    "`/ticker <sym>` 2-min vet · `/decide <q>` buy/sell/hold · `/crypto <coin>` crypto read\n"
    "`/news <q>` catalysts · `/regime` market regime · `/recall <q>` knowledge base\n\n"
    "**💼 Portfolio, trades & planning**\n"
    "`/portfolio` live P&L · `/scorecard` EOD book + pick grades · `/journal` recap · `/week` weekly · `/trades` fills\n"
    "`/levels <t>` S/R + entry/stop · `/size <t> <entry> <stop>` position size · `/pick <t>` action card\n"
    "`/flowpicks` ranked flow · `/signals` source liveness\n\n"
    "**👁️ Watchlist** (feeds your scheduled intel)\n"
    "`/watch <t>` · `/unwatch <t>` · `/watchlist`\n\n"
    "**🐦 Intel & briefs**\n"
    "`/x <ticker>` social sentiment · `/summarize [#chan]` channel TL;DR · `/desk-eod` EOD wrap · "
    "`/morning` morning note · `/aime <q>`\n\n"
    "**🛰️ Runs automatically:** morning briefing + events (8:05/8:15) · opening read (9:35) · "
    "**flow picks → #flow-picks (9:50/11/12:30/2/3:20)** · regime/news/X-sentiment (native Grok) · "
    "position-mgmt (11:30/2:00) · power hour (2:55) · portfolio snapshots (9:35/4:05) · "
    "**your-crypto alerts → #daily-crypto-pumps (24h ≥5% /30m + 15-min spike ≥3% /5m)** · "
    "risk/exit/shock alerts."
)


@tree.command(name="help", description="Show the full command deck + what runs automatically")
async def help_cmd(interaction: discord.Interaction):
    await interaction.response.send_message(HELP_TEXT)


@tree.command(name="size", description="Position size for a trade per your risk rules (equity fraction, $800 cap)")
@app_commands.describe(ticker="ticker", entry="entry price", stop="stop price",
                       risk="$ to risk (default 150, capped at 800)")
async def size_cmd(interaction: discord.Interaction, ticker: str, entry: float,
                   stop: float, risk: Optional[float] = None):
    await interaction.response.defer(thinking=True)
    eq = await asyncio.to_thread(total_equity)
    risk_amt = min(risk if risk else 150.0, 800.0)   # Mike's risk cap (raised 250→800 2026-06-15)
    psr = abs(entry - stop)
    if psr <= 0:
        await interaction.followup.send("⚠️ Entry and stop can't be equal.")
        return
    shares = int(risk_amt // psr)
    cost = shares * entry
    lines = [f"📐 **SIZE — {ticker.upper().strip()}**"]
    if eq:
        lines.append(f"Equity ${eq:,.0f} · risking ${risk_amt:,.0f} ({risk_amt/eq*100:.1f}% of equity)")
    else:
        lines.append(f"Risking ${risk_amt:,.0f}")
    lines.append(f"Entry ${entry:.2f} → stop ${stop:.2f} = ${psr:.2f}/share risk")
    cost_tag = f" ({cost/eq*100:.0f}% of equity)" if eq else ""
    lines.append(f"➡️ **{shares} shares** (~${cost:,.0f}{cost_tag})")
    lines.append(f"Max loss if stopped: **${shares*psr:,.0f}**")
    if shares == 0:
        lines.append("⚠️ Stop too wide for the risk budget — tighten the stop or raise risk.")
    elif eq and cost > eq:
        lines.append("⚠️ Cost exceeds account equity — reduce size.")
    elif eq and cost > eq * 0.5:
        lines.append("⚠️ >50% of equity in one name — concentration risk.")
    await interaction.followup.send("\n".join(lines))


@tree.command(name="journal", description="Today's trade recap — day P&L, fills, open book")
async def journal_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await asyncio.to_thread(daily_journal_recap))


@tree.command(name="week", description="This week's performance review (P&L, trades, most active)")
async def week_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await asyncio.to_thread(weekly_review))


@tree.command(name="scorecard", description="EOD scorecard on demand — book P&L + today's flow-pick grades")
async def scorecard_cmd(interaction: discord.Interaction):
    await interaction.response.defer(thinking=True)

    def _run():
        r = subprocess.run(
            ["/home/itsju/.venv/bin/python",
             "/home/itsju/05_AUTOMATION/scripts/eod_scorecard.py", "--print"],
            capture_output=True, text=True, timeout=150)
        return (r.stdout or r.stderr or "[no output]").strip()

    await _send_chunks(interaction, await asyncio.to_thread(_run))


@tree.command(name="levels", description="Key support/resistance + a suggested entry & stop (plug into /size)")
@app_commands.describe(ticker="ticker")
async def levels_cmd(interaction: discord.Interaction, ticker: str):
    await interaction.response.defer(thinking=True)
    t = ticker.upper().strip()
    prompt = (f"For {t}: list the key intraday and swing SUPPORT and RESISTANCE levels with the "
              f"current price, then give a concrete suggested ENTRY and STOP for a long (say clearly "
              f"if it's a no-trade / wait setup). Format tight, and put 'Entry X / Stop Y' on its own "
              f"line so it plugs into /size. End with a one-line bias. Use web search for live levels.")
    await _send_chunks(interaction, await _answer_skill(prompt, timeout=300))


# ─── POLISH: ticker autocomplete + right-click context menus (Phase 5) ────────
_AC_DEFAULTS = ["SPY", "QQQ", "NVDA", "TSLA", "AAPL", "AMD", "MSFT", "META",
                "AMZN", "GOOGL", "SOFI", "PLTR", "COIN", "MSTR"]


async def _ac_ticker(interaction: discord.Interaction, current: str):
    """Autocomplete tickers from the watchlist + common names."""
    cur = (current or "").upper()
    try:
        wl = await asyncio.to_thread(get_watchlist)
    except Exception:
        wl = []
    pool = list(dict.fromkeys([w.upper() for w in wl] + _AC_DEFAULTS))
    hits = [t for t in pool if cur in t][:25]
    return [app_commands.Choice(name=t, value=t) for t in hits]


# attach to every ticker-arg command (param names differ per command)
for _cmd, _param in ((ticker_cmd, "symbol"), (options_cmd, "ticker"), (levels_cmd, "ticker"),
                     (deck_cmd, "ticker"), (payoff_cmd, "ticker"), (watch_cmd, "ticker"),
                     (unwatch_cmd, "ticker")):
    try:
        _cmd.autocomplete(_param)(_ac_ticker)
    except Exception as _e:  # noqa: BLE001
        print(f"[autocomplete] {_param}: {_e}", flush=True)


async def _ctx_explain(interaction: discord.Interaction, message: discord.Message):
    t = _card_ticker(message)
    if t == "?":
        await interaction.response.send_message("Couldn't find a ticker in that message.", ephemeral=True)
        return
    await interaction.response.defer(thinking=True)
    await _send_chunks(interaction, await _answer_skill(f"/options-desk {t}", timeout=300))


async def _ctx_grade(interaction: discord.Interaction, message: discord.Message):
    t = _card_ticker(message)
    if t == "?":
        await interaction.response.send_message("Couldn't find a ticker in that message.", ephemeral=True)
        return
    await interaction.response.defer(thinking=True)
    await interaction.followup.send(await asyncio.to_thread(_grade_ticker, t))


tree.add_command(app_commands.ContextMenu(name="Explain this", callback=_ctx_explain))
tree.add_command(app_commands.ContextMenu(name="Grade this", callback=_ctx_grade))


# ─── SCHEDULED EVENTS + SIDEBAR PRESENCE (Phase 4) ────────────────────────────
MACRO_CAL = Path.home() / "05_AUTOMATION" / "scripts" / "data" / "macro_calendar.json"
EVENTS_STATE = Path.home() / ".openclaw" / "state" / "discord_events.json"


def _macro_events() -> list[dict]:
    """Dated macro/OPEX events from the hardcoded calendar → [{key,title,start,note}]."""
    try:
        d = json.loads(MACRO_CAL.read_text())
    except Exception:
        return []
    out = []
    for e in d.get("events", []):
        try:
            dt = datetime.strptime(f"{e['date']} {e.get('time', '09:30')}",
                                   "%Y-%m-%d %H:%M").replace(tzinfo=ET)
        except Exception:
            continue
        out.append({"key": f"{e['date']}:{e.get('kind', '')}:{e['title']}",
                    "title": e["title"], "start": dt,
                    "note": (e.get("note") or e.get("kind") or "Macro").strip()})
    return out


def _load_events_state() -> dict:
    try:
        return json.loads(EVENTS_STATE.read_text())
    except Exception:
        return {}


def _save_events_state(d: dict) -> None:
    try:
        EVENTS_STATE.parent.mkdir(parents=True, exist_ok=True)
        EVENTS_STATE.write_text(json.dumps(d, indent=2))
    except Exception:
        pass


@tasks.loop(minutes=3)
async def presence_loop():
    """Sidebar ticker = live regime line (RISK-ON · SPY .. · VIX .. · BTC ..)."""
    try:
        r = await asyncio.to_thread(regime_lib.regime)
        txt = (r.get("line") or "")[:120]
        if txt:
            await client.change_presence(activity=discord.CustomActivity(name=txt))
    except Exception as e:  # noqa: BLE001
        print(f"[presence] {e}", flush=True)


@presence_loop.before_loop
async def _before_presence():
    await client.wait_until_ready()


@tasks.loop(hours=12)
async def events_loop():
    """Create Discord scheduled events for upcoming macro/OPEX dates (deduped)."""
    gid = os.environ.get("AIME_GUILD_ID")
    if not gid:
        return
    guild = client.get_guild(int(gid))
    if not guild:
        return
    created = _load_events_state()
    now = datetime.now(ET)
    horizon = now + timedelta(days=21)         # only create within ~3 weeks out
    changed = False
    for ev in _macro_events():
        if ev["key"] in created:
            continue
        start = ev["start"]
        if start <= now or start > horizon:
            continue
        try:
            await guild.create_scheduled_event(
                name=ev["title"][:100],
                start_time=start, end_time=start + timedelta(hours=1),
                entity_type=discord.EntityType.external,
                privacy_level=discord.PrivacyLevel.guild_only,
                location=(ev["note"] or "Macro calendar")[:100],
                description="Auto-scheduled from the Mission Control macro calendar.")
            created[ev["key"]] = now.isoformat()
            changed = True
            print(f"[events] created '{ev['title']}' @ {start:%b %-d %-I:%M%p ET}", flush=True)
        except Exception as e:  # noqa: BLE001
            print(f"[events] create err {ev['title']}: {e}", flush=True)
    if changed:
        _save_events_state(created)


@events_loop.before_loop
async def _before_events():
    await client.wait_until_ready()


_VIEWS_ADDED = False


@client.event
async def on_ready():
    global _VIEWS_ADDED
    if not _VIEWS_ADDED:
        client.add_view(PickView())     # persistent — buttons survive restarts
        client.add_view(ActionView())   # Paper Buy / Set Alert / Explain / Grade / Mute / Payoff
        client.add_view(PayoffView())   # interactive payoff (−/+ contracts, flip C/P)
        client.add_view(ConfirmBuyView())  # two-step paper-buy ✅ Confirm / ✖ Cancel
        _VIEWS_ADDED = True
        if not presence_loop.is_running():
            presence_loop.start()
        if not events_loop.is_running():
            events_loop.start()
    try:
        gid = os.environ.get("AIME_GUILD_ID")
        if gid:
            g = discord.Object(id=int(gid))
            tree.copy_global_to(guild=g)
            await tree.sync(guild=g)
        else:
            await tree.sync()
    except Exception as e:  # noqa: BLE001
        print(f"[aime-discord] slash sync failed: {e}", flush=True)
    print(f"[aime-discord] ready as {client.user} | channel_listen={'on' if CHANNEL_ID else 'off'}",
          flush=True)


@client.event
async def on_message(message: discord.Message):
    if message.author.bot or not CHANNEL_ID or message.channel.id != CHANNEL_ID:
        return
    q = (message.content or "").strip()
    if not q or q.startswith("/"):
        return
    async with message.channel.typing():
        ans = await _answer(q)
    for p in _chunks(ans):
        await message.channel.send(p)


if __name__ == "__main__":
    client.run(TOKEN)
