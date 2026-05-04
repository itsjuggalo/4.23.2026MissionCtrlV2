package xf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import qf.k;
import xf.n1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f25002c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l1 f25003d = new l1(n1.a.f25026a, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f25004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f25005b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void b(int i10, fe.k1 k1Var) {
            if (i10 <= 100) {
                return;
            }
            throw new AssertionError("Too deep recursion while expanding type alias " + k1Var.getName());
        }

        public a() {
        }
    }

    public l1(n1 reportStrategy, boolean z10) {
        kotlin.jvm.internal.t.f(reportStrategy, "reportStrategy");
        this.f25004a = reportStrategy;
        this.f25005b = z10;
    }

    public final void a(ge.h hVar, ge.h hVar2) {
        HashSet hashSet = new HashSet();
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            hashSet.add(((ge.c) it.next()).e());
        }
        Iterator it2 = hVar2.iterator();
        while (it2.hasNext()) {
            ge.c cVar = (ge.c) it2.next();
            if (hashSet.contains(cVar.e())) {
                this.f25004a.a(cVar);
            }
        }
    }

    public final void b(r0 r0Var, r0 r0Var2) {
        f2 f2VarF = f2.f(r0Var2);
        kotlin.jvm.internal.t.e(f2VarF, "create(...)");
        int i10 = 0;
        for (Object obj : r0Var2.L0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            a2 a2Var = (a2) obj;
            if (!a2Var.c()) {
                r0 type = a2Var.getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                if (!cg.d.g(type)) {
                    a2 a2Var2 = (a2) r0Var.L0().get(i10);
                    fe.l1 l1Var = (fe.l1) r0Var.N0().getParameters().get(i10);
                    if (this.f25005b) {
                        n1 n1Var = this.f25004a;
                        r0 type2 = a2Var2.getType();
                        kotlin.jvm.internal.t.e(type2, "getType(...)");
                        r0 type3 = a2Var.getType();
                        kotlin.jvm.internal.t.e(type3, "getType(...)");
                        kotlin.jvm.internal.t.c(l1Var);
                        n1Var.b(f2VarF, type2, type3, l1Var);
                    }
                }
            }
            i10 = i11;
        }
    }

    public final c1 c(c1 c1Var, q1 q1Var) {
        return v0.a(c1Var) ? c1Var : e2.f(c1Var, null, g(c1Var, q1Var), 1, null);
    }

    public final c1 d(c1 c1Var, r0 r0Var) {
        c1 c1VarR = i2.r(c1Var, r0Var.O0());
        kotlin.jvm.internal.t.e(c1VarR, "makeNullableIfNeeded(...)");
        return c1VarR;
    }

    public final c1 e(c1 c1Var, r0 r0Var) {
        return c(d(c1Var, r0Var), r0Var.M0());
    }

    public final c1 f(m1 m1Var, q1 q1Var, boolean z10) {
        u1 u1VarK = m1Var.b().k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        return u0.m(q1Var, u1VarK, m1Var.a(), z10, k.b.f19087b);
    }

    public final q1 g(r0 r0Var, q1 q1Var) {
        return v0.a(r0Var) ? r0Var.M0() : q1Var.q(r0Var.M0());
    }

    public final c1 h(m1 typeAliasExpansion, q1 attributes) {
        kotlin.jvm.internal.t.f(typeAliasExpansion, "typeAliasExpansion");
        kotlin.jvm.internal.t.f(attributes, "attributes");
        return j(typeAliasExpansion, attributes, false, 0, true);
    }

    public final a2 i(a2 a2Var, m1 m1Var, int i10) {
        l2 l2VarQ0 = a2Var.getType().Q0();
        if (!e0.a(l2VarQ0)) {
            c1 c1VarA = e2.a(l2VarQ0);
            if (!v0.a(c1VarA) && cg.d.E(c1VarA)) {
                u1 u1VarN0 = c1VarA.N0();
                fe.h hVarB = u1VarN0.b();
                u1VarN0.getParameters().size();
                c1VarA.L0().size();
                if (!(hVarB instanceof fe.l1)) {
                    if (!(hVarB instanceof fe.k1)) {
                        c1 c1VarL = l(c1VarA, m1Var, i10);
                        b(c1VarA, c1VarL);
                        return new c2(a2Var.b(), c1VarL);
                    }
                    fe.k1 k1Var = (fe.k1) hVarB;
                    if (m1Var.d(k1Var)) {
                        this.f25004a.d(k1Var);
                        return new c2(m2.f25015e, zf.l.d(zf.k.f26534s, k1Var.getName().toString()));
                    }
                    List listL0 = c1VarA.L0();
                    ArrayList arrayList = new ArrayList(dd.s.u(listL0, 10));
                    int i11 = 0;
                    for (Object obj : listL0) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            dd.r.t();
                        }
                        arrayList.add(k((a2) obj, m1Var, (fe.l1) u1VarN0.getParameters().get(i11), i10 + 1));
                        i11 = i12;
                    }
                    c1 c1VarJ = j(m1.f25010e.a(m1Var, k1Var, arrayList), c1VarA.M0(), c1VarA.O0(), i10 + 1, false);
                    c1 c1VarL2 = l(c1VarA, m1Var, i10);
                    if (!e0.a(c1VarJ)) {
                        c1VarJ = g1.j(c1VarJ, c1VarL2);
                    }
                    return new c2(a2Var.b(), c1VarJ);
                }
            }
        }
        return a2Var;
    }

    public final c1 j(m1 m1Var, q1 q1Var, boolean z10, int i10, boolean z11) {
        a2 a2VarK = k(new c2(m2.f25015e, m1Var.b().f0()), m1Var, null, i10);
        r0 type = a2VarK.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        c1 c1VarA = e2.a(type);
        if (v0.a(c1VarA)) {
            return c1VarA;
        }
        a2VarK.b();
        a(c1VarA.getAnnotations(), t.a(q1Var));
        c1 c1VarR = i2.r(c(c1VarA, q1Var), z10);
        kotlin.jvm.internal.t.e(c1VarR, "let(...)");
        return z11 ? g1.j(c1VarR, f(m1Var, q1Var, z10)) : c1VarR;
    }

    public final a2 k(a2 a2Var, m1 m1Var, fe.l1 l1Var, int i10) {
        m2 m2VarO;
        m2 m2Var;
        m2 m2Var2;
        f25002c.b(i10, m1Var.b());
        if (a2Var.c()) {
            kotlin.jvm.internal.t.c(l1Var);
            a2 a2VarS = i2.s(l1Var);
            kotlin.jvm.internal.t.e(a2VarS, "makeStarProjection(...)");
            return a2VarS;
        }
        r0 type = a2Var.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        a2 a2VarC = m1Var.c(type.N0());
        if (a2VarC == null) {
            return i(a2Var, m1Var, i10);
        }
        if (a2VarC.c()) {
            kotlin.jvm.internal.t.c(l1Var);
            a2 a2VarS2 = i2.s(l1Var);
            kotlin.jvm.internal.t.e(a2VarS2, "makeStarProjection(...)");
            return a2VarS2;
        }
        l2 l2VarQ0 = a2VarC.getType().Q0();
        m2 m2VarB = a2VarC.b();
        kotlin.jvm.internal.t.e(m2VarB, "getProjectionKind(...)");
        m2 m2VarB2 = a2Var.b();
        kotlin.jvm.internal.t.e(m2VarB2, "getProjectionKind(...)");
        if (m2VarB2 != m2VarB && m2VarB2 != (m2Var2 = m2.f25015e)) {
            if (m2VarB == m2Var2) {
                m2VarB = m2VarB2;
            } else {
                this.f25004a.c(m1Var.b(), l1Var, l2VarQ0);
            }
        }
        if (l1Var == null || (m2VarO = l1Var.o()) == null) {
            m2VarO = m2.f25015e;
        }
        if (m2VarO != m2VarB && m2VarO != (m2Var = m2.f25015e)) {
            if (m2VarB == m2Var) {
                m2VarB = m2Var;
            } else {
                this.f25004a.c(m1Var.b(), l1Var, l2VarQ0);
            }
        }
        a(type.getAnnotations(), l2VarQ0.getAnnotations());
        return new c2(m2VarB, e(e2.a(l2VarQ0), type));
    }

    public final c1 l(c1 c1Var, m1 m1Var, int i10) {
        u1 u1VarN0 = c1Var.N0();
        List listL0 = c1Var.L0();
        ArrayList arrayList = new ArrayList(dd.s.u(listL0, 10));
        int i11 = 0;
        for (Object obj : listL0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                dd.r.t();
            }
            a2 a2Var = (a2) obj;
            a2 a2VarK = k(a2Var, m1Var, (fe.l1) u1VarN0.getParameters().get(i11), i10 + 1);
            if (!a2VarK.c()) {
                a2VarK = new c2(a2VarK.b(), i2.q(a2VarK.getType(), a2Var.getType().O0()));
            }
            arrayList.add(a2VarK);
            i11 = i12;
        }
        return e2.f(c1Var, arrayList, null, 2, null);
    }
}
