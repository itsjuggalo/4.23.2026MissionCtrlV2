import os, base64, json, time, random
from urllib.request import Request, urlopen
from urllib.error import HTTPError
from urllib.parse import quote
import gzip

SECRETS = '/home/ubuntu/.openclaw/secrets'
SC_MAP = {
    'lessons': 'Marine', 'analyst-setups': 'Ghost', 'analyst-watchlist': 'Reaper',
    'archive-analyst': 'Reaper', 'archive-auditor': 'Wraith',
    'archive-broadcaster': 'Battlecruiser', 'archive-ci': 'Wraith',
    'agent-debate': 'Hellion', 'spidey': 'Vulture',
    'boba': 'Marauder', 'jazzy': 'Sarah_Kerrigan',
    'orion': 'Phoenix', 'deepsheet': 'Raven', 'today': 'Reaper',
    'grok': 'Sentry', 'reminder': 'Adjutant', 'bridge': 'Probe',
    'todo': 'Drone', 'status': 'Nexus', 'synth': 'Battlecruiser',
}
POOL = ['Marauder','Reaper','Hellion','Banshee','Viking','Medivac','Thor','Raven','Hellbat','Cyclone','Liberator','Widow_Mine','Nexus','Probe','Drone','Marine','Ghost','SCV','Wraith','Goliath','Firebat','Vulture','Predator','Diamondback']

def get_unit_image(unit):
    # Try several name variants on starcraft.fandom.com
    variants = [unit, unit.replace('_',' '), unit.replace('-',' '), unit.split('_')[0]]
    seen = set()
    for v in variants:
        if v in seen: continue
        seen.add(v)
        api = f'https://starcraft.fandom.com/api.php?action=query&prop=pageimages&titles={quote(v)}&pithumbsize=256&format=json'
        try:
            d = json.loads(urlopen(Request(api, headers={'User-Agent':'Mozilla/5.0'}), timeout=10).read())
            pgs = d.get('query',{}).get('pages',{})
            for pid, info in pgs.items():
                if pid == '-1': continue
                thumb = info.get('thumbnail',{}).get('source')
                if not thumb: continue
                try:
                    img = urlopen(Request(thumb, headers={'User-Agent':'Mozilla/5.0'}), timeout=15).read()
                    mime = 'image/jpeg' if '.jpg' in thumb.lower() or '.jpeg' in thumb.lower() else 'image/gif' if '.gif' in thumb.lower() else 'image/png'
                    return f'data:{mime};base64,' + base64.b64encode(img).decode()
                except Exception as ie:
                    print(f'    fetch fail {v}: {ie}')
                    continue
        except Exception as e:
            print(f'    api fail {v}: {e}')
            continue
    return None


def webhook_get(url):
    try:
        return json.loads(urlopen(Request(url, headers={'User-Agent':'curl/8.0'}), timeout=10).read())
    except Exception as e:
        return {'error': str(e)}

def webhook_patch(url, b64):
    body = json.dumps({'avatar': b64}).encode()
    req = Request(url, data=body, method='PATCH', headers={'Content-Type':'application/json','User-Agent':'curl/8.0'})
    try:
        urlopen(req, timeout=15)
        return 'OK'
    except HTTPError as e:
        return f'HTTP {e.code}'
    except Exception as e:
        return f'ERR {e}'

files = sorted([f for f in os.listdir(SECRETS) if 'discord-webhook' in f.lower()])
print(f'== {len(files)} webhook files ==')
ok = fail = skipped = 0
pool_idx = 0
for i, f in enumerate(files):
    url = open(os.path.join(SECRETS, f)).read().strip()
    if not '/api/webhooks/' in url:
        print(f'  [{i+1:2}] {f}  SKIP not webhook')
        skipped += 1
        continue
    info = webhook_get(url)
    if 'error' in info:
        print(f'  [{i+1:2}] {f}  GET-FAIL')
        fail += 1
        continue
    name = info.get('name', '?')
    if info.get('avatar'):
        print(f'  [{i+1:2}] {f}  ({name}) HAS-AVATAR skip')
        skipped += 1
        continue
    flow = f.lower()
    unit = None
    for kw, u in SC_MAP.items():
        if kw in flow or kw in name.lower():
            unit = u; break
    if not unit:
        unit = POOL[pool_idx % len(POOL)]; pool_idx += 1
    img = get_unit_image(unit)
    if not img:
        print(f'  [{i+1:2}] {f}  ({name}) -> {unit}  IMG-FAIL')
        fail += 1
        continue
    res = webhook_patch(url, img)
    print(f'  [{i+1:2}] {f}  ({name}) -> {unit}  {res}')
    if res == 'OK': ok += 1
    else: fail += 1
    time.sleep(1.2)
print(f'\nDONE  ok={ok} fail={fail} skipped={skipped}')
