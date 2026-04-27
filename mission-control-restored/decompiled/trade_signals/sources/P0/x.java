package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.view.Display;
import android.view.WindowManager;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class x implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f6281b = new x();

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
        Context contextA = k.f6270a.a(context);
        if (contextA instanceof Activity) {
            return b((Activity) contextA, densityCompatHelper);
        }
        if (!(contextA instanceof InputMethodService)) {
            throw new IllegalArgumentException(context + " is not a UiContext");
        }
        Object systemService = context.getSystemService("window");
        AbstractC2304t.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        t tVar = t.f6276a;
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        AbstractC2304t.e(defaultDisplay, "getDefaultDisplay(...)");
        Point pointA = tVar.a(defaultDisplay);
        return new L0.k(new Rect(0, 0, pointA.x, pointA.y), densityCompatHelper.a(context));
    }
}
