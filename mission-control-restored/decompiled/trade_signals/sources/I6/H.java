package I6;

import java.util.HashSet;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class H {
    public static final M6.i a(H0 h02, M6.i inlineClassType) {
        AbstractC2304t.f(h02, "<this>");
        AbstractC2304t.f(inlineClassType, "inlineClassType");
        return b(h02, inlineClassType, new HashSet());
    }

    public static final M6.i b(H0 h02, M6.i iVar, HashSet hashSet) {
        M6.i iVarB;
        M6.i iVarD0;
        M6.n nVarJ = h02.J(iVar);
        if (!hashSet.add(nVarJ)) {
            return null;
        }
        M6.o oVarC0 = h02.c0(nVarJ);
        if (oVarC0 != null) {
            M6.i iVarF0 = h02.F0(oVarC0);
            iVarB = b(h02, iVarF0, hashSet);
            if (iVarB == null) {
                return null;
            }
            boolean z7 = h02.y0(h02.J(iVarF0)) || ((iVarF0 instanceof M6.k) && h02.o0((M6.k) iVarF0));
            if ((iVarB instanceof M6.k) && h02.o0((M6.k) iVarB) && h02.l(iVar) && z7) {
                iVarD0 = h02.d0(iVarF0);
            } else if (!h02.l(iVarB) && h02.a0(iVar)) {
                iVarD0 = h02.d0(iVarB);
            }
            return iVarD0;
        }
        if (!h02.y0(nVarJ)) {
            return iVar;
        }
        M6.i iVarK = h02.K(iVar);
        if (iVarK == null || (iVarB = b(h02, iVarK, hashSet)) == null) {
            return null;
        }
        if (h02.l(iVar)) {
            return h02.l(iVarB) ? iVar : ((iVarB instanceof M6.k) && h02.o0((M6.k) iVarB)) ? iVar : h02.d0(iVarB);
        }
        return iVarB;
    }
}
