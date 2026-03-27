package h0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class j extends f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Paint f14711f;

    public j(e eVar) {
        super(eVar);
    }

    public static Paint c() {
        if (f14711f == null) {
            TextPaint textPaint = new TextPaint();
            f14711f = textPaint;
            textPaint.setColor(androidx.emoji2.text.c.b().c());
            f14711f.setStyle(Paint.Style.FILL);
        }
        return f14711f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i7, int i8, float f7, int i9, int i10, int i11, Paint paint) {
        if (androidx.emoji2.text.c.b().i()) {
            canvas.drawRect(f7, i9, f7 + b(), i11, c());
        }
        a().a(canvas, f7, i10, paint);
    }
}
