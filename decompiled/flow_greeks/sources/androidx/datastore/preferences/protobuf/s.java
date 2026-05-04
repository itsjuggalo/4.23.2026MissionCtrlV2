package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class s implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f1891a = new s();

    public static s c() {
        return f1891a;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public h0 a(Class cls) {
        if (!t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (h0) t.u(cls.asSubclass(t.class)).j();
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public boolean b(Class cls) {
        return t.class.isAssignableFrom(cls);
    }
}
