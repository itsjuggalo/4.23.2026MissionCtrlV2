package dg;

import cd.o;
import cd.q;
import ce.i;
import dd.a0;
import dd.s;
import fe.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kf.e;
import kotlin.jvm.internal.t;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.e2;
import xf.f2;
import xf.i2;
import xf.k2;
import xf.l0;
import xf.l2;
import xf.m2;
import xf.r0;
import xf.u0;
import xf.u1;
import xf.v1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8116a;

        static {
            int[] iArr = new int[m2.values().length];
            try {
                iArr[m2.f25015e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[m2.f25016f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[m2.f25017g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f8116a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends v1 {
        @Override // xf.v1
        public a2 k(u1 key) {
            t.f(key, "key");
            kf.b bVar = key instanceof kf.b ? (kf.b) key : null;
            if (bVar == null) {
                return null;
            }
            return bVar.e().c() ? new c2(m2.f25017g, bVar.e().getType()) : bVar.e();
        }
    }

    public static final dg.a b(r0 type) {
        Object objG;
        t.f(type, "type");
        if (l0.b(type)) {
            dg.a aVarB = b(l0.c(type));
            dg.a aVarB2 = b(l0.d(type));
            return new dg.a(k2.b(u0.e(l0.c((r0) aVarB.c()), l0.d((r0) aVarB2.c())), type), k2.b(u0.e(l0.c((r0) aVarB.d()), l0.d((r0) aVarB2.d())), type));
        }
        u1 u1VarN0 = type.N0();
        if (e.f(type)) {
            t.d(u1VarN0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            a2 a2VarE = ((kf.b) u1VarN0).e();
            r0 type2 = a2VarE.getType();
            t.e(type2, "getType(...)");
            r0 r0VarC = c(type2, type);
            int i10 = a.f8116a[a2VarE.b().ordinal()];
            if (i10 == 2) {
                return new dg.a(r0VarC, cg.d.n(type).J());
            }
            if (i10 == 3) {
                c1 c1VarI = cg.d.n(type).I();
                t.e(c1VarI, "getNothingType(...)");
                return new dg.a(c(c1VarI, type), r0VarC);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + a2VarE);
        }
        if (type.L0().isEmpty() || type.L0().size() != u1VarN0.getParameters().size()) {
            return new dg.a(type, type);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listL0 = type.L0();
        List parameters = u1VarN0.getParameters();
        t.e(parameters, "getParameters(...)");
        for (q qVar : a0.S0(listL0, parameters)) {
            a2 a2Var = (a2) qVar.a();
            l1 l1Var = (l1) qVar.b();
            t.c(l1Var);
            d dVarI = i(a2Var, l1Var);
            if (a2Var.c()) {
                arrayList.add(dVarI);
                arrayList2.add(dVarI);
            } else {
                dg.a aVarF = f(dVarI);
                d dVar = (d) aVarF.a();
                d dVar2 = (d) aVarF.b();
                arrayList.add(dVar);
                arrayList2.add(dVar2);
            }
        }
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!((d) it.next()).d()) {
                    z10 = true;
                    break;
                }
            }
        }
        if (z10) {
            objG = cg.d.n(type).I();
            t.e(objG, "getNothingType(...)");
        } else {
            objG = g(type, arrayList);
        }
        return new dg.a(objG, g(type, arrayList2));
    }

    public static final r0 c(r0 r0Var, r0 r0Var2) {
        r0 r0VarQ = i2.q(r0Var, r0Var2.O0());
        t.e(r0VarQ, "makeNullableIfNeeded(...)");
        return r0VarQ;
    }

    public static final a2 d(a2 a2Var, boolean z10) {
        if (a2Var == null) {
            return null;
        }
        if (!a2Var.c()) {
            r0 type = a2Var.getType();
            t.e(type, "getType(...)");
            if (i2.c(type, dg.b.f8115a)) {
                m2 m2VarB = a2Var.b();
                t.e(m2VarB, "getProjectionKind(...)");
                return m2VarB == m2.f25017g ? new c2(m2VarB, (r0) b(type).d()) : z10 ? new c2(m2VarB, (r0) b(type).c()) : h(a2Var);
            }
        }
        return a2Var;
    }

    public static final Boolean e(l2 l2Var) {
        t.c(l2Var);
        return Boolean.valueOf(e.f(l2Var));
    }

    public static final dg.a f(d dVar) {
        dg.a aVarB = b(dVar.a());
        r0 r0Var = (r0) aVarB.a();
        r0 r0Var2 = (r0) aVarB.b();
        dg.a aVarB2 = b(dVar.b());
        return new dg.a(new d(dVar.c(), r0Var2, (r0) aVarB2.a()), new d(dVar.c(), r0Var, (r0) aVarB2.b()));
    }

    public static final r0 g(r0 r0Var, List list) {
        r0Var.L0().size();
        list.size();
        ArrayList arrayList = new ArrayList(s.u(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(j((d) it.next()));
        }
        return e2.e(r0Var, arrayList, null, null, 6, null);
    }

    public static final a2 h(a2 a2Var) {
        f2 f2VarG = f2.g(new b());
        t.e(f2VarG, "create(...)");
        return f2VarG.t(a2Var);
    }

    public static final d i(a2 a2Var, l1 l1Var) {
        int i10 = a.f8116a[f2.c(l1Var.o(), a2Var).ordinal()];
        if (i10 == 1) {
            r0 type = a2Var.getType();
            t.e(type, "getType(...)");
            r0 type2 = a2Var.getType();
            t.e(type2, "getType(...)");
            return new d(l1Var, type, type2);
        }
        if (i10 == 2) {
            r0 type3 = a2Var.getType();
            t.e(type3, "getType(...)");
            c1 c1VarJ = nf.e.m(l1Var).J();
            t.e(c1VarJ, "getNullableAnyType(...)");
            return new d(l1Var, type3, c1VarJ);
        }
        if (i10 != 3) {
            throw new o();
        }
        c1 c1VarI = nf.e.m(l1Var).I();
        t.e(c1VarI, "getNothingType(...)");
        r0 type4 = a2Var.getType();
        t.e(type4, "getType(...)");
        return new d(l1Var, c1VarI, type4);
    }

    public static final a2 j(d dVar) {
        dVar.d();
        if (!t.b(dVar.a(), dVar.b())) {
            m2 m2VarO = dVar.c().o();
            m2 m2Var = m2.f25016f;
            if (m2VarO != m2Var) {
                return (!i.o0(dVar.a()) || dVar.c().o() == m2Var) ? i.q0(dVar.b()) ? new c2(k(dVar, m2Var), dVar.a()) : new c2(k(dVar, m2.f25017g), dVar.b()) : new c2(k(dVar, m2.f25017g), dVar.b());
            }
        }
        return new c2(dVar.a());
    }

    public static final m2 k(d dVar, m2 m2Var) {
        return m2Var == dVar.c().o() ? m2.f25015e : m2Var;
    }
}
