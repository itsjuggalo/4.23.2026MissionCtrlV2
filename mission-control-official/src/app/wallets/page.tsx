'use client';
import { mockWallets } from '@/lib/mock/wallets';
import { PageHeader } from '@/components/shared/PageHeader';
import { StatusBadge } from '@/components/shared/StatusBadge';
import { WalletStatus } from '@/lib/types';

const walletStatusVariant: Record<WalletStatus, 'success' | 'error' | 'neutral'> = {
  active: 'success',
  inactive: 'neutral',
  error: 'error',
};

export default function WalletsPage() {
  const totalPortfolio = mockWallets.reduce((s, w) => s + w.totalBalance, 0);
  const totalAvailable = mockWallets.reduce((s, w) => s + w.availableFunds, 0);
  const totalInTrades = mockWallets.reduce((s, w) => s + w.fundsInTrades, 0);

  return (
    <div>
      <PageHeader title="Wallets" subtitle="Portfolio & Balance Overview" />

      {/* Global summary */}
      <div className="grid grid-cols-3 gap-4 mb-6">
        {[
          { label: 'Total Portfolio', value: `$${totalPortfolio.toLocaleString()}` },
          { label: 'Available Funds', value: `$${totalAvailable.toLocaleString()}` },
          { label: 'In Trades', value: `$${totalInTrades.toLocaleString()}` },
        ].map(({ label, value }) => (
          <div key={label} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            <p className="text-xs text-[#888] uppercase tracking-wider mb-1">{label}</p>
            <p className="text-2xl font-semibold text-[#f0f0f0]">{value}</p>
          </div>
        ))}
      </div>

      {/* Wallet cards */}
      <div className="grid grid-cols-1 xl:grid-cols-2 gap-4">
        {mockWallets.map(wallet => (
          <div key={wallet.id} className="bg-[#111] border border-[#1f1f1f] rounded-lg p-4">
            {/* Header */}
            <div className="flex items-center gap-2 mb-4">
              <h3 className="font-semibold text-[#f0f0f0]">{wallet.name}</h3>
              <StatusBadge variant="neutral">{wallet.type.replace('_', ' ')}</StatusBadge>
              <StatusBadge variant={walletStatusVariant[wallet.status]}>{wallet.status}</StatusBadge>
              {wallet.exchange && (
                <span className="ml-auto text-xs text-[#555]">{wallet.exchange}</span>
              )}
            </div>

            {/* Stats */}
            <div className="grid grid-cols-3 gap-3 mb-4">
              {[
                { label: 'Total Balance', value: `${wallet.currency} ${wallet.totalBalance.toLocaleString()}` },
                { label: 'Available', value: `${wallet.currency} ${wallet.availableFunds.toLocaleString()}` },
                { label: 'In Trades', value: `${wallet.currency} ${wallet.fundsInTrades.toLocaleString()}` },
              ].map(({ label, value }) => (
                <div key={label} className="bg-[#0d0d0d] rounded p-2">
                  <p className="text-[10px] text-[#555] uppercase tracking-wider mb-0.5">{label}</p>
                  <p className="text-sm font-medium text-[#f0f0f0]">{value}</p>
                </div>
              ))}
            </div>

            {/* Assets */}
            {wallet.assets.length > 0 ? (
              <table className="w-full">
                <thead>
                  <tr className="text-[10px] text-[#555] uppercase tracking-wider border-b border-[#1a1a1a]">
                    <th className="text-left pb-1.5">Asset</th>
                    <th className="text-right pb-1.5">Amount</th>
                    <th className="text-right pb-1.5">Value</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-[#1a1a1a]">
                  {wallet.assets.map(asset => (
                    <tr key={asset.symbol} className="text-sm">
                      <td className="py-1.5 font-medium text-[#f0f0f0]">{asset.symbol}</td>
                      <td className="py-1.5 text-right text-[#888] font-mono">{asset.amount}</td>
                      <td className="py-1.5 text-right text-[#f0f0f0] font-mono">${asset.value.toLocaleString()}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            ) : (
              <p className="text-xs text-[#444] text-center py-2">No open positions</p>
            )}
          </div>
        ))}
      </div>
    </div>
  );
}
