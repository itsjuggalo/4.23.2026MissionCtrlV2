package N4;

import F4.AbstractC0497k;
import F4.C0487a;
import F4.X;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends AbstractC0497k {
    @Override // F4.m0
    public void a(int i8) {
        o().a(i8);
    }

    @Override // F4.m0
    public void b(int i8, long j8, long j9) {
        o().b(i8, j8, j9);
    }

    @Override // F4.m0
    public void c(long j8) {
        o().c(j8);
    }

    @Override // F4.m0
    public void d(long j8) {
        o().d(j8);
    }

    @Override // F4.m0
    public void e(int i8) {
        o().e(i8);
    }

    @Override // F4.m0
    public void f(int i8, long j8, long j9) {
        o().f(i8, j8, j9);
    }

    @Override // F4.m0
    public void g(long j8) {
        o().g(j8);
    }

    @Override // F4.m0
    public void h(long j8) {
        o().h(j8);
    }

    @Override // F4.AbstractC0497k
    public void j() {
        o().j();
    }

    @Override // F4.AbstractC0497k
    public void k() {
        o().k();
    }

    @Override // F4.AbstractC0497k
    public void l(X x8) {
        o().l(x8);
    }

    @Override // F4.AbstractC0497k
    public void m() {
        o().m();
    }

    @Override // F4.AbstractC0497k
    public void n(C0487a c0487a, X x8) {
        o().n(c0487a, x8);
    }

    public abstract AbstractC0497k o();

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", o()).toString();
    }
}
