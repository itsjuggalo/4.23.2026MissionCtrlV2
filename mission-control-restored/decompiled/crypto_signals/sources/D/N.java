package D;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import w.C1264c;

/* JADX INFO: loaded from: classes.dex */
public abstract class N extends U {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f208f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class f210h;
    public static Field i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Field f211j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsets f212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1264c f213d;
    public C1264c e;

    public N(V v2, WindowInsets windowInsets) {
        super(v2);
        this.f213d = null;
        this.f212c = windowInsets;
    }

    private C1264c n(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f208f) {
            o();
        }
        Method method = f209g;
        if (method != null && f210h != null && i != null) {
            try {
                Object objInvoke = method.invoke(view, new Object[0]);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) i.get(f211j.get(objInvoke));
                if (rect != null) {
                    return C1264c.a(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    private static void o() {
        try {
            f209g = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f210h = cls;
            i = cls.getDeclaredField("mVisibleInsets");
            f211j = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            i.setAccessible(true);
            f211j.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        f208f = true;
    }

    @Override // D.U
    public void d(View view) {
        C1264c c1264cN = n(view);
        if (c1264cN == null) {
            c1264cN = C1264c.e;
        }
        p(c1264cN);
    }

    @Override // D.U
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.e, ((N) obj).e);
        }
        return false;
    }

    @Override // D.U
    public final C1264c g() {
        if (this.f213d == null) {
            WindowInsets windowInsets = this.f212c;
            this.f213d = C1264c.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f213d;
    }

    @Override // D.U
    public V h(int i6, int i7, int i8, int i9) {
        V vC = V.c(this.f212c, null);
        int i10 = Build.VERSION.SDK_INT;
        M l6 = i10 >= 30 ? new L(vC) : i10 >= 29 ? new K(vC) : new J(vC);
        l6.d(V.a(g(), i6, i7, i8, i9));
        l6.c(V.a(f(), i6, i7, i8, i9));
        return l6.b();
    }

    @Override // D.U
    public boolean j() {
        return this.f212c.isRound();
    }

    public void p(C1264c c1264c) {
        this.e = c1264c;
    }

    @Override // D.U
    public void k(C1264c[] c1264cArr) {
    }

    @Override // D.U
    public void l(V v2) {
    }
}
