"use client";
import { Component, ReactNode } from "react";
import * as Sentry from "@sentry/nextjs";

interface Props { children: ReactNode; pageName?: string; }
interface State { hasError: boolean; error?: Error; }

export default class PageErrorBoundary extends Component<Props, State> {
  state: State = { hasError: false };

  static getDerivedStateFromError(error: Error): State {
    return { hasError: true, error };
  }

  componentDidCatch(error: Error, info: any) {
    console.error("PageErrorBoundary caught:", error, info);
    Sentry.captureException(error, {
      tags: { errorBoundary: "PageErrorBoundary", page: this.props.pageName ?? "unknown" },
      extra: { componentStack: info?.componentStack },
    });
  }

  reset = () => this.setState({ hasError: false, error: undefined });

  render() {
    if (this.state.hasError) {
      return (
        <div style={{ padding: 32, color: "#e8edf2", background: "#0d1117", height: "100%", fontFamily: "ui-monospace,monospace" }}>
          <div style={{ maxWidth: 720, padding: 20, border: "1px solid #ff6b6b40", borderRadius: 6, background: "#1a0d0d" }}>
            <div style={{ color: "#ff6b6b", fontSize: 14, fontWeight: 600, marginBottom: 8 }}>
              ⚠ Page error{this.props.pageName ? ` — ${this.props.pageName}` : ""}
            </div>
            <div style={{ color: "#cfd6dd", fontSize: 12, marginBottom: 12 }}>
              {this.state.error?.message || "Unknown error"}
            </div>
            <button onClick={this.reset} style={{
              padding: "6px 14px", background: "#5fa3ff", color: "#000",
              border: "none", borderRadius: 4, cursor: "pointer", fontSize: 12, fontWeight: 600,
            }}>Retry</button>
          </div>
        </div>
      );
    }
    return this.props.children;
  }
}
