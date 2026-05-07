"use client"

export default function GlobalError({
  error,
  reset,
}: {
  error: Error & { digest?: string }
  reset: () => void
}) {
  return (
    <html>
      <body style={{ fontFamily: "system-ui", padding: "2rem", background: "#0a0a0a", color: "#fff" }}>
        <h1 style={{ fontSize: "1.5rem", marginBottom: "1rem" }}>Mission Control - Error</h1>
        <p style={{ color: "#888", marginBottom: "1rem" }}>{error.message || "An unexpected error occurred."}</p>
        {error.digest && <p style={{ color: "#666", fontSize: "0.85rem" }}>Digest: {error.digest}</p>}
        <button
          onClick={reset}
          style={{ marginTop: "1rem", padding: "0.5rem 1rem", background: "#222", color: "#fff", border: "1px solid #444", borderRadius: 4, cursor: "pointer" }}
        >
          Retry
        </button>
      </body>
    </html>
  )
}
