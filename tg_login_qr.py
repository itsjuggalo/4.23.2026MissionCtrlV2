#!/home/itsju/.venv/bin/python
"""tg_login_qr.py — one-shot QR login for the MTProto *user* session → vault.

Why: `tg_botfather.py login` uses client.start(), which needs an interactive TTY
(phone → code → 2FA). Under the `!` prompt or a subprocess there's no TTY (EOFError),
and the in-app code didn't arrive last time. QR login sidesteps BOTH: Mike scans the
code with the Telegram app already logged in on his phone
(Settings → Devices → Link Desktop Device). No code, no phone number, no TTY.

Runs headless (background-safe): writes a scannable PNG, waits for the scan,
saves the authenticated session string to the vault (telegram_user.session).

  ~/.venv/bin/python ~/scripts/tg_login_qr.py            # QR flow
  ~/.venv/bin/python ~/scripts/tg_login_qr.py --password <2FA>   # finish if 2FA prompted
"""
import asyncio
import os
import sys

sys.path.insert(0, os.path.expanduser("~/scripts"))
import tg_botfather as B  # _creds, _uput (vault, category telegram_user)

import qrcode
from telethon import TelegramClient
from telethon.sessions import StringSession
from telethon.errors import SessionPasswordNeededError

QR_PNG = os.path.expanduser("~/restructure/.tg_login_qr.png")
PARTIAL = os.path.expanduser("~/.openclaw/state/.tg_qr_partial.session")
PER_TOKEN = 30          # Telegram QR token life
MAX_SECONDS = 300       # total patience (~5 min of refreshes)


def _render(url):
    img = qrcode.make(url)
    img.save(QR_PNG)
    os.chmod(QR_PNG, 0o600)


async def _save_session(client, why):
    sess = client.session.save()
    B._uput("telegram_user.session", sess, "MTProto user session — password-grade")
    me = await client.get_me()
    print(f"✓ logged in as {me.first_name} (@{me.username}); session saved to vault ({why}).",
          flush=True)


async def main():
    api_id, api_hash, existing = B._creds()
    if not api_id:
        sys.exit("set-creds first.")

    pw = None
    if "--password" in sys.argv:
        pw = sys.argv[sys.argv.index("--password") + 1]

    # Resume a partially-authed session (post-scan, awaiting 2FA) if present.
    seed = ""
    if pw and os.path.exists(PARTIAL):
        seed = open(PARTIAL).read().strip()

    client = TelegramClient(StringSession(seed), int(api_id), api_hash)
    await client.connect()

    if await client.is_user_authorized():
        await _save_session(client, "already authorized")
        await client.disconnect()
        return

    # 2FA completion path (scan already happened in a prior run).
    if pw and seed:
        try:
            await client.sign_in(password=pw)
            await _save_session(client, "2FA")
            if os.path.exists(PARTIAL):
                os.remove(PARTIAL)
        finally:
            await client.disconnect()
        return

    # Fresh QR flow.
    qr = await client.qr_login()
    _render(qr.url)
    print(f"[qr] rendered {QR_PNG} — scan within ~{PER_TOKEN}s "
          f"(Telegram → Settings → Devices → Link Desktop Device)", flush=True)

    elapsed = 0
    while elapsed < MAX_SECONDS:
        try:
            await qr.wait(PER_TOKEN)
            await _save_session(client, "QR")
            await client.disconnect()
            return
        except asyncio.TimeoutError:
            elapsed += PER_TOKEN
            await qr.recreate()
            _render(qr.url)
            print(f"[qr] refreshed (still waiting, {elapsed}s elapsed)", flush=True)
        except SessionPasswordNeededError:
            # Scanned, but the account has a 2FA password. Persist partial session.
            os.makedirs(os.path.dirname(PARTIAL), exist_ok=True)
            with open(PARTIAL, "w") as f:
                f.write(client.session.save())
            os.chmod(PARTIAL, 0o600)
            print("NEEDS_2FA — scanned OK, account has a Two-Step password. "
                  "Re-run with: tg_login_qr.py --password <YOUR_2FA_PASSWORD>", flush=True)
            await client.disconnect()
            return

    print("EXPIRED_RETRY — QR went unscanned for 5 min; re-run to get a fresh code.",
          flush=True)
    await client.disconnect()


if __name__ == "__main__":
    asyncio.run(main())
