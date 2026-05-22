"""Peer-agent pick awareness — read what the OTHER agent picked today.

When called from Boba, returns Jazzy's recent picks. When called from Jazzy,
returns Boba's recent picks. The block injected into the prompt enforces
independent-thesis policy: pick a DIFFERENT contract by default; converge only
with explicit reasoning.

Public API:
    peer_picks_block(agent: str, window_hours: int = 6) -> str
"""
from __future__ import annotations
import json
from datetime import datetime, timezone, timedelta
from pathlib import Path

DECISIONS = {
    "boba": Path("/home/ubuntu/.openclaw/workspace/skill_outputs/boba_decisions_validated.json"),
    "jazzy": Path("/home/ubuntu/.openclaw/workspace/skill_outputs/jazzy_decisions_validated.json"),
}


def _occ_key(pick: dict) -> str:
    """A stable identifier for a contract: TICKER + STRIKE + TYPE + EXPIRY."""
    t = pick.get("ticker", "?")
    s = pick.get("strike", "?")
    o = (pick.get("option_type") or "")[:1]
    e = pick.get("expiry", "?")
    return f"{t}-{s}{o}-{e}"


def peer_picks_block(agent: str, window_hours: int = 6) -> str:
    peer = "jazzy" if agent == "boba" else "boba"
    path = DECISIONS.get(peer)
    if not path or not path.exists():
        return ""

    try:
        data = json.loads(path.read_text())
        decisions = data if isinstance(data, list) else data.get("decisions", [])
    except Exception:
        return ""

    cutoff = datetime.now(timezone.utc) - timedelta(hours=window_hours)

    recent_picks: list[dict] = []
    seen_occ: set[str] = set()
    for dec in decisions[-30:]:
        ts_str = dec.get("cycle_time") or dec.get("timestamp", "")
        if not ts_str:
            continue
        try:
            dts = datetime.fromisoformat(str(ts_str).replace("Z", "+00:00"))
        except Exception:
            continue
        if dts.tzinfo is None:
            dts = dts.replace(tzinfo=timezone.utc)
        if dts < cutoff:
            continue
        for pick in dec.get("picks_executed", []) or []:
            if not isinstance(pick, dict) or not pick.get("ticker"):
                continue
            occ = _occ_key(pick)
            if occ in seen_occ:
                continue
            seen_occ.add(occ)
            reasoning = (pick.get("reasoning") or "").replace("\n", " ")
            # Extract just the THESIS sentence if structured
            if "THESIS:" in reasoning:
                thesis = reasoning.split("THESIS:", 1)[1].split("CONTRACT:")[0].strip()[:140]
            else:
                thesis = reasoning[:140]
            recent_picks.append({
                "ticker": pick.get("ticker", "?"),
                "strike": pick.get("strike"),
                "option_type": pick.get("option_type", ""),
                "expiry": pick.get("expiry", ""),
                "contracts": pick.get("contracts", 1),
                "time": str(ts_str)[:19],
                "thesis": thesis,
                "kronos": pick.get("kronos_verdict", "?"),
            })

    if not recent_picks:
        return ""

    out = [f"\n# === PEER AGENT ({peer.upper()}) PICKS — last {window_hours}h — INDEPENDENT THESIS REQUIRED ==="]
    out.append(
        f"{peer.title()} has already taken the contracts listed below. "
        f"DEFAULT POLICY: pick DIFFERENT contracts so we get diversification + independent learning."
    )
    out.append(
        "Convergence on the same contract is permitted ONLY when:"
    )
    out.append("  1. You can articulate a DISTINCT edge or higher-conviction reason your independent analysis reached the same conclusion, AND")
    out.append("  2. Concentration risk is acceptable (we don't want both accounts down -X% on the same trade).")
    out.append("")
    out.append("If you converge on a peer pick, populate `convergence_rationale` on your pick explaining the distinct edge.")
    out.append("")
    for p in recent_picks[-8:]:
        if p.get("strike") and p.get("option_type"):
            contract = f"${p['strike']:.1f}{p['option_type'][:1].upper()}"
        else:
            contract = "stock"
        out.append(
            f"  - {p['time']} {peer}: {p['ticker']} {contract} {p['expiry']} × {p['contracts']}  "
            f"(Kronos: {p['kronos']})"
        )
        if p['thesis']:
            out.append(f"      thesis: {p['thesis']}")
    out.append("")
    return "\n".join(out)
