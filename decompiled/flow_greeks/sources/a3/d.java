package a3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f51b = new d();

    @Override // a3.b
    public Rect a(Activity activity) {
        kotlin.jvm.internal.t.f(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!a.f46a.a(activity)) {
            p pVar = p.f61a;
            kotlin.jvm.internal.t.c(defaultDisplay);
            Point pointA = pVar.a(defaultDisplay);
            int iE = j.e(activity);
            int i10 = rect.bottom;
            if (i10 + iE == pointA.y) {
                rect.bottom = i10 + iE;
                return rect;
            }
            int i11 = rect.right;
            if (i11 + iE == pointA.x) {
                rect.right = i11 + iE;
            }
        }
        return rect;
    }

    @Override // a3.b
    public Rect b(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        return c.f50b.b(context);
    }
}
