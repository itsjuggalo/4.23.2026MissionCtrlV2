package P0;

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
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f6267b = new e();

    @Override // P0.b
    public Rect a(Activity activity) throws Exception {
        Rect rect;
        AbstractC2304t.f(activity, "activity");
        Rect rect2 = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (a.f6261a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = (Rect) objInvoke;
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                AbstractC2304t.d(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect = (Rect) objInvoke2;
            }
            rect2.set(rect);
        } catch (Exception e8) {
            if (!(e8 instanceof NoSuchFieldException ? true : e8 instanceof NoSuchMethodException ? true : e8 instanceof IllegalAccessException ? true : e8 instanceof InvocationTargetException)) {
                throw e8;
            }
            Log.w(b.f6262a.b(), e8);
            j.f(activity, rect2);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        a aVar = a.f6261a;
        if (!aVar.a(activity)) {
            int iE = j.e(activity);
            int i8 = rect2.bottom;
            if (i8 + iE == point.y) {
                rect2.bottom = i8 + iE;
            } else {
                int i9 = rect2.right;
                if (i9 + iE == point.x) {
                    rect2.right = i9 + iE;
                } else if (rect2.left == iE) {
                    rect2.left = 0;
                }
            }
        }
        if ((rect2.width() < point.x || rect2.height() < point.y) && !aVar.a(activity)) {
            AbstractC2304t.c(defaultDisplay);
            DisplayCutout displayCutoutD = j.d(defaultDisplay);
            if (displayCutoutD != null) {
                int i10 = rect2.left;
                s sVar = s.f6275a;
                if (i10 == sVar.b(displayCutoutD)) {
                    rect2.left = 0;
                }
                if (point.x - rect2.right == sVar.c(displayCutoutD)) {
                    rect2.right += sVar.c(displayCutoutD);
                }
                if (rect2.top == sVar.d(displayCutoutD)) {
                    rect2.top = 0;
                }
                if (point.y - rect2.bottom == sVar.a(displayCutoutD)) {
                    rect2.bottom += sVar.a(displayCutoutD);
                }
            }
        }
        return rect2;
    }

    @Override // P0.b
    public Rect b(Context context) {
        AbstractC2304t.f(context, "context");
        return d.f6266b.b(context);
    }
}
