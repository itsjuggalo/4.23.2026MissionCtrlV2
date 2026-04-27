'use client';
import { PreviewWrapper } from '@/components/preview/PreviewWrapper';
import { SignalsPage } from '@/components/pages/SignalsPage';

export default function PreviewSignalsPage() {
  return (
    <PreviewWrapper pageName="Signals">
      <SignalsPage />
    </PreviewWrapper>
  );
}
