#!/usr/bin/env python3
"""Refresh the living Portfolio Review letter (RH cleanup tracker) with live RH data.
Durable copy — scratchpad wipes on session resume kept destroying the tmp copy.
Usage: python3 ~/scripts/rh_letter_update.py [letter_path]"""
import json, urllib.request, datetime, shutil, sys, os
from zoneinfo import ZoneInfo

SP = "/tmp/claude-1000/-home-itsju/91c5e358-c540-496c-8641-94e8691f3bb6/scratchpad"
LETTER = sys.argv[1] if len(sys.argv) > 1 else f"{SP}/Portfolio-Review-2026-07-23.html"
ONEDRIVE = "/mnt/c/Users/itsju/OneDrive/Desktop/From Claude To Mike/Portfolio-Review-2026-07-23.html"
STATE = f"{SP}/letter_state.json"

EXIT_TODAY = ["ORCL","QBTS","MSTY","MSTR","NFLX","BTC","META","TSM","AMC","NIO","TNXP","XXRP","XRPT","BBAI","TRMD","KITT","BBIG"]
TIMED = {"SNDL":"exit after 7/28 earnings","LIDR":"exit after 7/30"}

d = json.load(urllib.request.urlopen("http://127.0.0.1:3000/api/portfolio-rh", timeout=25))
pos = d.get("positions") or []
if not pos:
    print("FEED EMPTY — no update"); sys.exit(0)
syms = {p["symbol"]: p for p in pos}
sold = [s for s in EXIT_TODAY if s not in syms]
now = datetime.datetime.now(ZoneInfo("America/New_York")).strftime("%-I:%M %p ET")

def row(s):
    if s not in syms:
        return f'<tr><td style="text-decoration:line-through;color:#9aa0aa">{s}</td><td class="num" style="color:#9aa0aa">—</td><td style="color:var(--green);font-weight:700">SOLD ✓</td></tr>'
    p = syms[s]
    return f'<tr><td>{s}</td><td class="num">${p["marketValue"]:.2f}</td><td style="color:var(--red)">open — tap to sell</td></tr>'

timed_rows = ""
for t, note in TIMED.items():
    if t in syms:
        timed_rows += f'\n    <tr><td>{t}</td><td class="num">${syms[t]["marketValue"]:.2f}</td><td style="color:#6d28d9">timed — {note}</td></tr>'

sold_note = f"{len(sold)}/{len(EXIT_TODAY)} sold"
block = f'''<!-- PROGRESS -->
  <h2>Live Consolidation Tracker</h2>
  <p class="src">Auto-updated by the 5-minute verification loop. Last refresh: {now} · book {len(pos)} positions · equity ${d.get("equity",0):,.0f} · today's exits: {sold_note}.</p>
  <table>
    <tr><th>Position</th><th class="num">Value</th><th>Status</th></tr>
    {chr(10).join("    "+row(s) for s in EXIT_TODAY)}{timed_rows}
  </table>
<!-- /PROGRESS -->'''

html = open(LETTER).read()
if "<!-- PROGRESS -->" in html:
    pre = html.split("<!-- PROGRESS -->")[0]
    post = html.split("<!-- /PROGRESS -->")[1]
    html = pre + block + post
else:
    anchor = '<!-- 2. ACCOUNT SUMMARY TABLE -->'
    html = html.replace(anchor, block + "\n\n  " + anchor)
open(LETTER, "w").write(html)
shutil.copy(LETTER, ONEDRIVE)

prev = {}
if os.path.exists(STATE):
    try: prev = json.load(open(STATE))
    except Exception: prev = {}
cur = {"sold": sold}
json.dump(cur, open(STATE, "w"))
newly = [s for s in sold if s not in prev.get("sold", [])]
print(f"UPDATED letter {now} | {sold_note}" + (f" | NEW FILLS: {newly}" if newly else " | no new fills"))
