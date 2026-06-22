#!/usr/bin/env python3
"""
markov_regime_snapshot.py — compute an observable Markov regime snapshot for the
index ETFs and write it where the missionctrl /api/markov-regime route reads it.

Models the market as a 3-state probability map (Bull / Sideways / Bear) via a
20-day rolling-return label, fits the 3x3 transition matrix by MLE counting,
solves the stationary distribution, forecasts the next-day regime mix, and runs a
NO-LOOKAHEAD walk-forward backtest (re-estimate P each step on past-only data)
reporting Sharpe + max drawdown vs buy-and-hold. (mirrors the zero-one
markov-hedge-fund-method skill; surfaced as a dashboard panel.)

Run: ~/.venv/bin/python ~/scripts/markov_regime_snapshot.py
"""
import json, os, datetime
import numpy as np

OUT = os.path.expanduser("~/mission-control/signal-receiver/data/markov_regime.json")
TICKERS = ["SPY", "QQQ"]
STATES = ["Bear", "Sideways", "Bull"]   # index 0,1,2
ROLL = 20
THR = 0.02          # ±2% 20-day return splits the three regimes
WARMUP = 252        # walk-forward starts after 1y of data


def label_regimes(close):
    roll = close.pct_change(ROLL)
    lab = np.where(roll > THR, 2, np.where(roll < -THR, 0, 1))
    return lab[ROLL:]                    # drop the leading NaN window


def transition_matrix(labels):
    P = np.zeros((3, 3))
    for a, b in zip(labels[:-1], labels[1:]):
        P[a, b] += 1
    rows = P.sum(axis=1, keepdims=True)
    rows[rows == 0] = 1
    return P / rows


def stationary(P):
    vals, vecs = np.linalg.eig(P.T)
    i = np.argmin(np.abs(vals - 1.0))
    v = np.real(vecs[:, i])
    v = np.abs(v)
    return v / v.sum()


def walk_forward(close, labels, rets):
    # rets aligned to labels (next-day return after each labelled day)
    eq, bh = [1.0], [1.0]
    pos_returns = []
    for t in range(WARMUP, len(labels) - 1):
        P = transition_matrix(labels[:t])           # past-only
        cur = labels[t]
        nxt = P[cur]                                  # next-state distribution
        # expected directional bias: Bull mass - Bear mass
        bias = nxt[2] - nxt[0]
        pos = 1.0 if bias > 0.05 else (-1.0 if bias < -0.05 else 0.0)
        r = rets[t + 1]
        pos_returns.append(pos * r)
        eq.append(eq[-1] * (1 + pos * r))
        bh.append(bh[-1] * (1 + r))
    pr = np.array(pos_returns)
    sharpe = float(np.mean(pr) / (np.std(pr) + 1e-9) * np.sqrt(252)) if len(pr) else 0.0
    eqa = np.array(eq)
    dd = float(((eqa - np.maximum.accumulate(eqa)) / np.maximum.accumulate(eqa)).min())
    bha = np.array(bh)
    bh_ret = np.diff(bha) / bha[:-1]
    bh_sharpe = float(np.mean(bh_ret) / (np.std(bh_ret) + 1e-9) * np.sqrt(252)) if len(bh_ret) else 0.0
    return {"sharpe": round(sharpe, 2), "max_drawdown": round(dd, 3),
            "buyhold_sharpe": round(bh_sharpe, 2), "n_days": len(pr)}


def analyze(ticker):
    import yfinance as yf
    df = yf.download(ticker, period="3y", interval="1d", progress=False, auto_adjust=True)
    if df is None or df.empty:
        raise RuntimeError(f"no data for {ticker}")
    close = df["Close"].squeeze()
    rets = close.pct_change().fillna(0).to_numpy()[ROLL:]
    labels = label_regimes(close)
    P = transition_matrix(labels)
    stat = stationary(P)
    cur = int(labels[-1])
    nxt = P[cur]
    bias = float(nxt[2] - nxt[0])
    signal = 1 if bias > 0.05 else (-1 if bias < -0.05 else 0)
    wf = walk_forward(close, labels, rets)
    return {
        "current_regime": STATES[cur],
        "next_day_probs": {STATES[i]: round(float(nxt[i]), 3) for i in range(3)},
        "transition_matrix": {STATES[a]: {STATES[b]: round(float(P[a, b]), 3) for b in range(3)} for a in range(3)},
        "stationary": {STATES[i]: round(float(stat[i]), 3) for i in range(3)},
        "signal": signal,
        "bias": round(bias, 3),
        "walkforward": wf,
        "last_close": round(float(close.iloc[-1]), 2),
    }


def main():
    out = {"asof": datetime.datetime.now().isoformat(timespec="seconds"),
           "model": "observable 3-state Markov (Bull/Sideways/Bear), 20d roll, walk-forward no-lookahead",
           "tickers": {}}
    for tk in TICKERS:
        try:
            out["tickers"][tk] = analyze(tk)
        except Exception as e:
            out["tickers"][tk] = {"error": str(e)[:160]}
    os.makedirs(os.path.dirname(OUT), exist_ok=True)
    tmp = OUT + ".tmp"
    with open(tmp, "w") as f:
        json.dump(out, f, indent=2)
    os.replace(tmp, OUT)
    print(f"wrote {OUT}")
    for tk, d in out["tickers"].items():
        if "error" in d:
            print(f"  {tk}: ERROR {d['error']}")
        else:
            print(f"  {tk}: {d['current_regime']} signal={d['signal']} wf_sharpe={d['walkforward']['sharpe']} (bh {d['walkforward']['buyhold_sharpe']})")


if __name__ == "__main__":
    main()
