package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0321c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f4537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f4538b;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        f4537a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        f4538b = cls2 != null;
    }

    public static boolean a() {
        return (f4537a == null || f4538b) ? false : true;
    }
}
