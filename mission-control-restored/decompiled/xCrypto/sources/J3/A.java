package J3;

/* JADX INFO: loaded from: classes3.dex */
public final class A extends g0 implements F3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final A f859c = new A();

    public A() {
        super(G3.a.z(kotlin.jvm.internal.l.f13430a));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(float[] fArr) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        return fArr.length;
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public float[] r() {
        return new float[0];
    }

    @Override // J3.AbstractC0343p, J3.AbstractC0324a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(I3.c decoder, int i4, C0352z builder, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        builder.e(decoder.E(getDescriptor(), i4));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public C0352z k(float[] fArr) {
        kotlin.jvm.internal.r.f(fArr, "<this>");
        return new C0352z(fArr);
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(I3.d encoder, float[] content, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(content, "content");
        for (int i5 = 0; i5 < i4; i5++) {
            encoder.t(getDescriptor(), i5, content[i5]);
        }
    }
}
