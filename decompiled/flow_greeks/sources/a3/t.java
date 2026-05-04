package a3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f66b = new t();

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
        Context contextA = k.f55a.a(context);
        if (contextA instanceof Activity) {
            return c((Activity) contextA, densityCompatHelper);
        }
        if (!(contextA instanceof InputMethodService) && !(contextA instanceof Application)) {
            throw new IllegalArgumentException("Must provide a UiContext or Application Context");
        }
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.t.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        p pVar = p.f61a;
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        kotlin.jvm.internal.t.e(defaultDisplay, "getDefaultDisplay(...)");
        Point pointA = pVar.a(defaultDisplay);
        return new w2.t(new Rect(0, 0, pointA.x, pointA.y), densityCompatHelper.a(context));
    }

    @Override // a3.q
    public w2.t c(Activity activity, l densityCompatHelper) {
        kotlin.jvm.internal.t.f(activity, "activity");
        kotlin.jvm.internal.t.f(densityCompatHelper, "densityCompatHelper");
        return new w2.t(new t2.b(b.f47a.a().a(activity)), densityCompatHelper.a(activity));
    }
}
