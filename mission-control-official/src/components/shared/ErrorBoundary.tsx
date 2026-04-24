'use client';
import React from 'react';

interface Props {
  children: React.ReactNode;
  fallback?: React.ReactNode;
  name?: string;
}

interface State {
  hasError: boolean;
  error: Error | null;
}

export class ErrorBoundary extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = { hasError: false, error: null };
  }

  static getDerivedStateFromError(error: Error): State {
    return { hasError: true, error };
  }

  componentDidCatch(error: Error, info: React.ErrorInfo) {
    console.error(`[ErrorBoundary${this.props.name ? ` — ${this.props.name}` : ''}]`, error, info);
  }

  render() {
    if (this.state.hasError) {
      if (this.props.fallback) return this.props.fallback;
      return (
        <div className="p-6">
          <div className="bg-red-500/10 border border-red-500/20 rounded-lg p-6 max-w-2xl">
            <div className="flex items-center gap-3 mb-3">
              <span className="text-red-400 text-xl">⚠️</span>
              <h2 className="text-red-400 font-bold text-sm uppercase tracking-wider">
                {this.props.name ? `${this.props.name} — ` : ''}Page Error
              </h2>
            </div>
            <p className="text-sm text-red-300 mb-3">
              {this.state.error?.message || 'An unexpected error occurred.'}
            </p>
            <p className="text-xs text-red-400/60 mb-4">
              This page crashed but the rest of the app is unaffected.
            </p>
            <button
              onClick={() => this.setState({ hasError: false, error: null })}
              className="text-xs px-3 py-1.5 bg-red-500/20 hover:bg-red-500/30 text-red-300 rounded border border-red-500/20 transition-colors"
            >
              Try Again
            </button>
          </div>
        </div>
      );
    }
    return this.props.children;
  }
}
