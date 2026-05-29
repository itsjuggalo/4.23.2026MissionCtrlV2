/**
 * tests/fmt.test.ts — fallback-contract invariants for src/lib/fmt.ts.
 *
 * safeFixed/safePct/safeDollar render every number on the dashboard. Their
 * guarantee is: any non-finite input (null, undefined, NaN, ±Infinity) renders
 * as the fallback ('—' by default), never as "NaN"/"Infinity"/"$null". These
 * are pure, dependency-free functions, so this locks that contract in place
 * cheaply and would catch a regression that re-exposed raw bad values to the UI.
 */

import { describe, it, expect } from 'vitest';
import { safeFixed, safePct, safeDollar } from '@/lib/fmt';

describe('fmt fallback contract', () => {
  it('falls back to — for non-finite inputs', () => {
    for (const bad of [null, undefined, NaN, Infinity, -Infinity]) {
      expect(safeFixed(bad)).toBe('—');
      expect(safePct(bad)).toBe('—');
      expect(safeDollar(bad)).toBe('—');
    }
  });

  it('formats finite values with the default precision', () => {
    expect(safeFixed(12.5)).toBe('12.50');
    expect(safePct(12.5)).toBe('12.5%');
    expect(safeDollar(12.5)).toBe('$12.50');
  });

  it('honors a custom precision and zero', () => {
    expect(safeFixed(3.14159, 3)).toBe('3.142');
    expect(safePct(0)).toBe('0.0%');
    expect(safeDollar(0)).toBe('$0.00');
  });

  it('honors a custom fallback string', () => {
    expect(safeFixed(null, 2, 'n/a')).toBe('n/a');
    expect(safePct(NaN, 1, 'n/a')).toBe('n/a');
    expect(safeDollar(undefined, 2, 'n/a')).toBe('n/a');
  });
});
