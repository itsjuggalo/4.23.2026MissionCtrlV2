"""Every ~/scripts RSI reads the one canonical RSI (missionctrl lib/rsi_canonical = Robinhood's RSI indicator).
SPY Robinhood daily closes 2026-09-02 … 2026-10-21; Robinhood's RSI(14) for 2026-10-21 over this window = 53.1736."""
import importlib.util
import sys
from pathlib import Path

import pandas as pd

ROOT = Path(__file__).resolve().parents[1]
SPY = [765.16, 773.17, 770.19, 765.96, 762.4, 757.83, 764.29, 760.88, 757.39, 754.05, 762.6, 761.69, 773.5, 773.38,
       767.81, 767.18, 771.35, 765.61, 764.2, 762.63, 763.99, 769.64, 774.83, 779.09, 777.22, 773.93, 778.57, 778.1,
       778.01, 769.6, 771.79, 763.25, 766.48, 769.05, 773.09]
RH = 53.17359499155181


def _load(rel, name):
    """Load one script in isolation. Several scripts import a top-level `lib` package — ~/scripts/lib and missionctrl
    pipeline/lib share that name — so whichever another test imported first used to win (order-dependent failure:
    `cannot import name 'afterhours' from 'lib'`). Each load starts with no cached `lib*` modules and the original
    sys.path, and both are restored afterwards."""
    saved_path = list(sys.path)
    saved_lib = {k: v for k, v in sys.modules.items() if k == "lib" or k.startswith("lib.")}
    for k in saved_lib:
        del sys.modules[k]
    try:
        spec = importlib.util.spec_from_file_location(name, ROOT / rel)
        m = importlib.util.module_from_spec(spec)
        sys.path.insert(0, str((ROOT / rel).parent))
        spec.loader.exec_module(m)
        return m
    finally:
        for k in [k for k in sys.modules if k == "lib" or k.startswith("lib.")]:
            del sys.modules[k]
        sys.modules.update(saved_lib)
        sys.path[:] = saved_path


def test_all_rsi_paths_equal_robinhood():
    assert abs(_load("entry_radar_refresh.py", "er").rsi(SPY) - round(RH, 1)) < 1e-9
    assert abs(_load("ta_engine/indicators.py", "tei").rsi(SPY) - round(RH, 2)) < 1e-9
    assert abs(_load("ta_engine.py", "te").rsi(SPY) - round(RH, 2)) < 1e-9
    assert abs(_load("market_data_fetch.py", "mdf").calc_rsi(list(reversed(SPY))) - RH) < 1e-9   # newest first
    assert abs(_load("trade_charts/chartlib.py", "cl")._rsi(pd.Series(SPY)).iloc[-1] - RH) < 1e-9
