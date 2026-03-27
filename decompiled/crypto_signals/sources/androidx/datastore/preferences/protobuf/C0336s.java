package androidx.datastore.preferences.protobuf;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0336s implements K {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0336s f4612b = new C0336s(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4613a;

    public /* synthetic */ C0336s(int i) {
        this.f4613a = i;
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public final U a(Class cls) {
        switch (this.f4613a) {
            case 0:
                if (!AbstractC0339v.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (U) AbstractC0339v.d(cls.asSubclass(AbstractC0339v.class)).c(3);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public final boolean b(Class cls) {
        switch (this.f4613a) {
            case 0:
                return AbstractC0339v.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
