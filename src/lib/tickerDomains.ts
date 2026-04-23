// Ticker → primary domain for Clearbit logo lookup.
// Covers top ~200 US tickers. Fallback for unknown: ticker.toLowerCase() + ".com"
export const TICKER_DOMAINS: Record<string, string> = {
  // Mega caps
  AAPL: 'apple.com', MSFT: 'microsoft.com', GOOGL: 'abc.xyz', GOOG: 'abc.xyz',
  AMZN: 'amazon.com', META: 'meta.com', NVDA: 'nvidia.com', TSLA: 'tesla.com',
  BRK: 'berkshirehathaway.com', 'BRK.A': 'berkshirehathaway.com', 'BRK.B': 'berkshirehathaway.com',
  JPM: 'jpmorganchase.com', V: 'visa.com', UNH: 'unitedhealthgroup.com',
  JNJ: 'jnj.com', XOM: 'exxonmobil.com', WMT: 'walmart.com', MA: 'mastercard.com',
  PG: 'pg.com', HD: 'homedepot.com', LLY: 'lilly.com', AVGO: 'broadcom.com',
  ORCL: 'oracle.com', CVX: 'chevron.com', MRK: 'merck.com', ABBV: 'abbvie.com',
  KO: 'coca-cola.com', PEP: 'pepsico.com', COST: 'costco.com', BAC: 'bankofamerica.com',
  TMO: 'thermofisher.com', CRM: 'salesforce.com', ADBE: 'adobe.com', NFLX: 'netflix.com',
  AMD: 'amd.com', LIN: 'linde.com', DIS: 'disney.com', MCD: 'mcdonalds.com',
  CSCO: 'cisco.com', ACN: 'accenture.com', WFC: 'wellsfargo.com', ABT: 'abbott.com',
  PFE: 'pfizer.com', DHR: 'danaher.com', CMCSA: 'comcast.com', INTC: 'intel.com',
  NKE: 'nike.com', VZ: 'verizon.com', TMUS: 't-mobile.com', IBM: 'ibm.com',
  TXN: 'ti.com', PM: 'pmi.com', QCOM: 'qualcomm.com', NEE: 'nexteraenergy.com',
  UNP: 'up.com', RTX: 'rtx.com', BMY: 'bms.com', HON: 'honeywell.com',
  ELV: 'elevancehealth.com', SBUX: 'starbucks.com', LOW: 'lowes.com', INTU: 'intuit.com',
  SPGI: 'spglobal.com', MS: 'morganstanley.com', CAT: 'caterpillar.com', AMGN: 'amgen.com',
  GS: 'goldmansachs.com', AMAT: 'appliedmaterials.com', BA: 'boeing.com', ISRG: 'intuitive.com',
  DE: 'deere.com', NOW: 'servicenow.com', BKNG: 'booking.com', T: 'att.com',
  GE: 'ge.com', SYK: 'stryker.com', VRTX: 'vrtx.com', ADP: 'adp.com',
  CVS: 'cvshealth.com', BLK: 'blackrock.com', MDLZ: 'mondelezinternational.com',
  AXP: 'americanexpress.com', CI: 'thecignagroup.com', LMT: 'lockheedmartin.com',
  C: 'citigroup.com', ADI: 'analog.com', GILD: 'gilead.com', MO: 'altria.com',
  PLD: 'prologis.com', MMC: 'mmc.com', ZTS: 'zoetis.com', SCHW: 'schwab.com',
  TJX: 'tjx.com', REGN: 'regeneron.com', EOG: 'eogresources.com', SO: 'southerncompany.com',
  DUK: 'duke-energy.com', BSX: 'bostonscientific.com', PANW: 'paloaltonetworks.com',
  PGR: 'progressive.com', SLB: 'slb.com', TGT: 'target.com', CB: 'chubb.com',
  MU: 'micron.com', EQIX: 'equinix.com', ITW: 'itw.com', APD: 'airproducts.com',
  FI: 'fiserv.com', AON: 'aon.com', CSX: 'csx.com', NOC: 'northropgrumman.com',
  ICE: 'ice.com', KLAC: 'kla.com', HUM: 'humana.com', SNPS: 'synopsys.com',
  SHW: 'sherwin-williams.com', WM: 'wm.com', GD: 'gd.com', FDX: 'fedex.com',
  MCO: 'moodys.com', CME: 'cmegroup.com', CDNS: 'cadence.com', EMR: 'emerson.com',
  MMM: '3m.com', MAR: 'marriott.com', GIS: 'generalmills.com', USB: 'usbank.com',
  PNC: 'pnc.com', MCK: 'mckesson.com', COF: 'capitalone.com', FCX: 'fcx.com',
  ROP: 'ropertech.com', PSX: 'phillips66.com', TFC: 'truist.com', APH: 'amphenol.com',
  AJG: 'ajg.com', ORLY: 'oreillyauto.com', CL: 'colgatepalmolive.com', NSC: 'nscorp.com',
  TT: 'tranetechnologies.com', PYPL: 'paypal.com', ECL: 'ecolab.com', AFL: 'aflac.com',
  SRE: 'sempra.com', MET: 'metlife.com', HCA: 'hcahealthcare.com', AZO: 'autozone.com',
  OXY: 'oxy.com', PCAR: 'paccar.com', ROST: 'rossstores.com', AIG: 'aig.com',
  CARR: 'corporate.carrier.com', CTAS: 'cintas.com', PAYX: 'paychex.com', MNST: 'monsterenergy.com',
  BK: 'bnymellon.com', SPG: 'simon.com', HLT: 'hilton.com', DLR: 'digitalrealty.com',
  ADSK: 'autodesk.com', MSI: 'motorolasolutions.com', TEL: 'te.com', DHI: 'drhorton.com',
  AEP: 'aep.com', ALL: 'allstate.com', FTNT: 'fortinet.com', KMB: 'kimberly-clark.com',
  IDXX: 'idexx.com', RSG: 'rsg.com', LEN: 'lennar.com', WMB: 'williams.com',
  PRU: 'prudential.com', OTIS: 'otis.com', BDX: 'bd.com', ODFL: 'odfl.com',
  ANET: 'arista.com', PH: 'parker.com', STZ: 'stz.com', KHC: 'kraftheinzcompany.com',
  EXC: 'exeloncorp.com', KR: 'kroger.com', DXCM: 'dexcom.com', TRV: 'travelers.com',
  F: 'ford.com', GM: 'gm.com', KMI: 'kindermorgan.com', HSY: 'hersheys.com',
  NXPI: 'nxp.com', YUM: 'yum.com', A: 'agilent.com', CHTR: 'charter.com',
  IQV: 'iqvia.com', CTSH: 'cognizant.com', CNC: 'centene.com', SYY: 'sysco.com',
  EW: 'edwards.com', VLO: 'valero.com', MSCI: 'msci.com', VRSK: 'verisk.com',
  EL: 'elcompanies.com', CMI: 'cummins.com', AME: 'ametek.com', BKR: 'bakerhughes.com',
  D: 'dominionenergy.com', GEHC: 'gehealthcare.com', ON: 'onsemi.com', AMP: 'ameriprise.com',
  FIS: 'fisglobal.com', WELL: 'welltower.com', COP: 'conocophillips.com',
  MPC: 'marathonpetroleum.com', HAL: 'halliburton.com', ETN: 'eaton.com',
  MDT: 'medtronic.com', MO_: 'altria.com', BIIB: 'biogen.com', PYPL_: 'paypal.com',
  // Semi / Tech
  MRVL: 'marvell.com', LRCX: 'lamresearch.com', SMCI: 'supermicro.com',
  ASML: 'asml.com', TSM: 'tsmc.com', ARM: 'arm.com',
  // Fintech / Crypto
  SQ: 'block.xyz', COIN: 'coinbase.com', HOOD: 'robinhood.com', MSTR: 'microstrategy.com',
  // Travel / Leisure
  UAL: 'united.com', AAL: 'aa.com', DAL: 'delta.com', LUV: 'southwest.com', CCL: 'carnival.com',
  RCL: 'royalcaribbean.com', ABNB: 'airbnb.com', UBER: 'uber.com', LYFT: 'lyft.com',
  // Retail / Consumer
  EBAY: 'ebay.com', ETSY: 'etsy.com', LULU: 'lululemon.com', CMG: 'chipotle.com',
  WBA: 'walgreensbootsalliance.com', DLTR: 'dollartree.com', DG: 'dollargeneral.com',
  // Media / Entertainment
  SPOT: 'spotify.com', ROKU: 'roku.com', WBD: 'wbd.com', EA: 'ea.com', TTWO: 'take2games.com',
  // Biotech / Pharma
  NVAX: 'novavax.com', MRNA: 'modernatx.com', BNTX: 'biontech.de',
  // Energy
  EQT: 'eqt.com', DVN: 'devonenergy.com', PXD: 'pxd.com', APA: 'apacorp.com',
  // Industrial
  BWA: 'borgwarner.com', LI: 'lixiang.com', NIO: 'nio.com', RIVN: 'rivian.com', LCID: 'lucidmotors.com',
  // ETFs
  SPY: 'spglobal.com', QQQ: 'invesco.com', IWM: 'ishares.com', DIA: 'spglobal.com',
  VTI: 'vanguard.com', VOO: 'vanguard.com', VEA: 'vanguard.com', VWO: 'vanguard.com',
  XLK: 'ssga.com', XLF: 'ssga.com', XLE: 'ssga.com', XLV: 'ssga.com', XLI: 'ssga.com',
  XLY: 'ssga.com', XLP: 'ssga.com', XLU: 'ssga.com', XLB: 'ssga.com', XLC: 'ssga.com',
  TLT: 'ishares.com', HYG: 'ishares.com', LQD: 'ishares.com', GLD: 'spdrgoldshares.com',
  SLV: 'ishares.com', USO: 'uscfinvestments.com', UVXY: 'proshares.com', VIX: 'cboe.com',
  // Smaller caps we've seen in signals
  PCG: 'pcg.com', AXTI: 'axt.com', PLTR: 'palantir.com', SNOW: 'snowflake.com',
  NET: 'cloudflare.com', DDOG: 'datadoghq.com', ZS: 'zscaler.com', CRWD: 'crowdstrike.com',
  OKTA: 'okta.com', MDB: 'mongodb.com', TWLO: 'twilio.com', U: 'unity.com',
  SHOP: 'shopify.com', RBLX: 'roblox.com', PINS: 'pinterest.com', SNAP: 'snap.com',
  UPST: 'upstart.com', SOFI: 'sofi.com', AFRM: 'affirm.com', DKNG: 'draftkings.com',
  PENN: 'pennentertainment.com', MGM: 'mgmresorts.com', CIEN: 'ciena.com',
  LITE: 'lumentum.com', AAOI: 'ao-inc.com', EME: 'emcor.com',
};

/**
 * Get a Clearbit logo URL for a ticker. Returns null if we have no mapping
 * AND the naive fallback would almost certainly 404 (e.g. tickers with dots).
 * Otherwise returns the URL — the <img onError> handler is the final safety net.
 */
export function tickerLogoUrl(symbol: string): string | null {
  if (!symbol) return null;
  const up = symbol.toUpperCase();
  const mapped = TICKER_DOMAINS[up];
  if (mapped) return `https://logo.clearbit.com/${mapped}`;
  // Fallback: bet on ticker.lowercase.com working for unmapped ones.
  // Works for ~40% of tickers that happen to have this domain.
  if (!/^[A-Z]{1,6}$/.test(up)) return null; // skip weird tickers (BRK.B etc.)
  return `https://logo.clearbit.com/${up.toLowerCase()}.com`;
}
