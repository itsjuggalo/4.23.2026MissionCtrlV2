package i6;

import b6.AbstractC1082m0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends AbstractC1082m0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f16472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f16473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f16474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f16475h = B0();

    public f(int i7, int i8, long j7, String str) {
        this.f16471d = i7;
        this.f16472e = i8;
        this.f16473f = j7;
        this.f16474g = str;
    }

    public final a B0() {
        return new a(this.f16471d, this.f16472e, this.f16473f, this.f16474g);
    }

    public final void C0(Runnable runnable, i iVar, boolean z7) {
        this.f16475h.M(runnable, iVar, z7);
    }

    @Override // b6.I
    public void y0(H5.g gVar, Runnable runnable) {
        a.O(this.f16475h, runnable, null, false, 6, null);
    }
}
