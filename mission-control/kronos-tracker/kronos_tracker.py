"""Kronos Accuracy Tracker — records forecasts, evaluates 24h later."""
import argparse, csv, json, os, sys
from datetime import datetime, timezone, timedelta
from pathlib import Path

FORECAST_DIR = Path("/home/ubuntu/.openclaw/workspace/directives/kronos_forecasts")
TRACKER_DIR = Path("/home/ubuntu/mission-control/kronos-tracker")
TRACKER_DIR.mkdir(parents=True, exist_ok=True)
CSV_FILE = TRACKER_DIR / "kronos_predictions.csv"
SEEN_FILE = TRACKER_DIR / "seen_forecast_ids.json"
SECRETS = Path("/home/ubuntu/.openclaw/secrets")

FIELDS = ["forecast_id","ticker","generated_at","timeframe","current_price",
    "forecast_24h_direction","forecast_24h_target","forecast_24h_change_pct",
    "forecast_24h_confidence","forecast_24h_high","forecast_24h_low",
    "option_context","option_in_forecast_direction",
    "evaluated_at","actual_price_24h","actual_change_pct","actual_direction",
    "direction_correct","target_error_pct","evaluation_status"]


def read_csv():
    if not CSV_FILE.exists(): return []
    with open(CSV_FILE) as f:
        return list(csv.DictReader(f))


def write_csv(rows):
    with open(CSV_FILE, "w", newline="") as f:
        w = csv.DictWriter(f, fieldnames=FIELDS)
        w.writeheader()
        for r in rows:
            w.writerow({k: r.get(k, "") for k in FIELDS})


def load_seen():
    if SEEN_FILE.exists():
        try: return set(json.loads(SEEN_FILE.read_text()))
        except: return set()
    return set()


def save_seen(s): SEEN_FILE.write_text(json.dumps(list(s)))


def scan_and_record():
    seen = load_seen()
    rows = read_csv()
    added = 0
    for f in sorted(FORECAST_DIR.glob("*.json")):
        if f.name.startswith("latest_"): continue
        fid = f.stem
        if fid in seen: continue
        try: d = json.loads(f.read_text())
        except: continue
        if "error" in d or not d.get("current_price"):
            seen.add(fid); continue
        rows.append({
            "forecast_id": fid, "ticker": d.get("ticker",""),
            "generated_at": d.get("generated_at",""), "timeframe": d.get("timeframe",""),
            "current_price": d.get("current_price",""),
            "forecast_24h_direction": d.get("forecast_24h_direction",""),
            "forecast_24h_target": d.get("forecast_24h_target",""),
            "forecast_24h_change_pct": d.get("forecast_24h_change_pct",""),
            "forecast_24h_confidence": d.get("forecast_24h_confidence",""),
            "forecast_24h_high": d.get("forecast_24h_high",""),
            "forecast_24h_low": d.get("forecast_24h_low",""),
            "option_context": d.get("option_context",""),
            "option_in_forecast_direction": d.get("option_in_forecast_direction",""),
            "evaluated_at": "", "actual_price_24h": "", "actual_change_pct": "",
            "actual_direction": "", "direction_correct": "", "target_error_pct": "",
            "evaluation_status": "pending",
        })
        seen.add(fid); added += 1
    if added:
        write_csv(rows); save_seen(seen)
        print(f"[record] Added {added} new forecast(s)")
    else:
        print("[record] No new forecasts")


def fetch_current_price(ticker):
    import requests
    tu = ticker.upper()
    if tu in ("BTC","BTCUSD","BTCUSDT","XBTUSD"):
        try:
            r = requests.get("https://api.kraken.com/0/public/Ticker",
                params={"pair":"XBTUSD"}, timeout=10)
            d = r.json()
            if d.get("error"): return None
            pair = list(d["result"].keys())[0]
            return float(d["result"][pair]["c"][0])
        except: return None
    try:
        key = (SECRETS/"alpaca-key-id").read_text().strip()
        sec = (SECRETS/"alpaca-secret").read_text().strip()
        r = requests.get(
            f"https://data.alpaca.markets/v2/stocks/{tu}/trades/latest",
            headers={"APCA-API-KEY-ID":key,"APCA-API-SECRET-KEY":sec},
            params={"feed":"iex"}, timeout=10)
        if r.status_code == 200:
            return float(r.json().get("trade",{}).get("p",0)) or None
    except: pass
    return None


def evaluate():
    rows = read_csv()
    updated = 0
    for row in rows:
        if row.get("evaluation_status") in ("done","error"): continue
        try:
            gen = datetime.fromisoformat(row["generated_at"].replace("Z","+00:00"))
        except: continue
        if (datetime.now(timezone.utc) - gen) < timedelta(hours=24): continue
        actual = fetch_current_price(row["ticker"])
        if actual is None:
            row["evaluation_status"] = "price_fetch_failed"; continue
        try:
            current = float(row["current_price"])
            chg = (actual - current) / current * 100
            act_dir = "bullish" if chg > 0.3 else "bearish" if chg < -0.3 else "neutral"
            target = float(row["forecast_24h_target"])
            tgt_err = abs((target - actual) / actual * 100)
            row["evaluated_at"] = datetime.now(timezone.utc).isoformat()
            row["actual_price_24h"] = actual
            row["actual_change_pct"] = round(chg, 2)
            row["actual_direction"] = act_dir
            row["direction_correct"] = (row["forecast_24h_direction"] == act_dir)
            row["target_error_pct"] = round(tgt_err, 2)
            row["evaluation_status"] = "done"
            updated += 1
        except Exception as e:
            row["evaluation_status"] = f"error: {e}"
    if updated:
        write_csv(rows)
        print(f"[evaluate] Updated {updated} forecast(s)")
    else:
        print("[evaluate] No forecasts ready")


def report():
    rows = read_csv()
    if not rows: print("No predictions yet"); return
    ev = [r for r in rows if r.get("evaluation_status")=="done"]
    pn = [r for r in rows if r.get("evaluation_status")=="pending"]
    print(f"Total: {len(rows)}  Evaluated: {len(ev)}  Pending: {len(pn)}")
    if not ev: print("No 24h+ forecasts yet."); return
    ok = [r for r in ev if str(r.get("direction_correct")).lower()=="true"]
    print(f"Directional accuracy: {len(ok)}/{len(ev)} = {len(ok)/len(ev)*100:.1f}%")
    errs = [float(r["target_error_pct"]) for r in ev if r.get("target_error_pct")]
    if errs: print(f"Avg target error: {sum(errs)/len(errs):.2f}%")
    for conf in ("high","medium","low"):
        s = [r for r in ev if r.get("forecast_24h_confidence")==conf]
        if s:
            c = [r for r in s if str(r.get("direction_correct")).lower()=="true"]
            print(f"  {conf}: {len(c)}/{len(s)} = {len(c)/len(s)*100:.1f}%")


if __name__ == "__main__":
    p = argparse.ArgumentParser()
    p.add_argument("mode", choices=["record","evaluate","report"])
    a = p.parse_args()
    {"record":scan_and_record,"evaluate":evaluate,"report":report}[a.mode]()
