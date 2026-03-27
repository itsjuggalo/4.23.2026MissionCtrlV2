package r6;

import p6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f22905a = new n0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22906b = new h0("kotlin.Short", d.h.f22069a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Short deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Short.valueOf(decoder.E());
    }

    public void b(q6.f encoder, short s7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.h(s7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22906b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Number) obj).shortValue());
    }
}
