package h0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import i0.C1735a;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f14694d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.emoji2.text.f f14696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f14697c = 0;

    public e(androidx.emoji2.text.f fVar, int i7) {
        this.f14696b = fVar;
        this.f14695a = i7;
    }

    public void a(Canvas canvas, float f7, float f8, Paint paint) {
        Typeface typefaceG = this.f14696b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f14696b.c(), this.f14695a * 2, 2, f7, f8, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i7) {
        return g().h(i7);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f14697c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public final C1735a g() {
        ThreadLocal threadLocal = f14694d;
        C1735a c1735a = (C1735a) threadLocal.get();
        if (c1735a == null) {
            c1735a = new C1735a();
            threadLocal.set(c1735a);
        }
        this.f14696b.d().j(c1735a, this.f14695a);
        return c1735a;
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public void k(boolean z7) {
        this.f14697c = z7 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i7 = 0; i7 < iC; i7++) {
            sb.append(Integer.toHexString(b(i7)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
