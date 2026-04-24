package t3;

import Z2.f;
import a3.AbstractC0787c;

/* JADX INFO: renamed from: t3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC1822k {
    public static final T a(L l4, Z2.i iVar, N n4, i3.o oVar) {
        Z2.i iVarE = H.e(l4, iVar);
        U g02 = n4.g() ? new G0(iVarE, oVar) : new U(iVarE, true);
        g02.N0(n4, g02, oVar);
        return g02;
    }

    public static /* synthetic */ T b(L l4, Z2.i iVar, N n4, i3.o oVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            iVar = Z2.j.f6012a;
        }
        if ((i4 & 2) != 0) {
            n4 = N.DEFAULT;
        }
        return AbstractC1818i.a(l4, iVar, n4, oVar);
    }

    public static final InterfaceC1846w0 c(L l4, Z2.i iVar, N n4, i3.o oVar) {
        Z2.i iVarE = H.e(l4, iVar);
        Q0 h02 = n4.g() ? new H0(iVarE, oVar) : new Q0(iVarE, true);
        h02.N0(n4, h02, oVar);
        return h02;
    }

    public static /* synthetic */ InterfaceC1846w0 d(L l4, Z2.i iVar, N n4, i3.o oVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            iVar = Z2.j.f6012a;
        }
        if ((i4 & 2) != 0) {
            n4 = N.DEFAULT;
        }
        return AbstractC1818i.c(l4, iVar, n4, oVar);
    }

    public static final Object e(Z2.i iVar, i3.o oVar, Z2.e eVar) throws Throwable {
        Object objO0;
        Z2.i context = eVar.getContext();
        Z2.i iVarD = H.d(context, iVar);
        A0.h(iVarD);
        if (iVarD == context) {
            y3.B b4 = new y3.B(iVarD, eVar);
            objO0 = z3.b.b(b4, b4, oVar);
        } else {
            f.b bVar = Z2.f.f6010J;
            if (kotlin.jvm.internal.r.b(iVarD.get(bVar), context.get(bVar))) {
                Z0 z02 = new Z0(iVarD, eVar);
                Z2.i context2 = z02.getContext();
                Object objC = y3.J.c(context2, null);
                try {
                    Object objB = z3.b.b(z02, z02, oVar);
                    y3.J.a(context2, objC);
                    objO0 = objB;
                } catch (Throwable th) {
                    y3.J.a(context2, objC);
                    throw th;
                }
            } else {
                X x4 = new X(iVarD, eVar);
                z3.a.d(oVar, x4, x4, null, 4, null);
                objO0 = x4.O0();
            }
        }
        if (objO0 == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objO0;
    }
}
