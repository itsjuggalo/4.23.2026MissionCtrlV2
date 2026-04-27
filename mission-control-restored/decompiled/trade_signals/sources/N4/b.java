package N4;

import F4.P;
import F4.j0;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends P {
    @Override // F4.P
    public boolean b() {
        return g().b();
    }

    @Override // F4.P
    public void c(j0 j0Var) {
        g().c(j0Var);
    }

    @Override // F4.P
    public void d(P.h hVar) {
        g().d(hVar);
    }

    @Override // F4.P
    public void e() {
        g().e();
    }

    public abstract P g();

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", g()).toString();
    }
}
