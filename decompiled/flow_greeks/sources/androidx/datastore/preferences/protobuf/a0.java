package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f1641a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f1642b = new z();

    public static y a() {
        return f1641a;
    }

    public static y b() {
        return f1642b;
    }

    public static y c() {
        if (t0.f1908d) {
            return null;
        }
        try {
            return (y) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
