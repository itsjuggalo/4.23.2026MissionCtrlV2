package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e2 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f8137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8138b;

    public /* synthetic */ e2(int[] iArr, kotlin.jvm.internal.k kVar) {
        this(iArr);
    }

    @Override // dh.m1
    public /* bridge */ /* synthetic */ Object a() {
        return cd.a0.a(f());
    }

    @Override // dh.m1
    public void b(int i10) {
        if (cd.a0.u(this.f8137a) < i10) {
            int[] iArr = this.f8137a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, vd.l.b(i10, cd.a0.u(iArr) * 2));
            kotlin.jvm.internal.t.e(iArrCopyOf, "copyOf(...)");
            this.f8137a = cd.a0.e(iArrCopyOf);
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8138b;
    }

    public final void e(int i10) {
        m1.c(this, 0, 1, null);
        int[] iArr = this.f8137a;
        int iD = d();
        this.f8138b = iD + 1;
        cd.a0.A(iArr, iD, i10);
    }

    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.f8137a, d());
        kotlin.jvm.internal.t.e(iArrCopyOf, "copyOf(...)");
        return cd.a0.e(iArrCopyOf);
    }

    public e2(int[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8137a = bufferWithData;
        this.f8138b = cd.a0.u(bufferWithData);
        b(10);
    }
}
