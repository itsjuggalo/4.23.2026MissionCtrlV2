package R5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import u6.AbstractC2794i;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q0 {
    public static final X d(I6.S s8) {
        AbstractC2304t.f(s8, "<this>");
        InterfaceC0851h interfaceC0851hS = s8.O0().s();
        return e(s8, interfaceC0851hS instanceof InterfaceC0852i ? (InterfaceC0852i) interfaceC0851hS : null, 0);
    }

    public static final X e(I6.S s8, InterfaceC0852i interfaceC0852i, int i8) {
        if (interfaceC0852i == null || K6.l.m(interfaceC0852i)) {
            return null;
        }
        int size = interfaceC0852i.w().size() + i8;
        if (interfaceC0852i.M()) {
            List listSubList = s8.M0().subList(i8, size);
            InterfaceC0856m interfaceC0856mB = interfaceC0852i.b();
            return new X(interfaceC0852i, listSubList, e(s8, interfaceC0856mB instanceof InterfaceC0852i ? (InterfaceC0852i) interfaceC0856mB : null, size));
        }
        if (size != s8.M0().size()) {
            AbstractC2794i.E(interfaceC0852i);
        }
        return new X(interfaceC0852i, s8.M0().subList(i8, s8.M0().size()), null);
    }

    public static final C0846c f(m0 m0Var, InterfaceC0856m interfaceC0856m, int i8) {
        return new C0846c(m0Var, interfaceC0856m, i8);
    }

    public static final List g(InterfaceC0852i interfaceC0852i) {
        List listI;
        Object next;
        I6.v0 v0VarL;
        AbstractC2304t.f(interfaceC0852i, "<this>");
        List listW = interfaceC0852i.w();
        AbstractC2304t.e(listW, "getDeclaredTypeParameters(...)");
        if (!interfaceC0852i.M() && !(interfaceC0852i.b() instanceof InterfaceC0844a)) {
            return listW;
        }
        List listJ = U6.r.J(U6.r.z(U6.r.u(U6.r.H(AbstractC2996e.u(interfaceC0852i), n0.f7253a), o0.f7254a), p0.f7255a));
        Iterator it = AbstractC2996e.u(interfaceC0852i).iterator();
        while (true) {
            listI = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof InterfaceC0848e) {
                break;
            }
        }
        InterfaceC0848e interfaceC0848e = (InterfaceC0848e) next;
        if (interfaceC0848e != null && (v0VarL = interfaceC0848e.l()) != null) {
            listI = v0VarL.getParameters();
        }
        if (listI == null) {
            listI = AbstractC2595q.i();
        }
        if (listJ.isEmpty() && listI.isEmpty()) {
            List listW2 = interfaceC0852i.w();
            AbstractC2304t.e(listW2, "getDeclaredTypeParameters(...)");
            return listW2;
        }
        List<m0> listR0 = p5.z.r0(listJ, listI);
        ArrayList arrayList = new ArrayList(p5.r.s(listR0, 10));
        for (m0 m0Var : listR0) {
            AbstractC2304t.c(m0Var);
            arrayList.add(f(m0Var, interfaceC0852i, listW.size()));
        }
        return p5.z.r0(listW, arrayList);
    }

    public static final boolean h(InterfaceC0856m it) {
        AbstractC2304t.f(it, "it");
        return it instanceof InterfaceC0844a;
    }

    public static final boolean i(InterfaceC0856m it) {
        AbstractC2304t.f(it, "it");
        return !(it instanceof InterfaceC0855l);
    }

    public static final U6.h j(InterfaceC0856m it) {
        AbstractC2304t.f(it, "it");
        List typeParameters = ((InterfaceC0844a) it).getTypeParameters();
        AbstractC2304t.e(typeParameters, "getTypeParameters(...)");
        return p5.z.P(typeParameters);
    }
}
