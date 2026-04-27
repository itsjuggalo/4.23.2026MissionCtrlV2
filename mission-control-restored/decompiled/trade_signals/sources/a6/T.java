package a6;

import I6.AbstractC0613d0;
import R5.InterfaceC0844a;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import R5.Y;
import R5.Z;
import R5.g0;
import c6.InterfaceC1259c;
import kotlin.jvm.internal.AbstractC2304t;
import u6.AbstractC2794i;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class T {
    public static final boolean d(InterfaceC0845b interfaceC0845b) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        return g(interfaceC0845b) != null;
    }

    public static final String e(InterfaceC0845b callableMemberDescriptor) {
        InterfaceC0845b interfaceC0845bW;
        q6.f fVarJ;
        AbstractC2304t.f(callableMemberDescriptor, "callableMemberDescriptor");
        InterfaceC0845b interfaceC0845bF = f(callableMemberDescriptor);
        if (interfaceC0845bF == null || (interfaceC0845bW = AbstractC2996e.w(interfaceC0845bF)) == null) {
            return null;
        }
        if (interfaceC0845bW instanceof Z) {
            return C1090m.f10149a.b(interfaceC0845bW);
        }
        if (!(interfaceC0845bW instanceof g0) || (fVarJ = C1083f.f10138o.j((g0) interfaceC0845bW)) == null) {
            return null;
        }
        return fVarJ.b();
    }

    public static final InterfaceC0845b f(InterfaceC0845b interfaceC0845b) {
        if (O5.i.h0(interfaceC0845b)) {
            return g(interfaceC0845b);
        }
        return null;
    }

    public static final InterfaceC0845b g(InterfaceC0845b interfaceC0845b) {
        B5.k kVar;
        AbstractC2304t.f(interfaceC0845b, "<this>");
        if (!U.f10090a.g().contains(interfaceC0845b.getName()) && !C1087j.f10142a.d().contains(AbstractC2996e.w(interfaceC0845b).getName())) {
            return null;
        }
        if ((interfaceC0845b instanceof Z) || (interfaceC0845b instanceof Y)) {
            kVar = P.f10087a;
        } else {
            if (!(interfaceC0845b instanceof g0)) {
                return null;
            }
            kVar = Q.f10088a;
        }
        return AbstractC2996e.i(interfaceC0845b, false, kVar, 1, null);
    }

    public static final boolean h(InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return C1090m.f10149a.d(AbstractC2996e.w(it));
    }

    public static final boolean i(InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return C1083f.f10138o.k((g0) it);
    }

    public static final InterfaceC0845b j(InterfaceC0845b interfaceC0845b) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        InterfaceC0845b interfaceC0845bG = g(interfaceC0845b);
        if (interfaceC0845bG != null) {
            return interfaceC0845bG;
        }
        C1086i c1086i = C1086i.f10141o;
        q6.f name = interfaceC0845b.getName();
        AbstractC2304t.e(name, "getName(...)");
        if (c1086i.n(name)) {
            return AbstractC2996e.i(interfaceC0845b, false, S.f10089a, 1, null);
        }
        return null;
    }

    public static final boolean k(InterfaceC0845b it) {
        AbstractC2304t.f(it, "it");
        return O5.i.h0(it) && C1086i.o(it) != null;
    }

    public static final boolean l(InterfaceC0848e interfaceC0848e, InterfaceC0844a specialCallableDescriptor) {
        AbstractC2304t.f(interfaceC0848e, "<this>");
        AbstractC2304t.f(specialCallableDescriptor, "specialCallableDescriptor");
        InterfaceC0856m interfaceC0856mB = specialCallableDescriptor.b();
        AbstractC2304t.d(interfaceC0856mB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AbstractC0613d0 abstractC0613d0T = ((InterfaceC0848e) interfaceC0856mB).t();
        AbstractC2304t.e(abstractC0613d0T, "getDefaultType(...)");
        while (true) {
            interfaceC0848e = AbstractC2794i.s(interfaceC0848e);
            if (interfaceC0848e == null) {
                return false;
            }
            if (!(interfaceC0848e instanceof InterfaceC1259c) && J6.w.b(interfaceC0848e.t(), abstractC0613d0T) != null) {
                return !O5.i.h0(interfaceC0848e);
            }
        }
    }

    public static final boolean m(InterfaceC0845b interfaceC0845b) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        return AbstractC2996e.w(interfaceC0845b).b() instanceof InterfaceC1259c;
    }

    public static final boolean n(InterfaceC0845b interfaceC0845b) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        return m(interfaceC0845b) || O5.i.h0(interfaceC0845b);
    }
}
