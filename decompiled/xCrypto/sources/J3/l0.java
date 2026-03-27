package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f943b;

    public l0(short[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f942a = bufferWithData;
        this.f943b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        short[] sArr = this.f942a;
        if (sArr.length < i4) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, AbstractC1681l.b(i4, sArr.length * 2));
            kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
            this.f942a = sArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f943b;
    }

    public final void e(short s4) {
        e0.c(this, 0, 1, null);
        short[] sArr = this.f942a;
        int iD = d();
        this.f943b = iD + 1;
        sArr[iD] = s4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f942a, d());
        kotlin.jvm.internal.r.e(sArrCopyOf, "copyOf(this, newSize)");
        return sArrCopyOf;
    }
}
