package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class Q implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Q f22138a = new Q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22139b = new q0("kotlin.Long", d.g.f21506a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Long.valueOf(decoder.s());
    }

    public void b(n7.f encoder, long j8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.A(j8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22139b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Number) obj).longValue());
    }
}
