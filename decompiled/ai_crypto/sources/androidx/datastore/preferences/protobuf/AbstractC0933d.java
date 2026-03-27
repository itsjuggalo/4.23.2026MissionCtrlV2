package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0933d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f7398b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7399c;

    static {
        f7399c = (f7397a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f7398b;
    }

    public static boolean c() {
        return f7397a || !(f7398b == null || f7399c);
    }
}
