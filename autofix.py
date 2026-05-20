#!/usr/bin/env python3
"""Autofix bot: polls Linear for [autofix] issues, calls Claude, patches code, pushes."""
import os, json, subprocess, re, sys
from urllib.request import Request, urlopen
from urllib.error import HTTPError

LINEAR_KEY = open('/home/ubuntu/.openclaw/secrets/linear_api_key').read().strip()
ANTHROPIC_KEY = open('/home/ubuntu/.openclaw/secrets/anthropic.key').read().strip()
REPO = '/home/ubuntu/mission-control-vercel'
LOG = '/home/ubuntu/.openclaw/autofix.log'

def log(msg):
    import datetime
    line = f"{datetime.datetime.now().isoformat()} {msg}"
    print(line)
    with open(LOG, 'a') as f: f.write(line + '\n')

def linear_q(query, variables=None):
    body = {'query': query}
    if variables: body['variables'] = variables
    req = Request('https://api.linear.app/graphql',
                  data=json.dumps(body).encode(),
                  headers={'Authorization': LINEAR_KEY, 'Content-Type': 'application/json'})
    return json.loads(urlopen(req, timeout=20).read())

def linear_comment(issue_id, body):
    return linear_q('mutation($i: String!, $b: String!) { commentCreate(input: {issueId: $i, body: $b}) { success } }',
                    {'i': issue_id, 'b': body})

def claude_call(system_prompt, user_prompt):
    body = {'model': 'claude-sonnet-4-5', 'max_tokens': 4096,
            'system': system_prompt,
            'messages': [{'role': 'user', 'content': user_prompt}]}
    req = Request('https://api.anthropic.com/v1/messages',
                  data=json.dumps(body).encode(),
                  headers={'x-api-key': ANTHROPIC_KEY,
                           'anthropic-version': '2023-06-01',
                           'content-type': 'application/json'})
    return json.loads(urlopen(req, timeout=180).read())

def main():
    q = '''query { issues(filter: {title: {startsWith: "[autofix]"}}, first: 5, orderBy: createdAt) { nodes { id identifier title description state { name type } comments { nodes { body } } } } }'''
    res = linear_q(q)
    issues = res.get('data',{}).get('issues',{}).get('nodes',[])
    log(f"Found {len(issues)} candidate issues")
    for issue in issues:
        bot_processed = any('[autofix-bot]' in (c.get('body') or '') for c in issue.get('comments',{}).get('nodes',[]))
        if bot_processed:
            continue
        if issue.get('state',{}).get('type') in ('completed','canceled'):
            continue
        log(f"Picking up {issue['identifier']}: {issue['title']}")
        linear_comment(issue['id'], '[autofix-bot] picked up, analyzing...')
        error = issue.get('description') or issue['title']
        sys_p = ('You are an autofix bot. Given an error stack trace, produce a single-edit fix. '
                 'Output STRICTLY a single JSON object on its own line: '
                 '{"file":"src/path/to/file.tsx","search":"exact text in file","replace":"new text"}. '
                 'The search must be UNIQUE in the file. Path is relative to repo root. '
                 'No prose, no markdown fences. Just the JSON.')
        user_p = f"Repo: mission-control-vercel\nIssue: {issue['title']}\n\nError detail:\n{error[:3000]}\n\nGenerate the fix JSON."
        try:
            resp = claude_call(sys_p, user_p)
            text = resp.get('content',[{}])[0].get('text','')
        except HTTPError as e:
            log(f"  Claude HTTP {e.code}: {e.read()[:200]}")
            linear_comment(issue['id'], f'[autofix-bot] Claude API failed: HTTP {e.code}')
            continue
        m = re.search(r'\{[^{}]*"file"[\s\S]*?"replace"[\s\S]*?\}', text)
        if not m:
            log(f"  no JSON in response: {text[:200]}")
            linear_comment(issue['id'], f'[autofix-bot] could not parse fix. Claude said:\n```\n{text[:500]}\n```')
            continue
        try:
            patch = json.loads(m.group(0))
        except Exception as e:
            linear_comment(issue['id'], f'[autofix-bot] invalid JSON in patch: {e}')
            continue
        fp = os.path.join(REPO, patch['file'])
        if not os.path.isfile(fp):
            linear_comment(issue['id'], f'[autofix-bot] file not found: {patch["file"]}')
            continue
        content = open(fp).read()
        if patch['search'] not in content:
            linear_comment(issue['id'], f'[autofix-bot] search text not in file. Search prefix:\n```\n{patch["search"][:200]}\n```')
            continue
        if content.count(patch['search']) > 1:
            linear_comment(issue['id'], '[autofix-bot] search text not unique - multiple matches')
            continue
        open(fp,'w').write(content.replace(patch['search'], patch['replace'], 1))
        env = {**os.environ, 'GIT_COMMITTER_NAME':'autofix-bot','GIT_AUTHOR_NAME':'autofix-bot','GIT_COMMITTER_EMAIL':'autofix@bot','GIT_AUTHOR_EMAIL':'autofix@bot'}
        subprocess.run(['git','add','-A'], cwd=REPO, check=True, env=env)
        cmsg = f"autofix({issue['identifier']}): {issue['title'][:80]}"
        subprocess.run(['git','commit','-m',cmsg], cwd=REPO, check=True, env=env)
        push = subprocess.run(['git','push','origin','vercel'], cwd=REPO, capture_output=True, text=True, env=env)
        sha = subprocess.run(['git','rev-parse','--short','HEAD'], cwd=REPO, capture_output=True, text=True).stdout.strip()
        if push.returncode != 0:
            linear_comment(issue['id'], f'[autofix-bot] PUSH FAILED:\n```\n{push.stderr[:500]}\n```')
            continue
        linear_comment(issue['id'], f'[autofix-bot] patched at {sha}, pushed to vercel branch.\nFile: `{patch["file"]}`\nVerify Vercel deployment in ~90s.')
        log(f"  -> {sha}")
    log("done")

if __name__ == '__main__':
    try:
        main()
    except Exception as e:
        log(f"FATAL: {type(e).__name__}: {e}")
        sys.exit(1)
