"""macro_calendar_alert carries no size advice (R32; eval 10-23: "size down spec names before it" daily to 10-23).
Renders through render() — the function the 08:00 / 17:00 crons send — with the real 10-23 events and with none.
No send."""
import datetime as dt
import importlib.util
import re
import sys
from pathlib import Path

P = Path.home() / "scripts" / "macro_calendar_alert.py"
sys.path.insert(0, str(P.parent))
SIZE_RX = re.compile(r"\bsize\s+(?:down|up)|\bover-?deploy|\bhalf[- ]size|\bposition[- ]?siz|\btrim\b", re.I)


def load():
    spec = importlib.util.spec_from_file_location("macro_cal_t", P)
    m = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(m)
    return m


def test_real_card_has_no_size_advice():
    m = load()
    today = dt.date(2026, 10, 23)
    ev = [{"date": dt.date(2026, 10, 27), "tag": "💵 Earnings", "event": "SOFI earnings pre-mkt", "impact": "High"},
          {"date": dt.date(2026, 10, 28), "tag": "🏛️ FOMC", "event": "FOMC decision + dot-plot + Powell ~2:00 PM ET",
           "impact": "High"}]
    msg, _ = m.render(today, ev, False)
    assert "SOFI earnings pre-mkt" in msg and "FOMC decision" in msg
    assert SIZE_RX.search(msg) is None, msg
    assert msg.rstrip().endswith("<i>Heads-up only.</i>")
    assert "MACRO / EVENT RADAR" in msg


def test_negative_old_footer_would_fail():
    assert SIZE_RX.search("Heads-up only. Don't over-deploy into a high-impact event; size down spec names before it.")
