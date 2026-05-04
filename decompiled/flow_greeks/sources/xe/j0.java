package xe;

import ee.c;
import java.util.Iterator;
import java.util.List;
import we.s1;
import xf.g2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {
    public static final Object a(t tVar, Object possiblyPrimitiveType, boolean z10) {
        kotlin.jvm.internal.t.f(tVar, "<this>");
        kotlin.jvm.internal.t.f(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z10 ? tVar.e(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    public static final Object b(g2 g2Var, bg.i type, t typeFactory, i0 mode) {
        List listI;
        kotlin.jvm.internal.t.f(g2Var, "<this>");
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(typeFactory, "typeFactory");
        kotlin.jvm.internal.t.f(mode, "mode");
        bg.n nVarB = g2Var.B(type);
        if (!g2Var.C0(nVarB)) {
            return null;
        }
        ce.l lVarJ = g2Var.j(nVarB);
        if (lVarJ != null) {
            return a(typeFactory, typeFactory.d(lVarJ), g2Var.D0(type) || s1.c(g2Var, type));
        }
        ce.l lVarW = g2Var.W(nVarB);
        if (lVarW != null) {
            return typeFactory.b('[' + of.e.b(lVarW).h());
        }
        if (g2Var.J(nVarB)) {
            ef.d dVarV = g2Var.V(nVarB);
            ef.b bVarN = dVarV != null ? ee.c.f8681a.n(dVarV) : null;
            if (bVarN != null) {
                if (!mode.a() && ((listI = ee.c.f8681a.i()) == null || !listI.isEmpty())) {
                    Iterator it = listI.iterator();
                    while (it.hasNext()) {
                        if (kotlin.jvm.internal.t.b(((c.a) it.next()).d(), bVarN)) {
                            return null;
                        }
                    }
                }
                String strH = of.d.h(bVarN);
                kotlin.jvm.internal.t.e(strH, "internalNameByClassId(...)");
                return typeFactory.c(strH);
            }
        }
        return null;
    }
}
