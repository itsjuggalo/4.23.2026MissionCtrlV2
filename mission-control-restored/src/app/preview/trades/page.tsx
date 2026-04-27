'use client';
import { PreviewWrapper } from '@/components/preview/PreviewWrapper';
import { TradesPage } from '@/components/pages/TradesPage';

export default function PreviewTradesPage() {
  return (
    <PreviewWrapper pageName="Trades">
      <TradesPage />
    </PreviewWrapper>
  );
}
