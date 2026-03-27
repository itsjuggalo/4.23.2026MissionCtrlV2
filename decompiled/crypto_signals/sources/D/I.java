package D;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Field f199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Field f200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f201d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f198a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f199b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f200c = declaredField3;
            declaredField3.setAccessible(true);
            f201d = true;
        } catch (ReflectiveOperationException e) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }
    }
}
