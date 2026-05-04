package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends o1 implements zg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f8144c = new g();

    public g() {
        super(ah.a.v(kotlin.jvm.internal.d.f14934a));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(boolean[] zArr) {
        kotlin.jvm.internal.t.f(zArr, "<this>");
        return zArr.length;
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public boolean[] r() {
        return new boolean[0];
    }

    @Override // dh.p, dh.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(ch.c decoder, int i10, f builder, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        builder.e(decoder.B(getDescriptor(), i10));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public f k(boolean[] zArr) {
        kotlin.jvm.internal.t.f(zArr, "<this>");
        return new f(zArr);
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(ch.d encoder, boolean[] content, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.C(getDescriptor(), i11, content[i11]);
        }
    }
}
