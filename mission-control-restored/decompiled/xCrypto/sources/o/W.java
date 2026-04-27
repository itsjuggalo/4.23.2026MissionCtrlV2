package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import z.AbstractC1962a;

/* JADX INFO: loaded from: classes.dex */
public abstract class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f13776a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f13777b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f13778c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f13779d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f13780e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f13781f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f13782g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f13783h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f13784i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f13785j = new int[1];

    public static int a(Context context, int i4) {
        ColorStateList colorStateListD = d(context, i4);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f13777b, colorStateListD.getDefaultColor());
        }
        TypedValue typedValueE = e();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueE, true);
        return c(context, i4, typedValueE.getFloat());
    }

    public static int b(Context context, int i4) {
        int[] iArr = f13785j;
        iArr[0] = i4;
        a0 a0VarQ = a0.q(context, null, iArr);
        try {
            return a0VarQ.b(0, 0);
        } finally {
            a0VarQ.s();
        }
    }

    public static int c(Context context, int i4, float f4) {
        return AbstractC1962a.f(b(context, i4), Math.round(Color.alpha(r0) * f4));
    }

    public static ColorStateList d(Context context, int i4) {
        int[] iArr = f13785j;
        iArr[0] = i4;
        a0 a0VarQ = a0.q(context, null, iArr);
        try {
            return a0VarQ.c(0);
        } finally {
            a0VarQ.s();
        }
    }

    public static TypedValue e() {
        ThreadLocal threadLocal = f13776a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
