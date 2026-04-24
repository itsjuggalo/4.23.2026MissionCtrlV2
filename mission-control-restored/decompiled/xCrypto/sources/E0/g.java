package E0;

import H.L;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f378a = new g();

    public final Rect a(Context context) {
        r.f(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        r.e(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final L b(Context context) {
        r.f(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        r.e(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        L lN = L.n(windowInsets);
        r.e(lN, "toWindowInsetsCompat(platformInsets)");
        return lN;
    }

    public final A0.k c(Context context) {
        r.f(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        L lN = L.n(windowManager.getCurrentWindowMetrics().getWindowInsets());
        r.e(lN, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        r.e(bounds, "wm.currentWindowMetrics.bounds");
        return new A0.k(bounds, lN);
    }

    public final Rect d(Context context) {
        r.f(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        r.e(bounds, "wm.maximumWindowMetrics.bounds");
        return bounds;
    }
}
