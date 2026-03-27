package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1052b implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1070q f11002a = C1070q.b();

    public final W c(W w4) throws D {
        if (w4 == null || w4.isInitialized()) {
            return w4;
        }
        throw d(w4).a().k(w4);
    }

    public final v0 d(W w4) {
        return w4 instanceof AbstractC1050a ? ((AbstractC1050a) w4).newUninitializedMessageException() : new v0(w4);
    }

    @Override // com.google.protobuf.g0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public W a(AbstractC1063j abstractC1063j, C1070q c1070q) {
        return c((W) b(abstractC1063j, c1070q));
    }
}
