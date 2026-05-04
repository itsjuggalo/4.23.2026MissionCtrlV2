package we;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.a2;
import xf.i2;
import xf.l2;
import xf.m2;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final re.e f23966a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xf.r0 f23967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23968b;

        public a(xf.r0 r0Var, int i10) {
            this.f23967a = r0Var;
            this.f23968b = i10;
        }

        public final int a() {
            return this.f23968b;
        }

        public final xf.r0 b() {
            return this.f23967a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xf.c1 f23969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f23971c;

        public b(xf.c1 c1Var, int i10, boolean z10) {
            this.f23969a = c1Var;
            this.f23970b = i10;
            this.f23971c = z10;
        }

        public final boolean a() {
            return this.f23971c;
        }

        public final int b() {
            return this.f23970b;
        }

        public final xf.c1 c() {
            return this.f23969a;
        }
    }

    public g(re.e javaResolverSettings) {
        kotlin.jvm.internal.t.f(javaResolverSettings, "javaResolverSettings");
        this.f23966a = javaResolverSettings;
    }

    public static /* synthetic */ b c(g gVar, xf.c1 c1Var, pd.k kVar, int i10, o1 o1Var, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        return gVar.b(c1Var, kVar, i10, o1Var, z10, z11);
    }

    public final xf.r0 a(xf.r0 r0Var, pd.k qualifiers, boolean z10) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        kotlin.jvm.internal.t.f(qualifiers, "qualifiers");
        return d(r0Var.Q0(), qualifiers, 0, z10).b();
    }

    public final b b(xf.c1 c1Var, pd.k kVar, int i10, o1 o1Var, boolean z10, boolean z11) {
        u1 u1VarN0;
        Boolean bool;
        a aVar;
        a2 a2VarS;
        pd.k kVar2 = kVar;
        boolean zA = p1.a(o1Var);
        boolean z12 = (z11 && z10) ? false : true;
        xf.r0 r0Var = null;
        if (!zA && c1Var.L0().isEmpty()) {
            return new b(null, 1, false);
        }
        fe.h hVarB = c1Var.N0().b();
        if (hVarB == null) {
            return new b(null, 1, false);
        }
        h hVar = (h) kVar2.invoke(Integer.valueOf(i10));
        fe.h hVarF = r1.f(hVarB, hVar, o1Var);
        Boolean boolH = r1.h(hVar, o1Var);
        if (hVarF == null || (u1VarN0 = hVarF.k()) == null) {
            u1VarN0 = c1Var.N0();
        }
        u1 u1Var = u1VarN0;
        int iA = i10 + 1;
        List listL0 = c1Var.L0();
        List parameters = u1Var.getParameters();
        kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
        Iterator it = listL0.iterator();
        Iterator it2 = parameters.iterator();
        ArrayList arrayList = new ArrayList(Math.min(dd.s.u(listL0, 10), dd.s.u(parameters, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            fe.l1 l1Var = (fe.l1) it2.next();
            a2 a2Var = (a2) next;
            if (z12) {
                bool = boolH;
                if (!a2Var.c()) {
                    aVar = d(a2Var.getType().Q0(), kVar2, iA, z11);
                } else if (((h) kVar2.invoke(Integer.valueOf(iA))).f() == k.f23992a) {
                    l2 l2VarQ0 = a2Var.getType().Q0();
                    aVar = new a(xf.u0.e(xf.l0.c(l2VarQ0).R0(false), xf.l0.d(l2VarQ0).R0(true)), 1);
                } else {
                    aVar = new a(null, 1);
                }
            } else {
                bool = boolH;
                aVar = new a(r0Var, 0);
            }
            iA += aVar.a();
            if (aVar.b() != null) {
                xf.r0 r0VarB = aVar.b();
                m2 m2VarB = a2Var.b();
                kotlin.jvm.internal.t.e(m2VarB, "getProjectionKind(...)");
                a2VarS = cg.d.k(r0VarB, m2VarB, l1Var);
            } else if (hVarF == null || a2Var.c()) {
                a2VarS = hVarF != null ? i2.s(l1Var) : null;
            } else {
                xf.r0 type = a2Var.getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                m2 m2VarB2 = a2Var.b();
                kotlin.jvm.internal.t.e(m2VarB2, "getProjectionKind(...)");
                a2VarS = cg.d.k(type, m2VarB2, l1Var);
            }
            arrayList.add(a2VarS);
            kVar2 = kVar;
            boolH = bool;
            r0Var = null;
        }
        Boolean bool2 = boolH;
        int i11 = iA - i10;
        if (hVarF == null && bool2 == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    if (((a2) it3.next()) == null) {
                    }
                }
            }
            return new b(null, i11, false);
        }
        ge.h annotations = c1Var.getAnnotations();
        f fVar = r1.f24037b;
        if (hVarF == null) {
            fVar = null;
        }
        xf.q1 q1VarB = xf.r1.b(r1.e(dd.r.p(annotations, fVar, bool2 != null ? r1.g() : null)));
        List listL02 = c1Var.L0();
        Iterator it4 = arrayList.iterator();
        Iterator it5 = listL02.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(dd.s.u(arrayList, 10), dd.s.u(listL02, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            a2 a2Var2 = (a2) it5.next();
            a2 a2Var3 = (a2) next2;
            if (a2Var3 != null) {
                a2Var2 = a2Var3;
            }
            arrayList2.add(a2Var2);
        }
        xf.c1 c1VarK = xf.u0.k(q1VarB, u1Var, arrayList2, bool2 != null ? bool2.booleanValue() : c1Var.O0(), null, 16, null);
        if (hVar.d()) {
            c1VarK = e(c1VarK);
        }
        return new b(c1VarK, i11, bool2 != null && hVar.g());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final we.g.a d(xf.l2 r21, pd.k r22, int r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: we.g.d(xf.l2, pd.k, int, boolean):we.g$a");
    }

    public final xf.c1 e(xf.c1 c1Var) {
        return this.f23966a.a() ? xf.g1.h(c1Var, true) : new j(c1Var);
    }
}
