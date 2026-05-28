'use client';
import { useState, useEffect, useRef, useCallback } from 'react';

interface LiveData {
  portfolio: { equity: number; cash: number; buying_power: number } | null;
  crypto: { btc: number; eth: number; sol: number } | null;
  signal: { direction: string; last_action: string; signal_time: string | null; signal_count: number } | null;
  regime: { regime: string } | null;
  connected: boolean;
  lastUpdate: number | null;
}

export function useLiveStream(enabled: boolean = true): LiveData {
  const [data, setData] = useState<LiveData>({
    portfolio: null, crypto: null, signal: null, regime: null,
    connected: false, lastUpdate: null,
  });
  const esRef = useRef<EventSource | null>(null);
  const retryRef = useRef<NodeJS.Timeout | null>(null);

  const connect = useCallback(() => {
    if (!enabled) return;
    if (esRef.current) { esRef.current.close(); }

    const es = new EventSource('/api/live-stream');
    esRef.current = es;

    es.addEventListener('connected', () => {
      setData(prev => ({ ...prev, connected: true }));
    });

    es.addEventListener('update', (e) => {
      try {
        const parsed = JSON.parse(e.data);
        setData(prev => ({
          ...prev,
          portfolio: parsed.portfolio || prev.portfolio,
          crypto: parsed.crypto || prev.crypto,
          signal: parsed.signal || prev.signal,
          regime: parsed.regime || prev.regime,
          lastUpdate: parsed.ts,
          connected: true,
        }));
      } catch {}
    });

    es.addEventListener('heartbeat', () => {
      setData(prev => ({ ...prev, connected: true }));
    });

    es.onerror = () => {
      setData(prev => ({ ...prev, connected: false }));
      es.close();
      // Retry in 5 seconds
      // eslint-disable-next-line react-hooks/immutability
      retryRef.current = setTimeout(connect, 5000);
    };
  }, [enabled]);

  useEffect(() => {
    connect();
    return () => {
      if (esRef.current) esRef.current.close();
      if (retryRef.current) clearTimeout(retryRef.current);
    };
  }, [connect]);

  return data;
}
