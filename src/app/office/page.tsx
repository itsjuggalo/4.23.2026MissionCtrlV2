'use client';

import { useEffect } from 'react';
import { useRouter } from 'next/navigation';

export default function OfficeRedirect() {
  const router = useRouter();

  useEffect(() => {
    // Redirect to home with page query param
    router.push('/?page=office');
  }, [router]);

  return (
    <div style={{
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100vh',
      fontSize: '16px'
    }}>
      Redirecting to Office page...
    </div>
  );
}
