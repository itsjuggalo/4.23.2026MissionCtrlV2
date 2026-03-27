package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0799l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f7111a = c();

    public static C0800m a() {
        C0800m c0800mB = b("getEmptyRegistry");
        return c0800mB != null ? c0800mB : C0800m.f7116c;
    }

    public static final C0800m b(String str) {
        Class cls = f7111a;
        if (cls == null) {
            return null;
        }
        try {
            return (C0800m) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
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
