'use client';
import { useState, useRef, useEffect } from 'react';
import { useViewMode } from '@/lib/useViewMode';

const PSYCH_SYSTEM_PROMPT = `You are PsychTechologist, the behavioral finance and trading psychology specialist on an elite trading team modeled after AQR Capital's behavioral finance research.

Your role: Help the Commander maintain psychological discipline. Explain WHY bots made decisions. Identify market manipulation (stop hunts, spoofing, wash trading) vs genuine breakdowns. Detect cognitive biases: recency bias, loss aversion, anchoring, FOMO, revenge trading. Provide confidence metrics and historical context.

Personality: Senior behavioral finance researcher. Authoritative but warm. Concrete data, not platitudes. Ground the Commander in original thesis and risk parameters when stressed. Never sugarcoat — if a position should be cut, say so clearly. Keep responses concise and actionable.`;

interface Message {
  role: 'user' | 'assistant' | 'alert';
  content?: string;
  type?: string;
  icon?: string;
  message?: string;
  time?: string;
}

export function PsychChatWidget() {
  const [isOpen, setIsOpen] = useState(false);
  const [viewMode] = useViewMode();
  const isMobile = viewMode === 'mobile';
  const [messages, setMessages] = useState<Message[]>([
    { role: 'alert', type: 'manipulation', icon: '🎭', message: 'Detected potential stop hunt on ETH/USDT. Price wicked below support but recovered. Thesis intact.', time: '2m ago' },
    { role: 'alert', type: 'confidence', icon: '📊', message: 'BTC position tracking Dec 2023 post-Fed pattern. Historical win rate: 73% within 48hrs.', time: '18m ago' },
    { role: 'assistant', content: 'Commander, PsychTechologist online. All positions within expected parameters. Risk exposure at 62%. How are you feeling about the current setup?' },
  ]);
  const [input, setInput] = useState('');
  const [isTyping, setIsTyping] = useState(false);
  const [unreadCount, setUnreadCount] = useState(1);
  const messagesEndRef = useRef<HTMLDivElement>(null);
  const inputRef = useRef<HTMLTextAreaElement>(null);

  useEffect(() => { messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' }); }, [messages, isTyping]);
  useEffect(() => { if (isOpen) { setUnreadCount(0); setTimeout(() => inputRef.current?.focus(), 100); } }, [isOpen]);

  const sendMessage = async (text?: string) => {
    const msgText = text || input.trim();
    if (!msgText) return;
    const userMessage: Message = { role: 'user', content: msgText };
    setMessages(prev => [...prev, userMessage]);
    setInput('');
    setIsTyping(true);
    try {
      const apiMessages = [...messages, userMessage]
        .filter(m => m.role === 'user' || m.role === 'assistant')
        .map(m => ({ role: m.role, content: m.content }));
      const response = await fetch('/api/psych-chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ messages: apiMessages }),
        signal: AbortSignal.timeout(15000),
      });
      if (!response.ok) throw new Error(`HTTP ${response.status}`);
      const data = await response.json();
      const assistantText = data.content?.filter((item: any) => item.type === 'text').map((item: any) => item.text).join('\n') || 'Connection disrupted. Still monitoring — try again shortly.';
      setMessages(prev => [...prev, { role: 'assistant', content: assistantText }]);
    } catch {
      setMessages(prev => [...prev, { role: 'assistant', content: 'Temporary connection issue. Positions still monitored. Try again in a moment.' }]);
    }
    setIsTyping(false);
  };

  const handleKeyDown = (e: React.KeyboardEvent) => { if (e.key === 'Enter' && !e.shiftKey) { e.preventDefault(); sendMessage(); } };

  return (
    <>
      <style>{`
        @keyframes psychBounce { 0%, 60%, 100% { transform: translateY(0); opacity: 0.4; } 30% { transform: translateY(-5px); opacity: 1; } }
        @keyframes psychSlideUp { from { opacity: 0; transform: translateY(12px) scale(0.97); } to { opacity: 1; transform: translateY(0) scale(1); } }
        @keyframes psychPulse { 0%, 100% { box-shadow: 0 4px 20px rgba(139,92,246,0.25); } 50% { box-shadow: 0 4px 20px rgba(139,92,246,0.5), 0 0 0 8px rgba(139,92,246,0); } }
        .psych-scroll::-webkit-scrollbar { width: 3px; } .psych-scroll::-webkit-scrollbar-track { background: transparent; } .psych-scroll::-webkit-scrollbar-thumb { background: #1a3a4a; border-radius: 3px; }
      `}</style>

      {/* Mobile-only backdrop, dismisses on tap. Desktop has none. */}
      {isOpen && isMobile && (
        <div onClick={() => setIsOpen(false)} style={{ position: 'fixed', inset: 0, background: 'rgba(0,0,0,0.5)', zIndex: 9998 }} />
      )}

      {isOpen && (
        <div style={{
          position: 'fixed',
          // Desktop: floating 370×520 panel anchored bottom-right.
          // Mobile: full-width bottom sheet so it doesn't clip on a 390px viewport.
          ...(isMobile
            ? { left: 8, right: 8, bottom: 88, height: 'min(70vh, 560px)' }
            : { bottom: 88, right: 24, width: 370, height: 520 }
          ),
          background: '#0d1117', borderRadius: 12, border: '1px solid #1a3a4a',
          boxShadow: '0 20px 60px rgba(0,0,0,0.5)',
          display: 'flex', flexDirection: 'column', overflow: 'hidden',
          animation: 'psychSlideUp 0.25s ease-out', zIndex: 9999,
        }}>
          {/* Header */}
          <div style={{ padding: '14px 16px', background: '#111118', borderBottom: '1px solid #1a3a4a', display: 'flex', alignItems: 'center', gap: 10, flexShrink: 0 }}>
            <div style={{ position: 'relative' }}>
              <div style={{ width: 34, height: 34, borderRadius: 8, background: 'rgba(139,92,246,0.12)', border: '1px solid rgba(139,92,246,0.18)', display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: 16 }}>🧠</div>
              <div style={{ position: 'absolute', bottom: -1, right: -1, width: 9, height: 9, borderRadius: '50%', background: '#66bb6a', border: '2px solid #111118', boxShadow: '0 0 4px #66bb6a' }} />
            </div>
            <div style={{ flex: 1 }}>
              <div style={{ fontSize: 13, fontWeight: 600, color: '#e0e0e0' }}>PsychTechologist</div>
              <div style={{ fontSize: 10, fontFamily: 'var(--font-jetbrains-mono), monospace', color: '#8B5CF6', letterSpacing: 0.5, marginTop: 1 }}>ONLINE · MONITORING POSITIONS</div>
            </div>
            <button onClick={() => setIsOpen(false)} style={{ background: 'rgba(232,232,237,0.03)', border: '1px solid #1a3a4a', borderRadius: 6, color: '#607d8b', cursor: 'pointer', width: 28, height: 28, display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: 14 }}>−</button>
          </div>

          {/* Messages */}
          <div className="psych-scroll" style={{ flex: 1, overflowY: 'auto', padding: 14, display: 'flex', flexDirection: 'column', gap: 6 }}>
            {messages.map((msg, i) => {
              if (msg.role === 'alert') return (
                <div key={i} style={{ padding: '10px 12px', background: 'rgba(139,92,246,0.05)', border: '1px solid rgba(139,92,246,0.1)', borderRadius: 8, fontSize: 12, lineHeight: 1.5, color: '#455a64' }}>
                  <div style={{ display: 'flex', alignItems: 'center', gap: 6, marginBottom: 5 }}>
                    <span>{msg.icon}</span>
                    <span style={{ fontSize: 10, fontFamily: 'var(--font-jetbrains-mono), monospace', color: '#8B5CF6', textTransform: 'uppercase', letterSpacing: 0.8, fontWeight: 600 }}>{msg.type === 'manipulation' ? 'Manipulation Alert' : msg.type === 'bias' ? 'Bias Detection' : 'Confidence Read'}</span>
                    <span style={{ fontSize: 10, fontFamily: 'var(--font-jetbrains-mono), monospace', color: '#607d8b', marginLeft: 'auto' }}>{msg.time}</span>
                  </div>
                  {msg.message}
                </div>
              );
              const isUser = msg.role === 'user';
              return (
                <div key={i} style={{ display: 'flex', justifyContent: isUser ? 'flex-end' : 'flex-start' }}>
                  <div style={{ maxWidth: '84%', padding: '9px 13px', borderRadius: isUser ? '12px 12px 3px 12px' : '12px 12px 12px 3px', background: isUser ? '#8B5CF6' : '#111118', border: isUser ? 'none' : '1px solid #1a3a4a', color: isUser ? '#fff' : '#e0e0e0', fontSize: 13, lineHeight: 1.5, whiteSpace: 'pre-wrap' }}>{msg.content}</div>
                </div>
              );
            })}
            {isTyping && (
              <div style={{ display: 'flex' }}>
                <div style={{ padding: '10px 16px', borderRadius: '12px 12px 12px 3px', background: '#111118', border: '1px solid #1a3a4a', display: 'flex', gap: 4 }}>
                  {[0,1,2].map(i => <div key={i} style={{ width: 5, height: 5, borderRadius: '50%', background: '#8B5CF6', animation: `psychBounce 1.2s ease-in-out ${i*0.15}s infinite` }} />)}
                </div>
              </div>
            )}
            <div ref={messagesEndRef} />
          </div>

          {/* Quick Actions */}
          <div style={{ padding: '6px 14px 2px', display: 'flex', gap: 5, flexWrap: 'wrap', flexShrink: 0 }}>
            {['Why this trade?', 'Is this manipulation?', 'Bias check', 'Confidence read'].map(q => (
              <button key={q} onClick={() => sendMessage(q)} style={{ background: 'rgba(139,92,246,0.05)', border: '1px solid rgba(139,92,246,0.12)', borderRadius: 16, color: '#a78bfa', fontSize: 10, fontFamily: 'var(--font-jetbrains-mono), monospace', padding: '4px 10px', cursor: 'pointer' }}>{q}</button>
            ))}
          </div>

          {/* Input */}
          <div style={{ padding: '10px 14px 14px', display: 'flex', gap: 8, alignItems: 'flex-end', flexShrink: 0 }}>
            <textarea ref={inputRef} value={input} onChange={e => setInput(e.target.value)} onKeyDown={handleKeyDown} placeholder="Talk to PsychTechologist..." rows={1} style={{ flex: 1, background: '#111118', border: '1px solid #1a3a4a', borderRadius: 8, padding: '9px 12px', color: '#e0e0e0', fontSize: 13, resize: 'none', lineHeight: 1.4, maxHeight: 72, outline: 'none' }} />
            <button onClick={() => sendMessage()} disabled={!input.trim() || isTyping} style={{ width: 36, height: 36, borderRadius: 8, background: input.trim() ? '#8B5CF6' : 'rgba(232,232,237,0.03)', border: input.trim() ? 'none' : '1px solid #1a3a4a', cursor: input.trim() ? 'pointer' : 'default', display: 'flex', alignItems: 'center', justifyContent: 'center', flexShrink: 0 }}>
              <svg width="16" height="16" viewBox="0 0 24 24" fill="none"><path d="M22 2L11 13M22 2L15 22L11 13M22 2L2 9L11 13" stroke={input.trim() ? '#fff' : '#607d8b'} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" /></svg>
            </button>
          </div>
        </div>
      )}

      {/* Floating Bubble */}
      <button onClick={() => setIsOpen(!isOpen)} style={{ position: 'fixed', bottom: 24, right: 24, width: 54, height: 54, borderRadius: 14, background: 'linear-gradient(135deg, #8B5CF6, #6D28D9)', border: 'none', cursor: 'pointer', display: 'flex', alignItems: 'center', justifyContent: 'center', boxShadow: '0 4px 20px rgba(139,92,246,0.3)', animation: unreadCount > 0 && !isOpen ? 'psychPulse 2s ease-in-out infinite' : 'none', zIndex: 10000 }}>
        <span style={{ fontSize: 24 }}>{isOpen ? '✕' : '🧠'}</span>
        {unreadCount > 0 && !isOpen && (
          <div style={{ position: 'absolute', top: -3, right: -3, width: 18, height: 18, borderRadius: '50%', background: '#ef5350', color: '#fff', fontSize: 10, fontWeight: 700, display: 'flex', alignItems: 'center', justifyContent: 'center', border: '2px solid #0a0a0f', fontFamily: 'var(--font-jetbrains-mono), monospace' }}>{unreadCount}</div>
        )}
      </button>
    </>
  );
}
