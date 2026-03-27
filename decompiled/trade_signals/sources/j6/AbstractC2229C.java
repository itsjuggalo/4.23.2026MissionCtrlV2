package j6;

import I6.S;
import O5.o;
import R5.InterfaceC0844a;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0855l;
import R5.InterfaceC0856m;
import R5.InterfaceC0868z;
import R5.c0;
import R5.g0;
import R5.t0;
import a6.C1086i;
import a6.T;
import j6.AbstractC2255s;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import u6.AbstractC2794i;
import y6.AbstractC2996e;
import z6.C3020d;
import z6.EnumC3021e;

/* JADX INFO: renamed from: j6.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2229C {
    public static final void a(StringBuilder sb, S s8) {
        sb.append(g(s8));
    }

    public static final String b(InterfaceC0868z interfaceC0868z, boolean z7, boolean z8) {
        String strB;
        AbstractC2304t.f(interfaceC0868z, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z8) {
            if (interfaceC0868z instanceof InterfaceC0855l) {
                strB = "<init>";
            } else {
                strB = interfaceC0868z.getName().b();
                AbstractC2304t.e(strB, "asString(...)");
            }
            sb.append(strB);
        }
        sb.append("(");
        c0 c0VarL0 = interfaceC0868z.l0();
        if (c0VarL0 != null) {
            S type = c0VarL0.getType();
            AbstractC2304t.e(type, "getType(...)");
            a(sb, type);
        }
        Iterator it = interfaceC0868z.k().iterator();
        while (it.hasNext()) {
            S type2 = ((t0) it.next()).getType();
            AbstractC2304t.e(type2, "getType(...)");
            a(sb, type2);
        }
        sb.append(")");
        if (z7) {
            if (AbstractC2246j.c(interfaceC0868z)) {
                sb.append("V");
            } else {
                S returnType = interfaceC0868z.getReturnType();
                AbstractC2304t.c(returnType);
                a(sb, returnType);
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String c(InterfaceC0868z interfaceC0868z, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = true;
        }
        if ((i8 & 2) != 0) {
            z8 = true;
        }
        return b(interfaceC0868z, z7, z8);
    }

    public static final String d(InterfaceC0844a interfaceC0844a) {
        AbstractC2304t.f(interfaceC0844a, "<this>");
        C2232F c2232f = C2232F.f20124a;
        if (AbstractC2794i.E(interfaceC0844a)) {
            return null;
        }
        InterfaceC0856m interfaceC0856mB = interfaceC0844a.b();
        InterfaceC0848e interfaceC0848e = interfaceC0856mB instanceof InterfaceC0848e ? (InterfaceC0848e) interfaceC0856mB : null;
        if (interfaceC0848e == null || interfaceC0848e.getName().m()) {
            return null;
        }
        InterfaceC0844a interfaceC0844aA = interfaceC0844a.a();
        g0 g0Var = interfaceC0844aA instanceof g0 ? (g0) interfaceC0844aA : null;
        if (g0Var == null) {
            return null;
        }
        return AbstractC2228B.a(c2232f, interfaceC0848e, c(g0Var, false, false, 3, null));
    }

    public static final boolean e(InterfaceC0844a f8) {
        InterfaceC0868z interfaceC0868zL;
        AbstractC2304t.f(f8, "f");
        if (!(f8 instanceof InterfaceC0868z)) {
            return false;
        }
        InterfaceC0868z interfaceC0868z = (InterfaceC0868z) f8;
        if (!AbstractC2304t.b(interfaceC0868z.getName().b(), "remove") || interfaceC0868z.k().size() != 1 || T.n((InterfaceC0845b) f8)) {
            return false;
        }
        List listK = interfaceC0868z.a().k();
        AbstractC2304t.e(listK, "getValueParameters(...)");
        S type = ((t0) p5.z.u0(listK)).getType();
        AbstractC2304t.e(type, "getType(...)");
        AbstractC2255s abstractC2255sG = g(type);
        AbstractC2255s.d dVar = abstractC2255sG instanceof AbstractC2255s.d ? (AbstractC2255s.d) abstractC2255sG : null;
        if ((dVar != null ? dVar.i() : null) != EnumC3021e.INT || (interfaceC0868zL = C1086i.l(interfaceC0868z)) == null) {
            return false;
        }
        List listK2 = interfaceC0868zL.a().k();
        AbstractC2304t.e(listK2, "getValueParameters(...)");
        S type2 = ((t0) p5.z.u0(listK2)).getType();
        AbstractC2304t.e(type2, "getType(...)");
        AbstractC2255s abstractC2255sG2 = g(type2);
        InterfaceC0856m interfaceC0856mB = interfaceC0868zL.b();
        AbstractC2304t.e(interfaceC0856mB, "getContainingDeclaration(...)");
        return AbstractC2304t.b(AbstractC2996e.p(interfaceC0856mB), o.a.f6173f0.i()) && (abstractC2255sG2 instanceof AbstractC2255s.c) && AbstractC2304t.b(((AbstractC2255s.c) abstractC2255sG2).i(), "java/lang/Object");
    }

    public static final String f(InterfaceC0848e interfaceC0848e) {
        AbstractC2304t.f(interfaceC0848e, "<this>");
        q6.b bVarN = Q5.c.f6732a.n(AbstractC2996e.o(interfaceC0848e).i());
        if (bVarN == null) {
            return AbstractC2246j.b(interfaceC0848e, null, 2, null);
        }
        String strH = C3020d.h(bVarN);
        AbstractC2304t.e(strH, "internalNameByClassId(...)");
        return strH;
    }

    public static final AbstractC2255s g(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return (AbstractC2255s) AbstractC2246j.e(s8, C2257u.f20231a, C2235I.f20130o, C2234H.f20125a, null, null, 32, null);
    }
}
