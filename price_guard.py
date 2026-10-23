"""Send-time price guard for every Telegram/SMS sender (remedial W1, 2026-10-20).

One rule, one implementation: MissionCtrl's pipeline/decision/lib/quote_client.py
(send_price_check + src_label, thresholds in fact_policies.json "send_guard": 60 s in
the regular session, 300 s pre/after-hours, today's print only — Mike's decision 3).
This module only path-loads it, so the pipeline lib never lands on sys.path. If it
can't be loaded, every check fails closed — a sender holds the card, it never guesses.

    from price_guard import check, src_label, fresh, option_mid, option_quotes, alpaca_last
"""
from __future__ import annotations

import importlib.util
import os
import re
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

ET = ZoneInfo("America/New_York")

QUOTE_CLIENT = (os.environ.get("MC_QUOTE_CLIENT")
                or "/AIWorkWSL/web/missionctrl/pipeline/decision/lib/quote_client.py")


def _load():
    try:
        spec = importlib.util.spec_from_file_location("mc_quote_client", QUOTE_CLIENT)
        mod = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(mod)
        return mod if hasattr(mod, "send_price_check") else None
    except Exception:  # noqa: BLE001 — missing/broken lib = fail closed below
        return None


QC = _load()


def check(trade_ts, price, now: datetime | None = None, prev_bar_ts=None) -> dict:
    """{ok, reason, age_s, hhmm, window}. ok=False with a reason whenever the price can't be trusted."""
    if QC is None:
        return {"ok": False, "reason": "price guard unavailable", "age_s": None, "hhmm": None, "window": None}
    return QC.send_price_check(trade_ts, now=now, price=price, prev_bar_ts=prev_bar_ts)


def fresh(symbols, now: datetime | None = None) -> dict:
    """Remedial W4: quote_client.require_fresh — {SYM: {ok, price, provider, as_of, src, reason, window, cross,
    change_pct}}. Robinhood first; pre/after-hours use the extended print. Fails closed when the lib is missing."""
    syms = [s.strip().upper() for s in symbols if s and s.strip()]
    if QC is None or not hasattr(QC, "require_fresh"):
        return {s: {"ok": False, "price": None, "provider": None, "as_of": None, "src": None, "window": None,
                    "reason": "price guard unavailable", "cross": "UNCHECKED", "change_pct": None} for s in syms}
    return QC.require_fresh(syms, now=now)


_OF = None
_MD = None
OCC_RE = re.compile(r"^[A-Z]{1,6}\d{6}[CP]\d{8}$")


def _option_fallback_mod():
    """lib/option_fallback loaded by file path (same reason as rh_quote: the pipeline has its own `lib`)."""
    global _OF
    if _OF is None:
        spec = importlib.util.spec_from_file_location("pg_option_fallback", os.path.join(
            os.path.dirname(os.path.abspath(__file__)), "lib", "option_fallback.py"))
        _OF = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(_OF)
    return _OF


def _missing_data_mod():
    global _MD
    if _MD is None:
        spec = importlib.util.spec_from_file_location("pg_missing_data", os.path.join(
            os.path.dirname(QUOTE_CLIENT), "missing_data.py"))
        _MD = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(_MD)
    return _MD


def _alert_missing(input_name: str, tried: list) -> None:
    """Loud missing-data alert (ops lane + Data Health state), once per input per ET day. TG_DRY_RUN=1 renders only."""
    try:
        _missing_data_mod().alert_missing(input_name, tried, dry_run=os.environ.get("TG_DRY_RUN") == "1")
    except Exception as e:  # noqa: BLE001 - an alert failure never breaks a sender; it is printed
        print(f"[price_guard] missing-data alert failed: {type(e).__name__}")


def _expired(occ: str, now: datetime | None = None) -> bool:
    try:
        exp = datetime.strptime(occ[-15:-9], "%y%m%d").date()
    except ValueError:
        return False
    return exp < (now or datetime.now(timezone.utc)).astimezone(ET).date()


def fallback_mark(occ: str, rh_reason: str, now: datetime | None = None) -> tuple:
    """Robinhood had no quote: Yahoo option chain, then CBOE delayed (lib/option_fallback), each labelled and dated.
    -> (quote | None, check | None, tried[{source, error}], stale | None).  quote passed the send-guard age rule for
    `now`; `stale` is the first leg that answered but was too old (shown by display callers, never used by senders).
    Nothing answered at all -> quote None and stale None: that is the missing-data case (caller raises the alert)."""
    tried = [{"source": "Robinhood", "error": rh_reason}]
    if not re.match(r"^[A-Z]{1,6}\d{6}[CP]\d{8}$", occ or ""):
        tried.append({"source": "Yahoo/CBOE", "error": "not an OCC symbol"})
        return None, None, tried, None
    if _expired(occ, now):
        tried.append({"source": "Yahoo/CBOE", "error": "contract expired - nothing to price"})
        return None, None, tried, None
    of = _option_fallback_mod()
    stale = None
    chk = None
    for name, leg in of.LEGS:
        q, why = leg(occ)
        if q is None:
            tried.append({"source": name, "error": why})
            continue
        ts = datetime.fromtimestamp(q["as_of"], timezone.utc).isoformat()
        chk = check(ts, q["mid"], now=now)
        if chk["ok"]:
            return q, chk, tried + [{"source": name, "ok": True}], None
        tried.append({"source": name, "error": f"too old for a sender: {chk['reason']}"})
        stale = stale or {**q, "check": chk}
    return None, chk, tried, stale


def tried_text(tried: list) -> str:
    return "; ".join(f"{t['source']}: {t.get('error') or 'ok'}" for t in tried)


def option_mid(occ: str, now: datetime | None = None) -> tuple:
    """Remedial W4 (Mike 10-09 #1): option mid from Robinhood first (lib/rh_quote, read-only), else the
    Yahoo option chain, then CBOE delayed (each labelled, dated, send-guard age rule). No Alpaca leg (removed 2026-10-23).
    -> (mid | None, check, src, extras{iv, delta, high, low, rh_reason, tried}).
    extras["rh_reason"] names why Robinhood was not used (None when it was), so a fallback is never silent.
    A caller's `now` taken before this fetch (a run that started seconds earlier) is not allowed to make a
    fresh Robinhood quote look like it is "from the future" (2026-10-22: the SPY 0DTE scalp cards fell back
    to Alpaca all session for exactly that); the check then uses the fetch time."""
    diag: dict = {}
    try:
        rq = _rh_quote_mod()
        q = rq.rh_quotes([occ], diag=diag).get(occ)
    except Exception as e:  # noqa: BLE001 — no RH = fall through to the labelled fallback
        q, diag[occ] = None, f"Robinhood helper error ({type(e).__name__})"
    if q:
        ts = datetime.fromtimestamp(q["as_of"], timezone.utc).isoformat()
        fetched = datetime.now(timezone.utc)
        ref = fetched if (now is not None and now.timestamp() < q["as_of"] <= fetched.timestamp() + 2) else now
        chk = check(ts, q["mid"], now=ref)
        extras = {"iv": q.get("iv"), "delta": q.get("delta"), "high": q.get("high"), "low": q.get("low"),
                  "bid": q["bid"], "ask": q["ask"], "rh_reason": None if chk["ok"] else chk.get("reason")}
        return (q["mid"] if chk["ok"] else None), chk, src_label("Robinhood", ts), extras
    rh_reason = diag.get(occ) or "no Robinhood quote"
    fq, fchk, tried, stale = fallback_mark(occ, rh_reason, now)
    if fq:
        ts = datetime.fromtimestamp(fq["as_of"], timezone.utc).isoformat()
        return fq["mid"], fchk, src_label(fq["label"], ts), {"bid": fq["bid"], "ask": fq["ask"], "rh_reason": rh_reason,
                                                             "provider": fq["provider"], "as_of": fq["as_of"],
                                                             "as_of_et": fq["as_of_et"], "tried": tried}
    if stale is None and OCC_RE.match(occ or "") and not _expired(occ, now):
        _alert_missing(f"option mark {occ}", tried)   # every source failed: loud, once per day
    return None, {"ok": False, "reason": "UNAVAILABLE - " + tried_text(tried), "age_s": None, "hhmm": None,
                  "window": None}, None, {"rh_reason": rh_reason, "tried": tried, "stale": stale}


_RQ = None


def _rh_quote_mod():
    """lib/rh_quote loaded by file path: callers outside ~/scripts (MissionCtrl pipeline) have their own `lib`.
    Loaded once per process so its instrument-id cache survives between calls."""
    global _RQ
    if _RQ is not None:
        return _RQ
    spec = importlib.util.spec_from_file_location("pg_rh_quote", os.path.join(os.path.dirname(os.path.abspath(__file__)),
                                                                           "lib", "rh_quote.py"))
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    _RQ = mod
    return mod


def last_session_day(now: datetime | None = None):
    """The most recent COMPLETED regular session (today after its close, else the previous trading day)."""
    clk = getattr(QC, "_clock", None)
    if clk is None:
        return None
    now = (now or datetime.now(timezone.utc)).astimezone(ET)
    today = now.date()
    if clk.is_trading_day(today) and now >= clk.session_close(today):
        return today
    return clk.previous_trading_day(today)


def option_quotes(occs, now: datetime | None = None, mode: str = "live") -> dict:
    """Batch Robinhood option quotes (one read-only lib/rh_quote call; Mike GO 2026-10-22 option marks → RH).

    mode "live":  check() — today's quote within the send-guard age (gating at decision time).
    mode "close": the quote must be from last_session_day() (a nightly closing mark).
    -> {occ: {ok, mid, bid, ask, as_of (epoch), as_of_et, provider, src, reason}}. mid is None unless ok.
    A contract Robinhood cannot price falls to Yahoo, then CBOE delayed (labelled, dated). Every source failing gives
    ok False, provider None and a reason naming all of them (plus one loud missing-data alert)."""
    occs = list(dict.fromkeys(o for o in (occs or []) if o))
    try:
        rq = _rh_quote_mod().rh_quotes(occs)
    except Exception as e:  # noqa: BLE001 — no RH = every contract falls to the caller's fallback
        rq, err = {}, f"Robinhood unavailable ({type(e).__name__})"
    else:
        err = "Robinhood could not price it"
    day = last_session_day(now) if mode == "close" else None
    out = {}
    missing: list = []
    for occ in occs:
        q = rq.get(occ)
        provider, label = "robinhood", "Robinhood"
        tried = None
        if not q:
            fq, _fchk, tried, stale = fallback_mark(occ, err, now)
            if fq is None and stale is not None:   # answered but too old for the live gate; a "close" mark may still be dated right
                fq = stale
            if fq is None:
                if mode == "live" and OCC_RE.match(occ or "") and not _expired(occ, now):
                    missing.append(occ)
                out[occ] = {"ok": False, "mid": None, "bid": None, "ask": None, "as_of": None, "as_of_et": None,
                            "provider": None, "src": None, "reason": "UNAVAILABLE - " + tried_text(tried), "tried": tried}
                continue
            q, provider, label = fq, fq["provider"], fq["label"]
        ts = datetime.fromtimestamp(q["as_of"], timezone.utc).isoformat()
        if mode == "close":
            qd = datetime.fromtimestamp(q["as_of"], ET).date()
            ok = day is not None and qd == day
            reason = None if ok else (f"quote from {qd} — last session {day}" if day else "market calendar unavailable")
        else:
            chk = check(ts, q["mid"], now=now)
            ok, reason = chk["ok"], chk["reason"]
        out[occ] = {"ok": ok, "mid": q["mid"] if ok else None, "bid": q["bid"], "ask": q["ask"], "as_of": q["as_of"],
                    "as_of_et": q.get("as_of_et"), "provider": provider, "src": src_label(label, ts),
                    "reason": reason, **({"tried": tried} if tried else {})}
        if not ok and tried:   # a fallback leg answered but is too old: name every source in the reason
            out[occ]["reason"] = f"{reason} ({tried_text(tried)})"
    if missing:   # one loud alert per call (and per ET day) naming each contract + every source tried
        _alert_missing("option marks (no source answered)", [
            {"source": f"{o} via {t['source']}", "error": t.get("error")} for o in missing for t in out[o]["tried"]])
    return out


def src_label(source: str, ts) -> str:
    return QC.src_label(source, ts) if QC else f"src {source} time n/a"


def _bar_date(bar: dict):
    try:
        return datetime.fromisoformat(str(bar.get("t", "")).replace("Z", "+00:00")).astimezone(ET).date()
    except ValueError:
        return None


def alpaca_session_bars(node: dict | None, now: datetime | None = None) -> tuple:
    """(prior_bar, today_bar) from an Alpaca snapshot, anchored on bar DATES. Before today's
    first print, Alpaca's dailyBar is still the LAST session and prevDailyBar is two sessions
    back (the 10-08 PCRX premarket gap was measured against that bar). today_bar is {} then."""
    node = node or {}
    daily, prev = node.get("dailyBar") or {}, node.get("prevDailyBar") or {}
    today = (now or datetime.now(timezone.utc)).astimezone(ET).date()
    d = _bar_date(daily) if daily else None
    if d is not None and d < today:
        return daily, {}
    return prev, daily


def alpaca_last(node: dict | None, now: datetime | None = None) -> tuple:
    """(price, check) from an Alpaca stock/crypto snapshot's latestTrade. price is None unless check ok."""
    t = (node or {}).get("latestTrade") or {}
    chk = check(t.get("t"), t.get("p"), now=now)
    return (float(t["p"]) if chk["ok"] else None), chk
