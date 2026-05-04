package tb;

import rb.b1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 extends rb.b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.b1 f21545a;

    public n0(rb.b1 b1Var) {
        p6.n.o(b1Var, "delegate can not be null");
        this.f21545a = b1Var;
    }

    @Override // rb.b1
    public String a() {
        return this.f21545a.a();
    }

    @Override // rb.b1
    public void b() {
        this.f21545a.b();
    }

    @Override // rb.b1
    public void c() {
        this.f21545a.c();
    }

    @Override // rb.b1
    public void d(b1.d dVar) {
        this.f21545a.d(dVar);
    }

    public String toString() {
        return p6.h.b(this).d("delegate", this.f21545a).toString();
    }
}
