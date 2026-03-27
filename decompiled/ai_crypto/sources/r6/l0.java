package r6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f22899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22900b;

    public l0(short[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22899a = bufferWithData;
        this.f22900b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        short[] sArr = this.f22899a;
        if (sArr.length < i7) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, W5.l.b(i7, sArr.length * 2));
            kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
            this.f22899a = sArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22900b;
    }

    public final void e(short s7) {
        e0.c(this, 0, 1, null);
        short[] sArr = this.f22899a;
        int iD = d();
        this.f22900b = iD + 1;
        sArr[iD] = s7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f22899a, d());
        kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
        return sArrCopyOf;
    }
}
