package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f6269b = new g();

    @Override // P0.b
    public Rect a(Activity activity) {
        AbstractC2304t.f(activity, "activity");
        Rect bounds = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        AbstractC2304t.e(bounds, "getBounds(...)");
        return bounds;
    }

    @Override // P0.b
    public Rect b(Context context) {
        AbstractC2304t.f(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        AbstractC2304t.e(bounds, "getBounds(...)");
        return bounds;
    }
}
