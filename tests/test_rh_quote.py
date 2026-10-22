import sys, unittest
from pathlib import Path
sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from lib import rh_quote  # noqa: E402

UND = "11111111-1111-1111-1111-111111111111"
IID = "22222222-2222-2222-2222-222222222222"


class R:
    def __init__(self, d, code=200): self.d, self.status_code = d, code
    def json(self): return self.d


class Fake:
    def __init__(self, md): self.md, self.urls = md, []
    def get(self, url, params=None, **kw):
        path = url.replace(rh_quote.BASE, ""); self.urls.append(path)
        if path == "instruments/":
            return R({"results": [{"symbol": "SPY", "tradable_chain_id": UND}]})
        if path == "options/instruments/":
            return R({"results": [{"id": IID, "chain_symbol": "SPY", "expiration_date": "2026-10-16",
                                   "strike_price": "700.0000", "type": "call", "trade_value_multiplier": "100.0000"}]})
        if path == "marketdata/options/":
            return R({"results": [self.md]})
        if path == f"marketdata/options/historicals/{IID}/":
            self.params = params
            return R({"previous_close_price": "3.45", "data_points": getattr(self, "points", [])})
        return R({}, 404)


def md(**kw):
    d = {"instrument": rh_quote.BASE + "options/instruments/" + IID + "/", "bid_price": "5.10",
         "ask_price": "5.30", "last_trade_price": "5.20", "quote_updated_at": "2026-10-07T14:30:15Z"}
    d.update(kw); return d


class T(unittest.TestCase):
    def setUp(self): rh_quote._ID_CACHE.clear()

    def test_ok(self):
        s = Fake(md()); q = rh_quote.rh_quotes(["SPY261016C00700000"], session=s)["SPY261016C00700000"]
        self.assertEqual((q["bid"], q["ask"], q["mid"], q["source"]), (5.10, 5.30, 5.20, "robinhood"))
        self.assertTrue(q["as_of_et"].startswith("2026-10-07 10:30:15"))
        self.assertTrue(set(s.urls) <= rh_quote._ALLOWED)

    def test_no_timestamp_or_no_ask_is_absent(self):
        self.assertEqual(rh_quote.rh_quotes(["SPY261016C00700000"], session=Fake(md(quote_updated_at=None, updated_at=None))), {})
        rh_quote._ID_CACHE.clear()
        self.assertEqual(rh_quote.rh_quotes(["SPY261016C00700000"], session=Fake(md(ask_price=None))), {})

    def test_bad_occ_and_unknown_contract(self):
        self.assertEqual(rh_quote.rh_quotes(["junk"], session=Fake(md())), {})
        self.assertEqual(rh_quote.rh_quotes(["SPY261016C00999000"], session=Fake(md())), {})

class OpenInterest(unittest.TestCase):
    def setUp(self): rh_quote._ID_CACHE.clear()

    def test_oi_without_bid_ask_and_dated(self):
        s = Fake(md(bid_price=None, ask_price=None, open_interest=1234, previous_close_date="2026-10-21"))
        self.assertEqual(rh_quote.rh_open_interest(["SPY261016C00700000"], session=s),
                         {"SPY261016C00700000": {"oi": 1234, "as_of_date": "2026-10-21", "source": "robinhood"}})
        self.assertTrue(set(s.urls) <= rh_quote._ALLOWED)

    def test_missing_oi_is_named(self):
        d = {}
        self.assertEqual(rh_quote.rh_open_interest(["SPY261016C00700000"], session=Fake(md()), diag=d), {})
        self.assertEqual(d, {"SPY261016C00700000": "no open_interest in the marketdata row"})

    def test_quotes_carry_oi(self):
        q = rh_quote.rh_quotes(["SPY261016C00700000"], session=Fake(md(open_interest="77")))["SPY261016C00700000"]
        self.assertEqual(q["open_interest"], 77)


class Diag(unittest.TestCase):
    """2026-10-22: a missing contract says why (the scalp card logs it instead of a silent Alpaca fallback)."""
    def setUp(self): rh_quote._ID_CACHE.clear(); rh_quote._LAST_HTTP.clear()

    def test_reasons(self):
        d = {}
        rh_quote.rh_quotes(["junk", "SPY261016C00999000"], session=Fake(md()), diag=d)
        self.assertEqual(d["junk"], "not an OCC symbol")
        self.assertTrue(d["SPY261016C00999000"].startswith("instrument lookup failed"))
        d = {}
        rh_quote.rh_quotes(["SPY261016C00700000"], session=Fake(md(ask_price=None)), diag=d)
        self.assertIn("no usable bid/ask", d["SPY261016C00700000"])

    def test_http_status_is_named(self):
        class Unauth(Fake):
            def get(self, url, params=None, **kw):
                return R({}, 401)
        d = {}
        self.assertEqual(rh_quote.rh_quotes(["SPY261016C00700000"], session=Unauth(md()), diag=d), {})
        self.assertEqual(d["SPY261016C00700000"], "instrument lookup failed (HTTP 401)")


def pt(d, o, h, l, c, interp=False):
    return {"begins_at": d, "open_price": o, "high_price": h, "low_price": l, "close_price": c, "volume": 0, "interpolated": interp}


class Bars(unittest.TestCase):
    def setUp(self): rh_quote._ID_CACHE.clear()

    def test_daily_bars_drop_interpolated_and_stamp_session_close(self):
        s = Fake(md()); s.points = [pt("2025-10-21T00:00:00Z", "0.01", "0.01", "0.01", "0.01", True),
                                    pt("2026-10-15T00:00:00Z", "2.0", "3.9", "1.96", "3.45")]
        b = rh_quote.rh_option_bars("SPY261016C00700000", "day", "year", session=s, now=2e9)
        self.assertIsNone(b["error"]); self.assertEqual(len(b["bars"]), 1); self.assertEqual(b["interpolated_dropped"], 1)
        self.assertEqual(b["bars"][0]["c"], 3.45); self.assertEqual(b["prev_close"], 3.45)
        self.assertEqual(b["as_of_et"], "2026-10-15 16:00 ET")
        self.assertEqual(s.params, {"interval": "day", "span": "year"})

    def test_five_minute_as_of_is_bar_end_capped_at_now(self):
        s = Fake(md()); s.points = [pt("2026-10-15T19:55:00Z", "4.18", "4.23", "4.18", "4.23")]
        t0 = rh_quote._epoch("2026-10-15T19:55:00Z")
        b = rh_quote.rh_option_bars("SPY261016C00700000", "5minute", "day", session=s, now=t0 + 120)
        self.assertEqual(b["as_of"], t0 + 120)

    def test_fails_closed(self):
        s = Fake(md())
        self.assertIn("unsupported", rh_quote.rh_option_bars("SPY261016C00700000", "day", "day", session=s)["error"])
        self.assertIn("bad OCC", rh_quote.rh_option_bars("NOPE", session=s)["error"])
        s.points = [pt("2025-10-21T00:00:00Z", "0.01", "0.01", "0.01", "0.01", True)]
        b = rh_quote.rh_option_bars("SPY261016C00700000", session=s)
        self.assertEqual(b["bars"], []); self.assertIn("no traded bars", b["error"])

    def test_allowlist_rejects_other_paths(self):
        with self.assertRaises(ValueError):
            rh_quote._get(Fake(md()), "t", "marketdata/options/historicals/not-a-uuid/", {})
        with self.assertRaises(ValueError):
            rh_quote._get(Fake(md()), "t", "orders/", {})


if __name__ == "__main__":
    unittest.main()
