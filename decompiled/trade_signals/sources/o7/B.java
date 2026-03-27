package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class B extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f22095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22096b;

    public B(float[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22095a = bufferWithData;
        this.f22096b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        float[] fArr = this.f22095a;
        if (fArr.length < i8) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, H5.i.b(i8, fArr.length * 2));
            AbstractC2304t.e(fArrCopyOf, "copyOf(...)");
            this.f22095a = fArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22096b;
    }

    public final void e(float f8) {
        AbstractC2520n0.c(this, 0, 1, null);
        float[] fArr = this.f22095a;
        int iD = d();
        this.f22096b = iD + 1;
        fArr[iD] = f8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f22095a, d());
        AbstractC2304t.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }
}
