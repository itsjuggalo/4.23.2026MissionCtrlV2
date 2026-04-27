"""Daily Kronos Summary — posts end-of-day scorecard to Discord."""
import csv, json, sys
from datetime import datetime, timezone
from pathlib import Path
import urllib.request

CSV_FILE = Path("/home/ubuntu/mission-control/kronos-tracker/kronos_predictions.csv")
SECRETS = Path("/home/ubuntu/.openclaw/secrets")


def get_webhook():
    for n in ["discord-webhook-kronos.txt","discord_kronos_webhook"]:
        p = SECRETS / n
        if p.exists():
            v = p.read_text().strip()
            if v.startswith("http"): return v
    return ""


def post(embed):
    w = get_webhook()
    if not w: return False
    try:
        data = json.dumps({"username":"Kronos Tracker","embeds":[embed]}).encode()
        req = urllib.request.Request(w, data=data,
            headers={"Content-Type":"application/json","User-Agent":"MissionControl-KronosTracker/1.0"}, method="POST")
        urllib.request.urlopen(req, timeout=10)
        return True
    except Exception as e:
        print(f"Post failed: {e}"); return False


def main():
    if not CSV_FILE.exists(): print("No tracker CSV"); return
    with open(CSV_FILE) as f:
        rows = list(csv.DictReader(f))
    if not rows: print("No predictions yet"); return
    today = datetime.now(timezone.utc).strftime("%Y-%m-%d")
    today_ev = [r for r in rows if r.get("evaluation_status")=="done"
                and r.get("evaluated_at","").startswith(today)]
    all_ev = [r for r in rows if r.get("evaluation_status")=="done"]
    lines = []
    if today_ev:
        lines.append(f"**Today's {len(today_ev)} forecasts evaluated:**")
        for r in today_ev:
            ok = "✅" if str(r.get("direction_correct")).lower()=="true" else "❌"
            lines.append(f"{ok} **{r['ticker']}** pred:{r['forecast_24h_direction']}({r.get('forecast_24h_confidence','?')}) actual:{r.get('actual_direction','?')}({r.get('actual_change_pct','?')}%) err:{r.get('target_error_pct','?')}%")
        tc = [r for r in today_ev if str(r.get("direction_correct")).lower()=="true"]
        lines.append(f"\n**Today:** {len(tc)}/{len(today_ev)} = {len(tc)/len(today_ev)*100:.0f}%")
    else:
        lines.append("**No forecasts were evaluated today** (waiting for 24h maturity).")
        pending = [r for r in rows if r.get("evaluation_status")=="pending"]
        if pending:
            lines.append(f"\n{len(pending)} forecast(s) pending — will evaluate when 24h old.")
    if all_ev:
        ac = [r for r in all_ev if str(r.get("direction_correct")).lower()=="true"]
        lines.append(f"\n**All-time:** {len(ac)}/{len(all_ev)} = {len(ac)/len(all_ev)*100:.1f}%")
        lines.append("\n**By confidence:**")
        for c in ("high","medium","low"):
            s = [r for r in all_ev if r.get("forecast_24h_confidence")==c]
            if s:
                cc = [r for r in s if str(r.get("direction_correct")).lower()=="true"]
                lines.append(f"  {c}: {len(cc)}/{len(s)} = {len(cc)/len(s)*100:.0f}%")
    all_acc = (len([r for r in all_ev if str(r.get("direction_correct")).lower()=="true"])/len(all_ev)*100) if all_ev else 0
    color = 0x00FF00 if all_acc>=60 else 0xFFA502 if all_acc>=50 else 0xFF4757
    embed = {
        "title": f"📊 Kronos Daily Scorecard — {datetime.now().strftime('%b %d')}",
        "description": "\n".join(lines), "color": color,
        "footer": {"text": f"Kronos tracker • {datetime.now().strftime('%H:%M')}"},
    }
    if post(embed): print("Posted daily scorecard")


if __name__ == "__main__": main()
