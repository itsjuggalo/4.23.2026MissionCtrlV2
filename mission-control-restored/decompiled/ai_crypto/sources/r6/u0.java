package r6;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f22933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22934b;

    public /* synthetic */ u0(int[] iArr, AbstractC2148j abstractC2148j) {
        this(iArr);
    }

    @Override // r6.e0
    public /* bridge */ /* synthetic */ Object a() {
        return E5.x.a(f());
    }

    @Override // r6.e0
    public void b(int i7) {
        if (E5.x.p(this.f22933a) < i7) {
            int[] iArr = this.f22933a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, W5.l.b(i7, E5.x.p(iArr) * 2));
            kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
            this.f22933a = E5.x.g(iArrCopyOf);
        }
    }

    @Override // r6.e0
    public int d() {
        return this.f22934b;
    }

    public final void e(int i7) {
        e0.c(this, 0, 1, null);
        int[] iArr = this.f22933a;
        int iD = d();
        this.f22934b = iD + 1;
        E5.x.t(iArr, iD, i7);
    }

    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.f22933a, d());
        kotlin.jvm.internal.r.e(iArrCopyOf, "copyOf(this, newSize)");
        return E5.x.g(iArrCopyOf);
    }

    public u0(int[] bufferWithData) {
        kotlin.jvm.internal.r.f(bufferWithData, "bufferWithData");
        this.f22933a = bufferWithData;
        this.f22934b = E5.x.p(bufferWithData);
        b(10);
    }
}
