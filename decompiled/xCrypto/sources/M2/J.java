package M2;

import M2.InterfaceC0443s;
import M2.Q0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class J implements InterfaceC0443s {
    @Override // M2.Q0
    public void a(Q0.a aVar) {
        e().a(aVar);
    }

    @Override // M2.InterfaceC0443s
    public void b(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
        e().b(l0Var, aVar, z4);
    }

    @Override // M2.Q0
    public void c() {
        e().c();
    }

    @Override // M2.InterfaceC0443s
    public void d(K2.Z z4) {
        e().d(z4);
    }

    public abstract InterfaceC0443s e();

    public String toString() {
        return Z1.g.b(this).d("delegate", e()).toString();
    }
}
