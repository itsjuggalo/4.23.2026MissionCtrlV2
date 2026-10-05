#!/home/itsju/.venv/bin/python
"""Protective staged copy of the Trading Recaps contract scorecard.

Loaded relay contracts are model inputs, not confirmed holdings or executable
recommendations. Source times, settlement, deliverables and identity are unverified
here. The legacy calculations, thresholds, IV fallback and target/stop policy are
retained; presentation discloses those assumptions rather than asserting LIVE,
an empirical edge, or plan eligibility. Nothing places or cancels an order.

Activation and installed-path receipts belong in the deployment register. Running
this source performs the existing data reads, sends and OneDrive writes; DRY=1 is
not an offline fixture. Tests must extract reviewed functions with explicit mocks.
"""
from __future__ import annotations
import json, os, re, sys
from datetime import datetime, date
from math import erf, log, sqrt
from pathlib import Path
from zoneinfo import ZoneInfo

sys.path.insert(0, "/AIWorkWSL/labs/quantum/src")
import theo  # noqa: E402
sys.path.insert(0, str(Path.home() / "scripts"))
from tg_format import hdr, esc, footer  # noqa: E402

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SEC / "telegram_mc_skill_bot_token"   # @MMCTRL727_Bot "Trading Recaps"
CHAT_FILE = SEC / "telegram-chat-id.txt"
# Alpaca is market DATA only; never add account/positions/order reads.
DATA = "https://data.alpaca.markets"
RELAY_URL = "http://localhost:3000/api/firebase-relay"
DARKPOOL_URL = "http://localhost:3000/api/darkpool?view=relay"
ET = ZoneInfo("America/New_York")
DRY = os.environ.get("DRY") == "1"
ONEDRIVE = Path("/mnt/c/Users/itsju/OneDrive/Desktop/From Claude To Mike")
import urllib.request  # noqa: E402


def _diagnostic(code):
    """Static best-effort observability; no response, URL, input or exception echo."""
    messages = {"relay_failed": "relay request unverified",
                "relay_malformed": "relay response malformed",
                "darkpool_failed": "dark-pool context unverified",
                "darkpool_malformed": "dark-pool response malformed",
                "model_failed": "model row unavailable",
                "telegram_unverified": "Telegram acceptance unverified",
                "copy_failed": "OneDrive copy unverified"}
    try:
        print("[scorecard] " + messages.get(code, "operation unverified"))
    except Exception:
        pass


def _finite(value):
    return type(value) in (int, float) and value == value and abs(value) != float("inf")


def _body_state(body):
    if type(body) is not dict:
        return "MALFORMED"
    ok, error = body.get("ok"), body.get("error")
    if ("ok" in body and type(ok) is not bool) or (error is not None and type(error) is not str):
        return "MALFORMED"
    if ok is False or (error is not None and error.strip()):
        return "FAILED"
    return "LOADED"


def _relay_response(body):
    state = _body_state(body)
    rows = body.get("signals") if type(body) is dict else None
    if state != "LOADED" or type(rows) is not list:
        return {"state": state if state != "LOADED" else "MALFORMED",
                "rows": [], "input_count": None, "omitted": None}
    return {"state": "LOADED", "rows": rows, "input_count": len(rows), "omitted": 0}


def _coverage_text(coverage, shown, model_omitted, render_omitted=0):
    count, omitted = coverage.get("input_count"), coverage.get("omitted")
    if type(count) is not int or type(omitted) is not int:
        return "Loaded-response coverage UNKNOWN; request state " + coverage.get("state", "UNKNOWN") + "."
    return (f"Loaded-response coverage: {count} rows; {shown} model cards; "
            f"{omitted} mapping omissions; {model_omitted} model/data omissions; "
            f"{render_omitted} render omissions. "
            "This is not all-market coverage.")


def _presentation_evidence(card, now):
    pos = card["pos"]
    lines = ["MODEL ONLY — option quote / IEX trade source times and age UNKNOWN.",
             "Contract identity, deliverable and settlement verification UNKNOWN."]
    expiry = pos.get("exp")
    if type(expiry) is date and expiry < now.date():
        lines.append("PAST DISPLAYED EXPIRY — retained legacy model output, not current contract pricing.")
    elif type(expiry) is date and expiry == now.date():
        lines.append("SAME-DAY SETTLEMENT UNKNOWN — no execution eligibility established.")
    else:
        lines.append("Displayed expiry uses legacy ET conversion; source expiry semantics unverified.")
    if not card.get("iv"):
        lines.append("IV: assumed 30% fallback; Greeks/probability/move are assumption-based.")
    elif _finite(card.get("iv")) and card["iv"] > 0:
        lines.append("IV: inverted from supplied mid; source validity and calibration UNKNOWN.")
    else:
        lines.append("IV/model input invalid or nonfinite; legacy numeric output unverified.")
    lines.append("Legacy horizon: calendar DTE with synthetic minimum 0.5 day; POP uses zero drift.")
    lines.append("Model probability is not an empirical win rate or evidence of an edge.")
    if not pos.get("_side_known", False):
        lines.append("Source option side UNKNOWN; legacy model's side selection is unverified.")
    if not pos.get("_quote_valid", False):
        lines.append("Supplied two-sided quote validity UNKNOWN; model numbers are unverified.")
    return lines


def _renderable_card(card):
    """Display-only validation; never repairs a number or changes the legacy model."""
    if type(card) is not dict or type(card.get("pos")) is not dict:
        return False
    pos = card["pos"]
    if type(pos.get("exp")) is not date or not _finite(pos.get("strike")):
        return False
    flags, verdict = pos.get("flags", []), card.get("verdict")
    if type(flags) is not list or any(type(flag) is not str for flag in flags):
        return False
    if type(verdict) is not list or any(type(line) is not str for line in verdict):
        return False
    if any(not _finite(card.get(key)) for key in
           ("spot", "mark", "be", "dte", "need_pct", "one_sig_pct", "t1", "stop", "cliff")):
        return False
    return all(card.get(key) is None or _finite(card[key]) for key in
               ("delta", "theta_day", "theta_pct", "pop"))


def _chat_number(value):
    if type(value) is int:
        return value
    if type(value) is str and re.fullmatch(r"-?[0-9]+", value.strip()):
        try:
            return int(value.strip())
        except ValueError:
            return None
    return None


def _telegram_ack(status, body, expected_chat):
    expected = _chat_number(expected_chat)
    if type(status) is not int or not 200 <= status < 300 or type(body) is not dict or body.get("ok") is not True:
        return False
    result = body.get("result")
    if type(result) is not dict or type(result.get("message_id")) is not int or result["message_id"] <= 0:
        return False
    chat = result.get("chat")
    return (expected is not None and type(chat) is dict and type(chat.get("id")) is int
            and chat["id"] == expected)


def _html_units(text):
    """Conservative raw UTF-16 budget, including markup and escaped entities."""
    return sum(2 if ord(char) > 0xffff else 1 for char in text)


def _scorecard_html_tokens(text):
    """Validate the scorecard's narrow HTML dialect before splitting anything.

    Text runs, including adjacent entities, stay indivisible: a price, strike or
    date is never cut between messages. Unsupported/malformed markup fails closed.
    """
    if type(text) is not str or not text.strip():
        return None
    named = {"&amp;": "&", "&lt;": "<", "&gt;": ">", "&quot;": '"'}
    tokens, stack, word = [], [], []
    visible, index = False, 0

    def flush_word():
        if word:
            tokens.append(("text", "".join(word), ""))
            word.clear()

    while index < len(text):
        char = text[index]
        if char == "<":
            flush_word()
            match = re.match(r"</?(b|i)>", text[index:index + 4])
            if match is None:
                return None
            raw, tag = match.group(0), match.group(1)
            if raw.startswith("</"):
                if not stack or stack[-1] != tag:
                    return None
                stack.pop()
                kind = "close"
            else:
                stack.append(tag)
                kind = "open"
            tokens.append((kind, raw, tag))
            index += len(raw)
            continue
        if char == ">":
            return None
        raw, decoded = char, char
        if char == "&":
            end = text.find(";", index + 1)
            if end == -1:
                return None
            raw = text[index:end + 1]
            decoded = named.get(raw)
            if decoded is None:
                if re.fullmatch(r"&#[0-9]+;", raw):
                    digits, base = raw[2:-1], 10
                elif re.fullmatch(r"&#[xX][0-9a-fA-F]+;", raw):
                    digits, base = raw[3:-1], 16
                else:
                    return None
                try:
                    value = int(digits, base)
                except ValueError:
                    return None
                if not 0 < value <= 0x10ffff or 0xd800 <= value <= 0xdfff:
                    return None
                decoded = chr(value)
        value = ord(decoded)
        if 0xd800 <= value <= 0xdfff or (value < 32 and decoded not in "\t\n\r"):
            return None
        if decoded.isspace():
            flush_word()
            tokens.append(("text", raw, ""))
        else:
            visible = True
            word.append(raw)
        index += len(raw)
    flush_word()
    return tokens if visible and not stack else None


def _qualified_parts(text):
    """Split the original card into independently balanced, qualified HTML parts."""
    warning = "\n<i>MODEL ONLY · quote age/identity UNKNOWN · not an entry, fill or exit instruction.</i>"
    tokens = _scorecard_html_tokens(text)
    if tokens is None:
        return []
    parts, stack, current = [], [], []
    units, has_text = 0, False
    warning_units = _html_units(warning)
    for kind, raw, tag in tokens:
        next_stack = stack + [tag] if kind == "open" else stack[:-1] if kind == "close" else stack
        closing_units = sum(len(item) + 3 for item in next_stack)
        raw_units = _html_units(raw)
        if units + raw_units + closing_units + warning_units > 4096:
            if not has_text:
                return []
            parts.append("".join(current) + "".join("</" + item + ">" for item in reversed(stack)) + warning)
            prefix = "".join("<" + item + ">" for item in stack)
            current, units, has_text = [prefix], _html_units(prefix), False
            if units + raw_units + closing_units + warning_units > 4096:
                return []
        current.append(raw)
        units += raw_units
        stack = next_stack
        has_text = has_text or kind == "text"
    if has_text:
        parts.append("".join(current) + warning)
    return parts


def _key():
    return ((SEC / "alpaca-key-id").read_text().strip(),
            (SEC / "alpaca-secret").read_text().strip())


def _get(url: str):
    k, s = _key()
    req = urllib.request.Request(url, headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s})
    return json.loads(urllib.request.urlopen(req, timeout=20).read())


def _tg(method, **kwargs):
    """One attempt only. Strict application ACK is acceptance, not recipient delivery."""
    response = None
    try:
        text = kwargs.get("text")
        if method != "sendMessage" or type(text) is not str or not text.strip() or len(text) > 4096:
            _diagnostic("telegram_unverified")
            return False
        token = TOKEN_FILE.read_text().strip()
        response = urllib.request.urlopen(urllib.request.Request(
            f"https://api.telegram.org/bot{token}/{method}",
            data=json.dumps(kwargs).encode(), headers={"Content-Type": "application/json"}),
            timeout=15)
        accepted = _telegram_ack(response.status, json.loads(response.read()), kwargs.get("chat_id"))
        if not accepted:
            _diagnostic("telegram_unverified")
        return accepted
    except Exception:
        _diagnostic("telegram_unverified")
        return False
    finally:
        if response is not None:
            try:
                response.close()
            except Exception:
                pass


def _spot(sym: str):
    try:
        d = _get(f"{DATA}/v2/stocks/{sym}/trades/latest?feed=iex")
        return float(d.get("trade", {}).get("p") or 0) or None
    except Exception:
        return None


def ncdf(x: float) -> float:
    return 0.5 * (1 + erf(x / sqrt(2)))


def _relay_universe():
    """Existing single relay read; explicit request and mapping coverage, not holdings."""
    try:
        req = urllib.request.Request(RELAY_URL, headers={"User-Agent": "Mozilla/5.0"})
        d = json.loads(urllib.request.urlopen(req, timeout=15).read())
    except Exception:
        _diagnostic("relay_failed")
        return {"state": "FAILED", "rows": [], "input_count": None, "omitted": None}
    envelope = _relay_response(d)
    if envelope["state"] != "LOADED":
        _diagnostic("relay_malformed" if envelope["state"] == "MALFORMED" else "relay_failed")
        return envelope
    out = []
    for s in envelope["rows"]:
        try:
            strike, expiry_ms = s.get("strike"), s.get("expiryMs")
            if strike is None or not expiry_ms:
                envelope["omitted"] += 1
                continue
            exp = datetime.fromtimestamp(expiry_ms / 1000, tz=ET).date()
            bid, ask = s.get("bid"), s.get("ask")
            mid = (bid + ask) / 2 if (bid is not None and ask is not None) else None
            out.append({"id": s.get("id"), "root": s.get("ticker"), "exp": exp,
                        "kind": "put" if s.get("isPut") else "call", "strike": float(strike),
                        "mid": mid, "buyTarget": s.get("buyTarget"), "sellTarget": s.get("sellTarget"),
                        "stopLoss": s.get("stopLoss"), "flags": s.get("flags") or [],
                        "_side_known": type(s.get("isPut")) is bool,
                        "_quote_valid": _finite(bid) and _finite(ask) and 0 < bid <= ask})
        except Exception:
            envelope["omitted"] += 1
    envelope["rows"] = out
    return envelope


def _darkpool_tags():
    """Preserved legacy join; presentation calls association and source age unverified."""
    try:
        req = urllib.request.Request(DARKPOOL_URL, headers={"User-Agent": "Mozilla/5.0"})
        d = json.loads(urllib.request.urlopen(req, timeout=15).read())
        state = _body_state(d)
        relay = d.get("relayConfluence") if type(d) is dict else None
        sigs = relay.get("signals") if type(relay) is dict else None
        if state != "LOADED" or type(sigs) is not list:
            _diagnostic("darkpool_malformed" if state != "FAILED" else "darkpool_failed")
            return {}, {}, state if state != "LOADED" else "MALFORMED"
    except Exception:
        _diagnostic("darkpool_failed")
        return {}, {}, "FAILED"
    by_id, by_ts = {}, {}
    state = "LOADED"
    for s in sigs:
        try:
            by_id[s.get("id")] = s
            by_ts.setdefault((s.get("ticker"), s.get("strike")), s)
        except Exception:
            state = "PARTIAL"
    return by_id, by_ts, state


def _dp_tag_for(pos: dict, by_id: dict, by_ts: dict):
    s = by_id.get(pos.get("id")) or by_ts.get((pos["root"], pos["strike"]))
    return (s.get("tag"), s.get("note")) if s else (None, None)


def scorecard(pos: dict):
    """Legacy numerical model retained; no held-position fields or eligibility claim."""
    spot = _spot(pos["root"])
    mark = pos["mid"]
    if not spot or not mark:
        return None
    dte = max((pos["exp"] - datetime.now(ET).date()).days, 0)
    T = max(dte, 0.5) / 365.0
    kind, K = pos["kind"], pos["strike"]
    iv = theo.implied_vol(mark, spot, K, T, kind) or 0.0
    g = theo.bs_greeks(spot, K, T, iv or 0.30, kind) if (iv or mark) else {}
    delta = (g or {}).get("delta")
    theta_day = (g or {}).get("theta_day")
    be = K + mark if kind == "call" else K - mark
    moneyness = "ITM" if ((kind == "call" and spot > K) or (kind == "put" and spot < K)) else "OTM"

    sig = iv or 0.30
    srt = sig * sqrt(T)
    pop = (ncdf((log(spot / be) - 0.5 * sig * sig * T) / srt) if kind == "call"
           else ncdf((log(be / spot) + 0.5 * sig * sig * T) / srt)) if (srt > 0 and be > 0) else None
    one_sig_pct = sig * sqrt(T) * 100
    need_pct = abs((be - spot) / spot * 100)
    theta_pct = abs(theta_day) * 100 / mark if (theta_day and mark) else None

    t1 = pos.get("sellTarget") or mark * 1.5
    stop = pos.get("stopLoss") or mark * 0.5
    cliff = min(21, dte)

    v = []
    if pop is not None and pop >= 0.55:
        v.append("Model probability at least 55% under legacy assumptions; no empirical edge established")
    elif pop is not None and pop < 0.30:
        v.append("Model probability below 30% under legacy assumptions; no sizing recommendation")
    if dte <= 7 and moneyness == "OTM":
        v.append("Legacy model: at most 7 calendar DTE and OTM; no catalyst or entry eligibility established")
    elif dte <= 21:
        v.append("Legacy model: at most 21 calendar DTE; synthetic horizon may apply")
    if delta is not None and abs(delta) >= 0.65:
        v.append("Model absolute delta at least 0.65; not proof of leverage or executable exposure")
    if theta_pct is not None and theta_pct >= 10:
        v.append(f"Model theta ~{theta_pct:.0f}%/calendar day of supplied mid; not realized decay")
    if not v:
        v.append("Legacy model summary only; no plan, entry or exit eligibility established")

    return {"pos": pos, "spot": round(spot, 2), "mark": round(mark, 2), "dte": dte, "iv": iv,
            "delta": delta, "theta_day": theta_day, "theta_pct": theta_pct, "be": round(be, 2),
            "moneyness": moneyness, "pop": pop, "one_sig_pct": one_sig_pct,
            "need_pct": need_pct, "t1": t1, "stop": stop, "cliff": cliff, "verdict": v}


def fmt_card(cards, coverage=None, model_omitted=0, darkpool_state="UNKNOWN", render_omitted=0) -> str:
    now = datetime.now(ET)
    display_cards = [card for card in cards if _renderable_card(card)]
    render_omitted += len(cards) - len(display_cards)
    lines = [hdr("📟", "Model Contract Scorecard", now),
             "<i>Generated time, not source time. Loaded relay universe; quote age UNKNOWN.</i>",
             esc(_coverage_text(coverage or {"state": "UNKNOWN"}, len(display_cards), model_omitted, render_omitted)),
             esc("Dark-pool request state: " + darkpool_state + "; association/source age UNKNOWN."), ""]
    for c in display_cards:
        p = c["pos"]
        right = ("C" if p["kind"] == "call" else "P") if p.get("_side_known", False) else "? (side UNKNOWN)"
        label = f"{esc(p['root'])} {esc(str(p['strike']))}{right} {p['exp']:%Y-%m-%d}"
        d = f"{c['delta']:+.2f}" if c["delta"] is not None else "—"
        th = f"${abs(c['theta_day'])*100:.0f}/day" + (f" ({c['theta_pct']:.0f}%)" if c["theta_pct"] is not None else "") if c["theta_day"] is not None else "—"
        pop = f"{c['pop']*100:.0f}%" if c["pop"] is not None else "—"
        flags = esc(" ".join(p.get("flags") or []))
        lines.append(f"<b>{label}</b> · supplied mid ${c['mark']} · model {c['moneyness']} · {c['dte']} calendar d" + (f" · source flags (unverified): {flags}" if flags else ""))
        for evidence in _presentation_evidence(c, now):
            lines.append("  " + esc(evidence))
        lines.append(f"  supplied spot ${c['spot']} · model breakeven ${c['be']} · absolute BE distance {c['need_pct']:.1f}% vs model 1σ ±{c['one_sig_pct']:.1f}%")
        lines.append(f"  model Δ {d} · θ {th} · model P(long profitable at expiry) {pop}")
        lines.append(f"  legacy reference levels (not orders/fill guarantees) → T1 ${c['t1']:.2f} · stop ${c['stop']:.2f} · model cliff {c['cliff']} DTE")
        lines.append("  Targets/stop: supplied relay values when truthy, otherwise +50%/−50% of supplied mid; unchanged policy.")
        for vline in c["verdict"]:
            lines.append(f"  {esc(vline)}")
        if p.get("dp_tag"):
            lines.append(f"  Unverified DP association (legacy ID/ticker+strike join): {esc(p['dp_tag'])} — {esc(p.get('dp_note') or '')}".rstrip(" —"))
        lines.append("")
    lines.append(footer("Advisory · no broker orders · loaded relay universe, not held positions · MODEL ONLY. "
                        "Identity/quote age/calibration UNKNOWN; no entry, sizing or exit recommendation. "
                        "Stop references do not guarantee fills or maximum loss.").lstrip("\n"))
    return "\n".join(lines)


def main() -> int:
    coverage = _relay_universe()
    universe = coverage["rows"]
    if not universe:
        print("[scorecard] " + _coverage_text(coverage, 0, 0))
        return 0 if coverage["state"] == "LOADED" and coverage["input_count"] == 0 else 1
    by_id, by_ts, darkpool_state = _darkpool_tags()
    for p in universe:
        p["dp_tag"], p["dp_note"] = _dp_tag_for(p, by_id, by_ts)
    cards = []
    model_omitted = 0
    for p in sorted(universe, key=lambda x: (x["exp"] - date.today()).days):
        try:
            c = scorecard(p)
        except Exception:
            c = None
            _diagnostic("model_failed")
        if c:
            cards.append(c)
        else:
            model_omitted += 1
    if not cards:
        print("[scorecard] " + _coverage_text(coverage, 0, model_omitted))
        return 1
    display_cards = [c for c in cards if _renderable_card(c)]
    render_omitted = len(cards) - len(display_cards)
    if not display_cards:
        print("[scorecard] " + _coverage_text(coverage, 0, model_omitted, render_omitted))
        return 1
    card = fmt_card(display_cards, coverage, model_omitted, darkpool_state, render_omitted)

    def _plain(s: str) -> str:
        s = re.sub(r"</?[^>]+>", "", s)
        return s.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&")

    if DRY:
        print(_plain(card))
        return 0

    try:
        ONEDRIVE.mkdir(parents=True, exist_ok=True)
        (ONEDRIVE / "options-position-scorecard.txt").write_text(_plain(card))
    except Exception:
        _diagnostic("copy_failed")

    try:
        chat_id = CHAT_FILE.read_text().strip()
    except Exception:
        _diagnostic("telegram_unverified")
        return 1
    parts = _qualified_parts(card)
    accepted = 0
    for part in parts:
        if _tg("sendMessage", chat_id=chat_id, text=part, parse_mode="HTML") is True:
            accepted += 1
    complete = bool(parts) and accepted == len(parts)
    try:
        from lib.tg_ledger import record
        record("trading_recaps", card, complete, html=True, src="options_position_scorecard.py")
    except Exception:
        pass
    print(f"[scorecard] Telegram acceptance {'ACK' if complete else 'UNVERIFIED/PARTIAL'}: "
          f"{accepted}/{len(parts)} parts; {len(display_cards)} model card(s); not recipient-delivery proof")
    return 0 if complete else 1


if __name__ == "__main__":
    raise SystemExit(main())
