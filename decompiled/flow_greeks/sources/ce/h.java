package ce;

import cd.w;
import ce.o;
import dd.a0;
import dd.n0;
import dd.o0;
import de.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import lf.x;
import xf.a2;
import xf.c1;
import xf.r0;
import xf.r1;
import xf.u0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final int a(r0 r0Var) {
        t.f(r0Var, "<this>");
        ge.c cVarB = r0Var.getAnnotations().b(o.a.D);
        if (cVarB == null) {
            return 0;
        }
        lf.g gVar = (lf.g) o0.i(cVarB.a(), o.f3963q);
        t.d(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number) ((lf.n) gVar).b()).intValue();
    }

    public static final c1 b(i builtIns, ge.h annotations, r0 r0Var, List contextReceiverTypes, List parameterTypes, List list, r0 returnType, boolean z10) {
        t.f(builtIns, "builtIns");
        t.f(annotations, "annotations");
        t.f(contextReceiverTypes, "contextReceiverTypes");
        t.f(parameterTypes, "parameterTypes");
        t.f(returnType, "returnType");
        List listG = g(r0Var, contextReceiverTypes, parameterTypes, list, returnType, builtIns);
        fe.e eVarF = f(builtIns, parameterTypes.size() + contextReceiverTypes.size() + (r0Var == null ? 0 : 1), z10);
        if (r0Var != null) {
            annotations = u(annotations, builtIns);
        }
        if (!contextReceiverTypes.isEmpty()) {
            annotations = t(annotations, builtIns, contextReceiverTypes.size());
        }
        return u0.h(r1.b(annotations), eVarF, listG);
    }

    public static final ef.f d(r0 r0Var) {
        String str;
        t.f(r0Var, "<this>");
        ge.c cVarB = r0Var.getAnnotations().b(o.a.E);
        if (cVarB == null) {
            return null;
        }
        Object objW0 = a0.w0(cVarB.a().values());
        x xVar = objW0 instanceof x ? (x) objW0 : null;
        if (xVar != null && (str = (String) xVar.b()) != null) {
            if (!ef.f.m(str)) {
                str = null;
            }
            if (str != null) {
                return ef.f.k(str);
            }
        }
        return null;
    }

    public static final List e(r0 r0Var) {
        t.f(r0Var, "<this>");
        p(r0Var);
        int iA = a(r0Var);
        if (iA == 0) {
            return dd.r.k();
        }
        List listSubList = r0Var.L0().subList(0, iA);
        ArrayList arrayList = new ArrayList(dd.s.u(listSubList, 10));
        Iterator it = listSubList.iterator();
        while (it.hasNext()) {
            arrayList.add(((a2) it.next()).getType());
        }
        return arrayList;
    }

    public static final fe.e f(i builtIns, int i10, boolean z10) {
        t.f(builtIns, "builtIns");
        fe.e eVarY = z10 ? builtIns.Y(i10) : builtIns.D(i10);
        t.c(eVarY);
        return eVarY;
    }

    public static final List g(r0 r0Var, List contextReceiverTypes, List parameterTypes, List list, r0 returnType, i builtIns) {
        ef.f fVar;
        i iVar;
        t.f(contextReceiverTypes, "contextReceiverTypes");
        t.f(parameterTypes, "parameterTypes");
        t.f(returnType, "returnType");
        t.f(builtIns, "builtIns");
        int i10 = 0;
        ArrayList arrayList = new ArrayList(parameterTypes.size() + contextReceiverTypes.size() + (r0Var != null ? 1 : 0) + 1);
        ArrayList arrayList2 = new ArrayList(dd.s.u(contextReceiverTypes, 10));
        Iterator it = contextReceiverTypes.iterator();
        while (it.hasNext()) {
            arrayList2.add(cg.d.d((r0) it.next()));
        }
        arrayList.addAll(arrayList2);
        hg.a.a(arrayList, r0Var != null ? cg.d.d(r0Var) : null);
        for (Object obj : parameterTypes) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            r0 r0VarC = (r0) obj;
            if (list == null || (fVar = (ef.f) list.get(i10)) == null || fVar.l()) {
                fVar = null;
            }
            if (fVar != null) {
                ef.c cVar = o.a.E;
                ef.f fVar2 = o.f3959m;
                String strB = fVar.b();
                t.e(strB, "asString(...)");
                Map mapE = n0.e(w.a(fVar2, new x(strB)));
                iVar = builtIns;
                r0VarC = cg.d.C(r0VarC, ge.h.L.a(a0.r0(r0VarC.getAnnotations(), new ge.l(iVar, cVar, mapE, false, 8, null))));
            } else {
                iVar = builtIns;
            }
            arrayList.add(cg.d.d(r0VarC));
            i10 = i11;
            builtIns = iVar;
        }
        arrayList.add(cg.d.d(returnType));
        return arrayList;
    }

    public static final de.f h(ef.d dVar) {
        if (!dVar.f() || dVar.e()) {
            return null;
        }
        de.g gVarA = de.g.f8073c.a();
        ef.c cVarD = dVar.m().d();
        String strB = dVar.j().b();
        t.e(strB, "asString(...)");
        return gVarA.b(cVarD, strB);
    }

    public static final de.f i(fe.m mVar) {
        t.f(mVar, "<this>");
        if ((mVar instanceof fe.e) && i.C0(mVar)) {
            return h(nf.e.p(mVar));
        }
        return null;
    }

    public static final de.f j(r0 r0Var) {
        t.f(r0Var, "<this>");
        fe.h hVarB = r0Var.N0().b();
        if (hVarB != null) {
            return i(hVarB);
        }
        return null;
    }

    public static final r0 k(r0 r0Var) {
        t.f(r0Var, "<this>");
        p(r0Var);
        if (!s(r0Var)) {
            return null;
        }
        return ((a2) r0Var.L0().get(a(r0Var))).getType();
    }

    public static final r0 l(r0 r0Var) {
        t.f(r0Var, "<this>");
        p(r0Var);
        r0 type = ((a2) a0.k0(r0Var.L0())).getType();
        t.e(type, "getType(...)");
        return type;
    }

    public static final List m(r0 r0Var) {
        t.f(r0Var, "<this>");
        p(r0Var);
        return r0Var.L0().subList(a(r0Var) + (n(r0Var) ? 1 : 0), r0.size() - 1);
    }

    public static final boolean n(r0 r0Var) {
        t.f(r0Var, "<this>");
        return p(r0Var) && s(r0Var);
    }

    public static final boolean o(fe.m mVar) {
        t.f(mVar, "<this>");
        de.f fVarI = i(mVar);
        return t.b(fVarI, f.a.f8069e) || t.b(fVarI, f.d.f8072e);
    }

    public static final boolean p(r0 r0Var) {
        t.f(r0Var, "<this>");
        fe.h hVarB = r0Var.N0().b();
        return hVarB != null && o(hVarB);
    }

    public static final boolean q(r0 r0Var) {
        t.f(r0Var, "<this>");
        return t.b(j(r0Var), f.a.f8069e);
    }

    public static final boolean r(r0 r0Var) {
        t.f(r0Var, "<this>");
        return t.b(j(r0Var), f.d.f8072e);
    }

    public static final boolean s(r0 r0Var) {
        return r0Var.getAnnotations().b(o.a.C) != null;
    }

    public static final ge.h t(ge.h hVar, i builtIns, int i10) {
        t.f(hVar, "<this>");
        t.f(builtIns, "builtIns");
        ef.c cVar = o.a.D;
        return hVar.E(cVar) ? hVar : ge.h.L.a(a0.r0(hVar, new ge.l(builtIns, cVar, n0.e(w.a(o.f3963q, new lf.n(i10))), false, 8, null)));
    }

    public static final ge.h u(ge.h hVar, i builtIns) {
        t.f(hVar, "<this>");
        t.f(builtIns, "builtIns");
        ef.c cVar = o.a.C;
        return hVar.E(cVar) ? hVar : ge.h.L.a(a0.r0(hVar, new ge.l(builtIns, cVar, o0.h(), false, 8, null)));
    }
}
