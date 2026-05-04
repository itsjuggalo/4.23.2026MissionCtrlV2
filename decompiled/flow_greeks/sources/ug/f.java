package ug;

import java.util.concurrent.Executor;
import ng.p1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends p1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f23022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f23023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f23024h = f0();

    public f(int i10, int i11, long j10, String str) {
        this.f23020d = i10;
        this.f23021e = i11;
        this.f23022f = j10;
        this.f23023g = str;
    }

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        a.H(this.f23024h, runnable, false, false, 6, null);
    }

    @Override // ng.p1
    public Executor e0() {
        return this.f23024h;
    }

    public final a f0() {
        return new a(this.f23020d, this.f23021e, this.f23022f, this.f23023g);
    }

    public final void g0(Runnable runnable, boolean z10, boolean z11) {
        this.f23024h.E(runnable, z10, z11);
    }
}
