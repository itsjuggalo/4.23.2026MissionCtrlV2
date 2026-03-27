package y2;

import Q.V;
import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import t2.AbstractC2655b;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static void a(Window window, boolean z7, Integer num, Integer num2) {
        boolean z8 = num == null || num.intValue() == 0;
        boolean z9 = num2 == null || num2.intValue() == 0;
        if (z8 || z9) {
            int iB = AbstractC2655b.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z8) {
                num = Integer.valueOf(iB);
            }
            if (z9) {
                num2 = Integer.valueOf(iB);
            }
        }
        V.b(window, !z7);
        int iC = c(window.getContext(), z7);
        int iB2 = b(window.getContext(), z7);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, AbstractC2655b.f(num.intValue())));
        e(window, d(iB2, AbstractC2655b.f(num2.intValue())));
    }

    public static int b(Context context, boolean z7) {
        if (z7 && Build.VERSION.SDK_INT < 27) {
            return I.a.j(AbstractC2655b.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z7) {
            return 0;
        }
        return AbstractC2655b.b(context, R.attr.navigationBarColor, -16777216);
    }

    public static int c(Context context, boolean z7) {
        if (z7) {
            return 0;
        }
        return AbstractC2655b.b(context, R.attr.statusBarColor, -16777216);
    }

    public static boolean d(int i7, boolean z7) {
        return AbstractC2655b.f(i7) || (i7 == 0 && z7);
    }

    public static void e(Window window, boolean z7) {
        V.a(window, window.getDecorView()).a(z7);
    }

    public static void f(Window window, boolean z7) {
        V.a(window, window.getDecorView()).b(z7);
    }
}
