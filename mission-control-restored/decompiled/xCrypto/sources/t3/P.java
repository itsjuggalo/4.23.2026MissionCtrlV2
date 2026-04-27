package t3;

import W2.p;
import y3.C1956j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class P {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Z2.e eVar) {
        Object objB;
        if (eVar instanceof C1956j) {
            return eVar.toString();
        }
        try {
            p.a aVar = W2.p.f5487b;
            objB = W2.p.b(eVar + '@' + b(eVar));
        } catch (Throwable th) {
            p.a aVar2 = W2.p.f5487b;
            objB = W2.p.b(W2.q.a(th));
        }
        if (W2.p.e(objB) != null) {
            objB = eVar.getClass().getName() + '@' + b(eVar);
        }
        return (String) objB;
    }
}
