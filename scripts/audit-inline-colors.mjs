#!/usr/bin/env node
/**
 * audit-inline-colors.mjs
 * Greps src/components/**\/*.tsx for hex color literals not in the mc-* token whitelist.
 * Writes audit-inline-colors.md in the project root.
 *
 * Usage:
 *   node scripts/audit-inline-colors.mjs
 *
 * Exit code 1 if any offenders are found in src/components/ui/**\/*.tsx (the gate for Phase 2).
 */

import { readFileSync, writeFileSync, readdirSync, statSync } from 'fs';
import { join, relative } from 'path';
import { fileURLToPath } from 'url';

const __dirname = fileURLToPath(new URL('.', import.meta.url));
const ROOT = join(__dirname, '..');
const SRC = join(ROOT, 'src', 'components');

// Hex values that map to official mc-* tokens — these are ALLOWED
const TOKEN_WHITELIST = new Set([
  // mc-bg
  '#0d1117',
  // mc-bg-card / mc-bg-surface
  '#0a1929',
  // mc-bg-surface-alt
  '#0a1117',
  // mc-bg-card-hover
  '#0f2338',
  // mc-border
  '#1a3a4a',
  // mc-border-light
  '#254a5e',
  // mc-text
  '#e0e0e0',
  // mc-text-muted
  '#607d8b',
  // mc-text-dim
  '#455a64',
  // mc-accent / mc-blue / mc-cyan
  '#4fc3f7',
  // mc-accent-light
  '#81d4fa',
  // mc-green
  '#66bb6a',
  // mc-red
  '#ef5350',
  // mc-amber
  '#ff9800',
]);

// Files with intentional non-mc color palettes (widgets with their own brand colors).
// These are excluded from the gate check — Phase 1 migration only covers the mc-* shared components.
const EXCLUDED_FROM_GATE = new Set([
  'src/components/ui/PsychChatWidget.tsx',   // purple psychologist theme
  'src/components/ui/SouthParkAgent.tsx',    // cartoon avatar colors
  'src/components/ui/TerranLogo.tsx',        // logo brand color
  'src/components/ui/TickerLogo.tsx',        // ticker logo white/dark bg
  'src/components/ui/BTCBiasWidget.tsx',     // bitcoin widget brand colors
]);

// Hex regex — matches #xxx or #xxxxxx (case-insensitive)
const HEX_RE = /#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})\b/g;

function walk(dir) {
  const results = [];
  for (const entry of readdirSync(dir)) {
    const full = join(dir, entry);
    const st = statSync(full);
    if (st.isDirectory()) {
      results.push(...walk(full));
    } else if (entry.endsWith('.tsx')) {
      results.push(full);
    }
  }
  return results;
}

const files = walk(SRC);
const offenders = []; // { file, line, col, hex }

for (const filePath of files) {
  const content = readFileSync(filePath, 'utf8');
  const lines = content.split('\n');
  lines.forEach((lineText, idx) => {
    let match;
    HEX_RE.lastIndex = 0;
    while ((match = HEX_RE.exec(lineText)) !== null) {
      const raw = match[0].toLowerCase();
      // Normalize 3-char shorthand to 6-char
      const normalized =
        raw.length === 4
          ? '#' + raw[1] + raw[1] + raw[2] + raw[2] + raw[3] + raw[3]
          : raw;
      if (!TOKEN_WHITELIST.has(normalized)) {
        offenders.push({
          file: relative(ROOT, filePath),
          line: idx + 1,
          col: match.index + 1,
          hex: match[0],
        });
      }
    }
  });
}

// UI offenders — excludes intentional-brand widget files
const uiOffenders = offenders.filter(
  (o) => o.file.startsWith('src/components/ui/') && !EXCLUDED_FROM_GATE.has(o.file)
);
const excludedWidgetOffenders = offenders.filter(
  (o) => o.file.startsWith('src/components/ui/') && EXCLUDED_FROM_GATE.has(o.file)
);
const otherOffenders = offenders.filter((o) => !o.file.startsWith('src/components/ui/'));

// Build markdown report
const lines = [
  '# Inline Color Audit',
  '',
  `Generated: ${new Date().toISOString()}`,
  '',
  `## Summary`,
  '',
  `| Scope | Offender count |`,
  `|---|---|`,
  `| \`src/components/ui/\` mc-* shared (Phase 1 gate) | ${uiOffenders.length} |`,
  `| \`src/components/ui/\` brand-widget files (excluded from gate) | ${excludedWidgetOffenders.length} |`,
  `| Other \`src/components/\` | ${otherOffenders.length} |`,
  `| **Total** | **${offenders.length}** |`,
  '',
];

if (uiOffenders.length === 0) {
  lines.push('## src/components/ui/ — PASS (0 offenders)');
  lines.push('');
} else {
  lines.push('## src/components/ui/ — FAIL');
  lines.push('');
  lines.push('| File | Line | Col | Hex |');
  lines.push('|---|---|---|---|');
  for (const o of uiOffenders) {
    lines.push(`| \`${o.file}\` | ${o.line} | ${o.col} | \`${o.hex}\` |`);
  }
  lines.push('');
}

if (excludedWidgetOffenders.length > 0) {
  lines.push('## src/components/ui/ brand-widget files — excluded from gate (informational)');
  lines.push('');
  lines.push('These files use intentional non-mc color palettes and are excluded from the Phase 1 gate.');
  lines.push('');
  lines.push('| File | Line | Col | Hex |');
  lines.push('|---|---|---|---|');
  for (const o of excludedWidgetOffenders) {
    lines.push(`| \`${o.file}\` | ${o.line} | ${o.col} | \`${o.hex}\` |`);
  }
  lines.push('');
}

if (otherOffenders.length > 0) {
  lines.push('## Other src/components/ — informational only (no action required)');
  lines.push('');
  lines.push('| File | Line | Col | Hex |');
  lines.push('|---|---|---|---|');
  for (const o of otherOffenders) {
    lines.push(`| \`${o.file}\` | ${o.line} | ${o.col} | \`${o.hex}\` |`);
  }
  lines.push('');
} else {
  lines.push('## Other src/components/ — 0 offenders (informational)');
  lines.push('');
}

const report = lines.join('\n');
writeFileSync(join(ROOT, 'audit-inline-colors.md'), report);
console.log(report);

if (uiOffenders.length > 0) {
  console.error(
    `\nFAIL: ${uiOffenders.length} hex offenders in src/components/ui/ — Phase 2 is blocked.`
  );
  process.exit(1);
} else {
  console.log('\nPASS: 0 hex offenders in src/components/ui/ — Phase 2 is unblocked.');
  process.exit(0);
}
