package androidx.datastore.preferences.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class D implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public K[] f4479a;

    @Override // androidx.datastore.preferences.protobuf.K
    public final U a(Class cls) {
        for (K k6 : this.f4479a) {
            if (k6.b(cls)) {
                return k6.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public final boolean b(Class cls) {
        for (K k6 : this.f4479a) {
            if (k6.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
