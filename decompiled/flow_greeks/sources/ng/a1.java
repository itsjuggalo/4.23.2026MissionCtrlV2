package ng;

import cd.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a1 {
    public static final void a(z0 z0Var, int i10) {
        gd.e eVarD = z0Var.d();
        boolean z10 = i10 == 4;
        if (z10 || !(eVarD instanceof sg.h) || b(i10) != b(z0Var.f17199c)) {
            d(z0Var, eVarD, z10);
            return;
        }
        sg.h hVar = (sg.h) eVarD;
        k0 k0Var = hVar.f20390d;
        gd.i context = hVar.getContext();
        if (k0Var.a0(context)) {
            k0Var.Z(context, z0Var);
        } else {
            e(z0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final void d(z0 z0Var, gd.e eVar, boolean z10) {
        Object objG;
        Object objL = z0Var.l();
        Throwable thE = z0Var.e(objL);
        if (thE != null) {
            r.a aVar = cd.r.f3870b;
            objG = cd.s.a(thE);
        } else {
            r.a aVar2 = cd.r.f3870b;
            objG = z0Var.g(objL);
        }
        Object objB = cd.r.b(objG);
        if (!z10) {
            eVar.resumeWith(objB);
            return;
        }
        kotlin.jvm.internal.t.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        sg.h hVar = (sg.h) eVar;
        gd.e eVar2 = hVar.f20391e;
        Object obj = hVar.f20393g;
        gd.i context = eVar2.getContext();
        Object objI = sg.k0.i(context, obj);
        a3 a3VarM = objI != sg.k0.f20405a ? i0.m(eVar2, context, objI) : null;
        try {
            hVar.f20391e.resumeWith(objB);
            cd.h0 h0Var = cd.h0.f3852a;
            if (a3VarM == null || a3VarM.O0()) {
                sg.k0.f(context, objI);
            }
        } catch (Throwable th) {
            if (a3VarM == null || a3VarM.O0()) {
                sg.k0.f(context, objI);
            }
            throw th;
        }
    }

    public static final void e(z0 z0Var) {
        i1 i1VarB = v2.f17190a.b();
        if (i1VarB.l0()) {
            i1VarB.h0(z0Var);
            return;
        }
        i1VarB.j0(true);
        try {
            d(z0Var, z0Var.d(), true);
            do {
            } while (i1VarB.o0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
