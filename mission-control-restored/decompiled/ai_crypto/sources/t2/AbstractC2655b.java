package t2;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import z2.AbstractC2880b;

/* JADX INFO: renamed from: t2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2655b {
    public static int a(int i7, int i8) {
        return I.a.j(i7, (Color.alpha(i7) * i8) / 255);
    }

    public static int b(Context context, int i7, int i8) {
        TypedValue typedValueA = AbstractC2880b.a(context, i7);
        return typedValueA != null ? j(context, typedValueA) : i8;
    }

    public static int c(Context context, int i7, String str) {
        return j(context, AbstractC2880b.d(context, i7, str));
    }

    public static int d(View view, int i7) {
        return j(view.getContext(), AbstractC2880b.e(view, i7));
    }

    public static int e(View view, int i7, int i8) {
        return b(view.getContext(), i7, i8);
    }

    public static boolean f(int i7) {
        return i7 != 0 && I.a.c(i7) > 0.5d;
    }

    public static int g(int i7, int i8) {
        return I.a.f(i8, i7);
    }

    public static int h(int i7, int i8, float f7) {
        return g(i7, I.a.j(i8, Math.round(Color.alpha(i8) * f7)));
    }

    public static int i(View view, int i7, int i8, float f7) {
        return h(d(view, i7), d(view, i8), f7);
    }

    public static int j(Context context, TypedValue typedValue) {
        int i7 = typedValue.resourceId;
        return i7 != 0 ? G.a.getColor(context, i7) : typedValue.data;
    }
}
