package J6;

import I6.B0;
import I6.J0;
import I6.N0;
import I6.S;
import I6.v0;
import I6.w0;
import R5.InterfaceC0856m;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import v6.AbstractC2881e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A {
    public static final S a(S s8) {
        return (S) O6.c.b(s8).d();
    }

    public static final String b(v0 v0Var) {
        StringBuilder sb = new StringBuilder();
        c("type: " + v0Var, sb);
        c("hashCode: " + v0Var.hashCode(), sb);
        c("javaClass: " + v0Var.getClass().getCanonicalName(), sb);
        for (InterfaceC0856m interfaceC0856mS = v0Var.s(); interfaceC0856mS != null; interfaceC0856mS = interfaceC0856mS.b()) {
            c("fqName: " + t6.n.f23386h.M(interfaceC0856mS), sb);
            c("javaClass: " + interfaceC0856mS.getClass().getCanonicalName(), sb);
        }
        return sb.toString();
    }

    public static final StringBuilder c(String str, StringBuilder sb) {
        AbstractC2304t.f(str, "<this>");
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    public static final S d(S subtype, S supertype, x typeCheckingProcedureCallbacks) {
        AbstractC2304t.f(subtype, "subtype");
        AbstractC2304t.f(supertype, "supertype");
        AbstractC2304t.f(typeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new u(subtype, null));
        v0 v0VarO0 = supertype.O0();
        while (!arrayDeque.isEmpty()) {
            u uVarA = (u) arrayDeque.poll();
            S sB = uVarA.b();
            v0 v0VarO02 = sB.O0();
            if (typeCheckingProcedureCallbacks.a(v0VarO02, v0VarO0)) {
                boolean zP0 = sB.P0();
                while (true) {
                    uVarA = uVarA.a();
                    if (uVarA == null) {
                        break;
                    }
                    S sB2 = uVarA.b();
                    List listM0 = sB2.M0();
                    if ((listM0 instanceof Collection) && listM0.isEmpty()) {
                        sB = w0.f4488c.a(sB2).c().n(sB, N0.f4370e);
                        AbstractC2304t.c(sB);
                    } else {
                        Iterator it = listM0.iterator();
                        while (it.hasNext()) {
                            N0 n0B = ((B0) it.next()).b();
                            N0 n02 = N0.f4370e;
                            if (n0B != n02) {
                                S sN = AbstractC2881e.h(w0.f4488c.a(sB2), false, 1, null).c().n(sB, n02);
                                AbstractC2304t.e(sN, "safeSubstitute(...)");
                                sB = a(sN);
                                break;
                            }
                        }
                        sB = w0.f4488c.a(sB2).c().n(sB, N0.f4370e);
                        AbstractC2304t.c(sB);
                    }
                    zP0 = zP0 || sB2.P0();
                }
                v0 v0VarO03 = sB.O0();
                if (typeCheckingProcedureCallbacks.a(v0VarO03, v0VarO0)) {
                    return J0.p(sB, zP0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(v0VarO03) + ", \n\nsupertype: " + b(v0VarO0) + " \n" + typeCheckingProcedureCallbacks.a(v0VarO03, v0VarO0));
            }
            for (S s8 : v0VarO02.r()) {
                AbstractC2304t.c(s8);
                arrayDeque.add(new u(s8, uVarA));
            }
        }
        return null;
    }
}
