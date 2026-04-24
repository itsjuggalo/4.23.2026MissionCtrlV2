package I0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f2711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2712b;

    public abstract void a(View view);

    public abstract float b(View view);

    public abstract void c(View view);

    public abstract void d(View view, int i7, int i8, int i9, int i10);

    public abstract void e(View view, float f7);

    public void f(View view, int i7) {
        if (!f2712b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2711a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f2712b = true;
        }
        Field field = f2711a;
        if (field != null) {
            try {
                f2711a.setInt(view, i7 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void g(View view, Matrix matrix);

    public abstract void h(View view, Matrix matrix);
}
