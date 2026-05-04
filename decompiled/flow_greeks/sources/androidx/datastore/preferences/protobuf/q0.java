package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f1841a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o0 f1842b = new p0();

    public static o0 a() {
        return f1841a;
    }

    public static o0 b() {
        return f1842b;
    }

    public static o0 c() {
        if (t0.f1908d) {
            return null;
        }
        try {
            return (o0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
