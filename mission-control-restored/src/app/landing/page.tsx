'use client';
import { useState, useRef, useEffect } from 'react';
import Link from 'next/link';
import LandingBanner from '@/components/starcraft/LandingBanner';

type ModeKey = 'auto' | 'fast' | 'expert' | 'copilot' | 'support';

const MODES: Record<ModeKey, { label: string; desc: string; Icon: React.FC<{ size?: number; color?: string }> }> = {
  auto:    { label: 'Auto',    desc: 'Adapts models to each query',     Icon: ShuffleIcon },
  fast:    { label: 'Fast',    desc: 'Respond quicker to act sooner',   Icon: SpiralIcon },
  expert:  { label: 'Expert',  desc: 'Think further to explore deeper', Icon: AtomIcon },
  copilot: { label: 'Copilot', desc: 'Talk to your interface',          Icon: IntersectIcon },
  support: { label: 'Support', desc: 'AI speed, human care',            Icon: HeadsetIcon },
};

const QUICK_ACTIONS = [
  { label: 'Quick Insights',    icon: '✦', query: 'Give me a quick overview of my portfolio performance, open positions, and key metrics right now.' },
  { label: 'Trade Decision',    icon: '◎', query: 'Based on current market regime, signals, and my portfolio state — should I be trading right now? What setups look best?' },
  { label: 'Stock Health Check', icon: '♡', query: 'Run a health check on my current positions. Show P&L, risk exposure, and any positions that need attention.' },
  { label: 'News Scanner',      icon: '✧', query: 'What are the most important market-moving news items today that could affect my positions?' },
  { label: 'Price Forecast',    icon: '↗', query: 'What is the BTC price outlook for the next 1-4 weeks? Include technical levels, regime context, and key catalysts.' },
  { label: 'Crypto Compass',    icon: '◇', query: 'Give me a comprehensive crypto market overview — BTC dominance, ETH ratio, altcoin sentiment, and key levels to watch.' },
  { label: 'Top Stock Picks',   icon: '★', query: 'Based on congressional trading activity and LLM portfolio signals, what are the top stock picks right now?' },
  { label: 'Earnings Insight',  icon: '📊', query: 'What upcoming earnings events in the next 7 days could impact my portfolio or create trading opportunities?' },
  { label: 'Pattern Screening', icon: '◫', query: 'Scan for technical patterns on my watched tickers — breakouts, reversals, momentum shifts.' },
  { label: 'Congress Watch',    icon: '🏛', query: 'What are the latest suspicious or notable congressional trades? Any insider-level signals?' },
  { label: 'LLM Leaderboard',   icon: '🤖', query: 'How are the AI model portfolios performing? Show the leaderboard with returns and recent trades.' },
  { label: 'Alert',             icon: '⚠', query: 'Are there any alerts, issues, or warnings I should know about right now across my systems?' },
];

const TICKERS = ['BTC','ETH','NVDA','AAPL','MSFT','TSLA','PLTR','AMZN','GOOGL','META','AMD','MU','AVGO','COIN','VST','CEG','LLY','JPM','COST'];

// ============================================================================
// ICON COMPONENTS
// ============================================================================

function ShuffleIcon({ size = 16, color = 'currentColor' }: { size?: number; color?: string }) {
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke={color} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M16 3h5v5" /><path d="M4 20L21 3" /><path d="M21 16v5h-5" /><path d="M15 15l6 6" /><path d="M4 4l5 5" />
    </svg>
  );
}
function SpiralIcon({ size = 16, color = 'currentColor' }: { size?: number; color?: string }) {
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke={color} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M12 21a9 9 0 1 1 9-9" /><path d="M12 17a5 5 0 1 0-5-5" /><circle cx="12" cy="12" r="1" />
    </svg>
  );
}
function AtomIcon({ size = 16, color = 'currentColor' }: { size?: number; color?: string }) {
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke={color} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <circle cx="12" cy="12" r="2" />
      <ellipse cx="12" cy="12" rx="10" ry="4.5" />
      <ellipse cx="12" cy="12" rx="10" ry="4.5" transform="rotate(60 12 12)" />
      <ellipse cx="12" cy="12" rx="10" ry="4.5" transform="rotate(120 12 12)" />
    </svg>
  );
}
function IntersectIcon({ size = 16, color = 'currentColor' }: { size?: number; color?: string }) {
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke={color} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M1 8c4 0 6 8 10 8s6-8 10-8" /><path d="M1 16c4 0 6-8 10-8s6 8 10 8" />
    </svg>
  );
}
function HeadsetIcon({ size = 16, color = 'currentColor' }: { size?: number; color?: string }) {
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke={color} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M3 14v-2a9 9 0 0 1 18 0v2" />
      <path d="M3 14a2 2 0 0 1 2-2h1v5H5a2 2 0 0 1-2-2v-1z" />
      <path d="M21 14a2 2 0 0 0-2-2h-1v5h1a2 2 0 0 0 2-2v-1z" />
      <path d="M18 17v1a3 3 0 0 1-3 3h-2" />
    </svg>
  );
}
function PaperclipIcon() {
  return (
    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <path d="M21.44 11.05l-9.19 9.19a6 6 0 0 1-8.49-8.49l9.19-9.19a4 4 0 0 1 5.66 5.66l-9.2 9.19a2 2 0 0 1-2.83-2.83l8.49-8.48" />
    </svg>
  );
}
function ImageIcon() {
  return (
    <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
      <rect x="3" y="3" width="18" height="18" rx="2" ry="2" /><circle cx="8.5" cy="8.5" r="1.5" /><path d="M21 15l-5-5L5 21" />
    </svg>
  );
}
function SparkleIcon() {
  return (
    <svg width="14" height="14" viewBox="0 0 24 24" fill="currentColor">
      <path d="M12 2l1.5 5.5L19 9l-5.5 1.5L12 16l-1.5-5.5L5 9l5.5-1.5z" />
      <path d="M19 15l.75 2.75L22 18.5l-2.25.75L19 22l-.75-2.75L16 18.5l2.25-.75z" />
    </svg>
  );
}

// ============================================================================
// MAIN PAGE
// ============================================================================

export default function WelcomePage() {
  const [input, setInput] = useState('');
  const [mode, setMode] = useState<ModeKey>('auto');
  const [modeOpen, setModeOpen] = useState(false);
  const [answer, setAnswer] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);
  const [modelUsed, setModelUsed] = useState('');
  const [showMoreActions, setShowMoreActions] = useState(false);
  const inputRef = useRef<HTMLTextAreaElement>(null);
  const modeMenuRef = useRef<HTMLDivElement>(null);
  const actionsRef = useRef<HTMLDivElement>(null);

  useEffect(() => { inputRef.current?.focus(); }, []);

  useEffect(() => {
    function handler(e: MouseEvent) {
      if (modeMenuRef.current && !modeMenuRef.current.contains(e.target as Node)) setModeOpen(false);
      if (actionsRef.current && !actionsRef.current.contains(e.target as Node)) setShowMoreActions(false);
    }
    document.addEventListener('mousedown', handler);
    return () => document.removeEventListener('mousedown', handler);
  }, []);

  async function submit(text?: string) {
    const msg = (text || input).trim();
    if (!msg || loading) return;
    if (!text) { /* user typed it, it's already in input */ } else { setInput(msg); }
    setLoading(true); setError(''); setAnswer(''); setModelUsed('');
    try {
      const res = await fetch('/api/copilot', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ message: msg, mode }),
      });
      const data = await res.json();
      if (data.error) setError(data.error);
      else { setAnswer(data.response || '(empty)'); setModelUsed(data.model || ''); }
    } catch (e) { setError(e instanceof Error ? e.message : String(e)); }
    finally { setLoading(false); }
  }

  function onKeyDown(e: React.KeyboardEvent) {
    if (e.key === 'Enter' && !e.shiftKey) { e.preventDefault(); submit(); }
  }

  function clickAction(query: string) {
    setInput(query);
    setShowMoreActions(false);
    setTimeout(() => submit(query), 50);
  }

  const activeMode = MODES[mode];
  const visibleActions = QUICK_ACTIONS.slice(0, 5);
  const moreActions = QUICK_ACTIONS.slice(5);

  return (
    <div style={{ minHeight: '100vh', background: '#0d1117', color: '#e0e0e0', fontFamily: "'Inter', sans-serif", position: 'relative', overflow: 'hidden', display: 'flex', flexDirection: 'column' }}>
      <style dangerouslySetInnerHTML={{ __html: `
@keyframes wf { 0%, 100% { transform: translate(0,0); opacity: 0.1; } 50% { transform: translate(8px, -6px); opacity: 0.18; } }
@keyframes wb { 0%, 100% { opacity: 1; } 50% { opacity: 0.4; } }
@keyframes wr { from { transform: rotate(0deg); } to { transform: rotate(360deg); } }
@keyframes wgs { 0% { background-position: 0% 50%; } 50% { background-position: 100% 50%; } 100% { background-position: 0% 50%; } }
@keyframes wfi { from { opacity: 0; transform: translateY(6px); } to { opacity: 1; transform: translateY(0); } }
.wi::placeholder { color: #455a64; font-size: 16px; font-family: 'Inter', sans-serif; }
.wi:focus { outline: none; }
.wgb { background: linear-gradient(90deg, #4fc3f7 0%, #81d4fa 25%, #ff9800 50%, #81d4fa 75%, #4fc3f7 100%); background-size: 200% 200%; animation: wgs 6s ease infinite; }
.qa-btn { padding: 7px 14px; background: rgba(10,25,41,0.7); border: 1px solid #1a3a4a; border-radius: 100px; color: #e0e0e0; font-family: 'Inter', sans-serif; font-size: 12px; font-weight: 600; cursor: pointer; white-space: nowrap; transition: border-color 0.15s, background 0.15s; display: inline-flex; align-items: center; gap: 6px; backdrop-filter: blur(8px); }
.qa-btn:hover { border-color: #4fc3f7; background: rgba(79,195,247,0.06); }
.ub { width: 34px; height: 34px; border-radius: 50%; border: none; background: transparent; color: #607d8b; cursor: pointer; display: flex; align-items: center; justify-content: center; transition: color 0.15s, background 0.15s; }
.ub:hover { color: #4fc3f7; background: rgba(79,195,247,0.08); }
` }} />

      {/* Background layers */}
      <div style={{ position: 'absolute', inset: 0, background: 'radial-gradient(circle at 15% 20%, rgba(79,195,247,0.08) 0%, transparent 45%), radial-gradient(circle at 85% 80%, rgba(255,152,0,0.06) 0%, transparent 45%), radial-gradient(circle at 50% 50%, rgba(79,195,247,0.04) 0%, transparent 60%)', pointerEvents: 'none' }} />
      <div style={{ position: 'absolute', inset: 0, backgroundImage: 'radial-gradient(rgba(79,195,247,0.08) 1px, transparent 1px)', backgroundSize: '32px 32px', pointerEvents: 'none' }} />

      {/* Floating tickers */}
      {TICKERS.map((t, i) => {
        const positions = [
          {l:8,t:15},{l:18,t:65},{l:28,t:25},{l:42,t:75},{l:58,t:18},{l:72,t:68},{l:82,t:30},{l:92,t:80},
          {l:12,t:42},{l:25,t:85},{l:38,t:48},{l:50,t:10},{l:65,t:45},{l:78,t:12},{l:88,t:55},{l:5,t:88},
          {l:48,t:92},{l:68,t:88},{l:95,t:8},
        ];
        const p = positions[i % positions.length];
        return (
          <div key={t} style={{ position: 'absolute', left: `${p.l}%`, top: `${p.t}%`, fontFamily: "'Orbitron', monospace", fontSize: 20+((i*7)%32), fontWeight: 900, color: '#4fc3f7', opacity: 0.12, letterSpacing: 2, pointerEvents: 'none', animation: `wf 8s ease-in-out infinite`, animationDelay: `${(i*0.5)%6}s`, userSelect: 'none' }}>{t}</div>
        );
      })}

      {/* Top bar */}
      <div style={{ position: 'relative', zIndex: 10, padding: '16px 28px', display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
          <div style={{ width: 8, height: 8, borderRadius: '50%', background: '#66bb6a', boxShadow: '0 0 8px #66bb6a', animation: 'wb 1.4s infinite' }} />
          <span style={{ fontFamily: "'JetBrains Mono', monospace", fontSize: 11, color: '#66bb6a', fontWeight: 700, letterSpacing: 1 }}>SYSTEMS ONLINE</span>
        </div>
        <Link href="/dashboard" style={{ fontFamily: "'Orbitron', monospace", fontSize: 11, fontWeight: 900, letterSpacing: 2, color: '#ff9800', textDecoration: 'none', padding: '9px 18px', border: '1px solid #ff9800', borderRadius: 20, background: 'rgba(255,152,0,0.06)' }}>ENTER MISSION CTRL →</Link>
      </div>

      {/* HERO */}
      <div style={{ flex: 1, display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', padding: '0 24px 60px', position: 'relative', zIndex: 5 }}>
        {/* Pill badge */}
        <div style={{ display: 'inline-flex', alignItems: 'center', gap: 6, padding: '5px 14px', background: 'linear-gradient(90deg, rgba(79,195,247,0.2), rgba(129,212,250,0.2))', border: '1px solid rgba(79,195,247,0.4)', borderRadius: 100, fontSize: 13, fontWeight: 600, color: '#81d4fa', marginBottom: 18, backdropFilter: 'blur(10px)' }}>
          <span style={{ color: '#4fc3f7', display: 'inline-flex' }}><SparkleIcon /></span>
          <span>Copilot</span>
        </div>

        {/* StarCraft landing banner */}
        <div style={{ width: '100%', maxWidth: 900, marginBottom: 28 }}>
          <LandingBanner height={180} />
        </div>

        {/* Title */}
        <h1 style={{ fontFamily: "'Orbitron', sans-serif", fontSize: 'clamp(56px, 9vw, 104px)', fontWeight: 900, letterSpacing: '0.04em', margin: 0, lineHeight: 1, color: '#ffffff', textShadow: '0 0 40px rgba(79,195,247,0.5), 0 0 80px rgba(79,195,247,0.2)', textAlign: 'center' }}>
          MISSION CTRL
        </h1>
        <p style={{ fontSize: 'clamp(14px, 1.4vw, 18px)', color: '#81d4fa', margin: '14px 0 0', fontWeight: 400, letterSpacing: '0.02em' }}>
          Your AI Trading Command Console with Deep Insights
        </p>

        {/* Chat box */}
        <div style={{ width: '100%', maxWidth: 780, marginTop: 44, position: 'relative' }}>
          <div className="wgb" style={{ padding: 2, borderRadius: 20 }}>
            <div style={{ background: 'rgba(10,25,41,0.92)', borderRadius: 18, padding: '22px 24px 14px', minHeight: 160, position: 'relative', backdropFilter: 'blur(20px)' }}>
              <textarea ref={inputRef} className="wi" value={input} onChange={(e) => setInput(e.target.value)} onKeyDown={onKeyDown} placeholder="Ask me anything..." rows={3}
                style={{ width: '100%', background: 'transparent', border: 'none', color: '#e0e0e0', fontFamily: "'Inter', sans-serif", fontSize: 16, resize: 'none', lineHeight: 1.5, boxSizing: 'border-box', padding: 0, minHeight: 72 }} />

              {/* Bottom bar: mode pill | upload buttons | submit */}
              <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginTop: 8 }}>
                {/* Mode dropdown pill */}
                <div ref={modeMenuRef} style={{ position: 'relative' }}>
                  <button onClick={() => setModeOpen((v) => !v)}
                    style={{ display: 'inline-flex', alignItems: 'center', gap: 8, padding: '8px 12px 8px 14px', background: '#0d1117', border: `1px solid ${modeOpen ? '#4fc3f7' : '#1a3a4a'}`, borderRadius: 100, color: '#4fc3f7', fontSize: 13, fontWeight: 600, cursor: 'pointer', transition: 'border-color 0.15s', fontFamily: "'Inter', sans-serif" }}
                    onMouseEnter={(e) => { e.currentTarget.style.borderColor = '#4fc3f7'; }}
                    onMouseLeave={(e) => { if (!modeOpen) e.currentTarget.style.borderColor = '#1a3a4a'; }}>
                    <activeMode.Icon size={16} color="#4fc3f7" />
                    <span>{activeMode.label}</span>
                    <span style={{ display: 'inline-block', transform: modeOpen ? 'rotate(180deg)' : 'none', transition: 'transform 0.15s', fontSize: 10, color: '#4fc3f7' }}>▲</span>
                  </button>

                  {modeOpen && (
                    <div style={{ position: 'absolute', bottom: 'calc(100% + 8px)', left: 0, minWidth: 280, background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: 12, padding: 6, boxShadow: '0 10px 40px rgba(0,0,0,0.6)', zIndex: 20, animation: 'wfi 0.15s ease-out' }}>
                      {(Object.keys(MODES) as ModeKey[]).map((k) => {
                        const m = MODES[k]; const active = k === mode;
                        return (
                          <button key={k} onClick={() => { setMode(k); setModeOpen(false); }}
                            style={{ width: '100%', display: 'flex', alignItems: 'center', gap: 12, padding: '10px 12px', background: 'transparent', border: 'none', borderRadius: 8, cursor: 'pointer', textAlign: 'left', transition: 'background 0.1s' }}
                            onMouseEnter={(e) => { e.currentTarget.style.background = 'rgba(79,195,247,0.06)'; }}
                            onMouseLeave={(e) => { e.currentTarget.style.background = 'transparent'; }}>
                            <span style={{ flexShrink: 0, display: 'inline-flex', alignItems: 'center', justifyContent: 'center', width: 20 }}>
                              <m.Icon size={18} color={active ? '#4fc3f7' : '#9ca3af'} />
                            </span>
                            <div style={{ flex: 1 }}>
                              <div style={{ fontSize: 14, fontWeight: 700, color: active ? '#4fc3f7' : '#e0e0e0' }}>{m.label}</div>
                              <div style={{ fontSize: 11, color: '#607d8b', marginTop: 2 }}>{m.desc}</div>
                            </div>
                            {active && <span style={{ color: '#4fc3f7', fontSize: 16, fontWeight: 900 }}>✓</span>}
                          </button>
                        );
                      })}
                    </div>
                  )}
                </div>

                {/* Right side: upload buttons + submit */}
                <div style={{ display: 'flex', alignItems: 'center', gap: 4 }}>
                  <button className="ub" title="Attach file (coming soon)" onClick={() => {}}><PaperclipIcon /></button>
                  <button className="ub" title="Upload image (coming soon)" onClick={() => {}}><ImageIcon /></button>
                  <button onClick={() => submit()} disabled={!input.trim() || loading}
                    style={{ width: 42, height: 42, borderRadius: '50%', border: 'none', marginLeft: 4,
                      background: input.trim() && !loading ? 'linear-gradient(135deg, #4fc3f7, #0288d1)' : '#1a3a4a',
                      color: input.trim() && !loading ? '#ffffff' : '#455a64',
                      cursor: input.trim() && !loading ? 'pointer' : 'not-allowed',
                      fontSize: 18, fontWeight: 900, display: 'flex', alignItems: 'center', justifyContent: 'center',
                      boxShadow: input.trim() && !loading ? '0 4px 16px rgba(79,195,247,0.4)' : 'none',
                      transition: 'all 0.15s' }}>
                    {loading ? <span style={{ animation: 'wr 1s linear infinite', display: 'inline-block' }}>◌</span> : '↑'}
                  </button>
                </div>
              </div>
            </div>
          </div>

          {/* Quick action buttons — scrollable row with ≡ for more */}
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginTop: 14, position: 'relative' }}>
            {visibleActions.map((a) => (
              <button key={a.label} className="qa-btn" onClick={() => clickAction(a.query)}>
                <span style={{ fontSize: 13 }}>{a.icon}</span>
                <span>{a.label}</span>
              </button>
            ))}

            {/* ≡ More button */}
            <div ref={actionsRef} style={{ position: 'relative' }}>
              <button className="qa-btn" onClick={() => setShowMoreActions(v => !v)} style={{ padding: '7px 10px' }}>
                <span style={{ fontSize: 16, lineHeight: 1 }}>≡</span>
              </button>

              {showMoreActions && (
                <div style={{ position: 'absolute', bottom: 'calc(100% + 8px)', right: 0, minWidth: 240, background: '#0a1929', border: '1px solid #1a3a4a', borderRadius: 12, padding: 6, boxShadow: '0 10px 40px rgba(0,0,0,0.6)', zIndex: 20, animation: 'wfi 0.15s ease-out' }}>
                  {moreActions.map((a) => (
                    <button key={a.label} onClick={() => clickAction(a.query)}
                      style={{ width: '100%', display: 'flex', alignItems: 'center', gap: 10, padding: '9px 12px', background: 'transparent', border: 'none', borderRadius: 8, cursor: 'pointer', textAlign: 'left', transition: 'background 0.1s', color: '#e0e0e0', fontFamily: "'Inter', sans-serif", fontSize: 13 }}
                      onMouseEnter={(e) => { e.currentTarget.style.background = 'rgba(79,195,247,0.06)'; }}
                      onMouseLeave={(e) => { e.currentTarget.style.background = 'transparent'; }}>
                      <span style={{ fontSize: 14, width: 20, textAlign: 'center' }}>{a.icon}</span>
                      <span>{a.label}</span>
                    </button>
                  ))}
                </div>
              )}
            </div>
          </div>

          {/* Disclaimer — matches AInvest */}
          <div style={{ textAlign: 'center', marginTop: 10, fontFamily: "'Inter', sans-serif", fontSize: 11, color: '#455a64' }}>
            Not intended as financial advice <span style={{ color: '#607d8b', cursor: 'pointer' }}>›</span>
          </div>

          {/* Response area */}
          {(answer || error || loading) && (
            <div style={{ marginTop: 24, padding: '20px 24px', background: 'rgba(10,25,41,0.7)', border: '1px solid #1a3a4a', borderRadius: 16, backdropFilter: 'blur(10px)' }}>
              {loading && (
                <div style={{ display: 'flex', alignItems: 'center', gap: 10, color: '#4fc3f7', fontFamily: "'JetBrains Mono', monospace", fontSize: 12, letterSpacing: 1 }}>
                  <span style={{ width: 8, height: 8, borderRadius: '50%', background: '#4fc3f7', animation: 'wb 0.8s infinite' }} />
                  Thinking via {MODES[mode].label}...
                </div>
              )}
              {error && <div style={{ color: '#ef5350', fontFamily: "'JetBrains Mono', monospace", fontSize: 13 }}>Error: {error}</div>}
              {answer && (
                <>
                  {modelUsed && (
                    <div style={{ fontSize: 10, color: '#607d8b', fontFamily: "'JetBrains Mono', monospace", letterSpacing: 1, marginBottom: 12, display: 'flex', alignItems: 'center', gap: 8 }}>
                      <span style={{ color: '#66bb6a' }}>●</span>
                      <span>{modelUsed}</span>
                    </div>
                  )}
                  <div style={{ color: '#e0e0e0', fontSize: 15, lineHeight: 1.7, whiteSpace: 'pre-wrap' }}>{answer}</div>
                </>
              )}
            </div>
          )}
        </div>
      </div>

      {/* Footer */}
      <div style={{ position: 'relative', zIndex: 5, padding: '14px 28px', display: 'flex', justifyContent: 'space-between', alignItems: 'center', fontFamily: "'JetBrains Mono', monospace", fontSize: 10, color: '#455a64', letterSpacing: 1 }}>
        <span>TERRAN COMMAND v2026.04</span>
        <span>BOBA · JAZZYHAZZY · ORION · COMMANDER</span>
        <span>© 2026 MISSION CTRL</span>
      </div>
    </div>
  );
}
