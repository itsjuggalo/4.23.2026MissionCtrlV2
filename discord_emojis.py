#!/usr/bin/env python3
"""
discord_emojis.py — generate + upload a branded custom server-emoji set (real color
glyphs via NotoColorEmoji). Actor = ops bot (Administrator → Manage Emojis). Idempotent.
Builds a preview montage at /tmp/mc_emoji_sheet.png.
"""
import sys, time, base64, io
from pathlib import Path
sys.path.insert(0, str(Path.home() / ".openclaw"))
from vault import get_secret
import requests
from PIL import Image, ImageDraw, ImageFont

API = "https://discord.com/api/v10"
G = get_secret("discord_guild_id").strip()
BOT = get_secret("discord_ops_bot_token").strip()
H = {"Authorization": f"Bot {BOT}", "User-Agent": "MC/1.0", "Content-Type": "application/json"}
NOTO = "/usr/share/fonts/truetype/noto/NotoColorEmoji.ttf"

# name → emoji glyph (Discord emoji names: alnum + _)
SET = {
    "whale": "🐋", "flow": "🌊", "fire": "🔥", "rocket": "🚀", "chart": "📈",
    "brief": "📰", "bull": "🐂", "bear": "🐻", "macro": "🌐", "risk": "🛡️",
    "mc_yes": "✅", "mc_no": "❌", "star": "⭐", "alert": "🚨", "money": "💰",
}


def render(glyph) -> Image.Image:
    font = ImageFont.truetype(NOTO, 109)
    img = Image.new("RGBA", (136, 136), (0, 0, 0, 0))
    ImageDraw.Draw(img).text((4, 4), glyph, font=font, embedded_color=True)
    return img.resize((112, 112), Image.LANCZOS)


def main():
    existing = {e["name"] for e in requests.get(f"{API}/guilds/{G}/emojis", headers=H).json()}
    made, imgs = [], {}
    for name, glyph in SET.items():
        im = render(glyph); imgs[name] = im
        if name in existing:
            print(f"  :{name}: exists — skip"); continue
        buf = io.BytesIO(); im.save(buf, "PNG")
        data = "data:image/png;base64," + base64.b64encode(buf.getvalue()).decode()
        r = requests.post(f"{API}/guilds/{G}/emojis", headers=H, json={"name": name, "image": data, "roles": []})
        ok = r.status_code in (200, 201)
        print(f"  :{name}: {'✅ uploaded' if ok else str(r.status_code)+' '+r.text[:80]}")
        made.append(name) if ok else None
        time.sleep(1.0)  # emoji uploads are tightly rate-limited
    # preview montage on dark bg
    cols = 5; rows = (len(imgs) + cols - 1) // cols; cell = 128
    sheet = Image.new("RGBA", (cols * cell, rows * cell), (15, 17, 21, 255))
    d = ImageDraw.Draw(sheet)
    try:
        lbl = ImageFont.truetype("/usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf", 14)
    except Exception:
        lbl = None
    for i, (name, im) in enumerate(imgs.items()):
        x, y = (i % cols) * cell, (i // cols) * cell
        sheet.alpha_composite(im, (x + 8, y + 6))
        if lbl:
            d.text((x + cell/2, y + 116), f":{name}:", font=lbl, fill=(180, 185, 195), anchor="mm")
    out = "/tmp/mc_emoji_sheet.png"; sheet.convert("RGB").save(out)
    print(f"\n{len(made)} new emojis uploaded; preview → {out}")


if __name__ == "__main__":
    main()
