package C0;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f434b;

    public abstract void a(View view);

    public abstract float b(View view);

    public abstract void c(View view);

    public abstract void d(View view, int i8, int i9, int i10, int i11);

    public abstract void e(View view, float f8);

    public void f(View view, int i8) {
        if (!f434b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f433a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f434b = true;
        }
        Field field = f433a;
        if (field != null) {
            try {
                f433a.setInt(view, i8 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void g(View view, Matrix matrix);

    public abstract void h(View view, Matrix matrix);
}
