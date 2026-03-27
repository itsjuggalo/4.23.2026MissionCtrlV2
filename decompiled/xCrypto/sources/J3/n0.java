package J3;

import H3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f948a = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f949b = new h0("kotlin.Short", d.h.f741a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Short deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Short.valueOf(decoder.F());
    }

    public void b(I3.f encoder, short s4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.i(s4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f949b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Number) obj).shortValue());
    }
}
