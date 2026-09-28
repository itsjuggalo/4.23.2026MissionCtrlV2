# Astrology system — canonical doc

Mike's personal astrology bot (Telegram @JazzyHazzyClaw_Bot, lane `astrology` in tg-gateway) + the live page. Astrology only (no trading). **Tropical Western, Placidus, Swiss Ephemeris.** This is the one doc; the handoff ledger is `~/restructure/.remember/claudeclaw/astrology-daily-coach.md`.

## Architecture (one direction, no shortcuts)

```
PROFILE (astro_profiles) → ENGINE (astro_truth: ephemeris, time, crossings, progressions)
  → CANONICAL EVENTS (astro_events live + astro_timeline cache) → TIMING/PRIORITY/THEMES (astro_events)
  → INTERPRETATION (astro_lexicon + KB json) → FORMATTERS (daily_transits · astro_weekly · astro_alerts ·
     astro_moon · astro_synastry · astro_facts/astro_bot for free chat) → TELEGRAM (tg_responder) + PAGE
```

The LLM never computes: positions, degrees, signs, houses, aspects, orbs, dates, times, applying/separating, retrograde, progressions, ingresses, synastry. It gets `astro_facts.llm_context()` (JSON of computed facts + rule "not listed → UNAVAILABLE"), and every answer is then fact-checked by `astro_verify.py --check-text`.

| Module | Role |
|---|---|
| `astro_truth.py` | THE engine. Natal chart, `jd_for`/`jd_to_local`/`local_date`/`round_minute`, `find_crossings` (the one root finder, 5 s bisection), `progressed_at` (the one progression calculator) |
| `astro_events.py` | Canonical event model (`make_event`), motion, stationary, pass series, lifecycle, priority, themes, `fast_exacts` (Sun–Mars), cache metadata |
| `astro_timeline.py` | 5-year event cache (`~/portfolio/astrology/timeline.json`): transits (slow bodies), ingresses, progressions, transits to progressed, sky, eclipses, solar arcs |
| `svehla.py` | Aug-2026 Svehla reading: windows (`svehla_windows.json`, his dates verbatim + `[engine: exact …]` beside computable ones); exact hits are a VIEW of the timeline |
| `daily_transits.py` | Daily read (08:32 digest, `/today`, `/full`, `/explain`) |
| `astro_weekly.py` | Weekly read (`/week`, Monday section of the 08:32 packet) |
| `astro_moon.py` | Moon sign + phase posts against Mike's placements (`/moon`, `/moonguide`, auto-posts via alerts) |
| `astro_alerts.py` | Hourly 08–22 ET pushes: exacts (canonical `exact_at_local`), VoC, stations, lunations, Moon sign/phase changes |
| `astro_profiles.py` · `astro_synastry.py` | Birth profiles (`~/portfolio/astrology/profiles.json`, 600) · synastry + progressed synastry |
| `astro_facts.py` · `astro_bot.py` · `astro_trace.py` | Free-chat grounding · deterministic router called by the gateway · privacy-safe request trace |
| `astro_verify.py` | 08:25 truth check (natal, texts, NASA Horizons, Svehla dates, outputs, passes, page, commands) + `--check-text` |

## Time policy
- Every human-facing date/time = the real instant localized with `zoneinfo` America/New_York (DST from tzdb). Never `swe.revjul`'s UT date, never fixed offsets, never `hour=28`.
- Display = nearest minute (`T.round_minute`); instants stored to the second (`exact_at_utc`, `exact_at_local`, `local_date`).
- Processes: `tg_responder.py` pins `TZ=America/New_York` + `tzset()` at import; tg-gateway's PM2 env TZ fixed 2026-09-27. (Fleet-wide PM2 TZ strings are still corrupted — see ledger; other apps untouched.)

## Progressions
Secondary, day-for-a-year, key 365.25 days from each person's own natal JD: `progressed_jd = natal_jd + (target_jd − natal_jd)/365.25`. A civil date = **local noon** that day. (The old 03:46-UT sample = the evening before in ET → progressed ingresses 1 day late; fixed 2026-09-27: pMoon→11th Oct 29 2026, →Gemini May 3 2027.) Progressed angles are not computed (method-dependent); houses stay natal Placidus.

## Event schema (every event)
`event_id, event_type, subtype, moving_body, moving_frame (transit|progressed), target_body, target_frame, aspect, aspect_deg, moving_degree, target_degree, orb, orb_allowed, motion (applying|separating|exact|stationary), retrograde, exact_at_utc, exact_at_local, local_date, timezone, house, target_house, pass_number, pass_total, pass_label (FIRST/RETROGRADE/FINAL PASS), passes[], window_start, window_end, source, calculated_at` + live-only `lifecycle (NEW|BUILDING|EXACT|SEPARATING|ONGOING), priority, priority_reasons, changed`. Legacy aliases kept: `date, body, natal, key, what, kind, pass, rx`.

## Orbs, motion, passes
- Transit orbs: `astro_truth.ORB` (Sun 1.2, Moon 2.5, Mercury/Venus/Mars 1.0, Jupiter 0.8, Saturn/Chiron 0.7, outers 0.6, Juno 0.8, Ceres 0.6).
- Motion = signed distance × instantaneous speed; stationary if speed flips within ±1 day; exact if ≤0.02° or within ±1 h of the instant.
- Pass series = crossings of one target point grouped by gap (Sun/Moon 0, Mercury 60 d, Venus 100, Mars 200, others 600).
- Synastry orbs: luminary/angle pairs 8/8/7/7/5 (conj/opp/sq/tri/sext), others 6/6/5/5/4; anything progressed 1°.

## Ranking (`astro_events.PRIORITY_POINTS`)
Integer points, each with a readable reason (shown in `/full`): exact today +3, applying +1, strong orb +1, slow body +3 / medium +1 / Moon −2, angle +2, luminary +2, chart ruler +1, personal +1, major aspect +1, multi-pass +1, active Svehla window +2 / thread +1, profection +1, progression +2, new +1, theme corroboration +1. Sorted by (−priority, orb). Deterministic.

## Daily vs weekly
- Daily = what's live today: Moon house, stations, Δ since yesterday, top 4 ranked hits (+ up to 2 more that are NEW/EXACT; long paragraph only on NEW/EXACT), themes line, sky quality with reasons, next-48h exacts, Svehla active windows. `/full` = all hits + why.
- Weekly = shape of 7 days: themes, every exact (ET, pass label, incl. Sun–Mars), slow transits in force, progressions, Svehla windows with Why/Do, practice/profection, best/hardest day, coming up. A test asserts no duplicated lines.

## Telegram flow
Gateway (`tg_responder.py`, PM2 `tg-gateway`) → astro lane: trading commands refused → `astro_bot.py route` (subprocess): computed reply sent as-is, or COMPUTED FACTS → `claude -p` (sonnet) → `astro_verify --check-text` footer. Plain-text replies, split on line boundaries under 4096, one retry. Menu (9): today, week, transits, progressions, synastry, progsyn, timeline, moon, help. Unknown person → UNAVAILABLE + `/profile add` instructions.

## Caches
Every cache carries `meta = {schema_version, generated_at, source, timezone, code_hash, valid_until}`; `E.cache_fresh()` rebuilds on code-hash change or expiry (timeline 7 d ≈ 90 s rebuild; sky cache). Gateway sky-context cache is keyed by the ET date.

## Schedules (crontab, all `TZ=America/New_York`)
08:25 `astro_verify --all --send-on-fail` · 08:30 `astro_today_page` · 08:32 `astro_morning --send` · 08:34 `astro_tasks daily` (trading lane — separate, untouched) · `5 8-22` `astro_alerts` · Oct 27 solar return. Page: `~/agents/claudeclaw/data/astrology/mike-today-live.html` → https://claudeclaw.serveftp.com/astrology/readings/mike-today-live.html (login-gated).

## Tests
`cd ~/scripts/real_coach && ~/.venv/bin/python -m pytest tests -q`. Oracle = raw pyswisseph + own bisection + zoneinfo (`tests/conftest.py`), never the engine's root finder. Covers the TZ regressions (Sep 27 22:36 Sun☌Jupiter, Feb 17 2027 23:52 Saturn□Juno, 8 PM–midnight progression, EST/EDT, both DST switches, 23:52/00:01 events), progressed dates, schema, motion, passes, ranking, wording, daily/weekly duplication, trading contamination, themes, cache freshness, alerts, synastry (reversal, unknown time, four progressed frames), grounding, router, tracing, Moon posts. Profile tests use a temp store (`$ASTRO_PROFILES`).

## Ops
- Rebuild caches: `astro_timeline.py rebuild` · sky rebuilds itself.
- Deploy code: files are read per run; only the gateway needs `pm2 restart tg-gateway` after `tg_responder.py` changes (never restart claudeclaw).
- Traces: `~/logs/astrology/trace.jsonl` (no text, hashed chat id). Logs: `~/logs/astrology/astrology.log`.
- Git: local repo at `~/05_AUTOMATION/scripts` (allowlist `.gitignore`, no remote).
