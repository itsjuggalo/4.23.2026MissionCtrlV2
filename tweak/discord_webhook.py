"""
Discord Webhook integration for Tweak trading bot.
Posts position opens/closes and daily performance summaries to #tweak-trades.
"""

import requests
import json
from datetime import datetime
from typing import Optional, Dict, Any

# Discord webhook URL for #tweak-trades channel
WEBHOOK_URL = "https://discordapp.com/api/webhooks/1486526936837783764/oY8X-sq1fkpKsGzZzoqHp_tMcvhtvWsQrWqWvMl1HisCPHwh6_9UDNazqkwMr34yZH1u"

def post_position_open(symbol: str, entry_price: float, size_usd: float, target: Optional[float] = None, 
                       stop_loss: Optional[float] = None, strategy: str = "Default", source: str = "Unknown"):
    """Post a new position open to Discord."""
    embed = {
        "title": f"📈 Position Opened: {symbol}",
        "color": 3066993,  # Green
        "fields": [
            {"name": "Entry Price", "value": f"${entry_price:,.2f}", "inline": True},
            {"name": "Size", "value": f"${size_usd:,.2f}", "inline": True},
            {"name": "Strategy", "value": strategy, "inline": True},
            {"name": "Source", "value": source, "inline": True},
        ],
        "timestamp": datetime.utcnow().isoformat(),
        "footer": {"text": "Tweak Trading Bot"}
    }
    
    if target:
        embed["fields"].append({"name": "Target", "value": f"${target:,.2f}", "inline": True})
    if stop_loss:
        embed["fields"].append({"name": "Stop Loss", "value": f"${stop_loss:,.2f}", "inline": True})
    
    _send_webhook({"embeds": [embed]})

def post_position_close(symbol: str, entry_price: float, exit_price: float, quantity: float, 
                        pnl: float, pnl_pct: float, strategy: str = "Default", source: str = "Unknown"):
    """Post a position close with P&L to Discord."""
    color = 3066993 if pnl >= 0 else 15158332  # Green if profit, red if loss
    emoji = "✅" if pnl >= 0 else "❌"
    
    embed = {
        "title": f"{emoji} Position Closed: {symbol}",
        "color": color,
        "fields": [
            {"name": "Entry Price", "value": f"${entry_price:,.2f}", "inline": True},
            {"name": "Exit Price", "value": f"${exit_price:,.2f}", "inline": True},
            {"name": "Quantity", "value": f"{quantity:.8f}", "inline": True},
            {"name": "P&L (USD)", "value": f"${pnl:,.2f}", "inline": True},
            {"name": "P&L (%)", "value": f"{pnl_pct:.2f}%", "inline": True},
            {"name": "Strategy", "value": strategy, "inline": True},
            {"name": "Source", "value": source, "inline": True},
        ],
        "timestamp": datetime.utcnow().isoformat(),
        "footer": {"text": "Tweak Trading Bot"}
    }
    
    _send_webhook({"embeds": [embed]})

def post_daily_summary(stats: Dict[str, Any]):
    """Post daily performance summary to Discord."""
    total_pnl = stats.get("total_pnl_usd", 0)
    win_rate = stats.get("win_rate", 0)
    trades_today = stats.get("total_trades_today", 0)
    active_positions = stats.get("active_positions", 0)
    wallet_balance = stats.get("wallet_balance", 0)
    
    color = 3066993 if total_pnl >= 0 else 15158332
    emoji = "📊" if total_pnl >= 0 else "⚠️"
    
    embed = {
        "title": f"{emoji} Daily Summary - {datetime.now().strftime('%Y-%m-%d')}",
        "color": color,
        "fields": [
            {"name": "Daily P&L", "value": f"${total_pnl:,.2f}", "inline": True},
            {"name": "Trades Today", "value": str(trades_today), "inline": True},
            {"name": "Win Rate", "value": f"{win_rate:.1f}%", "inline": True},
            {"name": "Active Positions", "value": str(active_positions), "inline": True},
            {"name": "Wallet Balance", "value": f"${wallet_balance:,.2f}", "inline": True},
            {"name": "Grid Strategies", "value": str(stats.get("grid_strategies", 0)), "inline": True},
            {"name": "DCA Strategies", "value": str(stats.get("dca_strategies", 0)), "inline": True},
        ],
        "timestamp": datetime.utcnow().isoformat(),
        "footer": {"text": "Tweak Trading Bot - Daily Report"}
    }
    
    _send_webhook({"embeds": [embed]})

def _send_webhook(payload: Dict[str, Any]) -> bool:
    """Send payload to Discord webhook."""
    try:
        response = requests.post(
            WEBHOOK_URL,
            json=payload,
            headers={"Content-Type": "application/json"},
            timeout=10
        )
        
        if response.status_code in [200, 204]:
            print(f"[Discord] Message sent successfully")
            return True
        else:
            print(f"[Discord] Failed to send message: {response.status_code} - {response.text}")
            return False
    except Exception as e:
        print(f"[Discord] Error sending webhook: {str(e)}")
        return False

if __name__ == "__main__":
    # Test webhook connectivity
    print("[Discord] Testing webhook connectivity...")
    test_payload = {
        "embeds": [{
            "title": "✅ Tweak Discord Integration Active",
            "description": "The webhook is working and ready to receive trade updates.",
            "color": 3066993,
            "timestamp": datetime.utcnow().isoformat(),
            "footer": {"text": "Tweak Trading Bot"}
        }]
    }
    
    if _send_webhook(test_payload):
        print("[Discord] ✅ Webhook is active and working!")
    else:
        print("[Discord] ❌ Webhook connection failed - check URL")
