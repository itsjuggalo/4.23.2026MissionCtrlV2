package r6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f22921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22922b;

    public r(double[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22921a = bufferWithData;
        this.f22922b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        double[] dArr = this.f22921a;
        if (dArr.length < i7) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, W5.l.b(i7, dArr.length * 2));
            kotlin.jvm.internal.r.e(dArrCopyOf, "copyOf(this, newSize)");
            this.f22921a = dArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22922b;
    }

    public final void e(double d7) {
        e0.c(this, 0, 1, null);
        double[] dArr = this.f22921a;
        int iD = d();
        this.f22922b = iD + 1;
        dArr[iD] = d7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f22921a, d());
        kotlin.jvm.internal.r.e(dArrCopyOf, "copyOf(this, newSize)");
        return dArrCopyOf;
    }
}
