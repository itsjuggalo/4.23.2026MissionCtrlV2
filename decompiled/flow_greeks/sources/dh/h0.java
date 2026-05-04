package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f8151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8152b;

    public h0(int[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8151a = bufferWithData;
        this.f8152b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        int[] iArr = this.f8151a;
        if (iArr.length < i10) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, vd.l.b(i10, iArr.length * 2));
            kotlin.jvm.internal.t.e(iArrCopyOf, "copyOf(...)");
            this.f8151a = iArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8152b;
    }

    public final void e(int i10) {
        m1.c(this, 0, 1, null);
        int[] iArr = this.f8151a;
        int iD = d();
        this.f8152b = iD + 1;
        iArr[iD] = i10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f8151a, d());
        kotlin.jvm.internal.t.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }
}
