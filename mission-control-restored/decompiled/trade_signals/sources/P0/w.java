package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class w implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f6280b = new w();

    @Override // P0.u
    public L0.k a(Context context, l densityCompatHelper) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(densityCompatHelper, "densityCompatHelper");
        return v.f6279b.a(context, densityCompatHelper);
    }

    @Override // P0.u
    public L0.k b(Activity activity, l densityCompatHelper) {
        AbstractC2304t.f(activity, "activity");
        AbstractC2304t.f(densityCompatHelper, "densityCompatHelper");
        return v.f6279b.b(activity, densityCompatHelper);
    }

    @Override // P0.u
    public L0.k c(Context context, l densityCompatHelper) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(densityCompatHelper, "densityCompatHelper");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        AbstractC2304t.e(bounds, "getBounds(...)");
        return new L0.k(bounds, windowManager.getCurrentWindowMetrics().getDensity());
    }
}
