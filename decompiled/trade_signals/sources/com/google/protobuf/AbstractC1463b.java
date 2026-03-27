package com.google.protobuf;

import java.io.InputStream;

/* JADX INFO: renamed from: com.google.protobuf.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1463b implements S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1474m f16333a = C1474m.b();

    public final J d(J j8) throws C1482v {
        if (j8 == null || j8.e()) {
            return j8;
        }
        throw e(j8).a().k(j8);
    }

    public final e0 e(J j8) {
        return j8 instanceof AbstractC1462a ? ((AbstractC1462a) j8).m() : new e0(j8);
    }

    @Override // com.google.protobuf.S
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public J b(AbstractC1468g abstractC1468g, C1474m c1474m) {
        return d((J) c(abstractC1468g, c1474m));
    }

    @Override // com.google.protobuf.S
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public J a(InputStream inputStream) {
        return h(inputStream, f16333a);
    }

    public J h(InputStream inputStream, C1474m c1474m) {
        return d(i(inputStream, c1474m));
    }

    public J i(InputStream inputStream, C1474m c1474m) throws C1482v {
        AbstractC1468g abstractC1468gG = AbstractC1468g.g(inputStream);
        J j8 = (J) c(abstractC1468gG, c1474m);
        try {
            abstractC1468gG.a(0);
            return j8;
        } catch (C1482v e8) {
            throw e8.k(j8);
        }
    }
}
