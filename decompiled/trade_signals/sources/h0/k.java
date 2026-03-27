package h0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: classes.dex */
public final class k extends f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Paint f18330g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextPaint f18331f;

    public k(j jVar) {
        super(jVar);
    }

    public static Paint e() {
        if (f18330g == null) {
            TextPaint textPaint = new TextPaint();
            f18330g = textPaint;
            textPaint.setColor(androidx.emoji2.text.c.c().d());
            f18330g.setStyle(Paint.Style.FILL);
        }
        return f18330g;
    }

    public final TextPaint c(CharSequence charSequence, int i8, int i9, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i8, i9, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.f18331f;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.f18331f = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    public void d(Canvas canvas, TextPaint textPaint, float f8, float f9, float f10, float f11) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f8, f10, f9, f11, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i8, int i9, float f8, int i10, int i11, int i12, Paint paint) {
        Paint paint2 = paint;
        TextPaint textPaintC = c(charSequence, i8, i9, paint2);
        if (textPaintC != null && textPaintC.bgColor != 0) {
            d(canvas, textPaintC, f8, f8 + b(), i10, i12);
        }
        if (androidx.emoji2.text.c.c().j()) {
            canvas.drawRect(f8, i10, f8 + b(), i12, e());
        }
        j jVarA = a();
        float f9 = i11;
        if (textPaintC != null) {
            paint2 = textPaintC;
        }
        jVarA.a(canvas, f8, f9, paint2);
    }
}
