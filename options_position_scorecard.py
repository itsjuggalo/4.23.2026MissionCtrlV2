#!/home/itsju/.venv/bin/python
"""options_position_scorecard.py — Options Mastery: the live "take-this-contract"
grid read applied to the CURRENT Firebase Relay contract universe.

The Academy's price×time grid + POP/expected-move math, run on the relay's own
high-interest contracts (Name/Name2/Vivid feeds + Yahoo OI-flow, via /api/firebase-relay)
and pushed to his phone (Telegram) + OneDrive. For each contract: delta, theta RENT
(%/day of premium), POP (finish past breakeven), expected 1σ move vs the move it still
NEEDS, and the three exit marks (T1/stop from the relay's own targets when set, else
+50%/−50% off current mid, 21-DTE theta cliff) — plus a one-line disciplined verdict and
the relay×dark-pool confluence tag. READ-ONLY: never places or cancels an order.

2026-09-15: portfolio views retired site-wide — there is no live holdings feed, so this
no longer reads Mike's own positions (Alpaca /v2/positions is retired here too, per
Alpaca-as-data-feed-only doctrine). It reads the relay's flagged universe instead;
current spot ("_spot") stays on Alpaca as a free market-DATA read only.

Run:  options_position_scorecard.py        (send to TG + write OneDrive)
      DRY=1 options_position_scorecard.py   (print the card, send nothing)
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
from tg_format import hdr, esc, footer  # noqa: E402  (2026-09-15 format sweep)

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SEC / "telegram_mc_skill_bot_token"   # @MMCTRL727_Bot "Trading Recaps" (2026-09-28)
CHAT_FILE = SEC / "telegram-chat-id.txt"
# NOTE: Alpaca PAPER/account endpoint is retired here (2026-09-15) — Alpaca survives
# ONLY as a free market-DATA feed (see DATA / _spot below). Never re-add an
# account/positions/equity read.
DATA = "https://data.alpaca.markets"
RELAY_URL = "http://localhost:3000/api/firebase-relay"
DARKPOOL_URL = "http://localhost:3000/api/darkpool?view=relay"
ET = ZoneInfo("America/New_York")
DRY = os.environ.get("DRY") == "1"
ONEDRIVE = Path("/mnt/c/Users/itsju/OneDrive/Desktop/From Claude To Mike")
import urllib.request  # noqa: E402


def _key():
    return ((SEC / "alpaca-key-id").read_text().strip(),
            (SEC / "alpaca-secret").read_text().strip())


def _get(url: str):
    k, s = _key()
    req = urllib.request.Request(url, headers={"APCA-API-KEY-ID": k, "APCA-API-SECRET-KEY": s})
    return json.loads(urllib.request.urlopen(req, timeout=20).read())


def _tg(method, **kwargs):
    token = TOKEN_FILE.read_text().strip()
    try:
        return urllib.request.urlopen(urllib.request.Request(
            f"https://api.telegram.org/bot{token}/{method}",
            data=json.dumps(kwargs).encode(), headers={"Content-Type": "application/json"}),
            timeout=15)
    except Exception as e:
        print(f"tg {method} error: {e}")
        return None


def _spot(sym: str):
    try:
        d = _get(f"{DATA}/v2/stocks/{sym}/trades/latest?feed=iex")
        return float(d.get("trade", {}).get("p") or 0) or None
    except Exception:
        return None


def ncdf(x: float) -> float:
    return 0.5 * (1 + erf(x / sqrt(2)))


def _relay_universe():
    """Current contract universe from the Firebase Signal Relay (Name/Name2/Vivid feeds
    + Yahoo OI-flow), via /api/firebase-relay — replaces the retired Alpaca /v2/positions
    read (2026-09-15: no live holdings feed exists anywhere in the stack). This is the
    relay's own flagged universe, not anything confirmed as a position Mike holds.
    Fails soft: any fetch/parse error returns an empty list, never raises."""
    try:
        req = urllib.request.Request(RELAY_URL, headers={"User-Agent": "Mozilla/5.0"})
        d = json.loads(urllib.request.urlopen(req, timeout=15).read())
    except Exception as e:
        print(f"relay universe error: {e}")
        return []
    out = []
    for s in d.get("signals") or []:
        strike, expiry_ms = s.get("strike"), s.get("expiryMs")
        if strike is None or not expiry_ms:
            continue
        try:
            exp = datetime.fromtimestamp(expiry_ms / 1000, tz=ET).date()
        except Exception:
            continue
        bid, ask = s.get("bid"), s.get("ask")
        mid = (bid + ask) / 2 if (bid is not None and ask is not None) else None
        out.append({"id": s.get("id"), "root": s.get("ticker"), "exp": exp,
                    "kind": "put" if s.get("isPut") else "call", "strike": float(strike),
                    "mid": mid, "buyTarget": s.get("buyTarget"), "sellTarget": s.get("sellTarget"),
                    "stopLoss": s.get("stopLoss"), "flags": s.get("flags") or []})
    return out


def _darkpool_tags():
    """relay x dark-pool confluence tags from /api/darkpool?view=relay, keyed both by
    signal id (exact match) and by (ticker, strike) as a fallback since a relay signal's
    id can change on reissue while ticker+strike stays stable. Advisory only — an
    informational tag next to the grid read, never a filter. Fails soft."""
    try:
        req = urllib.request.Request(DARKPOOL_URL, headers={"User-Agent": "Mozilla/5.0"})
        d = json.loads(urllib.request.urlopen(req, timeout=15).read())
    except Exception as e:
        print(f"darkpool tag fetch error: {e}")
        return {}, {}
    sigs = ((d.get("relayConfluence") or {}).get("signals")) or []
    by_id, by_ts = {}, {}
    for s in sigs:
        by_id[s.get("id")] = s
        by_ts.setdefault((s.get("ticker"), s.get("strike")), s)
    return by_id, by_ts


def _dp_tag_for(pos: dict, by_id: dict, by_ts: dict):
    s = by_id.get(pos.get("id")) or by_ts.get((pos["root"], pos["strike"]))
    return (s.get("tag"), s.get("note")) if s else (None, None)


def scorecard(pos: dict):
    """Compute the grid-derived read for one relay contract. Returns a dict + a verdict
    line. `pos` has no held-position fields (qty/avg cost/P&L) — this is a prospective
    read on the relay's current mid, not Mike's own book."""
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

    # POP (finish past breakeven), expected 1σ vs needed move
    sig = iv or 0.30
    srt = sig * sqrt(T)
    pop = (ncdf((log(spot / be) - 0.5 * sig * sig * T) / srt) if kind == "call"
           else ncdf((log(be / spot) + 0.5 * sig * sig * T) / srt)) if (srt > 0 and be > 0) else None
    one_sig_pct = sig * sqrt(T) * 100
    need_pct = abs((be - spot) / spot * 100)
    theta_pct = abs(theta_day) * 100 / mark if (theta_day and mark) else None

    # exit marks — prefer the relay's own targets when it set them, else the grid's
    # standard +50%/−50% off current mid
    t1 = pos.get("sellTarget") or mark * 1.5
    stop = pos.get("stopLoss") or mark * 0.5
    cliff = min(21, dte)

    # one-line verdict (priority order) — signal-quality read, not a held-position P&L read
    v = []
    if pop is not None and pop >= 0.55:
        v.append("🟢 POP above coin-flip — probability edge on top of the payoff")
    elif pop is not None and pop < 0.30:
        v.append("🟡 low POP — this is a payoff bet; the grid's edge is the asymmetry, size accordingly")
    if dte <= 7 and moneyness == "OTM":
        # NOTE: keep this DTE phrase from starting with a literal "<" — _plain()'s
        # HTML-tag stripper below (and Telegram's own HTML parser on a live send)
        # both treat a bare "<" as an unterminated tag and eat text up to the next
        # ">", silently corrupting later lines. Pre-existing footgun, fixed in place.
        v.append("⏳ under 7 DTE & OTM — theta cliff; needs a catalyst in days, not weeks")
    elif dte <= 21:
        v.append("⏳ ≤21 DTE — theta-cliff zone approaching")
    if delta is not None and abs(delta) >= 0.65:
        v.append("ℹ️ deep ITM (~stock substitute) — little leverage left")
    if theta_pct is not None and theta_pct >= 10:
        v.append(f"🔥 ~{theta_pct:.0f}%/day rent at current mid — needs to move SOON or it bleeds")
    if not v:
        v.append("✅ in plan per the grid — respect the relay's T1/stop if set, else ±50% off mid")

    return {"pos": pos, "spot": round(spot, 2), "mark": round(mark, 2), "dte": dte, "iv": iv,
            "delta": delta, "theta_day": theta_day, "theta_pct": theta_pct, "be": round(be, 2),
            "moneyness": moneyness, "pop": pop, "one_sig_pct": one_sig_pct,
            "need_pct": need_pct, "t1": t1, "stop": stop, "cliff": cliff, "verdict": v}


def fmt_card(cards) -> str:
    now = datetime.now(ET)
    lines = [hdr("📟", "Live Contract Scorecard", now),
             "<i>Current Firebase Relay high-interest contracts, read through the Academy grid.</i>", ""]
    for c in cards:
        p = c["pos"]
        label = f"{esc(p['root'])} {p['strike']:g}{'C' if p['kind']=='call' else 'P'} {p['exp']:%-m/%-d}"
        d = f"{c['delta']:+.2f}" if c["delta"] is not None else "—"
        th = f"${abs(c['theta_day'])*100:.0f}/day" + (f" ({c['theta_pct']:.0f}%)" if c["theta_pct"] is not None else "") if c["theta_day"] is not None else "—"
        pop = f"{c['pop']*100:.0f}%" if c["pop"] is not None else "—"
        flags = esc(" ".join(p.get("flags") or []))
        lines.append(f"<b>{label}</b> · mid ${c['mark']} · {c['moneyness']} · {c['dte']}d" + (f" · {flags}" if flags else ""))
        lines.append(f"  spot ${c['spot']} · breakeven ${c['be']} · need {c['need_pct']:.1f}% vs 1σ ±{c['one_sig_pct']:.1f}%")
        lines.append(f"  Δ {d} · θ {th} · POP {pop}")
        lines.append(f"  exits → T1 ${c['t1']:.2f} · stop ${c['stop']:.2f} · cliff {c['cliff']} DTE")
        for vline in c["verdict"]:
            lines.append(f"  {esc(vline)}")
        if p.get("dp_tag"):
            lines.append(f"  DP: {esc(p['dp_tag'])} — {esc(p.get('dp_note') or '')}".rstrip(" —"))
        lines.append("")
    lines.append(footer("Read-only · relay universe, not a held position · educational, not advice. "
                        "POP on a long option is usually <50% — the edge is the payoff "
                        "(winners run, losses capped), not hit-rate.").lstrip("\n"))
    return "\n".join(lines)


def main() -> int:
    universe = _relay_universe()
    if not universe:
        print("[scorecard] no relay signals — nothing to send")
        return 0
    by_id, by_ts = _darkpool_tags()
    for p in universe:
        p["dp_tag"], p["dp_note"] = _dp_tag_for(p, by_id, by_ts)
    cards = [c for c in (scorecard(p) for p in
             sorted(universe, key=lambda x: (x["exp"] - date.today()).days)) if c]
    if not cards:
        print("[scorecard] no spot/price data — skipping")
        return 0
    card = fmt_card(cards)

    def _plain(s: str) -> str:
        s = re.sub(r"</?[^>]+>", "", s)
        return s.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&")

    if DRY:
        print(_plain(card))
        return 0

    # OneDrive copy (deliverable doctrine)
    try:
        ONEDRIVE.mkdir(parents=True, exist_ok=True)
        (ONEDRIVE / "options-position-scorecard.txt").write_text(_plain(card))
    except Exception as e:
        print(f"[scorecard] OneDrive warn: {e}")

    chat_id = CHAT_FILE.read_text().strip()
    from lib.tg_split import chunks, plain   # 9 cards ran 4.7k chars → Telegram 400 (2026-09-28)
    r = True
    for part in chunks(card):
        sent = _tg("sendMessage", chat_id=chat_id, text=part, parse_mode="HTML") \
            or _tg("sendMessage", chat_id=chat_id, text=plain(part))
        r = r and sent is not None
    r = r or None
    try:   # passive send record (lib/tg_ledger.py) — 2026-09-28
        from lib.tg_ledger import record
        record("trading_recaps", card, r is not None, html=True, src="options_position_scorecard.py")
    except Exception:
        pass
    if r is None:
        return 1
    print(f"[scorecard] sent {len(cards)} contract card(s) at {datetime.now(ET):%H:%M ET}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
