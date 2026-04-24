package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f22223a = new w0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22224b = new q0("kotlin.Short", d.h.f21507a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Short deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Short.valueOf(decoder.F());
    }

    public void b(n7.f encoder, short s8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.i(s8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22224b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Number) obj).shortValue());
    }
}
