#!/home/itsju/.venv/bin/python
"""options_position_scorecard.py — Options Mastery: the live "take-this-contract"
verdict applied to Mike's OWN open option positions.

The Academy's price×time grid + POP/expected-move math, run on his REAL Boba paper
option positions and pushed to his phone (Telegram) + OneDrive. For each contract:
delta, theta RENT (%/day of premium), POP (finish past breakeven), expected 1σ move
vs the move it still NEEDS, and the three exit marks (T1 +50% → sell half, −50% stop,
21-DTE theta cliff) — plus a one-line disciplined verdict. READ-ONLY: never places
or cancels an order. Paper account only.

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

SEC = Path.home() / ".openclaw" / "secrets"
TOKEN_FILE = SEC / "telegram_laptopclaude_bot_token"
CHAT_FILE = SEC / "telegram-chat-id.txt"
PAPER = "https://paper-api.alpaca.markets"
DATA = "https://data.alpaca.markets"
ET = ZoneInfo("America/New_York")
DRY = os.environ.get("DRY") == "1"
OCC = re.compile(r"^([A-Z]+)(\d{6})([CP])(\d{8})$")
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


def parse_occ(sym: str):
    m = OCC.match(sym)
    if not m:
        return None
    root, ymd, cp, strike8 = m.groups()
    return {"root": root, "exp": date(2000 + int(ymd[:2]), int(ymd[2:4]), int(ymd[4:6])),
            "kind": "call" if cp == "C" else "put", "strike": int(strike8) / 1000.0}


def _positions():
    try:
        rows = _get(f"{PAPER}/v2/positions")
    except Exception as e:
        print(f"positions error: {e}")
        return []
    out = []
    for p in rows:
        info = parse_occ(p.get("symbol", ""))
        if not info:
            continue
        info.update({"symbol": p["symbol"], "qty": int(float(p.get("qty", 0))),
                     "avg": float(p.get("avg_entry_price", 0) or 0),
                     "mark": float(p.get("current_price", 0) or 0),
                     "uplpc": float(p.get("unrealized_plpc", 0) or 0) * 100})
        if info["qty"] != 0:
            out.append(info)
    return out


def scorecard(pos: dict):
    """Compute the grid-derived read for one contract. Returns a dict + a verdict line."""
    spot = _spot(pos["root"])
    if not spot:
        return None
    dte = max((pos["exp"] - datetime.now(ET).date()).days, 0)
    T = max(dte, 0.5) / 365.0
    mark = pos["mark"] or pos["avg"]
    kind, K, avg = pos["kind"], pos["strike"], pos["avg"]
    iv = theo.implied_vol(mark, spot, K, T, kind) or 0.0
    g = theo.bs_greeks(spot, K, T, iv or 0.30, kind) if (iv or mark) else {}
    delta = (g or {}).get("delta")
    theta_day = (g or {}).get("theta_day")
    be = K + avg if kind == "call" else K - avg
    moneyness = "ITM" if ((kind == "call" and spot > K) or (kind == "put" and spot < K)) else "OTM"

    # POP (finish past breakeven), expected 1σ vs needed move
    sig = iv or 0.30
    srt = sig * sqrt(T)
    pop = (ncdf((log(spot / be) - 0.5 * sig * sig * T) / srt) if kind == "call"
           else ncdf((log(be / spot) + 0.5 * sig * sig * T) / srt)) if (srt > 0 and be > 0) else None
    one_sig_pct = sig * sqrt(T) * 100
    need_pct = (be - spot) / spot * 100 * (1 if kind == "call" else -1)  # signed toward profit direction
    need_pct = abs((be - spot) / spot * 100)
    theta_pct = abs(theta_day) * 100 / avg if (theta_day and avg) else None

    # exit marks
    t1, stop, cliff = avg * 1.5, avg * 0.5, min(21, dte)

    # one-line verdict (priority order)
    upl = pos["uplpc"]
    v = []
    if upl >= 50:
        v.append("🔔 T1 hit — SELL HALF, move the stop to breakeven on the runner")
    elif upl >= 25:
        v.append("🟢 winner forming — plan T1 at +50%, don't round-trip it")
    if upl <= -45:
        v.append("🛑 at/under the −50% stop — exit, don't average a loser")
    if dte <= 7 and moneyness == "OTM":
        v.append("⏳ <7 DTE & OTM — theta cliff; exit unless a catalyst hits in days")
    elif dte <= 21 and upl < 0:
        v.append("⏳ ≤21 DTE & red — theta-cliff zone; bail if the catalyst has passed")
    if delta is not None and abs(delta) >= 0.65:
        v.append("ℹ️ deep ITM (~stock substitute) — little leverage left; consider rolling up/out")
    if theta_pct is not None and theta_pct >= 10 and upl < 25:
        v.append(f"🔥 paying ~{theta_pct:.0f}%/day rent — needs to move SOON or it bleeds")
    if not v:
        v.append("✅ in plan — hold to T1 (+50%) / stop (−50%); reassess by 21 DTE")

    return {"pos": pos, "spot": round(spot, 2), "dte": dte, "iv": iv, "delta": delta,
            "theta_day": theta_day, "theta_pct": theta_pct, "be": round(be, 2),
            "moneyness": moneyness, "pop": pop, "one_sig_pct": one_sig_pct,
            "need_pct": need_pct, "t1": t1, "stop": stop, "cliff": cliff, "verdict": v}


def fmt_card(cards) -> str:
    now = datetime.now(ET)
    lines = [f"📟 <b>LIVE CONTRACT SCORECARD</b> — {now:%a %-m/%-d %-I:%M %p ET}",
             "<i>Your open paper option contracts, read through the Academy grid.</i>", ""]
    for c in cards:
        p = c["pos"]
        label = f"{p['root']} {p['strike']:g}{'C' if p['kind']=='call' else 'P'} {p['exp']:%-m/%-d}"
        d = f"{c['delta']:+.2f}" if c["delta"] is not None else "—"
        th = f"${abs(c['theta_day'])*100:.0f}/day" + (f" ({c['theta_pct']:.0f}%)" if c["theta_pct"] is not None else "") if c["theta_day"] is not None else "—"
        pop = f"{c['pop']*100:.0f}%" if c["pop"] is not None else "—"
        lines.append(f"<b>{label}</b> · {p['qty']}x · {p['uplpc']:+.0f}% · {c['moneyness']} · {c['dte']}d")
        lines.append(f"  spot ${c['spot']} · breakeven ${c['be']} · need {c['need_pct']:.1f}% vs 1σ ±{c['one_sig_pct']:.1f}%")
        lines.append(f"  Δ {d} · θ {th} · POP {pop}")
        lines.append(f"  exits → T1 ${c['t1']:.2f} (sell ½) · stop ${c['stop']:.2f} · cliff {c['cliff']} DTE")
        for vline in c["verdict"]:
            lines.append(f"  {vline}")
        lines.append("")
    lines.append("<i>Read-only · paper account · educational, not advice. POP on a long option "
                 "is usually &lt;50% — the edge is the payoff (winners run, losses capped), not hit-rate.</i>")
    return "\n".join(lines)


def main() -> int:
    positions = _positions()
    if not positions:
        print("[scorecard] no open option positions — nothing to send")
        return 0
    cards = [c for c in (scorecard(p) for p in
             sorted(positions, key=lambda x: (x["exp"] - date.today()).days)) if c]
    if not cards:
        print("[scorecard] no spot data — skipping")
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
    r = _tg("sendMessage", chat_id=chat_id, text=card, parse_mode="HTML")
    if r is None:
        return 1
    print(f"[scorecard] sent {len(cards)} contract card(s) at {datetime.now(ET):%H:%M ET}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
