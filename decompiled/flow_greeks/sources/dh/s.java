package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends o1 implements zg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f8218c = new s();

    public s() {
        super(ah.a.y(kotlin.jvm.internal.l.f14944a));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(double[] dArr) {
        kotlin.jvm.internal.t.f(dArr, "<this>");
        return dArr.length;
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public double[] r() {
        return new double[0];
    }

    @Override // dh.p, dh.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(ch.c decoder, int i10, r builder, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        builder.e(decoder.k(getDescriptor(), i10));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public r k(double[] dArr) {
        kotlin.jvm.internal.t.f(dArr, "<this>");
        return new r(dArr);
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(ch.d encoder, double[] content, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.q(getDescriptor(), i11, content[i11]);
        }
    }
}
