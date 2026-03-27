package G4;

import F4.AbstractC0497k;
import F4.C0487a;
import F4.C0489c;
import G4.InterfaceC0539l0;
import G4.InterfaceC0553t;
import java.util.concurrent.Executor;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class K implements InterfaceC0559w {
    public abstract InterfaceC0559w a();

    @Override // G4.InterfaceC0539l0
    public void b(F4.j0 j0Var) {
        a().b(j0Var);
    }

    @Override // G4.InterfaceC0559w
    public C0487a c() {
        return a().c();
    }

    @Override // G4.InterfaceC0553t
    public void d(InterfaceC0553t.a aVar, Executor executor) {
        a().d(aVar, executor);
    }

    @Override // G4.InterfaceC0553t
    public r e(F4.Y y7, F4.X x8, C0489c c0489c, AbstractC0497k[] abstractC0497kArr) {
        return a().e(y7, x8, c0489c, abstractC0497kArr);
    }

    @Override // G4.InterfaceC0539l0
    public void f(F4.j0 j0Var) {
        a().f(j0Var);
    }

    @Override // F4.N
    public F4.J h() {
        return a().h();
    }

    @Override // G4.InterfaceC0539l0
    public Runnable i(InterfaceC0539l0.a aVar) {
        return a().i(aVar);
    }

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", a()).toString();
    }
}
