'use client';

import { useState, useCallback } from 'react';
import { ExternalLink, RefreshCw, Activity } from 'lucide-react';

const WEBUI_URL = 'http://localhost:7070';

export function KronosLabPage() {
  const [key, setKey] = useState(0);
  const [status, setStatus] = useState<'loading' | 'ok' | 'error'>('loading');

  const reload = useCallback(() => {
    setStatus('loading');
    setKey(k => k + 1);
  }, []);

  return (
    <div style={{ display: 'flex', flexDirection: 'column', height: '100%', background: '#0a0f14', color: '#e0e0e0' }}>
      {/* Header bar */}
      <div style={{
        display: 'flex', alignItems: 'center', gap: 12, padding: '8px 16px',
        background: '#0d1a26', borderBottom: '1px solid #1a3a4a', flexShrink: 0,
      }}>
        <Activity size={16} color="#ce93d8" />
        <span style={{ fontFamily: 'var(--font-mc-mono)', fontWeight: 700, fontSize: 13, color: '#ce93d8', letterSpacing: 2 }}>
          KRONOS LAB
        </span>
        <span style={{ fontFamily: 'var(--font-mc-mono)', fontSize: 11, color: '#607d8b', marginLeft: 8 }}>
          shiyu-coder/Kronos · Flask + Plotly · :7070
        </span>
        <div style={{ marginLeft: 'auto', display: 'flex', gap: 8, alignItems: 'center' }}>
          {status === 'error' && (
            <span style={{ fontFamily: 'var(--font-mc-mono)', fontSize: 11, color: '#ef5350' }}>
              webui offline — run: systemctl --user start kronos-webui
            </span>
          )}
          <button
            onClick={reload}
            title="Reload webui"
            style={{ background: '#1a3a4a', border: 'none', borderRadius: 4, padding: '4px 8px', cursor: 'pointer', color: '#e0e0e0', display: 'flex', alignItems: 'center', gap: 4 }}
          >
            <RefreshCw size={13} />
          </button>
          <a
            href={WEBUI_URL}
            target="_blank"
            rel="noopener noreferrer"
            style={{ background: '#1a3a4a', border: 'none', borderRadius: 4, padding: '4px 8px', cursor: 'pointer', color: '#e0e0e0', display: 'flex', alignItems: 'center', gap: 4, textDecoration: 'none' }}
            title="Open in new tab"
          >
            <ExternalLink size={13} />
          </a>
        </div>
      </div>

      {/* iframe */}
      <div style={{ flex: 1, position: 'relative' }}>
        {status === 'loading' && (
          <div style={{
            position: 'absolute', inset: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
            background: '#0a0f14', zIndex: 1, fontFamily: 'var(--font-mc-mono)', color: '#607d8b', fontSize: 13,
          }}>
            LOADING KRONOS LAB...
          </div>
        )}
        <iframe
          key={key}
          src={WEBUI_URL}
          style={{ width: '100%', height: '100%', border: 'none', display: 'block' }}
          onLoad={() => setStatus('ok')}
          onError={() => setStatus('error')}
          title="Kronos Lab"
        />
      </div>
    </div>
  );
}
