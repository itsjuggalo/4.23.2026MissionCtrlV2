package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1231b implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1248q f12626a = C1248q.b();

    public final V c(V v7) throws D {
        if (v7 == null || v7.d()) {
            return v7;
        }
        throw d(v7).a().k(v7);
    }

    public final u0 d(V v7) {
        return v7 instanceof AbstractC1229a ? ((AbstractC1229a) v7).n() : new u0(v7);
    }

    @Override // com.google.protobuf.f0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public V a(AbstractC1241j abstractC1241j, C1248q c1248q) {
        return c((V) b(abstractC1241j, c1248q));
    }
}
