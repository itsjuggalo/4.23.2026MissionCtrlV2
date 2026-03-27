package M2;

import K2.AbstractC0363k;
import K2.C0353a;
import K2.C0355c;
import M2.InterfaceC0431l0;
import M2.InterfaceC0445t;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class K implements InterfaceC0451w {
    public abstract InterfaceC0451w a();

    @Override // M2.InterfaceC0431l0
    public void b(K2.l0 l0Var) {
        a().b(l0Var);
    }

    @Override // M2.InterfaceC0445t
    public r c(K2.a0 a0Var, K2.Z z4, C0355c c0355c, AbstractC0363k[] abstractC0363kArr) {
        return a().c(a0Var, z4, c0355c, abstractC0363kArr);
    }

    @Override // M2.InterfaceC0451w
    public C0353a d() {
        return a().d();
    }

    @Override // M2.InterfaceC0431l0
    public void e(K2.l0 l0Var) {
        a().e(l0Var);
    }

    @Override // M2.InterfaceC0445t
    public void f(InterfaceC0445t.a aVar, Executor executor) {
        a().f(aVar, executor);
    }

    @Override // K2.P
    public K2.K h() {
        return a().h();
    }

    @Override // M2.InterfaceC0431l0
    public Runnable i(InterfaceC0431l0.a aVar) {
        return a().i(aVar);
    }

    public String toString() {
        return Z1.g.b(this).d("delegate", a()).toString();
    }
}
