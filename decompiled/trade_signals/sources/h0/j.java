package h0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import i0.C1907a;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f18326d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.f f18328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f18329c = 0;

    public j(androidx.emoji2.text.f fVar, int i8) {
        this.f18328b = fVar;
        this.f18327a = i8;
    }

    public void a(Canvas canvas, float f8, float f9, Paint paint) {
        Typeface typefaceG = this.f18328b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f18328b.c(), this.f18327a * 2, 2, f8, f9, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i8) {
        return g().h(i8);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f18329c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final C1907a g() {
        ThreadLocal threadLocal = f18326d;
        C1907a c1907a = (C1907a) threadLocal.get();
        if (c1907a == null) {
            c1907a = new C1907a();
            threadLocal.set(c1907a);
        }
        this.f18328b.d().j(c1907a, this.f18327a);
        return c1907a;
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        return (this.f18329c & 4) > 0;
    }

    public void l(boolean z7) {
        int iD = d();
        if (z7) {
            this.f18329c = iD | 4;
        } else {
            this.f18329c = iD;
        }
    }

    public void m(boolean z7) {
        int i8 = this.f18329c & 4;
        this.f18329c = z7 ? i8 | 2 : i8 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i8 = 0; i8 < iC; i8++) {
            sb.append(Integer.toHexString(b(i8)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
