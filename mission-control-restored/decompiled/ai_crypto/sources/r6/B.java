package r6;

import p6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class B implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f22819a = new B();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22820b = new h0("kotlin.Float", d.e.f22066a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Float.valueOf(decoder.F());
    }

    public void b(q6.f encoder, float f7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.n(f7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22820b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Number) obj).floatValue());
    }
}
