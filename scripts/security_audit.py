#!/usr/bin/env python3
"""
security_audit.py — Checks server security posture
Run periodically or after any config change.
"""

import subprocess
import os
import json
import glob
import re

SECRETS_DIR = "/home/ubuntu/.openclaw/secrets"
WORKSPACE = "/home/ubuntu/.openclaw/workspace"
MC_DIR = "/home/ubuntu/mission-control-restored"
RESULTS = []


def check(name, status, detail=""):
    emoji = "✅" if status == "PASS" else "❌" if status == "FAIL" else "⚠️"
    RESULTS.append({"name": name, "status": status, "detail": detail})
    print(f"  {emoji} {name}: {detail}")


def run(cmd):
    try:
        r = subprocess.run(cmd, shell=True, capture_output=True, text=True, timeout=10)
        return r.stdout.strip()
    except:
        return ""


def audit_firewall():
    print("\n▎ FIREWALL")
    ufw = run("sudo ufw status 2>/dev/null")
    if "active" in ufw.lower():
        check("UFW Firewall", "PASS", "Active")
        # Check which ports are allowed
        lines = [l for l in ufw.split('\n') if 'ALLOW' in l]
        for l in lines[:10]:
            print(f"    {l.strip()}")
    elif "inactive" in ufw.lower():
        check("UFW Firewall", "FAIL", "INACTIVE — run: sudo ufw enable")
    else:
        check("UFW Firewall", "WARN", f"Could not determine status: {ufw[:50]}")


def audit_ports():
    print("\n▎ LISTENING PORTS")
    ports = run("ss -tlnp 2>/dev/null")
    exposed = []
    for line in ports.split('\n'):
        if '0.0.0.0:' in line or ':::' in line:
            # Extract port
            match = re.search(r':(\d+)\s', line)
            if match:
                port = match.group(1)
                if port not in ('22', '80', '443'):
                    exposed.append(port)
                    check(f"Port {port}", "WARN", f"Publicly listening — {line.strip()[-40:]}")

    if not exposed:
        check("External Ports", "PASS", "Only 22, 80, 443 exposed")

    # Check if internal services are bound to localhost
    for service, port in [("Dashboard", "3033"), ("Signal Receiver", "8420")]:
        if f"0.0.0.0:{port}" in ports:
            check(f"{service} ({port})", "WARN", "Bound to 0.0.0.0 — should be 127.0.0.1")
        elif f"127.0.0.1:{port}" in ports:
            check(f"{service} ({port})", "PASS", "Bound to localhost only")


def audit_secrets():
    print("\n▎ SECRETS PERMISSIONS")
    # Check directory permissions
    dir_perms = run(f"stat -c '%a' {SECRETS_DIR} 2>/dev/null")
    if dir_perms == "700":
        check("Secrets directory", "PASS", f"chmod {dir_perms}")
    else:
        check("Secrets directory", "FAIL", f"chmod {dir_perms} — should be 700")

    # Check individual file permissions
    bad_perms = []
    for f in glob.glob(os.path.join(SECRETS_DIR, "*")):
        perms = run(f"stat -c '%a' '{f}' 2>/dev/null")
        if perms and perms not in ("600", "700"):
            bad_perms.append(f"{os.path.basename(f)}: {perms}")

    if bad_perms:
        check("Secret file permissions", "FAIL", f"{len(bad_perms)} files not chmod 600")
        for b in bad_perms[:5]:
            print(f"    Fix: {b}")
    else:
        check("Secret file permissions", "PASS", "All files chmod 600/700")


def audit_keys_in_code():
    print("\n▎ EXPOSED KEYS IN CODE")
    # Search for hardcoded keys in source files
    patterns = [
        "APCA-API-KEY",
        "sk-ant-",
        "sk-proj-",
        "AIza",
        "xox[bpas]-",
    ]

    exposed = []
    for ext in ["*.py", "*.js", "*.ts", "*.tsx", "*.json", "*.env"]:
        for filepath in glob.glob(os.path.join(MC_DIR, "**", ext), recursive=True):
            if 'node_modules' in filepath or '.next' in filepath:
                continue
            try:
                with open(filepath, 'r', errors='ignore') as f:
                    content = f.read()
                for pattern in patterns:
                    if pattern in content:
                        exposed.append(f"{os.path.relpath(filepath, MC_DIR)}: contains {pattern}...")
            except:
                pass

    if exposed:
        check("Hardcoded keys", "FAIL", f"{len(exposed)} files contain API keys")
        for e in exposed[:10]:
            print(f"    {e}")
    else:
        check("Hardcoded keys", "PASS", "No API keys found in source code")

    # Check workspace for keys
    workspace_exposed = []
    for filepath in glob.glob(os.path.join(WORKSPACE, "**", "*.md"), recursive=True):
        try:
            with open(filepath, 'r') as f:
                content = f.read()
            for pattern in patterns:
                if pattern in content:
                    workspace_exposed.append(os.path.basename(filepath))
        except:
            pass

    if workspace_exposed:
        check("Keys in workspace", "WARN", f"{len(workspace_exposed)} workspace files contain key patterns")
    else:
        check("Keys in workspace", "PASS", "No keys found in workspace markdown files")


def audit_env_files():
    print("\n▎ ENV FILES")
    # Check if .env files are in .gitignore
    gitignore = os.path.join(MC_DIR, ".gitignore")
    if os.path.exists(gitignore):
        with open(gitignore) as f:
            content = f.read()
        if ".env" in content:
            check(".env in .gitignore", "PASS", "Excluded from git")
        else:
            check(".env in .gitignore", "FAIL", "Add .env* to .gitignore")
    else:
        check(".gitignore", "WARN", "No .gitignore found")

    # Check if .env files are readable by web
    env_path = os.path.join(MC_DIR, ".env.local")
    if os.path.exists(env_path):
        perms = run(f"stat -c '%a' '{env_path}' 2>/dev/null")
        if perms in ("600", "640"):
            check(".env.local permissions", "PASS", f"chmod {perms}")
        else:
            check(".env.local permissions", "WARN", f"chmod {perms} — consider 600")


def audit_nginx():
    print("\n▎ NGINX CONFIG")
    nginx_conf = run("cat /etc/nginx/sites-enabled/* 2>/dev/null")

    # Check if sensitive paths are blocked
    sensitive_paths = [".env", ".git", "secrets", "node_modules"]
    for path in sensitive_paths:
        if f"location ~ /\\.{path}" in nginx_conf or f"deny all" in nginx_conf:
            check(f"Block /{path}", "PASS", "Denied in nginx")
        else:
            check(f"Block /{path}", "WARN", f"/{path} not explicitly blocked — add deny rule")

    # Check SSL
    if "ssl_certificate" in nginx_conf:
        check("SSL/HTTPS", "PASS", "Certificate configured")
    else:
        check("SSL/HTTPS", "WARN", "No SSL certificate found in nginx config")


def audit_wallet_api():
    print("\n▎ WALLET API")
    # Check if wallet endpoint requires auth
    result = run("curl -s -o /dev/null -w '%{http_code}' http://localhost:3033/api/wallets 2>/dev/null")
    if result == "401":
        check("Wallet API auth", "PASS", "Returns 401 without auth")
    elif result == "200":
        check("Wallet API auth", "FAIL", "Returns 200 without auth — anyone can see balances")
    else:
        check("Wallet API auth", "WARN", f"Returned {result}")


def audit_pm2():
    print("\n▎ PM2 PROCESSES")
    pm2_list = run("pm2 jlist 2>/dev/null")
    try:
        procs = json.loads(pm2_list)
        high_restarts = [p for p in procs if p['pm2_env']['restart_time'] > 50]
        if high_restarts:
            for p in high_restarts:
                check(f"PM2 {p['name']}", "WARN",
                    f"{p['pm2_env']['restart_time']} restarts — possible crash loop")
        else:
            check("PM2 stability", "PASS", "No crash loops detected")
    except:
        check("PM2", "WARN", "Could not parse PM2 process list")


def main():
    print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    print("  SECURITY AUDIT")
    print(f"  {run('date')}")
    print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━")

    audit_firewall()
    audit_ports()
    audit_secrets()
    audit_keys_in_code()
    audit_env_files()
    audit_nginx()
    audit_wallet_api()
    audit_pm2()

    # Summary
    fails = [r for r in RESULTS if r["status"] == "FAIL"]
    warns = [r for r in RESULTS if r["status"] == "WARN"]
    passes = [r for r in RESULTS if r["status"] == "PASS"]

    print(f"\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━")
    print(f"  RESULTS: {len(passes)} pass | {len(warns)} warnings | {len(fails)} failures")
    print(f"━━━━━━━━━━━━━━━━━━━━━━━━━━━━")

    if fails:
        print("\n❌ CRITICAL FIXES NEEDED:")
        for f in fails:
            print(f"  • {f['name']}: {f['detail']}")

    if warns:
        print("\n⚠️ RECOMMENDED FIXES:")
        for w in warns:
            print(f"  • {w['name']}: {w['detail']}")

    # Save report
    report_path = "/home/ubuntu/.openclaw/workspace/memory/security-audit.json"
    with open(report_path, "w") as f:
        json.dump({"timestamp": run("date -Iseconds"), "results": RESULTS}, f, indent=2)
    print(f"\nReport saved: {report_path}")


if __name__ == "__main__":
    main()
