package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0941l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f7519a = c();

    public static C0942m a() {
        C0942m c0942mB = b("getEmptyRegistry");
        return c0942mB != null ? c0942mB : C0942m.f7524c;
    }

    public static final C0942m b(String str) {
        Class cls = f7519a;
        if (cls == null) {
            return null;
        }
        try {
            return (C0942m) cls.getDeclaredMethod(str, null).invoke(null, null);
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
