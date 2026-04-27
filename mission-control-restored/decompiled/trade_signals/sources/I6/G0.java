package I6;

import O5.o;
import java.util.ArrayList;
import java.util.List;
import v6.AbstractC2881e;

/* JADX INFO: loaded from: classes2.dex */
public class G0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final G0 f4343b = g(E0.f4338b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E0 f4344a;

    public static class a implements B5.k {
        private static /* synthetic */ void a(int i8) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // B5.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(q6.c cVar) {
            if (cVar == null) {
                a(0);
            }
            return Boolean.valueOf(!cVar.equals(o.a.f6152Q));
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4345a;

        static {
            int[] iArr = new int[d.values().length];
            f4345a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4345a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4345a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    public enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    public G0(E0 e02) {
        if (e02 == null) {
            a(7);
        }
        this.f4344a = e02;
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
        throw new UnsupportedOperationException("Method not decompiled: I6.G0.a(int):void");
    }

    public static void b(int i8, B0 b02, E0 e02) {
        if (i8 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(b02) + "; substitution: " + o(e02));
    }

    public static N0 c(N0 n02, B0 b02) {
        if (n02 == null) {
            a(35);
        }
        if (b02 == null) {
            a(36);
        }
        if (!b02.c()) {
            return d(n02, b02.b());
        }
        N0 n03 = N0.f4372g;
        if (n03 == null) {
            a(37);
        }
        return n03;
    }

    public static N0 d(N0 n02, N0 n03) {
        if (n02 == null) {
            a(38);
        }
        if (n03 == null) {
            a(39);
        }
        N0 n04 = N0.f4370e;
        if (n02 == n04) {
            if (n03 == null) {
                a(40);
            }
            return n03;
        }
        if (n03 == n04) {
            if (n02 == null) {
                a(41);
            }
            return n02;
        }
        if (n02 == n03) {
            if (n03 == null) {
                a(42);
            }
            return n03;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + n02 + "' and projection kind '" + n03 + "' cannot be combined");
    }

    public static d e(N0 n02, N0 n03) {
        N0 n04 = N0.f4371f;
        return (n02 == n04 && n03 == N0.f4372g) ? d.OUT_IN_IN_POSITION : (n02 == N0.f4372g && n03 == n04) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    public static G0 f(S s8) {
        if (s8 == null) {
            a(6);
        }
        return g(w0.i(s8.O0(), s8.M0()));
    }

    public static G0 g(E0 e02) {
        if (e02 == null) {
            a(0);
        }
        return new G0(e02);
    }

    public static G0 h(E0 e02, E0 e03) {
        if (e02 == null) {
            a(3);
        }
        if (e03 == null) {
            a(4);
        }
        return g(D.i(e02, e03));
    }

    public static S5.h i(S5.h hVar) {
        if (hVar == null) {
            a(33);
        }
        return !hVar.r(o.a.f6152Q) ? hVar : new S5.p(hVar, new a());
    }

    public static B0 l(S s8, B0 b02, R5.m0 m0Var, B0 b03) {
        if (s8 == null) {
            a(26);
        }
        if (b02 == null) {
            a(27);
        }
        if (b03 == null) {
            a(28);
        }
        if (!s8.getAnnotations().r(o.a.f6152Q)) {
            if (b02 == null) {
                a(29);
            }
            return b02;
        }
        v0 v0VarO0 = b02.getType().O0();
        if (!(v0VarO0 instanceof J6.n)) {
            return b02;
        }
        B0 b0B = ((J6.n) v0VarO0).b();
        N0 n0B = b0B.b();
        d dVarE = e(b03.b(), n0B);
        d dVar = d.OUT_IN_IN_POSITION;
        return dVarE == dVar ? new D0(b0B.getType()) : (m0Var != null && e(m0Var.p(), n0B) == dVar) ? new D0(b0B.getType()) : b02;
    }

    public static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (S6.d.a(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    public E0 j() {
        E0 e02 = this.f4344a;
        if (e02 == null) {
            a(8);
        }
        return e02;
    }

    public boolean k() {
        return this.f4344a.f();
    }

    public G0 m() {
        E0 e02 = this.f4344a;
        return ((e02 instanceof M) && e02.b()) ? new G0(new M(((M) this.f4344a).j(), ((M) this.f4344a).i(), false)) : this;
    }

    public S n(S s8, N0 n02) {
        if (s8 == null) {
            a(9);
        }
        if (n02 == null) {
            a(10);
        }
        if (k()) {
            if (s8 == null) {
                a(11);
            }
            return s8;
        }
        try {
            S type = u(new D0(n02, s8), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e8) {
            K6.i iVarD = K6.l.d(K6.k.f4831D, e8.getMessage());
            if (iVarD == null) {
                a(13);
            }
            return iVarD;
        }
    }

    public S p(S s8, N0 n02) {
        if (s8 == null) {
            a(14);
        }
        if (n02 == null) {
            a(15);
        }
        B0 b0Q = q(new D0(n02, j().g(s8, n02)));
        if (b0Q == null) {
            return null;
        }
        return b0Q.getType();
    }

    public B0 q(B0 b02) {
        if (b02 == null) {
            a(16);
        }
        B0 b0T = t(b02);
        return (this.f4344a.a() || this.f4344a.b()) ? O6.c.d(b0T, this.f4344a.b()) : b0T;
    }

    public final B0 r(B0 b02, int i8) {
        S type = b02.getType();
        N0 n0B = b02.b();
        if (type.O0().s() instanceof R5.m0) {
            return b02;
        }
        AbstractC0613d0 abstractC0613d0B = AbstractC0621h0.b(type);
        S sP = abstractC0613d0B != null ? m().p(abstractC0613d0B, N0.f4370e) : null;
        S sB = F0.b(type, s(type.O0().getParameters(), type.M0(), i8), this.f4344a.d(type.getAnnotations()));
        if ((sB instanceof AbstractC0613d0) && (sP instanceof AbstractC0613d0)) {
            sB = AbstractC0621h0.j((AbstractC0613d0) sB, (AbstractC0613d0) sP);
        }
        return new D0(n0B, sB);
    }

    public final List s(List list, List list2, int i8) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z7 = false;
        for (int i9 = 0; i9 < list.size(); i9++) {
            R5.m0 m0Var = (R5.m0) list.get(i9);
            B0 b02 = (B0) list2.get(i9);
            B0 b0U = u(b02, m0Var, i8 + 1);
            int i10 = b.f4345a[e(m0Var.p(), b0U.b()).ordinal()];
            if (i10 == 1 || i10 == 2) {
                b0U = J0.s(m0Var);
            } else if (i10 == 3) {
                N0 n0P = m0Var.p();
                N0 n02 = N0.f4370e;
                if (n0P != n02 && !b0U.c()) {
                    b0U = new D0(n02, b0U.getType());
                }
            }
            if (b0U != b02) {
                z7 = true;
            }
            arrayList.add(b0U);
        }
        return !z7 ? list2 : arrayList;
    }

    public B0 t(B0 b02) {
        if (b02 == null) {
            a(17);
        }
        if (k()) {
            return b02;
        }
        try {
            return u(b02, null, 0);
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
    public final B0 u(B0 b02, R5.m0 m0Var, int i8) throws c {
        if (b02 == null) {
            a(18);
        }
        b(i8, b02, this.f4344a);
        if (b02.c()) {
            return b02;
        }
        S type = b02.getType();
        if (type instanceof K0) {
            K0 k02 = (K0) type;
            M0 m0H0 = k02.H0();
            S sI = k02.I();
            B0 b0U = u(new D0(b02.b(), m0H0), m0Var, i8 + 1);
            return b0U.c() ? b0U : new D0(b0U.b(), L0.d(b0U.getType().R0(), p(sI, b02.b())));
        }
        if (!E.a(type) && !(type.R0() instanceof InterfaceC0611c0)) {
            B0 b0E = this.f4344a.e(type);
            B0 b0L = b0E != null ? l(type, b0E, m0Var, b02) : null;
            N0 n0B = b02.b();
            if (b0L == null && L.b(type) && !t0.b(type)) {
                I iA = L.a(type);
                int i9 = i8 + 1;
                B0 b0U2 = u(new D0(n0B, iA.W0()), m0Var, i9);
                B0 b0U3 = u(new D0(n0B, iA.X0()), m0Var, i9);
                return (b0U2.getType() == iA.W0() && b0U3.getType() == iA.X0()) ? b02 : new D0(b0U2.b(), V.e(F0.a(b0U2.getType()), F0.a(b0U3.getType())));
            }
            if (!O5.i.o0(type) && !W.a(type)) {
                if (b0L != null) {
                    d dVarE = e(n0B, b0L.b());
                    if (!AbstractC2881e.f(type)) {
                        int i10 = b.f4345a[dVarE.ordinal()];
                        if (i10 == 1) {
                            throw new c("Out-projection in in-position");
                        }
                        if (i10 == 2) {
                            return new D0(N0.f4372g, type.O0().q().J());
                        }
                    }
                    InterfaceC0642w interfaceC0642wA = t0.a(type);
                    if (b0L.c()) {
                        return b0L;
                    }
                    S sR = interfaceC0642wA != null ? interfaceC0642wA.R(b0L.getType()) : J0.q(b0L.getType(), type.P0());
                    if (!type.getAnnotations().isEmpty()) {
                        sR = N6.d.C(sR, new S5.o(sR.getAnnotations(), i(this.f4344a.d(type.getAnnotations()))));
                    }
                    if (dVarE == d.NO_CONFLICT) {
                        n0B = d(n0B, b0L.b());
                    }
                    return new D0(n0B, sR);
                }
                b02 = r(b02, i8);
                if (b02 == null) {
                    a(25);
                }
            }
        }
        return b02;
    }
}
