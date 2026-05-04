package dh;

import bh.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f8131a = new d0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8132b = new p1("kotlin.Float", d.e.f3375a);

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return Float.valueOf(decoder.G());
    }

    public void b(ch.f encoder, float f10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.p(f10);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8132b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((Number) obj).floatValue());
    }
}
