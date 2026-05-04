package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f1803a = c();

    public static m a() {
        m mVarB = b("getEmptyRegistry");
        return mVarB != null ? mVarB : m.f1806c;
    }

    public static final m b(String str) {
        Class cls = f1803a;
        if (cls == null) {
            return null;
        }
        try {
            return (m) cls.getDeclaredMethod(str, null).invoke(null, null);
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
