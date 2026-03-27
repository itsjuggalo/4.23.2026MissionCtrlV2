package A5;

import r5.S;
import r5.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends S {
    @Override // r5.S
    public boolean b() {
        return g().b();
    }

    @Override // r5.S
    public void c(l0 l0Var) {
        g().c(l0Var);
    }

    @Override // r5.S
    public void d(S.h hVar) {
        g().d(hVar);
    }

    @Override // r5.S
    public void e() {
        g().e();
    }

    public abstract S g();

    public String toString() {
        return H2.g.b(this).d("delegate", g()).toString();
    }
}
