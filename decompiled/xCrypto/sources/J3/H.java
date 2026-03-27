package J3;

import H3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class H implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f874a = new H();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f875b = new h0("kotlin.Int", d.f.f739a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Integer.valueOf(decoder.l());
    }

    public void b(I3.f encoder, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.B(i4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f875b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Number) obj).intValue());
    }
}
