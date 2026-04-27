package t5;

import t5.InterfaceC2698s;
import t5.Q0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J implements InterfaceC2698s {
    @Override // t5.Q0
    public void a(Q0.a aVar) {
        e().a(aVar);
    }

    @Override // t5.InterfaceC2698s
    public void b(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
        e().b(l0Var, aVar, z7);
    }

    @Override // t5.Q0
    public void c() {
        e().c();
    }

    @Override // t5.InterfaceC2698s
    public void d(r5.Z z7) {
        e().d(z7);
    }

    public abstract InterfaceC2698s e();

    public String toString() {
        return H2.g.b(this).d("delegate", e()).toString();
    }
}
