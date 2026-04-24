package p;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f21345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f21346b;

    static {
        f21346b = Build.VERSION.SDK_INT >= 27;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f21345a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f21345a.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static boolean a(View view) {
        return Q.N.z(view) == 1;
    }
}
