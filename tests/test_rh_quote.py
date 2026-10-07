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


if __name__ == "__main__":
    unittest.main()
