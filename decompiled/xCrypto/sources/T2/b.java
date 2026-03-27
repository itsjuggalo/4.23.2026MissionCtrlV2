package T2;

import K2.S;
import K2.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends S {
    @Override // K2.S
    public boolean b() {
        return g().b();
    }

    @Override // K2.S
    public void c(l0 l0Var) {
        g().c(l0Var);
    }

    @Override // K2.S
    public void d(S.h hVar) {
        g().d(hVar);
    }

    @Override // K2.S
    public void e() {
        g().e();
    }

    public abstract S g();

    public String toString() {
        return Z1.g.b(this).d("delegate", g()).toString();
    }
}
