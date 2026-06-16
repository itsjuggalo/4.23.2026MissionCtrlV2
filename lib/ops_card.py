#!/home/itsju/.venv/bin/python3
"""Discord OPS visual-card layer — StarCraft command-console stat cards.

Turns the wall-of-text cron posts (#pipeline health, #devops kronos-stale,
#squeeze-alerts, #macro session banners, #daily-wrap, night-shift digest) into
glanceable PNG cards, and posts them to a Discord webhook with a 1-line text
summary above the image.

Design: REUSES the proven LifeClaw renderer primitives (8 StarCraft faction
themes, inline-SVG glyphs/crests, bg patterns) from ~/.lifeclaw/render_card.py
WITHOUT editing it (that file is life-engine-critical). We only borrow its
visual primitives and add a generic STAT-CARD layout + the Discord image-upload
helper that didn't exist yet.

Public API:
    render_ops_card(spec, out_path) -> out_path | None   (never raises)
    post_image(webhook_url, png_path, content=None) -> bool
    render_and_post(spec, webhook_url, summary_line, out_path=None) -> str
        renders + posts the card with `summary_line` as the message content;
        on ANY render/post failure falls back to posting `summary_line` as text
        so a card bug never drops the alert.
    theme_for(bot) -> int            pin a stable faction per bot
    now_et()                         'Mon Jun 15 · 3:31 PM ET'

spec keys (all optional except title):
    bot         : 'SPIDEY'|'HERMES'|'SPACER'|'CAPTAIN HOOK'   (header tag+footer+theme)
    title       : 'PIPELINE HEALTH'
    subtitle    : 'Mon Jun 15 · 3:31 PM ET'    (defaults to now_et())
    glyph       : 'reticle'|'signal'|'chevron'|'intercept'|'sun'|'moon'|'gauge'
    status      : 'good'|'warn'|'crit'          overall badge/dot color
    status_text : 'SYSTEMS NOMINAL'
    theme       : int 0-7 OR faction name       (defaults to theme_for(bot))
    rows        : [ {label, value, state} ]      key/value stat rows
    bars        : [ {label, pct, state, note} ]  horizontal SVG gauges (0-100)
    sections    : [ {label, items:[...]} ]       optional bullet panels
    footer      : 'auto-posted · 3:31 PM ET'
"""
import importlib.util
import json
import os
import sys
import time

_RC_PATH = os.path.expanduser('~/.lifeclaw/render_card.py')
_SECRETS = os.path.expanduser('~/.openclaw/secrets')


# ── borrow the proven visual primitives from render_card.py (no edits) ────────
def _load_rc():
    try:
        spec = importlib.util.spec_from_file_location('lifeclaw_render_card', _RC_PATH)
        mod = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(mod)
        return mod
    except Exception as e:  # pragma: no cover
        print(f'ops_card: could not import render_card ({e})', file=sys.stderr)
        return None


_RC = _load_rc()


# ── theme pinning: one stable faction per bot (no day-rotation for ops) ───────
_BOT_THEME = {
    'SPIDEY': 0,        # Terran Dominion — industrial steel/amber → systems/ops
    'SPIDEY BOT1': 0,
    'HERMES': 7,        # Xel'Naga Relic — gold/iridescent → oracle/forecast
    'SPACER': 1,        # Khalai Protoss — gold/teal → scanners/market
    'CAPTAIN HOOK': 3,  # Raynor's Raiders — rust/red rebel → night-shift crew
}


def theme_for(bot):
    return _BOT_THEME.get((bot or '').upper(), 0)


def now_et():
    try:
        from datetime import datetime
        from zoneinfo import ZoneInfo
        return datetime.now(ZoneInfo('America/New_York')).strftime('%a %b %-d · %-I:%M %p ET')
    except Exception:
        return ''


def _theme(spec):
    themes = _RC.THEMES
    th = spec.get('theme')
    if isinstance(th, str):
        for i, t in enumerate(themes):
            if t['name'].upper().startswith(th.upper()):
                return t
        return themes[theme_for(spec.get('bot'))]
    if isinstance(th, int):
        return themes[th % len(themes)]
    return themes[theme_for(spec.get('bot')) % len(themes)]


def _state_color(state, t):
    return {
        'good': t['good'], 'ok': t['good'],
        'warn': t['accent'], 'warning': t['accent'],
        'crit': t['alert'], 'critical': t['alert'], 'bad': t['alert'],
    }.get((state or '').lower(), t['text'])


def _header_glyph(name, color):
    g = {
        'reticle': _RC._g_reticle, 'signal': _RC._g_signal,
        'chevron': _RC._g_chevron, 'intercept': _RC._g_intercept,
        'sun': _RC._g_sun, 'moon': _RC._g_moon, 'gauge': _RC._g_reticle,
    }.get((name or 'reticle').lower(), _RC._g_reticle)
    return g(color)


def _esc(s):
    import html
    return html.escape(str(s if s is not None else ''))


def build_ops_html(spec: dict) -> str:
    """Generic StarCraft stat-card. Pure HTML/CSS/inline-SVG (system Chrome)."""
    spec = spec or {}
    t = _theme(spec)
    rgba = _RC._rgba
    bot = _esc(spec.get('bot', 'OPS') or 'OPS')
    title = _esc(spec.get('title', 'STATUS') or 'STATUS')
    subtitle = _esc(spec.get('subtitle') or now_et())
    footer = _esc(spec.get('footer') or 'auto-posted')
    status = (spec.get('status') or 'good').lower()
    status_text = _esc(spec.get('status_text') or
                       {'good': 'NOMINAL', 'warn': 'WARNING',
                        'crit': 'CRITICAL'}.get(status, 'NOMINAL'))
    badge_c = _state_color({'good': 'good', 'warn': 'warn', 'crit': 'crit'}.get(status, ''), t)
    glyph = _header_glyph(spec.get('glyph', 'reticle'), t['accent'])
    crest = t['crest'](t['accent'])
    pattern = _RC._bg_pattern(t['grid'], t['edge'])

    # ── stat rows ──
    rows = spec.get('rows') or []
    rows_html = ''
    for r in rows:
        vc = _state_color(r.get('state'), t)
        dot = (f'<span class="rdot" style="background:{vc};box-shadow:0 0 7px {vc}"></span>'
               if r.get('state') else '<span class="rdot off"></span>')
        rows_html += (
            f'<div class="row">{dot}'
            f'<span class="rlabel">{_esc(r.get("label"))}</span>'
            f'<span class="rval" style="color:{vc}">{_esc(r.get("value"))}</span></div>')
    rows_block = f'<div class="rows">{rows_html}</div>' if rows_html else ''

    # ── gauges / bars ──
    bars = spec.get('bars') or []
    bars_html = ''
    for b in bars:
        try:
            pct = max(0, min(100, float(b.get('pct', 0))))
        except (TypeError, ValueError):
            pct = 0
        bc = _state_color(b.get('state'), t)
        note = _esc(b.get('note') or f'{pct:.0f}%')
        bars_html += (
            f'<div class="bar"><div class="bhead">'
            f'<span class="blabel">{_esc(b.get("label"))}</span>'
            f'<span class="bnote" style="color:{bc}">{note}</span></div>'
            f'<div class="btrack"><div class="bfill" '
            f'style="width:{pct:.1f}%;background:{bc};box-shadow:0 0 8px {bc}"></div></div></div>')
    bars_block = f'<div class="bars">{bars_html}</div>' if bars_html else ''

    # ── optional bullet sections ──
    sections = spec.get('sections') or []
    secs_html = ''
    for i, sec in enumerate(sections):
        items = sec.get('items', []) or []
        mk = _RC._g_chevron(t['accent'])
        lis = ''.join(
            f'<li><span class="mk">{mk}</span><span class="itxt">{_esc(it)}</span></li>'
            for it in items)
        secs_html += (
            f'<div class="sec"><div class="shead">{_esc(sec.get("label"))}</div>'
            f'<ul class="ilist">{lis}</ul></div>')
    secs_block = f'<div class="secs">{secs_html}</div>' if secs_html else ''

    css = f"""
* {{ box-sizing:border-box; margin:0; padding:0; }}
html,body {{ background:{t['bg1']}; }}
body {{ font-family:"Rajdhani","Saira Condensed","DejaVu Sans Condensed","Segoe UI",system-ui,sans-serif;
  -webkit-font-smoothing:antialiased; width:960px; padding:26px;
  background:{pattern}, radial-gradient(120% 100% at 50% -10%, {t['bg0']} 0%, {t['bg1']} 75%); }}
.mono {{ font-family:"Consolas","DejaVu Sans Mono","Liberation Mono",monospace; }}
.card {{ position:relative; border:1px solid {t['edge']};
  background:linear-gradient(180deg, rgba(0,0,0,.12), rgba(0,0,0,.40));
  box-shadow:0 0 0 1px rgba(0,0,0,.5), 0 16px 48px rgba(0,0,0,.6), inset 0 0 80px rgba(0,0,0,.42);
  clip-path:polygon(0 26px,26px 0,calc(100% - 26px) 0,100% 26px,100% calc(100% - 26px),calc(100% - 26px) 100%,26px 100%,0 calc(100% - 26px));
  padding:30px 36px 26px; overflow:hidden; }}
.card::after {{ content:""; position:absolute; inset:0; pointer-events:none;
  background:repeating-linear-gradient(0deg, rgba(0,0,0,0) 0px, rgba(0,0,0,0) 2px, rgba(0,0,0,.18) 3px, rgba(0,0,0,0) 4px);
  mix-blend-mode:multiply; }}
.card::before {{ content:""; position:absolute; inset:0; pointer-events:none;
  background:radial-gradient(120% 120% at 50% 45%, rgba(0,0,0,0) 42%, rgba(0,0,0,.40) 100%); }}
.frame {{ position:absolute; inset:0; width:100%; height:100%; pointer-events:none; opacity:.85; z-index:3; }}
.inner {{ position:relative; z-index:2; }}
.cmdbar {{ display:flex; align-items:stretch; gap:16px; padding-bottom:15px; margin-bottom:18px; border-bottom:1px solid {t['edge']}; }}
.crest {{ width:58px; height:58px; flex:0 0 auto; filter:drop-shadow(0 0 6px {t['glow']}); }}
.cmdmain {{ flex:1 1 auto; min-width:0; }}
.greet {{ display:flex; align-items:center; gap:12px; }}
.gicon {{ filter:drop-shadow(0 0 5px {t['glow']}); display:flex; }}
.title {{ color:{t['text']}; font-size:36px; font-weight:700; letter-spacing:2.4px;
  text-transform:uppercase; line-height:1; text-shadow:0 0 12px {t['glow']}; }}
.title .br {{ color:{t['accent']}; }}
.subline {{ display:flex; align-items:center; gap:14px; margin-top:8px; flex-wrap:wrap; }}
.bottag {{ color:{t['accent']}; font-size:14px; letter-spacing:3px; font-weight:700;
  padding:2px 9px; border:1px solid {t['accent']}; border-radius:2px; }}
.date {{ color:{t['muted']}; font-size:16px; letter-spacing:1px; }}
.cmdright {{ display:flex; flex-direction:column; align-items:flex-end; gap:9px; flex:0 0 auto; }}
.faction {{ color:{t['edge']}; font-size:13px; letter-spacing:3px; font-weight:700; }}
.badge {{ display:flex; align-items:center; gap:9px; padding:7px 13px;
  background:linear-gradient(180deg, rgba(255,255,255,.04), {rgba(t['panel'], 0.96)});
  border:1px solid {t['edge']}; border-left:3px solid {badge_c};
  clip-path:polygon(0 0,100% 0,100% 100%,8px 100%,0 calc(100% - 8px)); }}
.bdot {{ width:10px; height:10px; border-radius:50%; background:{badge_c}; box-shadow:0 0 9px {badge_c}; }}
.btext {{ color:{t['text']}; font-size:16px; font-weight:700; letter-spacing:2px; }}
.rows {{ display:flex; flex-direction:column; gap:0; margin-bottom:16px;
  border:1px solid {rgba(t['edge'], 0.6)};
  background:linear-gradient(180deg, {rgba(t['panel'], 0.96)}, {rgba(t['panel2'], 0.96)});
  clip-path:polygon(0 0,100% 0,100% calc(100% - 12px),calc(100% - 12px) 100%,0 100%); }}
.row {{ display:flex; align-items:center; gap:12px; padding:11px 18px; border-bottom:1px solid {rgba(t['edge'], 0.28)}; }}
.row:last-child {{ border-bottom:none; }}
.rdot {{ width:9px; height:9px; border-radius:50%; flex:0 0 auto; }}
.rdot.off {{ background:{t['muted']}; opacity:.4; }}
.rlabel {{ color:{t['muted']}; font-size:19px; letter-spacing:.6px; flex:1 1 auto; }}
.rval {{ font-size:21px; font-weight:700; letter-spacing:.4px; text-align:right; }}
.bars {{ display:flex; flex-direction:column; gap:14px; margin-bottom:16px; }}
.bar {{ }}
.bhead {{ display:flex; justify-content:space-between; align-items:baseline; margin-bottom:6px; }}
.blabel {{ color:{t['muted']}; font-size:17px; letter-spacing:1px; }}
.bnote {{ font-size:17px; font-weight:700; letter-spacing:.5px; }}
.btrack {{ height:13px; background:{rgba(t['panel2'], 0.96)}; border:1px solid {rgba(t['edge'], 0.6)};
  clip-path:polygon(0 0,100% 0,100% 100%,4px 100%,0 calc(100% - 4px)); overflow:hidden; }}
.bfill {{ height:100%; }}
.secs {{ display:flex; flex-direction:column; gap:12px; margin-bottom:14px; }}
.sec {{ border:1px solid {rgba(t['edge'], 0.6)}; padding:13px 18px 12px;
  background:linear-gradient(180deg, {rgba(t['panel'], 0.96)}, {rgba(t['panel2'], 0.96)});
  clip-path:polygon(0 0,100% 0,100% calc(100% - 10px),calc(100% - 10px) 100%,0 100%); }}
.shead {{ color:{t['accent']}; font-size:13px; letter-spacing:3px; font-weight:700;
  text-transform:uppercase; padding-bottom:9px; margin-bottom:10px; border-bottom:1px solid {rgba(t['edge'], 0.4)}; }}
.ilist {{ list-style:none; }}
.ilist li {{ display:flex; align-items:flex-start; gap:11px; margin-bottom:9px; }}
.ilist li:last-child {{ margin-bottom:0; }}
.mk {{ flex:0 0 auto; margin-top:2px; display:flex; filter:drop-shadow(0 0 3px {t['glow']}); }}
.itxt {{ color:{t['text']}; font-size:19px; line-height:1.3; font-weight:500; }}
.statusbar {{ display:flex; align-items:center; gap:12px; margin-top:4px; padding-top:13px; border-top:1px solid {t['edge']}; }}
.dotled {{ width:9px; height:9px; border-radius:50%; background:{badge_c}; box-shadow:0 0 8px {badge_c}; flex:0 0 auto; }}
.sbtext {{ color:{t['muted']}; font-size:14px; letter-spacing:1px; }}
.sbtext b {{ color:{t['accent']}; font-weight:700; letter-spacing:2px; }}
.sbright {{ margin-left:auto; color:{t['edge']}; font-size:12px; letter-spacing:3px; font-weight:700; }}
"""

    bracket_svg = (
        f'<svg class="frame" viewBox="0 0 960 600" preserveAspectRatio="none">'
        f'<path d="M14 70 L14 14 L70 14 M890 14 L946 14 L946 70 '
        f'M946 530 L946 586 L890 586 M70 586 L14 586 L14 530" '
        f'fill="none" stroke="{t["edge"]}" stroke-width="2.5"/></svg>')

    body = f"""
<div class="card">{bracket_svg}<div class="inner">
  <div class="cmdbar">
    <div class="crest">{crest}</div>
    <div class="cmdmain">
      <div class="greet"><span class="gicon">{glyph}</span>
        <span class="title">&#9700; {title} &#9701;</span></div>
      <div class="subline">
        <span class="bottag mono">{bot}</span>
        <span class="date mono">{subtitle}</span>
      </div>
    </div>
    <div class="cmdright">
      <span class="faction">{t['name']}</span>
      <div class="badge"><span class="bdot"></span><span class="btext">{status_text}</span></div>
    </div>
  </div>
  {rows_block}
  {bars_block}
  {secs_block}
  <div class="statusbar">
    <span class="dotled"></span>
    <span class="sbtext"><b>{bot}</b> · {footer}</span>
    <span class="sbright mono">{t['name']} · ONLINE</span>
  </div>
</div></div>"""

    return (f'<!doctype html><html><head><meta charset="utf-8">'
            f'<style>{css}</style></head><body>{body}</body></html>')


def _venv_python():
    """An interpreter that has playwright (cron may run /usr/bin/python3 which
    doesn't). Prefer ~/.venv (LifeClaw's renderer runs there)."""
    for p in ('~/.venv/bin/python', '~/.venv/bin/python3'):
        p = os.path.expanduser(p)
        if os.path.isfile(p):
            return p
    return None


def _render_inproc(spec, out_path):
    from playwright.sync_api import sync_playwright
    os.makedirs(os.path.dirname(os.path.abspath(out_path)), exist_ok=True)
    html_str = build_ops_html(spec)
    with sync_playwright() as p:
        browser = p.chromium.launch(channel='chrome', args=['--no-sandbox'])
        try:
            page = browser.new_page(viewport={'width': 960, 'height': 600},
                                    device_scale_factor=2)
            page.set_content(html_str, wait_until='networkidle')
            page.screenshot(path=out_path, full_page=True)
        finally:
            browser.close()
    return out_path


def _render_subproc(spec, out_path):
    """Re-exec the render under a venv that has playwright. Used when the caller's
    interpreter (e.g. cron's /usr/bin/python3) lacks it."""
    import subprocess
    import tempfile
    venv = _venv_python()
    if not venv:
        return None
    specf = None
    try:
        os.makedirs(os.path.dirname(os.path.abspath(out_path)), exist_ok=True)
        with tempfile.NamedTemporaryFile('w', suffix='.json', delete=False) as tf:
            json.dump(spec, tf)
            specf = tf.name
        env = dict(os.environ, OPS_CARD_SUBPROC='1')
        subprocess.run([venv, os.path.abspath(__file__), '--render', specf, out_path],
                       capture_output=True, text=True, timeout=150, env=env)
        return out_path if os.path.isfile(out_path) else None
    except Exception as e:
        print(f'render_ops_card subproc error: {e}', file=sys.stderr)
        return None
    finally:
        if specf:
            try:
                os.unlink(specf)
            except OSError:
                pass


def render_ops_card(spec: dict, out_path: str):
    """Render spec -> PNG. Returns out_path or None on ANY failure (never raises).
    Works from any interpreter: renders in-process when playwright is importable,
    otherwise re-execs the render under the venv."""
    try:
        return _render_inproc(spec, out_path)
    except ImportError:
        # this interpreter has no playwright; re-exec under venv (unless we ARE
        # the subprocess already — then just give up so the caller falls back).
        if os.environ.get('OPS_CARD_SUBPROC') == '1':
            return None
        return _render_subproc(spec, out_path)
    except Exception as e:
        print(f'render_ops_card error: {e}', file=sys.stderr)
        return None


# ── Discord webhook helpers (stdlib urllib only — works on ANY interpreter) ───
def resolve_webhook(name_or_url: str):
    """Accept a full webhook URL, or a secrets-file basename to read it from."""
    if not name_or_url:
        return None
    if name_or_url.startswith('http'):
        return name_or_url.strip()
    for cand in (name_or_url, f'{name_or_url}.txt'):
        p = os.path.join(_SECRETS, cand)
        if os.path.isfile(p):
            try:
                with open(p) as f:
                    v = f.read().strip()
                if v.startswith('http'):
                    return v
            except Exception:
                pass
    return None


_UA = 'MissionControl-OpsCard/1.0 (+https://missionctrl.serveftp.com)'


def _send(url, data, headers, retries, attempt_sleep=1.5, method='POST', return_json=False):
    """HTTP call with Discord 429 backoff. Returns True on 2xx (default), or the
    parsed JSON response dict when return_json=True (None on failure). `method`
    lets callers PATCH/PUT/GET (edit / pin / lookup) — defaults to POST so every
    existing caller is unaffected."""
    import urllib.error
    import urllib.request
    fail = None if return_json else False
    for attempt in range(retries):
        try:
            req = urllib.request.Request(url, data=data, headers=headers, method=method)
            with urllib.request.urlopen(req, timeout=45) as r:
                ok = 200 <= r.status < 300
                if not return_json:
                    return ok
                if not ok:
                    return None
                try:
                    return json.loads(r.read().decode() or '{}')
                except Exception:
                    return {}
        except urllib.error.HTTPError as e:
            if e.code == 429:
                wait = 1.0
                try:
                    body = json.loads(e.read().decode() or '{}')
                    wait = float(body.get('retry_after', 1.0))
                except Exception:
                    pass
                time.sleep(min(8.0, wait + 0.25))
                continue
            print(f'ops_card _send HTTP {e.code} ({method})', file=sys.stderr)
            return fail
        except Exception as e:
            print(f'ops_card _send error: {e}', file=sys.stderr)
            time.sleep(attempt_sleep * (attempt + 1))
    return fail


def post_text(webhook_url: str, content: str, retries: int = 4, username: str = None):
    """Plain-text webhook post with 429 backoff (stdlib)."""
    url = resolve_webhook(webhook_url)
    if not url or not content:
        return False
    pd = {'content': content[:1990]}
    if username:
        pd['username'] = username
    data = json.dumps(pd).encode()
    return _send(url, data, {'Content-Type': 'application/json', 'User-Agent': _UA}, retries)


def _multipart_image(png_path, content, extra_payload=None):
    """Build a Discord multipart/form-data body (payload_json + files[0])."""
    with open(png_path, 'rb') as fh:
        img = fh.read()
    boundary = '----OpsCardBoundary' + str(int(time.time() * 1000))
    pd = {}
    if content:
        pd['content'] = content[:1990]
    if extra_payload:
        pd.update(extra_payload)
    payload = json.dumps(pd)
    pre = (
        f'--{boundary}\r\n'
        f'Content-Disposition: form-data; name="payload_json"\r\n'
        f'Content-Type: application/json\r\n\r\n{payload}\r\n'
        f'--{boundary}\r\n'
        f'Content-Disposition: form-data; name="files[0]"; '
        f'filename="{os.path.basename(png_path)}"\r\n'
        f'Content-Type: image/png\r\n\r\n'
    ).encode()
    body = pre + img + f'\r\n--{boundary}--\r\n'.encode()
    return boundary, body


def _multipart_images(png_paths, content, extra_payload=None):
    """Multipart body with several files[i] (one Discord message, N images)."""
    boundary = '----OpsCardBoundary' + str(int(time.time() * 1000))
    pd = {}
    if content:
        pd['content'] = content[:1990]
    if extra_payload:
        pd.update(extra_payload)
    body = (f'--{boundary}\r\n'
            f'Content-Disposition: form-data; name="payload_json"\r\n'
            f'Content-Type: application/json\r\n\r\n{json.dumps(pd)}\r\n').encode()
    for i, p in enumerate(png_paths):
        with open(p, 'rb') as fh:
            img = fh.read()
        body += (f'--{boundary}\r\n'
                 f'Content-Disposition: form-data; name="files[{i}]"; '
                 f'filename="{os.path.basename(p)}"\r\n'
                 f'Content-Type: image/png\r\n\r\n').encode() + img + b'\r\n'
    body += f'--{boundary}--\r\n'.encode()
    return boundary, body


def post_images(webhook_url: str, png_paths, content: str = None, retries: int = 4,
                username: str = None):
    """Post several PNGs in ONE webhook message. Returns True/False."""
    url = resolve_webhook(webhook_url)
    paths = [p for p in (png_paths or []) if p and os.path.isfile(p)]
    if not url or not paths:
        return False
    try:
        extra = {'username': username} if username else None
        boundary, body = _multipart_images(paths, content, extra)
    except Exception:
        return False
    headers = {'Content-Type': f'multipart/form-data; boundary={boundary}', 'User-Agent': _UA}
    return _send(url, body, headers, retries)


def post_image(webhook_url: str, png_path: str, content: str = None, retries: int = 4,
               username: str = None):
    """Upload a PNG to a Discord WEBHOOK with `content` above it. Optional
    `username` overrides the webhook's display name. Returns True/False."""
    url = resolve_webhook(webhook_url)
    if not url or not png_path or not os.path.isfile(png_path):
        return False
    try:
        extra = {'username': username} if username else None
        boundary, body = _multipart_image(png_path, content, extra)
    except Exception:
        return False
    headers = {'Content-Type': f'multipart/form-data; boundary={boundary}', 'User-Agent': _UA}
    return _send(url, body, headers, retries)


# ── bot-token posting (preserves the named-bot identity + avatar) ─────────────
def _bot_channel_url(channel_id):
    return f'https://discord.com/api/v10/channels/{channel_id}/messages'


def post_text_bot(channel_id: str, token: str, content: str, retries: int = 4):
    """Plain-text post AS a bot (channels/{id}/messages). 429-aware, stdlib."""
    if not channel_id or not token or not content:
        return False
    data = json.dumps({'content': content[:1990]}).encode()
    headers = {'Authorization': f'Bot {token}', 'Content-Type': 'application/json', 'User-Agent': _UA}
    return _send(_bot_channel_url(channel_id), data, headers, retries)


def post_image_bot(channel_id: str, token: str, png_path: str, content: str = None,
                   retries: int = 4, components=None, return_msg: bool = False):
    """Upload a PNG AS a bot (channels/{id}/messages multipart). Optional `components`
    attaches an action row (buttons) — the message is then owned by this app, so the
    gateway bot's persistent Views handle the clicks by custom_id. Returns True/False,
    or the posted message dict (with 'id') when return_msg=True."""
    if not channel_id or not token or not png_path or not os.path.isfile(png_path):
        return None if return_msg else False
    try:
        extra = {'components': components} if components is not None else None
        boundary, body = _multipart_image(png_path, content, extra)
    except Exception:
        return None if return_msg else False
    headers = {'Authorization': f'Bot {token}',
               'Content-Type': f'multipart/form-data; boundary={boundary}', 'User-Agent': _UA}
    return _send(_bot_channel_url(channel_id), body, headers, retries, return_json=return_msg)


# ── interactive components (Discord action rows / buttons) ────────────────────
# Button styles: 1 primary(blurple) · 2 secondary(grey) · 3 success(green) ·
# 4 danger(red) · 5 link(url). Persistent buttons need a stable custom_id and a
# View registered (add_view) on the running gateway bot of the SAME app/token.
BTN_PRIMARY, BTN_SECONDARY, BTN_SUCCESS, BTN_DANGER, BTN_LINK = 1, 2, 3, 4, 5


def button(label, custom_id=None, style=BTN_SECONDARY, emoji=None, url=None, disabled=False):
    """Build one Discord button component dict."""
    b = {'type': 2, 'label': str(label)[:80]}
    if url:
        b['style'] = BTN_LINK
        b['url'] = url
    else:
        b['style'] = style
        b['custom_id'] = custom_id
    if emoji:
        b['emoji'] = {'name': emoji} if isinstance(emoji, str) else emoji
    if disabled:
        b['disabled'] = True
    return b


def action_row(buttons):
    """Wrap up to 5 button dicts in a single action row."""
    return {'type': 1, 'components': list(buttons)[:5]}


def post_message_bot(channel_id: str, token: str, content: str = None, embeds=None,
                     components=None, retries: int = 4, return_msg: bool = False,
                     thread_id: str = None):
    """Post a JSON message (content / embeds / components) AS a bot. Returns
    True/False, or the message dict when return_msg=True."""
    if not channel_id or not token:
        return None if return_msg else False
    pd = {}
    if content:
        pd['content'] = content[:1990]
    if embeds is not None:
        pd['embeds'] = embeds
    if components is not None:
        pd['components'] = components
    if not pd:
        return None if return_msg else False
    url = _bot_channel_url(channel_id) + (f'?thread_id={thread_id}' if thread_id else '')
    data = json.dumps(pd).encode()
    headers = {'Authorization': f'Bot {token}', 'Content-Type': 'application/json', 'User-Agent': _UA}
    return _send(url, data, headers, retries, return_json=return_msg)


def edit_message_bot(channel_id: str, token: str, message_id: str, content: str = None,
                     embeds=None, components=None, retries: int = 4, return_msg: bool = False):
    """Edit a message in place (PATCH). Pass only the fields to change. Returns
    True/False, or the message dict when return_msg=True. This is the cheap
    edit-in-place primitive behind the live command-center."""
    if not (channel_id and token and message_id):
        return None if return_msg else False
    pd = {}
    if content is not None:
        pd['content'] = content[:1990]
    if embeds is not None:
        pd['embeds'] = embeds
    if components is not None:
        pd['components'] = components
    url = f'{_bot_channel_url(channel_id)}/{message_id}'
    data = json.dumps(pd).encode()
    headers = {'Authorization': f'Bot {token}', 'Content-Type': 'application/json', 'User-Agent': _UA}
    return _send(url, data, headers, retries, method='PATCH', return_json=return_msg)


def pin_message_bot(channel_id: str, token: str, message_id: str, retries: int = 3):
    """Pin a message (PUT). Returns True/False."""
    if not (channel_id and token and message_id):
        return False
    url = f'https://discord.com/api/v10/channels/{channel_id}/pins/{message_id}'
    headers = {'Authorization': f'Bot {token}', 'User-Agent': _UA}
    return _send(url, b'', headers, retries, method='PUT')


def discord_get(path: str, token: str, retries: int = 3):
    """GET https://discord.com/api/v10<path> as a bot. Parsed JSON or None."""
    url = 'https://discord.com/api/v10' + path
    headers = {'Authorization': f'Bot {token}', 'User-Agent': _UA}
    return _send(url, None, headers, retries, method='GET', return_json=True)


def resolve_channel(guild_id: str, token: str, name: str):
    """Channel id for a channel NAME in a guild (or the id passed straight
    through). None if not found. Uses the given bot token."""
    if not name:
        return None
    if str(name).isdigit():
        return str(name)
    for c in (discord_get(f'/guilds/{guild_id}/channels', token) or []):
        if c.get('name') == name:
            return str(c.get('id'))
    return None


def create_text_channel(guild_id: str, token: str, name: str, topic: str = None):
    """Create a GUILD_TEXT channel, or return the id if it already exists.
    Returns channel id or None."""
    existing = resolve_channel(guild_id, token, name)
    if existing:
        return existing
    pd = {'name': name, 'type': 0}
    if topic:
        pd['topic'] = topic[:1024]
    headers = {'Authorization': f'Bot {token}', 'Content-Type': 'application/json', 'User-Agent': _UA}
    r = _send(f'https://discord.com/api/v10/guilds/{guild_id}/channels',
              json.dumps(pd).encode(), headers, 3, return_json=True)
    return str(r.get('id')) if r else None


def create_webhook(channel_id: str, token: str, name: str = 'MC'):
    """Create a webhook on a channel and return its full URL. None on failure.
    (Idempotency is the caller's job — check secrets before creating.)"""
    headers = {'Authorization': f'Bot {token}', 'Content-Type': 'application/json', 'User-Agent': _UA}
    r = _send(f'https://discord.com/api/v10/channels/{channel_id}/webhooks',
              json.dumps({'name': name[:80]}).encode(), headers, 3, return_json=True)
    if not r or not r.get('id') or not r.get('token'):
        return None
    return f"https://discord.com/api/webhooks/{r['id']}/{r['token']}"


def _as_bot(target):
    """Return (channel_id, token) if target is a bot dest, else (None, None)."""
    if isinstance(target, dict) and target.get('channel') and target.get('token'):
        return str(target['channel']), str(target['token'])
    if isinstance(target, (tuple, list)) and len(target) == 2:
        return str(target[0]), str(target[1])
    return None, None


def _post_image_any(target, png_path, content, username=None):
    ch, tok = _as_bot(target)
    if ch:
        return post_image_bot(ch, tok, png_path, content)
    return post_image(target, png_path, content, username=username)


def _post_text_any(target, content, username=None):
    ch, tok = _as_bot(target)
    if ch:
        return post_text_bot(ch, tok, content)
    return post_text(target, content, username=username)


def render_and_post(spec: dict, target, summary_line: str, out_path: str = None):
    """Render the card and post it with `summary_line` above. On ANY failure,
    fall back to posting `summary_line` as plain text so the alert never drops.

    `target` is either a webhook URL / secrets-name (str), or a bot destination
    {'channel': id, 'token': tok} / (channel_id, token) to post AS that bot.
    Returns a status string ('card:...', 'text-fallback', or 'FAILED')."""
    if out_path is None:
        safe = ''.join(c if c.isalnum() else '_' for c in (spec.get('title') or 'card'))[:32]
        out_path = f'/tmp/ops_card_{safe}_{int(time.time())}.png'
    png = render_ops_card(spec, out_path)
    un = spec.get('username')
    if png and _post_image_any(target, png, summary_line, username=un):
        return f'card:{png}'
    # fallback — never drop the alert
    if _post_text_any(target, summary_line or (spec.get('title') or ''), username=un):
        return 'text-fallback'
    return 'FAILED'


# ── CLI: --render (subprocess render entry) + demo ────────────────────────────
if __name__ == '__main__':
    # subprocess render entry used by _render_subproc(): --render <spec.json> <out.png>
    if len(sys.argv) >= 4 and sys.argv[1] == '--render':
        try:
            with open(sys.argv[2]) as _f:
                _spec = json.load(_f)
            _out = render_ops_card(_spec, sys.argv[3])
            sys.exit(0 if _out else 1)
        except Exception as _e:
            print(f'--render error: {_e}', file=sys.stderr)
            sys.exit(1)

    demos = {
        'pipeline': {
            'bot': 'SPIDEY', 'title': 'PIPELINE HEALTH', 'glyph': 'reticle',
            'status': 'warn', 'status_text': 'DEGRADED',
            'rows': [
                {'label': 'Database', 'value': 'healthy', 'state': 'good'},
                {'label': 'Signal scouts', 'value': '3 silent', 'state': 'warn'},
                {'label': 'Decision cycle', 'value': 'stalled 102m', 'state': 'crit'},
                {'label': 'Dashboard', 'value': 'reachable', 'state': 'good'},
            ],
            'bars': [
                {'label': 'Veto rate (last 4 cycles)', 'pct': 86, 'state': 'crit', 'note': '86% · 18/21'},
            ],
            'footer': 'auto-posted'},
        'kronos': {
            'bot': 'HERMES', 'title': 'KRONOS FRESHNESS', 'glyph': 'gauge',
            'status': 'crit', 'status_text': '79% STALE',
            'rows': [
                {'label': 'Stale models', 'value': '73', 'state': 'crit'},
                {'label': 'Fresh models', 'value': '20', 'state': 'good'},
                {'label': 'Oldest', 'value': 'KORU 55d', 'state': 'warn'},
            ],
            'bars': [{'label': 'Cache freshness', 'pct': 21, 'state': 'crit', 'note': '20 / 93 fresh'}],
            'footer': 'kronos cache monitor'},
        'squeeze': {
            'bot': 'SPACER', 'title': 'SQUEEZE WATCH · UPST', 'glyph': 'signal',
            'status': 'warn', 'status_text': 'SCORE 60',
            'rows': [
                {'label': 'Short interest', 'value': '33.6% float', 'state': 'crit'},
                {'label': 'Days to cover', 'value': '5.4d', 'state': 'warn'},
                {'label': 'Price', 'value': '$30.50  (-14.8% 52w)', 'state': 'good'},
                {'label': 'ATM call IV', 'value': '±11.4%  6/26', 'state': 'warn'},
            ],
            'bars': [{'label': 'Squeeze score', 'pct': 60, 'state': 'warn', 'note': '60 / 100'}],
            'footer': 'yfinance + Tradier + whale-flow'},
        'session': {
            'bot': 'SPACER', 'title': 'MARKET OPEN', 'glyph': 'sun',
            'status': 'good', 'status_text': 'LIVE',
            'rows': [
                {'label': 'Session', 'value': 'Mon Jun 15 · OPEN', 'state': 'good'},
                {'label': 'Prior', 'value': 'Sun Jun 14 · closed', 'state': None},
            ],
            'footer': 'market session banner'},
    }
    pick = sys.argv[1] if len(sys.argv) > 1 else 'all'
    keys = [pick] if pick in demos else list(demos)
    for k in keys:
        out = f'/tmp/ops_card_demo_{k}.png'
        r = render_ops_card(demos[k], out)
        print(f'{k}: {r or "FAILED"}')
