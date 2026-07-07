"""fills — pull + persist Mike's REAL-account trade history into ~/portfolio/mike.sqlite.

Four read-only pullers (RH stock / RH option / RH crypto / Coinbase v2 retail), one
orchestrator (fills_sync.py), a FIFO lot engine (lot_engine.py), and the bias report
(bias_report.py). Idempotent: UNIQUE fill key + INSERT OR IGNORE; incremental via
sync_state cursors. Never places orders.
"""
