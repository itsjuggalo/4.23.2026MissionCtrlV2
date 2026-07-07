"""ledger.py — the decision ledger: every coach verdict recorded, actionable ones
get FOLLOW/OVERRIDE buttons, overrides demand a typed WHY, outcomes get scored.

Mike's discipline mode (2026-07-07): "explain your reasoning in detail and quantum
every decision made and the outcome." This module is the recording half; scoring
lives in score_decisions.py, weekly quantum validation in labs/quantum/decision_qae.py.

Buttons ride @PipelineSignals_Bot (callback_data dec:<id>:follow|override) because
telegram_dm_responder.py is that token's single getUpdates consumer.
"""
from __future__ import annotations

import json
import sqlite3
import urllib.parse
import urllib.request
from pathlib import Path

DB = Path.home() / "portfolio" / "mike.sqlite"
SEC = Path.home() / ".openclaw" / "secrets"

ACTION_VERDICTS = ("TRIM", "EXIT", "EXIT_ON_BOUNCE", "ADD")


def connect() -> sqlite3.Connection:
    return sqlite3.connect(str(DB), timeout=30)


def insert_decisions(results: list[dict], as_of: str, source: str = "coach_sweep") -> dict:
    """Record every TA-mode verdict; return {key: decision_id} for actionables."""
    con = connect()
    ids = {}
    for r in results:
        if r.get("mode") != "ta":
            continue
        cur = con.execute(
            "INSERT INTO decision_ledger(ts, source, symbol, broker, bucket, verdict,"
            " confidence, reasoning, profile_factors, ta_snapshot, price_at, qty_at)"
            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
            (as_of, source, r["symbol"], r.get("broker"), r.get("bucket"), r["verdict"],
             r.get("confidence"),
             "\n".join(r.get("reasons") or []),
             json.dumps(_profile_factors(r)),
             json.dumps({"trend": r.get("trend"), "rsi": r.get("rsi"),
                         "signal_type": r.get("signal_type"), "stop": r.get("stop"),
                         "trail": r.get("trail_stop"), "target": r.get("target")}),
             r.get("current"), r.get("qty")))
        if r["verdict"] in ACTION_VERDICTS:
            ids[r["key"]] = cur.lastrowid
    con.commit()
    con.close()
    return ids


def _profile_factors(r: dict) -> list[str]:
    """Which of Mike's named biases this verdict guards (cited on cards per his ask)."""
    f = []
    v, pnl = r.get("verdict"), r.get("pnl_pct")
    if r.get("bucket") == "core" and v == "HOLD":
        f.append("sells-winners-early (core protected from panic sells)")
    if v == "TRIM" and pnl is not None and pnl > 0:
        f.append("sells-winners-early (structured trim ≠ panic sell: half rides on)")
    if v in ("EXIT_ON_BOUNCE", "EXIT") or (v == "TRIM" and pnl is not None and pnl < 0):
        f.append("holds-losers (cut/reduce before −50% dead-bag zone)")
    if v == "ADD":
        f.append("fomo-chasing (planned pullback add, not a chase)")
    if r.get("conc_pct", 0) > 20:
        f.append("oversizing (concentration watch)")
    return f


def _tg_api(method: str, **params):
    token = (SEC / "telegram-bot-token.txt").read_text().strip()
    data = urllib.parse.urlencode(params).encode()
    req = urllib.request.Request(f"https://api.telegram.org/bot{token}/{method}", data=data)
    with urllib.request.urlopen(req, timeout=20) as r:
        return json.loads(r.read())


def send_decision_buttons(r: dict, decision_id: int) -> bool:
    """One actionable verdict → tappable FOLLOW / OVERRIDE message."""
    try:
        chat = (SEC / "telegram-chat-id.txt").read_text().strip()
        icon = {"TRIM": "✂️", "EXIT": "🛑", "EXIT_ON_BOUNCE": "🏃", "ADD": "➕"}.get(
            r["verdict"], "·")
        pnl = r.get("pnl_pct")
        head = (f"{icon} #{decision_id} {r['symbol']} [{r['bucket']}] → "
                f"{r['verdict'].replace('_', ' ')}"
                + (f" ({pnl:+.0f}%)" if pnl is not None else ""))
        why = "\n".join("• " + x for x in (r.get("reasons") or [])[:3])
        guards = json.loads(json.dumps(_profile_factors(r)))
        guard_txt = ("\n🛡 guards: " + "; ".join(guards)) if guards else ""
        kb = {"inline_keyboard": [[
            {"text": "✅ FOLLOW", "callback_data": f"dec:{decision_id}:follow"},
            {"text": "✋ OVERRIDE", "callback_data": f"dec:{decision_id}:override"}]]}
        _tg_api("sendMessage", chat_id=chat, text=(head + "\n" + why + guard_txt)[:4000],
                reply_markup=json.dumps(kb))
        return True
    except Exception as e:
        print(f"decision buttons failed: {e}")
        return False
