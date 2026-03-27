package w2;

import android.content.Context;
import android.graphics.Color;
import n2.AbstractC2252a;
import t2.AbstractC2655b;
import z2.AbstractC2880b;

/* JADX INFO: renamed from: w2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2774a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24941f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f24942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f24946e;

    public C2774a(Context context) {
        this(AbstractC2880b.b(context, AbstractC2252a.f19108l, false), AbstractC2655b.b(context, AbstractC2252a.f19107k, 0), AbstractC2655b.b(context, AbstractC2252a.f19106j, 0), AbstractC2655b.b(context, AbstractC2252a.f19103g, 0), context.getResources().getDisplayMetrics().density);
    }

    public float a(float f7) {
        if (this.f24946e <= 0.0f || f7 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f7 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i7, float f7) {
        int i8;
        float fA = a(f7);
        int iAlpha = Color.alpha(i7);
        int iH = AbstractC2655b.h(I.a.j(i7, 255), this.f24943b, fA);
        if (fA > 0.0f && (i8 = this.f24944c) != 0) {
            iH = AbstractC2655b.g(iH, I.a.j(i8, f24941f));
        }
        return I.a.j(iH, iAlpha);
    }

    public int c(int i7, float f7) {
        return (this.f24942a && e(i7)) ? b(i7, f7) : i7;
    }

    public boolean d() {
        return this.f24942a;
    }

    public final boolean e(int i7) {
        return I.a.j(i7, 255) == this.f24945d;
    }

    public C2774a(boolean z7, int i7, int i8, int i9, float f7) {
        this.f24942a = z7;
        this.f24943b = i7;
        this.f24944c = i8;
        this.f24945d = i9;
        this.f24946e = f7;
    }
}
