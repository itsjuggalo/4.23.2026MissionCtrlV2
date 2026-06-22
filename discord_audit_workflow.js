export const meta = {
  name: 'discord-channel-audit',
  description: 'Judge every Discord channel stale-vs-current from the static dump (no API)',
  phases: [{ title: 'Judge' }],
}

// args = the batch index: [{ batch, file, count, names:[...] }, ...]
const batches = args

const SCHEMA = {
  type: 'object',
  required: ['verdicts'],
  properties: {
    verdicts: {
      type: 'array',
      items: {
        type: 'object',
        required: ['id', 'name', 'purpose', 'feeder', 'feeder_live', 'status', 'evidence', 'recommendation', 'detail'],
        properties: {
          id: { type: 'string' },
          name: { type: 'string' },
          purpose: { type: 'string', description: 'what this channel is for, inferred from name/topic/content' },
          feeder: { type: 'string', description: 'what posts here (webhook label / cron / bot / Spacer-only / none / unknown)' },
          feeder_live: { type: 'string', enum: ['yes', 'no', 'unknown'] },
          status: { type: 'string', enum: ['CURRENT', 'STALE', 'BROKEN', 'DEAD', 'REDUNDANT'] },
          evidence: { type: 'string', description: 'last real-post age, content read, feeder state — cite specifics' },
          recommendation: { type: 'string', enum: ['KEEP', 'FIX', 'REMOVE', 'MERGE'] },
          detail: { type: 'string', description: 'what to fix / merge-into target / why remove' },
        },
      },
    },
  },
}

const prompt = (b) => `You are auditing a batch of Mission Control Discord channels to decide, per channel,
whether it is CURRENT, STALE, BROKEN, DEAD, or REDUNDANT — and whether to KEEP / FIX / REMOVE / MERGE it.

Today's date is 2026-06-21 (ET). The trading week: last market day before today was Fri 2026-06-19.

STEP 1 — Read this self-contained data file (it has the last ~12 messages + feeder info per channel):
  ${b.file}
It also lists pm2_online (which feeder daemons are running). Do NOT call the Discord API — all data is in the file.

STEP 2 — For richer judgment you MAY grep/read the feeder scripts referenced under each channel's
"feeder.id_refs" / "feeder.cron_lines" (e.g. in ~/scripts, ~/05_AUTOMATION/scripts, ~/firebase-signals)
to see if the feed is healthy or erroring. Keep it light. Never edit anything.

CHANNELS IN THIS BATCH: ${b.names.join(', ')}

CLASSIFY each with this rubric:
- CURRENT  — real (non-"Spacer") content within ~3 trading days AND a live feeder.
- STALE    — had a real purpose but no real content in >~14 days / feeder silent → usually FIX.
- BROKEN   — recent posts are errors/empty/garbage, or the feeder is erroring → FIX.
- DEAD     — never used or ONLY "Spacer" day-divider banners, no live feeder → REMOVE.
- REDUNDANT— duplicates another channel's feed → MERGE (name the target channel in detail).
Notes: "Spacer" = the OPEN/CLOSED day-divider bot; its posts are NOT real content. spacer_msgs out of
total_100 tells you how sparse real content is. human_msgs>0 means a person actually used it.
A channel with a live webhook_feeder but stale content = FIX the feeder (say which). feeder_live: infer
from pm2_online + whether a webhook resolved + cron presence; "unknown" if slash-command/no binding.

Return ONLY the structured verdicts (one per channel in the batch). Be concrete in evidence (quote a
sample, give the last-real-post age). Recommendation must follow from status.`

phase('Judge')
const results = await parallel(
  batches.map((b) => () =>
    agent(prompt(b), {
      label: `judge:batch_${String(b.batch).padStart(2, '0')}`,
      phase: 'Judge',
      schema: SCHEMA,
      agentType: 'general-purpose',
    }).then((r) => (r && r.verdicts ? r.verdicts : []))
  )
)

const all = results.filter(Boolean).flat()
log(`collected ${all.length} channel verdicts across ${batches.length} batches`)
return { count: all.length, verdicts: all }
