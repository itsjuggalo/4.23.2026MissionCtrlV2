package a3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f54b = new g();

    @Override // a3.b
    public Rect a(Activity activity) {
        kotlin.jvm.internal.t.f(activity, "activity");
        Rect bounds = ((WindowManager) activity.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        kotlin.jvm.internal.t.e(bounds, "getBounds(...)");
        return bounds;
    }

    @Override // a3.b
    public Rect b(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        Rect bounds = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        kotlin.jvm.internal.t.e(bounds, "getBounds(...)");
        return bounds;
    }
}
