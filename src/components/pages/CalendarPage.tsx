"use client";

import { useState, useEffect, useCallback } from "react";

interface CalendarEvent {
  date: string;
  category: string;
  ticker: string;
  title: string;
  detail: string;
  time: string;
  importance: string;
}

interface CalendarData {
  last_updated: string;
  total_events: number;
  month_summaries: Record<string, Record<string, number>>;
  grouped: Record<string, CalendarEvent[]>;
  events: CalendarEvent[];
}

const CATEGORIES = [
  { key: "all", label: "All" },
  { key: "earnings", label: "Earnings" },
  { key: "economic", label: "Economic" },
  { key: "crypto", label: "Crypto" },
  { key: "dividend", label: "Dividends" },
  { key: "ipo", label: "IPO" },
];

const CAT_COLORS: Record<string, string> = {
  earnings: "#4fc3f7",
  economic: "#ff9800",
  crypto: "#ce93d8",
  dividend: "#66bb6a",
  ipo: "#ef5350",
  split: "#81d4fa",
};

const CAT_BG: Record<string, string> = {
  earnings: "rgba(79,195,247,0.15)",
  economic: "rgba(255,152,0,0.15)",
  crypto: "rgba(206,147,216,0.15)",
  dividend: "rgba(102,187,106,0.15)",
  ipo: "rgba(239,83,80,0.15)",
  split: "rgba(129,212,250,0.15)",
};

const MONTHS = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
const DAYS = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

function formatDateHeader(dateStr: string): string {
  const d = new Date(dateStr + "T12:00:00");
  const day = DAYS[d.getDay()];
  const month = MONTHS[d.getMonth()];
  return `${day} ${month} ${d.getDate()}, ${d.getFullYear()}`;
}

function getMonthKey(year: number, month: number): string {
  return `${year}-${String(month + 1).padStart(2, "0")}`;
}

function getMonthLabel(year: number, month: number): string {
  return `${MONTHS[month]} ${year}`;
}

export function CalendarPage() {
  const now = new Date();
  const [currentYear, setCurrentYear] = useState(now.getFullYear());
  const [currentMonth, setCurrentMonth] = useState(now.getMonth());
  const [activeCategory, setActiveCategory] = useState("all");
  const [viewMode, setViewMode] = useState<"list" | "grid">("list");
  const [data, setData] = useState<CalendarData | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(false);
  const [expandedDates, setExpandedDates] = useState<Set<string>>(new Set());

  const monthKey = getMonthKey(currentYear, currentMonth);

  const fetchData = useCallback(async () => {
    try {
      const cat = activeCategory === "all" ? "" : `&category=${activeCategory}`;
      const res = await fetch(`/api/calendar?month=${monthKey}${cat}`);
      if (res.ok) {
        const json = await res.json();
        setData(json);
        setError(false);
        // Auto-expand all dates
        if (json.grouped) {
          setExpandedDates(new Set(Object.keys(json.grouped)));
        }
      }
    } catch (e) {
      console.error("Calendar fetch error:", e);
      setError(true);
    } finally {
      setLoading(false);
    }
  }, [monthKey, activeCategory]);

  useEffect(() => {
    setLoading(true);
    fetchData();
    const interval = setInterval(fetchData, 60000);
    return () => clearInterval(interval);
  }, [fetchData]);

  const goToday = () => {
    setCurrentYear(now.getFullYear());
    setCurrentMonth(now.getMonth());
  };

  const goPrev = () => {
    if (currentMonth === 0) {
      setCurrentYear(currentYear - 1);
      setCurrentMonth(11);
    } else {
      setCurrentMonth(currentMonth - 1);
    }
  };

  const goNext = () => {
    if (currentMonth === 11) {
      setCurrentYear(currentYear + 1);
      setCurrentMonth(0);
    } else {
      setCurrentMonth(currentMonth + 1);
    }
  };

  const toggleDate = (date: string) => {
    setExpandedDates((prev) => {
      const next = new Set(prev);
      if (next.has(date)) next.delete(date);
      else next.add(date);
      return next;
    });
  };

  // Generate 6 months of summary cards (3 before, current, 2 after)
  const summaryMonths: { year: number; month: number; key: string }[] = [];
  for (let offset = -2; offset <= 4; offset++) {
    let m = currentMonth + offset;
    let y = currentYear;
    if (m < 0) { m += 12; y -= 1; }
    if (m > 11) { m -= 12; y += 1; }
    summaryMonths.push({ year: y, month: m, key: getMonthKey(y, m) });
  }

  const grouped = data?.grouped || {};
  const sortedDates = Object.keys(grouped).sort();

  // Calendar grid for grid view
  const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();
  const firstDayOfWeek = new Date(currentYear, currentMonth, 1).getDay();

  return (
    <div style={{ padding: "24px 32px", maxWidth: 1400, margin: "0 auto" }}>
      {error && <div style={{ background: '#1a0000', border: '1px solid #ef535044', color: '#ef5350', padding: '10px 16px', borderRadius: '6px', marginBottom: '12px', fontSize: '13px' }}>⚠ API unavailable — data may be stale</div>}
      {/* Header */}
      <h1 style={{
        fontSize: 22, fontWeight: 600, color: "#e0e0e0", margin: "0 0 24px",
        fontFamily: "var(--font-mc-mono, monospace)", letterSpacing: "0.5px"
      }}>
        Calendar
      </h1>

      {/* Navigation Bar */}
      <div style={{
        display: "flex", justifyContent: "space-between", alignItems: "center",
        marginBottom: 20
      }}>
        <div style={{ display: "flex", alignItems: "center", gap: 12 }}>
          <button onClick={goToday} style={{
            padding: "6px 14px", fontSize: 13, fontFamily: "var(--font-mc-mono, monospace)",
            border: "1px solid #1a3a4a", borderRadius: 6, background: "#0a1929",
            color: "#e0e0e0", cursor: "pointer"
          }}>
            Today
          </button>
          <button onClick={goPrev} style={{
            padding: "6px 10px", fontSize: 16, border: "1px solid #1a3a4a",
            borderRadius: 6, background: "#0a1929", color: "#4fc3f7", cursor: "pointer"
          }}>
            ‹
          </button>
          <span style={{
            fontSize: 18, fontWeight: 600, color: "#e0e0e0",
            fontFamily: "var(--font-mc-mono, monospace)", minWidth: 160, textAlign: "center"
          }}>
            {MONTHS[currentMonth]} {currentYear}
          </span>
          <button onClick={goNext} style={{
            padding: "6px 10px", fontSize: 16, border: "1px solid #1a3a4a",
            borderRadius: 6, background: "#0a1929", color: "#4fc3f7", cursor: "pointer"
          }}>
            ›
          </button>
        </div>

        {/* View toggle */}
        <div style={{ display: "flex", gap: 2 }}>
          {(["list", "grid"] as const).map((mode) => (
            <button key={mode} onClick={() => setViewMode(mode)} style={{
              padding: "6px 14px", fontSize: 12, fontFamily: "var(--font-mc-mono, monospace)",
              border: `1px solid ${viewMode === mode ? "#4fc3f7" : "#1a3a4a"}`,
              borderRadius: mode === "list" ? "6px 0 0 6px" : "0 6px 6px 0",
              background: viewMode === mode ? "rgba(79,195,247,0.15)" : "#0a1929",
              color: viewMode === mode ? "#4fc3f7" : "#607d8b", cursor: "pointer"
            }}>
              {mode === "list" ? "☰" : "⊞"} {mode.charAt(0).toUpperCase() + mode.slice(1)}
            </button>
          ))}
        </div>
      </div>

      {/* Month Summary Cards */}
      <div style={{
        display: "flex", gap: 12, marginBottom: 24, overflowX: "auto",
        paddingBottom: 8
      }}>
        {summaryMonths.map(({ year, month, key }) => {
          const isActive = key === monthKey;
          const summary = data?.month_summaries?.[key] || {};
          return (
            <div
              key={key}
              onClick={() => { setCurrentYear(year); setCurrentMonth(month); }}
              style={{
                minWidth: 170, padding: "14px 16px",
                background: isActive ? "rgba(79,195,247,0.1)" : "#0a1929",
                border: `1px solid ${isActive ? "#4fc3f7" : "#1a3a4a"}`,
                borderRadius: 8, cursor: "pointer", flexShrink: 0,
                transition: "border 0.2s"
              }}
            >
              <div style={{
                fontSize: 14, fontWeight: 600, color: isActive ? "#4fc3f7" : "#e0e0e0",
                fontFamily: "var(--font-mc-mono, monospace)", marginBottom: 10,
                display: "flex", alignItems: "center", gap: 6
              }}>
                {getMonthLabel(year, month)}
                {isActive && <span style={{ width: 6, height: 6, borderRadius: "50%", background: "#4fc3f7" }} />}
              </div>
              <div style={{ display: "grid", gridTemplateColumns: "1fr auto 1fr auto", gap: "3px 12px", fontSize: 11, fontFamily: "var(--font-mc-mono, monospace)" }}>
                <span style={{ color: "#607d8b" }}>Earnings</span>
                <span style={{ color: "#4fc3f7", textAlign: "right" }}>{summary.earnings || 0}</span>
                <span style={{ color: "#607d8b" }}>Economic</span>
                <span style={{ color: "#ff9800", textAlign: "right" }}>{summary.economic || 0}</span>
                <span style={{ color: "#607d8b" }}>Crypto</span>
                <span style={{ color: "#ce93d8", textAlign: "right" }}>{summary.crypto || 0}</span>
                <span style={{ color: "#607d8b" }}>IPO</span>
                <span style={{ color: "#ef5350", textAlign: "right" }}>{summary.ipo || 0}</span>
              </div>
            </div>
          );
        })}
      </div>

      {/* Category Filter Tabs */}
      <div style={{
        display: "flex", gap: 4, marginBottom: 24, borderBottom: "1px solid #1a3a4a",
        paddingBottom: 12
      }}>
        {CATEGORIES.map(({ key, label }) => (
          <button
            key={key}
            onClick={() => setActiveCategory(key)}
            style={{
              padding: "8px 18px", fontSize: 13,
              fontFamily: "var(--font-mc-mono, monospace)",
              border: "none", borderRadius: 6, cursor: "pointer",
              background: activeCategory === key
                ? (key === "all" ? "rgba(79,195,247,0.15)" : (CAT_BG[key] || "rgba(79,195,247,0.15)"))
                : "transparent",
              color: activeCategory === key
                ? (key === "all" ? "#4fc3f7" : (CAT_COLORS[key] || "#4fc3f7"))
                : "#607d8b",
              fontWeight: activeCategory === key ? 600 : 400,
              transition: "all 0.15s"
            }}
          >
            {label}
          </button>
        ))}
      </div>

      {/* Content */}
      {loading ? (
        <div style={{
          padding: 60, textAlign: "center", color: "#607d8b",
          fontFamily: "var(--font-mc-mono, monospace)", fontSize: 14
        }}>
          Loading calendar data...
        </div>
      ) : viewMode === "list" ? (
        /* LIST VIEW */
        <div>
          {sortedDates.length === 0 ? (
            <div style={{
              padding: 60, textAlign: "center", color: "#455a64",
              fontFamily: "var(--font-mc-mono, monospace)", fontSize: 13
            }}>
              No events for {MONTHS[currentMonth]} {currentYear}.
              <br /><br />
              <span style={{ fontSize: 12, color: "#607d8b" }}>
                Run the scraper: python3 ~/mission-control-restored/bots/calendar_scraper.py
              </span>
            </div>
          ) : (
            sortedDates.map((date) => {
              const events = grouped[date];
              const isExpanded = expandedDates.has(date);
              const isToday = date === now.toISOString().slice(0, 10);
              return (
                <div key={date} style={{ marginBottom: 2 }}>
                  {/* Date Header */}
                  <div
                    onClick={() => toggleDate(date)}
                    style={{
                      display: "flex", justifyContent: "space-between", alignItems: "center",
                      padding: "10px 16px", cursor: "pointer",
                      background: isToday ? "rgba(79,195,247,0.08)" : "#0f1923",
                      borderLeft: isToday ? "3px solid #4fc3f7" : "3px solid transparent",
                      borderRadius: 4
                    }}
                  >
                    <div style={{ display: "flex", alignItems: "center", gap: 10 }}>
                      <span style={{
                        fontSize: 10, color: "#607d8b", transform: isExpanded ? "rotate(0deg)" : "rotate(-90deg)",
                        transition: "transform 0.15s", display: "inline-block"
                      }}>
                        ▼
                      </span>
                      <span style={{
                        fontSize: 14, fontWeight: 600, color: isToday ? "#4fc3f7" : "#e0e0e0",
                        fontFamily: "var(--font-mc-mono, monospace)"
                      }}>
                        {formatDateHeader(date)}
                      </span>
                      {isToday && (
                        <span style={{
                          fontSize: 10, padding: "2px 8px", borderRadius: 4,
                          background: "rgba(79,195,247,0.15)", color: "#4fc3f7",
                          fontFamily: "var(--font-mc-mono, monospace)"
                        }}>
                          TODAY
                        </span>
                      )}
                    </div>
                    <span style={{ fontSize: 12, color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)" }}>
                      {events.length} event{events.length !== 1 ? "s" : ""}
                    </span>
                  </div>

                  {/* Event Items */}
                  {isExpanded && events.map((event, i) => (
                    <div
                      key={`${date}-${i}`}
                      style={{
                        display: "flex", alignItems: "center", gap: 12,
                        padding: "12px 16px 12px 40px",
                        borderBottom: i < events.length - 1 ? "1px solid rgba(26,58,74,0.3)" : "none",
                        transition: "background 0.1s"
                      }}
                      onMouseEnter={(e) => { e.currentTarget.style.background = "rgba(79,195,247,0.03)"; }}
                      onMouseLeave={(e) => { e.currentTarget.style.background = "transparent"; }}
                    >
                      {/* Category Badge */}
                      <span style={{
                        width: 28, height: 28, borderRadius: 6,
                        display: "flex", alignItems: "center", justifyContent: "center",
                        fontSize: 12, fontWeight: 700,
                        background: CAT_BG[event.category] || "rgba(79,195,247,0.15)",
                        color: CAT_COLORS[event.category] || "#4fc3f7",
                        fontFamily: "var(--font-mc-mono, monospace)",
                        flexShrink: 0
                      }}>
                        {event.ticker ? event.ticker.charAt(0) : event.category.charAt(0).toUpperCase()}
                      </span>

                      {/* Ticker + Title */}
                      <div style={{ flex: 1, minWidth: 0 }}>
                        <div style={{ display: "flex", alignItems: "center", gap: 8 }}>
                          {event.ticker && (
                            <span style={{
                              fontSize: 13, fontWeight: 700, color: "#e0e0e0",
                              fontFamily: "var(--font-mc-mono, monospace)"
                            }}>
                              {event.ticker}
                            </span>
                          )}
                          <span style={{
                            fontSize: 13, color: event.ticker ? "#607d8b" : "#e0e0e0",
                            fontFamily: "var(--font-mc-mono, monospace)",
                            overflow: "hidden", textOverflow: "ellipsis", whiteSpace: "nowrap"
                          }}>
                            {event.title.replace(event.ticker || "", "").trim() || event.title}
                          </span>
                        </div>
                      </div>

                      {/* Category Tag */}
                      <span style={{
                        fontSize: 10, padding: "3px 8px", borderRadius: 4,
                        background: CAT_BG[event.category] || "rgba(79,195,247,0.15)",
                        color: CAT_COLORS[event.category] || "#4fc3f7",
                        fontFamily: "var(--font-mc-mono, monospace)",
                        fontWeight: 600, flexShrink: 0, textTransform: "uppercase"
                      }}>
                        {event.category}
                      </span>

                      {/* Detail */}
                      <span style={{
                        fontSize: 12, color: "#607d8b",
                        fontFamily: "var(--font-mc-mono, monospace)",
                        textAlign: "right", flexShrink: 0, minWidth: 120
                      }}>
                        {event.detail}
                      </span>
                    </div>
                  ))}
                </div>
              );
            })
          )}
        </div>
      ) : (
        /* GRID VIEW — Calendar Grid */
        <div>
          {/* Day headers */}
          <div style={{
            display: "grid", gridTemplateColumns: "repeat(7, 1fr)", gap: 2, marginBottom: 2
          }}>
            {DAYS.map((day) => (
              <div key={day} style={{
                padding: "8px 0", textAlign: "center", fontSize: 12,
                color: "#607d8b", fontFamily: "var(--font-mc-mono, monospace)", fontWeight: 600
              }}>
                {day}
              </div>
            ))}
          </div>

          {/* Calendar cells */}
          <div style={{
            display: "grid", gridTemplateColumns: "repeat(7, 1fr)", gap: 2
          }}>
            {/* Empty cells before month starts */}
            {Array.from({ length: firstDayOfWeek }).map((_, i) => (
              <div key={`empty-${i}`} style={{
                minHeight: 100, background: "#070d14", borderRadius: 4, padding: 8
              }} />
            ))}

            {/* Day cells */}
            {Array.from({ length: daysInMonth }).map((_, i) => {
              const day = i + 1;
              const dateStr = `${currentYear}-${String(currentMonth + 1).padStart(2, "0")}-${String(day).padStart(2, "0")}`;
              const dayEvents = grouped[dateStr] || [];
              const isToday = dateStr === now.toISOString().slice(0, 10);

              return (
                <div key={day} style={{
                  minHeight: 100, background: isToday ? "rgba(79,195,247,0.06)" : "#0a1929",
                  border: `1px solid ${isToday ? "#4fc3f7" : "#1a3a4a"}`,
                  borderRadius: 4, padding: 8, overflow: "hidden"
                }}>
                  <div style={{
                    fontSize: 13, fontWeight: isToday ? 700 : 400,
                    color: isToday ? "#4fc3f7" : "#e0e0e0",
                    fontFamily: "var(--font-mc-mono, monospace)",
                    marginBottom: 6
                  }}>
                    {day}
                  </div>
                  {dayEvents.slice(0, 3).map((ev, j) => (
                    <div key={j} style={{
                      fontSize: 10, padding: "2px 4px", marginBottom: 2,
                      borderRadius: 3, overflow: "hidden", textOverflow: "ellipsis",
                      whiteSpace: "nowrap",
                      background: CAT_BG[ev.category] || "rgba(79,195,247,0.15)",
                      color: CAT_COLORS[ev.category] || "#4fc3f7",
                      fontFamily: "var(--font-mc-mono, monospace)"
                    }}>
                      {ev.ticker || ev.title.slice(0, 15)}
                    </div>
                  ))}
                  {dayEvents.length > 3 && (
                    <div style={{
                      fontSize: 9, color: "#607d8b", marginTop: 2,
                      fontFamily: "var(--font-mc-mono, monospace)"
                    }}>
                      +{dayEvents.length - 3} more
                    </div>
                  )}
                </div>
              );
            })}
          </div>
        </div>
      )}

      {/* Footer */}
      <div style={{
        marginTop: 24, padding: "12px 0", borderTop: "1px solid #1a3a4a",
        display: "flex", justifyContent: "space-between", alignItems: "center",
        fontSize: 11, color: "#455a64", fontFamily: "var(--font-mc-mono, monospace)"
      }}>
        <span>
          {data?.total_events || 0} events this month | Last updated: {data?.last_updated ? new Date(data.last_updated).toLocaleString() : "Never"}
        </span>
        <span>Auto-refresh 60s</span>
      </div>
    </div>
  );
}
