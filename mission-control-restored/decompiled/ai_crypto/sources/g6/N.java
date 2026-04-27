package g6;

import b6.T0;

/* JADX INFO: loaded from: classes2.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.g f14284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f14285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T0[] f14286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14287d;

    public N(H5.g gVar, int i7) {
        this.f14284a = gVar;
        this.f14285b = new Object[i7];
        this.f14286c = new T0[i7];
    }

    public final void a(T0 t02, Object obj) {
        Object[] objArr = this.f14285b;
        int i7 = this.f14287d;
        objArr[i7] = obj;
        T0[] t0Arr = this.f14286c;
        this.f14287d = i7 + 1;
        kotlin.jvm.internal.r.d(t02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        t0Arr[i7] = t02;
    }

    public final void b(H5.g gVar) {
        int length = this.f14286c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i7 = length - 1;
            T0 t02 = this.f14286c[length];
            kotlin.jvm.internal.r.c(t02);
            t02.O(gVar, this.f14285b[length]);
            if (i7 < 0) {
                return;
            } else {
                length = i7;
            }
        }
    }
}
