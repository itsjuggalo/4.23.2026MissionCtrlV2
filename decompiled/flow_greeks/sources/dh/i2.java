package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i2 extends o1 implements zg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i2 f8160c = new i2();

    public i2() {
        super(ah.a.s(cd.b0.f3836b));
    }

    @Override // dh.a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((cd.c0) obj).K());
    }

    @Override // dh.a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((cd.c0) obj).K());
    }

    @Override // dh.o1
    public /* bridge */ /* synthetic */ Object r() {
        return cd.c0.a(w());
    }

    @Override // dh.o1
    public /* bridge */ /* synthetic */ void u(ch.d dVar, Object obj, int i10) {
        z(dVar, ((cd.c0) obj).K(), i10);
    }

    public int v(long[] collectionSize) {
        kotlin.jvm.internal.t.f(collectionSize, "$this$collectionSize");
        return cd.c0.u(collectionSize);
    }

    public long[] w() {
        return cd.c0.c(0);
    }

    @Override // dh.p, dh.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(ch.c decoder, int i10, h2 builder, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        builder.e(cd.b0.b(decoder.v(getDescriptor(), i10).q()));
    }

    public h2 y(long[] toBuilder) {
        kotlin.jvm.internal.t.f(toBuilder, "$this$toBuilder");
        return new h2(toBuilder, null);
    }

    public void z(ch.d encoder, long[] content, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.h(getDescriptor(), i11).D(cd.c0.r(content, i11));
        }
    }
}
