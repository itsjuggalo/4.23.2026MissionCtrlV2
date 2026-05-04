package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f1833a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f1834b = c();

    public static n a() {
        n nVar = f1834b;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static n b() {
        return f1833a;
    }

    public static n c() {
        if (t0.f1908d) {
            return null;
        }
        try {
            return (n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
