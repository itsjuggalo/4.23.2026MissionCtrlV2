"""Every ~/scripts test runs with Telegram sends rendered not sent (TG_DRY_RUN=1) and a throwaway missing-data state
dir, so a test can never post a real ops alert or touch the real Data Health state (2026-10-23: one leaked)."""
import os
import tempfile

os.environ["TG_DRY_RUN"] = "1"
os.environ["MC_MISSING_DATA_DIR"] = tempfile.mkdtemp(prefix="mc-missing-data-test-")
