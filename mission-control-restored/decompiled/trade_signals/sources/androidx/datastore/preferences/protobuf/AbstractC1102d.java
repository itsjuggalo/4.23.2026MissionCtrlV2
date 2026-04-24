package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1102d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f11209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f11210b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f11211c;

    static {
        f11211c = (f11209a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f11210b;
    }

    public static boolean c() {
        return f11209a || !(f11210b == null || f11211c);
    }
}
