package p;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import h.AbstractC1664i;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f21283a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f21284b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f21285c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f21286d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f21287e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f21288f = {R.attr.state_checked};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f21289g = {R.attr.state_selected};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f21290h = {-16842919, -16842908};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f21291i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f21292j = new int[1];

    public static void a(View view, Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1664i.f14627k0);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14631l0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i7) {
        ColorStateList colorStateListE = e(context, i7);
        if (colorStateListE != null && colorStateListE.isStateful()) {
            return colorStateListE.getColorForState(f21284b, colorStateListE.getDefaultColor());
        }
        TypedValue typedValueF = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueF, true);
        return d(context, i7, typedValueF.getFloat());
    }

    public static int c(Context context, int i7) {
        int[] iArr = f21292j;
        iArr[0] = i7;
        S s7 = S.s(context, null, iArr);
        try {
            return s7.b(0, 0);
        } finally {
            s7.u();
        }
    }

    public static int d(Context context, int i7, float f7) {
        return I.a.j(c(context, i7), Math.round(Color.alpha(r0) * f7));
    }

    public static ColorStateList e(Context context, int i7) {
        int[] iArr = f21292j;
        iArr[0] = i7;
        S s7 = S.s(context, null, iArr);
        try {
            return s7.c(0);
        } finally {
            s7.u();
        }
    }

    public static TypedValue f() {
        ThreadLocal threadLocal = f21283a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
