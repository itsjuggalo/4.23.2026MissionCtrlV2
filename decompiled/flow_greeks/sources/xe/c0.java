package xe;

import ce.o;
import fe.b1;
import fe.f1;
import fe.s1;
import java.util.Iterator;
import java.util.List;
import oe.s0;
import xe.s;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {
    public static final void a(StringBuilder sb2, r0 r0Var) {
        sb2.append(g(r0Var));
    }

    public static final String b(fe.z zVar, boolean z10, boolean z11) {
        String strB;
        kotlin.jvm.internal.t.f(zVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        if (z11) {
            if (zVar instanceof fe.l) {
                strB = "<init>";
            } else {
                strB = zVar.getName().b();
                kotlin.jvm.internal.t.e(strB, "asString(...)");
            }
            sb2.append(strB);
        }
        sb2.append("(");
        b1 b1VarK0 = zVar.k0();
        if (b1VarK0 != null) {
            r0 type = b1VarK0.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            a(sb2, type);
        }
        Iterator it = zVar.i().iterator();
        while (it.hasNext()) {
            r0 type2 = ((s1) it.next()).getType();
            kotlin.jvm.internal.t.e(type2, "getType(...)");
            a(sb2, type2);
        }
        sb2.append(")");
        if (z10) {
            if (j.c(zVar)) {
                sb2.append("V");
            } else {
                r0 returnType = zVar.getReturnType();
                kotlin.jvm.internal.t.c(returnType);
                a(sb2, returnType);
            }
        }
        return sb2.toString();
    }

    public static /* synthetic */ String c(fe.z zVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return b(zVar, z10, z11);
    }

    public static final String d(fe.a aVar) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        f0 f0Var = f0.f24840a;
        if (jf.i.E(aVar)) {
            return null;
        }
        fe.m mVarB = aVar.b();
        fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
        if (eVar == null || eVar.getName().l()) {
            return null;
        }
        fe.a aVarA = aVar.a();
        f1 f1Var = aVarA instanceof f1 ? (f1) aVarA : null;
        if (f1Var == null) {
            return null;
        }
        return b0.a(f0Var, eVar, c(f1Var, false, false, 3, null));
    }

    public static final boolean e(fe.a f10) {
        fe.z zVarL;
        kotlin.jvm.internal.t.f(f10, "f");
        if (!(f10 instanceof fe.z)) {
            return false;
        }
        fe.z zVar = (fe.z) f10;
        if (kotlin.jvm.internal.t.b(zVar.getName().b(), "remove") && zVar.i().size() == 1 && !s0.n((fe.b) f10)) {
            List listI = zVar.a().i();
            kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
            r0 type = ((s1) dd.a0.v0(listI)).getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            s sVarG = g(type);
            s.d dVar = sVarG instanceof s.d ? (s.d) sVarG : null;
            if ((dVar != null ? dVar.i() : null) != of.e.INT || (zVarL = oe.i.l(zVar)) == null) {
                return false;
            }
            List listI2 = zVarL.a().i();
            kotlin.jvm.internal.t.e(listI2, "getValueParameters(...)");
            r0 type2 = ((s1) dd.a0.v0(listI2)).getType();
            kotlin.jvm.internal.t.e(type2, "getType(...)");
            s sVarG2 = g(type2);
            fe.m mVarB = zVarL.b();
            kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.t.b(nf.e.p(mVarB), o.a.f3984f0.i()) && (sVarG2 instanceof s.c) && kotlin.jvm.internal.t.b(((s.c) sVarG2).i(), "java/lang/Object")) {
                return true;
            }
        }
        return false;
    }

    public static final String f(fe.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        ef.b bVarN = ee.c.f8681a.n(nf.e.o(eVar).i());
        if (bVarN == null) {
            return j.b(eVar, null, 2, null);
        }
        String strH = of.d.h(bVarN);
        kotlin.jvm.internal.t.e(strH, "internalNameByClassId(...)");
        return strH;
    }

    public static final s g(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        return (s) j.e(r0Var, u.f24924a, i0.f24873o, h0.f24868a, null, null, 32, null);
    }
}
