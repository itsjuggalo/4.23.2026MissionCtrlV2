package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1116s implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1116s f11415a = new C1116s();

    public static C1116s c() {
        return f11415a;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public H a(Class cls) {
        if (!AbstractC1117t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (H) AbstractC1117t.u(cls.asSubclass(AbstractC1117t.class)).j();
        } catch (Exception e8) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e8);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public boolean b(Class cls) {
        return AbstractC1117t.class.isAssignableFrom(cls);
    }
}
