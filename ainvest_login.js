// ainvest_login.js — autonomous cookie-minter for ainvest.com.
//
// AInvest web login is OTP-only (email + emailed verification code) — there is NO
// password field, so the stored password is unused here. This drives the real
// login page headlessly (system google-chrome), captures the session cookies, and
// writes them to ~/.openclaw/secrets/ainvest_cookie.txt in Cookie-header format.
//
// Modes:
//   node ainvest_login.js --send            # request a code (sendMac), then exit
//   node ainvest_login.js --code 586132     # finish login with a code you supply
//   node ainvest_login.js --auto            # send + read code from Gmail IMAP + finish
//                                           # (needs GMAIL_APP_PASSWORD in the env file)
//
// Self-heal cron path = --auto. To enable it, add to ~/.openclaw/secrets/ainvest_login.env:
//   GMAIL_APP_PASSWORD=<16-char app password from myaccount.google.com/apppasswords>
// (--auto requires `npm i imapflow mailparser` in the benchmark node_modules dir.)
//
// Run from the dir that has rebrowser-playwright-core, e.g.:
//   cd ~/04_RESEARCH/aime_research/benchmark
//   NODE_PATH=$(pwd)/node_modules node ~/05_AUTOMATION/scripts/ainvest_login.js --auto
const { chromium } = require('rebrowser-playwright-core');
const fs = require('fs');
const os = require('os');
const path = require('path');

const SECRETS = path.join(os.homedir(), '.openclaw', 'secrets');
const ENV = path.join(SECRETS, 'ainvest_login.env');
const COOKIE_OUT = path.join(SECRETS, 'ainvest_cookie.txt');
const CHROME = '/usr/bin/google-chrome';
const UA = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0 Safari/537.36';
const sleep = ms => new Promise(r => setTimeout(r, ms));

function env() {
  const out = {};
  try { fs.readFileSync(ENV, 'utf8').split('\n').forEach(l => { const m = l.match(/^([A-Z_]+)=(.*)$/); if (m) out[m[1]] = m[2]; }); } catch {}
  return out;
}

async function newPage(browser) {
  const ctx = await browser.newContext({ userAgent: UA, viewport: { width: 1280, height: 900 } });
  const page = await ctx.newPage();
  return { ctx, page };
}

async function openLogin(page) {
  await page.goto('https://www.ainvest.com/login/', { waitUntil: 'domcontentloaded', timeout: 45000 });
  await sleep(4500);
  await page.locator('button:has-text("Accept")').first().click({ timeout: 1500 }).catch(() => {});
  await sleep(500);
}

async function fillEmail(page, email) {
  await page.locator('input[name="email"]').first().fill(email);
  await sleep(400);
}

async function sendCode(page) {
  await page.locator('button:has-text("Send code")').first().click({ timeout: 2500 }).catch(() => {});
  await sleep(4000);
}

async function submitCode(ctx, page, code) {
  await page.locator('input[placeholder*="verification" i]').first().fill(code)
    .catch(async () => { await page.locator('input[type="text"]').nth(1).fill(code); });
  await sleep(400);
  await page.locator('button:has-text("Log in")').first().click({ timeout: 2500 }).catch(() => {});
  await sleep(7000);
  const cookies = await ctx.cookies();
  const hasSession = cookies.some(c => /sess_tk|userid|sessionid|ticket/i.test(c.name));
  if (hasSession) {
    fs.writeFileSync(COOKIE_OUT, cookies.map(c => `${c.name}=${c.value}`).join('; '));
    fs.chmodSync(COOKIE_OUT, 0o600);
  }
  return { hasSession, count: cookies.length, names: cookies.map(c => c.name) };
}

// Pull the freshest AInvest code from Gmail via IMAP (only used in --auto).
async function fetchCodeFromGmail(email, appPassword, sentAfter) {
  const { ImapFlow } = require('imapflow');
  const client = new ImapFlow({ host: 'imap.gmail.com', port: 993, secure: true, auth: { user: email, pass: appPassword }, logger: false });
  await client.connect();
  let code = null;
  try {
    await client.mailboxOpen('INBOX');
    for (let attempt = 0; attempt < 20 && !code; attempt++) {
      const uids = await client.search({ from: 'ainvest.com', since: sentAfter });
      for (const uid of (uids || []).slice(-5).reverse()) {
        const msg = await client.fetchOne(uid, { envelope: true });
        const m = (msg.envelope.subject || '').match(/\b(\d{6})\b/);
        if (m) { code = m[1]; break; }
      }
      if (!code) await sleep(3000);
    }
  } finally { await client.logout().catch(() => {}); }
  return code;
}

(async () => {
  const args = process.argv.slice(2);
  const e = env();
  const email = e.AINVEST_EMAIL;
  if (!email) { console.error('missing AINVEST_EMAIL in ' + ENV); process.exit(2); }
  const codeArg = args.includes('--code') ? args[args.indexOf('--code') + 1] : null;
  const mode = codeArg ? 'code' : args.includes('--auto') ? 'auto' : args.includes('--send') ? 'send' : 'auto';

  const browser = await chromium.launch({ executablePath: CHROME, headless: true, args: ['--no-sandbox', '--disable-dev-shm-usage', '--disable-blink-features=AutomationControlled'] });
  try {
    const { ctx, page } = await newPage(browser);
    await openLogin(page);
    await fillEmail(page, email);

    if (mode === 'code') {
      const r = await submitCode(ctx, page, codeArg);
      console.log(r.hasSession ? `OK — wrote ${r.count} cookies (${r.names.filter(n=>/sess_tk|userid|ticket/i.test(n)).join(',')})` : 'FAILED — no session cookie');
      process.exitCode = r.hasSession ? 0 : 1;
    } else if (mode === 'send') {
      await sendCode(page);
      console.log('code requested — check email, then run with --code <NNNNNN>');
    } else { // auto
      const sentAfter = new Date(Date.now() - 60000);
      await sendCode(page);
      if (!e.GMAIL_APP_PASSWORD) { console.error('--auto needs GMAIL_APP_PASSWORD in ' + ENV); process.exitCode = 2; }
      else {
        const code = await fetchCodeFromGmail(email, e.GMAIL_APP_PASSWORD, sentAfter);
        if (!code) { console.error('no code found in Gmail within timeout'); process.exitCode = 1; }
        else {
          const r = await submitCode(ctx, page, code);
          console.log(r.hasSession ? `OK auto-login — wrote ${r.count} cookies` : 'FAILED — no session after code ' + code);
          process.exitCode = r.hasSession ? 0 : 1;
        }
      }
    }
  } catch (err) {
    console.error('ERR:', err.message);
    process.exitCode = 1;
  } finally { await browser.close(); }
})();
