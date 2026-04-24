package J3;

import kotlin.jvm.internal.C1578c;

/* JADX INFO: renamed from: J3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0334g extends g0 implements F3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0334g f927c = new C0334g();

    public C0334g() {
        super(G3.a.v(C1578c.f13417a));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(boolean[] zArr) {
        kotlin.jvm.internal.r.f(zArr, "<this>");
        return zArr.length;
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public boolean[] r() {
        return new boolean[0];
    }

    @Override // J3.AbstractC0343p, J3.AbstractC0324a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(I3.c decoder, int i4, C0333f builder, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        builder.e(decoder.n(getDescriptor(), i4));
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public C0333f k(boolean[] zArr) {
        kotlin.jvm.internal.r.f(zArr, "<this>");
        return new C0333f(zArr);
    }

    @Override // J3.g0
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(I3.d encoder, boolean[] content, int i4) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(content, "content");
        for (int i5 = 0; i5 < i4; i5++) {
            encoder.y(getDescriptor(), i5, content[i5]);
        }
    }
}
