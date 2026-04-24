package G4;

import G4.InterfaceC0551s;
import G4.Q0;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J implements InterfaceC0551s {
    @Override // G4.Q0
    public void a(Q0.a aVar) {
        e().a(aVar);
    }

    @Override // G4.InterfaceC0551s
    public void b(F4.X x8) {
        e().b(x8);
    }

    @Override // G4.InterfaceC0551s
    public void c(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
        e().c(j0Var, aVar, x8);
    }

    @Override // G4.Q0
    public void d() {
        e().d();
    }

    public abstract InterfaceC0551s e();

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", e()).toString();
    }
}
