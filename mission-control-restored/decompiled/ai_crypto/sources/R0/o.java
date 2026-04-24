package R0;

import F5.AbstractC0556n;
import Q.W;
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

/* JADX INFO: loaded from: classes.dex */
public final class o implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f4671b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList f4673d;

    static {
        String simpleName = o.class.getSimpleName();
        r.e(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f4672c = simpleName;
        f4673d = AbstractC0556n.e(Integer.valueOf(W.m.g()), Integer.valueOf(W.m.f()), Integer.valueOf(W.m.a()), Integer.valueOf(W.m.c()), Integer.valueOf(W.m.i()), Integer.valueOf(W.m.e()), Integer.valueOf(W.m.j()), Integer.valueOf(W.m.b()));
    }

    @Override // R0.l
    public k a(Activity activity) {
        r.f(activity, "activity");
        return e(activity);
    }

    public k c(Activity activity) throws Exception {
        W wA;
        r.f(activity, "activity");
        int i7 = Build.VERSION.SDK_INT;
        Rect rectA = i7 >= 30 ? V0.g.f5247a.a(activity) : i7 >= 29 ? h(activity) : i7 >= 28 ? g(activity) : f(activity);
        if (i7 >= 30) {
            wA = i(activity);
        } else {
            wA = new W.b().a();
            r.e(wA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new O0.b(rectA), wA);
    }

    public k d(Context context) {
        r.f(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return V0.g.f5247a.c(context);
        }
        Context contextA = V0.b.f5246a.a(context);
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
        W wA;
        r.f(context, "context");
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 30) {
            rect = V0.g.f5247a.d(context);
        } else {
            Object systemService = context.getSystemService("window");
            r.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display display = ((WindowManager) systemService).getDefaultDisplay();
            r.e(display, "display");
            Point pointL = l(display);
            rect = new Rect(0, 0, pointL.x, pointL.y);
        }
        if (i7 >= 30) {
            wA = i(context);
        } else {
            wA = new W.b().a();
            r.e(wA, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new O0.b(rect), wA);
    }

    public final Rect f(Activity activity) {
        r.f(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!V0.a.f5245a.a(activity)) {
            r.e(defaultDisplay, "defaultDisplay");
            Point pointL = l(defaultDisplay);
            int iK = k(activity);
            int i7 = rect.bottom;
            if (i7 + iK == pointL.y) {
                rect.bottom = i7 + iK;
            } else {
                int i8 = rect.right;
                if (i8 + iK == pointL.x) {
                    rect.right = i8 + iK;
                }
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
            if (V0.a.f5245a.a(activity)) {
                Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                r.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke);
            } else {
                Object objInvoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                r.d(objInvoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) objInvoke2);
            }
        } catch (IllegalAccessException e7) {
            Log.w(f4672c, e7);
            m(activity, rect);
        } catch (NoSuchFieldException e8) {
            Log.w(f4672c, e8);
            m(activity, rect);
        } catch (NoSuchMethodException e9) {
            Log.w(f4672c, e9);
            m(activity, rect);
        } catch (InvocationTargetException e10) {
            Log.w(f4672c, e10);
            m(activity, rect);
        }
        Display currentDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        V0.h hVar = V0.h.f5248a;
        r.e(currentDisplay, "currentDisplay");
        hVar.a(currentDisplay, point);
        V0.a aVar = V0.a.f5245a;
        if (!aVar.a(activity)) {
            int iK = k(activity);
            int i7 = rect.bottom;
            if (i7 + iK == point.y) {
                rect.bottom = i7 + iK;
            } else {
                int i8 = rect.right;
                if (i8 + iK == point.x) {
                    rect.right = i8 + iK;
                } else if (rect.left == iK) {
                    rect.left = 0;
                }
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !aVar.a(activity) && (displayCutoutJ = j(currentDisplay)) != null) {
            int i9 = rect.left;
            V0.m mVar = V0.m.f5249a;
            if (i9 == mVar.b(displayCutoutJ)) {
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
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            r.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (IllegalAccessException e7) {
            Log.w(f4672c, e7);
            return g(activity);
        } catch (NoSuchFieldException e8) {
            Log.w(f4672c, e8);
            return g(activity);
        } catch (NoSuchMethodException e9) {
            Log.w(f4672c, e9);
            return g(activity);
        } catch (InvocationTargetException e10) {
            Log.w(f4672c, e10);
            return g(activity);
        }
    }

    public final W i(Context context) throws Exception {
        r.f(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return V0.g.f5247a.b(context);
        }
        throw new Exception("Incompatible SDK version");
    }

    public final DisplayCutout j(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
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
        } catch (ClassNotFoundException e7) {
            Log.w(f4672c, e7);
            return null;
        } catch (IllegalAccessException e8) {
            Log.w(f4672c, e8);
            return null;
        } catch (InstantiationException e9) {
            Log.w(f4672c, e9);
            return null;
        } catch (NoSuchFieldException e10) {
            Log.w(f4672c, e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.w(f4672c, e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.w(f4672c, e12);
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
        V0.h.f5248a.a(display, point);
        return point;
    }

    public final void m(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }
}
