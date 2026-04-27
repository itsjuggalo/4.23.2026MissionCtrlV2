package t3;

import a3.AbstractC0787c;
import java.util.concurrent.CancellationException;
import y3.C1952f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class M {
    public static final L a(Z2.i iVar) {
        if (iVar.get(InterfaceC1846w0.f15039M) == null) {
            iVar = iVar.plus(C0.b(null, 1, null));
        }
        return new C1952f(iVar);
    }

    public static final L b() {
        return new C1952f(S0.b(null, 1, null).plus(C1803a0.c()));
    }

    public static final void c(L l4, String str, Throwable th) {
        d(l4, AbstractC1825l0.a(str, th));
    }

    public static final void d(L l4, CancellationException cancellationException) {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) l4.l().get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 != null) {
            interfaceC1846w0.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + l4).toString());
    }

    public static final Object e(i3.o oVar, Z2.e eVar) {
        y3.B b4 = new y3.B(eVar.getContext(), eVar);
        Object objB = z3.b.b(b4, b4, oVar);
        if (objB == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objB;
    }

    public static final void f(L l4) {
        A0.h(l4.l());
    }

    public static final boolean g(L l4) {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) l4.l().get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 != null) {
            return interfaceC1846w0.isActive();
        }
        return true;
    }
}
