package t5;

import java.util.concurrent.Executor;
import r5.AbstractC2595k;
import r5.C2585a;
import r5.C2587c;
import t5.InterfaceC2686l0;
import t5.InterfaceC2700t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K implements InterfaceC2706w {
    public abstract InterfaceC2706w a();

    @Override // t5.InterfaceC2700t
    public void b(InterfaceC2700t.a aVar, Executor executor) {
        a().b(aVar, executor);
    }

    @Override // t5.InterfaceC2706w
    public C2585a c() {
        return a().c();
    }

    @Override // t5.InterfaceC2686l0
    public void d(r5.l0 l0Var) {
        a().d(l0Var);
    }

    @Override // t5.InterfaceC2686l0
    public Runnable e(InterfaceC2686l0.a aVar) {
        return a().e(aVar);
    }

    @Override // t5.InterfaceC2700t
    public r f(r5.a0 a0Var, r5.Z z7, C2587c c2587c, AbstractC2595k[] abstractC2595kArr) {
        return a().f(a0Var, z7, c2587c, abstractC2595kArr);
    }

    @Override // r5.P
    public r5.K h() {
        return a().h();
    }

    @Override // t5.InterfaceC2686l0
    public void i(r5.l0 l0Var) {
        a().i(l0Var);
    }

    public String toString() {
        return H2.g.b(this).d("delegate", a()).toString();
    }
}
