'use client';

import { useEffect, useState } from 'react';

export type ViewMode = 'desktop' | 'mobile';

const STORAGE_KEY = 'mc-view-mode';
const BODY_CLASS_MOBILE = 'view-mobile';
const BODY_CLASS_DESKTOP = 'view-desktop';

function applyBodyClass(mode: ViewMode) {
  if (typeof document === 'undefined') return;
  document.body.classList.toggle(BODY_CLASS_MOBILE, mode === 'mobile');
  document.body.classList.toggle(BODY_CLASS_DESKTOP, mode === 'desktop');
}

/**
 * useViewMode — explicit desktop/mobile preference, persisted to localStorage.
 *
 * Returns [mode, setMode, hydrated]:
 *   • mode      — 'desktop' | 'mobile'
 *   • setMode   — persists the new value to localStorage AND toggles the
 *                 body class (view-mobile / view-desktop) so globals.css
 *                 can apply scoped overrides.
 *   • hydrated  — false until the localStorage read completes. Use to gate
 *                 SSR-sensitive rendering and avoid layout flicker.
 *
 * First-visit auto-detection: if nothing is stored, falls back to
 * window.innerWidth < 768 to pick a sensible default. Once the user makes
 * an explicit choice, the preference sticks across sessions and across
 * window resizes.
 *
 * The hook is safe to call from multiple components — each instance keeps
 * its own React state, but all writes hit the same localStorage key and
 * the same body classes, so visually they stay in sync after the next render.
 * For cross-component live sync (e.g. toggle in Sidebar updates the Landing
 * page in the same tab without a full reload), we listen for our custom
 * `mc-view-mode-change` event.
 */
export function useViewMode(): [ViewMode, (m: ViewMode) => void, boolean] {
  const [mode, setMode] = useState<ViewMode>('desktop');
  const [hydrated, setHydrated] = useState(false);

  useEffect(() => {
    let initial: ViewMode = 'desktop';
    try {
      const stored = localStorage.getItem(STORAGE_KEY);
      if (stored === 'mobile' || stored === 'desktop') {
        initial = stored;
      } else if (typeof window !== 'undefined' && window.innerWidth < 768) {
        initial = 'mobile';
      }
    } catch { /* localStorage unavailable in some browsers */ }
    setMode(initial);
    applyBodyClass(initial);
    setHydrated(true);

    // Cross-component live sync within the same tab
    const onChange = (e: Event) => {
      const v = (e as CustomEvent<ViewMode>).detail;
      if (v === 'mobile' || v === 'desktop') {
        setMode(v);
        applyBodyClass(v);
      }
    };
    // Cross-tab sync via storage event
    const onStorage = (e: StorageEvent) => {
      if (e.key !== STORAGE_KEY) return;
      if (e.newValue === 'mobile' || e.newValue === 'desktop') {
        setMode(e.newValue);
        applyBodyClass(e.newValue);
      }
    };
    window.addEventListener('mc-view-mode-change', onChange);
    window.addEventListener('storage', onStorage);
    return () => {
      window.removeEventListener('mc-view-mode-change', onChange);
      window.removeEventListener('storage', onStorage);
    };
  }, []);

  const update = (m: ViewMode) => {
    setMode(m);
    applyBodyClass(m);
    try { localStorage.setItem(STORAGE_KEY, m); } catch { /* ignore */ }
    try {
      window.dispatchEvent(new CustomEvent<ViewMode>('mc-view-mode-change', { detail: m }));
    } catch { /* ignore */ }
  };

  return [mode, update, hydrated];
}
