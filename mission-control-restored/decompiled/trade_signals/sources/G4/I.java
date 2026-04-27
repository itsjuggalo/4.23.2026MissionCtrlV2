package G4;

import F4.C0505t;
import F4.C0507v;
import F4.InterfaceC0500n;
import java.io.InputStream;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I implements r {
    @Override // G4.r
    public void a(F4.j0 j0Var) {
        n().a(j0Var);
    }

    @Override // G4.P0
    public void b(InterfaceC0500n interfaceC0500n) {
        n().b(interfaceC0500n);
    }

    @Override // G4.P0
    public boolean d() {
        return n().d();
    }

    @Override // G4.P0
    public void e(int i8) {
        n().e(i8);
    }

    @Override // G4.r
    public void f(int i8) {
        n().f(i8);
    }

    @Override // G4.P0
    public void flush() {
        n().flush();
    }

    @Override // G4.r
    public void g(int i8) {
        n().g(i8);
    }

    @Override // G4.r
    public void h(C0505t c0505t) {
        n().h(c0505t);
    }

    @Override // G4.r
    public void i(InterfaceC0551s interfaceC0551s) {
        n().i(interfaceC0551s);
    }

    @Override // G4.r
    public void j(String str) {
        n().j(str);
    }

    @Override // G4.r
    public void k() {
        n().k();
    }

    @Override // G4.r
    public void l(C0507v c0507v) {
        n().l(c0507v);
    }

    @Override // G4.r
    public void m(Y y7) {
        n().m(y7);
    }

    public abstract r n();

    @Override // G4.P0
    public void o(InputStream inputStream) {
        n().o(inputStream);
    }

    @Override // G4.P0
    public void p() {
        n().p();
    }

    @Override // G4.r
    public void q(boolean z7) {
        n().q(z7);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", n()).toString();
    }
}
