#!/home/itsju/.venv/bin/python
"""extend_bank_charts.py — Options Mastery: chart-READ questions.

Adds a `chart-read` module — questions that show a hand-drawn candlestick chart
(inline SVG) and ask Mike to READ it and pick the right options play. This is the
"screenshot in → verdict out" muscle made into practice: support/resistance,
breakout vs chase, pre-earnings IV, exhaustion gaps, contract selection.

These render in the HTML Academy (renderQuestion injects q.svg). The Telegram
sender skips `svg` questions (text-only), so they live in the Academy surface —
exactly where a chart belongs.

Idempotent: only appends ids not already present; adds the module if missing;
bumps version. Re-run build_academy.py afterward so the HTML picks them up.

Run:  extend_bank_charts.py          (writes the bank)
      DRY=1 extend_bank_charts.py    (prints what it WOULD add)
"""
from __future__ import annotations
import json, os
from pathlib import Path

BANK = Path(__file__).resolve().parent / "options_quiz_bank.json"
DRY = os.environ.get("DRY") == "1"

GREEN, RED, GRID, TXT = "#3fb950", "#f85149", "#27323f", "#8593a1"
AMBER, CYAN = "#ffb020", "#36d6e7"


def candles(ohlc, levels=None, trendline=None, annos=None, label="chart"):
    """Render a compact candlestick SVG. ohlc=[(o,h,l,c)], levels=[(price,label,color?)],
    trendline=(i0,p0,i1,p1), annos=[(i,price,text,color)]."""
    levels = levels or []
    W, H, L, R, T, B = 320, 196, 36, 308, 14, 168
    vals = [v for c in ohlc for v in c[:4]] + [lv[0] for lv in levels]
    lo, hi = min(vals), max(vals)
    pad = (hi - lo) * 0.08 or 1
    lo -= pad; hi += pad

    def y(p):
        return round(B - (p - lo) / (hi - lo) * (B - T), 1)

    n = len(ohlc); slot = (R - L) / n; cw = slot * 0.58
    s = [f'<svg viewBox="0 0 {W} {H}" xmlns="http://www.w3.org/2000/svg" role="img" '
         f'aria-label="{label}" style="max-width:340px;display:block;margin:2px auto 0;'
         f'background:rgba(7,11,16,.55);border-radius:6px">']
    s.append(f'<line x1="{L}" y1="{T}" x2="{L}" y2="{B}" stroke="{GRID}"/>')
    s.append(f'<line x1="{L}" y1="{B}" x2="{R}" y2="{B}" stroke="{GRID}"/>')
    for lv in levels:
        p, lab = lv[0], lv[1]; col = lv[2] if len(lv) > 2 else AMBER
        yy = y(p)
        s.append(f'<line x1="{L}" y1="{yy}" x2="{R}" y2="{yy}" stroke="{col}" stroke-dasharray="4,3" opacity=".8"/>')
        s.append(f'<text x="{R}" y="{yy-2}" text-anchor="end" font-family="monospace" font-size="8" fill="{col}">{lab}</text>')
    if trendline:
        i0, p0, i1, p1 = trendline
        x0 = L + slot * (i0 + 0.5); x1 = L + slot * (i1 + 0.5)
        s.append(f'<line x1="{x0:.1f}" y1="{y(p0)}" x2="{x1:.1f}" y2="{y(p1)}" stroke="{CYAN}" '
                 f'stroke-width="1.3" stroke-dasharray="5,3" opacity=".9"/>')
    for i, (o, h, l, c) in enumerate(ohlc):
        cx = L + slot * (i + 0.5); up = c >= o; col = GREEN if up else RED
        s.append(f'<line x1="{cx:.1f}" y1="{y(h)}" x2="{cx:.1f}" y2="{y(l)}" stroke="{col}" stroke-width="1"/>')
        yo, yc = y(o), y(c); top = min(yo, yc); ht = max(abs(yo - yc), 1)
        s.append(f'<rect x="{cx-cw/2:.1f}" y="{top:.1f}" width="{cw:.1f}" height="{ht:.1f}" fill="{col}"/>')
    for a in (annos or []):
        ai, ap, at, ac = a; ax = L + slot * (ai + 0.5)
        s.append(f'<text x="{ax:.1f}" y="{y(ap)}" text-anchor="middle" font-family="monospace" '
                 f'font-size="8.5" fill="{ac}">{at}</text>')
    s.append('</svg>')
    return ''.join(s)


NEW_MODULES = [
    {"id": "chart-read", "name": "Read the Chart",
     "blurb": "Screenshot-in, verdict-out — as practice. Support/resistance, breakout vs chase, "
              "pre-earnings IV, exhaustion gaps, and which contract the picture argues for."},
]

# --- chart series (deterministic, hand-authored) --------------------------------
_q136 = candles(  # uptrend pullback to RISING support, final green bounce
    [(100,102,99,101),(101,104,100,103),(103,106,102,105),(105,108,104,107),
     (107,109,106,106),(106,108,104,105),(105,106,103,104),(104,105,102.5,103),
     (103,104,102,102.5),(102.5,107,102.4,106)],
    levels=[(101,"rising support",CYAN)],
    trendline=(0,99,8,102),
    annos=[(9,108.5,"bounce ▲",GREEN)], label="uptrend pullback to support")

_q137 = candles(  # triple top — resistance rejected 3x, last red
    [(96,99,95,98),(98,105,97,104),(104,106,103,105),(105,106,104,99),
     (99,101,98,100),(100,105.7,99,104),(104,106,103,99),(99,102,98,101),
     (101,106,100,105),(105,106,104,98)],
    levels=[(106,"resistance ✕3",RED)],
    annos=[(3,106.8,"✕",RED),(6,106.8,"✕",RED),(9,106.8,"✕",RED)], label="triple resistance rejection")

_q138 = candles(  # tight range / coil before earnings, IV high
    [(100,101,99,100.5),(100.5,101,99.5,100),(100,100.8,99.2,100.2),(100.2,101,99.4,99.8),
     (99.8,100.6,99.3,100.1),(100.1,100.7,99.5,99.9),(99.9,100.9,99.4,100.3),(100.3,100.8,99.6,100),
     (100,100.6,99.5,99.9),(99.9,100.7,99.4,100.2)],
    levels=[(101,"range top",TXT),(99,"range floor",TXT)],
    annos=[(4,98.4,"earnings in 2d · IV rank 85",AMBER)], label="pre-earnings coil, high IV")

_q139 = candles(  # bull flag: pole up, tight down-drift flag, breakout
    [(98,101,97.5,100.5),(100.5,104,100,103.5),(103.5,107,103,106.5),(106.5,110,106,109.5),
     (109.5,110,108,108.5),(108.5,109,107.5,108),(108,108.5,107,107.5),(107.5,108,106.8,107.2),
     (107.2,108,106.7,107),(107,113,107,112)],
    levels=[(110,"flag breakout",GREEN)],
    trendline=(4,110,8,108),
    annos=[(2,103,"pole",CYAN),(9,113.5,"break ▲",GREEN)], label="bull flag breakout")

_q140 = candles(  # gap up then fade — exhaustion, alert came AFTER the run
    [(80,81,79.5,80.5),(80.5,82,80,81.5),(81.5,83,81,82.5),(83,84,82.5,83.5),
     (92,95,91,93),(93,93.5,89,90),(90,91,87,88),(88,88.5,85,86),
     (86,87,83.5,84),(84,85,82,83)],
    levels=[(83.5,"pre-gap base",TXT)],
    annos=[(4,96,"+15% GAP",GREEN),(5,95.5,"alert here ↓",AMBER),(8,88.5,"fading ▼",RED)],
    label="gap up then fade")

_q141 = candles(  # clean steady uptrend — contract-selection question
    [(100,102,99.5,101.5),(101.5,103.5,101,103),(103,105,102.5,104.5),(104.5,106.5,104,106),
     (106,108,105.5,107.5),(107.5,109.5,107,109),(109,111,108.5,110.5),(110.5,112.5,110,112),
     (112,114,111.5,113.5),(113.5,115.5,113,115)],
    levels=[(100,"trend origin",CYAN)],
    trendline=(0,99.5,9,113),
    annos=[(8,116,"strong uptrend",GREEN)], label="clean uptrend, pick the contract")


NEW_QUESTIONS = [
    {"id": "opt-136", "module": "chart-read", "level": 2, "svg": _q136,
     "question": "This name is in a clean uptrend and just pulled back to its RISING support line and printed a green bounce candle (your proven edge is CALLS, 8–14 DTE). What's the highest-quality play?",
     "options": ["Buy a 0DTE call right now to maximize leverage",
                 "Buy a slightly-ITM call (≈Δ0.45), 8–14 DTE, on the bounce confirmation off rising support",
                 "Buy a far-OTM Δ0.20 call because it's cheap",
                 "Short puts naked for premium into the bounce"],
     "correct_index": 1,
     "why": "Buy-the-dip into rising support, WITH the trend, is the textbook long-call setup — and it matches your flow fingerprint (CALL · 8–14 DTE). A Δ0.45 slightly-ITM call gives balanced odds and leverage with survivable theta; 0DTE throws away the trend with no time; Δ0.20 is a lottery ticket; naked short puts are undefined risk on a small account.",
     "tags": ["chart-read", "support", "trend", "contract-pick"]},

    {"id": "opt-137", "module": "chart-read", "level": 2, "svg": _q137,
     "question": "Price has tapped this flat ceiling THREE times and been rejected each time (last candle red, back below). A bullish flow alert just pinged. What's disciplined?",
     "options": ["Buy calls now — the 4th touch always breaks",
                 "Don't buy calls INTO triple resistance; wait for a clean breakout-and-retest, or take a small defined-risk put on the rejection",
                 "Buy a straddle and hope it breaks either way",
                 "Average into calls on every rejection"],
     "correct_index": 1,
     "why": "Three rejections at the same level = supply is stacked there; buying calls straight into it is paying full premium for the lowest-odds entry. Either wait for a breakout that holds on a retest (then the level becomes support), or fade the rejection with a DEFINED-RISK put. 'The 4th touch always breaks' is a gambler's tell, not an edge.",
     "tags": ["chart-read", "resistance", "patience"]},

    {"id": "opt-138", "module": "chart-read", "level": 3, "svg": _q138,
     "question": "The stock has coiled into a tight range. The label says earnings in 2 days and IV rank 85. You're bullish. What's the trap-aware move?",
     "options": ["Buy a naked long call and hold it through the print",
                 "Recognize IV is rich pre-earnings — a naked long single-leg gets IV-CRUSHED; wait for after the print, or use a defined-risk / calendar structure to harvest the crush",
                 "Buy a naked long straddle the morning of earnings",
                 "Sell a naked strangle for the fat premium"],
     "correct_index": 1,
     "why": "IV rank 85 into earnings means the fear premium is inflated and will collapse 30–60% the moment the report drops — you can be right on direction and still lose on a long single-leg. Either trade it AFTER the crush, or use a calendar (sell the front/buy the back) to harvest the crush. Naked long = crushed; naked short strangle = undefined risk on a small book.",
     "tags": ["chart-read", "earnings", "iv-crush", "vol-edge"]},

    {"id": "opt-139", "module": "chart-read", "level": 2, "svg": _q139,
     "question": "Strong pole up, then a tight downward-drifting flag, and now a breakout candle through the flag's top. This is your bread-and-butter continuation. Best contract?",
     "options": ["0DTE call — it's breaking now",
                 "A call with 8–14 DTE on the breakout — give the continuation room to run without paying the worst theta",
                 "A 60+ DTE deep-OTM call to be safe",
                 "Sell a call spread against the breakout"],
     "correct_index": 1,
     "why": "A bull-flag breakout is a continuation pattern — your proven CALL · 8–14 DTE window fits perfectly: enough time for the next leg, not so little that theta eats you before the move plays out. 0DTE gives the move no room; 60-DTE deep-OTM over-pays for time and distance; selling a call spread fights the very breakout you identified.",
     "tags": ["chart-read", "bull-flag", "breakout", "dte"]},

    {"id": "opt-140", "module": "chart-read", "level": 3, "svg": _q140,
     "question": "The stock gapped +15% and is now FADING red candle after red candle. The bullish alert pinged AFTER the gap (see marker). What does the picture say?",
     "options": ["Chase the call — momentum names keep running",
                 "RAN_ALREADY / exhaustion — the move already happened and is reversing; chasing here means buying calls from the people taking profit. Skip it (or it's a short/​put context)",
                 "Buy calls because it's 'on sale' after the red candles",
                 "Add a long straddle to catch the next leg"],
     "correct_index": 1,
     "why": "An alert that fires AFTER a big gap, with price already fading, is the classic RAN_ALREADY trap from the flow playbook — you'd be the late buyer the early money sells into. The disciplined read is no-trade (the edge is gone) or, with confirmation, a downside/defined-risk fade. 'On sale after a parabolic' ignores that the trend just flipped.",
     "tags": ["chart-read", "exhaustion", "chase", "flow"]},

    {"id": "opt-141", "module": "chart-read", "level": 2, "svg": _q141,
     "question": "Clean, steady uptrend riding its trendline. You want directional call exposure. Four contracts at the same expiry — which fits the house doctrine?",
     "options": ["Δ0.20 far-OTM call — cheapest, most contracts",
                 "Δ0.45 slightly-ITM call — balanced odds and leverage, survivable theta (the doctrine sweet spot)",
                 "Δ0.65 deep-ITM call — basically owns the stock, minimal leverage",
                 "Δ0.95 call — no time value, why bother with an option"],
     "correct_index": 1,
     "why": "House vehicle doctrine: target Δ0.35–0.55 — balanced probability of finishing ITM and leverage, with theta under ~7%/day. Δ0.20 is a lottery ticket (≈20% ITM odds); Δ0.65 is a stock substitute (you pay for delta you could get cheaper in shares); Δ0.95 is shares with extra steps. Same thesis, smarter ticket — the flow gives you direction, you pick the contract.",
     "tags": ["chart-read", "delta", "contract-pick", "vehicle"]},
]


def main() -> int:
    data = json.loads(BANK.read_text())
    meta = data.setdefault("meta", {})
    mods = meta.setdefault("modules", [])
    have_mod = {m["id"] for m in mods}
    added_mods = [m for m in NEW_MODULES if m["id"] not in have_mod]

    have_q = {q["id"] for q in data.get("questions", [])}
    added_q = [q for q in NEW_QUESTIONS if q["id"] not in have_q]

    new_ids = [q["id"] for q in NEW_QUESTIONS]
    assert len(new_ids) == len(set(new_ids)), "duplicate id in NEW_QUESTIONS"
    valid_mods = have_mod | {m["id"] for m in NEW_MODULES}
    for q in NEW_QUESTIONS:
        assert q["module"] in valid_mods, f"{q['id']} → unknown module {q['module']}"
        assert 0 <= q["correct_index"] < len(q["options"]), f"{q['id']} bad correct_index"
        assert "</script" not in q.get("svg", "").lower(), f"{q['id']} svg has a script tag"

    if DRY:
        print(f"[DRY] would add {len(added_mods)} modules: {[m['id'] for m in added_mods]}")
        print(f"[DRY] would add {len(added_q)} questions: {[q['id'] for q in added_q]}")
        print(f"[DRY] bank would total {len(have_q)+len(added_q)} questions")
        return 0

    mods.extend(added_mods)
    data["questions"].extend(added_q)
    meta["version"] = "2.1"
    BANK.write_text(json.dumps(data, ensure_ascii=False, indent=2))
    print(f"[extend-charts] +{len(added_mods)} modules, +{len(added_q)} questions "
          f"→ {len(data['questions'])} total (v{meta['version']})")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
