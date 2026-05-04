package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j2 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2 f8176a = new j2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8177b = g0.a("kotlin.ULong", ah.a.B(kotlin.jvm.internal.w.f14956a));

    public long a(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return cd.b0.b(decoder.A(getDescriptor()).q());
    }

    public void b(ch.f encoder, long j10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.v(getDescriptor()).D(j10);
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        return cd.b0.a(a(eVar));
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8177b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((cd.b0) obj).k());
    }
}
