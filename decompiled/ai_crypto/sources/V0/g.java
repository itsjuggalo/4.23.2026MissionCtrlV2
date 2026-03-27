package V0;

import Q.W;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f5247a = new g();

    public final Rect a(Context context) {
        r.f(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        r.e(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final W b(Context context) {
        r.f(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        r.e(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        W wT = W.t(windowInsets);
        r.e(wT, "toWindowInsetsCompat(platformInsets)");
        return wT;
    }

    public final R0.k c(Context context) {
        r.f(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        W wT = W.t(windowManager.getCurrentWindowMetrics().getWindowInsets());
        r.e(wT, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        r.e(bounds, "wm.currentWindowMetrics.bounds");
        return new R0.k(bounds, wT);
    }

    public final Rect d(Context context) {
        r.f(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        r.e(bounds, "wm.maximumWindowMetrics.bounds");
        return bounds;
    }
}
