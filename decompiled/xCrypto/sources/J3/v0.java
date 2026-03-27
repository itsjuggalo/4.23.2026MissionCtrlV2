package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends g0 implements F3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v0 f984c = new v0();

    public v0() {
        super(G3.a.r(W2.w.f5503b));
    }

    @Override // J3.AbstractC0324a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((W2.x) obj).x());
    }

    @Override // J3.AbstractC0324a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((W2.x) obj).x());
    }

    @Override // J3.g0
    public /* bridge */ /* synthetic */ Object r() {
        return W2.x.f(w());
    }

    @Override // J3.g0
    public /* bridge */ /* synthetic */ void u(I3.d dVar, Object obj, int i4) {
        z(dVar, ((W2.x) obj).x(), i4);
    }

    public int v(int[] collectionSize) {
        kotlin.jvm.internal.r.f(collectionSize, "$this$collectionSize");
        return W2.x.r(collectionSize);
    }

    public int[] w() {
        return W2.x.i(0);
    }

    @Override // J3.AbstractC0343p, J3.AbstractC0324a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(I3.c decoder, int i4, u0 builder, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        builder.e(W2.w.c(decoder.s(getDescriptor(), i4).l()));
    }

    public u0 y(int[] toBuilder) {
        kotlin.jvm.internal.r.f(toBuilder, "$this$toBuilder");
        return new u0(toBuilder, null);
    }

    public void z(I3.d encoder, int[] content, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(content, "content");
        for (int i5 = 0; i5 < i4; i5++) {
            encoder.s(getDescriptor(), i5).B(W2.x.p(content, i5));
        }
    }
}
