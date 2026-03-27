package r6;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f22836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22837b;

    public M(long[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22836a = bufferWithData;
        this.f22837b = bufferWithData.length;
        b(10);
    }

    @Override // r6.e0
    public void b(int i7) {
        long[] jArr = this.f22836a;
        if (jArr.length < i7) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, W5.l.b(i7, jArr.length * 2));
            kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
            this.f22836a = jArrCopyOf;
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22837b;
    }

    public final void e(long j7) {
        e0.c(this, 0, 1, null);
        long[] jArr = this.f22836a;
        int iD = d();
        this.f22837b = iD + 1;
        jArr[iD] = j7;
    }

    @Override // r6.e0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f22836a, d());
        kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
        return jArrCopyOf;
    }
}
