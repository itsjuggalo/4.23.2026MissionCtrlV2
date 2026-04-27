package J3;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f977b;

    public /* synthetic */ u0(int[] iArr, AbstractC1585j abstractC1585j) {
        this(iArr);
    }

    @Override // J3.e0
    public /* bridge */ /* synthetic */ Object a() {
        return W2.x.f(f());
    }

    @Override // J3.e0
    public void b(int i4) {
        if (W2.x.r(this.f976a) < i4) {
            int[] iArr = this.f976a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, AbstractC1681l.b(i4, W2.x.r(iArr) * 2));
            kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f976a = W2.x.k(iArrCopyOf);
        }
    }

    @Override // J3.e0
    public int d() {
        return this.f977b;
    }

    public final void e(int i4) {
        e0.c(this, 0, 1, null);
        int[] iArr = this.f976a;
        int iD = d();
        this.f977b = iD + 1;
        W2.x.v(iArr, iD, i4);
    }

    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.f976a, d());
        kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
        return W2.x.k(iArrCopyOf);
    }

    public u0(int[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f976a = bufferWithData;
        this.f977b = W2.x.r(bufferWithData);
        b(10);
    }
}
