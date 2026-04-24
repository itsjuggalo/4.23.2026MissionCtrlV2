package J3;

import kotlin.jvm.internal.C1581f;

/* JADX INFO: renamed from: J3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0341n extends g0 implements F3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0341n f947c = new C0341n();

    public C0341n() {
        super(G3.a.x(C1581f.f13420a));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(char[] cArr) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        return cArr.length;
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public char[] r() {
        return new char[0];
    }

    @Override // J3.AbstractC0343p, J3.AbstractC0324a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(I3.c decoder, int i4, C0340m builder, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        builder.e(decoder.x(getDescriptor(), i4));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public C0340m k(char[] cArr) {
        kotlin.jvm.internal.r.f(cArr, "<this>");
        return new C0340m(cArr);
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(I3.d encoder, char[] content, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(content, "content");
        for (int i5 = 0; i5 < i4; i5++) {
            encoder.A(getDescriptor(), i5, content[i5]);
        }
    }
}
