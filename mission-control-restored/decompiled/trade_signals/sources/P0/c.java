package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f6265b = new c();

    @Override // P0.b
    public Rect a(Activity activity) {
        int i8;
        AbstractC2304t.f(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        t tVar = t.f6276a;
        AbstractC2304t.c(defaultDisplay);
        Point pointA = tVar.a(defaultDisplay);
        Rect rect = new Rect();
        int i9 = pointA.x;
        if (i9 == 0 || (i8 = pointA.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i9;
            rect.bottom = i8;
        }
        return rect;
    }

    @Override // P0.b
    public Rect b(Context context) {
        AbstractC2304t.f(context, "context");
        Object systemService = context.getSystemService("window");
        AbstractC2304t.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        t tVar = t.f6276a;
        AbstractC2304t.c(defaultDisplay);
        Point pointA = tVar.a(defaultDisplay);
        return new Rect(0, 0, pointA.x, pointA.y);
    }
}
