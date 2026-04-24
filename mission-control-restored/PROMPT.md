You are building a Mission Control dashboard for an AI trading operation. This is a Next.js app with TypeScript, Tailwind CSS, and App Router (src/app directory). The app is already scaffolded with create-next-app. Build everything I describe below exactly.
DESIGN SYSTEM
Dark theme. Think Linear / Vercel dashboards but for trading.
Color tokens (use these exact hex values everywhere):

bg: #0a0a0f (page background)
bgCard: #111118 (card background)
bgCardHover: #16161f (card hover)
bgSurface: #1a1a24 (surface panels)
bgSurfaceAlt: #0f0f17 (sidebar, header)
border: #1e1e2a (default borders)
borderLight: #2a2a3a (hover borders)
text: #e8e8ed (primary text)
textMuted: #8b8b9e (secondary text)
textDim: #5c5c72 (tertiary/dim text)
accent: #6c5ce7 (primary accent purple)
accentLight: #a29bfe (light accent)
green: #00d2a0 (success, bullish, active)
red: #ff4757 (danger, bearish, rejected)
amber: #ffa502 (warning, pending, idle)
blue: #3498ff (info, stocks)
cyan: #00cec9 (crypto accent)

Fonts:

Monospace: 'JetBrains Mono', 'SF Mono', 'Fira Code', monospace — for data, numbers, codes, timestamps
Sans: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif — for body text, labels, descriptions

Put these in a shared constants file at src/lib/constants.ts.
TAILWIND CONFIG
Extend tailwind.config.ts to include all the color tokens above as custom colors so they can be used as Tailwind classes (e.g., bg-mc-bg, text-mc-text, border-mc-border, etc. — prefix them all with "mc-"). Also add the font families as fontFamily entries.
GLOBAL STYLES
In src/app/globals.css, import JetBrains Mono from Google Fonts. Set body background to #0a0a0f, color to #e8e8ed, font-family to the sans stack. Remove all default Next.js styles. Make sure scrollbars are styled dark (thin, dark track, accent thumb).
FOLDER STRUCTURE
src/
  app/
    layout.tsx          — root layout with metadata, fonts, global styles
    page.tsx            — renders the MissionControl component
    globals.css         — dark global styles + font import
  components/
    layout/
      Sidebar.tsx       — collapsible sidebar navigation
      Header.tsx        — top header bar with page title, live clock, status
      AppShell.tsx      — combines sidebar + header + content area
    ui/
      Card.tsx          — reusable dark card with hover state
      MetricCard.tsx    — metric display card (label, value, subtitle)
      Badge.tsx         — small colored badge/pill
      StatusDot.tsx     — colored dot indicator (active/idle/offline)
      ProgressBar.tsx   — thin progress bar
      SignalBar.tsx     — signal strength indicator (bar + number)
      TrendArrow.tsx    — colored directional arrow (bullish/bearish/neutral)
      SectionHeader.tsx — section title with optional action button
    pages/
      DashboardPage.tsx
      ScannerPage.tsx
      TasksPage.tsx
      AgentsPage.tsx
      ApprovalsPage.tsx
      CalendarPage.tsx
      ProjectsPage.tsx
      MemoryPage.tsx
      DocsPage.tsx
      WalletsPage.tsx
      ActivityPage.tsx
      RiskPage.tsx
  lib/
    constants.ts        — color tokens, font stacks
    mock-data.ts        — ALL mock data in one file
    types.ts            — TypeScript interfaces for all data models
NAVIGATION / SIDEBAR
The sidebar has these items in this exact order. Each has an icon from lucide-react:

Dashboard — LayoutDashboard icon
Scanner — Radar icon
Tasks — ListTodo icon
Agents — Bot icon
Approvals — CheckCircle icon
Calendar — Calendar icon
Projects — FolderKanban icon
Memory — Brain icon
Docs — FileText icon
Wallets — Wallet icon
Activity — Activity icon
Risk — ShieldAlert icon

The sidebar:

Defaults to 200px wide, collapsible to 56px by clicking the logo area
Has a gradient purple "M" logo square at top with "MISSION CTRL" text in monospace
Shows notification badges on Scanner (count of "new" status signals) and Approvals (count of "pending" status)
Active item has subtle purple background (#6c5ce715) and accentLight text
Inactive items are textMuted color
Sidebar background is bgSurfaceAlt (#0f0f17) with border-right
Footer shows "v0.1.0 MVP" when expanded

Navigation is CLIENT-SIDE state only (useState), not file-based routing. The entire app is a single page that swaps content based on which sidebar item is active.
HEADER

Shows current page title on the left (16px, font-weight 600)
Shows a green pulsing dot + "LIVE" text + real-time clock (updates every second) on the right
Background is bgSurfaceAlt with border-bottom

MOCK DATA (src/lib/mock-data.ts)
Create all of this mock data. I need the exact structure:
Agents (5 agents):
{ id: 1, name: "ALPHA-1", role: "Scanner Lead", status: "active", task: "Running RSI scan on BTC/USDT", lastAction: "Signal detected: BTC oversold on 4H", confidence: 0.92, uptime: "99.7%" }
{ id: 2, name: "BETA-2", role: "Risk Analyst", status: "active", task: "Monitoring portfolio exposure", lastAction: "Adjusted stop-loss on ETH position", confidence: 0.88, uptime: "99.9%" }
{ id: 3, name: "GAMMA-3", role: "Execution", status: "idle", task: "Awaiting approved trades", lastAction: "Executed AAPL limit order", confidence: 0.95, uptime: "98.2%" }
{ id: 4, name: "DELTA-4", role: "Intelligence", status: "active", task: "Parsing Fed minutes", lastAction: "Updated macro outlook model", confidence: 0.84, uptime: "97.5%" }
{ id: 5, name: "EPSILON-5", role: "Memory Manager", status: "idle", task: "Indexing daily journal", lastAction: "Stored 3 new trade insights", confidence: 0.91, uptime: "99.1%" }
Scanner Results (8 signals):
{ id: 1, symbol: "BTC/USDT", asset: "Crypto", timeframe: "4H", price: 67842.50, trend: "bullish", strength: 94, source: "RSI Scanner", time: "2m ago", status: "new", reasoning: "RSI crossed above 30 from oversold territory. Volume confirmation with 2.3x average. MACD histogram turning positive." }
{ id: 2, symbol: "ETH/USDT", asset: "Crypto", timeframe: "1H", price: 3521.80, trend: "bullish", strength: 87, source: "MACD Signal", time: "5m ago", status: "new", reasoning: "MACD line crossed above signal line. Bullish divergence confirmed on 1H timeframe. Supporting volume increase." }
{ id: 3, symbol: "AAPL", asset: "Stock", timeframe: "1D", price: 198.45, trend: "neutral", strength: 62, source: "EMA/SMA Trend", time: "12m ago", status: "reviewing", reasoning: "50 EMA approaching 200 SMA. Potential golden cross forming. Wait for confirmation before entry." }
{ id: 4, symbol: "SOL/USDT", asset: "Crypto", timeframe: "15m", price: 142.30, trend: "bullish", strength: 91, source: "Breakout Scanner", time: "1m ago", status: "new", reasoning: "Price broke above descending wedge resistance at $141.50. Volume spike 3.1x average. Strong momentum." }
{ id: 5, symbol: "NVDA", asset: "Stock", timeframe: "4H", price: 875.20, trend: "bullish", strength: 78, source: "Momentum Scanner", time: "18m ago", status: "reviewing", reasoning: "Strong momentum following earnings beat. RSI at 68, not yet overbought. Sector rotation favoring tech." }
{ id: 6, symbol: "TSLA", asset: "Stock", timeframe: "1D", price: 245.60, trend: "bearish", strength: 72, source: "Bollinger Bands", time: "22m ago", status: "dismissed", reasoning: "Price touched upper Bollinger Band with declining volume. Potential reversal signal. Watch for confirmation." }
{ id: 7, symbol: "AVAX/USDT", asset: "Crypto", timeframe: "1H", price: 38.75, trend: "bullish", strength: 83, source: "Volume Spike", time: "8m ago", status: "new", reasoning: "Unusual volume spike detected - 4.2x 20-period average. Price holding above VWAP. Accumulation pattern." }
{ id: 8, symbol: "MSFT", asset: "Stock", timeframe: "1D", price: 415.80, trend: "neutral", strength: 55, source: "RSI Scanner", time: "30m ago", status: "reviewing", reasoning: "RSI at midline (50). Price consolidating near all-time highs. Await directional break." }
Approvals (4 proposals):
{ id: 1, symbol: "BTC/USDT", type: "Long", entry: 67500, target: 71000, stop: 66200, risk: "1.2%", reasoning: "Oversold bounce with volume confirmation. Risk/reward 2.7:1. Aligns with macro thesis.", agent: "ALPHA-1", time: "3m ago", status: "pending" }
{ id: 2, symbol: "SOL/USDT", type: "Long", entry: 142.00, target: 155.00, stop: 138.50, risk: "0.8%", reasoning: "Breakout trade. Strong momentum. Multiple timeframe alignment.", agent: "ALPHA-1", time: "5m ago", status: "pending" }
{ id: 3, symbol: "AAPL", type: "Long", entry: 197.50, target: 210.00, stop: 193.00, risk: "1.5%", reasoning: "Golden cross forming. Earnings catalyst upcoming. Sector strength.", agent: "DELTA-4", time: "15m ago", status: "approved" }
{ id: 4, symbol: "TSLA", type: "Short", entry: 248.00, target: 230.00, stop: 255.00, risk: "2.0%", reasoning: "Bollinger Band reversal. Declining momentum. Overextended rally.", agent: "BETA-2", time: "25m ago", status: "rejected" }
Tasks (Kanban, 4 columns):
backlog: [
  { id: "T-007", title: "Analyze DXY correlation", priority: "medium", agent: "DELTA-4" },
  { id: "T-008", title: "Backtest momentum strategy", priority: "low", agent: "Unassigned" }
]
inProgress: [
  { id: "T-003", title: "BTC 4H RSI analysis", priority: "high", agent: "ALPHA-1" },
  { id: "T-004", title: "Portfolio rebalance calc", priority: "high", agent: "BETA-2" }
]
review: [
  { id: "T-005", title: "SOL breakout trade plan", priority: "high", agent: "ALPHA-1" }
]
done: [
  { id: "T-001", title: "AAPL golden cross alert", priority: "medium", agent: "GAMMA-3" },
  { id: "T-002", title: "Fed minutes parsing", priority: "high", agent: "DELTA-4" }
]
Activity Feed (9 entries):
{ time: "14:32:01", agent: "ALPHA-1", action: "Signal detected", detail: "BTC/USDT RSI oversold on 4H - strength 94", type: "signal" }
{ time: "14:31:45", agent: "BETA-2", action: "Risk check passed", detail: "BTC long proposal within limits - 1.2% risk", type: "risk" }
{ time: "14:30:12", agent: "ALPHA-1", action: "Signal detected", detail: "SOL/USDT breakout above $141.50", type: "signal" }
{ time: "14:28:33", agent: "DELTA-4", action: "Intelligence update", detail: "Fed minutes suggest dovish pivot - updated macro model", type: "intel" }
{ time: "14:25:00", agent: "GAMMA-3", action: "Order executed", detail: "AAPL limit buy filled at $197.50 - 50 shares", type: "execution" }
{ time: "14:22:17", agent: "EPSILON-5", action: "Memory stored", detail: "Saved insight: BTC historically rallies post-Fed dovish signals", type: "memory" }
{ time: "14:20:00", agent: "BETA-2", action: "Alert triggered", detail: "Portfolio exposure approaching 65% limit", type: "risk" }
{ time: "14:15:30", agent: "ALPHA-1", action: "Scan complete", detail: "Crypto scanner cycle finished - 3 new signals", type: "system" }
{ time: "14:10:00", agent: "System", action: "Heartbeat", detail: "All agents operational - latency 12ms", type: "system" }
Calendar (8 daily schedule items):
{ time: "06:00", name: "Pre-market scan", status: "completed", type: "scan" }
{ time: "06:30", name: "Overnight positions review", status: "completed", type: "review" }
{ time: "09:30", name: "Market open monitoring", status: "completed", type: "monitor" }
{ time: "12:00", name: "Midday review & rebalance", status: "active", type: "review" }
{ time: "14:00", name: "Afternoon scan cycle", status: "active", type: "scan" }
{ time: "16:00", name: "Market close analysis", status: "upcoming", type: "review" }
{ time: "18:00", name: "Evening summary & journal", status: "upcoming", type: "report" }
{ time: "20:00", name: "Overnight strategy prep", status: "upcoming", type: "scan" }
Also include recurring jobs data:
[
  { name: "Scanner heartbeat", interval: "Every 30s", status: "running" },
  { name: "Risk monitor", interval: "Every 1m", status: "running" },
  { name: "Portfolio sync", interval: "Every 5m", status: "running" },
  { name: "Memory index", interval: "Every 1h", status: "running" }
]
Projects (5 projects):
{ name: "Mission Control", progress: 72, status: "active", tasks: 24, completed: 17 }
{ name: "Strategy Engine", progress: 45, status: "active", tasks: 18, completed: 8 }
{ name: "Risk Engine", progress: 88, status: "active", tasks: 12, completed: 11 }
{ name: "Execution System", progress: 60, status: "active", tasks: 15, completed: 9 }
{ name: "Intelligence System", progress: 35, status: "building", tasks: 20, completed: 7 }
Memory (4 journal entries):
{ date: "Mar 23", title: "BTC post-Fed rally pattern", content: "Historically, BTC rallies 8-12% within 2 weeks of dovish Fed signals. Current setup mirrors Dec 2023.", tags: ["btc", "macro", "pattern"] }
{ date: "Mar 22", title: "SOL breakout levels", content: "Key resistance at $155, support at $135. Volume profile shows accumulation zone $138-142.", tags: ["sol", "levels"] }
{ date: "Mar 21", title: "Portfolio heat map insight", content: "Crypto exposure > 60% triggers drawdown risk. Optimal allocation: 55% crypto, 35% equities, 10% cash.", tags: ["risk", "allocation"] }
{ date: "Mar 20", title: "NVDA earnings correlation", content: "NVDA earnings beats correlate with 3-day sector momentum in semis. Use as leading indicator.", tags: ["nvda", "earnings", "correlation"] }
Documents (5 docs):
{ title: "Q1 Trading Playbook", type: "Strategy", updated: "Mar 20", pages: 12 }
{ title: "Risk Management Framework", type: "Policy", updated: "Mar 18", pages: 8 }
{ title: "Scanner Configuration Guide", type: "Technical", updated: "Mar 22", pages: 5 }
{ title: "Weekly Market Report #12", type: "Research", updated: "Mar 23", pages: 6 }
{ title: "Backtesting Results: Momentum v2", type: "Research", updated: "Mar 19", pages: 15 }
Wallets (3 wallets):
{ name: "Main Trading", type: "Crypto", balance: 142580.50, change: 3.2, positions: 5 }
{ name: "Brokerage", type: "Equities", balance: 89340.20, change: 1.1, positions: 8 }
{ name: "Reserve", type: "Stables", balance: 50000.00, change: 0.0, positions: 1 }
Risk data:
{
  exposure: 62,
  limit: 75,
  drawdown: -2.4,
  sharpe: 1.82,
  maxPosition: 15,
  openPositions: 13,
  alerts: [
    { level: "warning", message: "Portfolio exposure approaching 65% threshold" },
    { level: "info", message: "Volatility index elevated - consider reducing position sizes" }
  ]
}
Active Trades (for dashboard):
[
  { symbol: "AAPL", side: "LONG", entry: 197.50, current: 198.45, pnl: "+0.48%" },
  { symbol: "BTC/USDT", side: "LONG", entry: 66800, current: 67842.50, pnl: "+1.56%" },
  { symbol: "ETH/USDT", side: "LONG", entry: 3480, current: 3521.80, pnl: "+1.20%" }
]
PAGE SPECIFICATIONS
1. DASHBOARD PAGE
Top: Green pulsing dot + "ALL SYSTEMS OPERATIONAL" text + "Latency: 12ms"
Row of 4 MetricCards:

Active agents: "3/5", sub: "All agents healthy", color: green
Pending approvals: "2", sub: "2 high priority", color: amber
New signals: "4", sub: "Last scan: 2m ago", color: accent
Portfolio value: "$282k", sub: "+$4.2k today", color: green

Below that: 2-column grid:

Left: "Active trades" card showing the 3 active trades with symbol, LONG/SHORT badge, current price, P&L percentage colored green/red
Right: "Recent activity" card showing latest 5 activity feed items with timestamp, action title, truncated detail

Bottom row: 3 cards:

Risk exposure: 62% / 75% limit with progress bar (amber when >60)
Sharpe ratio: 1.82 with "30-day rolling" subtitle
Today's drawdown: -2.4% in red with "Max allowed: -5%" subtitle

2. SCANNER PAGE (MOST IMPORTANT PAGE)
Top: Tab buttons for "All signals" / "Crypto" / "Stocks" — active tab has purple border/bg. On the right, a timeframe dropdown filter (All, 15m, 1H, 4H, 1D).
Below: Scanner results table. Column headers (small uppercase dim text):
SYMBOL | ASSET | TF | PRICE | TREND | STRENGTH | SOURCE | TIME | STATUS
Each row is a hoverable card. Data displays:

Symbol: monospace, bold, white
Asset: Badge (cyan for Crypto, blue for Stock)
TF: monospace, muted
Price: monospace, white, formatted with commas
Trend: colored arrow (green up for bullish, red down for bearish, amber right for neutral)
Strength: thin progress bar + number (green >=80, amber >=60, dim otherwise)
Source: small monospace muted
Time: dim text
Status: Badge (green "new", amber "reviewing", dim "dismissed")

Clicking a row EXPANDS it to show:

"Signal reasoning" label
The reasoning text in regular sans font
Two buttons: "Send to tasks" (green border) and "Dismiss" (gray border)

Bottom: Dashed-border card showing "Active scanners" with badges for: RSI, MACD, EMA/SMA, Bollinger, Volume, Breakout, Momentum. Below that, dim text: "Modular architecture — add TradingView webhooks, external APIs, custom quant scanners"
Results should be sorted by strength (highest first) by default, and filtered by tab + timeframe.
3. TASKS PAGE
4-column Kanban board. Columns: Backlog (dim dot), In progress (blue dot), Review (amber dot), Done (green dot).
Each column header: colored dot + column name + item count.
Each task card: task ID in dim monospace, priority dot (red=high, amber=medium, dim=low), title in sans bold, agent name in dim monospace.
4. AGENTS PAGE
Vertical stack of agent cards. Each card:

Left: 40x40 rounded square with agent initial + number on purple bg
Agent name (monospace bold) + StatusDot + status badge
Role in muted text
"Task:" label + current task
"Last:" label + last action
Right side: Confidence percentage (large monospace number, green if >90%, amber otherwise) + uptime below

5. APPROVALS PAGE
Vertical stack. Each approval card has a 3px colored left border (amber=pending, green=approved, red=rejected) with border-radius only on right side.
Shows: symbol (large monospace) + Long/Short badge + status badge
Below: entry price, target price (green), stop price (red), risk (amber) in a flex row
Below: reasoning text
Below: agent name + time in dim
If status is "pending": show Approve (green) and Reject (red) buttons on the right. Clicking them should update the status in state.
6. CALENDAR PAGE
Title: "March 23, 2026 — Daily schedule"
Each schedule item is a row:

Time (monospace dim, 50px min-width)
Status icon (checkmark=completed, play=active, circle=upcoming) in status color
Name in sans
Status badge + type badge
Active items have subtle purple background + 2px purple left border

Below: "Recurring jobs" card with a 2-column grid of job items showing name, interval, and active StatusDot.
7. PROJECTS PAGE
Stack of hoverable cards. Each:

Project name (sans bold) + status badge (green "active" or amber "building")
Large percentage number on the right, colored by progress (green >75, amber >50, muted otherwise)
Progress bar spanning full width below
"X/Y tasks completed" in dim text

8. MEMORY PAGE
Search input at top: full width, dark bg, border, monospace placeholder "Search memories..."
Filtered list of memory cards. Each:

Title (sans bold) + date (dim monospace, right-aligned)
Content paragraph in muted text
Tags as gray badges at bottom

Search filters by title and tags (case insensitive).
9. DOCS PAGE
Stack of hoverable cards. Each:

Left: 36x36 rounded icon square colored by type (accent=Strategy, amber=Policy, blue=Technical, green=Research) with file icon
Title (sans medium) + type/page count in dim monospace
Right: updated date in dim monospace

10. WALLETS PAGE
Top card: "Total portfolio value" label, large formatted dollar amount ($281,920.70), green change text (+$4,218.40 today (+1.52%))
Below: Stack of wallet cards. Each:

Name (sans bold) + type badge (cyan=Crypto, blue=Equities, green=Stables)
Positions count in dim
Right side: large balance + change percentage colored green/red

11. ACTIVITY PAGE
Vertical feed. Each entry:

Left column: timestamp (dim monospace) + colored dot (signal=accent, risk=amber, intel=blue, execution=green, memory=cyan, system=dim)
Right: agent name (accentLight monospace) + action title (sans white) + type badge
Detail text in muted sans below
First/newest entry has subtle accent background

12. RISK PAGE
Top: 4 MetricCards in a row:

Exposure: 62% (amber), sub: "Limit: 75%"
Drawdown: -2.4% (red), sub: "Max: -5%"
Sharpe ratio: 1.82 (green), sub: "30d rolling"
Open positions: 13, sub: "Max: 15"

"Risk exposure" card: large progress bar (62/75) with percentage display. Below: 3-column grid showing Crypto (38%, cyan), Equities (18%, blue), Cash (6%, green) each with their own mini progress bar.
"Active alerts" section: cards with 3px left border (amber=warning, blue=info) + level badge + message text.
REUSABLE COMPONENTS SPECS
Card

background: bgCard (#111118)
border: 1px solid border (#1e1e2a)
borderRadius: 10px
padding: 16px
Optional: hover prop that changes bg to bgCardHover and border to borderLight on mouse enter

MetricCard

Uses Card as base
Top: 11px uppercase monospace label in textDim, letter-spacing 1px
Middle: 26px bold monospace value, custom color
Bottom (optional): 12px monospace subtitle in textMuted

Badge

fontSize: 11px, monospace
padding: 2px 8px
borderRadius: 4px
background: color at 10% opacity (append "18" to hex)
text: the color itself
fontWeight: 500, letterSpacing: 0.3px

StatusDot

7px circle
green (#00d2a0) for "active" with box-shadow glow
amber (#ffa502) for "idle"
dim (#5c5c72) for offline/other

ProgressBar

Full width container, custom height (default 4px), bgSurface background with 0a opacity text
Inner fill bar with custom color, border-radius matching height/2
Width is value/max * 100%

SignalBar

Flex row: 50px wide progress bar + strength number
Color: green if >=80, amber if >=60, dim otherwise

TrendArrow

"↑" green for bullish, "↓" red for bearish, "→" amber for neutral
fontWeight: 600

SectionHeader

Flex row, space-between
Left: 15px sans bold title
Right: optional action button (12px monospace, accent text, border, rounded)

CRITICAL REQUIREMENTS

The entire app must be client-side navigation using useState — do NOT create multiple route files. One page.tsx that renders AppShell which swaps page content.
Add "use client" to all component files that use hooks or interactivity.
All number formatting must use toLocaleString() for prices/balances.
The Approvals page must have working approve/reject that updates local state.
The Scanner page must have working tab filtering, timeframe filtering, and row expansion.
The Memory page must have working search filtering.
The sidebar must be collapsible with working toggle.
The header clock must tick every second.
Scanner badges on sidebar must show count of "new" status signals.
Approval badges must show count of "pending" status approvals.
Every file must have proper TypeScript types — create interfaces in types.ts.
DO NOT use any API routes or server components for data — everything reads from mock-data.ts.
Make sure npm run dev works on localhost:3000 with zero errors.

Build every file. Do not skip any component. Do not leave any placeholder TODOs. Build it all completely.
