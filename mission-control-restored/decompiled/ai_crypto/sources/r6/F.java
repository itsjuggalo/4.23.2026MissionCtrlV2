package r6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f22828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22829b;

    public F(int[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22828a = bufferWithData;
        this.f22829b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        int[] iArr = this.f22828a;
        if (iArr.length < i7) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, W5.l.b(i7, iArr.length * 2));
            kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f22828a = iArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22829b;
    }

    public final void e(int i7) {
        e0.c(this, 0, 1, null);
        int[] iArr = this.f22828a;
        int iD = d();
        this.f22829b = iD + 1;
        iArr[iD] = i7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f22828a, d());
        kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
        return iArrCopyOf;
    }
}
