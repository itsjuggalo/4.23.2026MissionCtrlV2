package A5;

import java.util.List;
import r5.AbstractC2590f;
import r5.C2585a;
import r5.S;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends S.i {
    @Override // r5.S.i
    public List b() {
        return j().b();
    }

    @Override // r5.S.i
    public C2585a c() {
        return j().c();
    }

    @Override // r5.S.i
    public AbstractC2590f d() {
        return j().d();
    }

    @Override // r5.S.i
    public Object e() {
        return j().e();
    }

    @Override // r5.S.i
    public void f() {
        j().f();
    }

    @Override // r5.S.i
    public void g() {
        j().g();
    }

    @Override // r5.S.i
    public void h(S.k kVar) {
        j().h(kVar);
    }

    @Override // r5.S.i
    public void i(List list) {
        j().i(list);
    }

    public abstract S.i j();

    public String toString() {
        return H2.g.b(this).d("delegate", j()).toString();
    }
}
