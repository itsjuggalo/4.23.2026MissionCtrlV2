package a3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f52b = new e();

    @Override // a3.b
    public Rect a(Activity activity) throws Exception {
        kotlin.jvm.internal.t.f(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (a.f46a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                kotlin.jvm.internal.t.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                kotlin.jvm.internal.t.d(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (Exception e10) {
            if (!(e10 instanceof NoSuchFieldException) && !(e10 instanceof NoSuchMethodException) && !(e10 instanceof IllegalAccessException) && !(e10 instanceof InvocationTargetException)) {
                throw e10;
            }
            Log.w(b.f47a.b(), e10);
            j.f(activity, rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        a aVar = a.f46a;
        if (!aVar.a(activity)) {
            int iE = j.e(activity);
            int i10 = rect.bottom;
            if (i10 + iE == point.y) {
                rect.bottom = i10 + iE;
            } else {
                int i11 = rect.right;
                if (i11 + iE == point.x) {
                    rect.right = i11 + iE;
                } else if (rect.left == iE) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !aVar.a(activity)) {
            kotlin.jvm.internal.t.c(defaultDisplay);
            DisplayCutout displayCutoutD = j.d(defaultDisplay);
            if (displayCutoutD != null) {
                int i12 = rect.left;
                o oVar = o.f60a;
                if (i12 == oVar.b(displayCutoutD)) {
                    rect.left = 0;
                }
                if (point.x - rect.right == oVar.c(displayCutoutD)) {
                    rect.right += oVar.c(displayCutoutD);
                }
                if (rect.top == oVar.d(displayCutoutD)) {
                    rect.top = 0;
                }
                if (point.y - rect.bottom == oVar.a(displayCutoutD)) {
                    rect.bottom += oVar.a(displayCutoutD);
                }
            }
        }
        return rect;
    }

    @Override // a3.b
    public Rect b(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        return d.f51b.b(context);
    }
}
