package h0;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f18314b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f18313a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f18315c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f18316d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f18317e = 1.0f;

    public f(j jVar) {
        S.g.e(jVar, "rasterizer cannot be null");
        this.f18314b = jVar;
    }

    public final j a() {
        return this.f18314b;
    }

    public final int b() {
        return this.f18315c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i8, int i9, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f18313a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f18313a;
        this.f18317e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f18314b.e();
        this.f18316d = (short) (this.f18314b.e() * this.f18317e);
        short sI = (short) (this.f18314b.i() * this.f18317e);
        this.f18315c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f18313a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
