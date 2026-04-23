# Option Signals App — Help Center (Canonical Rules)

Source: official Option Signals mobile app Help Center.
Use this as the authoritative reference for all Option Flow tab logic.

## Sentiment mapping (row text color)

| Execution | Sentiment | Color |
|-----------|-----------|-------|
| CALL on ASK side (=A or >A) | BULLISH | GREEN (#66bb6a) |
| CALL on BID side (=B or >B) | BEARISH | RED (#ef5350) |
| PUT on ASK side (=A or >A) | BEARISH | RED (#ef5350) |
| PUT on BID side (=B or >B) | BULLISH | GREEN (#66bb6a) |

## Unusual flow (YELLOW border on SWP/BLK pill)

A SWEEP or BLOCK is deemed Unusual when Volume > OI.

## High-conviction flow (GOLDEN border on entire row — Mission Ctrl addition)

Flow Premium (Value) >= $1,000,000 = golden border on the grid row.
These two rules are INDEPENDENT — a row can have: neither, yellow pill only,
gold row only, or both.

## Flow Alerts categories

- Weekly Flow: contracts expiring within a week
- Repeating Flow: same trade executed multiple times, more ASK side flows, price rising
- Huge Flow: single SWEEP on ASK with premium > $1M
- Unusual Huge Flow: single Unusual SWEEP on ASK with premium > $500K

## Price postfix meanings

- =A : AT ASK
- >A : ABOVE ASK
- =B : AT BID
- >B : ABOVE BID

## Signal types (analyst signals, not flow)

- SWING: chart breakout/upward move, days or same-day
- SCALP: momentum, quick in/out
- LOTTO: like scalp but no stop, ride to 0 or sell targets
- HEDGE: cover longs during selling
- MULTI WEEK: swing but 3-6 weeks to target
