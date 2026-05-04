package tb;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 implements r {
    @Override // tb.o2
    public void a(rb.n nVar) {
        m().a(nVar);
    }

    @Override // tb.o2
    public void b(int i10) {
        m().b(i10);
    }

    @Override // tb.r
    public void c(int i10) {
        m().c(i10);
    }

    @Override // tb.r
    public void d(int i10) {
        m().d(i10);
    }

    @Override // tb.r
    public void e(rb.k1 k1Var) {
        m().e(k1Var);
    }

    @Override // tb.o2
    public boolean f() {
        return m().f();
    }

    @Override // tb.o2
    public void flush() {
        m().flush();
    }

    @Override // tb.r
    public void g(rb.t tVar) {
        m().g(tVar);
    }

    @Override // tb.r
    public void h(String str) {
        m().h(str);
    }

    @Override // tb.r
    public void i() {
        m().i();
    }

    @Override // tb.r
    public void j(s sVar) {
        m().j(sVar);
    }

    @Override // tb.r
    public void k(rb.v vVar) {
        m().k(vVar);
    }

    @Override // tb.r
    public void l(x0 x0Var) {
        m().l(x0Var);
    }

    public abstract r m();

    @Override // tb.o2
    public void n(InputStream inputStream) {
        m().n(inputStream);
    }

    @Override // tb.o2
    public void o() {
        m().o();
    }

    @Override // tb.r
    public void p(boolean z10) {
        m().p(z10);
    }

    public String toString() {
        return p6.h.b(this).d("delegate", m()).toString();
    }
}
