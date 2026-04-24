package Q;

import android.view.ViewGroup;

/* JADX INFO: renamed from: Q.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0680v {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.setMarginEnd(i7);
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i7) {
        marginLayoutParams.setMarginStart(i7);
    }
}
