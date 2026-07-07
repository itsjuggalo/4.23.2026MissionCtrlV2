"""real_coach — Mike's REAL-account (Robinhood + Coinbase) hold/sell coach.

Advisory/alert-only: reads ~/portfolio/unified_book.json, runs TA (ta_engine) +
ported book rules (labs/quantum portfolio_manage + trail-daemon tiers) per holding,
and delivers verdict digests/cards to Telegram. NEVER places orders — there is no
order endpoint anywhere in this package (enforced by coach.py --selftest).
"""
