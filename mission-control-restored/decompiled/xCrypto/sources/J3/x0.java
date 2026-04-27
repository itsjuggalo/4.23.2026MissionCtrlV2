package J3;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f998b;

    public /* synthetic */ x0(long[] jArr, AbstractC1585j abstractC1585j) {
        this(jArr);
    }

    @Override // J3.e0
    public /* bridge */ /* synthetic */ Object a() {
        return W2.z.f(f());
    }

    @Override // J3.e0
    public void b(int i4) {
        if (W2.z.r(this.f997a) < i4) {
            long[] jArr = this.f997a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, AbstractC1681l.b(i4, W2.z.r(jArr) * 2));
            kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
            this.f997a = W2.z.k(jArrCopyOf);
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f998b;
    }

    public final void e(long j4) {
        e0.c(this, 0, 1, null);
        long[] jArr = this.f997a;
        int iD = d();
        this.f998b = iD + 1;
        W2.z.v(jArr, iD, j4);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.f997a, d());
        kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
        return W2.z.k(jArrCopyOf);
    }

    public x0(long[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f997a = bufferWithData;
        this.f998b = W2.z.r(bufferWithData);
        b(10);
    }
}
