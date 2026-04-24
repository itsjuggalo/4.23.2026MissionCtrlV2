#!/usr/bin/env python3
"""CouponClaw v2 Formatter — Format results for Discord display."""


def format_response(merchant: str, codes: list, validated: bool = False) -> str:
    """Format coupon codes for Discord display."""
    merchant_display = merchant.title()
    if not codes:
        return f"❌ No coupon codes found for **{merchant_display}**"

    lines = []
    for code in codes:
        if isinstance(code, dict):
            c = code.get('code', '')
            status = code.get('status', 'untested')
            discount = code.get('discount', '')
            icon = "✅" if status == 'success' else "❌" if status == 'failed' else "❓"
            line = f"{icon} `{c}` — {status}"
            if discount:
                line += f" ({discount})"
            lines.append(line)
        else:
            lines.append(f"❓ `{code}` — untested")

    status_text = "validated" if validated else "unverified"
    return (
        f"🎟️ **{merchant_display}** — {len(codes)} codes ({status_text})\n\n"
        + "\n".join(lines)
    )


def format_validation_results(merchant: str, results: list) -> str:
    """Format validation results for Discord."""
    merchant_display = merchant.title()

    working = [r for r in results if r.get('status') == 'success']
    failed = [r for r in results if r.get('status') == 'failed']
    untested = [r for r in results if r.get('status') not in ('success', 'failed')]

    lines = []

    if working:
        lines.append("**✅ WORKING:**")
        for r in working:
            line = f"  ✅ `{r['code']}`"
            if r.get('discount'):
                line += f" — {r['discount']}"
            lines.append(line)

    if untested:
        lines.append("\n**❓ UNTESTED:**")
        for r in untested[:5]:
            line = f"  ❓ `{r['code']}`"
            if r.get('error'):
                line += f" — {r['error'][:40]}"
            lines.append(line)
        if len(untested) > 5:
            lines.append(f"  ... and {len(untested) - 5} more")

    if failed:
        lines.append(f"\n**❌ FAILED:** {len(failed)} codes")
        for r in failed[:3]:
            lines.append(f"  ❌ `{r['code']}`")
        if len(failed) > 3:
            lines.append(f"  ... and {len(failed) - 3} more")

    platform = results[0].get('platform', '') if results else ''
    platform_note = f" | Platform: {platform}" if platform and platform != 'unknown' else ''

    header = f"🎟️ **{merchant_display}** — {len(results)} codes tested{platform_note}\n\n"

    summary = f"\n\n📊 **Summary:** {len(working)} working · {len(failed)} failed · {len(untested)} untested"
    if working:
        summary += f"\n💡 Type `verify {merchant.lower()}` to re-test later"

    return header + "\n".join(lines) + summary
