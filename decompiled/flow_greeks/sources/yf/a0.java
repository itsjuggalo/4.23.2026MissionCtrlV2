package yf;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import xf.a2;
import xf.i2;
import xf.m2;
import xf.r0;
import xf.u1;
import xf.v1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {
    public static final r0 a(r0 r0Var) {
        return (r0) dg.c.b(r0Var).d();
    }

    public static final String b(u1 u1Var) {
        StringBuilder sb2 = new StringBuilder();
        c("type: " + u1Var, sb2);
        c("hashCode: " + u1Var.hashCode(), sb2);
        c("javaClass: " + u1Var.getClass().getCanonicalName(), sb2);
        for (fe.m mVarB = u1Var.b(); mVarB != null; mVarB = mVarB.b()) {
            c("fqName: " + hf.n.f11354h.M(mVarB), sb2);
            c("javaClass: " + mVarB.getClass().getCanonicalName(), sb2);
        }
        return sb2.toString();
    }

    public static final StringBuilder c(String str, StringBuilder sb2) {
        kotlin.jvm.internal.t.f(str, "<this>");
        sb2.append(str);
        sb2.append('\n');
        return sb2;
    }

    public static final r0 d(r0 subtype, r0 supertype, x typeCheckingProcedureCallbacks) {
        kotlin.jvm.internal.t.f(subtype, "subtype");
        kotlin.jvm.internal.t.f(supertype, "supertype");
        kotlin.jvm.internal.t.f(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new u(subtype, null));
        u1 u1VarN0 = supertype.N0();
        while (!arrayDeque.isEmpty()) {
            u uVar = (u) arrayDeque.poll();
            r0 r0VarB = uVar.b();
            u1 u1VarN02 = r0VarB.N0();
            if (typeCheckingProcedureCallbacks.a(u1VarN02, u1VarN0)) {
                boolean zO0 = r0VarB.O0();
                for (u uVarA = uVar.a(); uVarA != null; uVarA = uVarA.a()) {
                    r0 r0VarB2 = uVarA.b();
                    List listL0 = r0VarB2.L0();
                    if (listL0 == null || !listL0.isEmpty()) {
                        Iterator it = listL0.iterator();
                        while (it.hasNext()) {
                            m2 m2VarB = ((a2) it.next()).b();
                            m2 m2Var = m2.f25015e;
                            if (m2VarB != m2Var) {
                                r0 r0VarN = kf.e.h(v1.f25085c.a(r0VarB2), false, 1, null).c().n(r0VarB, m2Var);
                                kotlin.jvm.internal.t.e(r0VarN, "safeSubstitute(...)");
                                r0VarB = a(r0VarN);
                                break;
                            }
                        }
                        r0VarB = v1.f25085c.a(r0VarB2).c().n(r0VarB, m2.f25015e);
                        kotlin.jvm.internal.t.c(r0VarB);
                    } else {
                        r0VarB = v1.f25085c.a(r0VarB2).c().n(r0VarB, m2.f25015e);
                        kotlin.jvm.internal.t.c(r0VarB);
                    }
                    zO0 = zO0 || r0VarB2.O0();
                }
                u1 u1VarN03 = r0VarB.N0();
                if (typeCheckingProcedureCallbacks.a(u1VarN03, u1VarN0)) {
                    return i2.p(r0VarB, zO0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(u1VarN03) + ", \n\nsupertype: " + b(u1VarN0) + " \n" + typeCheckingProcedureCallbacks.a(u1VarN03, u1VarN0));
            }
            for (r0 r0Var : u1VarN02.c()) {
                kotlin.jvm.internal.t.c(r0Var);
                arrayDeque.add(new u(r0Var, uVar));
            }
        }
        return null;
    }
}
