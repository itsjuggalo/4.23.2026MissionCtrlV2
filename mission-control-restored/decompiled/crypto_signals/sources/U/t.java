package U;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import e3.w;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class t extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f3097b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f3096a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3098c = 1.0f;

    public t(m mVar) {
        F1.h.f(mVar, "metadata cannot be null");
        this.f3097b = mVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i6, float f6, int i7, int i8, int i9, Paint paint) {
        j.a().getClass();
        m mVar = this.f3097b;
        w wVar = mVar.f3072b;
        Typeface typeface = (Typeface) wVar.e;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) wVar.f6192c, mVar.f3071a * 2, 2, f6, i8, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i6, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f3096a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        m mVar = this.f3097b;
        this.f3098c = fAbs / (mVar.b().a(14) != 0 ? ((ByteBuffer) r8.f254d).getShort(r1 + r8.f251a) : (short) 0);
        V.a aVarB = mVar.b();
        int iA = aVarB.a(14);
        if (iA != 0) {
            ((ByteBuffer) aVarB.f254d).getShort(iA + aVarB.f251a);
        }
        short s6 = (short) ((mVar.b().a(12) != 0 ? ((ByteBuffer) r5.f254d).getShort(r7 + r5.f251a) : (short) 0) * this.f3098c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s6;
    }
}
