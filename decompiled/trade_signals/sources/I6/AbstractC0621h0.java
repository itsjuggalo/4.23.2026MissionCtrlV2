package I6;

import I6.C0644y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0621h0 {
    public static final C0606a a(S s8) {
        AbstractC2304t.f(s8, "<this>");
        M0 m0R0 = s8.R0();
        if (m0R0 instanceof C0606a) {
            return (C0606a) m0R0;
        }
        return null;
    }

    public static final AbstractC0613d0 b(S s8) {
        AbstractC2304t.f(s8, "<this>");
        C0606a c0606aA = a(s8);
        if (c0606aA != null) {
            return c0606aA.a1();
        }
        return null;
    }

    public static final boolean c(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return s8.R0() instanceof C0644y;
    }

    public static final Q d(Q q8) {
        S s8;
        Collection collectionR = q8.r();
        ArrayList arrayList = new ArrayList(p5.r.s(collectionR, 10));
        Iterator it = collectionR.iterator();
        boolean z7 = false;
        while (true) {
            s8 = null;
            if (!it.hasNext()) {
                break;
            }
            S sF = (S) it.next();
            if (J0.l(sF)) {
                sF = f(sF.R0(), false, 1, null);
                z7 = true;
            }
            arrayList.add(sF);
        }
        if (!z7) {
            return null;
        }
        S sI = q8.i();
        if (sI != null) {
            if (J0.l(sI)) {
                sI = f(sI.R0(), false, 1, null);
            }
            s8 = sI;
        }
        return new Q(arrayList).o(s8);
    }

    public static final M0 e(M0 m02, boolean z7) {
        AbstractC2304t.f(m02, "<this>");
        C0644y c0644yC = C0644y.a.c(C0644y.f4494d, m02, z7, false, 4, null);
        if (c0644yC != null) {
            return c0644yC;
        }
        AbstractC0613d0 abstractC0613d0G = g(m02);
        return abstractC0613d0G != null ? abstractC0613d0G : m02.S0(false);
    }

    public static /* synthetic */ M0 f(M0 m02, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return e(m02, z7);
    }

    public static final AbstractC0613d0 g(S s8) {
        Q qD;
        v0 v0VarO0 = s8.O0();
        Q q8 = v0VarO0 instanceof Q ? (Q) v0VarO0 : null;
        if (q8 == null || (qD = d(q8)) == null) {
            return null;
        }
        return qD.g();
    }

    public static final AbstractC0613d0 h(AbstractC0613d0 abstractC0613d0, boolean z7) {
        AbstractC2304t.f(abstractC0613d0, "<this>");
        C0644y c0644yC = C0644y.a.c(C0644y.f4494d, abstractC0613d0, z7, false, 4, null);
        if (c0644yC != null) {
            return c0644yC;
        }
        AbstractC0613d0 abstractC0613d0G = g(abstractC0613d0);
        return abstractC0613d0G == null ? abstractC0613d0.S0(false) : abstractC0613d0G;
    }

    public static /* synthetic */ AbstractC0613d0 i(AbstractC0613d0 abstractC0613d0, boolean z7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return h(abstractC0613d0, z7);
    }

    public static final AbstractC0613d0 j(AbstractC0613d0 abstractC0613d0, AbstractC0613d0 abbreviatedType) {
        AbstractC2304t.f(abstractC0613d0, "<this>");
        AbstractC2304t.f(abbreviatedType, "abbreviatedType");
        return W.a(abstractC0613d0) ? abstractC0613d0 : new C0606a(abstractC0613d0, abbreviatedType);
    }

    public static final J6.i k(J6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        return new J6.i(iVar.X0(), iVar.O0(), iVar.Z0(), iVar.N0(), iVar.P0(), true);
    }
}
