package xf;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h0 {
    public static final bg.i a(g2 g2Var, bg.i inlineClassType) {
        kotlin.jvm.internal.t.f(g2Var, "<this>");
        kotlin.jvm.internal.t.f(inlineClassType, "inlineClassType");
        return b(g2Var, inlineClassType, new HashSet());
    }

    public static final bg.i b(g2 g2Var, bg.i iVar, HashSet hashSet) {
        bg.i iVarB;
        bg.n nVarB = g2Var.B(iVar);
        if (!hashSet.add(nVarB)) {
            return null;
        }
        bg.o oVarP0 = g2Var.p0(nVarB);
        if (oVarP0 != null) {
            bg.i iVarP = g2Var.P(oVarP0);
            bg.i iVarB2 = b(g2Var, iVarP, hashSet);
            if (iVarB2 != null) {
                return ((iVarB2 instanceof bg.k) && g2Var.u0((bg.k) iVarB2) && g2Var.D0(iVar) && (g2Var.w(g2Var.B(iVarP)) || ((iVarP instanceof bg.k) && g2Var.u0((bg.k) iVarP)))) ? g2Var.H0(iVarP) : (g2Var.D0(iVarB2) || !g2Var.n(iVar)) ? iVarB2 : g2Var.H0(iVarB2);
            }
            return null;
        }
        if (g2Var.w(nVarB)) {
            bg.i iVarI0 = g2Var.i0(iVar);
            if (iVarI0 == null || (iVarB = b(g2Var, iVarI0, hashSet)) == null) {
                return null;
            }
            if (!g2Var.D0(iVar)) {
                return iVarB;
            }
            if (!g2Var.D0(iVarB) && (!(iVarB instanceof bg.k) || !g2Var.u0((bg.k) iVarB))) {
                return g2Var.H0(iVarB);
            }
        }
        return iVar;
    }
}
