interface Props {
  label: string;
  value: string | number;
  subLabel?: string;
  change?: number;
  status?: 'ok' | 'warning' | 'error';
}

export function MetricCard({ label, value, subLabel, change, status }: Props) {
  const changeColor = change === undefined ? '' : change >= 0 ? 'text-green-400' : 'text-red-400';
  return (
    <div className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
      <p className="text-xs text-[#888] uppercase tracking-wider mb-1">{label}</p>
      <p className="text-2xl font-semibold text-[#f0f0f0]">{value}</p>
      {(subLabel || change !== undefined) && (
        <div className="flex items-center gap-2 mt-1">
          {subLabel && <span className="text-xs text-[#888]">{subLabel}</span>}
          {change !== undefined && (
            <span className={`text-xs font-medium ${changeColor}`}>
              {change >= 0 ? '+' : ''}{change}%
            </span>
          )}
        </div>
      )}
    </div>
  );
}
