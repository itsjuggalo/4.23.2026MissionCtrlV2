package a3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f64b = new r();

    @Override // a3.q
    public w2.t a(Context context, l densityCompatHelper) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(densityCompatHelper, "densityCompatHelper");
        return new w2.t(new t2.b(b.f47a.a().b(context)), densityCompatHelper.a(context));
    }

    @Override // a3.q
    public w2.t b(Context context, l densityCompatHelper) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(densityCompatHelper, "densityCompatHelper");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        float f10 = context.getResources().getDisplayMetrics().density;
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        kotlin.jvm.internal.t.e(bounds, "getBounds(...)");
        return new w2.t(bounds, f10);
    }

    @Override // a3.q
    public w2.t c(Activity activity, l densityCompatHelper) {
        kotlin.jvm.internal.t.f(activity, "activity");
        kotlin.jvm.internal.t.f(densityCompatHelper, "densityCompatHelper");
        return new w2.t(new t2.b(b.f47a.a().a(activity)), densityCompatHelper.a(activity));
    }
}
