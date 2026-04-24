package N6;

import B5.k;
import I6.AbstractC0613d0;
import I6.B0;
import I6.C0627k0;
import I6.C0644y;
import I6.D0;
import I6.F0;
import I6.I;
import I6.J0;
import I6.L0;
import I6.M0;
import I6.N0;
import I6.S;
import I6.V;
import I6.s0;
import I6.v0;
import J6.e;
import O5.i;
import R5.EnumC0849f;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0852i;
import R5.l0;
import R5.m0;
import S5.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;
import p5.C2577F;
import p5.r;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final S A(S s8) {
        AbstractC2304t.f(s8, "<this>");
        S sN = J0.n(s8);
        AbstractC2304t.e(sN, "makeNotNullable(...)");
        return sN;
    }

    public static final S B(S s8) {
        AbstractC2304t.f(s8, "<this>");
        S sO = J0.o(s8);
        AbstractC2304t.e(sO, "makeNullable(...)");
        return sO;
    }

    public static final S C(S s8, h newAnnotations) {
        AbstractC2304t.f(s8, "<this>");
        AbstractC2304t.f(newAnnotations, "newAnnotations");
        return (s8.getAnnotations().isEmpty() && newAnnotations.isEmpty()) ? s8 : s8.R0().U0(s0.a(s8.N0(), newAnnotations));
    }

    public static final S D(S s8) {
        M0 m0F;
        AbstractC2304t.f(s8, "<this>");
        M0 m0R0 = s8.R0();
        if (m0R0 instanceof I) {
            I i8 = (I) m0R0;
            AbstractC0613d0 abstractC0613d0W0 = i8.W0();
            if (!abstractC0613d0W0.O0().getParameters().isEmpty() && abstractC0613d0W0.O0().s() != null) {
                List parameters = abstractC0613d0W0.O0().getParameters();
                AbstractC2304t.e(parameters, "getParameters(...)");
                ArrayList arrayList = new ArrayList(r.s(parameters, 10));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C0627k0((m0) it.next()));
                }
                abstractC0613d0W0 = F0.f(abstractC0613d0W0, arrayList, null, 2, null);
            }
            AbstractC0613d0 abstractC0613d0X0 = i8.X0();
            if (!abstractC0613d0X0.O0().getParameters().isEmpty() && abstractC0613d0X0.O0().s() != null) {
                List parameters2 = abstractC0613d0X0.O0().getParameters();
                AbstractC2304t.e(parameters2, "getParameters(...)");
                ArrayList arrayList2 = new ArrayList(r.s(parameters2, 10));
                Iterator it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new C0627k0((m0) it2.next()));
                }
                abstractC0613d0X0 = F0.f(abstractC0613d0X0, arrayList2, null, 2, null);
            }
            m0F = V.e(abstractC0613d0W0, abstractC0613d0X0);
        } else {
            if (!(m0R0 instanceof AbstractC0613d0)) {
                throw new C2487o();
            }
            AbstractC0613d0 abstractC0613d0 = (AbstractC0613d0) m0R0;
            boolean zIsEmpty = abstractC0613d0.O0().getParameters().isEmpty();
            m0F = abstractC0613d0;
            if (!zIsEmpty) {
                InterfaceC0851h interfaceC0851hS = abstractC0613d0.O0().s();
                m0F = abstractC0613d0;
                if (interfaceC0851hS != null) {
                    List parameters3 = abstractC0613d0.O0().getParameters();
                    AbstractC2304t.e(parameters3, "getParameters(...)");
                    ArrayList arrayList3 = new ArrayList(r.s(parameters3, 10));
                    Iterator it3 = parameters3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new C0627k0((m0) it3.next()));
                    }
                    m0F = F0.f(abstractC0613d0, arrayList3, null, 2, null);
                }
            }
        }
        return L0.b(m0F, m0R0);
    }

    public static final boolean E(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return e(s8, c.f5885a);
    }

    public static final boolean F(M0 it) {
        AbstractC2304t.f(it, "it");
        InterfaceC0851h interfaceC0851hS = it.O0().s();
        if (interfaceC0851hS != null) {
            return (interfaceC0851hS instanceof l0) || (interfaceC0851hS instanceof m0);
        }
        return false;
    }

    public static final B0 d(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return new D0(s8);
    }

    public static final boolean e(S s8, k predicate) {
        AbstractC2304t.f(s8, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        return J0.c(s8, predicate);
    }

    public static final boolean f(S s8, v0 v0Var, Set set) {
        boolean zF;
        if (AbstractC2304t.b(s8.O0(), v0Var)) {
            return true;
        }
        InterfaceC0851h interfaceC0851hS = s8.O0().s();
        InterfaceC0852i interfaceC0852i = interfaceC0851hS instanceof InterfaceC0852i ? (InterfaceC0852i) interfaceC0851hS : null;
        List listW = interfaceC0852i != null ? interfaceC0852i.w() : null;
        Iterable<C2577F> iterableM0 = z.M0(s8.M0());
        if (!(iterableM0 instanceof Collection) || !((Collection) iterableM0).isEmpty()) {
            for (C2577F c2577f : iterableM0) {
                int iA = c2577f.a();
                B0 b02 = (B0) c2577f.b();
                m0 m0Var = listW != null ? (m0) z.b0(listW, iA) : null;
                if ((m0Var == null || set == null || !set.contains(m0Var)) && !b02.c()) {
                    S type = b02.getType();
                    AbstractC2304t.e(type, "getType(...)");
                    zF = f(type, v0Var, set);
                } else {
                    zF = false;
                }
                if (zF) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean g(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return e(s8, b.f5884a);
    }

    public static final boolean h(M0 it) {
        AbstractC2304t.f(it, "it");
        InterfaceC0851h interfaceC0851hS = it.O0().s();
        if (interfaceC0851hS != null) {
            return x(interfaceC0851hS);
        }
        return false;
    }

    public static final boolean i(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return J0.c(s8, a.f5883a);
    }

    public static final Boolean j(M0 m02) {
        return Boolean.valueOf(J0.m(m02));
    }

    public static final B0 k(S type, N0 projectionKind, m0 m0Var) {
        AbstractC2304t.f(type, "type");
        AbstractC2304t.f(projectionKind, "projectionKind");
        if ((m0Var != null ? m0Var.p() : null) == projectionKind) {
            projectionKind = N0.f4370e;
        }
        return new D0(projectionKind, type);
    }

    public static final Set l(S s8, Set set) {
        AbstractC2304t.f(s8, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        m(s8, s8, linkedHashSet, set);
        return linkedHashSet;
    }

    public static final void m(S s8, S s9, Set set, Set set2) {
        InterfaceC0851h interfaceC0851hS = s8.O0().s();
        if (interfaceC0851hS instanceof m0) {
            if (!AbstractC2304t.b(s8.O0(), s9.O0())) {
                set.add(interfaceC0851hS);
                return;
            }
            for (S s10 : ((m0) interfaceC0851hS).getUpperBounds()) {
                AbstractC2304t.c(s10);
                m(s10, s9, set, set2);
            }
            return;
        }
        InterfaceC0851h interfaceC0851hS2 = s8.O0().s();
        InterfaceC0852i interfaceC0852i = interfaceC0851hS2 instanceof InterfaceC0852i ? (InterfaceC0852i) interfaceC0851hS2 : null;
        List listW = interfaceC0852i != null ? interfaceC0852i.w() : null;
        int i8 = 0;
        for (B0 b02 : s8.M0()) {
            int i9 = i8 + 1;
            m0 m0Var = listW != null ? (m0) z.b0(listW, i8) : null;
            if ((m0Var == null || set2 == null || !set2.contains(m0Var)) && !b02.c() && !z.Q(set, b02.getType().O0().s()) && !AbstractC2304t.b(b02.getType().O0(), s9.O0())) {
                S type = b02.getType();
                AbstractC2304t.e(type, "getType(...)");
                m(type, s9, set, set2);
            }
            i8 = i9;
        }
    }

    public static final i n(S s8) {
        AbstractC2304t.f(s8, "<this>");
        i iVarQ = s8.O0().q();
        AbstractC2304t.e(iVarQ, "getBuiltIns(...)");
        return iVarQ;
    }

    public static final S o(m0 m0Var) {
        Object obj;
        AbstractC2304t.f(m0Var, "<this>");
        List upperBounds = m0Var.getUpperBounds();
        AbstractC2304t.e(upperBounds, "getUpperBounds(...)");
        upperBounds.isEmpty();
        List upperBounds2 = m0Var.getUpperBounds();
        AbstractC2304t.e(upperBounds2, "getUpperBounds(...)");
        Iterator it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InterfaceC0851h interfaceC0851hS = ((S) next).O0().s();
            InterfaceC0848e interfaceC0848e = interfaceC0851hS instanceof InterfaceC0848e ? (InterfaceC0848e) interfaceC0851hS : null;
            if (interfaceC0848e != null && interfaceC0848e.i() != EnumC0849f.f7235c && interfaceC0848e.i() != EnumC0849f.f7238f) {
                obj = next;
                break;
            }
        }
        S s8 = (S) obj;
        if (s8 != null) {
            return s8;
        }
        List upperBounds3 = m0Var.getUpperBounds();
        AbstractC2304t.e(upperBounds3, "getUpperBounds(...)");
        Object objY = z.Y(upperBounds3);
        AbstractC2304t.e(objY, "first(...)");
        return (S) objY;
    }

    public static final boolean p(m0 typeParameter) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        return r(typeParameter, null, null, 6, null);
    }

    public static final boolean q(m0 typeParameter, v0 v0Var, Set set) {
        AbstractC2304t.f(typeParameter, "typeParameter");
        List<S> upperBounds = typeParameter.getUpperBounds();
        AbstractC2304t.e(upperBounds, "getUpperBounds(...)");
        if ((upperBounds instanceof Collection) && upperBounds.isEmpty()) {
            return false;
        }
        for (S s8 : upperBounds) {
            AbstractC2304t.c(s8);
            if (f(s8, typeParameter.t().O0(), set) && (v0Var == null || AbstractC2304t.b(s8.O0(), v0Var))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean r(m0 m0Var, v0 v0Var, Set set, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            v0Var = null;
        }
        if ((i8 & 4) != 0) {
            set = null;
        }
        return q(m0Var, v0Var, set);
    }

    public static final boolean s(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return i.g0(s8);
    }

    public static final boolean t(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return i.o0(s8);
    }

    public static final boolean u(S s8) {
        AbstractC2304t.f(s8, "<this>");
        if (!(s8 instanceof C0644y)) {
            return false;
        }
        ((C0644y) s8).a1();
        return false;
    }

    public static final boolean v(S s8) {
        AbstractC2304t.f(s8, "<this>");
        if (!(s8 instanceof C0644y)) {
            return false;
        }
        ((C0644y) s8).a1();
        return false;
    }

    public static final boolean w(S s8, S superType) {
        AbstractC2304t.f(s8, "<this>");
        AbstractC2304t.f(superType, "superType");
        return e.f4643a.b(s8, superType);
    }

    public static final boolean x(InterfaceC0851h interfaceC0851h) {
        AbstractC2304t.f(interfaceC0851h, "<this>");
        return (interfaceC0851h instanceof m0) && (((m0) interfaceC0851h).b() instanceof l0);
    }

    public static final boolean y(S s8) {
        AbstractC2304t.f(s8, "<this>");
        return J0.m(s8);
    }

    public static final boolean z(S type) {
        AbstractC2304t.f(type, "type");
        return (type instanceof K6.i) && ((K6.i) type).Y0().g();
    }
}
