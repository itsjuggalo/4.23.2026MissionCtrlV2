'use client';
import { ReactNode } from 'react';

interface PreviewWrapperProps {
  children: ReactNode;
  pageName?: string;
}

export function PreviewWrapper({ children, pageName }: PreviewWrapperProps) {
  return (
    <div>
      {pageName && (
        <div className="mb-4 px-4 py-2 bg-blue-500/5 border border-blue-500/20 rounded-lg">
          <span className="text-xs font-semibold text-blue-400">PREVIEW</span>
          <span className="text-xs text-blue-300 ml-2">{pageName}</span>
          <p className="text-xs text-blue-400/60 mt-0.5">
            Safe staging version — changes here won&apos;t affect production.
          </p>
        </div>
      )}
      {children}
    </div>
  );
}
