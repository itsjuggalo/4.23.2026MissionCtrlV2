package a3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f50b = new c();

    @Override // a3.b
    public Rect a(Activity activity) {
        int i10;
        kotlin.jvm.internal.t.f(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        p pVar = p.f61a;
        kotlin.jvm.internal.t.c(defaultDisplay);
        Point pointA = pVar.a(defaultDisplay);
        Rect rect = new Rect();
        int i11 = pointA.x;
        if (i11 == 0 || (i10 = pointA.y) == 0) {
            defaultDisplay.getRectSize(rect);
            return rect;
        }
        rect.right = i11;
        rect.bottom = i10;
        return rect;
    }

    @Override // a3.b
    public Rect b(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.t.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        p pVar = p.f61a;
        kotlin.jvm.internal.t.c(defaultDisplay);
        Point pointA = pVar.a(defaultDisplay);
        return new Rect(0, 0, pointA.x, pointA.y);
    }
}
