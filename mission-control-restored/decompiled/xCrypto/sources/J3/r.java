package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f965b;

    public r(double[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f964a = bufferWithData;
        this.f965b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        double[] dArr = this.f964a;
        if (dArr.length < i4) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, AbstractC1681l.b(i4, dArr.length * 2));
            kotlin.jvm.internal.r.e(dArrCopyOf, "copyOf(this, newSize)");
            this.f964a = dArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f965b;
    }

    public final void e(double d4) {
        e0.c(this, 0, 1, null);
        double[] dArr = this.f964a;
        int iD = d();
        this.f965b = iD + 1;
        dArr[iD] = d4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f964a, d());
        kotlin.jvm.internal.r.e(dArrCopyOf, "copyOf(this, newSize)");
        return dArrCopyOf;
    }
}
