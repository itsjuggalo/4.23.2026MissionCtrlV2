package Y6;

import d7.C1647h;
import o5.AbstractC2491s;
import o5.C2490r;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class P {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(InterfaceC2707e interfaceC2707e) {
        Object objB;
        if (interfaceC2707e instanceof C1647h) {
            return ((C1647h) interfaceC2707e).toString();
        }
        try {
            C2490r.a aVar = C2490r.f21981b;
            objB = C2490r.b(interfaceC2707e + '@' + b(interfaceC2707e));
        } catch (Throwable th) {
            C2490r.a aVar2 = C2490r.f21981b;
            objB = C2490r.b(AbstractC2491s.a(th));
        }
        if (C2490r.e(objB) != null) {
            objB = interfaceC2707e.getClass().getName() + '@' + b(interfaceC2707e);
        }
        return (String) objB;
    }
}
