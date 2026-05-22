#!/usr/bin/env python3
"""Backtest framework — replay decision cycles on historical signals.
Usage:
  python3 replay.py --days 30 --account boba [--verbose]
"""
import os, sys, json, argparse, glob
from pathlib import Path
from datetime import datetime, timezone, timedelta
from zoneinfo import ZoneInfo
import requests

SECRETS = Path("/home/ubuntu/.openclaw/secrets")
ARCHIVE_DIRS = ["/home/ubuntu/.openclaw/_archive/flow-archives", "/home/ubuntu/Option-Signals-Scraper/data"]
LIVE_FLOW = "/home/ubuntu/mission-control-restored/Option-Signals-Scraper/data/flow_alerts_today.json"
ET = ZoneInfo("America/New_York")
MIN_FLOW = 500_000
TP = 0.50; SL = 0.25; HOLD_DAYS = 5

def _read(p):
    try: return Path(p).read_text().strip()
    except: return ""

def alpaca_bars(sym, start_dt, end_dt):
    key = _read(SECRETS / "alpaca-boba-key-id"); sec = _read(SECRETS / "alpaca-boba-secret")
    r = requests.get(
        f"https://data.alpaca.markets/v2/stocks/{sym}/bars",
        headers={"APCA-API-KEY-ID": key, "APCA-API-SECRET-KEY": sec},
        params={"timeframe":"1Hour","start":start_dt.isoformat(),"end":end_dt.isoformat(),"limit":200,"feed":"iex"},
        timeout=15)
    return r.json().get("bars", [])

def simulate(pick):
    sym = pick["ticker"]
    try: entry = datetime.fromisoformat(pick["entry_date"].replace("Z",""))
    except: return {"outcome":"bad_date","pnl_pct":0}
    if entry.tzinfo is None: entry = entry.replace(tzinfo=timezone.utc)
    end = entry + timedelta(days=HOLD_DAYS)
    try:
        bars = alpaca_bars(sym, entry, end)
        if not bars: return {"outcome":"no_data","pnl_pct":0}
        entry_px = bars[0]["c"]
        sign = 1 if pick["option_type"] == "CALL" else -1
        for b in bars[1:]:
            move = (b["c"] - entry_px) / entry_px
            opt_pl = move * 5 * sign  # 5x leverage approx for ATM short-DTE
            if opt_pl >= TP: return {"outcome":"tp","pnl_pct":TP*100}
            if opt_pl <= -SL: return {"outcome":"sl","pnl_pct":-SL*100}
        last = (bars[-1]["c"] - entry_px) / entry_px * 5 * sign
        return {"outcome":"time","pnl_pct":max(min(last, TP), -SL)*100}
    except Exception as e:
        return {"outcome":f"err:{type(e).__name__}","pnl_pct":0}

def replay(account, days, verbose=False):
    archives = []
    for d in ARCHIVE_DIRS:
        archives.extend(sorted(glob.glob(str(Path(d) / "flow_alerts_*.json"))))
    if not archives and Path(LIVE_FLOW).exists(): archives = [LIVE_FLOW]
    if not archives: return {"trades":0,"win_rate":0,"avg_pnl":0,"total_pnl":0}
    cutoff = datetime.now(ET) - timedelta(days=days)
    sims = []
    seen_keys = set()
    for arc in archives[-days*5:]:
        try:
            data = json.loads(Path(arc).read_text())
            entries = data if isinstance(data,list) else data.get("alerts",[])
            for e in entries:
                value = float(e.get("Value",0) or 0) or (float(e.get("Price",0) or 0)*float(e.get("Volume",0) or 0)*100)
                if value < MIN_FLOW: continue
                t_epoch = int(e.get("Time",0))/1000
                if t_epoch == 0: continue
                edate = datetime.fromtimestamp(t_epoch, tz=timezone.utc)
                if edate < cutoff.astimezone(timezone.utc): continue
                pick = {"ticker":(e.get("Symbol") or "").upper(),"strike":float(e.get("Strike",0) or 0),
                        "option_type":(e.get("OptionType") or "CALL").upper(),"entry_date":edate.isoformat(),"flow_value":value}
                k = (pick["ticker"], pick["strike"], pick["option_type"], edate.strftime("%Y-%m-%dT%H"))
                if k in seen_keys: continue
                seen_keys.add(k)
                out = simulate(pick); sims.append({**pick, **out})
                if verbose: print(f"  {pick['ticker']:>6} {pick['option_type']:<4} ${pick['strike']:>6.0f} val=${value/1e6:>5.1f}M @ {edate.strftime('%m-%d %H:%M')} -> {out['outcome']:<8} {out['pnl_pct']:+.1f}%")
                if len(sims) >= 60: break
        except Exception as ex: pass
        if len(sims) >= 60: break
    if not sims: return {"account":account,"trades":0}
    wins = [s for s in sims if s["pnl_pct"] > 0]
    return {"account":account,"trades":len(sims),"wins":len(wins),
            "win_rate":len(wins)/len(sims)*100,
            "avg_pnl":sum(s["pnl_pct"] for s in sims)/len(sims),
            "total_pnl":sum(s["pnl_pct"] for s in sims),
            "tp_hits":sum(1 for s in sims if s["outcome"]=="tp"),
            "sl_hits":sum(1 for s in sims if s["outcome"]=="sl"),
            "time_exits":sum(1 for s in sims if s["outcome"]=="time"),
            "no_data":sum(1 for s in sims if s["outcome"]=="no_data")}

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--days",type=int,default=7)
    ap.add_argument("--account",default="boba")
    ap.add_argument("--verbose",action="store_true")
    args = ap.parse_args()
    r = replay(args.account, args.days, args.verbose)
    print()
    print("="*55)
    print(f"BACKTEST: {args.account} | last {args.days} days | floor=${MIN_FLOW/1e3:.0f}K | TP=+{TP*100:.0f}% SL=-{SL*100:.0f}%")
    print("="*55)
    for k,v in r.items():
        if isinstance(v,float): print(f"  {k:<14} {v:.2f}")
        else: print(f"  {k:<14} {v}")

if __name__ == "__main__":
    main()
