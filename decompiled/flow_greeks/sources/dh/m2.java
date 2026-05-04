package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m2 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m2 f8187a = new m2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8188b = g0.a("kotlin.UShort", ah.a.C(kotlin.jvm.internal.q0.f14950a));

    public short a(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return cd.e0.b(decoder.A(getDescriptor()).F());
    }

    public void b(ch.f encoder, short s10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.v(getDescriptor()).k(s10);
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        return cd.e0.a(a(eVar));
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8188b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((cd.e0) obj).k());
    }
}
