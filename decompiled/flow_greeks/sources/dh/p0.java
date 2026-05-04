package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends o1 implements zg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p0 f8203c = new p0();

    public p0() {
        super(ah.a.B(kotlin.jvm.internal.w.f14956a));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(long[] jArr) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        return jArr.length;
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public long[] r() {
        return new long[0];
    }

    @Override // dh.p, dh.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(ch.c decoder, int i10, o0 builder, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        builder.e(decoder.g(getDescriptor(), i10));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public o0 k(long[] jArr) {
        kotlin.jvm.internal.t.f(jArr, "<this>");
        return new o0(jArr);
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(ch.d encoder, long[] content, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.r(getDescriptor(), i11, content[i11]);
        }
    }
}
