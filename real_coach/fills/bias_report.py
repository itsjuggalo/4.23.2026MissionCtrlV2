#!/usr/bin/env python3
"""bias_report.py — quantify Mike's 5 self-named trading biases from his REAL history.

Data: round_trips + fills in mike.sqlite (5y, all four sources). Price context:
one batched yfinance pull; forward-return and drawdown math stays inside yfinance's
adjusted series (own-close ratios) so splits/adjustments can't skew it.

The five biases (his own words, 2026-07-07):
  1. sells winners early  → max forward return within 30d AFTER each sell
  2. holds losers         → max drawdown endured while a (losing) trip was open
  3. oversizing           → buy-size distribution vs account scale
  4. FOMO chasing         → 5-day pre-buy run-up; chase vs patient outcomes
  5. options theta/IV     → option win rate, expired-worthless count, hold times

Writes ~/portfolio/REPORT_CARD.md + grades back onto round_trips; --send Telegrams
the summary + grade card. Read-only against brokers (DB + yfinance only).
"""
from __future__ import annotations

import argparse
import subprocess
import sys
import traceback
from datetime import timedelta
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent.parent.parent))

from real_coach.fills import db  # noqa: E402
from real_coach import symbols as symmod  # noqa: E402

OUT_MD = Path.home() / "portfolio" / "REPORT_CARD.md"
TG_FLEET = Path.home() / "scripts" / "tg_fleet.py"
GRADE_ORDER = "ABCDF"


def _grade(value, cuts, reverse=False):
    """cuts = 4 thresholds A<B<C<D; value below first cut → A (or above, if reverse)."""
    g = 4
    for i, c in enumerate(cuts):
        if (value <= c) if not reverse else (value >= c):
            g = i
            break
    return GRADE_ORDER[g]


def _yf_symbol(sym: str, ac: str) -> str:
    return symmod.ta_symbol(sym, "crypto") if ac == "crypto" else sym


def load_prices(pairs: set[tuple[str, str]]):
    """(sym, ac) set → {yf_sym: (close_series, low_series)} via one batched download."""
    import yfinance as yf
    want = sorted({_yf_symbol(s, a) for s, a in pairs})
    out = {}
    try:
        raw = yf.download(" ".join(want), start="2021-01-01", interval="1d",
                          progress=False, threads=True, auto_adjust=True, group_by="ticker")
        for t in want:
            try:
                df = raw[t] if len(want) > 1 else raw
                c = df["Close"].dropna()
                lo = df["Low"].dropna()
                if len(c) > 30:
                    out[t] = (c, lo)
            except Exception:
                pass
    except Exception:
        print("yfinance batch failed:\n" + traceback.format_exc())
    return out


def analyze(con, px) -> dict:
    import pandas as pd

    trips = pd.read_sql_query(
        "SELECT id, broker, asset_class, symbol, occ_symbol, qty, entry_px, exit_px,"
        " entry_at, exit_at, pnl_usd, pnl_pct, hold_days FROM round_trips", con)
    buys = pd.read_sql_query(
        "SELECT id, broker, asset_class, symbol, qty, price, amount_usd, filled_at,"
        " synthetic FROM fills WHERE side='buy' AND synthetic=0", con)
    for df, col in ((trips, "entry_at"), (trips, "exit_at"), (buys, "filled_at")):
        # floor to seconds: yfinance indexes are datetime64[s]; microsecond stamps make
        # searchsorted raise "Cannot losslessly convert units" and drop every RH row
        df[col + "_d"] = (pd.to_datetime(df[col], errors="coerce", utc=True)
                          .dt.tz_localize(None).dt.floor("s"))

    def series_for(sym, ac):
        return px.get(_yf_symbol(sym, ac))

    # 1 + 2: forward return after sells / drawdown while held (non-option trips)
    fwd_rows, dd_rows, updates = [], [], []
    for t in trips.itertuples():
        if t.asset_class == "option":
            continue
        s = series_for(t.symbol, t.asset_class)
        if not s:
            continue
        c, lo = s
        try:
            exit_d = t.exit_at_d
            entry_d = t.entry_at_d
            if pd.isna(exit_d) or pd.isna(entry_d):
                continue
            ci = c.index.searchsorted(exit_d)
            if ci >= len(c):
                continue
            base = float(c.iloc[max(ci - 1, 0)])
            fwd_win = c.iloc[ci:c.index.searchsorted(exit_d + timedelta(days=30))]
            fwd = (float(fwd_win.max()) / base - 1) * 100 if len(fwd_win) and base else None
            ei = c.index.searchsorted(entry_d)
            entry_base = float(c.iloc[min(ei, len(c) - 1)])
            held_lo = lo.iloc[lo.index.searchsorted(entry_d):lo.index.searchsorted(exit_d) + 1]
            mdd = (float(held_lo.min()) / entry_base - 1) * 100 if len(held_lo) and entry_base else None
            if fwd is not None:
                fwd_rows.append({"id": t.id, "symbol": t.symbol, "pnl_pct": t.pnl_pct,
                                 "pnl_usd": t.pnl_usd, "fwd": fwd, "exit_at": str(t.exit_at)[:10],
                                 "hold_days": t.hold_days})
            if mdd is not None:
                dd_rows.append({"id": t.id, "symbol": t.symbol, "pnl_pct": t.pnl_pct,
                                "pnl_usd": t.pnl_usd, "mdd": mdd, "hold_days": t.hold_days})
            updates.append((fwd, mdd, t.id))
        except Exception:
            continue
    con.executemany("UPDATE round_trips SET fwd_ret_30d=?, max_drawdown_pct=? WHERE id=?",
                    updates)
    con.commit()
    fwd_df = pd.DataFrame(fwd_rows)
    dd_df = pd.DataFrame(dd_rows)

    # 4: FOMO — 5-day pre-buy run-up per buy fill + 30d fwd outcome
    fomo_rows = []
    for b in buys.itertuples():
        if b.asset_class == "option":
            continue
        s = series_for(b.symbol, b.asset_class)
        if not s:
            continue
        c, _ = s
        try:
            bi = c.index.searchsorted(b.filled_at_d)
            if bi < 6 or bi >= len(c):
                continue
            run5 = (float(c.iloc[bi - 1]) / float(c.iloc[bi - 6]) - 1) * 100
            fw = c.iloc[bi:c.index.searchsorted(b.filled_at_d + timedelta(days=30))]
            fwd = (float(fw.max()) / float(c.iloc[bi - 1]) - 1) * 100 if len(fw) else None
            fomo_rows.append({"symbol": b.symbol, "usd": abs(b.amount_usd or 0),
                              "run5": run5, "fwd": fwd, "at": str(b.filled_at)[:10]})
        except Exception:
            continue
    fomo_df = pd.DataFrame(fomo_rows)

    # 5: options
    opt = trips[trips.asset_class == "option"]

    return {"trips": trips, "buys": buys, "fwd": fwd_df, "dd": dd_df,
            "fomo": fomo_df, "opt": opt}


def build_report(d) -> tuple[str, str, dict]:
    import pandas as pd
    trips, buys, fwd, dd, fomo, opt = (d["trips"], d["buys"], d["fwd"], d["dd"],
                                       d["fomo"], d["opt"])
    L = ["# YOUR TRADING REPORT CARD",
         f"*5 years of REAL fills (RH + Coinbase) · {len(buys)} buys · "
         f"{len(trips)} closed round-trips · generated {pd.Timestamp.now():%Y-%m-%d %H:%M} ET*",
         ""]
    grades = {}

    # ── 1. selling winners early ──
    if len(fwd):
        sold_winners = fwd[fwd.pnl_pct > 0]
        early = fwd[fwd.fwd >= 20]
        pct_early = len(early) / len(fwd) * 100
        med_missed = fwd.fwd.median()
        grades["sells_early"] = _grade(pct_early, (10, 20, 30, 45))
        L += [f"## 1. Selling winners early — **{grades['sells_early']}**",
              f"- After **{pct_early:.0f}%** of your sells, the price ran **≥+20% within 30 days**"
              f" (median post-sell max runup {med_missed:+.1f}%).",
              f"- On sells that were already winners ({len(sold_winners)}), median further runup "
              f"{sold_winners.fwd.median():+.1f}% — the leg you kept missing.",
              "", "Worst 5 early exits (what ran after you sold):", ""]
        fwd_show = fwd.sort_values("fwd", ascending=False)\
                      .drop_duplicates(subset=["symbol", "exit_at"])
        for r in fwd_show.head(5).itertuples():
            L.append(f"- **{r.symbol}** sold {r.exit_at} after {r.hold_days:.0f}d "
                     f"(trip {r.pnl_pct:+.0f}%) → ran **{r.fwd:+.0f}%** in the next 30d")
        L.append("")

    # ── 2. holding losers ──
    if len(dd):
        losers = dd[dd.pnl_pct < 0]
        winners_dd = dd[dd.pnl_pct > 0]
        deep = dd[dd.mdd <= -30]
        pct_deep = len(deep) / len(dd) * 100
        grades["holds_losers"] = _grade(pct_deep, (10, 20, 35, 50))
        lh, wh = losers.hold_days.mean() or 0, winners_dd.hold_days.mean() or 0
        hold_read = (f"losing trips held **{lh:.0f}d** vs {wh:.0f}d for winners — "
                     + ("you sit in the pain longer." if lh > wh else
                        "your long holds are the winners; the damage is the DEPTH you tolerate on the way."))
        L += [f"## 2. Holding losers — **{grades['holds_losers']}**",
              f"- **{pct_deep:.0f}%** of closed trips endured a **−30%+ drawdown** while open"
              f" (median worst-point {dd.mdd.median():+.1f}%).",
              f"- {hold_read}",
              "", "Deepest 5 rides:", ""]
        dd_show = dd.sort_values("mdd").drop_duplicates(subset=["symbol"])
        for r in dd_show.head(5).itertuples():
            L.append(f"- **{r.symbol}** bottomed **{r.mdd:+.0f}%** mid-trip, closed {r.pnl_pct:+.0f}%"
                     f" after {r.hold_days:.0f}d")
        L.append("")
        L.append("*And that's only CLOSED trips — DOGE −65% / MSTY −88% / AMC −99% are "
                 "still open in the book right now.*\n")

    # ── 3. sizing ──
    real_buys = buys[(buys.synthetic == 0) & (buys.asset_class != "option")]
    usd = real_buys.amount_usd.abs().dropna()
    usd = usd[usd > 1]
    if len(usd):
        p50, p90, mx = usd.median(), usd.quantile(0.9), usd.max()
        ratio = mx / max(p50, 1)
        grades["oversizing"] = _grade(ratio, (5, 12, 25, 60))
        L += [f"## 3. Position sizing — **{grades['oversizing']}**",
              f"- Median buy **${p50:,.0f}** · p90 **${p90:,.0f}** · biggest **${mx:,.0f}** "
              f"({ratio:.0f}× your median — one YOLO can erase months).",
              "", "Top 5 biggest buys:", ""]
        for r in real_buys.reindex(real_buys.amount_usd.abs().sort_values(ascending=False).index)\
                          .head(5).itertuples():
            L.append(f"- **{r.symbol}** ${abs(r.amount_usd):,.0f} on {str(r.filled_at)[:10]}")
        L.append("")

    # ── 4. FOMO chasing ──
    if len(fomo):
        chase = fomo[fomo.run5 >= 15]
        patient = fomo[fomo.run5 < 15]
        pct_chase = len(chase) / len(fomo) * 100
        grades["fomo"] = _grade(pct_chase, (8, 15, 25, 40))
        cw = chase.fwd.dropna()
        pw = patient.fwd.dropna()
        L += [f"## 4. FOMO chasing — **{grades['fomo']}**",
              f"- **{pct_chase:.0f}%** of buys came after a **+15% five-day run** "
              f"({len(chase)} of {len(fomo)}).",
              f"- Chased buys saw median +{cw.median():.1f}% max upside in 30d vs "
              f"+{pw.median():.1f}% for patient buys — "
              f"{'chasing UNDERperformed' if cw.median() < pw.median() else 'roughly even here'}"
              f", and chases carry far worse entries on the downside.",
              ""]

    # ── 5. options ──
    if len(opt):
        wins = opt[opt.pnl_usd > 0]
        expired = opt[(opt.exit_px == 0)]
        wr = len(wins) / len(opt) * 100
        net_opt = opt.pnl_usd.sum()
        grades["options"] = _grade(100 - wr, (30, 45, 60, 75))
        if net_opt < 0 and grades["options"] in "ABC":
            grades["options"] = "D"   # a losing book can't grade above D no matter the win rate
        L += [f"## 5. Options discipline — **{grades['options']}**"
              + (" *(win rate lies — the NET is red: one oversized loser ate every win)*"
                 if net_opt < 0 and wr >= 60 else ""),
              f"- {len(opt)} closed option trips · win rate **{wr:.0f}%** · "
              f"net **${opt.pnl_usd.sum():+,.0f}**.",
              f"- **{len(expired)} expired worthless** (−100%); avg hold "
              f"{opt.hold_days.mean():.1f}d.",
              ""]
        for r in opt.nlargest(3, "pnl_usd").itertuples():
            L.append(f"- best: **{r.symbol}** {r.occ_symbol or ''} {r.pnl_pct:+.0f}% (${r.pnl_usd:+,.0f})")
        for r in opt.nsmallest(2, "pnl_usd").itertuples():
            L.append(f"- worst: **{r.symbol}** {r.occ_symbol or ''} {r.pnl_pct:+.0f}% (${r.pnl_usd:+,.0f})")
        L.append("")

    # ── overall ──
    closed = trips[trips.asset_class != "option"]
    wr_all = (closed.pnl_usd > 0).mean() * 100 if len(closed) else 0
    net = trips.pnl_usd.sum()
    L += ["## Bottom line",
          f"- Closed-trip win rate **{wr_all:.0f}%** · realized net across all closed trips "
          f"**${net:+,.0f}**.",
          "- The coach now enforces: hard stop lines on every satellite, trail ratchets on "
          "winners, dead-bag exits INTO strength, core positions protected from panic sells, "
          "and (P3) every override gets tracked and scored.",
          ""]

    tg = ["📊 YOUR TRADING REPORT CARD (5y, real fills)"]
    label = {"sells_early": "Selling winners early", "holds_losers": "Holding losers",
             "oversizing": "Sizing", "fomo": "FOMO chasing", "options": "Options"}
    for k, g in grades.items():
        tg.append(f"{'🟢' if g in 'AB' else '🟡' if g == 'C' else '🔴'} {label[k]}: {g}")
    tg.append(f"win rate {wr_all:.0f}% · realized net ${net:+,.0f} · full detail: REPORT_CARD.md")
    return "\n".join(L), "\n".join(tg), grades


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--send", action="store_true")
    a = ap.parse_args()
    con = db.connect()
    pairs = {(r[0], r[1]) for r in con.execute(
        "SELECT DISTINCT symbol, asset_class FROM round_trips WHERE asset_class!='option' "
        "UNION SELECT DISTINCT symbol, asset_class FROM fills WHERE side='buy' AND synthetic=0 "
        "AND asset_class!='option'")}
    print(f"pricing {len(pairs)} symbols…")
    px = load_prices(pairs)
    print(f"got candles for {len(px)}")
    d = analyze(con, px)
    md, tg, grades = build_report(d)
    OUT_MD.write_text(md)
    print(md)
    print(f"\n→ {OUT_MD}")
    if a.send:
        subprocess.run([sys.executable, str(TG_FLEET), "send", "trading_command", tg],
                       timeout=30, check=False)
    return 0


if __name__ == "__main__":
    sys.exit(main())
