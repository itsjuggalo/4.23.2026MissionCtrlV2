package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0947s implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0947s f7603a = new C0947s();

    public static C0947s c() {
        return f7603a;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public H a(Class cls) {
        if (!AbstractC0948t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (H) AbstractC0948t.u(cls.asSubclass(AbstractC0948t.class)).j();
        } catch (Exception e7) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public boolean b(Class cls) {
        return AbstractC0948t.class.isAssignableFrom(cls);
    }
}
