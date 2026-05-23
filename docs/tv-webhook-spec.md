# TradingView Webhook -> Alpaca Bracket Order — Design Spec

Status: DRAFT — awaiting operator sign-off
Owner: Execution Specialist
Target app: `MissionCtrlV2` (Next.js 16.2.1, App Router, port 3000)
Last revised: 2026-05-22

> Spec only. No route code is written until the operator approves this doc.
> Default trading destination is **Alpaca paper accounts**. Live trading is explicitly out of scope until a separate `TV_WEBHOOK_LIVE=true` flag is wired and reviewed.

---

## 1. Route

| Item | Value |
|---|---|
| Path | `/api/tv-webhook/[secret]` |
| File | `src/app/api/tv-webhook/[secret]/route.ts` |
| Methods | `POST` (alert receiver), `GET` (health probe — returns `{ ok: true, enabled: <bool>, version: "..." }`, never echoes the secret) |
| Runtime | `nodejs` (we need `child_process`, `better-sqlite3`, full Node crypto) |
| Caching | `export const dynamic = 'force-dynamic'` (route handler reads request body + headers; never prerender) |
| Handler signature | `POST(req: NextRequest, ctx: RouteContext<'/api/tv-webhook/[secret]'>)` — Next 16 passes `ctx.params` as a `Promise`, `await ctx.params` before reading `secret` |

`GET` is provided so we can curl the URL during smoke tests and so Oracle's reverse proxy has a cheap liveness path. `GET` must not perform any trading action and must not log the secret.

---

## 2. Auth model — URL-slug shared secret (option B)

**Decision:** path-segment secret: `/api/tv-webhook/{secret}` where `{secret}` is a 32-byte URL-safe random string stored in `~/.openclaw/secrets/tv-webhook-slug` and read into env as `TV_WEBHOOK_SLUG`.

**Why not (a) body-token:** TradingView's alert JSON is operator-editable, easy to leak via screenshot, and gets logged inside the body payload everywhere we audit it. Rotating it means editing every alert in the TV UI.

**Why not (c) IP allowlist:** TradingView documents four egress IPs (`52.89.214.238`, `34.212.75.30`, `54.218.53.128`, `52.32.178.7`) but they change without notice. We would still need *some* secret for defence-in-depth, and an IP list adds an operational footgun on Oracle's nginx without removing the need for a token.

**Why (b) URL slug:**
- TV cannot add custom headers in standard plan alerts, so HMAC-over-headers is off the table.
- A path segment is naturally stripped from referer headers, stays out of body logs, and rotates by editing one env var and one TradingView field.
- Easy to revoke: change `TV_WEBHOOK_SLUG`, the old URL 404s on the next request.

**Security risk + mitigation:**
- *Risk:* Next.js request logs, nginx access logs, and Sentry tracing all capture the full URL by default — the secret would land in plaintext on disk.
- *Mitigations (all required before go-live):*
  1. In the route handler, **redact** the path before logging: anything matching `/api/tv-webhook/[^/]+` is rewritten to `/api/tv-webhook/[REDACTED]` before being passed to `console.log` or the sqlite audit table.
  2. Configure nginx on Oracle (`bridge.serveftp.com`) with `log_format` that masks the matching path.
  3. Set `SENTRY_BEFORE_SEND` (or use `beforeSend` in `sentry.server.config.ts`) to strip `request.url` for transactions whose route is `tv-webhook`.
  4. Constant-time compare (`crypto.timingSafeEqual`) when validating the slug against the env var, even though we 404 either way — prevents timing leaks if the route is ever reached by a brute-forcer.
  5. Rotate the slug quarterly.

If the slug fails validation, return `404 Not Found` (not 401) so the URL space is indistinguishable from any other unknown route to a scanner.

---

## 3. Payload validation

Required fields (POST body, JSON):

| Field | Type | Validation |
|---|---|---|
| `source` | string | Must equal `"tradingview"` |
| `strategy` | string | 1..80 chars, `[A-Za-z0-9_\-\.]+` |
| `action` | enum | `"buy"` \| `"sell"` |
| `symbol` | string | 1..15 chars, uppercase. Crypto pairs use Alpaca's slash form (`BTC/USD`); spec mandates we normalise both `BTCUSD` and `BTC/USD` to `BTC/USD` server-side |
| `price` | number | > 0, finite |
| `quantity` | number | > 0, finite. Crypto allows decimals; equities reject decimals when `fractionable=false` |
| `stop_loss` | number | > 0, finite. For `buy` must be < `price`; for `sell` must be > `price` |
| `take_profit` | number | > 0, finite. For `buy` must be > `price`; for `sell` must be < `price` |
| `bar_time` | string | ISO-8601 UTC. Rejected if > 5 minutes in the future or > 24h in the past |

Optional:

| Field | Type | Notes |
|---|---|---|
| `comment` | string | <= 200 chars, free text |
| `account` | enum | `"boba"` \| `"jazzy"`, default `"boba"` (see §4) |
| `discord` | object | `{ content: string, embed?: object }`. If omitted we generate a default message |
| `alpaca` | object | Override block — `{ side, order_class, type, time_in_force, limit_price? }`. Whitelisted keys only |
| `dry_run` | bool | If `true`, skip Alpaca submission, still log + ping Discord (tagged DRY) |

**Schema implementation:** zod (already widely used). Schema lives at `src/lib/tv-webhook/schema.ts`. Reject malformed payloads with `200 {"ok":false,"reason":"schema","detail":...}` — see §8 for why 200 instead of 4xx.

---

## 4. Account routing

- Inbound payload may set `account: "boba" | "jazzy"`.
- If absent, default to `"boba"`.
- Credentials resolved at startup from disk:
  - `boba`: `~/.openclaw/secrets/alpaca-boba-key-id` + `~/.openclaw/secrets/alpaca-boba-secret`
  - `jazzy`: `~/.openclaw/secrets/alpaca-jazzy-key-id` + `~/.openclaw/secrets/alpaca-jazzy-secret`
- Cached in a `Map<account, {keyId, secret}>` at module load. **Never** logged or echoed in responses.
- Base URL hard-coded to `https://paper-api.alpaca.markets` for both accounts. A separate `TV_WEBHOOK_LIVE=true` env var would be required to flip to `https://api.alpaca.markets`; the route refuses to start in live mode unless **both** `TV_WEBHOOK_LIVE=true` and `TV_WEBHOOK_LIVE_ACK=I_UNDERSTAND` are set.
- If the payload account is unknown, return `200 {"ok":false,"reason":"account"}` and Discord-alert the operator.

---

## 5. Order conversion — TV payload to Alpaca bracket

### 5a. Equities / ETFs

| Source | Target |
|---|---|
| Endpoint | `POST https://paper-api.alpaca.markets/v2/orders` |
| Headers | `APCA-API-KEY-ID: <account.keyId>`, `APCA-API-SECRET-KEY: <account.secret>`, `Content-Type: application/json` |

Body:

```json
{
  "symbol": "<symbol>",
  "qty": "<quantity-as-string>",
  "side": "<action>",
  "type": "<alpaca.type || 'market'>",
  "time_in_force": "<alpaca.time_in_force || 'day'>",
  "order_class": "bracket",
  "take_profit": { "limit_price": "<take_profit>" },
  "stop_loss":   { "stop_price":  "<stop_loss>" },
  "client_order_id": "<dedupe_key>"
}
```

`client_order_id` doubles as the idempotency key (see §6). Alpaca rejects duplicate `client_order_id` with HTTP 422 — we treat that as success.

Expected success: `200/201` with order JSON containing `id`, `client_order_id`, `status` (`accepted`/`new`), `legs[]` (the TP + SL children).

### 5b. Crypto (Alpaca quirks — required reading)

- Endpoint and headers identical.
- `order_class: "bracket"` is **not supported** for crypto on Alpaca. Spec: when `symbol` matches a crypto pair (`/USD$/` or `/USDT$/`), submit the entry as a plain order, then on fill confirmation submit two separate OCO-emulating orders (a `limit` sell at TP and a `stop` sell at SL) and track them in our sqlite table with a shared `bracket_group_id`. Operator must accept the gap risk between fill and child placement.
- `time_in_force` must be `gtc` for crypto (not `day`).
- Crypto market hours: 24/7 — skip the market-clock check that equities require.
- Paper crypto symbol coverage is limited to roughly `BTC/USD, ETH/USD, LTC/USD, BCH/USD, AVAX/USD, DOGE/USD, LINK/USD, SHIB/USD, USDC/USD, USDT/USD, AAVE/USD, BAT/USD, CRV/USD, DOT/USD, GRT/USD, MKR/USD, PEPE/USD, SUSHI/USD, UNI/USD, XTZ/USD, YFI/USD`. Maintain this list in `src/lib/tv-webhook/crypto-allowlist.ts`; reject unknown symbols with `200 {"ok":false,"reason":"symbol_unsupported"}`.
- Fractional quantity is allowed and expected; do not round.

### 5c. Equity market-hours guard

If equity and clock is closed, either (a) reject with `200 {"ok":false,"reason":"market_closed"}`, or (b) submit with `extended_hours: true` + `type: "limit"` when `alpaca.time_in_force === "day"` and an explicit `alpaca.limit_price` was provided. Default behaviour is (a); the operator opts in to (b) per-strategy.

---

## 6. Idempotency

**Dedupe key:**
```
sha256(`${account}|${symbol}|${action}|${bar_time}|${strategy}`)
```
First 32 hex chars used as `client_order_id` (Alpaca limit is 48 chars).

**Storage:** `tv_dedupe` table in the sqlite audit DB (see §9). Row is inserted with `INSERT OR IGNORE` *before* the Alpaca call. If the insert reports 0 changes, we have a duplicate — short-circuit and return `200 {"ok":true,"dedup":true,"key":"..."}`.

**TTL:** rows older than 24h are pruned by a cleanup pass on each POST (cheap because indexed on `created_at`).

**Why DB not in-memory:** Next.js dev mode reloads modules, PM2 may restart workers — in-memory `Set` loses state between restarts and would re-fire on TradingView's 5xx retries.

---

## 7. Discord forwarding

Webhook URL: read from `~/.openclaw/secrets/discord_bobatrades_webhook` at startup. Cached in module scope.

**Fires twice per alert (both POSTs are best-effort, never block the 200 to TradingView, run via `Promise.allSettled` after the response is queued):**

1. **Receipt ping** — immediately after schema validation passes:
   ```
   [TV ALERT] {strategy} {action} {qty} {symbol} @ {price}  (SL {stop_loss} / TP {take_profit})
   acct={account} bar_time={bar_time}
   ```
2. **Outcome ping** — after Alpaca call returns:
   - Success: `[FILL OK] order_id={id} client_order_id={...} status={status}` plus a compact embed (green) with the leg prices.
   - Reject: `[FILL REJECT] reason={alpaca_error_code}: {message}` (red embed). Tag `@here` if reason is in `{insufficient_buying_power, halted, restricted}`.
   - Dedupe short-circuit: `[DEDUP] {dedupe_key_prefix} — duplicate alert ignored`.
   - Dry-run: `[DRY RUN] order *not* sent — payload preview attached`.

Discord failures are logged but never fail the request.

---

## 8. Error handling — TradingView retry posture

TradingView retries on any `5xx` and on connection failures. We deliberately return **`200 OK`** for almost every business-logic outcome so TV does **not** retry. The response body indicates true status with `{ ok: boolean, reason?: string, detail?: any }`.

| Condition | HTTP | Body | Discord |
|---|---|---|---|
| Slug mismatch | `404` | empty | (no Discord — could be a scanner) |
| Schema invalid | `200` | `{ok:false, reason:"schema"}` | yellow embed |
| Kill switch off (§11) | `200` | `{ok:false, reason:"disabled"}` | yellow embed |
| Account unknown | `200` | `{ok:false, reason:"account"}` | red embed |
| Symbol unsupported / fractional reject | `200` | `{ok:false, reason:"symbol_unsupported"}` | red embed |
| Market closed (equities) | `200` | `{ok:false, reason:"market_closed"}` | yellow embed |
| Duplicate (dedupe hit) | `200` | `{ok:true, dedup:true}` | grey embed |
| Alpaca 4xx (buying power, halted, etc.) | `200` | `{ok:false, reason:"alpaca_4xx", detail:{...}}` | red embed |
| Alpaca 5xx / network timeout | `503` | `{ok:false, reason:"alpaca_5xx"}` | red embed, **let TV retry** |
| Our crash / unhandled | `500` | `{ok:false, reason:"internal"}` | red embed, let TV retry |
| Success | `200` | `{ok:true, order_id, client_order_id, status}` | green embed |

Only `5xx` outcomes invite a TV retry; everything else terminates cleanly.

---

## 9. Logging + audit trail

**SQLite DB:** `~/sites/missioncontrol/MissionCtrlV2/data/tv_webhook_log.sqlite` (directory exists at `MissionCtrlV2/data/`).

Driver: `better-sqlite3` (synchronous, fine for our volume; matches the rest of the app's pattern).

Two tables:

```sql
CREATE TABLE IF NOT EXISTS tv_webhook_log (
  id              INTEGER PRIMARY KEY AUTOINCREMENT,
  received_at     TEXT    NOT NULL,            -- ISO-8601 UTC, server clock
  remote_ip       TEXT,                        -- from x-forwarded-for, never the slug
  account         TEXT,                        -- 'boba' | 'jazzy' | NULL if rejected pre-routing
  strategy        TEXT,
  symbol          TEXT,
  action          TEXT,
  quantity        REAL,
  price           REAL,
  stop_loss       REAL,
  take_profit     REAL,
  bar_time        TEXT,
  dedupe_key      TEXT,
  outcome         TEXT    NOT NULL,            -- 'ok'|'dedup'|'reject_schema'|'reject_account'|'reject_market'|'reject_alpaca'|'error'
  http_status     INTEGER NOT NULL,
  alpaca_order_id TEXT,
  alpaca_status   TEXT,
  alpaca_error    TEXT,                        -- JSON-stringified error body if any
  raw_payload     TEXT    NOT NULL,            -- full inbound JSON, secret scrubbed
  duration_ms     INTEGER
);
CREATE INDEX IF NOT EXISTS ix_tv_log_received ON tv_webhook_log(received_at DESC);
CREATE INDEX IF NOT EXISTS ix_tv_log_symbol   ON tv_webhook_log(symbol, received_at DESC);

CREATE TABLE IF NOT EXISTS tv_dedupe (
  dedupe_key  TEXT PRIMARY KEY,
  created_at  TEXT NOT NULL,
  account     TEXT NOT NULL,
  symbol      TEXT NOT NULL
);
CREATE INDEX IF NOT EXISTS ix_tv_dedupe_created ON tv_dedupe(created_at);
```

The URL slug is **never** stored in any row. `raw_payload` is the validated JSON body only.

A dashboard page (future work) at `/?page=tv-webhook-log` can read this directly using the existing sqlite-page pattern.

---

## 10. Public exposure — recommend Oracle reverse-proxy

**Recommendation:** route TradingView through Oracle (`132.145.205.15`) at a new vhost like `tv.bridge.serveftp.com` or a sub-path `bridge.serveftp.com/tv/`, then have nginx `proxy_pass` to the laptop via the existing reverse SSH tunnel.

**Why:**
- Oracle is the always-on failover and already terminates TLS for `bridge.serveftp.com`. We piggy-back the cert.
- The hive-mind reverse SSH tunnel from laptop->Oracle (see `~/CLAUDE.md` → "Hive mind bridge") is already running; we add one more upstream block.
- ngrok and Cloudflare Tunnel both work, but ngrok burns a free-tier slot and rotates URLs (forces TradingView edits), and Cloudflare Tunnel is one more daemon to monitor when nginx already does the job.

**nginx sketch (Oracle side, to be implemented after spec sign-off):**
- New `location /tv-webhook/` (or new server block) that strips the prefix and proxies to `http://127.0.0.1:<tunnel-port>/api/tv-webhook/...`.
- Use the redacting `log_format` from §2.
- Rate-limit: `limit_req zone=tvwh burst=5 nodelay` keyed on `$binary_remote_addr` — TradingView's bursts stay well under 5 rps.

**Fallback:** if the laptop is down, the request still hits Oracle and gets a `502`. TradingView will retry (5xx behaviour, §8), so alerts queue rather than vanish during short outages. Document the recovery procedure: bring the laptop back, the tunnel re-establishes, replays come through naturally (TV retry window is ~3 attempts over a few minutes — anything longer is lost and must be reconciled manually).

---

## 11. Kill switch

Env var: `TV_WEBHOOK_ENABLED` in `.env.local`.
- Default: `false` (fail-closed on first deploy).
- Re-read on **every** request (`process.env.TV_WEBHOOK_ENABLED !== 'true'` evaluated inside the handler, not module-cached) so the operator flips the flag and the next call obeys without restarting `npm run dev`.
- When disabled: respond `200 {"ok":false,"reason":"disabled"}`, write an audit row with `outcome='reject_disabled'`, post a single Discord ping per *minute* (rate-limited via the dedupe table) so we don't spam during a known outage.
- Companion var `TV_WEBHOOK_ACCOUNTS=boba,jazzy` whitelists which accounts may receive. Empty list disables a single account without touching the master switch.

A future dashboard toggle can flip the env via a privileged internal route — explicitly out of scope here.

---

## 12. Testing recipe

Local smoke test (replace `LOCAL_SLUG` with the value of `TV_WEBHOOK_SLUG`):

```bash
SLUG="$(cat ~/.openclaw/secrets/tv-webhook-slug)" \
&& curl -sS -X POST "http://localhost:3000/api/tv-webhook/${SLUG}" \
  -H 'Content-Type: application/json' \
  -d '{
    "source":"tradingview",
    "strategy":"PullbackTrend_5m_intraday",
    "action":"buy",
    "symbol":"BTC/USD",
    "price":67234.5,
    "quantity":0.001,
    "stop_loss":65890.0,
    "take_profit":69921.0,
    "bar_time":"2026-05-23T01:30:00Z",
    "comment":"long entry",
    "account":"boba",
    "dry_run":true,
    "discord":{"content":"test ping from curl"},
    "alpaca":{"side":"buy","order_class":"bracket","type":"market","time_in_force":"gtc"}
  }' | jq .
```

Expected (dry-run): `{ "ok": true, "dry_run": true, "dedupe_key": "...", "would_submit": { ... } }`.

Re-running the same curl within 24h should yield `{ "ok": true, "dedup": true, ... }`.

Public-path smoke test (after Oracle nginx is wired):
```bash
curl -sS https://bridge.serveftp.com/tv/api/tv-webhook/${SLUG} | jq .  # GET health
```

---

## Open questions for the operator

1. **Account default** — confirm Boba is the right default, not Jazzy.
2. **Symbol normalisation** — TradingView typically sends `BTCUSD`; OK to silently rewrite to `BTC/USD` for crypto, or do you want a strict-mode reject?
3. **Crypto OCO emulation** — accept the small fill->child-placement gap (§5b), or require that crypto alerts arrive with `order_class: "simple"` and we *only* place the entry, leaving SL/TP to a separate strategy?
4. **Public hostname** — `tv.bridge.serveftp.com` (new subdomain, needs DNS + cert SAN) vs `bridge.serveftp.com/tv/...` (sub-path, zero DNS work)?
5. **Slug rotation cadence** — quarterly is the spec default; tighter?
6. **Live-trading gate** — happy with the dual-env-var (`TV_WEBHOOK_LIVE` + `TV_WEBHOOK_LIVE_ACK`) gate, or do you want a physical file-touch (`/home/itsju/.openclaw/secrets/tv-webhook-LIVE-ARMED`) before the route will even attempt a non-paper call?
