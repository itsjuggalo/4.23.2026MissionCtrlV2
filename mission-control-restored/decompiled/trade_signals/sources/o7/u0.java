package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f22211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22212b;

    public u0(short[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22211a = bufferWithData;
        this.f22212b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        short[] sArr = this.f22211a;
        if (sArr.length < i8) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, H5.i.b(i8, sArr.length * 2));
            AbstractC2304t.e(sArrCopyOf, "copyOf(...)");
            this.f22211a = sArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22212b;
    }

    public final void e(short s8) {
        AbstractC2520n0.c(this, 0, 1, null);
        short[] sArr = this.f22211a;
        int iD = d();
        this.f22212b = iD + 1;
        sArr[iD] = s8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f22211a, d());
        AbstractC2304t.e(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }
}
