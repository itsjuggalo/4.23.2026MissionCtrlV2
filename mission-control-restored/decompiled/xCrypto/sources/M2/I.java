package M2;

import K2.C0353a;
import K2.C0371t;
import K2.C0373v;
import K2.InterfaceC0366n;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class I implements r {
    @Override // M2.P0
    public void a(boolean z4) {
        k().a(z4);
    }

    @Override // M2.P0
    public void b(InterfaceC0366n interfaceC0366n) {
        k().b(interfaceC0366n);
    }

    @Override // M2.r
    public void c(K2.l0 l0Var) {
        k().c(l0Var);
    }

    @Override // M2.r
    public C0353a d() {
        return k().d();
    }

    @Override // M2.P0
    public void e(int i4) {
        k().e(i4);
    }

    @Override // M2.r
    public void f(int i4) {
        k().f(i4);
    }

    @Override // M2.P0
    public void flush() {
        k().flush();
    }

    @Override // M2.r
    public void g(int i4) {
        k().g(i4);
    }

    @Override // M2.r
    public void h(C0371t c0371t) {
        k().h(c0371t);
    }

    @Override // M2.r
    public void i(InterfaceC0443s interfaceC0443s) {
        k().i(interfaceC0443s);
    }

    @Override // M2.P0
    public boolean j() {
        return k().j();
    }

    public abstract r k();

    @Override // M2.r
    public void l(String str) {
        k().l(str);
    }

    @Override // M2.r
    public void m() {
        k().m();
    }

    @Override // M2.r
    public void n(Y y4) {
        k().n(y4);
    }

    @Override // M2.r
    public void o(C0373v c0373v) {
        k().o(c0373v);
    }

    @Override // M2.P0
    public void p(InputStream inputStream) {
        k().p(inputStream);
    }

    @Override // M2.P0
    public void q() {
        k().q();
    }

    @Override // M2.r
    public void r(boolean z4) {
        k().r(z4);
    }

    public String toString() {
        return Z1.g.b(this).d("delegate", k()).toString();
    }
}
