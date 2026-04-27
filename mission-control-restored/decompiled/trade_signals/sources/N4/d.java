package N4;

import F4.AbstractC0492f;
import F4.C0487a;
import F4.P;
import java.util.List;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends P.i {
    @Override // F4.P.i
    public List b() {
        return j().b();
    }

    @Override // F4.P.i
    public C0487a c() {
        return j().c();
    }

    @Override // F4.P.i
    public AbstractC0492f d() {
        return j().d();
    }

    @Override // F4.P.i
    public Object e() {
        return j().e();
    }

    @Override // F4.P.i
    public void f() {
        j().f();
    }

    @Override // F4.P.i
    public void g() {
        j().g();
    }

    @Override // F4.P.i
    public void h(P.k kVar) {
        j().h(kVar);
    }

    @Override // F4.P.i
    public void i(List list) {
        j().i(list);
    }

    public abstract P.i j();

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", j()).toString();
    }
}
