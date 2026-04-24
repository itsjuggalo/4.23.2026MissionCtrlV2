package T2;

import K2.AbstractC0358f;
import K2.C0353a;
import K2.S;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends S.i {
    @Override // K2.S.i
    public List b() {
        return j().b();
    }

    @Override // K2.S.i
    public C0353a c() {
        return j().c();
    }

    @Override // K2.S.i
    public AbstractC0358f d() {
        return j().d();
    }

    @Override // K2.S.i
    public Object e() {
        return j().e();
    }

    @Override // K2.S.i
    public void f() {
        j().f();
    }

    @Override // K2.S.i
    public void g() {
        j().g();
    }

    @Override // K2.S.i
    public void h(S.k kVar) {
        j().h(kVar);
    }

    @Override // K2.S.i
    public void i(List list) {
        j().i(list);
    }

    public abstract S.i j();

    public String toString() {
        return Z1.g.b(this).d("delegate", j()).toString();
    }
}
