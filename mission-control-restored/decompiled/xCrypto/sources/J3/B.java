package J3;

import H3.d;

/* JADX INFO: loaded from: classes3.dex */
public final class B implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f862a = new B();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f863b = new h0("kotlin.Float", d.e.f738a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Float.valueOf(decoder.G());
    }

    public void b(I3.f encoder, float f4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.p(f4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f863b;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(I3.f fVar, Object obj) {
        b(fVar, ((Number) obj).floatValue());
    }
}
