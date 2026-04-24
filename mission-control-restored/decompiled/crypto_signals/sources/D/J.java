package D;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import w.C1264c;

/* JADX INFO: loaded from: classes.dex */
public final class J extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f202c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f203d = false;
    public static Constructor e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f204f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowInsets f205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1264c f206b;

    public J() {
        this.f205a = e();
    }

    private static WindowInsets e() {
        if (!f203d) {
            try {
                f202c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f203d = true;
        }
        Field field = f202c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e6) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e6);
            }
        }
        if (!f204f) {
            try {
                e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e7) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e7);
            }
            f204f = true;
        }
        Constructor constructor = e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e8) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e8);
            }
        }
        return null;
    }

    @Override // D.M
    public V b() {
        a();
        V vC = V.c(this.f205a, null);
        U u6 = vC.f219a;
        u6.k(null);
        u6.m(this.f206b);
        return vC;
    }

    @Override // D.M
    public void c(C1264c c1264c) {
        this.f206b = c1264c;
    }

    @Override // D.M
    public void d(C1264c c1264c) {
        WindowInsets windowInsets = this.f205a;
        if (windowInsets != null) {
            this.f205a = windowInsets.replaceSystemWindowInsets(c1264c.f10677a, c1264c.f10678b, c1264c.f10679c, c1264c.f10680d);
        }
    }

    public J(V v2) {
        super(v2);
        this.f205a = v2.b();
    }
}
