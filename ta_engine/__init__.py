"""Standalone Technical-Analysis engine (Layer 2).

Computes indicators / candle patterns / SMC structure / levels on a signaled ticker
and emits a structured verdict whose top-level fields map directly onto the
signal_scorer + signal_gatekeeper contract (Layer 3 consumes this).

Pure numpy/pandas. Standalone — NOT imported by the live trader during Layer 2.
"""
