package p3;

import h3.C1875k;

/* JADX INFO: renamed from: p3.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2564r {
    public static InterfaceC2560n a() {
        return C2553g.M();
    }

    public static boolean b(InterfaceC2560n interfaceC2560n) {
        return interfaceC2560n.o().isEmpty() && (interfaceC2560n.isEmpty() || (interfaceC2560n instanceof C2552f) || (interfaceC2560n instanceof C2566t) || (interfaceC2560n instanceof C2551e));
    }

    public static InterfaceC2560n c(C1875k c1875k, Object obj) {
        String str;
        InterfaceC2560n interfaceC2560nA = AbstractC2561o.a(obj);
        if (interfaceC2560nA instanceof C2558l) {
            interfaceC2560nA = new C2552f(Double.valueOf(((Long) interfaceC2560nA.getValue()).longValue()), a());
        }
        if (b(interfaceC2560nA)) {
            return interfaceC2560nA;
        }
        StringBuilder sb = new StringBuilder();
        if (c1875k != null) {
            str = "Path '" + c1875k + "'";
        } else {
            str = "Node";
        }
        sb.append(str);
        sb.append(" contains invalid priority: Must be a string, double, ServerValue, or null");
        throw new c3.d(sb.toString());
    }

    public static InterfaceC2560n d(Object obj) {
        return c(null, obj);
    }
}
