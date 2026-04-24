package A0;

import H.L;
import X2.AbstractC0769p;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import x0.C1913b;

/* JADX INFO: loaded from: classes.dex */
public final class o implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f50b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f51c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList f52d;

    static {
        String simpleName = o.class.getSimpleName();
        r.e(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f51c = simpleName;
        f52d = AbstractC0769p.e(Integer.valueOf(L.m.g()), Integer.valueOf(L.m.f()), Integer.valueOf(L.m.a()), Integer.valueOf(L.m.c()), Integer.valueOf(L.m.h()), Integer.valueOf(L.m.e()), Integer.valueOf(L.m.i()), Integer.valueOf(L.m.b()));
    }

    @Override // A0.l
    public k a(Activity activity) {
        r.f(activity, "activity");
        return e(activity);
    }

    public k c(Activity activity) throws Exception {
        L lA;
        r.f(activity, "activity");
        int i4 = Build.VERSION.SDK_INT;
        Rect rectA = i4 >= 30 ? E0.g.f378a.a(activity) : i4 >= 29 ? h(activity) : i4 >= 28 ? g(activity) : f(activity);
        if (i4 >= 30) {
            lA = i(activity);
        } else {
            lA = new L.b().a();
            r.e(lA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new C1913b(rectA), lA);
    }

    public k d(Context context) {
        r.f(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return E0.g.f378a.c(context);
        }
        Context contextA = E0.b.f377a.a(context);
        if (contextA instanceof Activity) {
            return c((Activity) context);
        }
        if (!(contextA instanceof InputMethodService)) {
            throw new IllegalArgumentException(context + " is not a UiContext");
        }
        Object systemService = context.getSystemService("window");
        r.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        r.e(defaultDisplay, "wm.defaultDisplay");
        Point pointL = l(defaultDisplay);
        return new k(new Rect(0, 0, pointL.x, pointL.y), null, 2, null);
    }

    public k e(Context context) throws Exception {
        Rect rect;
        L lA;
        r.f(context, "context");
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            rect = E0.g.f378a.d(context);
        } else {
            Object systemService = context.getSystemService("window");
            r.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display display = ((WindowManager) systemService).getDefaultDisplay();
            r.e(display, "display");
            Point pointL = l(display);
            rect = new Rect(0, 0, pointL.x, pointL.y);
        }
        if (i4 >= 30) {
            lA = i(context);
        } else {
            lA = new L.b().a();
            r.e(lA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new C1913b(rect), lA);
    }

    public final Rect f(Activity activity) {
        r.f(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!E0.a.f376a.a(activity)) {
            r.e(defaultDisplay, "defaultDisplay");
            Point pointL = l(defaultDisplay);
            int iK = k(activity);
            int i4 = rect.bottom;
            if (i4 + iK == pointL.y) {
                rect.bottom = i4 + iK;
                return rect;
            }
            int i5 = rect.right;
            if (i5 + iK == pointL.x) {
                rect.right = i5 + iK;
            }
        }
        return rect;
    }

    public final Rect g(Activity activity) {
        DisplayCutout displayCutoutJ;
        r.f(activity, "activity");
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (E0.a.f376a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                r.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                r.d(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e4) {
            Log.w(f51c, e4);
            m(activity, rect);
        } catch (NoSuchFieldException e5) {
            Log.w(f51c, e5);
            m(activity, rect);
        } catch (NoSuchMethodException e6) {
            Log.w(f51c, e6);
            m(activity, rect);
        } catch (InvocationTargetException e7) {
            Log.w(f51c, e7);
            m(activity, rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        E0.h hVar = E0.h.f379a;
        r.e(currentDisplay, "currentDisplay");
        hVar.a(currentDisplay, point);
        E0.a aVar = E0.a.f376a;
        if (!aVar.a(activity)) {
            int iK = k(activity);
            int i4 = rect.bottom;
            if (i4 + iK == point.y) {
                rect.bottom = i4 + iK;
            } else {
                int i5 = rect.right;
                if (i5 + iK == point.x) {
                    rect.right = i5 + iK;
                } else if (rect.left == iK) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !aVar.a(activity) && (displayCutoutJ = j(currentDisplay)) != null) {
            int i6 = rect.left;
            E0.m mVar = E0.m.f380a;
            if (i6 == mVar.b(displayCutoutJ)) {
                rect.left = 0;
            }
            if (point.x - rect.right == mVar.c(displayCutoutJ)) {
                rect.right += mVar.c(displayCutoutJ);
            }
            if (rect.top == mVar.d(displayCutoutJ)) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == mVar.a(displayCutoutJ)) {
                rect.bottom += mVar.a(displayCutoutJ);
            }
        }
        return rect;
    }

    public final Rect h(Activity activity) {
        r.f(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            r.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (IllegalAccessException e4) {
            Log.w(f51c, e4);
            return g(activity);
        } catch (NoSuchFieldException e5) {
            Log.w(f51c, e5);
            return g(activity);
        } catch (NoSuchMethodException e6) {
            Log.w(f51c, e6);
            return g(activity);
        } catch (InvocationTargetException e7) {
            Log.w(f51c, e7);
            return g(activity);
        }
    }

    public final L i(Context context) throws Exception {
        r.f(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return E0.g.f378a.b(context);
        }
        throw new Exception("Incompatible SDK version");
    }

    public final DisplayCutout j(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", objNewInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, objNewInstance);
            Field declaredField = objNewInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objNewInstance);
            if (m.a(obj)) {
                return n.a(obj);
            }
            return null;
        } catch (ClassNotFoundException e4) {
            Log.w(f51c, e4);
            return null;
        } catch (IllegalAccessException e5) {
            Log.w(f51c, e5);
            return null;
        } catch (InstantiationException e6) {
            Log.w(f51c, e6);
            return null;
        } catch (NoSuchFieldException e7) {
            Log.w(f51c, e7);
            return null;
        } catch (NoSuchMethodException e8) {
            Log.w(f51c, e8);
            return null;
        } catch (InvocationTargetException e9) {
            Log.w(f51c, e9);
            return null;
        }
    }

    public final int k(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final Point l(Display display) {
        r.f(display, "display");
        Point point = new Point();
        E0.h.f379a.a(display, point);
        return point;
    }

    public final void m(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
