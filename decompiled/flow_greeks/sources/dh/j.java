package dh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends o1 implements zg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f8161c = new j();

    public j() {
        super(ah.a.w(kotlin.jvm.internal.e.f14935a));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(byte[] bArr) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        return bArr.length;
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public byte[] r() {
        return new byte[0];
    }

    @Override // dh.p, dh.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(ch.c decoder, int i10, i builder, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        builder.e(decoder.r(getDescriptor(), i10));
    }

    @Override // dh.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public i k(byte[] bArr) {
        kotlin.jvm.internal.t.f(bArr, "<this>");
        return new i(bArr);
    }

    @Override // dh.o1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(ch.d encoder, byte[] content, int i10) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.E(getDescriptor(), i11, content[i11]);
        }
    }
}
