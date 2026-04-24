package J3;

import java.util.Arrays;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class M extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f880b;

    public M(long[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f879a = bufferWithData;
        this.f880b = bufferWithData.length;
        b(10);
    }

    @Override // J3.e0
    public void b(int i4) {
        long[] jArr = this.f879a;
        if (jArr.length < i4) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, AbstractC1681l.b(i4, jArr.length * 2));
            kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
            this.f879a = jArrCopyOf;
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f880b;
    }

    public final void e(long j4) {
        e0.c(this, 0, 1, null);
        long[] jArr = this.f879a;
        int iD = d();
        this.f880b = iD + 1;
        jArr[iD] = j4;
    }

    @Override // J3.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f879a, d());
        kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
        return jArrCopyOf;
    }
}
