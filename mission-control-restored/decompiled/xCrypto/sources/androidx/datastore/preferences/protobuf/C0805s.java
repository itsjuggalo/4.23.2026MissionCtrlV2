package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0805s implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0805s f7195a = new C0805s();

    public static C0805s c() {
        return f7195a;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public H a(Class cls) {
        if (!AbstractC0806t.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (H) AbstractC0806t.q(cls.asSubclass(AbstractC0806t.class)).f();
        } catch (Exception e4) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public boolean b(Class cls) {
        return AbstractC0806t.class.isAssignableFrom(cls);
    }
}
