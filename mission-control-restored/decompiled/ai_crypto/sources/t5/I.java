package t5;

import java.io.InputStream;
import r5.C2603t;
import r5.C2605v;
import r5.InterfaceC2598n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I implements r {
    @Override // t5.P0
    public void a(InterfaceC2598n interfaceC2598n) {
        f().a(interfaceC2598n);
    }

    @Override // t5.r
    public void b(r5.l0 l0Var) {
        f().b(l0Var);
    }

    @Override // t5.P0
    public boolean d() {
        return f().d();
    }

    @Override // t5.P0
    public void e(InputStream inputStream) {
        f().e(inputStream);
    }

    public abstract r f();

    @Override // t5.P0
    public void flush() {
        f().flush();
    }

    @Override // t5.P0
    public void g() {
        f().g();
    }

    @Override // t5.P0
    public void h(int i7) {
        f().h(i7);
    }

    @Override // t5.r
    public void i(int i7) {
        f().i(i7);
    }

    @Override // t5.r
    public void j(int i7) {
        f().j(i7);
    }

    @Override // t5.r
    public void k(Y y7) {
        f().k(y7);
    }

    @Override // t5.r
    public void l(String str) {
        f().l(str);
    }

    @Override // t5.r
    public void m() {
        f().m();
    }

    @Override // t5.r
    public void n(InterfaceC2698s interfaceC2698s) {
        f().n(interfaceC2698s);
    }

    @Override // t5.r
    public void o(C2605v c2605v) {
        f().o(c2605v);
    }

    @Override // t5.r
    public void p(C2603t c2603t) {
        f().p(c2603t);
    }

    @Override // t5.r
    public void q(boolean z7) {
        f().q(z7);
    }

    public String toString() {
        return H2.g.b(this).d("delegate", f()).toString();
    }
}
