package t3;

import a3.AbstractC0787c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class X0 {
    public static final V0 a(long j4, V v4, InterfaceC1846w0 interfaceC1846w0) {
        return new V0("Timed out waiting for " + j4 + " ms", interfaceC1846w0);
    }

    public static final Object b(W0 w02, i3.o oVar) {
        A0.g(w02, W.b(w02.f15953d.getContext()).a0(w02.f14969e, w02, w02.getContext()));
        return z3.b.c(w02, w02, oVar);
    }

    public static final Object c(long j4, i3.o oVar, Z2.e eVar) {
        if (j4 <= 0) {
            throw new V0("Timed out immediately");
        }
        Object objB = b(new W0(j4, eVar), oVar);
        if (objB == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objB;
    }
}
