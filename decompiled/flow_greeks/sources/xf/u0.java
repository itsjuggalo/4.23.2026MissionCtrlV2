package xf;

import java.util.List;
import xf.n1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f25079a = new u0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pd.k f25080b = a.f25081a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f25081a = new a();

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(yf.g gVar) {
            kotlin.jvm.internal.t.f(gVar, "<unused var>");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c1 f25082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u1 f25083b;

        public b(c1 c1Var, u1 u1Var) {
            this.f25082a = c1Var;
            this.f25083b = u1Var;
        }

        public final c1 a() {
            return this.f25082a;
        }

        public final u1 b() {
            return this.f25083b;
        }
    }

    public static final c1 c(fe.k1 k1Var, List arguments) {
        kotlin.jvm.internal.t.f(k1Var, "<this>");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        return new l1(n1.a.f25026a, false).h(m1.f25010e.a(null, k1Var, arguments), q1.f25042b.k());
    }

    public static final l2 e(c1 lowerBound, c1 upperBound) {
        kotlin.jvm.internal.t.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.t.f(upperBound, "upperBound");
        return kotlin.jvm.internal.t.b(lowerBound, upperBound) ? lowerBound : new j0(lowerBound, upperBound);
    }

    public static final c1 f(q1 attributes, lf.q constructor, boolean z10) {
        kotlin.jvm.internal.t.f(attributes, "attributes");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        return m(attributes, constructor, dd.r.k(), z10, zf.l.a(zf.h.f26478c, true, "unknown integer literal type"));
    }

    public static final c1 h(q1 attributes, fe.e descriptor, List arguments) {
        kotlin.jvm.internal.t.f(attributes, "attributes");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        u1 u1VarK = descriptor.k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        return k(attributes, u1VarK, arguments, false, null, 16, null);
    }

    public static final c1 i(q1 attributes, u1 constructor, List arguments, boolean z10) {
        kotlin.jvm.internal.t.f(attributes, "attributes");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        return k(attributes, constructor, arguments, z10, null, 16, null);
    }

    public static final c1 j(q1 attributes, u1 constructor, List arguments, boolean z10, yf.g gVar) {
        kotlin.jvm.internal.t.f(attributes, "attributes");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        if (!attributes.isEmpty() || !arguments.isEmpty() || z10 || constructor.b() == null) {
            return n(attributes, constructor, arguments, z10, f25079a.d(constructor, arguments, gVar), new s0(constructor, arguments, attributes, z10));
        }
        fe.h hVarB = constructor.b();
        kotlin.jvm.internal.t.c(hVarB);
        c1 c1VarS = hVarB.s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        return c1VarS;
    }

    public static /* synthetic */ c1 k(q1 q1Var, u1 u1Var, List list, boolean z10, yf.g gVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            gVar = null;
        }
        return j(q1Var, u1Var, list, z10, gVar);
    }

    public static final c1 l(u1 u1Var, List list, q1 q1Var, boolean z10, yf.g refiner) {
        kotlin.jvm.internal.t.f(refiner, "refiner");
        b bVarG = f25079a.g(u1Var, refiner, list);
        if (bVarG == null) {
            return null;
        }
        c1 c1VarA = bVarG.a();
        if (c1VarA != null) {
            return c1VarA;
        }
        u1 u1VarB = bVarG.b();
        kotlin.jvm.internal.t.c(u1VarB);
        return j(q1Var, u1VarB, list, z10, refiner);
    }

    public static final c1 m(q1 attributes, u1 constructor, List arguments, boolean z10, qf.k memberScope) {
        kotlin.jvm.internal.t.f(attributes, "attributes");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        kotlin.jvm.internal.t.f(memberScope, "memberScope");
        d1 d1Var = new d1(constructor, arguments, z10, memberScope, new t0(constructor, arguments, attributes, z10, memberScope));
        return attributes.isEmpty() ? d1Var : new e1(d1Var, attributes);
    }

    public static final c1 n(q1 attributes, u1 constructor, List arguments, boolean z10, qf.k memberScope, pd.k refinedTypeFactory) {
        kotlin.jvm.internal.t.f(attributes, "attributes");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        kotlin.jvm.internal.t.f(memberScope, "memberScope");
        kotlin.jvm.internal.t.f(refinedTypeFactory, "refinedTypeFactory");
        d1 d1Var = new d1(constructor, arguments, z10, memberScope, refinedTypeFactory);
        return attributes.isEmpty() ? d1Var : new e1(d1Var, attributes);
    }

    public static final c1 o(u1 u1Var, List list, q1 q1Var, boolean z10, qf.k kVar, yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        b bVarG = f25079a.g(u1Var, kotlinTypeRefiner, list);
        if (bVarG == null) {
            return null;
        }
        c1 c1VarA = bVarG.a();
        if (c1VarA != null) {
            return c1VarA;
        }
        u1 u1VarB = bVarG.b();
        kotlin.jvm.internal.t.c(u1VarB);
        return m(q1Var, u1VarB, list, z10, kVar);
    }

    public final qf.k d(u1 u1Var, List list, yf.g gVar) {
        fe.h hVarB = u1Var.b();
        if (hVarB instanceof fe.l1) {
            return ((fe.l1) hVarB).s().q();
        }
        if (hVarB instanceof fe.e) {
            if (gVar == null) {
                gVar = nf.e.r(nf.e.s(hVarB));
            }
            return list.isEmpty() ? ie.a0.b((fe.e) hVarB, gVar) : ie.a0.a((fe.e) hVarB, v1.f25085c.b(u1Var, list), gVar);
        }
        if (hVarB instanceof fe.k1) {
            return zf.l.a(zf.h.f26480e, true, ((fe.k1) hVarB).getName().toString());
        }
        if (u1Var instanceof q0) {
            return ((q0) u1Var).i();
        }
        throw new IllegalStateException("Unsupported classifier: " + hVarB + " for constructor: " + u1Var);
    }

    public final b g(u1 u1Var, yf.g gVar, List list) {
        fe.h hVarF;
        fe.h hVarB = u1Var.b();
        if (hVarB == null || (hVarF = gVar.f(hVarB)) == null) {
            return null;
        }
        if (hVarF instanceof fe.k1) {
            return new b(c((fe.k1) hVarF, list), null);
        }
        u1 u1VarA = hVarF.k().a(gVar);
        kotlin.jvm.internal.t.e(u1VarA, "refine(...)");
        return new b(null, u1VarA);
    }
}
