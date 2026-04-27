#!/usr/bin/env python3
"""
Helper script to post trades to Discord.
Usage:
  python3 post_trade_to_discord.py open --symbol BTC/USDT --entry 67000 --size 200 --target 70000 --stop 65000
  python3 post_trade_to_discord.py close --symbol BTC/USDT --entry 67000 --exit 68000 --qty 0.003 --pnl 200 --pnl-pct 5.5
  python3 post_trade_to_discord.py daily --stats positions.json
"""

import argparse
import json
from discord_webhook import post_position_open, post_position_close, post_daily_summary

def main():
    parser = argparse.ArgumentParser(description="Post trades to Discord #tweak-trades channel")
    subparsers = parser.add_subparsers(dest="action", help="Action to perform")
    
    # Position open
    open_parser = subparsers.add_parser("open", help="Post position open")
    open_parser.add_argument("--symbol", required=True, help="Symbol (e.g., BTC/USDT)")
    open_parser.add_argument("--entry", type=float, required=True, help="Entry price")
    open_parser.add_argument("--size", type=float, required=True, help="Position size in USD")
    open_parser.add_argument("--target", type=float, help="Target price")
    open_parser.add_argument("--stop", type=float, help="Stop loss price")
    open_parser.add_argument("--strategy", default="Grid/DCA", help="Strategy name")
    open_parser.add_argument("--source", default="Tweak Bot", help="Signal source")
    
    # Position close
    close_parser = subparsers.add_parser("close", help="Post position close")
    close_parser.add_argument("--symbol", required=True, help="Symbol (e.g., BTC/USDT)")
    close_parser.add_argument("--entry", type=float, required=True, help="Entry price")
    close_parser.add_argument("--exit", type=float, required=True, help="Exit price")
    close_parser.add_argument("--qty", type=float, required=True, help="Quantity closed")
    close_parser.add_argument("--pnl", type=float, required=True, help="P&L in USD")
    close_parser.add_argument("--pnl-pct", type=float, required=True, help="P&L in percent")
    close_parser.add_argument("--strategy", default="Grid/DCA", help="Strategy name")
    close_parser.add_argument("--source", default="Tweak Bot", help="Signal source")
    
    # Daily summary
    summary_parser = subparsers.add_parser("daily", help="Post daily summary")
    summary_parser.add_argument("--stats", required=True, help="JSON file with stats")
    
    args = parser.parse_args()
    
    if args.action == "open":
        post_position_open(
            symbol=args.symbol,
            entry_price=args.entry,
            size_usd=args.size,
            target=args.target,
            stop_loss=args.stop,
            strategy=args.strategy,
            source=args.source
        )
        print(f"✅ Posted position open for {args.symbol}")
    
    elif args.action == "close":
        post_position_close(
            symbol=args.symbol,
            entry_price=args.entry,
            exit_price=args.exit,
            quantity=args.qty,
            pnl=args.pnl,
            pnl_pct=args.pnl_pct,
            strategy=args.strategy,
            source=args.source
        )
        print(f"✅ Posted position close for {args.symbol}")
    
    elif args.action == "daily":
        with open(args.stats, 'r') as f:
            stats = json.load(f)
        post_daily_summary(stats)
        print("✅ Posted daily summary")
    
    else:
        parser.print_help()

if __name__ == "__main__":
    main()
