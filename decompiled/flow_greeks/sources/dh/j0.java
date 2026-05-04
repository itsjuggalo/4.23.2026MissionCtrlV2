package dh;

import bh.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f8162a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8163b = new p1("kotlin.Int", d.f.f3376a);

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return Integer.valueOf(decoder.j());
    }

    public void b(ch.f encoder, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.A(i10);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8163b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((Number) obj).intValue());
    }
}
