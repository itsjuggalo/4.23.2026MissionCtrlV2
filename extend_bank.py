#!/home/itsju/.venv/bin/python
"""extend_bank.py — additively grow options_quiz_bank.json.

Adds deeper text questions + a NEW visual "Payoff Diagrams" module whose questions
carry an inline `svg` field (expiration P/L diagrams). Idempotent: skips ids already
present, so it's safe to re-run. After running, rebuild the HTML: build_academy.py.

Telegram reps stay TEXT-ONLY — options_quiz.py skips any question with an `svg`.
"""
from __future__ import annotations
import json
from pathlib import Path

BANK = Path(__file__).resolve().parent / "options_quiz_bank.json"

# ── inline SVG payoff-diagram generator (expiration P/L) ─────────────────────
def payoff_svg(fn, pmin, pmax, strikes):
    W, H = 320, 196
    x0, x1, ytop, ybot = 50, 304, 22, 166
    xs = [pmin + (pmax - pmin) * i / 80 for i in range(81)]
    ys = [fn(p) for p in xs]
    ymin, ymax = min(ys), max(ys)
    pad = (ymax - ymin) * 0.14 or 1.0
    ymin -= pad; ymax += pad
    def sx(p): return x0 + (p - pmin) / (pmax - pmin) * (x1 - x0)
    def sy(v): return ybot - (v - ymin) / (ymax - ymin) * (ybot - ytop)
    zy = sy(0)
    # split polyline into green (>=0) and red (<0) segments for clarity
    def seg(cond):
        out, run = [], []
        for p, v in zip(xs, ys):
            if cond(v):
                run.append(f"{sx(p):.1f},{sy(v):.1f}")
            else:
                if run: out.append(" ".join(run)); run = []
        if run: out.append(" ".join(run))
        return out
    line_all = " ".join(f"{sx(p):.1f},{sy(v):.1f}" for p, v in zip(xs, ys))
    strikemarks = "".join(
        f'<line x1="{sx(k):.1f}" y1="{ytop}" x2="{sx(k):.1f}" y2="{ybot}" stroke="#324252" stroke-width="1" stroke-dasharray="3 3"/>'
        for k in strikes)
    return (
        f'<svg viewBox="0 0 {W} {H}" width="100%" role="img" aria-label="payoff diagram" '
        f'style="max-width:340px;display:block;margin:2px auto 0;background:rgba(7,11,16,.5);border:1px solid #27323f;border-radius:8px">'
        f'<line x1="{x0}" y1="{ytop}" x2="{x0}" y2="{ybot}" stroke="#324252" stroke-width="1"/>'
        f'<line x1="{x0}" y1="{zy:.1f}" x2="{x1}" y2="{zy:.1f}" stroke="#56657a" stroke-width="1" stroke-dasharray="2 3"/>'
        f'{strikemarks}'
        f'<polyline points="{line_all}" fill="none" stroke="#36d6e7" stroke-width="2.5" stroke-linejoin="round" stroke-linecap="round"/>'
        f'<text x="{x0-3}" y="{ytop+4}" fill="#8593a1" font-size="9" font-family="monospace" text-anchor="end">+P/L</text>'
        f'<text x="{x0-3}" y="{ybot}" fill="#8593a1" font-size="9" font-family="monospace" text-anchor="end">−</text>'
        f'<text x="{(x0+x1)/2:.0f}" y="{H-4}" fill="#8593a1" font-size="9" font-family="monospace" text-anchor="middle">underlying price →</text>'
        f'</svg>')

# payoff functions (piecewise-linear, expiration)
def f_long_call(p):  return max(0, p-50) - 8
def f_long_put(p):   return max(0, 50-p) - 8
def f_bull_call(p):  return max(0, p-45) - max(0, p-60) - 6
def f_covered(p):    return (p-50) + (4 - max(0, p-58))
def f_short_put(p):  return 6 - max(0, 50-p)
def f_straddle(p):   return abs(p-50) - 12
def f_condor(p):     return min(4, 4 - max(0,45-p)*1.0 - max(0,p-55)*1.0)  # tent
def f_bear_put(p):   return max(0, 55-p) - max(0, 45-p) - 6

PAYOFF = [
    ("opt-101", f_long_call, 30, 75, [50], "Long Call",
     ["Long call", "Long put", "Covered call", "Cash-secured put"],
     "Flat at a small loss (the premium) until the strike, then it rises without a ceiling once price clears strike+premium. Capped loss, unlimited upside = a long call."),
    ("opt-102", f_long_put, 25, 70, [50], "Long Put",
     ["Long call", "Long put", "Short put", "Bull call spread"],
     "Rises to the LEFT (gains as price falls), flat small loss to the right. Profit when the stock drops, max loss = premium. That's a long put."),
    ("opt-103", f_bull_call, 35, 70, [45, 60], "Bull Call (Debit) Spread",
     ["Long call", "Bull call (debit) spread", "Iron condor", "Long straddle"],
     "Two kinks: flat loss below the lower strike, a rising ramp between the strikes, then flat capped GAIN above the upper strike. Defined risk AND defined reward = a debit (bull call) spread."),
    ("opt-104", f_covered, 36, 70, [58], "Covered Call",
     ["Covered call", "Long call", "Iron condor", "Long straddle"],
     "Rises with the stock but the upside is CAPPED above the short strike (the premium adds a small cushion below). Large downside if the stock falls = covered call (long stock + short call)."),
    ("opt-105", f_short_put, 25, 72, [50], "Short / Cash-Secured Put",
     ["Long put", "Short (cash-secured) put", "Bull call spread", "Long call"],
     "Flat capped PROFIT (the premium) above the strike, then losses grow as the stock falls below it. You're paid to take downside risk = a short / cash-secured put."),
    ("opt-106", f_straddle, 28, 72, [50], "Long Straddle",
     ["Long call", "Long straddle", "Covered call", "Iron condor"],
     "A V-shape: max loss at the strike, profit if price moves FAR either direction past the combined premium. A volatility bet = long straddle (long call + long put, same strike)."),
    ("opt-107", f_condor, 32, 68, [45, 55], "Iron Condor",
     ["Long straddle", "Iron condor", "Bull call spread", "Covered call"],
     "A tent: flat capped profit while price stays in the middle range, capped losses at both wings. A defined-risk, range-bound, theta-positive trade = an iron condor."),
    ("opt-108", f_bear_put, 35, 68, [45, 55], "Bear Put (Debit) Spread",
     ["Bull call spread", "Bear put (debit) spread", "Long call", "Short put"],
     "Mirror of the bull call spread: flat capped GAIN below the lower strike, a ramp down between strikes, flat loss above the upper strike. Profits as the stock falls, defined both ways = a bear put spread."),
]

def make_payoff_q(qid, fn, pmin, pmax, strikes, name, options, why):
    ci = next(i for i, o in enumerate(options) if o.lower().split(" (")[0] in name.lower() or name.lower().startswith(o.lower().split(" (")[0]))
    return {"id": qid, "module": "payoff", "level": 2,
            "question": "Which strategy does this expiration payoff diagram show?",
            "svg": payoff_svg(fn, pmin, pmax, strikes),
            "options": options, "correct_index": ci, "why": why,
            "tags": ["payoff", "visual", name.lower().replace(" ", "-")]}

# ── new TEXT questions (opt-079 .. opt-100) ──────────────────────────────────
TEXT = [
 {"id":"opt-079","module":"greeks-iv","level":3,"question":"Vega (sensitivity to IV) is LARGEST for which options?","options":["Deep ITM, short-dated","At-the-money, longer-dated","Far OTM, expiring today","It's the same for all"],"correct_index":1,"why":"ATM options with more time to expiration have the most extrinsic value, so they react most to IV changes. That's why a longer-dated ATM straddle is essentially a pure volatility bet.","tags":["vega","iv"]},
 {"id":"opt-080","module":"greeks-iv","level":3,"question":"As an ATM option approaches expiration, its gamma generally…","options":["Falls to zero","Spikes sharply higher","Stays flat","Turns negative"],"correct_index":1,"why":"Gamma concentrates near the strike as time runs out — tiny moves flip the option between OTM and ITM, so delta swings violently. This is exactly why 0DTE ATM options are so explosive (and dangerous).","tags":["gamma","dte"]},
 {"id":"opt-081","module":"greeks-iv","level":3,"question":"Rho (interest-rate sensitivity) matters most for…","options":["0DTE options","Long-dated options / LEAPS","Far-OTM weeklies","Covered calls"],"correct_index":1,"why":"Rho grows with time to expiration, so it's only really meaningful on long-dated options (LEAPS). For the weeklies/monthlies most retail traders use, rho is a rounding error vs delta/theta/vega.","tags":["rho","leaps"]},
 {"id":"opt-082","module":"greeks-iv","level":2,"question":"If a stock's implied volatility (IV) is much HIGHER than its recent realized/historical volatility (HV), options are…","options":["Cheap relative to actual movement","Expensive — the market is pricing more movement than has been happening","Free of theta","Guaranteed to fall"],"correct_index":1,"why":"IV >> HV means the market is charging up premium for expected (often event-driven) movement. Buying then is paying up; it favors premium SELLERS unless you expect the move to exceed what's priced.","tags":["iv","hv"]},
 {"id":"opt-083","module":"strategy","level":2,"question":"A LEAPS call is…","options":["A 0DTE call","A long-dated call (typically >1 year out)","A naked call","A call on leveraged ETFs only"],"correct_index":1,"why":"LEAPS = Long-term Equity AnticiPation Securities: options expiring far out (often 1-2+ years). A deep-ITM LEAPS call acts like owning the stock with less capital and slower daily theta — a 'stock replacement.'","tags":["leaps"]},
 {"id":"opt-084","module":"strategy","level":3,"question":"An iron condor makes money when…","options":["The stock makes a huge move","The stock stays within a range between the short strikes","IV explodes higher","It always loses"],"correct_index":1,"why":"An iron condor sells an OTM put spread AND an OTM call spread — you collect credit and profit if the stock stays range-bound between the short strikes. Defined risk on both wings; it's a theta-positive, low-volatility bet.","tags":["iron-condor","range"]},
 {"id":"opt-085","module":"strategy","level":3,"question":"A calendar (time) spread profits mainly from…","options":["A big directional move","The faster time-decay of the near-dated short option vs the longer-dated long option","Rising interest rates","Assignment"],"correct_index":1,"why":"Sell a near-dated option, buy a longer-dated one at the same strike. The short leg decays faster (more theta), and the position also gains if IV rises. Best when the stock sits near the strike as the front month expires.","tags":["calendar","theta"]},
 {"id":"opt-086","module":"strategy","level":2,"question":"'Rolling' an option means…","options":["Doubling your size","Closing the current option and opening a new one (later date and/or different strike) to extend or adjust","Exercising early","Converting to stock"],"correct_index":1,"why":"A roll is one combined adjustment: buy-to-close the existing contract and sell/buy-to-open a new expiration or strike. Traders roll to give a thesis more time, take in more credit, or move a tested short strike away.","tags":["roll"]},
 {"id":"opt-087","module":"strategy","level":2,"question":"A protective put is…","options":["Selling a put for income","Owning stock AND buying a put as downside insurance","Two short puts","A naked call"],"correct_index":1,"why":"Long stock + long put sets a floor: below the put's strike your losses stop (minus the premium paid). It's literally insurance on a position you want to keep — you pay premium for peace of mind.","tags":["protective-put","hedge"]},
 {"id":"opt-088","module":"strategy","level":3,"question":"A 'collar' on a stock position is…","options":["Long stock + long put + short call","Two long calls","A naked straddle","Long stock only"],"correct_index":0,"why":"A collar finances the protective put by selling a covered call above the price: long stock + long put (floor) + short call (ceiling). You cap upside to pay for downside protection — popular for protecting big gains cheaply.","tags":["collar","hedge"]},
 {"id":"opt-089","module":"risk","level":1,"question":"'Defined-risk' trade means…","options":["You can't lose","Your maximum loss is known and capped the moment you enter","No theta","Guaranteed profit"],"correct_index":1,"why":"Defined-risk structures (long options, debit/credit spreads) have a max loss you can calculate before entering — so you can size to it. Undefined-risk trades (naked calls/puts) can lose far more than you planned. Small accounts should live in defined-risk.","tags":["defined-risk"]},
 {"id":"opt-090","module":"risk","level":2,"question":"Why should you almost always use a LIMIT order (not a market order) when trading options?","options":["Limit orders are free","Option bid-ask spreads are often wide — a market order can fill at a terrible price","Market orders are banned","It avoids assignment"],"correct_index":1,"why":"Options frequently have wide bid-ask spreads and thin liquidity; a market order can fill well away from fair value, quietly costing you real money on entry AND exit. Always set a limit (often near the mid).","tags":["limit-order","execution"],"rh_note":"On Robinhood, tap to set a limit price near the mid instead of 'market'. On a $6k account, a bad fill on a wide spread can cost you several percent before the trade even moves."},
 {"id":"opt-091","module":"risk","level":2,"question":"The 'probability of profit' (POP) on a far-OTM long call is generally…","options":["Very high","Low — most far-OTM long calls expire worthless","Exactly 50%","Guaranteed"],"correct_index":1,"why":"Far-OTM calls are cheap precisely because they're unlikely to pay off — low delta ≈ low odds of finishing ITM. They feel like leverage but most expire worthless; the occasional big winner rarely covers the steady stream of zeros.","tags":["pop","otm"]},
 {"id":"opt-092","module":"risk","level":3,"question":"A trade that risks $200 to make $100 (2:1 against you) needs roughly what WIN RATE just to break even?","options":["About 33%","About 50%","About 67%","About 10%"],"correct_index":2,"why":"Break-even win rate p solves p×100 = (1−p)×200 → p ≈ 0.67. When your reward is smaller than your risk, you must win MORE often than you lose just to stay flat. Risk/reward and win rate are two halves of the same edge.","tags":["risk-reward","expectancy"]},
 {"id":"opt-093","module":"entry-exit","level":2,"question":"You hold an ITM long call you want to exit. Usually it's better to…","options":["Exercise it early","Sell-to-close (capture the remaining time value instead of forfeiting it)","Let it expire","Roll it forever"],"correct_index":1,"why":"Exercising early throws away any remaining extrinsic (time) value — you only get intrinsic. Selling-to-close captures intrinsic PLUS whatever time value is left, and needs no capital to buy 100 shares. Exercise is rarely the right retail move.","tags":["sell-to-close","exercise"]},
 {"id":"opt-094","module":"entry-exit","level":3,"question":"'Pin risk' refers to…","options":["A stock gapping overnight","Uncertainty when the stock sits right AT your strike into expiration (will it be assigned or not?)","A margin call","High theta"],"correct_index":1,"why":"If the underlying closes almost exactly on your strike at expiration, you can't be sure whether a short option gets assigned — you may wake up with (or without) an unexpected 100-share position. Close pinned short options before the close to avoid the coin-flip.","tags":["pin-risk","assignment"]},
 {"id":"opt-095","module":"entry-exit","level":2,"question":"Before buying an option, a key LIQUIDITY check is…","options":["Pick the cheapest premium","Prefer tight bid-ask spreads and high open interest/volume so you can exit easily","Only trade 0DTE","Ignore the spread"],"correct_index":1,"why":"An option you can't sell at a fair price is a trap. Tight spreads + healthy OI/volume mean you can get OUT near fair value. Illiquid contracts (wide spread, tiny OI) can cost you a chunk just to exit — check liquidity before you enter.","tags":["liquidity","oi"]},
 {"id":"opt-096","module":"entry-exit","level":2,"question":"For the SAME bullish thesis, a 0DTE call vs a 45-DTE call mainly differs in that 0DTE…","options":["Is always safer","Needs the move to happen TODAY — extreme gamma and theta, little room to be early","Has no theta","Costs more"],"correct_index":1,"why":"0DTE is all-or-nothing intraday: huge gamma (violent swings) and brutal theta (it's worthless by close if OTM). 45-DTE gives your thesis weeks to play out with gentler decay. Same direction, totally different risk — pick the DTE that matches your timing confidence.","tags":["dte","0dte"]},
 {"id":"opt-097","module":"flow","level":3,"question":"A large PUT sweep printing ask-side could mean…","options":["Definitely bearish, copy it","A bearish bet OR downside hedging/protection — check the context before assuming direction","A data error","The stock will rise"],"correct_index":1,"why":"Aggressive put buying can be a directional short OR portfolio insurance against longs. Like big call prints, a single put sweep doesn't reveal intent by itself — size, repetition, the stock's setup, and whether it's opening all matter before you read it as 'bearish.'","tags":["puts","hedge","flow"]},
 {"id":"opt-098","module":"flow","level":2,"question":"Heavy unusual activity in WEEKLY options vs in LEAPS tends to signal…","options":["Exactly the same thing","Weeklies = a near-term catalyst/gamma play; LEAPS = longer-term positioning or hedging","Weeklies are always wrong","LEAPS are illiquid junk"],"correct_index":1,"why":"Short-dated weekly flow usually keys on an imminent catalyst (earnings, event, momentum). Big LEAPS flow points to longer-horizon conviction or hedging. The expiration the smart money chose tells you their TIME FRAME — match yours to it.","tags":["weeklies","leaps","flow"]},
 {"id":"opt-099","module":"robinhood","level":2,"question":"To trade a multi-leg spread (e.g. a debit call spread) on Robinhood you generally need…","options":["No approval at all","Level 3 options approval, and both legs fill together as one order","A margin loan","100 shares first"],"correct_index":1,"why":"Spreads require higher options approval (Level 3) because they involve a short leg. RH submits both legs as a single combo order at a net debit/credit, so you're not legging in one side at a time. Apply for the level before you plan spread trades.","tags":["levels","spreads"]},
 {"id":"opt-100","module":"robinhood","level":2,"question":"On Robinhood, the buying power a LONG option ties up equals…","options":["Nothing","The premium paid (×100); a spread ties up its net debit / defined max loss","The strike price","Your whole account"],"correct_index":1,"why":"A long option costs (and reserves) its premium × 100. A defined-risk spread only ties up its net debit (its max loss), which is why spreads are so capital-efficient on a small account vs buying the naked long option outright.","tags":["buying-power","spreads"]},
]


def main() -> int:
    data = json.loads(BANK.read_text())
    qs = data["questions"]
    have = {q["id"] for q in qs}

    # add payoff module to meta
    mods = data["meta"]["modules"]
    if not any(m["id"] == "payoff" for m in mods):
        mods.append({"id": "payoff", "name": "Payoff Diagrams",
                     "blurb": "Read the picture — recognize each strategy from its expiration P/L shape."})

    added = 0
    for q in TEXT:
        if q["id"] not in have:
            qs.append(q); have.add(q["id"]); added += 1
    for (qid, fn, pmin, pmax, strikes, name, options, why) in PAYOFF:
        if qid not in have:
            qs.append(make_payoff_q(qid, fn, pmin, pmax, strikes, name, options, why))
            have.add(qid); added += 1

    BANK.write_text(json.dumps(data, ensure_ascii=False, indent=2))
    print(f"[extend_bank] +{added} questions → {len(qs)} total ({sum(1 for q in qs if 'svg' in q)} visual)")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
