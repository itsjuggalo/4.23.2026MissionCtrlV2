package cg;

import cd.o;
import dd.a0;
import dd.g0;
import dd.s;
import fe.e;
import fe.f;
import fe.i;
import fe.k1;
import fe.l1;
import ge.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.t;
import pd.k;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.e2;
import xf.i0;
import xf.i2;
import xf.j1;
import xf.k2;
import xf.l2;
import xf.m2;
import xf.r0;
import xf.r1;
import xf.u0;
import xf.u1;
import xf.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final r0 A(r0 r0Var) {
        t.f(r0Var, "<this>");
        r0 r0VarN = i2.n(r0Var);
        t.e(r0VarN, "makeNotNullable(...)");
        return r0VarN;
    }

    public static final r0 B(r0 r0Var) {
        t.f(r0Var, "<this>");
        r0 r0VarO = i2.o(r0Var);
        t.e(r0VarO, "makeNullable(...)");
        return r0VarO;
    }

    public static final r0 C(r0 r0Var, h newAnnotations) {
        t.f(r0Var, "<this>");
        t.f(newAnnotations, "newAnnotations");
        return (r0Var.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? r0Var : r0Var.Q0().T0(r1.a(r0Var.M0(), newAnnotations));
    }

    public static final r0 D(r0 r0Var) {
        l2 l2VarF;
        t.f(r0Var, "<this>");
        l2 l2VarQ0 = r0Var.Q0();
        if (l2VarQ0 instanceof i0) {
            i0 i0Var = (i0) l2VarQ0;
            c1 c1VarV0 = i0Var.V0();
            if (!c1VarV0.N0().getParameters().isEmpty() && c1VarV0.N0().b() != null) {
                List parameters = c1VarV0.N0().getParameters();
                t.e(parameters, "getParameters(...)");
                ArrayList arrayList = new ArrayList(s.u(parameters, 10));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new j1((l1) it.next()));
                }
                c1VarV0 = e2.f(c1VarV0, arrayList, null, 2, null);
            }
            c1 c1VarW0 = i0Var.W0();
            if (!c1VarW0.N0().getParameters().isEmpty() && c1VarW0.N0().b() != null) {
                List parameters2 = c1VarW0.N0().getParameters();
                t.e(parameters2, "getParameters(...)");
                ArrayList arrayList2 = new ArrayList(s.u(parameters2, 10));
                Iterator it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new j1((l1) it2.next()));
                }
                c1VarW0 = e2.f(c1VarW0, arrayList2, null, 2, null);
            }
            l2VarF = u0.e(c1VarV0, c1VarW0);
        } else {
            if (!(l2VarQ0 instanceof c1)) {
                throw new o();
            }
            c1 c1Var = (c1) l2VarQ0;
            boolean zIsEmpty = c1Var.N0().getParameters().isEmpty();
            l2VarF = c1Var;
            if (!zIsEmpty) {
                fe.h hVarB = c1Var.N0().b();
                l2VarF = c1Var;
                if (hVarB != null) {
                    List parameters3 = c1Var.N0().getParameters();
                    t.e(parameters3, "getParameters(...)");
                    ArrayList arrayList3 = new ArrayList(s.u(parameters3, 10));
                    Iterator it3 = parameters3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new j1((l1) it3.next()));
                    }
                    l2VarF = e2.f(c1Var, arrayList3, null, 2, null);
                }
            }
        }
        return k2.b(l2VarF, l2VarQ0);
    }

    public static final boolean E(r0 r0Var) {
        t.f(r0Var, "<this>");
        return e(r0Var, c.f4143a);
    }

    public static final boolean F(l2 it) {
        t.f(it, "it");
        fe.h hVarB = it.N0().b();
        if (hVarB != null) {
            return (hVarB instanceof k1) || (hVarB instanceof l1);
        }
        return false;
    }

    public static final a2 d(r0 r0Var) {
        t.f(r0Var, "<this>");
        return new c2(r0Var);
    }

    public static final boolean e(r0 r0Var, k predicate) {
        t.f(r0Var, "<this>");
        t.f(predicate, "predicate");
        return i2.c(r0Var, predicate);
    }

    public static final boolean f(r0 r0Var, u1 u1Var, Set set) {
        boolean zF;
        if (t.b(r0Var.N0(), u1Var)) {
            return true;
        }
        fe.h hVarB = r0Var.N0().b();
        i iVar = hVarB instanceof i ? (i) hVarB : null;
        List listV = iVar != null ? iVar.v() : null;
        Iterable<g0> iterableQ0 = a0.Q0(r0Var.L0());
        if ((iterableQ0 instanceof Collection) && ((Collection) iterableQ0).isEmpty()) {
            return false;
        }
        for (g0 g0Var : iterableQ0) {
            int iA = g0Var.a();
            a2 a2Var = (a2) g0Var.b();
            l1 l1Var = listV != null ? (l1) a0.c0(listV, iA) : null;
            if ((l1Var == null || set == null || !set.contains(l1Var)) && !a2Var.c()) {
                r0 type = a2Var.getType();
                t.e(type, "getType(...)");
                zF = f(type, u1Var, set);
            } else {
                zF = false;
            }
            if (zF) {
                return true;
            }
        }
        return false;
    }

    public static final boolean g(r0 r0Var) {
        t.f(r0Var, "<this>");
        return e(r0Var, b.f4142a);
    }

    public static final boolean h(l2 it) {
        t.f(it, "it");
        fe.h hVarB = it.N0().b();
        if (hVarB != null) {
            return x(hVarB);
        }
        return false;
    }

    public static final boolean i(r0 r0Var) {
        t.f(r0Var, "<this>");
        return i2.c(r0Var, a.f4141a);
    }

    public static final Boolean j(l2 l2Var) {
        return Boolean.valueOf(i2.m(l2Var));
    }

    public static final a2 k(r0 type, m2 projectionKind, l1 l1Var) {
        t.f(type, "type");
        t.f(projectionKind, "projectionKind");
        if ((l1Var != null ? l1Var.o() : null) == projectionKind) {
            projectionKind = m2.f25015e;
        }
        return new c2(projectionKind, type);
    }

    public static final Set l(r0 r0Var, Set set) {
        t.f(r0Var, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m(r0Var, r0Var, linkedHashSet, set);
        return linkedHashSet;
    }

    public static final void m(r0 r0Var, r0 r0Var2, Set set, Set set2) {
        fe.h hVarB = r0Var.N0().b();
        if (hVarB instanceof l1) {
            if (!t.b(r0Var.N0(), r0Var2.N0())) {
                set.add(hVarB);
                return;
            }
            for (r0 r0Var3 : ((l1) hVarB).getUpperBounds()) {
                t.c(r0Var3);
                m(r0Var3, r0Var2, set, set2);
            }
            return;
        }
        fe.h hVarB2 = r0Var.N0().b();
        i iVar = hVarB2 instanceof i ? (i) hVarB2 : null;
        List listV = iVar != null ? iVar.v() : null;
        int i10 = 0;
        for (a2 a2Var : r0Var.L0()) {
            int i11 = i10 + 1;
            l1 l1Var = listV != null ? (l1) a0.c0(listV, i10) : null;
            if ((l1Var == null || set2 == null || !set2.contains(l1Var)) && !a2Var.c() && !a0.R(set, a2Var.getType().N0().b()) && !t.b(a2Var.getType().N0(), r0Var2.N0())) {
                r0 type = a2Var.getType();
                t.e(type, "getType(...)");
                m(type, r0Var2, set, set2);
            }
            i10 = i11;
        }
    }

    public static final ce.i n(r0 r0Var) {
        t.f(r0Var, "<this>");
        ce.i iVarP = r0Var.N0().p();
        t.e(iVarP, "getBuiltIns(...)");
        return iVarP;
    }

    public static final r0 o(l1 l1Var) {
        Object obj;
        t.f(l1Var, "<this>");
        List upperBounds = l1Var.getUpperBounds();
        t.e(upperBounds, "getUpperBounds(...)");
        upperBounds.isEmpty();
        List upperBounds2 = l1Var.getUpperBounds();
        t.e(upperBounds2, "getUpperBounds(...)");
        Iterator it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            fe.h hVarB = ((r0) next).N0().b();
            e eVar = hVarB instanceof e ? (e) hVarB : null;
            if (eVar != null && eVar.h() != f.f9474c && eVar.h() != f.f9477f) {
                obj = next;
                break;
            }
        }
        r0 r0Var = (r0) obj;
        if (r0Var != null) {
            return r0Var;
        }
        List upperBounds3 = l1Var.getUpperBounds();
        t.e(upperBounds3, "getUpperBounds(...)");
        Object objZ = a0.Z(upperBounds3);
        t.e(objZ, "first(...)");
        return (r0) objZ;
    }

    public static final boolean p(l1 typeParameter) {
        t.f(typeParameter, "typeParameter");
        return r(typeParameter, null, null, 6, null);
    }

    public static final boolean q(l1 typeParameter, u1 u1Var, Set set) {
        t.f(typeParameter, "typeParameter");
        List<r0> upperBounds = typeParameter.getUpperBounds();
        t.e(upperBounds, "getUpperBounds(...)");
        if (upperBounds != null && upperBounds.isEmpty()) {
            return false;
        }
        for (r0 r0Var : upperBounds) {
            t.c(r0Var);
            if (f(r0Var, typeParameter.s().N0(), set) && (u1Var == null || t.b(r0Var.N0(), u1Var))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean r(l1 l1Var, u1 u1Var, Set set, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            u1Var = null;
        }
        if ((i10 & 4) != 0) {
            set = null;
        }
        return q(l1Var, u1Var, set);
    }

    public static final boolean s(r0 r0Var) {
        t.f(r0Var, "<this>");
        return ce.i.g0(r0Var);
    }

    public static final boolean t(r0 r0Var) {
        t.f(r0Var, "<this>");
        return ce.i.o0(r0Var);
    }

    public static final boolean u(r0 r0Var) {
        t.f(r0Var, "<this>");
        if (!(r0Var instanceof y)) {
            return false;
        }
        ((y) r0Var).Z0();
        return false;
    }

    public static final boolean v(r0 r0Var) {
        t.f(r0Var, "<this>");
        if (!(r0Var instanceof y)) {
            return false;
        }
        ((y) r0Var).Z0();
        return false;
    }

    public static final boolean w(r0 r0Var, r0 superType) {
        t.f(r0Var, "<this>");
        t.f(superType, "superType");
        return yf.e.f25402a.c(r0Var, superType);
    }

    public static final boolean x(fe.h hVar) {
        t.f(hVar, "<this>");
        return (hVar instanceof l1) && (((l1) hVar).b() instanceof k1);
    }

    public static final boolean y(r0 r0Var) {
        t.f(r0Var, "<this>");
        return i2.m(r0Var);
    }

    public static final boolean z(r0 type) {
        t.f(type, "type");
        return (type instanceof zf.i) && ((zf.i) type).X0().c();
    }
}
