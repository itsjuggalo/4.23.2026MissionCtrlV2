package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends g0 implements F3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m0 f946c = new m0();

    public m0() {
        super(G3.a.C(kotlin.jvm.internal.I.f13413a));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(short[] sArr) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        return sArr.length;
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public short[] r() {
        return new short[0];
    }

    @Override // J3.AbstractC0343p, J3.AbstractC0324a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(I3.c decoder, int i4, l0 builder, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        builder.e(decoder.u(getDescriptor(), i4));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public l0 k(short[] sArr) {
        kotlin.jvm.internal.r.f(sArr, "<this>");
        return new l0(sArr);
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(I3.d encoder, short[] content, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(content, "content");
        for (int i5 = 0; i5 < i4; i5++) {
            encoder.x(getDescriptor(), i5, content[i5]);
        }
    }
}
