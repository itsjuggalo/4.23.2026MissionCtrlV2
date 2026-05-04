package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f8209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8210b;

    public r(double[] bufferWithData) {
        kotlin.jvm.internal.t.f(bufferWithData, "bufferWithData");
        this.f8209a = bufferWithData;
        this.f8210b = bufferWithData.length;
        b(10);
    }

    @Override // dh.m1
    public void b(int i10) {
        double[] dArr = this.f8209a;
        if (dArr.length < i10) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, vd.l.b(i10, dArr.length * 2));
            kotlin.jvm.internal.t.e(dArrCopyOf, "copyOf(...)");
            this.f8209a = dArrCopyOf;
        }
    }

    @Override // dh.m1
    public int d() {
        return this.f8210b;
    }

    public final void e(double d10) {
        m1.c(this, 0, 1, null);
        double[] dArr = this.f8209a;
        int iD = d();
        this.f8210b = iD + 1;
        dArr[iD] = d10;
    }

    @Override // dh.m1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f8209a, d());
        kotlin.jvm.internal.t.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }
}
