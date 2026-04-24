package h0;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f14699b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f14698a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f14700c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f14701d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f14702e = 1.0f;

    public f(e eVar) {
        P.f.h(eVar, "metadata cannot be null");
        this.f14699b = eVar;
    }

    public final e a() {
        return this.f14699b;
    }

    public final int b() {
        return this.f14700c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i7, int i8, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f14698a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f14698a;
        this.f14702e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f14699b.e();
        this.f14701d = (short) (this.f14699b.e() * this.f14702e);
        short sI = (short) (this.f14699b.i() * this.f14702e);
        this.f14700c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f14698a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
