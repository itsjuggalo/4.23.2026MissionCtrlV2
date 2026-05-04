package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f1721a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f1722b = new f0();

    public static e0 a() {
        return f1721a;
    }

    public static e0 b() {
        return f1722b;
    }

    public static e0 c() {
        if (t0.f1908d) {
            return null;
        }
        try {
            return (e0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
