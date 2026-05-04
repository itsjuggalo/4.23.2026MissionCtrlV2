package tb;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m0 extends rb.u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.u0 f21519a;

    public m0(rb.u0 u0Var) {
        this.f21519a = u0Var;
    }

    @Override // rb.d
    public String a() {
        return this.f21519a.a();
    }

    @Override // rb.d
    public rb.g e(rb.z0 z0Var, rb.c cVar) {
        return this.f21519a.e(z0Var, cVar);
    }

    @Override // rb.u0
    public boolean i(long j10, TimeUnit timeUnit) {
        return this.f21519a.i(j10, timeUnit);
    }

    @Override // rb.u0
    public void j() {
        this.f21519a.j();
    }

    @Override // rb.u0
    public rb.p k(boolean z10) {
        return this.f21519a.k(z10);
    }

    @Override // rb.u0
    public void l(rb.p pVar, Runnable runnable) {
        this.f21519a.l(pVar, runnable);
    }

    @Override // rb.u0
    public rb.u0 m() {
        return this.f21519a.m();
    }

    @Override // rb.u0
    public rb.u0 n() {
        return this.f21519a.n();
    }

    public String toString() {
        return p6.h.b(this).d("delegate", this.f21519a).toString();
    }
}
