import pytest

from pipeline.discord import normalize


def test_from_flow_alert_canonical():
    alert = {
        "Symbol": "TSLA",
        "Strike": "480",
        "OptionType": "CALL",
        "Expiry": 1748563200,
        "DTE": 0,
        "isBullish": True,
        "totalFlowValue": "52400",
        "Volume": "1240",
        "OI": "830",
        "Spot": 478.50,
        "AlertPrice": 2.14,
        "BlockType": "SWEEP",
        "BidAskType": "A",
        "AlertType": "high_flow",
        "UnderlyingType": "STOCK",
        "Time": 1748560000,
        "SWEEPS": 4,
        "BLOCKS": 1,
    }
    evt = normalize.from_flow_alert("src1", alert)
    assert evt.symbol == "TSLA"
    assert evt.strike == 480.0
    assert evt.opt_type == "C"
    assert evt.premium == 52400.0
    assert evt.is_bullish is True
    assert evt.block_type == "SWEEP"
    assert evt.bid_ask == "A"
    assert evt.dte == 0
    assert evt.sweeps == 4


def test_from_flow_live_infers_bullishness():
    bullish_call = {
        "Symbol": "NVDA",
        "Strike": 145,
        "OptionType": "CALL",
        "BidAskType": "A",
        "Expiry": 1748563200,
        "Value": 18000,
        "Volume": 220,
        "OI": 410,
        "Spot": 142.10,
        "Price": 1.85,
        "BlockType": "BLOCK",
        "Time": 1748560000,
    }
    bearish_put = {**bullish_call, "OptionType": "PUT", "BidAskType": "B"}
    contra_call = {**bullish_call, "BidAskType": "B"}

    assert normalize.from_flow_live("a", bullish_call).is_bullish is True
    assert normalize.from_flow_live("b", bearish_put).is_bullish is True
    assert normalize.from_flow_live("c", contra_call).is_bullish is False


def test_missing_fields_default_safely():
    evt = normalize.from_flow_alert("x", {})
    assert evt.symbol == "?"
    assert evt.premium == 0.0
    assert evt.opt_type == ""
    assert evt.spot is None
