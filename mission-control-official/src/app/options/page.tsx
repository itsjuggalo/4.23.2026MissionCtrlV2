'use client';
import { useState, useRef, useCallback } from 'react';
import {
  LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ReferenceLine,
  ResponsiveContainer, AreaChart, Area, BarChart, Bar, Legend,
} from 'recharts';
import { ErrorBoundary } from '@/components/shared/ErrorBoundary';
import { Search, TrendingUp, TrendingDown, AlertTriangle, Send, ImagePlus, X, Loader2, ChevronDown } from 'lucide-react';

// ─── Types ───────────────────────────────────────────────────────────────────
interface OptionRow {
  strike: number; bid: number; ask: number; last: number; mid: number;
  iv: number; volume: number; openInterest: number; bsPrice: number;
  moneyness: 'ITM' | 'ATM' | 'OTM';
  delta: number; gamma: number; theta: number; vega: number; rho: number;
}

interface OptionsData {
  ticker: string; price: number; expiry: string; daysToExpiry: number;
  expirations: string[]; selectedExpiryIndex: number;
  calls: OptionRow[]; puts: OptionRow[];
  smileData: { strike: number; iv: number; type: string }[];
  payoff: { call: PayoffData | null; put: PayoffData | null };
  companyName: string; sector: string;
}

interface PayoffData {
  prices: number[]; payoffs: number[]; breakeven: number;
  maxLoss: number | null; maxGain: number | null;
  currentPrice: number; strike: number;
}

interface ChatMsg {
  role: 'user' | 'assistant';
  content: string;
  image?: string; // base64 data url
  taFetched?: boolean;
}

// ─── Helpers ─────────────────────────────────────────────────────────────────
const moneyBadge = (m: string) => {
  if (m === 'ITM') return 'bg-green-500/10 text-green-400 border border-green-500/20';
  if (m === 'ATM') return 'bg-yellow-500/10 text-yellow-400 border border-yellow-500/20';
  return 'bg-white/5 text-[#555] border border-white/10';
};

const greekColor = (v: number) => v >= 0 ? 'text-green-400' : 'text-red-400';

function num(v: number | undefined, decimals = 2) {
  if (v === undefined || v === null || isNaN(v)) return '—';
  return v.toFixed(decimals);
}

// ─── Sub-components ───────────────────────────────────────────────────────────

function OptionsTable({ rows, type, onSelect, selected }: {
  rows: OptionRow[]; type: 'calls' | 'puts';
  onSelect: (row: OptionRow) => void;
  selected: OptionRow | null;
}) {
  const color = type === 'calls' ? 'text-green-400' : 'text-red-400';
  return (
    <div className="overflow-x-auto">
      <table className="w-full text-xs">
        <thead>
          <tr className="border-b border-[#1f1f1f] text-[#555] uppercase tracking-wider">
            {['Strike','Bid','Ask','Mid','IV%','Vol','OI','BS Price','Δ Delta','Γ Gamma','Θ Theta','Vega','Moneyness'].map(h => (
              <th key={h} className="py-2 px-2 text-left font-medium whitespace-nowrap">{h}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {rows.map((row, i) => {
            const isSelected = selected?.strike === row.strike;
            return (
              <tr
                key={i}
                onClick={() => onSelect(row)}
                className={`border-b border-[#111] cursor-pointer transition-colors ${
                  isSelected ? 'bg-amber-500/10 border-amber-500/20' :
                  row.moneyness === 'ATM' ? 'bg-white/5' :
                  'hover:bg-[#161616]'
                }`}
              >
                <td className={`py-2 px-2 font-bold ${color}`}>{row.strike}</td>
                <td className="py-2 px-2 text-[#aaa]">{num(row.bid)}</td>
                <td className="py-2 px-2 text-[#aaa]">{num(row.ask)}</td>
                <td className="py-2 px-2 text-white font-medium">{num(row.mid)}</td>
                <td className="py-2 px-2">{num(row.iv, 1)}%</td>
                <td className="py-2 px-2 text-[#888]">{row.volume.toLocaleString()}</td>
                <td className="py-2 px-2 text-[#888]">{row.openInterest.toLocaleString()}</td>
                <td className="py-2 px-2 text-purple-400">{num(row.bsPrice)}</td>
                <td className={`py-2 px-2 ${greekColor(row.delta)}`}>{num(row.delta, 3)}</td>
                <td className="py-2 px-2 text-[#888]">{num(row.gamma, 4)}</td>
                <td className="py-2 px-2 text-red-400">{num(row.theta, 4)}</td>
                <td className="py-2 px-2 text-blue-400">{num(row.vega, 4)}</td>
                <td className="py-2 px-2">
                  <span className={`px-1.5 py-0.5 rounded text-[10px] font-medium ${moneyBadge(row.moneyness)}`}>
                    {row.moneyness}
                  </span>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}

function IVSmile({ smileData, currentPrice }: { smileData: OptionsData['smileData']; currentPrice: number }) {
  const calls = smileData.filter(d => d.type === 'call' && d.iv > 0);
  const puts = smileData.filter(d => d.type === 'put' && d.iv > 0);
  const combined = [...calls, ...puts].sort((a, b) => a.strike - b.strike);
  // Dedupe by strike, prefer calls
  const seen = new Set<number>();
  const deduped = combined.filter(d => {
    if (seen.has(d.strike)) return false;
    seen.add(d.strike); return true;
  });

  return (
    <ResponsiveContainer width="100%" height={220}>
      <LineChart data={deduped} margin={{ top: 10, right: 20, left: 0, bottom: 0 }}>
        <CartesianGrid strokeDasharray="3 3" stroke="#1f1f1f" />
        <XAxis dataKey="strike" tick={{ fill: '#555', fontSize: 10 }} />
        <YAxis tick={{ fill: '#555', fontSize: 10 }} tickFormatter={v => `${v.toFixed(0)}%`} />
        <Tooltip
          contentStyle={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 6, fontSize: 11 }}
          formatter={(v: any) => [`${Number(v).toFixed(2)}%`, 'IV']}
        />
        <ReferenceLine x={currentPrice} stroke="#ffa502" strokeDasharray="4 2" label={{ value: 'ATM', fill: '#ffa502', fontSize: 10 }} />
        <Line type="monotone" dataKey="iv" stroke="#6c5ce7" dot={{ r: 2, fill: '#6c5ce7' }} strokeWidth={2} name="IV %" />
      </LineChart>
    </ResponsiveContainer>
  );
}

function PayoffChart({ data, type }: { data: PayoffData; type: 'call' | 'put' }) {
  const chartData = data.prices.map((p, i) => ({ price: p, pnl: data.payoffs[i] }));
  const color = type === 'call' ? '#00d2a0' : '#ff4757';
  return (
    <div>
      <div className="flex gap-4 text-xs mb-3 flex-wrap">
        <span className="text-[#555]">Strike: <span className="text-white">${data.strike}</span></span>
        <span className="text-[#555]">Breakeven: <span className="text-amber-400">${data.breakeven}</span></span>
        {data.maxLoss !== null && <span className="text-[#555]">Max Loss: <span className="text-red-400">${Math.abs(data.maxLoss).toFixed(2)}/share</span></span>}
      </div>
      <ResponsiveContainer width="100%" height={180}>
        <AreaChart data={chartData} margin={{ top: 5, right: 20, left: 0, bottom: 0 }}>
          <CartesianGrid strokeDasharray="3 3" stroke="#1f1f1f" />
          <XAxis dataKey="price" tick={{ fill: '#555', fontSize: 10 }} tickFormatter={v => `$${v.toFixed(0)}`} />
          <YAxis tick={{ fill: '#555', fontSize: 10 }} tickFormatter={v => `$${v.toFixed(0)}`} />
          <Tooltip
            contentStyle={{ background: '#111', border: '1px solid #1f1f1f', borderRadius: 6, fontSize: 11 }}
            formatter={(v: any) => [`$${Number(v).toFixed(2)}`, 'P&L/share']}
            labelFormatter={(v: any) => `Price: $${Number(v).toFixed(2)}`}
          />
          <ReferenceLine y={0} stroke="#333" />
          <ReferenceLine x={data.currentPrice} stroke="#ffa502" strokeDasharray="4 2" />
          <ReferenceLine x={data.breakeven} stroke={color} strokeDasharray="4 2" />
          <Area type="monotone" dataKey="pnl" stroke={color} fill={color} fillOpacity={0.08} strokeWidth={2} />
        </AreaChart>
      </ResponsiveContainer>
    </div>
  );
}

function GreekCard({ label, value, desc, color }: { label: string; value: string; desc: string; color: string }) {
  return (
    <div className="bg-[#111] border border-[#1f1f1f] rounded p-3">
      <div className="text-[10px] text-[#555] uppercase tracking-wider mb-1">{label}</div>
      <div className={`text-lg font-bold ${color}`}>{value}</div>
      <div className="text-[10px] text-[#444] mt-0.5">{desc}</div>
    </div>
  );
}

// ─── Serialize page state into text context ───────────────────────────────────
function serializeChainContext(data: OptionsData, selected: OptionRow | null, activeTab: 'calls' | 'puts'): string {
  const rows = data[activeTab] || [];
  const atm = rows.find(r => r.moneyness === 'ATM') || rows.reduce((best, r) => Math.abs(r.strike - data.price) < Math.abs(best.strike - data.price) ? r : best, rows[0]);

  // Top 10 rows around ATM (5 above, 5 below)
  const atmIdx = rows.indexOf(atm);
  const slice = rows.slice(Math.max(0, atmIdx - 5), atmIdx + 6);

  const tableLines = [
    `Strike | Bid  | Ask  | Mid  | IV%   | Vol    | OI     | Delta  | Theta  | Moneyness`,
    ...slice.map(r =>
      `${r.strike} | ${r.bid} | ${r.ask} | ${r.mid} | ${r.iv}% | ${r.volume.toLocaleString()} | ${r.openInterest.toLocaleString()} | ${r.delta} | ${r.theta} | ${r.moneyness}`
    ),
  ];

  // IV smile summary
  const smileByStrike = data.smileData
    .filter(d => d.iv > 0)
    .sort((a, b) => a.strike - b.strike)
    .map(d => `$${d.strike}=${d.iv.toFixed(1)}%`)
    .join(' | ');

  // Payoff summary
  const pCall = data.payoff?.call;
  const pPut = data.payoff?.put;

  const lines = [
    `=== CURRENT PAGE DATA (${data.ticker} options chain) ===`,
    `Stock: ${data.companyName} (${data.ticker}) @ $${data.price}`,
    `Expiry: ${data.expiry} | DTE: ${data.daysToExpiry} days`,
    '',
    `--- ${activeTab.toUpperCase()} CHAIN (10 strikes around ATM $${data.price}) ---`,
    ...tableLines,
    '',
    `--- IV SMILE (all strikes) ---`,
    smileByStrike || 'N/A',
    '',
  ];

  if (pCall) {
    lines.push(`--- CALL PAYOFF (ATM strike $${pCall.strike}, premium $${(pCall.maxLoss ? Math.abs(pCall.maxLoss) : 0).toFixed(2)}) ---`);
    lines.push(`Breakeven: $${pCall.breakeven} | Max Loss: $${pCall.maxLoss?.toFixed(2) ?? 'unlimited'}/share`);
    lines.push('');
  }
  if (pPut) {
    lines.push(`--- PUT PAYOFF (ATM strike $${pPut.strike}, premium $${(pPut.maxLoss ? Math.abs(pPut.maxLoss) : 0).toFixed(2)}) ---`);
    lines.push(`Breakeven: $${pPut.breakeven} | Max Loss: $${pPut.maxLoss?.toFixed(2) ?? 'unlimited'}/share`);
    lines.push('');
  }

  if (selected) {
    lines.push(`--- USER SELECTED: ${activeTab.slice(0, -1).toUpperCase()} $${selected.strike} ---`);
    lines.push(`Bid: $${selected.bid} | Ask: $${selected.ask} | Mid: $${selected.mid}`);
    lines.push(`IV: ${selected.iv}% | Volume: ${selected.volume.toLocaleString()} | OI: ${selected.openInterest.toLocaleString()}`);
    lines.push(`Delta: ${selected.delta} | Gamma: ${selected.gamma} | Theta: ${selected.theta} | Vega: ${selected.vega}`);
    lines.push(`BS Fair Value: $${selected.bsPrice} | Moneyness: ${selected.moneyness}`);
  }

  return lines.join('\n');
}

// ─── Chat Panel ───────────────────────────────────────────────────────────────
function OptionsChat({ ticker, price, selected, chainData, activeTab }: {
  ticker: string; price: number; selected: OptionRow | null;
  chainData: OptionsData | null; activeTab: 'calls' | 'puts';
}) {
  const [msgs, setMsgs] = useState<ChatMsg[]>([{
    role: 'assistant',
    content: `Hey — options AI loaded${ticker ? ` for ${ticker}` : ''}.\n\nI can:\n• Analyze screenshots you paste\n• Explain any Greek or strategy\n• Give a price prediction with full TA (RSI, MACD, S/R levels, targets)\n• Help pick the best strike\n\nTry: "What's your price target for ${ticker || 'this ticker'}?" or paste a screenshot of an options chain.`,
  }]);
  const [input, setInput] = useState('');
  const [image, setImage] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);
  const [loadingTA, setLoadingTA] = useState(false);
  const fileRef = useRef<HTMLInputElement>(null);
  const bottomRef = useRef<HTMLDivElement>(null);

  const handleImage = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (!file) return;
    const reader = new FileReader();
    reader.onload = () => setImage(reader.result as string);
    reader.readAsDataURL(file);
  };

  const send = useCallback(async () => {
    const text = input.trim();
    if (!text && !image) return;
    setLoading(true);

    const userMsg: ChatMsg = { role: 'user', content: text, image: image || undefined };
    setMsgs(prev => [...prev, userMsg]);
    setInput('');
    setImage(null);

    // Show TA loading hint if prediction keyword detected
    const predKeywords = ['predict', 'target', 'going', 'price', 'forecast', 'upside', 'downside', 'where', 'high', 'low', 'support', 'resistance', 'analysis'];
    if (predKeywords.some(k => text.toLowerCase().includes(k))) {
      setLoadingTA(true);
    }

    // Serialize everything currently visible on the page into context
    const pageContext = chainData ? serializeChainContext(chainData, selected, activeTab) : '';
    const context = [
      pageContext,
      ticker ? `Ticker: ${ticker} @ $${price}` : '',
      selected ? `\nUser has selected: ${activeTab.slice(0,-1).toUpperCase()} $${selected.strike} | Mid $${selected.mid} | IV ${selected.iv}% | Delta ${selected.delta} | Theta ${selected.theta}` : '',
    ].filter(Boolean).join('\n');

    try {
      const res = await fetch('/api/options/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          ticker,
          messages: [...msgs, userMsg].map(m => ({
            role: m.role,
            content: m.image
              ? [{ type: 'image_url', image_url: { url: m.image } }, { type: 'text', text: m.content || 'Analyze this options screenshot and give me your best recommendation.' }]
              : m.content,
          })),
          context,
        }),
      });
      const data = await res.json();
      setMsgs(prev => [...prev, {
        role: 'assistant',
        content: data.reply || 'No response.',
        taFetched: data.taFetched,
      }]);
    } catch {
      setMsgs(prev => [...prev, { role: 'assistant', content: 'Error connecting to AI. Try again.' }]);
    }
    setLoading(false);
    setLoadingTA(false);
    setTimeout(() => bottomRef.current?.scrollIntoView({ behavior: 'smooth' }), 100);
  }, [input, image, msgs, ticker, price, selected, chainData, activeTab]);

  return (
    <div className="flex flex-col h-full">
      <div className="flex-1 overflow-y-auto space-y-3 p-4 min-h-0">
        {msgs.map((m, i) => (
          <div key={i} className={`flex ${m.role === 'user' ? 'justify-end' : 'justify-start'}`}>
            <div className={`max-w-[85%] rounded-lg px-3 py-2 text-sm ${
              m.role === 'user' ? 'bg-amber-500/10 border border-amber-500/20 text-[#f0f0f0]' : 'bg-[#111] border border-[#1f1f1f] text-[#ccc]'
            }`}>
              {m.image && (
                <img src={m.image} alt="uploaded" className="rounded mb-2 max-w-full max-h-48 object-contain" />
              )}
              {m.role === 'user' && chainData && (
                <div className="text-[10px] text-amber-400/50 mb-1 flex items-center gap-1">
                  <span>📋</span> Chain data injected
                </div>
              )}
              {m.taFetched && (
                <div className="text-[10px] text-purple-400/70 mb-1 flex items-center gap-1">
                  <span>📊</span> Live TA + news pulled
                </div>
              )}
              <pre className="whitespace-pre-wrap font-sans text-xs leading-relaxed">{m.content}</pre>
            </div>
          </div>
        ))}
        {loading && (
          <div className="flex justify-start">
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg px-3 py-2 flex flex-col gap-1">
              <div className="flex items-center gap-2">
                <Loader2 className="w-3 h-3 animate-spin text-amber-400" />
                <span className="text-xs text-[#555]">{loadingTA ? 'Fetching live TA data…' : 'Analyzing…'}</span>
              </div>
              {loadingTA && (
                <div className="text-[10px] text-[#444]">📊 RSI · MACD · S/R · Volume · News</div>
              )}
            </div>
          </div>
        )}
        <div ref={bottomRef} />
      </div>

      {/* Image preview */}
      {image && (
        <div className="px-4 pb-2 flex items-center gap-2">
          <img src={image} alt="preview" className="h-12 w-12 object-cover rounded border border-[#1f1f1f]" />
          <button onClick={() => setImage(null)} className="text-[#555] hover:text-red-400 transition-colors">
            <X className="w-4 h-4" />
          </button>
          <span className="text-xs text-[#555]">Image attached</span>
        </div>
      )}

      <div className="border-t border-[#1f1f1f] p-3 flex gap-2">
        <input type="file" ref={fileRef} className="hidden" accept="image/*" onChange={handleImage} />
        <button
          onClick={() => fileRef.current?.click()}
          className="p-2 text-[#555] hover:text-amber-400 transition-colors"
          title="Attach screenshot"
        >
          <ImagePlus className="w-4 h-4" />
        </button>
        <input
          value={input}
          onChange={e => setInput(e.target.value)}
          onKeyDown={e => { if (e.key === 'Enter' && !e.shiftKey) { e.preventDefault(); send(); } }}
          placeholder="Ask about this option, paste a screenshot…"
          className="flex-1 bg-[#0a0a0a] border border-[#1f1f1f] rounded px-3 py-2 text-xs text-[#f0f0f0] placeholder-[#444] focus:outline-none focus:border-amber-500/40"
        />
        <button
          onClick={send}
          disabled={loading || (!input.trim() && !image)}
          className="p-2 bg-amber-500/10 hover:bg-amber-500/20 text-amber-400 rounded border border-amber-500/20 disabled:opacity-40 transition-colors"
        >
          <Send className="w-4 h-4" />
        </button>
      </div>
    </div>
  );
}

// ─── Main Page ────────────────────────────────────────────────────────────────
export default function OptionsPage() {
  const [tickerInput, setTickerInput] = useState('');
  const [data, setData] = useState<OptionsData | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [activeTab, setActiveTab] = useState<'calls' | 'puts'>('calls');
  const [selectedOption, setSelectedOption] = useState<OptionRow | null>(null);
  const [payoffType, setPayoffType] = useState<'call' | 'put'>('call');
  const [chatOpen, setChatOpen] = useState(true);

  const fetchOptions = async (ticker: string, expiryIdx = 0) => {
    if (!ticker) return;
    setLoading(true);
    setError(null);
    setSelectedOption(null);
    try {
      const res = await fetch(`/api/options?ticker=${ticker}&expiry=${expiryIdx}`);
      const json = await res.json();
      if (json.error) throw new Error(json.error);
      setData(json);
    } catch (e: any) {
      setError(e.message);
      setData(null);
    }
    setLoading(false);
  };

  const handleSearch = () => {
    const t = tickerInput.trim().toUpperCase();
    if (t) fetchOptions(t);
  };

  return (
    <div className="flex flex-col h-full gap-4">
      {/* Header */}
      <div className="flex items-center justify-between flex-wrap gap-3">
        <div>
          <h1 className="text-lg font-bold text-[#f0f0f0]">Options Analyzer</h1>
          <p className="text-xs text-[#555]">Full chain · Greeks · IV Smile · P&L payoff · AI assistant</p>
        </div>
        {/* Search */}
        <div className="flex gap-2">
          <div className="relative">
            <Search className="absolute left-2.5 top-1/2 -translate-y-1/2 w-3.5 h-3.5 text-[#444]" />
            <input
              value={tickerInput}
              onChange={e => setTickerInput(e.target.value.toUpperCase())}
              onKeyDown={e => e.key === 'Enter' && handleSearch()}
              placeholder="AAPL, LLY, SPY…"
              className="pl-8 pr-3 py-2 text-sm bg-[#111] border border-[#1f1f1f] rounded text-[#f0f0f0] placeholder-[#444] focus:outline-none focus:border-amber-500/40 w-36"
            />
          </div>
          <button
            onClick={handleSearch}
            disabled={loading}
            className="px-4 py-2 bg-amber-500/10 hover:bg-amber-500/20 text-amber-400 text-sm rounded border border-amber-500/20 disabled:opacity-40 transition-colors flex items-center gap-2"
          >
            {loading ? <Loader2 className="w-3.5 h-3.5 animate-spin" /> : <Search className="w-3.5 h-3.5" />}
            {loading ? 'Loading…' : 'Fetch'}
          </button>
        </div>
      </div>

      {error && (
        <div className="bg-red-500/10 border border-red-500/20 rounded p-3 text-sm text-red-400 flex items-center gap-2">
          <AlertTriangle className="w-4 h-4 flex-shrink-0" />
          {error}
        </div>
      )}

      {!data && !loading && !error && (
        <div className="flex-1 flex items-center justify-center">
          <div className="text-center">
            <TrendingUp className="w-12 h-12 text-[#222] mx-auto mb-4" />
            <p className="text-[#555] text-sm">Enter a ticker to pull the options chain</p>
            <p className="text-[#333] text-xs mt-1">Try: AAPL · SPY · LLY · NVDA · QQQ</p>
          </div>
        </div>
      )}

      {data && (
        <div className="flex gap-4 flex-1 min-h-0">
          {/* Left: main content */}
          <div className="flex-1 space-y-4 overflow-y-auto min-w-0">

            {/* Ticker info + expiry selector */}
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4 flex items-center gap-6 flex-wrap">
              <div>
                <div className="text-xl font-bold text-[#f0f0f0]">{data.ticker}</div>
                <div className="text-xs text-[#555]">{data.companyName}</div>
              </div>
              <div className="text-2xl font-bold text-amber-400">${data.price}</div>
              <div className="text-xs text-[#555]">
                <div>Expiry: <span className="text-[#f0f0f0]">{data.expiry}</span></div>
                <div>DTE: <span className="text-[#f0f0f0]">{data.daysToExpiry}d</span></div>
              </div>
              <div className="flex items-center gap-2">
                <span className="text-xs text-[#555]">Expiry:</span>
                <select
                  className="bg-[#0a0a0a] border border-[#1f1f1f] text-xs text-[#f0f0f0] rounded px-2 py-1 focus:outline-none"
                  value={data.selectedExpiryIndex}
                  onChange={e => fetchOptions(data.ticker, parseInt(e.target.value))}
                >
                  {data.expirations.map((exp, i) => (
                    <option key={exp} value={i}>{exp}</option>
                  ))}
                </select>
              </div>
            </div>

            {/* Greeks for selected option */}
            {selectedOption && (
              <div className="bg-[#0d0d0d] border border-amber-500/20 rounded-lg p-4">
                <div className="flex items-center gap-2 mb-3">
                  <span className="text-sm font-semibold text-amber-400">
                    Selected: {activeTab === 'calls' ? 'CALL' : 'PUT'} ${selectedOption.strike} — Mid ${selectedOption.mid}
                  </span>
                  <span className={`text-xs px-1.5 py-0.5 rounded ${moneyBadge(selectedOption.moneyness)}`}>{selectedOption.moneyness}</span>
                  <button onClick={() => setSelectedOption(null)} className="ml-auto text-[#444] hover:text-[#888]">
                    <X className="w-3.5 h-3.5" />
                  </button>
                </div>
                <div className="grid grid-cols-5 gap-2">
                  <GreekCard label="Δ Delta" value={num(selectedOption.delta, 3)} desc="Price sensitivity" color={greekColor(selectedOption.delta)} />
                  <GreekCard label="Γ Gamma" value={num(selectedOption.gamma, 4)} desc="Delta change rate" color="text-purple-400" />
                  <GreekCard label="Θ Theta" value={num(selectedOption.theta, 4)} desc="Daily time decay" color="text-red-400" />
                  <GreekCard label="Vega" value={num(selectedOption.vega, 4)} desc="Per 1% IV change" color="text-blue-400" />
                  <GreekCard label="IV" value={`${num(selectedOption.iv, 1)}%`} desc="Implied volatility" color="text-amber-400" />
                </div>
              </div>
            )}

            {/* IV Smile */}
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
              <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider mb-3">Volatility Smile</h2>
              <ErrorBoundary name="IV Smile">
                <IVSmile smileData={data.smileData} currentPrice={data.price} />
              </ErrorBoundary>
            </div>

            {/* P&L Payoff */}
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
              <div className="flex items-center gap-3 mb-3">
                <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider">P&L Payoff (Long ATM)</h2>
                <div className="flex gap-1">
                  {(['call','put'] as const).map(t => (
                    <button key={t} onClick={() => setPayoffType(t)}
                      className={`px-2 py-1 text-[10px] rounded uppercase transition-colors ${payoffType === t ? (t === 'call' ? 'bg-green-500/10 text-green-400 border border-green-500/20' : 'bg-red-500/10 text-red-400 border border-red-500/20') : 'text-[#555] hover:text-[#f0f0f0]'}`}>
                      {t}
                    </button>
                  ))}
                </div>
              </div>
              <ErrorBoundary name="Payoff">
                {data.payoff[payoffType]
                  ? <PayoffChart data={data.payoff[payoffType]!} type={payoffType} />
                  : <p className="text-xs text-[#555] py-4 text-center">No payoff data available</p>
                }
              </ErrorBoundary>
            </div>

            {/* Options chain table */}
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg">
              <div className="flex items-center gap-2 px-4 py-3 border-b border-[#1f1f1f]">
                <h2 className="text-xs font-semibold text-[#555] uppercase tracking-wider">Options Chain</h2>
                <div className="flex gap-1 ml-auto">
                  {(['calls','puts'] as const).map(t => (
                    <button key={t} onClick={() => setActiveTab(t)}
                      className={`px-3 py-1.5 text-xs rounded uppercase transition-colors ${activeTab === t ? (t === 'calls' ? 'bg-green-500/10 text-green-400 border border-green-500/20' : 'bg-red-500/10 text-red-400 border border-red-500/20') : 'text-[#555] hover:text-[#f0f0f0]'}`}>
                      {t} ({(data[t] || []).length})
                    </button>
                  ))}
                </div>
              </div>
              <ErrorBoundary name="Options Table">
                <OptionsTable
                  rows={data[activeTab] || []}
                  type={activeTab}
                  onSelect={setSelectedOption}
                  selected={selectedOption}
                />
              </ErrorBoundary>
            </div>
          </div>

          {/* Right: AI Chat */}
          <div className={`flex-shrink-0 transition-all ${chatOpen ? 'w-80' : 'w-10'}`}>
            <div className="bg-[#111] border border-[#1f1f1f] rounded-lg h-full flex flex-col">
              <button
                onClick={() => setChatOpen(o => !o)}
                className="flex items-center gap-2 px-3 py-3 border-b border-[#1f1f1f] w-full text-left hover:bg-[#161616] transition-colors"
              >
                <span className="text-base">🤖</span>
                {chatOpen && <span className="text-xs font-semibold text-[#f0f0f0]">Options AI</span>}
                {chatOpen && <span className="text-[10px] text-[#555] ml-1">ask · screenshot · analyze</span>}
              </button>
              {chatOpen && (
                <div className="flex-1 min-h-0">
                  <ErrorBoundary name="Chat">
                    <OptionsChat ticker={data.ticker} price={data.price} selected={selectedOption} chainData={data} activeTab={activeTab} />
                  </ErrorBoundary>
                </div>
              )}
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
