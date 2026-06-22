export const meta = {
  name: 'trade-chart-builders',
  description: 'Build the remaining trade-chart generators (GEX, max-pain, repeat-flow, earnings-EM, breadth, volume-profile, net-worth)',
  phases: [{ title: 'Build' }],
}

const PATTERN = `
SHARED PATTERN (follow exactly — the foundation already works):
- Dir: /home/itsju/05_AUTOMATION/scripts/trade_charts/ . Create your file THERE. Python: /home/itsju/.venv/bin/python.
- At top: \`import sys; from pathlib import Path; sys.path.insert(0, str(Path(__file__).resolve().parent.parent))\`
  then \`import chartlib\` and \`import deliver\`.
- chartlib gives: \`chartlib.fetch(ticker, period="6mo", interval="1d")\` -> OHLCV DataFrame; \`chartlib.STYLE\`
  (mplfinance dark style); \`chartlib.OUT\` (Path to save PNGs); \`chartlib.BG = "#0d1117"\`. Match the dark theme
  (facecolor #0d1117, text #c9d1d9, green #3fb950, red #f85149, grid #21262d). NO emojis inside matplotlib
  titles (font lacks them) — emojis only in the Discord/TG caption text.
- Deliver with: \`deliver.post_chart(channel, png_path, caption, dry=args.dry)\` -> (discord_ok, tg_ok).
  It posts to BOTH Discord (SynthControl bot) and Telegram (trading chat) automatically.
- Add argparse: --channel (default as specified), --dry, plus any natural args. Read-only on all data.
- Flow data (READ ONLY, never modify): /home/itsju/trading/signals/option-scraper/data/flow_alerts_today.json
  = dict of {alert:{Symbol,Strike,OptionType,Expiry(epoch),DTE,OI,Volume,SWEEPS,BLOCKS,isBullish,AlertPrice,UnderlyingType}}.
- yfinance is available (chains: \`yf.Ticker(t).option_chain(expiry)\` -> .calls/.puts with strike,openInterest,
  impliedVolatility,bid,ask,lastPrice). After-hours bid/ask=0 and IV=0 — derive IV from price or note it.

VERIFY before returning: run \`python3 -m py_compile <file>\`, then run it once with \`--dry\` (must render a PNG into
chartlib.OUT with no error), THEN do ONE real run (no --dry) to confirm dual-delivery prints discord=✓ tg=✓.
Report exactly what you built, the channel, how verified, and a suggested cron time (ET, market hours).`

const SCHEMA = {
  type: 'object',
  required: ['name', 'file', 'status', 'channel', 'verified', 'cron', 'notes'],
  properties: {
    name: { type: 'string' }, file: { type: 'string' },
    status: { type: 'string', enum: ['built', 'partial', 'failed'] },
    channel: { type: 'string' }, verified: { type: 'string' },
    cron: { type: 'string', description: 'suggested crontab line (ET)' },
    notes: { type: 'string' },
  },
}

const TASKS = [
  { label: 'gex_chart', body: `Build gex_chart.py -> channel "gamma-levels". Dealer GAMMA EXPOSURE (GEX) by strike.
For a ticker (default SPY; also accept tickers as args / --from-flow top names): pull the nearest monthly
option chain, compute per-strike gamma via Black-Scholes (r=0, use IV from chain or derive), GEX_strike =
gamma * OI * 100 * spot^2 * 0.01, with calls +, puts - (dealer-short-gamma convention). Bar chart of GEX by
strike, mark spot and the GAMMA FLIP (zero-cross of cumulative GEX). Caption: net GEX sign + flip level +
regime ("negative GEX = dealers amplify moves / momentum" vs "positive = suppress / mean-revert"). Default --channel gamma-levels.` },
  { label: 'max_pain', body: `Build max_pain.py -> channel "gamma-levels". MAX PAIN per expiry. For a ticker
(default SPY,QQQ + --from-flow top names): for the nearest monthly expiry, compute total dollar pain at each
strike = sum over calls of OI*max(0,strike_price-K) + puts OI*max(0,K-strike_price)... (standard max-pain:
the strike minimizing total in-the-money payout to holders). Plot the pain curve vs strike, mark the max-pain
strike (min pain) and current spot. Caption: max pain $X vs spot, "price magnet into OpEx". --channel gamma-levels.` },
  { label: 'repeat_flow', body: `Build repeat_flow.py -> channel "ta-charts". REPEAT/STACKING flow detector — the
highest-quality flow signal. From the flow JSON, group by (Symbol, OptionType/direction, Expiry) and count
repeat hits + sum premium (Volume*AlertPrice*100). Rank tickers/contracts with >=2 stacked same-direction hits
(institutions accumulating). Render a horizontal bar chart "stacking score" (hits x premium) for the top ~12,
green=bullish/red=bearish. Caption: top 3 stacked names + what stacking means. --channel ta-charts.` },
  { label: 'earnings_em', body: `Build earnings_em.py -> channel "earnings-radar". EARNINGS expected-move vs
HISTORICAL. For tickers with earnings in the next ~10 trading days (check yfinance .calendar for --from-flow top
names + a majors list AAPL,MSFT,NVDA,TSLA,AMZN,META,GOOGL,AMD,NFLX): implied expected move = ATM straddle of the
expiry just after earnings / spot; historical avg move = mean abs 1-day return over the last ~6 earnings dates
(approx from large daily gaps if exact dates unavailable). Render a grouped bar chart implied vs historical per
ticker; flag CHEAP (implied<historical -> buy straddle edge) vs RICH (implied>historical -> sell). Caption with
the cheap names. --channel earnings-radar.` },
  { label: 'breadth', body: `Build breadth.py -> channel "market-regime". MARKET BREADTH regime gauge. Use a
representative basket of ~40 large caps (hardcode a diversified list across sectors) as an S&P proxy: compute %
trading above their 200-day MA, and a simple advance/decline (today up vs down). Render a gauge/bar: % above
200MA with zones (<30 oversold/fear -> straddles cheap; >80 complacent). Caption: breadth reading + what it
means for trusting flow signals today. --channel market-regime.` },
  { label: 'volume_profile', body: `Build volume_profile.py -> channel "ta-charts". VOLUME PROFILE (VPVR) for
top flow tickers (--from-flow, default top 3; or tickers as args). Bin ~6 months of daily data by price level,
sum volume per bin, draw a horizontal volume-by-price histogram alongside the price line; mark POC (point of
control = highest-volume price), and high/low volume nodes. Caption: POC + "flow at a low-volume node runs fast,
at a high-volume node it stalls". --channel ta-charts.` },
  { label: 'networth', body: `Build networth.py -> channel "net-worth". NET-WORTH equity curve. COORDINATE: another
session owns bank autosync — do NOT touch bank files; only ADD a self-contained daily snapshot here. Pull Alpaca
paper equity for Boba + Jazzy via the Alpaca portfolio-history endpoint (keys in ~/scripts/keys/alpaca-boba-* and
alpaca-jazzy-*; base https://paper-api.alpaca.markets, GET /v2/account/portfolio/history?period=1A&timeframe=1D).
Append today's total to a snapshot file ~/.openclaw/workspace/charts/networth_history.json so the curve grows over
time. Render the cumulative equity curve (what data exists). RH/Coinbase real-money + true "since 2021" history
need live broker tokens (often expired) — if a token is missing/expired, SKIP that source gracefully and note it
in the caption ("RH/CB pending token"). --channel net-worth.` },
]

phase('Build')
const out = await parallel(
  TASKS.map((t) => () =>
    agent(`${t.body}\n${PATTERN}`, { label: t.label, phase: 'Build', schema: SCHEMA, agentType: 'general-purpose' })
      .then((r) => r || { name: t.label, file: '', status: 'failed', channel: '', verified: '', cron: '', notes: 'null' })
  )
)
log(`built ${out.filter((r) => r.status === 'built').length}/${TASKS.length}`)
return { builds: out }
