package D;

import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    public static int a(ViewConfiguration viewConfiguration, int i, int i6, int i7) {
        return viewConfiguration.getScaledMaximumFlingVelocity(i, i6, i7);
    }

    public static int b(ViewConfiguration viewConfiguration, int i, int i6, int i7) {
        return viewConfiguration.getScaledMinimumFlingVelocity(i, i6, i7);
    }
}
