package A3;

import t3.AbstractC1827m0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends AbstractC1827m0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f86d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f87e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f88f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f89g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f90h = g0();

    public f(int i4, int i5, long j4, String str) {
        this.f86d = i4;
        this.f87e = i5;
        this.f88f = j4;
        this.f89g = str;
    }

    @Override // t3.I
    public void d0(Z2.i iVar, Runnable runnable) {
        a.J(this.f90h, runnable, null, false, 6, null);
    }

    public final a g0() {
        return new a(this.f86d, this.f87e, this.f88f, this.f89g);
    }

    public final void h0(Runnable runnable, i iVar, boolean z4) {
        this.f90h.G(runnable, iVar, z4);
    }
}
