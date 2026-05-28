'use client';
import { useState, useEffect, useMemo } from 'react';
import { ChevronDown, ChevronRight, Folder, RefreshCw, Search, X, BookOpen, Clock } from 'lucide-react';

interface DocFile {
  name: string;
  path: string;
  category: string;
  size: number;
  modified: string;
}

/* ── simple markdown renderer ── */
function renderMarkdown(text: string): string {
  // Extract code blocks (already escaped) so HTML escaping below doesn't touch them
  const codeBlocks: string[] = [];
  let html = text.replace(/```(\w*)\n([\s\S]*?)```/g, (_m, lang, code) => {
    const idx = codeBlocks.length;
    codeBlocks.push(`<pre class="doc-codeblock"><code class="lang-${lang}">${code.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;')}</code></pre>`);
    return `\x00CODE${idx}\x00`;
  });

  // Escape HTML in everything outside code blocks
  html = html.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');

  html = html
    // Inline code (backtick content is already escaped above)
    .replace(/`([^`]+)`/g, '<code class="doc-inline-code">$1</code>')
    // Headers
    .replace(/^#### (.+)$/gm, '<h4 class="doc-h4">$1</h4>')
    .replace(/^### (.+)$/gm, '<h3 class="doc-h3">$1</h3>')
    .replace(/^## (.+)$/gm, '<h2 class="doc-h2">$1</h2>')
    .replace(/^# (.+)$/gm, '<h1 class="doc-h1">$1</h1>')
    // Bold and italic
    .replace(/\*\*(.+?)\*\*/g, '<strong>$1</strong>')
    .replace(/\*(.+?)\*/g, '<em>$1</em>')
    // Horizontal rules
    .replace(/^---+$/gm, '<hr class="doc-hr" />')
    // Links (href is escaped since < > were replaced above)
    .replace(/\[([^\]]+)\]\(([^)]+)\)/g, '<a href="$2" class="doc-link" target="_blank" rel="noopener">$1</a>')
    // Unordered lists
    .replace(/^[\-\*] (.+)$/gm, '<li class="doc-li">$1</li>')
    // Ordered lists
    .replace(/^\d+\. (.+)$/gm, '<li class="doc-li-ordered">$1</li>')
    // Tables (basic)
    .replace(/^\|(.+)\|$/gm, (_m, row) => {
      const cells = row.split('|').map((c: string) => c.trim()).filter(Boolean);
      if (cells.every((c: string) => /^[-:]+$/.test(c))) return '';
      const cellHtml = cells.map((c: string) => `<td class="doc-td">${c}</td>`).join('');
      return `<tr class="doc-tr">${cellHtml}</tr>`;
    })
    // Blockquotes
    .replace(/^> (.+)$/gm, '<blockquote class="doc-quote">$1</blockquote>')
    // Paragraphs (double newline)
    .replace(/\n\n/g, '</p><p class="doc-p">');

  // Wrap consecutive <li> in <ul>
  html = html.replace(/((?:<li class="doc-li">.*<\/li>\n?)+)/g, '<ul class="doc-ul">$1</ul>');
  html = html.replace(/((?:<li class="doc-li-ordered">.*<\/li>\n?)+)/g, '<ol class="doc-ol">$1</ol>');

  // Wrap consecutive <tr> in <table>
  html = html.replace(/((?:<tr class="doc-tr">.*<\/tr>\n?)+)/g, '<table class="doc-table"><tbody>$1</tbody></table>');

  // Wrap in paragraph
  html = `<p class="doc-p">${html}</p>`;

  // Clean up empty paragraphs
  html = html.replace(/<p class="doc-p">\s*<\/p>/g, '');
  html = html.replace(/<p class="doc-p">(\s*<(?:h[1-4]|pre|ul|ol|table|blockquote|hr))/g, '$1');
  html = html.replace(/(<\/(?:h[1-4]|pre|ul|ol|table|blockquote|hr)>)\s*<\/p>/g, '$1');

  // Restore extracted code blocks
  html = html.replace(/\x00CODE(\d+)\x00/g, (_, idx) => codeBlocks[Number(idx)]);

  return html;
}

/* ── file type icon color ── */
function getFileColor(name: string): string {
  if (name.endsWith('.md')) return '#60a5fa';
  if (name.endsWith('.json')) return '#fbbf24';
  if (name.endsWith('.py')) return '#34d399';
  if (name.endsWith('.sh')) return '#f87171';
  if (name.endsWith('.txt')) return '#a78bfa';
  return '#888';
}

function getFileIcon(name: string): string {
  if (name.endsWith('.md')) return '📄';
  if (name.endsWith('.json')) return '📋';
  if (name.endsWith('.py')) return '🐍';
  if (name.endsWith('.sh')) return '⚙️';
  if (name.endsWith('.txt')) return '📝';
  return '📎';
}

/* ── category badge colors ── */
const CATEGORY_STYLES: Record<string, string> = {
  'Root': 'bg-amber-500/15 text-amber-400 border-amber-500/30',
  'memory': 'bg-blue-500/15 text-blue-400 border-blue-500/30',
  'directives': 'bg-purple-500/15 text-purple-400 border-purple-500/30',
  'context': 'bg-emerald-500/15 text-emerald-400 border-emerald-500/30',
  'skills': 'bg-cyan-500/15 text-cyan-400 border-cyan-500/30',
  'second-brain': 'bg-rose-500/15 text-rose-400 border-rose-500/30',
  'mission-control': 'bg-red-500/15 text-red-400 border-red-500/30',
};

export function DocsPage() {
  const [docs, setDocs] = useState<Record<string, DocFile[]>>({});
  const [total, setTotal] = useState(0);
  const [expanded, setExpanded] = useState<string | null>(null);
  const [content, setContent] = useState<Record<string, string>>({});
  const [loading, setLoading] = useState(true);
  const [loadingContent, setLoadingContent] = useState<string | null>(null);
  const [search, setSearch] = useState('');
  const [collapsedCategories, setCollapsedCategories] = useState<Set<string>>(new Set());
  const [error, setError] = useState(false);

  const fetchDocs = async () => {
    setLoading(true);
    try {
      const response = await fetch('/api/docs');
      if (!response.ok) throw new Error(`HTTP ${response.status}`);
      const data = await response.json();
      setDocs(data.docs || {});
      setTotal(data.total || 0);
      setError(false);
    } catch (e) {
      console.error('Failed to fetch docs:', e);
      setError(true);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchDocs();
  }, []);

  const fetchContent = async (path: string) => {
    if (content[path]) return;
    setLoadingContent(path);
    try {
      const response = await fetch(`/api/docs/content?path=${encodeURIComponent(path)}`);
      if (!response.ok) throw new Error(`HTTP ${response.status}`);
      const data = await response.json();
      setContent(prev => ({ ...prev, [path]: data.content }));
    } catch {
      setContent(prev => ({ ...prev, [path]: '⚠️ Error loading content' }));
    } finally {
      setLoadingContent(null);
    }
  };

  const handleToggle = async (path: string) => {
    if (expanded === path) {
      setExpanded(null);
    } else {
      setExpanded(path);
      await fetchContent(path);
    }
  };

  const toggleCategory = (cat: string) => {
    setCollapsedCategories(prev => {
      const next = new Set(prev);
      if (next.has(cat)) next.delete(cat);
      else next.add(cat);
      return next;
    });
  };

  /* ── filter by search ── */
  const filteredDocs = useMemo(() => {
    if (!search.trim()) return docs;
    const q = search.toLowerCase();
    const result: Record<string, DocFile[]> = {};
    for (const [cat, files] of Object.entries(docs)) {
      const matched = files.filter(
        f => f.name.toLowerCase().includes(q) || f.category.toLowerCase().includes(q)
      );
      if (matched.length) result[cat] = matched;
    }
    return result;
  }, [docs, search]);

  const categories = Object.keys(filteredDocs).sort();

  const formatSize = (bytes: number) => {
    if (bytes < 1024) return bytes + ' B';
    if (bytes < 1024 * 1024) return (bytes / 1024).toFixed(1) + ' KB';
    return (bytes / (1024 * 1024)).toFixed(1) + ' MB';
  };

  const timeAgo = (dateStr: string) => {
    const diff = Date.now() - new Date(dateStr).getTime();
    const mins = Math.floor(diff / 60000);
    if (mins < 60) return `${mins}m ago`;
    const hrs = Math.floor(mins / 60);
    if (hrs < 24) return `${hrs}h ago`;
    const days = Math.floor(hrs / 24);
    if (days < 7) return `${days}d ago`;
    return new Date(dateStr).toLocaleDateString();
  };

  return (
    <div style={{ padding: '24px', maxWidth: '1100px', margin: '0 auto' }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Header */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', marginBottom: '24px', flexWrap: 'wrap', gap: '16px' }}>
        <div>
          <h1 style={{ fontSize: 'var(--mc-font-2xl)', fontWeight: 700, color: '#f0f0f0', margin: 0, display: 'flex', alignItems: 'center', gap: '10px' }}>
            <BookOpen style={{ width: '22px', height: '22px', color: '#60a5fa' }} />
            Knowledge Library
          </h1>
          <p style={{ fontSize: 'var(--mc-font-xs)', color: '#666', marginTop: '4px' }}>
            {total} documents across {Object.keys(docs).length} categories
          </p>
        </div>
        <button
          onClick={fetchDocs}
          style={{
            display: 'flex', alignItems: 'center', gap: '6px',
            padding: '8px 14px', background: '#111', border: '1px solid #222',
            borderRadius: '8px', color: '#888', fontSize: 'var(--mc-font-xs)', cursor: 'pointer',
          }}
        >
          <RefreshCw style={{ width: '14px', height: '14px' }} />
          Refresh
        </button>
      </div>

      {/* Search */}
      <div style={{ position: 'relative', marginBottom: '24px' }}>
        <Search style={{ position: 'absolute', left: '14px', top: '50%', transform: 'translateY(-50%)', width: '16px', height: '16px', color: '#555' }} />
        <input
          type="text"
          value={search}
          onChange={e => setSearch(e.target.value)}
          placeholder="Search documents..."
          style={{
            width: '100%', padding: '12px 40px 12px 42px',
            background: '#0a0a0a', border: '1px solid #1f1f1f', borderRadius: '10px',
            color: '#f0f0f0', fontSize: 'var(--mc-font-sm)', outline: 'none', boxSizing: 'border-box',
          }}
        />
        {search && (
          <button onClick={() => setSearch('')} style={{
            position: 'absolute', right: '14px', top: '50%', transform: 'translateY(-50%)',
            background: 'none', border: 'none', color: '#555', cursor: 'pointer', padding: '4px',
          }}>
            <X style={{ width: '16px', height: '16px' }} />
          </button>
        )}
      </div>

      {loading ? (
        <div style={{ textAlign: 'center', padding: '60px 0', color: '#555' }}>
          <RefreshCw style={{ width: '24px', height: '24px', margin: '0 auto 12px', animation: 'spin 1s linear infinite' }} />
          <p>Loading documents...</p>
        </div>
      ) : categories.length === 0 ? (
        <div style={{ textAlign: 'center', padding: '60px 0', color: '#555' }}>
          <p>{search ? 'No documents match your search' : 'No documents found in workspace'}</p>
        </div>
      ) : (
        <div style={{ display: 'flex', flexDirection: 'column', gap: '28px' }}>
          {categories.map(category => {
            const files = filteredDocs[category];
            const isCollapsed = collapsedCategories.has(category);
            const badgeStyle = CATEGORY_STYLES[category] || 'bg-gray-500/15 text-gray-400 border-gray-500/30';

            return (
              <div key={category}>
                {/* Category header */}
                <button
                  onClick={() => toggleCategory(category)}
                  style={{
                    display: 'flex', alignItems: 'center', gap: '8px',
                    marginBottom: isCollapsed ? '0' : '10px', background: 'none',
                    border: 'none', cursor: 'pointer', padding: '4px 0', width: '100%',
                  }}
                >
                  {isCollapsed
                    ? <ChevronRight style={{ width: '14px', height: '14px', color: '#555' }} />
                    : <ChevronDown style={{ width: '14px', height: '14px', color: '#555' }} />
                  }
                  <Folder style={{ width: '15px', height: '15px', color: '#555' }} />
                  <span style={{ fontSize: 'var(--mc-font-badge)', fontWeight: 600, color: '#888', textTransform: 'uppercase', letterSpacing: '0.5px' }}>
                    {category}
                  </span>
                  <span style={{ fontSize: 'var(--mc-font-label)', color: '#555', marginLeft: '4px' }}>
                    ({files.length})
                  </span>
                </button>

                {!isCollapsed && (
                  <div style={{ display: 'flex', flexDirection: 'column', gap: '6px' }}>
                    {files.map(doc => {
                      const isExpanded = expanded === doc.path;
                      const isLoadingThis = loadingContent === doc.path;
                      const _fileColor = getFileColor(doc.name);

                      return (
                        <div key={doc.path} style={{
                          background: isExpanded ? '#0d0d0d' : '#111',
                          border: `1px solid ${isExpanded ? '#2a2a2a' : '#1a1a1a'}`,
                          borderRadius: '10px',
                          overflow: 'hidden',
                          transition: 'border-color 0.2s',
                        }}>
                          {/* File row */}
                          <div
                            onClick={() => handleToggle(doc.path)}
                            style={{
                              display: 'flex', alignItems: 'center', gap: '12px',
                              padding: '14px 16px', cursor: 'pointer',
                            }}
                          >
                            <span style={{ fontSize: 'var(--mc-font-xl)', flexShrink: 0 }}>{getFileIcon(doc.name)}</span>

                            <div style={{ flex: 1, minWidth: 0 }}>
                              <div style={{ fontSize: 'var(--mc-font-sm)', fontWeight: 500, color: '#e8e8e8', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                                {doc.name}
                              </div>
                              <div style={{ display: 'flex', alignItems: 'center', gap: '12px', marginTop: '3px', fontSize: 'var(--mc-font-badge)', color: '#555' }}>
                                <span style={{ display: 'flex', alignItems: 'center', gap: '4px' }}>
                                  <Clock style={{ width: '11px', height: '11px' }} />
                                  {timeAgo(doc.modified)}
                                </span>
                                <span>{formatSize(doc.size)}</span>
                              </div>
                            </div>

                            <span className={`${badgeStyle}`} style={{
                              display: 'inline-flex', padding: '3px 10px', borderRadius: '6px',
                              fontSize: 'var(--mc-font-label)', fontWeight: 500, flexShrink: 0, borderWidth: '1px', borderStyle: 'solid',
                            }}>
                              {category}
                            </span>

                            <div style={{ flexShrink: 0, color: '#555' }}>
                              {isLoadingThis ? (
                                <RefreshCw style={{ width: '16px', height: '16px', animation: 'spin 1s linear infinite' }} />
                              ) : isExpanded ? (
                                <ChevronDown style={{ width: '16px', height: '16px' }} />
                              ) : (
                                <ChevronRight style={{ width: '16px', height: '16px' }} />
                              )}
                            </div>
                          </div>

                          {/* Expanded content */}
                          {isExpanded && content[doc.path] && (
                            <div style={{
                              borderTop: '1px solid #1a1a1a',
                              padding: '28px 32px',
                              background: '#080808',
                              maxHeight: '70vh',
                              overflowY: 'auto',
                            }}>
                              {doc.name.endsWith('.json') ? (
                                <pre style={{
                                  fontSize: 'var(--mc-font-xs)', lineHeight: '1.7', color: '#c8c8c8',
                                  fontFamily: '"JetBrains Mono", "Fira Code", "Consolas", monospace',
                                  whiteSpace: 'pre-wrap', wordBreak: 'break-word', margin: 0,
                                }}>
                                  {(() => {
                                    try { return JSON.stringify(JSON.parse(content[doc.path]), null, 2); }
                                    catch { return content[doc.path]; }
                                  })()}
                                </pre>
                              ) : doc.name.endsWith('.py') || doc.name.endsWith('.sh') ? (
                                <pre style={{
                                  fontSize: 'var(--mc-font-xs)', lineHeight: '1.7', color: '#c8c8c8',
                                  fontFamily: '"JetBrains Mono", "Fira Code", "Consolas", monospace',
                                  whiteSpace: 'pre-wrap', wordBreak: 'break-word', margin: 0,
                                }}>
                                  {content[doc.path]}
                                </pre>
                              ) : (
                                <div
                                  className="doc-reader"
                                  dangerouslySetInnerHTML={{ __html: renderMarkdown(content[doc.path]) }}
                                />
                              )}
                            </div>
                          )}
                        </div>
                      );
                    })}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}

      {/* Document reader styles */}
      <style>{`
        @keyframes spin { to { transform: rotate(360deg); } }

        .doc-reader {
          font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
          font-size: 15px;
          line-height: 1.8;
          color: #d4d4d4;
        }
        .doc-reader .doc-h1 {
          font-size: 26px;
          font-weight: 700;
          color: #f0f0f0;
          margin: 32px 0 16px 0;
          padding-bottom: 8px;
          border-bottom: 1px solid #222;
        }
        .doc-reader .doc-h1:first-child { margin-top: 0; }
        .doc-reader .doc-h2 {
          font-size: 21px;
          font-weight: 600;
          color: #e8e8e8;
          margin: 28px 0 12px 0;
          padding-bottom: 6px;
          border-bottom: 1px solid #1a1a1a;
        }
        .doc-reader .doc-h3 {
          font-size: 17px;
          font-weight: 600;
          color: #d0d0d0;
          margin: 24px 0 10px 0;
        }
        .doc-reader .doc-h4 {
          font-size: 15px;
          font-weight: 600;
          color: #b0b0b0;
          margin: 20px 0 8px 0;
        }
        .doc-reader .doc-p {
          margin: 12px 0;
        }
        .doc-reader .doc-codeblock {
          background: #0f0f0f;
          border: 1px solid #1f1f1f;
          border-radius: 8px;
          padding: 16px 20px;
          margin: 16px 0;
          overflow-x: auto;
          font-family: "JetBrains Mono", "Fira Code", "Consolas", monospace;
          font-size: 13px;
          line-height: 1.6;
          color: #a8d8a8;
        }
        .doc-reader .doc-inline-code {
          background: #1a1a1a;
          border: 1px solid #2a2a2a;
          border-radius: 4px;
          padding: 2px 7px;
          font-family: "JetBrains Mono", "Fira Code", "Consolas", monospace;
          font-size: 13px;
          color: #e8a87c;
        }
        .doc-reader .doc-ul, .doc-reader .doc-ol {
          margin: 12px 0;
          padding-left: 24px;
        }
        .doc-reader .doc-li, .doc-reader .doc-li-ordered {
          margin: 6px 0;
          color: #c8c8c8;
        }
        .doc-reader .doc-hr {
          border: none;
          border-top: 1px solid #222;
          margin: 24px 0;
        }
        .doc-reader .doc-link {
          color: #60a5fa;
          text-decoration: none;
        }
        .doc-reader .doc-link:hover {
          text-decoration: underline;
        }
        .doc-reader .doc-quote {
          border-left: 3px solid #333;
          padding: 8px 16px;
          margin: 16px 0;
          color: #999;
          background: #0c0c0c;
          border-radius: 0 6px 6px 0;
        }
        .doc-reader .doc-table {
          width: 100%;
          border-collapse: collapse;
          margin: 16px 0;
          font-size: 14px;
        }
        .doc-reader .doc-td {
          padding: 10px 14px;
          border: 1px solid #1f1f1f;
          color: #c8c8c8;
        }
        .doc-reader .doc-tr:first-child .doc-td {
          background: #111;
          font-weight: 600;
          color: #e0e0e0;
        }
        .doc-reader strong {
          color: #f0f0f0;
          font-weight: 600;
        }
        .doc-reader em {
          color: #b8b8b8;
        }
      `}</style>
    </div>
  );
}
