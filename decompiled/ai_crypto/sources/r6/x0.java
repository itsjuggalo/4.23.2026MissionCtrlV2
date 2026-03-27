package r6;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f22954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22955b;

    public /* synthetic */ x0(long[] jArr, AbstractC2148j abstractC2148j) {
        this(jArr);
    }

    @Override // r6.e0
    public /* bridge */ /* synthetic */ Object a() {
        return E5.z.a(f());
    }

    @Override // r6.e0
    public void b(int i7) {
        if (E5.z.p(this.f22954a) < i7) {
            long[] jArr = this.f22954a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, W5.l.b(i7, E5.z.p(jArr) * 2));
            kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
            this.f22954a = E5.z.g(jArrCopyOf);
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22955b;
    }

    public final void e(long j7) {
        e0.c(this, 0, 1, null);
        long[] jArr = this.f22954a;
        int iD = d();
        this.f22955b = iD + 1;
        E5.z.t(jArr, iD, j7);
    }

    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.f22954a, d());
        kotlin.jvm.internal.r.e(jArrCopyOf, "copyOf(this, newSize)");
        return E5.z.g(jArrCopyOf);
    }

    public x0(long[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22954a = bufferWithData;
        this.f22955b = E5.z.p(bufferWithData);
        b(10);
    }
}
