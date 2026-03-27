package D;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: D.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0020u {
    public static V a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        V vC = V.c(rootWindowInsets, null);
        U u6 = vC.f219a;
        u6.l(vC);
        u6.d(view.getRootView());
        return vC;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i) {
        view.setScrollIndicators(i);
    }

    public static void d(View view, int i, int i6) {
        view.setScrollIndicators(i, i6);
    }
}
