export const meta = {
  name: 'discord-feeder-fixes',
  description: 'Apply minimal reversible fixes to broken Discord feeder daemons (no trade-logic, no restarts)',
  phases: [{ title: 'Fix' }],
}

const GUARD = `
GUARDRAILS (non-negotiable):
- Make ONLY the minimal change that fixes the described bug. Preserve all other behavior.
- NEVER change trading logic (entry/exit/sizing/gates/decision cycles). You may only touch
  logging destinations, health-check config (process names/paths), webhook routing, empty-payload
  guards, and presentation. If the real fix needs trade-logic or broker changes, DO NOT edit —
  set status="staged", needs_go=true, and give the exact proposed change.
- DO NOT restart/start/stop any pm2 process or daemon, and DO NOT edit crontab. If a restart or
  cron change is needed for the fix to take effect, set needs_restart with the exact command.
- After editing a .py file run \`python3 -m py_compile <file>\` (or \`bash -n\` for .sh) and confirm exit 0.
- Back up nothing destructively; these are small in-place edits (git/auto-snapshot covers them).
- If you cannot confidently locate the exact bug, set status="skipped" with what you found.
Report concisely.`

const SCHEMA = {
  type: 'object',
  required: ['channel', 'status', 'file', 'change', 'verified', 'needs_restart', 'needs_go', 'notes'],
  properties: {
    channel: { type: 'string' },
    status: { type: 'string', enum: ['applied', 'staged', 'skipped'] },
    file: { type: 'string', description: 'file(s) touched or inspected' },
    change: { type: 'string', description: 'exact change made (or proposed if staged)' },
    verified: { type: 'string', description: 'how verified (py_compile exit, grep, etc.)' },
    needs_restart: { type: 'string', description: 'exact restart/cron cmd if any, else "none"' },
    needs_go: { type: 'boolean', description: 'true if trade-tier change left for Mike' },
    notes: { type: 'string' },
  },
}

const TASKS = [
  {
    channel: 'risk', label: 'risk:daemon_health',
    body: `Fix #risk feeder ~/05_AUTOMATION/scripts/daemon_health.py — it checks STALE pm2 process
names and a retired Oracle path, so it spams false offline/restart warnings that bury real risk alerts.
Update the EXPECTED process names to the LIVE ones: 'option-signals-scraper' -> 'option-signals',
'mission-control' -> 'missionctrl'. Replace any retired Oracle scored-signals path
(/home/ubuntu/mission-control/signal-receiver/ or similar) with the laptop equivalent (verify the real
path under ~/ ; if unknown, drop that specific check rather than point at dead infra). Verify current pm2
names with \`pm2 jlist\` if needed. Alert-only daemon — safe.`,
  },
  {
    channel: 'reminders', label: 'reminders:oracle_gateway',
    body: `Fix #reminders feeder ~/05_AUTOMATION/scripts/watchdogs/oracle_gateway_health.py — it probes
the RETIRED Oracle/OpenClaw gateway + a dead /home/ubuntu pm2 path (deliberately off per current
doctrine), so it posts 100% failures every ~15 min forever, burying DNS-renewal reminders. The correct
fix: make this watchdog STOP spamming retired-infra failures — either (a) early-return/no-op the Oracle
gateway check, or (b) only alert on the laptop's real services. Do NOT delete the file. Keep the
DNS-renewal reminder path intact if present. Find how it's scheduled (grep crontab / pm2) and report the
exact cmd to disable that schedule in needs_restart IF code-disable isn't enough.`,
  },
  {
    channel: 'tg-bridge', label: 'tgbridge:fred_calendar',
    body: `Fix #tg-bridge feeder ~/05_AUTOMATION/scripts/cron-batch/fred_calendar.py — it posts the
'Economic Calendar — Next 14 Days' embed on schedule but the payload is EMPTY (header only, no events),
likely a FRED fetch/parse failure or empty-result fallback. Minimal fix: GUARD against posting when the
event list is empty (skip the Discord post + log why), and if the parse is trivially broken, fix it.
Do not change unrelated behavior. Verify py_compile.`,
  },
  {
    channel: 'price-checker', label: 'pricecheck:morning_note_spam',
    body: `Fix #price-checker — a poster is spamming the SAME stale 'Morning Note' (S&P/Nasdaq/BTC/
Fear&Greed) every ~12-15 min into a channel meant for on-demand lookups. The legit morning-note cron is
Mon-Fri 8:45 ONLY, so something ELSE re-posts every 15 min to the price-checker webhook. Hunt it down:
grep crontab + ~/05_AUTOMATION/scripts + ~/scripts for the price-checker channel id (1496301956631761086),
its webhook secret, or a */15 morning-note/price loop. Fix = stop the recurring auto-post (gate to once-
daily Mon-Fri and skip on weekends/frozen data), WITHOUT killing the legit 8:45 morning-note. If the
culprit is a cron line, set status=staged + needs_restart with the exact crontab edit (do NOT edit
crontab yourself). If it's a code loop, fix the code. Report the culprit precisely.`,
  },
  {
    channel: 'flow-picks + boba-trades', label: 'decisioncycle:routing',
    body: `Two fixes in the boba/jazzy decision-cycle code (likely ~/scripts/boba_decision_cycle.py or a
shared log_to_ops helper — locate it):
(1) #flow-picks is BROKEN — boba_cycle/jazzy_cycle '[DATA]/[INFO]' ops-log noise (log_to_ops) is being
posted into #flow-picks (id 1493809588804259881), swamping real picks. Re-route that diagnostic stream to
the OPS webhook (discord_ops_webhook, channel 1518338064089616426) so it STOPS hitting flow-picks. Only
flow_picks_post.py output should reach flow-picks. Change ONLY the log destination, never the decision logic.
(2) #boba-trades posts 'No API calls logged today' daily (Boba is on OAuth, so console-API usage is
legitimately 0). Suppress that post when usage is 0 (skip instead of posting a no-op).
These are logging/presentation only — safe. Verify py_compile. If you cannot cleanly separate the log
route from trade logic, set needs_go=true and propose the change instead.`,
  },
  {
    channel: 'pattern-alerts + provider-telegram', label: 'misroute:repoint',
    body: `Two misrouting fixes — diagnostic/log noise is polluting content channels:
(1) #pattern-alerts (id 1497766804209143979): a 'Channel Identity Audit' job is dumping into it. Find the
script doing the channel_identity audit (grep ~/scripts ~/05_AUTOMATION for 'channel_identity' / 'Channel
Identity Audit') and repoint its Discord webhook to the OPS/diagnostics channel (discord_ops_webhook /
1518338064089616426) so it stops polluting pattern-alerts. Real pattern alerts (Spidey webhook) keep flowing.
(2) #provider-telegram (id 1498486675565969639): the regime-engine archiver (grep for 'ARCHIVE ROTATED' /
archiver.py / risk_manager.py) is dumping rotation-log noise here. Repoint that archiver's Discord webhook
to a logs/ops channel (or silence it). Do NOT touch regime/trade logic — only the log webhook target.
Verify py_compile. Report exactly which webhook/secret you changed.`,
  },
  {
    channel: 'earnings', label: 'earnings:empty_playbook',
    body: `Fix #earnings — the daily 'Earnings Playbook' embed (posted via discord_earnings_playbook_webhook)
overwhelmingly yields EMPTY playbooks ('No large-cap names with available options data', 'BMO: 0, AMC: 0').
Find the playbook generator (grep ~/05_AUTOMATION ~/scripts for 'Earnings Playbook' / 'earnings_playbook').
Minimal fix: SUPPRESS the post on empty days (don't post when there are 0 real names). Do not widen the
universe (that's a bigger change) — just stop the empty-day noise. Verify py_compile.`,
  },
]

phase('Fix')
const out = await parallel(
  TASKS.map((t) => () =>
    agent(`${t.body}\n${GUARD}`, {
      label: t.label, phase: 'Fix', schema: SCHEMA, agentType: 'general-purpose',
    }).then((r) => r || { channel: t.channel, status: 'skipped', file: '', change: '',
      verified: '', needs_restart: 'none', needs_go: false, notes: 'agent returned null' })
  )
)
log(`fix agents done: ${out.filter((r) => r.status === 'applied').length} applied, ` +
    `${out.filter((r) => r.status === 'staged').length} staged, ` +
    `${out.filter((r) => r.status === 'skipped').length} skipped`)
return { fixes: out }
