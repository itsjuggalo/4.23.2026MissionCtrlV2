#!/usr/bin/env python3
"""
Execution Specialist - Trade Executor
Citadel DNA: Precise execution, scale-in/out, staleness monitoring

FIXED: Now properly logs completed trades to executions.json
"""

import json
import time
from datetime import datetime
from pathlib import Path

# Paths
PENDING_ORDERS_FILE = Path(__file__).parent / "pending_orders.json"
EXECUTIONS_FILE = Path(__file__).parent / "executions.json"

def load_json(filepath, default=None):
    """Load JSON file, return default if not found"""
    if default is None:
        default = []
    try:
        if filepath.exists():
            with open(filepath, 'r') as f:
                return json.load(f)
        return default
    except Exception as e:
        print(f"Error loading {filepath}: {e}")
        return default

def save_json(filepath, data):
    """Save data to JSON file"""
    try:
        with open(filepath, 'w') as f:
            json.dump(data, f, indent=2)
        return True
    except Exception as e:
        print(f"Error saving {filepath}: {e}")
        return False

def move_to_executions(order):
    """Move completed order from pending to executions"""
    try:
        # Load current executions
        executions = load_json(EXECUTIONS_FILE, default=[])
        
        # Add execution timestamp
        order['execution_timestamp'] = datetime.utcnow().isoformat()
        
        # Append to executions
        executions.append(order)
        
        # Save executions
        if save_json(EXECUTIONS_FILE, executions):
            print(f"✅ Order {order.get('order_id', 'unknown')} logged to executions.json")
            return True
        else:
            print(f"❌ Failed to save execution for order {order.get('order_id', 'unknown')}")
            return False
            
    except Exception as e:
        print(f"Error moving order to executions: {e}")
        return False

def check_order_status(order):
    """
    Check if order should be moved to executions
    
    Returns: ('status', reason) where status is:
    - 'pending': Still active
    - 'filled': Successfully filled
    - 'expired': Expired due to staleness
    - 'cancelled': Manually cancelled
    """
    
    # Check if order is stale (example: older than 5 minutes)
    created_at = datetime.fromisoformat(order.get('created_at', datetime.utcnow().isoformat()))
    age_seconds = (datetime.utcnow() - created_at).total_seconds()
    staleness_threshold = order.get('staleness_threshold_seconds', 300)  # 5 min default
    
    if age_seconds > staleness_threshold:
        return ('expired', f'Stale order (age: {int(age_seconds)}s, threshold: {staleness_threshold}s)')
    
    # Check manual status (if set by external process)
    status = order.get('status', 'pending')
    if status == 'filled':
        return ('filled', 'Order filled')
    elif status == 'cancelled':
        return ('cancelled', 'Order cancelled')
    
    # Still pending
    return ('pending', 'Active')

def process_pending_orders():
    """Main executor loop - check pending orders and move completed ones"""
    
    print(f"\n⚙️  Executor checking pending orders at {datetime.utcnow().isoformat()}")
    
    # Load pending orders
    pending_orders = load_json(PENDING_ORDERS_FILE, default=[])
    
    if not pending_orders:
        print("   No pending orders")
        return
    
    print(f"   Found {len(pending_orders)} pending orders")
    
    # Track orders to keep vs move
    still_pending = []
    completed_count = 0
    
    for order in pending_orders:
        order_id = order.get('order_id', 'unknown')
        symbol = order.get('symbol', 'unknown')
        
        # Check order status
        status, reason = check_order_status(order)
        
        if status == 'pending':
            # Keep in pending
            still_pending.append(order)
            print(f"   📊 {order_id} ({symbol}): {reason}")
        else:
            # Move to executions
            order['final_status'] = status
            order['completion_reason'] = reason
            
            if move_to_executions(order):
                completed_count += 1
                print(f"   ✅ {order_id} ({symbol}): {status.upper()} - {reason}")
            else:
                # If move failed, keep in pending to retry next time
                still_pending.append(order)
                print(f"   ⚠️  {order_id} ({symbol}): Failed to move to executions, keeping in pending")
    
    # Save updated pending orders
    if save_json(PENDING_ORDERS_FILE, still_pending):
        print(f"\n   Updated pending_orders.json: {len(still_pending)} remaining ({completed_count} moved to executions)")
    else:
        print(f"\n   ❌ Failed to update pending_orders.json")

def main():
    """Main execution loop"""
    
    print("="*60)
    print("EXECUTION SPECIALIST - Trade Executor")
    print("Citadel DNA: Precise execution with logging")
    print("="*60)
    
    # Ensure executions.json exists
    if not EXECUTIONS_FILE.exists():
        print(f"Creating {EXECUTIONS_FILE}")
        save_json(EXECUTIONS_FILE, [])
    
    # Run continuously
    while True:
        try:
            process_pending_orders()
            
            # Check every 30 seconds
            time.sleep(30)
            
        except KeyboardInterrupt:
            print("\n\n👋 Executor shutting down gracefully")
            break
        except Exception as e:
            print(f"\n❌ Error in executor loop: {e}")
            time.sleep(30)

if __name__ == "__main__":
    main()
