#!/home/itsju/.venv/bin/python
"""extend_bank_mastery.py — Options Mastery Phase 1: deepen the quiz bank.

Adds the ADVANCED tier the static 108-Q bank was missing — the content Mike said
felt "limiting": the volatility/edge tests, straddle MANAGEMENT, and the 5-author
"who's right & why" DEBATE type (judgment, not memorization). Source of truth =
straddle-playbook.md (researched 5 educators).

Idempotent: only appends questions whose id isn't already present; adds the new
modules to meta.modules if missing; bumps version. Re-runnable safely.

After running: build_academy.py regenerates the HTML so both surfaces (Telegram
reps + the Academy HTML) get the new content with zero drift.

Run:  extend_bank_mastery.py            (writes the bank)
      DRY=1 extend_bank_mastery.py      (prints what it WOULD add, no write)
"""
from __future__ import annotations
import json, os
from pathlib import Path

BANK = Path(__file__).resolve().parent / "options_quiz_bank.json"
DRY = os.environ.get("DRY") == "1"

NEW_MODULES = [
    {"id": "vol-edge", "name": "Volatility Edge & Expected Move",
     "blurb": "The straddle price IS the expected move. IV/HV cheap-vs-rich, IV crush, theta back-loading, edge ratio — the test of whether vol is mispriced."},
    {"id": "management", "name": "Managing the Trade",
     "blurb": "Cut the dead leg, scale winners at +50%, breakeven-after-T1, the −50% stop, roll the loser, convert to a butterfly."},
    {"id": "debate", "name": "How the Pros Disagree",
     "blurb": "tastytrade vs SteadyOptions vs SMB vs Option Alpha vs projectfinance — same setup, opposite calls. Learning to reason across the lenses IS the edge."},
]

# Each question stays MCQ-compatible (single correct_index) so it grades on both
# Telegram and the HTML. `why` is self-contained (works everywhere). `debate` is an
# OPTIONAL structured field the HTML can render as a lens panel — Telegram ignores it.
NEW_QUESTIONS = [
    # ----------------------------- vol-edge ------------------------------------ #
    {"id": "opt-109", "module": "vol-edge", "level": 2,
     "question": "SPY is $745 and the at-the-money straddle (ATM call + ATM put, same expiry) costs $8.00. What is that $8 actually telling you?",
     "options": ["The stock will definitely move $8", "The market's EXPECTED move by expiry is ~$8 (≈1.1%) in EITHER direction",
                 "You'll make $8 if you buy it", "The maximum the stock can move is $8"],
     "correct_index": 1,
     "why": "The ATM straddle price IS the market's expected (1-sigma-ish) move. $8 on $745 ≈ 1.1%. This is the single most important number in vol trading: every straddle decision reduces to 'is that expected move CHEAP or RICH versus how this stock actually moves?' It's a probability, not a promise — the stock can move far more or far less.",
     "tags": ["expected-move", "straddle", "core"],
     "rh_note": "Before you ever buy a straddle, read the ATM straddle price first — that's the bar your move has to clear just to break even."},

    {"id": "opt-110", "module": "vol-edge", "level": 2,
     "question": "You buy that $8.00 SPY straddle. At expiration, where do you actually make money?",
     "options": ["Anywhere the stock moves at all", "Only if SPY moves MORE than $8 (above $753 or below $737)",
                 "Only if SPY goes up", "As long as IV stays the same"],
     "correct_index": 1,
     "why": "A long straddle's breakevens are strike ± debit: 745 ± 8 = 737 and 753. The stock must move MORE than the expected move you paid for. This is why 'buying a straddle because a big move is coming' usually loses — the big move is already priced in. You need a move bigger than the one everyone agrees on.",
     "tags": ["breakeven", "expected-move", "straddle"]},

    {"id": "opt-111", "module": "vol-edge", "level": 2,
     "question": "A stock's options show IV = 18% while its recent realized (historical) volatility is HV = 26%. IV/HV = 0.69. What does that say?",
     "options": ["Vol is RICH — sell premium", "Vol is CHEAP — the move is underpriced vs how the stock actually moves (a buyer's setup)",
                 "Nothing — IV and HV are unrelated", "The stock is about to crash"],
     "correct_index": 1,
     "why": "IV/HV below ~0.85 = the market is pricing LESS movement than the stock has actually been delivering → options are cheap → favors the BUYER. Above ~1.20 = rich → favors the SELLER. This ratio is the engine's primary cheap/rich gate (straddle_engine IV_RV_CHEAP=0.85, IV_RV_RICH=1.20). Cheap vol alone isn't a green light though — you still need a catalyst (next question).",
     "tags": ["iv-hv", "cheap-rich", "edge-test"]},

    {"id": "opt-112", "module": "vol-edge", "level": 3,
     "question": "Vol is CHEAP (IV/HV 0.72) but there's NO catalyst — no earnings, no Fed, no event — in the option's life. The engine says CHEAP·WAIT. Why not just buy the cheap vol?",
     "options": ["Cheap vol can't be traded", "Without a driver, theta bleeds the position daily — cheap vol with no catalyst is a slow loss, not an edge",
                 "You always buy cheap vol", "Because SPY never moves"],
     "correct_index": 1,
     "why": "Cheapness tells you the move is underpriced; a CATALYST is what makes the move actually happen before theta eats you. Cheap vol + no catalyst = you're paying rent (theta) for a move that has no reason to come. The pros wait for cheap vol AND a driver (earnings 5–14d out, Fed/CPI 2–5d). That's the difference between the engine's CHEAP·WAIT and a real GO.",
     "tags": ["catalyst", "theta", "cheap-wait"],
     "debate": [
        {"author": "tastytrade", "stance": "Wouldn't buy it at all — long premium has negative expectancy on average (VRP)."},
        {"author": "SteadyOptions", "stance": "Agrees — buy only when a catalyst will lift IV while you hold; no catalyst, no trade."},
        {"author": "Option Alpha", "stance": "Systematic trigger missing — no IV-expansion driver means no entry signal."}
     ]},

    {"id": "opt-113", "module": "vol-edge", "level": 3,
     "question": "It's the day before earnings. IV is jacked to the 90th percentile. You buy a straddle expecting a big move. The stock gaps 4% the right way — and you still LOSE. What happened?",
     "options": ["The broker stole it", "IV CRUSH — post-earnings IV collapsed 30–60%, and the vega loss outran your directional gain",
                 "You bought the wrong strike", "Theta over one night"],
     "correct_index": 1,
     "why": "A long straddle is long vega. Buying it at 90th-percentile IV means you paid for a huge expected move; once the news is out, IV crushes 30–60% and the premium deflates even if direction was right — unless the move beats the (already enormous) implied move. This is THE classic earnings trap. SteadyOptions' answer: buy the IV RAMP days before and EXIT BEFORE the print — never hold a long single-leg through the crush.",
     "tags": ["iv-crush", "earnings", "vega"],
     "rh_note": "On RH, holding a long call/put through earnings is the fastest way to be 'right and still red.' Close before the print or use a calendar."},

    {"id": "opt-114", "module": "vol-edge", "level": 3,
     "question": "projectfinance's mechanics: a 30-day ATM option's time value doesn't decay evenly. Roughly when has it lost about HALF its time value?",
     "options": ["By day 1", "By about day 8 (the back half of the clock decays fastest)", "Only in the last hour", "Evenly — 1/30 per day"],
     "correct_index": 1,
     "why": "Theta is non-linear and BACK-LOADED: a 30-day ATM loses ~50% of its time value by ~day 8, and the decay accelerates into expiry (OTM options bleed even faster late). This is why 'I'll give it time' is a trap — the rent goes UP the longer you hold. It's also why the engine sets a 21-DTE time-stop: past that, theta acceleration works hard against a long option.",
     "tags": ["theta", "back-loaded", "dte"]},

    {"id": "opt-115", "module": "vol-edge", "level": 2,
     "question": "It's Friday. You're holding a long option over the weekend (market closed Sat/Sun). What happens to theta?",
     "options": ["Theta pauses — markets are closed", "Theta keeps decaying — you pay ~3 calendar days of time value Friday→Monday for 0 trading days",
                 "You gain theta", "Nothing changes"],
     "correct_index": 1,
     "why": "Time value tracks CALENDAR time, not trading days. A long option over a weekend decays ~3 days while you get 0 trading sessions to be right — and a 3-day holiday weekend is even worse (2–3× a normal day's bleed). Market makers price weekend/holiday theta in on Friday. This is exactly why a long straddle over a closed Friday (e.g. Juneteenth) is a theta trap — buy further-dated or wait.",
     "tags": ["theta", "weekend", "holiday"]},

    {"id": "opt-116", "module": "vol-edge", "level": 3,
     "question": "The 'edge ratio' the engine reports = realized move ÷ implied move. It reads 1.35. What does that mean for a straddle buyer?",
     "options": ["Bad — the move is overpriced", "Good — the stock typically moves 1.35× what the straddle is pricing, so the move is CHEAP (buyer's edge)",
                 "It means sell premium", "Nothing useful"],
     "correct_index": 1,
     "why": "edge_ratio = realized/implied. >1 means the stock has historically moved MORE than the option is pricing → you're buying a move at a discount. <1 means the move is overpriced → you'd overpay (seller's edge). It's the same cheap/rich idea as IV/HV but expressed directly in move terms, which is easier to act on: 'they're charging me for a 1% move and this thing usually does 1.35%.'",
     "tags": ["edge-ratio", "implied-vs-realized", "core"]},

    {"id": "opt-117", "module": "vol-edge", "level": 3,
     "question": "tastytrade's core claim: across thousands of trades, buying premium has roughly NEGATIVE expectancy. What structural fact makes that true?",
     "options": ["Brokers cheat buyers", "The Variance Risk Premium — implied vol is systematically HIGHER than realized vol, so on average buyers overpay and sellers collect",
                 "Options always expire worthless", "Stocks only go up"],
     "correct_index": 1,
     "why": "The Variance Risk Premium (VRP): IV trades above subsequent realized vol most of the time because people pay up for insurance/leverage. So a naive 'always buy straddles' bleeds the premium. That's why tastytrade SELLS. The buyer's counter (SteadyOptions): don't fight the VRP by holding to expiry — exit before the crush and harvest the IV RAMP. Both are internally consistent; the VRP is why you can't buy blindly.",
     "tags": ["vrp", "tastytrade", "expectancy"]},

    {"id": "opt-118", "module": "vol-edge", "level": 3,
     "question": "SMB Capital's earnings method: a stock has averaged an 8% move on its last several earnings, but the straddle is currently pricing only a 5% move. SMB's read?",
     "options": ["Sell an iron condor", "BUY the straddle — the implied move (5%) is UNDER the stock's historical move (8%), so it's mispriced cheap",
                 "Do nothing", "Buy stock instead"],
     "correct_index": 1,
     "why": "SMB prices the straddle against the stock's OWN historical earnings moves. Implied 5% < historical 8% → the market is underpricing this name's tendency to move on earnings → buy. Flip it (implied 11% vs historical 8%) → sell premium / iron condor OUTSIDE the expected move. It's the cleanest 'is the move cheap or rich' test because the benchmark is the stock's actual track record, not a generic vol number.",
     "tags": ["smb", "earnings", "historical-move"]},

    {"id": "opt-119", "module": "vol-edge", "level": 2,
     "question": "IV Rank (IVR) tells you where today's IV sits in its own 52-week range. You see IVR = 15. For a premium BUYER, is that good or bad?",
     "options": ["Bad — IV is high", "Good — IV is near its 1-year LOW (cheap), the zone to BUY premium, not sell it",
                 "Irrelevant", "It means earnings are coming"],
     "correct_index": 1,
     "why": "IVR < ~20–30 = vol is cheap relative to its own history → buy premium / avoid selling. IVR > ~50–80 = vol is rich → sell premium / avoid buying single legs. The IV-regime gate: high IVR → be a seller (credit spreads, iron condors); low IVR → be a buyer (debit structures, straddles when a catalyst exists). Trading the wrong side of the IV regime is a top retail mistake.",
     "tags": ["iv-rank", "regime", "buy-sell"]},

    {"id": "opt-120", "module": "vol-edge", "level": 3,
     "question": "Into the final day, your ATM option's GAMMA spikes hard. What's the practical danger of holding ATM into expiration?",
     "options": ["Nothing — gamma is good", "Pin risk + violent P/L swings — tiny stock moves flip the option's delta wildly, and assignment/exercise gets messy",
                 "Theta disappears", "IV goes to infinity"],
     "correct_index": 1,
     "why": "ATM gamma explodes near expiry: delta swings from ~0 to ~1 on small moves, so P/L whipsaws and the option can pin near the strike (max uncertainty about ITM/OTM). For a buyer it means your edge is now a coin flip on noise; for anyone short it's assignment risk. Manage or close before the last day rather than gambling on the gamma knife-edge.",
     "tags": ["gamma", "pin-risk", "expiration"]},

    # ----------------------------- management ---------------------------------- #
    {"id": "opt-121", "module": "management", "level": 2,
     "question": "You're long a straddle. The CALL leg is +80% and the PUT leg is nearly worthless after a clean move up. Best management?",
     "options": ["Hold both and hope the put recovers", "Cut the dead leg — take the winning call (or trail it) and stop paying to hold a put that's lost its thesis",
                 "Buy more puts", "Sell the call, hold the put"],
     "correct_index": 1,
     "why": "Once direction resolves, the losing leg is dead weight with decaying theta and no thesis. 'Cut the dead leg': lock or trail the winner, close the loser. Holding the dead put hoping for a reversal is how a winning straddle round-trips back to red. This is the exact lesson from the post-FOMC trade — the put won, the call was worthless; the edge was in NOT giving the winner back.",
     "tags": ["cut-dead-leg", "straddle", "manage"],
     "rh_note": "Your real post-FOMC straddle: put won, call died. Cutting the dead call and riding/locking the put is what turns a +30% into a kept +30%."},

    {"id": "opt-122", "module": "management", "level": 2,
     "question": "A long option position hits +50% on the debit you paid. The disciplined move that the profit-lock daemon now does in shadow mode?",
     "options": ["Hold for +500% or zero", "Sell HALF (bank the win), then arm a breakeven stop on the runner so the rest can't go red",
                 "Double down", "Sell everything and never re-enter"],
     "correct_index": 1,
     "why": "Scale-out: at +T1 (≈+50%) sell half to bank a real gain, then move the stop to breakeven on the remaining half so the worst case on the runner is flat — you've made money and given yourself a free shot at the home run. 'Scale winners, never give it all back.' This is now mechanical in profit_lock_daemon (SCALE_OUT_MODE), not just a rule in your head.",
     "tags": ["scale-out", "breakeven", "t1"]},

    {"id": "opt-123", "module": "management", "level": 2,
     "question": "Your long straddle is down 50% of the debit you paid and the catalyst already passed. The engine's rule?",
     "options": ["Average down", "Cut it — the −50% stop. The thesis (a move) didn't show; the rest is theta bleed",
                 "Hold to expiration", "Roll it out a year"],
     "correct_index": 1,
     "why": "STOP_FRAC = 0.50: a long straddle down 50% with the catalyst gone has failed its thesis — the expected move didn't materialize and theta will finish the job. The stop IS the trade: you survive to take the next setup. Averaging down on a decaying long-vol position is throwing more rent at a move that isn't coming.",
     "tags": ["stop", "risk", "straddle"]},

    {"id": "opt-124", "module": "management", "level": 3,
     "question": "Option Alpha's adjustment: you're long a straddle that's run your way and you want to LOCK gains while cutting theta. One classic move?",
     "options": ["Buy more of both legs", "Convert toward a butterfly — sell OTM wings against your long straddle to take in credit, cap risk, and reduce theta",
                 "Close and walk away only", "Add a third leg at random"],
     "correct_index": 1,
     "why": "Selling OTM options against your long straddle (toward an iron butterfly/condor) collects premium that offsets theta and locks in some of the move, in exchange for capping further upside. It's a way to 'bank the move without fully exiting.' Option Alpha leans on systematic adjustments like this; the alternative is simply scaling out. Both beat passively holding a winner into decay.",
     "tags": ["butterfly", "adjust", "option-alpha"]},

    {"id": "opt-125", "module": "management", "level": 3,
     "question": "After a sharp directional move, your straddle is now badly off-center (stock far from the strike). A way to keep the long-vol thesis alive?",
     "options": ["Nothing can be done", "ROLL the losing leg toward the money (re-center) so the structure tracks the new price",
                 "Close the winning leg only", "Buy stock to hedge"],
     "correct_index": 1,
     "why": "When price runs, the straddle is no longer ATM — the far leg is dead and the near leg is doing all the work. Rolling the losing leg up/down re-centers the position so it can still profit from continued movement, at the cost of more debit. It's a judgment call vs. just cutting the dead leg; roll when you still believe in MORE movement, cut when the move is done.",
     "tags": ["roll", "recenter", "straddle"]},

    {"id": "opt-126", "module": "management", "level": 2,
     "question": "T1 just filled (you sold half at +50%). What's the 'breakeven-after-T1' rule for the remaining half?",
     "options": ["Set a new target at +1000%", "Move the stop to your ENTRY price — the runner can no longer turn the trade into a loss",
                 "Add to the position", "Remove all stops"],
     "correct_index": 1,
     "why": "Breakeven-after-T1: once you've banked half at the first target, slide the stop on the rest to your entry. Now the worst case is 'I made money on half and broke even on the rest' — you've removed the risk of a winner becoming a loser. It's the mechanical heart of 'never give it all back,' and it's what arms after the T1 partial in the profit-lock daemon.",
     "tags": ["breakeven", "scale-out", "stop"]},

    {"id": "opt-127", "module": "management", "level": 3,
     "question": "You want to play an earnings move but refuse to eat the IV crush. Which structure is BUILT to harvest the crush instead of being killed by it?",
     "options": ["Long single-leg call", "A CALENDAR (sell the front-month/expiry that crushes, buy a later one) — you're net short the crushing IV",
                 "Long straddle held through the print", "Naked short put"],
     "correct_index": 1,
     "why": "A calendar sells the near-dated option (whose IV crushes hardest right after the event) and buys a later-dated one (whose IV holds better), so the post-print IV collapse HELPS you. It's the preferred earnings structure when you expect a contained move: harvest the crush rather than fight it. Long single legs through earnings are the VETO case — right direction, still red.",
     "tags": ["calendar", "iv-crush", "earnings"]},

    # ------------------------------- debate ------------------------------------ #
    {"id": "opt-128", "module": "debate", "level": 3,
     "question": "Setup: IV Rank is 85 (vol near a 1-year high), no strong directional view, you want to trade the elevated vol. Whose playbook FITS this setup best?",
     "options": ["SteadyOptions — buy the IV ramp", "tastytrade — SELL premium (defined-risk: iron condor/credit spread); rich IV favors the seller",
                 "Just buy a long straddle", "projectfinance — buy an OTM strangle"],
     "correct_index": 1,
     "why": "High IVR + no directional view = a SELLER's setup. tastytrade is right HERE: when IV is rich, sell premium and let the VRP work for you (prefer DEFINED-risk on a small account — an iron condor, not a naked strangle). SteadyOptions buys vol, but only when it's CHEAP and a catalyst will lift it — the opposite of IVR 85. Same market, different regime: the skill is matching the author to the vol regime.",
     "tags": ["debate", "iv-regime", "tastytrade"],
     "debate": [
        {"author": "tastytrade", "stance": "FITS: IV rich → sell premium, manage at 50%. Their home turf."},
        {"author": "SteadyOptions", "stance": "Would PASS: they buy cheap vol + catalyst; IVR 85 is the wrong side."},
        {"author": "SMB", "stance": "Only if it's a pre-earnings name and implied > historical move → sell outside the move."},
        {"author": "Option Alpha", "stance": "Mechanical seller here too — high IVR is a premium-selling trigger."},
        {"author": "projectfinance", "stance": "Neutral mechanics — would note theta favors the seller at high IV."}
     ]},

    {"id": "opt-129", "module": "debate", "level": 3,
     "question": "Setup: IV Rank is 12 (vol near a 1-year LOW) and a Fed decision lands in 4 days. Whose approach fits?",
     "options": ["tastytrade — sell premium", "SteadyOptions / Option Alpha — BUY premium: cheap vol + a catalyst that should EXPAND IV before the event",
                 "Do nothing — IV is too low to trade", "SMB — sell an iron condor"],
     "correct_index": 1,
     "why": "Low IVR + a known catalyst = a BUYER's setup. SteadyOptions buys the pre-event IV ramp; Option Alpha's trigger is 'need IV to expand.' Cheap vol means you're not overpaying, and the Fed event is the driver that lifts IV (and can move the underlying). tastytrade generally won't buy, but even they'd agree selling vol at IVR 12 is a poor risk/reward. The catalyst is what separates this GO from the earlier CHEAP·WAIT.",
     "tags": ["debate", "catalyst", "steadyoptions"],
     "debate": [
        {"author": "SteadyOptions", "stance": "FITS: buy the ramp into the Fed, exit before/at the event as IV peaks."},
        {"author": "Option Alpha", "stance": "FITS: low IV + catalyst = IV-expansion trigger met."},
        {"author": "tastytrade", "stance": "Won't sell at IVR 12 (no premium to collect); generally stays out of long vol."},
        {"author": "SMB", "stance": "Wants a historical-move benchmark; Fed isn't a single-stock earnings move."}
     ]},

    {"id": "opt-130", "module": "debate", "level": 3,
     "question": "tastytrade says long premium has NO edge. SteadyOptions makes money BUYING premium. They can't both be right — or can they? What reconciles it?",
     "options": ["One of them is lying", "Different TRADES: tastytrade holds to expiry (pays the VRP); SteadyOptions EXITS before the IV crush, harvesting the ramp — so they're not doing the same thing",
                 "tastytrade is always right", "SteadyOptions is always right"],
     "correct_index": 1,
     "why": "This is the most important reconciliation in the whole playbook. 'Buying premium' isn't one strategy. tastytrade's data is about HOLDING long options to expiration — there the VRP makes it a loser. SteadyOptions never holds through the crush; they buy the pre-earnings IV RAMP and SELL before the print, capturing rising vega while avoiding the crush. Same instrument, opposite holding period = opposite expectancy. Understanding WHY both are right is mastery; memorizing one rule is the 'limiting' trap.",
     "tags": ["debate", "vrp", "reconcile", "core"],
     "debate": [
        {"author": "tastytrade", "stance": "Measures HOLD-to-expiry long premium → negative expectancy (VRP). True for that trade."},
        {"author": "SteadyOptions", "stance": "Buys the IV ramp, EXITS before the crush → positive expectancy. True for THAT trade."},
        {"author": "Takeaway", "stance": "'Buy or sell premium?' is the wrong question. 'What's my holding period vs the crush?' is the right one."}
     ]},

    {"id": "opt-131", "module": "debate", "level": 2,
     "question": "Same name, earnings in 2 days: the straddle prices an 11% move; the stock has historically moved ~8% on earnings. SMB Capital's call?",
     "options": ["Buy the straddle", "SELL premium (e.g. an iron condor) OUTSIDE the expected move — implied (11%) is RICHER than the stock's historical (8%)",
                 "Buy a calendar", "No trade possible"],
     "correct_index": 1,
     "why": "SMB benchmarks implied vs the stock's OWN history. Implied 11% > historical 8% → the move is overpriced → be a seller, structuring an iron condor with short strikes outside the ~8% the stock actually tends to do. Flip the numbers (implied 5% < historical 8%) and SMB BUYS the straddle. The benchmark is the name's track record, which is why SMB's method travels across tickers.",
     "tags": ["debate", "smb", "historical-move"]},

    {"id": "opt-132", "module": "debate", "level": 3,
     "question": "You're long a straddle; the up-move came, the call leg is +120%, the put is dead. 'Just hold both to expiry' vs Option Alpha's instinct — what's the disciplined play?",
     "options": ["Hold both to expiry and hope for more", "MANAGE it — cut/trail the dead put, scale the call (take half, trail the rest); don't round-trip a +120% winner",
                 "Sell the call, buy more puts", "Add another straddle on top"],
     "correct_index": 1,
     "why": "Holding a resolved straddle to expiry surrenders the winner to theta and a possible reversal. The managed play: the put is dead (cut or let it expire worthless — its thesis is gone), and the call gets scaled — bank half at this huge gain, trail the rest with a breakeven-or-better stop. projectfinance's theta math says the back end of the clock punishes holders; Option Alpha says adjust/lock. Passive 'hold to expiry' is the trap.",
     "tags": ["debate", "manage", "cut-dead-leg"]},

    {"id": "opt-133", "module": "debate", "level": 2,
     "question": "projectfinance stresses theta is BACK-LOADED. Given that, when is an OTM long straddle the MOST dangerous to keep holding?",
     "options": ["The first day", "In the final third of its life — OTM time value decays fastest late, so a flat position bleeds out quickly near expiry",
                 "It's never dangerous", "Only at the open"],
     "correct_index": 1,
     "why": "projectfinance's mechanics: OTM options hold value early but decay viciously in the back third (an OTM can lose ~50% of value in roughly the last third of a 45-day life). So a straddle that hasn't worked and is drifting toward expiry is on a cliff. This is the math behind the engine's 21-DTE time-stop and the rule 'if it isn't working and the catalyst passed, don't let theta finish you.'",
     "tags": ["debate", "theta", "projectfinance", "dte"]},

    {"id": "opt-134", "module": "debate", "level": 3,
     "question": "On a small $3k account, you want long-vol exposure into a catalyst. tastytrade-style premium SELLING vs a defined-risk DEBIT structure — what's the account-survival call?",
     "options": ["Naked short strangle for max premium", "Prefer a DEFINED-RISK debit structure (or defined-risk credit spread) — undefined-risk selling can take a multiple of a small account on one bad move",
                 "All-in on one long straddle", "Sell naked puts on margin"],
     "correct_index": 1,
     "why": "tastytrade's edge is real but they run big, diversified accounts that can absorb the tail of UNDEFINED-risk selling. On a $3k account, one naked short strangle gone wrong can blow a hole bigger than the account. The survival rule: keep risk DEFINED (debit spreads, iron condors, or sized long premium with a hard −50% stop) and size each trade ≤2–5% / ≤$250. Right strategy, wrong size = blown account.",
     "tags": ["debate", "risk", "account-size", "defined-risk"],
     "rh_note": "On your $3k Boba book: defined-risk every time. The cap is ~$250/trade — one position should never be able to wreck the account."},

    {"id": "opt-135", "module": "debate", "level": 3,
     "question": "Bottom line across all five educators — what's the ONE question every straddle/strangle decision actually reduces to?",
     "options": ["Is the chart bullish?", "Is the IMPLIED move (what the straddle costs) CHEAP or RICH versus how this stock actually moves — and is there a catalyst to make the move happen?",
                 "What does the news say?", "Is it a meme stock?"],
     "correct_index": 1,
     "why": "Strip away the disagreements and all five agree on the frame: the ATM straddle price IS the expected move; you only buy when that move is underpriced (IV/HV < ~0.85, IVR low, implied < historical, edge_ratio > 1) AND a catalyst will deliver it before theta bites — otherwise you sell it or wait. tastytrade/SMB/Option Alpha lean seller when it's rich; SteadyOptions/Option Alpha lean buyer when it's cheap + catalyzed. The judgment is reading WHICH regime you're in.",
     "tags": ["debate", "core", "synthesis"]},
]


def main() -> int:
    data = json.loads(BANK.read_text())
    meta = data.setdefault("meta", {})
    mods = meta.setdefault("modules", [])
    have_mod = {m["id"] for m in mods}
    added_mods = [m for m in NEW_MODULES if m["id"] not in have_mod]

    have_q = {q["id"] for q in data.get("questions", [])}
    added_q = [q for q in NEW_QUESTIONS if q["id"] not in have_q]

    # sanity: no dup ids inside the new set, every q has a known module
    new_ids = [q["id"] for q in NEW_QUESTIONS]
    assert len(new_ids) == len(set(new_ids)), "duplicate id in NEW_QUESTIONS"
    valid_mods = have_mod | {m["id"] for m in NEW_MODULES}
    for q in NEW_QUESTIONS:
        assert q["module"] in valid_mods, f"{q['id']} → unknown module {q['module']}"
        assert 0 <= q["correct_index"] < len(q["options"]), f"{q['id']} bad correct_index"

    if DRY:
        print(f"[DRY] would add {len(added_mods)} modules: {[m['id'] for m in added_mods]}")
        print(f"[DRY] would add {len(added_q)} questions: {[q['id'] for q in added_q]}")
        print(f"[DRY] bank would total {len(have_q)+len(added_q)} questions")
        return 0

    mods.extend(added_mods)
    data["questions"].extend(added_q)
    meta["version"] = "2.0"
    meta["mastery_note"] = ("v2 adds the advanced tier: Volatility Edge (expected move / IV-HV / "
                            "crush / theta back-loading), Managing the Trade, and How the Pros "
                            "Disagree (5-author judgment). Source: straddle-playbook.md.")
    BANK.write_text(json.dumps(data, ensure_ascii=False, indent=2))
    print(f"[extend-mastery] +{len(added_mods)} modules, +{len(added_q)} questions "
          f"→ {len(data['questions'])} total (v{meta['version']})")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
