package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f22200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22201b;

    public r(double[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22200a = bufferWithData;
        this.f22201b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        double[] dArr = this.f22200a;
        if (dArr.length < i8) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, H5.i.b(i8, dArr.length * 2));
            AbstractC2304t.e(dArrCopyOf, "copyOf(...)");
            this.f22200a = dArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22201b;
    }

    public final void e(double d8) {
        AbstractC2520n0.c(this, 0, 1, null);
        double[] dArr = this.f22200a;
        int iD = d();
        this.f22201b = iD + 1;
        dArr[iD] = d8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f22200a, d());
        AbstractC2304t.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }
}
