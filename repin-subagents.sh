#!/usr/bin/env bash
# Re-pin all Claude Code subagents to a single model.
# Idempotent: replaces existing model: lines, inserts one where missing.
# Skips files without YAML frontmatter (plugin-private subagents loaded raw).
#
# Usage:
#   ~/scripts/repin-subagents.sh                       # default model below
#   ~/scripts/repin-subagents.sh claude-haiku-4-5      # override
#   ~/scripts/repin-subagents.sh --dry-run             # show what would change
#   ~/scripts/repin-subagents.sh --unpin               # remove model: lines (revert to inherit)

set -euo pipefail

MODEL="${1:-claude-3-5-sonnet-20241022}"
DRY_RUN=0
UNPIN=0

case "${1:-}" in
  --dry-run) DRY_RUN=1; MODEL="${2:-claude-3-5-sonnet-20241022}" ;;
  --unpin)   UNPIN=1 ;;
  -h|--help)
    sed -n '2,12p' "$0"; exit 0 ;;
esac

scan_paths=(
  "$HOME/.claude/agents"
  "$HOME/.claude/plugins/marketplaces"
  "$HOME/.claude/plugins/cache"
)

updated=0; added=0; skipped=0; unpinned=0

while IFS= read -r f; do
  # require YAML frontmatter
  if ! head -1 "$f" | grep -q '^---$'; then
    skipped=$((skipped+1))
    [[ $DRY_RUN -eq 1 ]] && echo "SKIP (no frontmatter): $f"
    continue
  fi

  if [[ $UNPIN -eq 1 ]]; then
    if grep -q '^model:' "$f"; then
      [[ $DRY_RUN -eq 0 ]] && sed -i '/^model:/d' "$f"
      unpinned=$((unpinned+1))
      echo "UNPIN:   $f"
    fi
    continue
  fi

  if grep -q "^model: ${MODEL}$" "$f"; then
    continue  # already correct
  elif grep -q '^model:' "$f"; then
    [[ $DRY_RUN -eq 0 ]] && sed -i "s|^model:.*|model: ${MODEL}|" "$f"
    updated=$((updated+1))
    echo "UPDATE:  $f"
  else
    if [[ $DRY_RUN -eq 0 ]]; then
      if grep -q '^description:' "$f"; then
        sed -i "/^description:/a model: ${MODEL}" "$f"
      else
        sed -i "/^name:/a model: ${MODEL}" "$f"
      fi
    fi
    added=$((added+1))
    echo "ADD:     $f"
  fi
done < <(find "${scan_paths[@]}" -name "*.md" -path "*/agents/*" 2>/dev/null)

echo
if [[ $UNPIN -eq 1 ]]; then
  echo "Unpinned: $unpinned  Skipped: $skipped"
else
  echo "Model:    $MODEL"
  echo "Updated:  $updated   Added: $added   Skipped: $skipped"
fi
[[ $DRY_RUN -eq 1 ]] && echo "(dry run — no files written)"
