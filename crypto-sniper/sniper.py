#!/usr/bin/env python3
"""
Crypto Sniper — detect new token launches, run safety analysis, alert within seconds.
ALERT-ONLY. Never auto-buys. Commander decides all entries.

Poll schedule:
  DEXScreener token-profiles : every 15 s
  GeckoTerminal new pools    : every 30 s (staggered with DS)
  Honeypot check             : on-demand per EVM token
  Price-tracking             : hourly for 24 h after detection
"""
import asyncio
import json
import logging
import os
import sys
import time
import uuid
from datetime import datetime, timezone, timedelta

import sys as _sys
_sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import aiohttp
import requests
from dotenv import load_dotenv
from shared.archiver import maybe_rotate

# ── Config ────────────────────────────────────────────────────────────────────

load_dotenv(os.path.join(os.path.dirname(os.path.abspath(__file__)), ".env"))

_DIR          = os.path.dirname(os.path.abspath(__file__))
LAUNCHES_FILE = os.path.join(_DIR, "launches.json")
BLACKLIST_FILE= os.path.join(_DIR, "blacklist.json")
WATCHLIST_FILE= os.path.join(_DIR, "watchlist.json")

LAUNCHES_URL  = os.getenv("DISCORD_SNIPER_LAUNCHES_WEBHOOK",  "")
ANALYSIS_URL  = os.getenv("DISCORD_SNIPER_ANALYSIS_WEBHOOK",  "")
BLACKLIST_URL = os.getenv("DISCORD_SNIPER_BLACKLIST_WEBHOOK",  "")
ARCHIVE_URL   = os.getenv("DISCORD_ARCHIVE_SNIPER_WEBHOOK",   "")
LAUNCHES_MAX  = 500

DS_INTERVAL   = 15   # DEXScreener poll seconds
GT_INTERVAL   = 30   # GeckoTerminal poll seconds
TRACK_HOURS   = 24   # track price this many hours post-launch
MAX_LAUNCHES  = 500
MAX_AGE_MIN   = 30   # ignore tokens launched > 30 min ago
MIN_LIQ_USD   = 1_000_000  # minimum liquidity threshold
MIN_MCAP_USD  = 1_000_000  # minimum market cap threshold
MIN_SCORE_ALERT = 10  # only alert on HIGH OPPORTUNITY (score 10+)

CHAINS_DS     = {"solana", "ethereum", "base", "bsc"}
CHAINS_GT     = {"eth": "Ethereum", "solana": "Solana",
                 "base": "Base",    "bsc": "BSC"}

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [SNIPER] %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
    stream=sys.stdout,
)
log = logging.getLogger("sniper")


# ── File I/O ──────────────────────────────────────────────────────────────────

def load_json(path: str, default):
    if os.path.exists(path):
        try:
            with open(path) as f:
                return json.load(f)
        except Exception:
            pass
    return default


def save_json(path: str, data) -> None:
    with open(path, "w") as f:
        json.dump(data, f, indent=2, default=str)


def load_launches() -> list:
    return load_json(LAUNCHES_FILE, [])


def save_launches(launches: list) -> None:
    if len(launches) > MAX_LAUNCHES:
        launches = launches[-MAX_LAUNCHES:]
    save_json(LAUNCHES_FILE, launches)


def load_blacklist() -> dict:
    return load_json(BLACKLIST_FILE, {"deployers": [], "contracts": []})


def save_blacklist(bl: dict) -> None:
    save_json(BLACKLIST_FILE, bl)


def load_watchlist() -> dict:
    return load_json(WATCHLIST_FILE, {"smart_wallets": [], "upcoming_launches": []})


def is_seen(pair_address: str, launches: list) -> bool:
    return any(la.get("pair_address") == pair_address for la in launches)


def get_seen_ids(launches: list) -> set:
    return {la.get("pair_address") for la in launches if la.get("pair_address")}


# ── API fetchers ──────────────────────────────────────────────────────────────

def _get(url: str, headers: dict | None = None, params: dict | None = None,
         timeout: int = 10) -> dict | list | None:
    try:
        h = {"User-Agent": "MissionControl/1.0"}
        if headers:
            h.update(headers)
        r = requests.get(url, headers=h, params=params, timeout=timeout)
        if r.status_code == 429:
            log.warning(f"Rate limited: {url[:60]} — backing off 30s")
            time.sleep(30)
            return None
        r.raise_for_status()
        return r.json()
    except Exception as e:
        log.warning(f"GET {url[:60]} failed: {e}")
        return None


def fetch_dexscreener_profiles() -> list[dict]:
    """Latest token profiles from DEXScreener — fastest new-token feed."""
    data = _get("https://api.dexscreener.com/token-profiles/latest/v1")
    if not isinstance(data, list):
        return []
    return [p for p in data if p.get("chainId") in CHAINS_DS]


def fetch_dexscreener_pair(token_address: str, chain: str) -> dict | None:
    """Fetch pair data for a token — price, liquidity, market cap."""
    data = _get(f"https://api.dexscreener.com/latest/dex/tokens/{token_address}")
    if not data:
        return None
    pairs = data.get("pairs") or []
    # Prefer highest-liquidity pair on the right chain
    chain_pairs = [p for p in pairs if p.get("chainId") == chain]
    if not chain_pairs:
        chain_pairs = pairs
    if not chain_pairs:
        return None
    return max(chain_pairs, key=lambda p: float((p.get("liquidity") or {}).get("usd") or 0))


def fetch_geckoterminal_pools(network: str) -> list[dict]:
    """New pools from GeckoTerminal for a given network."""
    data = _get(
        f"https://api.geckoterminal.com/api/v2/networks/{network}/new_pools",
        headers={"Accept": "application/json"},
        params={"page": "1"},
    )
    if not data:
        return []
    return data.get("data", [])


def fetch_honeypot(address: str) -> dict | None:
    """Honeypot.is check for EVM tokens."""
    data = _get(f"https://api.honeypot.is/v2/IsHoneypot?address={address}")
    return data


# ── Analysis Pipeline ─────────────────────────────────────────────────────────

def score_liquidity(liq_usd: float) -> tuple[int, bool]:
    """Returns (score, is_fatal)."""
    if liq_usd >= 50_000:  return 2, False
    if liq_usd >= 10_000:  return 1, False
    if liq_usd >= 1_000:   return 0, False
    return -2, False


def check_socials(info: dict) -> tuple[int, dict]:
    """Parse social links from DEXScreener pair info."""
    websites = info.get("websites") or []
    socials  = info.get("socials")  or []

    has_web  = bool(websites)
    has_tw   = any(s.get("type") == "twitter"  for s in socials)
    has_tg   = any(s.get("type") == "telegram" for s in socials)

    count = sum([has_web, has_tw, has_tg])
    score = 2 if count >= 3 else (1 if count >= 1 else -1)
    return score, {"twitter": has_tw, "website": has_web, "telegram": has_tg}


def check_contract_evm(address: str) -> tuple[int, dict]:
    """Honeypot.is check — only for EVM tokens."""
    result = fetch_honeypot(address)
    if result is None:
        return -1, {"verified": None, "honeypot": None, "error": True}

    hp       = result.get("isHoneypot")
    sim_ok   = result.get("simulationSuccess", False)
    verified = result.get("token", {}).get("isOpenSource") if result.get("token") else None

    if hp is True:
        return -10, {"verified": verified, "honeypot": True, "fatal": True}
    if not sim_ok:
        return -1, {"verified": verified, "honeypot": None, "sim_failed": True}
    score = 3 if verified else 1
    return score, {"verified": verified, "honeypot": False}


def check_deployer(deployer: str | None, blacklist: dict) -> tuple[int, dict]:
    """Check deployer against blacklist."""
    if not deployer:
        return 0, {"address": None, "blacklisted": False, "previous_launches": 0}
    bl_deployers = {b["address"].lower() for b in blacklist.get("deployers", [])}
    if deployer.lower() in bl_deployers:
        return -10, {"address": deployer, "blacklisted": True, "fatal": True}
    return 1, {"address": deployer, "blacklisted": False, "previous_launches": 0}


def check_smart_money(token_address: str, watchlist: dict) -> tuple[int, dict]:
    """Check if any tracked smart wallet holds this token (placeholder)."""
    # In a production system this would query on-chain data.
    # For now we store it for future enrichment.
    return 0, {"detected": False, "wallets": []}


def minutes_since(ts_ms: int | None) -> float:
    """Return minutes since a Unix-ms timestamp."""
    if not ts_ms:
        return 9999
    return (time.time() - ts_ms / 1000) / 60


def get_verdict(score: int, fatal: bool) -> str:
    if fatal:                    return "BLACKLISTED"
    if score >= 10:              return "HIGH OPPORTUNITY"
    if score >= 5:               return "MODERATE"
    if score >= 0:               return "RISKY"
    return "DANGER"


def verdict_emoji(verdict: str) -> str:
    return {
        "HIGH OPPORTUNITY": "🟢",
        "MODERATE":         "🟡",
        "RISKY":            "⚠️",
        "DANGER":           "🔴",
        "BLACKLISTED":      "⛔",
    }.get(verdict, "⚪")


# ── Full analysis for a single token ─────────────────────────────────────────

async def analyze_token(profile: dict, pair: dict, blacklist: dict,
                         watchlist: dict) -> dict | None:
    """
    Run the full 7-check pipeline. Returns a launch record or None to skip.
    """
    chain         = profile.get("chainId", "")
    token_address = profile.get("tokenAddress", "")
    pair_address  = pair.get("pairAddress", "")

    # ── Basic info from pair ──────────────────────────────────────────────────
    base       = pair.get("baseToken", {})
    name       = base.get("name", "?")
    symbol     = base.get("symbol", "?")
    dex        = pair.get("dexId", "?")
    liq_usd    = float((pair.get("liquidity") or {}).get("usd") or 0)
    price_usd  = float(pair.get("priceUsd") or 0)
    mcap       = float(pair.get("marketCap") or pair.get("fdv") or 0)
    vol_24h    = float((pair.get("volume") or {}).get("h24") or 0)
    created_ms = pair.get("pairCreatedAt")
    age_min    = minutes_since(created_ms)
    info       = pair.get("info") or {}

    if liq_usd < MIN_LIQ_USD:
        log.debug(f"Skipping {symbol} — liquidity ${liq_usd:,.0f} below threshold ${MIN_LIQ_USD:,.0f}")
        return None

    if mcap < MIN_MCAP_USD:
        log.debug(f"Skipping {symbol} — market cap ${mcap:,.0f} below threshold ${MIN_MCAP_USD:,.0f}")
        return None

    is_evm = chain in ("ethereum", "base", "bsc")

    # ── Check 1: Liquidity ────────────────────────────────────────────────────
    liq_score, _ = score_liquidity(liq_usd)
    checks_liq   = {"value": round(liq_usd, 2), "locked": False, "score": liq_score}

    # ── Check 2: Socials ──────────────────────────────────────────────────────
    soc_score, soc_data = check_socials(info)

    # ── Check 3: Contract (EVM only) ──────────────────────────────────────────
    fatal = False
    if is_evm:
        con_score, con_data = check_contract_evm(token_address)
        if con_data.get("fatal"):
            fatal = True
    else:
        # Solana: no honeypot.is support — mark as unknown
        con_score, con_data = 0, {"verified": None, "honeypot": None, "note": "Solana — no EVM check"}

    # ── Check 4: Holders (placeholder — no free real-time API) ───────────────
    hld_score = 0
    hld_data  = {"top10_pct": None, "deployer_pct": None, "score": 0,
                 "note": "holder data requires paid API"}

    # ── Check 5: Deployer ────────────────────────────────────────────────────
    deployer  = (pair.get("info") or {}).get("deployer") or None
    dep_score, dep_data = check_deployer(deployer, blacklist)
    if dep_data.get("fatal"):
        fatal = True

    # ── Check 6: Smart money ─────────────────────────────────────────────────
    sm_score, sm_data = check_smart_money(token_address, watchlist)

    # ── Check 7: Liquidity lock (placeholder) ────────────────────────────────
    # Real lock check requires subgraph queries — skipped for now
    lock_score = 0

    total_score = (liq_score + con_score + hld_score + soc_score +
                   sm_score + dep_score + lock_score)
    verdict     = get_verdict(total_score, fatal)

    ds_url = (pair.get("url") or
              f"https://dexscreener.com/{chain}/{pair_address}")

    return {
        "id":                  str(uuid.uuid4()),
        "timestamp":           datetime.now(timezone.utc).isoformat(),
        "token_name":          name,
        "token_symbol":        symbol,
        "chain":               chain,
        "contract_address":    token_address,
        "dex":                 dex,
        "pair_address":        pair_address,
        "launch_time":         (datetime.fromtimestamp(created_ms / 1000, tz=timezone.utc).isoformat()
                                if created_ms else None),
        "minutes_since_launch": round(age_min, 1),
        "price_usd":           price_usd,
        "market_cap_usd":      mcap,
        "liquidity_usd":       round(liq_usd, 2),
        "volume_24h":          vol_24h,
        "checks": {
            "liquidity":       checks_liq,
            "contract":        {**con_data, "score": con_score},
            "holders":         hld_data,
            "socials":         {**soc_data, "score": soc_score},
            "smart_money":     {**sm_data, "score": sm_score},
            "deployer":        {**dep_data, "score": dep_score},
        },
        "total_score":         total_score,
        "verdict":             verdict,
        "dexscreener_url":     ds_url,
        "alert_sent":          False,
        "price_history":       [{"ts": datetime.now(timezone.utc).isoformat(),
                                 "price": price_usd, "liq": liq_usd}],
        "fatal":               fatal,
    }


# ── Blacklist updater ─────────────────────────────────────────────────────────

def add_to_blacklist(launch: dict, blacklist: dict) -> None:
    reason = "Honeypot confirmed" if launch["checks"]["contract"].get("honeypot") \
             else "Deployer blacklisted"
    contract_entry = {
        "address": launch["contract_address"],
        "reason":  reason,
        "added":   datetime.now(timezone.utc).isoformat(),
    }
    existing_contracts = {b["address"].lower()
                          for b in blacklist.get("contracts", [])}
    if launch["contract_address"].lower() not in existing_contracts:
        blacklist.setdefault("contracts", []).append(contract_entry)

    # Blacklist deployer too if honeypot confirmed
    dep = launch["checks"]["deployer"].get("address")
    if dep and launch["checks"]["contract"].get("honeypot"):
        existing_deps = {b["address"].lower() for b in blacklist.get("deployers", [])}
        if dep.lower() not in existing_deps:
            blacklist.setdefault("deployers", []).append({
                "address": dep,
                "reason":  "Honeypot deployer",
                "added":   datetime.now(timezone.utc).isoformat(),
            })

    save_blacklist(blacklist)


# ── Discord embeds ────────────────────────────────────────────────────────────

def score_icon(sc: int) -> str:
    return "✅" if sc > 0 else ("❌" if sc < 0 else "⚠️")


def build_launch_embed(la: dict) -> dict:
    emoji   = verdict_emoji(la["verdict"])
    verdict = la["verdict"]
    score   = la["total_score"]
    ch      = la["checks"]
    sym     = la["token_symbol"]
    name    = la["token_name"]

    def fmt_usd(v):
        if not v: return "N/A"
        return f"${float(v):,.0f}"

    hp_line  = (f"{score_icon(ch['contract']['score'])} Contract: "
                f"{'Verified' if ch['contract'].get('verified') else 'Unverified'}"
                f"{', no honeypot' if ch['contract'].get('honeypot') is False else ''}")
    soc_line = (f"{score_icon(ch['socials']['score'])} Socials: "
                + " | ".join(k.capitalize() for k, v in {
                    "Twitter": ch["socials"].get("twitter"),
                    "Website": ch["socials"].get("website"),
                    "Telegram": ch["socials"].get("telegram"),
                }.items() if v))
    if not any([ch["socials"].get("twitter"), ch["socials"].get("website"),
                ch["socials"].get("telegram")]):
        soc_line = "❌ No socials found"

    sm_line  = (f"{'✅ Smart money detected' if ch['smart_money']['detected'] else '⚠️ No smart money detected'}")
    dep_line = (f"{'✅ Clean deployer' if not ch['deployer']['blacklisted'] else '❌ BLACKLISTED deployer'}")

    liq_lock = "Unknown"
    desc = (
        f"**Chain:** {la['chain'].capitalize()} | **DEX:** {la['dex']}\n"
        f"**Launched:** {la['minutes_since_launch']:.0f} minutes ago\n\n"
        f"**Price:** ${la['price_usd']:.8g}\n"
        f"**Market Cap:** {fmt_usd(la['market_cap_usd'])}\n"
        f"**Liquidity:** {fmt_usd(la['liquidity_usd'])}\n\n"
        f"{score_icon(ch['contract']['score'])} Contract: "
        f"{'Verified' if ch['contract'].get('verified') else 'Unverified'}"
        f"{', no honeypot' if ch['contract'].get('honeypot') is False else ''}\n"
        f"⚠️ Liquidity lock: {liq_lock}\n"
        f"{soc_line}\n"
        f"{sm_line}\n"
        f"{dep_line}\n\n"
        f"🔗 {la['dexscreener_url']}"
    )

    color = {
        "HIGH OPPORTUNITY": 0x00d2a0,
        "MODERATE":         0xffa502,
        "RISKY":            0xff7675,
        "DANGER":           0xff4757,
        "BLACKLISTED":      0x2d3436,
    }.get(verdict, 0x636e72)

    return {"embeds": [{
        "title":       f"{emoji} NEW TOKEN — {verdict} ({score}/16)\n{name} (${sym})",
        "description": desc,
        "color":       color,
        "footer":      {"text": f"Crypto Sniper • {la['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


def build_analysis_embed(la: dict) -> dict:
    """Compact summary for #sniper-analysis (all tokens)."""
    emoji   = verdict_emoji(la["verdict"])
    ch      = la["checks"]
    scores  = {
        "Liquidity":   ch["liquidity"]["score"],
        "Contract":    ch["contract"]["score"],
        "Socials":     ch["socials"]["score"],
        "Smart Money": ch["smart_money"]["score"],
        "Deployer":    ch["deployer"]["score"],
    }
    score_lines = " | ".join(f"{k}: {v:+d}" for k, v in scores.items())
    desc = (
        f"**{la['token_name']}** (${la['token_symbol']}) — {la['chain'].capitalize()}\n"
        f"Liquidity: ${la['liquidity_usd']:,.0f} | MCap: ${la['market_cap_usd']:,.0f}\n"
        f"Age: {la['minutes_since_launch']:.0f}m | DEX: {la['dex']}\n\n"
        f"`{score_lines}`\n\n"
        f"🔗 {la['dexscreener_url']}"
    )
    return {"embeds": [{
        "title":       f"{emoji} {la['verdict']} ({la['total_score']}/16) — ${la['token_symbol']}",
        "description": desc,
        "color":       0x6c5ce7,
        "footer":      {"text": f"Sniper Analysis • {la['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


def build_blacklist_embed(la: dict) -> dict:
    reason = ("Honeypot confirmed" if la["checks"]["contract"].get("honeypot")
              else "Deployer blacklisted")
    dep    = la["checks"]["deployer"].get("address","?")
    return {"embeds": [{
        "title":       f"⛔ BLACKLISTED — {la['token_name']} (${la['token_symbol']})",
        "description": (
            f"**Chain:** {la['chain'].capitalize()}\n"
            f"**Reason:** {reason}\n"
            f"**Deployer:** `{dep}`\n"
            f"Deployer added to permanent blacklist."
        ),
        "color":       0x2d3436,
        "footer":      {"text": f"Sniper Blacklist • {la['timestamp'][:19].replace('T',' ')} UTC"},
    }]}


async def post_discord(session: aiohttp.ClientSession, url: str, payload: dict) -> bool:
    if not url:
        return False
    try:
        async with session.post(url, json=payload,
                                timeout=aiohttp.ClientTimeout(total=10)) as resp:
            if resp.status not in (200, 204):
                body = await resp.text()
                log.warning(f"Discord {resp.status}: {body[:100]}")
                return False
            return True
    except Exception as e:
        log.warning(f"Discord post failed: {e}")
        return False


async def post_launch(session: aiohttp.ClientSession, la: dict) -> None:
    """Route Discord posts based on verdict. Only alert on HIGH OPPORTUNITY (score 10+)."""
    verdict = la["verdict"]
    score = la["total_score"]

    # Only post to Discord if score >= MIN_SCORE_ALERT (HIGH OPPORTUNITY)
    if score >= MIN_SCORE_ALERT:
        # All HIGH-OPPORTUNITY tokens → #sniper-analysis
        await post_discord(session, ANALYSIS_URL, build_analysis_embed(la))
        
        # Premium opportunities → #launches
        if verdict == "HIGH OPPORTUNITY":
            await post_discord(session, LAUNCHES_URL, build_launch_embed(la))
    else:
        # Below threshold: log silently, no Discord post
        log.debug(f"Score {score} below alert threshold ({MIN_SCORE_ALERT}) — no Discord alert for {la['token_symbol']}")

    # BLACKLISTED always goes to blacklist channel
    if verdict == "BLACKLISTED":
        bl = load_blacklist()
        add_to_blacklist(la, bl)
        await post_discord(session, BLACKLIST_URL, build_blacklist_embed(la))


# ── Price tracker (hourly for 24 h) ──────────────────────────────────────────

async def update_price_history(launches: list) -> None:
    """Update price history for tracked tokens within first 24h."""
    cutoff = datetime.now(timezone.utc) - timedelta(hours=TRACK_HOURS)
    to_track = [la for la in launches
                if not la.get("alert_sent") is False   # only tracked ones
                and la.get("launch_time")
                and datetime.fromisoformat(la["launch_time"].replace("Z","+00:00")) > cutoff
                and len(la.get("price_history", [])) < TRACK_HOURS]

    for la in to_track:
        pair = fetch_dexscreener_pair(la["contract_address"], la["chain"])
        if pair:
            price = float(pair.get("priceUsd") or 0)
            liq   = float((pair.get("liquidity") or {}).get("usd") or 0)
            la.setdefault("price_history", []).append({
                "ts":    datetime.now(timezone.utc).isoformat(),
                "price": price,
                "liq":   liq,
            })
            # Compute all-time high multiplier
            if la["price_history"]:
                first_price = la["price_history"][0].get("price") or la.get("price_usd") or 0
                if first_price:
                    peak = max(h["price"] for h in la["price_history"])
                    la["peak_multiplier"] = round(peak / first_price, 2)

        time.sleep(0.5)


# ── DEXScreener poll ──────────────────────────────────────────────────────────

async def poll_dexscreener(session: aiohttp.ClientSession,
                            seen: set, launches: list,
                            blacklist: dict, watchlist: dict) -> int:
    """Returns count of new tokens found."""
    profiles = fetch_dexscreener_profiles()
    if not profiles:
        return 0

    new_count = 0
    for profile in profiles:
        token_address = profile.get("tokenAddress", "")
        chain         = profile.get("chainId", "")

        # Quick pair lookup to get age + liquidity
        pair = fetch_dexscreener_pair(token_address, chain)
        if not pair:
            continue

        pair_address = pair.get("pairAddress", "")
        if not pair_address or pair_address in seen:
            continue

        age_min = minutes_since(pair.get("pairCreatedAt"))
        if age_min > MAX_AGE_MIN:
            continue

        liq_usd = float((pair.get("liquidity") or {}).get("usd") or 0)
        mcap = float(pair.get("marketCap") or pair.get("fdv") or 0)
        
        # Skip tokens below liquidity and market cap thresholds (log silently)
        if liq_usd < MIN_LIQ_USD:
            log.debug(f"DEXScreener: {pair.get('baseToken', {}).get('symbol', '?')} — liq ${liq_usd:,.0f} below ${MIN_LIQ_USD:,.0f}")
            continue
        
        if mcap < MIN_MCAP_USD:
            log.debug(f"DEXScreener: {pair.get('baseToken', {}).get('symbol', '?')} — mcap ${mcap:,.0f} below ${MIN_MCAP_USD:,.0f}")
            continue

        la = await analyze_token(profile, pair, blacklist, watchlist)
        if la is None:
            continue

        launches.append(la)
        seen.add(pair_address)
        save_launches(launches)
        new_count += 1

        # Only log if score meets alert threshold
        if la['total_score'] >= MIN_SCORE_ALERT:
            log.info(f"  [{la['chain'].upper():<8}] {la['token_symbol']:<10} "
                     f"liq=${la['liquidity_usd']:>8,.0f}  "
                     f"age={la['minutes_since_launch']:>4.0f}m  "
                     f"score={la['total_score']:>+3d}  {la['verdict']}")
        else:
            log.debug(f"  [{la['chain'].upper():<8}] {la['token_symbol']:<10} "
                      f"liq=${la['liquidity_usd']:>8,.0f}  "
                      f"score={la['total_score']:>+3d}  {la['verdict']} (below threshold)")

        await post_launch(session, la)
        la["alert_sent"] = True
        save_launches(launches)

        await asyncio.sleep(0.3)  # slight spacing between tokens

    return new_count


# ── GeckoTerminal poll ────────────────────────────────────────────────────────

async def poll_geckoterminal(session: aiohttp.ClientSession,
                              seen: set, launches: list,
                              blacklist: dict, watchlist: dict) -> int:
    new_count = 0
    for gt_chain, chain_label in CHAINS_GT.items():
        pools = fetch_geckoterminal_pools(gt_chain)
        for pool in pools:
            attrs        = pool.get("attributes", {})
            pool_address = attrs.get("address", "")
            if not pool_address or pool_address in seen:
                continue

            created_str = attrs.get("pool_created_at", "")
            try:
                created_dt = datetime.fromisoformat(created_str.replace("Z","+00:00"))
                age_min    = (datetime.now(timezone.utc) - created_dt).total_seconds() / 60
            except Exception:
                continue

            if age_min > MAX_AGE_MIN:
                continue

            liq_usd = float(attrs.get("reserve_in_usd") or 0)
            if liq_usd < MIN_LIQ_USD:
                continue

            # Build a minimal launch record from GT data (no full analysis pipeline)
            name_raw = attrs.get("name", "? / ?")
            base_sym = name_raw.split("/")[0].strip() if "/" in name_raw else name_raw
            rels     = pool.get("relationships", {})
            tok_data = rels.get("base_token", {}).get("data", {})
            token_id = tok_data.get("id","").split("_")[-1]  # GT format: "chain_address"

            ds_chain = {"eth":"ethereum","bsc":"bsc","base":"base","solana":"solana"}.get(gt_chain, gt_chain)

            la_simple = {
                "id":                  str(uuid.uuid4()),
                "timestamp":           datetime.now(timezone.utc).isoformat(),
                "token_name":          base_sym,
                "token_symbol":        base_sym,
                "chain":               ds_chain,
                "contract_address":    token_id,
                "dex":                 rels.get("dex",{}).get("data",{}).get("id","?"),
                "pair_address":        pool_address,
                "launch_time":         created_str,
                "minutes_since_launch": round(age_min, 1),
                "price_usd":           float(attrs.get("base_token_price_usd") or 0),
                "market_cap_usd":      float(attrs.get("market_cap_usd") or 0),
                "liquidity_usd":       round(liq_usd, 2),
                "volume_24h":          0,
                "checks": {
                    "liquidity":   {"value": round(liq_usd,2), "locked": False,
                                   "score": score_liquidity(liq_usd)[0]},
                    "contract":    {"verified": None, "honeypot": None, "score": 0,
                                   "note": "GT source — full check pending DS cross-ref"},
                    "holders":     {"top10_pct": None, "score": 0},
                    "socials":     {"twitter": False, "website": False, "telegram": False, "score": -1},
                    "smart_money": {"detected": False, "wallets": [], "score": 0},
                    "deployer":    {"address": None, "blacklisted": False, "score": 0},
                },
                "total_score":     score_liquidity(liq_usd)[0] - 1,  # liq + no socials
                "verdict":         "RISKY",
                "dexscreener_url": f"https://dexscreener.com/{ds_chain}/{pool_address}",
                "alert_sent":      False,
                "price_history":   [],
                "source":          "geckoterminal",
            }

            launches.append(la_simple)
            seen.add(pool_address)
            save_launches(launches)
            new_count += 1

            log.info(f"  [GT-{gt_chain.upper():<6}] {base_sym:<10} "
                     f"liq=${liq_usd:>8,.0f}  age={age_min:>4.0f}m  "
                     f"score={la_simple['total_score']:>+3d}  {la_simple['verdict']}")

            # Only post GT tokens to analysis channel (lower signal quality)
            await post_discord(session, ANALYSIS_URL, build_analysis_embed(la_simple))
            la_simple["alert_sent"] = True
            save_launches(launches)
            await asyncio.sleep(0.2)

        time.sleep(0.5)  # between GT networks

    return new_count


# ── Main loop ─────────────────────────────────────────────────────────────────

async def run():
    log.info("=== Crypto Sniper starting ===")
    log.info(f"Chains (DS)  : {', '.join(sorted(CHAINS_DS))}")
    log.info(f"Chains (GT)  : {', '.join(CHAINS_GT.keys())}")
    log.info(f"Discord launches  : {'✅' if LAUNCHES_URL else '❌'}")
    log.info(f"Discord analysis  : {'✅' if ANALYSIS_URL else '❌'}")
    log.info(f"Discord blacklist : {'✅' if BLACKLIST_URL else '❌'}")
    log.info(f"DS poll: {DS_INTERVAL}s | GT poll: {GT_INTERVAL}s\n")

    launches  = load_launches()
    blacklist = load_blacklist()
    watchlist = load_watchlist()
    seen      = get_seen_ids(launches)

    log.info(f"Loaded {len(launches)} existing launches, {len(seen)} seen pairs")

    last_ds     = 0.0
    last_gt     = 0.0
    last_track  = 0.0
    TRACK_INTERVAL = 3600  # hourly

    async with aiohttp.ClientSession() as session:
        while True:
            now = time.monotonic()

            # ── DEXScreener poll ───────────────────────────────────────────
            if now - last_ds >= DS_INTERVAL:
                try:
                    n = await poll_dexscreener(session, seen, launches,
                                               blacklist, watchlist)
                    if n:
                        log.info(f"DEXScreener: {n} new token(s)")
                except Exception as e:
                    log.error(f"DEXScreener poll error: {e}", exc_info=True)
                last_ds = time.monotonic()

            # ── GeckoTerminal poll (staggered) ─────────────────────────────
            if now - last_gt >= GT_INTERVAL:
                try:
                    n = await poll_geckoterminal(session, seen, launches,
                                                  blacklist, watchlist)
                    if n:
                        log.info(f"GeckoTerminal: {n} new pool(s)")
                except Exception as e:
                    log.error(f"GeckoTerminal poll error: {e}", exc_info=True)
                last_gt = time.monotonic()

            # ── Archive rotation ───────────────────────────────────────────
            if len(launches) > LAUNCHES_MAX:
                launches = await maybe_rotate(
                    session, "launches", launches, LAUNCHES_FILE,
                    max_entries=LAUNCHES_MAX, webhook_url=ARCHIVE_URL
                )
                seen = get_seen_ids(launches)
                save_launches(launches)

            # ── Hourly price tracking ──────────────────────────────────────
            if now - last_track >= TRACK_INTERVAL:
                try:
                    await update_price_history(launches)
                    save_launches(launches)
                except Exception as e:
                    log.error(f"Price tracking error: {e}", exc_info=True)
                last_track = time.monotonic()

            # Reload blacklist/watchlist periodically (Commander may update)
            if int(now) % 300 < 2:
                blacklist = load_blacklist()
                watchlist = load_watchlist()

            await asyncio.sleep(5)  # inner sleep — actual intervals gated above


if __name__ == "__main__":
    asyncio.run(run())
