package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1110l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f11331a = c();

    public static C1111m a() {
        C1111m c1111mB = b("getEmptyRegistry");
        return c1111mB != null ? c1111mB : C1111m.f11336c;
    }

    public static final C1111m b(String str) {
        Class cls = f11331a;
        if (cls == null) {
            return null;
        }
        try {
            return (C1111m) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
