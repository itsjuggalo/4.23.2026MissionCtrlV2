package fe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p1 {
    public static final w0 d(xf.r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        h hVarB = r0Var.N0().b();
        return e(r0Var, hVarB instanceof i ? (i) hVarB : null, 0);
    }

    public static final w0 e(xf.r0 r0Var, i iVar, int i10) {
        if (iVar == null || zf.l.m(iVar)) {
            return null;
        }
        int size = iVar.v().size() + i10;
        if (iVar.P()) {
            List listSubList = r0Var.L0().subList(i10, size);
            m mVarB = iVar.b();
            return new w0(iVar, listSubList, e(r0Var, mVarB instanceof i ? (i) mVarB : null, size));
        }
        if (size != r0Var.L0().size()) {
            jf.i.E(iVar);
        }
        return new w0(iVar, r0Var.L0().subList(i10, r0Var.L0().size()), null);
    }

    public static final c f(l1 l1Var, m mVar, int i10) {
        return new c(l1Var, mVar, i10);
    }

    public static final List g(i iVar) {
        List listK;
        Object next;
        xf.u1 u1VarK;
        kotlin.jvm.internal.t.f(iVar, "<this>");
        List listV = iVar.v();
        kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
        if (!iVar.P() && !(iVar.b() instanceof a)) {
            return listV;
        }
        List listM = jg.t.M(jg.t.C(jg.t.x(jg.t.K(nf.e.u(iVar), m1.f9500a), n1.f9501a), o1.f9502a));
        Iterator it = nf.e.u(iVar).iterator();
        while (true) {
            listK = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof e) {
                break;
            }
        }
        e eVar = (e) next;
        if (eVar != null && (u1VarK = eVar.k()) != null) {
            listK = u1VarK.getParameters();
        }
        if (listK == null) {
            listK = dd.r.k();
        }
        if (listM.isEmpty() && listK.isEmpty()) {
            List listV2 = iVar.v();
            kotlin.jvm.internal.t.e(listV2, "getDeclaredTypeParameters(...)");
            return listV2;
        }
        List<l1> listS0 = dd.a0.s0(listM, listK);
        ArrayList arrayList = new ArrayList(dd.s.u(listS0, 10));
        for (l1 l1Var : listS0) {
            kotlin.jvm.internal.t.c(l1Var);
            arrayList.add(f(l1Var, iVar, listV.size()));
        }
        return dd.a0.s0(listV, arrayList);
    }

    public static final boolean h(m it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it instanceof a;
    }

    public static final boolean i(m it) {
        kotlin.jvm.internal.t.f(it, "it");
        return !(it instanceof l);
    }

    public static final jg.h j(m it) {
        kotlin.jvm.internal.t.f(it, "it");
        List typeParameters = ((a) it).getTypeParameters();
        kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
        return dd.a0.Q(typeParameters);
    }
}
