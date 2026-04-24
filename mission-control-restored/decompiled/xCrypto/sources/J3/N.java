package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class N extends g0 implements F3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final N f881c = new N();

    public N() {
        super(G3.a.B(kotlin.jvm.internal.t.f13432a));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        return jArr.length;
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public long[] r() {
        return new long[0];
    }

    @Override // J3.AbstractC0343p, J3.AbstractC0324a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(I3.c decoder, int i4, M builder, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        builder.e(decoder.j(getDescriptor(), i4));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public M k(long[] jArr) {
        kotlin.jvm.internal.r.f(jArr, "<this>");
        return new M(jArr);
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(I3.d encoder, long[] content, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(content, "content");
        for (int i5 = 0; i5 < i4; i5++) {
            encoder.l(getDescriptor(), i5, content[i5]);
        }
    }
}
