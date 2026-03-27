package y3;

import t3.T0;

/* JADX INFO: loaded from: classes3.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.i f15970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f15971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T0[] f15972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15973d;

    public N(Z2.i iVar, int i4) {
        this.f15970a = iVar;
        this.f15971b = new Object[i4];
        this.f15972c = new T0[i4];
    }

    public final void a(T0 t02, Object obj) {
        Object[] objArr = this.f15971b;
        int i4 = this.f15973d;
        objArr[i4] = obj;
        T0[] t0Arr = this.f15972c;
        this.f15973d = i4 + 1;
        kotlin.jvm.internal.r.d(t02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        t0Arr[i4] = t02;
    }

    public final void b(Z2.i iVar) {
        int length = this.f15972c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i4 = length - 1;
            T0 t02 = this.f15972c[length];
            kotlin.jvm.internal.r.c(t02);
            t02.e(iVar, this.f15971b[length]);
            if (i4 < 0) {
                return;
            } else {
                length = i4;
            }
        }
    }
}
