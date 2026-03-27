package P0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6266b = new d();

    @Override // P0.b
    public Rect a(Activity activity) {
        AbstractC2304t.f(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!a.f6261a.a(activity)) {
            t tVar = t.f6276a;
            AbstractC2304t.c(defaultDisplay);
            Point pointA = tVar.a(defaultDisplay);
            int iE = j.e(activity);
            int i8 = rect.bottom;
            if (i8 + iE == pointA.y) {
                rect.bottom = i8 + iE;
            } else {
                int i9 = rect.right;
                if (i9 + iE == pointA.x) {
                    rect.right = i9 + iE;
                }
            }
        }
        return rect;
    }

    @Override // P0.b
    public Rect b(Context context) {
        AbstractC2304t.f(context, "context");
        return c.f6265b.b(context);
    }
}
