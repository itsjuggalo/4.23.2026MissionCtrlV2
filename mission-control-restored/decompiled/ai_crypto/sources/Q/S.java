package Q;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import com.google.android.gms.common.api.a;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f4402a;

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
        public static int a(ViewConfiguration viewConfiguration, int i7, int i8, int i9) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i7, i8, i9);
        }

        public static int b(ViewConfiguration viewConfiguration, int i7, int i8, int i9) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i7, i8, i9);
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f4402a = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", null);
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    public static int a(Resources resources, int i7, P.h hVar, int i8) {
        int dimensionPixelSize;
        return i7 != -1 ? (i7 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i7)) < 0) ? i8 : dimensionPixelSize : ((Integer) hVar.get()).intValue();
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f4402a) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, null)).intValue();
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

    public static int d(Resources resources, int i7, int i8) {
        if (i7 == 4194304 && i8 == 26) {
            return c(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static int e(Resources resources, int i7, int i8) {
        if (i7 == 4194304 && i8 == 26) {
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

    public static int h(Context context, final ViewConfiguration viewConfiguration, int i7, int i8, int i9) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.a(viewConfiguration, i7, i8, i9);
        }
        if (!k(i7, i8, i9)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i9, i8);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new P.h() { // from class: Q.P
            @Override // P.h
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    public static int i(Context context, final ViewConfiguration viewConfiguration, int i7, int i8, int i9) {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b(viewConfiguration, i7, i8, i9);
        }
        if (!k(i7, i8, i9)) {
            return a.e.API_PRIORITY_OTHER;
        }
        Resources resources = context.getResources();
        int iE = e(resources, i9, i8);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iE, new P.h() { // from class: Q.Q
            @Override // P.h
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, a.e.API_PRIORITY_OTHER);
    }

    public static float j(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : b(viewConfiguration, context);
    }

    public static boolean k(int i7, int i8, int i9) {
        InputDevice device = InputDevice.getDevice(i7);
        return (device == null || device.getMotionRange(i8, i9) == null) ? false : true;
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
