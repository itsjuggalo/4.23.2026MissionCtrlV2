package yf;

import fe.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.a2;
import xf.c1;
import xf.f2;
import xf.l2;
import xf.m2;
import xf.r0;
import xf.u0;
import xf.v1;
import yf.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o {
    public static final List a(l2 l2Var, bg.b bVar) {
        if (l2Var.L0().size() != l2Var.N0().getParameters().size()) {
            return null;
        }
        List listL0 = l2Var.L0();
        if (listL0 == null || !listL0.isEmpty()) {
            Iterator it = listL0.iterator();
            while (it.hasNext()) {
                if (((a2) it.next()).b() != m2.f25015e) {
                    List parameters = l2Var.N0().getParameters();
                    kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
                    List<cd.q> listS0 = dd.a0.S0(listL0, parameters);
                    ArrayList arrayList = new ArrayList(dd.s.u(listS0, 10));
                    for (cd.q qVar : listS0) {
                        a2 a2VarD = (a2) qVar.a();
                        l1 l1Var = (l1) qVar.b();
                        if (a2VarD.b() != m2.f25015e) {
                            l2 l2VarQ0 = (a2VarD.c() || a2VarD.b() != m2.f25016f) ? null : a2VarD.getType().Q0();
                            kotlin.jvm.internal.t.c(l1Var);
                            a2VarD = cg.d.d(new i(bVar, l2VarQ0, a2VarD, l1Var));
                        }
                        arrayList.add(a2VarD);
                    }
                    f2 f2VarC = v1.f25085c.b(l2Var.N0(), arrayList).c();
                    int size = listL0.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        a2 a2Var = (a2) listL0.get(i10);
                        a2 a2Var2 = (a2) arrayList.get(i10);
                        if (a2Var.b() != m2.f25015e) {
                            List upperBounds = ((l1) l2Var.N0().getParameters().get(i10)).getUpperBounds();
                            kotlin.jvm.internal.t.e(upperBounds, "getUpperBounds(...)");
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(f.a.f25403a.a(f2VarC.n((r0) it2.next(), m2.f25015e).Q0()));
                            }
                            if (!a2Var.c() && a2Var.b() == m2.f25017g) {
                                arrayList2.add(f.a.f25403a.a(a2Var.getType().Q0()));
                            }
                            r0 type = a2Var2.getType();
                            kotlin.jvm.internal.t.d(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                            ((i) type).N0().n(arrayList2);
                        }
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }

    public static final c1 b(c1 type, bg.b status) {
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(status, "status");
        List listA = a(type, status);
        if (listA != null) {
            return c(type, listA);
        }
        return null;
    }

    public static final c1 c(l2 l2Var, List list) {
        return u0.k(l2Var.M0(), l2Var.N0(), list, l2Var.O0(), null, 16, null);
    }
}
