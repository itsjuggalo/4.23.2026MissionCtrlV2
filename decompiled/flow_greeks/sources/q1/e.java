package q1;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f18759b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f18758a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short f18760c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short f18761d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f18762e = 1.0f;

    public e(i iVar) {
        s0.f.e(iVar, "rasterizer cannot be null");
        this.f18759b = iVar;
    }

    public final i a() {
        return this.f18759b;
    }

    public final int b() {
        return this.f18760c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f18758a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f18758a;
        this.f18762e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f18759b.e();
        this.f18761d = (short) (this.f18759b.e() * this.f18762e);
        short sI = (short) (this.f18759b.i() * this.f18762e);
        this.f18760c = sI;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f18758a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sI;
    }
}
