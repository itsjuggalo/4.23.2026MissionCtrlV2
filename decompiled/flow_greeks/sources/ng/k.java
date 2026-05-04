package ng;

import gd.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {
    public static final u0 a(n0 n0Var, gd.i iVar, p0 p0Var, pd.o oVar) {
        gd.i iVarK = i0.k(n0Var, iVar);
        v0 g2Var = p0Var.c() ? new g2(iVarK, oVar) : new v0(iVarK, true);
        g2Var.N0(p0Var, g2Var, oVar);
        return g2Var;
    }

    public static /* synthetic */ u0 b(n0 n0Var, gd.i iVar, p0 p0Var, pd.o oVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = gd.j.f10531a;
        }
        if ((i10 & 2) != 0) {
            p0Var = p0.f17167a;
        }
        return i.a(n0Var, iVar, p0Var, oVar);
    }

    public static final y1 c(n0 n0Var, gd.i iVar, p0 p0Var, pd.o oVar) {
        gd.i iVarK = i0.k(n0Var, iVar);
        r2 h2Var = p0Var.c() ? new h2(iVarK, oVar) : new r2(iVarK, true);
        h2Var.N0(p0Var, h2Var, oVar);
        return h2Var;
    }

    public static /* synthetic */ y1 d(n0 n0Var, gd.i iVar, p0 p0Var, pd.o oVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            iVar = gd.j.f10531a;
        }
        if ((i10 & 2) != 0) {
            p0Var = p0.f17167a;
        }
        return i.c(n0Var, iVar, p0Var, oVar);
    }

    public static final Object e(gd.i iVar, pd.o oVar, gd.e eVar) {
        Object objO0;
        gd.i context = eVar.getContext();
        gd.i iVarJ = i0.j(context, iVar);
        b2.g(iVarJ);
        if (iVarJ == context) {
            sg.z zVar = new sg.z(iVarJ, eVar);
            objO0 = tg.b.b(zVar, zVar, oVar);
        } else {
            f.b bVar = gd.f.K;
            if (kotlin.jvm.internal.t.b(iVarJ.get(bVar), context.get(bVar))) {
                a3 a3Var = new a3(iVarJ, eVar);
                gd.i context2 = a3Var.getContext();
                Object objI = sg.k0.i(context2, null);
                try {
                    Object objB = tg.b.b(a3Var, a3Var, oVar);
                    sg.k0.f(context2, objI);
                    objO0 = objB;
                } catch (Throwable th) {
                    sg.k0.f(context2, objI);
                    throw th;
                }
            } else {
                y0 y0Var = new y0(iVarJ, eVar);
                tg.a.c(oVar, y0Var, y0Var);
                objO0 = y0Var.O0();
            }
        }
        if (objO0 == hd.c.f()) {
            id.h.c(eVar);
        }
        return objO0;
    }
}
