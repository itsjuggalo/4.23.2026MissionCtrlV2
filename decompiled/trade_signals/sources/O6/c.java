package O6;

import I6.AbstractC0613d0;
import I6.B0;
import I6.D0;
import I6.F0;
import I6.G0;
import I6.J0;
import I6.L;
import I6.L0;
import I6.M0;
import I6.N0;
import I6.S;
import I6.V;
import I6.v0;
import I6.w0;
import O5.i;
import R5.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;
import o5.C2489q;
import p5.r;
import p5.z;
import v6.AbstractC2881e;
import v6.InterfaceC2878b;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6242a;

        static {
            int[] iArr = new int[N0.values().length];
            try {
                iArr[N0.f4370e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[N0.f4371f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[N0.f4372g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f6242a = iArr;
        }
    }

    public static final class b extends w0 {
        @Override // I6.w0
        public B0 k(v0 key) {
            AbstractC2304t.f(key, "key");
            InterfaceC2878b interfaceC2878b = key instanceof InterfaceC2878b ? (InterfaceC2878b) key : null;
            if (interfaceC2878b == null) {
                return null;
            }
            return interfaceC2878b.b().c() ? new D0(N0.f4372g, interfaceC2878b.b().getType()) : interfaceC2878b.b();
        }
    }

    public static final O6.a b(S type) {
        Object objG;
        AbstractC2304t.f(type, "type");
        if (L.b(type)) {
            O6.a aVarB = b(L.c(type));
            O6.a aVarB2 = b(L.d(type));
            return new O6.a(L0.b(V.e(L.c((S) aVarB.c()), L.d((S) aVarB2.c())), type), L0.b(V.e(L.c((S) aVarB.d()), L.d((S) aVarB2.d())), type));
        }
        v0 v0VarO0 = type.O0();
        if (AbstractC2881e.f(type)) {
            AbstractC2304t.d(v0VarO0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            B0 b0B = ((InterfaceC2878b) v0VarO0).b();
            S type2 = b0B.getType();
            AbstractC2304t.e(type2, "getType(...)");
            S sC = c(type2, type);
            int i8 = a.f6242a[b0B.b().ordinal()];
            if (i8 == 2) {
                return new O6.a(sC, N6.d.n(type).J());
            }
            if (i8 == 3) {
                AbstractC0613d0 abstractC0613d0I = N6.d.n(type).I();
                AbstractC2304t.e(abstractC0613d0I, "getNothingType(...)");
                return new O6.a(c(abstractC0613d0I, type), sC);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + b0B);
        }
        if (type.M0().isEmpty() || type.M0().size() != v0VarO0.getParameters().size()) {
            return new O6.a(type, type);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List listM0 = type.M0();
        List parameters = v0VarO0.getParameters();
        AbstractC2304t.e(parameters, "getParameters(...)");
        for (C2489q c2489q : z.O0(listM0, parameters)) {
            B0 b02 = (B0) c2489q.a();
            m0 m0Var = (m0) c2489q.b();
            AbstractC2304t.c(m0Var);
            d dVarI = i(b02, m0Var);
            if (b02.c()) {
                arrayList.add(dVarI);
            } else {
                O6.a aVarF = f(dVarI);
                d dVar = (d) aVarF.a();
                dVarI = (d) aVarF.b();
                arrayList.add(dVar);
            }
            arrayList2.add(dVarI);
        }
        boolean z7 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!((d) it.next()).d()) {
                    z7 = true;
                    break;
                }
            }
        }
        if (z7) {
            objG = N6.d.n(type).I();
            AbstractC2304t.e(objG, "getNothingType(...)");
        } else {
            objG = g(type, arrayList);
        }
        return new O6.a(objG, g(type, arrayList2));
    }

    public static final S c(S s8, S s9) {
        S sQ = J0.q(s8, s9.P0());
        AbstractC2304t.e(sQ, "makeNullableIfNeeded(...)");
        return sQ;
    }

    public static final B0 d(B0 b02, boolean z7) {
        if (b02 == null) {
            return null;
        }
        if (b02.c()) {
            return b02;
        }
        S type = b02.getType();
        AbstractC2304t.e(type, "getType(...)");
        if (!J0.c(type, O6.b.f6241a)) {
            return b02;
        }
        N0 n0B = b02.b();
        AbstractC2304t.e(n0B, "getProjectionKind(...)");
        return n0B == N0.f4372g ? new D0(n0B, (S) b(type).d()) : z7 ? new D0(n0B, (S) b(type).c()) : h(b02);
    }

    public static final Boolean e(M0 m02) {
        AbstractC2304t.c(m02);
        return Boolean.valueOf(AbstractC2881e.f(m02));
    }

    public static final O6.a f(d dVar) {
        O6.a aVarB = b(dVar.a());
        S s8 = (S) aVarB.a();
        S s9 = (S) aVarB.b();
        O6.a aVarB2 = b(dVar.b());
        return new O6.a(new d(dVar.c(), s9, (S) aVarB2.a()), new d(dVar.c(), s8, (S) aVarB2.b()));
    }

    public static final S g(S s8, List list) {
        s8.M0().size();
        list.size();
        ArrayList arrayList = new ArrayList(r.s(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(j((d) it.next()));
        }
        return F0.e(s8, arrayList, null, null, 6, null);
    }

    public static final B0 h(B0 b02) {
        G0 g0G = G0.g(new b());
        AbstractC2304t.e(g0G, "create(...)");
        return g0G.t(b02);
    }

    public static final d i(B0 b02, m0 m0Var) {
        int i8 = a.f6242a[G0.c(m0Var.p(), b02).ordinal()];
        if (i8 == 1) {
            S type = b02.getType();
            AbstractC2304t.e(type, "getType(...)");
            S type2 = b02.getType();
            AbstractC2304t.e(type2, "getType(...)");
            return new d(m0Var, type, type2);
        }
        if (i8 == 2) {
            S type3 = b02.getType();
            AbstractC2304t.e(type3, "getType(...)");
            AbstractC0613d0 abstractC0613d0J = AbstractC2996e.m(m0Var).J();
            AbstractC2304t.e(abstractC0613d0J, "getNullableAnyType(...)");
            return new d(m0Var, type3, abstractC0613d0J);
        }
        if (i8 != 3) {
            throw new C2487o();
        }
        AbstractC0613d0 abstractC0613d0I = AbstractC2996e.m(m0Var).I();
        AbstractC2304t.e(abstractC0613d0I, "getNothingType(...)");
        S type4 = b02.getType();
        AbstractC2304t.e(type4, "getType(...)");
        return new d(m0Var, abstractC0613d0I, type4);
    }

    public static final B0 j(d dVar) {
        dVar.d();
        if (!AbstractC2304t.b(dVar.a(), dVar.b())) {
            N0 n0P = dVar.c().p();
            N0 n02 = N0.f4371f;
            if (n0P != n02) {
                return (!i.o0(dVar.a()) || dVar.c().p() == n02) ? i.q0(dVar.b()) ? new D0(k(dVar, n02), dVar.a()) : new D0(k(dVar, N0.f4372g), dVar.b()) : new D0(k(dVar, N0.f4372g), dVar.b());
            }
        }
        return new D0(dVar.a());
    }

    public static final N0 k(d dVar, N0 n02) {
        return n02 == dVar.c().p() ? N0.f4370e : n02;
    }
}
