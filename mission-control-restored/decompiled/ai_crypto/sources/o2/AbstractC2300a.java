package o2;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import p0.C2365a;

/* JADX INFO: renamed from: o2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2300a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f20019a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f20020b = new p0.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f20021c = new C2365a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f20022d = new p0.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f20023e = new DecelerateInterpolator();

    public static float a(float f7, float f8, float f9) {
        return f7 + (f9 * (f8 - f7));
    }

    public static float b(float f7, float f8, float f9, float f10, float f11) {
        return f11 < f9 ? f7 : f11 > f10 ? f8 : a(f7, f8, (f11 - f9) / (f10 - f9));
    }

    public static int c(int i7, int i8, float f7) {
        return i7 + Math.round(f7 * (i8 - i7));
    }
}
