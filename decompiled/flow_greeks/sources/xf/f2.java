package xf;

import ce.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class f2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f2 f24962b = g(d2.f24949b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2 f24963a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements pd.k {
        private static /* synthetic */ void a(int i10) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // pd.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(ef.c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(o.a.Q));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24964a;

        static {
            int[] iArr = new int[d.values().length];
            f24964a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24964a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24964a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public f2(d2 d2Var) {
        if (d2Var == null) {
            a(7);
        }
        this.f24963a = d2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xf.f2.a(int):void");
    }

    public static void b(int i10, a2 a2Var, d2 d2Var) {
        if (i10 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(a2Var) + "; substitution: " + o(d2Var));
    }

    public static m2 c(m2 m2Var, a2 a2Var) {
        if (m2Var == null) {
            a(35);
        }
        if (a2Var == null) {
            a(36);
        }
        if (!a2Var.c()) {
            return d(m2Var, a2Var.b());
        }
        m2 m2Var2 = m2.f25017g;
        if (m2Var2 == null) {
            a(37);
        }
        return m2Var2;
    }

    public static m2 d(m2 m2Var, m2 m2Var2) {
        if (m2Var == null) {
            a(38);
        }
        if (m2Var2 == null) {
            a(39);
        }
        m2 m2Var3 = m2.f25015e;
        if (m2Var == m2Var3) {
            if (m2Var2 == null) {
                a(40);
            }
            return m2Var2;
        }
        if (m2Var2 == m2Var3) {
            if (m2Var == null) {
                a(41);
            }
            return m2Var;
        }
        if (m2Var == m2Var2) {
            if (m2Var2 == null) {
                a(42);
            }
            return m2Var2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + m2Var + "' and projection kind '" + m2Var2 + "' cannot be combined");
    }

    public static d e(m2 m2Var, m2 m2Var2) {
        m2 m2Var3 = m2.f25016f;
        return (m2Var == m2Var3 && m2Var2 == m2.f25017g) ? d.OUT_IN_IN_POSITION : (m2Var == m2.f25017g && m2Var2 == m2Var3) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    public static f2 f(r0 r0Var) {
        if (r0Var == null) {
            a(6);
        }
        return g(v1.i(r0Var.N0(), r0Var.L0()));
    }

    public static f2 g(d2 d2Var) {
        if (d2Var == null) {
            a(0);
        }
        return new f2(d2Var);
    }

    public static f2 h(d2 d2Var, d2 d2Var2) {
        if (d2Var == null) {
            a(3);
        }
        if (d2Var2 == null) {
            a(4);
        }
        return g(d0.i(d2Var, d2Var2));
    }

    public static ge.h i(ge.h hVar) {
        if (hVar == null) {
            a(33);
        }
        return !hVar.E(o.a.Q) ? hVar : new ge.p(hVar, new a());
    }

    public static a2 l(r0 r0Var, a2 a2Var, fe.l1 l1Var, a2 a2Var2) {
        if (r0Var == null) {
            a(26);
        }
        if (a2Var == null) {
            a(27);
        }
        if (a2Var2 == null) {
            a(28);
        }
        if (!r0Var.getAnnotations().E(o.a.Q)) {
            if (a2Var == null) {
                a(29);
            }
            return a2Var;
        }
        u1 u1VarN0 = a2Var.getType().N0();
        if (!(u1VarN0 instanceof yf.n)) {
            return a2Var;
        }
        a2 a2VarE = ((yf.n) u1VarN0).e();
        m2 m2VarB = a2VarE.b();
        d dVarE = e(a2Var2.b(), m2VarB);
        d dVar = d.OUT_IN_IN_POSITION;
        return dVarE == dVar ? new c2(a2VarE.getType()) : (l1Var != null && e(l1Var.o(), m2VarB) == dVar) ? new c2(a2VarE.getType()) : a2Var;
    }

    public static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (hg.d.a(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public d2 j() {
        d2 d2Var = this.f24963a;
        if (d2Var == null) {
            a(8);
        }
        return d2Var;
    }

    public boolean k() {
        return this.f24963a.f();
    }

    public f2 m() {
        d2 d2Var = this.f24963a;
        return ((d2Var instanceof m0) && d2Var.b()) ? new f2(new m0(((m0) this.f24963a).j(), ((m0) this.f24963a).i(), false)) : this;
    }

    public r0 n(r0 r0Var, m2 m2Var) {
        if (r0Var == null) {
            a(9);
        }
        if (m2Var == null) {
            a(10);
        }
        if (k()) {
            if (r0Var == null) {
                a(11);
            }
            return r0Var;
        }
        try {
            r0 type = u(new c2(m2Var, r0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e10) {
            zf.i iVarD = zf.l.d(zf.k.D, e10.getMessage());
            if (iVarD == null) {
                a(13);
            }
            return iVarD;
        }
    }

    public r0 p(r0 r0Var, m2 m2Var) {
        if (r0Var == null) {
            a(14);
        }
        if (m2Var == null) {
            a(15);
        }
        a2 a2VarQ = q(new c2(m2Var, j().g(r0Var, m2Var)));
        if (a2VarQ == null) {
            return null;
        }
        return a2VarQ.getType();
    }

    public a2 q(a2 a2Var) {
        if (a2Var == null) {
            a(16);
        }
        a2 a2VarT = t(a2Var);
        return (this.f24963a.a() || this.f24963a.b()) ? dg.c.d(a2VarT, this.f24963a.b()) : a2VarT;
    }

    public final a2 r(a2 a2Var, int i10) {
        r0 type = a2Var.getType();
        m2 m2VarB = a2Var.b();
        if (type.N0().b() instanceof fe.l1) {
            return a2Var;
        }
        c1 c1VarB = g1.b(type);
        r0 r0VarP = c1VarB != null ? m().p(c1VarB, m2.f25015e) : null;
        r0 r0VarB = e2.b(type, s(type.N0().getParameters(), type.L0(), i10), this.f24963a.d(type.getAnnotations()));
        if ((r0VarB instanceof c1) && (r0VarP instanceof c1)) {
            r0VarB = g1.j((c1) r0VarB, (c1) r0VarP);
        }
        return new c2(m2VarB, r0VarB);
    }

    public final List s(List list, List list2, int i10) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z10 = false;
        for (int i11 = 0; i11 < list.size(); i11++) {
            fe.l1 l1Var = (fe.l1) list.get(i11);
            a2 a2Var = (a2) list2.get(i11);
            a2 a2VarU = u(a2Var, l1Var, i10 + 1);
            int i12 = b.f24964a[e(l1Var.o(), a2VarU.b()).ordinal()];
            if (i12 == 1 || i12 == 2) {
                a2VarU = i2.s(l1Var);
            } else if (i12 == 3) {
                m2 m2VarO = l1Var.o();
                m2 m2Var = m2.f25015e;
                if (m2VarO != m2Var && !a2VarU.c()) {
                    a2VarU = new c2(m2Var, a2VarU.getType());
                }
            }
            if (a2VarU != a2Var) {
                z10 = true;
            }
            arrayList.add(a2VarU);
        }
        return !z10 ? list2 : arrayList;
    }

    public a2 t(a2 a2Var) {
        if (a2Var == null) {
            a(17);
        }
        if (k()) {
            return a2Var;
        }
        try {
            return u(a2Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final a2 u(a2 a2Var, fe.l1 l1Var, int i10) throws c {
        if (a2Var == null) {
            a(18);
        }
        b(i10, a2Var, this.f24963a);
        if (!a2Var.c()) {
            r0 type = a2Var.getType();
            if (type instanceof j2) {
                j2 j2Var = (j2) type;
                l2 l2VarF0 = j2Var.F0();
                r0 r0VarI = j2Var.I();
                a2 a2VarU = u(new c2(a2Var.b(), l2VarF0), l1Var, i10 + 1);
                return a2VarU.c() ? a2VarU : new c2(a2VarU.b(), k2.d(a2VarU.getType().Q0(), p(r0VarI, a2Var.b())));
            }
            if (!e0.a(type) && !(type.Q0() instanceof b1)) {
                a2 a2VarE = this.f24963a.e(type);
                a2 a2VarL = a2VarE != null ? l(type, a2VarE, l1Var, a2Var) : null;
                m2 m2VarB = a2Var.b();
                if (a2VarL == null && l0.b(type) && !s1.b(type)) {
                    i0 i0VarA = l0.a(type);
                    int i11 = i10 + 1;
                    a2 a2VarU2 = u(new c2(m2VarB, i0VarA.V0()), l1Var, i11);
                    a2 a2VarU3 = u(new c2(m2VarB, i0VarA.W0()), l1Var, i11);
                    m2 m2VarB2 = a2VarU2.b();
                    if (a2VarU2.getType() != i0VarA.V0() || a2VarU3.getType() != i0VarA.W0()) {
                        return new c2(m2VarB2, u0.e(e2.a(a2VarU2.getType()), e2.a(a2VarU3.getType())));
                    }
                } else if (!ce.i.o0(type) && !v0.a(type)) {
                    if (a2VarL != null) {
                        d dVarE = e(m2VarB, a2VarL.b());
                        if (!kf.e.f(type)) {
                            int i12 = b.f24964a[dVarE.ordinal()];
                            if (i12 == 1) {
                                throw new c("Out-projection in in-position");
                            }
                            if (i12 == 2) {
                                return new c2(m2.f25017g, type.N0().p().J());
                            }
                        }
                        w wVarA = s1.a(type);
                        if (a2VarL.c()) {
                            return a2VarL;
                        }
                        r0 r0VarW = wVarA != null ? wVarA.w(a2VarL.getType()) : i2.q(a2VarL.getType(), type.O0());
                        if (!type.getAnnotations().isEmpty()) {
                            r0VarW = cg.d.C(r0VarW, new ge.o(r0VarW.getAnnotations(), i(this.f24963a.d(type.getAnnotations()))));
                        }
                        if (dVarE == d.NO_CONFLICT) {
                            m2VarB = d(m2VarB, a2VarL.b());
                        }
                        return new c2(m2VarB, r0VarW);
                    }
                    a2Var = r(a2Var, i10);
                    if (a2Var == null) {
                        a(25);
                    }
                }
            }
        }
        return a2Var;
    }
}
