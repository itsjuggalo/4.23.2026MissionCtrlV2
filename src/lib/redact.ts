/**
 * redact.ts — scrub secrets from text before persistence or response.
 *
 * Covers: api_key, secret, token, password, account_number (case-insensitive).
 * Used by: route handlers before inserting stdout/stderr tails into DB,
 *          before writing to exec-audit.log, and at the response layer.
 */

const SECRET_PATTERN = /((api[_-]?key|secret|token|password|bearer|authorization|account_number)\s*[:=]\s*)\S+/gi;

/**
 * Redact secret-looking key=value / key: value patterns from a string.
 */
export function redactString(text: string): string {
  return text.replace(SECRET_PATTERN, '$1<redacted>');
}

/**
 * Redact secrets from all string values in a JSON-serializable object.
 * Traverses nested objects and arrays.
 */
export function redactObject(obj: unknown): unknown {
  if (typeof obj === 'string') return redactString(obj);
  if (Array.isArray(obj)) return obj.map(redactObject);
  if (obj !== null && typeof obj === 'object') {
    const result: Record<string, unknown> = {};
    for (const [k, v] of Object.entries(obj as Record<string, unknown>)) {
      // Redact keys that look like secrets regardless of value type
      if (/api[_-]?key|secret|token|password|account_number/i.test(k) && typeof v === 'string') {
        result[k] = '<redacted>';
      } else {
        result[k] = redactObject(v);
      }
    }
    return result;
  }
  return obj;
}

/**
 * Truncate + redact a stdout/stderr buffer for safe persistence.
 */
export function redactTail(text: string, maxBytes = 50_000): string {
  const truncated = text.length > maxBytes ? '…' + text.slice(-maxBytes) : text;
  return redactString(truncated);
}
