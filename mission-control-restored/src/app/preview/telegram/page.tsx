'use client';
import { PreviewWrapper } from '@/components/preview/PreviewWrapper';
import { TelegramSignalsPage } from '@/components/pages/TelegramSignalsPage';

export default function PreviewTelegramSignalsPage() {
  return (
    <PreviewWrapper pageName="Telegram Signals">
      <TelegramSignalsPage />
    </PreviewWrapper>
  );
}
