'use client';

import { useEffect } from 'react';
import { useRouter } from 'next/navigation';

export default function TradesRedirect() {
  const router = useRouter();

  useEffect(() => {
    // Redirect to home with page query param
    router.push('/?page=trades');
  }, [router]);

  return (
    <div style={{
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100vh',
      fontSize: '16px'
    }}>
      Redirecting to Trades page...
    </div>
  );
}
