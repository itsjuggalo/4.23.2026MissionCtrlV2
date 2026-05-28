import Link from 'next/link';

export default function NotFound() {
  return (
    <html lang="en">
      <body style={{ margin: 0, background: '#0a0f1a', color: '#e0e6f0', fontFamily: 'monospace', display: 'flex', alignItems: 'center', justifyContent: 'center', minHeight: '100vh' }}>
        <div style={{ textAlign: 'center' }}>
          <div style={{ fontSize: '4rem', fontWeight: 900, color: '#1976d2', letterSpacing: '0.1em' }}>404</div>
          <div style={{ fontSize: '1rem', color: '#607d8b', marginTop: '8px', marginBottom: '24px' }}>PAGE NOT FOUND</div>
          <Link href="/" style={{ color: '#1976d2', textDecoration: 'none', fontSize: '0.875rem', border: '1px solid #1976d233', padding: '8px 16px', borderRadius: '4px' }}>
            ← RETURN TO COMMAND CENTER
          </Link>
        </div>
      </body>
    </html>
  );
}
