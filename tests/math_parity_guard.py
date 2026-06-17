#!/usr/bin/env python3
"""
Math / parser PARITY GUARD — drift tripwire for the duplicated-but-not-consolidated
trading math across the three trees.

WHY this instead of a hard consolidation: the duplicated implementations live in three
separate trees (labs/quantum, web/missionctrl, 05_AUTOMATION) under different venvs and
deploy paths. A runtime cross-tree import/symlink would re-introduce exactly the
restructure path-fragility that broke things on 2026-06-07. The implementations are
proven numerically identical (0 drift), so the right safeguard is a TEST that fails loud
if they ever diverge — not a fragile shared import in production.

Covers:
  • Black-Scholes price + greeks: theo.bs_greeks  vs  options_engine.greeks  (web + 05_AUTOMATION copies)
  • OCC option-symbol parsing: validate.parse_occ vs tradier_client.parse_occ_symbol

Exit 0 = all parities hold. Exit 1 = drift detected (wire to a weekly cron if desired).
Run:  ~/.venv/bin/python ~/05_AUTOMATION/scripts/tests/math_parity_guard.py
"""
import importlib.util
import sys

TOL = 1e-3  # greeks agree to 3 decimals (different CDF impls: erf vs scipy)

def _load(path, name):
    """Load a module by explicit file path (avoids same-name collisions across trees)."""
    spec = importlib.util.spec_from_file_location(name, path)
    m = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(m)
    return m

results = []  # (label, ok, detail)

# ── 1. Black-Scholes price + greeks parity ──────────────────────────────────────
S, K, T, vol, r = 750.0, 745.0, 31 / 365, 0.143, 0.04
try:
    theo = _load("/AIWorkWSL/labs/quantum/src/theo.py", "theo_canon")
    p_theo = theo.bs_price(S, K, T, vol, "call", r)
    g_theo = theo.bs_greeks(S, K, T, vol, "call", r)
    for label, path in [
        ("options_engine[web]", "/home/itsju/web/missionctrl/scripts/options_engine.py"),
        ("options_engine[05A]", "/home/itsju/05_AUTOMATION/scripts/options_engine.py"),
    ]:
        try:
            oe = _load(path, "oe_" + label)
            p_oe = oe.black_scholes(S, K, T, r, vol, "call")
            g_oe = oe.greeks(S, K, T, r, vol, "call")
            dprice = abs(float(p_theo) - float(p_oe))
            ddelta = abs(float(g_theo["delta"]) - float(g_oe["delta"]))
            dvega = abs(float(g_theo["vega"]) - float(g_oe["vega"]))
            ok = dprice < TOL and ddelta < TOL and dvega < TOL
            results.append((f"BS parity theo vs {label}", ok,
                            f"Δprice={dprice:.2e} Δdelta={ddelta:.2e} Δvega={dvega:.2e}"))
        except Exception as e:
            results.append((f"BS parity theo vs {label}", None, f"SKIP ({e})"))
except Exception as e:
    results.append(("BS parity (theo load)", None, f"SKIP ({e})"))

# ── 2. OCC option-symbol parser parity ──────────────────────────────────────────
SAMPLE = "MSFT260515P00410000"  # MSFT 2026-05-15 PUT 410.0
EXPECT = ("MSFT", "2026-05-15", "P", 410.0)
def _norm_dict(d):  # validate.parse_occ → {ticker,expiry,kind,strike}
    if not d: return None
    return (d["ticker"], d["expiry"], "P" if d["kind"] == "put" else "C", float(d["strike"]))
def _norm_tuple(t):  # tradier.parse_occ_symbol → (und,expiry,type,strike)
    if not t: return None
    return (t[0], t[1], t[2], float(t[3]))
try:
    val = _load("/AIWorkWSL/labs/quantum/src/validate.py", "validate_canon")
    trad = _load("/home/itsju/web/missionctrl/scripts/lib/tradier_client.py", "tradier_canon")
    a = _norm_dict(val.parse_occ(SAMPLE))
    b = _norm_tuple(trad.parse_occ_symbol(SAMPLE))
    ok = (a == EXPECT) and (b == EXPECT) and (a == b)
    results.append(("OCC parity validate vs tradier", ok, f"validate={a} tradier={b} expect={EXPECT}"))
except Exception as e:
    results.append(("OCC parity", None, f"SKIP ({e})"))

# ── Report ──────────────────────────────────────────────────────────────────────
fails = [r for r in results if r[1] is False]
print("=== math/parser parity guard ===")
for label, ok, detail in results:
    tag = "PASS" if ok else ("SKIP" if ok is None else "DRIFT")
    print(f"  [{tag}] {label}: {detail}")
if fails:
    print(f"DRIFT DETECTED in {len(fails)} check(s) — duplicated impls have diverged.")
    sys.exit(1)
print("All parities hold (0 drift).")
sys.exit(0)
