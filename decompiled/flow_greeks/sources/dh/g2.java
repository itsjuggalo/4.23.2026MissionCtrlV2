package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g2 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g2 f8147a = new g2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8148b = g0.a("kotlin.UInt", ah.a.A(kotlin.jvm.internal.s.f14952a));

    public int a(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return cd.z.b(decoder.A(getDescriptor()).j());
    }

    public void b(ch.f encoder, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.v(getDescriptor()).A(i10);
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        return cd.z.a(a(eVar));
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8148b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((cd.z) obj).k());
    }
}
