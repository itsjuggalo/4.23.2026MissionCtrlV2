package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d2 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f8134a = new d2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8135b = g0.a("kotlin.UByte", ah.a.w(kotlin.jvm.internal.e.f14935a));

    public byte a(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return cd.x.b(decoder.A(getDescriptor()).D());
    }

    public void b(ch.f encoder, byte b10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.v(getDescriptor()).l(b10);
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        return cd.x.a(a(eVar));
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8135b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((cd.x) obj).k());
    }
}
