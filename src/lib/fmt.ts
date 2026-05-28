export const safeFixed = (n: number | null | undefined, d = 2, fallback = '—'): string =>
  n == null || !isFinite(n as number) ? fallback : (n as number).toFixed(d);

export const safePct = (n: number | null | undefined, d = 1, fallback = '—'): string =>
  n == null || !isFinite(n as number) ? fallback : `${(n as number).toFixed(d)}%`;

export const safeDollar = (n: number | null | undefined, d = 2, fallback = '—'): string =>
  n == null || !isFinite(n as number) ? fallback : `$${(n as number).toFixed(d)}`;
