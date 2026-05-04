package dh;

import bh.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f8225a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8226b = new p1("kotlin.time.Duration", d.i.f3379a);

    public long a(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return lg.a.f15679b.c(decoder.m());
    }

    public void b(ch.f encoder, long j10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        encoder.F(lg.a.Y(j10));
    }

    @Override // zg.a
    public /* bridge */ /* synthetic */ Object deserialize(ch.e eVar) {
        return lg.a.i(a(eVar));
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8226b;
    }

    @Override // zg.k
    public /* bridge */ /* synthetic */ void serialize(ch.f fVar, Object obj) {
        b(fVar, ((lg.a) obj).c0());
    }
}
