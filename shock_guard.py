#!/usr/bin/env python3
"""shock_guard.py — headline/market shock detector + tiered capital protection.

The hole this fills (2026-06-10): nothing watched VIX, SPY velocity, or news.
A Trump-post tariff shock (Apr 2025 style: post 9:37 ET, market moved in 2-3 min)
would have sailed straight past every existing guard. Price is ground truth here;
news only ARMS a watch state — price action must confirm before anything fires.

Detectors (full mode = market hours, every 2 min; light mode = off-hours, every 10):
  * SPY 1-min return z-score (Alpaca data API, IEX feed, boba paper key — data only)
  * VIX level tiers (Yahoo chart endpoint, no key): >=25 STRESS / >=30 CRISIS / >=40 PANIC
  * VIX term structure: VIX/VIX3M >= 1.0 (backwardation) escalates STRESS->CRISIS gate
  * BTC 15-min velocity (Yahoo): 24/7 risk proxy, off-hours early warning (alert-only)
  * Alpaca news REST poll, keyword pre-filter (tariff/fed/war/...) -> arms WATCH only

State machine (state file survives runs; debounce stops whipsaw on fake headlines):
  CALM -> WATCH  (headline hit, or one soft trigger)
  WATCH/CALM -> CRISIS  needs 2 consecutive trigger runs, OR one extreme print
                        (VIX>=40 or z<=-3.5) which fires immediately.
Actions on CRISIS (tiered, all wired to EXISTING enforcement):
  L1  touch ~/.openclaw/decipher_HALT  (decipher refuses new buys — already enforced)
      + LOUD Telegram via @PipelineSignals_Bot with reason + what was done
  L2  write ~/.openclaw/decipher_STRESS json (decipher tightens trail + scales size)
      — STRESS also engages alone at VIX>=25 without CRISIS (silent note)
  L3  list every DTE<=2 option position on boba+jazzy paper; if the flag file
      ~/.openclaw/shock_autoclose_paper exists, market-close them (PAPER ONLY —
      Robinhood positions get the alert text telling Mike exactly what to close)
Recovery: HALT is NEVER auto-removed. When calm holds 30 min, guard sends a
stand-down note; Mike replies RESUME to @PipelineSignals_Bot (dm_responder clears).
STRESS auto-clears at VIX<23 (hysteresis).

Off switch: touch ~/.openclaw/shock_guard_OFF.
Events log: ~/logs/shock_events.jsonl (scoreboard auditor grades detectors from it).
Test: DRY=1 python3 shock_guard.py   (no files touched, no sends, prints decisions)
Force a level for plumbing test: DRY=1 FORCE_LEVEL=CRISIS python3 shock_guard.py
"""
from __future__ import annotations

import json
import os
import statistics
import sys
import time
import urllib.parse
import urllib.request
from datetime import datetime
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from lib.http_retry import request as http_request, CAT_RATELIMIT  # noqa: E402

ET = ZoneInfo("America/New_York")
SEC = Path.home() / ".openclaw" / "secrets"
OC = Path.home() / ".openclaw"
STATE_DIR = OC / "workspace" / "state"
STATE = STATE_DIR / "shock_guard_state.json"
HALT_FILE = OC / "decipher_HALT"
STRESS_FILE = OC / "decipher_STRESS"
OFF_FILE = OC / "shock_guard_OFF"
AUTOCLOSE_FLAG = OC / "shock_autoclose_paper"
EVENTS = Path.home() / "logs" / "shock_events.jsonl"

# thresholds (practitioner consensus, see TELEGRAM-TRADER-COPILOT-PLAN.md item 41)
VIX_STRESS, VIX_CRISIS, VIX_PANIC = 25.0, 30.0, 40.0
VIX_CLEAR = 23.0                      # hysteresis for STRESS auto-clear
Z_CRISIS, Z_EXTREME = -2.5, -3.5
# Absolute 1-min move floor for the z-trigger. On an ultra-quiet tape the trailing
# stdev collapses toward zero, so a trivial blip explodes the z-score (a -0.26% SPY
# move read z -8.32 on 2026-06-17 and latched a false CRISIS). A genuine crash bar
# moves materially; require |move| >= this before the z-score can count as a trigger.
Z_MIN_MOVE_PCT = 0.40
BTC_15M_PCT = -3.0
NEWS_KEYWORDS = ("tariff", "trump", "truth social", "fed ", "federal reserve",
                 "rate hike", "emergency", "halt", "war ", "strike on", "nuclear",
                 "invasion", "default", "bank failure", "circuit breaker", "china")
DRY = os.environ.get("DRY") == "1"

UA = {"User-Agent": "Mozilla/5.0 (MissionControl shock-guard)"}


def _secret(name: str) -> str | None:
    p = SEC / name
    return p.read_text(encoding="utf-8").strip() if p.exists() else None


def _get(url: str, headers: dict | None = None, timeout: int = 15,
         retries: int = 1) -> dict | None:
    # Shared retry wrapper: one backoff retry on transient 429/5xx/timeout, then None.
    # Contract UNCHANGED — a data miss returns None and never triggers a halt (the state
    # machine only escalates on positive VIX/z/BTC signals), it just leaves the guard blind
    # for this run. 429 is expected noise under the shared Alpaca data limit (~38 spam
    # lines/day), so it is NOT logged as an error; genuine failures (DNS/5xx/timeout) still
    # surface. The retry makes the guard LESS blind through transient rate-limit blips.
    res = http_request(url, headers={**UA, **(headers or {})}, timeout=timeout, retries=retries)
    if res.ok:
        return res.json
    if res.category != CAT_RATELIMIT:
        print(f"[guard] GET {url.split('?')[0]} failed: {res.error or res.category}",
              file=sys.stderr)
    return None


def now_et() -> datetime:
    return datetime.now(tz=ET)


def market_open() -> bool:
    n = now_et()
    return n.weekday() <= 4 and 925 <= n.hour * 100 + n.minute <= 1605


# --------------------------------------------------------------------------- #
# Detectors
# --------------------------------------------------------------------------- #
def yahoo_last(symbol: str, interval: str = "5m", rng: str = "1d") -> list[float]:
    """Closing prices for symbol from Yahoo's public chart endpoint (no key)."""
    d = _get(f"https://query1.finance.yahoo.com/v8/finance/chart/"
             f"{urllib.parse.quote(symbol)}?interval={interval}&range={rng}")
    try:
        closes = d["chart"]["result"][0]["indicators"]["quote"][0]["close"]
        return [c for c in closes if c is not None]
    except (TypeError, KeyError, IndexError):
        return []


def check_vix() -> dict:
    vix = yahoo_last("^VIX")
    vix3m = yahoo_last("^VIX3M")
    v = vix[-1] if vix else None
    ratio = (v / vix3m[-1]) if (v and vix3m and vix3m[-1]) else None
    return {"vix": round(v, 2) if v else None,
            "backwardation": bool(ratio and ratio >= 1.0),
            "ratio": round(ratio, 3) if ratio else None}


def check_spy_z() -> dict:
    """z-score of the latest 1-min SPY return vs the trailing 20 bars."""
    key, sec_ = _secret("alpaca-boba-key-id"), _secret("alpaca-boba-secret")
    if not key or not sec_:
        return {"z": None}
    start = datetime.now(tz=ZoneInfo("UTC")).timestamp() - 40 * 60
    start_iso = datetime.fromtimestamp(start, tz=ZoneInfo("UTC")).strftime("%Y-%m-%dT%H:%M:%SZ")
    d = _get("https://data.alpaca.markets/v2/stocks/SPY/bars"
             f"?timeframe=1Min&limit=40&feed=iex&start={start_iso}",
             headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec_})
    bars = (d or {}).get("bars") or []
    closes = [b["c"] for b in bars if b.get("c")]
    if len(closes) < 15:
        return {"z": None}
    rets = [(b - a) / a for a, b in zip(closes, closes[1:])]
    last, hist = rets[-1], rets[:-1]
    sd = statistics.pstdev(hist)
    if not sd:
        return {"z": None}
    z = (last - statistics.fmean(hist)) / sd
    return {"z": round(z, 2), "last_ret_pct": round(last * 100, 3)}


def check_btc() -> dict:
    closes = yahoo_last("BTC-USD", interval="5m", rng="1d")  # Yahoo rejects range=1h
    if len(closes) < 4:
        return {"btc_15m_pct": None}
    pct = (closes[-1] - closes[-4]) / closes[-4] * 100
    return {"btc_15m_pct": round(pct, 2)}


def check_news(state: dict) -> list[str]:
    """Alpaca news since the last poll, keyword-filtered. Returns headlines."""
    key, sec_ = _secret("alpaca-boba-key-id"), _secret("alpaca-boba-secret")
    if not key or not sec_:
        return []
    params = {"limit": "25", "sort": "desc"}
    if state.get("news_since"):
        params["start"] = state["news_since"]
    d = _get("https://data.alpaca.markets/v1beta1/news?" + urllib.parse.urlencode(params),
             headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec_})
    items = (d or {}).get("news") or []
    if items:
        state["news_since"] = items[0].get("created_at") or state.get("news_since")
    hits = []
    for it in items:
        head = (it.get("headline") or "").lower()
        if any(k in head for k in NEWS_KEYWORDS):
            hits.append(it.get("headline", "")[:140])
    return hits[:5]


# --------------------------------------------------------------------------- #
# Actions
# --------------------------------------------------------------------------- #
def telegram(text: str, loud: bool) -> None:
    if DRY:
        print(f"DRY telegram (loud={loud}):\n{text}\n")
        return
    # Prefer the vault-backed fleet route (flow_signals = @PipelineSignals_Bot, where Mike
    # already watches). tg_push itself falls back to telegram-bot-token.txt; the inline send
    # below is a last-ditch for the narrow case where lib.notify can't even be imported.
    try:
        sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
        from lib.notify import tg_push
        if tg_push(text, "flow_signals", loud=loud,
                   fallback_token_file="telegram-bot-token.txt"):
            return
    except Exception as e:  # noqa: BLE001
        print(f"[guard] fleet route failed: {e}", file=sys.stderr)
    token, chat = _secret("telegram-bot-token.txt"), _secret("telegram-chat-id.txt")
    if not token or not chat:
        print("[guard] no telegram creds", file=sys.stderr)
        return
    data = urllib.parse.urlencode({
        "chat_id": chat, "parse_mode": "HTML",
        "disable_notification": "false" if loud else "true",
        "text": text[:4096]}).encode()
    try:
        urllib.request.urlopen(urllib.request.Request(
            f"https://api.telegram.org/bot{token}/sendMessage", data=data), timeout=20)
    except Exception as e:  # noqa: BLE001
        print(f"[guard] telegram failed: {e}", file=sys.stderr)


def log_event(kind: str, detail: dict) -> None:
    EVENTS.parent.mkdir(parents=True, exist_ok=True)
    rec = {"ts_et": now_et().isoformat(), "kind": kind, **detail}
    if DRY:
        print(f"DRY event: {json.dumps(rec)}")
        return
    with open(EVENTS, "a", encoding="utf-8") as f:
        f.write(json.dumps(rec) + "\n")


def alpaca_trade(path: str, account: str, method: str = "GET", body: dict | None = None):
    key = _secret(f"alpaca-{account}-key-id")
    sec_ = _secret(f"alpaca-{account}-secret")
    if not key or not sec_:
        return None
    req = urllib.request.Request(
        f"https://paper-api.alpaca.markets{path}",
        data=json.dumps(body).encode() if body else None, method=method,
        headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec_,
                 "Content-Type": "application/json"})
    try:
        with urllib.request.urlopen(req, timeout=20) as r:
            return json.loads(r.read())
    except Exception as e:  # noqa: BLE001
        print(f"[guard] alpaca {account} {path}: {e}", file=sys.stderr)
        return None


def short_dte_positions(account: str) -> list[dict]:
    """Option positions expiring within 2 days on a paper account."""
    pos = alpaca_trade("/v2/positions", account) or []
    out = []
    today = now_et().date()
    for p in pos:
        sym = p.get("symbol", "")
        if p.get("asset_class") != "us_option" and len(sym) < 12:
            continue
        digits = "".join(ch for ch in sym if ch.isdigit())
        try:
            exp = datetime.strptime(digits[:6], "%y%m%d").date()
        except ValueError:
            continue
        dte = (exp - today).days
        if dte <= 2:
            out.append({"symbol": sym, "qty": p.get("qty"), "dte": dte,
                        "account": account, "side": p.get("side", "long")})
    return out


def crisis_close_l3(reason: str) -> str:
    """List (and optionally market-close, paper only) all DTE<=2 option positions."""
    lines = []
    for acct in ("boba", "jazzy"):
        for p in short_dte_positions(acct):
            tag = f"{p['account']}: {p['symbol']} x{p['qty']} ({p['dte']} DTE)"
            if AUTOCLOSE_FLAG.exists() and not DRY:
                r = alpaca_trade(f"/v2/positions/{p['symbol']}", acct, method="DELETE")
                tag += " — CLOSED" if r is not None else " — CLOSE FAILED, do it manually"
            else:
                tag += " — CLOSE THIS NOW (auto-close off)"
            lines.append(tag)
            log_event("l3_position", {"reason": reason, **p,
                                      "auto": AUTOCLOSE_FLAG.exists()})
    if not lines:
        return "No 0-2 DTE options held on paper accounts."
    return "0-2 DTE options (these die first in a crash):\n  " + "\n  ".join(lines)


# --------------------------------------------------------------------------- #
# State machine
# --------------------------------------------------------------------------- #
def load_state() -> dict:
    try:
        return json.loads(STATE.read_text(encoding="utf-8"))
    except Exception:  # noqa: BLE001
        return {"level": "CALM", "trigger_runs": 0, "last_alert": 0,
                "calm_since": None, "news_since": None}


def main() -> int:
    if OFF_FILE.exists():
        return 0
    full = market_open()
    n = now_et()
    if not full and n.minute % 10 != 0 and not DRY and not os.environ.get("FORCE_LEVEL"):
        return 0          # light mode: only act on 10-minute boundaries off-hours

    st = load_state()
    STATE_DIR.mkdir(parents=True, exist_ok=True)

    vix_d = check_vix()
    btc_d = check_btc()
    spy_d = check_spy_z() if full else {"z": None}
    headlines = check_news(st)

    vix = vix_d.get("vix")
    z = spy_d.get("z")
    btc = btc_d.get("btc_15m_pct")

    triggers, extreme = [], False
    if vix is not None and vix >= VIX_CRISIS:
        triggers.append(f"VIX {vix:g} >= {VIX_CRISIS:g}")
        extreme = extreme or vix >= VIX_PANIC
    if z is not None and z <= Z_CRISIS and abs(spy_d.get("last_ret_pct") or 0) >= Z_MIN_MOVE_PCT:
        triggers.append(f"SPY 1-min z {z:g} (move {spy_d.get('last_ret_pct')}%)")
        extreme = extreme or z <= Z_EXTREME
    if vix is not None and vix >= VIX_STRESS and vix_d.get("backwardation"):
        triggers.append(f"VIX {vix:g} + term-structure backwardation "
                        f"(VIX/VIX3M {vix_d.get('ratio')})")
    if not full and btc is not None and btc <= BTC_15M_PCT:
        # off-hours proxy: warn loudly, arm WATCH, but never CRISIS on BTC alone
        if time.time() - st.get("last_btc_alert", 0) > 3600:
            telegram(f"⚠️ <b>Off-hours risk proxy</b>: BTC {btc:+.1f}% in 15 min. "
                     f"Possible gap risk at next open. VIX last {vix or '?'}.", loud=True)
            st["last_btc_alert"] = time.time()
        st["level"] = max_level(st["level"], "WATCH")
        log_event("btc_proxy", {"btc_15m_pct": btc, "vix": vix})

    forced = os.environ.get("FORCE_LEVEL")
    if forced:
        triggers = [f"FORCED {forced} (plumbing test)"]
        extreme = forced == "CRISIS"

    # --- escalation -------------------------------------------------------- #
    if triggers:
        st["trigger_runs"] = st.get("trigger_runs", 0) + 1
        st["calm_since"] = None
        st["calm_notes"] = 0   # a fresh trigger re-arms the stand-down notice
    else:
        st["trigger_runs"] = 0

    crisis_now = bool(triggers) and (extreme or st["trigger_runs"] >= 2)

    if headlines and st["level"] == "CALM" and not crisis_now:
        st["level"] = "WATCH"
        st["watch_armed_at"] = time.time()
        # ADD de-bloat (2026-06-15): WATCH is internal-only — no Telegram ping.
        # "Headline watch armed, no action taken" fired ~15×/day on keyword hits
        # (trump/china/fed/halt/war) = pure noise for an ADD trader. Price must
        # CONFIRM (escalate to CRISIS below) before Mike hears anything. Event is
        # still logged for the scoreboard auditor; CRISIS is the only shock that pings.
        log_event("watch_armed", {"headlines": headlines, "vix": vix, "z": z})

    if crisis_now and st["level"] != "CRISIS":
        st["level"] = "CRISIS"
        reason = "; ".join(triggers)
        if not DRY:
            HALT_FILE.write_text(f"shock_guard {n.isoformat()}: {reason}\n")
            STRESS_FILE.write_text(json.dumps({
                "set_at": n.isoformat(), "vix": vix, "reason": reason,
                "trail_giveback_mult": 0.6,
                "size_mult": round(min(1.0, 15.0 / vix), 2) if vix else 0.5}))
        l3 = crisis_close_l3(reason)
        telegram(
            f"🚨 <b>SHOCK GUARD — CRISIS</b>\n{reason}\n"
            f"{'• headlines: ' + ' | '.join(headlines) if headlines else ''}\n\n"
            f"DONE automatically:\n"
            f"1. New buys HALTED (decipher_HALT set)\n"
            f"2. Trailing stops tightened, sizing cut (decipher_STRESS)\n\n"
            f"{l3}\n\n"
            f"Robinhood: close anything expiring this week yourself.\n"
            f"Reply <b>RESUME</b> here when you want trading back on.", loud=True)
        log_event("crisis", {"reason": reason, "vix": vix, "z": z,
                             "headlines": headlines})
    elif st["level"] == "CRISIS" and not triggers:
        # crisis condition gone — start/continue the calm clock
        if st.get("calm_since") is None:
            st["calm_since"] = time.time()
            st["calm_notes"] = 0
        else:
            elapsed = time.time() - st["calm_since"]
            notes = st.get("calm_notes", 0)
            # De-spam (2026-06-15): the stand-down used to re-ping every 30 min for the
            # whole session (~10×/day on 06-13) because calm_since reset each fire. Now it
            # sends ONCE at 30 min, then at most ONE quiet backstop ~4h later, then goes
            # silent. HALT stays ON until Mike replies RESUME (dm_responder clears it);
            # we just stop nagging. Any fresh trigger re-arms the whole clock above.
            due = (notes == 0 and elapsed >= 1800) or (notes == 1 and elapsed >= 4 * 3600)
            if due:
                tail = ("HALT still ON — reply <b>RESUME</b> to clear it."
                        if notes == 0 else
                        "HALT is STILL ON (no RESUME seen) — reply <b>RESUME</b> when ready. "
                        "This is the last reminder.")
                telegram(f"✅ Shock guard: conditions calm (VIX {vix or '?'}). {tail}",
                         loud=False)
                st["calm_notes"] = notes + 1
                log_event("calm_notice", {"vix": vix, "note": notes + 1})
    elif st["level"] == "WATCH" and time.time() - st.get("watch_armed_at", 0) > 1800 \
            and not triggers:
        st["level"] = "CALM"  # watch expires after 30 quiet minutes

    # --- STRESS layer (independent of CRISIS, hysteresis clear) ------------- #
    if vix is not None and not DRY:
        if vix >= VIX_STRESS and not STRESS_FILE.exists():
            STRESS_FILE.write_text(json.dumps({
                "set_at": n.isoformat(), "vix": vix, "reason": f"VIX {vix:g}",
                "trail_giveback_mult": 0.6,
                "size_mult": round(min(1.0, 15.0 / vix), 2)}))
            telegram(f"🟠 VIX {vix:g} — stress mode: trails tightened, "
                     f"new-position sizing scaled down. Auto-clears under {VIX_CLEAR:g}.",
                     loud=False)
            log_event("stress_on", {"vix": vix})
        elif vix < VIX_CLEAR and STRESS_FILE.exists() and st["level"] != "CRISIS":
            STRESS_FILE.unlink(missing_ok=True)
            telegram(f"🟢 VIX {vix:g} — stress mode cleared.", loud=False)
            log_event("stress_off", {"vix": vix})

    if DRY:
        print(json.dumps({"level": st["level"], "triggers": triggers,
                          "vix": vix_d, "spy": spy_d, "btc": btc_d,
                          "headlines": headlines}, indent=1))
    else:
        STATE.write_text(json.dumps(st), encoding="utf-8")
    return 0


def max_level(a: str, b: str) -> str:
    order = {"CALM": 0, "WATCH": 1, "CRISIS": 2}
    return a if order.get(a, 0) >= order.get(b, 0) else b


if __name__ == "__main__":
    raise SystemExit(main())
