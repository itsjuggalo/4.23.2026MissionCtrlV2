package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0791d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f6989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f6990b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f6991c;

    static {
        f6991c = (f6989a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f6990b;
    }

    public static boolean c() {
        if (f6989a) {
            return true;
        }
        return (f6990b == null || f6991c) ? false : true;
    }
}
