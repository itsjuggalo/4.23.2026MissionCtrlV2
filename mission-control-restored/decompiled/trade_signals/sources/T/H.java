package T;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f7802a;

    public static class a {
        public static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        public static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    public static class b {
        public static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        public static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    public static class c {
        public static int a(ViewConfiguration viewConfiguration, int i8, int i9, int i10) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i8, i9, i10);
        }

        public static int b(ViewConfiguration viewConfiguration, int i8, int i9, int i10) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i8, i9, i10);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f7802a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static int a(Resources resources, int i8, S.h hVar, int i9) {
        int dimensionPixelSize;
        return i8 != -1 ? (i8 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i8)) < 0) ? i9 : dimensionPixelSize : ((Integer) hVar.get()).intValue();
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        if (f7802a != null) {
            try {
                return ((Integer) r0.invoke(viewConfiguration, null)).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int c(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    public static int d(Resources resources, int i8, int i9) {
        if (i8 == 4194304 && i9 == 26) {
            return c(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static int e(Resources resources, int i8, int i9) {
        if (i8 == 4194304 && i9 == 26) {
            return c(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float f(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.a(viewConfiguration) : b(viewConfiguration, context);
    }

    public static int g(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? b.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int h(Context context, final ViewConfiguration viewConfiguration, int i8, int i9, int i10) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(viewConfiguration, i8, i9, i10);
        }
        if (!k(i8, i9, i10)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i10, i9);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new S.h() { // from class: T.F
            @Override // S.h
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    public static int i(Context context, final ViewConfiguration viewConfiguration, int i8, int i9, int i10) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(viewConfiguration, i8, i9, i10);
        }
        if (!k(i8, i9, i10)) {
            return Integer.MAX_VALUE;
        }
        Resources resources = context.getResources();
        int iE = e(resources, i10, i9);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iE, new S.h() { // from class: T.G
            @Override // S.h
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Integer.MAX_VALUE);
    }

    public static float j(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : b(viewConfiguration, context);
    }

    public static boolean k(int i8, int i9, int i10) {
        InputDevice device = InputDevice.getDevice(i8);
        return (device == null || device.getMotionRange(i9, i10) == null) ? false : true;
    }

    public static boolean l(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int iC = c(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        return iC != 0 && resources.getBoolean(iC);
    }
}
