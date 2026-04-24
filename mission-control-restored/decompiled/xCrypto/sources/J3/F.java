package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class F extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f872b;

    public F(int[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f871a = bufferWithData;
        this.f872b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        int[] iArr = this.f871a;
        if (iArr.length < i4) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, AbstractC1681l.b(i4, iArr.length * 2));
            kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f871a = iArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f872b;
    }

    public final void e(int i4) {
        e0.c(this, 0, 1, null);
        int[] iArr = this.f871a;
        int iD = d();
        this.f872b = iD + 1;
        iArr[iD] = i4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f871a, d());
        kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
        return iArrCopyOf;
    }
}
