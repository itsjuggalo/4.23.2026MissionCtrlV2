import { TradeProposal, SimState, RiskValidationResult } from '../types';

// Hard limits — NON-BYPASSABLE
const HARD_LIMITS = {
  maxRiskPerTradePct: 0.01,
  maxDailyLossPct: 0.02,
  maxOpenTrades: 5,
  minRRRatio: 2.0,
  minConfidence: 60,
  maxSingleAssetExposurePct: 0.20,
  cooldownMs: 60000,
};

export function validateTrade(
  proposal: TradeProposal,
  state: SimState,
  portfolioValue: number
): RiskValidationResult {
  const checks: RiskValidationResult['checks'] = [];

  // 1. Stop loss required
  const hasStopLoss = proposal.stopLoss > 0 &&
    (proposal.direction === 'long'
      ? proposal.stopLoss < proposal.entryPrice
      : proposal.stopLoss > proposal.entryPrice);
  checks.push({
    name: 'Stop Loss Required',
    passed: hasStopLoss,
    message: hasStopLoss ? 'Stop loss set correctly' : 'Stop loss missing or invalid',
  });

  // 2. Risk per trade
  const riskPerTrade = Math.abs(proposal.entryPrice - proposal.stopLoss) * proposal.quantity;
  const riskPct = riskPerTrade / portfolioValue;
  const riskOk = riskPct <= HARD_LIMITS.maxRiskPerTradePct;
  checks.push({
    name: 'Max Risk Per Trade (1%)',
    passed: riskOk,
    message: riskOk
      ? `Risk: ${(riskPct * 100).toFixed(2)}% — within limit`
      : `Risk: ${(riskPct * 100).toFixed(2)}% — exceeds 1% limit`,
  });

  // 3. R/R ratio
  const potentialProfit = Math.abs(proposal.takeProfit - proposal.entryPrice) * proposal.quantity;
  const rrRatio = riskPerTrade > 0 ? potentialProfit / riskPerTrade : 0;
  const rrOk = rrRatio >= HARD_LIMITS.minRRRatio;
  checks.push({
    name: `Min R/R Ratio (${HARD_LIMITS.minRRRatio}:1)`,
    passed: rrOk,
    message: rrOk
      ? `R/R: ${rrRatio.toFixed(2)}:1 — acceptable`
      : `R/R: ${rrRatio.toFixed(2)}:1 — below minimum 2:1`,
  });

  // 4. Max open trades
  const openTrades = state.positions.filter(p => p.status === 'open').length;
  const tradesOk = openTrades < HARD_LIMITS.maxOpenTrades;
  checks.push({
    name: `Max Open Trades (${HARD_LIMITS.maxOpenTrades})`,
    passed: tradesOk,
    message: tradesOk
      ? `Open trades: ${openTrades}/${HARD_LIMITS.maxOpenTrades}`
      : `Too many open trades: ${openTrades}/${HARD_LIMITS.maxOpenTrades}`,
  });

  // 5. Daily loss limit
  const dailyLossPct = Math.abs(state.dailyPnL) / portfolioValue;
  const drawdownOk = state.dailyPnL >= 0 || dailyLossPct < HARD_LIMITS.maxDailyLossPct;
  checks.push({
    name: 'Daily Drawdown Limit (2%)',
    passed: drawdownOk,
    message: drawdownOk
      ? `Daily P&L: ${state.dailyPnL >= 0 ? '+' : ''}$${state.dailyPnL.toFixed(0)}`
      : `Daily loss limit reached: ${(dailyLossPct * 100).toFixed(2)}%`,
  });

  // 6. Minimum confidence
  const confidenceOk = proposal.confidence >= HARD_LIMITS.minConfidence;
  checks.push({
    name: `Min Confidence (${HARD_LIMITS.minConfidence}%)`,
    passed: confidenceOk,
    message: confidenceOk
      ? `Confidence: ${proposal.confidence}%`
      : `Confidence too low: ${proposal.confidence}% < ${HARD_LIMITS.minConfidence}%`,
  });

  // 7. Available funds
  const wallet = state.walletBalances[proposal.walletId];
  const tradeValue = proposal.entryPrice * proposal.quantity;
  const fundsOk = wallet !== undefined && wallet >= tradeValue;
  checks.push({
    name: 'Sufficient Funds',
    passed: fundsOk,
    message: fundsOk
      ? `Required: $${tradeValue.toFixed(0)}, Available: $${(wallet ?? 0).toFixed(0)}`
      : `Insufficient funds. Required: $${tradeValue.toFixed(0)}, Available: $${(wallet ?? 0).toFixed(0)}`,
  });

  const failedCheck = checks.find(c => !c.passed);
  return {
    passed: !failedCheck,
    rejectionReason: failedCheck?.message,
    checks,
  };
}

export function calculatePositionSize(
  entryPrice: number,
  stopLoss: number,
  portfolioValue: number,
  riskPct = 0.008
): number {
  const riskPerUnit = Math.abs(entryPrice - stopLoss);
  if (riskPerUnit === 0) return 0;
  const riskDollars = portfolioValue * riskPct;
  const quantity = riskDollars / riskPerUnit;
  return Math.floor(quantity * 1000) / 1000;
}

export { HARD_LIMITS };
