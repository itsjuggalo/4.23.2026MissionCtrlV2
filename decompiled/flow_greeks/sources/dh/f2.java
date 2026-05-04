package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f2 extends o1 implements zg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f2 f8143c = new f2();

    public f2() {
        super(ah.a.r(cd.z.f3889b));
    }

    @Override // dh.a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((cd.a0) obj).K());
    }

    @Override // dh.a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((cd.a0) obj).K());
    }

    @Override // dh.o1
    public /* bridge */ /* synthetic */ Object r() {
        return cd.a0.a(w());
    }

    @Override // dh.o1
    public /* bridge */ /* synthetic */ void u(ch.d dVar, Object obj, int i10) {
        z(dVar, ((cd.a0) obj).K(), i10);
    }

    public int v(int[] collectionSize) {
        kotlin.jvm.internal.t.f(collectionSize, "$this$collectionSize");
        return cd.a0.u(collectionSize);
    }

    public int[] w() {
        return cd.a0.c(0);
    }

    @Override // dh.p, dh.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(ch.c decoder, int i10, e2 builder, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        builder.e(cd.z.b(decoder.v(getDescriptor(), i10).j()));
    }

    public e2 y(int[] toBuilder) {
        kotlin.jvm.internal.t.f(toBuilder, "$this$toBuilder");
        return new e2(toBuilder, null);
    }

    public void z(ch.d encoder, int[] content, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.h(getDescriptor(), i11).A(cd.a0.r(content, i11));
        }
    }
}
