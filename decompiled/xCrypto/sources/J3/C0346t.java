package J3;

import H3.d;

/* JADX INFO: renamed from: J3.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0346t implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0346t f970a = new C0346t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f971b = new h0("kotlin.Double", d.C0024d.f737a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Double deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Double.valueOf(decoder.H());
    }

    public void b(I3.f encoder, double d4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.h(d4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f971b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Number) obj).doubleValue());
    }
}
