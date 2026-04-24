package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class v implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f6279b = new v();

    @Override // P0.u
    public L0.k a(Context context, l densityCompatHelper) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(densityCompatHelper, "densityCompatHelper");
        return new L0.k(new I0.b(b.f6262a.a().b(context)), densityCompatHelper.a(context));
    }

    @Override // P0.u
    public L0.k b(Activity activity, l densityCompatHelper) {
        AbstractC2304t.f(activity, "activity");
        AbstractC2304t.f(densityCompatHelper, "densityCompatHelper");
        return new L0.k(new I0.b(b.f6262a.a().a(activity)), densityCompatHelper.a(activity));
    }

    @Override // P0.u
    public L0.k c(Context context, l densityCompatHelper) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(densityCompatHelper, "densityCompatHelper");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        float f8 = context.getResources().getDisplayMetrics().density;
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        AbstractC2304t.e(bounds, "getBounds(...)");
        return new L0.k(bounds, f8);
    }
}
