package Y6;

import o5.AbstractC2491s;
import o5.C2490r;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C {
    public static final Object a(Object obj, InterfaceC2707e interfaceC2707e) {
        if (obj instanceof A) {
            C2490r.a aVar = C2490r.f21981b;
            obj = AbstractC2491s.a(((A) obj).f9602a);
        }
        return C2490r.b(obj);
    }

    public static final Object b(Object obj) {
        Throwable thE = C2490r.e(obj);
        return thE == null ? obj : new A(thE, false, 2, null);
    }

    public static final Object c(Object obj, InterfaceC1015l interfaceC1015l) {
        Throwable thE = C2490r.e(obj);
        return thE == null ? obj : new A(thE, false, 2, null);
    }
}
