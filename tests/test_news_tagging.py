"""lib.news ticker tags (2026-10-07 TG audit): a multi-ticker roundup must not be tagged with a ticker the
headline never names ("[INTC] Marvell Stock Rallies..." in the 10-06 digest)."""
import sys
import unittest
from pathlib import Path
from unittest import mock

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from lib import news  # noqa: E402

NAMES = {'INTC': {'title': 'INTEL CORP'}, 'MRVL': {'title': 'MARVELL TECHNOLOGY, INC.'},
         'AMD': {'title': 'ADVANCED MICRO DEVICES INC'}, 'NVDA': {'title': 'NVIDIA CORP'}}


class TagTests(unittest.TestCase):
    def setUp(self):
        p = mock.patch.object(news, '_NAMES', NAMES); p.start(); self.addCleanup(p.stop)

    def test_roundup_not_tagged_with_unnamed_requested_ticker(self):
        t = news._tag(['INTC', 'MRVL', 'AMD', 'NVDA'], {'INTC'}, 'Marvell Stock Rallies as Investor Day Targets Smash Estimates')
        self.assertEqual(t, 'MRVL')

    def test_ticker_symbol_in_headline(self):
        self.assertEqual(news._tag(['INTC', 'AMD', 'NVDA'], {'AMD'}, 'AMD’s Monster 2026 Rally Gets Fresh Fuel'), 'AMD')

    def test_single_ticker_article_keeps_requested_tag(self):
        self.assertEqual(news._tag(['INTC'], {'INTC'}, 'Chipmaker shares rise on new fab plan'), 'INTC')

    def test_unnamed_roundup_is_market_wide(self):
        self.assertEqual(news._tag(['INTC', 'MRVL', 'AMD'], {'INTC'}, 'Chip stocks rally into the close'), '')

    def test_only_filter_drops_other_tickers(self):
        items = [dict(ticker='MRVL', headline='Marvell rallies', source='x', url='', epoch=news._now()),
                 dict(ticker='INTC', headline='Intel wins order', source='x', url='', epoch=news._now())]
        with mock.patch.object(news, 'recent_headlines', return_value=items):
            out = news.headlines_block(['INTC'], title='T', only=True)
        self.assertIn('Intel wins order', out)
        self.assertNotIn('Marvell', out)
        with mock.patch.object(news, 'recent_headlines', return_value=items[:1]):
            self.assertEqual(news.headlines_block(['INTC'], title='T', only=True), '')


if __name__ == '__main__':
    unittest.main()
