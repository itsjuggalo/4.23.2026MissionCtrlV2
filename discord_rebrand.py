#!/home/itsju/.venv/bin/python
"""discord_rebrand.py — full Discord bot rebrand: function NAME + StarCraft 1 avatar +
Brood War "About Me". Mirrors bot_rebrand.py (Telegram). Authorized by Mike 2026-06-15.

Bot identity via the bot token:
  - name + avatar : PATCH /users/@me  {"username","avatar":"data:image/png;base64,..."}
  - about         : PATCH /applications/@me  {"description": "..."}  (best-effort)
Username/avatar edits are rate-limited — we honor 429 retry_after.

  discord_rebrand.py --smoke <token_file>   # one bot
  discord_rebrand.py                         # whole fleet
"""
import base64
import json
import os
import sys
import time

import requests

SEC = os.path.expanduser("~/.openclaw/secrets")
AV = os.path.expanduser("~/.openclaw/bot_avatars")
API = "https://discord.com/api/v10"

# token-file → (function name, StarCraft avatar stem, Brood War about-line)
IDENTITY = {
    "discord_bot_token":          ("Boba Decisions",   "fenix",      "The Boba decision engine. For Aiur."),
    "discord_boba_token":         ("Boba Trader",      "goliath",    "Boba upgraded — heavy trade execution."),
    "discord_boba_qa_token":      ("Boba QA",          "marine_sc1", "Frontline checks on every pick."),
    "discord_boba_today_token":   ("Boba Today",       "firebat",    "The daily heat: today's flow & picks."),
    "discord_jazzyhazzy_token":   ("Jazzy Trader",     "kerrigan",   "The Queen's second account. We hunt the flow."),
    "discord_orion_token":        ("Orion Research",   "tassadar",   "Deep research desk. I have seen the future."),
    "discord_deepseek_token":     ("Deep Research",    "zealot",     "DeepSeek-model research & analysis."),  # "DeepSeek" name blocked by Discord (err 50277)
    "discord_kronos_token":       ("Kronos Forecast",  "zeratul",    "The forecasting seer. Time bends."),
    "discord_synthcontrol_token": ("Synth Control",    "dragoon",    "Synthetic-control attribution engine."),
    "discord_askgrok_token":      ("Grok Intel",       "zergling",   "Fast X/Grok intel swarm."),
    "discord_status_bot_token":   ("System Status",    "adjutant",   "The Adjutant. System online, commander."),
    "discord_ops_bot_token":      ("Reminders",        "scv",        "Ops worker. Job's finished."),
    "discord_todo_bot_token":     ("To-Do",            "mutalisk",   "Task swarm — never forgets."),
    "discord_tgbridge_token":     ("TG Bridge",        "wraith",     "Telegram<->Discord relay. Cloaked and routing."),
    "discord_verify_token":       ("Verify",           "aldaris",    "The Judicator. Access judged."),
    "lifeclaw_discord_bot_token": ("LifeClaw",         "arbiter",    "Your life compass. My life for Aiur."),
    # NOTE: these 3 LOOK like dead telegram tokens (getMe→404) but are LIVE DISCORD bots:
    "betabot-token":              ("Beta Bot",         "firebat",    "Experimental sandbox bot. Burn it down, rebuild."),
    "spacer_bot_token.txt":       ("Spacer",           "scv",        "Channel spacer / daily utility. Keeping the lines clean."),
    "watchlist_editor_bot_token.txt": ("Watchlist Editor","goliath",  "Edits your watchlists. The Conclave records all."),
}


def _tok(f):
    return open(os.path.join(SEC, f)).read().strip()


def _data_uri(stem):
    with open(f"{AV}/{stem}.png", "rb") as fh:
        return "data:image/png;base64," + base64.b64encode(fh.read()).decode()


def _patch(url, tok, body):
    for _ in range(5):
        r = requests.patch(url, headers={"Authorization": f"Bot {tok}",
                                         "Content-Type": "application/json"},
                           data=json.dumps(body), timeout=20)
        if r.status_code == 429:
            time.sleep(float(r.json().get("retry_after", 2)) + 0.5)
            continue
        return r.status_code, (r.json() if r.text else {})
    return 429, {}


def rebrand(tokfile, name, stem, about):
    tok = _tok(tokfile)
    res = {}
    sc, body = _patch(f"{API}/users/@me", tok, {"username": name, "avatar": _data_uri(stem)})
    res["id"] = (sc == 200)
    if sc != 200:
        res["err"] = str(body)[:120]
    time.sleep(1.0)
    sc2, _ = _patch(f"{API}/applications/@me", tok, {"description": about})
    res["about"] = (sc2 == 200)
    return res


if __name__ == "__main__":
    args = sys.argv[1:]
    if args and args[0] == "--smoke":
        tf = args[1]
        nm, stem, about = IDENTITY[tf]
        print(tf, "→", rebrand(tf, nm, stem, about))
        sys.exit()
    for tf, (nm, stem, about) in IDENTITY.items():
        try:
            r = rebrand(tf, nm, stem, about)
            print(f"{'✓' if r.get('id') else '✗'} {nm:18} ({tf}) {r}")
        except Exception as e:
            print(f"✗ {nm}: {e}")
        time.sleep(2)
