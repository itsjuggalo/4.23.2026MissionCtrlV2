package o7;

import kotlin.jvm.internal.AbstractC2304t;
import m7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class D implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f22101a = new D();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22102b = new q0("kotlin.Float", d.e.f21504a);

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return Float.valueOf(decoder.G());
    }

    public void b(n7.f encoder, float f8) {
        AbstractC2304t.f(encoder, "encoder");
        encoder.m(f8);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22102b;
    }

    @Override // k7.k
    public /* bridge */ /* synthetic */ void serialize(n7.f fVar, Object obj) {
        b(fVar, ((Number) obj).floatValue());
    }
}
