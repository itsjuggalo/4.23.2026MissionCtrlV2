package r6;

import p6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class O implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O f22839a = new O();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f22840b = new h0("kotlin.Long", d.g.f22068a);

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return Long.valueOf(decoder.r());
    }

    public void b(q6.f encoder, long j7) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        encoder.B(j7);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f22840b;
    }

    @Override // n6.h
    public /* bridge */ /* synthetic */ void serialize(q6.f fVar, Object obj) {
        b(fVar, ((Number) obj).longValue());
    }
}
